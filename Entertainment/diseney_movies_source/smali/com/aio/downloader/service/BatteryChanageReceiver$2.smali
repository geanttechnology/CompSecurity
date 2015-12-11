.class Lcom/aio/downloader/service/BatteryChanageReceiver$2;
.super Ljava/lang/Object;
.source "BatteryChanageReceiver.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/BatteryChanageReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

.field private final synthetic val$arg0:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/BatteryChanageReceiver;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    iput-object p2, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->val$arg0:Landroid/content/Context;

    .line 324
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/BatteryChanageReceiver$2;)Lcom/aio/downloader/service/BatteryChanageReceiver;
    .locals 1

    .prologue
    .line 324
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const-wide/32 v7, 0x377eff

    const/high16 v6, 0x10000000

    .line 326
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 410
    :goto_0
    return-void

    .line 328
    :pswitch_0
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->val$arg0:Landroid/content/Context;

    const-string v4, "batterychange_click"

    invoke-static {v3, v4}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 329
    new-instance v3, Lcom/aio/downloader/service/BatteryChanageReceiver$2$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/service/BatteryChanageReceiver$2$1;-><init>(Lcom/aio/downloader/service/BatteryChanageReceiver$2;)V

    .line 338
    invoke-virtual {v3}, Lcom/aio/downloader/service/BatteryChanageReceiver$2$1;->start()V

    .line 339
    const/4 v2, 0x0

    .line 341
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->val$arg0:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 342
    const-string v4, "com.aioapp.battery"

    .line 343
    const/4 v5, 0x0

    .line 342
    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 347
    :goto_1
    if-nez v2, :cond_2

    .line 349
    :try_start_1
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    # getter for: Lcom/aio/downloader/service/BatteryChanageReceiver;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/BatteryChanageReceiver;->access$0(Lcom/aio/downloader/service/BatteryChanageReceiver;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 350
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    iget-object v4, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    # getter for: Lcom/aio/downloader/service/BatteryChanageReceiver;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryChanageReceiver;->access$0(Lcom/aio/downloader/service/BatteryChanageReceiver;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/aio/downloader/service/BatteryChanageReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v3

    cmp-long v3, v3, v7

    if-ltz v3, :cond_0

    .line 351
    new-instance v1, Landroid/content/Intent;

    .line 352
    const-string v3, "android.intent.action.VIEW"

    .line 351
    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 353
    .local v1, "intent":Landroid/content/Intent;
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "file://"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 354
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    # getter for: Lcom/aio/downloader/service/BatteryChanageReceiver;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryChanageReceiver;->access$0(Lcom/aio/downloader/service/BatteryChanageReceiver;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 353
    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 355
    const-string v4, "application/vnd.android.package-archive"

    .line 353
    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 356
    const/high16 v3, 0x10000000

    invoke-virtual {v1, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 357
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->val$arg0:Landroid/content/Context;

    invoke-virtual {v3, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 404
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_2
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    # getter for: Lcom/aio/downloader/service/BatteryChanageReceiver;->changeDialog:Lcom/aio/downloader/dialog/ChangeDialog;
    invoke-static {v3}, Lcom/aio/downloader/service/BatteryChanageReceiver;->access$2(Lcom/aio/downloader/service/BatteryChanageReceiver;)Lcom/aio/downloader/dialog/ChangeDialog;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/dialog/ChangeDialog;->dismiss()V

    goto :goto_0

    .line 344
    :catch_0
    move-exception v0

    .line 345
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 358
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    :try_start_2
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    # getter for: Lcom/aio/downloader/service/BatteryChanageReceiver;->AIOBATTERY:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/BatteryChanageReceiver;->access$1(Lcom/aio/downloader/service/BatteryChanageReceiver;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 359
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    iget-object v4, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    # getter for: Lcom/aio/downloader/service/BatteryChanageReceiver;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryChanageReceiver;->access$1(Lcom/aio/downloader/service/BatteryChanageReceiver;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/aio/downloader/service/BatteryChanageReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v3

    cmp-long v3, v3, v7

    if-ltz v3, :cond_1

    .line 360
    new-instance v3, Lcom/aio/downloader/service/BatteryChanageReceiver$2$2;

    iget-object v4, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->val$arg0:Landroid/content/Context;

    invoke-direct {v3, p0, v4}, Lcom/aio/downloader/service/BatteryChanageReceiver$2$2;-><init>(Lcom/aio/downloader/service/BatteryChanageReceiver$2;Landroid/content/Context;)V

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    .line 383
    invoke-virtual {v3, v4}, Lcom/aio/downloader/service/BatteryChanageReceiver$2$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_2

    .line 393
    :catch_1
    move-exception v0

    .line 395
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2

    .line 385
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_3
    new-instance v1, Landroid/content/Intent;

    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->val$arg0:Landroid/content/Context;

    .line 386
    const-class v4, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 385
    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 387
    .restart local v1    # "intent":Landroid/content/Intent;
    const-string v3, "myid"

    .line 388
    const-string v4, "com.aioapp.battery"

    .line 387
    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 389
    const-string v3, "xiazaidianchi"

    const/4 v4, 0x1

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 390
    const/high16 v3, 0x10000000

    invoke-virtual {v1, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 391
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->val$arg0:Landroid/content/Context;

    invoke-virtual {v3, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_2

    .line 398
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_2
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->val$arg0:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 400
    const-string v4, "com.aioapp.battery"

    .line 399
    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 401
    .restart local v1    # "intent":Landroid/content/Intent;
    invoke-virtual {v1, v6}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 402
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->val$arg0:Landroid/content/Context;

    invoke-virtual {v3, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 407
    .end local v1    # "intent":Landroid/content/Intent;
    .end local v2    # "packageInfo":Landroid/content/pm/PackageInfo;
    :pswitch_1
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$2;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    # getter for: Lcom/aio/downloader/service/BatteryChanageReceiver;->changeDialog:Lcom/aio/downloader/dialog/ChangeDialog;
    invoke-static {v3}, Lcom/aio/downloader/service/BatteryChanageReceiver;->access$2(Lcom/aio/downloader/service/BatteryChanageReceiver;)Lcom/aio/downloader/dialog/ChangeDialog;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/dialog/ChangeDialog;->dismiss()V

    goto/16 :goto_0

    .line 326
    :pswitch_data_0
    .packed-switch 0x7f070138
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
