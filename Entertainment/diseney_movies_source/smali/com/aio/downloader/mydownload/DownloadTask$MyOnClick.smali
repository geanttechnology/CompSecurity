.class public Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;
.super Ljava/lang/Object;
.source "DownloadTask.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/mydownload/DownloadTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MyOnClick"
.end annotation


# instance fields
.field private button:Landroid/widget/TextView;

.field public clickState:Z

.field private current_progress:Landroid/widget/TextView;

.field private downItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field public state:I

.field final synthetic this$0:Lcom/aio/downloader/mydownload/DownloadTask;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/mydownload/DownloadTask;ILcom/aio/downloader/mydownload/DownloadMovieItem;Landroid/widget/TextView;)V
    .locals 1
    .param p2, "state"    # I
    .param p3, "downItem"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .param p4, "button"    # Landroid/widget/TextView;

    .prologue
    .line 274
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 267
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->clickState:Z

    .line 275
    iput p2, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->state:I

    .line 276
    iput-object p3, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->downItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 277
    iput-object p4, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->button:Landroid/widget/TextView;

    .line 278
    return-void
.end method


# virtual methods
.method public getCurrent_progress()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 353
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->current_progress:Landroid/widget/TextView;

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 11
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x0

    .line 288
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->downItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    .line 290
    .local v2, "name":Ljava/lang/String;
    iget v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->state:I

    packed-switch v5, :pswitch_data_0

    .line 350
    :goto_0
    :pswitch_0
    return-void

    .line 297
    :pswitch_1
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->button:Landroid/widget/TextView;

    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 298
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->current_progress:Landroid/widget/TextView;

    const-string v6, "#cccccc"

    invoke-static {v6}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTextColor(I)V

    .line 299
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->current_progress:Landroid/widget/TextView;

    const-string v6, "Waiting in queue"

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 300
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    iget-object v6, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v6}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;
    invoke-static {v7}, Lcom/aio/downloader/mydownload/DownloadTask;->access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lcom/aio/downloader/mydownload/DownloadTask;->gotoDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;Landroid/view/View;)V

    .line 303
    :try_start_0
    sget-object v5, Lcom/aio/downloader/mydownload/DownloadTask;->mNotificationManager:Landroid/app/NotificationManager;

    iget-object v6, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v6}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v6

    invoke-virtual {v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/app/NotificationManager;->cancel(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 304
    :catch_0
    move-exception v5

    goto :goto_0

    .line 310
    :pswitch_2
    iget-boolean v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->clickState:Z

    if-eqz v5, :cond_1

    .line 312
    new-instance v1, Landroid/content/Intent;

    const-string v5, "intent_start"

    invoke-direct {v1, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 313
    .local v1, "intent_start":Landroid/content/Intent;
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 314
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    iget-object v6, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v6}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;
    invoke-static {v7}, Lcom/aio/downloader/mydownload/DownloadTask;->access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lcom/aio/downloader/mydownload/DownloadTask;->gotoDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;Landroid/view/View;)V

    .line 315
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v5

    .line 316
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "\'"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\' starts downloading."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 315
    invoke-static {v5, v6, v8}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v5

    .line 317
    invoke-virtual {v5}, Landroid/widget/Toast;->show()V

    .line 318
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->button:Landroid/widget/TextView;

    if-eqz v5, :cond_0

    .line 320
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->button:Landroid/widget/TextView;

    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 321
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->current_progress:Landroid/widget/TextView;

    .line 322
    const-string v6, "#cccccc"

    invoke-static {v6}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v6

    .line 321
    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTextColor(I)V

    .line 323
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->current_progress:Landroid/widget/TextView;

    iget-object v6, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v6}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v6

    .line 324
    const v7, 0x7f0b0020

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 323
    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 326
    :cond_0
    iput-boolean v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->clickState:Z

    goto/16 :goto_0

    .line 328
    .end local v1    # "intent_start":Landroid/content/Intent;
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v5, "intent_pause"

    invoke-direct {v0, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 329
    .local v0, "intent_pause":Landroid/content/Intent;
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 330
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloadFile()Lcom/aio/downloader/mydownload/DownloadFile;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadFile;->stopDownload()V

    .line 332
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "\'"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\' is paused."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v8}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v5

    .line 333
    invoke-virtual {v5}, Landroid/widget/Toast;->show()V

    .line 334
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->button:Landroid/widget/TextView;

    if-eqz v5, :cond_2

    .line 336
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->button:Landroid/widget/TextView;

    const-string v6, "Start"

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 338
    :cond_2
    const/4 v5, 0x1

    iput-boolean v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->clickState:Z

    goto/16 :goto_0

    .line 343
    .end local v0    # "intent_pause":Landroid/content/Intent;
    :pswitch_3
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloadUrl()Ljava/lang/String;

    move-result-object v4

    .line 344
    .local v4, "url":Ljava/lang/String;
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v3

    .line 345
    .local v3, "path":Ljava/lang/String;
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    new-instance v6, Lcom/aio/downloader/mydownload/DownloadFile;

    invoke-direct {v6}, Lcom/aio/downloader/mydownload/DownloadFile;-><init>()V

    .line 346
    new-instance v7, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;
    invoke-static {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;

    move-result-object v9

    iget-object v10, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v10}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 345
    invoke-virtual {v6, v4, v3, v7}, Lcom/aio/downloader/mydownload/DownloadFile;->startDownloadFileByUrl(Ljava/lang/String;Ljava/lang/String;Lnet/tsz/afinal/http/AjaxCallBack;)Lcom/aio/downloader/mydownload/DownloadFile;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadFile(Lcom/aio/downloader/mydownload/DownloadFile;)V

    goto/16 :goto_0

    .line 290
    nop

    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public setCurrent_progress(Landroid/widget/TextView;)V
    .locals 0
    .param p1, "current_progress"    # Landroid/widget/TextView;

    .prologue
    .line 357
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->current_progress:Landroid/widget/TextView;

    .line 358
    return-void
.end method
