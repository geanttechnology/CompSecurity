.class Lcom/adobe/mediacore/TrickPlayManager$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/SeekCompletedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/TrickPlayManager;->addEventListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/TrickPlayManager;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/TrickPlayManager;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TrickPlayManager$1;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted(J)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$1;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_returningFromTrickPlay:Z
    invoke-static {v0}, Lcom/adobe/mediacore/TrickPlayManager;->access$000(Lcom/adobe/mediacore/TrickPlayManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$1;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    const/4 v1, 0x0

    # setter for: Lcom/adobe/mediacore/TrickPlayManager;->_returningFromTrickPlay:Z
    invoke-static {v0, v1}, Lcom/adobe/mediacore/TrickPlayManager;->access$002(Lcom/adobe/mediacore/TrickPlayManager;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$1;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/TrickPlayManager;->access$100(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-static {v1}, Lcom/adobe/mediacore/PlaybackRateEvent;->createRatePlayingEvent(F)Lcom/adobe/mediacore/PlaybackRateEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_0
    return-void
.end method
