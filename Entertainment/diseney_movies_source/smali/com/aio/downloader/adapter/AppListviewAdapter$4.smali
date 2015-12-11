.class Lcom/aio/downloader/adapter/AppListviewAdapter$4;
.super Ljava/lang/Object;
.source "AppListviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppListviewAdapter;->popuWindow(ILjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

.field private final synthetic val$myPosition:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppListviewAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->val$myPosition:I

    .line 612
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/AppListviewAdapter$4;)Lcom/aio/downloader/adapter/AppListviewAdapter;
    .locals 1

    .prologue
    .line 612
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 618
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "Share: http://android.downloadatoz.com/apps/"

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$8(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->val$myPosition:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$8(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->val$myPosition:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".html"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 619
    .local v1, "share_t":Ljava/lang/String;
    const-string v2, "location"

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 620
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 621
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "text/plain"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 622
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 623
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v2

    const-string v3, "AIO Downloaded"

    invoke-static {v0, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 625
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    new-instance v3, Lcom/aio/downloader/adapter/AppListviewAdapter$4$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/adapter/AppListviewAdapter$4$1;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter$4;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 634
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v2

    const-string v3, "share"

    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 635
    return-void
.end method
