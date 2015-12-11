.class Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$3;
.super Landroid/os/Handler;
.source "Ringtone_Popular_Fragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$3;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    .line 108
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 112
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 113
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 126
    :cond_0
    :goto_0
    return-void

    .line 116
    :pswitch_0
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$3;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->currenttime:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$1(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$3;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v2}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$2(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 117
    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v2

    int-to-long v2, v2

    .line 116
    invoke-static {v2, v3}, Lcom/aio/downloader/utils/Player;->formatTime(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 118
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$3;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->playbar:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$3(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    .line 119
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$3;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$2(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 121
    :catch_0
    move-exception v0

    goto :goto_0

    .line 113
    :pswitch_data_0
    .packed-switch 0x1f4
        :pswitch_0
    .end packed-switch
.end method
