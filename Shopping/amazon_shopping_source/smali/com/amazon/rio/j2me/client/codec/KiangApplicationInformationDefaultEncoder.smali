.class public Lcom/amazon/rio/j2me/client/codec/KiangApplicationInformationDefaultEncoder;
.super Ljava/lang/Object;
.source "KiangApplicationInformationDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;Ljava/io/DataOutputStream;)V
    .locals 4
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;
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
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->getUbid()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 30
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->getHardwareIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 35
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->getOsIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 40
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->getOsVersion()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 45
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->getApplicationIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 50
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->getApplicationVersion()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 54
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->getAssociateTag()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    const/4 v0, 0x1

    .line 55
    .local v0, "isAbsent":Z
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 56
    if-nez v0, :cond_0

    .line 58
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->getAssociateTag()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 63
    :cond_0
    new-instance v2, Lcom/amazon/rio/j2me/client/codec/KiangDeviceUniqueIdDefaultEncoder;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/codec/KiangDeviceUniqueIdDefaultEncoder;-><init>()V

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->getDeviceUniqueId()Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;

    move-result-object v3

    invoke-virtual {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/KiangDeviceUniqueIdDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;Ljava/io/DataOutputStream;)V

    .line 65
    return-void

    .line 54
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/KiangApplicationInformationDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;Ljava/io/DataOutputStream;)V

    return-void
.end method
