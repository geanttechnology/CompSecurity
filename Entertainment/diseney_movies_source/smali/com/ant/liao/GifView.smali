.class public Lcom/ant/liao/GifView;
.super Landroid/widget/ImageView;
.source "GifView.java"

# interfaces
.implements Lcom/ant/liao/GifAction;
.implements Lcom/ant/liao/GifReDraw;


# instance fields
.field private animation:Lcom/ant/liao/GifAnimation;

.field private animationRun:Z

.field private animationType:Lcom/ant/liao/GifImageType;

.field private currentFrame:I

.field private currentImage:Landroid/graphics/Bitmap;

.field private currentLoop:I

.field private gifDecoder:Lcom/ant/liao/GifDecoder;

.field private iListenerType:I

.field private isLoop:Z

.field private listener:Lcom/ant/liao/GifListener;

.field private loopNum:I

.field private redrawHandler:Landroid/os/Handler;

.field private singleFrame:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 53
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 26
    iput-object v2, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 28
    iput-object v2, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    .line 30
    iput-object v2, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    .line 32
    iput-boolean v1, p0, Lcom/ant/liao/GifView;->animationRun:Z

    .line 35
    const/4 v0, -0x1

    iput v0, p0, Lcom/ant/liao/GifView;->loopNum:I

    .line 37
    iput-boolean v1, p0, Lcom/ant/liao/GifView;->isLoop:Z

    .line 39
    iput v1, p0, Lcom/ant/liao/GifView;->currentLoop:I

    .line 41
    iput v1, p0, Lcom/ant/liao/GifView;->currentFrame:I

    .line 43
    iput-object v2, p0, Lcom/ant/liao/GifView;->listener:Lcom/ant/liao/GifListener;

    .line 45
    iput-boolean v1, p0, Lcom/ant/liao/GifView;->singleFrame:Z

    .line 48
    iput v1, p0, Lcom/ant/liao/GifView;->iListenerType:I

    .line 50
    sget-object v0, Lcom/ant/liao/GifImageType;->SYNC_DECODER:Lcom/ant/liao/GifImageType;

    iput-object v0, p0, Lcom/ant/liao/GifView;->animationType:Lcom/ant/liao/GifImageType;

    .line 379
    new-instance v0, Lcom/ant/liao/GifView$1;

    invoke-direct {v0, p0}, Lcom/ant/liao/GifView$1;-><init>(Lcom/ant/liao/GifView;)V

    iput-object v0, p0, Lcom/ant/liao/GifView;->redrawHandler:Landroid/os/Handler;

    .line 54
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, v0}, Lcom/ant/liao/GifView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 55
    new-instance v0, Lcom/ant/liao/GifAnimation;

    invoke-direct {v0}, Lcom/ant/liao/GifAnimation;-><init>()V

    iput-object v0, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    .line 56
    iget-object v0, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0, p0}, Lcom/ant/liao/GifAnimation;->setRedraw(Lcom/ant/liao/GifReDraw;)V

    .line 57
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 60
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/ant/liao/GifView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 61
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 64
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 26
    iput-object v2, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 28
    iput-object v2, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    .line 30
    iput-object v2, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    .line 32
    iput-boolean v1, p0, Lcom/ant/liao/GifView;->animationRun:Z

    .line 35
    const/4 v0, -0x1

    iput v0, p0, Lcom/ant/liao/GifView;->loopNum:I

    .line 37
    iput-boolean v1, p0, Lcom/ant/liao/GifView;->isLoop:Z

    .line 39
    iput v1, p0, Lcom/ant/liao/GifView;->currentLoop:I

    .line 41
    iput v1, p0, Lcom/ant/liao/GifView;->currentFrame:I

    .line 43
    iput-object v2, p0, Lcom/ant/liao/GifView;->listener:Lcom/ant/liao/GifListener;

    .line 45
    iput-boolean v1, p0, Lcom/ant/liao/GifView;->singleFrame:Z

    .line 48
    iput v1, p0, Lcom/ant/liao/GifView;->iListenerType:I

    .line 50
    sget-object v0, Lcom/ant/liao/GifImageType;->SYNC_DECODER:Lcom/ant/liao/GifImageType;

    iput-object v0, p0, Lcom/ant/liao/GifView;->animationType:Lcom/ant/liao/GifImageType;

    .line 379
    new-instance v0, Lcom/ant/liao/GifView$1;

    invoke-direct {v0, p0}, Lcom/ant/liao/GifView$1;-><init>(Lcom/ant/liao/GifView;)V

    iput-object v0, p0, Lcom/ant/liao/GifView;->redrawHandler:Landroid/os/Handler;

    .line 65
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, v0}, Lcom/ant/liao/GifView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 66
    new-instance v0, Lcom/ant/liao/GifAnimation;

    invoke-direct {v0}, Lcom/ant/liao/GifAnimation;-><init>()V

    iput-object v0, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    .line 67
    iget-object v0, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0, p0}, Lcom/ant/liao/GifAnimation;->setRedraw(Lcom/ant/liao/GifReDraw;)V

    .line 68
    return-void
