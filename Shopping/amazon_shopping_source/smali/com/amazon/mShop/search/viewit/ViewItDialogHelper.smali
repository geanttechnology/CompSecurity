.class public Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;
.super Ljava/lang/Object;
.source "ViewItDialogHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$6;,
        Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    }
.end annotation


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mErrorDialog:Landroid/widget/LinearLayout;

.field private mErrorDialogBottomMargin:I

.field private mErrorDialogMessage:Landroid/widget/TextView;

.field private mErrorDialogTitle:Landroid/widget/TextView;

.field private mHandler:Landroid/os/Handler;

.field private mHasNoObjectFoundErrorShowed:Z

.field private mNoObjectFoundErrorHappenedTimes:I

.field private mPauseDialogMessage:Ljava/lang/String;

.field private mPauseDialogTitle:Ljava/lang/String;

.field private mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field private mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

.field private mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field private mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)V
    .locals 2
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .param p2, "parentView"    # Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogBottomMargin:I

    .line 76
    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mNoObjectFoundErrorHappenedTimes:I

    .line 78
    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHasNoObjectFoundErrorShowed:Z

    .line 79
    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogTitle:Ljava/lang/String;

    .line 80
    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogMessage:Ljava/lang/String;

    .line 128
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    .line 120
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getViewItMetricHelper()Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    .line 122
    invoke-virtual {p2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .line 123
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->view_it_error_dialog_box:I

    invoke-virtual {p2, v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialog:Landroid/widget/LinearLayout;

    .line 124
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->view_it_error_dialog_title:I

    invoke-virtual {p2, v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogTitle:Landroid/widget/TextView;

    .line 125
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->view_it_error_dialog_message:I

    invoke-virtual {p2, v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogMessage:Landroid/widget/TextView;

    .line 126
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showPauseDialog()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialog:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dimissErrorWindow()V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dismissStillNoObjectFoundDialog()V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dismissPublicDataMatrixInfoDialog()V

    return-void
.end method

.method private clearPendingMessages()V
    .locals 2

    .prologue
    .line 385
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 386
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 387
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    const v1, 0x7fffffff

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 388
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 389
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 390
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 391
    return-void
.end method

.method private dimissErrorWindow()V
    .locals 2

    .prologue
    .line 370
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialog:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 371
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->clearPendingMessages()V

    .line 372
    return-void
.end method

.method private dismissPublicDataMatrixInfoDialog()V
    .locals 1

    .prologue
    .line 363
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 364
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 365
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 367
    :cond_0
    return-void
.end method

.method private dismissStillNoObjectFoundDialog()V
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 316
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 317
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 319
    :cond_0
    return-void
.end method

.method private showErrorDialog(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 227
    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogBottomMargin:I

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBottomOffset()I

    move-result v2

    neg-int v2, v2

    div-int/lit8 v2, v2, 0x2

    if-eq v1, v2, :cond_0

    .line 228
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBottomOffset()I

    move-result v1

    neg-int v1, v1

    div-int/lit8 v1, v1, 0x2

    iput v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogBottomMargin:I

    .line 229
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialog:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout$LayoutParams;

    .line 230
    .local v0, "params":Landroid/widget/FrameLayout$LayoutParams;
    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogBottomMargin:I

    iput v1, v0, Landroid/widget/FrameLayout$LayoutParams;->bottomMargin:I

    .line 231
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialog:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 234
    .end local v0    # "params":Landroid/widget/FrameLayout$LayoutParams;
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialog:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 235
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 236
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogTitle:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 237
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogTitle:Landroid/widget/TextView;

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 242
    :goto_0
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 243
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogMessage:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 244
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogMessage:Landroid/widget/TextView;

    invoke-virtual {v1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 248
    :goto_1
    return-void

    .line 239
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogTitle:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 246
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogMessage:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method private showPauseDialog()V
    .locals 4

    .prologue
    const/4 v3, 0x3

    .line 252
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    const-string/jumbo v1, "messages-per-session-idle"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 254
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dismissStillNoObjectFoundDialog()V

    .line 255
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dismissPublicDataMatrixInfoDialog()V

    .line 257
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogTitle:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_pause_dialog_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogTitle:Ljava/lang/String;

    .line 260
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogMessage:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 261
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_pause_dialog_message:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogMessage:Ljava/lang/String;

    .line 264
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogTitle:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogMessage:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showErrorDialog(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeMessages(I)V

    .line 266
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v3}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    const-wide/16 v2, 0x7530

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 269
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowTimeToSuccessObserver()V

    .line 270
    return-void
.end method

.method private showPublicDataMatrixInfoDialog()V
    .locals 8

    .prologue
    .line 326
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->view_it_public_data_matrix_info_dialog_message:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 330
    .local v3, "msg":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v5

    const-wide/32 v6, 0x15f90

    invoke-virtual {v4, v5, v6, v7}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 333
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {v0, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 334
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 335
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v4}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 336
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v4}, Lcom/amazon/mShop/AmazonAlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$layout;->view_it_info_no_title_dialog:I

    invoke-virtual {v4, v5}, Landroid/view/Window;->setContentView(I)V

    .line 337
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/AmazonAlertDialog;->setCancelable(Z)V

    .line 338
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/AmazonAlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 339
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    new-instance v5, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$4;

    invoke-direct {v5, p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$4;-><init>(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/AmazonAlertDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 347
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    sget v5, Lcom/amazon/mShop/android/lib/R$id;->view_it_info_dialog_ok:I

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/AmazonAlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 348
    .local v2, "errorOKButton":Landroid/widget/Button;
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    sget v5, Lcom/amazon/mShop/android/lib/R$id;->view_it_info_dialog_message:I

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/AmazonAlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 350
    .local v1, "errorMessage":Landroid/widget/TextView;
    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 351
    new-instance v4, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$5;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$5;-><init>(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V

    invoke-virtual {v2, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 360
    return-void
.end method

.method private showStillNoObjectFoundDialog()V
    .locals 10

    .prologue
    .line 277
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v6}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_still_no_object_found_title:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 278
    .local v5, "title":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v6}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_still_no_object_found_message:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 281
    .local v1, "errMsg":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    const/4 v8, 0x4

    invoke-virtual {v7, v8}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v7

    const-wide/32 v8, 0x15f90

    invoke-virtual {v6, v7, v8, v9}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 284
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {v0, v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 285
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 286
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 287
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonAlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->view_it_error_dialog_still_not_found:I

    invoke-virtual {v6, v7}, Landroid/view/Window;->setContentView(I)V

    .line 288
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    const/4 v7, 0x1

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/AmazonAlertDialog;->setCancelable(Z)V

    .line 289
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/AmazonAlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 290
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    new-instance v7, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$2;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/AmazonAlertDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 298
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    sget v7, Lcom/amazon/mShop/android/lib/R$id;->view_it_error_dialog_ok:I

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/AmazonAlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 299
    .local v3, "errorOKButton":Landroid/widget/Button;
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    sget v7, Lcom/amazon/mShop/android/lib/R$id;->view_it_error_dialog_title:I

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/AmazonAlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 300
    .local v4, "errorTitle":Landroid/widget/TextView;
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    sget v7, Lcom/amazon/mShop/android/lib/R$id;->view_it_error_dialog_message:I

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/AmazonAlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 301
    .local v2, "errorMessage":Landroid/widget/TextView;
    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 302
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 303
    new-instance v6, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$3;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V

    invoke-virtual {v3, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 312
    return-void
.end method


# virtual methods
.method public canclePendingStopScanningMessage()V
    .locals 2

    .prologue
    .line 399
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 400
    return-void
.end method

.method public clearErrorWindow()V
    .locals 1

    .prologue
    .line 375
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dimissErrorWindow()V

    .line 376
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dismissStillNoObjectFoundDialog()V

    .line 377
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dismissPublicDataMatrixInfoDialog()V

    .line 378
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mNoObjectFoundErrorHappenedTimes:I

    .line 379
    return-void
.end method

.method public isPauseDialogShowing()Z
    .locals 2

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialog:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogMessage:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPauseDialogMessage:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialogMessage:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 100
    const/4 v0, 0x1

    .line 102
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isStillNoObjectFoundDialogShowing()Z
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mStillNoObjectFoundDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isStillPublicDataMatrixInfoDialogShowing()Z
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mPublicDataMatrixInfoDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public sendStopScanningMessageDelayed()V
    .locals 4

    .prologue
    const/4 v2, 0x5

    .line 394
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeMessages(I)V

    .line 395
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    const-wide/32 v2, 0x15f90

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 396
    return-void
.end method

.method public showDialog(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V
    .locals 6
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "errMsg"    # Ljava/lang/String;
    .param p3, "type"    # Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .prologue
    const/4 v4, 0x1

    .line 168
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isMoving()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->isStillNoObjectFoundDialogShowing()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->isPauseDialogShowing()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->isStillPublicDataMatrixInfoDialogShowing()Z

    move-result v2

    if-nez v2, :cond_0

    .line 169
    const v1, 0x7fffffff

    .line 170
    .local v1, "what":I
    const/16 v0, 0xbb8

    .line 172
    .local v0, "dismissDelayed":I
    sget-object v2, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$6;->$SwitchMap$com$amazon$mShop$search$viewit$ViewItDialogHelper$DialogType:[I

    invoke-virtual {p3}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 213
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    const-string/jumbo v3, "messages-per-session-error"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 218
    :goto_0
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showErrorDialog(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 221
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v1}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    int-to-long v4, v0

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 223
    .end local v0    # "dismissDelayed":I
    .end local v1    # "what":I
    :cond_0
    :goto_1
    return-void

    .line 174
    .restart local v0    # "dismissDelayed":I
    .restart local v1    # "what":I
    :pswitch_0
    const/4 v1, 0x1

    .line 175
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    const-string/jumbo v3, "messages-per-session-error"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    goto :goto_0

    .line 178
    :pswitch_1
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mNoObjectFoundErrorHappenedTimes:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mNoObjectFoundErrorHappenedTimes:I

    .line 184
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mNoObjectFoundErrorHappenedTimes:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_1

    .line 185
    const/4 v2, 0x0

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mNoObjectFoundErrorHappenedTimes:I

    .line 186
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showStillNoObjectFoundDialog()V

    .line 188
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    const-string/jumbo v3, "messages-per-session-stuck"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    goto :goto_1

    .line 191
    :cond_1
    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHasNoObjectFoundErrorShowed:Z

    if-nez v2, :cond_0

    .line 192
    iput-boolean v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mHasNoObjectFoundErrorShowed:Z

    .line 193
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_no_object_found_title:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p1

    .line 194
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_no_object_found_message:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p2

    .line 195
    const/4 v1, 0x2

    .line 196
    const/16 v0, 0xfa0

    .line 198
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    const-string/jumbo v3, "messages-per-session-stuck"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    goto :goto_0

    .line 204
    :pswitch_2
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showPublicDataMatrixInfoDialog()V

    goto :goto_1

    .line 207
    :pswitch_3
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    const-string/jumbo v3, "messages-per-session-nomatches"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    goto :goto_0

    .line 172
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
