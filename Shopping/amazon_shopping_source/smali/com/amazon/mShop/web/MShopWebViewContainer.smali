.class public Lcom/amazon/mShop/web/MShopWebViewContainer;
.super Landroid/widget/FrameLayout;
.source "MShopWebViewContainer.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;
    }
.end annotation


# static fields
.field private static final DEBUG:Z


# instance fields
.field private hasContentHeightChanged:Z

.field private hasUpdatedVisitedHistory:Z

.field private hasWebviewAnimated:Z

.field private isPageFinished:Z

.field private final mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

.field private mCurrHistIndex:I

.field private final mDismissSpinnerJob:Ljava/lang/Runnable;

.field private mDismissSpinnerOnNonWebviewAnimation:Z

.field private mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

.field private final mHandler:Landroid/os/Handler;

.field private mIsHTTPBlockedErrorShown:Z

.field private mIsPageLoadHandledNatively:Z

.field private volatile mIsShowingSpinner:Z

.field private mIsUrlReloading:Z

.field private mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

.field private mOldLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

.field private mOldRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

.field private mPageHasStarted:Z

.field private mPendingIndex:I

.field private final mProgressBarContainer:Landroid/view/View;

.field private mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

.field private mProgressHideSpinner:I

.field private mProgressSpinnerInjectThreshold:I

.field private mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

.field private mShouldClearHistory:Z

.field private mShouldDelayTransition:Z

.field private mShouldInjectAnimation:Z

.field private mSpinnerAppearTimeStamp:Ljava/lang/Long;

.field private mStartLoadingUrl:Ljava/lang/String;

.field private final mSyncLockSpinner:Ljava/lang/Object;

.field private mTitle:Ljava/lang/CharSequence;

.field private final mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

.field private final mWebView:Lcom/amazon/mShop/web/MShopWebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 136
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 237
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 238
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 245
    move-object v0, p1

    check-cast v0, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebActivity;->createWebViewClient()Lcom/amazon/mShop/web/MShopWebViewClient;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/amazon/mShop/web/MShopWebViewClient;Lcom/amazon/mShop/web/MShopWebViewTransitionManager;)V

    .line 249
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/amazon/mShop/web/MShopWebViewClient;Lcom/amazon/mShop/web/MShopWebViewTransitionManager;)V
    .locals 10
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "webViewClient"    # Lcom/amazon/mShop/web/MShopWebViewClient;
    .param p4, "transitionManager"    # Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    .prologue
    .line 270
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 132
    new-instance v7, Landroid/os/Handler;

    invoke-direct {v7}, Landroid/os/Handler;-><init>()V

    iput-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mHandler:Landroid/os/Handler;

    .line 167
    const/16 v7, 0x32

    iput v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressHideSpinner:I

    .line 168
    const/4 v7, -0x1

    iput v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPendingIndex:I

    .line 174
    new-instance v7, Ljava/lang/Object;

    invoke-direct {v7}, Ljava/lang/Object;-><init>()V

    iput-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mSyncLockSpinner:Ljava/lang/Object;

    .line 175
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsShowingSpinner:Z

    .line 180
    const/16 v7, 0x19

    iput v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressSpinnerInjectThreshold:I

    .line 188
    const/4 v7, -0x1

    iput v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    .line 189
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasUpdatedVisitedHistory:Z

    .line 190
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->isPageFinished:Z

    .line 191
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasWebviewAnimated:Z

    .line 192
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasContentHeightChanged:Z

    .line 194
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldInjectAnimation:Z

    .line 195
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPageHasStarted:Z

    .line 199
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsUrlReloading:Z

    .line 201
    new-instance v7, Lcom/amazon/mShop/web/MShopWebViewContainer$1;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/web/MShopWebViewContainer$1;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    iput-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerJob:Ljava/lang/Runnable;

    .line 214
    const-wide/16 v7, 0x0

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mSpinnerAppearTimeStamp:Ljava/lang/Long;

    .line 216
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerOnNonWebviewAnimation:Z

    .line 226
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldDelayTransition:Z

    .line 231
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsPageLoadHandledNatively:Z

    .line 271
    iput-object p4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    .line 276
    new-instance v4, Landroid/widget/RelativeLayout;

    invoke-direct {v4, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 277
    .local v4, "webContent":Landroid/widget/RelativeLayout;
    new-instance v5, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v7, -0x1

    const/4 v8, -0x1

    invoke-direct {v5, v7, v8}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 278
    .local v5, "webContentParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    move-object v7, p1

    .line 280
    check-cast v7, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {v7}, Lcom/amazon/mShop/web/MShopWebActivity;->createWebView()Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    .line 281
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v7, p0}, Lcom/amazon/mShop/web/MShopWebView;->setWebViewContainer(Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    .line 283
    invoke-virtual {p3, p0}, Lcom/amazon/mShop/web/MShopWebViewClient;->setWebViewContainer(Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    .line 284
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v7, p3}, Lcom/amazon/mShop/web/MShopWebView;->setWebViewClient(Lorg/apache/cordova/CordovaWebViewClient;)V

    .line 285
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {p3, v7}, Lcom/amazon/mShop/web/MShopWebViewClient;->setWebView(Lorg/apache/cordova/CordovaWebView;)V

    .line 287
    new-instance v3, Lcom/amazon/mShop/web/MShopWebChromeClient;

    move-object v7, p1

    check-cast v7, Lorg/apache/cordova/CordovaInterface;

    iget-object v8, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-direct {v3, p0, v7, v8}, Lcom/amazon/mShop/web/MShopWebChromeClient;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;Lorg/apache/cordova/CordovaInterface;Lorg/apache/cordova/CordovaWebView;)V

    .line 288
    .local v3, "webChromeClient":Lcom/amazon/mShop/web/MShopWebChromeClient;
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v7, v3}, Lcom/amazon/mShop/web/MShopWebView;->setWebChromeClient(Lorg/apache/cordova/CordovaChromeClient;)V

    .line 289
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v3, v7}, Lcom/amazon/mShop/web/MShopWebChromeClient;->setWebView(Lorg/apache/cordova/CordovaWebView;)V

    .line 291
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    new-instance v8, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    invoke-virtual {p3}, Lcom/amazon/mShop/web/MShopWebViewClient;->getMASHNavDelegate()Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    move-result-object v9

    invoke-direct {v8, p1, p0, v9}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;-><init>(Landroid/content/Context;Lcom/amazon/mShop/web/MShopWebViewContainer;Lcom/amazon/mobile/mash/nav/MASHNavDelegate;)V

    invoke-virtual {v7, v8}, Lcom/amazon/mShop/web/MShopWebView;->exposeJavaScriptClient(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)V

    .line 293
    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->progress_bar:I

    const/4 v8, 0x0

    invoke-static {p1, v7, v8}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    .line 295
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    const/4 v7, -0x1

    const/4 v8, -0x1

    invoke-direct {v0, v7, v8}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 297
    .local v0, "progressBarParams":Landroid/widget/FrameLayout$LayoutParams;
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    invoke-virtual {v7, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 298
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSpinnerV2Enabled()Z

    move-result v1

    .line 299
    .local v1, "spinnerV2Enabled":Z
    iget-object v8, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    if-eqz v1, :cond_1

    const/4 v7, 0x0

    :goto_0
    invoke-virtual {v8, v7}, Landroid/view/View;->setVisibility(I)V

    .line 301
    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->bottom_toolbar:I

    const/4 v8, 0x0

    invoke-static {p1, v7, v8}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/amazon/mShop/ui/BottomToolBar;

    iput-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    .line 303
    new-instance v6, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v7, -0x1

    const/4 v8, -0x1

    invoke-direct {v6, v7, v8}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 305
    .local v6, "webViewParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/4 v7, 0x2

    iget-object v8, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v8}, Lcom/amazon/mShop/ui/BottomToolBar;->getId()I

    move-result v8

    invoke-virtual {v6, v7, v8}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 306
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v7, v6}, Lcom/amazon/mShop/web/MShopWebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 311
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Lcom/amazon/mShop/web/MShopWebView;->setVerticalFadingEdgeEnabled(Z)V

    .line 312
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$dimen;->fading_edge_length:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    invoke-virtual {v7, v8}, Lcom/amazon/mShop/web/MShopWebView;->setFadingEdgeLength(I)V

    .line 315
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Lcom/amazon/mShop/web/MShopWebView;->setScrollBarStyle(I)V

    .line 317
    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v7, -0x1

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$dimen;->bottom_toolbar_height:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    invoke-direct {v2, v7, v8}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 320
    .local v2, "toolbarParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v7, 0xc

    invoke-virtual {v2, v7}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 321
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v7, v2}, Lcom/amazon/mShop/ui/BottomToolBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 322
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v7, p0}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarParent(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;)V

    .line 323
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    const/16 v8, 0x8

    invoke-virtual {v7, v8}, Lcom/amazon/mShop/ui/BottomToolBar;->setVisibility(I)V

    .line 325
    new-instance v7, Landroid/widget/FrameLayout$LayoutParams;

    const/4 v8, -0x1

    const/4 v9, -0x1

    invoke-direct {v7, v8, v9}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v7}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 326
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v4, v7}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 327
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v4, v7}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 328
    invoke-virtual {p0, v4}, Lcom/amazon/mShop/web/MShopWebViewContainer;->addView(Landroid/view/View;)V

    .line 329
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    invoke-virtual {p0, v7}, Lcom/amazon/mShop/web/MShopWebViewContainer;->addView(Landroid/view/View;)V

    .line 332
    if-eqz v1, :cond_0

    .line 333
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showSpinner()V

    .line 335
    :cond_0
    return-void

    .line 299
    .end local v2    # "toolbarParams":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v6    # "webViewParams":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_1
    const/16 v7, 0x8

    goto/16 :goto_0
