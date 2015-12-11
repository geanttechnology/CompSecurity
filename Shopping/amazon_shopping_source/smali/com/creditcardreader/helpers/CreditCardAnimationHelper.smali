.class public Lcom/creditcardreader/helpers/CreditCardAnimationHelper;
.super Ljava/lang/Object;
.source "CreditCardAnimationHelper.java"


# instance fields
.field private mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

.field private mCenterToScanning:Landroid/view/animation/Animation$AnimationListener;

.field private mFadeInGhost:Landroid/view/animation/Animation;

.field private mFadeInText:Landroid/view/animation/Animation;

.field private mFadeOutGhost:Landroid/view/animation/Animation;

.field private mFadeOutScan:Landroid/view/animation/Animation;

.field private mFadeOutText:Landroid/view/animation/Animation;

.field private mGhostView:Landroid/widget/ImageView;

.field private mInnerLayout:Landroid/widget/RelativeLayout;

.field private mInvisToVisible:Landroid/view/animation/Animation$AnimationListener;

.field private mOuterLayout:Landroid/widget/RelativeLayout;

.field private mPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;

.field private mProgressView:Landroid/widget/ImageView;

.field private mResources:Landroid/content/res/Resources;

.field private mScanningToCenter:Landroid/view/animation/Animation$AnimationListener;

.field private mScanningToScanned:Landroid/view/animation/Animation$AnimationListener;

.field private mSlideScan:Landroid/view/animation/Animation;

.field private mSlideToFade:Landroid/view/animation/Animation$AnimationListener;

.field private mStatusView:Landroid/widget/TextView;

.field private mVisibleToInvis:Landroid/view/animation/Animation$AnimationListener;


