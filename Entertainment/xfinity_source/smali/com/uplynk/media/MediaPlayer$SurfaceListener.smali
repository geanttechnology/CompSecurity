.class Lcom/uplynk/media/MediaPlayer$SurfaceListener;
.super Ljava/lang/Object;
.source "MediaPlayer.java"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback2;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SurfaceListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/uplynk/media/MediaPlayer;


# direct methods
.method private constructor <init>(Lcom/uplynk/media/MediaPlayer;)V
    .locals 0

    .prologue
    .line 1565
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$SurfaceListener;->this$0:Lcom/uplynk/media/MediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$SurfaceListener;)V
    .locals 0

    .prologue
    .line 1565
    invoke-direct {p0, p1}, Lcom/uplynk/media/MediaPlayer$SurfaceListener;-><init>(Lcom/uplynk/media/MediaPlayer;)V

    return-void
.end method


# virtual methods
.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 4
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    const/4 v3, 0x0

    .line 1569
    const-string v0, "upLynkMediaPlayer"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "SurfaceListener::surfaceChanged() "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "x"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1570
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$SurfaceListener;->this$0:Lcom/uplynk/media/MediaPlayer;

    # invokes: Lcom/uplynk/media/MediaPlayer;->updateSurfaceBounds(IIII)V
    invoke-static {v0, v3, v3, p3, p4}, Lcom/uplynk/media/MediaPlayer;->access$22(Lcom/uplynk/media/MediaPlayer;IIII)V

    .line 1571
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 7
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 1575
    const-string v0, "upLynkMediaPlayer"

    const-string v1, "SurfaceListener::surfaceCreated()"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1576
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurfaceFrame()Landroid/graphics/Rect;

    move-result-object v6

    .line 1577
    .local v6, "frame":Landroid/graphics/Rect;
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$SurfaceListener;->this$0:Lcom/uplynk/media/MediaPlayer;

    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v1

    iget v2, v6, Landroid/graphics/Rect;->left:I

    iget v3, v6, Landroid/graphics/Rect;->top:I

    iget v4, v6, Landroid/graphics/Rect;->right:I

    iget v5, v6, Landroid/graphics/Rect;->bottom:I

    # invokes: Lcom/uplynk/media/MediaPlayer;->_setSurface(Landroid/view/Surface;IIII)V
    invoke-static/range {v0 .. v5}, Lcom/uplynk/media/MediaPlayer;->access$23(Lcom/uplynk/media/MediaPlayer;Landroid/view/Surface;IIII)V

    .line 1578
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 7
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 1582
    const-string v0, "upLynkMediaPlayer"

    const-string v1, "SurfaceListener::surfaceDestroyed()"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1583
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$SurfaceListener;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mNativeContext:I
    invoke-static {v0}, Lcom/uplynk/media/MediaPlayer;->access$0(Lcom/uplynk/media/MediaPlayer;)I

    move-result v0

    if-nez v0, :cond_1

    .line 1598
    :cond_0
    :goto_0
    return-void

    .line 1587
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$SurfaceListener;->this$0:Lcom/uplynk/media/MediaPlayer;

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    # invokes: Lcom/uplynk/media/MediaPlayer;->_setSurface(Landroid/view/Surface;IIII)V
    invoke-static/range {v0 .. v5}, Lcom/uplynk/media/MediaPlayer;->access$23(Lcom/uplynk/media/MediaPlayer;Landroid/view/Surface;IIII)V

    .line 1588
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$SurfaceListener;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;
    invoke-static {v0}, Lcom/uplynk/media/MediaPlayer;->access$9(Lcom/uplynk/media/MediaPlayer;)Landroid/view/SurfaceHolder;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1590
    const-string v0, "upLynkMediaPlayer"

    const-string v1, "Display Surface Destroyed - Unlinking SurfaceHolder from Player"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1591
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$SurfaceListener;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;
    invoke-static {v0}, Lcom/uplynk/media/MediaPlayer;->access$9(Lcom/uplynk/media/MediaPlayer;)Landroid/view/SurfaceHolder;

    move-result-object v0

    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer$SurfaceListener;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mSurfaceListener:Lcom/uplynk/media/MediaPlayer$SurfaceListener;
    invoke-static {v1}, Lcom/uplynk/media/MediaPlayer;->access$24(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$SurfaceListener;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->removeCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 1592
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$SurfaceListener;->this$0:Lcom/uplynk/media/MediaPlayer;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/uplynk/media/MediaPlayer;->access$25(Lcom/uplynk/media/MediaPlayer;Landroid/view/SurfaceHolder;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1595
    :catch_0
    move-exception v6

    .line 1596
    .local v6, "ise":Ljava/lang/IllegalStateException;
    const-string v0, "upLynkMediaPlayer"

    const-string v1, "Ignoring IllegalStateException on _setSurface(null,0,0,0,0)"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public surfaceRedrawNeeded(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 1602
    const-string v0, "upLynkMediaPlayer"

    const-string v1, "SurfaceListener::surfaceRedrawNeeded()"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1603
    return-void
.end method
