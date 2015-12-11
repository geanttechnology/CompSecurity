.class public interface abstract Lcom/amazon/mShop/control/wishlist/WishListSubscriber;
.super Ljava/lang/Object;
.source "WishListSubscriber.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserSubscriber;


# virtual methods
.method public abstract onListLists(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ListList;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract onWishListItemAdded()V
.end method
