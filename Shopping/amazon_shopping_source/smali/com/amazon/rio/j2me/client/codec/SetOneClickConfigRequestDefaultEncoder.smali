.class public Lcom/amazon/rio/j2me/client/codec/SetOneClickConfigRequestDefaultEncoder;
.super Ljava/lang/Object;
.source "SetOneClickConfigRequestDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;Ljava/io/DataOutputStream;)V
    .locals 6
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 20
    move-object v1, p1

    .line 24
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->getDeviceName()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_4

    move v0, v2

    .line 25
    .local v0, "isAbsent":Z
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 26
    if-nez v0, :cond_0

    .line 28
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->getDeviceName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 32
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->getAddressId()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_5

    move v0, v2

    .line 33
    :goto_1
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 34
    if-nez v0, :cond_1

    .line 36
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->getAddressId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 40
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->getPaymentId()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_6

    move v0, v2

    .line 41
    :goto_2
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 42
    if-nez v0, :cond_2

    .line 44
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->getPaymentId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 48
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->getOneClickStatus()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_7

    move v0, v2

    .line 49
    :goto_3
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 50
    if-nez v0, :cond_3

    .line 52
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->getOneClickStatus()Ljava/lang/Boolean;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 54
    :cond_3
    return-void

    .end local v0    # "isAbsent":Z
    :cond_4
    move v0, v3

    .line 24
    goto :goto_0

    .restart local v0    # "isAbsent":Z
    :cond_5
    move v0, v3

    .line 32
    goto :goto_1

    :cond_6
    move v0, v3

    .line 40
    goto :goto_2

    :cond_7
    move v0, v3

    .line 48
    goto :goto_3
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/SetOneClickConfigRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;Ljava/io/DataOutputStream;)V

    return-void
.end method
