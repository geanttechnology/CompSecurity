.class public Lcom/uplynk/media/CaptionManager;
.super Ljava/lang/Object;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/uplynk/media/CaptionManager$CCEventHandler;,
        Lcom/uplynk/media/CaptionManager$CCTimerHandler;,
        Lcom/uplynk/media/CaptionManager$CaptionAction;,
        Lcom/uplynk/media/CaptionManager$CaptionChannel;,
        Lcom/uplynk/media/CaptionManager$CaptionQueueItem;,
        Lcom/uplynk/media/CaptionManager$OverlayHandler;,
        Lcom/uplynk/media/CaptionManager$OverlayView;,
        Lcom/uplynk/media/CaptionManager$_CaptionCharacter;,
        Lcom/uplynk/media/CaptionManager$_CaptionRow;
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction:[I = null

.field private static final CC_CLEAR:I = 0x0

.field private static final CC_ROW_COUNT:I = 0xf

.field private static final CC_STREAM:I = 0x2

.field protected static final CC_STREAM_ROW:I = 0xe

.field private static final CC_TEXT:I = 0x1

.field private static final TAG:Ljava/lang/String; = "upLynkCaptionManager"

.field private static final TAG_CC:Ljava/lang/String; = "upLynkCaptionManager"

.field private static final TAG_OVERLAY:Ljava/lang/String; = "upLynkCaptionOverlay"

.field private static final TRACE_CC:Z


# instance fields
.field private _activeLineText:Ljava/lang/StringBuffer;

.field private _activeRowCount:I

.field _captions:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/uplynk/media/CaptionManager$CaptionChannel;",
            ">;"
        }
    .end annotation
.end field

.field private _ccColOffsetX:I

.field private _ccColSize:I

.field private _ccColWidth:I

.field private _ccContainer:Landroid/widget/RelativeLayout;

.field private _ccEnabled:Z

.field private _ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

.field private _ccLayoutHeight:I

.field private _ccLayoutWidth:I

.field private _ccRowHeight:I

.field private _ccRowHeightNormal:I

.field private _ccRowOffsetY:I

.field private _ccRowSize:I

.field private _ccRowSizeNormal:I

.field private _currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

.field _currentChannelIndex:I

.field private _lastData1:C

.field private _lastData2:C

.field private _layoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

.field private _mp:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/uplynk/media/MediaPlayer;",
            ">;"
        }
    .end annotation
.end field

.field private _overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

.field _preferredChannelIndex:I

.field private _style:Lcom/uplynk/media/CaptionStyle;

.field private _videoAspectRatio:F

.field private _videoHeight:I

.field private _videoWidth:I

.field private inXdsMode:Z


