.class Lcom/aio/downloader/activity/AppDetailsActivity$24;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppDetailsActivity$24;)Lcom/aio/downloader/activity/AppDetailsActivity;
    .locals 1

    .prologue
    .line 1184
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const-wide/32 v7, 0x19ee4c

    .line 1189
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1190
    const-string v5, "pdt_caller_click"

    .line 1189
    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1197
    const/4 v3, 0x0

    .line 1199
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 1200
    const-string v5, "com.freepezzle.hexcrush"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 1204
    :goto_0
    if-nez v3, :cond_2

    .line 1206
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$72(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1207
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$72(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    cmp-long v4, v4, v7

    if-ltz v4, :cond_0

    .line 1208
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1210
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHAPK:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$72(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 1211
    const-string v5, "application/vnd.android.package-archive"

    .line 1209
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 1212
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 1251
    .end local v0    # "aa":Landroid/content/Intent;
    :goto_1
    return-void

    .line 1201
    :catch_0
    move-exception v1

    .line 1202
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 1213
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$73(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1214
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHSWF:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$73(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    cmp-long v4, v4, v7

    if-ltz v4, :cond_1

    .line 1215
    new-instance v4, Lcom/aio/downloader/activity/AppDetailsActivity$24$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$24$1;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity$24;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 1233
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppDetailsActivity$24$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 1241
    :catch_1
    move-exception v1

    .line 1242
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 1235
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_3
    new-instance v0, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 1236
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1235
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1237
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1238
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1

    .line 1245
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 1247
    const-string v5, "com.freepezzle.hexcrush"

    .line 1246
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 1248
    .local v2, "intent":Landroid/content/Intent;
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity$24;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1
.end method
