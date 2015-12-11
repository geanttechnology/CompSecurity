.class public final Lcom/amazon/dcp/settings/SettingsCache;
.super Ljava/lang/Object;
.source "SettingsCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/dcp/settings/SettingsCache$IListener;
    }
.end annotation


# static fields
.field private static final INSTANCE:Lcom/amazon/dcp/settings/SettingsCache;

.field private static final NEVER_SYNC_WITH_PROVIDER:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mSettingsCacheUpdater:Lcom/amazon/dcp/settings/SettingsCacheUpdater;

.field private mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 35
    const-class v0, Lcom/amazon/dcp/settings/SettingsCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/SettingsCache;->TAG:Ljava/lang/String;

    .line 37
    new-instance v0, Lcom/amazon/dcp/settings/SettingsCache;

    invoke-direct {v0}, Lcom/amazon/dcp/settings/SettingsCache;-><init>()V

    sput-object v0, Lcom/amazon/dcp/settings/SettingsCache;->INSTANCE:Lcom/amazon/dcp/settings/SettingsCache;

    .line 38
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    sput-object v0, Lcom/amazon/dcp/settings/SettingsCache;->NEVER_SYNC_WITH_PROVIDER:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    invoke-virtual {p0}, Lcom/amazon/dcp/settings/SettingsCache;->clear()V

    .line 45
    return-void
.end method

