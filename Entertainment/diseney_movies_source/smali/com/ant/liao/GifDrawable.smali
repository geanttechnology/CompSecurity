.class public Lcom/ant/liao/GifDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "GifDrawable.java"

# interfaces
.implements Lcom/ant/liao/GifAction;
.implements Lcom/ant/liao/GifReDraw;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/ant/liao/GifDrawable$BitmapState;
    }
.end annotation


# static fields
.field private static final DEFAULT_PAINT_FLAGS:I = 0x6


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

.field private mApplyGravity:Z

.field private mBitmap:Landroid/graphics/Bitmap;

.field private mBitmapHeight:I

.field private mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

.field private mBitmapWidth:I

.field private final mDstRect:Landroid/graphics/Rect;

.field private mMutated:Z

.field private mTargetDensity:I

.field private redrawHandler:Landroid/os/Handler;

.field private singleFrame:Z


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 53
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 28
    iput-object v2, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 30
    sget-object v0, Lcom/ant/liao/GifImageType;->SYNC_DECODER:Lcom/ant/liao/GifImageType;

    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->animationType:Lcom/ant/liao/GifImageType;

    .line 32
    const/4 v0, -0x1

    iput v0, p0, Lcom/ant/liao/GifDrawable;->loopNum:I

    .line 34
    iput v1, p0, Lcom/ant/liao/GifDrawable;->currentLoop:I

    .line 36
    iput-object v2, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    .line 38
    iput-boolean v1, p0, Lcom/ant/liao/GifDrawable;->animationRun:Z

    .line 40
    iput-boolean v1, p0, Lcom/ant/liao/GifDrawable;->isLoop:Z

    .line 42
    iput-boolean v1, p0, Lcom/ant/liao/GifDrawable;->singleFrame:Z

    .line 45
    iput-object v2, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    .line 47
    iput-object v2, p0, Lcom/ant/liao/GifDrawable;->listener:Lcom/ant/liao/GifListener;

    .line 49
    iput v1, p0, Lcom/ant/liao/GifDrawable;->iListenerType:I

    .line 51
    iput v1, p0, Lcom/ant/liao/GifDrawable;->currentFrame:I

    .line 243
    new-instance v0, Lcom/ant/liao/GifDrawable$1;

    invoke-direct {v0, p0}, Lcom/ant/liao/GifDrawable$1;-><init>(Lcom/ant/liao/GifDrawable;)V

    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->redrawHandler:Landroid/os/Handler;

    .line 329
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->mDstRect:Landroid/graphics/Rect;

    .line 54
    new-instance v0, Lcom/ant/liao/GifDrawable$BitmapState;

    invoke-direct {v0, v2}, Lcom/ant/liao/GifDrawable$BitmapState;-><init>(Landroid/graphics/Bitmap;)V

    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    .line 55
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget v1, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    iput v1, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mTargetDensity:I

    .line 56
    new-instance v0, Lcom/ant/liao/GifAnimation;

    invoke-direct {v0}, Lcom/ant/liao/GifAnimation;-><init>()V

    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    .line 57
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0, p0}, Lcom/ant/liao/GifAnimation;->setRedraw(Lcom/ant/liao/GifReDraw;)V

    .line 58
    return-void
.end method

