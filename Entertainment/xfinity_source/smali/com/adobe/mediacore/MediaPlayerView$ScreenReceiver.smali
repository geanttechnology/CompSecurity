.class Lcom/adobe/mediacore/MediaPlayerView$ScreenReceiver;
.super Landroid/content/BroadcastReceiver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ScreenReceiver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/MediaPlayerView;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/MediaPlayerView;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerView$ScreenReceiver;->this$0:Lcom/adobe/mediacore/MediaPlayerView;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.intent.action.SCREEN_OFF"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    # getter for: Lcom/adobe/mediacore/MediaPlayerView;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerView;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerView;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerView;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "::ScreenReceiver#onReceive"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Device screen was turned off."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$ScreenReceiver;->this$0:Lcom/adobe/mediacore/MediaPlayerView;

    # invokes: Lcom/adobe/mediacore/MediaPlayerView;->suspendPlayer()V
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerView;->access$500(Lcom/adobe/mediacore/MediaPlayerView;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.intent.action.SCREEN_ON"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    # getter for: Lcom/adobe/mediacore/MediaPlayerView;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerView;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerView;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerView;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "::ScreenReceiver#onReceive"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Device screen was turned on."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$ScreenReceiver;->this$0:Lcom/adobe/mediacore/MediaPlayerView;

    # invokes: Lcom/adobe/mediacore/MediaPlayerView;->restorePlayer()V
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerView;->access$400(Lcom/adobe/mediacore/MediaPlayerView;)V

    goto :goto_0
.end method
