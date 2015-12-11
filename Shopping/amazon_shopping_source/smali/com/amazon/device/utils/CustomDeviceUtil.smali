.class public Lcom/amazon/device/utils/CustomDeviceUtil;
.super Lcom/amazon/device/utils/AbstractDeviceUtil;
.source "CustomDeviceUtil.java"

# interfaces
.implements Lcom/amazon/device/utils/DeviceUtil;


# instance fields
.field private mCountryOfResidence:Ljava/lang/String;

.field private mDeviceSerialNumber:Ljava/lang/String;

.field private mDeviceType:Ljava/lang/String;

.field private mPreferredMarketplace:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/amazon/device/utils/AbstractDeviceUtil;-><init>(Landroid/content/Context;)V

    .line 36
    return-void
.end method


# virtual methods
.method public fetchCountryOfResidence()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mCountryOfResidence:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 76
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v0

    .line 78
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mCountryOfResidence:Ljava/lang/String;

    goto :goto_0
.end method

.method public fetchDeviceLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public fetchDeviceMode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    const/4 v0, 0x0

    return-object v0
.end method

.method public fetchDeviceSerialNumberOrAnonymous()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mDeviceSerialNumber:Ljava/lang/String;

    return-object v0
.end method

.method public fetchDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mDeviceType:Ljava/lang/String;

    return-object v0
.end method

.method public fetchPreferredMarketplace()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mPreferredMarketplace:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 88
    const-string/jumbo v0, "UNKNOWN"

    .line 90
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mPreferredMarketplace:Ljava/lang/String;

    goto :goto_0
.end method

.method public fetchRsmGroupName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    const/4 v0, 0x0

    return-object v0
.end method

.method public fetchStaticCredential()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    invoke-virtual {p0}, Lcom/amazon/device/utils/CustomDeviceUtil;->fetchDeviceType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isDeviceSerialNumberAnonymous()Z
    .locals 1

    .prologue
    .line 105
    const/4 v0, 0x1

    return v0
.end method

.method public setCountryOfResidence(Ljava/lang/String;)V
    .locals 0
    .param p1, "countryOfResidence"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mCountryOfResidence:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setDeviceSerialNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceSerialNumber"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mDeviceSerialNumber:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setDeviceType(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mDeviceType:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setPreferredMarketplace(Ljava/lang/String;)V
    .locals 0
    .param p1, "preferredMarketplace"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/amazon/device/utils/CustomDeviceUtil;->mPreferredMarketplace:Ljava/lang/String;

    .line 52
    return-void
.end method