.end method

.method static synthetic access$0(Lcom/ant/liao/GifView;)V
    .locals 0

    .prologue
    .line 367
    invoke-direct {p0}, Lcom/ant/liao/GifView;->drawImage()V

    return-void
.end method

.method private drawImage()V
    .locals 2

    .prologue
    .line 368
    iget-object v0, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-nez v0, :cond_2

    .line 369
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    invoke-virtual {p0, v0}, Lcom/ant/liao/GifView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 370
    invoke-virtual {p0}, Lcom/ant/liao/GifView;->invalidate()V

    .line 371
    iget-object v0, p0, Lcom/ant/liao/GifView;->listener:Lcom/ant/liao/GifListener;

    if-eqz v0, :cond_2

    .line 372
    iget v0, p0, Lcom/ant/liao/GifView;->iListenerType:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_1

    iget v0, p0, Lcom/ant/liao/GifView;->iListenerType:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    .line 373
    :cond_1
    iget v0, p0, Lcom/ant/liao/GifView;->currentFrame:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/ant/liao/GifView;->currentFrame:I

    .line 374
    iget-object v0, p0, Lcom/ant/liao/GifView;->listener:Lcom/ant/liao/GifListener;

    iget v1, p0, Lcom/ant/liao/GifView;->currentFrame:I

    invoke-interface {v0, v1}, Lcom/ant/liao/GifListener;->frameCount(I)V

    .line 377
    :cond_2
    return-void
.end method

.method private getCurrentFrame()I
    .locals 3

    .prologue
    const/4 v1, -0x1

    .line 340
    iget-object v2, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    if-eqz v2, :cond_0

    .line 341
    iget-object v2, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v2}, Lcom/ant/liao/GifDecoder;->next()Lcom/ant/liao/GifFrame;

    move-result-object v0

    .line 342
    .local v0, "frame":Lcom/ant/liao/GifFrame;
    if-nez v0, :cond_1

    .line 350
    .end local v0    # "frame":Lcom/ant/liao/GifFrame;
    :cond_0
    :goto_0
    return v1

    .line 345
    .restart local v0    # "frame":Lcom/ant/liao/GifFrame;
    :cond_1
    iget-object v1, v0, Lcom/ant/liao/GifFrame;->image:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_2

    .line 346
    iget-object v1, v0, Lcom/ant/liao/GifFrame;->image:Landroid/graphics/Bitmap;

    iput-object v1, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    .line 348
    :cond_2
    iget v1, v0, Lcom/ant/liao/GifFrame;->delay:I

    goto :goto_0
.end method

.method private init()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 71
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDrawThread()V

    .line 72
    iget-object v0, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 73
    iput-object v1, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    .line 75
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    if-eqz v0, :cond_1

    .line 76
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDecodeThread()V

    .line 77
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->destroy()V

    .line 78
    iput-object v1, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 80
    :cond_1
    const/4 v0, 0x0

    iput v0, p0, Lcom/ant/liao/GifView;->currentLoop:I

    .line 81
    new-instance v0, Lcom/ant/liao/GifDecoder;

    invoke-direct {v0, p0}, Lcom/ant/liao/GifDecoder;-><init>(Lcom/ant/liao/GifAction;)V

    iput-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 82
    iget-boolean v0, p0, Lcom/ant/liao/GifView;->isLoop:Z

    if-eqz v0, :cond_2

    .line 83
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->setLoopAnimation()V

    .line 85
    :cond_2
    return-void
.end method

