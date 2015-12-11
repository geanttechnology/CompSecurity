.class public Lcom/aio/downloader/activity/FunGifActivity;
.super Landroid/app/Activity;
.source "FunGifActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/view/GestureDetector$OnGestureListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;
    }
.end annotation


# static fields
.field public static final GIF_LOAD_FINISH:I = 0x123


# instance fields
.field private animateFirstListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

.field private apath:Ljava/lang/String;

.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private appbanner:Landroid/widget/LinearLayout;

.field private bitmap:Landroid/graphics/Bitmap;

.field private detailcount:I

.field private detailserial:Ljava/lang/String;

.field private detailtitle:Ljava/lang/String;

.field private fullPath:Ljava/lang/String;

.field private gifView:Lcom/ant/liao/GifView;

.field private gif_name:Ljava/lang/String;

.field private handler:Landroid/os/Handler;

.field private imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

.field private iv_detail_back:Lcom/aio/downloader/views/LImageButton;

.field private iv_gif:Landroid/widget/ImageView;

.field private iv_gif_likeshow:Landroid/widget/ImageView;

.field private lf_gif_download:Lcom/aio/downloader/views/LFrameLayout;

.field private lf_gif_like:Lcom/aio/downloader/views/LFrameLayout;

.field private lf_gif_share:Lcom/aio/downloader/views/LFrameLayout;

.field private ll_gif_detail:Landroid/widget/LinearLayout;

.field private options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

.field para:Landroid/view/ViewGroup$LayoutParams;

.field private progress_wheel_gif:Lcom/aio/downloader/utils/ProgressWheel;

.field private rl_gif_gongneng:Landroid/widget/RelativeLayout;

.field private tv_detail_title:Landroid/widget/TextView;

.field private viewTreeObserver:Landroid/view/ViewTreeObserver;

.field private window_height:I

