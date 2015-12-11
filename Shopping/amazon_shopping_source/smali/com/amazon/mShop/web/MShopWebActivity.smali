.class public Lcom/amazon/mShop/web/MShopWebActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "MShopWebActivity.java"

# interfaces
.implements Lcom/amazon/mShop/web/MShopWebViewTransitionManager;
.implements Lcom/amazon/mobile/mash/nav/MASHNavInterface;
.implements Lorg/apache/cordova/CordovaInterface;


# static fields
.field protected static final KEEP_HISTORY_STACK:Ljava/lang/String; = "KeepHistoryStack"

.field public static final TAG:Ljava/lang/String; = "MShopWebActivity"


# instance fields
.field private mActivityResultCallback:Lorg/apache/cordova/CordovaPlugin;

.field private mBackTransitionPending:Z

.field private mForwardTransitionPending:Z

.field private mIsFirstOnResume:Z

.field private mIsLastOnPause:Z

.field protected mPicture:Lcom/amazon/mShop/web/TitledImageView;

.field private mThreadPool:Ljava/util/concurrent/ExecutorService;

.field protected mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

.field protected mWebviewLoadStartTime:J


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 61
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mIsFirstOnResume:Z

    .line 67
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mIsLastOnPause:Z

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/web/MShopWebActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebActivity;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mForwardTransitionPending:Z

    return v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/web/MShopWebActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mForwardTransitionPending:Z

    return p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/web/MShopWebActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebActivity;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mBackTransitionPending:Z

    return v0
.end method

