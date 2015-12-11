.class Lcom/aio/downloader/activity/TodaysPickActivity$7;
.super Ljava/lang/Object;
.source "TodaysPickActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/TodaysPickActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/TodaysPickActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    .line 232
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/TodaysPickActivity$7;)Lcom/aio/downloader/activity/TodaysPickActivity;
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 236
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 237
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 236
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 238
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$0(Lcom/aio/downloader/activity/TodaysPickActivity;)Landroid/widget/ImageView;

    move-result-object v4

    const v5, 0x7f0200d7

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 239
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->isfbshow:Z
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$6(Lcom/aio/downloader/activity/TodaysPickActivity;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 243
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4010000000000000L    # 4.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$7(Lcom/aio/downloader/activity/TodaysPickActivity;I)V

    .line 244
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$8(Lcom/aio/downloader/activity/TodaysPickActivity;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 247
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 249
    const-string v6, "com.evzapp.cleanmaster"

    const/4 v7, 0x0

    .line 248
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 247
    iput-object v5, v4, Lcom/aio/downloader/activity/TodaysPickActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 253
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/TodaysPickActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_3

    .line 254
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$9(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 255
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 257
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$10(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 258
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 259
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 257
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 260
    const-string v5, "application/vnd.android.package-archive"

    .line 256
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 261
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 262
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    .line 485
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 250
    :catch_0
    move-exception v1

    .line 251
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 263
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$11(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 264
    new-instance v4, Lcom/aio/downloader/activity/TodaysPickActivity$7$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$7$1;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity$7;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 290
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity$7$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 292
    :cond_2
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 293
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 292
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 294
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 295
    const-string v5, "com.evzapp.cleanmaster"

    .line 294
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 296
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 297
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 300
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 302
    const-string v5, "com.evzapp.cleanmaster"

    .line 301
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 303
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 304
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 306
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$8(Lcom/aio/downloader/activity/TodaysPickActivity;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_8

    .line 308
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 309
    const-string v6, "com.freepezzle.hexcrush"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 308
    iput-object v5, v4, Lcom/aio/downloader/activity/TodaysPickActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 313
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/TodaysPickActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_7

    .line 315
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$12(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 316
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$12(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_5

    .line 317
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 319
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$12(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 320
    const-string v5, "application/vnd.android.package-archive"

    .line 318
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 321
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 350
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 351
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 310
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 311
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 322
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$13(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 323
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$13(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 324
    new-instance v4, Lcom/aio/downloader/activity/TodaysPickActivity$7$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$7$2;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity$7;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 342
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity$7$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 344
    :cond_6
    new-instance v0, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 345
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 344
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 346
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 347
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_1

    .line 354
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 356
    const-string v5, "com.freepezzle.hexcrush"

    .line 355
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 357
    .local v3, "intent5":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v3}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 361
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$8(Lcom/aio/downloader/activity/TodaysPickActivity;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    .line 363
    :try_start_4
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 364
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 363
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/TodaysPickActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 368
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/TodaysPickActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_b

    .line 370
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$14(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_9

    .line 371
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$14(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_9

    .line 372
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 374
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$14(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

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
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 376
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 377
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_1

    .line 413
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 415
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 365
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 366
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 378
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$15(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 379
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$15(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 381
    new-instance v4, Lcom/aio/downloader/activity/TodaysPickActivity$7$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$7$3;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity$7;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 404
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity$7$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 407
    :cond_a
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 408
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 407
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 409
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.allinone.callerid"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 410
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 411
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_1

    .line 418
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 419
    const-string v5, "com.allinone.callerid"

    .line 418
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 420
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 421
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 423
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$8(Lcom/aio/downloader/activity/TodaysPickActivity;)I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 425
    :try_start_7
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 426
    const-string v6, "com.aioapp.battery"

    const/4 v7, 0x0

    .line 425
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/TodaysPickActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 430
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/TodaysPickActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_f

    .line 432
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$16(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 433
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$16(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_d

    .line 434
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 436
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$16(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 437
    const-string v5, "application/vnd.android.package-archive"

    .line 435
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 438
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 439
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 471
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 473
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 427
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 428
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 440
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$17(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 441
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->AIOBATTERY:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$17(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 442
    new-instance v4, Lcom/aio/downloader/activity/TodaysPickActivity$7$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$7$4;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity$7;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 462
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/TodaysPickActivity$7$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 464
    :cond_e
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 465
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 464
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 466
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 468
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 469
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_1

    .line 476
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 477
    const-string v5, "com.aioapp.battery"

    .line 476
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 478
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 479
    iget-object v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity$7;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method
