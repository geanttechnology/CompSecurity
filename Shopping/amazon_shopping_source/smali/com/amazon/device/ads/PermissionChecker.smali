.class Lcom/amazon/device/ads/PermissionChecker;
.super Ljava/lang/Object;
.source "PermissionChecker.java"


# static fields
.field private static INSTANCE:Lcom/amazon/device/ads/PermissionChecker; = null

.field private static final INTERNET_PERMISSION:Ljava/lang/String; = "android.permission.INTERNET"

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private isInternetPermissionPresent:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/device/ads/PermissionChecker;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/PermissionChecker;->LOG_TAG:Ljava/lang/String;

    .line 18
    new-instance v0, Lcom/amazon/device/ads/PermissionChecker;

    invoke-direct {v0}, Lcom/amazon/device/ads/PermissionChecker;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/PermissionChecker;->INSTANCE:Lcom/amazon/device/ads/PermissionChecker;

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/PermissionChecker;->isInternetPermissionPresent:Z

    .line 23
    return-void
.end method

.method static getInstance()Lcom/amazon/device/ads/PermissionChecker;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/device/ads/PermissionChecker;->INSTANCE:Lcom/amazon/device/ads/PermissionChecker;

    return-object v0
.end method

.method private static final permissionCheckErrorCondition()Z
    .locals 2

    .prologue
    .line 120
    sget-object v0, Lcom/amazon/device/ads/PermissionChecker;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "App permissions were not read."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    const/4 v0, 0x1

    return v0
.end method

.method protected static setInstance(Lcom/amazon/device/ads/PermissionChecker;)V
    .locals 0
    .param p0, "instance"    # Lcom/amazon/device/ads/PermissionChecker;

    .prologue
    .line 30
    sput-object p0, Lcom/amazon/device/ads/PermissionChecker;->INSTANCE:Lcom/amazon/device/ads/PermissionChecker;

    .line 31
    return-void
.end method


# virtual methods
.method public final passesInternetPermissionCheck(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 46
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/device/ads/PermissionChecker;->passesInternetPermissionCheck(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public final passesInternetPermissionCheck(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 11
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "logtag"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    .line 63
    iget-boolean v9, p0, Lcom/amazon/device/ads/PermissionChecker;->isInternetPermissionPresent:Z

    if-eqz v9, :cond_0

    .line 110
    :goto_0
    return v8

    .line 69
    :cond_0
    sget v9, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v10, 0x8

    if-ge v9, v10, :cond_1

    .line 73
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->permissionCheckErrorCondition()Z

    move-result v8

    goto :goto_0

    .line 76
    :cond_1
    invoke-static {p1}, Lcom/amazon/device/ads/AndroidTargetUtils;->getPackageCodePath(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    .line 77
    .local v5, "path":Ljava/lang/String;
    if-nez v5, :cond_2

    .line 79
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->permissionCheckErrorCondition()Z

    move-result v8

    goto :goto_0

    .line 81
    :cond_2
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 82
    .local v4, "pManager":Landroid/content/pm/PackageManager;
    if-nez v4, :cond_3

    .line 84
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->permissionCheckErrorCondition()Z

    move-result v8

    goto :goto_0

    .line 86
    :cond_3
    const/16 v9, 0x1000

    invoke-virtual {v4, v5, v9}, Landroid/content/pm/PackageManager;->getPackageArchiveInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    .line 87
    .local v2, "info":Landroid/content/pm/PackageInfo;
    if-nez v2, :cond_4

    .line 89
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->permissionCheckErrorCondition()Z

    move-result v8

    goto :goto_0

    .line 91
    :cond_4
    iget-object v7, v2, Landroid/content/pm/PackageInfo;->requestedPermissions:[Ljava/lang/String;

    .line 92
    .local v7, "permissions":[Ljava/lang/String;
    if-nez v7, :cond_5

    .line 94
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->permissionCheckErrorCondition()Z

    move-result v8

    goto :goto_0

    .line 97
    :cond_5
    move-object v0, v7

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_1
    if-ge v1, v3, :cond_7

    aget-object v6, v0, v1

    .line 99
    .local v6, "permission":Ljava/lang/String;
    const-string/jumbo v9, "android.permission.INTERNET"

    invoke-virtual {v6, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 101
    iput-boolean v8, p0, Lcom/amazon/device/ads/PermissionChecker;->isInternetPermissionPresent:Z

    goto :goto_0

    .line 97
    :cond_6
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 106
    .end local v6    # "permission":Ljava/lang/String;
    :cond_7
    if-eqz p2, :cond_8

    .line 108
    const-string/jumbo v8, "Network task cannot commence because the INTERNET permission is missing from the app\'s manifest."

    invoke-static {p2, v8}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    :cond_8
    const/4 v8, 0x0

    goto :goto_0
.end method
