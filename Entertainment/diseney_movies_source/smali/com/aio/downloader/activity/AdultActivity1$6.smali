.class Lcom/aio/downloader/activity/AdultActivity1$6;
.super Ljava/lang/Object;
.source "AdultActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AdultActivity1;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AdultActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AdultActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    .line 287
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AdultActivity1$6;)Lcom/aio/downloader/activity/AdultActivity1;
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 291
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AdultActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 292
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 291
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 293
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$0(Lcom/aio/downloader/activity/AdultActivity1;)Landroid/widget/ImageView;

    move-result-object v4

    const v5, 0x7f0200d7

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 294
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->isfbshow:Z
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$8(Lcom/aio/downloader/activity/AdultActivity1;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 298
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4010000000000000L    # 4.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$9(Lcom/aio/downloader/activity/AdultActivity1;I)V

    .line 299
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$10(Lcom/aio/downloader/activity/AdultActivity1;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 302
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/AdultActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 304
    const-string v6, "com.evzapp.cleanmaster"

    const/4 v7, 0x0

    .line 303
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 302
    iput-object v5, v4, Lcom/aio/downloader/activity/AdultActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 308
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/AdultActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_3

    .line 309
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$11(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 310
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 312
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$12(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 313
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 314
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 312
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 315
    const-string v5, "application/vnd.android.package-archive"

    .line 311
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 316
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 317
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V

    .line 540
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 305
    :catch_0
    move-exception v1

    .line 306
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 318
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$13(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 319
    new-instance v4, Lcom/aio/downloader/activity/AdultActivity1$6$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AdultActivity1$6$1;-><init>(Lcom/aio/downloader/activity/AdultActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 345
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1$6$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 347
    :cond_2
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AdultActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 348
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 347
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 349
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 350
    const-string v5, "com.evzapp.cleanmaster"

    .line 349
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 351
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 352
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 355
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AdultActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 357
    const-string v5, "com.evzapp.cleanmaster"

    .line 356
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 358
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 359
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 361
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$10(Lcom/aio/downloader/activity/AdultActivity1;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_8

    .line 363
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/AdultActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 364
    const-string v6, "com.freepezzle.hexcrush"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 363
    iput-object v5, v4, Lcom/aio/downloader/activity/AdultActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 368
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/AdultActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_7

    .line 370
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$14(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 371
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$14(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_5

    .line 372
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 374
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$14(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 375
    const-string v5, "application/vnd.android.package-archive"

    .line 373
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 376
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 405
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 406
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 365
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 366
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 377
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$15(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 378
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$15(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 379
    new-instance v4, Lcom/aio/downloader/activity/AdultActivity1$6$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AdultActivity1$6$2;-><init>(Lcom/aio/downloader/activity/AdultActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 397
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1$6$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 399
    :cond_6
    new-instance v0, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AdultActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 400
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 399
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 401
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 402
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_1

    .line 409
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AdultActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 411
    const-string v5, "com.freepezzle.hexcrush"

    .line 410
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 412
    .local v3, "intent5":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v3}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 416
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$10(Lcom/aio/downloader/activity/AdultActivity1;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    .line 418
    :try_start_4
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/AdultActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 419
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 418
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/AdultActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 423
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/AdultActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_b

    .line 425
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$16(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_9

    .line 426
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$16(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_9

    .line 427
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 429
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$16(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 430
    const-string v5, "application/vnd.android.package-archive"

    .line 428
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 431
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 432
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_1

    .line 468
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 470
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 420
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 421
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 433
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$17(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 434
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$17(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 436
    new-instance v4, Lcom/aio/downloader/activity/AdultActivity1$6$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AdultActivity1$6$3;-><init>(Lcom/aio/downloader/activity/AdultActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 459
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1$6$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 462
    :cond_a
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AdultActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 463
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 462
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 464
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.allinone.callerid"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 465
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 466
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_1

    .line 473
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AdultActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 474
    const-string v5, "com.allinone.callerid"

    .line 473
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 475
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 476
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 478
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$10(Lcom/aio/downloader/activity/AdultActivity1;)I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 480
    :try_start_7
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/AdultActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 481
    const-string v6, "com.aioapp.battery"

    const/4 v7, 0x0

    .line 480
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/AdultActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 485
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/AdultActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_f

    .line 487
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$18(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 488
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$18(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_d

    .line 489
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 491
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$18(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 492
    const-string v5, "application/vnd.android.package-archive"

    .line 490
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 493
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 494
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 526
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 528
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 482
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 483
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 495
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AdultActivity1;->access$19(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 496
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AdultActivity1;->access$19(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 497
    new-instance v4, Lcom/aio/downloader/activity/AdultActivity1$6$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AdultActivity1$6$4;-><init>(Lcom/aio/downloader/activity/AdultActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 517
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AdultActivity1$6$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 519
    :cond_e
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AdultActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 520
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 519
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 521
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 523
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 524
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_1

    .line 531
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AdultActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 532
    const-string v5, "com.aioapp.battery"

    .line 531
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 533
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 534
    iget-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1$6;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method
