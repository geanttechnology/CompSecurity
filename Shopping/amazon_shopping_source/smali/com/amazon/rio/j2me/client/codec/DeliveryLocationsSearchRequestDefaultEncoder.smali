.class public Lcom/amazon/rio/j2me/client/codec/DeliveryLocationsSearchRequestDefaultEncoder;
.super Ljava/lang/Object;
.source "DeliveryLocationsSearchRequestDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Ljava/io/DataOutputStream;)V
    .locals 11
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/32 v9, 0x7fffffff

    const-wide/32 v7, -0x80000000

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 20
    move-object v1, p1

    .line 25
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;
    const/4 v4, 0x4

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getType()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 29
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getState()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_6

    move v0, v2

    .line 30
    .local v0, "isAbsent":Z
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 31
    if-nez v0, :cond_0

    .line 33
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getState()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 37
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getQuery()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_7

    move v0, v2

    .line 38
    :goto_1
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 39
    if-nez v0, :cond_1

    .line 41
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getQuery()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 45
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getCoordinates()Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    move-result-object v4

    if-nez v4, :cond_8

    move v0, v2

    .line 46
    :goto_2
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 47
    if-nez v0, :cond_2

    .line 49
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/CoordinatesDefaultEncoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/CoordinatesDefaultEncoder;-><init>()V

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getCoordinates()Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    move-result-object v5

    invoke-virtual {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/CoordinatesDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;Ljava/io/DataOutputStream;)V

    .line 53
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getRadiusKm()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_9

    move v0, v2

    .line 54
    :goto_3
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 55
    if-nez v0, :cond_3

    .line 57
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getRadiusKm()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 61
    :cond_3
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getPage()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_a

    move v0, v2

    .line 62
    :goto_4
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 63
    if-nez v0, :cond_4

    .line 65
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getPage()Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 69
    :cond_4
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getSize()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_b

    move v0, v2

    .line 70
    :goto_5
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 71
    if-nez v0, :cond_5

    .line 73
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->getSize()Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 75
    :cond_5
    return-void

    .end local v0    # "isAbsent":Z
    :cond_6
    move v0, v3

    .line 29
    goto/16 :goto_0

    .restart local v0    # "isAbsent":Z
    :cond_7
    move v0, v3

    .line 37
    goto :goto_1

    :cond_8
    move v0, v3

    .line 45
    goto :goto_2

    :cond_9
    move v0, v3

    .line 53
    goto :goto_3

    :cond_a
    move v0, v3

    .line 61
    goto :goto_4

    :cond_b
    move v0, v3

    .line 69
    goto :goto_5
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/DeliveryLocationsSearchRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Ljava/io/DataOutputStream;)V

    return-void
.end method
