.class public Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;
.super Landroid/widget/LinearLayout;
.source "ViewItTutorialContentView.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field protected mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

.field protected mDeviceFrame:Landroid/widget/ImageView;

.field private mDeviceFrameBottom:F

.field protected mDeviceFrameHeight:I

.field private mDeviceFrameTop:F

.field private mHistoryArrow:Landroid/widget/ImageView;

.field private mHistoryBottomTray:Landroid/widget/ImageView;

.field private mHistoryTrayFrame:Landroid/widget/LinearLayout;

.field private mHistoryTrayFrameHandle:F

.field private mHistoryTrayFrameHeight:I

.field private mNextButton:Landroid/widget/Button;

.field protected mProductsFrame:Landroid/widget/ImageView;

.field protected mProductsFrameWidth:I

.field protected mScannedHistoryItem:Landroid/widget/ImageView;

.field private mScannedItemAnimationToYValue:F

.field private mScannedItemFrame:Landroid/widget/ImageView;

.field private mScannedItemHeight:I

.field private mScannedItemWidth:I

.field protected mScreenWidth:I

.field private mSkipButton:Landroid/widget/Button;

.field private mTutorialDescription:Landroid/widget/TextView;

.field private mTutorialTitle:Landroid/widget/TextView;

.field private mTutorialTitleAndDescription:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, -0x1

    .line 66
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 67
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 68
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->view_it_tutorial:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v1, v3, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 70
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->completeTutorial()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;IF)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;
    .param p1, "x1"    # I
    .param p2, "x2"    # F

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startScannedItemTranslateAnimation(IF)V

    return-void
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mNextButton:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation4()V

    return-void
.end method

.method static synthetic access$1200(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->showHistorySlidingArrow()V

    return-void
.end method

.method static synthetic access$1300(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryArrow:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startHistoryTrayFrameTranslateAnimation()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->reLayoutContentView()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;II)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;
    .param p1, "x1"    # I
    .param p2, "x2"    # I

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->showTutorialTitleAndDescription(II)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->animateInBarcodeFrame()V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;F)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;
    .param p1, "x1"    # F

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation2(F)V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;F)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;
    .param p1, "x1"    # F

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation3(F)V

    return-void
.end method

