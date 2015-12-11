.class Lcom/aio/downloader/activity/AppDetailsActivity$27;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;->init()V
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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1405
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppDetailsActivity$27;)Lcom/aio/downloader/activity/AppDetailsActivity;
    .locals 1

    .prologue
    .line 1405
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 14
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 1409
    const-string v0, "logg"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "linkurl1="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->linkurl1:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$83(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "wocao="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wocao:I
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$17(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1411
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wocao:I
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$17(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v0

    if-nez v0, :cond_4

    .line 1412
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_apk()Ljava/lang/String;

    move-result-object v0

    const-string v1, "1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1415
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$27$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$27$1;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity$27;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 1432
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$27$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1434
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->spnetworkre:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$84(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "isopen"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1436
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1

    .line 1437
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # invokes: Lcom/aio/downloader/activity/AppDetailsActivity;->downwifi()V
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$85(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    .line 1534
    :cond_0
    :goto_0
    return-void

    .line 1442
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$26(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    .line 1444
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    .line 1445
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v4

    .line 1444
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 1446
    const-string v0, "bbb"

    .line 1447
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "+"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 1448
    const-string v2, "+"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 1447
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1446
    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1449
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->bt_dea_download:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$32(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/Button;

    move-result-object v0

    .line 1450
    const v1, 0x7f02006e

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundResource(I)V

    .line 1451
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->bt_dea_download:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$32(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/Button;

    move-result-object v0

    const-string v1, "Downloading"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 1463
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # invokes: Lcom/aio/downloader/activity/AppDetailsActivity;->Mydialog()V
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$16(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    goto/16 :goto_0

    .line 1467
    :cond_3
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_apk()Ljava/lang/String;

    move-result-object v0

    const-string v1, "0"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1470
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$27$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$27$2;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity$27;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 1484
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1485
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->bt_dea_download:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$32(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/Button;

    move-result-object v0

    .line 1486
    const v1, 0x7f02006e

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundResource(I)V

    .line 1490
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "https://play.google.com/store/apps/details?id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1491
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 1490
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v11

    .line 1492
    .local v11, "uri":Landroid/net/Uri;
    new-instance v8, Landroid/content/Intent;

    const-string v0, "android.intent.action.VIEW"

    invoke-direct {v8, v0, v11}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 1493
    .local v8, "intent":Landroid/content/Intent;
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v0, v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1497
    .end local v8    # "intent":Landroid/content/Intent;
    .end local v11    # "uri":Landroid/net/Uri;
    :cond_4
    const-string v12, "qqq"

    .line 1498
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "dbUtils.queryfile(wycmyid)="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1499
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$26(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 1500
    const-string v1, "========="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    .line 1501
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$10(Lcom/aio/downloader/activity/AppDetailsActivity;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    .line 1502
    const-string v1, "file_id"

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v2

    .line 1503
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1504
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 1501
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1504
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 1501
    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 1498
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1497
    invoke-static {v12, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1505
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$26(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_5

    .line 1506
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$10(Lcom/aio/downloader/activity/AppDetailsActivity;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const-string v1, "file_id"

    .line 1507
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1508
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 1506
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1508
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 1506
    if-nez v0, :cond_5

    .line 1509
    new-instance v6, Lcom/aio/downloader/utils/MyAppInfo;

    .line 1510
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 1509
    invoke-direct {v6, v0}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 1512
    .local v6, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Lcom/aio/downloader/utils/MyAppInfo;->getAppName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$28(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V

    .line 1513
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Lcom/aio/downloader/utils/MyAppInfo;->getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$29(Lcom/aio/downloader/activity/AppDetailsActivity;Landroid/graphics/drawable/Drawable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1519
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appName:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$19(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->myUpver:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$30(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x6e

    .line 1520
    iget-object v5, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appIcon2:Landroid/graphics/drawable/Drawable;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$31(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-static {v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 1519
    invoke-virtual/range {v0 .. v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->MydownloadApk_Update(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V

    .line 1521
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->bt_dea_download:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$32(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/Button;

    move-result-object v0

    .line 1522
    const v1, 0x7f02006e

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundResource(I)V

    .line 1523
    new-instance v9, Landroid/content/Intent;

    const-string v0, "setbroadUpdate"

    invoke-direct {v9, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1525
    .local v9, "mIntent":Landroid/content/Intent;
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v0, v9}, Lcom/aio/downloader/activity/AppDetailsActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1515
    .end local v9    # "mIntent":Landroid/content/Intent;
    :catch_0
    move-exception v7

    .line 1517
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 1528
    .end local v6    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v7    # "e":Ljava/lang/Exception;
    :cond_5
    new-instance v10, Landroid/os/Message;

    invoke-direct {v10}, Landroid/os/Message;-><init>()V

    .line 1529
    .local v10, "msg":Landroid/os/Message;
    const/4 v0, 0x2

    iput v0, v10, Landroid/os/Message;->what:I

    .line 1530
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$27;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v10}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_0
.end method
