.class public Lnet/tsz/afinal/bitmap/core/BitmapDecoder;
.super Ljava/lang/Object;
.source "BitmapDecoder.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "BitmapDecoder"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I
    .locals 7
    .param p0, "options"    # Landroid/graphics/BitmapFactory$Options;
    .param p1, "reqWidth"    # I
    .param p2, "reqHeight"    # I

    .prologue
    .line 80
    iget v0, p0, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    .line 81
    .local v0, "height":I
    iget v4, p0, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    .line 82
    .local v4, "width":I
    const/4 v1, 0x1

    .line 84
    .local v1, "inSampleSize":I
    if-gt v0, p2, :cond_0

    if-le v4, p1, :cond_1

    .line 85
    :cond_0
    if-le v4, v0, :cond_2

    .line 86
    int-to-float v5, v0

    int-to-float v6, p2

    div-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v1

    .line 91
    :goto_0
    mul-int v5, v4, v0

    int-to-float v2, v5

    .line 93
    .local v2, "totalPixels":F
    mul-int v5, p1, p2

    mul-int/lit8 v5, v5, 0x2

    int-to-float v3, v5

    .line 95
    .local v3, "totalReqPixelsCap":F
    :goto_1
    mul-int v5, v1, v1

    int-to-float v5, v5

    div-float v5, v2, v5

    cmpl-float v5, v5, v3

    if-gtz v5, :cond_3

    .line 99
    .end local v2    # "totalPixels":F
    .end local v3    # "totalReqPixelsCap":F
    :cond_1
    return v1

    .line 88
    :cond_2
    int-to-float v5, v4

    int-to-float v6, p1

    div-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v1

    goto :goto_0

    .line 96
    .restart local v2    # "totalPixels":F
    .restart local v3    # "totalReqPixelsCap":F
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method public static decodeSampledBitmapFromDescriptor(Ljava/io/FileDescriptor;II)Landroid/graphics/Bitmap;
    .locals 5
    .param p0, "fileDescriptor"    # Ljava/io/FileDescriptor;
    .param p1, "reqWidth"    # I
    .param p2, "reqHeight"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 64
    new-instance v1, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v1}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 65
    .local v1, "options":Landroid/graphics/BitmapFactory$Options;
    iput-boolean v3, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 66
    iput-boolean v3, v1, Landroid/graphics/BitmapFactory$Options;->inPurgeable:Z

    .line 67
    invoke-static {p0, v2, v1}, Landroid/graphics/BitmapFactory;->decodeFileDescriptor(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 68
    invoke-static {v1, p1, p2}, Lnet/tsz/afinal/bitmap/core/BitmapDecoder;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v3

    iput v3, v1, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 69
    const/4 v3, 0x0

    iput-boolean v3, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 71
    const/4 v3, 0x0

    :try_start_0
    invoke-static {p0, v3, v1}, Landroid/graphics/BitmapFactory;->decodeFileDescriptor(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 75
    :goto_0
    return-object v2

    .line 72
    :catch_0
    move-exception v0

    .line 73
    .local v0, "e":Ljava/lang/OutOfMemoryError;
    const-string v3, "BitmapDecoder"

    const-string v4, "decodeSampledBitmapFromDescriptor\u5185\u5b58\u6ea2\u51fa\uff0c\u5982\u679c\u9891\u7e41\u51fa\u73b0\u8fd9\u4e2a\u60c5\u51b5 \u53ef\u4ee5\u5c1d\u8bd5\u914d\u7f6e\u589e\u52a0\u5185\u5b58\u7f13\u5b58\u5927\u5c0f"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 74
    invoke-virtual {v0}, Ljava/lang/OutOfMemoryError;->printStackTrace()V

    goto :goto_0
.end method

.method public static decodeSampledBitmapFromFile(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    .locals 4
    .param p0, "filename"    # Ljava/lang/String;
    .param p1, "reqWidth"    # I
    .param p2, "reqHeight"    # I

    .prologue
    const/4 v2, 0x1

    .line 47
    new-instance v1, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v1}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 48
    .local v1, "options":Landroid/graphics/BitmapFactory$Options;
    iput-boolean v2, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 49
    iput-boolean v2, v1, Landroid/graphics/BitmapFactory$Options;->inPurgeable:Z

    .line 50
    invoke-static {p0, v1}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 51
    invoke-static {v1, p1, p2}, Lnet/tsz/afinal/bitmap/core/BitmapDecoder;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v2

    iput v2, v1, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 52
    const/4 v2, 0x0

    iput-boolean v2, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 54
    :try_start_0
    invoke-static {p0, v1}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 58
    :goto_0
    return-object v2

    .line 55
    :catch_0
    move-exception v0

    .line 56
    .local v0, "e":Ljava/lang/OutOfMemoryError;
    const-string v2, "BitmapDecoder"

    const-string v3, "decodeSampledBitmapFromFile\u5185\u5b58\u6ea2\u51fa\uff0c\u5982\u679c\u9891\u7e41\u51fa\u73b0\u8fd9\u4e2a\u60c5\u51b5 \u53ef\u4ee5\u5c1d\u8bd5\u914d\u7f6e\u589e\u52a0\u5185\u5b58\u7f13\u5b58\u5927\u5c0f"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 57
    invoke-virtual {v0}, Ljava/lang/OutOfMemoryError;->printStackTrace()V

    .line 58
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static decodeSampledBitmapFromResource(Landroid/content/res/Resources;III)Landroid/graphics/Bitmap;
    .locals 4
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "resId"    # I
    .param p2, "reqWidth"    # I
    .param p3, "reqHeight"    # I

    .prologue
    const/4 v2, 0x1

    .line 31
    new-instance v1, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v1}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 32
    .local v1, "options":Landroid/graphics/BitmapFactory$Options;
    iput-boolean v2, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 33
    iput-boolean v2, v1, Landroid/graphics/BitmapFactory$Options;->inPurgeable:Z

    .line 34
    invoke-static {p0, p1, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 35
    invoke-static {v1, p2, p3}, Lnet/tsz/afinal/bitmap/core/BitmapDecoder;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v2

    iput v2, v1, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 36
    const/4 v2, 0x0

    iput-boolean v2, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 38
    :try_start_0
    invoke-static {p0, p1, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 42
    :goto_0
    return-object v2

    .line 39
    :catch_0
    move-exception v0

    .line 40
    .local v0, "e":Ljava/lang/OutOfMemoryError;
    const-string v2, "BitmapDecoder"

    const-string v3, "decodeSampledBitmapFromResource\u5185\u5b58\u6ea2\u51fa\uff0c\u5982\u679c\u9891\u7e41\u51fa\u73b0\u8fd9\u4e2a\u60c5\u51b5 \u53ef\u4ee5\u5c1d\u8bd5\u914d\u7f6e\u589e\u52a0\u5185\u5b58\u7f13\u5b58\u5927\u5c0f"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 41
    invoke-virtual {v0}, Ljava/lang/OutOfMemoryError;->printStackTrace()V

    .line 42
    const/4 v2, 0x0

    goto :goto_0
.end method
