.class public interface abstract Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;
.super Ljava/lang/Object;
.source "OneClickController.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/control/account/OneClickController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "OneClickSubscriber"
.end annotation


# virtual methods
.method public abstract onReceiveOneClickAddresses(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract onReceiveOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V
.end method

.method public abstract onSaveOneClickStatus(Z)V
.end method