.method private constructor <init>(Lcom/ant/liao/GifDrawable$BitmapState;Landroid/content/res/Resources;)V
    .locals 3
    .param p1, "state"    # Lcom/ant/liao/GifDrawable$BitmapState;
    .param p2, "res"    # Landroid/content/res/Resources;

    .prologue
    const/4 v0, 0x0

    const/4 v2, 0x0

    .line 691
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 28
    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 30
    sget-object v1, Lcom/ant/liao/GifImageType;->SYNC_DECODER:Lcom/ant/liao/GifImageType;

    iput-object v1, p0, Lcom/ant/liao/GifDrawable;->animationType:Lcom/ant/liao/GifImageType;

    .line 32
    const/4 v1, -0x1

    iput v1, p0, Lcom/ant/liao/GifDrawable;->loopNum:I

    .line 34
    iput v2, p0, Lcom/ant/liao/GifDrawable;->currentLoop:I

    .line 36
    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    .line 38
    iput-boolean v2, p0, Lcom/ant/liao/GifDrawable;->animationRun:Z

    .line 40
    iput-boolean v2, p0, Lcom/ant/liao/GifDrawable;->isLoop:Z

    .line 42
    iput-boolean v2, p0, Lcom/ant/liao/GifDrawable;->singleFrame:Z

    .line 45
    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    .line 47
    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->listener:Lcom/ant/liao/GifListener;

    .line 49
    iput v2, p0, Lcom/ant/liao/GifDrawable;->iListenerType:I

    .line 51
    iput v2, p0, Lcom/ant/liao/GifDrawable;->currentFrame:I

    .line 243
    new-instance v1, Lcom/ant/liao/GifDrawable$1;

    invoke-direct {v1, p0}, Lcom/ant/liao/GifDrawable$1;-><init>(Lcom/ant/liao/GifDrawable;)V

    iput-object v1, p0, Lcom/ant/liao/GifDrawable;->redrawHandler:Landroid/os/Handler;

    .line 329
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, p0, Lcom/ant/liao/GifDrawable;->mDstRect:Landroid/graphics/Rect;

    .line 692
    iput-object p1, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    .line 693
    if-eqz p2, :cond_1

    .line 694
    invoke-virtual {p2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->densityDpi:I

    iput v1, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    .line 698
    :goto_0
    if-eqz p1, :cond_0

    iget-object v0, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mBitmap:Landroid/graphics/Bitmap;

    :cond_0
    invoke-direct {p0, v0}, Lcom/ant/liao/GifDrawable;->setBitmap(Landroid/graphics/Bitmap;)V

    .line 699
    return-void

    .line 696
    :cond_1
    iget v1, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mTargetDensity:I

    iput v1, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    goto :goto_0
.end method

.method synthetic constructor <init>(Lcom/ant/liao/GifDrawable$BitmapState;Landroid/content/res/Resources;Lcom/ant/liao/GifDrawable;)V
    .locals 0

    .prologue
    .line 691
    invoke-direct {p0, p1, p2}, Lcom/ant/liao/GifDrawable;-><init>(Lcom/ant/liao/GifDrawable$BitmapState;Landroid/content/res/Resources;)V

    return-void
.end method

.method static synthetic access$0(Lcom/ant/liao/GifDrawable;)V
    .locals 0

    .prologue
    .line 232
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->drawImage()V

    return-void
.end method

.method private computeBitmapSize()V
    .locals 2

    .prologue
    .line 355
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmap:Landroid/graphics/Bitmap;

    iget v1, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    invoke-virtual {v0, v1}, Landroid/graphics/Bitmap;->getScaledWidth(I)I

    move-result v0

    iput v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapWidth:I

    .line 356
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmap:Landroid/graphics/Bitmap;

    iget v1, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    invoke-virtual {v0, v1}, Landroid/graphics/Bitmap;->getScaledHeight(I)I

    move-result v0

    iput v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapHeight:I

    .line 357
    return-void
.end method

.method private drawImage()V
    .locals 2

    .prologue
    .line 233
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-nez v0, :cond_3

    .line 234
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0}, Lcom/ant/liao/GifDrawable;->setBitmap(Landroid/graphics/Bitmap;)V

    .line 235
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->listener:Lcom/ant/liao/GifListener;

    if-eqz v0, :cond_2

    iget v0, p0, Lcom/ant/liao/GifDrawable;->iListenerType:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_1

    iget v0, p0, Lcom/ant/liao/GifDrawable;->iListenerType:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    .line 236
    :cond_1
    iget v0, p0, Lcom/ant/liao/GifDrawable;->currentFrame:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/ant/liao/GifDrawable;->currentFrame:I

    .line 237
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->listener:Lcom/ant/liao/GifListener;

    iget v1, p0, Lcom/ant/liao/GifDrawable;->currentFrame:I

    invoke-interface {v0, v1}, Lcom/ant/liao/GifListener;->frameCount(I)V

    .line 239
    :cond_2
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 241
    :cond_3
    return-void
.end method