.end method

.method public constructor <init>(Lcom/amazon/mShop/web/MShopWebActivity;)V
    .locals 2
    .param p1, "activity"    # Lcom/amazon/mShop/web/MShopWebActivity;

    .prologue
    .line 257
    const/4 v0, 0x0

    invoke-virtual {p1}, Lcom/amazon/mShop/web/MShopWebActivity;->createWebViewClient()Lcom/amazon/mShop/web/MShopWebViewClient;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/amazon/mShop/web/MShopWebViewClient;Lcom/amazon/mShop/web/MShopWebViewTransitionManager;)V

    .line 261
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/web/MShopWebViewContainer;)Lcom/amazon/mShop/web/MShopWebView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebViewContainer;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    return-object v0
.end method

.method static synthetic access$100()Z
    .locals 1

    .prologue
    .line 58
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    return v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/web/MShopWebViewContainer;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebViewContainer;

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->clearError()V

    return-void
.end method

.method static synthetic access$302(Lcom/amazon/mShop/web/MShopWebViewContainer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebViewContainer;
    .param p1, "x1"    # Z

    .prologue
    .line 58
    iput-boolean p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsHTTPBlockedErrorShown:Z

    return p1
.end method

.method private applyOrientationToErrorBox(II)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 500
    new-instance v0, Landroid/content/res/Configuration;

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/content/res/Configuration;-><init>(Landroid/content/res/Configuration;)V

    .line 503
    .local v0, "configuration":Landroid/content/res/Configuration;
    if-gt p1, p2, :cond_0

    const/4 v1, 0x1

    :goto_0
    iput v1, v0, Landroid/content/res/Configuration;->orientation:I

    .line 507
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/error/AmazonErrorBox;->handleConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 508
    return-void

    .line 503
    :cond_0
    const/4 v1, 0x2

    goto :goto_0
.end method

.method private clearBottomToolBar()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 1192
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/BottomToolBar;->removeAllViews()V

    .line 1193
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/ui/BottomToolBar;->setVisibility(I)V

    .line 1194
    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mOldLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1195
    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mOldRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1196
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    if-eqz v0, :cond_0

    .line 1197
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->getItemName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-virtual {v3}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->isEnabled()Z

    move-result v3

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;ILjava/lang/String;Z)V

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mOldLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1198
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mOldLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->getOnTouchCallbackId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->setOnTouchCallbackId(Ljava/lang/String;)V

    .line 1199
    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1202
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    if-eqz v0, :cond_1

    .line 1203
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->getItemName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-virtual {v3}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->isEnabled()Z

    move-result v3

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;ILjava/lang/String;Z)V

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mOldRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1204
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mOldRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->getOnTouchCallbackId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->setOnTouchCallbackId(Ljava/lang/String;)V

    .line 1205
    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1207
    :cond_1
    return-void
.end method

.method private clearError()V
    .locals 2

    .prologue
    .line 609
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-eqz v0, :cond_0

    .line 610
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setErrorBox(Lcom/amazon/mShop/error/AmazonErrorBox;)V

    .line 611
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebView;->setVisibility(I)V

    .line 613
    :cond_0
    return-void
.end method

.method private executeJavaScript(Ljava/lang/String;)V
    .locals 2
    .param p1, "script"    # Ljava/lang/String;

    .prologue
    .line 945
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewContainer$4;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer$4;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 952
    return-void
.end method

