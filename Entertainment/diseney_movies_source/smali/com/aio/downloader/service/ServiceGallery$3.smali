.class Lcom/aio/downloader/service/ServiceGallery$3;
.super Ljava/lang/Object;
.source "ServiceGallery.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceGallery;->onCreate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/ServiceGallery;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceGallery;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    .line 267
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceGallery$3;)Lcom/aio/downloader/service/ServiceGallery;
    .locals 1

    .prologue
    .line 267
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v8, 0x0

    const/high16 v7, 0x10000000

    .line 272
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 354
    :goto_0
    return-void

    .line 275
    :pswitch_0
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceGallery;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 276
    const-string v5, "first_install_cleaner_click"

    .line 275
    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 277
    new-instance v4, Lcom/aio/downloader/service/ServiceGallery$3$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/service/ServiceGallery$3$1;-><init>(Lcom/aio/downloader/service/ServiceGallery$3;)V

    .line 287
    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceGallery$3$1;->start()V

    .line 289
    const/4 v3, 0x0

    .line 291
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceGallery;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 292
    const-string v5, "com.evzapp.cleanmaster"

    const/4 v6, 0x0

    .line 291
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 296
    :goto_1
    if-nez v3, :cond_2

    .line 297
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceGallery;->access$4(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 298
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 300
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/service/ServiceGallery;->access$5(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 301
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 302
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 300
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 303
    const-string v5, "application/vnd.android.package-archive"

    .line 299
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 304
    invoke-virtual {v0, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 305
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/service/ServiceGallery;->startActivity(Landroid/content/Intent;)V

    .line 346
    .end local v0    # "aa":Landroid/content/Intent;
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceGallery;->access$0(Lcom/aio/downloader/service/ServiceGallery;)Lcom/aio/downloader/dialog/InstallfirstDialog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/InstallfirstDialog;->dismiss()V

    goto :goto_0

    .line 293
    :catch_0
    move-exception v1

    .line 294
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 306
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceGallery;->access$6(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 307
    new-instance v4, Lcom/aio/downloader/service/ServiceGallery$3$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/service/ServiceGallery$3$2;-><init>(Lcom/aio/downloader/service/ServiceGallery$3;)V

    new-array v5, v8, [Ljava/lang/Void;

    .line 331
    invoke-virtual {v4, v5}, Lcom/aio/downloader/service/ServiceGallery$3$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2

    .line 333
    :cond_1
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceGallery;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 334
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 333
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 335
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.evzapp.cleanmaster"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 336
    invoke-virtual {v2, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 337
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/service/ServiceGallery;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 340
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceGallery;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 342
    const-string v5, "com.evzapp.cleanmaster"

    .line 341
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 343
    .restart local v2    # "intent":Landroid/content/Intent;
    invoke-virtual {v2, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 344
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/service/ServiceGallery;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 349
    .end local v2    # "intent":Landroid/content/Intent;
    .end local v3    # "packageInfo":Landroid/content/pm/PackageInfo;
    :pswitch_1
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceGallery$3;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceGallery;->access$0(Lcom/aio/downloader/service/ServiceGallery;)Lcom/aio/downloader/dialog/InstallfirstDialog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/InstallfirstDialog;->dismiss()V

    goto/16 :goto_0

    .line 272
    :pswitch_data_0
    .packed-switch 0x7f07014c
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
