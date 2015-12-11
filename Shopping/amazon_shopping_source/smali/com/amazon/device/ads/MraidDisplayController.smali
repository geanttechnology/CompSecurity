.class Lcom/amazon/device/ads/MraidDisplayController;
.super Lcom/amazon/device/ads/MraidAbstractController;
.source "MraidDisplayController.java"


# static fields
.field private static final CLOSE_BUTTON_SIZE_DP:I = 0x32

.field private static final LOGTAG:Ljava/lang/String; = "MraidDisplayController"


# instance fields
.field protected adContainerLayoutId_:I

.field private mAdWantsCustomCloseButton:Z

.field private mCloseButton:Landroid/widget/ImageView;

.field private mContext:Landroid/content/Context;

.field protected mDensity:F

.field private final mExpansionStyle:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

.field private mIsViewable:Z

.field private final mNativeCloseButtonStyle:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

.field private mOrientationBroadcastReceiver:Landroid/content/BroadcastReceiver;

.field private final mOriginalRequestedOrientation:I

.field mPlaceholderView:Landroid/widget/FrameLayout;

.field private mRegistered:Z

.field private mRootView:Landroid/widget/FrameLayout;

.field protected mScreenHeight:I

.field protected mScreenWidth:I

.field private mTwoPartExpansionView:Lcom/amazon/device/ads/MraidView;

.field private mViewHeight:I

.field private mViewIndexInParent:I

.field private mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

.field private mViewWidth:I

.field private modalContainerLayoutId_:I

.field private scalingMultiplier_:D

.field private vidPlayer_:Lcom/amazon/device/ads/AdVideoPlayer;

.field private vidPlaying_:Z

.field private videoContainerId_:I

.field private viewCounterIncrement_:I

.field private viewCounter_:I

.field private windowHeight_:I

.field private windowWidth_:I


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidView;Lcom/amazon/device/ads/MraidView$ExpansionStyle;Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;)V
    .locals 3
    .param p1, "view"    # Lcom/amazon/device/ads/MraidView;
    .param p2, "expStyle"    # Lcom/amazon/device/ads/MraidView$ExpansionStyle;
    .param p3, "buttonStyle"    # Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    .prologue
    const/4 v0, -0x1

    const/4 v2, 0x0

    .line 150
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/MraidAbstractController;-><init>(Lcom/amazon/device/ads/MraidView;)V

    .line 57
    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->HIDDEN:Lcom/amazon/device/ads/MraidView$ViewState;

    iput-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 72
    iput-boolean v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlaying_:Z

    .line 82
    new-instance v1, Lcom/amazon/device/ads/MraidDisplayController$1;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/MraidDisplayController$1;-><init>(Lcom/amazon/device/ads/MraidDisplayController;)V

    iput-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mOrientationBroadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 118
    iput v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenWidth:I

    .line 121
    iput v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenHeight:I

    .line 131
    iput-boolean v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRegistered:Z

    .line 140
    iput v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->modalContainerLayoutId_:I

    .line 141
    iput v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->adContainerLayoutId_:I

    .line 142
    iput v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->videoContainerId_:I

    .line 144
    const v1, 0x436dae49

    iput v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounter_:I

    .line 146
    const/16 v1, 0x32

    iput v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounterIncrement_:I

    .line 151
    iput-object p2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mExpansionStyle:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    .line 152
    iput-object p3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mNativeCloseButtonStyle:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    .line 153
    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidView;->getWindowHeight()I

    move-result v1

    iput v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->windowHeight_:I

    .line 154
    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidView;->getWindowWidth()I

    move-result v1

    iput v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->windowWidth_:I

    .line 155
    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidView;->getScalingMultiplier()D

    move-result-wide v1

    iput-wide v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->scalingMultiplier_:D

    .line 157
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mContext:Landroid/content/Context;

    .line 158
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mContext:Landroid/content/Context;

    instance-of v1, v1, Landroid/app/Activity;

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mContext:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getRequestedOrientation()I

    move-result v0

    :cond_0
    iput v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mOriginalRequestedOrientation:I

    .line 162
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->initialize()V

    .line 163
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/MraidDisplayController;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidDisplayController;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getDisplayRotation()I

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/device/ads/MraidDisplayController;I)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidDisplayController;
    .param p1, "x1"    # I

    .prologue
    .line 52
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/MraidDisplayController;->onOrientationChanged(I)V

    return-void
.end method

