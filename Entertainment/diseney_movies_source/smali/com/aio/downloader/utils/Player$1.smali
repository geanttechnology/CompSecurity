.class Lcom/aio/downloader/utils/Player$1;
.super Ljava/util/TimerTask;
.source "Player.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/utils/Player;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/utils/Player;


# direct methods
.method constructor <init>(Lcom/aio/downloader/utils/Player;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/utils/Player$1;->this$0:Lcom/aio/downloader/utils/Player;

    .line 45
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 49
    iget-object v0, p0, Lcom/aio/downloader/utils/Player$1;->this$0:Lcom/aio/downloader/utils/Player;

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    if-nez v0, :cond_1

    .line 54
    :cond_0
    :goto_0
    return-void

    .line 51
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/utils/Player$1;->this$0:Lcom/aio/downloader/utils/Player;

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/utils/Player$1;->this$0:Lcom/aio/downloader/utils/Player;

    # getter for: Lcom/aio/downloader/utils/Player;->seekBar:Landroid/widget/SeekBar;
    invoke-static {v0}, Lcom/aio/downloader/utils/Player;->access$0(Lcom/aio/downloader/utils/Player;)Landroid/widget/SeekBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/SeekBar;->isPressed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/aio/downloader/utils/Player$1;->this$0:Lcom/aio/downloader/utils/Player;

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->handler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_0
.end method
