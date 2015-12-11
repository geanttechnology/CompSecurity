.class Lcom/aio/downloader/utils/ImageUtil$2;
.super Ljava/lang/Object;
.source "ImageUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/utils/ImageUtil;->loadImage(Ljava/lang/String;Ljava/lang/String;Lcom/aio/downloader/utils/ImageUtil$ImageCallback;I)Landroid/graphics/Bitmap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$handler:Landroid/os/Handler;

.field private final synthetic val$imagePath:Ljava/lang/String;

.field private final synthetic val$imgUrl:Ljava/lang/String;

.field private final synthetic val$opInSampleSize:I


# direct methods
.method constructor <init>(Ljava/lang/String;ILjava/lang/String;Landroid/os/Handler;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/utils/ImageUtil$2;->val$imgUrl:Ljava/lang/String;

    iput p2, p0, Lcom/aio/downloader/utils/ImageUtil$2;->val$opInSampleSize:I

    iput-object p3, p0, Lcom/aio/downloader/utils/ImageUtil$2;->val$imagePath:Ljava/lang/String;

    iput-object p4, p0, Lcom/aio/downloader/utils/ImageUtil$2;->val$handler:Landroid/os/Handler;

    .line 115
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 118
    :try_start_0
    new-instance v6, Ljava/net/URL;

    iget-object v7, p0, Lcom/aio/downloader/utils/ImageUtil$2;->val$imgUrl:Ljava/lang/String;

    invoke-direct {v6, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 119
    .local v6, "url":Ljava/net/URL;
    invoke-virtual {v6}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v1

    .line 121
    .local v1, "conn":Ljava/net/URLConnection;
    const/4 v7, 0x1

    invoke-virtual {v1, v7}, Ljava/net/URLConnection;->setDoInput(Z)V

    .line 122
    invoke-virtual {v1}, Ljava/net/URLConnection;->connect()V

    .line 123
    invoke-virtual {v1}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    .line 124
    .local v3, "inputStream":Ljava/io/InputStream;
    new-instance v5, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v5}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 125
    .local v5, "opts":Landroid/graphics/BitmapFactory$Options;
    const/4 v7, 0x0

    iput-boolean v7, v5, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 126
    iget v7, p0, Lcom/aio/downloader/utils/ImageUtil$2;->val$opInSampleSize:I

    iput v7, v5, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 127
    const/4 v7, 0x0

    invoke-static {v3, v7, v5}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 128
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    sget-object v7, Lcom/aio/downloader/utils/ImageUtil;->cache:Landroid/support/v4/util/LruCache;

    iget-object v8, p0, Lcom/aio/downloader/utils/ImageUtil$2;->val$imagePath:Ljava/lang/String;

    invoke-virtual {v7, v8, v0}, Landroid/support/v4/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 135
    iget-object v7, p0, Lcom/aio/downloader/utils/ImageUtil$2;->val$handler:Landroid/os/Handler;

    invoke-virtual {v7}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v4

    .line 136
    .local v4, "msg":Landroid/os/Message;
    iput-object v0, v4, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 137
    iget-object v7, p0, Lcom/aio/downloader/utils/ImageUtil$2;->val$handler:Landroid/os/Handler;

    invoke-virtual {v7, v4}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 141
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "conn":Ljava/net/URLConnection;
    .end local v3    # "inputStream":Ljava/io/InputStream;
    .end local v4    # "msg":Landroid/os/Message;
    .end local v5    # "opts":Landroid/graphics/BitmapFactory$Options;
    .end local v6    # "url":Ljava/net/URL;
    :goto_0
    return-void

    .line 138
    :catch_0
    move-exception v2

    .line 139
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method