.method private getCurrentFrame()I
    .locals 4

    .prologue
    const/4 v2, -0x1

    .line 205
    iget-object v3, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    if-eqz v3, :cond_0

    .line 206
    iget-object v3, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v3}, Lcom/ant/liao/GifDecoder;->next()Lcom/ant/liao/GifFrame;

    move-result-object v0

    .line 207
    .local v0, "frame":Lcom/ant/liao/GifFrame;
    if-nez v0, :cond_1

    .line 218
    .end local v0    # "frame":Lcom/ant/liao/GifFrame;
    :cond_0
    :goto_0
    return v2

    .line 210
    .restart local v0    # "frame":Lcom/ant/liao/GifFrame;
    :cond_1
    iget-object v2, v0, Lcom/ant/liao/GifFrame;->image:Landroid/graphics/Bitmap;

    if-eqz v2, :cond_2

    .line 211
    iget-object v2, v0, Lcom/ant/liao/GifFrame;->image:Landroid/graphics/Bitmap;

    iput-object v2, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    .line 212
    new-instance v1, Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v2, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    invoke-direct {v1, v2}, Lcom/ant/liao/GifDrawable$BitmapState;-><init>(Landroid/graphics/Bitmap;)V

    .line 213
    .local v1, "mb":Lcom/ant/liao/GifDrawable$BitmapState;
    iget v2, v1, Lcom/ant/liao/GifDrawable$BitmapState;->mTargetDensity:I

    iput v2, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    .line 214
    iget-object v2, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget v3, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    iput v3, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mTargetDensity:I

    .line 216
    .end local v1    # "mb":Lcom/ant/liao/GifDrawable$BitmapState;
    :cond_2
    iget v2, v0, Lcom/ant/liao/GifFrame;->delay:I

    goto :goto_0
.end method

.method private init()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 61
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->stopDrawThread()V

    .line 62
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 63
    iput-object v1, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    .line 65
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    if-eqz v0, :cond_1

    .line 66
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->stopDecodeThread()V

    .line 67
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->destroy()V

    .line 68
    iput-object v1, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 70
    :cond_1
    const/4 v0, 0x0

    iput v0, p0, Lcom/ant/liao/GifDrawable;->currentLoop:I

    .line 71
    new-instance v0, Lcom/ant/liao/GifDecoder;

    invoke-direct {v0, p0}, Lcom/ant/liao/GifDecoder;-><init>(Lcom/ant/liao/GifAction;)V

    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 72
    iget-boolean v0, p0, Lcom/ant/liao/GifDrawable;->isLoop:Z

    if-eqz v0, :cond_2

    .line 73
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->setLoopAnimation()V

    .line 75
    :cond_2
    return-void
.end method

.method private invalidateImage()V
    .locals 2

    .prologue
    .line 297
    iget-object v1, p0, Lcom/ant/liao/GifDrawable;->redrawHandler:Landroid/os/Handler;

    if-eqz v1, :cond_0

    .line 298
    iget-object v1, p0, Lcom/ant/liao/GifDrawable;->redrawHandler:Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 299
    .local v0, "msg":Landroid/os/Message;
    iget-object v1, p0, Lcom/ant/liao/GifDrawable;->redrawHandler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 302
    .end local v0    # "msg":Landroid/os/Message;
    :cond_0
    return-void
.end method

.method private reAnimation()V
    .locals 1

    .prologue
    .line 197
    iget-boolean v0, p0, Lcom/ant/liao/GifDrawable;->singleFrame:Z

    if-eqz v0, :cond_0

    .line 202
    :goto_0
    return-void

    .line 199
    :cond_0
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->stopDrawThread()V

    .line 200
    const/4 v0, 0x0

    iput v0, p0, Lcom/ant/liao/GifDrawable;->currentLoop:I

    .line 201
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->runAnimation()V

    goto :goto_0
.end method

