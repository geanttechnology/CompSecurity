.class Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;
.super Ljava/lang/Object;
.source "Home_Gridview_Adapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->popuWindow(ILjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

.field private final synthetic val$myPosition:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    iput p2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;->val$myPosition:I

    .line 738
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;)Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
    .locals 1

    .prologue
    .line 738
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 745
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v2

    const-string v3, "share"

    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 746
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "Share: http://android.downloadatoz.com/apps/"

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 748
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;->val$myPosition:I

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

    .line 749
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;->val$myPosition:I

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

    .line 746
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 750
    .local v1, "share_t":Ljava/lang/String;
    const-string v2, "location"

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 751
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 752
    .local v0, "intent_share":Landroid/content/Intent;
    const-string v2, "text/plain"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 753
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 754
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v2

    .line 755
    const-string v3, "AIO Downloaded"

    .line 754
    invoke-static {v0, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    .line 756
    const/high16 v4, 0x10000000

    .line 755
    invoke-virtual {v3, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v3

    .line 754
    invoke-virtual {v2, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 757
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    new-instance v3, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8$1;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 766
    return-void
.end method
