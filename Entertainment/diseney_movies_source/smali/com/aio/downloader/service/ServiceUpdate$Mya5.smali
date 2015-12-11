.class Lcom/aio/downloader/service/ServiceUpdate$Mya5;
.super Landroid/os/AsyncTask;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/service/ServiceUpdate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Mya5"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private icon_pick1:Ljava/lang/String;

.field private img_pick:Ljava/lang/String;

.field private short_desc1:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/service/ServiceUpdate;

.field private title_pick1:Ljava/lang/String;

.field private url1:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate;)V
    .locals 0

    .prologue
    .line 1302
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method private ShowResult6(Ljava/lang/String;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 1334
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parsetodaypick(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1335
    const-string v2, "lpl"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "list_pick="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1337
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$1(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1338
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$2(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1339
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getShort_desc()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$3(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1340
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->img_pick:Ljava/lang/String;

    .line 1341
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$5(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1343
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->icon_pick1:Ljava/lang/String;

    .line 1344
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->title_pick1:Ljava/lang/String;

    .line 1345
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getShort_desc()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->short_desc1:Ljava/lang/String;

    .line 1346
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v4, 0x1

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$9(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1352
    :goto_0
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 1353
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;-><init>(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)V

    .line 1376
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0x7530

    const-wide/32 v4, 0xea60

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 1378
    return-void

    .line 1348
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1304
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->icon_pick1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1305
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->title_pick1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1306
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->short_desc1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1307
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->img_pick:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Lcom/aio/downloader/service/ServiceUpdate;
    .locals 1

    .prologue
    .line 1302
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 2
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 1317
    const-string v1, "http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=1"

    iput-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->url1:Ljava/lang/String;

    .line 1319
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->url1:Ljava/lang/String;

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1320
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 1325
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 1326
    if-nez p1, :cond_0

    .line 1331
    :goto_0
    return-void

    .line 1329
    :cond_0
    const-string v0, "asd"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "result="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1330
    invoke-direct {p0, p1}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->ShowResult6(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 1311
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 1312
    return-void
.end method
