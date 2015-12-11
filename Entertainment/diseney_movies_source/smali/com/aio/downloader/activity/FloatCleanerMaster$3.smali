.class Lcom/aio/downloader/activity/FloatCleanerMaster$3;
.super Ljava/lang/Object;
.source "FloatCleanerMaster.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FloatCleanerMaster;->findclick()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FloatCleanerMaster;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    .line 226
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FloatCleanerMaster$3;)Lcom/aio/downloader/activity/FloatCleanerMaster;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 230
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 231
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 230
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 232
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$3(Lcom/aio/downloader/activity/FloatCleanerMaster;)Landroid/widget/ImageView;

    move-result-object v4

    const v5, 0x7f020090

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 233
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->isfbshow:Z
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$4(Lcom/aio/downloader/activity/FloatCleanerMaster;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 237
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4010000000000000L    # 4.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$5(Lcom/aio/downloader/activity/FloatCleanerMaster;I)V

    .line 238
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$6(Lcom/aio/downloader/activity/FloatCleanerMaster;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 241
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 242
    const-string v6, "com.evzapp.cleanmaster"

    const/4 v7, 0x0

    .line 241
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/FloatCleanerMaster;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 246
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v4, v4, Lcom/aio/downloader/activity/FloatCleanerMaster;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_3

    .line 247
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$7(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 248
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 250
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$8(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 251
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 252
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 250
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 253
    const-string v5, "application/vnd.android.package-archive"

    .line 249
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 254
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 255
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    .line 496
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 243
    :catch_0
    move-exception v1

    .line 244
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 256
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$9(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 257
    new-instance v4, Lcom/aio/downloader/activity/FloatCleanerMaster$3$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster$3$1;-><init>(Lcom/aio/downloader/activity/FloatCleanerMaster$3;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 281
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster$3$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 283
    :cond_2
    new-instance v2, Landroid/content/Intent;

    .line 284
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 285
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 283
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 286
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 287
    const-string v5, "com.evzapp.cleanmaster"

    .line 286
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 288
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 289
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 292
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 294
    const-string v5, "com.evzapp.cleanmaster"

    .line 293
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 295
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 296
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 298
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$6(Lcom/aio/downloader/activity/FloatCleanerMaster;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_8

    .line 300
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 301
    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 302
    const-string v6, "com.freepezzle.hexcrush"

    const/4 v7, 0x0

    .line 301
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 300
    iput-object v5, v4, Lcom/aio/downloader/activity/FloatCleanerMaster;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 306
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v4, v4, Lcom/aio/downloader/activity/FloatCleanerMaster;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_7

    .line 308
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$10(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 309
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$10(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_5

    .line 310
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 312
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$10(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 313
    const-string v5, "application/vnd.android.package-archive"

    .line 311
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 314
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 348
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 349
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 303
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 304
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 315
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$11(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 316
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$11(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 317
    new-instance v4, Lcom/aio/downloader/activity/FloatCleanerMaster$3$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster$3$2;-><init>(Lcom/aio/downloader/activity/FloatCleanerMaster$3;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 338
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster$3$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 340
    :cond_6
    new-instance v0, Landroid/content/Intent;

    .line 341
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 342
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 340
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 343
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    .line 344
    const-string v5, "com.freepezzle.hexcrush"

    .line 343
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 345
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_1

    .line 352
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 354
    const-string v5, "com.freepezzle.hexcrush"

    .line 353
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 355
    .local v3, "intent5":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v3}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 358
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$6(Lcom/aio/downloader/activity/FloatCleanerMaster;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    .line 360
    :try_start_4
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 361
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 360
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/FloatCleanerMaster;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 365
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v4, v4, Lcom/aio/downloader/activity/FloatCleanerMaster;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_b

    .line 367
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$12(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_9

    .line 368
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$12(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_9

    .line 369
    new-instance v2, Landroid/content/Intent;

    .line 370
    const-string v4, "android.intent.action.VIEW"

    .line 369
    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 372
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$12(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

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
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 374
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 375
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_1

    .line 416
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 418
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 362
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 363
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 376
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$13(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 377
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$13(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 379
    new-instance v4, Lcom/aio/downloader/activity/FloatCleanerMaster$3$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster$3$3;-><init>(Lcom/aio/downloader/activity/FloatCleanerMaster$3;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 405
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster$3$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 408
    :cond_a
    new-instance v2, Landroid/content/Intent;

    .line 409
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 410
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 408
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 411
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 412
    const-string v5, "com.allinone.callerid"

    .line 411
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 413
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 414
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_1

    .line 421
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 423
    const-string v5, "com.allinone.callerid"

    .line 422
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 424
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 425
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 427
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$6(Lcom/aio/downloader/activity/FloatCleanerMaster;)I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 429
    :try_start_7
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 430
    const-string v6, "com.aioapp.battery"

    const/4 v7, 0x0

    .line 429
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/FloatCleanerMaster;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 434
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v4, v4, Lcom/aio/downloader/activity/FloatCleanerMaster;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_f

    .line 436
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$14(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 437
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$14(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_d

    .line 438
    new-instance v2, Landroid/content/Intent;

    .line 439
    const-string v4, "android.intent.action.VIEW"

    .line 438
    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 440
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 441
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$14(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 440
    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 442
    const-string v5, "application/vnd.android.package-archive"

    .line 440
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 443
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 444
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 481
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 483
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 431
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 432
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 445
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$15(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 446
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOBATTERY:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$15(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 447
    new-instance v4, Lcom/aio/downloader/activity/FloatCleanerMaster$3$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster$3$4;-><init>(Lcom/aio/downloader/activity/FloatCleanerMaster$3;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 470
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster$3$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 472
    :cond_e
    new-instance v2, Landroid/content/Intent;

    .line 473
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 474
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 472
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 475
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 476
    const-string v5, "com.aioapp.battery"

    .line 475
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 478
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 479
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_1

    .line 486
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 488
    const-string v5, "com.aioapp.battery"

    .line 487
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 489
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 490
    iget-object v4, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$3;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method
