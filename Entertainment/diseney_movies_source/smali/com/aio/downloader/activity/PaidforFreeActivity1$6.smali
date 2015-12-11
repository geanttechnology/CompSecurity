.class Lcom/aio/downloader/activity/PaidforFreeActivity1$6;
.super Ljava/lang/Object;
.source "PaidforFreeActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/PaidforFreeActivity1;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/PaidforFreeActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    .line 288
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/PaidforFreeActivity1$6;)Lcom/aio/downloader/activity/PaidforFreeActivity1;
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 292
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 293
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 292
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 294
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$0(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Landroid/widget/ImageView;

    move-result-object v4

    const v5, 0x7f0200d7

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 295
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->isfbshow:Z
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$8(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 299
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4010000000000000L    # 4.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$9(Lcom/aio/downloader/activity/PaidforFreeActivity1;I)V

    .line 300
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$10(Lcom/aio/downloader/activity/PaidforFreeActivity1;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 303
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 305
    const-string v6, "com.evzapp.cleanmaster"

    const/4 v7, 0x0

    .line 304
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 303
    iput-object v5, v4, Lcom/aio/downloader/activity/PaidforFreeActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 309
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/PaidforFreeActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_3

    .line 310
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$11(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 311
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 313
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$12(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 314
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 315
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 313
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 316
    const-string v5, "application/vnd.android.package-archive"

    .line 312
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 317
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 318
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V

    .line 541
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 306
    :catch_0
    move-exception v1

    .line 307
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 319
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$13(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 320
    new-instance v4, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$1;-><init>(Lcom/aio/downloader/activity/PaidforFreeActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 346
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 348
    :cond_2
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 349
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 348
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 350
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 351
    const-string v5, "com.evzapp.cleanmaster"

    .line 350
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 352
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 353
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 356
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 358
    const-string v5, "com.evzapp.cleanmaster"

    .line 357
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 359
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 360
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 362
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$10(Lcom/aio/downloader/activity/PaidforFreeActivity1;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_8

    .line 364
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 365
    const-string v6, "com.freepezzle.hexcrush"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 364
    iput-object v5, v4, Lcom/aio/downloader/activity/PaidforFreeActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 369
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/PaidforFreeActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_7

    .line 371
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$14(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 372
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$14(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_5

    .line 373
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 375
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$14(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 376
    const-string v5, "application/vnd.android.package-archive"

    .line 374
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 377
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 406
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 407
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 366
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 367
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 378
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$15(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 379
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$15(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 380
    new-instance v4, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$2;-><init>(Lcom/aio/downloader/activity/PaidforFreeActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 398
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 400
    :cond_6
    new-instance v0, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 401
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 400
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 402
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 403
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_1

    .line 410
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 412
    const-string v5, "com.freepezzle.hexcrush"

    .line 411
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 413
    .local v3, "intent5":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v3}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 417
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$10(Lcom/aio/downloader/activity/PaidforFreeActivity1;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    .line 419
    :try_start_4
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 420
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 419
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/PaidforFreeActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 424
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/PaidforFreeActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_b

    .line 426
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$16(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_9

    .line 427
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$16(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_9

    .line 428
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 430
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$16(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 431
    const-string v5, "application/vnd.android.package-archive"

    .line 429
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 432
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 433
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_1

    .line 469
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 471
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 421
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 422
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 434
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$17(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 435
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$17(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 437
    new-instance v4, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$3;-><init>(Lcom/aio/downloader/activity/PaidforFreeActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 460
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 463
    :cond_a
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 464
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 463
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 465
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.allinone.callerid"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 466
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 467
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_1

    .line 474
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 475
    const-string v5, "com.allinone.callerid"

    .line 474
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 476
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 477
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 479
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$10(Lcom/aio/downloader/activity/PaidforFreeActivity1;)I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 481
    :try_start_7
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 482
    const-string v6, "com.aioapp.battery"

    const/4 v7, 0x0

    .line 481
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/PaidforFreeActivity1;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 486
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v4, v4, Lcom/aio/downloader/activity/PaidforFreeActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_f

    .line 488
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$18(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 489
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$18(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_d

    .line 490
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 492
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$18(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 493
    const-string v5, "application/vnd.android.package-archive"

    .line 491
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 494
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 495
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 527
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 529
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 483
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 484
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 496
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$19(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 497
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    iget-object v5, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->AIOBATTERY:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$19(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 498
    new-instance v4, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$4;-><init>(Lcom/aio/downloader/activity/PaidforFreeActivity1$6;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 518
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/PaidforFreeActivity1$6$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 520
    :cond_e
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 521
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 520
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 522
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 524
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 525
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_1

    .line 532
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 533
    const-string v5, "com.aioapp.battery"

    .line 532
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 534
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 535
    iget-object v4, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$6;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method
