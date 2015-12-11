.class public Lcom/amazon/mShop/anim/ExpandCollapseAnimation;
.super Landroid/view/animation/Animation;
.source "ExpandCollapseAnimation.java"


# instance fields
.field private mAnimType:I

.field private mFullHeight:I

.field private mMinHeight:I

.field private mRect:Landroid/graphics/Rect;

.field private mShowExpandedArea:Z

.field private mView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/view/View;IIZJ)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "type"    # I
    .param p3, "expandedHeight"    # I
    .param p4, "showExpandedArea"    # Z
    .param p5, "durationMillis"    # J

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mView:Landroid/view/View;

    .line 42
    iput p3, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mFullHeight:I

    .line 43
    iput p2, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mAnimType:I

    .line 44
    iput-boolean p4, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mShowExpandedArea:Z

    .line 45
    invoke-virtual {p0, p5, p6}, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->setDuration(J)V

    .line 46
    return-void
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 4
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .prologue
    const/high16 v3, 0x3f800000    # 1.0f

    .line 58
    invoke-super {p0, p1, p2}, Landroid/view/animation/Animation;->applyTransformation(FLandroid/view/animation/Transformation;)V

    .line 60
    iget v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mAnimType:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_3

    .line 63
    cmpg-float v1, p1, v3

    if-gez v1, :cond_2

    .line 64
    iget v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mFullHeight:I

    int-to-float v1, v1

    mul-float/2addr v1, p1

    float-to-int v1, v1

    iget v2, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mMinHeight:I

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 65
    .local v0, "height":I
    iget-object v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 71
    .end local v0    # "height":I
    :goto_0
    iget-boolean v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mShowExpandedArea:Z

    if-eqz v1, :cond_1

    .line 72
    iget-object v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mRect:Landroid/graphics/Rect;

    if-nez v1, :cond_0

    .line 73
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mRect:Landroid/graphics/Rect;

    .line 76
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mView:Landroid/view/View;

    iget-object v2, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mRect:Landroid/graphics/Rect;

    invoke-virtual {v1, v2}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 77
    iget-object v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mView:Landroid/view/View;

    iget-object v2, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mRect:Landroid/graphics/Rect;

    invoke-virtual {v1, v2}, Landroid/view/View;->requestRectangleOnScreen(Landroid/graphics/Rect;)Z

    .line 90
    :cond_1
    :goto_1
    iget-object v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->requestLayout()V

    .line 91
    return-void

    .line 67
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iget v2, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mFullHeight:I

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_0

    .line 82
    :cond_3
    cmpg-float v1, p1, v3

    if-gez v1, :cond_4

    .line 83
    iget v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mFullHeight:I

    iget v2, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mFullHeight:I

    int-to-float v2, v2

    mul-float/2addr v2, p1

    float-to-int v2, v2

    sub-int/2addr v1, v2

    iget v2, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mMinHeight:I

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 84
    .restart local v0    # "height":I
    iget-object v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_1

    .line 86
    .end local v0    # "height":I
    :cond_4
    iget-object v1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iget v2, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mMinHeight:I

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_1
.end method

.method public setMinHeight(I)V
    .locals 0
    .param p1, "minHeight"    # I

    .prologue
    .line 53
    iput p1, p0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->mMinHeight:I

    .line 54
    return-void
.end method
