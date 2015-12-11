.class Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback$1;->this$1:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 0

    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 3

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

    const-string v2, "#surfaceCreated"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Media player surface was created."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback$1;->this$1:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    const/4 v1, 0x1

    # setter for: Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_hasSurface:Z
    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->access$302(Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback$1;->this$1:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    iget-object v0, v0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->this$0:Lcom/adobe/mediacore/MediaPlayerView;

    # invokes: Lcom/adobe/mediacore/MediaPlayerView;->restorePlayer()V
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerView;->access$400(Lcom/adobe/mediacore/MediaPlayerView;)V

    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 3

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

    const-string v2, "#surfaceDestroyed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Media player surface was destroyed."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback$1;->this$1:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    const/4 v1, 0x0

    # setter for: Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_hasSurface:Z
    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->access$302(Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback$1;->this$1:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    iget-object v0, v0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->this$0:Lcom/adobe/mediacore/MediaPlayerView;

    # invokes: Lcom/adobe/mediacore/MediaPlayerView;->suspendPlayer()V
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerView;->access$500(Lcom/adobe/mediacore/MediaPlayerView;)V

    return-void
.end method
