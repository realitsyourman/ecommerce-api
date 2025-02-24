package me.realits.ecommerce.api.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import me.realits.ecommerce.api.CartApi;
import me.realits.ecommerce.api.model.Cart;
import me.realits.ecommerce.api.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

@Slf4j
@RestController
public class CartsController implements CartApi {

  @Override
  public ResponseEntity<List<Item>> addCartItemsByCustomerId(String customerId, @Validated Item item)
      throws Exception {

    log.info("고객 ID 요청: {}\nItem: {}", customerId, item);

    return ResponseEntity.ok(Collections.EMPTY_LIST);
  }

  @Override
  public ResponseEntity<List<Cart>> getCartByCustomerId(String customerId) throws Exception {
    throw new RuntimeException("수동 예외 발생(Manual Exception thrown");
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return CartApi.super.getRequest();
  }

  @Override
  public ResponseEntity<List<Item>> addOrReplaceItemsByCustomerId(String customerId, Item item)
      throws Exception {
    return CartApi.super.addOrReplaceItemsByCustomerId(customerId, item);
  }

  @Override
  public ResponseEntity<Void> deleteCart(String customerId) throws Exception {
    return CartApi.super.deleteCart(customerId);
  }

  @Override
  public ResponseEntity<Void> deleteItemFromCart(String customerId, String itemId)
      throws Exception {
    return CartApi.super.deleteItemFromCart(customerId, itemId);
  }

  @Override
  public ResponseEntity<List<Item>> getCartItemsByCustomerId(String customerId) throws Exception {
    return CartApi.super.getCartItemsByCustomerId(customerId);
  }

  @Override
  public ResponseEntity<List<Item>> getCartItemsByItemId(String customerId, String itemId)
      throws Exception {
    return CartApi.super.getCartItemsByItemId(customerId, itemId);
  }
}
