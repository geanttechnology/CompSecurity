.class Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;
.super Ljava/lang/Object;
.source "ExclusiveAppsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/ExclusiveAppsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    .line 144
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;)Lcom/aio/downloader/activity/ExclusiveAppsActivity;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 148
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 149
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 148
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 150
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$0(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Landroid/widget/ImageView;

    move-result-object v4

    const v5, 0x7f0200d7

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 151
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->isfbshow:Z
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$1(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 155
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4008000000000000L    # 3.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$2(Lcom/aio/downloader/activity/ExclusiveAppsActivity;I)V

    .line 156
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$3(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 159
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 160
    const-string v6, "com.evzapp.cleanmaster"

    const/4 v7, 0x0

    .line 159
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 164
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_3

    .line 165
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$4(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 166
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 168
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$5(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 169
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 170
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 168
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 171
    const-string v5, "application/vnd.android.package-archive"

    .line 167
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 172
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 173
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V

    .line 410
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 161
    :catch_0
    move-exception v1

    .line 162
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 174
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$6(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 175
    new-instance v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$1;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 199
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 201
    :cond_2
    new-instance v2, Landroid/content/Intent;

    .line 202
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 203
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 201
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 204
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 205
    const-string v5, "com.evzapp.cleanmaster"

    .line 204
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 206
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 207
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 210
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 212
    const-string v5, "com.evzapp.cleanmaster"

    .line 211
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 213
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 214
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 216
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$3(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_8

    .line 218
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 219
    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 220
    const-string v6, "com.freepezzle.hexcrush"

    const/4 v7, 0x0

    .line 219
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 218
    iput-object v5, v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 224
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_7

    .line 226
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$7(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 227
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$7(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_5

    .line 228
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 230
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$7(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 231
    const-string v5, "application/vnd.android.package-archive"

    .line 229
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 232
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 266
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 267
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 221
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 222
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 233
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$8(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 234
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$8(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 235
    new-instance v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$2;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 256
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 258
    :cond_6
    new-instance v0, Landroid/content/Intent;

    .line 259
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 260
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 258
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 261
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    .line 262
    const-string v5, "com.freepezzle.hexcrush"

    .line 261
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 263
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_1

    .line 270
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 272
    const-string v5, "com.freepezzle.hexcrush"

    .line 271
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 273
    .local v3, "intent5":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v3}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 276
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$3(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    .line 278
    :try_start_4
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 279
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 278
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 283
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_b

    .line 285
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$9(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_9

    .line 286
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$9(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_9

    .line 287
    new-instance v2, Landroid/content/Intent;

    .line 288
    const-string v4, "android.intent.action.VIEW"

    .line 287
    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 290
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$9(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 291
    const-string v5, "application/vnd.android.package-archive"

    .line 289
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 292
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 293
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_1

    .line 334
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 336
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 280
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 281
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 294
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$10(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 295
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$10(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 297
    new-instance v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$3;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 323
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 326
    :cond_a
    new-instance v2, Landroid/content/Intent;

    .line 327
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 328
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 326
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 329
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 330
    const-string v5, "com.allinone.callerid"

    .line 329
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 331
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 332
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_1

    .line 339
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 341
    const-string v5, "com.allinone.callerid"

    .line 340
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 342
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 343
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 345
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$3(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 348
    :try_start_7
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 349
    const-string v6, "com.aioapp.battery"

    const/4 v7, 0x0

    .line 348
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 353
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_f

    .line 355
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$11(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 356
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$11(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_d

    .line 357
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 359
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$11(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 360
    const-string v5, "application/vnd.android.package-archive"

    .line 358
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 361
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 362
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 394
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 396
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 350
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 351
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 363
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$12(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 364
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOBATTERY:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$12(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 365
    new-instance v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$4;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 385
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 387
    :cond_e
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 388
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 387
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 389
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 391
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 392
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_1

    .line 399
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 400
    const-string v5, "com.aioapp.battery"

    .line 399
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 401
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 402
    iget-object v4, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method
