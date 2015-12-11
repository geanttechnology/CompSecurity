.class Lcom/aio/downloader/activity/FunActivity1$6;
.super Ljava/lang/Object;
.source "FunActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunActivity1;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    .line 293
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FunActivity1$6;)Lcom/aio/downloader/activity/FunActivity1;
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 297
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 298
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 297
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 299
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$0(Lcom/aio/downloader/activity/FunActivity1;)Landroid/widget/ImageView;

    move-result-object v4

    const v5, 0x7f0200d7

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 300
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->isfbshow:Z
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$8(Lcom/aio/downloader/activity/FunActivity1;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 304
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4010000000000000L    # 4.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/FunActivity1;->access$9(Lcom/aio/downloader/activity/FunActivity1;I)V

    .line 305
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$10(Lcom/aio/downloader/activity/FunActivity1;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 308
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/FunActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 310
    const-string v6, "com.evzapp.cleanmaster"

    const/4 v7, 0x0

    .line 309
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 308
    iput-object v5, v4, Lcom/aio/downloader/activity/FunActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 314
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/FunActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_3

    .line 315
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$11(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 316
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 318
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$12(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 319
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 320
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 318
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 321
    const-string v5, "application/vnd.android.package-archive"

    .line 317
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 322
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 323
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V

    .line 546
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 311
    :catch_0
    move-exception v1

    .line 312
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 324
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$13(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 325
    new-instance v4, Lcom/aio/downloader/activity/FunActivity1$6$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FunActivity1$6$1;-><init>(Lcom/aio/downloader/activity/FunActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 351
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1$6$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 353
    :cond_2
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 354
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 353
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 355
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 356
    const-string v5, "com.evzapp.cleanmaster"

    .line 355
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 357
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 358
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 361
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 363
    const-string v5, "com.evzapp.cleanmaster"

    .line 362
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 364
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 365
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 367
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$10(Lcom/aio/downloader/activity/FunActivity1;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_8

    .line 369
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/FunActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 370
    const-string v6, "com.freepezzle.hexcrush"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 369
    iput-object v5, v4, Lcom/aio/downloader/activity/FunActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 374
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/FunActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_7

    .line 376
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$14(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 377
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$14(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_5

    .line 378
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 380
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$14(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 381
    const-string v5, "application/vnd.android.package-archive"

    .line 379
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 382
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 411
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 412
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 371
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 372
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 383
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$15(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 384
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$15(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 385
    new-instance v4, Lcom/aio/downloader/activity/FunActivity1$6$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FunActivity1$6$2;-><init>(Lcom/aio/downloader/activity/FunActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 403
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1$6$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 405
    :cond_6
    new-instance v0, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 406
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 405
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 407
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 408
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_1

    .line 415
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 417
    const-string v5, "com.freepezzle.hexcrush"

    .line 416
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 418
    .local v3, "intent5":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v3}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 422
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$10(Lcom/aio/downloader/activity/FunActivity1;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    .line 424
    :try_start_4
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/FunActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 425
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 424
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/FunActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 429
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/FunActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_b

    .line 431
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$16(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_9

    .line 432
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$16(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_9

    .line 433
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 435
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$16(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 436
    const-string v5, "application/vnd.android.package-archive"

    .line 434
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 437
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 438
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_1

    .line 474
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 476
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 426
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 427
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 439
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$17(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 440
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$17(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 442
    new-instance v4, Lcom/aio/downloader/activity/FunActivity1$6$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FunActivity1$6$3;-><init>(Lcom/aio/downloader/activity/FunActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 465
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1$6$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 468
    :cond_a
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 469
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 468
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 470
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.allinone.callerid"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 471
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 472
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_1

    .line 479
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 480
    const-string v5, "com.allinone.callerid"

    .line 479
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 481
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 482
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 484
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$10(Lcom/aio/downloader/activity/FunActivity1;)I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 486
    :try_start_7
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/FunActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 487
    const-string v6, "com.aioapp.battery"

    const/4 v7, 0x0

    .line 486
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/FunActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 491
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/FunActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_f

    .line 493
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$18(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 494
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$18(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_d

    .line 495
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 497
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$18(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 498
    const-string v5, "application/vnd.android.package-archive"

    .line 496
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 499
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 500
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 532
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 534
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 488
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 489
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 501
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunActivity1;->access$19(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 502
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    # getter for: Lcom/aio/downloader/activity/FunActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunActivity1;->access$19(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 503
    new-instance v4, Lcom/aio/downloader/activity/FunActivity1$6$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FunActivity1$6$4;-><init>(Lcom/aio/downloader/activity/FunActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 523
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FunActivity1$6$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 525
    :cond_e
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 526
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 525
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 527
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 529
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 530
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_1

    .line 537
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 538
    const-string v5, "com.aioapp.battery"

    .line 537
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 539
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 540
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1$6;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FunActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method
