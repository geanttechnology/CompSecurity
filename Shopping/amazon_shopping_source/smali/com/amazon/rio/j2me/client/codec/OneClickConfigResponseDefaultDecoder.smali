.class public Lcom/amazon/rio/j2me/client/codec/OneClickConfigResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "OneClickConfigResponseDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;
    .locals 5
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 21
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;-><init>()V

    .line 27
    .local v2, "record":Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 28
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-virtual {v2, v3}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->setOneClickStatus(Z)V

    .line 31
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 32
    .local v1, "isAbsent":Z
    if-nez v1, :cond_0

    .line 34
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Boolean;
    check-cast v0, Ljava/lang/String;

    .line 35
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->setDeviceName(Ljava/lang/String;)V

    .line 38
    .end local v0    # "data":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 39
    if-nez v1, :cond_1

    .line 41
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v0

    .line 42
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->setAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;)V

    .line 45
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 46
    if-nez v1, :cond_2

    .line 48
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/PaymentMethodDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/PaymentMethodDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/PaymentMethodDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    move-result-object v0

    .line 49
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->setPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;)V

    .line 52
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 53
    if-nez v1, :cond_3

    .line 55
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 56
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->setShippingSpeed(Ljava/lang/String;)V

    .line 58
    .end local v0    # "data":Ljava/lang/String;
    :cond_3
    return-object v2
.end method

.method public bridge synthetic decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/io/DataInputStream;
    .param p2, "x1"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 17
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/OneClickConfigResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    move-result-object v0

    return-object v0
.end method