.method private invalidateImage()V
    .locals 2

    .prologue
    .line 361
    iget-object v1, p0, Lcom/ant/liao/GifView;->redrawHandler:Landroid/os/Handler;

    if-eqz v1, :cond_0

    .line 362
    iget-object v1, p0, Lcom/ant/liao/GifView;->redrawHandler:Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 363
    .local v0, "msg":Landroid/os/Message;
    iget-object v1, p0, Lcom/ant/liao/GifView;->redrawHandler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 365
    .end local v0    # "msg":Landroid/os/Message;
    :cond_0
    return-void
.end method

.method private reAnimation()V
    .locals 1

    .prologue
    .line 272
    iget-boolean v0, p0, Lcom/ant/liao/GifView;->singleFrame:Z

    if-eqz v0, :cond_0

    .line 277
    :goto_0
    return-void

    .line 274
    :cond_0
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDrawThread()V

    .line 275
    const/4 v0, 0x0

    iput v0, p0, Lcom/ant/liao/GifView;->currentLoop:I

    .line 276
    iget-object v0, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->runAnimation()V

    goto :goto_0
.end method

.method private setGifDecoderImage(Landroid/content/res/Resources;I)V
    .locals 1
    .param p1, "rs"    # Landroid/content/res/Resources;
    .param p2, "resId"    # I

    .prologue
    .line 100
    invoke-direct {p0}, Lcom/ant/liao/GifView;->init()V

    .line 101
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0, p1, p2}, Lcom/ant/liao/GifDecoder;->setGifImage(Landroid/content/res/Resources;I)V

    .line 102
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->start()V

    .line 103
    return-void
.end method

