.class public Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "AIVGatewayStartupActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;
    }
.end annotation


# static fields
.field private static final REFMARKER_LAUNCH_FROM_AIV_APP:Ljava/lang/String; = "aiv_aw_app_open"

.field private static final SOURCE_COMPANION_APP_EXTRA:Ljava/lang/String; = "SOURCE_AIV_COMPANION_APP"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 92
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->launchAIVGatewayPage()V

    return-void
.end method

.method private launchAIVGatewayPage()V
    .locals 2

    .prologue
    .line 49
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 50
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->finish()V

    .line 52
    invoke-direct {p0}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->redirectVideoAsin()V

    .line 65
    :goto_0
    return-void

    .line 55
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->finish()V

    .line 56
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    .line 57
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$1;-><init>(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method private redirectVideoAsin()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 72
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string/jumbo v5, "SOURCE_AIV_COMPANION_APP"

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    .line 73
    .local v1, "isSourceAIVApp":Z
    invoke-static {}, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->getInstance()Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->takeAsin()Ljava/lang/String;

    move-result-object v0

    .line 75
    .local v0, "asin":Ljava/lang/String;
    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    .line 78
    new-instance v2, Lcom/amazon/mShop/control/item/ProductController;

    sget-object v4, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_DEFAULT:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v2, v0, v4}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 79
    .local v2, "productController":Lcom/amazon/mShop/control/item/ProductController;
    new-array v4, v6, [I

    invoke-static {p0, v2, v4}, Lcom/amazon/mShop/util/ActivityUtils;->launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;[I)Z

    .line 85
    .end local v2    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :goto_0
    return-void

    .line 82
    :cond_0
    if-eqz v1, :cond_1

    const-string/jumbo v3, "aiv_aw_app_open"

    .line 83
    .local v3, "refmarker":Ljava/lang/String;
    :goto_1
    const/4 v4, -0x1

    invoke-static {p0, v3, v4}, Lcom/amazon/mShop/util/ActivityUtils;->startAIVGatewayActivity(Landroid/content/Context;Ljava/lang/String;I)Z

    goto :goto_0

    .line 82
    .end local v3    # "refmarker":Ljava/lang/String;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 36
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->splash_screen:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->pushView(I)V

    .line 39
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    .line 41
    .local v0, "service":Ljava/util/concurrent/ExecutorService;
    :try_start_0
    new-instance v1, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;-><init>(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$1;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 44
    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    .line 46
    return-void

    .line 44
    :catchall_0
    move-exception v1

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    throw v1
.end method
