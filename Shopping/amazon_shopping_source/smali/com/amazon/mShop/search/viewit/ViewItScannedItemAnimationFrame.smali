.class public Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
.super Landroid/widget/LinearLayout;
.source "ViewItScannedItemAnimationFrame.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$4;
    }
.end annotation


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

.field private mBarcodeSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

.field private mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

.field private mImageSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

.field private mIsAnimationEnd:Z

.field private mIsErrorHappened:Z

.field private mItemContent:Landroid/view/ViewGroup;

.field private mItemRow:Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;

.field private mProgressContainer:Landroid/view/View;

.field private mProgressSpinner:Landroid/view/View;

.field private mProgressSpinnerMinimumHeight:I

.field private mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

.field private mStatus:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 52
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsErrorHappened:Z

    .line 53
    check-cast p1, Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 54
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_sliding_drawer_empty_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinnerMinimumHeight:I

    .line 55
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsErrorHappened:Z

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    .param p1, "x1"    # Z

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->prepareLoading(Z)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->startItemScaleAndTranslateAnimation()V

    return-void
.end method

.method static synthetic access$302(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    .param p1, "x1"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsAnimationEnd:Z

    return p1
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinner:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .prologue
    .line 27
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinnerMinimumHeight:I

    return v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    return-object v0
.end method

.method private cancel()V
    .locals 1

    .prologue
    .line 310
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBarcodeSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    if-eqz v0, :cond_0

    .line 311
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBarcodeSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->cancel()V

    .line 314
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mImageSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    if-eqz v0, :cond_1

    .line 315
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mImageSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->cancel()V

    .line 317
    :cond_1
    return-void
.end method

.method private getStatusBarHeight()I
    .locals 2

    .prologue
    .line 165
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 166
    .local v0, "frame":Landroid/graphics/Rect;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    .line 167
    iget v1, v0, Landroid/graphics/Rect;->top:I

    return v1
.end method

.method private hideProgressBar()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 138
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressContainer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 139
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinner:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 140
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 141
    return-void
.end method

.method private prepareLoading(Z)V
    .locals 3
    .param p1, "showProgressBar"    # Z

    .prologue
    const/4 v2, 0x0

    .line 125
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->setVisibility(I)V

    .line 126
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemContent:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setClickable(Z)V

    .line 127
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemContent:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 128
    iput-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsAnimationEnd:Z

    .line 130
    if-eqz p1, :cond_0

    .line 131
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->showProgressBar()V

    .line 135
    :goto_0
    return-void

    .line 133
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->hideProgressBar()V

    goto :goto_0
.end method

.method private showProgressBar()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 144
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressContainer:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 145
    .local v0, "layoutParameters":Landroid/view/ViewGroup$LayoutParams;
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBottomOffset()I

    move-result v2

    neg-int v2, v2

    if-eq v1, v2, :cond_0

    .line 146
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBottomOffset()I

    move-result v1

    neg-int v1, v1

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinnerMinimumHeight:I

    if-ge v1, v2, :cond_1

    .line 147
    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinnerMinimumHeight:I

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 151
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressContainer:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 154
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressContainer:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 155
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinner:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 156
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 157
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mStatus:Landroid/widget/TextView;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 158
    return-void

    .line 149
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBottomOffset()I

    move-result v1

    neg-int v1, v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_0
.end method

.method private startItemScaleAndTranslateAnimation()V
    .locals 19

    .prologue
    .line 175
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsAnimationEnd:Z

    .line 177
    new-instance v1, Landroid/view/animation/ScaleAnimation;

    const/high16 v2, 0x3f000000    # 0.5f

    const/high16 v3, 0x3f800000    # 1.0f

    const/high16 v4, 0x3f000000    # 0.5f

    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v6, 0x1

    const/high16 v7, 0x3f000000    # 0.5f

    const/4 v8, 0x1

    const/high16 v9, 0x3f000000    # 0.5f

    invoke-direct/range {v1 .. v9}, Landroid/view/animation/ScaleAnimation;-><init>(FFFFIFIF)V

    .line 180
    .local v1, "scaleanimation":Landroid/view/animation/ScaleAnimation;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBottomOffset()I

    move-result v3

    neg-int v12, v3

    .line 181
    .local v12, "itemHeight":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v3

    invoke-interface {v3}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Display;->getHeight()I

    move-result v13

    .line 182
    .local v13, "screenHeight":I
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_top_toolbar_height:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v15

    .line 183
    .local v15, "topToolBarHeight":I
    const/4 v2, 0x0

    .line 184
    .local v2, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v3

    iget v3, v3, Landroid/content/res/Configuration;->orientation:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 185
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getStatusBarHeight()I

    move-result v3

    sub-int v3, v13, v3

    sub-int/2addr v3, v15

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBottomOffset()I

    move-result v4

    neg-int v4, v4

    sub-int/2addr v3, v4

    div-int/lit8 v3, v3, 0x2

    div-int/lit8 v4, v12, 0x2

    add-int v17, v3, v4

    .line 186
    .local v17, "translateFromYValue":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBottomOffset()I

    move-result v3

    neg-int v3, v3

    sub-int v18, v3, v12

    .line 188
    .local v18, "translateToYValue":I
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    .end local v2    # "translateAnimation":Landroid/view/animation/TranslateAnimation;
    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    move/from16 v0, v17

    neg-int v8, v0

    int-to-float v8, v8

    const/4 v9, 0x0

    move/from16 v0, v18

    neg-int v10, v0

    int-to-float v10, v10

    invoke-direct/range {v2 .. v10}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 213
    .end local v18    # "translateToYValue":I
    .restart local v2    # "translateAnimation":Landroid/view/animation/TranslateAnimation;
    :goto_0
    new-instance v14, Landroid/view/animation/AnimationSet;

    const/4 v3, 0x1

    invoke-direct {v14, v3}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 214
    .local v14, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v14, v1}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 215
    invoke-virtual {v14, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 216
    new-instance v3, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v3}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    invoke-virtual {v14, v3}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 217
    const/4 v3, 0x1

    invoke-virtual {v14, v3}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 218
    const-wide/16 v3, 0x3e8

    invoke-virtual {v14, v3, v4}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 219
    new-instance v3, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V

    invoke-virtual {v14, v3}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 245
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemRow:Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;

    invoke-virtual {v3, v14}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 246
    return-void

    .line 199
    .end local v14    # "set":Landroid/view/animation/AnimationSet;
    .end local v17    # "translateFromYValue":I
    :cond_0
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_bottom_toolbar_height:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v11

    .line 200
    .local v11, "bottomToolBarHeight":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    iget v3, v3, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomOffset:I

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getHandle()Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    move-result v4

    add-int/2addr v3, v4

    div-int/lit8 v16, v3, 0x2

    .line 201
    .local v16, "translateFromXValue":I
    div-int/lit8 v3, v11, 0x2

    neg-int v0, v3

    move/from16 v17, v0

    .line 202
    .restart local v17    # "translateFromYValue":I
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    .end local v2    # "translateAnimation":Landroid/view/animation/TranslateAnimation;
    const/4 v3, 0x0

    move/from16 v0, v16

    int-to-float v4, v0

    const/4 v5, 0x0

    move/from16 v0, v16

    int-to-float v6, v0

    const/4 v7, 0x0

    move/from16 v0, v17

    int-to-float v8, v0

    const/4 v9, 0x0

    move/from16 v0, v17

    int-to-float v10, v0

    invoke-direct/range {v2 .. v10}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .restart local v2    # "translateAnimation":Landroid/view/animation/TranslateAnimation;
    goto :goto_0