.method static synthetic access$800(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;Landroid/view/View$OnClickListener;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;
    .param p1, "x1"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->showNextButton(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method private animateInBarcodeFrame()V
    .locals 10

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 502
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrame:Landroid/widget/ImageView;

    sget v6, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_barcode:I

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 503
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrame:Landroid/widget/ImageView;

    invoke-virtual {v5, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 505
    iget v5, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScreenWidth:I

    div-int/lit8 v5, v5, 0x2

    iget v6, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrameWidth:I

    div-int/lit8 v6, v6, 0x2

    add-int/2addr v5, v6

    int-to-float v2, v5

    .line 506
    .local v2, "fromXValue":F
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    move v5, v3

    move v6, v4

    move v7, v3

    move v8, v4

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 516
    .local v0, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    new-instance v9, Landroid/view/animation/AnimationSet;

    invoke-direct {v9, v3}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 517
    .local v9, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v9, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 518
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v9, v1}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 519
    invoke-virtual {v9, v3}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 520
    const-wide/16 v3, 0x1f4

    invoke-virtual {v9, v3, v4}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 521
    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    invoke-virtual {v9, v1}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 543
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrame:Landroid/widget/ImageView;

    invoke-virtual {v1, v9}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 544
    return-void
.end method

.method private completeTutorial()V
    .locals 3

    .prologue
    .line 158
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "keyTutorialScreenDisplayed"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    const/4 v1, -0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/AmazonActivity;->setResult(ILandroid/content/Intent;)V

    .line 160
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 161
    return-void
.end method

.method private reLayoutContentView()V
    .locals 2

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrame:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getHeight()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    .line 122
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    int-to-float v0, v0

    const v1, 0x3da3d70a    # 0.08f

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameTop:F

    .line 123
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    int-to-float v0, v0

    const v1, 0x3dcccccd    # 0.1f

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameBottom:F

    .line 124
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameBottom:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemHeight:I

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    sub-float/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemAnimationToYValue:F

    .line 126
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->setHistoryTrayToBottomOfDeviceFrame()V

    .line 127
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->setScannedHistoryItemToBottomOfDeviceFrame()V

    .line 128
    return-void
.end method

.method private setHistoryTrayToBottomOfDeviceFrame()V
    .locals 4

    .prologue
    .line 134
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    .line 135
    .local v1, "matrix":Landroid/graphics/Matrix;
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHeight:I

    sub-int/2addr v2, v3

    div-int/lit8 v2, v2, 0x2

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHeight:I

    add-int/2addr v2, v3

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameBottom:F

    float-to-int v3, v3

    sub-int/2addr v2, v3

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemHeight:I

    sub-int/2addr v2, v3

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHandle:F

    float-to-int v3, v3

    sub-int v0, v2, v3

    .line 138
    .local v0, "dy":I
    const/4 v2, 0x0

    int-to-float v3, v0

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Matrix;->setTranslate(FF)V

    .line 139
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryBottomTray:Landroid/widget/ImageView;

    invoke-virtual {v2, v1}, Landroid/widget/ImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 140
    return-void
.end method

.method private setScannedHistoryItemToBottomOfDeviceFrame()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 146
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedHistoryItem:Landroid/widget/ImageView;

    invoke-virtual {v2}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 147
    .local v0, "layoutParameters":Landroid/view/ViewGroup$LayoutParams;
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameBottom:F

    float-to-int v2, v2

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemHeight:I

    add-int/2addr v2, v3

    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 148
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedHistoryItem:Landroid/widget/ImageView;

    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 150
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameBottom:F

    float-to-int v1, v2

    .line 151
    .local v1, "paddingBottom":I
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedHistoryItem:Landroid/widget/ImageView;

    invoke-virtual {v2, v4, v4, v4, v1}, Landroid/widget/ImageView;->setPadding(IIII)V

    .line 152
    return-void
.end method

.method private showHistorySlidingArrow()V
    .locals 15

    .prologue
    const/4 v14, 0x3

    const/4 v13, 0x2

    const/4 v2, 0x0

    const/4 v5, 0x0

    const/4 v1, 0x1

    .line 613
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryArrow:Landroid/widget/ImageView;

    invoke-virtual {v3, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 614
    new-instance v9, Landroid/view/animation/AlphaAnimation;

    const/high16 v3, 0x3f000000    # 0.5f

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-direct {v9, v3, v4}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 615
    .local v9, "alphaAnimation":Landroid/view/animation/AlphaAnimation;
    invoke-virtual {v9, v14}, Landroid/view/animation/AlphaAnimation;->setRepeatCount(I)V

    .line 616
    invoke-virtual {v9, v13}, Landroid/view/animation/AlphaAnimation;->setRepeatMode(I)V

    .line 618
    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameBottom:F

    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemHeight:I

    int-to-float v4, v4

    add-float/2addr v3, v4

    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHandle:F

    add-float v10, v3, v4

    .line 619
    .local v10, "fromYValue":F
    const/high16 v3, 0x42200000    # 40.0f

    add-float v12, v10, v3

    .line 620
    .local v12, "toYValue":F
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    neg-float v6, v10

    neg-float v8, v12

    move v3, v1

    move v4, v2

    move v7, v5

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 627
    .local v0, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    invoke-virtual {v0, v14}, Landroid/view/animation/TranslateAnimation;->setRepeatCount(I)V

    .line 628
    invoke-virtual {v0, v13}, Landroid/view/animation/TranslateAnimation;->setRepeatMode(I)V

    .line 630
    new-instance v11, Landroid/view/animation/AnimationSet;

    invoke-direct {v11, v1}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 631
    .local v11, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v11, v9}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 632
    invoke-virtual {v11, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 633
    new-instance v2, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v2}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 634
    invoke-virtual {v11, v1}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 635
    const-wide/16 v1, 0x1f4

    invoke-virtual {v11, v1, v2}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 636
    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$12;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$12;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    invoke-virtual {v11, v1}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 653
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryArrow:Landroid/widget/ImageView;

    invoke-virtual {v1, v11}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 654
    return-void
.end method

.method private showNextButton(Landroid/view/View$OnClickListener;)V
    .locals 5
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    const/4 v4, 0x1

    .line 547
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mNextButton:Landroid/widget/Button;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 548
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mNextButton:Landroid/widget/Button;

    invoke-virtual {v2, p1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 550
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/4 v2, 0x0

    const/high16 v3, 0x3f800000    # 1.0f

    invoke-direct {v0, v2, v3}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 551
    .local v0, "alphaAnimation":Landroid/view/animation/AlphaAnimation;
    new-instance v1, Landroid/view/animation/AnimationSet;

    invoke-direct {v1, v4}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 552
    .local v1, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v1, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 553
    new-instance v2, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v2}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 554
    invoke-virtual {v1, v4}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 555
    const-wide/16 v2, 0x5dc

    invoke-virtual {v1, v2, v3}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 556
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mNextButton:Landroid/widget/Button;

    invoke-virtual {v2, v1}, Landroid/widget/Button;->startAnimation(Landroid/view/animation/Animation;)V

    .line 557
    return-void
.end method

.method private showTutorialTitleAndDescription(II)V
    .locals 5
    .param p1, "titleId"    # I
    .param p2, "descriptionID"    # I

    .prologue
    const/4 v4, 0x1

    .line 596
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->updateTitleAndDescription(II)V

    .line 597
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/4 v2, 0x0

    const/high16 v3, 0x3f800000    # 1.0f

    invoke-direct {v0, v2, v3}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 598
    .local v0, "alphaAnimation":Landroid/view/animation/AlphaAnimation;
    new-instance v1, Landroid/view/animation/AnimationSet;

    invoke-direct {v1, v4}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 599
    .local v1, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v1, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 600
    new-instance v2, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v2}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 601
    invoke-virtual {v1, v4}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 602
    const-wide/16 v2, 0xc8

    invoke-virtual {v1, v2, v3}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 603
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mTutorialTitleAndDescription:Landroid/view/View;

    invoke-virtual {v2, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 604
    return-void
.end method

.method private startDeviceFrameTranslateAnimation2(F)V
    .locals 9
    .param p1, "fromXValue"    # F

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 213
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x0

    move v2, p1

    move v5, v3

    move v6, v4

    move v7, v3

    move v8, v4

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 222
    .local v0, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

    const/16 v2, 0x3e8

    new-instance v3, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$4;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$4;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    invoke-direct {p0, v1, v0, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startTranslateAnimation(Landroid/view/View;Landroid/view/animation/TranslateAnimation;ILandroid/view/animation/Animation$AnimationListener;)V

    .line 238
    return-void
.end method

.method private startDeviceFrameTranslateAnimation3(F)V
    .locals 9
    .param p1, "fromXValue"    # F

    .prologue
    const/4 v5, 0x1

    const/4 v1, 0x0

    const/4 v6, 0x0

    .line 244
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrameWidth:I

    int-to-float v2, v2

    const/high16 v3, 0x3ec00000    # 0.375f

    mul-float/2addr v2, v3

    add-float v4, p1, v2

    .line 246
    .local v4, "toXValue":F
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    move v2, p1

    move v3, v1

    move v7, v5

    move v8, v6

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 254
    .local v0, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

    const/16 v2, 0x3e8

    new-instance v3, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$5;

    invoke-direct {v3, p0, v4}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$5;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;F)V

    invoke-direct {p0, v1, v0, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startTranslateAnimation(Landroid/view/View;Landroid/view/animation/TranslateAnimation;ILandroid/view/animation/Animation$AnimationListener;)V

    .line 270
    return-void
.end method

.method private startDeviceFrameTranslateAnimation4()V
    .locals 9

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 276
    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrameWidth:I

    int-to-float v1, v1

    const/high16 v5, 0x3ec00000    # 0.375f

    mul-float v2, v1, v5

    .line 277
    .local v2, "fromXValue":F
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x0

    move v5, v3

    move v6, v4

    move v7, v3

    move v8, v4

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 286
    .local v0, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

    const/16 v3, 0x1f4

    new-instance v4, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$6;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$6;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    invoke-direct {p0, v1, v0, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startTranslateAnimation(Landroid/view/View;Landroid/view/animation/TranslateAnimation;ILandroid/view/animation/Animation$AnimationListener;)V

    .line 303
    return-void
.end method

.method private startHistoryTrayFrameTranslateAnimation()V
    .locals 11

    .prologue
    const/4 v2, 0x0

    const/4 v5, 0x0

    const/4 v1, 0x1

    .line 410
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrame:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 411
    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHeight:I

    int-to-float v3, v3

    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameBottom:F

    sub-float/2addr v3, v4

    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemHeight:I

    int-to-float v4, v4

    sub-float/2addr v3, v4

    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHandle:F

    sub-float v6, v3, v4

    .line 413
    .local v6, "fromYValue":F
    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    int-to-float v3, v3

    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameTop:F

    sub-float/2addr v3, v4

    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHeight:I

    int-to-float v4, v4

    sub-float v10, v3, v4

    .line 414
    .local v10, "toYValue":F
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    neg-float v8, v10

    move v3, v1

    move v4, v2

    move v7, v5

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 422
    .local v0, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    new-instance v9, Landroid/view/animation/AnimationSet;

    invoke-direct {v9, v1}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 423
    .local v9, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v9, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 424
    new-instance v2, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v2}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v9, v2}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 425
    invoke-virtual {v9, v1}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 426
    const-wide/16 v1, 0x5dc

    invoke-virtual {v9, v1, v2}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 427
    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    invoke-virtual {v9, v1}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 451
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrame:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v9}, Landroid/widget/LinearLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 452
    return-void
.end method

.method private startScannedItemTranslateAnimation(IF)V
    .locals 13
    .param p1, "scannedItemIndex"    # I
    .param p2, "fromXValue"    # F

    .prologue
    const/4 v7, 0x1

    const/high16 v2, 0x3f800000    # 1.0f

    const/high16 v1, 0x3f000000    # 0.5f

    const/4 v5, 0x0

    .line 319
    packed-switch p1, :pswitch_data_0

    .line 335
    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    invoke-virtual {v3, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 337
    new-instance v11, Landroid/view/animation/AlphaAnimation;

    invoke-direct {v11, v1, v2}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 338
    .local v11, "alphaAnimation":Landroid/view/animation/AlphaAnimation;
    new-instance v0, Landroid/view/animation/ScaleAnimation;

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemWidth:I

    div-int/lit8 v3, v3, 0x2

    int-to-float v6, v3

    move v3, v1

    move v4, v2

    move v8, v1

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/ScaleAnimation;-><init>(FFFFIFIF)V

    .line 340
    .local v0, "scaleanimation":Landroid/view/animation/ScaleAnimation;
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v8, 0x0

    iget v10, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemAnimationToYValue:F

    move v3, v5

    move v4, p2

    move v6, p2

    move v9, v5

    invoke-direct/range {v2 .. v10}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 347
    .local v2, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    new-instance v12, Landroid/view/animation/AnimationSet;

    invoke-direct {v12, v7}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 348
    .local v12, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v12, v11}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 349
    invoke-virtual {v12, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 350
    invoke-virtual {v12, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 351
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v12, v1}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 352
    invoke-virtual {v12, v5}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 353
    const-wide/16 v3, 0x3e8

    invoke-virtual {v12, v3, v4}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 354
    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;IF)V

    invoke-virtual {v12, v1}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 403
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    invoke-virtual {v1, v12}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 404
    return-void

    .line 321
    .end local v0    # "scaleanimation":Landroid/view/animation/ScaleAnimation;
    .end local v2    # "translateAnimation":Landroid/view/animation/TranslateAnimation;
    .end local v11    # "alphaAnimation":Landroid/view/animation/AlphaAnimation;
    .end local v12    # "set":Landroid/view/animation/AnimationSet;
    :pswitch_0
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_bottle:I

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 324
    :pswitch_1
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_book:I

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 327
    :pswitch_2
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_jar:I

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 330
    :pswitch_3
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_barcode:I

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 319
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private startTranslateAnimation(Landroid/view/View;Landroid/view/animation/TranslateAnimation;ILandroid/view/animation/Animation$AnimationListener;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "translateAnimation"    # Landroid/view/animation/TranslateAnimation;
    .param p3, "duration"    # I
    .param p4, "listener"    # Landroid/view/animation/Animation$AnimationListener;

    .prologue
    const/4 v2, 0x1

    .line 306
    new-instance v0, Landroid/view/animation/AnimationSet;

    invoke-direct {v0, v2}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 307
    .local v0, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v0, p2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 308
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 309
    invoke-virtual {v0, v2}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 310
    int-to-long v1, p3

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 311
    invoke-virtual {v0, p4}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 312
    invoke-virtual {p1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 313
    return-void
.end method


# virtual methods
.method public animateOutProductsFrame(Z)V
    .locals 11
    .param p1, "isBarcode"    # Z

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 455
    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScreenWidth:I

    div-int/lit8 v4, v4, 0x2

    iget v5, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrameWidth:I

    div-int/lit8 v5, v5, 0x2

    add-int/2addr v4, v5

    int-to-float v10, v4

    .line 456
    .local v10, "toXValue":F
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    neg-float v4, v10

    move v5, v1

    move v6, v2

    move v7, v1

    move v8, v2

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 465
    .local v0, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    new-instance v9, Landroid/view/animation/AnimationSet;

    invoke-direct {v9, v1}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 466
    .local v9, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v9, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 467
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v9, v1}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 468
    invoke-virtual {v9, v3}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 469
    const-wide/16 v1, 0x1f4

    invoke-virtual {v9, v1, v2}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 470
    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;Z)V

    invoke-virtual {v9, v1}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 498
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrame:Landroid/widget/ImageView;

    invoke-virtual {v1, v9}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 499
    return-void
.end method

.method public hideNextButton()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 560
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v3, 0x0

    invoke-direct {v0, v2, v3}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 561
    .local v0, "alphaAnimation":Landroid/view/animation/AlphaAnimation;
    new-instance v1, Landroid/view/animation/AnimationSet;

    invoke-direct {v1, v4}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 562
    .local v1, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v1, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 563
    new-instance v2, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v2}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 564
    invoke-virtual {v1, v4}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 565
    const-wide/16 v2, 0x3e8

    invoke-virtual {v1, v2, v3}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 566
    new-instance v2, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$11;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$11;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    invoke-virtual {v1, v2}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 582
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mNextButton:Landroid/widget/Button;

    invoke-virtual {v2, v1}, Landroid/widget/Button;->startAnimation(Landroid/view/animation/Animation;)V

    .line 583
    return-void
