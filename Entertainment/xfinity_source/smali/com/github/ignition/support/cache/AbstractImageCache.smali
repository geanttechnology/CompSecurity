.class public abstract Lcom/github/ignition/support/cache/AbstractImageCache;
.super Lcom/github/ignition/support/cache/AbstractCache;
.source "AbstractImageCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<MT:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/github/ignition/support/cache/AbstractCache",
        "<",
        "Ljava/lang/String;",
        "[BTMT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;IIJI)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "initialCapacity"    # I
    .param p3, "maxSize"    # I
    .param p4, "expirationInMinutes"    # J
    .param p6, "maxConcurrentThreads"    # I

    .prologue
    .line 14
    .local p0, "this":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    invoke-direct/range {p0 .. p6}, Lcom/github/ignition/support/cache/AbstractCache;-><init>(Ljava/lang/String;IIJI)V

    .line 15
    return-void
.end method


# virtual methods
.method public abstract decodeToBitmap(Ljava/lang/Object;)Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TMT;)",
            "Landroid/graphics/Bitmap;"
        }
    .end annotation
.end method

.method public abstract getBitmap(Ljava/lang/Object;)Landroid/graphics/Bitmap;
.end method

.method public abstract getBitmapFromMemory(Ljava/lang/String;)Landroid/graphics/Bitmap;
.end method

.method public bridge synthetic getFileNameForKey(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 8
    .local p0, "this":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/github/ignition/support/cache/AbstractImageCache;->getFileNameForKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFileNameForKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 23
    .local p0, "this":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    invoke-static {p1}, Lcom/github/ignition/support/cache/CacheHelper;->getFileNameFromUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic readValueFromDisk(Ljava/io/File;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 8
    .local p0, "this":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    invoke-virtual {p0, p1}, Lcom/github/ignition/support/cache/AbstractImageCache;->readValueFromDisk(Ljava/io/File;)[B

    move-result-object v0

    return-object v0
.end method

.method protected readValueFromDisk(Ljava/io/File;)[B
    .locals 8
    .param p1, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 28
    .local p0, "this":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    new-instance v4, Ljava/io/BufferedInputStream;

    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v4, v5}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 29
    .local v4, "istream":Ljava/io/BufferedInputStream;
    invoke-virtual {p1}, Ljava/io/File;->length()J

    move-result-wide v0

    .line 30
    .local v0, "fileSize":J
    const-wide/32 v6, 0x7fffffff

    cmp-long v5, v0, v6

    if-lez v5, :cond_0

    .line 31
    new-instance v5, Ljava/io/IOException;

    const-string v6, "Cannot read files larger than 2147483647 bytes"

    invoke-direct {v5, v6}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 34
    :cond_0
    long-to-int v3, v0

    .line 36
    .local v3, "imageDataLength":I
    new-array v2, v3, [B

    .line 37
    .local v2, "imageData":[B
    const/4 v5, 0x0

    invoke-virtual {v4, v2, v5, v3}, Ljava/io/BufferedInputStream;->read([BII)I

    .line 38
    invoke-virtual {v4}, Ljava/io/BufferedInputStream;->close()V

    .line 40
    return-object v2
.end method

.method protected bridge synthetic writeValueToDisk(Ljava/io/File;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/io/File;
    .param p2, "x1"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 8
    .local p0, "this":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    check-cast p2, [B

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/github/ignition/support/cache/AbstractImageCache;->writeValueToDisk(Ljava/io/File;[B)V

    return-void
.end method

.method protected writeValueToDisk(Ljava/io/File;[B)V
    .locals 2
    .param p1, "file"    # Ljava/io/File;
    .param p2, "imageData"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 45
    .local p0, "this":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    new-instance v0, Ljava/io/BufferedOutputStream;

    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v0, v1}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 47
    .local v0, "ostream":Ljava/io/BufferedOutputStream;
    invoke-virtual {v0, p2}, Ljava/io/BufferedOutputStream;->write([B)V

    .line 49
    invoke-virtual {v0}, Ljava/io/BufferedOutputStream;->close()V

    .line 50
    return-void
.end method
