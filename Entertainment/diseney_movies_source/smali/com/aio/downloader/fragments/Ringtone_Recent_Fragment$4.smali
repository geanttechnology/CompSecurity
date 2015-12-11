.class Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$4;
.super Landroid/content/BroadcastReceiver;
.source "Ringtone_Recent_Fragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$4;->this$0:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;

    .line 127
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 130
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$4;->this$0:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;->totaltime:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;->access$4(Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$4;->this$0:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v2}, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;->access$2(Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 131
    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v2

    int-to-long v2, v2

    .line 130
    invoke-static {v2, v3}, Lcom/aio/downloader/utils/Player;->formatTime(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 132
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$4;->this$0:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;

    iget-object v1, p0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$4;->this$0:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;->access$2(Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v1

    iput v1, v0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;->mytotaltime:I

    .line 133
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$4;->this$0:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;

    invoke-virtual {v0}, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/FragmentActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 134
    return-void
.end method
