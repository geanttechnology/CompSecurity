.class Lcom/aio/downloader/activity/AppDetailsActivity$10;
.super Landroid/os/Handler;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 267
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v5, 0x0

    .line 270
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 271
    iget v2, p1, Landroid/os/Message;->what:I

    sparse-switch v2, :sswitch_data_0

    .line 318
    :cond_0
    :goto_0
    return-void

    .line 273
    :sswitch_0
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 274
    const-string v3, "Failed to connect server."

    .line 273
    invoke-static {v2, v3, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 274
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 278
    :sswitch_1
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # invokes: Lcom/aio/downloader/activity/AppDetailsActivity;->Mydialog()V
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$16(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    goto :goto_0

    .line 281
    :sswitch_2
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wocao:I
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$17(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v2

    if-nez v2, :cond_1

    .line 283
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 284
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 285
    const-string v4, "\' is added to download queue."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 284
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 282
    invoke-static {v2, v3, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 286
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 293
    :goto_1
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 294
    .local v1, "ti":Landroid/content/Intent;
    const-string v2, "appdetail"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 295
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0

    .line 288
    .end local v1    # "ti":Landroid/content/Intent;
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 289
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appName:Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$19(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\' is added to download queue."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 288
    invoke-static {v2, v3, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 290
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_1

    .line 308
    :sswitch_3
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 309
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->GetClickTime(Landroid/content/Context;)J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 310
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailtogift:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$20(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;

    move-result-object v2

    const v3, 0x7f0200d8

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 312
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f04001e

    .line 311
    invoke-static {v2, v3}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 313
    .local v0, "shake":Landroid/view/animation/Animation;
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$10;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailtogift:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$20(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_0

    .line 271
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x3 -> :sswitch_2
        0x7530 -> :sswitch_3
    .end sparse-switch
.end method
