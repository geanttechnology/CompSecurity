.class public Lcom/ant/liao/GifDecoder;
.super Ljava/lang/Thread;
.source "GifDecoder.java"


# static fields
.field private static final MAX_QUEUE:I = 0xf

.field private static final MaxStackSize:I = 0x1000

.field public static final STATUS_FINISH:I = -0x1

.field public static final STATUS_FORMAT_ERROR:I = 0x1

.field public static final STATUS_OPEN_ERROR:I = 0x2

.field public static final STATUS_PARSING:I


# instance fields
.field private act:[I

.field private action:Lcom/ant/liao/GifAction;

.field private backUpIn:Ljava/io/InputStream;

.field private bgColor:I

.field private bgIndex:I

.field private block:[B

.field private blockSize:I

.field private delay:I

.field private dest:[I

.field private dispose:I

.field private fileType:I

.field private frameCache:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/ant/liao/GifFrame;",
            ">;"
        }
    .end annotation
.end field

.field private frameCount:I

.field private frameQueue:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/ant/liao/GifFrame;",
            ">;"
        }
    .end annotation
.end field

.field private gct:[I

.field private gctFlag:Z

.field private gctSize:I

.field private gifData:[B

.field public height:I

.field private iCurrentFrame:I

.field private icacheParse:I

.field private ih:I

.field private image:Landroid/graphics/Bitmap;

.field private in:Ljava/io/InputStream;

.field private interlace:Z

.field public isDestroy:Z

.field private isLoop:Z

.field private iw:I

.field private ix:I

.field private iy:I

.field private lastBgColor:I

.field private lastDispose:I

.field private lastImage:Landroid/graphics/Bitmap;

.field private lct:[I

.field private lctFlag:Z

.field private lctSize:I

.field private final lock:Ljava/util/concurrent/locks/ReentrantLock;

.field private loopCache:Z

.field private loopCount:I

.field private loopParse:Z

.field private lrh:I

.field private lrw:I

.field private lrx:I

.field private lry:I

.field private pixelAspect:I

.field private pixelStack:[B

.field private pixels:[B

.field private prefix:[S

.field private final rCondition:Ljava/util/concurrent/locks/Condition;

.field private res:Landroid/content/res/Resources;

.field private resId:I

.field private status:I

.field private strFileName:Ljava/lang/String;

.field private suffix:[B

.field private tab:[I

.field private transIndex:I

.field private transparency:Z

.field private final wCondition:Ljava/util/concurrent/locks/Condition;

.field public width:I


# direct methods
.method public constructor <init>(Lcom/ant/liao/GifAction;)V
    .locals 5
    .param p1, "action"    # Lcom/ant/liao/GifAction;

    .prologue
    const/16 v4, 0x100

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 109
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 34
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->isDestroy:Z

    .line 44
    const/4 v0, 0x1

    iput v0, p0, Lcom/ant/liao/GifDecoder;->loopCount:I

    .line 64
    new-array v0, v4, [B

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->block:[B

    .line 65
    iput v2, p0, Lcom/ant/liao/GifDecoder;->blockSize:I

    .line 68
    iput v2, p0, Lcom/ant/liao/GifDecoder;->dispose:I

    .line 70
    iput v2, p0, Lcom/ant/liao/GifDecoder;->lastDispose:I

    .line 71
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->transparency:Z

    .line 72
    iput v2, p0, Lcom/ant/liao/GifDecoder;->delay:I

    .line 87
    new-instance v0, Ljava/util/concurrent/ArrayBlockingQueue;

    const/16 v1, 0xf

    invoke-direct {v0, v1}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    .line 88
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 89
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->rCondition:Ljava/util/concurrent/locks/Condition;

    .line 90
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->wCondition:Ljava/util/concurrent/locks/Condition;

    .line 91
    iput v2, p0, Lcom/ant/liao/GifDecoder;->icacheParse:I

    .line 92
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    .line 93
    new-instance v0, Ljava/util/ArrayList;

    iget v1, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->frameCache:Ljava/util/ArrayList;

    .line 94
    iput v2, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    .line 95
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->loopCache:Z

    .line 97
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    .line 99
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->gifData:[B

    .line 101
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->isLoop:Z

    .line 103
    iput v2, p0, Lcom/ant/liao/GifDecoder;->fileType:I

    .line 105
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->res:Landroid/content/res/Resources;

    .line 106
    iput v2, p0, Lcom/ant/liao/GifDecoder;->resId:I

    .line 107
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->strFileName:Ljava/lang/String;

    .line 234
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->dest:[I

    .line 630
    new-array v0, v4, [I

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->tab:[I

    .line 110
    iput-object p1, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    .line 111
    return-void
.end method

.method public constructor <init>(Lcom/ant/liao/GifAction;Z)V
    .locals 5
    .param p1, "action"    # Lcom/ant/liao/GifAction;
    .param p2, "isLoop"    # Z

    .prologue
    const/16 v4, 0x100

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 113
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 34
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->isDestroy:Z

    .line 44
    const/4 v0, 0x1

    iput v0, p0, Lcom/ant/liao/GifDecoder;->loopCount:I

    .line 64
    new-array v0, v4, [B

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->block:[B

    .line 65
    iput v2, p0, Lcom/ant/liao/GifDecoder;->blockSize:I

    .line 68
    iput v2, p0, Lcom/ant/liao/GifDecoder;->dispose:I

    .line 70
    iput v2, p0, Lcom/ant/liao/GifDecoder;->lastDispose:I

    .line 71
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->transparency:Z

    .line 72
    iput v2, p0, Lcom/ant/liao/GifDecoder;->delay:I

    .line 87
    new-instance v0, Ljava/util/concurrent/ArrayBlockingQueue;

    const/16 v1, 0xf

    invoke-direct {v0, v1}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    .line 88
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 89
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->rCondition:Ljava/util/concurrent/locks/Condition;

    .line 90
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->wCondition:Ljava/util/concurrent/locks/Condition;

    .line 91
    iput v2, p0, Lcom/ant/liao/GifDecoder;->icacheParse:I

    .line 92
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    .line 93
    new-instance v0, Ljava/util/ArrayList;

    iget v1, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->frameCache:Ljava/util/ArrayList;

    .line 94
    iput v2, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    .line 95
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->loopCache:Z

    .line 97
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    .line 99
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->gifData:[B

    .line 101
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->isLoop:Z

    .line 103
    iput v2, p0, Lcom/ant/liao/GifDecoder;->fileType:I

    .line 105
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->res:Landroid/content/res/Resources;

    .line 106
    iput v2, p0, Lcom/ant/liao/GifDecoder;->resId:I

    .line 107
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->strFileName:Ljava/lang/String;

    .line 234
    iput-object v3, p0, Lcom/ant/liao/GifDecoder;->dest:[I

    .line 630
    new-array v0, v4, [I

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->tab:[I

    .line 114
    iput-object p1, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    .line 115
    iput-boolean p2, p0, Lcom/ant/liao/GifDecoder;->isLoop:Z

    .line 116
    return-void
.end method

.method private checkLoop()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 436
    iget-boolean v0, p0, Lcom/ant/liao/GifDecoder;->isLoop:Z

    if-eqz v0, :cond_0

    .line 437
    iget-boolean v0, p0, Lcom/ant/liao/GifDecoder;->loopCache:Z

    if-eqz v0, :cond_1

    .line 474
    :cond_0
    :goto_0
    return-void

    .line 441
    :cond_1
    iget v0, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    const/16 v1, 0xf

    if-gt v0, v1, :cond_4

    .line 444
    :try_start_0
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lockInterruptibly()V

    .line 445
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifDecoder;->loopCache:Z

    .line 446
    const/4 v0, -0x1

    iput v0, p0, Lcom/ant/liao/GifDecoder;->status:I

    .line 447
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    if-eqz v0, :cond_2

    .line 448
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    const/4 v1, 0x2

    invoke-interface {v0, v1}, Lcom/ant/liao/GifAction;->parseReturn(I)V

    .line 449
    :cond_2
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->rCondition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signal()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 453
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 459
    :cond_3
    :goto_1
    iget v0, p0, Lcom/ant/liao/GifDecoder;->fileType:I

    packed-switch v0, :pswitch_data_0

    .line 470
    :goto_2
    iput-boolean v2, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    .line 471
    iget-boolean v0, p0, Lcom/ant/liao/GifDecoder;->isDestroy:Z

    if-nez v0, :cond_0

    .line 472
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readStream()I

    goto :goto_0

    .line 450
    :catch_0
    move-exception v0

    .line 453
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_1

    .line 452
    :catchall_0
    move-exception v0

    .line 453
    iget-object v1, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 454
    throw v0

    .line 456
    :cond_4
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->frameCache:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    .line 457
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->frameCache:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    goto :goto_1

    .line 461
    :pswitch_0
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->openResourceFile()V

    goto :goto_2

    .line 464
    :pswitch_1
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->openFile()V

    goto :goto_2

    .line 467
    :pswitch_2
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->openInputstream()V

    goto :goto_2

    .line 459
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private decodeImageData()V
    .locals 25

    .prologue
    .line 477
    const/4 v2, -0x1

    .line 478
    .local v2, "NullCode":I
    move-object/from16 v0, p0

    iget v0, v0, Lcom/ant/liao/GifDecoder;->iw:I

    move/from16 v23, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/ant/liao/GifDecoder;->ih:I

    move/from16 v24, v0

    mul-int v17, v23, v24

    .line 481
    .local v17, "npix":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixels:[B

    move-object/from16 v23, v0

    if-eqz v23, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixels:[B

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    array-length v0, v0

    move/from16 v23, v0

    move/from16 v0, v23

    move/from16 v1, v17

    if-ge v0, v1, :cond_1

    .line 482
    :cond_0
    move/from16 v0, v17

    new-array v0, v0, [B

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/ant/liao/GifDecoder;->pixels:[B

    .line 484
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->prefix:[S

    move-object/from16 v23, v0

    if-nez v23, :cond_2

    .line 485
    const/16 v23, 0x1000

    move/from16 v0, v23

    new-array v0, v0, [S

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/ant/liao/GifDecoder;->prefix:[S

    .line 487
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->suffix:[B

    move-object/from16 v23, v0

    if-nez v23, :cond_3

    .line 488
    const/16 v23, 0x1000

    move/from16 v0, v23

    new-array v0, v0, [B

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/ant/liao/GifDecoder;->suffix:[B

    .line 490
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    if-nez v23, :cond_4

    .line 491
    const/16 v23, 0x1001

    move/from16 v0, v23

    new-array v0, v0, [B

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/ant/liao/GifDecoder;->pixelStack:[B

    .line 494
    :cond_4
    invoke-direct/range {p0 .. p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v11

    .line 495
    .local v11, "data_size":I
    const/16 v23, 0x1

    shl-int v6, v23, v11

    .line 496
    .local v6, "clear":I
    add-int/lit8 v13, v6, 0x1

    .line 497
    .local v13, "end_of_information":I
    add-int/lit8 v3, v6, 0x2

    .line 498
    .local v3, "available":I
    move/from16 v18, v2

    .line 499
    .local v18, "old_code":I
    add-int/lit8 v9, v11, 0x1

    .line 500
    .local v9, "code_size":I
    const/16 v23, 0x1

    shl-int v23, v23, v9

    add-int/lit8 v8, v23, -0x1

    .line 501
    .local v8, "code_mask":I
    const/4 v7, 0x0

    .local v7, "code":I
    :goto_0
    if-lt v7, v6, :cond_6

    .line 507
    const/4 v4, 0x0

    .local v4, "bi":I
    move/from16 v19, v4

    .local v19, "pi":I
    move/from16 v21, v4

    .local v21, "top":I
    move v14, v4

    .local v14, "first":I
    move v10, v4

    .local v10, "count":I
    move v5, v4

    .local v5, "bits":I
    move v12, v4

    .line 508
    .local v12, "datum":I
    const/4 v15, 0x0

    .local v15, "i":I
    move/from16 v20, v19

    .end local v19    # "pi":I
    .local v20, "pi":I
    move/from16 v22, v21

    .end local v21    # "top":I
    .local v22, "top":I
    :goto_1
    move/from16 v0, v17

    if-lt v15, v0, :cond_7

    :cond_5
    move/from16 v21, v22

    .line 579
    .end local v22    # "top":I
    .restart local v21    # "top":I
    :goto_2
    move/from16 v15, v20

    :goto_3
    move/from16 v0, v17

    if-lt v15, v0, :cond_12

    .line 582
    return-void

    .line 502
    .end local v4    # "bi":I
    .end local v5    # "bits":I
    .end local v10    # "count":I
    .end local v12    # "datum":I
    .end local v14    # "first":I
    .end local v15    # "i":I
    .end local v20    # "pi":I
    .end local v21    # "top":I
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->prefix:[S

    move-object/from16 v23, v0

    const/16 v24, 0x0

    aput-short v24, v23, v7

    .line 503
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->suffix:[B

    move-object/from16 v23, v0

    int-to-byte v0, v7

    move/from16 v24, v0

    aput-byte v24, v23, v7

    .line 501
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 509
    .restart local v4    # "bi":I
    .restart local v5    # "bits":I
    .restart local v10    # "count":I
    .restart local v12    # "datum":I
    .restart local v14    # "first":I
    .restart local v15    # "i":I
    .restart local v20    # "pi":I
    .restart local v22    # "top":I
    :cond_7
    if-nez v22, :cond_13

    .line 510
    if-ge v5, v9, :cond_a

    .line 512
    if-nez v10, :cond_9

    .line 514
    invoke-direct/range {p0 .. p0}, Lcom/ant/liao/GifDecoder;->readBlock()I

    move-result v10

    .line 515
    if-gtz v10, :cond_8

    move/from16 v21, v22

    .line 516
    .end local v22    # "top":I
    .restart local v21    # "top":I
    goto :goto_2

    .line 518
    .end local v21    # "top":I
    .restart local v22    # "top":I
    :cond_8
    const/4 v4, 0x0

    .line 520
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->block:[B

    move-object/from16 v23, v0

    aget-byte v23, v23, v4

    move/from16 v0, v23

    and-int/lit16 v0, v0, 0xff

    move/from16 v23, v0

    shl-int v23, v23, v5

    add-int v12, v12, v23

    .line 521
    add-int/lit8 v5, v5, 0x8

    .line 522
    add-int/lit8 v4, v4, 0x1

    .line 523
    add-int/lit8 v10, v10, -0x1

    .line 524
    goto :goto_1

    .line 527
    :cond_a
    and-int v7, v12, v8

    .line 528
    shr-int/2addr v12, v9

    .line 529
    sub-int/2addr v5, v9

    .line 532
    if-gt v7, v3, :cond_5

    if-ne v7, v13, :cond_b

    move/from16 v21, v22

    .line 533
    .end local v22    # "top":I
    .restart local v21    # "top":I
    goto :goto_2

    .line 535
    .end local v21    # "top":I
    .restart local v22    # "top":I
    :cond_b
    if-ne v7, v6, :cond_c

    .line 537
    add-int/lit8 v9, v11, 0x1

    .line 538
    const/16 v23, 0x1

    shl-int v23, v23, v9

    add-int/lit8 v8, v23, -0x1

    .line 539
    add-int/lit8 v3, v6, 0x2

    .line 540
    move/from16 v18, v2

    .line 541
    goto :goto_1

    .line 543
    :cond_c
    move/from16 v0, v18

    if-ne v0, v2, :cond_d

    .line 544
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    add-int/lit8 v21, v22, 0x1

    .end local v22    # "top":I
    .restart local v21    # "top":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->suffix:[B

    move-object/from16 v24, v0

    aget-byte v24, v24, v7

    aput-byte v24, v23, v22

    .line 545
    move/from16 v18, v7

    .line 546
    move v14, v7

    move/from16 v22, v21

    .line 547
    .end local v21    # "top":I
    .restart local v22    # "top":I
    goto/16 :goto_1

    .line 549
    :cond_d
    move/from16 v16, v7

    .line 550
    .local v16, "in_code":I
    if-ne v7, v3, :cond_e

    .line 551
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    add-int/lit8 v21, v22, 0x1

    .end local v22    # "top":I
    .restart local v21    # "top":I
    int-to-byte v0, v14

    move/from16 v24, v0

    aput-byte v24, v23, v22

    .line 552
    move/from16 v7, v18

    move/from16 v22, v21

    .line 554
    .end local v21    # "top":I
    .restart local v22    # "top":I
    :cond_e
    :goto_4
    if-gt v7, v6, :cond_f

    .line 558
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->suffix:[B

    move-object/from16 v23, v0

    aget-byte v23, v23, v7

    move/from16 v0, v23

    and-int/lit16 v14, v0, 0xff

    .line 560
    const/16 v23, 0x1000

    move/from16 v0, v23

    if-lt v3, v0, :cond_10

    move/from16 v21, v22

    .line 561
    .end local v22    # "top":I
    .restart local v21    # "top":I
    goto/16 :goto_2

    .line 555
    .end local v21    # "top":I
    .restart local v22    # "top":I
    :cond_f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    add-int/lit8 v21, v22, 0x1

    .end local v22    # "top":I
    .restart local v21    # "top":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->suffix:[B

    move-object/from16 v24, v0

    aget-byte v24, v24, v7

    aput-byte v24, v23, v22

    .line 556
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->prefix:[S

    move-object/from16 v23, v0

    aget-short v7, v23, v7

    move/from16 v22, v21

    .end local v21    # "top":I
    .restart local v22    # "top":I
    goto :goto_4

    .line 563
    :cond_10
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    add-int/lit8 v21, v22, 0x1

    .end local v22    # "top":I
    .restart local v21    # "top":I
    int-to-byte v0, v14

    move/from16 v24, v0

    aput-byte v24, v23, v22

    .line 564
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->prefix:[S

    move-object/from16 v23, v0

    move/from16 v0, v18

    int-to-short v0, v0

    move/from16 v24, v0

    aput-short v24, v23, v3

    .line 565
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->suffix:[B

    move-object/from16 v23, v0

    int-to-byte v0, v14

    move/from16 v24, v0

    aput-byte v24, v23, v3

    .line 566
    add-int/lit8 v3, v3, 0x1

    .line 567
    and-int v23, v3, v8

    if-nez v23, :cond_11

    const/16 v23, 0x1000

    move/from16 v0, v23

    if-ge v3, v0, :cond_11

    .line 568
    add-int/lit8 v9, v9, 0x1

    .line 569
    add-int/2addr v8, v3

    .line 571
    :cond_11
    move/from16 v18, v16

    .line 575
    .end local v16    # "in_code":I
    :goto_5
    add-int/lit8 v21, v21, -0x1

    .line 576
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixels:[B

    move-object/from16 v23, v0

    add-int/lit8 v19, v20, 0x1

    .end local v20    # "pi":I
    .restart local v19    # "pi":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixelStack:[B

    move-object/from16 v24, v0

    aget-byte v24, v24, v21

    aput-byte v24, v23, v20

    .line 577
    add-int/lit8 v15, v15, 0x1

    move/from16 v20, v19

    .end local v19    # "pi":I
    .restart local v20    # "pi":I
    move/from16 v22, v21

    .end local v21    # "top":I
    .restart local v22    # "top":I
    goto/16 :goto_1

    .line 580
    .end local v22    # "top":I
    .restart local v21    # "top":I
    :cond_12
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/ant/liao/GifDecoder;->pixels:[B

    move-object/from16 v23, v0

    const/16 v24, 0x0

    aput-byte v24, v23, v15

    .line 579
    add-int/lit8 v15, v15, 0x1

    goto/16 :goto_3

    .end local v21    # "top":I
    .restart local v22    # "top":I
    :cond_13
    move/from16 v21, v22

    .end local v22    # "top":I
    .restart local v21    # "top":I
    goto :goto_5
.end method

.method private err()Z
    .locals 1

    .prologue
    .line 585
    iget v0, p0, Lcom/ant/liao/GifDecoder;->status:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private free()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 174
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    if-eqz v0, :cond_0

    .line 176
    :try_start_0
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 179
    :goto_0
    iput-object v1, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    .line 181
    :cond_0
    iput-object v1, p0, Lcom/ant/liao/GifDecoder;->gifData:[B

    .line 182
    const/4 v0, 0x0

    iput v0, p0, Lcom/ant/liao/GifDecoder;->status:I

    .line 183
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->frameCache:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 184
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->frameCache:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 185
    iput-object v1, p0, Lcom/ant/liao/GifDecoder;->frameCache:Ljava/util/ArrayList;

    .line 187
    :cond_1
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    if-eqz v0, :cond_2

    .line 188
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    .line 189
    iput-object v1, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    .line 191
    :cond_2
    return-void

    .line 177
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private init()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 589
    iput v1, p0, Lcom/ant/liao/GifDecoder;->status:I

    .line 590
    iget-boolean v0, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    if-nez v0, :cond_0

    .line 591
    iput v1, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    .line 592
    :cond_0
    iput-object v2, p0, Lcom/ant/liao/GifDecoder;->gct:[I

    .line 593
    iput-object v2, p0, Lcom/ant/liao/GifDecoder;->lct:[I

    .line 594
    iput v1, p0, Lcom/ant/liao/GifDecoder;->icacheParse:I

    .line 595
    return-void
.end method

.method private openFile()V
    .locals 3

    .prologue
    .line 155
    :try_start_0
    new-instance v1, Ljava/io/FileInputStream;

    iget-object v2, p0, Lcom/ant/liao/GifDecoder;->strFileName:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 159
    :goto_0
    return-void

    .line 156
    :catch_0
    move-exception v0

    .line 157
    .local v0, "ex":Ljava/lang/Exception;
    const-string v1, "open failed"

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private openInputstream()V
    .locals 2

    .prologue
    .line 133
    new-instance v0, Ljava/io/ByteArrayInputStream;

    iget-object v1, p0, Lcom/ant/liao/GifDecoder;->gifData:[B

    invoke-direct {v0, v1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    .line 134
    return-void
.end method

.method private openResourceFile()V
    .locals 2

    .prologue
    .line 144
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->res:Landroid/content/res/Resources;

    iget v1, p0, Lcom/ant/liao/GifDecoder;->resId:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v0

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    .line 145
    return-void
.end method

.method private read()I
    .locals 3

    .prologue
    .line 598
    const/4 v0, 0x0

    .line 600
    .local v0, "curByte":I
    :try_start_0
    iget-object v2, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    invoke-virtual {v2}, Ljava/io/InputStream;->read()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 604
    :goto_0
    return v0

    .line 601
    :catch_0
    move-exception v1

    .line 602
    .local v1, "e":Ljava/lang/Exception;
    const/4 v2, 0x1

    iput v2, p0, Lcom/ant/liao/GifDecoder;->status:I

    goto :goto_0
.end method

.method private readBlock()I
    .locals 6

    .prologue
    .line 608
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v3

    iput v3, p0, Lcom/ant/liao/GifDecoder;->blockSize:I

    .line 609
    const/4 v2, 0x0

    .line 610
    .local v2, "n":I
    iget v3, p0, Lcom/ant/liao/GifDecoder;->blockSize:I

    if-lez v3, :cond_1

    .line 612
    const/4 v0, 0x0

    .line 613
    .local v0, "count":I
    :goto_0
    :try_start_0
    iget v3, p0, Lcom/ant/liao/GifDecoder;->blockSize:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    if-lt v2, v3, :cond_2

    .line 623
    :cond_0
    :goto_1
    iget v3, p0, Lcom/ant/liao/GifDecoder;->blockSize:I

    if-ge v2, v3, :cond_1

    .line 624
    const/4 v3, 0x1

    iput v3, p0, Lcom/ant/liao/GifDecoder;->status:I

    .line 627
    .end local v0    # "count":I
    :cond_1
    return v2

    .line 614
    .restart local v0    # "count":I
    :cond_2
    :try_start_1
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    iget-object v4, p0, Lcom/ant/liao/GifDecoder;->block:[B

    iget v5, p0, Lcom/ant/liao/GifDecoder;->blockSize:I

    sub-int/2addr v5, v2

    invoke-virtual {v3, v4, v2, v5}, Ljava/io/InputStream;->read([BII)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result v0

    .line 615
    const/4 v3, -0x1

    if-eq v0, v3, :cond_0

    .line 618
    add-int/2addr v2, v0

    goto :goto_0

    .line 620
    :catch_0
    move-exception v1

    .line 621
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method private readColorTable(I)[I
    .locals 14
    .param p1, "ncolors"    # I

    .prologue
    .line 633
    mul-int/lit8 v9, p1, 0x3

    .line 635
    .local v9, "nbytes":I
    new-array v1, v9, [B

    .line 636
    .local v1, "c":[B
    const/4 v8, 0x0

    .line 638
    .local v8, "n":I
    :try_start_0
    iget-object v11, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    invoke-virtual {v11, v1}, Ljava/io/InputStream;->read([B)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v8

    .line 642
    :goto_0
    if-ge v8, v9, :cond_1

    .line 643
    const/4 v11, 0x1

    iput v11, p0, Lcom/ant/liao/GifDecoder;->status:I

    .line 655
    :cond_0
    iget-object v11, p0, Lcom/ant/liao/GifDecoder;->tab:[I

    return-object v11

    .line 639
    :catch_0
    move-exception v2

    .line 640
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 646
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_1
    const/4 v4, 0x0

    .line 647
    .local v4, "i":I
    const/4 v6, 0x0

    .local v6, "j":I
    move v7, v6

    .end local v6    # "j":I
    .local v7, "j":I
    move v5, v4

    .line 648
    .end local v4    # "i":I
    .local v5, "i":I
    :goto_1
    if-ge v5, p1, :cond_0

    .line 649
    add-int/lit8 v6, v7, 0x1

    .end local v7    # "j":I
    .restart local v6    # "j":I
    aget-byte v11, v1, v7

    and-int/lit16 v10, v11, 0xff

    .line 650
    .local v10, "r":I
    add-int/lit8 v7, v6, 0x1

    .end local v6    # "j":I
    .restart local v7    # "j":I
    aget-byte v11, v1, v6

    and-int/lit16 v3, v11, 0xff

    .line 651
    .local v3, "g":I
    add-int/lit8 v6, v7, 0x1

    .end local v7    # "j":I
    .restart local v6    # "j":I
    aget-byte v11, v1, v7

    and-int/lit16 v0, v11, 0xff

    .line 652
    .local v0, "b":I
    iget-object v11, p0, Lcom/ant/liao/GifDecoder;->tab:[I

    add-int/lit8 v4, v5, 0x1

    .end local v5    # "i":I
    .restart local v4    # "i":I
    const/high16 v12, -0x1000000

    shl-int/lit8 v13, v10, 0x10

    or-int/2addr v12, v13

    shl-int/lit8 v13, v3, 0x8

    or-int/2addr v12, v13

    or-int/2addr v12, v0

    aput v12, v11, v5

    move v7, v6

    .end local v6    # "j":I
    .restart local v7    # "j":I
    move v5, v4

    .end local v4    # "i":I
    .restart local v5    # "i":I
    goto :goto_1
.end method

.method private readContents()V
    .locals 6

    .prologue
    .line 660
    const/4 v2, 0x0

    .line 661
    .local v2, "done":Z
    :goto_0
    :sswitch_0
    if-nez v2, :cond_0

    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->err()Z

    move-result v4

    if-nez v4, :cond_0

    iget-boolean v4, p0, Lcom/ant/liao/GifDecoder;->isDestroy:Z

    if-eqz v4, :cond_1

    .line 698
    :cond_0
    return-void

    .line 662
    :cond_1
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v1

    .line 663
    .local v1, "code":I
    sparse-switch v1, :sswitch_data_0

    .line 695
    const/4 v4, 0x1

    iput v4, p0, Lcom/ant/liao/GifDecoder;->status:I

    goto :goto_0

    .line 665
    :sswitch_1
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readImage()V

    goto :goto_0

    .line 668
    :sswitch_2
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v1

    .line 669
    sparse-switch v1, :sswitch_data_1

    .line 686
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->skip()V

    goto :goto_0

    .line 671
    :sswitch_3
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readGraphicControlExt()V

    goto :goto_0

    .line 674
    :sswitch_4
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readBlock()I

    .line 675
    const-string v0, ""

    .line 676
    .local v0, "app":Ljava/lang/String;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    const/16 v4, 0xb

    if-lt v3, v4, :cond_2

    .line 679
    const-string v4, "NETSCAPE2.0"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 680
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readNetscapeExt()V

    goto :goto_0

    .line 677
    :cond_2
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->block:[B

    aget-byte v5, v5, v3

    int-to-char v5, v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 676
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 682
    :cond_3
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->skip()V

    goto :goto_0

    .line 690
    .end local v0    # "app":Ljava/lang/String;
    .end local v3    # "i":I
    :sswitch_5
    const/4 v2, 0x1

    .line 691
    goto :goto_0

    .line 663
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x21 -> :sswitch_2
        0x2c -> :sswitch_1
        0x3b -> :sswitch_5
    .end sparse-switch

    .line 669
    :sswitch_data_1
    .sparse-switch
        0xf9 -> :sswitch_3
        0xff -> :sswitch_4
    .end sparse-switch
.end method

.method private readGraphicControlExt()V
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 701
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    .line 702
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v0

    .line 703
    .local v0, "packed":I
    and-int/lit8 v2, v0, 0x1c

    shr-int/lit8 v2, v2, 0x2

    iput v2, p0, Lcom/ant/liao/GifDecoder;->dispose:I

    .line 704
    iget v2, p0, Lcom/ant/liao/GifDecoder;->dispose:I

    if-nez v2, :cond_0

    .line 705
    iput v1, p0, Lcom/ant/liao/GifDecoder;->dispose:I

    .line 707
    :cond_0
    and-int/lit8 v2, v0, 0x1

    if-eqz v2, :cond_2

    :goto_0
    iput-boolean v1, p0, Lcom/ant/liao/GifDecoder;->transparency:Z

    .line 708
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readShort()I

    move-result v1

    mul-int/lit8 v1, v1, 0xa

    iput v1, p0, Lcom/ant/liao/GifDecoder;->delay:I

    .line 709
    iget v1, p0, Lcom/ant/liao/GifDecoder;->delay:I

    if-nez v1, :cond_1

    .line 710
    const/16 v1, 0x64

    iput v1, p0, Lcom/ant/liao/GifDecoder;->delay:I

    .line 712
    :cond_1
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v1

    iput v1, p0, Lcom/ant/liao/GifDecoder;->transIndex:I

    .line 713
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    .line 714
    return-void

    .line 707
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private readHeader()V
    .locals 4

    .prologue
    .line 717
    const-string v1, ""

    .line 718
    .local v1, "id":Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    const/4 v2, 0x6

    if-lt v0, v2, :cond_1

    .line 721
    const-string v2, "GIF"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 722
    const/4 v2, 0x1

    iput v2, p0, Lcom/ant/liao/GifDecoder;->status:I

    .line 730
    :cond_0
    :goto_1
    return-void

    .line 719
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v3

    int-to-char v3, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 718
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 725
    :cond_2
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readLSD()V

    .line 726
    iget-boolean v2, p0, Lcom/ant/liao/GifDecoder;->gctFlag:Z

    if-eqz v2, :cond_0

    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->err()Z

    move-result v2

    if-nez v2, :cond_0

    .line 727
    iget v2, p0, Lcom/ant/liao/GifDecoder;->gctSize:I

    invoke-direct {p0, v2}, Lcom/ant/liao/GifDecoder;->readColorTable(I)[I

    move-result-object v2

    iput-object v2, p0, Lcom/ant/liao/GifDecoder;->gct:[I

    .line 728
    iget-object v2, p0, Lcom/ant/liao/GifDecoder;->gct:[I

    iget v3, p0, Lcom/ant/liao/GifDecoder;->bgIndex:I

    aget v2, v2, v3

    iput v2, p0, Lcom/ant/liao/GifDecoder;->bgColor:I

    goto :goto_1
.end method

.method private readImage()V
    .locals 10

    .prologue
    const/16 v9, 0xf

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 733
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readShort()I

    move-result v5

    iput v5, p0, Lcom/ant/liao/GifDecoder;->ix:I

    .line 734
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readShort()I

    move-result v5

    iput v5, p0, Lcom/ant/liao/GifDecoder;->iy:I

    .line 735
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readShort()I

    move-result v5

    iput v5, p0, Lcom/ant/liao/GifDecoder;->iw:I

    .line 736
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readShort()I

    move-result v5

    iput v5, p0, Lcom/ant/liao/GifDecoder;->ih:I

    .line 737
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v3

    .line 738
    .local v3, "packed":I
    and-int/lit16 v5, v3, 0x80

    if-eqz v5, :cond_4

    move v5, v6

    :goto_0
    iput-boolean v5, p0, Lcom/ant/liao/GifDecoder;->lctFlag:Z

    .line 739
    and-int/lit8 v5, v3, 0x40

    if-eqz v5, :cond_5

    move v5, v6

    :goto_1
    iput-boolean v5, p0, Lcom/ant/liao/GifDecoder;->interlace:Z

    .line 742
    const/4 v5, 0x2

    and-int/lit8 v8, v3, 0x7

    shl-int/2addr v5, v8

    iput v5, p0, Lcom/ant/liao/GifDecoder;->lctSize:I

    .line 743
    iget-boolean v5, p0, Lcom/ant/liao/GifDecoder;->lctFlag:Z

    if-eqz v5, :cond_6

    .line 744
    iget v5, p0, Lcom/ant/liao/GifDecoder;->lctSize:I

    invoke-direct {p0, v5}, Lcom/ant/liao/GifDecoder;->readColorTable(I)[I

    move-result-object v5

    iput-object v5, p0, Lcom/ant/liao/GifDecoder;->lct:[I

    .line 745
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->lct:[I

    iput-object v5, p0, Lcom/ant/liao/GifDecoder;->act:[I

    .line 752
    :cond_0
    :goto_2
    const/4 v4, 0x0

    .line 753
    .local v4, "save":I
    iget-boolean v5, p0, Lcom/ant/liao/GifDecoder;->transparency:Z

    if-eqz v5, :cond_1

    .line 754
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->act:[I

    if-eqz v5, :cond_1

    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->act:[I

    array-length v5, v5

    if-lez v5, :cond_1

    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->act:[I

    array-length v5, v5

    iget v8, p0, Lcom/ant/liao/GifDecoder;->transIndex:I

    if-le v5, v8, :cond_1

    .line 755
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->act:[I

    iget v8, p0, Lcom/ant/liao/GifDecoder;->transIndex:I

    aget v4, v5, v8

    .line 756
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->act:[I

    iget v8, p0, Lcom/ant/liao/GifDecoder;->transIndex:I

    aput v7, v5, v8

    .line 759
    :cond_1
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->act:[I

    if-nez v5, :cond_2

    .line 760
    iput v6, p0, Lcom/ant/liao/GifDecoder;->status:I

    .line 762
    :cond_2
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->err()Z

    move-result v5

    if-eqz v5, :cond_7

    .line 819
    :cond_3
    :goto_3
    return-void

    .end local v4    # "save":I
    :cond_4
    move v5, v7

    .line 738
    goto :goto_0

    :cond_5
    move v5, v7

    .line 739
    goto :goto_1

    .line 747
    :cond_6
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->gct:[I

    iput-object v5, p0, Lcom/ant/liao/GifDecoder;->act:[I

    .line 748
    iget v5, p0, Lcom/ant/liao/GifDecoder;->bgIndex:I

    iget v8, p0, Lcom/ant/liao/GifDecoder;->transIndex:I

    if-ne v5, v8, :cond_0

    .line 749
    iput v7, p0, Lcom/ant/liao/GifDecoder;->bgColor:I

    goto :goto_2

    .line 765
    .restart local v4    # "save":I
    :cond_7
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->decodeImageData()V

    .line 766
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->skip()V

    .line 767
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->err()Z

    move-result v5

    if-nez v5, :cond_3

    .line 770
    iget-boolean v5, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    if-nez v5, :cond_8

    .line 771
    iget v5, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    .line 775
    :cond_8
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->setPixels()V

    .line 779
    :try_start_0
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantLock;->lockInterruptibly()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 782
    :goto_4
    :try_start_1
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    if-eqz v5, :cond_9

    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    invoke-interface {v5}, Ljava/util/Queue;->size()I

    move-result v5

    if-ge v5, v9, :cond_d

    .line 785
    :cond_9
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    if-eqz v5, :cond_b

    .line 786
    new-instance v1, Lcom/ant/liao/GifFrame;

    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->image:Landroid/graphics/Bitmap;

    iget v7, p0, Lcom/ant/liao/GifDecoder;->delay:I

    invoke-direct {v1, v5, v7}, Lcom/ant/liao/GifFrame;-><init>(Landroid/graphics/Bitmap;I)V

    .line 787
    .local v1, "gif":Lcom/ant/liao/GifFrame;
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    invoke-interface {v5, v1}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 788
    iget-boolean v5, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    if-nez v5, :cond_a

    .line 789
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->frameCache:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 791
    :cond_a
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->rCondition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Condition;->signal()V

    .line 792
    iget-boolean v5, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    if-nez v5, :cond_b

    iget v5, p0, Lcom/ant/liao/GifDecoder;->icacheParse:I

    if-ltz v5, :cond_b

    .line 793
    iget v5, p0, Lcom/ant/liao/GifDecoder;->icacheParse:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/ant/liao/GifDecoder;->icacheParse:I

    .line 794
    iget v5, p0, Lcom/ant/liao/GifDecoder;->icacheParse:I

    if-lt v5, v9, :cond_e

    .line 796
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    const/4 v6, 0x3

    invoke-interface {v5, v6}, Lcom/ant/liao/GifAction;->parseReturn(I)V

    .line 797
    const/4 v5, -0x1

    iput v5, p0, Lcom/ant/liao/GifDecoder;->icacheParse:I
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 807
    .end local v1    # "gif":Lcom/ant/liao/GifFrame;
    :cond_b
    :goto_5
    :try_start_2
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 814
    :goto_6
    iget-boolean v5, p0, Lcom/ant/liao/GifDecoder;->transparency:Z

    if-eqz v5, :cond_c

    .line 815
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->act:[I

    iget v6, p0, Lcom/ant/liao/GifDecoder;->transIndex:I

    aput v4, v5, v6

    .line 817
    :cond_c
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->resetFrame()V

    goto/16 :goto_3

    .line 783
    :cond_d
    :try_start_3
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->wCondition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_4

    .line 804
    :catch_0
    move-exception v2

    .line 805
    .local v2, "ie":Ljava/lang/InterruptedException;
    :try_start_4
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->wCondition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Condition;->signal()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 807
    :try_start_5
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_6

    .line 810
    .end local v2    # "ie":Ljava/lang/InterruptedException;
    :catch_1
    move-exception v0

    .line 811
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_6

    .line 798
    .end local v0    # "ex":Ljava/lang/Exception;
    .restart local v1    # "gif":Lcom/ant/liao/GifFrame;
    :cond_e
    :try_start_6
    iget v5, p0, Lcom/ant/liao/GifDecoder;->icacheParse:I

    if-ne v5, v6, :cond_b

    .line 800
    iget-object v5, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    const/4 v6, 0x1

    invoke-interface {v5, v6}, Lcom/ant/liao/GifAction;->parseReturn(I)V
    :try_end_6
    .catch Ljava/lang/InterruptedException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_5

    .line 806
    .end local v1    # "gif":Lcom/ant/liao/GifFrame;
    :catchall_0
    move-exception v5

    .line 807
    :try_start_7
    iget-object v6, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v6}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 808
    throw v5
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
.end method

.method private readLSD()V
    .locals 3

    .prologue
    .line 823
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readShort()I

    move-result v1

    iput v1, p0, Lcom/ant/liao/GifDecoder;->width:I

    .line 824
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readShort()I

    move-result v1

    iput v1, p0, Lcom/ant/liao/GifDecoder;->height:I

    .line 826
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v0

    .line 827
    .local v0, "packed":I
    and-int/lit16 v1, v0, 0x80

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    iput-boolean v1, p0, Lcom/ant/liao/GifDecoder;->gctFlag:Z

    .line 830
    const/4 v1, 0x2

    and-int/lit8 v2, v0, 0x7

    shl-int/2addr v1, v2

    iput v1, p0, Lcom/ant/liao/GifDecoder;->gctSize:I

    .line 831
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v1

    iput v1, p0, Lcom/ant/liao/GifDecoder;->bgIndex:I

    .line 832
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v1

    iput v1, p0, Lcom/ant/liao/GifDecoder;->pixelAspect:I

    .line 833
    return-void

    .line 827
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private readNetscapeExt()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 837
    :cond_0
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readBlock()I

    .line 838
    iget-object v2, p0, Lcom/ant/liao/GifDecoder;->block:[B

    const/4 v3, 0x0

    aget-byte v2, v2, v3

    if-ne v2, v4, :cond_1

    .line 840
    iget-object v2, p0, Lcom/ant/liao/GifDecoder;->block:[B

    aget-byte v2, v2, v4

    and-int/lit16 v0, v2, 0xff

    .line 841
    .local v0, "b1":I
    iget-object v2, p0, Lcom/ant/liao/GifDecoder;->block:[B

    const/4 v3, 0x2

    aget-byte v2, v2, v3

    and-int/lit16 v1, v2, 0xff

    .line 842
    .local v1, "b2":I
    shl-int/lit8 v2, v1, 0x8

    or-int/2addr v2, v0

    iput v2, p0, Lcom/ant/liao/GifDecoder;->loopCount:I

    .line 844
    .end local v0    # "b1":I
    .end local v1    # "b2":I
    :cond_1
    iget v2, p0, Lcom/ant/liao/GifDecoder;->blockSize:I

    if-lez v2, :cond_2

    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->err()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 845
    :cond_2
    return-void
.end method

.method private readShort()I
    .locals 4

    .prologue
    .line 849
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v1

    .line 850
    .local v1, "s":I
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->read()I

    move-result v0

    .line 851
    .local v0, "f":I
    shl-int/lit8 v3, v0, 0x8

    or-int v2, v1, v3

    .line 852
    .local v2, "t":I
    return v2
.end method

.method private readStream()I
    .locals 3

    .prologue
    const/4 v2, 0x4

    .line 402
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->init()V

    .line 403
    iget-object v1, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    if-eqz v1, :cond_3

    .line 404
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readHeader()V

    .line 405
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->err()Z

    move-result v1

    if-nez v1, :cond_0

    .line 406
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readContents()V

    .line 407
    iget-boolean v1, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    if-nez v1, :cond_0

    .line 408
    iget v1, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    if-gez v1, :cond_0

    .line 409
    const/4 v1, 0x1

    iput v1, p0, Lcom/ant/liao/GifDecoder;->status:I

    .line 410
    iget-object v1, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    if-eqz v1, :cond_0

    .line 411
    iget-object v1, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    invoke-interface {v1, v2}, Lcom/ant/liao/GifAction;->parseReturn(I)V

    .line 420
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    if-eqz v1, :cond_1

    .line 421
    iget-object v1, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 425
    :cond_1
    :goto_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/ant/liao/GifDecoder;->in:Ljava/io/InputStream;

    .line 426
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->checkLoop()V

    .line 432
    :cond_2
    :goto_1
    iget v1, p0, Lcom/ant/liao/GifDecoder;->status:I

    return v1

    .line 422
    :catch_0
    move-exception v0

    .line 423
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 428
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_3
    const/4 v1, 0x2

    iput v1, p0, Lcom/ant/liao/GifDecoder;->status:I

    .line 429
    iget-object v1, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    if-eqz v1, :cond_2

    .line 430
    iget-object v1, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    invoke-interface {v1, v2}, Lcom/ant/liao/GifAction;->parseReturn(I)V

    goto :goto_1
.end method

.method private resetFrame()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 857
    iget v0, p0, Lcom/ant/liao/GifDecoder;->dispose:I

    iput v0, p0, Lcom/ant/liao/GifDecoder;->lastDispose:I

    .line 858
    iget v0, p0, Lcom/ant/liao/GifDecoder;->ix:I

    iput v0, p0, Lcom/ant/liao/GifDecoder;->lrx:I

    .line 859
    iget v0, p0, Lcom/ant/liao/GifDecoder;->iy:I

    iput v0, p0, Lcom/ant/liao/GifDecoder;->lry:I

    .line 860
    iget v0, p0, Lcom/ant/liao/GifDecoder;->iw:I

    iput v0, p0, Lcom/ant/liao/GifDecoder;->lrw:I

    .line 861
    iget v0, p0, Lcom/ant/liao/GifDecoder;->ih:I

    iput v0, p0, Lcom/ant/liao/GifDecoder;->lrh:I

    .line 862
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->image:Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->lastImage:Landroid/graphics/Bitmap;

    .line 863
    iget v0, p0, Lcom/ant/liao/GifDecoder;->bgColor:I

    iput v0, p0, Lcom/ant/liao/GifDecoder;->lastBgColor:I

    .line 864
    iput v1, p0, Lcom/ant/liao/GifDecoder;->dispose:I

    .line 865
    iput-boolean v1, p0, Lcom/ant/liao/GifDecoder;->transparency:Z

    .line 866
    iput v1, p0, Lcom/ant/liao/GifDecoder;->delay:I

    .line 867
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->lct:[I

    .line 868
    return-void
.end method

.method private setPixels()V
    .locals 28

    .prologue
    .line 239
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/ant/liao/GifDecoder;->dest:[I

    if-nez v2, :cond_0

    .line 240
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v3, v0, Lcom/ant/liao/GifDecoder;->height:I

    mul-int/2addr v2, v3

    new-array v2, v2, [I

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/ant/liao/GifDecoder;->dest:[I

    .line 246
    :cond_0
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->lastDispose:I

    if-lez v2, :cond_4

    .line 247
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->lastDispose:I

    const/4 v3, 0x3

    if-ne v2, v3, :cond_2

    .line 249
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->frameCount:I

    add-int/lit8 v22, v2, -0x2

    .line 250
    .local v22, "n":I
    if-gtz v22, :cond_1

    .line 253
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/ant/liao/GifDecoder;->lastImage:Landroid/graphics/Bitmap;

    .line 255
    :cond_1
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/ant/liao/GifDecoder;->lastImage:Landroid/graphics/Bitmap;

    .line 257
    .end local v22    # "n":I
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/ant/liao/GifDecoder;->lastImage:Landroid/graphics/Bitmap;

    if-eqz v2, :cond_4

    .line 258
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/ant/liao/GifDecoder;->lastImage:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/ant/liao/GifDecoder;->dest:[I

    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget v5, v0, Lcom/ant/liao/GifDecoder;->width:I

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v0, p0

    iget v8, v0, Lcom/ant/liao/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v9, v0, Lcom/ant/liao/GifDecoder;->height:I

    invoke-virtual/range {v2 .. v9}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 260
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->lastDispose:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_4

    .line 262
    const/4 v10, 0x0

    .line 263
    .local v10, "c":I
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/ant/liao/GifDecoder;->transparency:Z

    if-nez v2, :cond_3

    .line 264
    move-object/from16 v0, p0

    iget v10, v0, Lcom/ant/liao/GifDecoder;->lastBgColor:I

    .line 266
    :cond_3
    const/16 v16, 0x0

    .local v16, "i":I
    :goto_0
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->lrh:I

    move/from16 v0, v16

    if-lt v0, v2, :cond_5

    .line 278
    .end local v10    # "c":I
    .end local v16    # "i":I
    :cond_4
    const/16 v25, 0x1

    .line 279
    .local v25, "pass":I
    const/16 v18, 0x8

    .line 280
    .local v18, "inc":I
    const/16 v17, 0x0

    .line 281
    .local v17, "iline":I
    const/16 v16, 0x0

    .restart local v16    # "i":I
    :goto_1
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->ih:I

    move/from16 v0, v16

    if-lt v0, v2, :cond_7

    .line 323
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/ant/liao/GifDecoder;->dest:[I

    move-object/from16 v0, p0

    iget v3, v0, Lcom/ant/liao/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v4, v0, Lcom/ant/liao/GifDecoder;->height:I

    sget-object v5, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v2, v3, v4, v5}, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/ant/liao/GifDecoder;->image:Landroid/graphics/Bitmap;

    .line 331
    .end local v16    # "i":I
    .end local v17    # "iline":I
    .end local v18    # "inc":I
    .end local v25    # "pass":I
    :goto_2
    return-void

    .line 267
    .restart local v10    # "c":I
    .restart local v16    # "i":I
    :cond_5
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->lry:I

    add-int v2, v2, v16

    move-object/from16 v0, p0

    iget v3, v0, Lcom/ant/liao/GifDecoder;->width:I

    mul-int/2addr v2, v3

    move-object/from16 v0, p0

    iget v3, v0, Lcom/ant/liao/GifDecoder;->lrx:I

    add-int v23, v2, v3

    .line 268
    .local v23, "n1":I
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->lrw:I

    add-int v24, v23, v2

    .line 269
    .local v24, "n2":I
    move/from16 v20, v23

    .local v20, "k":I
    :goto_3
    move/from16 v0, v20

    move/from16 v1, v24

    if-lt v0, v1, :cond_6

    .line 266
    add-int/lit8 v16, v16, 0x1

    goto :goto_0

    .line 270
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/ant/liao/GifDecoder;->dest:[I

    aput v10, v2, v20

    .line 269
    add-int/lit8 v20, v20, 0x1

    goto :goto_3

    .line 282
    .end local v10    # "c":I
    .end local v20    # "k":I
    .end local v23    # "n1":I
    .end local v24    # "n2":I
    .restart local v17    # "iline":I
    .restart local v18    # "inc":I
    .restart local v25    # "pass":I
    :cond_7
    move/from16 v21, v16

    .line 283
    .local v21, "line":I
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/ant/liao/GifDecoder;->interlace:Z

    if-eqz v2, :cond_9

    .line 284
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->ih:I

    move/from16 v0, v17

    if-lt v0, v2, :cond_8

    .line 285
    add-int/lit8 v25, v25, 0x1

    .line 286
    packed-switch v25, :pswitch_data_0

    .line 299
    :cond_8
    :goto_4
    move/from16 v21, v17

    .line 300
    add-int v17, v17, v18

    .line 302
    :cond_9
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->iy:I

    add-int v21, v21, v2

    .line 303
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->height:I

    move/from16 v0, v21

    if-ge v0, v2, :cond_b

    .line 304
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->width:I

    mul-int v20, v21, v2

    .line 305
    .restart local v20    # "k":I
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->ix:I

    add-int v12, v20, v2

    .line 306
    .local v12, "dx":I
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->iw:I

    add-int v11, v12, v2

    .line 307
    .local v11, "dlim":I
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->width:I

    add-int v2, v2, v20

    if-ge v2, v11, :cond_a

    .line 308
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->width:I

    add-int v11, v20, v2

    .line 310
    :cond_a
    move-object/from16 v0, p0

    iget v2, v0, Lcom/ant/liao/GifDecoder;->iw:I

    mul-int v26, v16, v2

    .local v26, "sx":I
    move/from16 v27, v26

    .line 311
    .end local v26    # "sx":I
    .local v27, "sx":I
    :goto_5
    if-lt v12, v11, :cond_c

    .line 281
    .end local v11    # "dlim":I
    .end local v12    # "dx":I
    .end local v20    # "k":I
    .end local v27    # "sx":I
    :cond_b
    add-int/lit8 v16, v16, 0x1

    goto/16 :goto_1

    .line 288
    :pswitch_0
    const/16 v17, 0x4

    .line 289
    goto :goto_4

    .line 291
    :pswitch_1
    const/16 v17, 0x2

    .line 292
    const/16 v18, 0x4

    .line 293
    goto :goto_4

    .line 295
    :pswitch_2
    const/16 v17, 0x1

    .line 296
    const/16 v18, 0x2

    goto :goto_4

    .line 313
    .restart local v11    # "dlim":I
    .restart local v12    # "dx":I
    .restart local v20    # "k":I
    .restart local v27    # "sx":I
    :cond_c
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/ant/liao/GifDecoder;->pixels:[B

    add-int/lit8 v26, v27, 0x1

    .end local v27    # "sx":I
    .restart local v26    # "sx":I
    aget-byte v2, v2, v27

    and-int/lit16 v0, v2, 0xff

    move/from16 v19, v0

    .line 314
    .local v19, "index":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/ant/liao/GifDecoder;->act:[I

    aget v10, v2, v19

    .line 315
    .restart local v10    # "c":I
    if-eqz v10, :cond_d

    .line 316
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/ant/liao/GifDecoder;->dest:[I

    aput v10, v2, v12
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/StackOverflowError; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 318
    :cond_d
    add-int/lit8 v12, v12, 0x1

    move/from16 v27, v26

    .end local v26    # "sx":I
    .restart local v27    # "sx":I
    goto :goto_5

    .line 324
    .end local v10    # "c":I
    .end local v11    # "dlim":I
    .end local v12    # "dx":I
    .end local v16    # "i":I
    .end local v17    # "iline":I
    .end local v18    # "inc":I
    .end local v19    # "index":I
    .end local v20    # "k":I
    .end local v21    # "line":I
    .end local v25    # "pass":I
    .end local v27    # "sx":I
    :catch_0
    move-exception v13

    .line 325
    .local v13, "e":Ljava/lang/OutOfMemoryError;
    invoke-virtual {v13}, Ljava/lang/OutOfMemoryError;->printStackTrace()V

    goto/16 :goto_2

    .line 326
    .end local v13    # "e":Ljava/lang/OutOfMemoryError;
    :catch_1
    move-exception v14

    .line 327
    .local v14, "ee":Ljava/lang/StackOverflowError;
    invoke-virtual {v14}, Ljava/lang/StackOverflowError;->printStackTrace()V

    goto/16 :goto_2

    .line 328
    .end local v14    # "ee":Ljava/lang/StackOverflowError;
    :catch_2
    move-exception v15

    .line 329
    .local v15, "ex":Ljava/lang/Exception;
    const-string v2, "GifView decode setpixel"

    invoke-virtual {v15}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 286
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private skip()V
    .locals 1

    .prologue
    .line 875
    :cond_0
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readBlock()I

    .line 876
    iget v0, p0, Lcom/ant/liao/GifDecoder;->blockSize:I

    if-lez v0, :cond_1

    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->err()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 877
    :cond_1
    return-void
.end method


# virtual methods
.method public destroy()V
    .locals 1

    .prologue
    .line 194
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifDecoder;->isDestroy:Z

    .line 195
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->free()V

    .line 196
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    .line 198
    return-void
.end method

.method public getCurrentFrame()Lcom/ant/liao/GifFrame;
    .locals 6

    .prologue
    const/4 v4, 0x0

    const/4 v5, 0x0

    .line 355
    const/4 v2, 0x0

    .line 356
    .local v2, "gif":Lcom/ant/liao/GifFrame;
    iget-boolean v3, p0, Lcom/ant/liao/GifDecoder;->loopCache:Z

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    invoke-interface {v3}, Ljava/util/Queue;->size()I

    move-result v3

    if-nez v3, :cond_1

    .line 357
    iget v3, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    iget v4, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    if-lt v3, v4, :cond_0

    .line 358
    iput v5, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    .line 359
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    invoke-interface {v3}, Lcom/ant/liao/GifAction;->loopEnd()V

    .line 361
    :cond_0
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->frameCache:Ljava/util/ArrayList;

    iget v4, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "gif":Lcom/ant/liao/GifFrame;
    check-cast v2, Lcom/ant/liao/GifFrame;

    .line 362
    .restart local v2    # "gif":Lcom/ant/liao/GifFrame;
    iget v3, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    :goto_0
    move-object v3, v2

    .line 388
    :goto_1
    return-object v3

    .line 366
    :cond_1
    :try_start_0
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->lockInterruptibly()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 368
    :goto_2
    :try_start_1
    iget-boolean v3, p0, Lcom/ant/liao/GifDecoder;->loopCache:Z

    if-nez v3, :cond_2

    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    invoke-interface {v3}, Ljava/util/Queue;->size()I

    move-result v3

    if-eqz v3, :cond_4

    .line 371
    :cond_2
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->frameQueue:Ljava/util/Queue;

    invoke-interface {v3}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Lcom/ant/liao/GifFrame;

    move-object v2, v0

    .line 372
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->wCondition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Condition;->signal()V

    .line 373
    iget v3, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    .line 374
    iget-boolean v3, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    if-eqz v3, :cond_3

    iget v3, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I

    iget v5, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    if-lt v3, v5, :cond_3

    .line 375
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->action:Lcom/ant/liao/GifAction;

    invoke-interface {v3}, Lcom/ant/liao/GifAction;->loopEnd()V

    .line 376
    const/4 v3, 0x0

    iput v3, p0, Lcom/ant/liao/GifDecoder;->iCurrentFrame:I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 385
    :cond_3
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    .line 369
    :cond_4
    :try_start_2
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->rCondition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 378
    :catch_0
    move-exception v1

    .line 379
    .local v1, "ex":Ljava/lang/Exception;
    :try_start_3
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->rCondition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Condition;->signal()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 385
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    move-object v3, v4

    .line 380
    goto :goto_1

    .line 382
    .end local v1    # "ex":Ljava/lang/Exception;
    :catch_1
    move-exception v1

    .line 385
    .restart local v1    # "ex":Ljava/lang/Exception;
    iget-object v3, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    move-object v3, v4

    .line 383
    goto :goto_1

    .line 384
    .end local v1    # "ex":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    .line 385
    iget-object v4, p0, Lcom/ant/liao/GifDecoder;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 386
    throw v3
.end method

.method public getFrameCount()I
    .locals 2

    .prologue
    const/4 v0, -0x1

    .line 215
    iget-boolean v1, p0, Lcom/ant/liao/GifDecoder;->loopParse:Z

    if-nez v1, :cond_0

    iget v1, p0, Lcom/ant/liao/GifDecoder;->status:I

    if-eq v1, v0, :cond_0

    .line 218
    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/ant/liao/GifDecoder;->frameCount:I

    goto :goto_0
.end method

.method public getFrameImage()Landroid/graphics/Bitmap;
    .locals 2

    .prologue
    .line 341
    invoke-virtual {p0}, Lcom/ant/liao/GifDecoder;->getCurrentFrame()Lcom/ant/liao/GifFrame;

    move-result-object v0

    .line 342
    .local v0, "frame":Lcom/ant/liao/GifFrame;
    if-nez v0, :cond_0

    .line 343
    const/4 v1, 0x0

    .line 345
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, v0, Lcom/ant/liao/GifFrame;->image:Landroid/graphics/Bitmap;

    goto :goto_0
.end method

.method public getImage()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 227
    invoke-virtual {p0}, Lcom/ant/liao/GifDecoder;->getFrameImage()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getInputStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/ant/liao/GifDecoder;->backUpIn:Ljava/io/InputStream;

    return-object v0
.end method

.method public getLoopCount()I
    .locals 1

    .prologue
    .line 231
    iget v0, p0, Lcom/ant/liao/GifDecoder;->loopCount:I

    return v0
.end method

.method public getStatus()I
    .locals 1

    .prologue
    .line 206
    iget v0, p0, Lcom/ant/liao/GifDecoder;->status:I

    return v0
.end method

.method public next()Lcom/ant/liao/GifFrame;
    .locals 1

    .prologue
    .line 398
    invoke-virtual {p0}, Lcom/ant/liao/GifDecoder;->getCurrentFrame()Lcom/ant/liao/GifFrame;

    move-result-object v0

    return-object v0
.end method

.method public run()V
    .locals 3

    .prologue
    .line 163
    :try_start_0
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->readStream()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 168
    :goto_0
    return-void

    .line 164
    :catch_0
    move-exception v0

    .line 165
    .local v0, "ex":Ljava/lang/Exception;
    const-string v1, "GifView decode run"

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 166
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public setGifImage(Landroid/content/res/Resources;I)V
    .locals 1
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "resId"    # I

    .prologue
    .line 137
    iput-object p1, p0, Lcom/ant/liao/GifDecoder;->res:Landroid/content/res/Resources;

    .line 138
    iput p2, p0, Lcom/ant/liao/GifDecoder;->resId:I

    .line 139
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->openResourceFile()V

    .line 140
    const/4 v0, 0x1

    iput v0, p0, Lcom/ant/liao/GifDecoder;->fileType:I

    .line 141
    return-void
.end method

.method public setGifImage(Ljava/lang/String;)V
    .locals 1
    .param p1, "strFileName"    # Ljava/lang/String;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/ant/liao/GifDecoder;->strFileName:Ljava/lang/String;

    .line 149
    const/4 v0, 0x2

    iput v0, p0, Lcom/ant/liao/GifDecoder;->fileType:I

    .line 150
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->openFile()V

    .line 151
    return-void
.end method

.method public setGifImage([B)V
    .locals 1
    .param p1, "data"    # [B

    .prologue
    .line 127
    iput-object p1, p0, Lcom/ant/liao/GifDecoder;->gifData:[B

    .line 128
    invoke-direct {p0}, Lcom/ant/liao/GifDecoder;->openInputstream()V

    .line 129
    const/4 v0, 0x3

    iput v0, p0, Lcom/ant/liao/GifDecoder;->fileType:I

    .line 130
    return-void
.end method

.method public setLoopAnimation()V
    .locals 1

    .prologue
    .line 119
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifDecoder;->isLoop:Z

    .line 120
    return-void
.end method