.field private window_width:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 60
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 67
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

    .line 68
    new-instance v0, Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;-><init>(Lcom/aio/downloader/activity/FunGifActivity;Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->animateFirstListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .line 76
    iput-object v1, p0, Lcom/aio/downloader/activity/FunGifActivity;->bitmap:Landroid/graphics/Bitmap;

    .line 77
    new-instance v0, Lcom/aio/downloader/activity/FunGifActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/FunGifActivity$1;-><init>(Lcom/aio/downloader/activity/FunGifActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->handler:Landroid/os/Handler;

    .line 60
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->progress_wheel_gif:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/FunGifActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->iv_gif:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/FunGifActivity;Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/aio/downloader/activity/FunGifActivity;->bitmap:Landroid/graphics/Bitmap;

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/FunGifActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/ant/liao/GifView;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/FunGifActivity;Landroid/view/ViewTreeObserver;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/aio/downloader/activity/FunGifActivity;->viewTreeObserver:Landroid/view/ViewTreeObserver;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->gif_name:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/FunGifActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->iv_gif_likeshow:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->detailserial:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->detailtitle:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->fullPath:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/FunGifActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 494
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/FunGifActivity;->getImage(Ljava/lang/String;)V

    return-void
.end method

.method private getImage(Ljava/lang/String;)V
    .locals 4
    .param p1, "picPath"    # Ljava/lang/String;

    .prologue
    .line 496
    move-object v1, p1

    .line 497
    .local v1, "uri":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 498
    const-string v3, "AIO_GIF"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity;->gif_name:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".gif"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 497
    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 499
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 500
    const-string v2, "ALREADY EXISTS"

    const/4 v3, 0x0

    invoke-static {p0, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 577
    :goto_0
    return-void

    .line 504
    :cond_0
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/activity/FunGifActivity$7;

    invoke-direct {v3, p0, v1}, Lcom/aio/downloader/activity/FunGifActivity$7;-><init>(Lcom/aio/downloader/activity/FunGifActivity;Ljava/lang/String;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 575
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto :goto_0
.end method

.method private initDatas()V
    .locals 10

    .prologue
    const v9, 0x7f02006f

    const/4 v8, 0x0

    .line 300
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunGifActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    const-string v7, "fullpath"

    invoke-virtual {v6, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->fullPath:Ljava/lang/String;

    .line 301
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunGifActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    const-string v7, "apath"

    invoke-virtual {v6, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->apath:Ljava/lang/String;

    .line 302
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunGifActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    const-string v7, "detailtitle"

    invoke-virtual {v6, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->detailtitle:Ljava/lang/String;

    .line 303
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunGifActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    const-string v7, "detailcount"

    invoke-virtual {v6, v7, v8}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v6

    iput v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->detailcount:I

    .line 304
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunGifActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    const-string v7, "detailserial"

    invoke-virtual {v6, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->detailserial:Ljava/lang/String;

    .line 306
    iget-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->fullPath:Ljava/lang/String;

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 307
    .local v4, "str":[Ljava/lang/String;
    array-length v6, v4

    add-int/lit8 v6, v6, -0x1

    aget-object v3, v4, v6

    .line 308
    .local v3, "s1":Ljava/lang/String;
    const-string v6, ".gif"

    invoke-virtual {v3, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 309
    .local v5, "str2":[Ljava/lang/String;
    aget-object v6, v5, v8

    iput-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->gif_name:Ljava/lang/String;

    .line 311
    iget-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->lf_gif_download:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v7, Lcom/aio/downloader/activity/FunGifActivity$6;

    invoke-direct {v7, p0}, Lcom/aio/downloader/activity/FunGifActivity$6;-><init>(Lcom/aio/downloader/activity/FunGifActivity;)V

    invoke-virtual {v6, v7}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 322
    iget-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    iget-object v7, p0, Lcom/aio/downloader/activity/FunGifActivity;->apath:Ljava/lang/String;

    iget-object v8, p0, Lcom/aio/downloader/activity/FunGifActivity;->iv_gif:Landroid/widget/ImageView;

    invoke-virtual {v6, v7, v8}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 324
    const-string v6, "www"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "fullPath="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, p0, Lcom/aio/downloader/activity/FunGifActivity;->fullPath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 328
    iget-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;

    invoke-virtual {v6}, Lcom/ant/liao/GifView;->setLoopAnimation()V

    .line 329
    iget-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;

    sget-object v7, Lcom/ant/liao/GifImageType;->COVER:Lcom/ant/liao/GifImageType;

    invoke-virtual {v6, v7}, Lcom/ant/liao/GifView;->setGifImageType(Lcom/ant/liao/GifImageType;)V

    .line 330
    new-instance v6, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v6}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    invoke-virtual {v6}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc()Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v6

    .line 331
    invoke-virtual {v6, v9}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showStubImage(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v6

    .line 332
    invoke-virtual {v6, v9}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageOnFail(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v6

    invoke-virtual {v6}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v6

    .line 330
    iput-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 333
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 334
    const-string v7, "AIO_GIF"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/activity/FunGifActivity;->gif_name:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ".gif"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 333
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 335
    .local v1, "gifpath":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 336
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 337
    new-instance v2, Landroid/os/Message;

    invoke-direct {v2}, Landroid/os/Message;-><init>()V

    .line 338
    .local v2, "msg":Landroid/os/Message;
    const/4 v6, 0x4

    iput v6, v2, Landroid/os/Message;->what:I

    .line 339
    iget-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v6, v2}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 390
    .end local v2    # "msg":Landroid/os/Message;
    :goto_0
    return-void

    .line 342
    :cond_0
    iget-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity;->fullPath:Ljava/lang/String;

    invoke-direct {p0, v6}, Lcom/aio/downloader/activity/FunGifActivity;->getImage(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private setListener()V
    .locals 2

    .prologue
    .line 271
    iget-object v1, p0, Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;

    invoke-virtual {v1, p0}, Lcom/ant/liao/GifView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 273
    new-instance v0, Landroid/view/GestureDetector;

    invoke-direct {v0, p0, p0}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    .line 274
    .local v0, "detector":Landroid/view/GestureDetector;
    new-instance v1, Lcom/aio/downloader/activity/FunGifActivity$5;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/FunGifActivity$5;-><init>(Lcom/aio/downloader/activity/FunGifActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/GestureDetector;->setOnDoubleTapListener(Landroid/view/GestureDetector$OnDoubleTapListener;)V

    .line 296
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 455
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 474
    :goto_0
    return-void

    .line 459
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->ll_gif_detail:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 460
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->ll_gif_detail:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 461
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->rl_gif_gongneng:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 462
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->appbanner:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 463
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/views/LImageButton;->setVisibility(I)V

    goto :goto_0

    .line 465
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->ll_gif_detail:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 466
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->rl_gif_gongneng:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 467
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->appbanner:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 468
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setVisibility(I)V

    goto :goto_0

    .line 455
    nop

    :pswitch_data_0
    .packed-switch 0x7f07020d
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 174
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 175
    const v2, 0x7f030050

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->setContentView(I)V

    .line 176
    const v2, 0x7f07020f

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->ll_gif_detail:Landroid/widget/LinearLayout;

    .line 177
    const v2, 0x7f07020e

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->rl_gif_gongneng:Landroid/widget/RelativeLayout;

    .line 179
    const v2, 0x7f07020d

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/ant/liao/GifView;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;

    .line 180
    const v2, 0x7f070211

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->progress_wheel_gif:Lcom/aio/downloader/utils/ProgressWheel;

    .line 181
    const v2, 0x7f070116

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->tv_detail_title:Landroid/widget/TextView;

    .line 182
    const v2, 0x7f070212

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/LFrameLayout;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->lf_gif_like:Lcom/aio/downloader/views/LFrameLayout;

    .line 183
    const v2, 0x7f070214

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/LFrameLayout;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->lf_gif_download:Lcom/aio/downloader/views/LFrameLayout;

    .line 184
    const v2, 0x7f070215

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/LFrameLayout;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->lf_gif_share:Lcom/aio/downloader/views/LFrameLayout;

    .line 186
    const v2, 0x7f070213

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->iv_gif_likeshow:Landroid/widget/ImageView;

    .line 188
    const v2, 0x7f070114

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/LImageButton;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;

    .line 189
    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;

    new-instance v3, Lcom/aio/downloader/activity/FunGifActivity$2;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/FunGifActivity$2;-><init>(Lcom/aio/downloader/activity/FunGifActivity;)V

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 197
    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->lf_gif_like:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v3, Lcom/aio/downloader/activity/FunGifActivity$3;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/FunGifActivity$3;-><init>(Lcom/aio/downloader/activity/FunGifActivity;)V

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 219
    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->lf_gif_share:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v3, Lcom/aio/downloader/activity/FunGifActivity$4;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/FunGifActivity$4;-><init>(Lcom/aio/downloader/activity/FunGifActivity;)V

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 246
    const v2, 0x7f070070

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->appbanner:Landroid/widget/LinearLayout;

    .line 247
    new-instance v0, Lcom/google/ads/AdView;

    sget-object v2, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 248
    const-string v3, "ca-app-pub-2192624499353475/1272210540"

    .line 247
    invoke-direct {v0, p0, v2, v3}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 249
    .local v0, "adView":Lcom/google/ads/AdView;
    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->appbanner:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 250
    new-instance v2, Lcom/google/ads/AdRequest;

    invoke-direct {v2}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v0, v2}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 251
    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->progress_wheel_gif:Lcom/aio/downloader/utils/ProgressWheel;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 252
    const v2, 0x7f070210

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FunGifActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->iv_gif:Landroid/widget/ImageView;

    .line 254
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunGifActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    .line 255
    .local v1, "manager":Landroid/view/WindowManager;
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Display;->getWidth()I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->window_width:I

    .line 256
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Display;->getHeight()I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->window_height:I

    .line 259
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunGifActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 264
    :goto_0
    invoke-direct {p0}, Lcom/aio/downloader/activity/FunGifActivity;->initDatas()V

    .line 265
    invoke-direct {p0}, Lcom/aio/downloader/activity/FunGifActivity;->setListener()V

    .line 267
    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity;->tv_detail_title:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity;->detailtitle:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 268
    return-void

    .line 260
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 487
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 492
    return-void
.end method

.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "arg0"    # Landroid/view/MotionEvent;

    .prologue
    .line 416
    const/4 v0, 0x0

    return v0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1
    .param p1, "arg0"    # Landroid/view/MotionEvent;
    .param p2, "arg1"    # Landroid/view/MotionEvent;
    .param p3, "arg2"    # F
    .param p4, "arg3"    # F

    .prologue
    .line 423
    const/4 v0, 0x0

    return v0
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x0

    .line 478
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 479
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunGifActivity;->finish()V

    .line 480
    invoke-virtual {p0, v1, v1}, Lcom/aio/downloader/activity/FunGifActivity;->overridePendingTransition(II)V

    .line 482
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/MotionEvent;

    .prologue
    .line 430
    return-void
.end method

.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1
    .param p1, "arg0"    # Landroid/view/MotionEvent;
    .param p2, "arg1"    # Landroid/view/MotionEvent;
    .param p3, "arg2"    # F
    .param p4, "arg3"    # F

    .prologue
    .line 436
    const/4 v0, 0x0

    return v0
.end method

.method public onShowPress(Landroid/view/MotionEvent;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/MotionEvent;

    .prologue
    .line 443
    return-void
.end method

.method public onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "arg0"    # Landroid/view/MotionEvent;

    .prologue
    .line 448
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunGifActivity;->finish()V

    .line 449
    const/4 v0, 0x0

    return v0
.end method
