.class public Lcom/poshmark/utils/ImageUtils;
.super Ljava/lang/Object;
.source "ImageUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/ImageUtils$BitmapDownloader;
    }
.end annotation


# static fields
.field public static final defaultJPEGQuality:I = 0x5f


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 306
    return-void
.end method

.method private static broadcastToMediaScanner()V
    .locals 7

    .prologue
    .line 79
    :try_start_0
    new-instance v1, Ljava/io/File;

    invoke-static {}, Lcom/poshmark/utils/ImageUtils;->getPictureDirectory()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 80
    .local v1, "mediaStorageDir":Ljava/io/File;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    new-instance v3, Landroid/content/Intent;

    const-string v4, "android.intent.action.MEDIA_MOUNTED"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "file://"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v2, v3}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 86
    :goto_0
    return-void

    .line 82
    :catch_0
    move-exception v0

    .line 84
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public static calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I
    .locals 7
    .param p0, "options"    # Landroid/graphics/BitmapFactory$Options;
    .param p1, "reqWidth"    # I
    .param p2, "reqHeight"    # I

    .prologue
    .line 226
    iget v0, p0, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    .line 227
    .local v0, "height":I
    iget v3, p0, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    .line 228
    .local v3, "width":I
    const/4 v2, 0x1

    .line 230
    .local v2, "inSampleSize":I
    if-gt v0, p2, :cond_0

    if-le v3, p1, :cond_1

    .line 233
    :cond_0
    int-to-float v5, v0

    int-to-float v6, p2

    div-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v1

    .line 234
    .local v1, "heightRatio":I
    int-to-float v5, v3

    int-to-float v6, p1

    div-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v4

    .line 236
    .local v4, "widthRatio":I
    move v2, v4

    .line 239
    .end local v1    # "heightRatio":I
    .end local v4    # "widthRatio":I
    :cond_1
    return v2
.end method

