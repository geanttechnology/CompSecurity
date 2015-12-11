.class Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;
.super Ljava/lang/Object;
.source "DownloadTask.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/mydownload/DownloadTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DeleteClick"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/mydownload/DownloadTask;


# direct methods
.method constructor <init>(Lcom/aio/downloader/mydownload/DownloadTask;)V
    .locals 0

    .prologue
    .line 373
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 383
    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->onDeleteTaskListener:Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$4(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 384
    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->onDeleteTaskListener:Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$4(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v3}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-interface {v1, v2, v3, v4}, Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;->onDelete(Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;Ljava/lang/Boolean;)V

    .line 386
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "pdt_del"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 387
    .local v0, "intentpdt_del":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 388
    return-void
.end method