.method private getMShopButtonById(I)Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;
    .locals 4
    .param p1, "id"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 1116
    if-nez p1, :cond_1

    .line 1117
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    if-nez v0, :cond_0

    .line 1118
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-direct {v0, p0, v2, v3, v2}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;ILjava/lang/String;Z)V

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1120
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1126
    :goto_0
    return-object v0

    .line 1123
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    if-nez v0, :cond_2

    .line 1124
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    const/4 v1, 0x1

    invoke-direct {v0, p0, v1, v3, v2}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;ILjava/lang/String;Z)V

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1126
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    goto :goto_0
.end method

.method private injectJavaScriptAnimation(Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 955
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSpinnerV2Enabled()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isInEmbeddedBrowserMode()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->notHtmlGatewayIfItsWebViewHAOff()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 959
    iput-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerOnNonWebviewAnimation:Z

    .line 960
    const-string/jumbo v1, "var _aaaap;var spinnerInterval;(function(){    var currentUrl = decodeURIComponent(\"%s\");    var locationHref = decodeURIComponent(location.href);    var anim = function() {        if (_aaaap===1) {            return;        } else if  (locationHref !== currentUrl) {             %s.finishSpinnerOnNonWebviewAnimation();            return;        }        try {            var div = document.createElement(\'div\');            div.id = \'aaap\';            div.style.position = \'fixed\';            div.style.zIndex = 99;            div.style.left = \'0px\';            div.style.width = \'1px\';            div.style.top = \'0px\';            div.style.height = \'1px\';            div.style.background = \'white\';            div.style.setProperty(\'-webkit-transform\', \'translate3d(0,0,0)\');            document.body.appendChild(div);            div.addEventListener(\'webkitTransitionEnd\',               function(e) {               try{                   window.clearInterval(spinnerInterval);                   spinnerInterval = null;                   document.body.removeChild(div);                   _aaaap = 0;                   %s.finishSpinnerWebviewAnimated(decodeURIComponent(location.href));               }catch(e){}              }            );                        spinnerInterval = window.setInterval(function(){               try{                 div.style.setProperty(\'-webkit-transform\', \'translate3d(1px,0,0)\');                 div.style.setProperty(\'-webkit-transition-duration\', \'1ms\');               }catch(e){}            }, 32);        } catch(e) {}        _aaaap = 1;    };    if(document.body !== null) {        anim();    } else {        document.addEventListener(\'DOMContentLoaded\', function(event) {anim();});    }})();"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v3

    const/4 v3, 0x1

    const-string/jumbo v4, "webclient"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string/jumbo v4, "webclient"

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 961
    .local v0, "script":Ljava/lang/String;
    sget-boolean v1, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 962
    const-string/jumbo v1, "MShopWebViewContainer"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "spinner injecting into: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 964
    :cond_0
    invoke-direct {p0, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->executeJavaScript(Ljava/lang/String;)V

    .line 966
    .end local v0    # "script":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private injectJavaScriptAnimationRemoval()V
    .locals 2

    .prologue
    .line 969
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSpinnerV2Enabled()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isInEmbeddedBrowserMode()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->notHtmlGatewayIfItsWebViewHAOff()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 973
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 974
    const-string/jumbo v0, "MShopWebViewContainer"

    const-string/jumbo v1, "spinner injectJavaScriptAnimationRemoval "

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 976
    :cond_0
    const-string/jumbo v0, "(function() {try{    if( document.body !== null){       var div = document.getElementById(\'aaap\');       if ((typeof(div) !== \'undefined\') && (div !== null)){           div.style.setProperty(\'-webkit-transform\', \'\');           div.style.setProperty(\'-webkit-transition\', \'\');           document.body.removeChild(div);           _aaaap = 0;           if ((typeof(spinnerInterval) !== \'undefined\') && (spinnerInterval !== null)){               window.clearInterval(spinnerInterval);               spinnerInterval = null;           }       }    }} catch(e) {}})();"

    invoke-direct {p0, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->executeJavaScript(Ljava/lang/String;)V

    .line 978
    :cond_1
    return-void
.end method

.method private isInEmbeddedBrowserMode()Z
    .locals 1

    .prologue
    .line 737
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->isInEmbeddedBrowserMode()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isReload(Ljava/lang/String;)Z
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 1087
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1100
    :cond_0
    :goto_0
    return v0

    .line 1093
    :cond_1
    iget-boolean v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldClearHistory:Z

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebView;->getOriginalUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1095
    :cond_2
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_3

    .line 1096
    const-string/jumbo v0, "MShopWebViewContainer"

    const-string/jumbo v1, "spinnner: reload"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1098
    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private isURLFormat(Ljava/lang/String;)Z
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 1314
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1316
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1321
    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    .line 1317
    :catch_0
    move-exception v0

    .line 1318
    .local v0, "e":Ljava/net/MalformedURLException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private notHtmlGatewayIfItsWebViewHAOff()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 987
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isHtmlGatewayWebViewHAOff()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    instance-of v1, v1, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private restoreOldBottomToolBar()V
    .locals 1

    .prologue
    .line 1214
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mOldLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1215
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mOldRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1216
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->updateBottomToolBar()V

    .line 1217
    return-void
.end method

.method private setErrorBox(Lcom/amazon/mShop/error/AmazonErrorBox;)V
    .locals 2
    .param p1, "errorBox"    # Lcom/amazon/mShop/error/AmazonErrorBox;

    .prologue
    .line 480
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-eqz v0, :cond_0

    .line 481
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->removeView(Landroid/view/View;)V

    .line 484
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    .line 486
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-eqz v0, :cond_1

    .line 487
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getHeight()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->applyOrientationToErrorBox(II)V

    .line 488
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->addView(Landroid/view/View;I)V

    .line 490
    :cond_1
    return-void
.end method

.method private shouldNavigate(Ljava/lang/String;)Z
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 1104
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1111
    :cond_0
    :goto_0
    return v1

    .line 1107
    :cond_1
    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    .line 1108
    .local v0, "lowerUrl":Ljava/lang/String;
    const-string/jumbo v2, "https://"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string/jumbo v2, "http://"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 1109
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private shouldPreventBackWhenWebPageIsScrolling()Z
    .locals 7
    .annotation build Landroid/annotation/TargetApi;
        value = 0x9
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 441
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0xa

    if-gt v5, v6, :cond_1

    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x9

    if-lt v5, v6, :cond_1

    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v5}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/mShop/util/WebUtils;->isFragmentUrl(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 446
    :try_start_0
    const-class v5, Landroid/webkit/WebView;

    const-string/jumbo v6, "mScroller"

    invoke-virtual {v5, v6}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 447
    .local v1, "filed":Ljava/lang/reflect/Field;
    const/4 v5, 0x1

    invoke-virtual {v1, v5}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 448
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v1, v5}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/widget/OverScroller;

    .line 449
    .local v2, "scroller":Landroid/widget/OverScroller;
    invoke-virtual {v2}, Landroid/widget/OverScroller;->isFinished()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    if-nez v5, :cond_0

    .line 454
    .end local v1    # "filed":Ljava/lang/reflect/Field;
    .end local v2    # "scroller":Landroid/widget/OverScroller;
    :goto_0
    return v3

    .restart local v1    # "filed":Ljava/lang/reflect/Field;
    .restart local v2    # "scroller":Landroid/widget/OverScroller;
    :cond_0
    move v3, v4

    .line 449
    goto :goto_0

    .line 450
    .end local v1    # "filed":Ljava/lang/reflect/Field;
    .end local v2    # "scroller":Landroid/widget/OverScroller;
    :catch_0
    move-exception v0

    .line 451
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v3, "MShopWebViewContainer"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Access private field mScroller fail."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    move v3, v4

    .line 454
    goto :goto_0
.end method

.method private showErrorBox(ILjava/lang/String;Landroid/view/View$OnClickListener;)V
    .locals 8
    .param p1, "errorId"    # I
    .param p2, "buttonText"    # Ljava/lang/String;
    .param p3, "buttonOnClickListener"    # Landroid/view/View$OnClickListener;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 523
    packed-switch p1, :pswitch_data_0

    .line 538
    :pswitch_0
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->error_network_fail_access_amazon_message:I

    .line 542
    .local v3, "messageId":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 543
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {v0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, p1}, Lcom/amazon/mShop/util/UIUtils;->formatErrorMessage(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v2

    .line 544
    .local v2, "message":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v1, v4}, Lcom/amazon/mShop/error/AmazonErrorBox;-><init>(Landroid/content/Context;)V

    .line 545
    .local v1, "errorBox":Lcom/amazon/mShop/error/AmazonErrorBox;
    invoke-virtual {v1, v2}, Lcom/amazon/mShop/error/AmazonErrorBox;->setMessage(Ljava/lang/CharSequence;)V

    .line 546
    if-eqz p2, :cond_0

    .line 547
    invoke-virtual {v1, v6, p2}, Lcom/amazon/mShop/error/AmazonErrorBox;->setButtonText(ILjava/lang/CharSequence;)V

    .line 549
    :cond_0
    invoke-virtual {v1, v6, p3}, Lcom/amazon/mShop/error/AmazonErrorBox;->setButtonOnClick(ILandroid/view/View$OnClickListener;)V

    .line 551
    invoke-direct {p0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setErrorBox(Lcom/amazon/mShop/error/AmazonErrorBox;)V

    .line 552
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mHandler:Landroid/os/Handler;

    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerJob:Ljava/lang/Runnable;

    invoke-virtual {v4, v5}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 553
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/web/MShopWebView;->setVisibility(I)V

    .line 554
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 557
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->injectJavaScriptAnimationRemoval()V

    .line 558
    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsShowingSpinner:Z

    .line 559
    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPageHasStarted:Z

    .line 562
    iput-boolean v6, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerOnNonWebviewAnimation:Z

    .line 563
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->clearBottomToolBar()V

    .line 564
    return-void

    .line 525
    .end local v0    # "context":Landroid/content/Context;
    .end local v1    # "errorBox":Lcom/amazon/mShop/error/AmazonErrorBox;
    .end local v2    # "message":Ljava/lang/String;
    .end local v3    # "messageId":I
    :pswitch_1
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->error_network_no_connection_message:I

    .line 526
    .restart local v3    # "messageId":I
    goto :goto_0

    .line 529
    .end local v3    # "messageId":I
    :pswitch_2
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->error_something_wrong_will_fix_message:I

    .line 530
    .restart local v3    # "messageId":I
    goto :goto_0

    .line 533
    .end local v3    # "messageId":I
    :pswitch_3
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->error_something_wrong_will_fix_message:I

    .line 534
    .restart local v3    # "messageId":I
    iput-boolean v6, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsHTTPBlockedErrorShown:Z

    goto :goto_0

    .line 523
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method private tryRemoveSpinner()V
    .locals 5

    .prologue
    .line 757
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    if-eqz v2, :cond_0

    .line 758
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    invoke-interface {v2}, Lcom/amazon/mShop/web/MShopWebViewTransitionManager;->doTransitionAnimation()V

    .line 760
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebView;->getProgress()I

    move-result v0

    .line 761
    .local v0, "progress":I
    const/4 v1, 0x0

    .line 762
    .local v1, "triggered":Z
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSpinnerV2Enabled()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isInEmbeddedBrowserMode()Z

    move-result v2

    if-nez v2, :cond_1

    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->notHtmlGatewayIfItsWebViewHAOff()Z

    move-result v2

    if-nez v2, :cond_5

    .line 766
    :cond_1
    iget v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressHideSpinner:I

    if-lt v0, v2, :cond_3

    .line 767
    sget-boolean v2, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v2, :cond_2

    .line 768
    const-string/jumbo v2, "MShopWebViewContainer"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Spinner, v1 try to hide the spinner on progress "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 770
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->hideSpinner()V

    .line 771
    const/4 v1, 0x1

    .line 806
    :cond_3
    :goto_0
    if-eqz v1, :cond_4

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingAmazonProgressDialog()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 818
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->hideProgressDialog()V

    .line 820
    :cond_4
    return-void

    .line 774
    :cond_5
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->doUpdateVisitedHistory(Z)V

    .line 781
    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasUpdatedVisitedHistory:Z

    if-eqz v2, :cond_3

    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasWebviewAnimated:Z

    if-nez v2, :cond_6

    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerOnNonWebviewAnimation:Z

    if-eqz v2, :cond_3

    const/16 v2, 0x64

    if-ge v0, v2, :cond_6

    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->isPageFinished:Z

    if-nez v2, :cond_6

    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasContentHeightChanged:Z

    if-eqz v2, :cond_3

    iget v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressHideSpinner:I

    if-lt v0, v2, :cond_3

    .line 783
    :cond_6
    sget-boolean v2, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v2, :cond_9

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingSpinner()Z

    move-result v2

    if-eqz v2, :cond_9

    .line 784
    const-string/jumbo v2, "MShopWebViewContainer"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "spinner "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebView;->getProgress()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "% hasUpdatedVisitedHistory: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasUpdatedVisitedHistory:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ", isFinished: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->isPageFinished:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ", hasWebviewAnimated: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasWebviewAnimated:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ", hasContentHeightChanged: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasContentHeightChanged:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ", mDismissSpinnerOnNonWebviewAnimation: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerOnNonWebviewAnimation:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ", currHistIndex: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v4

    invoke-virtual {v4}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 791
    const-string/jumbo v2, "MShopWebViewContainer"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "spinner: progress "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "%"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 792
    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->isPageFinished:Z

    if-eqz v2, :cond_7

    .line 793
    const-string/jumbo v2, "MShopWebViewContainer"

    const-string/jumbo v3, "spinner: pagefinished"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 795
    :cond_7
    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasWebviewAnimated:Z

    if-eqz v2, :cond_8

    .line 796
    const-string/jumbo v2, "MShopWebViewContainer"

    const-string/jumbo v3, "spinner: hasWebviewAnimated"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 798
    :cond_8
    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasContentHeightChanged:Z

    if-eqz v2, :cond_9

    .line 799
    const-string/jumbo v2, "MShopWebViewContainer"

    const-string/jumbo v3, "spinner: hasContentHeightChanged"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 802
    :cond_9
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->hideSpinner()V

    .line 803
    const/4 v1, 0x1

    goto/16 :goto_0
.end method

.method private updateBottomToolBar()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 1223
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v1}, Lcom/amazon/mShop/ui/BottomToolBar;->removeAllViews()V

    .line 1225
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingSpinner()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1226
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/ui/BottomToolBar;->setVisibility(I)V

    .line 1245
    :goto_0
    return-void

    .line 1228
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 1230
    .local v0, "toolBarItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;>;"
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->getItemName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 1231
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1234
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->getItemName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 1235
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1238
    :cond_2
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_3

    .line 1239
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/ui/BottomToolBar;->init(Ljava/util/List;)V

    .line 1240
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/ui/BottomToolBar;->setVisibility(I)V

    goto :goto_0

    .line 1242
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/ui/BottomToolBar;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public clearHistory()V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 1334
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldClearHistory:Z

    .line 1335
    iput v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    .line 1336
    iput v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPendingIndex:I

    .line 1337
    return-void
.end method

.method public destroy()V
    .locals 2

    .prologue
    .line 1341
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerJob:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1342
    return-void
.end method

.method public dismissSpinnerOnNonWebviewAnimation()V
    .locals 2

    .prologue
    .line 1361
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerOnNonWebviewAnimation:Z

    .line 1362
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 1363
    const-string/jumbo v0, "MShopWebViewContainer"

    const-string/jumbo v1, "spinner set spinner dismiss flag based on content height change, page finished or progress 100"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1365
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->tryRemoveSpinner()V

    .line 1366
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 6
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 369
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 370
    .local v0, "context":Landroid/content/Context;
    instance-of v4, v0, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v4, :cond_1

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .end local v0    # "context":Landroid/content/Context;
    invoke-virtual {v0, p1}, Lcom/amazon/mShop/AmazonActivity;->menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 429
    :cond_0
    :goto_0
    return v2

    .line 374
    :cond_1
    const/4 v4, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v5

    if-ne v4, v5, :cond_7

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v4

    if-nez v4, :cond_7

    .line 377
    iget-boolean v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsHTTPBlockedErrorShown:Z

    if-eqz v4, :cond_3

    .line 378
    iput-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsHTTPBlockedErrorShown:Z

    .line 379
    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v3}, Lcom/amazon/mShop/web/MShopWebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v3

    invoke-virtual {v3}, Landroid/webkit/WebBackForwardList;->getSize()I

    move-result v3

    if-lez v3, :cond_2

    .line 381
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->clearError()V

    goto :goto_0

    .line 385
    :cond_2
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    goto :goto_0

    .line 390
    :cond_3
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebView;->stopLoading()V

    .line 392
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 393
    .local v1, "topHistoryUrl":Ljava/lang/String;
    if-eqz v1, :cond_6

    .line 394
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mStartLoadingUrl:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 396
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebView;->canGoBack()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 401
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->clearError()V

    .line 402
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->shouldPreventBackWhenWebPageIsScrolling()Z

    move-result v3

    if-nez v3, :cond_0

    .line 403
    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v3}, Lcom/amazon/mShop/web/MShopWebView;->goBack()V

    goto :goto_0

    :cond_4
    move v2, v3

    .line 407
    goto :goto_0

    .line 412
    :cond_5
    iput-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mStartLoadingUrl:Ljava/lang/String;

    .line 413
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->restoreOldBottomToolBar()V

    .line 414
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->hideSpinner()V

    .line 417
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->clearError()V

    goto :goto_0

    :cond_6
    move v2, v3

    .line 425
    goto :goto_0

    .line 429
    .end local v1    # "topHistoryUrl":Ljava/lang/String;
    :cond_7
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    goto :goto_0
.end method