.method private setGifDecoderImage([B)V
    .locals 1
    .param p1, "gif"    # [B

    .prologue
    .line 94
    invoke-direct {p0}, Lcom/ant/liao/GifView;->init()V

    .line 95
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0, p1}, Lcom/ant/liao/GifDecoder;->setGifImage([B)V

    .line 96
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->start()V

    .line 97
    return-void
.end method

.method private stopDecodeThread()V
    .locals 2

    .prologue
    .line 239
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->getState()Ljava/lang/Thread$State;

    move-result-object v0

    sget-object v1, Ljava/lang/Thread$State;->TERMINATED:Ljava/lang/Thread$State;

    if-eq v0, v1, :cond_0

    .line 240
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->interrupt()V

    .line 241
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->destroy()V

    .line 243
    :cond_0
    return-void
.end method

.method private stopDrawThread()V
    .locals 1

    .prologue
    .line 229
    iget-boolean v0, p0, Lcom/ant/liao/GifView;->singleFrame:Z

    if-eqz v0, :cond_0

    .line 233
    :goto_0
    return-void

    .line 231
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->stopAnimation()V

    .line 232
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/ant/liao/GifView;->animationRun:Z

    goto :goto_0
.end method


# virtual methods
.method public destroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 184
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDrawThread()V

    .line 185
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDecodeThread()V

    .line 186
    iget-object v0, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->destroy()V

    .line 187
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->destroy()V

    .line 188
    iput-object v1, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 189
    iput-object v1, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    .line 190
    return-void
.end method

.method public dispatchWindowVisibilityChanged(I)V
    .locals 1
    .param p1, "visibility"    # I

    .prologue
    .line 257
    const/16 v0, 0x8

    if-eq p1, v0, :cond_0

    const/4 v0, 0x4

    if-ne p1, v0, :cond_2

    .line 258
    :cond_0
    invoke-virtual {p0}, Lcom/ant/liao/GifView;->pauseGifAnimation()V

    .line 262
    :cond_1
    :goto_0
    invoke-super {p0, p1}, Landroid/widget/ImageView;->dispatchWindowVisibilityChanged(I)V

    .line 263
    return-void

    .line 259
    :cond_2
    if-nez p1, :cond_1

    .line 260
    invoke-virtual {p0}, Lcom/ant/liao/GifView;->restartGifAnimation()V

    goto :goto_0
.end method

.method public loopEnd()V
    .locals 2

    .prologue
    .line 325
    iget v0, p0, Lcom/ant/liao/GifView;->currentLoop:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/ant/liao/GifView;->currentLoop:I

    .line 326
    iget v0, p0, Lcom/ant/liao/GifView;->loopNum:I

    if-lez v0, :cond_0

    .line 327
    iget v0, p0, Lcom/ant/liao/GifView;->currentLoop:I

    iget v1, p0, Lcom/ant/liao/GifView;->loopNum:I

    if-lt v0, v1, :cond_0

    .line 328
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDrawThread()V

    .line 329
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDecodeThread()V

    .line 332
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifView;->listener:Lcom/ant/liao/GifListener;

    if-eqz v0, :cond_3

    .line 333
    iget v0, p0, Lcom/ant/liao/GifView;->iListenerType:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1

    iget v0, p0, Lcom/ant/liao/GifView;->iListenerType:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    .line 334
    :cond_1
    iget-object v0, p0, Lcom/ant/liao/GifView;->listener:Lcom/ant/liao/GifListener;

    iget v1, p0, Lcom/ant/liao/GifView;->currentLoop:I

    invoke-interface {v0, v1}, Lcom/ant/liao/GifListener;->gifEnd(I)V

    .line 335
    :cond_2
    const/4 v0, 0x0

    iput v0, p0, Lcom/ant/liao/GifView;->currentFrame:I

    .line 337
    :cond_3
    return-void
.end method

.method protected onWindowVisibilityChanged(I)V
    .locals 0
    .param p1, "visibility"    # I

    .prologue
    .line 268
    return-void
.end method

.method public parseReturn(I)V
    .locals 3
    .param p1, "iResult"    # I

    .prologue
    const/4 v2, 0x1

    .line 283
    invoke-virtual {p0}, Lcom/ant/liao/GifView;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-eq v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/ant/liao/GifView;->getVisibility()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    .line 322
    :cond_0
    :goto_0
    return-void

    .line 286
    :cond_1
    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 288
    :pswitch_0
    const-string v0, "parseReturn"

    const-string v1, "FIRST"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 289
    iget-object v0, p0, Lcom/ant/liao/GifView;->animationType:Lcom/ant/liao/GifImageType;

    sget-object v1, Lcom/ant/liao/GifImageType;->COVER:Lcom/ant/liao/GifImageType;

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lcom/ant/liao/GifView;->animationType:Lcom/ant/liao/GifImageType;

    sget-object v1, Lcom/ant/liao/GifImageType;->SYNC_DECODER:Lcom/ant/liao/GifImageType;

    if-ne v0, v1, :cond_0

    .line 290
    :cond_2
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->getFrameImage()Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/ant/liao/GifView;->currentImage:Landroid/graphics/Bitmap;

    .line 291
    invoke-direct {p0}, Lcom/ant/liao/GifView;->invalidateImage()V

    goto :goto_0

    .line 296
    :pswitch_1
    const-string v0, "parseReturn"

    const-string v1, "FINISH"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 297
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->getFrameCount()I

    move-result v0

    if-ne v0, v2, :cond_3

    .line 299
    invoke-direct {p0}, Lcom/ant/liao/GifView;->getCurrentFrame()I

    .line 300
    invoke-direct {p0}, Lcom/ant/liao/GifView;->invalidateImage()V

    .line 301
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDrawThread()V

    .line 302
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDecodeThread()V

    .line 303
    iput-boolean v2, p0, Lcom/ant/liao/GifView;->singleFrame:Z

    goto :goto_0

    .line 305
    :cond_3
    iget-boolean v0, p0, Lcom/ant/liao/GifView;->animationRun:Z

    if-nez v0, :cond_0

    .line 306
    invoke-direct {p0}, Lcom/ant/liao/GifView;->reAnimation()V

    .line 307
    iput-boolean v2, p0, Lcom/ant/liao/GifView;->animationRun:Z

    goto :goto_0

    .line 312
    :pswitch_2
    const-string v0, "parseReturn"

    const-string v1, "CACHE_FINISH"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 313
    iget-boolean v0, p0, Lcom/ant/liao/GifView;->animationRun:Z

    if-nez v0, :cond_0

    .line 314
    invoke-direct {p0}, Lcom/ant/liao/GifView;->reAnimation()V

    .line 315
    iput-boolean v2, p0, Lcom/ant/liao/GifView;->animationRun:Z

    goto :goto_0

    .line 319
    :pswitch_3
    const-string v0, "parseReturn"

    const-string v1, "ERROR"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 286
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public pauseGifAnimation()V
    .locals 1

    .prologue
    .line 208
    iget-boolean v0, p0, Lcom/ant/liao/GifView;->singleFrame:Z

    if-eqz v0, :cond_0

    .line 211
    :goto_0
    return-void

    .line 210
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->pauseAnimation()V

    goto :goto_0
.end method

.method public reDraw()I
    .locals 1

    .prologue
    .line 355
    invoke-direct {p0}, Lcom/ant/liao/GifView;->getCurrentFrame()I

    move-result v0

    .line 356
    .local v0, "delay":I
    invoke-direct {p0}, Lcom/ant/liao/GifView;->drawImage()V

    .line 357
    return v0
.end method

.method public restartGifAnimation()V
    .locals 1

    .prologue
    .line 196
    iget-boolean v0, p0, Lcom/ant/liao/GifView;->singleFrame:Z

    if-eqz v0, :cond_1

    .line 201
    :cond_0
    :goto_0
    return-void

    .line 198
    :cond_1
    iget-boolean v0, p0, Lcom/ant/liao/GifView;->animationRun:Z

    if-eqz v0, :cond_0

    .line 199
    iget-object v0, p0, Lcom/ant/liao/GifView;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->restartAnimation()V

    goto :goto_0
.end method

.method public setGifImage(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 176
    invoke-virtual {p0}, Lcom/ant/liao/GifView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Lcom/ant/liao/GifView;->setGifDecoderImage(Landroid/content/res/Resources;I)V

    .line 177
    return-void
.end method

.method public setGifImage(Ljava/lang/String;)V
    .locals 1
    .param p1, "strFileName"    # Ljava/lang/String;

    .prologue
    .line 164
    invoke-direct {p0}, Lcom/ant/liao/GifView;->init()V

    .line 165
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0, p1}, Lcom/ant/liao/GifDecoder;->setGifImage(Ljava/lang/String;)V

    .line 166
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->start()V

    .line 167
    return-void
.end method

.method public setGifImage([B)V
    .locals 0
    .param p1, "gif"    # [B

    .prologue
    .line 154
    invoke-direct {p0, p1}, Lcom/ant/liao/GifView;->setGifDecoderImage([B)V

    .line 155
    return-void
.end method

.method public setGifImageType(Lcom/ant/liao/GifImageType;)V
    .locals 1
    .param p1, "type"    # Lcom/ant/liao/GifImageType;

    .prologue
    .line 221
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    if-nez v0, :cond_0

    .line 222
    iput-object p1, p0, Lcom/ant/liao/GifView;->animationType:Lcom/ant/liao/GifImageType;

    .line 223
    :cond_0
    return-void
.end method

.method public setListener(Lcom/ant/liao/GifListener;I)V
    .locals 1
    .param p1, "listener"    # Lcom/ant/liao/GifListener;
    .param p2, "iType"    # I

    .prologue
    .line 114
    iput-object p1, p0, Lcom/ant/liao/GifView;->listener:Lcom/ant/liao/GifListener;

    .line 115
    const/4 v0, 0x1

    if-lt p2, v0, :cond_0

    const/4 v0, 0x3

    if-gt p2, v0, :cond_0

    .line 116
    iput p2, p0, Lcom/ant/liao/GifView;->iListenerType:I

    .line 118
    :cond_0
    return-void
.end method

.method public setLoopAnimation()V
    .locals 1

    .prologue
    .line 139
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifView;->isLoop:Z

    .line 140
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    if-eqz v0, :cond_0

    .line 141
    iget-object v0, p0, Lcom/ant/liao/GifView;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->setLoopAnimation()V

    .line 143
    :cond_0
    return-void
.end method

.method public setLoopNumber(I)V
    .locals 1
    .param p1, "num"    # I

    .prologue
    .line 128
    const/4 v0, 0x1

    if-le p1, v0, :cond_0

    .line 129
    iput p1, p0, Lcom/ant/liao/GifView;->loopNum:I

    .line 130
    invoke-virtual {p0}, Lcom/ant/liao/GifView;->setLoopAnimation()V

    .line 132
    :cond_0
    return-void
.end method

.method public setVisibility(I)V
    .locals 1
    .param p1, "visibility"    # I

    .prologue
    .line 247
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 248
    const/16 v0, 0x8

    if-eq p1, v0, :cond_0

    const/4 v0, 0x4

    if-ne p1, v0, :cond_2

    .line 249
    :cond_0
    invoke-direct {p0}, Lcom/ant/liao/GifView;->stopDrawThread()V

    .line 253
    :cond_1
    :goto_0
    return-void

    .line 250
    :cond_2
    if-nez p1, :cond_1

    .line 251
    invoke-direct {p0}, Lcom/ant/liao/GifView;->reAnimation()V

    goto :goto_0
.end method
