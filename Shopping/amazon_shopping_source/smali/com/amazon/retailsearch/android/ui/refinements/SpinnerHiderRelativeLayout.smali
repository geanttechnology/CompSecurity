.class public Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
.super Landroid/widget/RelativeLayout;
.source "SpinnerHiderRelativeLayout.java"


# static fields
.field public static final DEFAULT_APPEAR_DURATION:J = 0xafL

.field public static final DEFAULT_OVERLAY_ALPHA:F = 0.75f

.field public static final DEFAULT_OVERLAY_COLOR:I


# instance fields
.field private mAppearDuration:J

.field private mOverlay:Landroid/view/View;

.field private mOverlayAlpha:F

.field private mOverlayColor:I

.field private mOverlayVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

.field private mSpinner:Landroid/widget/ProgressBar;

.field private mSpinnerVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

.field private useAnimation:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-string/jumbo v0, "#F2F3F4"

    invoke-static {v0}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v0

    sput v0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->DEFAULT_OVERLAY_COLOR:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 36
    sget v0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->DEFAULT_OVERLAY_COLOR:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayColor:I

    .line 37
    const/high16 v0, 0x3f400000    # 0.75f

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayAlpha:F

    .line 38
    const-wide/16 v0, 0xaf

    iput-wide v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mAppearDuration:J

    .line 40
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->useAnimation:Z

    .line 58
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->init(Landroid/content/Context;)V

    .line 59
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 36
    sget v0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->DEFAULT_OVERLAY_COLOR:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayColor:I

    .line 37
    const/high16 v0, 0x3f400000    # 0.75f

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayAlpha:F

    .line 38
    const-wide/16 v0, 0xaf

    iput-wide v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mAppearDuration:J

    .line 40
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->useAnimation:Z

    .line 52
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->init(Landroid/content/Context;)V

    .line 53
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 45
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 36
    sget v0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->DEFAULT_OVERLAY_COLOR:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayColor:I

    .line 37
    const/high16 v0, 0x3f400000    # 0.75f

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayAlpha:F

    .line 38
    const-wide/16 v0, 0xaf

    iput-wide v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mAppearDuration:J

    .line 40
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->useAnimation:Z

    .line 46
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->init(Landroid/content/Context;)V

    .line 47
    return-void
.end method

.method private init(Landroid/content/Context;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, -0x1

    const/4 v2, -0x2

    .line 63
    new-instance v0, Landroid/view/View;

    invoke-direct {v0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    .line 64
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v1, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 66
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayColor:I

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 67
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout$1;-><init>(Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 76
    new-instance v6, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v6, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 78
    .local v6, "spinnerParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v0, 0xd

    invoke-virtual {v6, v0}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 80
    new-instance v0, Landroid/widget/ProgressBar;

    invoke-direct {v0, p1}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinner:Landroid/widget/ProgressBar;

    .line 81
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v6}, Landroid/widget/ProgressBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 83
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    .line 85
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->useAnimation:Z

    .line 88
    :cond_0
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->useAnimation:Z

    if-eqz v0, :cond_1

    .line 90
    new-instance v0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    const/4 v2, 0x0

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayAlpha:F

    iget-wide v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mAppearDuration:J

    invoke-direct/range {v0 .. v5}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;-><init>(Landroid/view/View;FFJ)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    .line 92
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->hide()V

    .line 94
    new-instance v0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinner:Landroid/widget/ProgressBar;

    iget-wide v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mAppearDuration:J

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;-><init>(Landroid/view/View;J)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinnerVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    .line 96
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinnerVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->hide()V

    .line 98
    :cond_1
    return-void
.end method


# virtual methods
.method public getAppearDuration()J
    .locals 2

    .prologue
    .line 169
    iget-wide v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mAppearDuration:J

    return-wide v0
.end method

.method public getOverlayAlpha()F
    .locals 1

    .prologue
    .line 147
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayAlpha:F

    return v0
.end method

.method public getOverlayColor()I
    .locals 1

    .prologue
    .line 128
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayColor:I

    return v0
.end method

.method public hide()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 207
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->useAnimation:Z

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->animateHide()V

    .line 210
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinnerVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->animateHide()V

    .line 216
    :goto_0
    return-void

    .line 213
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 214
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0
.end method

.method protected onMeasure(II)V
    .locals 1
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-nez v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->addView(Landroid/view/View;)V

    .line 117
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->addView(Landroid/view/View;)V

    .line 119
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/RelativeLayout;->onMeasure(II)V

    .line 120
    return-void
.end method

.method public setAppearDuration(J)V
    .locals 1
    .param p1, "duration"    # J

    .prologue
    .line 178
    iput-wide p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mAppearDuration:J

    .line 179
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->useAnimation:Z

    if-eqz v0, :cond_0

    .line 181
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->setDuration(J)V

    .line 182
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinnerVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->setDuration(J)V

    .line 184
    :cond_0
    return-void
.end method

.method public setOverlayAlpha(F)V
    .locals 1
    .param p1, "alpha"    # F

    .prologue
    .line 156
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayAlpha:F

    .line 157
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->useAnimation:Z

    if-eqz v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0, p1}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->setMaxAlpha(F)V

    .line 161
    :cond_0
    return-void
.end method

.method public setOverlayColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 137
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayColor:I

    .line 138
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 139
    return-void
.end method

.method public show()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 191
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->useAnimation:Z

    if-eqz v0, :cond_0

    .line 193
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlayVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->animateShow()V

    .line 194
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinnerVisibility:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->animateShow()V

    .line 200
    :goto_0
    return-void

    .line 197
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mOverlay:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 198
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->mSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0
.end method
