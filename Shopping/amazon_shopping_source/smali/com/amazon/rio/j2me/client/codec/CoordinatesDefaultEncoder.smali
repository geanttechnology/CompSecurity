.class public Lcom/amazon/rio/j2me/client/codec/CoordinatesDefaultEncoder;
.super Ljava/lang/Object;
.source "CoordinatesDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;Ljava/io/DataOutputStream;)V
    .locals 4
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 20
    move-object v1, p1

    .line 25
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getLatitude()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 30
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getLongitude()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 34
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getElevation()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    const/4 v0, 0x1

    .line 35
    .local v0, "isAbsent":Z
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 36
    if-nez v0, :cond_0

    .line 38
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getElevation()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 40
    :cond_0
    return-void

    .line 34
    .end local v0    # "isAbsent":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/CoordinatesDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;Ljava/io/DataOutputStream;)V

    return-void
.end method
