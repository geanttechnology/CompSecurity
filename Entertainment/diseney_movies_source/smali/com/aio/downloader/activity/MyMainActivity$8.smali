.class Lcom/aio/downloader/activity/MyMainActivity$8;
.super Landroid/os/Handler;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 521
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;
    .locals 1

    .prologue
    .line 521
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 8
    .param p1, "mymsg"    # Landroid/os/Message;

    .prologue
    const/4 v7, 0x0

    .line 525
    iget v2, p1, Landroid/os/Message;->what:I

    sparse-switch v2, :sswitch_data_0

    .line 629
    :cond_0
    :goto_0
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 630
    return-void

    .line 528
    :sswitch_0
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 529
    sget-object v4, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v5, "neitui_time"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 528
    sub-long/2addr v2, v4

    .line 529
    const-wide/32 v4, 0x2932e00

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 530
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    new-instance v3, Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    .line 531
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    const v5, 0x7f0c0010

    .line 532
    iget-object v6, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v6, v6, Lcom/aio/downloader/activity/MyMainActivity;->itemsOnClick2:Landroid/view/View$OnClickListener;

    invoke-direct {v3, v4, v5, v6}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V

    .line 530
    iput-object v3, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    .line 533
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v2, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->setCanceledOnTouchOutside(Z)V

    .line 534
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v2, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->show()V

    .line 535
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v2, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v3, v3, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-virtual {v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->getNtTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->setTvTitle(Ljava/lang/String;)V

    .line 536
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v2, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v3, v3, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-virtual {v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->getNtMsg()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->setTvContent(Ljava/lang/String;)V

    .line 537
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v2, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v3, v3, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-virtual {v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->getPicPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->setImgIcon(Ljava/lang/String;)V

    .line 539
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v3, "neitui_time"

    .line 540
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 539
    invoke-virtual {v2, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 541
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->saveSetting()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 545
    :catch_0
    move-exception v1

    .line 546
    .local v1, "e1":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    .line 548
    :try_start_1
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v3, "neitui_time"

    .line 549
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 548
    invoke-virtual {v2, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 550
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->saveSetting()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 555
    :goto_1
    new-instance v2, Lcom/aio/downloader/activity/MyMainActivity$8$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/MyMainActivity$8$1;-><init>(Lcom/aio/downloader/activity/MyMainActivity$8;)V

    new-array v3, v7, [Ljava/lang/Void;

    .line 583
    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/MyMainActivity$8$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 551
    :catch_1
    move-exception v0

    .line 553
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 588
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v1    # "e1":Lorg/json/JSONException;
    :sswitch_1
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->windowFocus:Z
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity;->access$14(Lcom/aio/downloader/activity/MyMainActivity;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 589
    new-instance v2, Lcom/aio/downloader/activity/MyMainActivity$8$2;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/MyMainActivity$8$2;-><init>(Lcom/aio/downloader/activity/MyMainActivity$8;)V

    new-array v3, v7, [Ljava/lang/Void;

    .line 609
    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/MyMainActivity$8$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 525
    :sswitch_data_0
    .sparse-switch
        0x14 -> :sswitch_1
        0x2710 -> :sswitch_0
    .end sparse-switch
.end method
