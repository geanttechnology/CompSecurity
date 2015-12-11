.class Lcom/aio/downloader/service/ServiceUpdate$4;
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
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    .line 1457
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 60
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 1461
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    .line 1463
    .local v6, "action":Ljava/lang/String;
    new-instance v52, Landroid/text/format/Time;

    invoke-direct/range {v52 .. v52}, Landroid/text/format/Time;-><init>()V

    .line 1464
    .local v52, "t":Landroid/text/format/Time;
    invoke-virtual/range {v52 .. v52}, Landroid/text/format/Time;->setToNow()V

    .line 1465
    move-object/from16 v0, v52

    iget v0, v0, Landroid/text/format/Time;->year:I

    move/from16 v56, v0

    .line 1466
    .local v56, "year":I
    move-object/from16 v0, v52

    iget v0, v0, Landroid/text/format/Time;->month:I

    move/from16 v28, v0

    .line 1467
    .local v28, "month":I
    move-object/from16 v0, v52

    iget v15, v0, Landroid/text/format/Time;->monthDay:I

    .line 1468
    .local v15, "date":I
    move-object/from16 v0, v52

    iget v0, v0, Landroid/text/format/Time;->hour:I

    move/from16 v17, v0

    .line 1469
    .local v17, "hour":I
    move-object/from16 v0, v52

    iget v0, v0, Landroid/text/format/Time;->minute:I

    move/from16 v27, v0

    .line 1470
    .local v27, "minute":I
    move-object/from16 v0, v52

    iget v0, v0, Landroid/text/format/Time;->second:I

    move/from16 v48, v0

    .line 1471
    .local v48, "second":I
    const-string v57, "caobi"

    new-instance v58, Ljava/lang/StringBuilder;

    const-string v59, "hour="

    invoke-direct/range {v58 .. v59}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v58

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v58

    const-string v59, "minute="

    invoke-virtual/range {v58 .. v59}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v58

    move-object/from16 v0, v58

    move/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v58

    const-string v59, "second="

    invoke-virtual/range {v58 .. v59}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v58

    .line 1472
    move-object/from16 v0, v58

    move/from16 v1, v48

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v58

    invoke-virtual/range {v58 .. v58}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v58

    .line 1471
    invoke-static/range {v57 .. v58}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1474
    const-string v57, "\u53d1\u9001\u5347\u7ea7\u5e7f\u64ad"

    move-object/from16 v0, v57

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v57

    if-eqz v57, :cond_1

    .line 1479
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    .line 1480
    const-string v58, "app_update"

    const/16 v59, 0x0

    .line 1479
    invoke-virtual/range {v57 .. v59}, Lcom/aio/downloader/service/ServiceUpdate;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v55

    .line 1481
    .local v55, "userInfo_change":Landroid/content/SharedPreferences;
    const-string v57, "wycupdate"

    const/16 v58, 0x0

    move-object/from16 v0, v55

    move-object/from16 v1, v57

    move/from16 v2, v58

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v51

    .line 1483
    .local v51, "show_chage":I
    const/16 v57, 0xe

    move/from16 v0, v17

    move/from16 v1, v57

    if-ne v0, v1, :cond_0

    if-nez v27, :cond_0

    if-nez v51, :cond_0

    .line 1484
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "appid"

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    iput-object v0, v1, Lcom/aio/downloader/service/ServiceUpdate;->appid:Ljava/lang/String;

    .line 1485
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "appurl"

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$26(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1486
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "appvirsion"

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$27(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1488
    new-instance v8, Lcom/aio/downloader/utils/MyAppInfo;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    move-object/from16 v0, v57

    invoke-direct {v8, v0}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 1490
    .local v8, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->appid:Ljava/lang/String;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    invoke-virtual {v8, v0}, Lcom/aio/downloader/utils/MyAppInfo;->getAppName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    iput-object v0, v1, Lcom/aio/downloader/service/ServiceUpdate;->appName:Ljava/lang/String;

    .line 1491
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->appid:Ljava/lang/String;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    invoke-virtual {v8, v0}, Lcom/aio/downloader/utils/MyAppInfo;->getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v58

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    iput-object v0, v1, Lcom/aio/downloader/service/ServiceUpdate;->appIcon:Landroid/graphics/drawable/Drawable;

    .line 1492
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->appid:Ljava/lang/String;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    invoke-virtual {v8, v0}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    iput-object v0, v1, Lcom/aio/downloader/service/ServiceUpdate;->appVersion:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1498
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    const-string v58, "update_not"

    invoke-static/range {v57 .. v58}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1502
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v59, "notification"

    move-object/from16 v0, v57

    move-object/from16 v1, v59

    invoke-virtual {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v57

    check-cast v57, Landroid/app/NotificationManager;

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    invoke-static {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->access$28(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V

    .line 1503
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    new-instance v58, Landroid/app/Notification;

    invoke-direct/range {v58 .. v58}, Landroid/app/Notification;-><init>()V

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$29(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/Notification;)V

    .line 1504
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_ram:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$30(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    const/16 v58, 0x10

    move/from16 v0, v58

    move-object/from16 v1, v57

    iput v0, v1, Landroid/app/Notification;->flags:I

    .line 1505
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_ram:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$30(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    const v58, 0x7f0201ab

    move/from16 v0, v58

    move-object/from16 v1, v57

    iput v0, v1, Landroid/app/Notification;->icon:I

    .line 1507
    new-instance v7, Landroid/content/Intent;

    .line 1508
    const-string v57, "update"

    .line 1507
    move-object/from16 v0, v57

    invoke-direct {v7, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1515
    .local v7, "aio_intent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    const/16 v58, 0x0

    const/16 v59, 0x0

    .line 1514
    move-object/from16 v0, v57

    move/from16 v1, v58

    move/from16 v2, v59

    invoke-static {v0, v1, v7, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v42

    .line 1516
    .local v42, "pendingIntent2":Landroid/app/PendingIntent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_ram:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$30(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    move-object/from16 v0, v42

    move-object/from16 v1, v57

    iput-object v0, v1, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 1517
    new-instance v45, Landroid/widget/RemoteViews;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    .line 1518
    invoke-virtual/range {v57 .. v57}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v57

    const v58, 0x7f030086

    .line 1517
    move-object/from16 v0, v45

    move-object/from16 v1, v57

    move/from16 v2, v58

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 1520
    .local v45, "rv2":Landroid/widget/RemoteViews;
    const v57, 0x7f07031d

    .line 1521
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->appIcon:Landroid/graphics/drawable/Drawable;

    move-object/from16 v58, v0

    invoke-static/range {v58 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1520
    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1522
    const v57, 0x7f07031e

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->appName:Ljava/lang/String;

    move-object/from16 v58, v0

    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1523
    const v57, 0x7f070320

    new-instance v58, Ljava/lang/StringBuilder;

    const-string v59, "v"

    invoke-direct/range {v58 .. v59}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1524
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v59, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->appversion2:Ljava/lang/String;
    invoke-static/range {v59 .. v59}, Lcom/aio/downloader/service/ServiceUpdate;->access$23(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v59

    invoke-virtual/range {v58 .. v59}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v58

    invoke-virtual/range {v58 .. v58}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v58

    .line 1523
    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1525
    const v57, 0x7f07031f

    new-instance v58, Ljava/lang/StringBuilder;

    const-string v59, "v"

    invoke-direct/range {v58 .. v59}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1526
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v59, v0

    move-object/from16 v0, v59

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->appVersion:Ljava/lang/String;

    move-object/from16 v59, v0

    invoke-virtual/range {v58 .. v59}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v58

    invoke-virtual/range {v58 .. v58}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v58

    .line 1525
    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1527
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_ram:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$30(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    move-object/from16 v0, v45

    move-object/from16 v1, v57

    iput-object v0, v1, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 1528
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager1:Landroid/app/NotificationManager;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$31(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;

    move-result-object v57

    const/16 v58, 0x291

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v59, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_ram:Landroid/app/Notification;
    invoke-static/range {v59 .. v59}, Lcom/aio/downloader/service/ServiceUpdate;->access$30(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v59

    invoke-virtual/range {v57 .. v59}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 1901
    .end local v7    # "aio_intent":Landroid/content/Intent;
    .end local v8    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v42    # "pendingIntent2":Landroid/app/PendingIntent;
    .end local v45    # "rv2":Landroid/widget/RemoteViews;
    .end local v51    # "show_chage":I
    .end local v55    # "userInfo_change":Landroid/content/SharedPreferences;
    :cond_0
    :goto_1
    return-void

    .line 1493
    .restart local v8    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .restart local v51    # "show_chage":I
    .restart local v55    # "userInfo_change":Landroid/content/SharedPreferences;
    :catch_0
    move-exception v16

    .line 1495
    .local v16, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual/range {v16 .. v16}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 1531
    .end local v8    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v16    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v51    # "show_chage":I
    .end local v55    # "userInfo_change":Landroid/content/SharedPreferences;
    :cond_1
    const-string v57, "setbroadUpdate"

    move-object/from16 v0, v57

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v57

    if-nez v57, :cond_0

    .line 1533
    const-string v57, "meiri"

    move-object/from16 v0, v57

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v57

    if-eqz v57, :cond_2

    .line 1534
    const-string v57, "icon_pick1"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 1535
    .local v25, "icon_pick1":Ljava/lang/String;
    const-string v57, "title_pick1"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v54

    .line 1536
    .local v54, "title_pick1":Ljava/lang/String;
    const-string v57, "short_desc1"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v50

    .line 1537
    .local v50, "short_desc1":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "id_meiri"

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$9(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1539
    const/16 v57, 0xa

    move/from16 v0, v17

    move/from16 v1, v57

    if-ne v0, v1, :cond_0

    if-nez v27, :cond_0

    .line 1541
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v59, "notification"

    move-object/from16 v0, v57

    move-object/from16 v1, v59

    invoke-virtual {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v57

    check-cast v57, Landroid/app/NotificationManager;

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    invoke-static {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->access$32(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V

    .line 1542
    new-instance v29, Landroid/app/Notification;

    invoke-direct/range {v29 .. v29}, Landroid/app/Notification;-><init>()V

    .line 1543
    .local v29, "notification2":Landroid/app/Notification;
    const/16 v57, 0x10

    move/from16 v0, v57

    move-object/from16 v1, v29

    iput v0, v1, Landroid/app/Notification;->flags:I

    .line 1544
    const v57, 0x7f0201aa

    move/from16 v0, v57

    move-object/from16 v1, v29

    iput v0, v1, Landroid/app/Notification;->icon:I

    .line 1545
    new-instance v3, Landroid/content/Intent;

    const-string v57, "pick"

    move-object/from16 v0, v57

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1547
    .local v3, "aa":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    const/16 v58, 0x0

    const/16 v59, 0x0

    move-object/from16 v0, v57

    move/from16 v1, v58

    move/from16 v2, v59

    invoke-static {v0, v1, v3, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v42

    .line 1548
    .restart local v42    # "pendingIntent2":Landroid/app/PendingIntent;
    move-object/from16 v0, v42

    move-object/from16 v1, v29

    iput-object v0, v1, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 1549
    new-instance v45, Landroid/widget/RemoteViews;

    .line 1550
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    invoke-virtual/range {v57 .. v57}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v57

    .line 1551
    const v58, 0x7f030098

    .line 1549
    move-object/from16 v0, v45

    move-object/from16 v1, v57

    move/from16 v2, v58

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 1552
    .restart local v45    # "rv2":Landroid/widget/RemoteViews;
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1553
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1554
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1555
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1556
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1557
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1558
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1559
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1560
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1561
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1562
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1563
    invoke-static/range {v25 .. v25}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1552
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v39

    .line 1564
    .local v39, "path_pick":Ljava/lang/String;
    const v57, 0x7f070351

    .line 1565
    invoke-static/range {v39 .. v39}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1564
    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1566
    const v57, 0x7f070352

    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v54

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1567
    const v57, 0x7f070353

    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v50

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1568
    move-object/from16 v0, v45

    move-object/from16 v1, v29

    iput-object v0, v1, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 1569
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager8:Landroid/app/NotificationManager;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$33(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;

    move-result-object v57

    const/16 v58, 0x13

    move-object/from16 v0, v57

    move/from16 v1, v58

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_1

    .line 1571
    .end local v3    # "aa":Landroid/content/Intent;
    .end local v29    # "notification2":Landroid/app/Notification;
    .end local v39    # "path_pick":Ljava/lang/String;
    .end local v42    # "pendingIntent2":Landroid/app/PendingIntent;
    .end local v45    # "rv2":Landroid/widget/RemoteViews;
    :catch_1
    move-exception v57

    goto/16 :goto_1

    .line 1576
    .end local v25    # "icon_pick1":Ljava/lang/String;
    .end local v50    # "short_desc1":Ljava/lang/String;
    .end local v54    # "title_pick1":Ljava/lang/String;
    :cond_2
    const-string v57, "meiribig"

    move-object/from16 v0, v57

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v57

    if-eqz v57, :cond_4

    .line 1577
    const-string v57, "short_desc"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v49

    .line 1578
    .local v49, "short_desc":Ljava/lang/String;
    const-string v57, "title_pick"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v53

    .line 1579
    .local v53, "title_pick":Ljava/lang/String;
    const-string v57, "img_pick"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    .line 1580
    .local v26, "img_pick":Ljava/lang/String;
    const-string v57, "icon_pick"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 1581
    .local v24, "icon_pick":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "id_meiribig"

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$5(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1583
    const/16 v57, 0x16

    move/from16 v0, v17

    move/from16 v1, v57

    if-ne v0, v1, :cond_0

    if-nez v27, :cond_0

    .line 1585
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    .line 1586
    const-string v58, "pick_big"

    .line 1585
    invoke-static/range {v57 .. v58}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1587
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v59, "notification"

    move-object/from16 v0, v57

    move-object/from16 v1, v59

    invoke-virtual {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v57

    check-cast v57, Landroid/app/NotificationManager;

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    invoke-static {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->access$34(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V

    .line 1588
    new-instance v5, Landroid/content/Intent;

    const-string v57, "pick_big"

    move-object/from16 v0, v57

    invoke-direct {v5, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1590
    .local v5, "aa4":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    const/16 v58, 0x0

    .line 1591
    const/16 v59, 0x0

    .line 1590
    move-object/from16 v0, v57

    move/from16 v1, v58

    move/from16 v2, v59

    invoke-static {v0, v1, v5, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v44

    .line 1592
    .local v44, "pendingIntent4":Landroid/app/PendingIntent;
    new-instance v57, Landroid/support/v4/app/NotificationCompat$Builder;

    .line 1593
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    invoke-virtual/range {v58 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v58

    .line 1592
    invoke-direct/range {v57 .. v58}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 1594
    const/16 v58, 0x1

    invoke-virtual/range {v57 .. v58}, Landroid/support/v4/app/NotificationCompat$Builder;->setAutoCancel(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v57

    .line 1596
    move-object/from16 v0, v57

    move-object/from16 v1, v49

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v57

    .line 1597
    move-object/from16 v0, v57

    move-object/from16 v1, v53

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v57

    .line 1599
    const/16 v58, 0x4

    invoke-virtual/range {v57 .. v58}, Landroid/support/v4/app/NotificationCompat$Builder;->setDefaults(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v57

    .line 1604
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    invoke-virtual/range {v58 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->getResources()Landroid/content/res/Resources;

    move-result-object v58

    .line 1605
    const v59, 0x7f0200eb

    .line 1604
    invoke-static/range {v58 .. v59}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1602
    invoke-virtual/range {v57 .. v58}, Landroid/support/v4/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v57

    .line 1606
    const/16 v58, 0x0

    invoke-virtual/range {v57 .. v58}, Landroid/support/v4/app/NotificationCompat$Builder;->setOngoing(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v57

    .line 1613
    move-object/from16 v0, v57

    move-object/from16 v1, v53

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v57

    .line 1614
    const/16 v58, 0x2

    invoke-virtual/range {v57 .. v58}, Landroid/support/v4/app/NotificationCompat$Builder;->setPriority(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v57

    .line 1615
    const v58, 0x7f0200eb

    const/16 v59, 0x0

    invoke-virtual/range {v57 .. v59}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(II)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v14

    .line 1616
    .local v14, "builder":Landroid/support/v4/app/NotificationCompat$Builder;
    new-instance v13, Landroid/support/v4/app/NotificationCompat$BigPictureStyle;

    invoke-direct {v13}, Landroid/support/v4/app/NotificationCompat$BigPictureStyle;-><init>()V

    .line 1618
    .local v13, "bigPicture":Landroid/support/v4/app/NotificationCompat$BigPictureStyle;
    invoke-virtual {v14, v13}, Landroid/support/v4/app/NotificationCompat$Builder;->setStyle(Landroid/support/v4/app/NotificationCompat$Style;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 1619
    invoke-virtual {v14}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v31

    .line 1620
    .local v31, "notification4":Landroid/app/Notification;
    const/16 v57, 0x10

    move/from16 v0, v57

    move-object/from16 v1, v31

    iput v0, v1, Landroid/app/Notification;->flags:I

    .line 1621
    const v57, 0x7f0201aa

    move/from16 v0, v57

    move-object/from16 v1, v31

    iput v0, v1, Landroid/app/Notification;->icon:I

    .line 1623
    move-object/from16 v0, v44

    move-object/from16 v1, v31

    iput-object v0, v1, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 1624
    new-instance v47, Landroid/widget/RemoteViews;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplication()Landroid/app/Application;

    move-result-object v57

    .line 1625
    invoke-virtual/range {v57 .. v57}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v57

    const v58, 0x7f030099

    .line 1624
    move-object/from16 v0, v47

    move-object/from16 v1, v57

    move/from16 v2, v58

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 1626
    .local v47, "rv4":Landroid/widget/RemoteViews;
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1627
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1628
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1629
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1630
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1631
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1632
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1633
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1634
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1635
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1636
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1637
    invoke-static/range {v26 .. v26}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1626
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v41

    .line 1638
    .local v41, "path_pick_big":Ljava/lang/String;
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1639
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1640
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1641
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1642
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1643
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1644
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1645
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1646
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1647
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1648
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1649
    invoke-static/range {v24 .. v24}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1638
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v40

    .line 1650
    .local v40, "path_pick1":Ljava/lang/String;
    const v57, 0x7f070358

    .line 1651
    invoke-static/range {v41 .. v41}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1650
    move-object/from16 v0, v47

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1652
    const v57, 0x7f070354

    .line 1653
    invoke-static/range {v40 .. v40}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1652
    move-object/from16 v0, v47

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1654
    const v57, 0x7f070355

    move-object/from16 v0, v47

    move/from16 v1, v57

    move-object/from16 v2, v53

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1655
    const v57, 0x7f070357

    move-object/from16 v0, v47

    move/from16 v1, v57

    move-object/from16 v2, v49

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1657
    sget v57, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v58, 0x10

    move/from16 v0, v57

    move/from16 v1, v58

    if-lt v0, v1, :cond_3

    .line 1658
    move-object/from16 v0, v47

    move-object/from16 v1, v31

    iput-object v0, v1, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    .line 1663
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager9:Landroid/app/NotificationManager;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$35(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;

    move-result-object v57

    const/16 v58, 0x7cf

    move-object/from16 v0, v57

    move/from16 v1, v58

    move-object/from16 v2, v31

    invoke-virtual {v0, v1, v2}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    goto/16 :goto_1

    .line 1664
    .end local v5    # "aa4":Landroid/content/Intent;
    .end local v13    # "bigPicture":Landroid/support/v4/app/NotificationCompat$BigPictureStyle;
    .end local v14    # "builder":Landroid/support/v4/app/NotificationCompat$Builder;
    .end local v31    # "notification4":Landroid/app/Notification;
    .end local v40    # "path_pick1":Ljava/lang/String;
    .end local v41    # "path_pick_big":Ljava/lang/String;
    .end local v44    # "pendingIntent4":Landroid/app/PendingIntent;
    .end local v47    # "rv4":Landroid/widget/RemoteViews;
    :catch_2
    move-exception v57

    goto/16 :goto_1

    .line 1661
    .restart local v5    # "aa4":Landroid/content/Intent;
    .restart local v13    # "bigPicture":Landroid/support/v4/app/NotificationCompat$BigPictureStyle;
    .restart local v14    # "builder":Landroid/support/v4/app/NotificationCompat$Builder;
    .restart local v31    # "notification4":Landroid/app/Notification;
    .restart local v40    # "path_pick1":Ljava/lang/String;
    .restart local v41    # "path_pick_big":Ljava/lang/String;
    .restart local v44    # "pendingIntent4":Landroid/app/PendingIntent;
    .restart local v47    # "rv4":Landroid/widget/RemoteViews;
    :cond_3
    move-object/from16 v0, v47

    move-object/from16 v1, v31

    iput-object v0, v1, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_2

    .line 1669
    .end local v5    # "aa4":Landroid/content/Intent;
    .end local v13    # "bigPicture":Landroid/support/v4/app/NotificationCompat$BigPictureStyle;
    .end local v14    # "builder":Landroid/support/v4/app/NotificationCompat$Builder;
    .end local v24    # "icon_pick":Ljava/lang/String;
    .end local v26    # "img_pick":Ljava/lang/String;
    .end local v31    # "notification4":Landroid/app/Notification;
    .end local v40    # "path_pick1":Ljava/lang/String;
    .end local v41    # "path_pick_big":Ljava/lang/String;
    .end local v44    # "pendingIntent4":Landroid/app/PendingIntent;
    .end local v47    # "rv4":Landroid/widget/RemoteViews;
    .end local v49    # "short_desc":Ljava/lang/String;
    .end local v53    # "title_pick":Ljava/lang/String;
    :cond_4
    const-string v57, "paidppp"

    move-object/from16 v0, v57

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v57

    if-eqz v57, :cond_5

    .line 1670
    const-string v57, "icon0"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 1671
    .local v18, "icon0":Ljava/lang/String;
    const-string v57, "icon1"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 1672
    .local v19, "icon1":Ljava/lang/String;
    const-string v57, "icon2"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    .line 1673
    .local v20, "icon2":Ljava/lang/String;
    const-string v57, "icon3"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 1674
    .local v21, "icon3":Ljava/lang/String;
    const-string v57, "icon4"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 1675
    .local v22, "icon4":Ljava/lang/String;
    const-string v57, "icon5"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 1677
    .local v23, "icon5":Ljava/lang/String;
    const/16 v57, 0x12

    move/from16 v0, v17

    move/from16 v1, v57

    if-ne v0, v1, :cond_0

    if-nez v27, :cond_0

    .line 1679
    :try_start_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v59, "notification"

    move-object/from16 v0, v57

    move-object/from16 v1, v59

    invoke-virtual {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v57

    check-cast v57, Landroid/app/NotificationManager;

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    invoke-static {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->access$36(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V

    .line 1680
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    const-string v58, "paid"

    invoke-static/range {v57 .. v58}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1681
    new-instance v30, Landroid/app/Notification;

    invoke-direct/range {v30 .. v30}, Landroid/app/Notification;-><init>()V

    .line 1682
    .local v30, "notification3":Landroid/app/Notification;
    const/16 v57, 0x10

    move/from16 v0, v57

    move-object/from16 v1, v30

    iput v0, v1, Landroid/app/Notification;->flags:I

    .line 1683
    const v57, 0x7f0200ec

    move/from16 v0, v57

    move-object/from16 v1, v30

    iput v0, v1, Landroid/app/Notification;->icon:I

    .line 1684
    new-instance v4, Landroid/content/Intent;

    const-string v57, "paid"

    move-object/from16 v0, v57

    invoke-direct {v4, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1687
    .local v4, "aa1":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    const/16 v58, 0x0

    .line 1688
    const/16 v59, 0x0

    .line 1687
    move-object/from16 v0, v57

    move/from16 v1, v58

    move/from16 v2, v59

    invoke-static {v0, v1, v4, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v43

    .line 1689
    .local v43, "pendingIntent21":Landroid/app/PendingIntent;
    move-object/from16 v0, v43

    move-object/from16 v1, v30

    iput-object v0, v1, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 1690
    new-instance v46, Landroid/widget/RemoteViews;

    .line 1691
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    invoke-virtual/range {v57 .. v57}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v57

    .line 1692
    const v58, 0x7f030093

    .line 1690
    move-object/from16 v0, v46

    move-object/from16 v1, v57

    move/from16 v2, v58

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 1693
    .local v46, "rv21":Landroid/widget/RemoteViews;
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1694
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1695
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1696
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1697
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1698
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1699
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1700
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1701
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1702
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1703
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1704
    invoke-static/range {v18 .. v18}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1693
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    .line 1705
    .local v32, "path0":Ljava/lang/String;
    const v57, 0x7f070337

    .line 1706
    invoke-static/range {v32 .. v32}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1705
    move-object/from16 v0, v46

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1708
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1709
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1710
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1711
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1712
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1713
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1714
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1715
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1716
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1717
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1718
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1719
    invoke-static/range {v19 .. v19}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1708
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    .line 1720
    .local v33, "path1":Ljava/lang/String;
    const v57, 0x7f070339

    .line 1721
    invoke-static/range {v33 .. v33}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1720
    move-object/from16 v0, v46

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1723
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1724
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1725
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1726
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1727
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1728
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1729
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1730
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1731
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1732
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1733
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1734
    invoke-static/range {v20 .. v20}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1723
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v34

    .line 1735
    .local v34, "path2":Ljava/lang/String;
    const v57, 0x7f07033b

    .line 1736
    invoke-static/range {v34 .. v34}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1735
    move-object/from16 v0, v46

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1738
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1739
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1740
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1741
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1742
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1743
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1744
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1745
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1746
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1747
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1748
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1749
    invoke-static/range {v21 .. v21}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1738
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    .line 1750
    .local v35, "path3":Ljava/lang/String;
    const v57, 0x7f07033d

    .line 1751
    invoke-static/range {v35 .. v35}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1750
    move-object/from16 v0, v46

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1753
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1754
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1755
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1756
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1757
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1758
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1759
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1760
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1761
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1762
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1763
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1764
    invoke-static/range {v22 .. v22}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1753
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    .line 1765
    .local v36, "path4":Ljava/lang/String;
    const v57, 0x7f07033f

    .line 1766
    invoke-static/range {v36 .. v36}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1765
    move-object/from16 v0, v46

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1768
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1769
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1770
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1771
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1772
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1773
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1774
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1775
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1776
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1777
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1778
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1779
    invoke-static/range {v23 .. v23}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1768
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v37

    .line 1780
    .local v37, "path5":Ljava/lang/String;
    const v57, 0x7f070341

    .line 1781
    invoke-static/range {v37 .. v37}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1780
    move-object/from16 v0, v46

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1783
    move-object/from16 v0, v46

    move-object/from16 v1, v30

    iput-object v0, v1, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 1784
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager2:Landroid/app/NotificationManager;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$37(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;

    move-result-object v57

    const/16 v58, 0x36

    move-object/from16 v0, v57

    move/from16 v1, v58

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    goto/16 :goto_1

    .line 1785
    .end local v4    # "aa1":Landroid/content/Intent;
    .end local v30    # "notification3":Landroid/app/Notification;
    .end local v32    # "path0":Ljava/lang/String;
    .end local v33    # "path1":Ljava/lang/String;
    .end local v34    # "path2":Ljava/lang/String;
    .end local v35    # "path3":Ljava/lang/String;
    .end local v36    # "path4":Ljava/lang/String;
    .end local v37    # "path5":Ljava/lang/String;
    .end local v43    # "pendingIntent21":Landroid/app/PendingIntent;
    .end local v46    # "rv21":Landroid/widget/RemoteViews;
    :catch_3
    move-exception v57

    goto/16 :goto_1

    .line 1790
    .end local v18    # "icon0":Ljava/lang/String;
    .end local v19    # "icon1":Ljava/lang/String;
    .end local v20    # "icon2":Ljava/lang/String;
    .end local v21    # "icon3":Ljava/lang/String;
    .end local v22    # "icon4":Ljava/lang/String;
    .end local v23    # "icon5":Ljava/lang/String;
    :cond_5
    const-string v57, "downloadsuccess"

    move-object/from16 v0, v57

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v57

    if-eqz v57, :cond_8

    .line 1792
    const-string v57, "appname"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 1793
    .local v12, "appname_down":Ljava/lang/String;
    const-string v57, "headimage"

    move-object/from16 v0, p2

    move-object/from16 v1, v57

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 1794
    .local v11, "appimage_down":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "baoming"

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$38(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1795
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "serial"

    const/16 v59, 0x1

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    move/from16 v2, v59

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v58

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$39(Lcom/aio/downloader/service/ServiceUpdate;I)V

    .line 1796
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "filepathdown"

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$40(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1808
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->serial:I
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$41(Lcom/aio/downloader/service/ServiceUpdate;)I

    move-result v57

    const/16 v58, 0x6e

    move/from16 v0, v57

    move/from16 v1, v58

    if-ne v0, v1, :cond_6

    .line 1809
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "iddown"

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$42(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1811
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "notification"

    invoke-virtual/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v57

    check-cast v57, Landroid/app/NotificationManager;

    sput-object v57, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager3:Landroid/app/NotificationManager;

    .line 1813
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    new-instance v58, Landroid/app/Notification;

    invoke-direct/range {v58 .. v58}, Landroid/app/Notification;-><init>()V

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$43(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/Notification;)V

    .line 1814
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_down:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$44(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    const/16 v58, 0x10

    move/from16 v0, v58

    move-object/from16 v1, v57

    iput v0, v1, Landroid/app/Notification;->flags:I

    .line 1815
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_down:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$44(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    const v58, 0x7f0201a8

    move/from16 v0, v58

    move-object/from16 v1, v57

    iput v0, v1, Landroid/app/Notification;->icon:I

    .line 1817
    new-instance v7, Landroid/content/Intent;

    const-string v57, "status_bar_download_success"

    move-object/from16 v0, v57

    invoke-direct {v7, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1824
    .restart local v7    # "aio_intent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    const/16 v58, 0x0

    const/16 v59, 0x0

    .line 1823
    move-object/from16 v0, v57

    move/from16 v1, v58

    move/from16 v2, v59

    invoke-static {v0, v1, v7, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v42

    .line 1825
    .restart local v42    # "pendingIntent2":Landroid/app/PendingIntent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_down:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$44(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    move-object/from16 v0, v42

    move-object/from16 v1, v57

    iput-object v0, v1, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 1826
    new-instance v45, Landroid/widget/RemoteViews;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    .line 1827
    invoke-virtual/range {v57 .. v57}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v57

    const v58, 0x7f03008b

    .line 1826
    move-object/from16 v0, v45

    move-object/from16 v1, v57

    move/from16 v2, v58

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 1828
    .restart local v45    # "rv2":Landroid/widget/RemoteViews;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->serial:I
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$41(Lcom/aio/downloader/service/ServiceUpdate;)I

    move-result v57

    const/16 v58, 0x6e

    move/from16 v0, v57

    move/from16 v1, v58

    if-ne v0, v1, :cond_7

    .line 1829
    new-instance v9, Lcom/aio/downloader/utils/MyAppInfo;

    .line 1830
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    .line 1829
    move-object/from16 v0, v57

    invoke-direct {v9, v0}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 1832
    .local v9, "appInfo_down":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->iddown:Ljava/lang/String;
    invoke-static/range {v58 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$45(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v58

    move-object/from16 v0, v58

    invoke-virtual {v9, v0}, Lcom/aio/downloader/utils/MyAppInfo;->getAppName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    iput-object v0, v1, Lcom/aio/downloader/service/ServiceUpdate;->appNamedown:Ljava/lang/String;

    .line 1833
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->iddown:Ljava/lang/String;
    invoke-static/range {v58 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$45(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v58

    move-object/from16 v0, v58

    invoke-virtual {v9, v0}, Lcom/aio/downloader/utils/MyAppInfo;->getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v58

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    iput-object v0, v1, Lcom/aio/downloader/service/ServiceUpdate;->appIcondown:Landroid/graphics/drawable/Drawable;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 1838
    :goto_3
    const v57, 0x7f070325

    .line 1839
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->appIcondown:Landroid/graphics/drawable/Drawable;

    move-object/from16 v58, v0

    invoke-static/range {v58 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1838
    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1857
    .end local v9    # "appInfo_down":Lcom/aio/downloader/utils/MyAppInfo;
    :goto_4
    const v57, 0x7f070326

    move-object/from16 v0, v45

    move/from16 v1, v57

    invoke-virtual {v0, v1, v12}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1858
    const v57, 0x7f070327

    const-string v58, "Click to install"

    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1859
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_down:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$44(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    move-object/from16 v0, v45

    move-object/from16 v1, v57

    iput-object v0, v1, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 1860
    sget-object v57, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager3:Landroid/app/NotificationManager;

    const/16 v58, 0x334b

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v59, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_down:Landroid/app/Notification;
    invoke-static/range {v59 .. v59}, Lcom/aio/downloader/service/ServiceUpdate;->access$44(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v59

    invoke-virtual/range {v57 .. v59}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    goto/16 :goto_1

    .line 1834
    .restart local v9    # "appInfo_down":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_4
    move-exception v16

    .line 1836
    .restart local v16    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual/range {v16 .. v16}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 1841
    .end local v9    # "appInfo_down":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v16    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_7
    new-instance v57, Ljava/lang/StringBuilder;

    invoke-direct/range {v57 .. v57}, Ljava/lang/StringBuilder;-><init>()V

    .line 1842
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1843
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1844
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1845
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1846
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1847
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1848
    const-string v58, "com.ywh.imgcache"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1849
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1850
    const-string v58, "allicon"

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1851
    sget-object v58, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1852
    invoke-static {v11}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-virtual/range {v57 .. v58}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v57

    .line 1841
    invoke-virtual/range {v57 .. v57}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v38

    .line 1853
    .local v38, "path_down":Ljava/lang/String;
    const v57, 0x7f070325

    .line 1854
    invoke-static/range {v38 .. v38}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1853
    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    goto/16 :goto_4

    .line 1861
    .end local v7    # "aio_intent":Landroid/content/Intent;
    .end local v11    # "appimage_down":Ljava/lang/String;
    .end local v12    # "appname_down":Ljava/lang/String;
    .end local v38    # "path_down":Ljava/lang/String;
    .end local v42    # "pendingIntent2":Landroid/app/PendingIntent;
    .end local v45    # "rv2":Landroid/widget/RemoteViews;
    :cond_8
    const-string v57, "downloadinstall"

    move-object/from16 v0, v57

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v57

    if-eqz v57, :cond_0

    .line 1864
    :try_start_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v58, "appidinstall"

    move-object/from16 v0, p2

    move-object/from16 v1, v58

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$46(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 1865
    new-instance v10, Lcom/aio/downloader/utils/MyAppInfo;

    .line 1866
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    .line 1865
    move-object/from16 v0, v57

    invoke-direct {v10, v0}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5

    .line 1868
    .local v10, "appInfo_install":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    .line 1869
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->appidinstall:Ljava/lang/String;
    invoke-static/range {v58 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$25(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v58

    move-object/from16 v0, v58

    invoke-virtual {v10, v0}, Lcom/aio/downloader/utils/MyAppInfo;->getAppName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v58

    .line 1868
    move-object/from16 v0, v58

    move-object/from16 v1, v57

    iput-object v0, v1, Lcom/aio/downloader/service/ServiceUpdate;->appNameinstall:Ljava/lang/String;

    .line 1870
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    .line 1871
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->appidinstall:Ljava/lang/String;
    invoke-static/range {v58 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$25(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v58

    move-object/from16 v0, v58

    invoke-virtual {v10, v0}, Lcom/aio/downloader/utils/MyAppInfo;->getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v58

    .line 1870
    move-object/from16 v0, v58

    move-object/from16 v1, v57

    iput-object v0, v1, Lcom/aio/downloader/service/ServiceUpdate;->appIconinstall:Landroid/graphics/drawable/Drawable;
    :try_end_6
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_6 .. :try_end_6} :catch_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_5

    .line 1877
    :goto_5
    :try_start_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    const-string v59, "notification"

    move-object/from16 v0, v57

    move-object/from16 v1, v59

    invoke-virtual {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v57

    check-cast v57, Landroid/app/NotificationManager;

    move-object/from16 v0, v58

    move-object/from16 v1, v57

    invoke-static {v0, v1}, Lcom/aio/downloader/service/ServiceUpdate;->access$47(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V

    .line 1879
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    new-instance v58, Landroid/app/Notification;

    invoke-direct/range {v58 .. v58}, Landroid/app/Notification;-><init>()V

    invoke-static/range {v57 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->access$48(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/Notification;)V

    .line 1880
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_install:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$49(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    const/16 v58, 0x10

    move/from16 v0, v58

    move-object/from16 v1, v57

    iput v0, v1, Landroid/app/Notification;->flags:I

    .line 1881
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_install:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$49(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    const v58, 0x7f0201a9

    move/from16 v0, v58

    move-object/from16 v1, v57

    iput v0, v1, Landroid/app/Notification;->icon:I

    .line 1883
    new-instance v7, Landroid/content/Intent;

    const-string v57, "status_bar_download_install"

    move-object/from16 v0, v57

    invoke-direct {v7, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1885
    .restart local v7    # "aio_intent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    const/16 v58, 0x0

    const/16 v59, 0x0

    .line 1884
    move-object/from16 v0, v57

    move/from16 v1, v58

    move/from16 v2, v59

    invoke-static {v0, v1, v7, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v42

    .line 1886
    .restart local v42    # "pendingIntent2":Landroid/app/PendingIntent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_install:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$49(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    move-object/from16 v0, v42

    move-object/from16 v1, v57

    iput-object v0, v1, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 1887
    new-instance v45, Landroid/widget/RemoteViews;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    invoke-virtual/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v57

    .line 1888
    invoke-virtual/range {v57 .. v57}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v57

    const v58, 0x7f03008b

    .line 1887
    move-object/from16 v0, v45

    move-object/from16 v1, v57

    move/from16 v2, v58

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 1890
    .restart local v45    # "rv2":Landroid/widget/RemoteViews;
    const v57, 0x7f070325

    .line 1891
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->appIconinstall:Landroid/graphics/drawable/Drawable;

    move-object/from16 v58, v0

    invoke-static/range {v58 .. v58}, Lcom/aio/downloader/service/ServiceUpdate;->drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v58

    .line 1890
    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1892
    const v57, 0x7f070326

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v58, v0

    move-object/from16 v0, v58

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->appNameinstall:Ljava/lang/String;

    move-object/from16 v58, v0

    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1893
    const v57, 0x7f070327

    const-string v58, "Click to launch"

    move-object/from16 v0, v45

    move/from16 v1, v57

    move-object/from16 v2, v58

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1894
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_install:Landroid/app/Notification;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$49(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v57

    move-object/from16 v0, v45

    move-object/from16 v1, v57

    iput-object v0, v1, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 1895
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v57, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager4:Landroid/app/NotificationManager;
    invoke-static/range {v57 .. v57}, Lcom/aio/downloader/service/ServiceUpdate;->access$50(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;

    move-result-object v57

    const/16 v58, 0x373d

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$4;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v59, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->notification_install:Landroid/app/Notification;
    invoke-static/range {v59 .. v59}, Lcom/aio/downloader/service/ServiceUpdate;->access$49(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;

    move-result-object v59

    invoke-virtual/range {v57 .. v59}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    goto/16 :goto_1

    .line 1896
    .end local v7    # "aio_intent":Landroid/content/Intent;
    .end local v10    # "appInfo_install":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v42    # "pendingIntent2":Landroid/app/PendingIntent;
    .end local v45    # "rv2":Landroid/widget/RemoteViews;
    :catch_5
    move-exception v57

    goto/16 :goto_1

    .line 1872
    .restart local v10    # "appInfo_install":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_6
    move-exception v16

    .line 1874
    .restart local v16    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual/range {v16 .. v16}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_5

    goto/16 :goto_5
.end method
