.class public Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;
.super Ljava/lang/Object;
.source "KiangApplicationInformation.java"


# instance fields
.field private applicationIdentifier:Ljava/lang/String;

.field private applicationVersion:Ljava/lang/String;

.field private associateTag:Ljava/lang/String;

.field private deviceUniqueId:Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;

.field private hardwareIdentifier:Ljava/lang/String;

.field private osIdentifier:Ljava/lang/String;

.field private osVersion:Ljava/lang/String;

.field private ubid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getApplicationIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->applicationIdentifier:Ljava/lang/String;

    return-object v0
.end method

.method public getApplicationVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->applicationVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getAssociateTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->associateTag:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceUniqueId()Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->deviceUniqueId:Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;

    return-object v0
.end method

.method public getHardwareIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->hardwareIdentifier:Ljava/lang/String;

    return-object v0
.end method

.method public getOsIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->osIdentifier:Ljava/lang/String;

    return-object v0
.end method

.method public getOsVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->osVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getUbid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->ubid:Ljava/lang/String;

    return-object v0
.end method

.method public setApplicationIdentifier(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->applicationIdentifier:Ljava/lang/String;

    .line 70
    return-void
.end method

.method public setApplicationVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->applicationVersion:Ljava/lang/String;

    .line 80
    return-void
.end method

.method public setAssociateTag(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->associateTag:Ljava/lang/String;

    .line 93
    return-void
.end method

.method public setDeviceUniqueId(Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->deviceUniqueId:Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;

    .line 103
    return-void
.end method

.method public setHardwareIdentifier(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->hardwareIdentifier:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setOsIdentifier(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->osIdentifier:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setOsVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->osVersion:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setUbid(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->ubid:Ljava/lang/String;

    .line 30
    return-void
.end method
