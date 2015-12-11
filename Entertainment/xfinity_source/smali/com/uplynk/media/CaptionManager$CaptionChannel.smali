.class public Lcom/uplynk/media/CaptionManager$CaptionChannel;
.super Ljava/lang/Object;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "CaptionChannel"
.end annotation


# instance fields
.field _color:I

.field _column:I

.field private _index:I

.field _italic:Z

.field private _mgr:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/uplynk/media/CaptionManager;",
            ">;"
        }
    .end annotation
.end field

.field _mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

.field _row:I

.field private _runTimer:Z

.field private _timer:Lcom/uplynk/media/CaptionManager$CCTimerHandler;

.field _underlined:Z

.field private currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

.field private currentRowIndex:I

.field queue:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lcom/uplynk/media/CaptionManager$CaptionQueueItem;",
            ">;"
        }
    .end annotation
.end field

.field rowCount:S

.field private rows:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/uplynk/media/CaptionManager$_CaptionRow;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/uplynk/media/CaptionManager;


# direct methods
.method public constructor <init>(Lcom/uplynk/media/CaptionManager;ILcom/uplynk/media/CaptionManager;)V
    .locals 3
    .param p2, "index"    # I
    .param p3, "mgr"    # Lcom/uplynk/media/CaptionManager;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 1253
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    .line 1252
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1230
    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queue:Ljava/util/LinkedList;

    .line 1232
    sget-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 1249
    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_timer:Lcom/uplynk/media/CaptionManager$CCTimerHandler;

    .line 1250
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_runTimer:Z

    .line 1254
    iput v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_column:I

    .line 1255
    const v0, 0xffffff

    iput v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_color:I

    .line 1256
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_italic:Z

    .line 1258
    sget-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 1259
    iput v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_row:I

    .line 1260
    iput v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRowIndex:I

    .line 1261
    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .line 1262
    const/4 v0, 0x1

    iput-short v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rowCount:S

    .line 1263
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_underlined:Z

    .line 1265
    iput p2, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_index:I

    .line 1266
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p3}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mgr:Ljava/lang/ref/WeakReference;

    .line 1267
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    .line 1268
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queue:Ljava/util/LinkedList;

    .line 1269
    return-void
.end method

.method static synthetic access$0(Lcom/uplynk/media/CaptionManager$CaptionChannel;)Z
    .locals 1

    .prologue
    .line 1250
    iget-boolean v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_runTimer:Z

    return v0
.end method

.method static synthetic access$1(Lcom/uplynk/media/CaptionManager$CaptionChannel;)Ljava/lang/ref/WeakReference;
    .locals 1

    .prologue
    .line 1246
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mgr:Ljava/lang/ref/WeakReference;

    return-object v0
.end method

.method static synthetic access$2(Lcom/uplynk/media/CaptionManager$CaptionChannel;)I
    .locals 1

    .prologue
    .line 1245
    iget v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_index:I

    return v0
.end method

