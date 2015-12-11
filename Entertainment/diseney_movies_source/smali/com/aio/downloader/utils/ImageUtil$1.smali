.class Lcom/aio/downloader/utils/ImageUtil$1;
.super Landroid/os/Handler;
.source "ImageUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/utils/ImageUtil;->loadImage(Ljava/lang/String;Ljava/lang/String;Lcom/aio/downloader/utils/ImageUtil$ImageCallback;I)Landroid/graphics/Bitmap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$callback:Lcom/aio/downloader/utils/ImageUtil$ImageCallback;

.field private final synthetic val$imagePath:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/utils/ImageUtil$ImageCallback;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/utils/ImageUtil$1;->val$callback:Lcom/aio/downloader/utils/ImageUtil$ImageCallback;

    iput-object p2, p0, Lcom/aio/downloader/utils/ImageUtil$1;->val$imagePath:Ljava/lang/String;

    .line 91
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 5
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 94
    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    if-eqz v3, :cond_0

    .line 95
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/graphics/Bitmap;

    .line 96
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    iget-object v3, p0, Lcom/aio/downloader/utils/ImageUtil$1;->val$callback:Lcom/aio/downloader/utils/ImageUtil$ImageCallback;

    iget-object v4, p0, Lcom/aio/downloader/utils/ImageUtil$1;->val$imagePath:Ljava/lang/String;

    invoke-interface {v3, v0, v4}, Lcom/aio/downloader/utils/ImageUtil$ImageCallback;->loadImage(Landroid/graphics/Bitmap;Ljava/lang/String;)V

    .line 98
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/utils/ImageUtil$1;->val$imagePath:Ljava/lang/String;

    invoke-static {v0}, Lcom/aio/downloader/utils/ImageUtil;->Bitmap2Bytes(Landroid/graphics/Bitmap;)[B

    move-result-object v4

    invoke-static {v3, v4}, Lcom/aio/downloader/utils/ImageUtil;->saveImage(Ljava/lang/String;[B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 104
    :goto_0
    invoke-static {v0}, Lcom/aio/downloader/utils/ImageUtil;->Bitmap2Bytes(Landroid/graphics/Bitmap;)[B

    move-result-object v1

    .line 106
    .local v1, "buffer":[B
    :try_start_1
    iget-object v3, p0, Lcom/aio/downloader/utils/ImageUtil$1;->val$imagePath:Ljava/lang/String;

    invoke-static {v3, v1}, Lcom/aio/downloader/utils/ImageUtil;->saveImage(Ljava/lang/String;[B)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 112
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "buffer":[B
    :cond_0
    :goto_1
    return-void

    .line 99
    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    :catch_0
    move-exception v2

    .line 101
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 107
    .end local v2    # "e":Ljava/io/IOException;
    .restart local v1    # "buffer":[B
    :catch_1
    move-exception v2

    .line 109
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method
