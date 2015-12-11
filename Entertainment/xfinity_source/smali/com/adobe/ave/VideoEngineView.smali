.class public Lcom/adobe/ave/VideoEngineView;
.super Landroid/view/SurfaceView;
.source "VideoEngineView.java"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;


# static fields
.field static final TAG:Ljava/lang/String; = "VideoEngineView(j)"


# instance fields
.field mHolder:Landroid/view/SurfaceHolder;

.field private mLockedCanvas:Landroid/graphics/Canvas;

.field private m_nativeInstance:J

.field private m_surface:Landroid/view/Surface;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 59
    invoke-direct {p0, p1}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    .line 44
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    .line 55
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/ave/VideoEngineView;->m_surface:Landroid/view/Surface;

    .line 61
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x11

    if-lt v0, v1, :cond_0

    .line 62
    const/4 v0, 0x1

    invoke-super {p0, v0}, Landroid/view/SurfaceView;->setSecure(Z)V

    .line 64
    :cond_0
    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/ave/VideoEngineView;->mHolder:Landroid/view/SurfaceHolder;

    .line 66
    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->useOverlay()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 67
    iget-object v0, p0, Lcom/adobe/ave/VideoEngineView;->mHolder:Landroid/view/SurfaceHolder;

    const v1, 0x32315659

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setFormat(I)V

    .line 71
    :goto_0
    iget-object v0, p0, Lcom/adobe/ave/VideoEngineView;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 72
    return-void

    .line 69
    :cond_1
    iget-object v0, p0, Lcom/adobe/ave/VideoEngineView;->mHolder:Landroid/view/SurfaceHolder;

    const/4 v1, 0x4

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setFormat(I)V

    goto :goto_0
.end method

.method private getSurface()Landroid/view/Surface;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/adobe/ave/VideoEngineView;->m_surface:Landroid/view/Surface;

    return-object v0
.end method

.method private lockCanvas(IIII)V
    .locals 2
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 137
    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->useOverlay()Z

    move-result v1

    if-nez v1, :cond_0

    .line 139
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0, p1, p2, p3, p4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 140
    .local v0, "rect":Landroid/graphics/Rect;
    iget-object v1, p0, Lcom/adobe/ave/VideoEngineView;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v1, v0}, Landroid/view/SurfaceHolder;->lockCanvas(Landroid/graphics/Rect;)Landroid/graphics/Canvas;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/ave/VideoEngineView;->mLockedCanvas:Landroid/graphics/Canvas;

    .line 142
    .end local v0    # "rect":Landroid/graphics/Rect;
    :cond_0
    return-void
.end method

.method private native nativeDrawBitmapToCanvas(JLandroid/graphics/Canvas;)V
.end method

.method private native nativeSurfaceChanged(JII)V
.end method

.method private native nativeSurfaceCreated(JII)V
.end method

.method private native nativeSurfaceDestroyed(J)V
.end method

.method private unlockCanvas()V
    .locals 2

    .prologue
    .line 149
    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->useOverlay()Z

    move-result v0

    if-nez v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/adobe/ave/VideoEngineView;->mHolder:Landroid/view/SurfaceHolder;

    iget-object v1, p0, Lcom/adobe/ave/VideoEngineView;->mLockedCanvas:Landroid/graphics/Canvas;

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V

    .line 153
    :cond_0
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 188
    invoke-super {p0, p1}, Landroid/view/SurfaceView;->onDraw(Landroid/graphics/Canvas;)V

    .line 190
    iget-wide v0, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 191
    iget-wide v0, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    invoke-direct {p0, v0, v1, p1}, Lcom/adobe/ave/VideoEngineView;->nativeDrawBitmapToCanvas(JLandroid/graphics/Canvas;)V

    .line 192
    :cond_0
    return-void
.end method

.method public setNativeInstance(J)V
    .locals 1
    .param p1, "inNativeInstance"    # J

    .prologue
    .line 122
    iput-wide p1, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    .line 123
    return-void
.end method

.method public setWillNotDraw(Z)V
    .locals 0
    .param p1, "willNotDraw"    # Z

    .prologue
    .line 177
    return-void
.end method

.method public setWillNotDrawCaption(Z)V
    .locals 0
    .param p1, "willNotDraw"    # Z

    .prologue
    .line 161
    invoke-super {p0, p1}, Landroid/view/SurfaceView;->setWillNotDraw(Z)V

    .line 162
    return-void
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 4
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 114
    iget-wide v0, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 115
    iget-wide v0, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->getHeight()I

    move-result v3

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/adobe/ave/VideoEngineView;->nativeSurfaceChanged(JII)V

    .line 116
    :cond_0
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 8
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 78
    iget-object v2, p0, Lcom/adobe/ave/VideoEngineView;->mHolder:Landroid/view/SurfaceHolder;

    monitor-enter v2

    .line 80
    :try_start_0
    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->useOverlay()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 82
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/ave/VideoEngineView;->m_surface:Landroid/view/Surface;

    .line 94
    :goto_0
    iget-wide v4, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    const-wide/16 v6, 0x0

    cmp-long v1, v4, v6

    if-eqz v1, :cond_0

    .line 95
    iget-wide v4, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->getWidth()I

    move-result v1

    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->getHeight()I

    move-result v3

    invoke-direct {p0, v4, v5, v1, v3}, Lcom/adobe/ave/VideoEngineView;->nativeSurfaceCreated(JII)V

    .line 96
    :cond_0
    monitor-exit v2

    .line 97
    :goto_1
    return-void

    .line 87
    :cond_1
    iget-object v1, p0, Lcom/adobe/ave/VideoEngineView;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v1}, Landroid/view/SurfaceHolder;->lockCanvas()Landroid/graphics/Canvas;

    move-result-object v0

    .line 88
    .local v0, "canvas":Landroid/graphics/Canvas;
    if-nez v0, :cond_2

    .line 89
    monitor-exit v2

    goto :goto_1

    .line 96
    .end local v0    # "canvas":Landroid/graphics/Canvas;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 90
    .restart local v0    # "canvas":Landroid/graphics/Canvas;
    :cond_2
    const/4 v1, -0x1

    :try_start_1
    invoke-virtual {v0, v1}, Landroid/graphics/Canvas;->drawColor(I)V

    .line 91
    iget-object v1, p0, Lcom/adobe/ave/VideoEngineView;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v1, v0}, Landroid/view/SurfaceHolder;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 4
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 103
    iget-wide v0, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 104
    iget-wide v0, p0, Lcom/adobe/ave/VideoEngineView;->m_nativeInstance:J

    invoke-direct {p0, v0, v1}, Lcom/adobe/ave/VideoEngineView;->nativeSurfaceDestroyed(J)V

    .line 106
    :cond_0
    invoke-virtual {p0}, Lcom/adobe/ave/VideoEngineView;->useOverlay()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 107
    iget-object v0, p0, Lcom/adobe/ave/VideoEngineView;->m_surface:Landroid/view/Surface;

    invoke-virtual {v0}, Landroid/view/Surface;->release()V

    .line 108
    :cond_1
    return-void
.end method

.method protected useOverlay()Z
    .locals 2

    .prologue
    .line 198
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    .line 199
    const/4 v0, 0x1

    .line 201
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
