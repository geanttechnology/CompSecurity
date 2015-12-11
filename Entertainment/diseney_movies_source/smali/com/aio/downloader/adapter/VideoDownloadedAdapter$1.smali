.class Lcom/aio/downloader/adapter/VideoDownloadedAdapter$1;
.super Ljava/lang/Object;
.source "VideoDownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/VideoDownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 101
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 105
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    iget-object v1, v1, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->ctx:Landroid/content/Context;

    const-class v2, Lcom/aio/downloader/activity/VideoViewActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 107
    .local v0, "tiplay":Landroid/content/Intent;
    const-string v1, "playurl"

    iget-object v2, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 108
    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    iget-object v1, v1, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 112
    return-void
.end method
