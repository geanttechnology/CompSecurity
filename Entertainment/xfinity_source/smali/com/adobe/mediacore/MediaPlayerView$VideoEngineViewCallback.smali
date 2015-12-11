.class Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "VideoEngineViewCallback"
.end annotation


# instance fields
.field private _hasSurface:Z

.field private _viewHolder:Landroid/view/SurfaceHolder;

.field private _viewHolderCallback:Landroid/view/SurfaceHolder$Callback;

.field final synthetic this$0:Lcom/adobe/mediacore/MediaPlayerView;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerView;Landroid/view/SurfaceView;)V
    .locals 2

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->this$0:Lcom/adobe/mediacore/MediaPlayerView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_hasSurface:Z

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback$1;-><init>(Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolderCallback:Landroid/view/SurfaceHolder$Callback;

    if-eqz p2, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolder:Landroid/view/SurfaceHolder;

    if-nez v0, :cond_0

    invoke-virtual {p2}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolder:Landroid/view/SurfaceHolder;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolder:Landroid/view/SurfaceHolder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolder:Landroid/view/SurfaceHolder;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolderCallback:Landroid/view/SurfaceHolder$Callback;

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    :cond_0
    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->release()V

    return-void
.end method

.method static synthetic access$302(Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_hasSurface:Z

    return p1
.end method

.method private release()V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolder:Landroid/view/SurfaceHolder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolder:Landroid/view/SurfaceHolder;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolderCallback:Landroid/view/SurfaceHolder$Callback;

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->removeCallback(Landroid/view/SurfaceHolder$Callback;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_viewHolder:Landroid/view/SurfaceHolder;

    :cond_0
    return-void
.end method


# virtual methods
.method public hasSurface()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->_hasSurface:Z

    return v0
.end method
