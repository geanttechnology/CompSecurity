.class public Lcom/creditcardreader/camera/CreditCardCameraPreview;
.super Lcom/a9/cameralibrary/A9CameraPreview;
.source "CreditCardCameraPreview.java"


# instance fields
.field private mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

.field private mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

.field private mBottomBound:F

.field private mBounds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/graphics/PointF;",
            ">;"
        }
    .end annotation
.end field

.field private mLeftBound:F

.field private mRadius:F

.field private mResources:Landroid/content/res/Resources;

.field private mRightBound:F

.field private mScanBox:Landroid/graphics/RectF;

.field private mScanning:Z

.field private mSuccess:Z

.field private mTopBound:F


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/a9/cameralibrary/CameraFrameListener;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "aInterface"    # Lcom/a9/cameralibrary/CameraFrameListener;

    .prologue
    const/high16 v2, 0x7f800000    # Float.POSITIVE_INFINITY

    const/high16 v1, -0x800000    # Float.NEGATIVE_INFINITY

    .line 67
    invoke-direct {p0, p1, p2}, Lcom/a9/cameralibrary/A9CameraPreview;-><init>(Landroid/content/Context;Lcom/a9/cameralibrary/CameraFrameListener;)V

    .line 68
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->setWillNotDraw(Z)V

    .line 71
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mBounds:Ljava/util/ArrayList;

    .line 72
    check-cast p1, Lcom/creditcardreader/activities/CreditCardScanActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    .line 73
    iget-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-virtual {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mResources:Landroid/content/res/Resources;

    .line 76
    iput v2, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mLeftBound:F

    .line 77
    iput v1, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mRightBound:F

    .line 78
    iput v2, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mTopBound:F

    .line 79
    iput v1, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mBottomBound:F

    .line 80
    return-void
.end method

.method private createAnimations()V
    .locals 2

    .prologue
    .line 215
    new-instance v0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    iget-object v1, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-direct {v0, v1, p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Lcom/creditcardreader/camera/CreditCardCameraPreview;)V

    iput-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    .line 216
    iget-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    invoke-virtual {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->setViews()V

    .line 217
    iget-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    invoke-virtual {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createAnimations()V

    .line 218
    iget-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    invoke-virtual {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->lighten()V

    .line 219
    return-void
.end method

.method private createOverlay()V
    .locals 5

    .prologue
    .line 205
    new-instance v0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;

    iget-object v1, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-direct {v0, v1, p0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Lcom/creditcardreader/camera/CreditCardCameraPreview;)V

    .line 207
    .local v0, "overlayHelper":Lcom/creditcardreader/helpers/CreditCardOverlayHelper;
    iget v1, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mLeftBound:F

    iget v2, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mRightBound:F

    iget v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mTopBound:F

    iget v4, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mBottomBound:F

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->setBounds(FFFF)V

    .line 208
    invoke-virtual {v0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->drawOverlay()V

    .line 209
    return-void
.end method

.method private drawOverlay(Landroid/graphics/Canvas;)V
    .locals 18
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 230
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mResources:Landroid/content/res/Resources;

    sget v14, Lcom/creditcardreader/R$color;->cc_scan_background:I

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getColor(I)I

    move-result v13

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/graphics/Canvas;->drawColor(I)V

    .line 233
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 234
    .local v2, "paint":Landroid/graphics/Paint;
    const/4 v13, 0x1

    invoke-virtual {v2, v13}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 235
    new-instance v13, Landroid/graphics/PorterDuffXfermode;

    sget-object v14, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v13, v14}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v2, v13}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 238
    move-object/from16 v0, p0

    iget v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mLeftBound:F

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v6

    .line 239
    .local v6, "xLeftScanRect":I
    move-object/from16 v0, p0

    iget v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mTopBound:F

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v12

    .line 240
    .local v12, "yTopScanRect":I
    move-object/from16 v0, p0

    iget v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mRightBound:F

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v8

    .line 241
    .local v8, "xRightScanRect":I
    move-object/from16 v0, p0

    iget v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mBottomBound:F

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v10

    .line 242
    .local v10, "yBottomScanRect":I
    new-instance v13, Landroid/graphics/RectF;

    int-to-float v14, v6

    int-to-float v15, v12

    int-to-float v0, v8

    move/from16 v16, v0

    int-to-float v0, v10

    move/from16 v17, v0

    invoke-direct/range {v13 .. v17}, Landroid/graphics/RectF;-><init>(FFFF)V

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanBox:Landroid/graphics/RectF;

    .line 244
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanBox:Landroid/graphics/RectF;

    move-object/from16 v0, p1

    invoke-virtual {v0, v13, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 247
    move-object/from16 v0, p0

    iget-boolean v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mSuccess:Z

    if-eqz v13, :cond_0

    .line 249
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mResources:Landroid/content/res/Resources;

    sget v14, Lcom/creditcardreader/R$dimen;->cc_scan_thickness:I

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v4

    .line 252
    .local v4, "strokeWidth":F
    const/4 v13, 0x0

    invoke-virtual {v2, v13}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 253
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mResources:Landroid/content/res/Resources;

    sget v14, Lcom/creditcardreader/R$color;->cc_scan_green:I

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getColor(I)I

    move-result v13

    invoke-virtual {v2, v13}, Landroid/graphics/Paint;->setColor(I)V

    .line 254
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanBox:Landroid/graphics/RectF;

    move-object/from16 v0, p0

    iget v14, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mRadius:F

    move-object/from16 v0, p0

    iget v15, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mRadius:F

    move-object/from16 v0, p1

    invoke-virtual {v0, v13, v14, v15, v2}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 257
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanBox:Landroid/graphics/RectF;

    iget v13, v13, Landroid/graphics/RectF;->left:F

    add-float/2addr v13, v4

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v5

    .line 258
    .local v5, "xLeftFrameRect":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanBox:Landroid/graphics/RectF;

    iget v13, v13, Landroid/graphics/RectF;->top:F

    add-float/2addr v13, v4

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v11

    .line 259
    .local v11, "yTopFrameRect":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanBox:Landroid/graphics/RectF;

    iget v13, v13, Landroid/graphics/RectF;->right:F

    sub-float/2addr v13, v4

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v7

    .line 260
    .local v7, "xRightFrameRect":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanBox:Landroid/graphics/RectF;

    iget v13, v13, Landroid/graphics/RectF;->bottom:F

    sub-float/2addr v13, v4

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v9

    .line 261
    .local v9, "yBottomFrameRect":I
    new-instance v3, Landroid/graphics/RectF;

    int-to-float v13, v5

    int-to-float v14, v11

    int-to-float v15, v7

    int-to-float v0, v9

    move/from16 v16, v0

    move/from16 v0, v16

    invoke-direct {v3, v13, v14, v15, v0}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 265
    .local v3, "scanFrame":Landroid/graphics/RectF;
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mResources:Landroid/content/res/Resources;

    sget v14, Lcom/creditcardreader/R$dimen;->cc_scan_inner_radius:I

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v1

    .line 266
    .local v1, "innerRadius":F
    float-to-int v13, v1

    invoke-static {v13}, Lcom/creditcardreader/utils/CreditCardUtils;->convertDpToPx(I)F

    move-result v1

    .line 267
    new-instance v13, Landroid/graphics/PorterDuffXfermode;

    sget-object v14, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v13, v14}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v2, v13}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 268
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v1, v1, v2}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 270
    .end local v1    # "innerRadius":F
    .end local v3    # "scanFrame":Landroid/graphics/RectF;
    .end local v4    # "strokeWidth":F
    .end local v5    # "xLeftFrameRect":I
    .end local v7    # "xRightFrameRect":I
    .end local v9    # "yBottomFrameRect":I
    .end local v11    # "yTopFrameRect":I
    :cond_0
    return-void
.end method


# virtual methods
.method public blacken()V
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    if-eqz v0, :cond_0

    .line 184
    iget-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    invoke-virtual {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->blacken()V

    .line 186
    :cond_0
    return-void
.end method

.method public isScanning()Z
    .locals 1

    .prologue
    .line 278
    iget-boolean v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanning:Z

    return v0
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 0
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 197
    invoke-super {p0, p1}, Lcom/a9/cameralibrary/A9CameraPreview;->onDraw(Landroid/graphics/Canvas;)V

    .line 198
    invoke-direct {p0, p1}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->drawOverlay(Landroid/graphics/Canvas;)V

    .line 199
    return-void
.end method

.method public resetOverlay()V
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    if-eqz v0, :cond_0

    .line 176
    iget-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    invoke-virtual {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->resetOverlay()V

    .line 178
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanning:Z

    .line 179
    invoke-virtual {p0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->invalidate()V

    .line 180
    return-void
.end method

.method public setBounds(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/graphics/Point;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 90
    .local p1, "bounds":Ljava/util/List;, "Ljava/util/List<Landroid/graphics/Point;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Point;

    .line 91
    .local v0, "bound":Landroid/graphics/Point;
    new-instance v2, Landroid/graphics/PointF;

    iget v3, v0, Landroid/graphics/Point;->x:I

    int-to-float v3, v3

    iget v4, v0, Landroid/graphics/Point;->y:I

    int-to-float v4, v4

    invoke-direct {v2, v3, v4}, Landroid/graphics/PointF;-><init>(FF)V

    .line 92
    .local v2, "pointF":Landroid/graphics/PointF;
    invoke-virtual {p0, v2}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->translatePointInPlace(Landroid/graphics/PointF;)V

    .line 93
    iget-object v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mBounds:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 96
    iget v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mLeftBound:F

    iget v4, v2, Landroid/graphics/PointF;->x:F

    invoke-static {v3, v4}, Ljava/lang/Math;->min(FF)F

    move-result v3

    iput v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mLeftBound:F

    .line 97
    iget v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mRightBound:F

    iget v4, v2, Landroid/graphics/PointF;->x:F

    invoke-static {v3, v4}, Ljava/lang/Math;->max(FF)F

    move-result v3

    iput v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mRightBound:F

    .line 98
    iget v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mTopBound:F

    iget v4, v2, Landroid/graphics/PointF;->y:F

    invoke-static {v3, v4}, Ljava/lang/Math;->min(FF)F

    move-result v3

    iput v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mTopBound:F

    .line 99
    iget v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mBottomBound:F

    iget v4, v2, Landroid/graphics/PointF;->y:F

    invoke-static {v3, v4}, Ljava/lang/Math;->max(FF)F

    move-result v3

    iput v3, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mBottomBound:F

    goto :goto_0

    .line 102
    .end local v0    # "bound":Landroid/graphics/Point;
    .end local v2    # "pointF":Landroid/graphics/PointF;
    :cond_0
    invoke-direct {p0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->createOverlay()V

    .line 103
    invoke-direct {p0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->createAnimations()V

    .line 104
    invoke-virtual {p0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->invalidate()V

    .line 105
    return-void
.end method

.method public setEdges(Ljava/util/List;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/util/Pair",
            "<",
            "Landroid/graphics/Point;",
            "Landroid/graphics/Point;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 116
    .local p1, "edges":Ljava/util/List;, "Ljava/util/List<Landroid/util/Pair<Landroid/graphics/Point;Landroid/graphics/Point;>;>;"
    const/4 v7, 0x0

    .line 117
    .local v7, "topDetected":Z
    const/4 v3, 0x0

    .line 118
    .local v3, "leftDetected":Z
    const/4 v6, 0x0

    .line 119
    .local v6, "rightDetected":Z
    const/4 v0, 0x0

    .line 122
    .local v0, "bottomDetected":Z
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/util/Pair;

    .line 123
    .local v1, "edge":Landroid/util/Pair;, "Landroid/util/Pair<Landroid/graphics/Point;Landroid/graphics/Point;>;"
    new-instance v4, Landroid/graphics/PointF;

    iget-object v8, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v8, Landroid/graphics/Point;

    invoke-direct {v4, v8}, Landroid/graphics/PointF;-><init>(Landroid/graphics/Point;)V

    .line 124
    .local v4, "point1":Landroid/graphics/PointF;
    new-instance v5, Landroid/graphics/PointF;

    iget-object v8, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v8, Landroid/graphics/Point;

    invoke-direct {v5, v8}, Landroid/graphics/PointF;-><init>(Landroid/graphics/Point;)V

    .line 125
    .local v5, "point2":Landroid/graphics/PointF;
    invoke-virtual {p0, v4}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->translatePointInPlace(Landroid/graphics/PointF;)V

    .line 126
    invoke-virtual {p0, v5}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->translatePointInPlace(Landroid/graphics/PointF;)V

    .line 129
    iget v8, v4, Landroid/graphics/PointF;->x:F

    iget v9, v5, Landroid/graphics/PointF;->x:F

    cmpl-float v8, v8, v9

    if-nez v8, :cond_1

    .line 130
    iget v8, v4, Landroid/graphics/PointF;->y:F

    iget v9, v5, Landroid/graphics/PointF;->y:F

    cmpl-float v8, v8, v9

    if-lez v8, :cond_0

    .line 131
    const/4 v3, 0x1

    goto :goto_0

    .line 133
    :cond_0
    const/4 v6, 0x1

    goto :goto_0

    .line 138
    :cond_1
    iget v8, v4, Landroid/graphics/PointF;->x:F

    iget v9, v5, Landroid/graphics/PointF;->x:F

    cmpg-float v8, v8, v9

    if-gez v8, :cond_2

    .line 139
    const/4 v7, 0x1

    goto :goto_0

    .line 141
    :cond_2
    const/4 v0, 0x1

    goto :goto_0

    .line 146
    .end local v1    # "edge":Landroid/util/Pair;, "Landroid/util/Pair<Landroid/graphics/Point;Landroid/graphics/Point;>;"
    .end local v4    # "point1":Landroid/graphics/PointF;
    .end local v5    # "point2":Landroid/graphics/PointF;
    :cond_3
    if-eqz v3, :cond_5

    if-eqz v6, :cond_5

    if-eqz v7, :cond_5

    if-eqz v0, :cond_5

    .line 147
    const/4 v8, 0x1

    iput-boolean v8, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanning:Z

    .line 148
    iget-object v8, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    invoke-virtual {v8}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->centerToScanning()V

    .line 149
    invoke-virtual {p0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->invalidate()V

    .line 158
    :cond_4
    :goto_1
    return-void

    .line 153
    :cond_5
    iget-boolean v8, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanning:Z

    if-eqz v8, :cond_4

    .line 154
    const/4 v8, 0x0

    iput-boolean v8, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanning:Z

    .line 155
    iget-object v8, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    invoke-virtual {v8}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->scanningToCenter()V

    .line 156
    invoke-virtual {p0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->invalidate()V

    goto :goto_1
.end method

.method public showSuccess()V
    .locals 1

    .prologue
    .line 164
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mScanning:Z

    .line 165
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mSuccess:Z

    .line 166
    iget-object v0, p0, Lcom/creditcardreader/camera/CreditCardCameraPreview;->mAnimationHelper:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    invoke-virtual {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->scanningToScanned()V

    .line 167
    invoke-virtual {p0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->invalidate()V

    .line 168
    return-void
.end method

.method public startPreview()V
    .locals 0

    .prologue
    .line 288
    invoke-super {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->startPreview()V

    .line 289
    return-void
.end method

.method public stopPreview()V
    .locals 0

    .prologue
    .line 283
    invoke-super {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->stopPreview()V

    .line 284
    return-void
.end method