.method public static convertBase64StringToBitmap(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 4
    .param p0, "b64Str"    # Ljava/lang/String;

    .prologue
    .line 218
    const/4 v2, 0x2

    invoke-static {p0, v2}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    .line 219
    .local v0, "b":[B
    const/4 v2, 0x0

    array-length v3, v0

    invoke-static {v0, v2, v3}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 220
    .local v1, "bmp":Landroid/graphics/Bitmap;
    return-object v1
.end method

.method public static downloadBitmap(Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;
    .locals 12
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "url"    # Landroid/net/Uri;

    .prologue
    const/4 v7, 0x0

    .line 245
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v8

    const-string v9, "mounted"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 246
    new-instance v1, Ljava/io/File;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v8

    const-string v9, ".OCFL311"

    invoke-direct {v1, v8, v9}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 251
    .local v1, "cacheDir":Ljava/io/File;
    :goto_0
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_0

    .line 252
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    .line 254
    :cond_0
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v1, p0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 257
    .local v3, "f":Ljava/io/File;
    const/4 v4, 0x0

    .line 259
    .local v4, "is":Ljava/io/InputStream;
    :try_start_0
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v8

    const-string v9, "content://"

    invoke-virtual {v8, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 260
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/application/PMApplication;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v8

    invoke-virtual {v8, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v4

    .line 265
    :goto_1
    new-instance v6, Ljava/io/FileOutputStream;

    invoke-direct {v6, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 266
    .local v6, "os":Ljava/io/OutputStream;
    const/16 v8, 0x400

    new-array v0, v8, [B

    .line 268
    .local v0, "buffer":[B
    :goto_2
    invoke-virtual {v4, v0}, Ljava/io/InputStream;->read([B)I

    move-result v5

    .local v5, "len":I
    const/4 v8, -0x1

    if-eq v5, v8, :cond_4

    .line 269
    const/4 v8, 0x0

    invoke-virtual {v6, v0, v8, v5}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 276
    .end local v0    # "buffer":[B
    .end local v5    # "len":I
    .end local v6    # "os":Ljava/io/OutputStream;
    :catch_0
    move-exception v2

    .line 277
    :cond_1
    :goto_3
    return-object v7

    .line 249
    .end local v1    # "cacheDir":Ljava/io/File;
    .end local v3    # "f":Ljava/io/File;
    .end local v4    # "is":Ljava/io/InputStream;
    :cond_2
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/application/PMApplication;->getCacheDir()Ljava/io/File;

    move-result-object v1

    .restart local v1    # "cacheDir":Ljava/io/File;
    goto :goto_0

    .line 262
    .restart local v3    # "f":Ljava/io/File;
    .restart local v4    # "is":Ljava/io/InputStream;
    :cond_3
    :try_start_1
    new-instance v8, Ljava/net/URL;

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/net/URL;->openStream()Ljava/io/InputStream;

    move-result-object v4

    goto :goto_1

    .line 271
    .restart local v0    # "buffer":[B
    .restart local v5    # "len":I
    .restart local v6    # "os":Ljava/io/OutputStream;
    :cond_4
    invoke-virtual {v6}, Ljava/io/OutputStream;->close()V

    .line 272
    invoke-virtual {v3}, Ljava/io/File;->length()J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v8, v8, v10

    if-lez v8, :cond_1

    .line 273
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v7

    goto :goto_3
.end method

.method public static exifOrientation(Ljava/lang/String;)I
    .locals 6
    .param p0, "file"    # Ljava/lang/String;

    .prologue
    .line 284
    const/4 v0, 0x0

    .line 285
    .local v0, "angle":I
    :try_start_0
    new-instance v2, Landroid/media/ExifInterface;

    invoke-direct {v2, p0}, Landroid/media/ExifInterface;-><init>(Ljava/lang/String;)V

    .line 286
    .local v2, "exifInterface":Landroid/media/ExifInterface;
    const-string v4, "Orientation"

    const/4 v5, 0x1

    invoke-virtual {v2, v4, v5}, Landroid/media/ExifInterface;->getAttributeInt(Ljava/lang/String;I)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 287
    .local v3, "orientation":I
    packed-switch v3, :pswitch_data_0

    .line 302
    .end local v0    # "angle":I
    .end local v2    # "exifInterface":Landroid/media/ExifInterface;
    .end local v3    # "orientation":I
    :goto_0
    :pswitch_0
    return v0

    .line 289
    .restart local v0    # "angle":I
    .restart local v2    # "exifInterface":Landroid/media/ExifInterface;
    .restart local v3    # "orientation":I
    :pswitch_1
    const/16 v0, 0x5a

    .line 290
    goto :goto_0

    .line 292
    :pswitch_2
    const/16 v0, 0xb4

    .line 293
    goto :goto_0

    .line 295
    :pswitch_3
    const/16 v0, 0x10e

    goto :goto_0

    .line 300
    .end local v2    # "exifInterface":Landroid/media/ExifInterface;
    .end local v3    # "orientation":I
    :catch_0
    move-exception v1

    .line 301
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    .line 302
    const/4 v0, 0x0

    goto :goto_0

    .line 287
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public static generateFileName()Ljava/lang/String;
    .locals 4

    .prologue
    .line 125
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyy-MMdd HH_mm_ss"

    invoke-direct {v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 126
    .local v1, "dateFormat":Ljava/text/SimpleDateFormat;
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 127
    .local v0, "date":Ljava/util/Date;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "PMCovershot"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".jpg"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static getBitmapAsBase64String(Landroid/net/Uri;I)Ljava/lang/String;
    .locals 5
    .param p0, "imageFile"    # Landroid/net/Uri;
    .param p1, "imageQualityValue"    # I

    .prologue
    .line 209
    invoke-virtual {p0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 210
    .local v1, "bm":Landroid/graphics/Bitmap;
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 211
    .local v2, "os":Ljava/io/ByteArrayOutputStream;
    sget-object v3, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v4, 0x5f

    invoke-virtual {v1, v3, v4, v2}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 212
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    .line 213
    .local v0, "b":[B
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    .line 214
    const/4 v3, 0x2

    invoke-static {v0, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public static getBitmapFromDrawable(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 7
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v4, 0x1

    const/4 v6, 0x0

    .line 162
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    .line 163
    .local v3, "width":I
    if-lez v3, :cond_0

    .line 164
    :goto_0
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    .line 165
    .local v2, "height":I
    if-lez v2, :cond_1

    .line 167
    :goto_1
    sget-object v4, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v3, v2, v4}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 168
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 169
    .local v1, "canvas":Landroid/graphics/Canvas;
    invoke-virtual {v1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v4

    invoke-virtual {v1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    invoke-virtual {p0, v6, v6, v4, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 170
    invoke-virtual {p0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 172
    return-object v0

    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "canvas":Landroid/graphics/Canvas;
    .end local v2    # "height":I
    :cond_0
    move v3, v4

    .line 163
    goto :goto_0

    .restart local v2    # "height":I
    :cond_1
    move v2, v4

    .line 165
    goto :goto_1
.end method

.method public static getPictureDirectory()Ljava/lang/String;
    .locals 2

    .prologue
    .line 68
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Landroid/os/Environment;->DIRECTORY_PICTURES:Ljava/lang/String;

    invoke-static {v1}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/Poshmark"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static loadScaledBitmapFromResource(Landroid/content/res/Resources;IIIZ)Landroid/graphics/Bitmap;
    .locals 4
    .param p0, "resources"    # Landroid/content/res/Resources;
    .param p1, "resourceID"    # I
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "lowRes"    # Z

    .prologue
    .line 328
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 329
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v3, 0x1

    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 330
    invoke-static {p0, p1, v0}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 332
    .local v1, "originalSelectedImage":Landroid/graphics/Bitmap;
    invoke-static {v0, p2, p3}, Lcom/poshmark/utils/ImageUtils;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v2

    .line 333
    .local v2, "sampleSize":I
    const/4 v3, 0x0

    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 334
    iput v2, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 335
    if-eqz p4, :cond_0

    .line 336
    sget-object v3, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    iput-object v3, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    .line 339
    :cond_0
    invoke-static {p0, p1, v0}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 340
    return-object v1
.end method

.method public static saveBitmapToDisk(Landroid/graphics/Bitmap;)Landroid/net/Uri;
    .locals 5
    .param p0, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 118
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v3, "yyyy-MMdd HH_mm_ss"

    invoke-direct {v1, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 119
    .local v1, "dateFormat":Ljava/text/SimpleDateFormat;
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 120
    .local v0, "date":Ljava/util/Date;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "PMCovershot"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".jpg"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 121
    .local v2, "fileName":Ljava/lang/String;
    invoke-static {p0, v2}, Lcom/poshmark/utils/ImageUtils;->saveBitmapToDisk(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    return-object v3
.end method

.method public static saveBitmapToDisk(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/net/Uri;
    .locals 9
    .param p0, "bmp"    # Landroid/graphics/Bitmap;
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 89
    if-nez p1, :cond_0

    .line 90
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v7, "yyyy-MMdd HH_mm_ss"

    invoke-direct {v1, v7}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 91
    .local v1, "dateFormat":Ljava/text/SimpleDateFormat;
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 92
    .local v0, "date":Ljava/util/Date;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "PMCovershot"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ".jpg"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 95
    .end local v0    # "date":Ljava/util/Date;
    .end local v1    # "dateFormat":Ljava/text/SimpleDateFormat;
    :cond_0
    new-instance v5, Ljava/io/File;

    invoke-static {}, Lcom/poshmark/utils/ImageUtils;->getPictureDirectory()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 96
    .local v5, "storage_path":Ljava/io/File;
    invoke-virtual {v5}, Ljava/io/File;->mkdirs()Z

    move-result v7

    if-nez v7, :cond_1

    invoke-virtual {v5}, Ljava/io/File;->isDirectory()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 97
    :cond_1
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v5, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 100
    .local v3, "file":Ljava/io/File;
    :try_start_0
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 101
    .local v4, "fo":Ljava/io/OutputStream;
    sget-object v7, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v8, 0x64

    invoke-virtual {p0, v7, v8, v4}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 102
    invoke-virtual {v4}, Ljava/io/OutputStream;->flush()V

    .line 103
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V

    .line 104
    invoke-static {}, Lcom/poshmark/utils/ImageUtils;->broadcastToMediaScanner()V

    .line 105
    invoke-static {v3}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v6

    .line 114
    .end local v3    # "file":Ljava/io/File;
    .end local v4    # "fo":Ljava/io/OutputStream;
    :cond_2
    :goto_0
    return-object v6

    .line 106
    .restart local v3    # "file":Ljava/io/File;
    :catch_0
    move-exception v2

    .line 107
    .local v2, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v2}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 109
    .end local v2    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v2

    .line 110
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public static saveDrawableToDisk(Landroid/graphics/drawable/Drawable;)Landroid/net/Uri;
    .locals 10
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v7, 0x0

    .line 131
    new-instance v6, Ljava/io/File;

    invoke-static {}, Lcom/poshmark/utils/ImageUtils;->getPictureDirectory()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v6, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 132
    .local v6, "storage_path":Ljava/io/File;
    invoke-virtual {v6}, Ljava/io/File;->mkdirs()Z

    move-result v8

    if-nez v8, :cond_0

    invoke-virtual {v6}, Ljava/io/File;->isDirectory()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 133
    :cond_0
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v8, "yyyy-MMdd HH_mm_ss"

    invoke-direct {v2, v8}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 134
    .local v2, "dateFormat":Ljava/text/SimpleDateFormat;
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 135
    .local v1, "date":Ljava/util/Date;
    new-instance v4, Ljava/io/File;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "PMCovershot"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v2, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ".jpg"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v4, v6, v8}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 139
    .local v4, "file":Ljava/io/File;
    :try_start_0
    invoke-static {p0}, Lcom/poshmark/utils/ImageUtils;->getBitmapFromDrawable(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 140
    .local v0, "bmp":Landroid/graphics/Bitmap;
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 141
    .local v5, "fo":Ljava/io/OutputStream;
    sget-object v8, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v9, 0x64

    invoke-virtual {v0, v8, v9, v5}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 142
    invoke-virtual {v5}, Ljava/io/OutputStream;->flush()V

    .line 143
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V

    .line 144
    invoke-static {}, Lcom/poshmark/utils/ImageUtils;->broadcastToMediaScanner()V

    .line 145
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 146
    const/4 v0, 0x0

    .line 147
    invoke-static {v4}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v7

    .line 156
    .end local v0    # "bmp":Landroid/graphics/Bitmap;
    .end local v1    # "date":Ljava/util/Date;
    .end local v2    # "dateFormat":Ljava/text/SimpleDateFormat;
    .end local v4    # "file":Ljava/io/File;
    .end local v5    # "fo":Ljava/io/OutputStream;
    :cond_1
    :goto_0
    return-object v7

    .line 148
    .restart local v1    # "date":Ljava/util/Date;
    .restart local v2    # "dateFormat":Ljava/text/SimpleDateFormat;
    .restart local v4    # "file":Ljava/io/File;
    :catch_0
    move-exception v3

    .line 149
    .local v3, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v3}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 151
    .end local v3    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v3

    .line 152
    .local v3, "e":Ljava/io/IOException;
    invoke-virtual {v3}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public static scaleBitmap(IILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "width"    # I
    .param p1, "height"    # I
    .param p2, "sourceBmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 39
    const/4 v0, 0x0

    return-object v0
.end method

.method public static scaleBitmap(IILandroid/net/Uri;)Landroid/graphics/Bitmap;
    .locals 6
    .param p0, "width"    # I
    .param p1, "height"    # I
    .param p2, "sourceBmpUri"    # Landroid/net/Uri;

    .prologue
    const/4 v0, 0x0

    .line 43
    const/4 v2, 0x0

    .line 46
    .local v2, "is":Ljava/io/InputStream;
    :try_start_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    invoke-virtual {v5, p2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v2

    .line 47
    new-instance v3, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v3}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 48
    .local v3, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v5, 0x1

    iput-boolean v5, v3, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 49
    const/4 v5, 0x0

    invoke-static {v2, v5, v3}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 52
    invoke-static {v3, p0, p1}, Lcom/poshmark/utils/ImageUtils;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v4

    .line 53
    .local v4, "sampleSize":I
    const/4 v5, 0x0

    iput-boolean v5, v3, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 54
    iput v4, v3, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 57
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    invoke-virtual {v5, p2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v2

    .line 58
    const/4 v5, 0x0

    invoke-static {v2, v5, v3}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 62
    .end local v3    # "options":Landroid/graphics/BitmapFactory$Options;
    .end local v4    # "sampleSize":I
    :goto_0
    return-object v0

    .line 60
    :catch_0
    move-exception v1

    .line 61
    .local v1, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v1}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_0
.end method

.method public static takeScreenshot(Landroid/view/View;)Landroid/net/Uri;
    .locals 10
    .param p0, "view"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x0

    const/4 v8, 0x1

    .line 177
    invoke-virtual {p0, v8}, Landroid/view/View;->setDrawingCacheEnabled(Z)V

    .line 178
    invoke-virtual {p0, v8}, Landroid/view/View;->buildDrawingCache(Z)V

    .line 179
    invoke-virtual {p0}, Landroid/view/View;->getDrawingCache()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 181
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v6, Ljava/io/File;

    invoke-static {}, Lcom/poshmark/utils/ImageUtils;->getPictureDirectory()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v6, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 182
    .local v6, "storage_path":Ljava/io/File;
    invoke-virtual {v6}, Ljava/io/File;->mkdirs()Z

    move-result v8

    if-nez v8, :cond_0

    invoke-virtual {v6}, Ljava/io/File;->isDirectory()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 184
    :cond_0
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v8, "yyyy-MMdd HH_mm_ss"

    invoke-direct {v2, v8}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 185
    .local v2, "dateFormat":Ljava/text/SimpleDateFormat;
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 186
    .local v1, "date":Ljava/util/Date;
    new-instance v4, Ljava/io/File;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "PMCloset"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v2, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ".jpg"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v4, v6, v8}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 190
    .local v4, "file":Ljava/io/File;
    :try_start_0
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 191
    .local v5, "fo":Ljava/io/FileOutputStream;
    sget-object v8, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v9, 0x64

    invoke-virtual {v0, v8, v9, v5}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 192
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->close()V

    .line 193
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 194
    const/4 v8, 0x0

    invoke-virtual {p0, v8}, Landroid/view/View;->setDrawingCacheEnabled(Z)V

    .line 195
    invoke-static {v4}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    .line 203
    .end local v1    # "date":Ljava/util/Date;
    .end local v2    # "dateFormat":Ljava/text/SimpleDateFormat;
    .end local v4    # "file":Ljava/io/File;
    .end local v5    # "fo":Ljava/io/FileOutputStream;
    :cond_1
    :goto_0
    return-object v7

    .line 197
    .restart local v1    # "date":Ljava/util/Date;
    .restart local v2    # "dateFormat":Ljava/text/SimpleDateFormat;
    .restart local v4    # "file":Ljava/io/File;
    :catch_0
    move-exception v3

    .line 199
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
