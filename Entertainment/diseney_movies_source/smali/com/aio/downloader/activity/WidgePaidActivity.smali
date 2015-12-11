.class public Lcom/aio/downloader/activity/WidgePaidActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "WidgePaidActivity.java"


# instance fields
.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 20
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 21
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/WidgePaidActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 22
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 23
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/WidgePaidActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 24
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 25
    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/WidgePaidActivity;->PRO_DIR:Ljava/io/File;

    .line 18
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/WidgePaidActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/aio/downloader/activity/WidgePaidActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/WidgePaidActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/aio/downloader/activity/WidgePaidActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/WidgePaidActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/aio/downloader/activity/WidgePaidActivity;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    const/high16 v7, 0x10000000

    .line 30
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 31
    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgePaidActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "shortcut_cleaner_click"

    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 32
    const/4 v3, 0x0

    .line 34
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgePaidActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 35
    const-string v5, "com.evzapp.cleanmaster"

    const/4 v6, 0x0

    .line 34
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 39
    :goto_0
    if-nez v3, :cond_2

    .line 40
    iget-object v4, p0, Lcom/aio/downloader/activity/WidgePaidActivity;->PRO_DIR_FOME:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 41
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 43
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/WidgePaidActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 44
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 43
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 45
    const-string v5, "application/vnd.android.package-archive"

    .line 42
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 46
    invoke-virtual {v0, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 47
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/WidgePaidActivity;->startActivity(Landroid/content/Intent;)V

    .line 85
    .end local v0    # "aa":Landroid/content/Intent;
    :goto_1
    return-void

    .line 36
    :catch_0
    move-exception v1

    .line 37
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 48
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/activity/WidgePaidActivity;->PRO_DIR_TO:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 49
    new-instance v4, Lcom/aio/downloader/activity/WidgePaidActivity$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/WidgePaidActivity$1;-><init>(Lcom/aio/downloader/activity/WidgePaidActivity;)V

    new-array v5, v8, [Ljava/lang/Void;

    .line 70
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/WidgePaidActivity$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 72
    :cond_1
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgePaidActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 73
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 72
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 74
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.evzapp.cleanmaster"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 75
    invoke-virtual {v2, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 76
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/WidgePaidActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 79
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgePaidActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 80
    const-string v5, "com.evzapp.cleanmaster"

    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 81
    .restart local v2    # "intent":Landroid/content/Intent;
    invoke-virtual {v2, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 82
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/WidgePaidActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    .line 96
    const/4 v1, 0x4

    if-ne p1, v1, :cond_0

    .line 97
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/WidgePaidActivity;->moveTaskToBack(Z)Z

    .line 102
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Lcom/aio/downloader/mydownload/BaseActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 90
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 91
    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgePaidActivity;->finish()V

    .line 92
    return-void
.end method