# direct methods
.method public constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Lcom/creditcardreader/camera/CreditCardCameraPreview;)V
    .locals 1
    .param p1, "activity"    # Lcom/creditcardreader/activities/CreditCardScanActivity;
    .param p2, "preview"    # Lcom/creditcardreader/camera/CreditCardCameraPreview;

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    iput-object p1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    .line 76
    iput-object p2, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;

    .line 77
    invoke-virtual {p1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mResources:Landroid/content/res/Resources;

    .line 78
    sget v0, Lcom/creditcardreader/R$id;->cc_scan_outer_layout:I

    invoke-virtual {p1, v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mOuterLayout:Landroid/widget/RelativeLayout;

    .line 80
    sget v0, Lcom/creditcardreader/R$id;->cc_scan_inner_layout:I

    invoke-virtual {p1, v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mInnerLayout:Landroid/widget/RelativeLayout;

    .line 82
    return-void
.end method

.method static synthetic access$000(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mStatusView:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$100(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/view/animation/Animation;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeInText:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$200(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mGhostView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/view/animation/Animation;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutScan:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$400(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Lcom/creditcardreader/camera/CreditCardCameraPreview;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;

    return-object v0
.end method

.method static synthetic access$500(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/view/animation/Animation;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mSlideScan:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$600(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;

    return-object v0
.end method

.method private createGhostListener(Z)Landroid/view/animation/Animation$AnimationListener;
    .locals 1
    .param p1, "visible"    # Z

    .prologue
    .line 245
    new-instance v0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$2;

    invoke-direct {v0, p0, p1}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$2;-><init>(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;Z)V

    .line 260
    .local v0, "listener":Landroid/view/animation/Animation$AnimationListener;
    return-object v0
.end method

.method private createSlideListener()Landroid/view/animation/Animation$AnimationListener;
    .locals 1

    .prologue
    .line 270
    new-instance v0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;

    invoke-direct {v0, p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;-><init>(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)V

    .line 300
    .local v0, "listener":Landroid/view/animation/Animation$AnimationListener;
    return-object v0
.end method

.method private createSlideScan()Landroid/view/animation/Animation;
    .locals 7

    .prologue
    .line 201
    const/4 v4, 0x0

    .line 202
    .local v4, "startY":F
    const/4 v1, 0x0

    .line 203
    .local v1, "endY":F
    iget-object v5, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;

    invoke-virtual {v5}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v5}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v5

    mul-int/lit8 v5, v5, -0x1

    int-to-float v3, v5

    .line 204
    .local v3, "startX":F
    iget-object v5, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;

    invoke-virtual {v5}, Landroid/widget/ImageView;->getLeft()I

    move-result v5

    int-to-float v0, v5

    .line 205
    .local v0, "endX":F
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    invoke-direct {v2, v3, v0, v4, v1}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .line 207
    .local v2, "slideScan":Landroid/view/animation/TranslateAnimation;
    const-wide/16 v5, 0x384

    invoke-virtual {v2, v5, v6}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 208
    return-object v2
.end method

.method private createStatusListener(Ljava/lang/String;)Landroid/view/animation/Animation$AnimationListener;
    .locals 1
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 220
    new-instance v0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$1;

    invoke-direct {v0, p0, p1}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$1;-><init>(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;Ljava/lang/String;)V

    .line 233
    .local v0, "listener":Landroid/view/animation/Animation$AnimationListener;
    return-object v0
.end method

.method private setAnimationListeners()V
    .locals 2

    .prologue
    .line 180
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mResources:Landroid/content/res/Resources;

    sget v1, Lcom/creditcardreader/R$string;->cc_scan_scanning:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createStatusListener(Ljava/lang/String;)Landroid/view/animation/Animation$AnimationListener;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mCenterToScanning:Landroid/view/animation/Animation$AnimationListener;

    .line 182
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mResources:Landroid/content/res/Resources;

    sget v1, Lcom/creditcardreader/R$string;->cc_scan_center_card:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createStatusListener(Ljava/lang/String;)Landroid/view/animation/Animation$AnimationListener;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mScanningToCenter:Landroid/view/animation/Animation$AnimationListener;

    .line 184
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mResources:Landroid/content/res/Resources;

    sget v1, Lcom/creditcardreader/R$string;->cc_scan_success:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createStatusListener(Ljava/lang/String;)Landroid/view/animation/Animation$AnimationListener;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mScanningToScanned:Landroid/view/animation/Animation$AnimationListener;

    .line 186
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createGhostListener(Z)Landroid/view/animation/Animation$AnimationListener;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mVisibleToInvis:Landroid/view/animation/Animation$AnimationListener;

    .line 187
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createGhostListener(Z)Landroid/view/animation/Animation$AnimationListener;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mInvisToVisible:Landroid/view/animation/Animation$AnimationListener;

    .line 188
    invoke-direct {p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createSlideListener()Landroid/view/animation/Animation$AnimationListener;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mSlideToFade:Landroid/view/animation/Animation$AnimationListener;

    .line 190
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutGhost:Landroid/view/animation/Animation;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mVisibleToInvis:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 191
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeInGhost:Landroid/view/animation/Animation;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mInvisToVisible:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 192
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mSlideScan:Landroid/view/animation/Animation;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mSlideToFade:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 193
    return-void
.end method

.method private setAnimations()V
    .locals 2

    .prologue
    .line 162
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$anim;->cc_scan_fade_out:I

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutText:Landroid/view/animation/Animation;

    .line 164
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$anim;->cc_scan_fade_in:I

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeInText:Landroid/view/animation/Animation;

    .line 166
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$anim;->cc_scan_fade_out:I

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutGhost:Landroid/view/animation/Animation;

    .line 168
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$anim;->cc_scan_fade_in:I

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeInGhost:Landroid/view/animation/Animation;

    .line 170
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$anim;->cc_scan_fade_out_scan:I

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutScan:Landroid/view/animation/Animation;

    .line 172
    invoke-direct {p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createSlideScan()Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mSlideScan:Landroid/view/animation/Animation;

    .line 173
    return-void
.end method

.method private stopScanAnimation()V
    .locals 2

    .prologue
    .line 307
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->clearAnimation()V

    .line 308
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 309
    return-void
.end method


# virtual methods
.method public blacken()V
    .locals 3

    .prologue
    .line 148
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mOuterLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mResources:Landroid/content/res/Resources;

    sget v2, Lcom/creditcardreader/R$color;->cc_scan_background:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    .line 150
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mInnerLayout:Landroid/widget/RelativeLayout;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 151
    return-void
.end method

.method public centerToScanning()V
    .locals 2

    .prologue
    .line 106
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mGhostView:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutGhost:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 107
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutText:Landroid/view/animation/Animation;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mCenterToScanning:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 108
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mStatusView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutText:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 109
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mSlideScan:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 110
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 111
    return-void
.end method

.method public createAnimations()V
    .locals 0

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->setAnimations()V

    .line 98
    invoke-direct {p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->setAnimationListeners()V

    .line 99
    return-void
.end method

.method public lighten()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 154
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mInnerLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 155
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mOuterLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    .line 156
    return-void
.end method

.method public resetOverlay()V
    .locals 3

    .prologue
    .line 139
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mStatusView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mResources:Landroid/content/res/Resources;

    sget v2, Lcom/creditcardreader/R$string;->cc_scan_center_card:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 140
    invoke-direct {p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->stopScanAnimation()V

    .line 141
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mGhostView:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 142
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeInGhost:Landroid/view/animation/Animation;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mInvisToVisible:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 143
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mGhostView:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeInGhost:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 145
    :cond_0
    return-void
.end method

.method public scanningToCenter()V
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeInGhost:Landroid/view/animation/Animation;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mInvisToVisible:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 119
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mGhostView:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeInGhost:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 120
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutText:Landroid/view/animation/Animation;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mScanningToCenter:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 121
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mStatusView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutText:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 122
    invoke-direct {p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->stopScanAnimation()V

    .line 123
    return-void
.end method

.method public scanningToScanned()V
    .locals 2

    .prologue
    .line 130
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutText:Landroid/view/animation/Animation;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mScanningToScanned:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 131
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mStatusView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutText:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 132
    invoke-direct {p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->stopScanAnimation()V

    .line 133
    return-void
.end method

.method public setViews()V
    .locals 2

    .prologue
    .line 88
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_status_text:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mStatusView:Landroid/widget/TextView;

    .line 89
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_ghost:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mGhostView:Landroid/widget/ImageView;

    .line 90
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_progress:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;

    .line 91
    return-void
.end method
