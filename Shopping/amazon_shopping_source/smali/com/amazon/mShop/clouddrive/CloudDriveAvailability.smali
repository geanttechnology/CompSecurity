.class public Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;
.super Ljava/lang/Object;
.source "CloudDriveAvailability.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/clouddrive/CloudDriveAvailability$1;,
        Lcom/amazon/mShop/clouddrive/CloudDriveAvailability$Holder;
    }
.end annotation


# instance fields
.field private isInitializedSuccessful:Z

.field private final mInitialLatch:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->mInitialLatch:Ljava/util/concurrent/CountDownLatch;

    .line 39
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->isInitializedSuccessful:Z

    .line 32
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/clouddrive/CloudDriveAvailability$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/clouddrive/CloudDriveAvailability$1;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability$Holder;->INSTANCE:Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;

    return-object v0
.end method

.method private isCloudDRiveEnabledInConfig()Z
    .locals 2

    .prologue
    .line 78
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$bool;->config_has_cloudDrive:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabledForApp(Landroid/content/Context;I)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public isCloudDriveAvailable()Z
    .locals 1

    .prologue
    .line 52
    invoke-virtual {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->waitForInitialization()V

    .line 53
    iget-boolean v0, p0, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->isInitializedSuccessful:Z

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->isCloudDRiveEnabledInConfig()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setCloudDriveInitialized(Z)V
    .locals 1
    .param p1, "successful"    # Z

    .prologue
    .line 61
    iput-boolean p1, p0, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->isInitializedSuccessful:Z

    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->mInitialLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 63
    return-void
.end method

.method public waitForInitialization()V
    .locals 4

    .prologue
    .line 70
    invoke-direct {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->isCloudDRiveEnabledInConfig()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->mInitialLatch:Ljava/util/concurrent/CountDownLatch;

    const-wide/16 v1, 0xa

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/util/ConcurrentUtils;->waitLatchWithTimeOut(Ljava/util/concurrent/CountDownLatch;JLjava/util/concurrent/TimeUnit;)Z

    .line 75
    :cond_0
    return-void
.end method
