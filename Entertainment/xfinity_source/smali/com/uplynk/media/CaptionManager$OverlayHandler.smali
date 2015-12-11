.class Lcom/uplynk/media/CaptionManager$OverlayHandler;
.super Landroid/os/Handler;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "OverlayHandler"
.end annotation


# instance fields
.field _overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

.field final synthetic this$0:Lcom/uplynk/media/CaptionManager;


# direct methods
.method protected constructor <init>(Lcom/uplynk/media/CaptionManager;Lcom/uplynk/media/CaptionManager$OverlayView;Landroid/os/Looper;)V
    .locals 0
    .param p2, "overlayView"    # Lcom/uplynk/media/CaptionManager$OverlayView;
    .param p3, "looper"    # Landroid/os/Looper;

    .prologue
    .line 1846
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$OverlayHandler;->this$0:Lcom/uplynk/media/CaptionManager;

    .line 1847
    invoke-direct {p0, p3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 1848
    iput-object p2, p0, Lcom/uplynk/media/CaptionManager$OverlayHandler;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    .line 1849
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v1, 0x1

    .line 1854
    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v0, v1, :cond_0

    .line 1857
    invoke-virtual {p0, v1}, Lcom/uplynk/media/CaptionManager$OverlayHandler;->removeMessages(I)V

    .line 1858
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayHandler;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iput-object v1, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 1859
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayHandler;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$OverlayView;->invalidate()V

    .line 1860
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayHandler;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/uplynk/media/CaptionManager$OverlayView;->access$0(Lcom/uplynk/media/CaptionManager$OverlayView;Z)V

    .line 1862
    :cond_0
    return-void
.end method