# direct methods
.method static synthetic $SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction()[I
    .locals 3

    .prologue
    .line 39
    sget-object v0, Lcom/uplynk/media/CaptionManager;->$SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/uplynk/media/CaptionManager$CaptionAction;->values()[Lcom/uplynk/media/CaptionManager$CaptionAction;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->BACKSPACE:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_d

    :goto_1
    :try_start_1
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->CLEAR_ALL:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_c

    :goto_2
    :try_start_2
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->CLEAR_EOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_b

    :goto_3
    :try_start_3
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->COLOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_a

    :goto_4
    :try_start_4
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->COLUMN:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_9

    :goto_5
    :try_start_5
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->ERASE_DISPLAY_MEM:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_8

    :goto_6
    :try_start_6
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->FLUSH:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/16 v2, 0x9

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_7

    :goto_7
    :try_start_7
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->INDENT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/16 v2, 0xa

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_6

    :goto_8
    :try_start_8
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->ITALIC:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/16 v2, 0xb

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_5

    :goto_9
    :try_start_9
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->LINEBREAK:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/16 v2, 0xc

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_4

    :goto_a
    :try_start_a
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->START_NEW_ROW:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/16 v2, 0xe

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_3

    :goto_b
    :try_start_b
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->TEXT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_2

    :goto_c
    :try_start_c
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->UNDERLINED:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/16 v2, 0xd

    aput v2, v0, v1
    :try_end_c
    .catch Ljava/lang/NoSuchFieldError; {:try_start_c .. :try_end_c} :catch_1

    :goto_d
    :try_start_d
    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->UNKNOWN:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_d .. :try_end_d} :catch_0

    :goto_e
    sput-object v0, Lcom/uplynk/media/CaptionManager;->$SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction:[I

    goto/16 :goto_0

    :catch_0
    move-exception v1

    goto :goto_e

    :catch_1
    move-exception v1

    goto :goto_d

    :catch_2
    move-exception v1

    goto :goto_c

    :catch_3
    move-exception v1

    goto :goto_b

    :catch_4
    move-exception v1

    goto :goto_a

    :catch_5
    move-exception v1

    goto :goto_9

    :catch_6
    move-exception v1

    goto :goto_8

    :catch_7
    move-exception v1

    goto :goto_7

    :catch_8
    move-exception v1

    goto :goto_6

    :catch_9
    move-exception v1

    goto :goto_5

    :catch_a
    move-exception v1

    goto :goto_4

    :catch_b
    move-exception v1

    goto/16 :goto_3

    :catch_c
    move-exception v1

    goto/16 :goto_2

    :catch_d
    move-exception v1

    goto/16 :goto_1
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    .line 63
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowSizeNormal:I

    .line 64
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowHeight:I

    .line 65
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowHeightNormal:I

    .line 66
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I

    .line 67
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccColSize:I

    .line 68
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccColWidth:I

    .line 69
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I

    .line 70
    const v0, 0x3fe38bac    # 1.7777f

    iput v0, p0, Lcom/uplynk/media/CaptionManager;->_videoAspectRatio:F

    .line 71
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_videoWidth:I

    .line 72
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_videoHeight:I

    .line 73
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccLayoutWidth:I

    .line 74
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccLayoutHeight:I

    .line 77
    const/4 v0, 0x1

    iput v0, p0, Lcom/uplynk/media/CaptionManager;->_activeRowCount:I

    .line 80
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager;->inXdsMode:Z

    .line 82
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannelIndex:I

    .line 83
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_preferredChannelIndex:I

    .line 91
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager;->_layoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    .line 95
    return-void
.end method

.method protected constructor <init>(Lcom/uplynk/media/MediaPlayer;)V
    .locals 2
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;

    .prologue
    const/4 v1, 0x0

    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    .line 63
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowSizeNormal:I

    .line 64
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowHeight:I

    .line 65
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowHeightNormal:I

    .line 66
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I

    .line 67
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccColSize:I

    .line 68
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccColWidth:I

    .line 69
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I

    .line 70
    const v0, 0x3fe38bac    # 1.7777f

    iput v0, p0, Lcom/uplynk/media/CaptionManager;->_videoAspectRatio:F

    .line 71
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_videoWidth:I

    .line 72
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_videoHeight:I

    .line 73
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccLayoutWidth:I

    .line 74
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_ccLayoutHeight:I

    .line 77
    const/4 v0, 0x1

    iput v0, p0, Lcom/uplynk/media/CaptionManager;->_activeRowCount:I

    .line 80
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager;->inXdsMode:Z

    .line 82
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannelIndex:I

    .line 83
    iput v1, p0, Lcom/uplynk/media/CaptionManager;->_preferredChannelIndex:I

    .line 91
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager;->_layoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    .line 99
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager;->_mp:Ljava/lang/ref/WeakReference;

    .line 100
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager;->_ccEnabled:Z

    .line 101
    new-instance v0, Lcom/uplynk/media/CaptionStyle;

    invoke-direct {v0}, Lcom/uplynk/media/CaptionStyle;-><init>()V

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager;->_style:Lcom/uplynk/media/CaptionStyle;

    .line 103
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager;->_captions:Landroid/util/SparseArray;

    .line 105
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager;->_activeLineText:Ljava/lang/StringBuffer;

    .line 107
    new-instance v0, Lcom/uplynk/media/CaptionManager$1;

    invoke-direct {v0, p0}, Lcom/uplynk/media/CaptionManager$1;-><init>(Lcom/uplynk/media/CaptionManager;)V

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager;->_layoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    .line 129
    return-void
.end method

.method static synthetic access$0(Lcom/uplynk/media/CaptionManager;)Lcom/uplynk/media/CaptionManager$CCEventHandler;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    return-object v0
.end method

.method static synthetic access$1([S[S)[S
    .locals 1

    .prologue
    .line 2668
    invoke-static {p0, p1}, Lcom/uplynk/media/CaptionManager;->concat([S[S)[S

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$10(Lcom/uplynk/media/CaptionManager;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$11(Lcom/uplynk/media/CaptionManager;)I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lcom/uplynk/media/CaptionManager;->_ccLayoutWidth:I

    return v0
.end method

.method static synthetic access$2(Lcom/uplynk/media/CaptionManager;)Lcom/uplynk/media/CaptionManager$OverlayView;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    return-object v0
.end method

.method static synthetic access$3(Lcom/uplynk/media/CaptionManager;)Z
    .locals 1

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/uplynk/media/CaptionManager;->_ccEnabled:Z

    return v0
.end method

.method static synthetic access$4(Lcom/uplynk/media/CaptionManager;)Ljava/lang/ref/WeakReference;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_mp:Ljava/lang/ref/WeakReference;

    return-object v0
.end method

.method static synthetic access$5(Lcom/uplynk/media/CaptionManager;)I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    return v0
.end method

.method static synthetic access$6(Lcom/uplynk/media/CaptionManager;)I
    .locals 1

    .prologue
    .line 66
    iget v0, p0, Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I

    return v0
.end method

.method static synthetic access$7(Lcom/uplynk/media/CaptionManager;)I
    .locals 1

    .prologue
    .line 74
    iget v0, p0, Lcom/uplynk/media/CaptionManager;->_ccLayoutHeight:I

    return v0
.end method

.method static synthetic access$8(Lcom/uplynk/media/CaptionManager;)I
    .locals 1

    .prologue
    .line 67
    iget v0, p0, Lcom/uplynk/media/CaptionManager;->_ccColSize:I

    return v0
.end method

.method static synthetic access$9(Lcom/uplynk/media/CaptionManager;)I
    .locals 1

    .prologue
    .line 69
    iget v0, p0, Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I

    return v0
.end method

.method private checkForDuplicateCommands(CC)Z
    .locals 1
    .param p1, "data1"    # C
    .param p2, "data2"    # C

    .prologue
    .line 401
    iget-char v0, p0, Lcom/uplynk/media/CaptionManager;->_lastData1:C

    if-ne v0, p1, :cond_0

    iget-char v0, p0, Lcom/uplynk/media/CaptionManager;->_lastData2:C

    if-ne v0, p2, :cond_0

    .line 404
    const/4 v0, 0x1

    .line 407
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static concat([S[S)[S
    .locals 4
    .param p0, "data"    # [S
    .param p1, "rd"    # [S

    .prologue
    .line 2670
    array-length v1, p0

    array-length v2, p1

    add-int/2addr v1, v2

    invoke-static {p0, v1}, Ljava/util/Arrays;->copyOf([SI)[S

    move-result-object v0

    .line 2671
    .local v0, "result":[S
    const/4 v1, 0x0

    array-length v2, p0

    array-length v3, p1

    invoke-static {p1, v1, v0, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2672
    return-object v0
.end method

.method private decodeCCStyle(C)V
    .locals 8
    .param p1, "data1"    # C

    .prologue
    const/16 v7, 0xa

    const/16 v6, 0x8

    const/4 v5, 0x6

    const/4 v4, 0x4

    const/4 v3, 0x2

    .line 348
    and-int/lit8 v1, p1, 0x10

    const/16 v2, 0x10

    if-ne v1, v2, :cond_a

    .line 350
    const/4 v0, 0x0

    .line 351
    .local v0, "col":I
    and-int/lit8 v1, p1, 0xe

    if-nez v1, :cond_3

    .line 352
    const/4 v0, 0x0

    .line 369
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v1, v0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->column(I)V

    .line 370
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const v2, 0xffffff

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->color(I)V

    .line 394
    .end local v0    # "col":I
    :cond_1
    :goto_1
    and-int/lit8 v1, p1, 0x1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_2

    .line 395
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->underlined()V

    .line 397
    :cond_2
    return-void

    .line 353
    .restart local v0    # "col":I
    :cond_3
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v3, :cond_4

    .line 354
    const/4 v0, 0x4

    .line 355
    goto :goto_0

    :cond_4
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v4, :cond_5

    .line 356
    const/16 v0, 0x8

    .line 357
    goto :goto_0

    :cond_5
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v5, :cond_6

    .line 358
    const/16 v0, 0xc

    .line 359
    goto :goto_0

    :cond_6
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v6, :cond_7

    .line 360
    const/16 v0, 0x10

    .line 361
    goto :goto_0

    :cond_7
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v7, :cond_8

    .line 362
    const/16 v0, 0x14

    .line 363
    goto :goto_0

    :cond_8
    and-int/lit8 v1, p1, 0xe

    const/16 v2, 0xc

    if-ne v1, v2, :cond_9

    .line 364
    const/16 v0, 0x18

    .line 365
    goto :goto_0

    :cond_9
    and-int/lit8 v1, p1, 0xe

    const/16 v2, 0xe

    if-ne v1, v2, :cond_0

    .line 366
    const/16 v0, 0x1c

    goto :goto_0

    .line 375
    .end local v0    # "col":I
    :cond_a
    and-int/lit8 v1, p1, 0xe

    if-nez v1, :cond_b

    .line 376
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const v2, 0xffffff

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->color(I)V

    goto :goto_1

    .line 377
    :cond_b
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v3, :cond_c

    .line 378
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const v2, 0xff00

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->color(I)V

    goto :goto_1

    .line 379
    :cond_c
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v4, :cond_d

    .line 380
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v2, 0xff

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->color(I)V

    goto :goto_1

    .line 381
    :cond_d
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v5, :cond_e

    .line 382
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const v2, 0xffff

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->color(I)V

    goto :goto_1

    .line 383
    :cond_e
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v6, :cond_f

    .line 384
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/high16 v2, 0xff0000

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->color(I)V

    goto :goto_1

    .line 385
    :cond_f
    and-int/lit8 v1, p1, 0xe

    if-ne v1, v7, :cond_10

    .line 386
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const v2, 0xffff00

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->color(I)V

    goto/16 :goto_1

    .line 387
    :cond_10
    and-int/lit8 v1, p1, 0xe

    const/16 v2, 0xc

    if-ne v1, v2, :cond_11

    .line 388
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const v2, 0xff00ff

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->color(I)V

    goto/16 :goto_1

    .line 389
    :cond_11
    and-int/lit8 v1, p1, 0xe

    const/16 v2, 0xe

    if-ne v1, v2, :cond_1

    .line 390
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->italic()V

    goto/16 :goto_1
.end method


# virtual methods
.method protected clearDisplay()V
    .locals 1

    .prologue
    .line 331
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/uplynk/media/CaptionManager;->clearDisplay(Z)V

    .line 332
    return-void
.end method

.method protected clearDisplay(Z)V
    .locals 1
    .param p1, "immediate"    # Z

    .prologue
    .line 340
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    if-eqz v0, :cond_0

    .line 341
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/CaptionManager$OverlayView;->clear(Z)V

    .line 344
    :cond_0
    return-void
.end method

.method protected getEventHandler()Lcom/uplynk/media/CaptionManager$CCEventHandler;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    return-object v0
.end method

.method protected processPacket(CCC)V
    .locals 10
    .param p1, "data1"    # C
    .param p2, "data2"    # C
    .param p3, "fieldType"    # C

    .prologue
    const/4 v9, 0x3

    const/4 v8, 0x2

    const/16 v7, 0x40

    const/4 v6, 0x1

    const/16 v5, 0x14

    .line 427
    and-int/lit8 v3, p1, 0x7f

    int-to-char p1, v3

    .line 428
    and-int/lit8 v3, p2, 0x7f

    int-to-char p2, v3

    .line 430
    if-nez p1, :cond_1

    if-nez p2, :cond_1

    .line 432
    const-string v3, "upLynkCaptionManager"

    const-string v4, "Empty CC"

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 678
    :cond_0
    :goto_0
    return-void

    .line 436
    :cond_1
    if-lt p1, v6, :cond_2

    const/16 v3, 0xe

    if-gt p1, v3, :cond_2

    if-ne p3, v6, :cond_2

    .line 438
    iput-boolean v6, p0, Lcom/uplynk/media/CaptionManager;->inXdsMode:Z

    .line 441
    :cond_2
    const/16 v3, 0xf

    if-ne p1, v3, :cond_3

    iget-boolean v3, p0, Lcom/uplynk/media/CaptionManager;->inXdsMode:Z

    if-eqz v3, :cond_3

    if-ne p3, v6, :cond_3

    .line 443
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/uplynk/media/CaptionManager;->inXdsMode:Z

    goto :goto_0

    .line 450
    :cond_3
    const/16 v3, 0x10

    if-lt p1, v3, :cond_39

    const/16 v3, 0x1f

    if-ge p1, v3, :cond_39

    .line 452
    invoke-direct {p0, p1, p2}, Lcom/uplynk/media/CaptionManager;->checkForDuplicateCommands(CC)Z

    move-result v3

    if-nez v3, :cond_0

    .line 455
    and-int/lit8 v3, p1, 0x8

    const/16 v4, 0x8

    if-eq v3, v4, :cond_9

    if-nez p3, :cond_9

    .line 456
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/uplynk/media/CaptionManager;->updateCurrentChannel(I)V

    .line 465
    :cond_4
    :goto_1
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    if-eqz v3, :cond_0

    .line 469
    iget v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannelIndex:I

    iget v4, p0, Lcom/uplynk/media/CaptionManager;->_preferredChannelIndex:I

    if-ne v3, v4, :cond_0

    .line 477
    and-int/lit8 v0, p1, 0x77

    .line 478
    .local v0, "CONTROL_BYTE":I
    and-int/lit8 v1, p2, 0x60

    .line 480
    .local v1, "PAC_ROW":I
    const/16 v3, 0x11

    if-ne v0, v3, :cond_c

    if-ne v1, v7, :cond_c

    .line 481
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3, v6}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 482
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    .line 528
    :cond_5
    :goto_2
    const/16 v3, 0x11

    if-ne v0, v3, :cond_6

    and-int/lit8 v3, p2, 0x70

    const/16 v4, 0x20

    if-ne v3, v4, :cond_6

    .line 530
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    .line 531
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x20

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    .line 536
    :cond_6
    if-ne v0, v5, :cond_1a

    const/16 v3, 0x20

    if-ne p2, v3, :cond_1a

    .line 538
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    sget-object v4, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->mode(Lcom/uplynk/media/CaptionEvent$CaptionMode;)V

    .line 604
    :cond_7
    :goto_3
    const/16 v3, 0x11

    if-ne v0, v3, :cond_8

    and-int/lit8 v3, p2, 0x70

    const/16 v4, 0x30

    if-ne v3, v4, :cond_8

    .line 606
    and-int/lit8 v2, p2, 0xf

    .line 607
    .local v2, "character":I
    if-nez v2, :cond_2a

    .line 608
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xa9

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    .line 676
    .end local v0    # "CONTROL_BYTE":I
    .end local v1    # "PAC_ROW":I
    .end local v2    # "character":I
    :cond_8
    :goto_4
    iput-char p1, p0, Lcom/uplynk/media/CaptionManager;->_lastData1:C

    .line 677
    iput-char p2, p0, Lcom/uplynk/media/CaptionManager;->_lastData2:C

    goto/16 :goto_0

    .line 457
    :cond_9
    and-int/lit8 v3, p1, 0x8

    const/16 v4, 0x8

    if-ne v3, v4, :cond_a

    if-nez p3, :cond_a

    .line 458
    invoke-virtual {p0, v6}, Lcom/uplynk/media/CaptionManager;->updateCurrentChannel(I)V

    goto :goto_1

    .line 459
    :cond_a
    and-int/lit8 v3, p1, 0x8

    const/16 v4, 0x8

    if-eq v3, v4, :cond_b

    if-ne p3, v6, :cond_b

    .line 460
    invoke-virtual {p0, v8}, Lcom/uplynk/media/CaptionManager;->updateCurrentChannel(I)V

    goto :goto_1

    .line 461
    :cond_b
    and-int/lit8 v3, p1, 0x8

    const/16 v4, 0x8

    if-ne v3, v4, :cond_4

    if-ne p3, v6, :cond_4

    .line 462
    invoke-virtual {p0, v9}, Lcom/uplynk/media/CaptionManager;->updateCurrentChannel(I)V

    goto :goto_1

    .line 483
    .restart local v0    # "CONTROL_BYTE":I
    .restart local v1    # "PAC_ROW":I
    :cond_c
    const/16 v3, 0x11

    if-ne v0, v3, :cond_d

    const/16 v3, 0x60

    if-ne v1, v3, :cond_d

    .line 484
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3, v8}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 485
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto :goto_2

    .line 486
    :cond_d
    const/16 v3, 0x12

    if-ne v0, v3, :cond_e

    if-ne v1, v7, :cond_e

    .line 487
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3, v9}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 488
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto :goto_2

    .line 489
    :cond_e
    const/16 v3, 0x12

    if-ne v0, v3, :cond_f

    const/16 v3, 0x60

    if-ne v1, v3, :cond_f

    .line 490
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 491
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 492
    :cond_f
    const/16 v3, 0x15

    if-ne v0, v3, :cond_10

    if-ne v1, v7, :cond_10

    .line 493
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/4 v4, 0x5

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 494
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 495
    :cond_10
    const/16 v3, 0x15

    if-ne v0, v3, :cond_11

    const/16 v3, 0x60

    if-ne v1, v3, :cond_11

    .line 496
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/4 v4, 0x6

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 497
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 498
    :cond_11
    const/16 v3, 0x16

    if-ne v0, v3, :cond_12

    if-ne v1, v7, :cond_12

    .line 499
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/4 v4, 0x7

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 500
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 501
    :cond_12
    const/16 v3, 0x16

    if-ne v0, v3, :cond_13

    const/16 v3, 0x60

    if-ne v1, v3, :cond_13

    .line 502
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 503
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 504
    :cond_13
    const/16 v3, 0x17

    if-ne v0, v3, :cond_14

    if-ne v1, v7, :cond_14

    .line 505
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x9

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 506
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 507
    :cond_14
    const/16 v3, 0x17

    if-ne v0, v3, :cond_15

    const/16 v3, 0x60

    if-ne v1, v3, :cond_15

    .line 508
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 509
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 510
    :cond_15
    const/16 v3, 0x10

    if-ne v0, v3, :cond_16

    if-ne v1, v7, :cond_16

    .line 511
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xb

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 512
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 513
    :cond_16
    const/16 v3, 0x13

    if-ne v0, v3, :cond_17

    if-ne v1, v7, :cond_17

    .line 514
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xc

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 515
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 516
    :cond_17
    const/16 v3, 0x13

    if-ne v0, v3, :cond_18

    const/16 v3, 0x60

    if-ne v1, v3, :cond_18

    .line 517
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xd

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 518
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 519
    :cond_18
    if-ne v0, v5, :cond_19

    if-ne v1, v7, :cond_19

    .line 520
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xe

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 521
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 522
    :cond_19
    if-ne v0, v5, :cond_5

    const/16 v3, 0x60

    if-ne v1, v3, :cond_5

    .line 523
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xf

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->startNewRow(I)V

    .line 524
    invoke-direct {p0, p2}, Lcom/uplynk/media/CaptionManager;->decodeCCStyle(C)V

    goto/16 :goto_2

    .line 540
    :cond_1a
    if-ne v0, v5, :cond_1b

    const/16 v3, 0x21

    if-ne p2, v3, :cond_1b

    .line 542
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->backspace()V

    goto/16 :goto_3

    .line 544
    :cond_1b
    if-ne v0, v5, :cond_1c

    const/16 v3, 0x24

    if-ne p2, v3, :cond_1c

    .line 546
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->clearEndOfRow()V

    goto/16 :goto_3

    .line 548
    :cond_1c
    if-ne v0, v5, :cond_1d

    const/16 v3, 0x25

    if-ne p2, v3, :cond_1d

    .line 550
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    sget-object v4, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->mode(Lcom/uplynk/media/CaptionEvent$CaptionMode;)V

    .line 551
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iput-short v8, v3, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rowCount:S

    goto/16 :goto_3

    .line 553
    :cond_1d
    if-ne v0, v5, :cond_1e

    const/16 v3, 0x26

    if-ne p2, v3, :cond_1e

    .line 555
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    sget-object v4, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->mode(Lcom/uplynk/media/CaptionEvent$CaptionMode;)V

    .line 556
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iput-short v9, v3, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rowCount:S

    goto/16 :goto_3

    .line 558
    :cond_1e
    if-ne v0, v5, :cond_1f

    const/16 v3, 0x27

    if-ne p2, v3, :cond_1f

    .line 560
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    sget-object v4, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->mode(Lcom/uplynk/media/CaptionEvent$CaptionMode;)V

    .line 561
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/4 v4, 0x4

    iput-short v4, v3, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rowCount:S

    goto/16 :goto_3

    .line 563
    :cond_1f
    if-ne v0, v5, :cond_20

    const/16 v3, 0x28

    if-eq p2, v3, :cond_7

    .line 566
    :cond_20
    if-ne v0, v5, :cond_21

    const/16 v3, 0x29

    if-ne p2, v3, :cond_21

    .line 568
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    sget-object v4, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->mode(Lcom/uplynk/media/CaptionEvent$CaptionMode;)V

    goto/16 :goto_3

    .line 570
    :cond_21
    if-ne v0, v5, :cond_22

    const/16 v3, 0x2a

    if-eq p2, v3, :cond_7

    .line 573
    :cond_22
    if-ne v0, v5, :cond_23

    const/16 v3, 0x2b

    if-eq p2, v3, :cond_7

    .line 576
    :cond_23
    if-ne v0, v5, :cond_24

    const/16 v3, 0x2c

    if-ne p2, v3, :cond_24

    .line 578
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->eraseDisplayMemory()V

    goto/16 :goto_3

    .line 580
    :cond_24
    if-ne v0, v5, :cond_25

    const/16 v3, 0x2d

    if-ne p2, v3, :cond_25

    .line 582
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->linebreak()V

    goto/16 :goto_3

    .line 584
    :cond_25
    if-ne v0, v5, :cond_26

    const/16 v3, 0x2e

    if-ne p2, v3, :cond_26

    .line 586
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->clearAll()V

    goto/16 :goto_3

    .line 588
    :cond_26
    if-ne v0, v5, :cond_27

    const/16 v3, 0x2f

    if-ne p2, v3, :cond_27

    .line 590
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->flush()V

    goto/16 :goto_3

    .line 592
    :cond_27
    const/16 v3, 0x17

    if-ne v0, v3, :cond_28

    const/16 v3, 0x21

    if-ne p2, v3, :cond_28

    .line 594
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3, v6}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->indent(I)V

    goto/16 :goto_3

    .line 595
    :cond_28
    const/16 v3, 0x17

    if-ne v0, v3, :cond_29

    const/16 v3, 0x22

    if-ne p2, v3, :cond_29

    .line 597
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3, v8}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->indent(I)V

    goto/16 :goto_3

    .line 598
    :cond_29
    const/16 v3, 0x17

    if-ne v0, v3, :cond_7

    const/16 v3, 0x23

    if-ne p2, v3, :cond_7

    .line 600
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3, v9}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->indent(I)V

    goto/16 :goto_3

    .line 609
    .restart local v2    # "character":I
    :cond_2a
    if-ne v2, v6, :cond_2b

    .line 610
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xa7

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 611
    :cond_2b
    if-ne v2, v8, :cond_2c

    .line 612
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xab

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 613
    :cond_2c
    if-ne v2, v9, :cond_2d

    .line 614
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0xa8

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 615
    :cond_2d
    const/4 v3, 0x4

    if-ne v2, v3, :cond_2e

    .line 616
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x2122

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 617
    :cond_2e
    const/4 v3, 0x5

    if-ne v2, v3, :cond_2f

    .line 618
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x9b

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 619
    :cond_2f
    const/4 v3, 0x6

    if-ne v2, v3, :cond_30

    .line 620
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x9c

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 621
    :cond_30
    const/4 v3, 0x7

    if-ne v2, v3, :cond_31

    .line 622
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x266a

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 623
    :cond_31
    const/16 v3, 0x8

    if-ne v2, v3, :cond_32

    .line 624
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x85

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 625
    :cond_32
    const/16 v3, 0x9

    if-ne v2, v3, :cond_33

    .line 626
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x20

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 627
    :cond_33
    const/16 v3, 0xa

    if-ne v2, v3, :cond_34

    .line 628
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x8a

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 629
    :cond_34
    const/16 v3, 0xb

    if-ne v2, v3, :cond_35

    .line 630
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x83

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 631
    :cond_35
    const/16 v3, 0xc

    if-ne v2, v3, :cond_36

    .line 632
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x88

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 633
    :cond_36
    const/16 v3, 0xd

    if-ne v2, v3, :cond_37

    .line 634
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x8c

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 635
    :cond_37
    const/16 v3, 0xe

    if-ne v2, v3, :cond_38

    .line 636
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x93

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 637
    :cond_38
    const/16 v3, 0xf

    if-ne v2, v3, :cond_8

    .line 638
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    const/16 v4, 0x96

    invoke-virtual {v3, v4}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 645
    .end local v0    # "CONTROL_BYTE":I
    .end local v1    # "PAC_ROW":I
    .end local v2    # "character":I
    :cond_39
    iget-boolean v3, p0, Lcom/uplynk/media/CaptionManager;->inXdsMode:Z

    if-eqz v3, :cond_3a

    if-eq p3, v6, :cond_0

    .line 650
    :cond_3a
    const/16 v3, 0x20

    if-lt p1, v3, :cond_8

    const/16 v3, 0x7e

    if-ge p1, v3, :cond_8

    .line 655
    if-nez p3, :cond_3c

    iget v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannelIndex:I

    if-ne v3, v8, :cond_3c

    .line 656
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/uplynk/media/CaptionManager;->updateCurrentChannel(I)V

    .line 665
    :cond_3b
    :goto_5
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    if-eqz v3, :cond_0

    .line 668
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3, p1}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    .line 669
    const/16 v3, 0x20

    if-lt p2, v3, :cond_8

    const/16 v3, 0x7e

    if-ge p2, v3, :cond_8

    .line 670
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-virtual {v3, p2}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->appendText(C)V

    goto/16 :goto_4

    .line 657
    :cond_3c
    if-nez p3, :cond_3d

    iget v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannelIndex:I

    if-ne v3, v9, :cond_3d

    .line 658
    invoke-virtual {p0, v6}, Lcom/uplynk/media/CaptionManager;->updateCurrentChannel(I)V

    goto :goto_5

    .line 659
    :cond_3d
    if-ne p3, v6, :cond_3e

    iget v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannelIndex:I

    if-nez v3, :cond_3e

    .line 660
    invoke-virtual {p0, v8}, Lcom/uplynk/media/CaptionManager;->updateCurrentChannel(I)V

    goto :goto_5

    .line 661
    :cond_3e
    if-ne p3, v6, :cond_3b

    iget v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannelIndex:I

    if-ne v3, v6, :cond_3b

    .line 662
    invoke-virtual {p0, v9}, Lcom/uplynk/media/CaptionManager;->updateCurrentChannel(I)V

    goto :goto_5
.end method

.method protected release()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 133
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 136
    iput-object v1, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    .line 139
    :cond_0
    invoke-virtual {p0}, Lcom/uplynk/media/CaptionManager;->reset()V

    .line 140
    invoke-virtual {p0, v1}, Lcom/uplynk/media/CaptionManager;->setLayoutContainer(Landroid/widget/RelativeLayout;)V

    .line 142
    iput-object v1, p0, Lcom/uplynk/media/CaptionManager;->_layoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    .line 143
    iput-object v1, p0, Lcom/uplynk/media/CaptionManager;->_activeLineText:Ljava/lang/StringBuffer;

    .line 144
    iput-object v1, p0, Lcom/uplynk/media/CaptionManager;->_style:Lcom/uplynk/media/CaptionStyle;

    .line 145
    iput-object v1, p0, Lcom/uplynk/media/CaptionManager;->_mp:Ljava/lang/ref/WeakReference;

    .line 146
    return-void
.end method

.method protected renderCCData(I[S)V
    .locals 11
    .param p1, "size"    # I
    .param p2, "data"    # [S

    .prologue
    const/4 v10, 0x0

    .line 752
    const/4 v2, 0x0

    .line 754
    .local v2, "pos":I
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 757
    .local v1, "line":Ljava/lang/StringBuffer;
    invoke-virtual {p0}, Lcom/uplynk/media/CaptionManager;->clearDisplay()V

    .line 759
    :goto_0
    add-int/lit8 v7, v2, 0x3

    if-lt v7, p1, :cond_1

    .line 794
    iget-boolean v7, p0, Lcom/uplynk/media/CaptionManager;->_ccEnabled:Z

    if-eqz v7, :cond_0

    iget-object v7, p0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    if-eqz v7, :cond_0

    .line 796
    iget-object v7, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    const-wide/16 v8, 0xfa0

    invoke-virtual {v7, v10, v8, v9}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 798
    :cond_0
    :goto_1
    return-void

    .line 762
    :cond_1
    aget-short v3, p2, v2

    .line 763
    .local v3, "r":I
    add-int/lit8 v7, v2, 0x1

    aget-short v4, p2, v7

    .line 764
    .local v4, "rc":I
    add-int/lit8 v7, v2, 0x2

    aget-short v6, p2, v7

    .line 765
    .local v6, "rs":I
    add-int/lit8 v7, v2, 0x3

    aget-short v5, p2, v7

    .line 767
    .local v5, "rl":I
    add-int/lit8 v2, v2, 0x4

    .line 769
    const/4 v7, 0x4

    if-ne p1, v7, :cond_2

    .line 771
    const-string v7, "upLynkCaptionManager"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "CC Packet Data Size 4, text size = "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 775
    :cond_2
    const/16 v7, 0x20

    if-le v5, v7, :cond_3

    .line 777
    const-string v7, "upLynkCaptionManager"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "CC Packet Row Length > 32 ("

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ")"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 782
    :cond_3
    move v0, v2

    .local v0, "i":I
    :goto_2
    add-int v7, v5, v2

    if-lt v0, v7, :cond_4

    .line 786
    add-int/2addr v2, v5

    .line 791
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->length()I

    move-result v7

    invoke-virtual {v1, v10, v7}, Ljava/lang/StringBuffer;->delete(II)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 784
    :cond_4
    aget-short v7, p2, v0

    int-to-char v7, v7

    invoke-virtual {v1, v7}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 782
    add-int/lit8 v0, v0, 0x1

    goto :goto_2
.end method

.method protected renderCCStreamItem(Lcom/uplynk/media/CaptionManager$CaptionQueueItem;)V
    .locals 9
    .param p1, "item"    # Lcom/uplynk/media/CaptionManager$CaptionQueueItem;

    .prologue
    const/4 v2, 0x1

    const/4 v6, 0x0

    .line 683
    iget v0, p0, Lcom/uplynk/media/CaptionManager;->_currentChannelIndex:I

    iget-short v3, p1, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->channel:S

    if-eq v0, v3, :cond_0

    .line 685
    const-string v0, "upLynkCaptionManager"

    const-string v3, "IGNORING CaptionQueueItem From Wrong Channel"

    invoke-static {v0, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 688
    :cond_0
    invoke-static {}, Lcom/uplynk/media/CaptionManager;->$SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction()[I

    move-result-object v0

    iget-object v3, p1, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->action:Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager$CaptionAction;->ordinal()I

    move-result v3

    aget v0, v0, v3

    packed-switch v0, :pswitch_data_0

    .line 718
    :goto_0
    :pswitch_0
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_mp:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/MediaPlayer;

    iget-object v0, v0, Lcom/uplynk/media/MediaPlayer;->mOnCaptionEventListener:Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

    if-eqz v0, :cond_4

    move v7, v2

    .line 719
    .local v7, "hasListener":Z
    :goto_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    if-eqz v0, :cond_5

    iget-boolean v0, p0, Lcom/uplynk/media/CaptionManager;->_ccEnabled:Z

    if-eqz v0, :cond_5

    move v8, v2

    .line 721
    .local v8, "shouldRender":Z
    :goto_2
    if-nez v7, :cond_1

    if-eqz v8, :cond_3

    .line 723
    :cond_1
    iget-object v0, p1, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->action:Lcom/uplynk/media/CaptionManager$CaptionAction;

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->TEXT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    if-ne v0, v2, :cond_6

    .line 725
    new-instance v1, Lcom/uplynk/media/CaptionEvent;

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-object v0, v0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v2, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-short v3, v3, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rowCount:S

    invoke-direct {v1, v0, v2, v3}, Lcom/uplynk/media/CaptionEvent;-><init>(Lcom/uplynk/media/CaptionEvent$CaptionMode;Lcom/uplynk/media/CaptionEvent$CaptionEventType;S)V

    .line 726
    .local v1, "e":Lcom/uplynk/media/CaptionEvent;
    new-instance v0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v2, p1, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->value:I

    int-to-short v2, v2

    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget v3, v3, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_color:I

    iget-object v4, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-boolean v4, v4, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_italic:Z

    iget-object v5, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-boolean v5, v5, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_underlined:Z

    invoke-direct/range {v0 .. v6}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;-><init>(Lcom/uplynk/media/CaptionEvent;SIZZZ)V

    iput-object v0, v1, Lcom/uplynk/media/CaptionEvent;->character:Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

    .line 728
    if-eqz v8, :cond_2

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager$OverlayView;->renderCaptionEvent(Lcom/uplynk/media/CaptionEvent;)V

    .line 730
    :cond_2
    if-eqz v7, :cond_3

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_mp:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/MediaPlayer;

    iget-object v0, v0, Lcom/uplynk/media/MediaPlayer;->mOnCaptionEventListener:Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    # getter for: Lcom/uplynk/media/CaptionManager$CCEventHandler;->_mediaPlayer:Lcom/uplynk/media/MediaPlayer;
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->access$0(Lcom/uplynk/media/CaptionManager$CCEventHandler;)Lcom/uplynk/media/MediaPlayer;

    move-result-object v2

    invoke-interface {v0, v2, v1}, Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;->onCaptionEvent(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/CaptionEvent;)Z

    .line 747
    .end local v1    # "e":Lcom/uplynk/media/CaptionEvent;
    :cond_3
    :goto_3
    return-void

    .line 690
    .end local v7    # "hasListener":Z
    .end local v8    # "shouldRender":Z
    :pswitch_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget v3, p1, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->value:I

    # invokes: Lcom/uplynk/media/CaptionManager$CaptionChannel;->doColor(I)V
    invoke-static {v0, v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->access$3(Lcom/uplynk/media/CaptionManager$CaptionChannel;I)V

    goto :goto_0

    .line 691
    :pswitch_2
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    # invokes: Lcom/uplynk/media/CaptionManager$CaptionChannel;->doItalic()V
    invoke-static {v0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->access$4(Lcom/uplynk/media/CaptionManager$CaptionChannel;)V

    goto :goto_0

    .line 692
    :pswitch_3
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    # invokes: Lcom/uplynk/media/CaptionManager$CaptionChannel;->doUnderlined()V
    invoke-static {v0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->access$5(Lcom/uplynk/media/CaptionManager$CaptionChannel;)V

    goto :goto_0

    .line 693
    :pswitch_4
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget v3, p1, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->value:I

    int-to-char v3, v3

    # invokes: Lcom/uplynk/media/CaptionManager$CaptionChannel;->doAppendText(C)V
    invoke-static {v0, v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->access$6(Lcom/uplynk/media/CaptionManager$CaptionChannel;C)V

    goto/16 :goto_0

    :cond_4
    move v7, v6

    .line 718
    goto :goto_1

    .restart local v7    # "hasListener":Z
    :cond_5
    move v8, v6

    .line 719
    goto :goto_2

    .line 732
    .restart local v8    # "shouldRender":Z
    :cond_6
    iget-object v0, p1, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->action:Lcom/uplynk/media/CaptionManager$CaptionAction;

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->LINEBREAK:Lcom/uplynk/media/CaptionManager$CaptionAction;

    if-ne v0, v2, :cond_8

    .line 734
    new-instance v1, Lcom/uplynk/media/CaptionEvent;

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-object v0, v0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v2, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->LINEBREAK:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-short v3, v3, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rowCount:S

    invoke-direct {v1, v0, v2, v3}, Lcom/uplynk/media/CaptionEvent;-><init>(Lcom/uplynk/media/CaptionEvent$CaptionMode;Lcom/uplynk/media/CaptionEvent$CaptionEventType;S)V

    .line 736
    .restart local v1    # "e":Lcom/uplynk/media/CaptionEvent;
    if-eqz v8, :cond_7

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager$OverlayView;->renderCaptionEvent(Lcom/uplynk/media/CaptionEvent;)V

    .line 738
    :cond_7
    if-eqz v7, :cond_3

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_mp:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/MediaPlayer;

    iget-object v0, v0, Lcom/uplynk/media/MediaPlayer;->mOnCaptionEventListener:Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    # getter for: Lcom/uplynk/media/CaptionManager$CCEventHandler;->_mediaPlayer:Lcom/uplynk/media/MediaPlayer;
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->access$0(Lcom/uplynk/media/CaptionManager$CCEventHandler;)Lcom/uplynk/media/MediaPlayer;

    move-result-object v2

    invoke-interface {v0, v2, v1}, Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;->onCaptionEvent(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/CaptionEvent;)Z

    goto :goto_3

    .line 740
    .end local v1    # "e":Lcom/uplynk/media/CaptionEvent;
    :cond_8
    iget-object v0, p1, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->action:Lcom/uplynk/media/CaptionManager$CaptionAction;

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->ERASE_DISPLAY_MEM:Lcom/uplynk/media/CaptionManager$CaptionAction;

    if-ne v0, v2, :cond_3

    .line 742
    new-instance v1, Lcom/uplynk/media/CaptionEvent;

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-object v0, v0, Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v2, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->CLEAR:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    iget-object v3, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-short v3, v3, Lcom/uplynk/media/CaptionManager$CaptionChannel;->rowCount:S

    invoke-direct {v1, v0, v2, v3}, Lcom/uplynk/media/CaptionEvent;-><init>(Lcom/uplynk/media/CaptionEvent$CaptionMode;Lcom/uplynk/media/CaptionEvent$CaptionEventType;S)V

    .line 744
    .restart local v1    # "e":Lcom/uplynk/media/CaptionEvent;
    if-eqz v7, :cond_3

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_mp:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/MediaPlayer;

    iget-object v0, v0, Lcom/uplynk/media/MediaPlayer;->mOnCaptionEventListener:Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    # getter for: Lcom/uplynk/media/CaptionManager$CCEventHandler;->_mediaPlayer:Lcom/uplynk/media/MediaPlayer;
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->access$0(Lcom/uplynk/media/CaptionManager$CCEventHandler;)Lcom/uplynk/media/MediaPlayer;

    move-result-object v2

    invoke-interface {v0, v2, v1}, Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;->onCaptionEvent(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/CaptionEvent;)Z

    goto :goto_3

    .line 688
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_0
    .end packed-switch
.end method

.method protected reset()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 151
    iput v4, p0, Lcom/uplynk/media/CaptionManager;->_activeRowCount:I

    .line 152
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_activeLineText:Ljava/lang/StringBuffer;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->setLength(I)V

    .line 155
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_captions:Landroid/util/SparseArray;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_captions:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 157
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_captions:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->size()I

    move-result v2

    if-lt v1, v2, :cond_1

    .line 169
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {p0, v4}, Lcom/uplynk/media/CaptionManager;->clearDisplay(Z)V

    .line 170
    return-void

    .line 160
    .restart local v1    # "i":I
    :cond_1
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_captions:Landroid/util/SparseArray;

    invoke-virtual {v2, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionManager$CaptionChannel;

    .line 161
    .local v0, "cc":Lcom/uplynk/media/CaptionManager$CaptionChannel;
    if-eqz v0, :cond_2

    .line 163
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->reset()V

    .line 157
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method protected setCaptionStyle(Lcom/uplynk/media/CaptionStyle;)V
    .locals 2
    .param p1, "style"    # Lcom/uplynk/media/CaptionStyle;

    .prologue
    .line 214
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager;->_style:Lcom/uplynk/media/CaptionStyle;

    .line 215
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_style:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager$OverlayView;->setStyle(Lcom/uplynk/media/CaptionStyle;)V

    .line 216
    :cond_0
    invoke-virtual {p0}, Lcom/uplynk/media/CaptionManager;->updateMetrics()V

    .line 217
    return-void
.end method

.method protected setEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 181
    iput-boolean p1, p0, Lcom/uplynk/media/CaptionManager;->_ccEnabled:Z

    .line 183
    if-nez p1, :cond_0

    .line 185
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/uplynk/media/CaptionManager;->clearDisplay(Z)V

    .line 187
    :cond_0
    return-void
.end method

.method protected setEventHandler(Lcom/uplynk/media/CaptionManager$CCEventHandler;)V
    .locals 0
    .param p1, "handler"    # Lcom/uplynk/media/CaptionManager$CCEventHandler;

    .prologue
    .line 176
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager;->_ccEventHandler:Lcom/uplynk/media/CaptionManager$CCEventHandler;

    .line 177
    return-void
.end method

.method public setLayoutContainer(Landroid/widget/RelativeLayout;)V
    .locals 5
    .param p1, "layout"    # Landroid/widget/RelativeLayout;

    .prologue
    const/4 v4, 0x0

    const/4 v3, -0x1

    .line 299
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    if-eqz v1, :cond_0

    .line 301
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v1

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_layoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    invoke-virtual {v1, v2}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 304
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    if-eqz v1, :cond_0

    .line 306
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->removeView(Landroid/view/View;)V

    .line 307
    iput-object v4, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    .line 311
    :cond_0
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    .line 313
    if-nez p1, :cond_1

    .line 327
    :goto_0
    return-void

    .line 316
    :cond_1
    new-instance v1, Lcom/uplynk/media/CaptionManager$OverlayView;

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v2}, Landroid/widget/RelativeLayout;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, p0, v2, v4}, Lcom/uplynk/media/CaptionManager$OverlayView;-><init>(Lcom/uplynk/media/CaptionManager;Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    .line 317
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_style:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager$OverlayView;->setStyle(Lcom/uplynk/media/CaptionStyle;)V

    .line 318
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 319
    .local v0, "lp":Landroid/widget/RelativeLayout$LayoutParams;
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    invoke-virtual {v1, v2, v0}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 323
    invoke-virtual {p0}, Lcom/uplynk/media/CaptionManager;->updateMetrics()V

    .line 326
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v1

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager;->_layoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    invoke-virtual {v1, v2}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_0
.end method

.method protected setPreferredCaptionChannel(I)Z
    .locals 2
    .param p1, "index"    # I

    .prologue
    const/4 v0, 0x1

    .line 199
    if-ltz p1, :cond_0

    const/4 v1, 0x3

    if-le p1, v1, :cond_2

    .line 200
    :cond_0
    const/4 v0, 0x0

    .line 208
    :cond_1
    :goto_0
    return v0

    .line 203
    :cond_2
    iget v1, p0, Lcom/uplynk/media/CaptionManager;->_preferredChannelIndex:I

    if-eq p1, v1, :cond_1

    .line 205
    iput p1, p0, Lcom/uplynk/media/CaptionManager;->_preferredChannelIndex:I

    .line 206
    invoke-virtual {p0, v0}, Lcom/uplynk/media/CaptionManager;->clearDisplay(Z)V

    goto :goto_0
.end method

.method protected setPreviewText(IILjava/lang/String;)V
    .locals 1
    .param p1, "row"    # I
    .param p2, "column"    # I
    .param p3, "text"    # Ljava/lang/String;

    .prologue
    .line 221
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    invoke-virtual {v0, p1, p2, p3}, Lcom/uplynk/media/CaptionManager$OverlayView;->setPreviewText(IILjava/lang/String;)V

    .line 222
    :cond_0
    return-void
.end method

.method protected setVideoSize(II)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 191
    iput p1, p0, Lcom/uplynk/media/CaptionManager;->_videoWidth:I

    .line 192
    iput p2, p0, Lcom/uplynk/media/CaptionManager;->_videoHeight:I

    .line 193
    int-to-float v0, p1

    int-to-float v1, p2

    div-float/2addr v0, v1

    iput v0, p0, Lcom/uplynk/media/CaptionManager;->_videoAspectRatio:F

    .line 194
    invoke-virtual {p0}, Lcom/uplynk/media/CaptionManager;->updateMetrics()V

    .line 195
    return-void
.end method

.method protected updateCurrentChannel(I)V
    .locals 2
    .param p1, "channelIndex"    # I

    .prologue
    .line 414
    iput p1, p0, Lcom/uplynk/media/CaptionManager;->_currentChannelIndex:I

    .line 416
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_captions:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    .line 417
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_captions:Landroid/util/SparseArray;

    new-instance v1, Lcom/uplynk/media/CaptionManager$CaptionChannel;

    invoke-direct {v1, p0, p1, p0}, Lcom/uplynk/media/CaptionManager$CaptionChannel;-><init>(Lcom/uplynk/media/CaptionManager;ILcom/uplynk/media/CaptionManager;)V

    invoke-virtual {v0, p1, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 422
    :cond_0
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager;->_captions:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager;->_currentChannel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    .line 423
    return-void
.end method

.method protected updateMetrics()V
    .locals 20

    .prologue
    .line 226
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    if-nez v15, :cond_0

    .line 228
    const/4 v15, 0x0

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccLayoutHeight:I

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccLayoutWidth:I

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccColWidth:I

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowHeight:I

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccColSize:I

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    .line 295
    :goto_0
    return-void

    .line 233
    :cond_0
    const/high16 v5, 0x3f800000    # 1.0f

    .line 237
    .local v5, "density":F
    :try_start_0
    new-instance v6, Landroid/util/DisplayMetrics;

    invoke-direct {v6}, Landroid/util/DisplayMetrics;-><init>()V

    .line 238
    .local v6, "dm":Landroid/util/DisplayMetrics;
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v15}, Landroid/widget/RelativeLayout;->getContext()Landroid/content/Context;

    move-result-object v15

    check-cast v15, Landroid/app/Activity;

    invoke-virtual {v15}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v15

    invoke-interface {v15}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v15

    invoke-virtual {v15, v6}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 239
    iget v5, v6, Landroid/util/DisplayMetrics;->density:F
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 242
    .end local v6    # "dm":Landroid/util/DisplayMetrics;
    :goto_1
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v15}, Landroid/widget/RelativeLayout;->getWidth()I

    move-result v12

    move-object/from16 v0, p0

    iput v12, v0, Lcom/uplynk/media/CaptionManager;->_ccLayoutWidth:I

    .line 243
    .local v12, "w":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v15}, Landroid/widget/RelativeLayout;->getHeight()I

    move-result v7

    move-object/from16 v0, p0

    iput v7, v0, Lcom/uplynk/media/CaptionManager;->_ccLayoutHeight:I

    .line 245
    .local v7, "h":I
    const/high16 v15, 0x41200000    # 10.0f

    mul-float/2addr v15, v5

    float-to-int v11, v15

    .line 248
    .local v11, "vpadding":I
    int-to-float v15, v12

    int-to-float v0, v7

    move/from16 v16, v0

    div-float v4, v15, v16

    .line 250
    .local v4, "containerAspectRatio":F
    move v9, v12

    .line 251
    .local v9, "scaledWidth":I
    move v8, v7

    .line 252
    .local v8, "scaledHeight":I
    const/4 v14, 0x0

    .line 257
    .local v14, "yOffset":I
    move-object/from16 v0, p0

    iget v15, v0, Lcom/uplynk/media/CaptionManager;->_videoAspectRatio:F

    cmpg-float v15, v15, v4

    if-gez v15, :cond_2

    .line 259
    int-to-float v15, v8

    move-object/from16 v0, p0

    iget v0, v0, Lcom/uplynk/media/CaptionManager;->_videoAspectRatio:F

    move/from16 v16, v0

    mul-float v15, v15, v16

    float-to-double v0, v15

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v16

    move-wide/from16 v0, v16

    double-to-int v9, v0

    .line 260
    sub-int v15, v12, v9

    div-int/lit8 v13, v15, 0x2

    .line 261
    .local v13, "xOffset":I
    const/4 v14, 0x0

    .line 270
    :goto_2
    move-object/from16 v0, p0

    iput v13, v0, Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I

    .line 271
    move-object/from16 v0, p0

    iput v14, v0, Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I

    .line 272
    mul-int/lit8 v15, v11, 0x2

    sub-int v15, v8, v15

    div-int/lit8 v15, v15, 0xf

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSizeNormal:I

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    .line 273
    div-int/lit8 v15, v9, 0x40

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccColSize:I

    .line 277
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/uplynk/media/CaptionManager;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v15, v15, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    int-to-double v0, v15

    move-wide/from16 v16, v0

    const-wide/high16 v18, 0x4059000000000000L    # 100.0

    div-double v16, v16, v18

    move-wide/from16 v0, v16

    double-to-float v10, v0

    .line 279
    .local v10, "styleSizeAdjustment":F
    move-object/from16 v0, p0

    iget v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    int-to-float v15, v15

    mul-float/2addr v15, v10

    float-to-int v15, v15

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    .line 281
    move-object/from16 v0, p0

    iget v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSizeNormal:I

    int-to-float v15, v15

    div-float/2addr v15, v5

    float-to-double v0, v15

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v16

    move-wide/from16 v0, v16

    double-to-int v15, v0

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowHeightNormal:I

    .line 282
    move-object/from16 v0, p0

    iget v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    int-to-float v15, v15

    div-float/2addr v15, v5

    float-to-double v0, v15

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v16

    move-wide/from16 v0, v16

    double-to-int v15, v0

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowHeight:I

    .line 283
    move-object/from16 v0, p0

    iget v15, v0, Lcom/uplynk/media/CaptionManager;->_ccColSize:I

    int-to-float v15, v15

    div-float/2addr v15, v5

    float-to-double v0, v15

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v16

    move-wide/from16 v0, v16

    double-to-int v15, v0

    move-object/from16 v0, p0

    iput v15, v0, Lcom/uplynk/media/CaptionManager;->_ccColWidth:I

    .line 285
    move-object/from16 v0, p0

    iget v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    int-to-float v15, v15

    const v16, 0x3fe66666    # 1.8f

    mul-float v16, v16, v5

    div-float v3, v15, v16

    .line 289
    .local v3, "_ccTextSize":F
    move-object/from16 v0, p0

    iget v15, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    int-to-float v15, v15

    sub-float/2addr v15, v3

    const/high16 v16, 0x40c00000    # 6.0f

    div-float v15, v15, v16

    float-to-double v0, v15

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Math;->floor(D)D

    move-result-wide v16

    move-wide/from16 v0, v16

    double-to-int v2, v0

    .line 291
    .local v2, "_ccTextPadding":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    if-eqz v15, :cond_1

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;

    invoke-virtual {v15, v5, v3, v2}, Lcom/uplynk/media/CaptionManager$OverlayView;->setFontMetrics(FFI)V

    .line 293
    :cond_1
    const-string v15, "upLynkCaptionManager"

    const-string v16, "CC Container %dx%d | Content %dx%d x:%d y:%d | rowSize:%d (%d)  colSize:%d (%d)  textSize:%f  textPadding:%d"

    const/16 v17, 0xc

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x1

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x2

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x3

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x4

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x5

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x6

    move-object/from16 v0, p0

    iget v0, v0, Lcom/uplynk/media/CaptionManager;->_ccRowSize:I

    move/from16 v19, v0

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x7

    move-object/from16 v0, p0

    iget v0, v0, Lcom/uplynk/media/CaptionManager;->_ccRowHeight:I

    move/from16 v19, v0

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x8

    move-object/from16 v0, p0

    iget v0, v0, Lcom/uplynk/media/CaptionManager;->_ccColSize:I

    move/from16 v19, v0

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x9

    move-object/from16 v0, p0

    iget v0, v0, Lcom/uplynk/media/CaptionManager;->_ccColWidth:I

    move/from16 v19, v0

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0xa

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0xb

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v17, v18

    invoke-static/range {v16 .. v17}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 265
    .end local v2    # "_ccTextPadding":I
    .end local v3    # "_ccTextSize":F
    .end local v10    # "styleSizeAdjustment":F
    .end local v13    # "xOffset":I
    :cond_2
    int-to-float v15, v9

    move-object/from16 v0, p0

    iget v0, v0, Lcom/uplynk/media/CaptionManager;->_videoAspectRatio:F

    move/from16 v16, v0

    div-float v15, v15, v16

    float-to-double v0, v15

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v16

    move-wide/from16 v0, v16

    double-to-int v8, v0

    .line 266
    sub-int v15, v7, v8

    div-int/lit8 v14, v15, 0x2

    .line 267
    const/4 v13, 0x0

    .restart local v13    # "xOffset":I
    goto/16 :goto_2

    .line 240
    .end local v4    # "containerAspectRatio":F
    .end local v7    # "h":I
    .end local v8    # "scaledHeight":I
    .end local v9    # "scaledWidth":I
    .end local v11    # "vpadding":I
    .end local v12    # "w":I
    .end local v13    # "xOffset":I
    .end local v14    # "yOffset":I
    :catch_0
    move-exception v15

    goto/16 :goto_1
.end method