.method private static dcpReadPermissionExists(Landroid/content/Context;)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 218
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 221
    .local v1, "packageMan":Landroid/content/pm/PackageManager;
    :try_start_0
    const-string/jumbo v6, "com.amazon.dcp.settings.permission.READ_SETTINGS"

    const/16 v7, 0x80

    invoke-virtual {v1, v6, v7}, Landroid/content/pm/PackageManager;->getPermissionInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionInfo;

    move-result-object v2

    .line 224
    .local v2, "permInfo":Landroid/content/pm/PermissionInfo;
    iget-object v6, v2, Landroid/content/pm/PermissionInfo;->packageName:Ljava/lang/String;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v6, v7}, Landroid/content/pm/PackageManager;->checkSignatures(Ljava/lang/String;Ljava/lang/String;)I

    move-result v6

    if-nez v6, :cond_0

    move v3, v5

    .line 228
    .local v3, "signatureMatched":Z
    :goto_0
    if-nez v3, :cond_1

    .line 230
    sget-object v5, Lcom/amazon/dcp/settings/SettingsCache;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Somebody is trying something sneaky. The package that owns the permission to read device settings does not have the same signature as this application"

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 241
    .end local v2    # "permInfo":Landroid/content/pm/PermissionInfo;
    .end local v3    # "signatureMatched":Z
    :goto_1
    return v4

    .restart local v2    # "permInfo":Landroid/content/pm/PermissionInfo;
    :cond_0
    move v3, v4

    .line 224
    goto :goto_0

    .restart local v3    # "signatureMatched":Z
    :cond_1
    move v4, v5

    .line 236
    goto :goto_1

    .line 238
    .end local v2    # "permInfo":Landroid/content/pm/PermissionInfo;
    .end local v3    # "signatureMatched":Z
    :catch_0
    move-exception v0

    .line 240
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-object v5, Lcom/amazon/dcp/settings/SettingsCache;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Permission to read device settings doesn\'t exist. This is normal on third-party devices."

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method private static enforceReadPermission(Landroid/content/Context;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 205
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 206
    .local v0, "packageMan":Landroid/content/pm/PackageManager;
    const-string/jumbo v2, "com.amazon.dcp.settings.permission.READ_SETTINGS"

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 209
    .local v1, "permissionCheckResult":I
    if-eqz v1, :cond_0

    .line 211
    new-instance v2, Ljava/lang/SecurityException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " does not have the permission to read device settings"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 214
    :cond_0
    return-void
.end method

.method static forceSetContext(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 85
    sget-object v0, Lcom/amazon/dcp/settings/SettingsCache;->NEVER_SYNC_WITH_PROVIDER:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 86
    sget-object v0, Lcom/amazon/dcp/settings/SettingsCache;->INSTANCE:Lcom/amazon/dcp/settings/SettingsCache;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/dcp/settings/SettingsCache;->forceSetContextImpl(Landroid/content/Context;)V

    .line 87
    return-void
.end method

.method private forceSetContextImpl(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    if-eqz v0, :cond_1

    .line 93
    invoke-static {}, Lcom/amazon/dcp/framework/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-nez v0, :cond_0

    .line 96
    sget-object v0, Lcom/amazon/dcp/settings/SettingsCache;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Attempted to set context on SettingsCache more than once."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 107
    :goto_0
    return-void

    .line 101
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/dcp/settings/SettingsCache;->clear()V

    .line 105
    :cond_1
    new-instance v0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    iget-object v1, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSettingsCacheUpdater:Lcom/amazon/dcp/settings/SettingsCacheUpdater;

    invoke-direct {v0, v1, p1}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;-><init>(Lcom/amazon/dcp/settings/SettingsCacheUpdater;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    .line 106
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    invoke-virtual {v0}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->init()V

    goto :goto_0
.end method

.method public static getInstance()Lcom/amazon/dcp/settings/SettingsCache;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/amazon/dcp/settings/SettingsCache;->INSTANCE:Lcom/amazon/dcp/settings/SettingsCache;

    return-object v0
.end method

.method public static setContext(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 55
    if-nez p0, :cond_0

    .line 57
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Context cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 60
    :cond_0
    invoke-static {}, Lcom/amazon/dcp/framework/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {p0}, Lcom/amazon/dcp/settings/SettingsCache;->dcpReadPermissionExists(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 71
    :cond_1
    sget-object v0, Lcom/amazon/dcp/settings/SettingsCache;->NEVER_SYNC_WITH_PROVIDER:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 72
    sget-object v0, Lcom/amazon/dcp/settings/SettingsCache;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Always use default values for settings"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 78
    :goto_0
    return-void

    .line 76
    :cond_2
    invoke-static {p0}, Lcom/amazon/dcp/settings/SettingsCache;->enforceReadPermission(Landroid/content/Context;)V

    .line 77
    invoke-static {p0}, Lcom/amazon/dcp/settings/SettingsCache;->forceSetContext(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public static waitForInitialSync()V
    .locals 1

    .prologue
    .line 117
    sget-object v0, Lcom/amazon/dcp/settings/SettingsCache;->INSTANCE:Lcom/amazon/dcp/settings/SettingsCache;

    invoke-direct {v0}, Lcom/amazon/dcp/settings/SettingsCache;->waitForInitialSyncImpl()V

    .line 118
    return-void
.end method

.method private waitForInitialSyncImpl()V
    .locals 2

    .prologue
    .line 122
    sget-object v0, Lcom/amazon/dcp/settings/SettingsCache;->NEVER_SYNC_WITH_PROVIDER:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 137
    :cond_0
    :goto_0
    return-void

    .line 127
    :cond_1
    sget-object v0, Lcom/amazon/dcp/settings/SettingsCache;->INSTANCE:Lcom/amazon/dcp/settings/SettingsCache;

    iget-object v0, v0, Lcom/amazon/dcp/settings/SettingsCache;->mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    if-nez v0, :cond_2

    invoke-static {}, Lcom/amazon/dcp/framework/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-nez v0, :cond_2

    .line 130
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Must call SettingsCache.setContext before using SettingsCache."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 133
    :cond_2
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    invoke-virtual {v0}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->waitForInitialSync()V

    goto :goto_0
.end method


# virtual methods
.method public addListener(Lcom/amazon/dcp/settings/SettingsCache$IListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/dcp/settings/SettingsCache$IListener;

    .prologue
    .line 173
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSettingsCacheUpdater:Lcom/amazon/dcp/settings/SettingsCacheUpdater;

    invoke-virtual {v0, p1}, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->addListener(Lcom/amazon/dcp/settings/SettingsCache$IListener;)V

    .line 174
    return-void
.end method

.method clear()V
    .locals 1

    .prologue
    .line 194
    new-instance v0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;

    invoke-direct {v0}, Lcom/amazon/dcp/settings/SettingsCacheUpdater;-><init>()V

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSettingsCacheUpdater:Lcom/amazon/dcp/settings/SettingsCacheUpdater;

    .line 196
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    if-eqz v0, :cond_0

    .line 198
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    invoke-virtual {v0}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->destroy()V

    .line 200
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSynchronizer:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    .line 201
    return-void
.end method

.method public getValue(Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "namespace"    # Lcom/amazon/dcp/settings/SettingsNamespace;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 159
    invoke-static {}, Lcom/amazon/dcp/settings/SettingsCache;->waitForInitialSync()V

    .line 161
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCache;->mSettingsCacheUpdater:Lcom/amazon/dcp/settings/SettingsCacheUpdater;

    invoke-virtual {v0}, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->getMap()Lcom/amazon/dcp/settings/SettingsMap;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/dcp/settings/SettingsMap;->getValue(Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