.method static synthetic access$102(Lcom/amazon/mShop/web/MShopWebActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mBackTransitionPending:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/web/MShopWebActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebActivity;

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->goBackTransition()V

    return-void
.end method

.method private cordovaOnCreate()V
    .locals 1

    .prologue
    .line 597
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebActivity;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 598
    const/4 v0, 0x2

    invoke-static {v0}, Lorg/apache/cordova/LOG;->setLogLevel(I)V

    .line 601
    :cond_0
    invoke-static {p0}, Lorg/apache/cordova/Config;->init(Landroid/app/Activity;)V

    .line 602
    return-void
.end method

.method private goBackTransition()V
    .locals 1

    .prologue
    .line 418
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    if-eqz v0, :cond_0

    .line 419
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->popView()Z

    .line 420
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    .line 422
    :cond_0
    return-void
.end method


# virtual methods
.method public beginBackwardTransition(Ljava/lang/String;)V
    .locals 1
    .param p1, "currentUrl"    # Ljava/lang/String;

    .prologue
    .line 465
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->captureTopView()V

    .line 470
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mBackTransitionPending:Z

    .line 471
    return-void
.end method

.method public beginForwardTransition(Ljava/lang/String;)V
    .locals 3
    .param p1, "requestUrl"    # Ljava/lang/String;

    .prologue
    .line 431
    if-eqz p1, :cond_1

    .line 432
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 436
    .local v1, "uri":Landroid/net/Uri;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Landroid/net/Uri;->isHierarchical()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 437
    const-string/jumbo v2, "app-action"

    invoke-virtual {v1, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 438
    .local v0, "appAction":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 461
    .end local v0    # "appAction":Ljava/lang/String;
    .end local v1    # "uri":Landroid/net/Uri;
    :cond_0
    :goto_0
    return-void

    .line 445
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingSpinner()Z

    move-result v2

    if-nez v2, :cond_0

    .line 450
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingAmazonProgressDialog()Z

    move-result v2

    if-nez v2, :cond_0

    .line 455
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->captureTopView()V

    .line 460
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mForwardTransitionPending:Z

    goto :goto_0
.end method

.method public calcWebviewStartTime()V
    .locals 2

    .prologue
    .line 91
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebviewLoadStartTime:J

    .line 92
    return-void
.end method

.method protected captureTopView()V
    .locals 3

    .prologue
    .line 339
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    if-eqz v1, :cond_1

    .line 360
    :cond_0
    :goto_0
    return-void

    .line 344
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 348
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ViewAnimator;->clearDisappearingChildren()V

    .line 350
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getCaptureTopView()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 351
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v1, Lcom/amazon/mShop/web/TitledImageView;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/web/TitledImageView;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    .line 352
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/web/TitledImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 353
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getTitle()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/web/TitledImageView;->setTitle(Ljava/lang/CharSequence;)V

    .line 355
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/web/MShopWebActivity;->pushView(Landroid/view/View;Z)V

    .line 357
    sget-boolean v1, Lcom/amazon/mShop/web/MShopWebActivity;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 358
    const-string/jumbo v1, "MShopWebActivity"

    const-string/jumbo v2, "captureTopView"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected createWebView()Lcom/amazon/mShop/web/MShopWebView;
    .locals 1

    .prologue
    .line 283
    new-instance v0, Lcom/amazon/mShop/web/MShopWebView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/web/MShopWebView;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method protected createWebViewClient()Lcom/amazon/mShop/web/MShopWebViewClient;
    .locals 1

    .prologue
    .line 291
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewClient;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/web/MShopWebViewClient;-><init>(Lorg/apache/cordova/CordovaInterface;)V

    return-object v0
.end method

.method protected createWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;
    .locals 1

    .prologue
    .line 276
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;-><init>(Lcom/amazon/mShop/web/MShopWebActivity;)V

    return-object v0
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 641
    const/4 v0, 0x0

    .line 644
    .local v0, "consumed":Z
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getId()I

    move-result v1

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->web_view_frame:I

    if-ne v1, v2, :cond_0

    .line 645
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    .line 647
    :cond_0
    if-nez v0, :cond_1

    .line 648
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    .line 650
    :cond_1
    return v0
.end method

.method public doTransitionAnimation()V
    .locals 5

    .prologue
    .line 494
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    .line 495
    .local v0, "container":Lcom/amazon/mShop/web/MShopWebViewContainer;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShouldDelayTransition()Z

    move-result v3

    if-eqz v3, :cond_2

    const-wide/16 v1, 0xfa

    .line 498
    .local v1, "transitionDelayMills":J
    :goto_0
    iget-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mForwardTransitionPending:Z

    if-eqz v3, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->isPushAnimationInProgress()Z

    move-result v3

    if-nez v3, :cond_0

    .line 499
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/web/MShopWebActivity$1;

    invoke-direct {v4, p0, v0}, Lcom/amazon/mShop/web/MShopWebActivity$1;-><init>(Lcom/amazon/mShop/web/MShopWebActivity;Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    invoke-interface {v3, v4, v1, v2}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 514
    :cond_0
    iget-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mBackTransitionPending:Z

    if-eqz v3, :cond_1

    .line 515
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/web/MShopWebActivity$2;

    invoke-direct {v4, p0, v0}, Lcom/amazon/mShop/web/MShopWebActivity$2;-><init>(Lcom/amazon/mShop/web/MShopWebActivity;Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    invoke-interface {v3, v4, v1, v2}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 528
    :cond_1
    return-void

    .line 495
    .end local v1    # "transitionDelayMills":J
    :cond_2
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public finish()V
    .locals 1

    .prologue
    .line 206
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 207
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mIsLastOnPause:Z

    .line 208
    return-void
.end method

.method public getActivity()Landroid/app/Activity;
    .locals 0

    .prologue
    .line 576
    return-object p0
.end method

.method protected getCaptureTopView()Landroid/graphics/Bitmap;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 366
    const/4 v1, 0x0

    .line 367
    .local v1, "cachedBitmap":Landroid/graphics/Bitmap;
    const/4 v0, 0x0

    .line 368
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 369
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v4

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setDrawingCacheEnabled(Z)V

    .line 370
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getDrawingCache()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 371
    if-eqz v1, :cond_0

    .line 374
    :try_start_0
    invoke-static {v1}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 391
    :cond_0
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setDrawingCacheEnabled(Z)V

    .line 394
    :cond_1
    return-object v0

    .line 375
    :catch_0
    move-exception v2

    .line 378
    .local v2, "exception":Ljava/lang/Exception;
    iput-object v6, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    .line 379
    sget-boolean v4, Lcom/amazon/mShop/web/MShopWebActivity;->DEBUG:Z

    if-eqz v4, :cond_0

    .line 380
    const-string/jumbo v4, "MShopWebActivity"

    const-string/jumbo v5, "exception happend in captureTopView"

    invoke-static {v4, v5, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 382
    .end local v2    # "exception":Ljava/lang/Exception;
    :catch_1
    move-exception v3

    .line 383
    .local v3, "oome":Ljava/lang/OutOfMemoryError;
    iput-object v6, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    .line 385
    const/16 v4, 0x32

    invoke-static {v4}, Lcom/amazon/mShop/net/LRUCache;->reduceByPercent(I)V

    .line 386
    sget-boolean v4, Lcom/amazon/mShop/web/MShopWebActivity;->DEBUG:Z

    if-eqz v4, :cond_0

    .line 387
    const-string/jumbo v4, "MShopWebActivity"

    const-string/jumbo v5, "OutOfMemoryError happend in captureTopView"

    invoke-static {v4, v5, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected getCurrentUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 322
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getModalActivityClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 636
    const-class v0, Lcom/amazon/mShop/web/MShopModalWebActivity;

    return-object v0
.end method

.method public getPostParameters()[B
    .locals 2

    .prologue
    .line 311
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "postParams"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getByteArrayExtra(Ljava/lang/String;)[B

    move-result-object v0

    return-object v0
.end method

.method public getRealClickTime()J
    .locals 2

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebviewLoadStartTime:J

    return-wide v0
.end method

.method public getThreadPool()Ljava/util/concurrent/ExecutorService;
    .locals 1

    .prologue
    .line 589
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mThreadPool:Ljava/util/concurrent/ExecutorService;

    if-nez v0, :cond_0

    .line 591
    invoke-static {}, Ljava/util/concurrent/Executors;->newCachedThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mThreadPool:Ljava/util/concurrent/ExecutorService;

    .line 593
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mThreadPool:Ljava/util/concurrent/ExecutorService;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 2

    .prologue
    .line 307
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getWebView()Landroid/webkit/WebView;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 267
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    .line 269
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    return-object v0
.end method

.method protected goForwardTransition()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 402
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->web_view_frame:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/web/MShopWebActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 403
    .local v0, "webviewContainer":Landroid/view/View;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    if-eqz v1, :cond_0

    invoke-virtual {p0, v0, v2}, Lcom/amazon/mShop/web/MShopWebActivity;->removeView(Landroid/view/View;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 405
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebActivity;->pushView(Landroid/view/View;)V

    .line 406
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/web/MShopWebActivity;->removeView(Landroid/view/View;Z)Z

    .line 407
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mPicture:Lcom/amazon/mShop/web/TitledImageView;

    .line 409
    sget-boolean v1, Lcom/amazon/mShop/web/MShopWebActivity;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 410
    const-string/jumbo v1, "MShopWebActivity"

    const-string/jumbo v2, "goForwardTransition"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 413
    :cond_0
    return-void
.end method

.method protected initLayout()V
    .locals 3

    .prologue
    .line 262
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->web_activity:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebActivity;->pushView(Landroid/view/View;)V

    .line 263
    return-void
.end method

.method protected initWebView()V
    .locals 3

    .prologue
    .line 241
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/web/MShopWebFragment;->initWebViewContainer(Lcom/amazon/mShop/web/MShopWebActivity;)V

    .line 242
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->isMethodPOST()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 243
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getPostParameters()[B

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebView;->postUrl(Ljava/lang/String;[B)V

    .line 247
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->initLayout()V

    .line 248
    return-void

    .line 245
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->loadUrl()V

    goto :goto_0
.end method

.method public isBackTransitionPending()Z
    .locals 1

    .prologue
    .line 480
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mBackTransitionPending:Z

    return v0
.end method

.method public isForwardTransitionPending()Z
    .locals 1

    .prologue
    .line 475
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mForwardTransitionPending:Z

    return v0
.end method

.method public isMethodPOST()Z
    .locals 3

    .prologue
    .line 315
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "method"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 316
    .local v0, "method":Ljava/lang/String;
    const-string/jumbo v1, "POST"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected loadUrl()V
    .locals 2

    .prologue
    .line 255
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 256
    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "intent"    # Landroid/content/Intent;

    .prologue
    .line 549
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/AmazonActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 550
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mActivityResultCallback:Lorg/apache/cordova/CordovaPlugin;

    if-eqz v0, :cond_0

    .line 551
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mActivityResultCallback:Lorg/apache/cordova/CordovaPlugin;

    invoke-virtual {v0, p1, p2, p3}, Lorg/apache/cordova/CordovaPlugin;->onActivityResult(IILandroid/content/Intent;)V

    .line 555
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mobile/mash/MASHWebView;

    if-eqz v0, :cond_1

    .line 556
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/MASHWebView;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mobile/mash/MASHWebView;->checkForFileChooserActivityResult(IILandroid/content/Intent;)V

    .line 560
    :cond_1
    const/16 v0, 0x11

    if-ne p1, v0, :cond_2

    const/4 v0, -0x1

    if-ne p2, v0, :cond_2

    .line 561
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    const-string/jumbo v1, "javascript:try{app.willReappear2();}catch(e){}"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 564
    :cond_2
    const v0, 0xface

    if-ne p1, v0, :cond_3

    .line 565
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v0

    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/facebook/Session;->onActivityResult(Landroid/app/Activity;IILandroid/content/Intent;)Z

    .line 567
    :cond_3
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 127
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->calcWebviewStartTime()V

    .line 128
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->cordovaOnCreate()V

    .line 129
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 130
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->web_view_frame:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/web/MShopWebFragment;->add(Landroid/support/v4/app/FragmentManager;I)Lcom/amazon/mShop/web/MShopWebFragment;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    .line 131
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->processSavedInstanceAndInitWebview(Landroid/os/Bundle;)V

    .line 132
    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 213
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    .line 218
    .local v0, "webView":Landroid/webkit/WebView;
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->removeAllViews()V

    .line 223
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 224
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->destroy()V

    .line 227
    :cond_0
    if-eqz v0, :cond_1

    .line 228
    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    .line 234
    :cond_1
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 235
    return-void
.end method

.method public onMessage(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/Object;

    .prologue
    .line 584
    const/4 v0, 0x0

    return-object v0
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 102
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 104
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->setIntent(Landroid/content/Intent;)V

    .line 108
    invoke-static {p0}, Lorg/apache/cordova/Config;->init(Landroid/app/Activity;)V

    .line 109
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->calcWebviewStartTime()V

    .line 111
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 112
    .local v0, "newUrl":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 117
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->stopLoading()V

    .line 118
    const-string/jumbo v1, "KeepHistoryStack"

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_0

    .line 119
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->clearHistory()V

    .line 121
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 123
    :cond_1
    return-void
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 179
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->clearDisappearingChildren()V

    .line 180
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onPause()V

    .line 181
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mIsLastOnPause:Z

    if-nez v0, :cond_0

    .line 184
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/web/MShopWebView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebView;->handlePause(Z)V

    .line 186
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebFragment;->detach()V

    .line 187
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 191
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onResume()V

    .line 192
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mIsFirstOnResume:Z

    if-eqz v0, :cond_0

    .line 193
    iput-boolean v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mIsFirstOnResume:Z

    .line 200
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setIsPageLoadHandledNatively(Z)V

    .line 201
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebFragment;->attach()V

    .line 202
    return-void

    .line 195
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v0, v2, v2}, Lcom/amazon/mShop/web/MShopWebView;->handleResume(ZZ)V

    goto :goto_0
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 167
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStop()V

    .line 170
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 173
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->handlePageLoadNatively()V

    .line 175
    :cond_0
    return-void
.end method

.method protected processSavedInstanceAndInitWebview(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/high16 v2, 0x1000000

    const/4 v0, 0x1

    .line 135
    if-eqz p1, :cond_0

    .line 141
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->finish()V

    .line 163
    :goto_0
    return-void

    .line 152
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isHtmlGatewayWebViewHAOff()Z

    move-result v1

    if-eqz v1, :cond_1

    instance-of v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    if-nez v1, :cond_3

    .line 155
    .local v0, "htmlGatewayWebViewHACondition":Z
    :cond_1
    :goto_1
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSpinnerV2Enabled()Z

    move-result v1

    if-eqz v1, :cond_2

    if-eqz v0, :cond_2

    .line 158
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v2, v2}, Landroid/view/Window;->setFlags(II)V

    .line 162
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->initWebView()V

    goto :goto_0

    .line 152
    .end local v0    # "htmlGatewayWebViewHACondition":Z
    :cond_3
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public refresh()V
    .locals 1

    .prologue
    .line 326
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    .line 327
    .local v0, "webView":Landroid/webkit/WebView;
    if-eqz v0, :cond_0

    .line 328
    invoke-virtual {v0}, Landroid/webkit/WebView;->stopLoading()V

    .line 329
    invoke-virtual {v0}, Landroid/webkit/WebView;->reload()V

    .line 332
    :cond_0
    return-void
.end method

.method public replaceRootWebViewWithNewUrl(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V
    .locals 7
    .param p1, "webView"    # Lcom/amazon/mobile/mash/MASHWebView;
    .param p2, "mashNavRequest"    # Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    .prologue
    .line 607
    :try_start_0
    const-string/jumbo v3, "POST"

    invoke-virtual {p2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getMethod()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 608
    invoke-virtual {p2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getParams()Lorg/json/JSONObject;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mobile/mash/util/Util;->getPostDataAsByteArray(Lorg/json/JSONObject;)[B

    move-result-object v2

    .line 609
    .local v2, "postParams":[B
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string/jumbo v4, "method"

    invoke-virtual {p2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getMethod()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 610
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string/jumbo v4, "postParams"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;

    .line 611
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 620
    .end local v2    # "postParams":[B
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/webkit/WebView;->stopLoading()V

    .line 621
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/webkit/WebView;->destroy()V

    .line 625
    new-instance v1, Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-direct {v1}, Lcom/amazon/mShop/web/MShopWebFragment;-><init>()V

    .line 626
    .local v1, "fragment":Lcom/amazon/mShop/web/MShopWebFragment;
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebFragment;->getId()I

    move-result v4

    invoke-virtual {v3, v4, v1}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 627
    iput-object v1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    .line 630
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->removeAllViews()V

    .line 631
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->initWebView()V

    .line 632
    return-void

    .line 613
    .end local v1    # "fragment":Lcom/amazon/mShop/web/MShopWebFragment;
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getParams()Lorg/json/JSONObject;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->getFullUrlForGetRequest(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 616
    :catch_0
    move-exception v0

    .line 617
    .local v0, "e":Lorg/json/JSONException;
    const-string/jumbo v3, "MShopWebActivity"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "JSON parameters parse error : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public setActivityResultCallback(Lorg/apache/cordova/CordovaPlugin;)V
    .locals 0
    .param p1, "cordovaPlugin"    # Lorg/apache/cordova/CordovaPlugin;

    .prologue
    .line 571
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mActivityResultCallback:Lorg/apache/cordova/CordovaPlugin;

    .line 572
    return-void
.end method

.method public startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V
    .locals 0
    .param p1, "cordovaPlugin"    # Lorg/apache/cordova/CordovaPlugin;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "requestCode"    # I

    .prologue
    .line 543
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebActivity;->mActivityResultCallback:Lorg/apache/cordova/CordovaPlugin;

    .line 544
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mShop/web/MShopWebActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 545
    return-void
.end method
