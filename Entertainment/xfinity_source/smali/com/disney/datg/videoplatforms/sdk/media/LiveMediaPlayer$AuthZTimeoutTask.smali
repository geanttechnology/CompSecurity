.class Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$AuthZTimeoutTask;
.super Ljava/util/TimerTask;
.source "LiveMediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "AuthZTimeoutTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$AuthZTimeoutTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$AuthZTimeoutTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->authTimerDone()V
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;)V

    .line 36
    return-void
.end method
