.class public Lcom/amazon/mShop/util/JpegUtils;
.super Ljava/lang/Object;
.source "JpegUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static computeWidthAndHeightForMyRawJpegImage()[I
    .locals 1

    .prologue
    .line 116
    const/4 v0, 0x2

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    return-object v0

    nop

    :array_0
    .array-data 4
        0x1e0
        0x168
    .end array-data
.end method

.method public static jpegToBitmap([B)Landroid/graphics/Bitmap;
    .locals 9
    .param p0, "jpeg"    # [B

    .prologue
    const/4 v6, 0x1

    const/4 v8, 0x0

    .line 46
    invoke-static {}, Lcom/amazon/mShop/util/JpegUtils;->computeWidthAndHeightForMyRawJpegImage()[I

    move-result-object v5

    .line 47
    .local v5, "widthAndHeight":[I
    aget v3, v5, v8

    .line 48
    .local v3, "maxWidth":I
    aget v2, v5, v6

    .line 53
    .local v2, "maxHeight":I
    new-instance v4, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v4}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 54
    .local v4, "options":Landroid/graphics/BitmapFactory$Options;
    iput-boolean v6, v4, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 55
    array-length v6, p0

    invoke-static {p0, v8, v6, v4}, Landroid/graphics/BitmapFactory;->decodeByteArray([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 56
    iget v6, v4, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    iget v7, v4, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    invoke-static {v6, v7}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 57
    .local v0, "maxDimension":I
    iput-boolean v8, v4, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 59
    invoke-static {v3, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 60
    .local v1, "maxExpectedDimension":I
    if-le v0, v1, :cond_0

    .line 61
    div-int v6, v0, v1

    iput v6, v4, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 63
    :cond_0
    array-length v6, p0

    invoke-static {p0, v8, v6, v4}, Landroid/graphics/BitmapFactory;->decodeByteArray([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v6

    invoke-static {v6, v3, v2, v8}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v6

    return-object v6
.end method