.method private setBitmap(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 360
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmap:Landroid/graphics/Bitmap;

    if-eq p1, v0, :cond_1

    .line 361
    iput-object p1, p0, Lcom/ant/liao/GifDrawable;->mBitmap:Landroid/graphics/Bitmap;

    .line 362
    if-eqz p1, :cond_2

    .line 363
    iget v0, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    if-nez v0, :cond_0

    .line 364
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getDensity()I

    move-result v0

    iput v0, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    .line 366
    :cond_0
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->computeBitmapSize()V

    .line 370
    :goto_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifDrawable;->mApplyGravity:Z

    .line 371
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 373
    :cond_1
    return-void

    .line 368
    :cond_2
    const/4 v0, -0x1

    iput v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapHeight:I

    iput v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapWidth:I

    goto :goto_0
.end method

.method private stopDecodeThread()V
    .locals 2

    .prologue
    .line 180
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->getState()Ljava/lang/Thread$State;

    move-result-object v0

    sget-object v1, Ljava/lang/Thread$State;->TERMINATED:Ljava/lang/Thread$State;

    if-eq v0, v1, :cond_0

    .line 182
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->interrupt()V

    .line 184
    :cond_0
    return-void
.end method

.method private stopDrawThread()V
    .locals 1

    .prologue
    .line 190
    iget-boolean v0, p0, Lcom/ant/liao/GifDrawable;->singleFrame:Z

    if-eqz v0, :cond_0

    .line 194
    :goto_0
    return-void

    .line 192
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->stopAnimation()V

    .line 193
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/ant/liao/GifDrawable;->animationRun:Z

    goto :goto_0
.end method


# virtual methods
.method public destroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 114
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->stopDrawThread()V

    .line 115
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->stopDecodeThread()V

    .line 116
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->destroy()V

    .line 117
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->destroy()V

    .line 118
    iput-object v1, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    .line 119
    iput-object v1, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    .line 120
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 12
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v11, 0x0

    const/4 v10, 0x0

    .line 547
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmap:Landroid/graphics/Bitmap;

    .line 548
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_2

    .line 549
    iget-object v2, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    .line 550
    .local v2, "state":Lcom/ant/liao/GifDrawable$BitmapState;
    iget-boolean v5, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mRebuildShader:Z

    if-eqz v5, :cond_0

    .line 551
    iget-object v3, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeX:Landroid/graphics/Shader$TileMode;

    .line 552
    .local v3, "tmx":Landroid/graphics/Shader$TileMode;
    iget-object v4, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeY:Landroid/graphics/Shader$TileMode;

    .line 554
    .local v4, "tmy":Landroid/graphics/Shader$TileMode;
    if-nez v3, :cond_3

    if-nez v4, :cond_3

    .line 555
    iget-object v5, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v5, v11}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 561
    .end local v3    # "tmx":Landroid/graphics/Shader$TileMode;
    .end local v4    # "tmy":Landroid/graphics/Shader$TileMode;
    :goto_0
    iput-boolean v10, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mRebuildShader:Z

    .line 562
    iget-object v5, p0, Lcom/ant/liao/GifDrawable;->mDstRect:Landroid/graphics/Rect;

    invoke-virtual {p0, v5}, Lcom/ant/liao/GifDrawable;->copyBounds(Landroid/graphics/Rect;)V

    .line 565
    :cond_0
    iget-object v5, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v5}, Landroid/graphics/Paint;->getShader()Landroid/graphics/Shader;

    move-result-object v1

    .line 566
    .local v1, "shader":Landroid/graphics/Shader;
    if-nez v1, :cond_6

    .line 567
    iget-boolean v5, p0, Lcom/ant/liao/GifDrawable;->mApplyGravity:Z

    if-eqz v5, :cond_1

    .line 568
    iget v5, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mGravity:I

    iget v6, p0, Lcom/ant/liao/GifDrawable;->mBitmapWidth:I

    iget v7, p0, Lcom/ant/liao/GifDrawable;->mBitmapHeight:I

    .line 569
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v8

    iget-object v9, p0, Lcom/ant/liao/GifDrawable;->mDstRect:Landroid/graphics/Rect;

    .line 568
    invoke-static {v5, v6, v7, v8, v9}, Landroid/view/Gravity;->apply(IIILandroid/graphics/Rect;Landroid/graphics/Rect;)V

    .line 575
    iput-boolean v10, p0, Lcom/ant/liao/GifDrawable;->mApplyGravity:Z

    .line 577
    :cond_1
    iget-object v5, p0, Lcom/ant/liao/GifDrawable;->mDstRect:Landroid/graphics/Rect;

    iget-object v6, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v11, v5, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 586
    .end local v1    # "shader":Landroid/graphics/Shader;
    .end local v2    # "state":Lcom/ant/liao/GifDrawable$BitmapState;
    :cond_2
    :goto_1
    return-void

    .line 557
    .restart local v2    # "state":Lcom/ant/liao/GifDrawable$BitmapState;
    .restart local v3    # "tmx":Landroid/graphics/Shader$TileMode;
    .restart local v4    # "tmy":Landroid/graphics/Shader$TileMode;
    :cond_3
    iget-object v5, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    new-instance v6, Landroid/graphics/BitmapShader;

    .line 558
    if-nez v3, :cond_4

    sget-object v3, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    .line 559
    .end local v3    # "tmx":Landroid/graphics/Shader$TileMode;
    :cond_4
    if-nez v4, :cond_5

    sget-object v4, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    .end local v4    # "tmy":Landroid/graphics/Shader$TileMode;
    :cond_5
    invoke-direct {v6, v0, v3, v4}, Landroid/graphics/BitmapShader;-><init>(Landroid/graphics/Bitmap;Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V

    .line 557
    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    goto :goto_0

    .line 579
    .restart local v1    # "shader":Landroid/graphics/Shader;
    :cond_6
    iget-boolean v5, p0, Lcom/ant/liao/GifDrawable;->mApplyGravity:Z

    if-eqz v5, :cond_7

    .line 580
    iget-object v5, p0, Lcom/ant/liao/GifDrawable;->mDstRect:Landroid/graphics/Rect;

    invoke-virtual {p0, v5}, Lcom/ant/liao/GifDrawable;->copyBounds(Landroid/graphics/Rect;)V

    .line 581
    iput-boolean v10, p0, Lcom/ant/liao/GifDrawable;->mApplyGravity:Z

    .line 583
    :cond_7
    iget-object v5, p0, Lcom/ant/liao/GifDrawable;->mDstRect:Landroid/graphics/Rect;

    iget-object v6, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v5, v6}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    goto :goto_1
