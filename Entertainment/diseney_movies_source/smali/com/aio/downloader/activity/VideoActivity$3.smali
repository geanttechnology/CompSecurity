.class Lcom/aio/downloader/activity/VideoActivity$3;
.super Ljava/lang/Object;
.source "VideoActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/VideoActivity;->dowload_video(Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoActivity;

.field private final synthetic val$list:Ljava/util/ArrayList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$3;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/VideoActivity$3;->val$list:Ljava/util/ArrayList;

    .line 470
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 473
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v6, p0, Lcom/aio/downloader/activity/VideoActivity$3;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-lt v2, v6, :cond_0

    .line 491
    return-void

    .line 475
    :cond_0
    :try_start_0
    new-instance v5, Ljava/net/URL;

    iget-object v6, p0, Lcom/aio/downloader/activity/VideoActivity$3;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v6, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/aio/downloader/model/VideoModel;

    invoke-virtual {v6}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_url()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 476
    .local v5, "u":Ljava/net/URL;
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 477
    .local v0, "conn":Ljava/net/HttpURLConnection;
    const-string v6, "Accept-Encoding"

    const-string v7, "identity"

    invoke-virtual {v0, v6, v7}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 478
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V

    .line 479
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContentLength()I

    move-result v7

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 480
    .local v4, "s":Ljava/lang/String;
    const-string v7, "sss"

    new-instance v8, Ljava/lang/StringBuilder;

    iget-object v6, p0, Lcom/aio/downloader/activity/VideoActivity$3;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v6, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/aio/downloader/model/VideoModel;

    invoke-virtual {v6}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_url()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v8, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, ":"

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v7, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 481
    iget-object v6, p0, Lcom/aio/downloader/activity/VideoActivity$3;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v6, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/aio/downloader/model/VideoModel;

    invoke-virtual {v6, v4}, Lcom/aio/downloader/model/VideoModel;->setVideo_item_size(Ljava/lang/String;)V

    .line 482
    new-instance v3, Landroid/os/Message;

    invoke-direct {v3}, Landroid/os/Message;-><init>()V

    .line 483
    .local v3, "msg":Landroid/os/Message;
    const/4 v6, 0x3

    iput v6, v3, Landroid/os/Message;->what:I

    .line 484
    iget-object v6, p0, Lcom/aio/downloader/activity/VideoActivity$3;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    iget-object v6, v6, Lcom/aio/downloader/activity/VideoActivity;->hander:Landroid/os/Handler;

    invoke-virtual {v6, v3}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 473
    .end local v0    # "conn":Ljava/net/HttpURLConnection;
    .end local v3    # "msg":Landroid/os/Message;
    .end local v4    # "s":Ljava/lang/String;
    .end local v5    # "u":Ljava/net/URL;
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 486
    :catch_0
    move-exception v1

    .line 488
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method
