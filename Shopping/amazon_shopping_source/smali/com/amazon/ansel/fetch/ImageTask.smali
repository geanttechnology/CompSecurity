.class public Lcom/amazon/ansel/fetch/ImageTask;
.super Lcom/amazon/ansel/fetch/UriTask;
.source "ImageTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/ansel/fetch/UriTask",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# static fields
.field private static final decodeLock:Ljava/lang/Object;


# instance fields
.field private final imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/amazon/ansel/fetch/ImageTask;->decodeLock:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Object;JLcom/amazon/ansel/fetch/ImageRequest;)V
    .locals 6
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .param p2, "resourceKey"    # Ljava/lang/Object;
    .param p3, "priority"    # J
    .param p5, "imageRequest"    # Lcom/amazon/ansel/fetch/ImageRequest;

    .prologue
    .line 22
    invoke-virtual {p5}, Lcom/amazon/ansel/fetch/ImageRequest;->getUriRequest()Lcom/amazon/ansel/fetch/UriRequest;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-wide v3, p3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/ansel/fetch/UriTask;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Object;JLcom/amazon/ansel/fetch/UriRequest;)V

    .line 23
    iput-object p5, p0, Lcom/amazon/ansel/fetch/ImageTask;->imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    .line 24
    return-void
.end method


# virtual methods
.method public readResponse(ILjava/io/InputStream;)Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;
    .locals 6
    .param p1, "statusCode"    # I
    .param p2, "stream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/io/InputStream;",
            ")",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/ansel/fetch/LoaderException;
        }
    .end annotation

    .prologue
    .line 29
    const/4 v0, 0x0

    .line 31
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    sget-object v4, Lcom/amazon/ansel/fetch/ImageTask;->decodeLock:Ljava/lang/Object;

    monitor-enter v4

    .line 33
    :try_start_0
    invoke-static {p2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 37
    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 39
    const/4 v1, 0x0

    .line 41
    .local v1, "byteCount":I
    if-eqz v0, :cond_0

    .line 42
    invoke-static {v0}, Lcom/amazon/ansel/fetch/BitmapUtil;->getBitmapByteCount(Landroid/graphics/Bitmap;)I

    move-result v1

    .line 44
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ImageTask;->imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    invoke-virtual {v3}, Lcom/amazon/ansel/fetch/ImageRequest;->getBitmapDensity()I

    move-result v3

    if-eqz v3, :cond_0

    .line 45
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ImageTask;->imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    invoke-virtual {v3}, Lcom/amazon/ansel/fetch/ImageRequest;->getBitmapDensity()I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/graphics/Bitmap;->setDensity(I)V

    .line 49
    :cond_0
    new-instance v3, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;

    const-wide/16 v4, -0x1

    invoke-direct {v3, v0, v1, v4, v5}, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;-><init>(Ljava/lang/Object;IJ)V

    return-object v3

    .line 34
    .end local v1    # "byteCount":I
    :catch_0
    move-exception v2

    .line 35
    .local v2, "oom":Ljava/lang/OutOfMemoryError;
    :try_start_2
    new-instance v3, Lcom/amazon/ansel/fetch/LoaderException;

    invoke-direct {v3, v2}, Lcom/amazon/ansel/fetch/LoaderException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 37
    .end local v2    # "oom":Ljava/lang/OutOfMemoryError;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3
.end method