.end method

.method public final getBitmap()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getChangingConfigurations()I
    .locals 2

    .prologue
    .line 536
    invoke-super {p0}, Landroid/graphics/drawable/Drawable;->getChangingConfigurations()I

    move-result v0

    iget-object v1, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget v1, v1, Lcom/ant/liao/GifDrawable$BitmapState;->mChangingConfigurations:I

    or-int/2addr v0, v1

    return v0
.end method

.method public final getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;
    .locals 2

    .prologue
    .line 646
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->getChangingConfigurations()I

    move-result v1

    iput v1, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mChangingConfigurations:I

    .line 647
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    return-object v0
.end method

.method public getGravity()I
    .locals 1

    .prologue
    .line 424
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mGravity:I

    return v0
.end method

.method public getIntrinsicHeight()I
    .locals 1

    .prologue
    .line 631
    iget v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapHeight:I

    return v0
.end method

.method public getIntrinsicWidth()I
    .locals 1

    .prologue
    .line 626
    iget v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapWidth:I

    return v0
.end method

.method public getOpacity()I
    .locals 4

    .prologue
    const/4 v1, -0x3

    .line 636
    iget-object v2, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget v2, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mGravity:I

    const/16 v3, 0x77

    if-eq v2, v3, :cond_1

    .line 640
    :cond_0
    :goto_0
    return v1

    .line 639
    :cond_1
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmap:Landroid/graphics/Bitmap;

    .line 640
    .local v0, "bm":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->hasAlpha()Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v2, v2, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v2}, Landroid/graphics/Paint;->getAlpha()I

    move-result v2

    const/16 v3, 0xff

    if-lt v2, v3, :cond_0

    .line 641
    const/4 v1, -0x1

    goto :goto_0
.end method

.method public final getPaint()Landroid/graphics/Paint;
    .locals 1

    .prologue
    .line 344
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    return-object v0
.end method

.method public getTileModeX()Landroid/graphics/Shader$TileMode;
    .locals 1

    .prologue
    .line 469
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeX:Landroid/graphics/Shader$TileMode;

    return-object v0
.end method

.method public getTileModeY()Landroid/graphics/Shader$TileMode;
    .locals 1

    .prologue
    .line 479
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeY:Landroid/graphics/Shader$TileMode;

    return-object v0
.end method

.method public inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "r"    # Landroid/content/res/Resources;
    .param p2, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 621
    invoke-super {p0, p1, p2, p3}, Landroid/graphics/drawable/Drawable;->inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)V

    .line 622
    return-void
.end method

