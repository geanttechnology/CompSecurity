.class public Lcom/creditcardreader/activities/CreditCardScanActivity;
.super Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;
.source "CreditCardScanActivity.java"


# instance fields
.field private mAligned:Z

.field private mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;

.field private mCancelExit:Z

.field private mDialogShown:Z

.field private mForegroundExit:Z

.field private mHandler:Landroid/os/Handler;

.field private mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

.field private mPromising:Z

.field private mScanningThread:Ljava/lang/Thread;

.field private mTimeOfLastAlign:J

.field private mTimeToScan:J

.field private mVibrator:Landroid/os/Vibrator;

.field private m_handler:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;-><init>()V

    .line 102
    new-instance v0, Lcom/creditcardreader/activities/CreditCardScanActivity$1;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity$1;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->m_handler:Landroid/os/Handler;

    return-void
.end method

.method static synthetic access$000(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->checkForFocus()V

    return-void
.end method

.method static synthetic access$100(Lcom/creditcardreader/activities/CreditCardScanActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->m_handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->handleTorchOn()V

    return-void
.end method

.method static synthetic access$1100(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->setRescan()V

    return-void
.end method

.method static synthetic access$1200(Lcom/creditcardreader/activities/CreditCardScanActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$200(Lcom/creditcardreader/activities/CreditCardScanActivity;)Lcom/creditcardreader/camera/CreditCardCameraPreview;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;

    return-object v0
.end method

.method static synthetic access$302(Lcom/creditcardreader/activities/CreditCardScanActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 52
    iput-boolean p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mForegroundExit:Z

    return p1
.end method

.method static synthetic access$402(Lcom/creditcardreader/activities/CreditCardScanActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 52
    iput-boolean p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mCancelExit:Z

    return p1
.end method

.method static synthetic access$500(Lcom/creditcardreader/activities/CreditCardScanActivity;)J
    .locals 2
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    iget-wide v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mTimeToScan:J

    return-wide v0
.end method

.method static synthetic access$600(Lcom/creditcardreader/activities/CreditCardScanActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    iget-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mDialogShown:Z

    return v0
.end method

.method static synthetic access$700(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->showUnreadableDialog()V

    return-void
.end method

.method static synthetic access$800(Lcom/creditcardreader/activities/CreditCardScanActivity;)Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;
    .locals 1
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    return-object v0
.end method

.method static synthetic access$900(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 52
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->handleTorchOff()V

    return-void
.end method

.method private checkForFocus()V
    .locals 0

    .prologue
    .line 115
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->triggerFocus()V

    .line 116
    return-void
.end method

.method private setHelpButton()V
    .locals 2

    .prologue
    .line 427
    sget v1, Lcom/creditcardreader/R$id;->cc_scan_help_button:I

    invoke-virtual {p0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 429
    .local v0, "helpButton":Landroid/widget/ImageButton;
    new-instance v1, Lcom/creditcardreader/activities/CreditCardScanActivity$7;

    invoke-direct {v1, p0}, Lcom/creditcardreader/activities/CreditCardScanActivity$7;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 439
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 440
    return-void
.end method

.method private setRescan()V
    .locals 2

    .prologue
    .line 542
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordRescan()V

    .line 543
    const-wide/16 v0, 0x3a98

    iput-wide v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mTimeToScan:J

    .line 544
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;

    invoke-virtual {v0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->startPreview()V

    .line 545
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mDialogShown:Z

    .line 546
    return-void
.end method

.method private setTorchButton()V
    .locals 2

    .prologue
    .line 447
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->supportsFlash()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 448
    sget v1, Lcom/creditcardreader/R$id;->cc_scan_torch_button:I

    invoke-virtual {p0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 450
    .local v0, "torchButton":Landroid/widget/ImageButton;
    sget v1, Lcom/creditcardreader/R$drawable;->cc_scan_flash:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 451
    new-instance v1, Lcom/creditcardreader/activities/CreditCardScanActivity$8;

    invoke-direct {v1, p0, v0}, Lcom/creditcardreader/activities/CreditCardScanActivity$8;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Landroid/widget/ImageButton;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 466
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 468
    .end local v0    # "torchButton":Landroid/widget/ImageButton;
    :cond_0
    return-void
.end method

.method private showUnreadableDialog()V
    .locals 2

    .prologue
    .line 477
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordTimeout()V

    .line 478
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mDialogShown:Z

    .line 480
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    invoke-direct {v1, p0}, Lcom/creditcardreader/activities/CreditCardScanActivity$9;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 535
    return-void
.end method

.method private wasAlignedRecently()Z
    .locals 6

    .prologue
    .line 553
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mTimeOfLastAlign:J

    sub-long v0, v2, v4

    .line 554
    .local v0, "timeSinceLastAlign":J
    const-wide/16 v2, 0x7d0

    cmp-long v2, v0, v2

    if-gtz v2, :cond_0

    .line 555
    const/4 v2, 0x1

    .line 557
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected didDetectGoodEdges(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/util/Pair",
            "<",
            "Landroid/graphics/Point;",
            "Landroid/graphics/Point;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 335
    .local p1, "edges":Ljava/util/List;, "Ljava/util/List<Landroid/util/Pair<Landroid/graphics/Point;Landroid/graphics/Point;>;>;"
    invoke-direct {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->wasAlignedRecently()Z

    move-result v0

    if-nez v0, :cond_1

    .line 338
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mScanningThread:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    .line 339
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mScanningThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 340
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mScanningThread:Ljava/lang/Thread;

    .line 341
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->didStableCardRecognition()V

    .line 345
    :cond_0
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/creditcardreader/activities/CreditCardScanActivity$4;

    invoke-direct {v1, p0, p1}, Lcom/creditcardreader/activities/CreditCardScanActivity$4;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Ljava/util/List;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 355
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_2

    .line 356
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mTimeOfLastAlign:J

    .line 358
    :cond_2
    return-void
.end method

.method protected didPromisingCardRecognition()V
    .locals 1

    .prologue
    .line 417
    iget-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mPromising:Z

    if-nez v0, :cond_0

    .line 418
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mPromising:Z

    .line 419
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordPromising()V

    .line 421
    :cond_0
    return-void
.end method

.method protected didRecognizeCreditCard(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)V
    .locals 4
    .param p1, "result"    # Lcom/a9/creditcardreaderlibrary/CreditCardResult;

    .prologue
    .line 296
    iget-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mAligned:Z

    if-nez v0, :cond_0

    .line 297
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordAlign()V

    .line 298
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mAligned:Z

    .line 301
    :cond_0
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0, p1}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordSuccess(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)V

    .line 302
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mVibrator:Landroid/os/Vibrator;

    const-wide/16 v1, 0xfa

    invoke-virtual {v0, v1, v2}, Landroid/os/Vibrator;->vibrate(J)V

    .line 305
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/creditcardreader/activities/CreditCardScanActivity$2;

    invoke-direct {v1, p0}, Lcom/creditcardreader/activities/CreditCardScanActivity$2;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 313
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/creditcardreader/activities/CreditCardScanActivity$3;

    invoke-direct {v1, p0, p1}, Lcom/creditcardreader/activities/CreditCardScanActivity$3;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Lcom/a9/creditcardreaderlibrary/CreditCardResult;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 323
    return-void
.end method

.method protected didStableCardRecognition()V
    .locals 2

    .prologue
    .line 385
    iget-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mAligned:Z

    if-nez v0, :cond_0

    .line 386
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordAlign()V

    .line 387
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mAligned:Z

    .line 391
    :cond_0
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mScanningThread:Ljava/lang/Thread;

    if-nez v0, :cond_1

    .line 392
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/creditcardreader/activities/CreditCardScanActivity$6;

    invoke-direct {v1, p0}, Lcom/creditcardreader/activities/CreditCardScanActivity$6;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mScanningThread:Ljava/lang/Thread;

    .line 407
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mScanningThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 409
    :cond_1
    return-void
.end method

.method protected getCameraViewHeight()I
    .locals 4

    .prologue
    .line 578
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 579
    .local v1, "metrics":Landroid/util/DisplayMetrics;
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getScreenOrientation()I

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getScreenOrientation()I

    move-result v2

    const/16 v3, 0x8

    if-ne v2, v3, :cond_1

    .line 581
    :cond_0
    iget v2, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v3, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 586
    .local v0, "height":I
    :goto_0
    return v0

    .line 584
    .end local v0    # "height":I
    :cond_1
    iget v2, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v3, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v0

    .restart local v0    # "height":I
    goto :goto_0
.end method

.method protected getCameraViewWidth()I
    .locals 4

    .prologue
    .line 595
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 596
    .local v0, "metrics":Landroid/util/DisplayMetrics;
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getScreenOrientation()I

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getScreenOrientation()I

    move-result v2

    const/16 v3, 0x8

    if-ne v2, v3, :cond_1

    .line 598
    :cond_0
    iget v2, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v3, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 603
    .local v1, "width":I
    :goto_0
    return v1

    .line 601
    .end local v1    # "width":I
    :cond_1
    iget v2, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v3, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v1

    .restart local v1    # "width":I
    goto :goto_0
.end method

.method protected getCreditCardOrientation()Lcom/a9/vs/mobile/library/impl/jni/Orientation;
    .locals 2

    .prologue
    .line 242
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Display;->getRotation()I

    move-result v0

    .line 243
    .local v0, "orientation":I
    packed-switch v0, :pswitch_data_0

    .line 251
    :pswitch_0
    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/Orientation;->PORTRAIT:Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    :goto_0
    return-object v1

    .line 245
    :pswitch_1
    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/Orientation;->PORTRAIT:Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    goto :goto_0

    .line 247
    :pswitch_2
    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/Orientation;->LANDSCAPE_LEFT:Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    goto :goto_0

    .line 249
    :pswitch_3
    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/Orientation;->LANDSCAPE_RIGHT:Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    goto :goto_0

    .line 243
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method protected getMarketPlace()Ljava/lang/String;
    .locals 1

    .prologue
    .line 262
    const-string/jumbo v0, "1"

    return-object v0
.end method

.method public getScreenOrientation()I
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 221
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v2

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Display;->getRotation()I

    move-result v0

    .line 222
    .local v0, "orientation":I
    packed-switch v0, :pswitch_data_0

    .line 230
    :goto_0
    :pswitch_0
    return v1

    .line 226
    :pswitch_1
    const/4 v1, 0x0

    goto :goto_0

    .line 228
    :pswitch_2
    const/16 v1, 0x8

    goto :goto_0

    .line 222
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected handleCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V
    .locals 4
    .param p1, "reason"    # Lcom/a9/cameralibrary/CameraErrorReason;
    .param p2, "extraInfo"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 279
    iput-boolean v3, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mCancelExit:Z

    .line 280
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordCameraError()V

    .line 281
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string/jumbo v1, "CANNOT_OPEN_CAMERA"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v3, v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->setResult(ILandroid/content/Intent;)V

    .line 283
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->finish()V

    .line 284
    return-void
.end method

.method protected initCardDetectionRegion(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/graphics/Point;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 369
    .local p1, "bounds":Ljava/util/List;, "Ljava/util/List<Landroid/graphics/Point;>;"
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/creditcardreader/activities/CreditCardScanActivity$5;

    invoke-direct {v1, p0, p1}, Lcom/creditcardreader/activities/CreditCardScanActivity$5;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Ljava/util/List;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 375
    return-void
.end method

.method protected initLayout()V
    .locals 1

    .prologue
    .line 270
    sget v0, Lcom/creditcardreader/R$layout;->credit_card_scan:I

    invoke-virtual {p0, v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->setContentView(I)V

    .line 271
    return-void
.end method

.method public newCameraPreview()Lcom/a9/cameralibrary/A9CameraPreview;
    .locals 1

    .prologue
    .line 208
    new-instance v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;

    invoke-direct {v0, p0, p0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;-><init>(Landroid/content/Context;Lcom/a9/cameralibrary/CameraFrameListener;)V

    invoke-virtual {p0, v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->setCameraPreview(Lcom/a9/cameralibrary/A9CameraPreview;)V

    .line 209
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getCameraPreview()Lcom/a9/cameralibrary/A9CameraPreview;

    move-result-object v0

    check-cast v0, Lcom/creditcardreader/camera/CreditCardCameraPreview;

    iput-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;

    .line 210
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getCameraPreview()Lcom/a9/cameralibrary/A9CameraPreview;

    move-result-object v0

    return-object v0
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 199
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mForegroundExit:Z

    .line 200
    invoke-super {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->onBackPressed()V

    .line 201
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 126
    invoke-super {p0, p1}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->onCreate(Landroid/os/Bundle;)V

    .line 127
    sget v0, Lcom/creditcardreader/R$layout;->credit_card_scan:I

    invoke-virtual {p0, v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->setContentView(I)V

    .line 129
    invoke-virtual {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-static {v0}, Lcom/creditcardreader/utils/CreditCardUtils;->setResources(Landroid/content/res/Resources;)V

    .line 131
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mHandler:Landroid/os/Handler;

    .line 132
    const-string/jumbo v0, "vibrator"

    invoke-virtual {p0, v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Vibrator;

    iput-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mVibrator:Landroid/os/Vibrator;

    .line 133
    const-wide/16 v0, 0x1388

    iput-wide v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mTimeToScan:J

    .line 134
    iput-boolean v2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mAligned:Z

    .line 135
    iput-boolean v2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mPromising:Z

    .line 136
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-direct {v0, p0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    iput-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    .line 137
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordSession()V

    .line 139
    invoke-direct {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->setHelpButton()V

    .line 140
    invoke-direct {p0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->setTorchButton()V

    .line 141
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 182
    iget-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mCancelExit:Z

    if-eqz v0, :cond_0

    .line 183
    iget-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mForegroundExit:Z

    if-eqz v0, :cond_1

    .line 184
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordCancel()V

    .line 189
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordMetric()V

    .line 190
    invoke-super {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->onDestroy()V

    .line 191
    return-void

    .line 186
    :cond_1
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordCancelOnBackground()V

    goto :goto_0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mScanningThread:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    .line 168
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mScanningThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 169
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mScanningThread:Ljava/lang/Thread;

    .line 171
    :cond_0
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;

    invoke-virtual {v0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->blacken()V

    .line 172
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;

    invoke-virtual {v0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->resetOverlay()V

    .line 173
    invoke-super {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->onPause()V

    .line 174
    return-void
.end method

.method protected onResume()V
    .locals 4

    .prologue
    const/4 v2, 0x1

    .line 149
    invoke-super {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->onResume()V

    .line 150
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mForegroundExit:Z

    .line 151
    iput-boolean v2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->mCancelExit:Z

    .line 158
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->m_handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity;->m_handler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 159
    return-void
.end method
