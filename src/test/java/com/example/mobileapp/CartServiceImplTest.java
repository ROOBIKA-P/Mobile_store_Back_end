import com.example.mobileapp.cart.Cart;
import com.example.mobileapp.cart.CartExceptions;
import com.example.mobileapp.cart.CartRepository;
import com.example.mobileapp.cart.CartServiceImpl;
import com.example.mobileapp.product.Product;
import com.example.mobileapp.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    @Test
    public void testAddProductToCart() throws CartExceptions {
        Cart cart = new Cart();
        when(cartRepository.save(any())).thenReturn(cart);

        Cart savedCart = cartService.addProductToCart(cart);

        assertEquals(cart, savedCart);
    }

    @Test
    public void testDeleteCartProductById() throws CartExceptions {
        Cart cart = new Cart();
        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));

        Cart deletedCart = cartService.deleteCartProductById(1);

        assertEquals(cart, deletedCart);
    }

    @Test
    public void testGetAllCartProducts() throws CartExceptions {
        List<Cart> cartList = new ArrayList<>();
        cartList.add(new Cart());
        when(cartRepository.findAll()).thenReturn(cartList);

        List<Cart> retrievedCarts = cartService.getAllCartProducts();

        assertEquals(cartList.size(), retrievedCarts.size());
    }

    @Test
    public void testUpdateProductQuantityInCart() throws CartExceptions {
        Cart cart = new Cart();
        Product product = new Product();
        product.setId(1);
        product.setQuantity(5);
        cart.getProducts().add(product);

        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));
        when(cartRepository.save(any())).thenReturn(cart);

        Cart updatedCart = cartService.updateProductQuantityInCart(1, 1, 10);

        assertEquals(10, updatedCart.getProducts().get(0).getQuantity());
    }

    @Test
    public void testCalculateTotalPriceOfCart() throws CartExceptions {
        Cart cart = new Cart();
        Product product1 = new Product();
        product1.setPrice(10.0);
        product1.setQuantity(2);
        Product product2 = new Product();
        product2.setPrice(20.0);
        product2.setQuantity(1);
        cart.getProducts().add(product1);
        cart.getProducts().add(product2);

        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));

        Double totalPrice = cartService.calculateTotalPriceOfCart(1);

        assertEquals(40.0, totalPrice);
    }

    @Test
    public void testUpdateCart() throws CartExceptions {
        Cart existingCart = new Cart();
        Cart updatedCart = new Cart();
        List<Product> updatedProducts = new ArrayList<>();
        Product updatedProduct = new Product();
        updatedProduct.setId(1);
        updatedProduct.setQuantity(3);
        updatedProducts.add(updatedProduct);
        updatedCart.setProducts(updatedProducts);

        when(cartRepository.findById(any())).thenReturn(Optional.of(existingCart));
        when(cartRepository.save(any())).thenReturn(updatedCart);

        Cart modifiedCart = cartService.updateCart(1, updatedCart);

        assertEquals(updatedProducts.size(), modifiedCart.getProducts().size());
    }
}