.method public loopEnd()V
    .locals 2

    .prologue
    .line 309
    iget v0, p0, Lcom/ant/liao/GifDrawable;->currentLoop:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/ant/liao/GifDrawable;->currentLoop:I

    .line 310
    iget v0, p0, Lcom/ant/liao/GifDrawable;->loopNum:I

    if-lez v0, :cond_0

    .line 311
    iget v0, p0, Lcom/ant/liao/GifDrawable;->currentLoop:I

    iget v1, p0, Lcom/ant/liao/GifDrawable;->loopNum:I

    if-lt v0, v1, :cond_0

    .line 312
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->stopDrawThread()V

    .line 313
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->stopDecodeThread()V

    .line 316
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->listener:Lcom/ant/liao/GifListener;

    if-eqz v0, :cond_3

    .line 317
    iget v0, p0, Lcom/ant/liao/GifDrawable;->iListenerType:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1

    iget v0, p0, Lcom/ant/liao/GifDrawable;->iListenerType:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    .line 318
    :cond_1
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->listener:Lcom/ant/liao/GifListener;

    iget v1, p0, Lcom/ant/liao/GifDrawable;->currentLoop:I

    invoke-interface {v0, v1}, Lcom/ant/liao/GifListener;->gifEnd(I)V

    .line 319
    :cond_2
    const/4 v0, 0x0

    iput v0, p0, Lcom/ant/liao/GifDrawable;->currentFrame:I

    .line 321
    :cond_3
    return-void
.end method

.method public mutate()Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    .line 611
    iget-boolean v0, p0, Lcom/ant/liao/GifDrawable;->mMutated:Z

    if-nez v0, :cond_0

    invoke-super {p0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-ne v0, p0, :cond_0

    .line 612
    new-instance v0, Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v1, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    invoke-direct {v0, v1}, Lcom/ant/liao/GifDrawable$BitmapState;-><init>(Lcom/ant/liao/GifDrawable$BitmapState;)V

    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    .line 613
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifDrawable;->mMutated:Z

    .line 615
    :cond_0
    return-object p0
.end method

.method protected onBoundsChange(Landroid/graphics/Rect;)V
    .locals 1
    .param p1, "bounds"    # Landroid/graphics/Rect;

    .prologue
    .line 541
    invoke-super {p0, p1}, Landroid/graphics/drawable/Drawable;->onBoundsChange(Landroid/graphics/Rect;)V

    .line 542
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifDrawable;->mApplyGravity:Z

    .line 543
    return-void
.end method

.method public parseReturn(I)V
    .locals 3
    .param p1, "iResult"    # I

    .prologue
    const/4 v2, 0x1

    .line 257
    packed-switch p1, :pswitch_data_0

    .line 293
    :cond_0
    :goto_0
    return-void

    .line 259
    :pswitch_0
    const-string v0, "parseReturn"

    const-string v1, "FIRST"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 260
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->animationType:Lcom/ant/liao/GifImageType;

    sget-object v1, Lcom/ant/liao/GifImageType;->COVER:Lcom/ant/liao/GifImageType;

    if-eq v0, v1, :cond_1

    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->animationType:Lcom/ant/liao/GifImageType;

    sget-object v1, Lcom/ant/liao/GifImageType;->SYNC_DECODER:Lcom/ant/liao/GifImageType;

    if-ne v0, v1, :cond_0

    .line 261
    :cond_1
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->getFrameImage()Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    .line 262
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->invalidateImage()V

    goto :goto_0

    .line 267
    :pswitch_1
    const-string v0, "parseReturn"

    const-string v1, "FINISH"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 268
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->getFrameCount()I

    move-result v0

    if-ne v0, v2, :cond_2

    .line 270
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->getFrameImage()Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/ant/liao/GifDrawable;->currentImage:Landroid/graphics/Bitmap;

    .line 271
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->invalidateImage()V

    .line 272
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->stopDrawThread()V

    .line 273
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->stopDecodeThread()V

    .line 274
    iput-boolean v2, p0, Lcom/ant/liao/GifDrawable;->singleFrame:Z

    goto :goto_0

    .line 276
    :cond_2
    iget-boolean v0, p0, Lcom/ant/liao/GifDrawable;->animationRun:Z

    if-nez v0, :cond_0

    .line 277
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->reAnimation()V

    .line 278
    iput-boolean v2, p0, Lcom/ant/liao/GifDrawable;->animationRun:Z

    goto :goto_0

    .line 283
    :pswitch_2
    const-string v0, "parseReturn"

    const-string v1, "CACHE_FINISH"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 284
    iget-boolean v0, p0, Lcom/ant/liao/GifDrawable;->animationRun:Z

    if-nez v0, :cond_0

    .line 285
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->reAnimation()V

    .line 286
    iput-boolean v2, p0, Lcom/ant/liao/GifDrawable;->animationRun:Z

    goto :goto_0

    .line 290
    :pswitch_3
    const-string v0, "parseReturn"

    const-string v1, "ERROR"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 257
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
    .line 174
    iget-boolean v0, p0, Lcom/ant/liao/GifDrawable;->singleFrame:Z

    if-eqz v0, :cond_0

    .line 177
    :goto_0
    return-void

    .line 176
    :cond_0
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->pauseAnimation()V

    goto :goto_0
.end method

.method public reDraw()I
    .locals 1

    .prologue
    .line 226
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->getCurrentFrame()I

    move-result v0

    .line 227
    .local v0, "delay":I
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->drawImage()V

    .line 228
    return v0
.end method

.method public restartGifAnimation()V
    .locals 1

    .prologue
    .line 162
    iget-boolean v0, p0, Lcom/ant/liao/GifDrawable;->singleFrame:Z

    if-eqz v0, :cond_1

    .line 167
    :cond_0
    :goto_0
    return-void

    .line 164
    :cond_1
    iget-boolean v0, p0, Lcom/ant/liao/GifDrawable;->animationRun:Z

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->animation:Lcom/ant/liao/GifAnimation;

    invoke-virtual {v0}, Lcom/ant/liao/GifAnimation;->restartAnimation()V

    goto :goto_0
.end method

.method public setAlpha(I)V
    .locals 2
    .param p1, "alpha"    # I

    .prologue
    .line 590
    iget-object v1, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v1, v1, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v1}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    .line 591
    .local v0, "oldAlpha":I
    if-eq p1, v0, :cond_0

    .line 592
    iget-object v1, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v1, v1, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v1, p1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 593
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 595
    :cond_0
    return-void
