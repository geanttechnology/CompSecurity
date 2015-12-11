.class public Lcom/creditcardreader/helpers/CreditCardOverlayHelper;
.super Ljava/lang/Object;
.source "CreditCardOverlayHelper.java"


# instance fields
.field private mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

.field private mBottomBound:I

.field private mLeftBound:I

.field private mPadding:F

.field private mResources:Landroid/content/res/Resources;

.field private mRightBound:I

.field private mScanBox:Landroid/graphics/RectF;

.field private mTopBound:I


# direct methods
.method public constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Lcom/creditcardreader/camera/CreditCardCameraPreview;)V
    .locals 2
    .param p1, "activity"    # Lcom/creditcardreader/activities/CreditCardScanActivity;
    .param p2, "preview"    # Lcom/creditcardreader/camera/CreditCardCameraPreview;

    .prologue
    const/high16 v1, 0x41a00000    # 20.0f

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p1, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    .line 59
    invoke-virtual {p1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mResources:Landroid/content/res/Resources;

    .line 62
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-virtual {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getScreenOrientation()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 67
    invoke-virtual {p2}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->getScreenHeight()F

    move-result v0

    div-float/2addr v0, v1

    iput v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mPadding:F

    .line 69
    :goto_0
    return-void

    .line 64
    :pswitch_0
    invoke-virtual {p2}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->getScreenWidth()F

    move-result v0

    div-float/2addr v0, v1

    iput v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mPadding:F

    goto :goto_0

    .line 62
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method private positionBorderLayout(Landroid/widget/RelativeLayout;)V
    .locals 2
    .param p1, "borderLayout"    # Landroid/widget/RelativeLayout;

    .prologue
    .line 148
    invoke-virtual {p1}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 150
    .local v0, "borderParams":Landroid/widget/RelativeLayout$LayoutParams;
    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->height()F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    iput v1, v0, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 151
    iget v1, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mTopBound:I

    iput v1, v0, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 152
    const/4 v1, 0x0

    iput v1, v0, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 153
    invoke-virtual {p1, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 154
    return-void
.end method

.method private positionScanLayout(Landroid/widget/RelativeLayout;)V
    .locals 4
    .param p1, "progressLayout"    # Landroid/widget/RelativeLayout;

    .prologue
    .line 131
    invoke-virtual {p1}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 133
    .local v0, "progressParams":Landroid/widget/RelativeLayout$LayoutParams;
    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->width()F

    move-result v1

    const/high16 v2, 0x40000000    # 2.0f

    iget v3, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mPadding:F

    mul-float/2addr v2, v3

    add-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    iput v1, v0, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    .line 134
    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->height()F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    iput v1, v0, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 135
    iget v1, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mTopBound:I

    iput v1, v0, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 136
    iget v1, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mLeftBound:I

    int-to-float v1, v1

    iget v2, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mPadding:F

    sub-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    iput v1, v0, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 137
    invoke-virtual {p1, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 138
    return-void
.end method

.method private setBorderView(Landroid/widget/ImageView;)V
    .locals 9
    .param p1, "borderView"    # Landroid/widget/ImageView;

    .prologue
    .line 241
    iget-object v4, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mResources:Landroid/content/res/Resources;

    sget v5, Lcom/creditcardreader/R$dimen;->cc_scan_outer_radius:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v3

    .line 242
    .local v3, "radius":F
    float-to-int v4, v3

    invoke-static {v4}, Lcom/creditcardreader/utils/CreditCardUtils;->convertDpToPx(I)F

    move-result v3

    .line 245
    invoke-virtual {p1}, Landroid/widget/ImageView;->getWidth()I

    move-result v4

    iget-object v5, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v5}, Landroid/graphics/RectF;->height()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v5

    sget-object v6, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v4, v5, v6}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 247
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 248
    .local v1, "canvas":Landroid/graphics/Canvas;
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 249
    .local v2, "paint":Landroid/graphics/Paint;
    iget-object v4, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mResources:Landroid/content/res/Resources;

    sget v5, Lcom/creditcardreader/R$color;->cc_scan_background:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v1, v4}, Landroid/graphics/Canvas;->drawColor(I)V

    .line 252
    const/4 v4, 0x1

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 253
    new-instance v4, Landroid/graphics/PorterDuffXfermode;

    sget-object v5, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v4, v5}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 254
    new-instance v4, Landroid/graphics/RectF;

    iget v5, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mLeftBound:I

    int-to-float v5, v5

    const/4 v6, 0x0

    iget v7, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mRightBound:I

    int-to-float v7, v7

    iget-object v8, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v8}, Landroid/graphics/RectF;->height()F

    move-result v8

    invoke-static {v8}, Ljava/lang/Math;->round(F)I

    move-result v8

    int-to-float v8, v8

    invoke-direct {v4, v5, v6, v7, v8}, Landroid/graphics/RectF;-><init>(FFFF)V

    invoke-virtual {v1, v4, v3, v3, v2}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 256
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 257
    const/4 v4, 0x0

    invoke-virtual {p1, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 258
    return-void
.end method

.method private setGhostView(Landroid/widget/ImageView;)V
    .locals 5
    .param p1, "ghostView"    # Landroid/widget/ImageView;

    .prologue
    .line 191
    iget-object v2, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mResources:Landroid/content/res/Resources;

    sget v3, Lcom/creditcardreader/R$drawable;->cc_scan_ghost:I

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 193
    .local v1, "ghostedCard":Landroid/graphics/Bitmap;
    iget-object v2, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v2}, Landroid/graphics/RectF;->width()F

    move-result v2

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    iget-object v3, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v3

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    const/4 v4, 0x1

    invoke-static {v1, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 197
    invoke-virtual {p1}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 199
    .local v0, "ghostParams":Landroid/widget/RelativeLayout$LayoutParams;
    iget v2, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mTopBound:I

    iput v2, v0, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 200
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 201
    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 202
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 203
    return-void
.end method

.method private setLayouts()V
    .locals 2

    .prologue
    .line 104
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_progress_layout:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->positionScanLayout(Landroid/widget/RelativeLayout;)V

    .line 106
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_border_layout:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->positionBorderLayout(Landroid/widget/RelativeLayout;)V

    .line 108
    return-void
.end method

.method private setProgressView(Landroid/widget/ImageView;)V
    .locals 6
    .param p1, "progressView"    # Landroid/widget/ImageView;

    .prologue
    const/4 v5, 0x0

    .line 214
    iget-object v2, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mResources:Landroid/content/res/Resources;

    sget v3, Lcom/creditcardreader/R$drawable;->cc_scanning:I

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 216
    .local v0, "progressLine":Landroid/graphics/Bitmap;
    iget-object v2, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v2}, Landroid/graphics/RectF;->width()F

    move-result v2

    iget v3, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mPadding:F

    add-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    iget-object v3, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v3

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    const/4 v4, 0x1

    invoke-static {v0, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 220
    invoke-virtual {p1}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout$LayoutParams;

    .line 222
    .local v1, "progressParams":Landroid/widget/RelativeLayout$LayoutParams;
    iput v5, v1, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 223
    iput v5, v1, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 225
    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 226
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 227
    const/4 v2, 0x4

    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 228
    return-void
.end method

.method private setSecureLockViews(Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;)V
    .locals 16
    .param p1, "lockView"    # Landroid/widget/ImageView;
    .param p2, "secureView"    # Landroid/widget/TextView;
    .param p3, "saveView"    # Landroid/widget/TextView;

    .prologue
    .line 274
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mResources:Landroid/content/res/Resources;

    sget v14, Lcom/creditcardreader/R$dimen;->cc_lock_padding:I

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    .line 275
    .local v2, "lockPadding":F
    float-to-int v13, v2

    invoke-static {v13}, Lcom/creditcardreader/utils/CreditCardUtils;->convertDpToPx(I)F

    move-result v2

    .line 278
    invoke-virtual/range {p1 .. p1}, Landroid/widget/ImageView;->getWidth()I

    move-result v13

    int-to-float v13, v13

    add-float/2addr v13, v2

    invoke-virtual/range {p3 .. p3}, Landroid/widget/TextView;->getWidth()I

    move-result v14

    int-to-float v14, v14

    add-float v12, v13, v14

    .line 281
    .local v12, "totalLength":F
    move-object/from16 v0, p0

    iget v13, v0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mBottomBound:I

    int-to-float v13, v13

    move-object/from16 v0, p0

    iget v14, v0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mTopBound:I

    int-to-float v14, v14

    const/high16 v15, 0x40000000    # 2.0f

    div-float/2addr v14, v15

    add-float v1, v13, v14

    .line 284
    .local v1, "centerBottom":F
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    invoke-virtual {v13}, Landroid/graphics/RectF;->centerX()F

    move-result v13

    const/high16 v14, 0x40000000    # 2.0f

    div-float v14, v12, v14

    sub-float v4, v13, v14

    .line 285
    .local v4, "lockX":F
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mResources:Landroid/content/res/Resources;

    sget v14, Lcom/creditcardreader/R$dimen;->cc_lock_padding_left_min:I

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v6

    .line 289
    .local v6, "minLockPaddingLeft":F
    cmpl-float v13, v4, v6

    if-lez v13, :cond_0

    .line 292
    :goto_0
    invoke-virtual/range {p1 .. p1}, Landroid/widget/ImageView;->getHeight()I

    move-result v13

    int-to-float v13, v13

    const/high16 v14, 0x40000000    # 2.0f

    div-float/2addr v13, v14

    sub-float v5, v1, v13

    .line 293
    .local v5, "lockY":F
    invoke-virtual/range {p1 .. p1}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout$LayoutParams;

    .line 295
    .local v3, "lockParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v13

    iput v13, v3, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 296
    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v13

    iput v13, v3, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 299
    invoke-virtual/range {p1 .. p1}, Landroid/widget/ImageView;->getWidth()I

    move-result v13

    int-to-float v13, v13

    add-float/2addr v13, v4

    add-float v10, v13, v2

    .line 300
    .local v10, "secureX":F
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getHeight()I

    move-result v13

    int-to-float v13, v13

    sub-float v11, v1, v13

    .line 301
    .local v11, "secureY":F
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/widget/RelativeLayout$LayoutParams;

    .line 303
    .local v9, "secureParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v13

    iput v13, v9, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 304
    invoke-static {v11}, Ljava/lang/Math;->round(F)I

    move-result v13

    iput v13, v9, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 307
    move v8, v1

    .line 308
    .local v8, "saveY":F
    invoke-virtual/range {p3 .. p3}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v7

    check-cast v7, Landroid/widget/RelativeLayout$LayoutParams;

    .line 310
    .local v7, "saveParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v13

    iput v13, v7, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 311
    invoke-static {v8}, Ljava/lang/Math;->round(F)I

    move-result v13

    iput v13, v7, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 313
    const/4 v13, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 314
    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/widget/TextView;->setVisibility(I)V

    .line 315
    const/4 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/widget/TextView;->setVisibility(I)V

    .line 316
    return-void

    .end local v3    # "lockParams":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v5    # "lockY":F
    .end local v7    # "saveParams":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v8    # "saveY":F
    .end local v9    # "secureParams":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v10    # "secureX":F
    .end local v11    # "secureY":F
    :cond_0
    move v4, v6

    .line 289
    goto :goto_0
.end method

.method private setStatusView(Landroid/widget/TextView;)V
    .locals 6
    .param p1, "statusView"    # Landroid/widget/TextView;

    .prologue
    .line 166
    iget-object v4, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mResources:Landroid/content/res/Resources;

    sget v5, Lcom/creditcardreader/R$dimen;->cc_status_padding:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    .line 167
    .local v0, "statusPadding":F
    float-to-int v4, v0

    invoke-static {v4}, Lcom/creditcardreader/utils/CreditCardUtils;->convertDpToPx(I)F

    move-result v0

    .line 170
    iget v4, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mTopBound:I

    int-to-float v4, v4

    sub-float v2, v4, v0

    .line 171
    .local v2, "upperTextY":F
    iget v4, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mTopBound:I

    div-int/lit8 v4, v4, 0x2

    invoke-virtual {p1}, Landroid/widget/TextView;->getHeight()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    sub-int/2addr v4, v5

    int-to-float v3, v4

    .line 173
    .local v3, "upperTextYCenter":F
    invoke-static {v2, v3}, Ljava/lang/Math;->max(FF)F

    move-result v2

    .line 175
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout$LayoutParams;

    .line 177
    .local v1, "statusParams":Landroid/widget/RelativeLayout$LayoutParams;
    float-to-int v4, v2

    iput v4, v1, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 178
    invoke-virtual {p1, v1}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 179
    const/4 v4, 0x0

    invoke-virtual {p1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 180
    return-void
.end method

.method private setViews()V
    .locals 4

    .prologue
    .line 114
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_status_text:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->setStatusView(Landroid/widget/TextView;)V

    .line 115
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_ghost:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->setGhostView(Landroid/widget/ImageView;)V

    .line 116
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_progress:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->setProgressView(Landroid/widget/ImageView;)V

    .line 117
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_border:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-direct {p0, v0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->setBorderView(Landroid/widget/ImageView;)V

    .line 118
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v1, Lcom/creditcardreader/R$id;->cc_scan_lock:I

    invoke-virtual {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v2, Lcom/creditcardreader/R$id;->cc_scan_secure_text:I

    invoke-virtual {v1, v2}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iget-object v2, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mActivity:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v3, Lcom/creditcardreader/R$id;->cc_scan_save_text:I

    invoke-virtual {v2, v3}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    invoke-direct {p0, v0, v1, v2}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->setSecureLockViews(Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;)V

    .line 121
    return-void
.end method


# virtual methods
.method public drawOverlay()V
    .locals 0

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->setLayouts()V

    .line 76
    invoke-direct {p0}, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->setViews()V

    .line 77
    return-void
.end method

.method public setBounds(FFFF)V
    .locals 5
    .param p1, "leftBound"    # F
    .param p2, "rightBound"    # F
    .param p3, "topBound"    # F
    .param p4, "bottomBound"    # F

    .prologue
    .line 93
    invoke-static {p1}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mLeftBound:I

    .line 94
    invoke-static {p3}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mTopBound:I

    .line 95
    invoke-static {p2}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mRightBound:I

    .line 96
    invoke-static {p4}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mBottomBound:I

    .line 97
    new-instance v0, Landroid/graphics/RectF;

    iget v1, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mLeftBound:I

    int-to-float v1, v1

    iget v2, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mTopBound:I

    int-to-float v2, v2

    iget v3, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mRightBound:I

    int-to-float v3, v3

    iget v4, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mBottomBound:I

    int-to-float v4, v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lcom/creditcardreader/helpers/CreditCardOverlayHelper;->mScanBox:Landroid/graphics/RectF;

    .line 98
    return-void
.end method
