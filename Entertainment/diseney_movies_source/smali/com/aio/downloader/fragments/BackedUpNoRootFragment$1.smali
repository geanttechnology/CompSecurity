.class Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;
.super Landroid/os/Handler;
.source "BackedUpNoRootFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    .line 45
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 50
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 51
    iget v0, p1, Landroid/os/Message;->what:I

    const/16 v1, 0x64

    if-ne v0, v1, :cond_1

    .line 53
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Lcom/aio/downloader/db/TypeDbUtilsBackup;

    move-result-object v1

    const-string v2, "game_app"

    const-string v3, "timesort"

    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/db/TypeDbUtilsBackup;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$1(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;Ljava/util/List;)V

    .line 54
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    .line 55
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$1(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;Ljava/util/List;)V

    .line 57
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    new-instance v1, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    invoke-direct {v1, v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;-><init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)V

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$3(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)V

    .line 58
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->lv_uninstall:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$4(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->musicListAdapter:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$5(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 59
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 60
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->ll_downnull:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$6(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 61
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->lv_uninstall:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$4(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Landroid/widget/ListView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 71
    :cond_1
    :goto_0
    return-void

    .line 63
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->ll_downnull:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$6(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 64
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->lv_uninstall:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$4(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Landroid/widget/ListView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 66
    :catch_0
    move-exception v0

    goto :goto_0
.end method