.end method

.method public setAntiAlias(Z)V
    .locals 1
    .param p1, "aa"    # Z

    .prologue
    .line 446
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 447
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 448
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 1
    .param p1, "cf"    # Landroid/graphics/ColorFilter;

    .prologue
    .line 599
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 600
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 601
    return-void
.end method

.method public setDither(Z)V
    .locals 1
    .param p1, "dither"    # Z

    .prologue
    .line 458
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setDither(Z)V

    .line 459
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 460
    return-void
.end method

.method public setFilterBitmap(Z)V
    .locals 1
    .param p1, "filter"    # Z

    .prologue
    .line 452
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 453
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 454
    return-void
.end method

.method public setGifImage(Landroid/content/res/Resources;I)V
    .locals 1
    .param p1, "rs"    # Landroid/content/res/Resources;
    .param p2, "resId"    # I

    .prologue
    .line 94
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->init()V

    .line 95
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0, p1, p2}, Lcom/ant/liao/GifDecoder;->setGifImage(Landroid/content/res/Resources;I)V

    .line 96
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->start()V

    .line 97
    return-void
.end method

.method public setGifImage(Ljava/lang/String;)V
    .locals 1
    .param p1, "strFileName"    # Ljava/lang/String;

    .prologue
    .line 104
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->init()V

    .line 105
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0, p1}, Lcom/ant/liao/GifDecoder;->setGifImage(Ljava/lang/String;)V

    .line 106
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->start()V

    .line 107
    return-void
.end method

