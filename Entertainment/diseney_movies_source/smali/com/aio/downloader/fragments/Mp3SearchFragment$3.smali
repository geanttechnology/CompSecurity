.class Lcom/aio/downloader/fragments/Mp3SearchFragment$3;
.super Landroid/os/Handler;
.source "Mp3SearchFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/Mp3SearchFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Mp3SearchFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$3;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    .line 69
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 73
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 74
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 87
    :cond_0
    :goto_0
    return-void

    .line 77
    :pswitch_0
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$3;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->currenttime:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$1(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$3;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v2}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$2(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 78
    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v2

    int-to-long v2, v2

    .line 77
    invoke-static {v2, v3}, Lcom/aio/downloader/utils/Player;->formatTime(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 79
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$3;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->playbar:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$3(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    .line 80
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$3;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$2(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 82
    :catch_0
    move-exception v0

    goto :goto_0

    .line 74
    :pswitch_data_0
    .packed-switch 0x12c
        :pswitch_0
    .end packed-switch
.end method
