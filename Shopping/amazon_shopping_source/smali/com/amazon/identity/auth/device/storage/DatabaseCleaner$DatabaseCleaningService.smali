.class public Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;
.super Lcom/amazon/identity/auth/device/framework/AmazonIntentService;
.source "DatabaseCleaner.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DatabaseCleaningService"
.end annotation


# instance fields
.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/AmazonIntentService;-><init>(Ljava/lang/String;)V

    .line 45
    invoke-virtual {p0, p0}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;->setContext(Landroid/content/Context;)V

    .line 46
    return-void
.end method

.method public static isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z
    .locals 1
    .param p0, "platform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .prologue
    .line 50
    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->shouldPlatformUseThisStore(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method protected protectedOnHandleIntent(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 61
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_platform"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 64
    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;->isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 66
    sget-object v1, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Ignoring Database cleaning request because this platform does not use distributed data storage"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    :goto_0
    return-void

    .line 71
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cleaning database of unneeded items"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    new-instance v0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;-><init>(Landroid/content/Context;)V

    .line 76
    .local v0, "databaseCleaner":Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;
    :try_start_0
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->cleanDatabase()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 80
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->scheduleDatabaseClean()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->scheduleDatabaseClean()V

    throw v1
.end method

.method public setContext(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 55
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;->mContext:Landroid/content/Context;

    .line 56
    return-void
.end method
