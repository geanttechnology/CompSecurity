.class public interface abstract Lcom/amazon/mShop/control/cart/CartSubscriber;
.super Ljava/lang/Object;
.source "CartSubscriber.java"

# interfaces
.implements Lcom/amazon/mShop/control/GenericSubscriber;


# virtual methods
.method public abstract onCartDidUpdateCheckOutTimerForItem(Lcom/amazon/rio/j2me/client/services/mShop/CartItem;)V
.end method

.method public abstract onCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
.end method
