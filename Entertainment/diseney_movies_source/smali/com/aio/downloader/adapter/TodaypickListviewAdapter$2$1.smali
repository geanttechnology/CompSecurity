.class Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2$1;
.super Ljava/lang/Object;
.source "TodaypickListviewAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2$1;->this$1:Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2;

    iput-object p2, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 353
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 356
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=app&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 357
    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&from=apk"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 356
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 359
    return-void
.end method
