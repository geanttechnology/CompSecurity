.class Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$3;
.super Ljava/lang/Object;
.source "RingtoneDownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$3;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$3;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 210
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 214
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 215
    .local v0, "ringtone":Landroid/content/Intent;
    const-string v1, "ringtoneplay"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 216
    const-string v1, "ringtoneposition"

    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$3;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 217
    const-string v1, "ringtonepositiontitle"

    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$3;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 218
    const-string v1, "ringtoneposition"

    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$3;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 219
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$3;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 220
    return-void
.end method
