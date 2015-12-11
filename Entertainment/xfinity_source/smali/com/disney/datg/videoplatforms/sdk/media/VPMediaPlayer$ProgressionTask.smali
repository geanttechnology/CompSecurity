.class Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$ProgressionTask;
.super Ljava/util/TimerTask;
.source "VPMediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ProgressionTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;)V
    .locals 0

    .prologue
    .line 1274
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1277
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1278
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->PING:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 1280
    :cond_0
    return-void
.end method