.method public doUpdateVisitedHistory(Z)V
    .locals 9
    .param p1, "force"    # Z

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 993
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingSpinner()Z

    move-result v4

    if-nez v4, :cond_1

    .line 1032
    :cond_0
    :goto_0
    return-void

    .line 997
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    .line 998
    .local v1, "histList":Landroid/webkit/WebBackForwardList;
    if-eqz v1, :cond_0

    .line 999
    iget v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    invoke-virtual {p0, v1, v4}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getHistoryUrl(Landroid/webkit/WebBackForwardList;I)Ljava/lang/String;

    move-result-object v0

    .line 1000
    .local v0, "currHistUrl":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v4}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v3

    .line 1001
    .local v3, "url":Ljava/lang/String;
    invoke-virtual {v1}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v2

    .line 1003
    .local v2, "index":I
    if-nez p1, :cond_3

    if-ltz v2, :cond_0

    iget-boolean v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsUrlReloading:Z

    if-nez v4, :cond_3

    if-nez v0, :cond_2

    if-nez v3, :cond_3

    :cond_2
    if-eqz v0, :cond_0

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 1008
    :cond_3
    iput v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    .line 1009
    iput-boolean v8, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasUpdatedVisitedHistory:Z

    .line 1010
    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->isPageFinished:Z

    .line 1011
    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasWebviewAnimated:Z

    .line 1012
    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasContentHeightChanged:Z

    .line 1013
    sget-boolean v4, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v4, :cond_4

    .line 1014
    const-string/jumbo v4, "MShopWebViewContainer"

    const-string/jumbo v5, "spinner set hasUpdatedVisitedHistory to true"

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1015
    const-string/jumbo v4, "MShopWebViewContainer"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "spinner: height:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v6}, Lcom/amazon/mShop/web/MShopWebView;->getContentHeight()I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1019
    :cond_4
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-nez v4, :cond_5

    .line 1020
    iput-boolean v8, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldInjectAnimation:Z

    .line 1029
    :goto_1
    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsUrlReloading:Z

    goto :goto_0

    .line 1022
    :cond_5
    iput-boolean v8, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerOnNonWebviewAnimation:Z

    .line 1023
    iput-boolean v7, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldInjectAnimation:Z

    goto :goto_1
