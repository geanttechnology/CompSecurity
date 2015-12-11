.class public interface abstract Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickAddressesResponseListener;
.super Ljava/lang/Object;
.source "GetOneClickAddressesResponseListener.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/ResponseListener;


# virtual methods
.method public abstract completed(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation
.end method
