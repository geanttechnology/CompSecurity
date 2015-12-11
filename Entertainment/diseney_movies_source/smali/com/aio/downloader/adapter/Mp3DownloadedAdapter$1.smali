.class Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$1;
.super Ljava/lang/Object;
.source "Mp3DownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 101
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 102
    .local v0, "timp3":Landroid/content/Intent;
    const-string v1, "mp3play"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 103
    const-string v1, "mp3positiontitle"

    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 104
    const-string v1, "mp3position"

    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 105
    const-string v1, "mp3position"

    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 107
    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 108
    return-void
.end method
