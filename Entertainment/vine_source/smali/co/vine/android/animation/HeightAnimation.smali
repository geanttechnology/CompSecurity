.class public Lco/vine/android/animation/HeightAnimation;
.super Landroid/view/animation/Animation;
.source "HeightAnimation.java"


# instance fields
.field private final mAnimatedView:Landroid/view/View;

.field private final mFinalHeight:I

.field private final mIsExpansion:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/view/View;ZJ)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "isExpansion"    # Z
    .param p4, "duration"    # J

    .prologue
    const/4 v5, 0x0

    .line 15
    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    .line 16
    new-instance v1, Landroid/util/DisplayMetrics;

    invoke-direct {v1}, Landroid/util/DisplayMetrics;-><init>()V

    .line 17
    .local v1, "metrics":Landroid/util/DisplayMetrics;
    invoke-virtual {p1}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v3

    invoke-interface {v3}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 18
    iput-object p2, p0, Lco/vine/android/animation/HeightAnimation;->mAnimatedView:Landroid/view/View;

    .line 19
    iput-boolean p3, p0, Lco/vine/android/animation/HeightAnimation;->mIsExpansion:Z

    .line 20
    invoke-virtual {p0, p4, p5}, Lco/vine/android/animation/HeightAnimation;->setDuration(J)V

    .line 21
    invoke-static {v5, v5}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 22
    .local v0, "heightMeasureSpec":I
    iget v3, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .line 23
    .local v2, "widthMeasureSpec":I
    iget-object v3, p0, Lco/vine/android/animation/HeightAnimation;->mAnimatedView:Landroid/view/View;

    invoke-virtual {v3, v2, v0}, Landroid/view/View;->measure(II)V

    .line 24
    iget-object v3, p0, Lco/vine/android/animation/HeightAnimation;->mAnimatedView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v3

    iput v3, p0, Lco/vine/android/animation/HeightAnimation;->mFinalHeight:I

    .line 25
    iget-boolean v3, p0, Lco/vine/android/animation/HeightAnimation;->mIsExpansion:Z

    if-eqz v3, :cond_0

    .line 26
    iget-object v3, p0, Lco/vine/android/animation/HeightAnimation;->mAnimatedView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    iput v5, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 27
    iget-object v3, p0, Lco/vine/android/animation/HeightAnimation;->mAnimatedView:Landroid/view/View;

    invoke-virtual {v3, v5}, Landroid/view/View;->setVisibility(I)V

    .line 29
    :cond_0
    return-void
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 3
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .prologue
    .line 33
    invoke-super {p0, p1, p2}, Landroid/view/animation/Animation;->applyTransformation(FLandroid/view/animation/Transformation;)V

    .line 34
    iget-object v1, p0, Lco/vine/android/animation/HeightAnimation;->mAnimatedView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 35
    .local v0, "params":Landroid/view/ViewGroup$LayoutParams;
    if-eqz v0, :cond_0

    .line 36
    const/high16 v1, 0x3f800000    # 1.0f

    cmpg-float v1, p1, v1

    if-gez v1, :cond_2

    .line 37
    iget-boolean v1, p0, Lco/vine/android/animation/HeightAnimation;->mIsExpansion:Z

    if-eqz v1, :cond_1

    .line 38
    iget v1, p0, Lco/vine/android/animation/HeightAnimation;->mFinalHeight:I

    int-to-float v1, v1

    mul-float/2addr v1, p1

    float-to-int v1, v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 42
    :goto_0
    iget-object v1, p0, Lco/vine/android/animation/HeightAnimation;->mAnimatedView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->requestLayout()V

    .line 54
    :cond_0
    :goto_1
    return-void

    .line 40
    :cond_1
    iget v1, p0, Lco/vine/android/animation/HeightAnimation;->mFinalHeight:I

    iget v2, p0, Lco/vine/android/animation/HeightAnimation;->mFinalHeight:I

    int-to-float v2, v2

    mul-float/2addr v2, p1

    float-to-int v2, v2

    sub-int/2addr v1, v2

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_0

    .line 44
    :cond_2
    iget-boolean v1, p0, Lco/vine/android/animation/HeightAnimation;->mIsExpansion:Z

    if-eqz v1, :cond_3

    .line 45
    iget v1, p0, Lco/vine/android/animation/HeightAnimation;->mFinalHeight:I

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 46
    iget-object v1, p0, Lco/vine/android/animation/HeightAnimation;->mAnimatedView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->requestLayout()V

    goto :goto_1

    .line 48
    :cond_3
    const/4 v1, 0x0

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 49
    iget-object v1, p0, Lco/vine/android/animation/HeightAnimation;->mAnimatedView:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 50
    iget v1, p0, Lco/vine/android/animation/HeightAnimation;->mFinalHeight:I

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_1
.end method
