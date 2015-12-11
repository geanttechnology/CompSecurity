.class public Lcom/amazon/rio/j2me/client/codec/BarcodeSearchRequestDefaultEncoder;
.super Ljava/lang/Object;
.source "BarcodeSearchRequestDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;Ljava/io/DataOutputStream;)V
    .locals 11
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;
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
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->getBarcode()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 29
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->getBarcodeType()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_3

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

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->getBarcodeType()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 38
    :cond_0
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->getSize()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 43
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->getMaxImageDimension()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 47
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_4

    move v0, v2

    .line 48
    :goto_1
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 49
    if-nez v0, :cond_1

    .line 51
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 55
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->getIncludeAddOnItems()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_5

    move v0, v2

    .line 56
    :goto_2
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 57
    if-nez v0, :cond_2

    .line 59
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->getIncludeAddOnItems()Ljava/lang/Boolean;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 61
    :cond_2
    return-void

    .end local v0    # "isAbsent":Z
    :cond_3
    move v0, v3

    .line 29
    goto :goto_0

    .restart local v0    # "isAbsent":Z
    :cond_4
    move v0, v3

    .line 47
    goto :goto_1

    :cond_5
    move v0, v3

    .line 55
    goto :goto_2
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/BarcodeSearchRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;Ljava/io/DataOutputStream;)V

    return-void
.end method
