.class final enum Lcom/localytics/android/LocalyticsManager;
.super Ljava/lang/Enum;
.source "SourceFile"

# interfaces
.implements Lcom/localytics/android/LocalyticsDao;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/localytics/android/LocalyticsManager;",
        ">;",
        "Lcom/localytics/android/LocalyticsDao;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/localytics/android/LocalyticsManager;

.field public static final enum INSTANCE:Lcom/localytics/android/LocalyticsManager;

.field private static mActivityCounter:I

.field private static mIsAutoIntegrate:Z


# instance fields
.field private mApiKey:Ljava/lang/String;

.field private mAppContext:Landroid/content/Context;

.field private mCustomerId:Ljava/lang/String;

.field private mHandlerWrapper:Lcom/localytics/android/LocalyticsManager$HandlerWrapper;

.field private mInitiatedLatch:Ljava/util/concurrent/CountDownLatch;

.field private mInstallationId:Ljava/lang/String;

.field private proxy:Ljava/net/Proxy;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 34
    new-instance v0, Lcom/localytics/android/LocalyticsManager;

    const-string v1, "INSTANCE"

    invoke-direct {v0, v1, v2}, Lcom/localytics/android/LocalyticsManager;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/localytics/android/LocalyticsManager;->INSTANCE:Lcom/localytics/android/LocalyticsManager;

    .line 32
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/localytics/android/LocalyticsManager;

    sget-object v1, Lcom/localytics/android/LocalyticsManager;->INSTANCE:Lcom/localytics/android/LocalyticsManager;

    aput-object v1, v0, v2

    sput-object v0, Lcom/localytics/android/LocalyticsManager;->$VALUES:[Lcom/localytics/android/LocalyticsManager;

    .line 43
    sput v2, Lcom/localytics/android/LocalyticsManager;->mActivityCounter:I

    .line 44
    sput-boolean v2, Lcom/localytics/android/LocalyticsManager;->mIsAutoIntegrate:Z

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 54
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 40
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mInitiatedLatch:Ljava/util/concurrent/CountDownLatch;

    .line 55
    return-void
.end method

.method private classInManifest([Landroid/content/pm/ActivityInfo;Ljava/lang/String;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 823
    if-eqz p1, :cond_0

    .line 825
    array-length v2, p1

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, p1, v1

    .line 827
    iget-object v3, v3, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {v3, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 829
    const/4 v0, 0x1

    .line 834
    :cond_0
    return v0

    .line 825
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private getHandlerThread(Ljava/lang/String;)Landroid/os/HandlerThread;
    .locals 2

    .prologue
    .line 845
    new-instance v0, Landroid/os/HandlerThread;

    const/16 v1, 0xa

    invoke-direct {v0, p1, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    .line 847
    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 854
    return-object v0
.end method

.method static getInstance()Lcom/localytics/android/LocalyticsManager;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/localytics/android/LocalyticsManager;->INSTANCE:Lcom/localytics/android/LocalyticsManager;

    return-object v0
.end method

.method private scaleDownBitmap(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/high16 v3, 0x3f000000    # 0.5f

    .line 871
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 872
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    int-to-float v2, v2

    div-float/2addr v1, v2

    .line 875
    int-to-float v0, v0

    cmpl-float v0, v0, p2

    if-lez v0, :cond_0

    .line 878
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    if-lt v0, v2, :cond_1

    .line 880
    float-to-int v0, p2

    div-float v1, p2, v1

    add-float/2addr v1, v3

    float-to-int v1, v1

    invoke-static {p1, v0, v1, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object p1

    .line 887
    :goto_0
    if-nez p1, :cond_0

    .line 889
    const-string v0, "Cannot scale down the new dismiss button image."

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 896
    :cond_0
    return-object p1

    .line 884
    :cond_1
    mul-float v0, p2, v1

    add-float/2addr v0, v3

    float-to-int v0, v0

    float-to-int v1, p2

    invoke-static {p1, v0, v1, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object p1

    goto :goto_0
.end method

.method private setSpecialCustomerIdentifierAndAttribute(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 396
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "$"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/localytics/android/Localytics$ProfileScope;->ORGANIZATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, v0, p2, v1}, Lcom/localytics/android/LocalyticsManager;->setProfileAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 397
    invoke-virtual {p0, p1, p2}, Lcom/localytics/android/LocalyticsManager;->setIdentifier(Ljava/lang/String;Ljava/lang/String;)V

    .line 398
    return-void
.end method

.method static throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 901
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Exception;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method static throwOrLogError(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Exception;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 924
    const/4 v0, 0x0

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/localytics/android/LocalyticsManager;
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/localytics/android/LocalyticsManager;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/LocalyticsManager;

    return-object v0
.end method

.method public static values()[Lcom/localytics/android/LocalyticsManager;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/localytics/android/LocalyticsManager;->$VALUES:[Lcom/localytics/android/LocalyticsManager;

    invoke-virtual {v0}, [Lcom/localytics/android/LocalyticsManager;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/localytics/android/LocalyticsManager;

    return-object v0
.end method


# virtual methods
.method public final addAnalyticsListener(Lcom/localytics/android/AnalyticsListener;)V
    .locals 1

    .prologue
    .line 212
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->addListener(Lcom/localytics/android/BaseHandler$BaseListener;)V

    .line 213
    return-void
.end method

.method public final addMessagingListener(Lcom/localytics/android/MessagingListener;)V
    .locals 1

    .prologue
    .line 573
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/MarketingHandler;->addListener(Lcom/localytics/android/BaseHandler$BaseListener;)V

    .line 574
    return-void
.end method

.method public final addProfileAttributesToSet(Ljava/lang/String;[J)V
    .locals 1

    .prologue
    .line 291
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->addProfileAttributesToSet(Ljava/lang/String;[JLcom/localytics/android/Localytics$ProfileScope;)V

    .line 292
    return-void
.end method

.method public final addProfileAttributesToSet(Ljava/lang/String;[JLcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 286
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->addProfileAttributesToSet(Ljava/lang/String;[JLjava/lang/String;)V

    .line 287
    return-void
.end method

.method public final addProfileAttributesToSet(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 301
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->addProfileAttributesToSet(Ljava/lang/String;[Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 302
    return-void
.end method

.method public final addProfileAttributesToSet(Ljava/lang/String;[Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 296
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->addProfileAttributesToSet(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 297
    return-void
.end method

.method public final addProfileAttributesToSet(Ljava/lang/String;[Ljava/util/Date;)V
    .locals 1

    .prologue
    .line 311
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->addProfileAttributesToSet(Ljava/lang/String;[Ljava/util/Date;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 312
    return-void
.end method

.method public final addProfileAttributesToSet(Ljava/lang/String;[Ljava/util/Date;Lcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 306
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->addProfileAttributesToSet(Ljava/lang/String;[Ljava/util/Date;Ljava/lang/String;)V

    .line 307
    return-void
.end method

.method public final clearInAppMessageDisplayActivity()V
    .locals 2

    .prologue
    .line 421
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingHandler;->setFragmentManager(Landroid/support/v4/app/ah;)V

    .line 422
    return-void
.end method

.method public final closeSession()V
    .locals 1

    .prologue
    .line 172
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/AnalyticsHandler;->closeSession()V

    .line 173
    return-void
.end method

.method final decrementActivityCounter()V
    .locals 1

    .prologue
    .line 743
    sget v0, Lcom/localytics/android/LocalyticsManager;->mActivityCounter:I

    add-int/lit8 v0, v0, -0x1

    sput v0, Lcom/localytics/android/LocalyticsManager;->mActivityCounter:I

    .line 744
    return-void
.end method

.method public final decrementProfileAttribute(Ljava/lang/String;J)V
    .locals 2

    .prologue
    .line 361
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/localytics/android/LocalyticsManager;->decrementProfileAttribute(Ljava/lang/String;JLcom/localytics/android/Localytics$ProfileScope;)V

    .line 362
    return-void
.end method

.method public final decrementProfileAttribute(Ljava/lang/String;JLcom/localytics/android/Localytics$ProfileScope;)V
    .locals 4

    .prologue
    .line 356
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    const-wide/16 v2, -0x1

    mul-long/2addr v2, p2

    invoke-virtual {p4}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v2, v3, v1}, Lcom/localytics/android/ProfileHandler;->incrementProfileAttribute(Ljava/lang/String;JLjava/lang/String;)V

    .line 357
    return-void
.end method

.method public final deleteProfileAttribute(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 371
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, v0}, Lcom/localytics/android/LocalyticsManager;->deleteProfileAttribute(Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 372
    return-void
.end method

.method public final deleteProfileAttribute(Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 366
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p2}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/localytics/android/ProfileHandler;->deleteProfileAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 367
    return-void
.end method

.method public final dismissCurrentInAppMessage()V
    .locals 3

    .prologue
    .line 444
    new-instance v0, Lcom/localytics/android/LocalyticsManager$1;

    invoke-direct {v0, p0}, Lcom/localytics/android/LocalyticsManager$1;-><init>(Lcom/localytics/android/LocalyticsManager;)V

    .line 452
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    if-ne v1, v2, :cond_0

    .line 454
    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 460
    :goto_0
    return-void

    .line 458
    :cond_0
    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    invoke-virtual {v1, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method final getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;
    .locals 2

    .prologue
    .line 786
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mHandlerWrapper:Lcom/localytics/android/LocalyticsManager$HandlerWrapper;

    if-nez v0, :cond_0

    .line 788
    new-instance v0, Lcom/localytics/android/LocalyticsManager$LocalyticsNotInitializedException;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/localytics/android/LocalyticsManager$LocalyticsNotInitializedException;-><init>(Lcom/localytics/android/LocalyticsManager$1;)V

    throw v0

    .line 791
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mHandlerWrapper:Lcom/localytics/android/LocalyticsManager$HandlerWrapper;

    iget-object v0, v0, Lcom/localytics/android/LocalyticsManager$HandlerWrapper;->analyticsHandler:Lcom/localytics/android/AnalyticsHandler;

    return-object v0
.end method

.method public final getApiKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mApiKey:Ljava/lang/String;

    return-object v0
.end method

.method public final getAppContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mAppContext:Landroid/content/Context;

    return-object v0
.end method

.method public final getAppKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 670
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mAppContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/localytics/android/DatapointHelper;->getLocalyticsAppKeyOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getCalendar()Ljava/util/Calendar;
    .locals 1

    .prologue
    .line 937
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    return-object v0
.end method

.method public final getCurrentTimeMillis()J
    .locals 2

    .prologue
    .line 931
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getCustomDimension(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 207
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->getCustomDimension(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getCustomerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 632
    const-string v0, "customer_id"

    invoke-virtual {p0, v0}, Lcom/localytics/android/LocalyticsManager;->getIdentifier(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getCustomerIdInMemory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 603
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/localytics/android/LocalyticsManager;->getCustomerIdInMemory(Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getCustomerIdInMemory(Z)Ljava/lang/String;
    .locals 2

    .prologue
    .line 609
    if-nez p1, :cond_0

    .line 613
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mInitiatedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 619
    :cond_0
    :goto_0
    const-class v1, Lcom/localytics/android/Localytics;

    monitor-enter v1

    .line 621
    :try_start_1
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mCustomerId:Ljava/lang/String;

    monitor-exit v1

    return-object v0

    .line 622
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public final getCustomerIdInitiatedLatch()Ljava/util/concurrent/CountDownLatch;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mInitiatedLatch:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method public final getIdentifier(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 637
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->getIdentifier(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getIdentifiers()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 721
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/AnalyticsHandler;->getIdentifiers()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final getInAppMessageDismissButtonLocation()Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;
    .locals 1

    .prologue
    .line 680
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/MarketingHandler;->getInAppDismissButtonLocation()Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

    move-result-object v0

    return-object v0
.end method

.method public final getInstallationId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 652
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mInstallationId:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 654
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mInstallationId:Ljava/lang/String;

    return-object v0

    .line 658
    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "No installation id!"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method final getMarketingHandler()Lcom/localytics/android/MarketingHandler;
    .locals 2

    .prologue
    .line 796
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mHandlerWrapper:Lcom/localytics/android/LocalyticsManager$HandlerWrapper;

    if-nez v0, :cond_0

    .line 798
    new-instance v0, Lcom/localytics/android/LocalyticsManager$LocalyticsNotInitializedException;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/localytics/android/LocalyticsManager$LocalyticsNotInitializedException;-><init>(Lcom/localytics/android/LocalyticsManager$1;)V

    throw v0

    .line 801
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mHandlerWrapper:Lcom/localytics/android/LocalyticsManager$HandlerWrapper;

    iget-object v0, v0, Lcom/localytics/android/LocalyticsManager$HandlerWrapper;->marketingHandler:Lcom/localytics/android/MarketingHandler;

    return-object v0
.end method

.method final getProfileHandler()Lcom/localytics/android/ProfileHandler;
    .locals 2

    .prologue
    .line 806
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mHandlerWrapper:Lcom/localytics/android/LocalyticsManager$HandlerWrapper;

    if-nez v0, :cond_0

    .line 808
    new-instance v0, Lcom/localytics/android/LocalyticsManager$LocalyticsNotInitializedException;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/localytics/android/LocalyticsManager$LocalyticsNotInitializedException;-><init>(Lcom/localytics/android/LocalyticsManager$1;)V

    throw v0

    .line 811
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mHandlerWrapper:Lcom/localytics/android/LocalyticsManager$HandlerWrapper;

    iget-object v0, v0, Lcom/localytics/android/LocalyticsManager$HandlerWrapper;->profileHandler:Lcom/localytics/android/ProfileHandler;

    return-object v0
.end method

.method public final getProxy()Ljava/net/Proxy;
    .locals 1

    .prologue
    .line 949
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->proxy:Ljava/net/Proxy;

    return-object v0
.end method

.method public final getPushRegistrationId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 475
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/AnalyticsHandler;->getPushRegistrationID()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getTimeStringForSQLite()Ljava/lang/String;
    .locals 1

    .prologue
    .line 943
    const-string v0, "now"

    return-object v0
.end method

.method public final handleNotificationReceived(Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 711
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/MarketingHandler;->handleNotificationReceived(Landroid/content/Intent;)V

    .line 712
    return-void
.end method

.method public final handlePushNotificationOpened(Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 495
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/MarketingHandler;->handlePushNotificationOpened(Landroid/content/Intent;)V

    .line 496
    return-void
.end method

.method public final handleRegistration(Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 706
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->handleRegistration(Landroid/content/Intent;)V

    .line 707
    return-void
.end method

.method public final handleTestMode(Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 500
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/MarketingHandler;->handleTestModeIntent(Landroid/content/Intent;)V

    .line 501
    return-void
.end method

.method final incrementActivityCounter()V
    .locals 1

    .prologue
    .line 732
    sget v0, Lcom/localytics/android/LocalyticsManager;->mActivityCounter:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/localytics/android/LocalyticsManager;->mActivityCounter:I

    .line 733
    return-void
.end method

.method public final incrementProfileAttribute(Ljava/lang/String;J)V
    .locals 2

    .prologue
    .line 351
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/localytics/android/LocalyticsManager;->incrementProfileAttribute(Ljava/lang/String;JLcom/localytics/android/Localytics$ProfileScope;)V

    .line 352
    return-void
.end method

.method public final incrementProfileAttribute(Ljava/lang/String;JLcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 346
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p4}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, p3, v1}, Lcom/localytics/android/ProfileHandler;->incrementProfileAttribute(Ljava/lang/String;JLjava/lang/String;)V

    .line 347
    return-void
.end method

.method public final declared-synchronized integrate(Landroid/content/Context;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 63
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mHandlerWrapper:Lcom/localytics/android/LocalyticsManager$HandlerWrapper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 120
    :goto_0
    monitor-exit p0

    return-void

    .line 73
    :cond_0
    :try_start_1
    const-string v0, "com.localytics.android"

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.test.IsolatedContext"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.test.RenamingDelegatingContext"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 75
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context.getPackageName() returned %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 63
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 82
    :cond_1
    :try_start_2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.test.RenamingDelegatingContext"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 83
    if-nez v0, :cond_2

    instance-of v1, p1, Landroid/app/Activity;

    if-eqz v1, :cond_2

    .line 85
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Activity context use is not supported. You must call integrate() or registerActivityLifecycleCallbacks() from your Application class (see integration guide). If migrating from 3.0, see https://support.localytics.com/Android_SDK_Migration_3.0_to_3.x"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 87
    :cond_2
    if-eqz v0, :cond_4

    :goto_1
    iput-object p1, p0, Lcom/localytics/android/LocalyticsManager;->mAppContext:Landroid/content/Context;

    .line 89
    iput-object p2, p0, Lcom/localytics/android/LocalyticsManager;->mApiKey:Ljava/lang/String;

    .line 90
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mApiKey:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 92
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mAppContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/localytics/android/DatapointHelper;->getLocalyticsAppKeyOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mApiKey:Ljava/lang/String;

    .line 94
    :cond_3
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mApiKey:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 96
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "App key must be declared in a meta data tag in AndroidManifest.xml or passed into integrate(final Context context, final String localyticsKey) or new LocalyticsActivityLifecycleCallbacks(final Context context, final String localyticsKey) (see integration guide)."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 87
    :cond_4
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object p1

    goto :goto_1

    .line 101
    :cond_5
    :try_start_3
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mAppContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/LocalyticsManager;->mAppContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x3

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 102
    iget-object v1, v0, Landroid/content/pm/PackageInfo;->receivers:[Landroid/content/pm/ActivityInfo;

    const-class v2, Lcom/localytics/android/PushReceiver;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/localytics/android/LocalyticsManager;->classInManifest([Landroid/content/pm/ActivityInfo;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 104
    iget-object v0, v0, Landroid/content/pm/PackageInfo;->activities:[Landroid/content/pm/ActivityInfo;

    const-class v1, Lcom/localytics/android/PushTrackingActivity;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/localytics/android/LocalyticsManager;->classInManifest([Landroid/content/pm/ActivityInfo;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 106
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "PushTrackingActivity must be declared in AndroidManifest.xml (see integration guide). If migrating from 3.0, see https://support.localytics.com/Android_SDK_Migration_3.0_to_3.x"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_3
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 109
    :catch_0
    move-exception v0

    :try_start_4
    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/Throwable;)I

    .line 113
    :cond_6
    new-instance v2, Lcom/localytics/android/AnalyticsHandler;

    const-class v0, Lcom/localytics/android/AnalyticsHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/localytics/android/LocalyticsManager;->getHandlerThread(Ljava/lang/String;)Landroid/os/HandlerThread;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/AnalyticsHandler;-><init>(Lcom/localytics/android/LocalyticsDao;Landroid/os/Looper;)V

    .line 114
    new-instance v3, Lcom/localytics/android/MarketingHandler;

    const-class v0, Lcom/localytics/android/MarketingHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/localytics/android/LocalyticsManager;->getHandlerThread(Ljava/lang/String;)Landroid/os/HandlerThread;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/LocalyticsManager;->mAppContext:Landroid/content/Context;

    invoke-direct {v3, p0, v0, v1}, Lcom/localytics/android/MarketingHandler;-><init>(Lcom/localytics/android/LocalyticsDao;Landroid/os/Looper;Landroid/content/Context;)V

    .line 115
    new-instance v4, Lcom/localytics/android/ProfileHandler;

    const-class v0, Lcom/localytics/android/ProfileHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/localytics/android/LocalyticsManager;->getHandlerThread(Ljava/lang/String;)Landroid/os/HandlerThread;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {v4, p0, v0}, Lcom/localytics/android/ProfileHandler;-><init>(Lcom/localytics/android/LocalyticsDao;Landroid/os/Looper;)V

    .line 117
    new-instance v0, Lcom/localytics/android/LocalyticsManager$HandlerWrapper;

    const/4 v5, 0x0

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/localytics/android/LocalyticsManager$HandlerWrapper;-><init>(Lcom/localytics/android/LocalyticsManager;Lcom/localytics/android/AnalyticsHandler;Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/ProfileHandler;Lcom/localytics/android/LocalyticsManager$1;)V

    iput-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mHandlerWrapper:Lcom/localytics/android/LocalyticsManager$HandlerWrapper;

    .line 119
    invoke-virtual {v2, v3}, Lcom/localytics/android/AnalyticsHandler;->addListener(Lcom/localytics/android/BaseHandler$BaseListener;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_0
.end method

.method public final isAppInForeground()Z
    .locals 1

    .prologue
    .line 756
    sget v0, Lcom/localytics/android/LocalyticsManager;->mActivityCounter:I

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final isAutoIntegrate()Z
    .locals 1

    .prologue
    .line 770
    sget-boolean v0, Lcom/localytics/android/LocalyticsManager;->mIsAutoIntegrate:Z

    return v0
.end method

.method public final isOptedOut()Z
    .locals 1

    .prologue
    .line 162
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/AnalyticsHandler;->isOptedOut()Z

    move-result v0

    return v0
.end method

.method public final isPushDisabled()Z
    .locals 1

    .prologue
    .line 490
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/AnalyticsHandler;->isPushDisabled()Z

    move-result v0

    return v0
.end method

.method public final isTestModeEnabled()Z
    .locals 1

    .prologue
    .line 518
    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v0

    return v0
.end method

.method public final openSession()V
    .locals 1

    .prologue
    .line 167
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/AnalyticsHandler;->openSession()V

    .line 168
    return-void
.end method

.method public final registerPush(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 464
    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, v0, v1}, Lcom/localytics/android/LocalyticsManager;->registerPush(Ljava/lang/String;J)V

    .line 465
    return-void
.end method

.method public final registerPush(Ljava/lang/String;J)V
    .locals 2

    .prologue
    .line 469
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/localytics/android/AnalyticsHandler;->registerPush(Ljava/lang/String;J)V

    .line 470
    return-void
.end method

.method public final removeAnalyticsListener(Lcom/localytics/android/AnalyticsListener;)V
    .locals 1

    .prologue
    .line 217
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->removeListener(Lcom/localytics/android/BaseHandler$BaseListener;)V

    .line 218
    return-void
.end method

.method public final removeMessagingListener(Lcom/localytics/android/MessagingListener;)V
    .locals 1

    .prologue
    .line 578
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/MarketingHandler;->removeListener(Lcom/localytics/android/BaseHandler$BaseListener;)V

    .line 579
    return-void
.end method

.method public final removeProfileAttributesFromSet(Ljava/lang/String;[J)V
    .locals 1

    .prologue
    .line 321
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->removeProfileAttributesFromSet(Ljava/lang/String;[JLcom/localytics/android/Localytics$ProfileScope;)V

    .line 322
    return-void
.end method

.method public final removeProfileAttributesFromSet(Ljava/lang/String;[JLcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 316
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->removeProfileAttributesFromSet(Ljava/lang/String;[JLjava/lang/String;)V

    .line 317
    return-void
.end method

.method public final removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 331
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 332
    return-void
.end method

.method public final removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 326
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 327
    return-void
.end method

.method public final removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/util/Date;)V
    .locals 1

    .prologue
    .line 341
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/util/Date;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 342
    return-void
.end method

.method public final removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/util/Date;Lcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 336
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/util/Date;Ljava/lang/String;)V

    .line 337
    return-void
.end method

.method public final setCustomDimension(ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 201
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/localytics/android/AnalyticsHandler;->setCustomDimension(ILjava/lang/String;)V

    .line 202
    return-void
.end method

.method public final setCustomerEmail(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 376
    const-string v0, "email"

    invoke-direct {p0, v0, p1}, Lcom/localytics/android/LocalyticsManager;->setSpecialCustomerIdentifierAndAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 377
    return-void
.end method

.method public final setCustomerFirstName(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 381
    const-string v0, "first_name"

    invoke-direct {p0, v0, p1}, Lcom/localytics/android/LocalyticsManager;->setSpecialCustomerIdentifierAndAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 382
    return-void
.end method

.method public final setCustomerFullName(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 391
    const-string v0, "full_name"

    invoke-direct {p0, v0, p1}, Lcom/localytics/android/LocalyticsManager;->setSpecialCustomerIdentifierAndAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 392
    return-void
.end method

.method public final setCustomerId(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 627
    const-string v0, "customer_id"

    invoke-virtual {p0, v0, p1}, Lcom/localytics/android/LocalyticsManager;->setIdentifier(Ljava/lang/String;Ljava/lang/String;)V

    .line 628
    return-void
.end method

.method public final declared-synchronized setCustomerIdInMemory(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 597
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object p1, p0, Lcom/localytics/android/LocalyticsManager;->mInstallationId:Ljava/lang/String;

    :cond_0
    iput-object p1, p0, Lcom/localytics/android/LocalyticsManager;->mCustomerId:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 598
    monitor-exit p0

    return-void

    .line 597
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final setCustomerLastName(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 386
    const-string v0, "last_name"

    invoke-direct {p0, v0, p1}, Lcom/localytics/android/LocalyticsManager;->setSpecialCustomerIdentifierAndAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 387
    return-void
.end method

.method public final setIdentifier(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 587
    const-string v0, "customer_id"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 589
    invoke-virtual {p0, p2}, Lcom/localytics/android/LocalyticsManager;->setCustomerIdInMemory(Ljava/lang/String;)V

    .line 591
    :cond_0
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/localytics/android/AnalyticsHandler;->setIdentifier(Ljava/lang/String;Ljava/lang/String;)V

    .line 592
    return-void
.end method

.method public final setInAppMessageDismissButtonImage(Landroid/content/res/Resources;I)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 526
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 527
    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inPurgeable:Z

    .line 528
    sget-object v1, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    iput-object v1, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    .line 529
    invoke-static {p1, p2, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 530
    if-nez v0, :cond_0

    .line 532
    const-string v0, "Cannot load the new dismiss button image. Is the resource id corrected?"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 533
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingHandler;->setDismissButtonImage(Landroid/graphics/Bitmap;)V

    .line 549
    :goto_0
    return-void

    .line 538
    :cond_0
    const/high16 v1, 0x42200000    # 40.0f

    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v3, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v1

    .line 539
    invoke-direct {p0, v0, v1}, Lcom/localytics/android/LocalyticsManager;->scaleDownBitmap(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 542
    if-eq v1, v0, :cond_1

    .line 544
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 545
    :cond_1
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingHandler;->setDismissButtonImage(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public final setInAppMessageDismissButtonImage(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    .locals 3

    .prologue
    .line 553
    const/4 v0, 0x0

    .line 555
    if-eqz p2, :cond_0

    .line 558
    const/4 v0, 0x1

    const/high16 v1, 0x42200000    # 40.0f

    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v0, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    .line 559
    invoke-direct {p0, p2, v0}, Lcom/localytics/android/LocalyticsManager;->scaleDownBitmap(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 562
    if-ne v0, p2, :cond_0

    .line 564
    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    const/4 v1, 0x0

    invoke-virtual {p2, v0, v1}, Landroid/graphics/Bitmap;->copy(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 568
    :cond_0
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/localytics/android/MarketingHandler;->setDismissButtonImage(Landroid/graphics/Bitmap;)V

    .line 569
    return-void
.end method

.method public final setInAppMessageDismissButtonLocation(Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;)V
    .locals 1

    .prologue
    .line 675
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/MarketingHandler;->setInAppDismissButtonLocation(Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;)V

    .line 676
    return-void
.end method

.method public final setInAppMessageDisplayActivity(Landroid/support/v4/app/ac;)V
    .locals 2

    .prologue
    .line 406
    if-nez p1, :cond_0

    .line 408
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "attached activity cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 411
    :cond_0
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {p1}, Landroid/support/v4/app/ac;->getSupportFragmentManager()Landroid/support/v4/app/ah;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingHandler;->setFragmentManager(Landroid/support/v4/app/ah;)V

    .line 413
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->isTestModeEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 415
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/MarketingHandler;->showMarketingTest()V

    .line 417
    :cond_1
    return-void
.end method

.method public final setInstallationId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 665
    iput-object p1, p0, Lcom/localytics/android/LocalyticsManager;->mInstallationId:Ljava/lang/String;

    .line 666
    return-void
.end method

.method final setIsAutoIntegrate(Z)V
    .locals 0

    .prologue
    .line 781
    sput-boolean p1, Lcom/localytics/android/LocalyticsManager;->mIsAutoIntegrate:Z

    .line 782
    return-void
.end method

.method public final setLocation(Landroid/location/Location;)V
    .locals 1

    .prologue
    .line 642
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->setLocation(Landroid/location/Location;)V

    .line 643
    return-void
.end method

.method public final setOptedOut(Z)V
    .locals 1

    .prologue
    .line 157
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->setOptedOut(Z)V

    .line 158
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;J)V
    .locals 2

    .prologue
    .line 231
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/localytics/android/LocalyticsManager;->setProfileAttribute(Ljava/lang/String;JLcom/localytics/android/Localytics$ProfileScope;)V

    .line 232
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;JLcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 226
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p4}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, p3, v1}, Lcom/localytics/android/ProfileHandler;->setProfileAttribute(Ljava/lang/String;JLjava/lang/String;)V

    .line 227
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 251
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->setProfileAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 252
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 246
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->setProfileAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 247
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;Ljava/util/Date;)V
    .locals 1

    .prologue
    .line 271
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->setProfileAttribute(Ljava/lang/String;Ljava/util/Date;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 272
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;Ljava/util/Date;Lcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 266
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->setProfileAttribute(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;)V

    .line 267
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;[J)V
    .locals 1

    .prologue
    .line 241
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->setProfileAttribute(Ljava/lang/String;[JLcom/localytics/android/Localytics$ProfileScope;)V

    .line 242
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;[JLcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 236
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->setProfileAttribute(Ljava/lang/String;[JLjava/lang/String;)V

    .line 237
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 261
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->setProfileAttribute(Ljava/lang/String;[Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 262
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;[Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 256
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->setProfileAttribute(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;[Ljava/util/Date;)V
    .locals 1

    .prologue
    .line 281
    sget-object v0, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->setProfileAttribute(Ljava/lang/String;[Ljava/util/Date;Lcom/localytics/android/Localytics$ProfileScope;)V

    .line 282
    return-void
.end method

.method public final setProfileAttribute(Ljava/lang/String;[Ljava/util/Date;Lcom/localytics/android/Localytics$ProfileScope;)V
    .locals 2

    .prologue
    .line 276
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v0

    invoke-virtual {p3}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Lcom/localytics/android/ProfileHandler;->setProfileAttribute(Ljava/lang/String;[Ljava/util/Date;Ljava/lang/String;)V

    .line 277
    return-void
.end method

.method public final setProxy(Ljava/net/Proxy;)V
    .locals 0

    .prologue
    .line 954
    iput-object p1, p0, Lcom/localytics/android/LocalyticsManager;->proxy:Ljava/net/Proxy;

    .line 955
    return-void
.end method

.method public final setPushDisabled(Z)V
    .locals 1

    .prologue
    .line 485
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->setPushDisabled(Z)V

    .line 486
    return-void
.end method

.method public final setPushRegistrationId(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 480
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->setPushRegistrationId(Ljava/lang/String;)V

    .line 481
    return-void
.end method

.method public final setReferrerId(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 701
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->setReferrerId(Ljava/lang/String;)V

    .line 702
    return-void
.end method

.method public final setScreenFlow(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 696
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->setScreenFlow(Ljava/util/List;)V

    .line 697
    return-void
.end method

.method public final setTestModeEnabled(Z)V
    .locals 1

    .prologue
    .line 506
    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v0

    if-eq v0, p1, :cond_0

    .line 508
    invoke-static {p1}, Lcom/localytics/android/Constants;->setTestModeEnabled(Z)V

    .line 509
    if-eqz p1, :cond_0

    .line 511
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/MarketingHandler;->showMarketingTest()V

    .line 514
    :cond_0
    return-void
.end method

.method public final tagEvent(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 178
    const/4 v0, 0x0

    const-wide/16 v2, 0x0

    invoke-virtual {p0, p1, v0, v2, v3}, Lcom/localytics/android/LocalyticsManager;->tagEvent(Ljava/lang/String;Ljava/util/Map;J)V

    .line 179
    return-void
.end method

.method public final tagEvent(Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 184
    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/localytics/android/LocalyticsManager;->tagEvent(Ljava/lang/String;Ljava/util/Map;J)V

    .line 185
    return-void
.end method

.method public final tagEvent(Ljava/lang/String;Ljava/util/Map;J)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .line 190
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/localytics/android/AnalyticsHandler;->tagEvent(Ljava/lang/String;Ljava/util/Map;J)V

    .line 191
    return-void
.end method

.method public final tagScreen(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 195
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/localytics/android/AnalyticsHandler;->tagScreen(Ljava/lang/String;)V

    .line 196
    return-void
.end method

.method public final triggerInAppMessage(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 427
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/localytics/android/LocalyticsManager;->triggerInAppMessage(Ljava/lang/String;Ljava/util/Map;)V

    .line 428
    return-void
.end method

.method public final triggerInAppMessage(Ljava/lang/String;Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 433
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/localytics/android/LocalyticsManager;->triggerInAppMessage(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 434
    return-void
.end method

.method public final triggerInAppMessage(Ljava/lang/String;Ljava/util/Map;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 439
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getMarketingHandler()Lcom/localytics/android/MarketingHandler;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/localytics/android/MarketingHandler;->displayMarketingMessage(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 440
    return-void
.end method

.method public final upload()V
    .locals 2

    .prologue
    .line 143
    iget-object v0, p0, Lcom/localytics/android/LocalyticsManager;->mApiKey:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 145
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getCustomerIdInMemory()Ljava/lang/String;

    move-result-object v0

    .line 146
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getProfileHandler()Lcom/localytics/android/ProfileHandler;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/localytics/android/ProfileHandler;->upload(Ljava/lang/String;)V

    .line 147
    invoke-virtual {p0}, Lcom/localytics/android/LocalyticsManager;->getAnalyticsHandler()Lcom/localytics/android/AnalyticsHandler;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/localytics/android/AnalyticsHandler;->upload(Ljava/lang/String;)V

    .line 149
    :cond_0
    return-void
.end method
