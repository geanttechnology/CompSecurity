.class Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;
.super Landroid/graphics/drawable/Drawable;
.source "PromoSlotView.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/home/PromoSlotView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PromoSlotImage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/graphics/drawable/Drawable;",
        "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

.field private mGenericMarginOnProductPromo:F

.field private mHeader:Ljava/lang/String;

.field private mProductHeaderFontSize:F

.field private mProductTitleFontSize:F

.field private mPromoImageOnly:Z

.field private mPromoSlotHeight:F

.field private mPromoSlotWidth:F

.field private mRes:Landroid/content/res/Resources;

.field private mRightMarginOnThumbnail:F

.field private mThumbnail:Landroid/graphics/Bitmap;

.field private mThumbnailImageUrl:Ljava/lang/String;

.field private mTitle:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/mShop/home/PromoSlotView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/home/PromoSlotView;Landroid/content/res/Resources;Ljava/lang/String;FF)V
    .locals 1
    .param p2, "res"    # Landroid/content/res/Resources;
    .param p3, "imageUrl"    # Ljava/lang/String;
    .param p4, "height"    # F
    .param p5, "width"    # F

    .prologue
    const/4 v0, 0x0

    .line 157
    iput-object p1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 136
    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    .line 137
    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    .line 138
    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    .line 139
    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    .line 158
    iput-object p2, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    .line 159
    iput p4, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotHeight:F

    .line 160
    iput p5, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotWidth:F

    .line 161
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoImageOnly:Z

    .line 162
    invoke-direct {p0, p3}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->setImageUrl(Ljava/lang/String;)V

    .line 163
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/home/PromoSlotView;Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FF)V
    .locals 1
    .param p2, "res"    # Landroid/content/res/Resources;
    .param p3, "imageUrl"    # Ljava/lang/String;
    .param p4, "header"    # Ljava/lang/String;
    .param p5, "title"    # Ljava/lang/String;
    .param p6, "height"    # F
    .param p7, "width"    # F

    .prologue
    const/4 v0, 0x0

    .line 166
    iput-object p1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 136
    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    .line 137
    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    .line 138
    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    .line 139
    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    .line 167
    iput-object p2, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    .line 168
    iput-object p4, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    .line 169
    iput-object p5, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    .line 170
    iput p6, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotHeight:F

    .line 171
    iput p7, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotWidth:F

    .line 172
    invoke-direct {p0, p3}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->setImageUrl(Ljava/lang/String;)V

    .line 173
    return-void
.end method

.method private calculatePixelValues()V
    .locals 2

    .prologue
    .line 214
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$dimen;->generic_margin_on_product_promo:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mGenericMarginOnProductPromo:F

    .line 215
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$dimen;->right_margin_on_thumbnail:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRightMarginOnThumbnail:F

    .line 216
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$dimen;->product_header_font_size:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mProductHeaderFontSize:F

    .line 217
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$dimen;->product_title_font_size:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mProductTitleFontSize:F

    .line 219
    return-void
.end method

.method private cancelImageFetcher()V
    .locals 1

    .prologue
    .line 462
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    .line 463
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->cancel()V

    .line 464
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 466
    :cond_0
    return-void
.end method

