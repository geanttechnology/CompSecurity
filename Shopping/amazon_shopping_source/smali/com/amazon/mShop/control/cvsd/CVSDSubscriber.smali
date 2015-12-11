.class public interface abstract Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
.super Ljava/lang/Object;
.source "CVSDSubscriber.java"

# interfaces
.implements Lcom/amazon/mShop/control/GenericSubscriber;


# virtual methods
.method public abstract onDeliveryLocationsReceived(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Address;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract onOnlyMessageReceived(Ljava/lang/String;)V
.end method

.method public abstract onRefinementsReceived()V
.end method
