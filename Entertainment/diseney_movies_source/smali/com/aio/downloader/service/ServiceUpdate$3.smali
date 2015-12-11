.class Lcom/aio/downloader/service/ServiceUpdate$3;
.super Landroid/content/BroadcastReceiver;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/service/ServiceUpdate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/ServiceUpdate;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    .line 1381
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v5, 0x0

    const/high16 v4, 0x10000000

    .line 1386
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "update"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1387
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 1388
    const-string v3, "update_not_click"

    .line 1387
    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1394
    new-instance p2, Landroid/content/Intent;

    .end local p2    # "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 1395
    const-class v3, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1394
    invoke-direct {p2, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1396
    .restart local p2    # "intent":Landroid/content/Intent;
    const-string v2, "myid"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v3, v3, Lcom/aio/downloader/service/ServiceUpdate;->appid:Ljava/lang/String;

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1397
    const-string v2, "linkurl"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->appurl:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$22(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1398
    const-string v2, "wocao"

    const/4 v3, 0x1

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1399
    const-string v2, "caocao"

    invoke-virtual {p2, v2, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1400
    const-string v2, "myupver"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->appversion2:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$23(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1401
    invoke-virtual {p2, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 1402
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2, p2}, Lcom/aio/downloader/service/ServiceUpdate;->startActivity(Landroid/content/Intent;)V

    .line 1443
    :cond_0
    :goto_0
    return-void

    .line 1403
    :cond_1
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "pick"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1404
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 1405
    const-string v3, "pick_apps_click"

    .line 1404
    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1406
    new-instance p2, Landroid/content/Intent;

    .end local p2    # "intent":Landroid/content/Intent;
    const-class v2, Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-direct {p2, p1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1407
    .restart local p2    # "intent":Landroid/content/Intent;
    const-string v2, "myid"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->id_meiri:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$13(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1408
    invoke-virtual {p2, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 1409
    const-string v2, "linkurl"

    const-string v3, ""

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1410
    const-string v2, "caocao"

    invoke-virtual {p2, v2, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1411
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2, p2}, Lcom/aio/downloader/service/ServiceUpdate;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 1413
    :cond_2
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "pick_big"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1415
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "pick_big_click"

    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1416
    new-instance p2, Landroid/content/Intent;

    .end local p2    # "intent":Landroid/content/Intent;
    const-class v2, Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-direct {p2, p1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1417
    .restart local p2    # "intent":Landroid/content/Intent;
    const-string v2, "myid"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->id_meiribig:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$18(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1418
    invoke-virtual {p2, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 1419
    const-string v2, "linkurl"

    const-string v3, ""

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1420
    const-string v2, "caocao"

    invoke-virtual {p2, v2, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1421
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2, p2}, Lcom/aio/downloader/service/ServiceUpdate;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 1423
    :cond_3
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "paid"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1424
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "paid_click"

    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1425
    new-instance p2, Landroid/content/Intent;

    .end local p2    # "intent":Landroid/content/Intent;
    const-class v2, Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-direct {p2, p1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1426
    .restart local p2    # "intent":Landroid/content/Intent;
    invoke-virtual {p2, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 1427
    const-string v2, "caocao"

    invoke-virtual {p2, v2, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1428
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2, p2}, Lcom/aio/downloader/service/ServiceUpdate;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1429
    :cond_4
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "status_bar_download_success"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 1430
    const-string v2, "downloadsuccess_click"

    invoke-static {p1, v2}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1431
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1432
    .local v0, "aa":Landroid/content/Intent;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->filepathdown:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$24(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 1433
    const-string v3, "application/vnd.android.package-archive"

    .line 1432
    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 1434
    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 1435
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2, v0}, Lcom/aio/downloader/service/ServiceUpdate;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1436
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_5
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "status_bar_download_install"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1437
    const-string v2, "installsuccess_click"

    invoke-static {p1, v2}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1438
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 1439
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$3;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->appidinstall:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$25(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 1440
    .local v1, "intent_install":Landroid/content/Intent;
    invoke-virtual {v1, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 1441
    invoke-virtual {p1, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0
.end method
