.class Lcom/aio/downloader/activity/AppActivity1$6;
.super Ljava/lang/Object;
.source "AppActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppActivity1;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    .line 293
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppActivity1$6;)Lcom/aio/downloader/activity/AppActivity1;
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 297
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 298
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 297
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 299
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$0(Lcom/aio/downloader/activity/AppActivity1;)Landroid/widget/ImageView;

    move-result-object v4

    const v5, 0x7f0200d7

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 300
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->isfbshow:Z
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$8(Lcom/aio/downloader/activity/AppActivity1;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 304
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4008000000000000L    # 3.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/AppActivity1;->access$9(Lcom/aio/downloader/activity/AppActivity1;I)V

    .line 305
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$10(Lcom/aio/downloader/activity/AppActivity1;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 308
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/AppActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 309
    const-string v6, "com.evzapp.cleanmaster"

    const/4 v7, 0x0

    .line 308
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/AppActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 313
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/AppActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_3

    .line 314
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$11(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 315
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 317
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$12(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 318
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 319
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 317
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 320
    const-string v5, "application/vnd.android.package-archive"

    .line 316
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 321
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 322
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V

    .line 559
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 310
    :catch_0
    move-exception v1

    .line 311
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 323
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$13(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 324
    new-instance v4, Lcom/aio/downloader/activity/AppActivity1$6$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppActivity1$6$1;-><init>(Lcom/aio/downloader/activity/AppActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 348
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1$6$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 350
    :cond_2
    new-instance v2, Landroid/content/Intent;

    .line 351
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 352
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 350
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 353
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 354
    const-string v5, "com.evzapp.cleanmaster"

    .line 353
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 355
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 356
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 359
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 361
    const-string v5, "com.evzapp.cleanmaster"

    .line 360
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 362
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 363
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 365
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$10(Lcom/aio/downloader/activity/AppActivity1;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_8

    .line 367
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/AppActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 368
    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 369
    const-string v6, "com.freepezzle.hexcrush"

    const/4 v7, 0x0

    .line 368
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 367
    iput-object v5, v4, Lcom/aio/downloader/activity/AppActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 373
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/AppActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_7

    .line 375
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$14(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 376
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$14(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_5

    .line 377
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 379
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$14(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 380
    const-string v5, "application/vnd.android.package-archive"

    .line 378
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 381
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 415
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 416
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 370
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 371
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 382
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$15(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 383
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$15(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 384
    new-instance v4, Lcom/aio/downloader/activity/AppActivity1$6$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppActivity1$6$2;-><init>(Lcom/aio/downloader/activity/AppActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 405
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1$6$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 407
    :cond_6
    new-instance v0, Landroid/content/Intent;

    .line 408
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 409
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 407
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 410
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    .line 411
    const-string v5, "com.freepezzle.hexcrush"

    .line 410
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 412
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_1

    .line 419
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 421
    const-string v5, "com.freepezzle.hexcrush"

    .line 420
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 422
    .local v3, "intent5":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v3}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 425
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$10(Lcom/aio/downloader/activity/AppActivity1;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    .line 427
    :try_start_4
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/AppActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 428
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 427
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/AppActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 432
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/AppActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_b

    .line 434
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$16(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_9

    .line 435
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$16(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_9

    .line 436
    new-instance v2, Landroid/content/Intent;

    .line 437
    const-string v4, "android.intent.action.VIEW"

    .line 436
    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 439
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$16(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 440
    const-string v5, "application/vnd.android.package-archive"

    .line 438
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 441
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 442
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_1

    .line 483
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 485
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 429
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 430
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 443
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$17(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 444
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$17(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 446
    new-instance v4, Lcom/aio/downloader/activity/AppActivity1$6$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppActivity1$6$3;-><init>(Lcom/aio/downloader/activity/AppActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 472
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1$6$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 475
    :cond_a
    new-instance v2, Landroid/content/Intent;

    .line 476
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 477
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 475
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 478
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 479
    const-string v5, "com.allinone.callerid"

    .line 478
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 480
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 481
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_1

    .line 488
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 490
    const-string v5, "com.allinone.callerid"

    .line 489
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 491
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 492
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 494
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$10(Lcom/aio/downloader/activity/AppActivity1;)I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 497
    :try_start_7
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/AppActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 498
    const-string v6, "com.aioapp.battery"

    const/4 v7, 0x0

    .line 497
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/AppActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 502
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/AppActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_f

    .line 504
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$18(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 505
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$18(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_d

    .line 506
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 508
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$18(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 509
    const-string v5, "application/vnd.android.package-archive"

    .line 507
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 510
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 511
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 543
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 545
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 499
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 500
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 512
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppActivity1;->access$19(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 513
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppActivity1;->access$19(Lcom/aio/downloader/activity/AppActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 514
    new-instance v4, Lcom/aio/downloader/activity/AppActivity1$6$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppActivity1$6$4;-><init>(Lcom/aio/downloader/activity/AppActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 534
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppActivity1$6$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 536
    :cond_e
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 537
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 536
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 538
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 540
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 541
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_1

    .line 548
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 549
    const-string v5, "com.aioapp.battery"

    .line 548
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 550
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 551
    iget-object v4, p0, Lcom/aio/downloader/activity/AppActivity1$6;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method
