.class public Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;
.super Ljava/lang/Object;
.source "RemoteImageLoaderJob.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<MT:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# instance fields
.field private final imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<TMT;>;"
        }
    .end annotation
.end field

.field private final imageRequest:Lcom/squareup/okhttp/Request;

.field private final imageUrl:Ljava/lang/String;

.field private final numRetries:I

.field private final ohHttpClient:Lcom/squareup/okhttp/OkHttpClient;

.field private final remoteImageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;I)V
    .locals 2
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "remoteImageLoader"    # Lcom/github/ignition/support/images/remote/RemoteImageLoader;
    .param p4, "numRetries"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/github/ignition/support/images/remote/RemoteImageLoader;",
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<TMT;>;I)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;, "Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob<TMT;>;"
    .local p3, "imageCache":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageUrl:Ljava/lang/String;

    .line 31
    iput-object p2, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->remoteImageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    .line 32
    iput-object p3, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    .line 33
    iput p4, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->numRetries:I

    .line 34
    new-instance v1, Lcom/squareup/okhttp/OkHttpClient;

    invoke-direct {v1}, Lcom/squareup/okhttp/OkHttpClient;-><init>()V

    iput-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->ohHttpClient:Lcom/squareup/okhttp/OkHttpClient;

    .line 36
    new-instance v1, Lcom/squareup/okhttp/Request$Builder;

    invoke-direct {v1}, Lcom/squareup/okhttp/Request$Builder;-><init>()V

    invoke-virtual {v1, p1}, Lcom/squareup/okhttp/Request$Builder;->url(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;

    move-result-object v0

    .line 37
    .local v0, "builder":Lcom/squareup/okhttp/Request$Builder;
    invoke-virtual {v0}, Lcom/squareup/okhttp/Request$Builder;->build()Lcom/squareup/okhttp/Request;

    move-result-object v1

    iput-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageRequest:Lcom/squareup/okhttp/Request;

    .line 38
    return-void
.end method


# virtual methods
.method protected downloadImage()Landroid/graphics/Bitmap;
    .locals 7

    .prologue
    .line 66
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;, "Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob<TMT;>;"
    const/4 v3, 0x1

    .line 68
    .local v3, "timesTried":I
    :cond_0
    :goto_0
    iget v4, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->numRetries:I

    if-gt v3, v4, :cond_1

    .line 70
    :try_start_0
    invoke-virtual {p0}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->retrieveImageData()[B

    move-result-object v2

    .line 72
    .local v2, "imageData":[B
    if-nez v2, :cond_2

    .line 88
    .end local v2    # "imageData":[B
    :cond_1
    const/4 v4, 0x0

    :goto_1
    return-object v4

    .line 76
    .restart local v2    # "imageData":[B
    :cond_2
    iget-object v4, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    if-eqz v4, :cond_0

    .line 77
    iget-object v4, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    iget-object v5, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageUrl:Ljava/lang/String;

    invoke-virtual {v4, v5, v2}, Lcom/github/ignition/support/cache/AbstractImageCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    iget-object v4, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    iget-object v5, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageUrl:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/github/ignition/support/cache/AbstractImageCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 79
    .local v0, "cachedImageData":Ljava/lang/Object;, "TMT;"
    iget-object v4, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    invoke-virtual {v4, v0}, Lcom/github/ignition/support/cache/AbstractImageCache;->decodeToBitmap(Ljava/lang/Object;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    goto :goto_1

    .line 81
    .end local v0    # "cachedImageData":Ljava/lang/Object;, "TMT;"
    .end local v2    # "imageData":[B
    :catch_0
    move-exception v1

    .line 82
    .local v1, "e":Ljava/lang/Throwable;
    const-string v4, "Ignition/ImageLoader"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "download for "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageUrl:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " failed (attempt "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 83
    const-wide/16 v4, 0x3e8

    invoke-static {v4, v5}, Landroid/os/SystemClock;->sleep(J)V

    .line 84
    add-int/lit8 v3, v3, 0x1

    .line 85
    goto :goto_0
.end method

.method protected notifyImageLoaded(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 105
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;, "Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob<TMT;>;"
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 106
    .local v0, "data":Landroid/os/Bundle;
    const-string v2, "ign:extra_image_url"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    move-object v1, p2

    .line 108
    .local v1, "image":Landroid/graphics/Bitmap;
    const-string v2, "ign:extra_bitmap"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 110
    iget-object v2, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->remoteImageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    invoke-virtual {v2, p1, v0}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->notifyAndCleanupHandlers(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 111
    return-void
.end method

.method protected retrieveImageData()[B
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 92
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;, "Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob<TMT;>;"
    iget-object v2, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->ohHttpClient:Lcom/squareup/okhttp/OkHttpClient;

    iget-object v3, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageRequest:Lcom/squareup/okhttp/Request;

    invoke-virtual {v2, v3}, Lcom/squareup/okhttp/OkHttpClient;->newCall(Lcom/squareup/okhttp/Request;)Lcom/squareup/okhttp/Call;

    move-result-object v2

    invoke-virtual {v2}, Lcom/squareup/okhttp/Call;->execute()Lcom/squareup/okhttp/Response;

    move-result-object v0

    .line 94
    .local v0, "response":Lcom/squareup/okhttp/Response;
    invoke-virtual {v0}, Lcom/squareup/okhttp/Response;->code()I

    move-result v1

    .line 95
    .local v1, "responseCode":I
    const/16 v2, 0x12c

    if-lt v1, v2, :cond_0

    .line 96
    invoke-virtual {v0}, Lcom/squareup/okhttp/Response;->body()Lcom/squareup/okhttp/ResponseBody;

    move-result-object v2

    invoke-virtual {v2}, Lcom/squareup/okhttp/ResponseBody;->close()V

    .line 97
    new-instance v2, Ljava/io/IOException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Ignition IOException on: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\nGot: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/squareup/okhttp/Response;->message()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 100
    :cond_0
    invoke-virtual {v0}, Lcom/squareup/okhttp/Response;->body()Lcom/squareup/okhttp/ResponseBody;

    move-result-object v2

    invoke-virtual {v2}, Lcom/squareup/okhttp/ResponseBody;->bytes()[B

    move-result-object v2

    return-object v2
.end method

.method public run()V
    .locals 3

    .prologue
    .line 46
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;, "Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob<TMT;>;"
    const/4 v0, 0x0

    .line 49
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    :try_start_0
    iget-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    if-eqz v1, :cond_0

    .line 51
    iget-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    iget-object v2, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/github/ignition/support/cache/AbstractImageCache;->getBitmap(Ljava/lang/Object;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 54
    :cond_0
    if-nez v0, :cond_1

    .line 55
    invoke-virtual {p0}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->downloadImage()Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 58
    :cond_1
    iget-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageUrl:Ljava/lang/String;

    invoke-virtual {p0, v1, v0}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->notifyImageLoaded(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 61
    return-void

    .line 58
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->imageUrl:Ljava/lang/String;

    invoke-virtual {p0, v2, v0}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;->notifyImageLoaded(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    throw v1
.end method