.method private setImageUrl(Ljava/lang/String;)V
    .locals 7
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 185
    iput-object p1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnailImageUrl:Ljava/lang/String;

    .line 186
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_2

    .line 187
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 205
    :cond_0
    :goto_0
    return-void

    .line 191
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->cancelImageFetcher()V

    .line 195
    :cond_2
    if-eqz p1, :cond_0

    .line 197
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v0}, Lcom/amazon/mShop/home/PromoSlotView;->access$000(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 198
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v0}, Lcom/amazon/mShop/home/PromoSlotView;->access$000(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 200
    :cond_3
    iget-boolean v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoImageOnly:Z

    if-eqz v0, :cond_4

    iget v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotWidth:F

    float-to-int v6, v0

    .line 201
    .local v6, "imageDimen":I
    :goto_1
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const/4 v4, 0x1

    sget-object v5, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    move-object v1, p1

    move-object v3, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ZLcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 202
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    goto :goto_0

    .line 200
    .end local v6    # "imageDimen":I
    :cond_4
    iget v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotHeight:F

    float-to-double v0, v0

    const-wide/high16 v2, 0x3fec000000000000L    # 0.875

    mul-double/2addr v0, v2

    double-to-int v6, v0

    goto :goto_1
.end method


# virtual methods
.method public cancel()V
    .locals 0

    .prologue
    .line 458
    invoke-direct {p0}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->cancelImageFetcher()V

    .line 459
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 28
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 223
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->calculatePixelValues()V

    .line 225
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    move-object/from16 v24, v0

    if-nez v24, :cond_2

    const/16 v23, 0x0

    .line 226
    .local v23, "widthThumbnail":F
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    move-object/from16 v24, v0

    if-nez v24, :cond_3

    const/4 v9, 0x0

    .line 230
    .local v9, "heightThumbnail":F
    :goto_1
    new-instance v18, Landroid/graphics/Paint;

    invoke-direct/range {v18 .. v18}, Landroid/graphics/Paint;-><init>()V

    .line 231
    .local v18, "paint":Landroid/graphics/Paint;
    const-string/jumbo v24, "Calibri"

    const/16 v25, 0x0

    invoke-static/range {v24 .. v25}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v8

    .line 232
    .local v8, "headerFont":Landroid/graphics/Typeface;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    move-object/from16 v24, v0

    sget v25, Lcom/amazon/mShop/android/lib/R$color;->amazon_gold:I

    invoke-virtual/range {v24 .. v25}, Landroid/content/res/Resources;->getColor(I)I

    move-result v24

    move-object/from16 v0, v18

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 233
    const/16 v24, 0x1

    move-object/from16 v0, v18

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setFlags(I)V

    .line 234
    const/16 v24, 0x1

    move-object/from16 v0, v18

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 235
    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 236
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mProductHeaderFontSize:F

    move/from16 v24, v0

    move-object/from16 v0, v18

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 239
    invoke-virtual/range {v18 .. v18}, Landroid/graphics/Paint;->getFontSpacing()F

    move-result v13

    .line 243
    .local v13, "lineSpaceHeadText":F
    new-instance v20, Landroid/graphics/RectF;

    invoke-direct/range {v20 .. v20}, Landroid/graphics/RectF;-><init>()V

    .line 244
    .local v20, "thumbnailOrigin":Landroid/graphics/RectF;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Lcom/amazon/mShop/home/PromoSlotView;->getMeasuredWidth()I

    move-result v24

    move/from16 v0, v24

    int-to-float v0, v0

    move/from16 v22, v0

    .line 245
    .local v22, "viewWidth":F
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoImageOnly:Z

    move/from16 v24, v0

    if-eqz v24, :cond_4

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotWidth:F

    move/from16 v24, v0

    cmpg-float v24, v23, v24

    if-gez v24, :cond_4

    .line 246
    sub-float v24, v22, v23

    const/high16 v25, 0x40000000    # 2.0f

    div-float v24, v24, v25

    move/from16 v0, v24

    move-object/from16 v1, v20

    iput v0, v1, Landroid/graphics/RectF;->left:F

    .line 250
    :goto_2
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotHeight:F

    move/from16 v24, v0

    sub-float v24, v24, v9

    const/high16 v25, 0x40000000    # 2.0f

    div-float v24, v24, v25

    move/from16 v0, v24

    move-object/from16 v1, v20

    iput v0, v1, Landroid/graphics/RectF;->top:F

    .line 251
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    move-object/from16 v24, v0

    if-eqz v24, :cond_0

    .line 252
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    move-object/from16 v24, v0

    move-object/from16 v0, v20

    iget v0, v0, Landroid/graphics/RectF;->left:F

    move/from16 v25, v0

    move-object/from16 v0, v20

    iget v0, v0, Landroid/graphics/RectF;->top:F

    move/from16 v26, v0

    const/16 v27, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    move/from16 v2, v25

    move/from16 v3, v26

    move-object/from16 v4, v27

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 257
    :cond_0
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoImageOnly:Z

    move/from16 v24, v0

    if-eqz v24, :cond_5

    .line 392
    :cond_1
    :goto_3
    return-void

    .line 225
    .end local v8    # "headerFont":Landroid/graphics/Typeface;
    .end local v9    # "heightThumbnail":F
    .end local v13    # "lineSpaceHeadText":F
    .end local v18    # "paint":Landroid/graphics/Paint;
    .end local v20    # "thumbnailOrigin":Landroid/graphics/RectF;
    .end local v22    # "viewWidth":F
    .end local v23    # "widthThumbnail":F
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v24

    move/from16 v0, v24

    int-to-float v0, v0

    move/from16 v23, v0

    goto/16 :goto_0

    .line 226
    .restart local v23    # "widthThumbnail":F
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v24

    move/from16 v0, v24

    int-to-float v9, v0

    goto/16 :goto_1

    .line 248
    .restart local v8    # "headerFont":Landroid/graphics/Typeface;
    .restart local v9    # "heightThumbnail":F
    .restart local v13    # "lineSpaceHeadText":F
    .restart local v18    # "paint":Landroid/graphics/Paint;
    .restart local v20    # "thumbnailOrigin":Landroid/graphics/RectF;
    .restart local v22    # "viewWidth":F
    :cond_4
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotWidth:F

    move/from16 v24, v0

    sub-float v24, v22, v24

    const/high16 v25, 0x40000000    # 2.0f

    div-float v24, v24, v25

    move/from16 v0, v24

    move-object/from16 v1, v20

    iput v0, v1, Landroid/graphics/RectF;->left:F

    goto :goto_2

    .line 262
    :cond_5
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotWidth:F

    move/from16 v24, v0

    sub-float v24, v24, v23

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRightMarginOnThumbnail:F

    move/from16 v25, v0

    sub-float v24, v24, v25

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mGenericMarginOnProductPromo:F

    move/from16 v25, v0

    sub-float v14, v24, v25

    .line 266
    .local v14, "measuredWidth":F
    const/16 v16, 0x0

    .line 267
    .local v16, "numberInMeaturedWidth":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    move-object/from16 v24, v0

    if-eqz v24, :cond_6

    .line 268
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    move-object/from16 v24, v0

    const/16 v25, 0x1

    const/16 v26, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v24

    move/from16 v2, v25

    move-object/from16 v3, v26

    invoke-virtual {v0, v1, v2, v14, v3}, Landroid/graphics/Paint;->breakText(Ljava/lang/String;ZF[F)I

    move-result v16

    .line 275
    :cond_6
    new-instance v7, Landroid/graphics/RectF;

    invoke-direct {v7}, Landroid/graphics/RectF;-><init>()V

    .line 280
    .local v7, "headTextOrigin":Landroid/graphics/RectF;
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoSlotHeight:F

    move/from16 v24, v0

    const/high16 v25, 0x3e000000    # 0.125f

    mul-float v24, v24, v25

    const/high16 v25, 0x40000000    # 2.0f

    div-float v17, v24, v25

    .line 281
    .local v17, "originTop":F
    move-object/from16 v0, v20

    iget v0, v0, Landroid/graphics/RectF;->left:F

    move/from16 v24, v0

    add-float v24, v24, v23

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRightMarginOnThumbnail:F

    move/from16 v25, v0

    add-float v24, v24, v25

    move/from16 v0, v24

    iput v0, v7, Landroid/graphics/RectF;->left:F

    .line 286
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    move-object/from16 v24, v0

    if-eqz v24, :cond_8

    .line 287
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mProductHeaderFontSize:F

    move/from16 v24, v0

    add-float v24, v24, v17

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mGenericMarginOnProductPromo:F

    move/from16 v25, v0

    add-float v24, v24, v25

    move/from16 v0, v24

    iput v0, v7, Landroid/graphics/RectF;->top:F

    .line 295
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    move-object/from16 v24, v0

    if-eqz v24, :cond_7

    .line 296
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    move/from16 v0, v24

    move/from16 v1, v16

    if-gt v0, v1, :cond_9

    .line 297
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    move-object/from16 v24, v0

    iget v0, v7, Landroid/graphics/RectF;->left:F

    move/from16 v25, v0

    iget v0, v7, Landroid/graphics/RectF;->top:F

    move/from16 v26, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    move/from16 v2, v25

    move/from16 v3, v26

    move-object/from16 v4, v18

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 306
    :cond_7
    :goto_5
    const-string/jumbo v24, "Calibri"

    const/16 v25, 0x0

    invoke-static/range {v24 .. v25}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v21

    .line 307
    .local v21, "titleFont":Landroid/graphics/Typeface;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mRes:Landroid/content/res/Resources;

    move-object/from16 v24, v0

    sget v25, Lcom/amazon/mShop/android/lib/R$color;->gray_text:I

    invoke-virtual/range {v24 .. v25}, Landroid/content/res/Resources;->getColor(I)I

    move-result v24

    move-object/from16 v0, v18

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 308
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mProductTitleFontSize:F

    move/from16 v24, v0

    move-object/from16 v0, v18

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 309
    move-object/from16 v0, v18

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 312
    invoke-virtual/range {v18 .. v18}, Landroid/graphics/Paint;->getFontSpacing()F

    move-result v12

    .line 315
    .local v12, "lineSpaceBottomText":F
    new-instance v5, Landroid/graphics/RectF;

    invoke-direct {v5}, Landroid/graphics/RectF;-><init>()V

    .line 316
    .local v5, "bottomTextOrigin":Landroid/graphics/RectF;
    iget v0, v7, Landroid/graphics/RectF;->left:F

    move/from16 v24, v0

    move/from16 v0, v24

    iput v0, v5, Landroid/graphics/RectF;->left:F

    .line 317
    iget v0, v7, Landroid/graphics/RectF;->top:F

    move/from16 v24, v0

    add-float v24, v24, v13

    move/from16 v0, v24

    iput v0, v5, Landroid/graphics/RectF;->top:F

    .line 319
    const/16 v19, 0x0

    .line 320
    .local v19, "start":I
    const/4 v6, 0x0

    .line 321
    .local v6, "end":I
    const-string/jumbo v24, "..."

    move-object/from16 v0, v18

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v15

    .line 322
    .local v15, "measuredWidthOfEllipsis":F
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/lang/String;->length()I

    move-result v25

    move-object/from16 v0, v24

    move/from16 v1, v19

    move/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v24

    const/16 v25, 0x1

    const/16 v26, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v24

    move/from16 v2, v25

    move-object/from16 v3, v26

    invoke-virtual {v0, v1, v2, v14, v3}, Landroid/graphics/Paint;->breakText(Ljava/lang/String;ZF[F)I

    move-result v16

    .line 327
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_6
    int-to-float v0, v10

    move/from16 v24, v0

    const/high16 v25, 0x40400000    # 3.0f

    cmpg-float v24, v24, v25

    if-gez v24, :cond_1

    .line 329
    const/4 v11, -0x1

    .line 332
    .local v11, "lastIndexOfSpace":I
    :goto_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    move/from16 v0, v19

    move/from16 v1, v24

    if-ge v0, v1, :cond_a

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v24

    const/16 v25, 0x20

    move/from16 v0, v24

    move/from16 v1, v25

    if-ne v0, v1, :cond_a

    .line 333
    add-int/lit8 v19, v19, 0x1

    goto :goto_7

    .line 290
    .end local v5    # "bottomTextOrigin":Landroid/graphics/RectF;
    .end local v6    # "end":I
    .end local v10    # "i":I
    .end local v11    # "lastIndexOfSpace":I
    .end local v12    # "lineSpaceBottomText":F
    .end local v15    # "measuredWidthOfEllipsis":F
    .end local v19    # "start":I
    .end local v21    # "titleFont":Landroid/graphics/Typeface;
    :cond_8
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mProductTitleFontSize:F

    move/from16 v24, v0

    add-float v24, v24, v17

    move/from16 v0, v24

    iput v0, v7, Landroid/graphics/RectF;->top:F

    goto/16 :goto_4

    .line 300
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mHeader:Ljava/lang/String;

    move-object/from16 v24, v0

    const/16 v25, 0x0

    move-object/from16 v0, v24

    move/from16 v1, v25

    move/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v24

    iget v0, v7, Landroid/graphics/RectF;->left:F

    move/from16 v25, v0

    iget v0, v7, Landroid/graphics/RectF;->top:F

    move/from16 v26, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    move/from16 v2, v25

    move/from16 v3, v26

    move-object/from16 v4, v18

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_5

    .line 336
    .restart local v5    # "bottomTextOrigin":Landroid/graphics/RectF;
    .restart local v6    # "end":I
    .restart local v10    # "i":I
    .restart local v11    # "lastIndexOfSpace":I
    .restart local v12    # "lineSpaceBottomText":F
    .restart local v15    # "measuredWidthOfEllipsis":F
    .restart local v19    # "start":I
    .restart local v21    # "titleFont":Landroid/graphics/Typeface;
    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    move/from16 v0, v19

    move/from16 v1, v24

    if-eq v0, v1, :cond_1

    .line 341
    int-to-float v0, v10

    move/from16 v24, v0

    const/high16 v25, 0x40000000    # 2.0f

    cmpl-float v24, v24, v25

    if-nez v24, :cond_b

    .line 342
    sub-float/2addr v14, v15

    .line 346
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/lang/String;->length()I

    move-result v25

    move-object/from16 v0, v24

    move/from16 v1, v19

    move/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v24

    const/16 v25, 0x1

    const/16 v26, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v24

    move/from16 v2, v25

    move-object/from16 v3, v26

    invoke-virtual {v0, v1, v2, v14, v3}, Landroid/graphics/Paint;->breakText(Ljava/lang/String;ZF[F)I

    move-result v16

    .line 349
    add-int v6, v19, v16

    .line 352
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    move/from16 v1, v19

    invoke-virtual {v0, v1, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v24

    const-string/jumbo v25, " "

    invoke-virtual/range {v24 .. v25}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v11

    .line 355
    const/16 v24, -0x1

    move/from16 v0, v24

    if-eq v0, v11, :cond_c

    int-to-float v0, v10

    move/from16 v24, v0

    const/high16 v25, 0x40000000    # 2.0f

    cmpl-float v24, v24, v25

    if-eqz v24, :cond_c

    .line 359
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    move/from16 v0, v24

    if-ge v6, v0, :cond_c

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Ljava/lang/String;->charAt(I)C

    move-result v24

    const/16 v25, 0x20

    move/from16 v0, v24

    move/from16 v1, v25

    if-eq v0, v1, :cond_c

    .line 360
    add-int v6, v11, v19

    .line 364
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    move/from16 v0, v24

    if-ge v6, v0, :cond_e

    .line 367
    int-to-float v0, v10

    move/from16 v24, v0

    const/high16 v25, 0x40000000    # 2.0f

    cmpl-float v24, v24, v25

    if-nez v24, :cond_d

    .line 368
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-direct/range {v24 .. v24}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    move/from16 v1, v19

    invoke-virtual {v0, v1, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string/jumbo v25, "..."

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    iget v0, v5, Landroid/graphics/RectF;->left:F

    move/from16 v25, v0

    iget v0, v5, Landroid/graphics/RectF;->top:F

    move/from16 v26, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    move/from16 v2, v25

    move/from16 v3, v26

    move-object/from16 v4, v18

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 383
    :goto_8
    iget v0, v5, Landroid/graphics/RectF;->top:F

    move/from16 v24, v0

    add-float v24, v24, v12

    move/from16 v0, v24

    iput v0, v5, Landroid/graphics/RectF;->top:F

    .line 384
    const/16 v24, -0x1

    move/from16 v0, v24

    if-eq v0, v11, :cond_f

    .line 385
    add-int/lit8 v19, v6, 0x1

    .line 327
    :goto_9
    add-int/lit8 v10, v10, 0x1

    goto/16 :goto_6

    .line 372
    :cond_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    move/from16 v1, v19

    invoke-virtual {v0, v1, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v24

    iget v0, v5, Landroid/graphics/RectF;->left:F

    move/from16 v25, v0

    iget v0, v5, Landroid/graphics/RectF;->top:F

    move/from16 v26, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    move/from16 v2, v25

    move/from16 v3, v26

    move-object/from16 v4, v18

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_8

    .line 377
    :cond_e
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mTitle:Ljava/lang/String;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/lang/String;->length()I

    move-result v25

    move-object/from16 v0, v24

    move/from16 v1, v19

    move/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v24

    iget v0, v5, Landroid/graphics/RectF;->left:F

    move/from16 v25, v0

    iget v0, v5, Landroid/graphics/RectF;->top:F

    move/from16 v26, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    move/from16 v2, v25

    move/from16 v3, v26

    move-object/from16 v4, v18

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_3

    .line 387
    :cond_f
    move/from16 v19, v6

    goto :goto_9
.end method

.method public getOpacity()I
    .locals 1

    .prologue
    .line 396
    const/4 v0, 0x0

    return v0
.end method

.method public getThumbnail()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 176
    iget-boolean v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mPromoImageOnly:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    .line 179
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 450
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/PromoSlotView;->setDefaultPromoSlot()V

    .line 451
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 452
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v0}, Lcom/amazon/mShop/home/PromoSlotView;->access$000(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 453
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v0}, Lcom/amazon/mShop/home/PromoSlotView;->access$000(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 455
    :cond_0
    return-void
.end method

.method public onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 4
    .param p1, "response"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    const/4 v3, 0x1

    .line 411
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v1

    if-nez v1, :cond_1

    .line 412
    check-cast p2, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    .end local p2    # "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    invoke-virtual {p2}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    .line 413
    .local v0, "baseUrl":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnailImageUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 414
    iput-object p1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mThumbnail:Landroid/graphics/Bitmap;

    .line 415
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # invokes: Lcom/amazon/mShop/home/PromoSlotView;->showPromoSlot()V
    invoke-static {v1}, Lcom/amazon/mShop/home/PromoSlotView;->access$100(Lcom/amazon/mShop/home/PromoSlotView;)V

    .line 416
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/home/PromoSlotView;->setFocusable(Z)V

    .line 417
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    sget v2, Lcom/amazon/mShop/android/lib/R$color;->gallery_image_selector:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/PromoSlotView;->setBackgroundResource(I)V

    .line 418
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/home/PromoSlotView;->setClickable(Z)V

    .line 419
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v2, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotValue:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    invoke-static {v2}, Lcom/amazon/mShop/home/PromoSlotView;->access$200(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/PromoSlotView;->setTag(Ljava/lang/Object;)V

    .line 420
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    new-instance v2, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage$1;-><init>(Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;)V

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/PromoSlotView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 438
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 441
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v1}, Lcom/amazon/mShop/home/PromoSlotView;->access$000(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 442
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v1}, Lcom/amazon/mShop/home/PromoSlotView;->access$000(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 445
    .end local v0    # "baseUrl":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 134
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method

.method public setAlpha(I)V
    .locals 0
    .param p1, "alpha"    # I

    .prologue
    .line 402
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 0
    .param p1, "cf"    # Landroid/graphics/ColorFilter;

    .prologue
    .line 407
    return-void
.end method
