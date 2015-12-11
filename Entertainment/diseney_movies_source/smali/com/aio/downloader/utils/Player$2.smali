.class Lcom/aio/downloader/utils/Player$2;
.super Landroid/os/Handler;
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
    iput-object p1, p0, Lcom/aio/downloader/utils/Player$2;->this$0:Lcom/aio/downloader/utils/Player;

    .line 57
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 59
    iget-object v4, p0, Lcom/aio/downloader/utils/Player$2;->this$0:Lcom/aio/downloader/utils/Player;

    iget-object v4, v4, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v4}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v3

    .line 60
    .local v3, "position":I
    iget-object v4, p0, Lcom/aio/downloader/utils/Player$2;->this$0:Lcom/aio/downloader/utils/Player;

    iget-object v4, v4, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v4}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    .line 61
    .local v0, "duration":I
    if-lez v0, :cond_0

    .line 63
    iget-object v4, p0, Lcom/aio/downloader/utils/Player$2;->this$0:Lcom/aio/downloader/utils/Player;

    # getter for: Lcom/aio/downloader/utils/Player;->seekBar:Landroid/widget/SeekBar;
    invoke-static {v4}, Lcom/aio/downloader/utils/Player;->access$0(Lcom/aio/downloader/utils/Player;)Landroid/widget/SeekBar;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/SeekBar;->getMax()I

    move-result v4

    mul-int/2addr v4, v3

    div-int/2addr v4, v0

    int-to-long v1, v4

    .line 64
    .local v1, "pos":J
    iget-object v4, p0, Lcom/aio/downloader/utils/Player$2;->this$0:Lcom/aio/downloader/utils/Player;

    # getter for: Lcom/aio/downloader/utils/Player;->seekBar:Landroid/widget/SeekBar;
    invoke-static {v4}, Lcom/aio/downloader/utils/Player;->access$0(Lcom/aio/downloader/utils/Player;)Landroid/widget/SeekBar;

    move-result-object v4

    long-to-int v5, v1

    invoke-virtual {v4, v5}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 66
    .end local v1    # "pos":J
    :cond_0
    return-void
.end method
