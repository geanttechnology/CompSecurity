.class public Lcom/aio/downloader/utils/ImageUtil;
.super Ljava/lang/Object;
.source "ImageUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/utils/ImageUtil$ImageCallback;
    }
.end annotation


# static fields
.field private static final SDCARD_CACHE_IMG_PATH:Ljava/lang/String;

.field public static cache:Landroid/support/v4/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LruCache",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 28
    new-instance v0, Ljava/lang/StringBuilder;

    .line 29
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "/DCIM/Camera/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 28
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/ImageUtil;->SDCARD_CACHE_IMG_PATH:Ljava/lang/String;

    .line 30
    new-instance v0, Landroid/support/v4/util/LruCache;

    const/4 v1, 0x6

    invoke-direct {v0, v1}, Landroid/support/v4/util/LruCache;-><init>(I)V

    sput-object v0, Lcom/aio/downloader/utils/ImageUtil;->cache:Landroid/support/v4/util/LruCache;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static Bitmap2Bytes(Landroid/graphics/Bitmap;)[B
    .locals 3
    .param p0, "bm"    # Landroid/graphics/Bitmap;

    .prologue
    .line 204
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 205
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    sget-object v1, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v2, 0x64

    invoke-virtual {p0, v1, v2, v0}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 206
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    return-object v1
.end method

.method public static byteToHexString([B)Ljava/lang/String;
    .locals 5
    .param p0, "b"    # [B

    .prologue
    .line 178
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 179
    .local v1, "hexString":Ljava/lang/StringBuffer;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v3, p0

    if-lt v2, v3, :cond_0

    .line 186
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 180
    :cond_0
    aget-byte v3, p0, v2

    and-int/lit16 v3, v3, 0xff

    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    .line 181
    .local v0, "hex":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    .line 182
    new-instance v3, Ljava/lang/StringBuilder;

    const/16 v4, 0x30

    invoke-static {v4}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 184
    :cond_1
    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 179
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static getCacheImgPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    sget-object v0, Lcom/aio/downloader/utils/ImageUtil;->SDCARD_CACHE_IMG_PATH:Ljava/lang/String;

    return-object v0
.end method

.method public static getImageFromLocal(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 4
    .param p0, "imagePath"    # Ljava/lang/String;

    .prologue
    .line 65
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 66
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 67
    invoke-static {p0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 68
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/io/File;->setLastModified(J)Z

    .line 71
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static loadImage(Ljava/lang/String;Ljava/lang/String;Lcom/aio/downloader/utils/ImageUtil$ImageCallback;I)Landroid/graphics/Bitmap;
    .locals 4
    .param p0, "imagePath"    # Ljava/lang/String;
    .param p1, "imgUrl"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/aio/downloader/utils/ImageUtil$ImageCallback;
    .param p3, "opInSampleSize"    # I

    .prologue
    .line 82
    const/4 v0, 0x0

    .line 83
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    sget-object v3, Lcom/aio/downloader/utils/ImageUtil;->cache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v3, p0}, Landroid/support/v4/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    check-cast v0, Landroid/graphics/Bitmap;

    .line 84
    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    move-object v3, v0

    .line 146
    :goto_0
    return-object v3

    .line 87
    :cond_0
    invoke-static {p0}, Lcom/aio/downloader/utils/ImageUtil;->getImageFromLocal(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 88
    if-eqz v0, :cond_1

    move-object v3, v0

    .line 89
    goto :goto_0

    .line 91
    :cond_1
    new-instance v1, Lcom/aio/downloader/utils/ImageUtil$1;

    invoke-direct {v1, p2, p0}, Lcom/aio/downloader/utils/ImageUtil$1;-><init>(Lcom/aio/downloader/utils/ImageUtil$ImageCallback;Ljava/lang/String;)V

    .line 115
    .local v1, "handler":Landroid/os/Handler;
    new-instance v2, Lcom/aio/downloader/utils/ImageUtil$2;

    invoke-direct {v2, p1, p3, p0, v1}, Lcom/aio/downloader/utils/ImageUtil$2;-><init>(Ljava/lang/String;ILjava/lang/String;Landroid/os/Handler;)V

    .line 143
    .local v2, "runnable":Ljava/lang/Runnable;
    invoke-static {}, Lcom/aio/downloader/utils/ThreadPoolManager;->getInstance()Lcom/aio/downloader/utils/ThreadPoolManager;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/aio/downloader/utils/ThreadPoolManager;->addTask(Ljava/lang/Runnable;)V

    .line 146
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static md5(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "paramString"    # Ljava/lang/String;

    .prologue
    .line 162
    :try_start_0
    const-string v3, "MD5"

    invoke-static {v3}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    .line 163
    .local v1, "localMessageDigest":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/security/MessageDigest;->update([B)V

    .line 164
    invoke-virtual {v1}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v3

    invoke-static {v3}, Lcom/aio/downloader/utils/ImageUtil;->byteToHexString([B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 167
    .end local v1    # "localMessageDigest":Ljava/security/MessageDigest;
    :goto_0
    return-object v2

    .line 166
    :catch_0
    move-exception v0

    .local v0, "e":Ljava/lang/Exception;
    move-object v2, p0

    .line 167
    goto :goto_0
.end method

.method public static saveImage(Ljava/lang/String;[B)V
    .locals 4
    .param p0, "imagePath"    # Ljava/lang/String;
    .param p1, "buffer"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 41
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 42
    .local v0, "f":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 55
    :goto_0
    return-void

    .line 45
    :cond_0
    invoke-virtual {v0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v2

    .line 46
    .local v2, "parentFile":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v3

    if-nez v3, :cond_1

    .line 47
    invoke-virtual {v2}, Ljava/io/File;->mkdirs()Z

    .line 49
    :cond_1
    invoke-virtual {v0}, Ljava/io/File;->createNewFile()Z

    .line 50
    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, p0}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    .line 51
    .local v1, "fos":Ljava/io/FileOutputStream;
    invoke-virtual {v1, p1}, Ljava/io/FileOutputStream;->write([B)V

    .line 52
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->flush()V

    .line 53
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V

    goto :goto_0
.end method
