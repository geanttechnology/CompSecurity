.class Lcom/aio/downloader/adapter/AppListviewAdapter$5;
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
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$5;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$5;->val$myPosition:I

    .line 637
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/AppListviewAdapter$5;)Lcom/aio/downloader/adapter/AppListviewAdapter;
    .locals 1

    .prologue
    .line 637
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$5;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 642
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$5;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 644
    .local v0, "ti":Landroid/content/Intent;
    const-string v2, "myid"

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$5;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$8(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$5;->val$myPosition:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 645
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 647
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$5;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 648
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    new-instance v2, Lcom/aio/downloader/adapter/AppListviewAdapter$5$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/AppListviewAdapter$5$1;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter$5;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 656
    return-void
.end method
