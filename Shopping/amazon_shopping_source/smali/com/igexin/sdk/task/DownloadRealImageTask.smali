.class public Lcom/igexin/sdk/task/DownloadRealImageTask;
.super Lcom/igexin/sdk/task/HttpTask;
.source "DownloadRealImageTask.java"


# instance fields
.field private actionId:Ljava/lang/String;

.field private callbackListener:Lcom/igexin/sdk/CallbackListener;

.field private taskId:Ljava/lang/String;

.field private type:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/igexin/sdk/CallbackListener;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "taskId"    # Ljava/lang/String;
    .param p3, "actionId"    # Ljava/lang/String;
    .param p4, "type"    # I
    .param p5, "callbackListener"    # Lcom/igexin/sdk/CallbackListener;

    .prologue
    .line 24
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p5}, Lcom/igexin/sdk/task/HttpTask;-><init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;)V

    .line 25
    iput p4, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->type:I

    .line 26
    iput-object p2, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->taskId:Ljava/lang/String;

    .line 27
    iput-object p3, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->actionId:Ljava/lang/String;

    .line 28
    iput-object p5, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    .line 29
    return-void
.end method

.method private downloadDir(Ljava/lang/String;)V
    .locals 4
    .param p1, "imgdir"    # Ljava/lang/String;

    .prologue
    .line 59
    new-instance v0, Ljava/io/File;

    sget-object v2, Lcom/igexin/sdk/Consts;->IMGPATHDIR:Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 60
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 61
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 62
    :cond_0
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/igexin/sdk/Consts;->IMGPATHDIR:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 63
    .local v1, "files":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_1

    .line 64
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    .line 65
    :cond_1
    return-void
.end method


# virtual methods
.method public parseData([B)V
    .locals 8
    .param p1, "data"    # [B

    .prologue
    .line 33
    iget-object v5, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->taskId:Ljava/lang/String;

    invoke-direct {p0, v5}, Lcom/igexin/sdk/task/DownloadRealImageTask;->downloadDir(Ljava/lang/String;)V

    .line 34
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/igexin/sdk/Consts;->IMGPATHDIR:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->taskId:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->actionId:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v5, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->type:I

    const/4 v7, 0x1

    if-ne v5, v7, :cond_0

    const-string/jumbo v5, ""

    :goto_0
    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ".png"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 37
    .local v2, "img_src":Ljava/lang/String;
    :try_start_0
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    .line 38
    .local v4, "localFileOutputStream":Ljava/io/FileOutputStream;
    sget-object v3, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    .line 39
    .local v3, "localCompressFormat":Landroid/graphics/Bitmap$CompressFormat;
    const/4 v5, 0x0

    array-length v6, p1

    invoke-static {p1, v5, v6}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 41
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_1

    .line 43
    const/16 v5, 0x64

    invoke-virtual {v0, v3, v5, v4}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 44
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 46
    iget-object v5, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    invoke-interface {v5, v2}, Lcom/igexin/sdk/CallbackListener;->getCallbackData(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 56
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v3    # "localCompressFormat":Landroid/graphics/Bitmap$CompressFormat;
    .end local v4    # "localFileOutputStream":Ljava/io/FileOutputStream;
    :goto_1
    return-void

    .line 34
    .end local v2    # "img_src":Ljava/lang/String;
    :cond_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "_"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v7, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->type:I

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 48
    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    .restart local v2    # "img_src":Ljava/lang/String;
    .restart local v3    # "localCompressFormat":Landroid/graphics/Bitmap$CompressFormat;
    .restart local v4    # "localFileOutputStream":Ljava/io/FileOutputStream;
    :cond_1
    :try_start_1
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 49
    iget-object v5, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    const-string/jumbo v6, ""

    invoke-interface {v5, v6}, Lcom/igexin/sdk/CallbackListener;->getCallbackData(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 52
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v3    # "localCompressFormat":Landroid/graphics/Bitmap$CompressFormat;
    .end local v4    # "localFileOutputStream":Ljava/io/FileOutputStream;
    :catch_0
    move-exception v1

    .line 53
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 54
    iget-object v5, p0, Lcom/igexin/sdk/task/DownloadRealImageTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    const-string/jumbo v6, ""

    invoke-interface {v5, v6}, Lcom/igexin/sdk/CallbackListener;->getCallbackData(Ljava/lang/Object;)V

    goto :goto_1
.end method
