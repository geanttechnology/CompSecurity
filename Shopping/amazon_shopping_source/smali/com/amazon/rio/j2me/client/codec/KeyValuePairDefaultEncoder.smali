.class public Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultEncoder;
.super Ljava/lang/Object;
.source "KeyValuePairDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;Ljava/io/DataOutputStream;)V
    .locals 3
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 20
    move-object v0, p1

    .line 24
    .local v0, "record":Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 29
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 31
    return-void
.end method

.method public bridge synthetic encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 16
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;Ljava/io/DataOutputStream;)V

    return-void
.end method