.end method

.method public hideTutorialTitleAndDescription()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 586
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v3, 0x0

    invoke-direct {v0, v2, v3}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 587
    .local v0, "alphaAnimation":Landroid/view/animation/AlphaAnimation;
    new-instance v1, Landroid/view/animation/AnimationSet;

    invoke-direct {v1, v4}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 588
    .local v1, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v1, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 589
    new-instance v2, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v2}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 590
    invoke-virtual {v1, v4}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 591
    const-wide/16 v2, 0x12c

    invoke-virtual {v1, v2, v3}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 592
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mTutorialTitleAndDescription:Landroid/view/View;

    invoke-virtual {v2, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 593
    return-void
.end method

.method public reLayoutContentView(II)V
    .locals 2
    .param p1, "deviceFrameHeight"    # I
    .param p2, "productsFrameWidth"    # I

    .prologue
    .line 110
    iput p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    .line 111
    iput p2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrameWidth:I

    .line 112
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    int-to-float v0, v0

    const v1, 0x3da3d70a    # 0.08f

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameTop:F

    .line 113
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    int-to-float v0, v0

    const v1, 0x3dcccccd    # 0.1f

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameBottom:F

    .line 114
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameBottom:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemHeight:I

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    sub-float/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemAnimationToYValue:F

    .line 116
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->setHistoryTrayToBottomOfDeviceFrame()V

    .line 117
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->setScannedHistoryItemToBottomOfDeviceFrame()V

    .line 118
    return-void
.end method

.method public startDeviceFrameTranslateAnimation1()V
    .locals 12

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    const/4 v2, 0x0

    .line 167
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 168
    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScreenWidth:I

    int-to-float v10, v1

    .line 169
    .local v10, "fromXValue":F
    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrameWidth:I

    int-to-float v1, v1

    const/high16 v3, 0x3ec00000    # 0.375f

    mul-float v11, v1, v3

    .line 171
    .local v11, "toXValue":F
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$2;

    neg-float v3, v10

    neg-float v5, v11

    move-object v1, p0

    move v4, v2

    move v8, v6

    move v9, v7

    invoke-direct/range {v0 .. v9}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;IFIFIFIF)V

    .line 190
    .local v0, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

    const/16 v2, 0x3e8

    new-instance v3, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$3;

    invoke-direct {v3, p0, v11}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;F)V

    invoke-direct {p0, v1, v0, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startTranslateAnimation(Landroid/view/View;Landroid/view/animation/TranslateAnimation;ILandroid/view/animation/Animation$AnimationListener;)V

    .line 207
    return-void
.end method

.method public updateContentView()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 73
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_skip_button:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mSkipButton:Landroid/widget/Button;

    .line 74
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_next_button:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mNextButton:Landroid/widget/Button;

    .line 76
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->view_it_tutorial_title_and_description:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mTutorialTitleAndDescription:Landroid/view/View;

    .line 77
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->view_it_tutorial_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mTutorialTitle:Landroid/widget/TextView;

    .line 78
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->view_it_tutorial_description:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mTutorialDescription:Landroid/widget/TextView;

    .line 80
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_history_arrow:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryArrow:Landroid/widget/ImageView;

    .line 81
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_history_bottom_tray:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryBottomTray:Landroid/widget/ImageView;

    .line 82
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_animation_history_tray_frame:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrame:Landroid/widget/LinearLayout;

    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrame:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHeight:I

    .line 84
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHeight:I

    int-to-float v0, v0

    const v1, 0x3d23d70a    # 0.04f

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHandle:F

    .line 85
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrame:Landroid/widget/LinearLayout;

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mHistoryTrayFrameHandle:F

    float-to-int v1, v1

    invoke-virtual {v0, v2, v1, v2, v2}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 87
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_animation_scanned_item_frame:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    .line 88
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_history_scanned_item:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedHistoryItem:Landroid/widget/ImageView;

    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemHeight:I

    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemWidth:I

    .line 92
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_animation_products_frame:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrame:Landroid/widget/ImageView;

    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrame:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getWidth()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrameWidth:I

    .line 95
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_animation_device_and_history_frame:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

    .line 96
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->tutorial_animation_device_frame:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrame:Landroid/widget/ImageView;

    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->getScreenSize(Lcom/amazon/mShop/AmazonActivity;)Landroid/graphics/Point;

    move-result-object v0

    iget v0, v0, Landroid/graphics/Point;->x:I

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScreenWidth:I

    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mSkipButton:Landroid/widget/Button;

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    return-void
.end method

.method public updateTitleAndDescription(II)V
    .locals 2
    .param p1, "titleId"    # I
    .param p2, "descriptionID"    # I

    .prologue
    .line 607
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mTutorialTitle:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(I)V

    .line 608
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mTutorialDescription:Landroid/widget/TextView;

    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(I)V

    .line 609
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mTutorialTitleAndDescription:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 610
    return-void
.end method