.method static synthetic access$202(Lcom/amazon/device/ads/MraidDisplayController;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidDisplayController;
    .param p1, "x1"    # Z

    .prologue
    .line 52
    iput-boolean p1, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlaying_:Z

    return p1
.end method

.method static synthetic access$300(Lcom/amazon/device/ads/MraidDisplayController;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidDisplayController;

    .prologue
    .line 52
    iget v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->videoContainerId_:I

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/device/ads/MraidDisplayController;)Landroid/widget/FrameLayout;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidDisplayController;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method private establishViewIds()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 690
    iget v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->modalContainerLayoutId_:I

    if-eqz v0, :cond_0

    .line 696
    :goto_0
    return-void

    .line 693
    :cond_0
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getUniqueViewId()I

    move-result v0

    iput v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->modalContainerLayoutId_:I

    .line 694
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getUniqueViewId()I

    move-result v0

    iput v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->adContainerLayoutId_:I

    .line 695
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getUniqueViewId()I

    move-result v0

    iput v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->videoContainerId_:I

    goto :goto_0
.end method

.method private getDisplayRotation()I
    .locals 3

    .prologue
    .line 222
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string/jumbo v2, "window"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 224
    .local v0, "wm":Landroid/view/WindowManager;
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/device/ads/AndroidTargetUtils;->getOrientation(Landroid/view/Display;)I

    move-result v1

    return v1
.end method

.method private getUniqueViewId()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 662
    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    if-nez v2, :cond_0

    .line 664
    const-string/jumbo v2, "MraidDisplayController"

    const-string/jumbo v3, "Could not find root view. View ID may not be unique."

    invoke-static {v2, v3}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 665
    iget v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounter_:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounter_:I

    .line 680
    :goto_0
    return v2

    .line 668
    :cond_0
    iget v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounter_:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounter_:I

    .line 669
    const/4 v0, 0x0

    .line 670
    .local v0, "foundUnique":Z
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    const/16 v2, 0x64

    if-ge v1, v2, :cond_2

    if-nez v0, :cond_2

    .line 672
    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    iget v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounter_:I

    invoke-virtual {v2, v3}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    if-nez v2, :cond_1

    .line 673
    const/4 v0, 0x1

    .line 670
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 675
    :cond_1
    iget v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounter_:I

    iget v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounterIncrement_:I

    add-int/2addr v2, v3

    iput v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounter_:I

    goto :goto_2

    .line 677
    :cond_2
    if-nez v0, :cond_3

    .line 678
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-direct {v2}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v2

    .line 680
    :cond_3
    iget v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->viewCounter_:I

    goto :goto_0
.end method

.method private onOrientationChanged(I)V
    .locals 3
    .param p1, "currentRotation"    # I

    .prologue
    .line 228
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->initializeScreenMetrics()V

    .line 229
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRegistered:Z

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 230
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    iget v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenWidth:I

    iget v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenHeight:I

    invoke-static {v1, v2}, Lcom/amazon/device/ads/MraidScreenSizeProperty;->createWithSize(II)Lcom/amazon/device/ads/MraidScreenSizeProperty;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MraidView;->fireChangeEventForProperty(Lcom/amazon/device/ads/MraidProperty;)V

    .line 233
    :cond_0
    return-void
.end method

.method private resetViewToDefaultState()V
    .locals 8

    .prologue
    .line 344
    iget v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->adContainerLayoutId_:I

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/MraidDisplayController;->findViewByIdInRootView(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 345
    .local v0, "adContainerLayout":Landroid/widget/FrameLayout;
    iget v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->modalContainerLayoutId_:I

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/MraidDisplayController;->findViewByIdInRootView(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    .line 347
    .local v1, "expansionLayout":Landroid/widget/RelativeLayout;
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/MraidDisplayController;->setNativeCloseButtonEnabled(Z)V

    .line 348
    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViewsInLayout()V

    .line 349
    iget-object v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    invoke-virtual {v3, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 351
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/MraidView;->requestLayout()V

    .line 353
    iget-object v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mPlaceholderView:Landroid/widget/FrameLayout;

    invoke-virtual {v3}, Landroid/widget/FrameLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 354
    .local v2, "parent":Landroid/view/ViewGroup;
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v3

    iget v4, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewIndexInParent:I

    new-instance v5, Landroid/view/ViewGroup$LayoutParams;

    iget v6, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewWidth:I

    iget v7, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewHeight:I

    invoke-direct {v5, v6, v7}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v3, v4, v5}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 355
    iget-object v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mPlaceholderView:Landroid/widget/FrameLayout;

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 356
    invoke-virtual {v2}, Landroid/view/ViewGroup;->invalidate()V

    .line 357
    return-void
.end method

.method private setOrientationLockEnabled(Z)V
    .locals 7
    .param p1, "enabled"    # Z

    .prologue
    .line 584
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 585
    .local v2, "context":Landroid/content/Context;
    const/4 v1, 0x0

    .line 587
    .local v1, "activity":Landroid/app/Activity;
    :try_start_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 590
    if-eqz p1, :cond_0

    .line 592
    invoke-static {}, Lcom/amazon/device/ads/Utils;->determineCanonicalScreenOrientation()I

    move-result v4

    .line 597
    .local v4, "requestedOrientation":I
    :goto_0
    invoke-virtual {v1, v4}, Landroid/app/Activity;->setRequestedOrientation(I)V

    .line 601
    .end local v4    # "requestedOrientation":I
    :goto_1
    return-void

    .line 595
    :cond_0
    iget v4, p0, Lcom/amazon/device/ads/MraidDisplayController;->mOriginalRequestedOrientation:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .restart local v4    # "requestedOrientation":I
    goto :goto_0

    .line 598
    .end local v4    # "requestedOrientation":I
    :catch_0
    move-exception v3

    .line 599
    .local v3, "e":Ljava/lang/Exception;
    const-string/jumbo v5, "MraidDisplayController"

    const-string/jumbo v6, "Unable to modify device orientation."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private swapViewWithPlaceholderView()V
    .locals 7

    .prologue
    .line 509
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getParentOfView()Landroid/view/ViewGroup;

    move-result-object v2

    .line 510
    .local v2, "parent":Landroid/view/ViewGroup;
    if-nez v2, :cond_0

    .line 526
    :goto_0
    return-void

    .line 512
    :cond_0
    new-instance v3, Landroid/widget/FrameLayout;

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mPlaceholderView:Landroid/widget/FrameLayout;

    .line 515
    invoke-virtual {v2}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    .line 516
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "index":I
    :goto_1
    if-ge v1, v0, :cond_1

    .line 517
    invoke-virtual {v2, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v4

    if-ne v3, v4, :cond_2

    .line 520
    :cond_1
    iput v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewIndexInParent:I

    .line 521
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getViewHeight()I

    move-result v3

    iput v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewHeight:I

    .line 522
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getViewWidth()I

    move-result v3

    iput v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewWidth:I

    .line 523
    iget-object v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mPlaceholderView:Landroid/widget/FrameLayout;

    new-instance v4, Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/MraidView;->getWidth()I

    move-result v5

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/device/ads/MraidView;->getHeight()I

    move-result v6

    invoke-direct {v4, v5, v6}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v3, v1, v4}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 525
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0

    .line 516
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method


# virtual methods
.method protected addViewToRootView(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1
    .param p1, "expansionViewContainer"    # Landroid/view/ViewGroup;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 476
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    invoke-virtual {v0, p1, p2}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 477
    return-void
.end method

.method protected checkViewable()Z
    .locals 1

    .prologue
    .line 652
    const/4 v0, 0x1

    return v0
.end method

.method protected close()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 269
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlaying_:Z

    if-eqz v0, :cond_0

    .line 271
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlayer_:Lcom/amazon/device/ads/AdVideoPlayer;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdVideoPlayer;->releasePlayer()V

    .line 272
    iput-boolean v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlaying_:Z

    .line 276
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->removeKeyListenerFromWebView()V

    .line 278
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->EXPANDED:Lcom/amazon/device/ads/MraidView$ViewState;

    if-ne v0, v1, :cond_3

    .line 279
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidDisplayController;->resetViewToDefaultState()V

    .line 280
    invoke-direct {p0, v2}, Lcom/amazon/device/ads/MraidDisplayController;->setOrientationLockEnabled(Z)V

    .line 281
    sget-object v0, Lcom/amazon/device/ads/MraidView$ViewState;->DEFAULT:Lcom/amazon/device/ads/MraidView$ViewState;

    iput-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 282
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    invoke-static {v1}, Lcom/amazon/device/ads/MraidStateProperty;->createWithViewState(Lcom/amazon/device/ads/MraidView$ViewState;)Lcom/amazon/device/ads/MraidStateProperty;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MraidView;->fireChangeEventForProperty(Lcom/amazon/device/ads/MraidProperty;)V

    .line 289
    :cond_1
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getOnCloseListener()Lcom/amazon/device/ads/MraidView$OnCloseListener;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 290
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getOnCloseListener()Lcom/amazon/device/ads/MraidView$OnCloseListener;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    invoke-interface {v0, v1, v2}, Lcom/amazon/device/ads/MraidView$OnCloseListener;->onClose(Lcom/amazon/device/ads/MraidView;Lcom/amazon/device/ads/MraidView$ViewState;)V

    .line 292
    :cond_2
    return-void

    .line 283
    :cond_3
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->DEFAULT:Lcom/amazon/device/ads/MraidView$ViewState;

    if-ne v0, v1, :cond_1

    .line 284
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MraidView;->setVisibility(I)V

    .line 285
    sget-object v0, Lcom/amazon/device/ads/MraidView$ViewState;->HIDDEN:Lcom/amazon/device/ads/MraidView$ViewState;

    iput-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 286
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    invoke-static {v1}, Lcom/amazon/device/ads/MraidStateProperty;->createWithViewState(Lcom/amazon/device/ads/MraidView$ViewState;)Lcom/amazon/device/ads/MraidStateProperty;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MraidView;->fireChangeEventForProperty(Lcom/amazon/device/ads/MraidProperty;)V

    goto :goto_0
.end method

.method protected createExpansionViewContainer(Landroid/view/View;II)Landroid/view/ViewGroup;
    .locals 8
    .param p1, "expansionContentView"    # Landroid/view/View;
    .param p2, "expandWidth"    # I
    .param p3, "expandHeight"    # I

    .prologue
    const/4 v7, -0x1

    .line 552
    const/high16 v5, 0x42480000    # 50.0f

    iget v6, p0, Lcom/amazon/device/ads/MraidDisplayController;->mDensity:F

    mul-float/2addr v5, v6

    const/high16 v6, 0x3f000000    # 0.5f

    add-float/2addr v5, v6

    float-to-int v1, v5

    .line 553
    .local v1, "closeButtonSize":I
    if-ge p2, v1, :cond_0

    move p2, v1

    .line 554
    :cond_0
    if-ge p3, v1, :cond_1

    move p3, v1

    .line 556
    :cond_1
    new-instance v3, Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v3, v5}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 557
    .local v3, "expansionLayout":Landroid/widget/RelativeLayout;
    iget v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->modalContainerLayoutId_:I

    invoke-virtual {v3, v5}, Landroid/widget/RelativeLayout;->setId(I)V

    .line 559
    new-instance v2, Landroid/view/View;

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v2, v5}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 560
    .local v2, "dimmingView":Landroid/view/View;
    const/4 v5, 0x0

    invoke-virtual {v2, v5}, Landroid/view/View;->setBackgroundColor(I)V

    .line 561
    new-instance v5, Lcom/amazon/device/ads/MraidDisplayController$4;

    invoke-direct {v5, p0}, Lcom/amazon/device/ads/MraidDisplayController$4;-><init>(Lcom/amazon/device/ads/MraidDisplayController;)V

    invoke-virtual {v2, v5}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 567
    new-instance v5, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v5, v7, v7}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v2, v5}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 570
    new-instance v0, Landroid/widget/FrameLayout;

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v0, v5}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 571
    .local v0, "adContainerLayout":Landroid/widget/FrameLayout;
    iget v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->adContainerLayoutId_:I

    invoke-virtual {v0, v5}, Landroid/widget/FrameLayout;->setId(I)V

    .line 573
    new-instance v5, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v5, v7, v7}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, p1, v5}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 576
    new-instance v4, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v4, p2, p3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 577
    .local v4, "lp":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v5, 0xd

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 578
    invoke-virtual {v3, v0, v4}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 580
    return-object v3
