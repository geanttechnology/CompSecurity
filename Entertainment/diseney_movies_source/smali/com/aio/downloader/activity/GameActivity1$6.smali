.class Lcom/aio/downloader/activity/GameActivity1$6;
.super Ljava/lang/Object;
.source "GameActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/GameActivity1;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/GameActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/GameActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    .line 285
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/GameActivity1$6;)Lcom/aio/downloader/activity/GameActivity1;
    .locals 1

    .prologue
    .line 285
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 289
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/GameActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 290
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 289
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 291
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$0(Lcom/aio/downloader/activity/GameActivity1;)Landroid/widget/ImageView;

    move-result-object v4

    const v5, 0x7f0200d7

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 292
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->isfbshow:Z
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$8(Lcom/aio/downloader/activity/GameActivity1;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 296
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4010000000000000L    # 4.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/GameActivity1;->access$9(Lcom/aio/downloader/activity/GameActivity1;I)V

    .line 297
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$10(Lcom/aio/downloader/activity/GameActivity1;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 300
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/GameActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 302
    const-string v6, "com.evzapp.cleanmaster"

    const/4 v7, 0x0

    .line 301
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 300
    iput-object v5, v4, Lcom/aio/downloader/activity/GameActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 306
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/GameActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_3

    .line 307
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$11(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 308
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 310
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$12(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 311
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 312
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 310
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 313
    const-string v5, "application/vnd.android.package-archive"

    .line 309
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 314
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 315
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V

    .line 538
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 303
    :catch_0
    move-exception v1

    .line 304
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 316
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$13(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 317
    new-instance v4, Lcom/aio/downloader/activity/GameActivity1$6$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/GameActivity1$6$1;-><init>(Lcom/aio/downloader/activity/GameActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 343
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1$6$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 345
    :cond_2
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/GameActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 346
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 345
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 347
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 348
    const-string v5, "com.evzapp.cleanmaster"

    .line 347
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 349
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 350
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 353
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/GameActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 355
    const-string v5, "com.evzapp.cleanmaster"

    .line 354
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 356
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 357
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 359
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$10(Lcom/aio/downloader/activity/GameActivity1;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_8

    .line 361
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/GameActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 362
    const-string v6, "com.freepezzle.hexcrush"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 361
    iput-object v5, v4, Lcom/aio/downloader/activity/GameActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 366
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/GameActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_7

    .line 368
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$14(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 369
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$14(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_5

    .line 370
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 372
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$14(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 373
    const-string v5, "application/vnd.android.package-archive"

    .line 371
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 374
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 403
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 404
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 363
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 364
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 375
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$15(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 376
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$15(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 377
    new-instance v4, Lcom/aio/downloader/activity/GameActivity1$6$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/GameActivity1$6$2;-><init>(Lcom/aio/downloader/activity/GameActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 395
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1$6$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 397
    :cond_6
    new-instance v0, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/GameActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 398
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 397
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 399
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 400
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_1

    .line 407
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/GameActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 409
    const-string v5, "com.freepezzle.hexcrush"

    .line 408
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 410
    .local v3, "intent5":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v3}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 414
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$10(Lcom/aio/downloader/activity/GameActivity1;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    .line 416
    :try_start_4
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/GameActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 417
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 416
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/GameActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 421
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/GameActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_b

    .line 423
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$16(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_9

    .line 424
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$16(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_9

    .line 425
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 427
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$16(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 428
    const-string v5, "application/vnd.android.package-archive"

    .line 426
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 429
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 430
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_1

    .line 466
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 468
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 418
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 419
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 431
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$17(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 432
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$17(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 434
    new-instance v4, Lcom/aio/downloader/activity/GameActivity1$6$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/GameActivity1$6$3;-><init>(Lcom/aio/downloader/activity/GameActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 457
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1$6$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 460
    :cond_a
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/GameActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 461
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 460
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 462
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.allinone.callerid"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 463
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 464
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_1

    .line 471
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/GameActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 472
    const-string v5, "com.allinone.callerid"

    .line 471
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 473
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 474
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 476
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$10(Lcom/aio/downloader/activity/GameActivity1;)I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 478
    :try_start_7
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/GameActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 479
    const-string v6, "com.aioapp.battery"

    const/4 v7, 0x0

    .line 478
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/GameActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 483
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/GameActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_f

    .line 485
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$18(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 486
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$18(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_d

    .line 487
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 489
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$18(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 490
    const-string v5, "application/vnd.android.package-archive"

    .line 488
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 491
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 492
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 524
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 526
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 480
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 481
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 493
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/GameActivity1;->access$19(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 494
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/GameActivity1;->access$19(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 495
    new-instance v4, Lcom/aio/downloader/activity/GameActivity1$6$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/GameActivity1$6$4;-><init>(Lcom/aio/downloader/activity/GameActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 515
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/GameActivity1$6$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 517
    :cond_e
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/GameActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 518
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 517
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 519
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 521
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 522
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_1

    .line 529
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/GameActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 530
    const-string v5, "com.aioapp.battery"

    .line 529
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 531
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 532
    iget-object v4, p0, Lcom/aio/downloader/activity/GameActivity1$6;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/GameActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method
