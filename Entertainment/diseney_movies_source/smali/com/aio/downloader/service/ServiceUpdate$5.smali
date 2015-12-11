.class Lcom/aio/downloader/service/ServiceUpdate$5;
.super Ljava/lang/Object;
.source "ServiceUpdate.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceUpdate;->onCreate()V
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
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    .line 418
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceUpdate$5;)Lcom/aio/downloader/service/ServiceUpdate;
    .locals 1

    .prologue
    .line 418
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const-wide/32 v4, 0x4e87bd

    .line 423
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 487
    :goto_0
    :pswitch_0
    return-void

    .line 425
    :pswitch_1
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$21(Lcom/aio/downloader/service/ServiceUpdate;)Lcom/aio/downloader/dialog/CallerOutDialog1;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/CallerOutDialog1;->dismiss()V

    goto :goto_0

    .line 428
    :pswitch_2
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 429
    const-string v3, "simulate_call_click"

    .line 428
    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 432
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$52(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 433
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$52(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceUpdate;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    .line 434
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 436
    .local v1, "intent":Landroid/content/Intent;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$52(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 437
    const-string v3, "application/vnd.android.package-archive"

    .line 435
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 438
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 439
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 481
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_1
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$21(Lcom/aio/downloader/service/ServiceUpdate;)Lcom/aio/downloader/dialog/CallerOutDialog1;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/CallerOutDialog1;->dismiss()V

    goto :goto_0

    .line 440
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$53(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 441
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$53(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceUpdate;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_1

    .line 443
    new-instance v2, Lcom/aio/downloader/service/ServiceUpdate$5$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/service/ServiceUpdate$5$1;-><init>(Lcom/aio/downloader/service/ServiceUpdate$5;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    .line 468
    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceUpdate$5$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 477
    :catch_0
    move-exception v0

    .line 479
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 471
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_2
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 472
    const-class v3, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 471
    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 473
    .restart local v1    # "intent":Landroid/content/Intent;
    const-string v2, "myid"

    const-string v3, "com.allinone.callerid"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 474
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 475
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1

    .line 423
    nop

    :pswitch_data_0
    .packed-switch 0x7f070368
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
