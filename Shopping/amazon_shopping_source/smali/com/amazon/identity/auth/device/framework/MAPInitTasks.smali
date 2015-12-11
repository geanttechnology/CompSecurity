.class public final Lcom/amazon/identity/auth/device/framework/MAPInitTasks;
.super Ljava/lang/Object;
.source "MAPInitTasks.java"


# static fields
.field public static final DCP_SSO_SPLIT_VERSION:I = 0x1

.field public static final DISABLE_UNNEEDED_MANIFEST_COMPONENTS_VERSION:I = 0x4

.field public static final INIT_DATA_STORAGE_VERSION:I = 0x3

.field public static final SSO_INTL_VERSION:I = 0x2

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mContext:Landroid/content/Context;

    .line 38
    new-instance v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 39
    return-void
.end method

.method public static getMAPInitVersion(Landroid/content/Context;)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 125
    const-string/jumbo v0, "SSOInfo.config"

    invoke-virtual {p0, v0, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 127
    const-string/jumbo v1, "SSOInfo.config"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method private setComponentStatus(Ljava/lang/Class;I)V
    .locals 5
    .param p2, "setting"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;I)V"
        }
    .end annotation

    .prologue
    .local p1, "componentClassToModifySettings":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v4, 0x1

    .line 75
    sget-object v2, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v2, 0x2

    if-ne p2, v2, :cond_0

    const-string/jumbo v2, "Disabling "

    :goto_0
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 79
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 80
    .local v1, "packageManager":Landroid/content/pm/PackageManager;
    new-instance v0, Landroid/content/ComponentName;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mContext:Landroid/content/Context;

    invoke-direct {v0, v2, p1}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 81
    .local v0, "compNameToDisable":Landroid/content/ComponentName;
    const/4 v2, 0x1

    invoke-virtual {v1, v0, p2, v2}, Landroid/content/pm/PackageManager;->setComponentEnabledSetting(Landroid/content/ComponentName;II)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 87
    .end local v0    # "compNameToDisable":Landroid/content/ComponentName;
    .end local v1    # "packageManager":Landroid/content/pm/PackageManager;
    :goto_1
    return-void

    .line 75
    :cond_0
    const-string/jumbo v2, "Enabling "

    goto :goto_0

    .line 85
    :catch_0
    move-exception v2

    sget-object v2, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->TAG:Ljava/lang/String;

    new-array v2, v4, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    goto :goto_1
.end method

.method static setMAPInitVersion(Landroid/content/Context;I)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "version"    # I

    .prologue
    .line 132
    const-string/jumbo v0, "SSOInfo.config"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 133
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string/jumbo v1, "SSOInfo.config"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 134
    return-void
.end method


# virtual methods
.method public performInitOperations()V
    .locals 4

    .prologue
    const/4 v3, 0x2

    .line 91
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 93
    sget-object v1, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Not migrating because we are running unit tests"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    :goto_0
    return-void

    .line 97
    :cond_0
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->isRunningOnMainThread()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 99
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "Cannot do MAP init tasks on the main thread!"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 106
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 109
    invoke-interface {v1}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v0

    .line 111
    .local v0, "storage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->initialize()V

    .line 113
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setup()V

    .line 115
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mContext:Landroid/content/Context;

    const/4 v2, 0x3

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->setMAPInitVersion(Landroid/content/Context;I)V

    .line 118
    sget-object v1, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->TAG:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock$ChangeTimestampsBroadcastReceiver;->isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-class v1, Lcom/amazon/identity/auth/device/storage/LambortishClock$ChangeTimestampsBroadcastReceiver;

    const/4 v2, 0x1

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->setComponentStatus(Ljava/lang/Class;I)V

    :cond_2
    sget-object v1, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->TAG:Ljava/lang/String;

    .line 119
    sget-object v1, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->TAG:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v1

    if-nez v1, :cond_3

    const-class v1, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;

    invoke-direct {p0, v1, v3}, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->setComponentStatus(Ljava/lang/Class;I)V

    :cond_3
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;->isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v1

    if-nez v1, :cond_4

    const-class v1, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;

    invoke-direct {p0, v1, v3}, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->setComponentStatus(Ljava/lang/Class;I)V

    :cond_4
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v1

    if-nez v1, :cond_5

    const-class v1, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;

    invoke-direct {p0, v1, v3}, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->setComponentStatus(Ljava/lang/Class;I)V

    :cond_5
    sget-object v1, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->TAG:Ljava/lang/String;

    .line 120
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->mContext:Landroid/content/Context;

    const/4 v2, 0x4

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->setMAPInitVersion(Landroid/content/Context;I)V

    goto :goto_0
.end method