.method static synthetic access$3(Lcom/uplynk/media/CaptionManager$CaptionChannel;I)V
    .locals 0

    .prologue
    .line 1684
    invoke-direct {p0, p1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doColor(I)V

    return-void
.end method

.method static synthetic access$4(Lcom/uplynk/media/CaptionManager$CaptionChannel;)V
    .locals 0

    .prologue
    .line 1785
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doItalic()V

    return-void
.end method

.method static synthetic access$5(Lcom/uplynk/media/CaptionManager$CaptionChannel;)V
    .locals 0

    .prologue
    .line 1833
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doUnderlined()V

    return-void
.end method

.method static synthetic access$6(Lcom/uplynk/media/CaptionManager$CaptionChannel;C)V
    .locals 0

    .prologue
    .line 1648
    invoke-direct {p0, p1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doAppendText(C)V

    return-void
.end method

.method private doAppendText(C)V
    .locals 1
    .param p1, "value"    # C

    .prologue
    .line 1650
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    if-eqz v0, :cond_0

    .line 1652
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->writeChar(C)V

    .line 1654
    :cond_0
    return-void
.end method

.method private doBackspace()V
    .locals 1

    .prologue
    .line 1658
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    if-eqz v0, :cond_0

    .line 1659
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->backspace()V

    .line 1661
    :cond_0
    return-void
.end method

.method private doClearAll()V
    .locals 1

    .prologue
    .line 1673
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 1674
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .line 1675
    return-void
.end method

.method private doClearEndOfRow()V
    .locals 1

    .prologue
    .line 1679
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    if-eqz v0, :cond_0

    .line 1680
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->clearToEnd()V

    .line 1682
    :cond_0
    return-void
.end method

.method private doColor(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    const/4 v1, 0x0

    .line 1686
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    if-eqz v0, :cond_0

    .line 1688
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    iput p1, v0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->color:I

    .line 1689
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    iput-boolean v1, v0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isItalic:Z

    .line 1690
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    iput-boolean v1, v0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isUnderlined:Z

    .line 1692
    :cond_0
    return-void
.end method

.method private doColumn(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 1696
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    if-eqz v0, :cond_0

    .line 1698
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    int-to-short v1, p1

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->setColumnIndex(S)V

    .line 1700
    :cond_0
    return-void
.end method

.method private doEraseDisplayMemory()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 1704
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v3, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v2, v3, :cond_1

    .line 1708
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mgr:Ljava/lang/ref/WeakReference;

    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v2}, Lcom/uplynk/media/CaptionManager;->getEventHandler()Lcom/uplynk/media/CaptionManager$CCEventHandler;

    move-result-object v0

    .line 1710
    .local v0, "eh":Lcom/uplynk/media/CaptionManager$CCEventHandler;
    if-eqz v0, :cond_0

    .line 1712
    iget v2, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_index:I

    const/4 v3, 0x0

    invoke-virtual {v0, v4, v2, v4, v3}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 1713
    .local v1, "m":Landroid/os/Message;
    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->sendMessage(Landroid/os/Message;)Z

    .line 1718
    .end local v0    # "eh":Lcom/uplynk/media/CaptionManager$CCEventHandler;
    .end local v1    # "m":Landroid/os/Message;
    :cond_0
    :goto_0
    return-void

    .line 1716
    :cond_1
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doClearAll()V

    goto :goto_0
.end method

.method private doFlush()V
    .locals 12

    .prologue
    .line 1723
    const/4 v2, 0x0

    .line 1728
    .local v2, "dsize":I
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->getRowsData()[S

    move-result-object v1

    .line 1731
    .local v1, "data":[S
    array-length v9, v1

    if-lez v9, :cond_2

    .line 1739
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v10, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v9, v10, :cond_2

    .line 1741
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mgr:Ljava/lang/ref/WeakReference;

    invoke-virtual {v9}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v9}, Lcom/uplynk/media/CaptionManager;->getEventHandler()Lcom/uplynk/media/CaptionManager$CCEventHandler;

    move-result-object v4

    .line 1743
    .local v4, "eh":Lcom/uplynk/media/CaptionManager$CCEventHandler;
    if-eqz v4, :cond_0

    .line 1745
    const/4 v9, 0x1

    iget v10, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_index:I

    array-length v11, v1

    invoke-virtual {v4, v9, v10, v11, v1}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v6

    .line 1746
    .local v6, "m":Landroid/os/Message;
    invoke-virtual {v4, v6}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->sendMessage(Landroid/os/Message;)Z

    .line 1749
    .end local v6    # "m":Landroid/os/Message;
    :cond_0
    new-instance v3, Lcom/uplynk/media/CaptionEvent;

    sget-object v9, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v10, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    invoke-direct {v3, v9, v10}, Lcom/uplynk/media/CaptionEvent;-><init>(Lcom/uplynk/media/CaptionEvent$CaptionMode;Lcom/uplynk/media/CaptionEvent$CaptionEventType;)V

    .line 1750
    .local v3, "e":Lcom/uplynk/media/CaptionEvent;
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v9}, Landroid/util/SparseArray;->size()I

    move-result v9

    if-lt v5, v9, :cond_4

    .line 1760
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;
    invoke-static {v9}, Lcom/uplynk/media/CaptionManager;->access$2(Lcom/uplynk/media/CaptionManager;)Lcom/uplynk/media/CaptionManager$OverlayView;

    move-result-object v9

    if-eqz v9, :cond_1

    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccEnabled:Z
    invoke-static {v9}, Lcom/uplynk/media/CaptionManager;->access$3(Lcom/uplynk/media/CaptionManager;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 1762
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;
    invoke-static {v9}, Lcom/uplynk/media/CaptionManager;->access$2(Lcom/uplynk/media/CaptionManager;)Lcom/uplynk/media/CaptionManager$OverlayView;

    move-result-object v9

    invoke-virtual {v9, v3}, Lcom/uplynk/media/CaptionManager$OverlayView;->renderCaptionEvent(Lcom/uplynk/media/CaptionEvent;)V

    .line 1767
    :cond_1
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_mp:Ljava/lang/ref/WeakReference;
    invoke-static {v9}, Lcom/uplynk/media/CaptionManager;->access$4(Lcom/uplynk/media/CaptionManager;)Ljava/lang/ref/WeakReference;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/uplynk/media/MediaPlayer;

    iget-object v9, v9, Lcom/uplynk/media/MediaPlayer;->mOnCaptionEventListener:Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

    if-eqz v9, :cond_2

    .line 1768
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_mp:Ljava/lang/ref/WeakReference;
    invoke-static {v9}, Lcom/uplynk/media/CaptionManager;->access$4(Lcom/uplynk/media/CaptionManager;)Ljava/lang/ref/WeakReference;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/uplynk/media/MediaPlayer;

    iget-object v9, v9, Lcom/uplynk/media/MediaPlayer;->mOnCaptionEventListener:Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

    iget-object v10, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;
    invoke-static {v10}, Lcom/uplynk/media/CaptionManager;->access$0(Lcom/uplynk/media/CaptionManager;)Lcom/uplynk/media/CaptionManager$CCEventHandler;

    move-result-object v10

    # getter for: Lcom/uplynk/media/CaptionManager$CCEventHandler;->_mediaPlayer:Lcom/uplynk/media/MediaPlayer;
    invoke-static {v10}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->access$0(Lcom/uplynk/media/CaptionManager$CCEventHandler;)Lcom/uplynk/media/MediaPlayer;

    move-result-object v10

    invoke-interface {v9, v10, v3}, Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;->onCaptionEvent(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/CaptionEvent;)Z

    .line 1772
    .end local v3    # "e":Lcom/uplynk/media/CaptionEvent;
    .end local v4    # "eh":Lcom/uplynk/media/CaptionManager$CCEventHandler;
    .end local v5    # "i":I
    :cond_2
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v10, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v9, v10, :cond_3

    .line 1774
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doClearAll()V

    .line 1776
    :cond_3
    return-void

    .line 1752
    .restart local v3    # "e":Lcom/uplynk/media/CaptionEvent;
    .restart local v4    # "eh":Lcom/uplynk/media/CaptionManager$CCEventHandler;
    .restart local v5    # "i":I
    :cond_4
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v9, v5}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v8

    .line 1753
    .local v8, "rowIndex":I
    iget-object v9, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v9, v8}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .line 1755
    .local v7, "row":Lcom/uplynk/media/CaptionManager$_CaptionRow;
    invoke-virtual {v7, v3}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->toCaptionRow(Lcom/uplynk/media/CaptionEvent;)Lcom/uplynk/media/CaptionEvent$CaptionRow;

    move-result-object v0

    .line 1756
    .local v0, "cr":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    iget-object v9, v3, Lcom/uplynk/media/CaptionEvent;->rows:Landroid/util/SparseArray;

    invoke-virtual {v9, v8, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1750
    add-int/lit8 v5, v5, 0x1

    goto :goto_0
.end method

.method private doIndent(I)V
    .locals 1
    .param p1, "value"    # I

    .prologue
    .line 1780
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    if-eqz v0, :cond_0

    .line 1781
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->tabIndex(I)V

    .line 1783
    :cond_0
    return-void
.end method

.method private doItalic()V
    .locals 2

    .prologue
    .line 1787
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    if-eqz v0, :cond_0

    .line 1788
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isItalic:Z

    .line 1790
    :cond_0
    return-void
.end method

.method private doLinebreak()V
    .locals 2

    .prologue
    .line 1794
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    if-eqz v0, :cond_0

    .line 1796
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    .line 1821
    iget v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRowIndex:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRowIndex:I

    .line 1822
    iget v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRowIndex:I

    invoke-direct {p0, v0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->getCaptionRow(I)Lcom/uplynk/media/CaptionManager$_CaptionRow;

    move-result-object v0

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .line 1825
    :cond_0
    return-void
.end method

.method private doStartNewRow(I)V
    .locals 1
    .param p1, "row"    # I

    .prologue
    .line 1829
    iput p1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRowIndex:I

    .line 1830
    invoke-direct {p0, p1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->getCaptionRow(I)Lcom/uplynk/media/CaptionManager$_CaptionRow;

    move-result-object v0

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .line 1831
    return-void
.end method

.method private doUnderlined()V
    .locals 2

    .prologue
    .line 1835
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    if-eqz v0, :cond_0

    .line 1836
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isUnderlined:Z

    .line 1838
    :cond_0
    return-void
.end method

.method private getCaptionRow(I)Lcom/uplynk/media/CaptionManager$_CaptionRow;
    .locals 2
    .param p1, "rowIndex"    # I

    .prologue
    .line 1522
    if-lez p1, :cond_1

    const/16 v1, 0xf

    if-gt p1, v1, :cond_1

    .line 1524
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .line 1526
    .local v0, "row":Lcom/uplynk/media/CaptionManager$_CaptionRow;
    if-nez v0, :cond_0

    .line 1531
    new-instance v0, Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .end local v0    # "row":Lcom/uplynk/media/CaptionManager$_CaptionRow;
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    invoke-direct {v0, v1, p1}, Lcom/uplynk/media/CaptionManager$_CaptionRow;-><init>(Lcom/uplynk/media/CaptionManager;I)V

    .line 1534
    .restart local v0    # "row":Lcom/uplynk/media/CaptionManager$_CaptionRow;
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1540
    .end local v0    # "row":Lcom/uplynk/media/CaptionManager$_CaptionRow;
    :cond_0
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getRowsData()[S
    .locals 6

    .prologue
    .line 1572
    const/4 v5, 0x0

    new-array v0, v5, [S

    .line 1574
    .local v0, "data":[S
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v5}, Landroid/util/SparseArray;->size()I

    move-result v5

    if-lt v1, v5, :cond_0

    .line 1594
    return-object v0

    .line 1576
    :cond_0
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v4

    .line 1577
    .local v4, "rowIndex":I
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v5, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .line 1580
    .local v3, "row":Lcom/uplynk/media/CaptionManager$_CaptionRow;
    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->getData()[S

    move-result-object v2

    .line 1586
    .local v2, "rd":[S
    # invokes: Lcom/uplynk/media/CaptionManager;->concat([S[S)[S
    invoke-static {v0, v2}, Lcom/uplynk/media/CaptionManager;->access$1([S[S)[S

    move-result-object v0

    .line 1574
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private getRowsMarkup()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1645
    const-string v0, " "

    return-object v0
.end method

.method private getRowsText()Ljava/lang/String;
    .locals 11

    .prologue
    .line 1609
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 1618
    .local v0, "data":Ljava/lang/String;
    const/4 v2, 0x0

    .line 1620
    .local v2, "idx":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v6, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v6}, Landroid/util/SparseArray;->size()I

    move-result v6

    if-lt v1, v6, :cond_0

    .line 1640
    return-object v0

    .line 1622
    :cond_0
    iget-object v6, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v6, v1}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v4

    .line 1623
    .local v4, "rowIndex":I
    iget-object v6, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rows:Landroid/util/SparseArray;

    invoke-virtual {v6, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .line 1625
    .local v3, "row":Lcom/uplynk/media/CaptionManager$_CaptionRow;
    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->getText()Ljava/lang/String;

    move-result-object v5

    .line 1628
    .local v5, "rowText":Ljava/lang/String;
    if-lez v2, :cond_1

    .line 1629
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, "\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1631
    :cond_1
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1634
    const-string v6, "upLynkCaptionManager"

    const-string v7, "CC (%d): %s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v5, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1635
    add-int/lit8 v2, v2, 0x1

    .line 1620
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private varargs queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V
    .locals 3
    .param p1, "pause"    # Z
    .param p2, "type"    # Lcom/uplynk/media/CaptionManager$CaptionAction;
    .param p3, "values"    # [I

    .prologue
    const/4 v2, 0x0

    .line 1290
    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;

    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    invoke-direct {v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;-><init>(Lcom/uplynk/media/CaptionManager;)V

    .line 1291
    .local v0, "item":Lcom/uplynk/media/CaptionManager$CaptionQueueItem;
    iput-boolean p1, v0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->pause:Z

    .line 1292
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iput-object v1, v0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 1293
    iget v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_index:I

    int-to-short v1, v1

    iput-short v1, v0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->channel:S

    .line 1294
    iput-object p2, v0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->action:Lcom/uplynk/media/CaptionManager$CaptionAction;

    .line 1295
    iget-short v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rowCount:S

    iput v1, v0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->rowCount:I

    .line 1297
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->TEXT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    if-ne p2, v1, :cond_2

    .line 1298
    aget v1, p3, v2

    iput v1, v0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->value:I

    .line 1302
    :cond_0
    :goto_0
    monitor-enter p0

    .line 1304
    :try_start_0
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queue:Ljava/util/LinkedList;

    invoke-virtual {v1, v0}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 1302
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1308
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_timer:Lcom/uplynk/media/CaptionManager$CCTimerHandler;

    if-nez v1, :cond_1

    .line 1309
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startTimer()V

    .line 1310
    :cond_1
    return-void

    .line 1299
    :cond_2
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->COLOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

    if-ne p2, v1, :cond_0

    .line 1300
    aget v1, p3, v2

    iput v1, v0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->value:I

    goto :goto_0

    .line 1302
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method private startTimer()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 1314
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_timer:Lcom/uplynk/media/CaptionManager$CCTimerHandler;

    if-nez v0, :cond_0

    .line 1316
    new-instance v0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;

    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->this$0:Lcom/uplynk/media/CaptionManager;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v0, v1, p0, v2}, Lcom/uplynk/media/CaptionManager$CCTimerHandler;-><init>(Lcom/uplynk/media/CaptionManager;Lcom/uplynk/media/CaptionManager$CaptionChannel;Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_timer:Lcom/uplynk/media/CaptionManager$CCTimerHandler;

    .line 1317
    iput-boolean v4, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_runTimer:Z

    .line 1318
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_timer:Lcom/uplynk/media/CaptionManager$CCTimerHandler;

    const-wide/16 v2, 0x1e

    invoke-virtual {v0, v4, v2, v3}, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 1320
    :cond_0
    return-void
.end method

.method private stopTimer()V
    .locals 2

    .prologue
    .line 1325
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_timer:Lcom/uplynk/media/CaptionManager$CCTimerHandler;

    if-eqz v0, :cond_0

    .line 1327
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_timer:Lcom/uplynk/media/CaptionManager$CCTimerHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->removeMessages(I)V

    .line 1328
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_runTimer:Z

    .line 1329
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_timer:Lcom/uplynk/media/CaptionManager$CCTimerHandler;

    .line 1331
    :cond_0
    return-void
.end method


# virtual methods
.method appendText(C)V
    .locals 4
    .param p1, "value"    # C

    .prologue
    const/4 v3, 0x1

    .line 1364
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1373
    :cond_0
    :goto_0
    return-void

    .line 1367
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1368
    invoke-direct {p0, p1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doAppendText(C)V

    goto :goto_0

    .line 1371
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->TEXT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-array v1, v3, [I

    const/4 v2, 0x0

    aput p1, v1, v2

    invoke-direct {p0, v3, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method backspace()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1377
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1385
    :cond_0
    :goto_0
    return-void

    .line 1380
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1381
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doBackspace()V

    goto :goto_0

    .line 1383
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->BACKSPACE:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-array v1, v2, [I

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method clearAll()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1389
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1397
    :cond_0
    :goto_0
    return-void

    .line 1392
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1393
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doClearAll()V

    goto :goto_0

    .line 1395
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->CLEAR_ALL:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-array v1, v2, [I

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method clearEndOfRow()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1401
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1409
    :cond_0
    :goto_0
    return-void

    .line 1404
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1405
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doClearEndOfRow()V

    goto :goto_0

    .line 1407
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->CLEAR_EOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-array v1, v2, [I

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method color(I)V
    .locals 3
    .param p1, "value"    # I

    .prologue
    const/4 v2, 0x0

    .line 1413
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1421
    :cond_0
    :goto_0
    return-void

    .line 1416
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1417
    invoke-direct {p0, p1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doColor(I)V

    goto :goto_0

    .line 1419
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->COLOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

    const/4 v1, 0x1

    new-array v1, v1, [I

    aput p1, v1, v2

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method column(I)V
    .locals 3
    .param p1, "value"    # I

    .prologue
    const/4 v2, 0x0

    .line 1425
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1433
    :cond_0
    :goto_0
    return-void

    .line 1428
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1429
    invoke-direct {p0, p1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doColumn(I)V

    goto :goto_0

    .line 1431
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->COLUMN:Lcom/uplynk/media/CaptionManager$CaptionAction;

    const/4 v1, 0x1

    new-array v1, v1, [I

    aput p1, v1, v2

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method eraseDisplayMemory()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1437
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1445
    :cond_0
    :goto_0
    return-void

    .line 1440
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1441
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doEraseDisplayMemory()V

    goto :goto_0

    .line 1443
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->ERASE_DISPLAY_MEM:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-array v1, v2, [I

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method flush()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1449
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1457
    :cond_0
    :goto_0
    return-void

    .line 1452
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1453
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doFlush()V

    goto :goto_0

    .line 1455
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->FLUSH:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-array v1, v2, [I

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method indent(I)V
    .locals 3
    .param p1, "value"    # I

    .prologue
    const/4 v2, 0x0

    .line 1461
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1469
    :cond_0
    :goto_0
    return-void

    .line 1464
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1465
    invoke-direct {p0, p1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doIndent(I)V

    goto :goto_0

    .line 1467
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->INDENT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    const/4 v1, 0x1

    new-array v1, v1, [I

    aput p1, v1, v2

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method italic()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1473
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1481
    :cond_0
    :goto_0
    return-void

    .line 1476
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1477
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doItalic()V

    goto :goto_0

    .line 1479
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->ITALIC:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-array v1, v2, [I

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method linebreak()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1485
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1493
    :cond_0
    :goto_0
    return-void

    .line 1488
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1489
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doLinebreak()V

    goto :goto_0

    .line 1491
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->LINEBREAK:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-array v1, v2, [I

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method mode(Lcom/uplynk/media/CaptionEvent$CaptionMode;)V
    .locals 2
    .param p1, "value"    # Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .prologue
    .line 1335
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq p1, v0, :cond_0

    .line 1337
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 1339
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_1

    .line 1345
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startTimer()V

    .line 1359
    :cond_0
    :goto_0
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 1360
    return-void

    .line 1351
    :cond_1
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->stopTimer()V

    .line 1353
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queue:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->clear()V

    goto :goto_0
.end method

.method protected reset()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1273
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->stopTimer()V

    .line 1275
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queue:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->clear()V

    .line 1277
    iput v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_column:I

    .line 1278
    const v0, 0xffffff

    iput v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_color:I

    .line 1279
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_italic:Z

    .line 1280
    sget-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 1281
    iput v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_row:I

    .line 1282
    iput v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRowIndex:I

    .line 1283
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->currentRow:Lcom/uplynk/media/CaptionManager$_CaptionRow;

    .line 1284
    const/4 v0, 0x1

    iput-short v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rowCount:S

    .line 1285
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_underlined:Z

    .line 1286
    return-void
.end method

.method startNewRow(I)V
    .locals 3
    .param p1, "row"    # I

    .prologue
    const/4 v2, 0x0

    .line 1510
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1518
    :cond_0
    :goto_0
    return-void

    .line 1513
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1514
    invoke-direct {p0, p1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doStartNewRow(I)V

    goto :goto_0

    .line 1516
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->START_NEW_ROW:Lcom/uplynk/media/CaptionManager$CaptionAction;

    const/4 v1, 0x1

    new-array v1, v1, [I

    aput p1, v1, v2

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method

.method underlined()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1497
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_1

    .line 1505
    :cond_0
    :goto_0
    return-void

    .line 1500
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v0, v1, :cond_2

    .line 1501
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->doUnderlined()V

    goto :goto_0

    .line 1503
    :cond_2
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->UNDERLINED:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-array v1, v2, [I

    invoke-direct {p0, v2, v0, v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queueTask(ZLcom/uplynk/media/CaptionManager$CaptionAction;[I)V

    goto :goto_0
.end method
