.class public Lcom/uplynk/media/CaptionManager$CCEventHandler;
.super Landroid/os/Handler;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "CCEventHandler"
.end annotation


# instance fields
.field private _cc:Lcom/uplynk/media/CaptionManager;

.field private _mediaPlayer:Lcom/uplynk/media/MediaPlayer;

.field final synthetic this$0:Lcom/uplynk/media/CaptionManager;


# direct methods
.method public constructor <init>(Lcom/uplynk/media/CaptionManager;Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/CaptionManager;Landroid/os/Looper;)V
    .locals 0
    .param p2, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p3, "cc"    # Lcom/uplynk/media/CaptionManager;
    .param p4, "looper"    # Landroid/os/Looper;

    .prologue
    .line 807
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->this$0:Lcom/uplynk/media/CaptionManager;

    .line 808
    invoke-direct {p0, p4}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 809
    iput-object p2, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->_mediaPlayer:Lcom/uplynk/media/MediaPlayer;

    .line 810
    iput-object p3, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->_cc:Lcom/uplynk/media/CaptionManager;

    .line 811
    return-void
.end method

.method static synthetic access$0(Lcom/uplynk/media/CaptionManager$CCEventHandler;)Lcom/uplynk/media/MediaPlayer;
    .locals 1

    .prologue
    .line 804
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->_mediaPlayer:Lcom/uplynk/media/MediaPlayer;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 7
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v6, 0x0

    .line 816
    iget-object v4, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->_mediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v4}, Lcom/uplynk/media/MediaPlayer;->hasNativeContext()Z

    move-result v4

    if-nez v4, :cond_1

    .line 817
    const-string v4, "upLynkCaptionManager"

    const-string v5, "mediaplayer went away with unhandled closed caption events"

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 852
    :cond_0
    :goto_0
    return-void

    .line 821
    :cond_1
    iget v0, p1, Landroid/os/Message;->arg1:I

    .line 822
    .local v0, "channelIndex":I
    iget-object v4, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->_cc:Lcom/uplynk/media/CaptionManager;

    iget v4, v4, Lcom/uplynk/media/CaptionManager;->_preferredChannelIndex:I

    if-ne v4, v0, :cond_0

    .line 825
    iget v4, p1, Landroid/os/Message;->what:I

    if-nez v4, :cond_2

    .line 828
    iget-object v4, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->this$0:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v4}, Lcom/uplynk/media/CaptionManager;->clearDisplay()V

    goto :goto_0

    .line 830
    :cond_2
    iget v4, p1, Landroid/os/Message;->what:I

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 832
    iget-object v4, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;
    invoke-static {v4}, Lcom/uplynk/media/CaptionManager;->access$0(Lcom/uplynk/media/CaptionManager;)Lcom/uplynk/media/CaptionManager$CCEventHandler;

    move-result-object v4

    invoke-virtual {v4, v6}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->removeMessages(I)V

    .line 834
    iget v3, p1, Landroid/os/Message;->arg2:I

    .line 835
    .local v3, "size":I
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, [S

    .line 837
    .local v1, "data":[S
    array-length v4, v1

    if-eq v3, v4, :cond_3

    .line 839
    const-string v4, "upLynkCaptionManager"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "CC: Data Packet doesn\'t match advertised length  ("

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    array-length v6, v1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " vs "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 843
    :cond_3
    iget-object v4, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->_cc:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v4, v3, v1}, Lcom/uplynk/media/CaptionManager;->renderCCData(I[S)V

    goto :goto_0

    .line 845
    .end local v1    # "data":[S
    .end local v3    # "size":I
    :cond_4
    iget v4, p1, Landroid/os/Message;->what:I

    const/4 v5, 0x2

    if-ne v4, v5, :cond_0

    .line 847
    iget-object v4, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;
    invoke-static {v4}, Lcom/uplynk/media/CaptionManager;->access$0(Lcom/uplynk/media/CaptionManager;)Lcom/uplynk/media/CaptionManager$CCEventHandler;

    move-result-object v4

    invoke-virtual {v4, v6}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->removeMessages(I)V

    .line 849
    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;

    .line 850
    .local v2, "item":Lcom/uplynk/media/CaptionManager$CaptionQueueItem;
    iget-object v4, p0, Lcom/uplynk/media/CaptionManager$CCEventHandler;->_cc:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v4, v2}, Lcom/uplynk/media/CaptionManager;->renderCCStreamItem(Lcom/uplynk/media/CaptionManager$CaptionQueueItem;)V

    goto :goto_0
.end method
