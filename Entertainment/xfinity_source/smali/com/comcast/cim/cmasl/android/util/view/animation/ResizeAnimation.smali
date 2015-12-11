.class public Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;
.super Landroid/view/animation/Animation;
.source "ResizeAnimation.java"


# instance fields
.field private fromHeight:F

.field private fromWidth:F

.field private toHeight:F

.field private toWidth:F

.field private view:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/view/View;FFFF)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;
    .param p2, "fromWidth"    # F
    .param p3, "fromHeight"    # F
    .param p4, "toWidth"    # F
    .param p5, "toHeight"    # F

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    .line 17
    iput p5, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->toHeight:F

    .line 18
    iput p4, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->toWidth:F

    .line 19
    iput p3, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->fromHeight:F

    .line 20
    iput p2, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->fromWidth:F

    .line 21
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->view:Landroid/view/View;

    .line 22
    return-void
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 5
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .prologue
    .line 26
    iget v3, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->toHeight:F

    iget v4, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->fromHeight:F

    sub-float/2addr v3, v4

    mul-float/2addr v3, p1

    iget v4, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->fromHeight:F

    add-float v0, v3, v4

    .line 27
    .local v0, "height":F
    iget v3, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->toWidth:F

    iget v4, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->fromWidth:F

    sub-float/2addr v3, v4

    mul-float/2addr v3, p1

    iget v4, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->fromWidth:F

    add-float v2, v3, v4

    .line 28
    .local v2, "width":F
    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->view:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 29
    .local v1, "p":Landroid/view/ViewGroup$LayoutParams;
    float-to-int v3, v0

    iput v3, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 30
    float-to-int v3, v2

    iput v3, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 31
    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;->view:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->requestLayout()V

    .line 32
    return-void
.end method