.end method


# virtual methods
.method public dismissAnimationWindow(Z)V
    .locals 1
    .param p1, "enableLoading"    # Z

    .prologue
    .line 336
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->setVisibility(I)V

    .line 338
    if-eqz p1, :cond_0

    .line 339
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->enableLoading()V

    .line 341
    :cond_0
    return-void
.end method

.method public isLoading()Z
    .locals 1

    .prologue
    .line 161
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinner:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onDetachedFromWindow()V
    .locals 0

    .prologue
    .line 345
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 348
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->hideProgressBar()V

    .line 349
    return-void
.end method

.method protected onFinishInflate()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 59
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 60
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->setVisibility(I)V

    .line 62
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->animation_item_row:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemRow:Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;

    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemRow:Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->animation_item_content:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemContent:Landroid/view/ViewGroup;

    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemContent:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 66
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemRow:Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->view_it_item_loading_progress:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressContainer:Landroid/view/View;

    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressContainer:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->loading_progress:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinner:Landroid/view/View;

    .line 68
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressContainer:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->loading_results_status:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mStatus:Landroid/widget/TextView;

    .line 69
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->hideProgressBar()V

    .line 70
    return-void
.end method

.method public popUpLoadingWindow(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V
    .locals 5
    .param p2, "objType"    # Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "obj":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-wide/16 v3, 0xc8

    const/4 v2, 0x0

    .line 78
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isMoving()Z

    move-result v0

    if-nez v0, :cond_0

    .line 79
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$4;->$SwitchMap$com$amazon$mShop$search$viewit$ResultWrapper$ResultType:[I

    invoke-virtual {p2}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 122
    :cond_0
    :goto_0
    return-void

    .line 82
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBarcodeSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    if-nez v0, :cond_1

    .line 83
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {v0, v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBarcodeSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    .line 85
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBarcodeSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->startBarcodeSearch(Ljava/util/List;)V

    .line 86
    iput-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsErrorHappened:Z

    .line 89
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V

    invoke-interface {v0, v1, v3, v4}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    goto :goto_0

    .line 101
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mImageSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    if-nez v0, :cond_2

    .line 102
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {v0, v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mImageSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    .line 104
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mImageSearchController:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->startBasicProductsRequest(Ljava/util/List;)V

    .line 105
    iput-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsErrorHappened:Z

    .line 108
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V

    invoke-interface {v0, v1, v3, v4}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    goto :goto_0

    .line 79
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public setViewItSlidingDrawer(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V
    .locals 1
    .param p1, "slidingDrawer"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getViewItSlidingDrawerItemAdapter()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBrowser()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .line 49
    return-void
.end method

.method public showServiceCallErrorInLoadingWindow(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V
    .locals 4
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "errMsg"    # Ljava/lang/String;
    .param p3, "type"    # Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .prologue
    const/4 v3, 0x1

    .line 302
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->view_it_product_not_found:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->view_it_searching:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateTitleForPeriod(II)V

    .line 303
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsErrorHappened:Z

    .line 304
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->hideProgressBar()V

    .line 305
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p2, p3}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showDialog(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    .line 306
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->dismissAnimationWindow(Z)V

    .line 307
    return-void
.end method

.method public updateSlidingDrawerAndDismissAnimationWindow(Z)V
    .locals 2
    .param p1, "enableLoading"    # Z

    .prologue
    .line 321
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getListViewHeaderContent()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getRecentlyScannedObjects()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 323
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->setListViewHeaderVisibility(I)V

    .line 326
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->notifyDataSetChanged()V

    .line 327
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->dismissAnimationWindow(Z)V

    .line 328
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->cancel()V

    .line 329
    return-void
.end method

.method public declared-synchronized updateToShowItemContentInLoadingWindow(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V
    .locals 6
    .param p1, "item"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    .line 252
    monitor-enter p0

    :try_start_0
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 254
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->view_it_product_found:I

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_searching:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateTitleForPeriod(II)V

    .line 263
    sget-object v1, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getResultType()Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 264
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getAsinList()Ljava/util/List;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getViewItDBHelper()Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v1, v2, v3, v4, v5}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->removeSimilarObjectFromHistory(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;Lcom/amazon/mShop/search/viewit/ViewItDBHelper;Z)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v0

    .line 266
    .local v0, "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    if-eqz v0, :cond_0

    .line 267
    invoke-static {p1, v0}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->mergeSimilarObejcts(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    .line 268
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->setDeletedAsin(Ljava/lang/String;)V

    .line 269
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->setRecentlyScanned(Z)V

    .line 270
    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->updateScannedDate()V

    .line 271
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getRecentlyScannedObjects()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v1, v2, v0}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 272
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getViewItDBHelper()Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->update(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    .line 273
    move-object p1, v0

    .line 281
    .end local v0    # "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    :goto_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->hideProgressBar()V

    .line 285
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsAnimationEnd:Z

    if-eqz v1, :cond_2

    .line 286
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->updateSlidingDrawerAndDismissAnimationWindow(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 294
    :goto_1
    monitor-exit p0

    return-void

    .line 275
    .restart local v0    # "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    :cond_0
    :try_start_1
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->addNewSannedObejct(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 252
    .end local v0    # "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 278
    :cond_1
    :try_start_2
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->addNewSannedObejct(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    goto :goto_0

    .line 288
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemContent:Landroid/view/ViewGroup;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 289
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mItemRow:Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->updateAnimationItem(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    goto :goto_1

    .line 292
    :cond_3
    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_no_matched_item_found:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NO_MATCHED_ITEM:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-virtual {p0, v1, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->showServiceCallErrorInLoadingWindow(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method
