.class Lcom/aio/downloader/fragments/BackedUpFragment$1;
.super Landroid/os/Handler;
.source "BackedUpFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/BackedUpFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/BackedUpFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    .line 50
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 53
    iget v0, p1, Landroid/os/Message;->what:I

    sparse-switch v0, :sswitch_data_0

    .line 79
    :goto_0
    return-void

    .line 55
    :sswitch_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    new-instance v1, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    invoke-direct {v1, v2}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;-><init>(Lcom/aio/downloader/fragments/BackedUpFragment;)V

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment;Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)V

    .line 60
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->lv_uninstall:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$1(Lcom/aio/downloader/fragments/BackedUpFragment;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->ma:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpFragment;)Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    goto :goto_0

    .line 70
    :sswitch_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$3(Lcom/aio/downloader/fragments/BackedUpFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 71
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->ll_downnull:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$4(Lcom/aio/downloader/fragments/BackedUpFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 73
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$1;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->ll_downnull:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$4(Lcom/aio/downloader/fragments/BackedUpFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 53
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x64 -> :sswitch_1
    .end sparse-switch
.end method
