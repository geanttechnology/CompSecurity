.class Lcom/aio/downloader/fragments/BackedUpFragment$3;
.super Ljava/util/TimerTask;
.source "BackedUpFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/BackedUpFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$3;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    .line 101
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 106
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 107
    .local v0, "msg":Landroid/os/Message;
    const/16 v1, 0x64

    iput v1, v0, Landroid/os/Message;->what:I

    .line 108
    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$3;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->hander:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$7(Lcom/aio/downloader/fragments/BackedUpFragment;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 110
    return-void
.end method
