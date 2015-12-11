.class public final Lcom/amazon/identity/auth/device/utils/VersionUtils;
.super Ljava/lang/Object;
.source "VersionUtils.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/amazon/identity/auth/device/utils/VersionUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/VersionUtils;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    return-void
.end method

.method public static getAmazonPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    const/4 v3, 0x0

    .line 20
    new-instance v1, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    .line 21
    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 36
    :goto_0
    return-object v0

    .line 28
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 30
    iget v1, v1, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 34
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/device/utils/VersionUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s cannot be found because it is not installed"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    goto :goto_0
.end method