.end method

.method public destroy()V
    .locals 3

    .prologue
    .line 237
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mOrientationBroadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 244
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mTwoPartExpansionView:Lcom/amazon/device/ads/MraidView;

    if-eqz v1, :cond_1

    .line 246
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mTwoPartExpansionView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->destroy()V

    .line 247
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mTwoPartExpansionView:Lcom/amazon/device/ads/MraidView;

    .line 249
    :cond_1
    return-void

    .line 238
    :catch_0
    move-exception v0

    .line 239
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Receiver not registered"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 241
    throw v0
.end method

.method protected detachExpandedView()V
    .locals 4

    .prologue
    .line 308
    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    sget-object v3, Lcom/amazon/device/ads/MraidView$ViewState;->EXPANDED:Lcom/amazon/device/ads/MraidView$ViewState;

    if-ne v2, v3, :cond_1

    .line 310
    const-string/jumbo v2, "MraidDisplayController"

    const-string/jumbo v3, "Ad is currently expanded. Detaching the expanded view and returning ad to its default state."

    invoke-static {v2, v3}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 314
    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    iget v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->modalContainerLayoutId_:I

    invoke-virtual {v2, v3}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 316
    .local v0, "expansionLayout":Landroid/widget/RelativeLayout;
    if-eqz v0, :cond_0

    .line 318
    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->isShown()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 320
    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    invoke-virtual {v2, v0}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 329
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mPlaceholderView:Landroid/widget/FrameLayout;

    invoke-virtual {v2}, Landroid/widget/FrameLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 330
    .local v1, "placeholderParent":Landroid/view/ViewGroup;
    if-eqz v1, :cond_1

    .line 332
    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mPlaceholderView:Landroid/widget/FrameLayout;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 333
    const/4 v2, 0x0

    invoke-direct {p0, v2}, Lcom/amazon/device/ads/MraidDisplayController;->setOrientationLockEnabled(Z)V

    .line 334
    sget-object v2, Lcom/amazon/device/ads/MraidView$ViewState;->DEFAULT:Lcom/amazon/device/ads/MraidView$ViewState;

    iput-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 335
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    invoke-static {v3}, Lcom/amazon/device/ads/MraidStateProperty;->createWithViewState(Lcom/amazon/device/ads/MraidView$ViewState;)Lcom/amazon/device/ads/MraidStateProperty;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/MraidView;->fireChangeEventForProperty(Lcom/amazon/device/ads/MraidProperty;)V

    .line 338
    .end local v0    # "expansionLayout":Landroid/widget/RelativeLayout;
    .end local v1    # "placeholderParent":Landroid/view/ViewGroup;
    :cond_1
    return-void

    .line 324
    .restart local v0    # "expansionLayout":Landroid/widget/RelativeLayout;
    :cond_2
    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->removeAllViews()V

    goto :goto_0
