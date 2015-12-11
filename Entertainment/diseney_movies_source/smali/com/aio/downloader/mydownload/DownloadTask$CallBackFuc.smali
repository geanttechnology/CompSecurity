.class Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;
.super Lnet/tsz/afinal/http/AjaxCallBack;
.source "DownloadTask.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/mydownload/DownloadTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "CallBackFuc"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lnet/tsz/afinal/http/AjaxCallBack",
        "<",
        "Ljava/io/File;",
        ">;"
    }
.end annotation


# instance fields
.field private cu:I

.field private current_progress:Landroid/widget/TextView;

.field private down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field private kb:Landroid/widget/TextView;

.field private movie_name_item:Landroid/widget/TextView;

.field private p:Landroid/widget/ProgressBar;

.field private stop_download_bt:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/mydownload/DownloadTask;

.field private totalSize:Landroid/widget/TextView;

.field private view:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/mydownload/DownloadTask;Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 5
    .param p2, "view"    # Landroid/view/View;
    .param p3, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 406
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    invoke-direct {p0}, Lnet/tsz/afinal/http/AjaxCallBack;-><init>()V

    .line 407
    iput-object p3, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 408
    iput-object p2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->view:Landroid/view/View;

    .line 410
    if-eqz p2, :cond_1

    .line 412
    const v2, 0x7f07027a

    :try_start_0
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ProgressBar;

    .line 411
    iput-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->p:Landroid/widget/ProgressBar;

    .line 413
    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {p1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 414
    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 415
    .local v0, "displayMetrics":Landroid/util/DisplayMetrics;
    iget v2, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-static {p1, v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$5(Lcom/aio/downloader/mydownload/DownloadTask;I)V

    .line 416
    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->screenWidth:I
    invoke-static {p1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$6(Lcom/aio/downloader/mydownload/DownloadTask;)I

    move-result v2

    const/16 v3, 0x1f4

    if-ge v2, v3, :cond_0

    .line 417
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->p:Landroid/widget/ProgressBar;

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 418
    .local v1, "para":Landroid/view/ViewGroup$LayoutParams;
    const/16 v2, 0xba

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 419
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->p:Landroid/widget/ProgressBar;

    invoke-virtual {v2, v1}, Landroid/widget/ProgressBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 421
    .end local v1    # "para":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    const v2, 0x7f07027b

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->kb:Landroid/widget/TextView;

    .line 422
    const v2, 0x7f070279

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->totalSize:Landroid/widget/TextView;

    .line 424
    const v2, 0x7f070276

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 423
    iput-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    .line 426
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    const-string v3, "Pause"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 428
    const v2, 0x7f07027c

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 427
    iput-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    .line 430
    const v2, 0x7f070278

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 429
    iput-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->movie_name_item:Landroid/widget/TextView;

    .line 431
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    const/4 v3, 0x4

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 434
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    const-string v3, "Pause"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 436
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->movie_name_item:Landroid/widget/TextView;

    invoke-virtual {p3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 438
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->movie_name_item:Landroid/widget/TextView;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->typeFace:Landroid/graphics/Typeface;
    invoke-static {p1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$7(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/graphics/Typeface;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 440
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    const-string v3, "#cccccc"

    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 441
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {p1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v3

    .line 442
    const v4, 0x7f0b0020

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 441
    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 443
    new-instance v2, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    const/4 v3, 0x7

    .line 444
    iget-object v4, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    invoke-direct {v2, p1, v3, p3, v4}, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;ILcom/aio/downloader/mydownload/DownloadMovieItem;Landroid/widget/TextView;)V

    .line 443
    invoke-static {p1, v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$8(Lcom/aio/downloader/mydownload/DownloadTask;Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;)V

    .line 445
    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mc:Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;
    invoke-static {p1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$0(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    invoke-virtual {v2, v3}, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->setCurrent_progress(Landroid/widget/TextView;)V

    .line 446
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mc:Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;
    invoke-static {p1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$0(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 454
    .end local v0    # "displayMetrics":Landroid/util/DisplayMetrics;
    :cond_1
    :goto_0
    return-void

    .line 450
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method static synthetic access$1(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .locals 1

    .prologue
    .line 401
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadTask;
    .locals 1

    .prologue
    .line 392
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    return-object v0
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 17
    .param p1, "t"    # Ljava/lang/Throwable;
    .param p2, "strMsg"    # Ljava/lang/String;

    .prologue
    .line 798
    const-string v1, "qaz"

    const-string v2, "onFailure"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 800
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$4;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$4;-><init>(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 808
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 809
    new-instance v9, Landroid/content/Intent;

    const-string v1, "pdt_failure"

    invoke-direct {v9, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 810
    .local v9, "intent_failure":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v9}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 813
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 815
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v2, "0.0B"

    invoke-virtual {v1, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFileSize(Ljava/lang/String;)V

    .line 817
    :cond_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const/4 v2, 0x5

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 818
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$9(Lcom/aio/downloader/mydownload/DownloadTask;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v1

    const-string v2, "downloadtask2"

    const-string v3, "movieName=?"

    .line 819
    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 818
    invoke-virtual {v1, v2, v3, v4, v5}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    .line 862
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->view:Landroid/view/View;

    if-eqz v1, :cond_2

    .line 864
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->kb:Landroid/widget/TextView;

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 865
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getVisibility()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_1

    .line 866
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 869
    :cond_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    const-string v2, "Retry"

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 873
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    const-string v2, "#f39801"

    invoke-static {v2}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 875
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v2

    .line 876
    const v3, 0x7f0b0026

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 875
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 878
    new-instance v7, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    const/4 v2, 0x5

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 879
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    .line 878
    invoke-direct {v7, v1, v2, v3, v4}, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;ILcom/aio/downloader/mydownload/DownloadMovieItem;Landroid/widget/TextView;)V

    .line 880
    .local v7, "c":Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    invoke-virtual {v7, v1}, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->setCurrent_progress(Landroid/widget/TextView;)V

    .line 881
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    invoke-virtual {v1, v7}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 882
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->click_time:I
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$13(Lcom/aio/downloader/mydownload/DownloadTask;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$14(Lcom/aio/downloader/mydownload/DownloadTask;I)V

    .line 883
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v1

    const-string v2, "downloadcomplete"

    .line 884
    const/4 v3, 0x0

    .line 883
    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v15

    .line 885
    .local v15, "userInfo2":Landroid/content/SharedPreferences;
    const-string v1, "wycand"

    const/4 v2, 0x0

    invoke-interface {v15, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v14

    .line 887
    .local v14, "show":I
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->click_time:I
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$13(Lcom/aio/downloader/mydownload/DownloadTask;)I

    move-result v1

    const/4 v2, 0x4

    if-ge v1, v2, :cond_3

    .line 888
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->performClick()Z

    .line 942
    .end local v7    # "c":Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;
    .end local v14    # "show":I
    .end local v15    # "userInfo2":Landroid/content/SharedPreferences;
    :cond_2
    :goto_0
    return-void

    .line 894
    .restart local v7    # "c":Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;
    .restart local v14    # "show":I
    .restart local v15    # "userInfo2":Landroid/content/SharedPreferences;
    :cond_3
    if-nez v14, :cond_2

    .line 895
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$14(Lcom/aio/downloader/mydownload/DownloadTask;I)V

    .line 897
    new-instance v10, Landroid/app/Notification;

    invoke-direct {v10}, Landroid/app/Notification;-><init>()V

    .line 898
    .local v10, "notification3":Landroid/app/Notification;
    const/16 v1, 0x10

    iput v1, v10, Landroid/app/Notification;->flags:I

    .line 899
    const v1, 0x7f0200ec

    iput v1, v10, Landroid/app/Notification;->icon:I

    .line 900
    new-instance v8, Landroid/content/Intent;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v1

    .line 901
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 900
    invoke-direct {v8, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 902
    .local v8, "intent3":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v8, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 904
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v2

    .line 906
    const/high16 v3, 0x8000000

    .line 904
    invoke-static {v1, v2, v8, v3}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v12

    .line 907
    .local v12, "pendingIntent3":Landroid/app/PendingIntent;
    iput-object v12, v10, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 908
    new-instance v13, Landroid/widget/RemoteViews;

    .line 909
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 910
    const v2, 0x7f030091

    .line 908
    invoke-direct {v13, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 911
    .local v13, "rv3":Landroid/widget/RemoteViews;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$9(Lcom/aio/downloader/mydownload/DownloadTask;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 912
    const-class v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v5, "downloadtask2"

    .line 913
    const/4 v6, 0x0

    .line 911
    invoke-virtual/range {v1 .. v6}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    move-object/from16 v0, v16

    invoke-static {v0, v1}, Lcom/aio/downloader/mydownload/DownloadTask;->access$11(Lcom/aio/downloader/mydownload/DownloadTask;Ljava/util/List;)V

    .line 914
    const v1, 0x7f070332

    .line 915
    const-string v2, "Incomplete Task"

    .line 914
    invoke-virtual {v13, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 917
    const v1, 0x7f070333

    .line 918
    const-string v2, "kk:mm"

    .line 919
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 918
    invoke-static {v2, v3, v4}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v2

    .line 916
    invoke-virtual {v13, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 921
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 922
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "com.ywh.imgcache"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 923
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "allicon"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 924
    const-string v2, "com.ywh.imgcache"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 925
    const-string v2, "allicon"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 926
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 921
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 928
    .local v11, "path":Ljava/lang/String;
    const v1, 0x7f070331

    .line 929
    invoke-static {v11}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 928
    invoke-virtual {v13, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 930
    iput-object v13, v10, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 932
    :try_start_0
    sget-object v1, Lcom/aio/downloader/mydownload/DownloadTask;->mNotificationManager:Landroid/app/NotificationManager;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v2

    invoke-virtual {v1, v2, v10}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 934
    :catch_0
    move-exception v1

    goto/16 :goto_0
.end method

.method public onLoading(JJ)V
    .locals 14
    .param p1, "count"    # J
    .param p3, "current"    # J

    .prologue
    .line 488
    const/4 v3, 0x0

    .line 489
    .local v3, "cus":I
    iget v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->cu:I

    int-to-long v8, v8

    cmp-long v8, p3, v8

    if-lez v8, :cond_0

    .line 490
    iget v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->cu:I

    int-to-long v8, v8

    sub-long v8, p3, v8

    long-to-int v3, v8

    .line 491
    move-wide/from16 v0, p3

    long-to-int v8, v0

    iput v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->cu:I

    .line 493
    :cond_0
    new-instance v8, Ljava/lang/StringBuilder;

    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v9

    int-to-long v10, v3

    invoke-static {v9, v10, v11}, Landroid/text/format/Formatter;->formatFileSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "/s"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 495
    .local v4, "m":Ljava/lang/String;
    const-wide/16 v8, 0x64

    mul-long v8, v8, p3

    div-long/2addr v8, p1

    long-to-int v5, v8

    .line 497
    .local v5, "pc":I
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->view:Landroid/view/View;

    if-eqz v8, :cond_3

    .line 499
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v8}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v8

    move-wide/from16 v0, p3

    invoke-static {v8, v0, v1}, Landroid/text/format/Formatter;->formatFileSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v2

    .line 500
    .local v2, "currentSize":Ljava/lang/String;
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "%"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 502
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "%"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setPercentage(Ljava/lang/String;)V

    .line 503
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setProgressCount(Ljava/lang/Long;)V

    .line 504
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCurrentProgress(Ljava/lang/Long;)V

    .line 505
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v8}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v8

    move-wide v0, p1

    invoke-static {v8, v0, v1}, Landroid/text/format/Formatter;->formatFileSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v7

    .line 508
    .local v7, "tsize2":Ljava/lang/String;
    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    .line 509
    .local v6, "tsize":Ljava/lang/String;
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFileSize(Ljava/lang/String;)V

    .line 510
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->totalSize:Landroid/widget/TextView;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "/"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 511
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->kb:Landroid/widget/TextView;

    invoke-virtual {v8, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 512
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->kb:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->getVisibility()I

    move-result v8

    const/4 v9, 0x4

    if-ne v8, v9, :cond_1

    .line 513
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->kb:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 515
    :cond_1
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->p:Landroid/widget/ProgressBar;

    long-to-int v9, p1

    invoke-virtual {v8, v9}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 516
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->p:Landroid/widget/ProgressBar;

    move-wide/from16 v0, p3

    long-to-int v9, v0

    invoke-virtual {v8, v9}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 518
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->getVisibility()I

    move-result v8

    const/4 v9, 0x4

    if-ne v8, v9, :cond_2

    .line 519
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 520
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    const-string v9, "Pause"

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 524
    :cond_2
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const/4 v9, 0x2

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 525
    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v8}, Lcom/aio/downloader/mydownload/DownloadTask;->access$9(Lcom/aio/downloader/mydownload/DownloadTask;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v8

    const-string v9, "downloadtask2"

    const-string v10, "movieName=?"

    .line 526
    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/String;

    const/4 v12, 0x0

    iget-object v13, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v13}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v13

    aput-object v13, v11, v12

    iget-object v12, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 525
    invoke-virtual {v8, v9, v10, v11, v12}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    .line 530
    .end local v2    # "currentSize":Ljava/lang/String;
    .end local v6    # "tsize":Ljava/lang/String;
    .end local v7    # "tsize2":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method public onStart()V
    .locals 9

    .prologue
    const/4 v8, 0x7

    .line 464
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 465
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$9(Lcom/aio/downloader/mydownload/DownloadTask;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v2

    const-string v3, "downloadtask2"

    const-string v4, "movieName=?"

    .line 466
    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    iget-object v6, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 465
    invoke-virtual {v2, v3, v4, v5, v6}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    .line 468
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 469
    .local v1, "i":Landroid/content/Intent;
    const-string v2, "downloadType"

    invoke-virtual {v1, v2, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 470
    const-string v2, "downloadType"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 471
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 472
    .local v0, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/mydownload/MyApplcation;->setDownloadSuccess(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 473
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 475
    invoke-super {p0}, Lnet/tsz/afinal/http/AjaxCallBack;->onStart()V

    .line 476
    return-void
.end method

.method public onSuccess(Ljava/io/File;)V
    .locals 15
    .param p1, "t"    # Ljava/io/File;

    .prologue
    .line 543
    new-instance v9, Ljava/lang/Thread;

    new-instance v10, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$1;

    invoke-direct {v10, p0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$1;-><init>(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)V

    invoke-direct {v9, v10}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 551
    invoke-virtual {v9}, Ljava/lang/Thread;->start()V

    .line 552
    const-string v9, "qaz"

    const-string v10, "onSuccess"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 553
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->view:Landroid/view/View;

    if-eqz v9, :cond_0

    .line 554
    const-string v9, "qaz"

    const-string v10, "view!=null"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 555
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->kb:Landroid/widget/TextView;

    const/4 v10, 0x4

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 556
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    iget-object v10, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v10}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v10

    .line 557
    const v11, 0x7f0b0024

    invoke-virtual {v10, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 556
    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 559
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    const-string v10, "Pause"

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 560
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    new-instance v10, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    iget-object v11, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    .line 561
    const/4 v12, 0x6

    iget-object v13, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v14, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->stop_download_bt:Landroid/widget/TextView;

    invoke-direct {v10, v11, v12, v13, v14}, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;ILcom/aio/downloader/mydownload/DownloadMovieItem;Landroid/widget/TextView;)V

    .line 560
    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 568
    :cond_0
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const/4 v10, 0x6

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 569
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->access$9(Lcom/aio/downloader/mydownload/DownloadTask;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v9

    const-string v10, "downloadtask2"

    const-string v11, "movieName=?"

    .line 570
    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/String;

    const/4 v13, 0x0

    iget-object v14, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v14

    aput-object v14, v12, v13

    iget-object v13, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 569
    invoke-virtual {v9, v10, v11, v12, v13}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    .line 573
    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4}, Landroid/content/Intent;-><init>()V

    .line 574
    .local v4, "i":Landroid/content/Intent;
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    sput-object v9, Lcom/aio/downloader/utils/Myutils;->successItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 575
    const-string v9, "erer"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "11111111"

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v11, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v11}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v11}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 576
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 577
    .local v1, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    const-string v9, "downpath"

    iget-object v10, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v9, v10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 578
    const-string v9, "successful"

    invoke-virtual {v4, v9}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 580
    new-instance v5, Landroid/content/Intent;

    invoke-direct {v5}, Landroid/content/Intent;-><init>()V

    .line 581
    .local v5, "i2":Landroid/content/Intent;
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "mp3"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 583
    const-string v9, "mp3successful"

    invoke-virtual {v5, v9}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 595
    :cond_1
    :goto_0
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->is_valid_file()Ljava/lang/Boolean;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    if-eqz v9, :cond_7

    .line 598
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1, v9}, Lcom/aio/downloader/mydownload/MyApplcation;->setDownloadSuccess(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 600
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->view:Landroid/view/View;

    invoke-virtual {v9}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v7

    check-cast v7, Landroid/widget/LinearLayout;

    .line 604
    .local v7, "listview_lin":Landroid/widget/LinearLayout;
    :try_start_0
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->view:Landroid/view/View;

    invoke-virtual {v7, v9}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    .line 608
    :goto_1
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9, v4}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 609
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9, v5}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 611
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "app"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 612
    const/4 v9, 0x0

    sput-boolean v9, Lcom/aio/downloader/utils/publicTools;->toptoast:Z

    .line 613
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v9

    sput-object v9, Lcom/aio/downloader/utils/publicTools;->openimgpath:Ljava/lang/String;

    .line 614
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v9

    sput-object v9, Lcom/aio/downloader/utils/publicTools;->opentitle:Ljava/lang/String;

    .line 615
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v9

    sput-object v9, Lcom/aio/downloader/utils/publicTools;->openid:Ljava/lang/String;

    .line 617
    invoke-static {}, Lcom/stericson/RootTools/RootTools;->isRootAvailable()Z

    move-result v9

    if-eqz v9, :cond_6

    .line 618
    const-string v9, "qaz"

    const-string v10, "root"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 619
    new-instance v9, Ljava/lang/Thread;

    new-instance v10, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$2;

    invoke-direct {v10, p0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$2;-><init>(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)V

    invoke-direct {v9, v10}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 626
    invoke-virtual {v9}, Ljava/lang/Thread;->start()V

    .line 642
    :goto_2
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    const v10, 0x7f0200ec

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "\'"

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v12, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v12}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 643
    const-string v12, "\' Download Complete. Click to install"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 642
    # invokes: Lcom/aio/downloader/mydownload/DownloadTask;->showTips(ILjava/lang/String;)V
    invoke-static {v9, v10, v11}, Lcom/aio/downloader/mydownload/DownloadTask;->access$10(Lcom/aio/downloader/mydownload/DownloadTask;ILjava/lang/String;)V

    .line 644
    new-instance v6, Landroid/content/Intent;

    invoke-direct {v6}, Landroid/content/Intent;-><init>()V

    .line 645
    .local v6, "i3":Landroid/content/Intent;
    const-string v9, "jingmoanzhuang_aio"

    invoke-virtual {v6, v9}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 646
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9, v6}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 648
    new-instance v9, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;

    invoke-direct {v9, p0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;-><init>(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)V

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Void;

    .line 693
    invoke-virtual {v9, v10}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 793
    .end local v6    # "i3":Landroid/content/Intent;
    .end local v7    # "listview_lin":Landroid/widget/LinearLayout;
    :cond_2
    :goto_3
    invoke-super/range {p0 .. p1}, Lnet/tsz/afinal/http/AjaxCallBack;->onSuccess(Ljava/lang/Object;)V

    .line 794
    return-void

    .line 584
    :cond_3
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "ringtone"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 585
    const-string v9, "ringtonesuccessful"

    invoke-virtual {v5, v9}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 586
    :cond_4
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "app"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 588
    const-string v9, "appsuccessful_aio"

    invoke-virtual {v5, v9}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 589
    :cond_5
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "video"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 591
    const-string v9, "videosuccessful"

    invoke-virtual {v5, v9}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 630
    .restart local v7    # "listview_lin":Landroid/widget/LinearLayout;
    :cond_6
    :try_start_1
    new-instance v0, Landroid/content/Intent;

    const-string v9, "android.intent.action.VIEW"

    invoke-direct {v0, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 632
    .local v0, "aa":Landroid/content/Intent;
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "file://"

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v10, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v9

    .line 633
    const-string v10, "application/vnd.android.package-archive"

    .line 631
    invoke-virtual {v0, v9, v10}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 634
    const/high16 v9, 0x10000000

    invoke-virtual {v0, v9}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 635
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_2

    .line 636
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_0
    move-exception v9

    goto/16 :goto_2

    .line 699
    .end local v7    # "listview_lin":Landroid/widget/LinearLayout;
    :cond_7
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 700
    .local v8, "msg":Landroid/os/Message;
    const/16 v9, 0x4bc

    iput v9, v8, Landroid/os/Message;->what:I

    .line 701
    invoke-virtual {v8}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v9

    const-string v10, "type"

    iget-object v11, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v11}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 702
    invoke-virtual {v8}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v9

    const-string v10, "id"

    iget-object v11, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v11}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 703
    invoke-virtual {v8}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v9

    const-string v10, "size"

    iget-object v11, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v11}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 704
    const-string v2, ""

    .line 706
    .local v2, "content":Ljava/lang/String;
    :try_start_2
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    iget-object v10, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/aio/downloader/mydownload/DownloadTask;->BufferedReader(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 707
    const-string v9, "tyty"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "content==="

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 713
    :goto_4
    :try_start_3
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v9

    const/16 v10, 0x64

    if-le v9, v10, :cond_9

    .line 714
    invoke-virtual {v8}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v9

    const-string v10, "content"

    .line 715
    const/4 v11, 0x1

    const/16 v12, 0x64

    invoke-virtual {v2, v11, v12}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v11

    .line 714
    invoke-virtual {v9, v10, v11}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 720
    :goto_5
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "app"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_a

    .line 721
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 722
    const-string v10, "app_recent"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_a

    .line 723
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->app_recent_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    .line 787
    :cond_8
    :goto_6
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    const-string v10, "Invalid"

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 788
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->current_progress:Landroid/widget/TextView;

    const-string v10, "#f39801"

    invoke-static {v10}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setTextColor(I)V

    .line 789
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->kb:Landroid/widget/TextView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 790
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->kb:Landroid/widget/TextView;

    const-string v10, "0KB/s"

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_3

    .line 709
    :catch_1
    move-exception v3

    .line 710
    .local v3, "e":Ljava/io/IOException;
    invoke-virtual {v3}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 717
    .end local v3    # "e":Ljava/io/IOException;
    :cond_9
    :try_start_4
    invoke-virtual {v8}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v9

    const-string v10, "content"

    invoke-virtual {v9, v10, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    .line 783
    :catch_2
    move-exception v9

    goto :goto_6

    .line 724
    :cond_a
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "app"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_b

    .line 725
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 726
    const-string v10, "app_popular"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_b

    .line 727
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->app_popular_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_6

    .line 728
    :cond_b
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "app"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_c

    .line 729
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 730
    const-string v10, "app_search"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_c

    .line 731
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->app_search_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_6

    .line 733
    :cond_c
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "app"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_d

    .line 734
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 735
    const-string v10, "app_detail"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_d

    .line 736
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->app_detail_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_6

    .line 740
    :cond_d
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "game"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_e

    .line 741
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 742
    const-string v10, "game_recent"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_e

    .line 743
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->game_recent_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_6

    .line 745
    :cond_e
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "game"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_f

    .line 746
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 747
    const-string v10, "game_popular"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_f

    .line 748
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->game_popular_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_6

    .line 753
    :cond_f
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "mp3"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_10

    .line 754
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 755
    const-string v10, "mp3_recent"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_10

    .line 757
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->mp3_recent_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_6

    .line 759
    :cond_10
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "mp3"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_11

    .line 760
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 761
    const-string v10, "mp3_popular"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_11

    .line 763
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->mp3_popular_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_6

    .line 764
    :cond_11
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "mp3"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_12

    .line 765
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 766
    const-string v10, "mp3_search"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_12

    .line 767
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->mp3_search_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_6

    .line 770
    :cond_12
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "ringtone"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_13

    .line 771
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 772
    const-string v10, "ringtone_recent"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_13

    .line 773
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->ringtone_recent_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_6

    .line 774
    :cond_13
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "ringtone"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_14

    .line 775
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 776
    const-string v10, "ringtone_popular"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_14

    .line 777
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->ringtone_popular_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_6

    .line 778
    :cond_14
    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "ringtone"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 779
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v9, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 780
    const-string v10, "ringtone_search"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 781
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->ringtone_search_handler:Landroid/os/Handler;

    invoke-virtual {v9, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    goto/16 :goto_6

    .line 605
    .end local v2    # "content":Ljava/lang/String;
    .end local v8    # "msg":Landroid/os/Message;
    .restart local v7    # "listview_lin":Landroid/widget/LinearLayout;
    :catch_3
    move-exception v9

    goto/16 :goto_1
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/io/File;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->onSuccess(Ljava/io/File;)V

    return-void
.end method
