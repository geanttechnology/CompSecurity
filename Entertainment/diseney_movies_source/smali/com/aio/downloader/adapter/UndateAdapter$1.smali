.class Lcom/aio/downloader/adapter/UndateAdapter$1;
.super Ljava/lang/Object;
.source "UndateAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/UndateAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/UndateAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/UndateAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->this$0:Lcom/aio/downloader/adapter/UndateAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->val$position:I

    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 124
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->this$0:Lcom/aio/downloader/adapter/UndateAdapter;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/UndateAdapter;->access$0(Lcom/aio/downloader/adapter/UndateAdapter;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 125
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "myid"

    iget-object v1, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->this$0:Lcom/aio/downloader/adapter/UndateAdapter;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/UndateAdapter;->access$1(Lcom/aio/downloader/adapter/UndateAdapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->val$position:I

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 126
    const-string v2, "linkurl"

    iget-object v1, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->this$0:Lcom/aio/downloader/adapter/UndateAdapter;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/UndateAdapter;->access$1(Lcom/aio/downloader/adapter/UndateAdapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->val$position:I

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 127
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getLink_url()Ljava/lang/String;

    move-result-object v1

    .line 126
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 128
    const-string v2, "myupver"

    iget-object v1, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->this$0:Lcom/aio/downloader/adapter/UndateAdapter;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/UndateAdapter;->access$1(Lcom/aio/downloader/adapter/UndateAdapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->val$position:I

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 129
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getVersion()Ljava/lang/String;

    move-result-object v1

    .line 128
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 130
    const-string v1, "wocao"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 131
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 132
    iget-object v1, p0, Lcom/aio/downloader/adapter/UndateAdapter$1;->this$0:Lcom/aio/downloader/adapter/UndateAdapter;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/UndateAdapter;->access$0(Lcom/aio/downloader/adapter/UndateAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 133
    return-void
.end method
