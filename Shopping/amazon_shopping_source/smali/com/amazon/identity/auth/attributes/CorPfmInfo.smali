.class public Lcom/amazon/identity/auth/attributes/CorPfmInfo;
.super Ljava/lang/Object;
.source "CorPfmInfo.java"


# static fields
.field static final DEFAULT_COR_PFM_STORE:Ljava/lang/String; = "default_cor_pfm_store"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->mContext:Landroid/content/Context;

    .line 31
    return-void
.end method

.method private getDefaultValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 75
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->TAG:Ljava/lang/String;

    .line 77
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getSharedPrefs()Landroid/content/SharedPreferences;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v1, p1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 78
    .local v0, "value":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 80
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Returning Device Default Cor/Pfm from Shared Preference for key: %s and value: %s"

    new-array v2, v5, [Ljava/lang/Object;

    aput-object p1, v2, v3

    aput-object v0, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 92
    .end local v0    # "value":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 88
    .restart local v0    # "value":Ljava/lang/String;
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Returning Device Default Cor/Pfm from default settings for key: %s and value: %s"

    new-array v2, v5, [Ljava/lang/Object;

    aput-object p1, v2, v3

    aput-object p2, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-object v0, p2

    .line 92
    goto :goto_0
.end method

.method private getSharedPrefs()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "default_cor_pfm_store"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getCorPfmDeviceDefaults()Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    .locals 4

    .prologue
    .line 68
    invoke-virtual {p0}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getDeviceDefaultCor()Ljava/lang/String;

    move-result-object v0

    .line 69
    .local v0, "cor":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getDeviceDefaultPfm()Ljava/lang/String;

    move-result-object v1

    .line 70
    .local v1, "pfm":Ljava/lang/String;
    new-instance v2, Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    sget-object v3, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->DEVICE_BASED_GUESS:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    invoke-direct {v2, v0, v1, v3}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;)V

    return-object v2
.end method

.method public getDeviceDefaultCor()Ljava/lang/String;
    .locals 4

    .prologue
    .line 55
    const-string/jumbo v0, "default.cor"

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v1

    const-string/jumbo v2, "default.cor"

    const-string/jumbo v3, "US"

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getDefaultValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceDefaultPfm()Ljava/lang/String;
    .locals 4

    .prologue
    .line 61
    const-string/jumbo v0, "default.pfm"

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v1

    const-string/jumbo v2, "default.pfm"

    const-string/jumbo v3, "ATVPDKIKX0DER"

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getDefaultValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hasSetDeviceDefaultsForCorPfm()Z
    .locals 2

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getSharedPrefs()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 50
    .local v0, "corPfmStore":Landroid/content/SharedPreferences;
    const-string/jumbo v1, "default.cor"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "default.pfm"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setDeviceDefaultCorPfm(Lcom/amazon/identity/auth/attributes/CORPFMResponse;)V
    .locals 3
    .param p1, "corPfmResponse"    # Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getSharedPrefs()Landroid/content/SharedPreferences;

    move-result-object v1

    .line 36
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 37
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string/jumbo v1, "default.cor"

    invoke-virtual {p1}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getCOR()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 38
    const-string/jumbo v1, "default.pfm"

    invoke-virtual {p1}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getPFM()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 39
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    .line 40
    if-nez v1, :cond_0

    .line 42
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Couldn\'t set device default CoR/PFM"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    :cond_0
    return-void
.end method
