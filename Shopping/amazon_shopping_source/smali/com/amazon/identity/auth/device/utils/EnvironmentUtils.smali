.class public abstract Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;
.super Ljava/lang/Object;
.source "EnvironmentUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$1;,
        Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field static sInstance:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ProdUtils;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/ProdUtils;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->sInstance:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    .line 18
    const-class v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private static getEnvironmentFromSharedPref(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 176
    :try_start_0
    new-instance v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    .line 180
    const-string/jumbo v1, "com.amazon.map.devoProdSwitch"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 182
    const-string/jumbo v0, "com.amazon.map.devoProdSwitch"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->createPackageContext(Ljava/lang/String;I)Landroid/content/Context;

    move-result-object v0

    .line 183
    const-string/jumbo v1, "map_environment"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 185
    const-string/jumbo v1, "environment"

    sget-object v2, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->name()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 193
    :goto_0
    return-object v0

    .line 190
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->TAG:Ljava/lang/String;

    new-array v0, v4, [Ljava/lang/Object;

    const-string/jumbo v1, "com.amazon.map.devoProdSwitch"

    aput-object v1, v0, v3

    .line 193
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->name()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;
    .locals 1

    .prologue
    .line 44
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->sInstance:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    return-object v0
.end method

.method public static isCurrentEnvironmentDevo()Z
    .locals 2

    .prologue
    .line 102
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->sInstance:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getCurrentEnvironment()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->devo:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    if-ne v0, v1, :cond_0

    .line 104
    const/4 v0, 0x1

    .line 106
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isCurrentEnvironmentProd()Z
    .locals 2

    .prologue
    .line 93
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->sInstance:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getCurrentEnvironment()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    if-ne v0, v1, :cond_0

    .line 95
    const/4 v0, 0x1

    .line 97
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static toggleEnvironment(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 53
    invoke-static {p0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v1

    const-string/jumbo v2, "environment"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 54
    .local v0, "envString":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "got setting string "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 55
    if-nez v0, :cond_0

    .line 57
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getEnvironmentFromSharedPref(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 60
    :cond_0
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->fromString(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    .line 61
    return-void
.end method

.method protected static toggleEnvironmentTo(Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;)V
    .locals 4
    .param p0, "env"    # Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    .prologue
    .line 69
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Toggling environment to %s. This should not happen in release builds"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$1;->$SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment:[I

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 85
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ProdUtils;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/ProdUtils;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->sInstance:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    .line 86
    :goto_0
    return-void

    .line 73
    :pswitch_0
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ProdUtils;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/ProdUtils;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->sInstance:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    goto :goto_0

    .line 77
    :pswitch_1
    new-instance v0, Lcom/amazon/identity/auth/device/utils/PreProdUtils;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/PreProdUtils;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->sInstance:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    goto :goto_0

    .line 81
    :pswitch_2
    new-instance v0, Lcom/amazon/identity/auth/device/utils/DevoUtils;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/DevoUtils;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->sInstance:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    goto :goto_0

    .line 70
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public abstract getAmazonCNDomain()Ljava/lang/String;
.end method

.method public abstract getAmazonJPDomain()Ljava/lang/String;
.end method

.method public abstract getAmazonUKDomain()Ljava/lang/String;
.end method

.method public abstract getAmazonUSDomain()Ljava/lang/String;
.end method

.method public abstract getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;
.end method

.method protected abstract getCurrentEnvironment()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
.end method

.method public abstract getDCAHost()Ljava/lang/String;
.end method

.method public abstract getDefaultAmazonDomain()Ljava/lang/String;
.end method

.method public abstract getFIRSHost()Ljava/lang/String;
.end method

.method public abstract getPandaHost(Ljava/lang/String;)Ljava/lang/String;
.end method