.end method

.method public getHistoryUrl(Landroid/webkit/WebBackForwardList;I)Ljava/lang/String;
    .locals 3
    .param p1, "webBackForwardList"    # Landroid/webkit/WebBackForwardList;
    .param p2, "index"    # I

    .prologue
    const/4 v1, 0x0

    .line 1036
    if-ltz p2, :cond_1

    invoke-virtual {p1}, Landroid/webkit/WebBackForwardList;->getSize()I

    move-result v2

    if-ge p2, v2, :cond_1

    invoke-virtual {p1, p2}, Landroid/webkit/WebBackForwardList;->getItemAtIndex(I)Landroid/webkit/WebHistoryItem;

    move-result-object v0

    .line 1037
    .local v0, "webHistoryItem":Landroid/webkit/WebHistoryItem;
    :goto_0
    if-eqz v0, :cond_0

    .line 1038
    invoke-virtual {v0}, Landroid/webkit/WebHistoryItem;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 1040
    :cond_0
    return-object v1

    .end local v0    # "webHistoryItem":Landroid/webkit/WebHistoryItem;
    :cond_1
    move-object v0, v1

    .line 1036
    goto :goto_0
.end method

.method protected getProgressBarContainer()Landroid/view/View;
    .locals 1

    .prologue
    .line 1398
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    return-object v0
.end method

