.class Lcom/aio/downloader/service/ServiceCleaner$1$7;
.super Ljava/lang/Object;
.source "ServiceCleaner.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceCleaner$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/service/ServiceCleaner$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceCleaner$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    .line 541
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceCleaner$1$7;)Lcom/aio/downloader/service/ServiceCleaner$1;
    .locals 1

    .prologue
    .line 541
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const-wide/32 v4, 0x4e87bd

    .line 547
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceCleaner;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "interpolate_click"

    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 549
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner;->access$3(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 550
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceCleaner;->access$3(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceCleaner;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    .line 551
    new-instance v1, Landroid/content/Intent;

    .line 552
    const-string v2, "android.intent.action.VIEW"

    .line 551
    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 554
    .local v1, "intent":Landroid/content/Intent;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 555
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceCleaner;->access$3(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 554
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 556
    const-string v3, "application/vnd.android.package-archive"

    .line 553
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 557
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 558
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/aio/downloader/service/ServiceCleaner;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 612
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$0(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/dialog/NeituiDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/NeituiDialog;->dismiss()V

    .line 613
    return-void

    .line 559
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner;->access$4(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v2

    .line 560
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 561
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceCleaner;->access$4(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceCleaner;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_1

    .line 563
    new-instance v2, Lcom/aio/downloader/service/ServiceCleaner$1$7$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/service/ServiceCleaner$1$7$1;-><init>(Lcom/aio/downloader/service/ServiceCleaner$1$7;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    .line 596
    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceCleaner$1$7$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 607
    :catch_0
    move-exception v0

    .line 610
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 599
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_2
    new-instance v1, Landroid/content/Intent;

    .line 600
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceCleaner;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 601
    const-class v3, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 599
    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 602
    .restart local v1    # "intent":Landroid/content/Intent;
    const-string v2, "myid"

    .line 603
    const-string v3, "com.allinone.callerid"

    .line 602
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 604
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 605
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$7;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/aio/downloader/service/ServiceCleaner;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0
.end method
