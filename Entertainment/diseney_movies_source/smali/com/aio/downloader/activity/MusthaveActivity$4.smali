.class Lcom/aio/downloader/activity/MusthaveActivity$4;
.super Ljava/lang/Object;
.source "MusthaveActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MusthaveActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MusthaveActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MusthaveActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    .line 144
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MusthaveActivity$4;)Lcom/aio/downloader/activity/MusthaveActivity;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 148
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 149
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 148
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 150
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$0(Lcom/aio/downloader/activity/MusthaveActivity;)Landroid/widget/ImageView;

    move-result-object v4

    const v5, 0x7f0200d7

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 151
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->isfbshow:Z
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$1(Lcom/aio/downloader/activity/MusthaveActivity;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 155
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4010000000000000L    # 4.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$2(Lcom/aio/downloader/activity/MusthaveActivity;I)V

    .line 156
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$3(Lcom/aio/downloader/activity/MusthaveActivity;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 159
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 161
    const-string v6, "com.evzapp.cleanmaster"

    const/4 v7, 0x0

    .line 160
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 159
    iput-object v5, v4, Lcom/aio/downloader/activity/MusthaveActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 165
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/MusthaveActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_3

    .line 166
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$4(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 167
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 169
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$5(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 170
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 171
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 169
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 172
    const-string v5, "application/vnd.android.package-archive"

    .line 168
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 173
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 174
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V

    .line 397
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 162
    :catch_0
    move-exception v1

    .line 163
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 175
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$6(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 176
    new-instance v4, Lcom/aio/downloader/activity/MusthaveActivity$4$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/MusthaveActivity$4$1;-><init>(Lcom/aio/downloader/activity/MusthaveActivity$4;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 202
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity$4$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 204
    :cond_2
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 205
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 204
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 206
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 207
    const-string v5, "com.evzapp.cleanmaster"

    .line 206
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 208
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 209
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 212
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 214
    const-string v5, "com.evzapp.cleanmaster"

    .line 213
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 215
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 216
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 218
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$3(Lcom/aio/downloader/activity/MusthaveActivity;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_8

    .line 220
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 221
    const-string v6, "com.freepezzle.hexcrush"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 220
    iput-object v5, v4, Lcom/aio/downloader/activity/MusthaveActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 225
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/MusthaveActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_7

    .line 227
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$7(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 228
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$7(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_5

    .line 229
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 231
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$7(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 232
    const-string v5, "application/vnd.android.package-archive"

    .line 230
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 233
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 262
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 263
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 222
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 223
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 234
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$8(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 235
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$8(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 236
    new-instance v4, Lcom/aio/downloader/activity/MusthaveActivity$4$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/MusthaveActivity$4$2;-><init>(Lcom/aio/downloader/activity/MusthaveActivity$4;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 254
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity$4$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 256
    :cond_6
    new-instance v0, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 257
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 256
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 258
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 259
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_1

    .line 266
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 268
    const-string v5, "com.freepezzle.hexcrush"

    .line 267
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 269
    .local v3, "intent5":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v3}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 273
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$3(Lcom/aio/downloader/activity/MusthaveActivity;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    .line 275
    :try_start_4
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 276
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 275
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/MusthaveActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 280
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/MusthaveActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_b

    .line 282
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$9(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_9

    .line 283
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$9(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_9

    .line 284
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 286
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$9(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 287
    const-string v5, "application/vnd.android.package-archive"

    .line 285
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 288
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 289
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_1

    .line 325
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 327
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 277
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 278
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 290
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$10(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 291
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$10(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 293
    new-instance v4, Lcom/aio/downloader/activity/MusthaveActivity$4$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/MusthaveActivity$4$3;-><init>(Lcom/aio/downloader/activity/MusthaveActivity$4;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 316
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity$4$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 319
    :cond_a
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 320
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 319
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 321
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.allinone.callerid"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 322
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 323
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_1

    .line 330
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 331
    const-string v5, "com.allinone.callerid"

    .line 330
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 332
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 333
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 335
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$3(Lcom/aio/downloader/activity/MusthaveActivity;)I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 337
    :try_start_7
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 338
    const-string v6, "com.aioapp.battery"

    const/4 v7, 0x0

    .line 337
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    iput-object v5, v4, Lcom/aio/downloader/activity/MusthaveActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 342
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/MusthaveActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_f

    .line 344
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$11(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 345
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$11(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_d

    .line 346
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 348
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$11(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 349
    const-string v5, "application/vnd.android.package-archive"

    .line 347
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 350
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 351
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 383
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 385
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 339
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 340
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 352
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOBATTERY:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->access$12(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 353
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    # getter for: Lcom/aio/downloader/activity/MusthaveActivity;->AIOBATTERY:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MusthaveActivity;->access$12(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 354
    new-instance v4, Lcom/aio/downloader/activity/MusthaveActivity$4$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/MusthaveActivity$4$4;-><init>(Lcom/aio/downloader/activity/MusthaveActivity$4;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 374
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MusthaveActivity$4$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 376
    :cond_e
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 377
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 376
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 378
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 380
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 381
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_1

    .line 388
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 389
    const-string v5, "com.aioapp.battery"

    .line 388
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 390
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 391
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity$4;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/MusthaveActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method