.method public getProgressHideSpinner()I
    .locals 1

    .prologue
    .line 744
    iget v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressHideSpinner:I

    return v0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 1280
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebView;->isReceivedError()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1281
    const/4 v0, 0x0

    .line 1301
    :cond_0
    :goto_0
    return-object v0

    .line 1284
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebView;->getTitle()Ljava/lang/String;

    move-result-object v0

    .line 1296
    .local v0, "title":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    invoke-direct {p0, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isURLFormat(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1301
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTitle:Ljava/lang/CharSequence;

    goto :goto_0
.end method

.method getTransitionManager()Lcom/amazon/mShop/web/MShopWebViewTransitionManager;
    .locals 1

    .prologue
    .line 342
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    return-object v0
.end method

.method public getWebView()Landroid/webkit/WebView;
    .locals 1

    .prologue
    .line 338
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    return-object v0
.end method

.method public handlePageLoadNatively()V
    .locals 2

    .prologue
    .line 1381
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsPageLoadHandledNatively:Z

    if-eqz v0, :cond_1

    .line 1382
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsPageLoadHandledNatively:Z

    .line 1383
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    if-eqz v0, :cond_0

    .line 1384
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    invoke-interface {v0}, Lcom/amazon/mShop/web/MShopWebViewTransitionManager;->doTransitionAnimation()V

    .line 1387
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewContainer$5;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/web/MShopWebViewContainer$5;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 1395
    :cond_1
    return-void
.end method

.method hideBottomButton(I)V
    .locals 1
    .param p1, "id"    # I

    .prologue
    const/4 v0, 0x0

    .line 1150
    if-nez p1, :cond_0

    .line 1151
    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mLeftButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    .line 1155
    :goto_0
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->updateBottomToolBar()V

    .line 1156
    return-void

    .line 1153
    :cond_0
    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mRightButton:Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    goto :goto_0
.end method

.method public hideProgressDialog()V
    .locals 4

    .prologue
    .line 929
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    if-eqz v1, :cond_0

    .line 931
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonProgressDialog;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 935
    :goto_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    .line 937
    :cond_0
    return-void

    .line 932
    :catch_0
    move-exception v0

    .line 933
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "MShopWebViewContainer"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "hideAmazonProgressDialog "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public hideSpinner()V
    .locals 8

    .prologue
    const/4 v3, 0x0

    .line 859
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mSyncLockSpinner:Ljava/lang/Object;

    monitor-enter v4

    .line 860
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingSpinner()Z

    move-result v2

    if-nez v2, :cond_1

    .line 861
    monitor-exit v4

    .line 895
    :cond_0
    :goto_0
    return-void

    .line 863
    :cond_1
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsShowingSpinner:Z

    .line 864
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 866
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mSpinnerAppearTimeStamp:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    sub-long/2addr v4, v6

    long-to-int v1, v4

    .line 867
    .local v1, "spinnerShowingTime":I
    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldClearHistory:Z

    if-eqz v2, :cond_2

    .line 868
    iput-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldClearHistory:Z

    .line 869
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebView;->clearHistory()V

    .line 871
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v2

    iput v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPendingIndex:I

    .line 872
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mHandler:Landroid/os/Handler;

    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerJob:Ljava/lang/Runnable;

    invoke-virtual {v2, v4}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 876
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v4, 0x0

    invoke-direct {v0, v2, v4}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 877
    .local v0, "animation":Landroid/view/animation/Animation;
    const-wide/16 v4, 0xfa

    invoke-virtual {v0, v4, v5}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 878
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->clearAnimation()V

    .line 879
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    invoke-virtual {v2, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 881
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->injectJavaScriptAnimationRemoval()V

    .line 887
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-eqz v2, :cond_3

    const/4 v2, 0x4

    :goto_1
    invoke-virtual {v4, v2}, Lcom/amazon/mShop/web/MShopWebView;->setVisibility(I)V

    .line 888
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    const/16 v4, 0x8

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 890
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->updateBottomToolBar()V

    .line 892
    iput-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPageHasStarted:Z

    .line 893
    sget-boolean v2, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v2, :cond_0

    .line 894
    const-string/jumbo v2, "MShopWebViewContainer"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "-- Hide spinner after "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "ms --"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 864
    .end local v0    # "animation":Landroid/view/animation/Animation;
    .end local v1    # "spinnerShowingTime":I
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2

    .restart local v0    # "animation":Landroid/view/animation/Animation;
    .restart local v1    # "spinnerShowingTime":I
    :cond_3
    move v2, v3

    .line 887
    goto :goto_1
.end method

.method public isShouldDelayTransition()Z
    .locals 1

    .prologue
    .line 1369
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldDelayTransition:Z

    return v0
.end method

.method public isShowingAmazonProgressDialog()Z
    .locals 1

    .prologue
    .line 902
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isShowingSpinner()Z
    .locals 1

    .prologue
    .line 898
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsShowingSpinner:Z

    return v0
.end method

.method public isWebViewReceivedError()Z
    .locals 1

    .prologue
    .line 1330
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->isReceivedError()Z

    move-result v0

    return v0
.end method

.method public navigate(Ljava/lang/String;ZZ)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "isForward"    # Z
    .param p3, "isReload"    # Z

    .prologue
    const/4 v2, 0x1

    .line 1054
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->shouldNavigate(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1084
    :cond_0
    :goto_0
    return-void

    .line 1057
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    .line 1058
    if-nez p3, :cond_2

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    if-eqz v0, :cond_2

    .line 1059
    if-eqz p2, :cond_4

    .line 1060
    iget v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    iget v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPendingIndex:I

    if-lt v0, v1, :cond_2

    .line 1061
    iget v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPendingIndex:I

    .line 1062
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/web/MShopWebViewTransitionManager;->beginForwardTransition(Ljava/lang/String;)V

    .line 1071
    :cond_2
    :goto_1
    if-eqz p1, :cond_5

    .line 1072
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showSpinner()V

    .line 1073
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setShouldDelayTransition(Z)V

    .line 1078
    :goto_2
    if-nez p3, :cond_3

    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1082
    :cond_3
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->doUpdateVisitedHistory(Z)V

    goto :goto_0

    .line 1065
    :cond_4
    iget v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    iget v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPendingIndex:I

    if-gt v0, v1, :cond_2

    .line 1066
    iget v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPendingIndex:I

    .line 1067
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/web/MShopWebViewTransitionManager;->beginBackwardTransition(Ljava/lang/String;)V

    goto :goto_1

    .line 1075
    :cond_5
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setShouldDelayTransition(Z)V

    goto :goto_2
.end method

.method public navigateBackward(Ljava/lang/String;)V
    .locals 1
    .param p1, "destinationUrl"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 1050
    invoke-virtual {p0, p1, v0, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->navigate(Ljava/lang/String;ZZ)V

    .line 1051
    return-void
.end method

.method public navigateForward(Ljava/lang/String;)V
    .locals 2
    .param p1, "destinationUrl"    # Ljava/lang/String;

    .prologue
    .line 1045
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isReload(Ljava/lang/String;)Z

    move-result v0

    .line 1046
    .local v0, "isReload":Z
    const/4 v1, 0x1

    invoke-virtual {p0, p1, v1, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->navigate(Ljava/lang/String;ZZ)V

    .line 1047
    return-void
.end method

.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 463
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-eqz v0, :cond_0

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v0

    if-eqz v0, :cond_0

    .line 467
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->applyOrientationToErrorBox(II)V

    .line 471
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    .line 472
    return-void
.end method

.method onPageFinished(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 668
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 669
    const-string/jumbo v0, "MShopWebViewContainer"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onPageFinished url = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 674
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mStartLoadingUrl:Ljava/lang/String;

    .line 676
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingAmazonProgressDialog()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 678
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->hideProgressDialog()V

    .line 683
    :cond_1
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mStartLoadingUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->isPageFinished:Z

    .line 684
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_2

    .line 685
    const-string/jumbo v0, "MShopWebViewContainer"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onPageFinished isPageFinished is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->isPageFinished:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", mStartLoadingUrl is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mStartLoadingUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 688
    :cond_2
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->tryRemoveSpinner()V

    .line 690
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSpinnerV2Enabled()Z

    move-result v0

    if-nez v0, :cond_3

    .line 692
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->hideSpinner()V

    .line 706
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->updateActivityTitle()V

    .line 707
    return-void

    .line 683
    :cond_4
    const/4 v0, 0x0

    goto :goto_0
.end method

.method onPageStarted(Ljava/lang/String;)V
    .locals 7
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    .line 622
    sget-boolean v3, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v3, :cond_0

    .line 623
    const-string/jumbo v3, "MShopWebViewContainer"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "spinner onPageStarted mStartLoadingUrl = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 625
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mStartLoadingUrl:Ljava/lang/String;

    .line 629
    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v3}, Lcom/amazon/mShop/web/MShopWebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    .line 630
    .local v1, "histList":Landroid/webkit/WebBackForwardList;
    if-eqz v1, :cond_1

    .line 631
    iget v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mCurrHistIndex:I

    invoke-virtual {p0, v1, v3}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getHistoryUrl(Landroid/webkit/WebBackForwardList;I)Ljava/lang/String;

    move-result-object v0

    .line 632
    .local v0, "currHistUrl":Ljava/lang/String;
    if-eqz v0, :cond_1

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 633
    iput-boolean v6, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsUrlReloading:Z

    .line 639
    .end local v0    # "currHistUrl":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mErrorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-nez v3, :cond_2

    .line 640
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showSpinner()V

    .line 641
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->clearBottomToolBar()V

    .line 644
    :cond_2
    iput-boolean v6, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPageHasStarted:Z

    .line 651
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 652
    .local v2, "uri":Landroid/net/Uri;
    invoke-virtual {v2}, Landroid/net/Uri;->isHierarchical()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 654
    const-string/jumbo v3, "app-title"

    invoke-virtual {v2, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTitle:Ljava/lang/CharSequence;

    .line 655
    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTitle:Ljava/lang/CharSequence;

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 656
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->updateActivityTitle()V

    .line 659
    :cond_3
    return-void
.end method

.method public onProgressChanged(I)V
    .locals 4
    .param p1, "newProgress"    # I

    .prologue
    const/4 v3, 0x0

    .line 716
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 717
    const-string/jumbo v0, "MShopWebViewContainer"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "progress: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 721
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isInEmbeddedBrowserMode()Z

    move-result v0

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasUpdatedVisitedHistory:Z

    if-eqz v0, :cond_2

    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldInjectAnimation:Z

    if-eqz v0, :cond_2

    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPageHasStarted:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    iget v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressSpinnerInjectThreshold:I

    if-lt p1, v0, :cond_2

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->shouldHideProgressIndicator()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 725
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_1

    .line 726
    const-string/jumbo v0, "MShopWebViewContainer"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, " spinner progress: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", begin to inject the animation js"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 728
    :cond_1
    iput-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldInjectAnimation:Z

    .line 729
    iput-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mPageHasStarted:Z

    .line 730
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->injectJavaScriptAnimation(Ljava/lang/String;)V

    .line 733
    :cond_2
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->tryRemoveSpinner()V

    .line 734
    return-void
.end method

.method public onToolBarItemSelected(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;)V
    .locals 4
    .param p1, "toolBarItem"    # Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .prologue
    .line 1270
    invoke-virtual {p1}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getItemId()I

    move-result v1

    invoke-direct {p0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getMShopButtonById(I)Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->getOnTouchCallbackId()Ljava/lang/String;

    move-result-object v0

    .line 1271
    .local v0, "callbackId":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-static {v1, v0, v2, v3}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$MASHcallback;->execSuccessCallback(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 1272
    return-void
.end method

.method setBottomButtonEnabled(IZ)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "isEnabled"    # Z

    .prologue
    .line 1173
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getMShopButtonById(I)Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    move-result-object v0

    .line 1174
    .local v0, "button":Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->setEnabled(Z)V

    .line 1175
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v1, v0, p2}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarItemEnabled(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;Z)V

    .line 1176
    return-void
.end method

.method setBottomButtonOnTouch(ILjava/lang/String;)V
    .locals 1
    .param p1, "id"    # I
    .param p2, "callbackId"    # Ljava/lang/String;

    .prologue
    .line 1164
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getMShopButtonById(I)Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->setOnTouchCallbackId(Ljava/lang/String;)V

    .line 1165
    return-void
.end method

.method setBottomButtonText(ILjava/lang/String;)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "text"    # Ljava/lang/String;

    .prologue
    .line 1184
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getMShopButtonById(I)Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->setItemName(Ljava/lang/String;)V

    .line 1185
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/ui/BottomToolBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 1186
    .local v0, "view":Landroid/view/View;
    instance-of v1, v0, Landroid/widget/TextView;

    if-eqz v1, :cond_0

    .line 1187
    check-cast v0, Landroid/widget/TextView;

    .end local v0    # "view":Landroid/view/View;
    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1189
    :cond_0
    return-void
.end method

.method public setIsPageLoadHandledNatively(Z)V
    .locals 0
    .param p1, "isPageLoadHandledNatively"    # Z

    .prologue
    .line 1377
    iput-boolean p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsPageLoadHandledNatively:Z

    .line 1378
    return-void
.end method

.method public setProgressHideSpinner(I)V
    .locals 0
    .param p1, "progressHideSpinner"    # I

    .prologue
    .line 753
    iput p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressHideSpinner:I

    .line 754
    return-void
.end method

.method public setShouldDelayTransition(Z)V
    .locals 0
    .param p1, "shouldDelayTransition"    # Z

    .prologue
    .line 1373
    iput-boolean p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mShouldDelayTransition:Z

    .line 1374
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 350
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTitle:Ljava/lang/CharSequence;

    .line 351
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->updateActivityTitle()V

    .line 352
    return-void
.end method

.method public showAmazonProgressDialog(Ljava/lang/String;Landroid/content/DialogInterface$OnCancelListener;)V
    .locals 4
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "cancelListener"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 907
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingSpinner()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 908
    const-string/jumbo v1, "MShopWebViewContainer"

    const-string/jumbo v2, "showAmazonProgressDialog: Not allow to show dual progress bar"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 926
    :goto_0
    return-void

    .line 913
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->hideProgressDialog()V

    .line 915
    new-instance v1, Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/amazon/mShop/AmazonProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    .line 916
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/AmazonProgressDialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 917
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonProgressDialog;->setCanceledOnTouchOutside(Z)V

    .line 918
    if-eqz p2, :cond_1

    .line 919
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v1, p2}, Lcom/amazon/mShop/AmazonProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 922
    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonProgressDialog;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 923
    :catch_0
    move-exception v0

    .line 924
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "MShopWebViewContainer"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "showAmazonProgressDialog "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method showBottomButton(ILjava/lang/String;ZLjava/lang/String;)V
    .locals 1
    .param p1, "id"    # I
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "isEnabled"    # Z
    .param p4, "callbackId"    # Ljava/lang/String;

    .prologue
    .line 1138
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getMShopButtonById(I)Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;

    move-result-object v0

    .line 1139
    .local v0, "button":Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->setItemName(Ljava/lang/String;)V

    .line 1140
    invoke-virtual {v0, p3}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->setEnabled(Z)V

    .line 1141
    invoke-virtual {v0, p4}, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->setOnTouchCallbackId(Ljava/lang/String;)V

    .line 1142
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->updateBottomToolBar()V

    .line 1143
    return-void
.end method

.method showError()V
    .locals 3

    .prologue
    .line 567
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x2

    .line 571
    .local v1, "errorId":I
    :goto_0
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewContainer$2;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/web/MShopWebViewContainer$2;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    .line 580
    .local v0, "buttonOnClickListener":Landroid/view/View$OnClickListener;
    const/4 v2, 0x0

    invoke-direct {p0, v1, v2, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showErrorBox(ILjava/lang/String;Landroid/view/View$OnClickListener;)V

    .line 581
    return-void

    .line 567
    .end local v0    # "buttonOnClickListener":Landroid/view/View$OnClickListener;
    .end local v1    # "errorId":I
    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public showSpinner()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 826
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mSyncLockSpinner:Ljava/lang/Object;

    monitor-enter v1

    .line 827
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingSpinner()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 828
    monitor-exit v1

    .line 856
    :cond_0
    :goto_0
    return-void

    .line 830
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsShowingSpinner:Z

    .line 831
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 836
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingAmazonProgressDialog()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 837
    const-string/jumbo v0, "MShopWebViewContainer"

    const-string/jumbo v1, "showSpinner: Not allow to show dual progress bar"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 831
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 840
    :cond_2
    iput-boolean v4, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasUpdatedVisitedHistory:Z

    .line 841
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mSpinnerAppearTimeStamp:Ljava/lang/Long;

    .line 844
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->updateBottomToolBar()V

    .line 845
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mDismissSpinnerJob:Ljava/lang/Runnable;

    const-wide/16 v2, 0x7530

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 846
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mProgressBarContainer:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 849
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/web/MShopWebView;->setVisibility(I)V

    .line 851
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    if-eqz v0, :cond_3

    .line 852
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mTransitionManager:Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    invoke-interface {v0}, Lcom/amazon/mShop/web/MShopWebViewTransitionManager;->doTransitionAnimation()V

    .line 854
    :cond_3
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 855
    const-string/jumbo v0, "MShopWebViewContainer"

    const-string/jumbo v1, "-- Show spinner --"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method showSslError(I)V
    .locals 3
    .param p1, "errorCode"    # I

    .prologue
    .line 585
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewContainer$3;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/web/MShopWebViewContainer$3;-><init>(Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    .line 599
    .local v0, "buttonOnClickListener":Landroid/view/View$OnClickListener;
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->go_to_amazon_home:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p1, v1, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showErrorBox(ILjava/lang/String;Landroid/view/View$OnClickListener;)V

    .line 602
    return-void
.end method

.method updateActivityTitle()V
    .locals 1

    .prologue
    .line 359
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getContext()Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v0, :cond_0

    .line 360
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    .line 362
    :cond_0
    return-void
.end method

.method public webviewAnimated()V
    .locals 2

    .prologue
    .line 1345
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasWebviewAnimated:Z

    .line 1346
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 1347
    const-string/jumbo v0, "MShopWebViewContainer"

    const-string/jumbo v1, "spinner webviewAnimated in webviewAnimated()"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1349
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->tryRemoveSpinner()V

    .line 1350
    return-void
.end method

.method public webviewContentHeightChanged()V
    .locals 3

    .prologue
    .line 1353
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->hasContentHeightChanged:Z

    .line 1354
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 1355
    const-string/jumbo v0, "MShopWebViewContainer"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "spinner contentHeightChanged, "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebView;->getContentHeight()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1357
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->tryRemoveSpinner()V

    .line 1358
    return-void
.end method
