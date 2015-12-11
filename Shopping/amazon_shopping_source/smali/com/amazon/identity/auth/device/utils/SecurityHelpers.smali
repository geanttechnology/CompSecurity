.class public final Lcom/amazon/identity/auth/device/utils/SecurityHelpers;
.super Ljava/lang/Object;
.source "SecurityHelpers.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/utils/SecurityHelpers$BroadcastTimer;
    }
.end annotation


# static fields
.field private static final DELIMITER:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 42
    const-class v0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    .line 44
    new-instance v0, Ljava/lang/String;

    const/4 v1, 0x1

    new-array v1, v1, [B

    aput-byte v2, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([B)V

    invoke-static {v0}, Ljava/util/regex/Pattern;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->DELIMITER:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    return-void
.end method

.method public static checkCaller(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 61
    new-instance v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    .line 63
    invoke-static {}, Landroid/os/Binder;->getCallingUid()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedUid(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 65
    sget-object v0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Unauthorized caller"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    new-instance v0, Ljava/lang/SecurityException;

    invoke-direct {v0}, Ljava/lang/SecurityException;-><init>()V

    throw v0

    .line 68
    :cond_0
    return-void
.end method

.method public static checkCallerSignatureOrPermission(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "permission"    # Ljava/lang/String;

    .prologue
    .line 103
    invoke-virtual {p0, p1}, Landroid/content/Context;->checkCallingPermission(Ljava/lang/String;)I

    move-result v0

    .line 104
    if-nez v0, :cond_0

    .line 110
    :goto_0
    return-void

    .line 109
    :cond_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkCaller(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public static checkCallingPackagePermissions(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 93
    new-instance v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    .line 94
    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 96
    sget-object v0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Package %s is an unauthorized caller"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    new-instance v0, Ljava/lang/SecurityException;

    invoke-direct {v0}, Ljava/lang/SecurityException;-><init>()V

    throw v0

    .line 99
    :cond_0
    return-void
.end method

.method public static checkCallingPackagePermissionsOrSystem(Landroid/app/Activity;)V
    .locals 7
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 79
    invoke-virtual {p0}, Landroid/app/Activity;->getCallingActivity()Landroid/content/ComponentName;

    move-result-object v0

    .line 80
    .local v0, "callingActivity":Landroid/content/ComponentName;
    if-nez v0, :cond_0

    .line 82
    sget-object v2, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Android System called activity %s in package %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-virtual {p0}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    :goto_0
    return-void

    .line 87
    :cond_0
    invoke-virtual {v0}, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 88
    .local v1, "callingPackage":Ljava/lang/String;
    invoke-static {p0, v1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkCallingPackagePermissions(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static checkIsAmazonOwnedContentProvider(Landroid/content/Context;Landroid/net/Uri;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v5, 0x0

    .line 242
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 243
    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v5}, Landroid/content/pm/PackageManager;->resolveContentProvider(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;

    move-result-object v0

    .line 244
    .local v0, "providerInfo":Landroid/content/pm/ProviderInfo;
    if-nez v0, :cond_0

    .line 246
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "Authority %s does not exist on the device"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 250
    :cond_0
    iget-object v1, v0, Landroid/content/pm/ProviderInfo;->packageName:Ljava/lang/String;

    invoke-static {p0, v1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkCallingPackagePermissions(Landroid/content/Context;Ljava/lang/String;)V

    .line 251
    return-void
.end method

.method public static getCallingPackages(Landroid/content/Context;)[Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 197
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->getCallingProcess(Landroid/content/Context;)Landroid/app/ActivityManager$RunningAppProcessInfo;

    move-result-object v0

    .line 199
    .local v0, "processInfo":Landroid/app/ActivityManager$RunningAppProcessInfo;
    if-nez v0, :cond_0

    .line 201
    sget-object v1, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Calling process could not be found. Cannot find it\'s package"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    .line 205
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, v0, Landroid/app/ActivityManager$RunningAppProcessInfo;->pkgList:[Ljava/lang/String;

    goto :goto_0
.end method

.method public static getCallingProcess(Landroid/content/Context;)Landroid/app/ActivityManager$RunningAppProcessInfo;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 210
    invoke-static {}, Landroid/os/Binder;->getCallingPid()I

    move-result v0

    .line 212
    .local v0, "callingPid":I
    const-string/jumbo v3, "activity"

    invoke-virtual {p0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/ActivityManager;

    .line 214
    invoke-virtual {v3}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 216
    .local v2, "info":Landroid/app/ActivityManager$RunningAppProcessInfo;
    iget v3, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    if-ne v3, v0, :cond_0

    .line 222
    .end local v2    # "info":Landroid/app/ActivityManager$RunningAppProcessInfo;
    :goto_0
    return-object v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static getCallingProcessName(Landroid/content/Context;)Ljava/lang/String;
    .locals 11
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v7, 0x1

    const/4 v9, 0x0

    .line 169
    invoke-static {}, Landroid/os/Binder;->getCallingPid()I

    move-result v3

    .line 170
    .local v3, "pid":I
    new-instance v4, Ljava/io/File;

    const-string/jumbo v6, "/proc/%d/cmdline"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 172
    .local v4, "processNameProc":Ljava/io/File;
    const/4 v1, 0x0

    .line 175
    .local v1, "inputStream":Ljava/io/InputStream;
    :try_start_0
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v4}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 176
    .end local v1    # "inputStream":Ljava/io/InputStream;
    .local v2, "inputStream":Ljava/io/InputStream;
    :try_start_1
    new-instance v5, Ljava/util/Scanner;

    invoke-direct {v5, v2}, Ljava/util/Scanner;-><init>(Ljava/io/InputStream;)V

    .line 177
    .local v5, "scanner":Ljava/util/Scanner;
    sget-object v6, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->DELIMITER:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/util/Scanner;->useDelimiter(Ljava/lang/String;)Ljava/util/Scanner;

    .line 178
    invoke-virtual {v5}, Ljava/util/Scanner;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 180
    invoke-virtual {v5}, Ljava/util/Scanner;->next()Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v6

    .line 189
    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    move-object v1, v2

    .line 192
    .end local v2    # "inputStream":Ljava/io/InputStream;
    .end local v5    # "scanner":Ljava/util/Scanner;
    .restart local v1    # "inputStream":Ljava/io/InputStream;
    :goto_0
    return-object v6

    .line 189
    .end local v1    # "inputStream":Ljava/io/InputStream;
    .restart local v2    # "inputStream":Ljava/io/InputStream;
    .restart local v5    # "scanner":Ljava/util/Scanner;
    :cond_0
    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    move-object v1, v2

    .line 192
    .end local v2    # "inputStream":Ljava/io/InputStream;
    .end local v5    # "scanner":Ljava/util/Scanner;
    .restart local v1    # "inputStream":Ljava/io/InputStream;
    :goto_1
    const/4 v6, 0x0

    goto :goto_0

    .line 183
    :catch_0
    move-exception v0

    .line 185
    .local v0, "e":Ljava/io/FileNotFoundException;
    :goto_2
    :try_start_2
    sget-object v6, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "pid %d could not be found"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 189
    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    goto :goto_1

    .end local v0    # "e":Ljava/io/FileNotFoundException;
    :catchall_0
    move-exception v6

    :goto_3
    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    throw v6

    .end local v1    # "inputStream":Ljava/io/InputStream;
    .restart local v2    # "inputStream":Ljava/io/InputStream;
    :catchall_1
    move-exception v6

    move-object v1, v2

    .end local v2    # "inputStream":Ljava/io/InputStream;
    .restart local v1    # "inputStream":Ljava/io/InputStream;
    goto :goto_3

    .line 183
    .end local v1    # "inputStream":Ljava/io/InputStream;
    .restart local v2    # "inputStream":Ljava/io/InputStream;
    :catch_1
    move-exception v0

    move-object v1, v2

    .end local v2    # "inputStream":Ljava/io/InputStream;
    .restart local v1    # "inputStream":Ljava/io/InputStream;
    goto :goto_2
.end method

.method public static isPkgsWhitelisted(Ljava/util/List;Ljava/util/Set;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p0, "pkgListToCheck":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p1, "pkgListWhiteListed":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .line 227
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_1

    .line 237
    :cond_0
    :goto_0
    return v0

    .line 232
    :cond_1
    invoke-interface {p1, p0}, Ljava/util/Set;->containsAll(Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 237
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isSameAppAcrossUsers(II)Z
    .locals 10
    .param p0, "uid1"    # I
    .param p1, "uid2"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 126
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AndroidUser;->USER_HANDLE_CLASS:Ljava/lang/Class;

    if-eqz v1, :cond_0

    .line 130
    :try_start_0
    new-instance v1, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v1}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    .line 131
    const-string/jumbo v4, "isSameApp"

    sget-object v5, Lcom/amazon/identity/auth/device/framework/AndroidUser;->USER_HANDLE_CLASS:Ljava/lang/Class;

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Class;

    const/4 v7, 0x0

    sget-object v8, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v8, v6, v7

    const/4 v7, 0x1

    sget-object v8, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v8, v6, v7

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v1, v4, v5, v6, v7}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invokeStatic(Ljava/lang/String;Ljava/lang/Class;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 143
    :goto_0
    return v1

    .line 137
    :catch_0
    move-exception v0

    .line 139
    .local v0, "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    sget-object v1, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cannot call isSampeApp on UserHandle class"

    invoke-static {v1, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 143
    .end local v0    # "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    :cond_0
    if-ne p0, p1, :cond_1

    move v1, v2

    goto :goto_0

    :cond_1
    move v1, v3

    goto :goto_0
.end method

.method public static isSelfCalling()Z
    .locals 3

    .prologue
    .line 114
    invoke-static {}, Landroid/os/Binder;->getCallingUid()I

    move-result v0

    .line 115
    .local v0, "callingUid":I
    invoke-static {}, Landroid/os/Process;->myUid()I

    move-result v1

    .line 116
    .local v1, "myUid":I
    if-ne v0, v1, :cond_0

    .line 118
    const/4 v2, 0x1

    .line 121
    :goto_0
    return v2

    :cond_0
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->isSameAppAcrossUsers(II)Z

    move-result v2

    goto :goto_0
.end method

.method public static isSignedTheSameAsCentralApk(Landroid/content/Context;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    .line 155
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    move-result-object v0

    .line 156
    .local v0, "centralApkDesc":Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;
    if-nez v0, :cond_1

    .line 163
    :cond_0
    :goto_0
    return v3

    .line 161
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 162
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 163
    .local v1, "myPackageName":Ljava/lang/String;
    iget-object v4, v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mPackageName:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    iget-object v4, v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mPackageName:Ljava/lang/String;

    invoke-virtual {v2, v4, v1}, Landroid/content/pm/PackageManager;->checkSignatures(Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_0

    :cond_2
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public static isSystemApplication(Landroid/content/Context;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 397
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 398
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    .line 399
    iget v2, v2, Landroid/content/pm/ApplicationInfo;->flags:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    and-int/lit8 v2, v2, 0x1

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 406
    :cond_0
    :goto_0
    return v1

    .line 401
    :catch_0
    move-exception v0

    .line 403
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-object v2, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Cannot calculate whether current app is a system app or not"

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static secureSendBroadcast(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V
    .locals 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "receiverPermission"    # Ljava/lang/String;
    .param p3, "user"    # Lcom/amazon/identity/auth/device/framework/AndroidUser;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 264
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->isSystemApplication(Landroid/content/Context;)Z

    move-result v5

    if-nez v5, :cond_1

    if-eqz p1, :cond_3

    invoke-virtual {p1}, Landroid/content/Intent;->getPackage()Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_0

    invoke-virtual {p1}, Landroid/content/Intent;->getComponent()Landroid/content/ComponentName;

    move-result-object v5

    if-eqz v5, :cond_3

    :cond_0
    move v5, v6

    :goto_0
    if-eqz v5, :cond_4

    .line 266
    :cond_1
    sget-object v5, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    .line 268
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->sendBroadcast(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    .line 306
    :cond_2
    return-void

    :cond_3
    move v5, v7

    .line 264
    goto :goto_0

    .line 276
    :cond_4
    if-eqz p3, :cond_5

    .line 278
    new-instance v5, Ljava/lang/IllegalStateException;

    const-string/jumbo v6, "We can only fire a broadcast to a user if we are a system app"

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 286
    :cond_5
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAllMapApplication()Ljava/util/Collection;

    move-result-object v2

    .line 288
    .local v2, "mapR5Apps":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    new-instance v4, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v4, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    .line 289
    .local v4, "trustedPackageManager":Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 291
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    .line 292
    .local v3, "packageName":Ljava/lang/String;
    invoke-virtual {v4, v3}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 294
    sget-object v5, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "%s cannot listen to intent %s because it is not signed with the same signature"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v3, v9, v7

    invoke-virtual {p1}, Landroid/content/Intent;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v6

    invoke-static {v5, v8, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 301
    :cond_6
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    .line 302
    .local v0, "clonedIntent":Landroid/content/Intent;
    invoke-virtual {v0, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 303
    const/4 v5, 0x0

    invoke-static {p0, v0, p2, v5}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->sendBroadcast(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    goto :goto_1
.end method

.method private static sendBroadcast(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "receiverPermission"    # Ljava/lang/String;
    .param p3, "user"    # Lcom/amazon/identity/auth/device/framework/AndroidUser;

    .prologue
    const/4 v6, -0x1

    const/4 v5, 0x0

    .line 323
    if-eqz p3, :cond_1

    .line 325
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->shouldUseOrderedBroadcast(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "sendOrderedBroadcastAsUser "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserHandle()Landroid/os/UserHandle;

    move-result-object v2

    new-instance v4, Lcom/amazon/identity/auth/device/utils/SecurityHelpers$BroadcastTimer;

    invoke-direct {v4, p1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers$BroadcastTimer;-><init>(Landroid/content/Intent;)V

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v7, v5

    move-object v8, v5

    invoke-virtual/range {v0 .. v8}, Landroid/content/Context;->sendOrderedBroadcastAsUser(Landroid/content/Intent;Landroid/os/UserHandle;Ljava/lang/String;Landroid/content/BroadcastReceiver;Landroid/os/Handler;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 331
    :goto_0
    return-void

    .line 325
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "sendBroadcastAsUser "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserHandle()Landroid/os/UserHandle;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p2}, Landroid/content/Context;->sendBroadcastAsUser(Landroid/content/Intent;Landroid/os/UserHandle;Ljava/lang/String;)V

    goto :goto_0

    .line 329
    :cond_1
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->shouldUseOrderedBroadcast(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "sendOrderedBroadcast "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    new-instance v4, Lcom/amazon/identity/auth/device/utils/SecurityHelpers$BroadcastTimer;

    invoke-direct {v4, p1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers$BroadcastTimer;-><init>(Landroid/content/Intent;)V

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v7, v5

    move-object v8, v5

    invoke-virtual/range {v1 .. v8}, Landroid/content/Context;->sendOrderedBroadcast(Landroid/content/Intent;Ljava/lang/String;Landroid/content/BroadcastReceiver;Landroid/os/Handler;ILjava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0

    :cond_2
    sget-object v0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "sendBroadcast "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-virtual {p0, p1, p2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static shouldUseOrderedBroadcast(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 387
    invoke-static {p0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v0

    const-string/jumbo v1, "ordered.broadcast"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method