.end method

.method protected expand(Ljava/lang/String;IIZZ)V
    .locals 15
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "shouldUseCustomClose"    # Z
    .param p5, "shouldLockOrientation"    # Z

    .prologue
    .line 376
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mExpansionStyle:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    sget-object v3, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->DISABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    if-eq v1, v3, :cond_0

    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    sget-object v3, Lcom/amazon/device/ads/MraidView$ViewState;->EXPANDED:Lcom/amazon/device/ads/MraidView$ViewState;

    if-ne v1, v3, :cond_1

    .line 454
    :cond_0
    :goto_0
    return-void

    .line 378
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->isAdLoading()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 380
    const-string/jumbo v1, "MraidDisplayController"

    const-string/jumbo v3, "Expansion failed because ad loading is currently in progress."

    invoke-static {v1, v3}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 384
    :cond_2
    if-eqz p1, :cond_3

    invoke-static/range {p1 .. p1}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 385
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    const-string/jumbo v3, "expand"

    const-string/jumbo v4, "URL passed to expand() was invalid."

    invoke-virtual {v1, v3, v4}, Lcom/amazon/device/ads/MraidView;->fireErrorEvent(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 393
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->obtainRootView()Z

    move-result v1

    if-nez v1, :cond_4

    .line 395
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    const-string/jumbo v3, "expand"

    const-string/jumbo v4, "Root view could not be found."

    invoke-virtual {v1, v3, v4}, Lcom/amazon/device/ads/MraidView;->fireErrorEvent(Ljava/lang/String;Ljava/lang/String;)V

    .line 396
    const-string/jumbo v1, "MraidDisplayController"

    const-string/jumbo v3, "Expansion failed because root view could not be found."

    invoke-static {v1, v3}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 402
    :cond_4
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidDisplayController;->establishViewIds()V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 411
    move/from16 v0, p4

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidDisplayController;->useCustomClose(Z)V

    .line 412
    move/from16 v0, p5

    invoke-direct {p0, v0}, Lcom/amazon/device/ads/MraidDisplayController;->setOrientationLockEnabled(Z)V

    .line 413
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidDisplayController;->swapViewWithPlaceholderView()V

    .line 415
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v13

    .line 417
    .local v13, "expansionContentView":Lcom/amazon/device/ads/MraidView;
    const/4 v1, -0x1

    const/4 v3, -0x1

    invoke-virtual {v13, v1, v3}, Lcom/amazon/device/ads/MraidView;->setWebViewLayoutParams(II)V

    .line 418
    if-eqz p1, :cond_5

    .line 419
    invoke-virtual {v13}, Lcom/amazon/device/ads/MraidView;->getAdView()Lcom/amazon/device/ads/AdView;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/ads/MraidRenderer;

    .line 420
    .local v2, "renderer":Lcom/amazon/device/ads/MraidRenderer;
    invoke-static {}, Lcom/amazon/device/ads/WebViewFactory;->getInstance()Lcom/amazon/device/ads/WebViewFactory;

    move-result-object v1

    iget-object v3, v2, Lcom/amazon/device/ads/MraidRenderer;->context:Landroid/content/Context;

    invoke-virtual {v1, v3}, Lcom/amazon/device/ads/WebViewFactory;->createWebView(Landroid/content/Context;)Landroid/webkit/WebView;

    move-result-object v8

    .line 421
    .local v8, "webView":Landroid/webkit/WebView;
    new-instance v1, Lcom/amazon/device/ads/MraidView;

    iget v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->windowWidth_:I

    iget v4, p0, Lcom/amazon/device/ads/MraidDisplayController;->windowHeight_:I

    iget-wide v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->scalingMultiplier_:D

    iget-object v7, v2, Lcom/amazon/device/ads/MraidRenderer;->context:Landroid/content/Context;

    sget-object v9, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->DISABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    sget-object v10, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->AD_CONTROLLED:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    sget-object v11, Lcom/amazon/device/ads/MraidView$PlacementType;->INLINE:Lcom/amazon/device/ads/MraidView$PlacementType;

    invoke-direct/range {v1 .. v11}, Lcom/amazon/device/ads/MraidView;-><init>(Lcom/amazon/device/ads/AdView;IIDLandroid/content/Context;Landroid/webkit/WebView;Lcom/amazon/device/ads/MraidView$ExpansionStyle;Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;Lcom/amazon/device/ads/MraidView$PlacementType;)V

    iput-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mTwoPartExpansionView:Lcom/amazon/device/ads/MraidView;

    .line 430
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mTwoPartExpansionView:Lcom/amazon/device/ads/MraidView;

    new-instance v3, Lcom/amazon/device/ads/MraidDisplayController$2;

    invoke-direct {v3, p0}, Lcom/amazon/device/ads/MraidDisplayController$2;-><init>(Lcom/amazon/device/ads/MraidDisplayController;)V

    invoke-virtual {v1, v3}, Lcom/amazon/device/ads/MraidView;->setOnCloseListener(Lcom/amazon/device/ads/MraidView$OnCloseListener;)V

    .line 435
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mTwoPartExpansionView:Lcom/amazon/device/ads/MraidView;

    move-object/from16 v0, p1

    invoke-virtual {v1, v0}, Lcom/amazon/device/ads/MraidView;->loadUrlForTwoPartExpansionView(Ljava/lang/String;)V

    .line 436
    iget-object v13, p0, Lcom/amazon/device/ads/MraidDisplayController;->mTwoPartExpansionView:Lcom/amazon/device/ads/MraidView;

    .line 439
    .end local v2    # "renderer":Lcom/amazon/device/ads/MraidRenderer;
    .end local v8    # "webView":Landroid/webkit/WebView;
    :cond_5
    move/from16 v0, p2

    int-to-float v1, v0

    iget v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mDensity:F

    mul-float/2addr v1, v3

    float-to-int v1, v1

    move/from16 v0, p3

    int-to-float v3, v0

    iget v4, p0, Lcom/amazon/device/ads/MraidDisplayController;->mDensity:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    invoke-virtual {p0, v13, v1, v3}, Lcom/amazon/device/ads/MraidDisplayController;->createExpansionViewContainer(Landroid/view/View;II)Landroid/view/ViewGroup;

    move-result-object v14

    .line 441
    .local v14, "expansionViewContainer":Landroid/view/ViewGroup;
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v3, -0x1

    const/4 v4, -0x1

    invoke-direct {v1, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v14, v1}, Lcom/amazon/device/ads/MraidDisplayController;->addViewToRootView(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)V

    .line 443
    invoke-virtual {p0, v13}, Lcom/amazon/device/ads/MraidDisplayController;->setKeyListenerToClose(Lcom/amazon/device/ads/MraidView;)V

    .line 445
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mNativeCloseButtonStyle:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    sget-object v3, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->ALWAYS_VISIBLE:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    if-eq v1, v3, :cond_6

    iget-boolean v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mAdWantsCustomCloseButton:Z

    if-nez v1, :cond_7

    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mNativeCloseButtonStyle:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    sget-object v3, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->ALWAYS_HIDDEN:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    if-eq v1, v3, :cond_7

    .line 448
    :cond_6
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidDisplayController;->setNativeCloseButtonEnabled(Z)V

    .line 451
    :cond_7
    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->EXPANDED:Lcom/amazon/device/ads/MraidView$ViewState;

    iput-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 452
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    iget-object v3, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    invoke-static {v3}, Lcom/amazon/device/ads/MraidStateProperty;->createWithViewState(Lcom/amazon/device/ads/MraidView$ViewState;)Lcom/amazon/device/ads/MraidStateProperty;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/device/ads/MraidView;->fireChangeEventForProperty(Lcom/amazon/device/ads/MraidProperty;)V

    .line 453
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getOnExpandListener()Lcom/amazon/device/ads/MraidView$OnExpandListener;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getOnExpandListener()Lcom/amazon/device/ads/MraidView$OnExpandListener;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v3

    invoke-interface {v1, v3}, Lcom/amazon/device/ads/MraidView$OnExpandListener;->onExpand(Lcom/amazon/device/ads/MraidView;)V

    goto/16 :goto_0

    .line 404
    .end local v13    # "expansionContentView":Lcom/amazon/device/ads/MraidView;
    .end local v14    # "expansionViewContainer":Landroid/view/ViewGroup;
    :catch_0
    move-exception v12

    .line 406
    .local v12, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    const-string/jumbo v3, "expand"

    const-string/jumbo v4, "Could not find available view ID."

    invoke-virtual {v1, v3, v4}, Lcom/amazon/device/ads/MraidView;->fireErrorEvent(Ljava/lang/String;Ljava/lang/String;)V

    .line 407
    const-string/jumbo v1, "MraidDisplayController"

    const-string/jumbo v3, "Expansion failed because available view ID could not be found."

    invoke-static {v1, v3}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method protected findViewByIdInRootView(I)Landroid/view/View;
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 363
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    invoke-virtual {v0, p1}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected getParentOfView()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 547
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    return-object v0
.end method

.method protected getViewHeight()I
    .locals 1

    .prologue
    .line 532
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getHeight()I

    move-result v0

    return v0
.end method

.method protected getViewWidth()I
    .locals 1

    .prologue
    .line 540
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getWidth()I

    move-result v0

    return v0
.end method

.method protected initialize()V
    .locals 1

    .prologue
    .line 184
    sget-object v0, Lcom/amazon/device/ads/MraidView$ViewState;->LOADING:Lcom/amazon/device/ads/MraidView$ViewState;

    iput-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 185
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->initializeScreenMetrics()V

    .line 186
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->registerReceivers()V

    .line 187
    return-void
.end method

.method protected initializeJavaScriptState()V
    .locals 3

    .prologue
    .line 252
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 253
    .local v0, "properties":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/device/ads/MraidProperty;>;"
    iget v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenWidth:I

    iget v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenHeight:I

    invoke-static {v1, v2}, Lcom/amazon/device/ads/MraidScreenSizeProperty;->createWithSize(II)Lcom/amazon/device/ads/MraidScreenSizeProperty;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 254
    iget-boolean v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mIsViewable:Z

    invoke-static {v1}, Lcom/amazon/device/ads/MraidViewableProperty;->createWithViewable(Z)Lcom/amazon/device/ads/MraidViewableProperty;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 255
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/device/ads/MraidView;->fireChangeEventForProperties(Ljava/util/ArrayList;)V

    .line 257
    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->DEFAULT:Lcom/amazon/device/ads/MraidView$ViewState;

    iput-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 258
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    invoke-static {v2}, Lcom/amazon/device/ads/MraidStateProperty;->createWithViewState(Lcom/amazon/device/ads/MraidView$ViewState;)Lcom/amazon/device/ads/MraidStateProperty;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/MraidView;->fireChangeEventForProperty(Lcom/amazon/device/ads/MraidProperty;)V

    .line 259
    return-void
.end method

.method protected initializeScreenMetrics()V
    .locals 19

    .prologue
    .line 195
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v13

    invoke-virtual {v13}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v4

    .line 196
    .local v4, "context":Landroid/content/Context;
    new-instance v6, Landroid/util/DisplayMetrics;

    invoke-direct {v6}, Landroid/util/DisplayMetrics;-><init>()V

    .line 197
    .local v6, "metrics":Landroid/util/DisplayMetrics;
    const-string/jumbo v13, "window"

    invoke-virtual {v4, v13}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroid/view/WindowManager;

    .line 198
    .local v12, "wm":Landroid/view/WindowManager;
    invoke-interface {v12}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v13

    invoke-virtual {v13, v6}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 199
    iget v13, v6, Landroid/util/DisplayMetrics;->density:F

    move-object/from16 v0, p0

    iput v13, v0, Lcom/amazon/device/ads/MraidDisplayController;->mDensity:F

    .line 201
    const/4 v8, 0x0

    .local v8, "statusBarHeight":I
    const/4 v9, 0x0

    .line 202
    .local v9, "titleBarHeight":I
    instance-of v13, v4, Landroid/app/Activity;

    if-eqz v13, :cond_0

    move-object v2, v4

    .line 203
    check-cast v2, Landroid/app/Activity;

    .line 204
    .local v2, "activity":Landroid/app/Activity;
    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v11

    .line 205
    .local v11, "window":Landroid/view/Window;
    new-instance v7, Landroid/graphics/Rect;

    invoke-direct {v7}, Landroid/graphics/Rect;-><init>()V

    .line 206
    .local v7, "rect":Landroid/graphics/Rect;
    invoke-virtual {v11}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v13

    invoke-virtual {v13, v7}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    .line 207
    iget v8, v7, Landroid/graphics/Rect;->top:I

    .line 208
    const v13, 0x1020002

    invoke-virtual {v11, v13}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v13

    invoke-virtual {v13}, Landroid/view/View;->getTop()I

    move-result v3

    .line 209
    .local v3, "contentViewTop":I
    sub-int v9, v3, v8

    .line 213
    .end local v2    # "activity":Landroid/app/Activity;
    .end local v3    # "contentViewTop":I
    .end local v7    # "rect":Landroid/graphics/Rect;
    .end local v11    # "window":Landroid/view/Window;
    :cond_0
    iget v10, v6, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 214
    .local v10, "widthPixels":I
    iget v13, v6, Landroid/util/DisplayMetrics;->heightPixels:I

    sub-int/2addr v13, v8

    sub-int v5, v13, v9

    .line 216
    .local v5, "heightPixels":I
    int-to-double v13, v10

    const-wide/high16 v15, 0x4064000000000000L    # 160.0

    iget v0, v6, Landroid/util/DisplayMetrics;->densityDpi:I

    move/from16 v17, v0

    move/from16 v0, v17

    int-to-double v0, v0

    move-wide/from16 v17, v0

    div-double v15, v15, v17

    mul-double/2addr v13, v15

    double-to-int v13, v13

    move-object/from16 v0, p0

    iput v13, v0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenWidth:I

    .line 217
    int-to-double v13, v5

    const-wide/high16 v15, 0x4064000000000000L    # 160.0

    iget v0, v6, Landroid/util/DisplayMetrics;->densityDpi:I

    move/from16 v17, v0

    move/from16 v0, v17

    int-to-double v0, v0

    move-wide/from16 v17, v0

    div-double v15, v15, v17

    mul-double/2addr v13, v15

    double-to-int v13, v13

    move-object/from16 v0, p0

    iput v13, v0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenHeight:I

    .line 219
    return-void
.end method

.method protected isAdLoading()Z
    .locals 1

    .prologue
    .line 461
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getAdView()Lcom/amazon/device/ads/AdView;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/MraidRenderer;

    iget-object v0, v0, Lcom/amazon/device/ads/MraidRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->isAdLoading()Z

    move-result v0

    return v0
.end method

.method protected isExpanded()Z
    .locals 2

    .prologue
    .line 262
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->EXPANDED:Lcom/amazon/device/ads/MraidView$ViewState;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected obtainRootView()Z
    .locals 2

    .prologue
    .line 471
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getRootView()Landroid/view/View;

    move-result-object v0

    const v1, 0x1020002

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    .line 472
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected playVideo(Ljava/lang/String;Lcom/amazon/device/ads/Controller$Dimensions;Lcom/amazon/device/ads/Controller$PlayerProperties;)V
    .locals 9
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "d"    # Lcom/amazon/device/ads/Controller$Dimensions;
    .param p3, "props"    # Lcom/amazon/device/ads/Controller$PlayerProperties;

    .prologue
    const/4 v8, 0x0

    const/4 v7, -0x1

    .line 700
    const-string/jumbo v5, "MraidDisplayController"

    const-string/jumbo v6, "in playVideo"

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 701
    iget-boolean v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlaying_:Z

    if-eqz v5, :cond_0

    .line 760
    :goto_0
    return-void

    .line 703
    :cond_0
    invoke-virtual {p3}, Lcom/amazon/device/ads/Controller$PlayerProperties;->isFullScreen()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 705
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 706
    .local v0, "data":Landroid/os/Bundle;
    const-string/jumbo v5, "url"

    invoke-virtual {v0, v5, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 707
    const-string/jumbo v5, "player_dimensions"

    invoke-virtual {v0, v5, p2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 708
    const-string/jumbo v5, "player_properties"

    invoke-virtual {v0, v5, p3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 711
    :try_start_0
    new-instance v3, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/amazon/device/ads/AdActivity;

    invoke-direct {v3, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 712
    .local v3, "intent":Landroid/content/Intent;
    const-string/jumbo v5, "adapter"

    const-class v6, Lcom/amazon/device/ads/VideoActionHandler;

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 713
    invoke-virtual {v3, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 714
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 716
    .end local v3    # "intent":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 718
    .local v1, "e":Landroid/content/ActivityNotFoundException;
    const-string/jumbo v5, "MraidDisplayController"

    const-string/jumbo v6, "Failed to open VideoAction activity"

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 723
    .end local v0    # "data":Landroid/os/Bundle;
    .end local v1    # "e":Landroid/content/ActivityNotFoundException;
    :cond_1
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlayer_:Lcom/amazon/device/ads/AdVideoPlayer;

    if-nez v5, :cond_2

    .line 724
    new-instance v5, Lcom/amazon/device/ads/AdVideoPlayer;

    iget-object v6, p0, Lcom/amazon/device/ads/MraidDisplayController;->mContext:Landroid/content/Context;

    invoke-direct {v5, v6}, Lcom/amazon/device/ads/AdVideoPlayer;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlayer_:Lcom/amazon/device/ads/AdVideoPlayer;

    .line 726
    :cond_2
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlayer_:Lcom/amazon/device/ads/AdVideoPlayer;

    new-instance v6, Lcom/amazon/device/ads/Controller$PlayerProperties;

    invoke-direct {v6}, Lcom/amazon/device/ads/Controller$PlayerProperties;-><init>()V

    invoke-virtual {v5, v6, p1}, Lcom/amazon/device/ads/AdVideoPlayer;->setPlayData(Lcom/amazon/device/ads/Controller$PlayerProperties;Ljava/lang/String;)V

    .line 727
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlayer_:Lcom/amazon/device/ads/AdVideoPlayer;

    new-instance v6, Lcom/amazon/device/ads/MraidDisplayController$6;

    invoke-direct {v6, p0}, Lcom/amazon/device/ads/MraidDisplayController$6;-><init>(Lcom/amazon/device/ads/MraidDisplayController;)V

    invoke-virtual {v5, v6}, Lcom/amazon/device/ads/AdVideoPlayer;->setListener(Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;)V

    .line 746
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;

    iget v5, p2, Lcom/amazon/device/ads/Controller$Dimensions;->width:I

    iget v6, p2, Lcom/amazon/device/ads/Controller$Dimensions;->height:I

    invoke-direct {v2, v5, v6}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 747
    .local v2, "fl":Landroid/widget/FrameLayout$LayoutParams;
    iget v5, p2, Lcom/amazon/device/ads/Controller$Dimensions;->x:I

    iput v5, v2, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    .line 748
    iget v5, p2, Lcom/amazon/device/ads/Controller$Dimensions;->y:I

    iput v5, v2, Landroid/widget/FrameLayout$LayoutParams;->bottomMargin:I

    .line 749
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlayer_:Lcom/amazon/device/ads/AdVideoPlayer;

    invoke-virtual {v5, v2}, Lcom/amazon/device/ads/AdVideoPlayer;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 751
    new-instance v4, Landroid/widget/FrameLayout;

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v4, v5}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 752
    .local v4, "vidContainer":Landroid/widget/FrameLayout;
    iget v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->videoContainerId_:I

    invoke-virtual {v4, v5}, Landroid/widget/FrameLayout;->setId(I)V

    .line 753
    iget v5, p2, Lcom/amazon/device/ads/Controller$Dimensions;->x:I

    iget v6, p2, Lcom/amazon/device/ads/Controller$Dimensions;->y:I

    invoke-virtual {v4, v5, v6, v8, v8}, Landroid/widget/FrameLayout;->setPadding(IIII)V

    .line 754
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlayer_:Lcom/amazon/device/ads/AdVideoPlayer;

    invoke-virtual {v5, v4}, Lcom/amazon/device/ads/AdVideoPlayer;->setViewGroup(Landroid/view/ViewGroup;)V

    .line 757
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    invoke-virtual {v5, v4, v7, v7}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;II)V

    .line 758
    const/4 v5, 0x1

    iput-boolean v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlaying_:Z

    .line 759
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->vidPlayer_:Lcom/amazon/device/ads/AdVideoPlayer;

    invoke-virtual {v5}, Lcom/amazon/device/ads/AdVideoPlayer;->playVideo()V

    goto/16 :goto_0
.end method

.method protected registerReceivers()V
    .locals 4

    .prologue
    .line 166
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRegistered:Z

    if-nez v0, :cond_0

    .line 167
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRegistered:Z

    .line 168
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mOrientationBroadcastReceiver:Landroid/content/BroadcastReceiver;

    new-instance v2, Landroid/content/IntentFilter;

    const-string/jumbo v3, "android.intent.action.CONFIGURATION_CHANGED"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 171
    :cond_0
    return-void
.end method

.method protected removeKeyListenerFromWebView()V
    .locals 2

    .prologue
    .line 299
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 300
    return-void
.end method

.method protected setKeyListenerToClose(Lcom/amazon/device/ads/MraidView;)V
    .locals 2
    .param p1, "expansionContentView"    # Lcom/amazon/device/ads/MraidView;

    .prologue
    .line 488
    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidView;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->requestFocus()Z

    .line 489
    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidView;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    new-instance v1, Lcom/amazon/device/ads/MraidDisplayController$3;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/MraidDisplayController$3;-><init>(Lcom/amazon/device/ads/MraidDisplayController;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 502
    return-void
.end method

.method protected setNativeCloseButtonEnabled(Z)V
    .locals 11
    .param p1, "enabled"    # Z

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 604
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    if-nez v5, :cond_1

    .line 638
    :cond_0
    :goto_0
    return-void

    .line 606
    :cond_1
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    iget v6, p0, Lcom/amazon/device/ads/MraidDisplayController;->adContainerLayoutId_:I

    invoke-virtual {v5, v6}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 609
    .local v0, "adContainerLayout":Landroid/widget/FrameLayout;
    if-eqz p1, :cond_3

    .line 610
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mCloseButton:Landroid/widget/ImageView;

    if-nez v5, :cond_2

    .line 611
    new-instance v3, Landroid/graphics/drawable/StateListDrawable;

    invoke-direct {v3}, Landroid/graphics/drawable/StateListDrawable;-><init>()V

    .line 612
    .local v3, "states":Landroid/graphics/drawable/StateListDrawable;
    new-array v5, v10, [I

    const v6, -0x10100a7

    aput v6, v5, v9

    iget-object v6, p0, Lcom/amazon/device/ads/MraidDisplayController;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v7

    const-string/jumbo v8, "amazon_ads_close_button_normal.png"

    invoke-virtual {v7, v8}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/device/ads/AndroidTargetUtils;->getNewBitmapDrawable(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 614
    new-array v5, v10, [I

    const v6, 0x10100a7

    aput v6, v5, v9

    iget-object v6, p0, Lcom/amazon/device/ads/MraidDisplayController;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v7

    const-string/jumbo v8, "amazon_ads_close_button_pressed.png"

    invoke-virtual {v7, v8}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/device/ads/AndroidTargetUtils;->getNewBitmapDrawable(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 616
    new-instance v5, Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {v5, v6}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mCloseButton:Landroid/widget/ImageView;

    .line 617
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mCloseButton:Landroid/widget/ImageView;

    invoke-virtual {v5, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 618
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mCloseButton:Landroid/widget/ImageView;

    const/4 v6, 0x0

    invoke-static {v5, v6}, Lcom/amazon/device/ads/AndroidTargetUtils;->setBackgroundDrawable(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 619
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mCloseButton:Landroid/widget/ImageView;

    new-instance v6, Lcom/amazon/device/ads/MraidDisplayController$5;

    invoke-direct {v6, p0}, Lcom/amazon/device/ads/MraidDisplayController$5;-><init>(Lcom/amazon/device/ads/MraidDisplayController;)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 626
    .end local v3    # "states":Landroid/graphics/drawable/StateListDrawable;
    :cond_2
    const/high16 v5, 0x42480000    # 50.0f

    iget v6, p0, Lcom/amazon/device/ads/MraidDisplayController;->mDensity:F

    mul-float/2addr v5, v6

    const/high16 v6, 0x3f000000    # 0.5f

    add-float/2addr v5, v6

    float-to-int v2, v5

    .line 627
    .local v2, "buttonSize":I
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    const/4 v5, 0x5

    invoke-direct {v1, v2, v2, v5}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    .line 629
    .local v1, "buttonLayout":Landroid/widget/FrameLayout$LayoutParams;
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mCloseButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v5, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 634
    .end local v1    # "buttonLayout":Landroid/widget/FrameLayout$LayoutParams;
    .end local v2    # "buttonSize":I
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v4

    .line 635
    .local v4, "view":Lcom/amazon/device/ads/MraidView;
    invoke-virtual {v4}, Lcom/amazon/device/ads/MraidView;->getOnCloseButtonStateChangeListener()Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 636
    invoke-virtual {v4}, Lcom/amazon/device/ads/MraidView;->getOnCloseButtonStateChangeListener()Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    move-result-object v5

    invoke-interface {v5, v4, p1}, Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;->onCloseButtonStateChange(Lcom/amazon/device/ads/MraidView;Z)V

    goto/16 :goto_0

    .line 631
    .end local v4    # "view":Lcom/amazon/device/ads/MraidView;
    :cond_3
    iget-object v5, p0, Lcom/amazon/device/ads/MraidDisplayController;->mCloseButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    goto :goto_1
.end method

.method protected setRootView(Landroid/widget/FrameLayout;)V
    .locals 0
    .param p1, "layout"    # Landroid/widget/FrameLayout;

    .prologue
    .line 766
    iput-object p1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;

    .line 767
    return-void
.end method

.method protected surfaceAd()V
    .locals 2

    .prologue
    .line 191
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Lcom/amazon/device/ads/MraidViewableProperty;->createWithViewable(Z)Lcom/amazon/device/ads/MraidViewableProperty;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MraidView;->fireChangeEventForProperty(Lcom/amazon/device/ads/MraidProperty;)V

    .line 192
    return-void
.end method

.method protected unregisterReceivers()V
    .locals 2

    .prologue
    .line 174
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRegistered:Z

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 175
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidDisplayController;->mRegistered:Z

    .line 177
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mOrientationBroadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 181
    :cond_0
    :goto_0
    return-void

    .line 179
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected useCustomClose(Z)V
    .locals 3
    .param p1, "shouldUseCustomCloseButton"    # Z

    .prologue
    .line 641
    iput-boolean p1, p0, Lcom/amazon/device/ads/MraidDisplayController;->mAdWantsCustomCloseButton:Z

    .line 643
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    .line 644
    .local v1, "view":Lcom/amazon/device/ads/MraidView;
    if-nez p1, :cond_1

    const/4 v0, 0x1

    .line 645
    .local v0, "enabled":Z
    :goto_0
    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getOnCloseButtonStateChangeListener()Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 646
    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getOnCloseButtonStateChangeListener()Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    move-result-object v2

    invoke-interface {v2, v1, v0}, Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;->onCloseButtonStateChange(Lcom/amazon/device/ads/MraidView;Z)V

    .line 648
    :cond_0
    return-void

    .line 644
    .end local v0    # "enabled":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
