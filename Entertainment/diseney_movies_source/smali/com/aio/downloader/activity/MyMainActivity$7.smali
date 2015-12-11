.class Lcom/aio/downloader/activity/MyMainActivity$7;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 423
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyMainActivity$7;)Lcom/aio/downloader/activity/MyMainActivity;
    .locals 1

    .prologue
    .line 423
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 10
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v9, 0x0

    .line 428
    iget v5, p1, Landroid/os/Message;->what:I

    const/16 v6, 0x234

    if-ne v5, v6, :cond_1

    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->windowFocus:Z
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$14(Lcom/aio/downloader/activity/MyMainActivity;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 430
    iget-object v6, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v5, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v5, Lcom/aio/downloader/model/GameInfosVersionModel;

    iput-object v5, v6, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    .line 431
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v5, v5, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/GameInfosVersionModel;->getNtId()Ljava/lang/String;

    move-result-object v3

    .line 434
    .local v3, "ntId":Ljava/lang/String;
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v6, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v6, v6, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-virtual {v6}, Lcom/aio/downloader/model/GameInfosVersionModel;->getUpdatePath()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/aio/downloader/activity/MyMainActivity;->access$0(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V

    .line 435
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->newVersionUrl:Ljava/lang/String;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$1(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v5

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 437
    const-string v5, "version"

    const-string v6, "777777"

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 438
    new-instance v1, Lcom/aio/downloader/activity/MyMainActivity$7$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyMainActivity$7$1;-><init>(Lcom/aio/downloader/activity/MyMainActivity$7;)V

    .line 458
    .local v1, "itemsOnClick":Landroid/view/View$OnClickListener;
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    new-instance v6, Lcom/aio/downloader/dialog/UpdateDialogVerison;

    .line 459
    iget-object v7, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    const v8, 0x7f0c0010

    .line 460
    invoke-direct {v6, v7, v8, v1}, Lcom/aio/downloader/dialog/UpdateDialogVerison;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V

    .line 458
    iput-object v6, v5, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion:Lcom/aio/downloader/dialog/UpdateDialogVerison;

    .line 461
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v5, v5, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion:Lcom/aio/downloader/dialog/UpdateDialogVerison;

    invoke-virtual {v5, v9}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->setCanceledOnTouchOutside(Z)V

    .line 464
    :try_start_0
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v5, v5, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion:Lcom/aio/downloader/dialog/UpdateDialogVerison;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Update Time: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 466
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    .line 465
    invoke-static {v7, v8}, Lcom/aio/downloader/utils/Myutils;->timezhuanhua(J)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 467
    const-string v7, " dd, yyyy"

    .line 468
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    .line 467
    invoke-static {v7, v8, v9}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 464
    invoke-virtual {v5, v6}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->setTvTitle(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 481
    .end local v1    # "itemsOnClick":Landroid/view/View$OnClickListener;
    :cond_0
    :goto_0
    if-eqz v3, :cond_1

    const-string v5, ""

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 484
    :try_start_1
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v6, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v6}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 485
    const/4 v7, 0x0

    invoke-virtual {v6, v3, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v6

    .line 484
    iput-object v6, v5, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0

    .line 490
    :goto_1
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v5, v5, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/GameInfosVersionModel;->getNtPath()Ljava/lang/String;

    move-result-object v4

    .line 491
    .local v4, "ntPath":Ljava/lang/String;
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v5, v5, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v5, :cond_1

    if-eqz v4, :cond_1

    .line 492
    const-string v5, ""

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 493
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    new-instance v6, Lcom/aio/downloader/activity/MyMainActivity$7$2;

    invoke-direct {v6, p0, v4}, Lcom/aio/downloader/activity/MyMainActivity$7$2;-><init>(Lcom/aio/downloader/activity/MyMainActivity$7;Ljava/lang/String;)V

    iput-object v6, v5, Lcom/aio/downloader/activity/MyMainActivity;->itemsOnClick2:Landroid/view/View$OnClickListener;

    .line 509
    new-instance v2, Landroid/os/Message;

    invoke-direct {v2}, Landroid/os/Message;-><init>()V

    .line 510
    .local v2, "mymsg":Landroid/os/Message;
    const/16 v5, 0x2710

    iput v5, v2, Landroid/os/Message;->what:I

    .line 511
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v5, v5, Lcom/aio/downloader/activity/MyMainActivity;->handlertimer:Landroid/os/Handler;

    const-wide/16 v6, 0x1388

    invoke-virtual {v5, v2, v6, v7}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 512
    const-string v5, "ppp"

    const-string v6, "10000"

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 519
    .end local v2    # "mymsg":Landroid/os/Message;
    .end local v3    # "ntId":Ljava/lang/String;
    .end local v4    # "ntPath":Ljava/lang/String;
    :cond_1
    return-void

    .line 486
    .restart local v3    # "ntId":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 487
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    const/4 v6, 0x0

    iput-object v6, v5, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 488
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 470
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v1    # "itemsOnClick":Landroid/view/View$OnClickListener;
    :catch_1
    move-exception v5

    goto :goto_0
.end method
