.class Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$1;
.super Ljava/lang/Object;
.source "Home_Gridview_Adapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;

.field private final synthetic val$myPosition:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$1;->this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;

    iput p2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$1;->val$myPosition:I

    .line 668
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 671
    const-string v1, "bbb"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v0, "http://android.downloadatoz.com/_201409/market/hits.php?type=app&id="

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 672
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$1;->this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;)Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    move-result-object v0

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v0

    iget v3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$1;->val$myPosition:I

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 673
    const-string v2, "&from=apk"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 671
    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 674
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v0, "http://android.downloadatoz.com/_201409/market/hits.php?type=app&id="

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 675
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$1;->this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;)Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    move-result-object v0

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v0

    iget v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$1;->val$myPosition:I

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 676
    const-string v1, "&from=apk"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 674
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 677
    return-void
.end method
