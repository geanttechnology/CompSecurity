.class Lcom/aio/downloader/service/ServiceCleaner$1$5;
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
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    .line 393
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceCleaner$1$5;)Lcom/aio/downloader/service/ServiceCleaner$1;
    .locals 1

    .prologue
    .line 393
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/high16 v4, 0x10000000

    .line 399
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceCleaner;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "interpolate_click"

    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 400
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner;->access$5(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 401
    new-instance v0, Landroid/content/Intent;

    .line 402
    const-string v2, "android.intent.action.VIEW"

    .line 401
    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 404
    .local v0, "aa":Landroid/content/Intent;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 405
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->PRO_DIR:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceCleaner;->access$6(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 406
    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 407
    const-string v3, "cleaner.apk"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 404
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 408
    const-string v3, "application/vnd.android.package-archive"

    .line 403
    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 409
    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 410
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/aio/downloader/service/ServiceCleaner;->startActivity(Landroid/content/Intent;)V

    .line 455
    .end local v0    # "aa":Landroid/content/Intent;
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$0(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/dialog/NeituiDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/NeituiDialog;->dismiss()V

    .line 456
    return-void

    .line 411
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner;->access$7(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 412
    new-instance v2, Lcom/aio/downloader/service/ServiceCleaner$1$5$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/service/ServiceCleaner$1$5$1;-><init>(Lcom/aio/downloader/service/ServiceCleaner$1$5;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    .line 445
    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceCleaner$1$5$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 447
    :cond_1
    new-instance v1, Landroid/content/Intent;

    .line 448
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceCleaner;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 449
    const-class v3, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 447
    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 450
    .local v1, "intent":Landroid/content/Intent;
    const-string v2, "myid"

    .line 451
    const-string v3, "com.evzapp.cleanmaster"

    .line 450
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 452
    invoke-virtual {v1, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 453
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$5;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/aio/downloader/service/ServiceCleaner;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method