.method public setGifImage([B)V
    .locals 1
    .param p1, "gif"    # [B

    .prologue
    .line 83
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->init()V

    .line 84
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0, p1}, Lcom/ant/liao/GifDecoder;->setGifImage([B)V

    .line 85
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->start()V

    .line 86
    return-void
.end method

.method public setGravity(I)V
    .locals 1
    .param p1, "gravity"    # I

    .prologue
    .line 432
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mGravity:I

    if-eq v0, p1, :cond_0

    .line 433
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iput p1, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mGravity:I

    .line 434
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifDrawable;->mApplyGravity:Z

    .line 435
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 437
    :cond_0
    return-void
.end method

.method public setListener(Lcom/ant/liao/GifListener;I)V
    .locals 1
    .param p1, "listener"    # Lcom/ant/liao/GifListener;
    .param p2, "iType"    # I

    .prologue
    .line 128
    iput-object p1, p0, Lcom/ant/liao/GifDrawable;->listener:Lcom/ant/liao/GifListener;

    .line 129
    const/4 v0, 0x1

    if-lt p2, v0, :cond_0

    const/4 v0, 0x3

    if-gt p2, v0, :cond_0

    .line 130
    iput p2, p0, Lcom/ant/liao/GifDrawable;->iListenerType:I

    .line 132
    :cond_0
    return-void
.end method

.method public setLoopAnimation()V
    .locals 1

    .prologue
    .line 151
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifDrawable;->isLoop:Z

    .line 152
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    if-eqz v0, :cond_0

    .line 153
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->gifDecoder:Lcom/ant/liao/GifDecoder;

    invoke-virtual {v0}, Lcom/ant/liao/GifDecoder;->setLoopAnimation()V

    .line 155
    :cond_0
    return-void
.end method

.method public setLoopNumber(I)V
    .locals 1
    .param p1, "num"    # I

    .prologue
    .line 140
    const/4 v0, 0x1

    if-le p1, v0, :cond_0

    .line 141
    iput p1, p0, Lcom/ant/liao/GifDrawable;->loopNum:I

    .line 142
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->setLoopAnimation()V

    .line 144
    :cond_0
    return-void
.end method

.method public setTargetDensity(I)V
    .locals 1
    .param p1, "density"    # I

    .prologue
    .line 410
    iget v0, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    if-eq v0, p1, :cond_2

    .line 411
    if-nez p1, :cond_0

    const/16 p1, 0xa0

    .end local p1    # "density":I
    :cond_0
    iput p1, p0, Lcom/ant/liao/GifDrawable;->mTargetDensity:I

    .line 412
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_1

    .line 413
    invoke-direct {p0}, Lcom/ant/liao/GifDrawable;->computeBitmapSize()V

    .line 415
    :cond_1
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 417
    :cond_2
    return-void
.end method

.method public setTargetDensity(Landroid/graphics/Canvas;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 386
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getDensity()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/ant/liao/GifDrawable;->setTargetDensity(I)V

    .line 387
    return-void
.end method

.method public setTargetDensity(Landroid/util/DisplayMetrics;)V
    .locals 1
    .param p1, "metrics"    # Landroid/util/DisplayMetrics;

    .prologue
    .line 398
    iget v0, p1, Landroid/util/DisplayMetrics;->densityDpi:I

    invoke-virtual {p0, v0}, Lcom/ant/liao/GifDrawable;->setTargetDensity(I)V

    .line 399
    return-void
.end method

.method public setTileModeX(Landroid/graphics/Shader$TileMode;)V
    .locals 1
    .param p1, "mode"    # Landroid/graphics/Shader$TileMode;

    .prologue
    .line 494
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeY:Landroid/graphics/Shader$TileMode;

    invoke-virtual {p0, p1, v0}, Lcom/ant/liao/GifDrawable;->setTileModeXY(Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V

    .line 495
    return-void
.end method

.method public setTileModeXY(Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V
    .locals 2
    .param p1, "xmode"    # Landroid/graphics/Shader$TileMode;
    .param p2, "ymode"    # Landroid/graphics/Shader$TileMode;

    .prologue
    .line 525
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    .line 526
    .local v0, "state":Lcom/ant/liao/GifDrawable$BitmapState;
    iget-object v1, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeX:Landroid/graphics/Shader$TileMode;

    if-ne v1, p1, :cond_0

    iget-object v1, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeY:Landroid/graphics/Shader$TileMode;

    if-eq v1, p2, :cond_1

    .line 527
    :cond_0
    iput-object p1, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeX:Landroid/graphics/Shader$TileMode;

    .line 528
    iput-object p2, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeY:Landroid/graphics/Shader$TileMode;

    .line 529
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mRebuildShader:Z

    .line 530
    invoke-virtual {p0}, Lcom/ant/liao/GifDrawable;->invalidateSelf()V

    .line 532
    :cond_1
    return-void
.end method

.method public final setTileModeY(Landroid/graphics/Shader$TileMode;)V
    .locals 1
    .param p1, "mode"    # Landroid/graphics/Shader$TileMode;

    .prologue
    .line 509
    iget-object v0, p0, Lcom/ant/liao/GifDrawable;->mBitmapState:Lcom/ant/liao/GifDrawable$BitmapState;

    iget-object v0, v0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeX:Landroid/graphics/Shader$TileMode;

    invoke-virtual {p0, v0, p1}, Lcom/ant/liao/GifDrawable;->setTileModeXY(Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V

    .line 510
    return-void
.end method
