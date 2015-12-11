.class Lcom/aio/downloader/service/GetBroadcast$5;
.super Ljava/lang/Object;
.source "GetBroadcast.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/GetBroadcast;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/GetBroadcast;

.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/GetBroadcast;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/GetBroadcast$5;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    iput-object p2, p0, Lcom/aio/downloader/service/GetBroadcast$5;->val$context:Landroid/content/Context;

    .line 348
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/GetBroadcast$5;)Lcom/aio/downloader/service/GetBroadcast;
    .locals 1

    .prologue
    .line 348
    iget-object v0, p0, Lcom/aio/downloader/service/GetBroadcast$5;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v8, 0x0

    const/high16 v7, 0x10000000

    .line 353
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 442
    :goto_0
    :pswitch_0
    return-void

    .line 355
    :pswitch_1
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->uninstallDailog:Lcom/aio/downloader/dialog/UninstallDailog;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$4(Lcom/aio/downloader/service/GetBroadcast;)Lcom/aio/downloader/dialog/UninstallDailog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/UninstallDailog;->dismiss()V

    goto :goto_0

    .line 358
    :pswitch_2
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->val$context:Landroid/content/Context;

    .line 359
    const-string v5, "UnInstall_click"

    .line 358
    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 360
    new-instance v4, Lcom/aio/downloader/service/GetBroadcast$5$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/service/GetBroadcast$5$1;-><init>(Lcom/aio/downloader/service/GetBroadcast$5;)V

    .line 370
    invoke-virtual {v4}, Lcom/aio/downloader/service/GetBroadcast$5$1;->start()V

    .line 371
    const/4 v3, 0x0

    .line 373
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->val$context:Landroid/content/Context;

    .line 374
    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 376
    const-string v5, "com.evzapp.cleanmaster"

    const/4 v6, 0x0

    .line 375
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 380
    :goto_1
    if-nez v3, :cond_2

    .line 381
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$1(Lcom/aio/downloader/service/GetBroadcast;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 382
    new-instance v0, Landroid/content/Intent;

    .line 383
    const-string v4, "android.intent.action.VIEW"

    .line 382
    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 385
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/service/GetBroadcast$5;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/service/GetBroadcast;->access$2(Lcom/aio/downloader/service/GetBroadcast;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 386
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 387
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 385
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 388
    const-string v5, "application/vnd.android.package-archive"

    .line 384
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 389
    invoke-virtual {v0, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 390
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->val$context:Landroid/content/Context;

    invoke-virtual {v4, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 437
    .end local v0    # "aa":Landroid/content/Intent;
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->uninstallDailog:Lcom/aio/downloader/dialog/UninstallDailog;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$4(Lcom/aio/downloader/service/GetBroadcast;)Lcom/aio/downloader/dialog/UninstallDailog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/UninstallDailog;->dismiss()V

    goto :goto_0

    .line 377
    :catch_0
    move-exception v1

    .line 378
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 391
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$3(Lcom/aio/downloader/service/GetBroadcast;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 392
    new-instance v4, Lcom/aio/downloader/service/GetBroadcast$5$2;

    iget-object v5, p0, Lcom/aio/downloader/service/GetBroadcast$5;->val$context:Landroid/content/Context;

    invoke-direct {v4, p0, v5}, Lcom/aio/downloader/service/GetBroadcast$5$2;-><init>(Lcom/aio/downloader/service/GetBroadcast$5;Landroid/content/Context;)V

    new-array v5, v8, [Ljava/lang/Void;

    .line 421
    invoke-virtual {v4, v5}, Lcom/aio/downloader/service/GetBroadcast$5$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2

    .line 423
    :cond_1
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->val$context:Landroid/content/Context;

    .line 424
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 423
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 425
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 426
    const-string v5, "com.evzapp.cleanmaster"

    .line 425
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 427
    invoke-virtual {v2, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 428
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->val$context:Landroid/content/Context;

    invoke-virtual {v4, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 431
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->val$context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 433
    const-string v5, "com.evzapp.cleanmaster"

    .line 432
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 434
    .restart local v2    # "intent":Landroid/content/Intent;
    invoke-virtual {v2, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 435
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$5;->val$context:Landroid/content/Context;

    invoke-virtual {v4, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 353
    nop

    :pswitch_data_0
    .packed-switch 0x7f070090
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
