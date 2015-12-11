.class public Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;
.super Landroid/app/IntentService;
.source "DirtyDataSyncingService.java"


# static fields
.field static final SYNC_DIRTY_DATA_ACTION:Ljava/lang/String; = "com.amazon.identity.action.SYNC_DIRTY_DATA"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 28
    iput-object p0, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mContext:Landroid/content/Context;

    .line 29
    return-void
.end method

.method public static isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z
    .locals 1
    .param p0, "platform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .prologue
    .line 33
    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->shouldPlatformUseThisStore(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public onCreate()V
    .locals 3

    .prologue
    .line 39
    invoke-super {p0}, Landroid/app/IntentService;->onCreate()V

    .line 41
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 43
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mContext:Landroid/content/Context;

    .line 45
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_platform"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 47
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 49
    .local v0, "factory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 50
    return-void
.end method

.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 60
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Package %s is syncing dirty data to other processes"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->getPackageName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 64
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Ignoring dirty data sync request because this platform does not use the distributed datastorage"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    :goto_0
    return-void

    .line 69
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->syncDirtyData()V

    goto :goto_0
.end method

.method setContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;->mContext:Landroid/content/Context;

    .line 55
    return-void
.end method
