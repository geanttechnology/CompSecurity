.class public Lcom/amazon/mShop/anim/FlipAnimation;
.super Landroid/view/animation/Animation;
.source "FlipAnimation.java"


# static fields
.field public static MAX_ROTATION_DEGREES:F

.field public static X_AXIS:I

.field public static Y_AXIS:I


# instance fields
.field private mCamera:Landroid/graphics/Camera;

.field private mCenterX:I

.field private mCenterY:I

.field private mIsReversed:Z

.field private mRotationAxis:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/high16 v0, 0x43340000    # 180.0f

    sput v0, Lcom/amazon/mShop/anim/FlipAnimation;->MAX_ROTATION_DEGREES:F

    .line 23
    const/4 v0, 0x1

    sput v0, Lcom/amazon/mShop/anim/FlipAnimation;->X_AXIS:I

    .line 24
    const/4 v0, 0x2

    sput v0, Lcom/amazon/mShop/anim/FlipAnimation;->Y_AXIS:I

    return-void
.end method

.method public constructor <init>(Landroid/view/View;IZJ)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "rotationAxis"    # I
    .param p3, "reversed"    # Z
    .param p4, "durationMillis"    # J

    .prologue
    .line 55
    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    .line 56
    iput-boolean p3, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mIsReversed:Z

    .line 57
    new-instance v0, Landroid/graphics/Camera;

    invoke-direct {v0}, Landroid/graphics/Camera;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCamera:Landroid/graphics/Camera;

    .line 58
    iput p2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mRotationAxis:I

    .line 61
    invoke-virtual {p1}, Landroid/view/View;->getLeft()I

    move-result v0

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCenterX:I

    .line 62
    invoke-virtual {p1}, Landroid/view/View;->getBottom()I

    move-result v0

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCenterY:I

    .line 64
    invoke-virtual {p0, p4, p5}, Lcom/amazon/mShop/anim/FlipAnimation;->setDuration(J)V

    .line 65
    return-void
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 4
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .prologue
    .line 69
    invoke-super {p0, p1, p2}, Landroid/view/animation/Animation;->applyTransformation(FLandroid/view/animation/Transformation;)V

    .line 71
    invoke-virtual {p2}, Landroid/view/animation/Transformation;->getMatrix()Landroid/graphics/Matrix;

    move-result-object v1

    .line 73
    .local v1, "matrix":Landroid/graphics/Matrix;
    const/high16 v2, 0x3f800000    # 1.0f

    cmpg-float v2, p1, v2

    if-gtz v2, :cond_3

    .line 74
    sget v2, Lcom/amazon/mShop/anim/FlipAnimation;->MAX_ROTATION_DEGREES:F

    mul-float v0, p1, v2

    .line 76
    .local v0, "degreesToRotate":F
    iget-object v2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCamera:Landroid/graphics/Camera;

    invoke-virtual {v2}, Landroid/graphics/Camera;->save()V

    .line 79
    iget v2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mRotationAxis:I

    sget v3, Lcom/amazon/mShop/anim/FlipAnimation;->X_AXIS:I

    and-int/2addr v2, v3

    sget v3, Lcom/amazon/mShop/anim/FlipAnimation;->X_AXIS:I

    if-ne v2, v3, :cond_0

    .line 80
    iget-object v3, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCamera:Landroid/graphics/Camera;

    iget-boolean v2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mIsReversed:Z

    if-eqz v2, :cond_4

    sget v2, Lcom/amazon/mShop/anim/FlipAnimation;->MAX_ROTATION_DEGREES:F

    sub-float/2addr v2, v0

    :goto_0
    invoke-virtual {v3, v2}, Landroid/graphics/Camera;->rotateX(F)V

    .line 84
    :cond_0
    iget v2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mRotationAxis:I

    sget v3, Lcom/amazon/mShop/anim/FlipAnimation;->Y_AXIS:I

    and-int/2addr v2, v3

    sget v3, Lcom/amazon/mShop/anim/FlipAnimation;->Y_AXIS:I

    if-ne v2, v3, :cond_2

    .line 85
    iget-object v2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCamera:Landroid/graphics/Camera;

    iget-boolean v3, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mIsReversed:Z

    if-eqz v3, :cond_1

    sget v3, Lcom/amazon/mShop/anim/FlipAnimation;->MAX_ROTATION_DEGREES:F

    sub-float v0, v3, v0

    .end local v0    # "degreesToRotate":F
    :cond_1
    invoke-virtual {v2, v0}, Landroid/graphics/Camera;->rotateY(F)V

    .line 88
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCamera:Landroid/graphics/Camera;

    invoke-virtual {v2, v1}, Landroid/graphics/Camera;->getMatrix(Landroid/graphics/Matrix;)V

    .line 89
    iget-object v2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCamera:Landroid/graphics/Camera;

    invoke-virtual {v2}, Landroid/graphics/Camera;->restore()V

    .line 92
    iget v2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCenterX:I

    neg-int v2, v2

    int-to-float v2, v2

    iget v3, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCenterY:I

    neg-int v3, v3

    int-to-float v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Matrix;->preTranslate(FF)Z

    .line 94
    iget v2, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCenterX:I

    int-to-float v2, v2

    iget v3, p0, Lcom/amazon/mShop/anim/FlipAnimation;->mCenterY:I

    int-to-float v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 96
    :cond_3
    return-void

    .restart local v0    # "degreesToRotate":F
    :cond_4
    move v2, v0

    .line 80
    goto :goto_0
.end method
