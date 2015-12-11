.class public Lco/vine/android/SonyRecordingActivity;
.super Lco/vine/android/AbstractRecordingActivity;
.source "SonyRecordingActivity.java"


# instance fields
.field private mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

.field private mSonyFilterColor:I

.field private mSonyModeName:Ljava/lang/String;

.field private mSonyModeSelectorButton:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lco/vine/android/SonyRecordingActivity;)Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SonyRecordingActivity;

    .prologue
    .line 19
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/SonyRecordingActivity;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SonyRecordingActivity;

    .prologue
    .line 19
    invoke-direct {p0}, Lco/vine/android/SonyRecordingActivity;->showSonyOverlay()V

    return-void
.end method

.method static synthetic access$200(Lco/vine/android/SonyRecordingActivity;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SonyRecordingActivity;

    .prologue
    .line 19
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/SonyRecordingActivity;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SonyRecordingActivity;

    .prologue
    .line 19
    iget v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyFilterColor:I

    return v0
.end method

.method private onHideSonyOverlay()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 207
    const v3, 0x7f0a01be

    invoke-virtual {p0, v3}, Lco/vine/android/SonyRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 208
    .local v2, "recordingOptions":Landroid/view/View;
    const v3, 0x7f0a01bb

    invoke-virtual {p0, v3}, Lco/vine/android/SonyRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 209
    .local v0, "captureX":Landroid/view/View;
    const v3, 0x7f0a00b2

    invoke-virtual {p0, v3}, Lco/vine/android/SonyRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 211
    .local v1, "progressBar":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 212
    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 214
    :cond_0
    if-eqz v0, :cond_1

    .line 215
    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 217
    :cond_1
    if-eqz v1, :cond_2

    .line 218
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 220
    :cond_2
    return-void
.end method

.method private onShowSonyOverlay()V
    .locals 5

    .prologue
    const/4 v4, 0x4

    .line 223
    const v3, 0x7f0a01be

    invoke-virtual {p0, v3}, Lco/vine/android/SonyRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 224
    .local v2, "recordingOptions":Landroid/view/View;
    const v3, 0x7f0a01bb

    invoke-virtual {p0, v3}, Lco/vine/android/SonyRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 225
    .local v0, "captureX":Landroid/view/View;
    const v3, 0x7f0a00b2

    invoke-virtual {p0, v3}, Lco/vine/android/SonyRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 227
    .local v1, "progressBar":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 228
    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 230
    :cond_0
    if-eqz v0, :cond_1

    .line 231
    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 233
    :cond_1
    if-eqz v1, :cond_2

    .line 234
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 236
    :cond_2
    return-void
.end method

.method private showSonyOverlay()V
    .locals 2

    .prologue
    .line 164
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    iget-object v1, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;->open(Ljava/lang/String;)V

    .line 165
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 166
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->clearColorFilter()V

    .line 167
    invoke-direct {p0}, Lco/vine/android/SonyRecordingActivity;->onShowSonyOverlay()V

    .line 168
    return-void
.end method


# virtual methods
.method protected createRecordingFragment()Lco/vine/android/RecordingFragment;
    .locals 1

    .prologue
    .line 203
    new-instance v0, Lco/vine/android/SonyRecordingFragment;

    invoke-direct {v0}, Lco/vine/android/SonyRecordingFragment;-><init>()V

    return-object v0
.end method

.method public isFromSony()Z
    .locals 1

    .prologue
    .line 72
    const/4 v0, 0x1

    return v0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 42
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    invoke-virtual {v0}, Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;->isOpened()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    invoke-virtual {v0}, Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;->close()V

    .line 44
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 45
    invoke-direct {p0}, Lco/vine/android/SonyRecordingActivity;->onHideSonyOverlay()V

    .line 49
    :goto_0
    return-void

    .line 47
    :cond_0
    invoke-super {p0}, Lco/vine/android/AbstractRecordingActivity;->onBackPressed()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 28
    invoke-super {p0, p1}, Lco/vine/android/AbstractRecordingActivity;->onCreate(Landroid/os/Bundle;)V

    .line 29
    invoke-virtual {p0}, Lco/vine/android/SonyRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 30
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f090084

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    iput v1, p0, Lco/vine/android/SonyRecordingActivity;->mSonyFilterColor:I

    .line 31
    const v1, 0x7f0e004e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeName:Ljava/lang/String;

    .line 32
    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 63
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 67
    :cond_0
    invoke-super {p0}, Lco/vine/android/AbstractRecordingActivity;->onDestroy()V

    .line 68
    return-void
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 172
    packed-switch p2, :pswitch_data_0

    .line 195
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/AbstractRecordingActivity;->onDialogDone(Landroid/content/DialogInterface;II)V

    .line 199
    :goto_0
    return-void

    .line 174
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    .line 185
    invoke-virtual {p0}, Lco/vine/android/SonyRecordingActivity;->currentlyHoldsRecordingFragment()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 186
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->saveSession()V

    .line 188
    :cond_0
    invoke-direct {p0}, Lco/vine/android/SonyRecordingActivity;->showSonyOverlay()V

    goto :goto_0

    .line 177
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/SonyRecordingActivity;->currentlyHoldsRecordingFragment()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 178
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->setDiscardChangesOnStop()V

    .line 180
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/SonyRecordingActivity;->discardUpload()V

    .line 181
    invoke-direct {p0}, Lco/vine/android/SonyRecordingActivity;->showSonyOverlay()V

    goto :goto_0

    .line 172
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch

    .line 174
    :pswitch_data_1
    .packed-switch -0x3
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    if-eqz v0, :cond_0

    .line 55
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    invoke-virtual {v0}, Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;->release()V

    .line 56
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    .line 58
    :cond_0
    invoke-super {p0}, Lco/vine/android/AbstractRecordingActivity;->onPause()V

    .line 59
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 36
    invoke-super {p0}, Lco/vine/android/AbstractRecordingActivity;->onResume()V

    .line 37
    invoke-virtual {p0}, Lco/vine/android/SonyRecordingActivity;->setupSonyOverlay()V

    .line 38
    return-void
.end method

.method public setupSonyOverlay()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 76
    const v2, 0x7f0a01cd

    invoke-virtual {p0, v2}, Lco/vine/android/SonyRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 77
    .local v1, "mSonySelectorContainer":Landroid/view/ViewGroup;
    const v2, 0x7f0a01cb

    invoke-virtual {p0, v2}, Lco/vine/android/SonyRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    .line 79
    iget-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    if-eqz v2, :cond_0

    if-nez v1, :cond_1

    .line 158
    :cond_0
    :goto_0
    return-void

    .line 83
    :cond_1
    iget-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 84
    iget-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    new-instance v3, Lco/vine/android/SonyRecordingActivity$1;

    invoke-direct {v3, p0}, Lco/vine/android/SonyRecordingActivity$1;-><init>(Lco/vine/android/SonyRecordingActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 106
    iget-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    new-instance v3, Lco/vine/android/SonyRecordingActivity$2;

    invoke-direct {v3, p0}, Lco/vine/android/SonyRecordingActivity$2;-><init>(Lco/vine/android/SonyRecordingActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 122
    :try_start_0
    new-instance v2, Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    invoke-direct {v2, p0, v1}, Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;-><init>(Landroid/content/Context;Landroid/view/ViewGroup;)V

    iput-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;
    :try_end_0
    .catch Ljava/lang/NoClassDefFoundError; {:try_start_0 .. :try_end_0} :catch_0

    .line 130
    :goto_1
    iget-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    if-eqz v2, :cond_2

    .line 132
    iget-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    new-instance v3, Lco/vine/android/SonyRecordingActivity$3;

    invoke-direct {v3, p0}, Lco/vine/android/SonyRecordingActivity$3;-><init>(Lco/vine/android/SonyRecordingActivity;)V

    invoke-virtual {v2, v3}, Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;->setOnModeSelectListener(Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector$OnModeSelectListener;)V

    .line 142
    iget-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    new-instance v3, Lco/vine/android/SonyRecordingActivity$4;

    invoke-direct {v3, p0}, Lco/vine/android/SonyRecordingActivity$4;-><init>(Lco/vine/android/SonyRecordingActivity;)V

    invoke-virtual {v2, v3}, Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;->setOnModeFinishListener(Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector$OnModeFinishListener;)V

    .line 152
    iget-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 123
    :catch_0
    move-exception v0

    .line 126
    .local v0, "e":Ljava/lang/NoClassDefFoundError;
    new-instance v2, Lco/vine/android/VineLoggingException;

    const-string v3, "Unable to create Sony Capture Mode selector."

    invoke-direct {v2, v3}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 156
    .end local v0    # "e":Ljava/lang/NoClassDefFoundError;
    :cond_2
    iget-object v2, p0, Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method
