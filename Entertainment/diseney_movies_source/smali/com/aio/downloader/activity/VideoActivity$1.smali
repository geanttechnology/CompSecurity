.class Lcom/aio/downloader/activity/VideoActivity$1;
.super Landroid/os/Handler;
.source "VideoActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/VideoActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$1;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    .line 68
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v2, 0x0

    const/16 v1, 0x8

    .line 73
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 74
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 92
    :goto_0
    return-void

    .line 76
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$1;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->videodownloader:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$0(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 77
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$1;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->videodownloader2:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$1(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 78
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$1;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->tvloading:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$2(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 79
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$1;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$3(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    goto :goto_0

    .line 84
    :pswitch_1
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$1;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->videodownloader2:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$1(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 85
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$1;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->videodownloader:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$0(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_0

    .line 89
    :pswitch_2
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$1;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->adapter:Lcom/aio/downloader/adapter/VideoListviewAdapter;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$4(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/adapter/VideoListviewAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/VideoListviewAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 74
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
