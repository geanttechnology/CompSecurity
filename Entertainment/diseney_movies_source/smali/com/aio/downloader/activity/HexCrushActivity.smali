.class public Lcom/aio/downloader/activity/HexCrushActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "HexCrushActivity.java"


# instance fields
.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 21
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 22
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 23
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 24
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/HexCrushActivity;->AIOCRUSHSWF:Ljava/io/File;

    .line 25
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 26
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 27
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 28
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/HexCrushActivity;->AIOCRUSHAPK:Ljava/io/File;

    .line 19
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/HexCrushActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/aio/downloader/activity/HexCrushActivity;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/HexCrushActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/aio/downloader/activity/HexCrushActivity;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method


# virtual methods
.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 110
    const-wide/16 v1, 0x0

    .line 111
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 112
    const/4 v0, 0x0

    .line 113
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 114
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 118
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 116
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const-wide/32 v7, 0x19ee4c

    .line 33
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 34
    invoke-virtual {p0}, Lcom/aio/downloader/activity/HexCrushActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "shortcut_crush_click"

    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 35
    const/4 v3, 0x0

    .line 37
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/HexCrushActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 38
    const-string v5, "com.freepezzle.hexcrush"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 42
    :goto_0
    if-nez v3, :cond_2

    .line 44
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/activity/HexCrushActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 45
    iget-object v4, p0, Lcom/aio/downloader/activity/HexCrushActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/HexCrushActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    cmp-long v4, v4, v7

    if-ltz v4, :cond_0

    .line 46
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 48
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/HexCrushActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 49
    const-string v5, "application/vnd.android.package-archive"

    .line 47
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 50
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/HexCrushActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 89
    .end local v0    # "aa":Landroid/content/Intent;
    :goto_1
    return-void

    .line 39
    :catch_0
    move-exception v1

    .line 40
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 51
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/HexCrushActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 52
    iget-object v4, p0, Lcom/aio/downloader/activity/HexCrushActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/HexCrushActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    cmp-long v4, v4, v7

    if-ltz v4, :cond_1

    .line 53
    new-instance v4, Lcom/aio/downloader/activity/HexCrushActivity$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/HexCrushActivity$1;-><init>(Lcom/aio/downloader/activity/HexCrushActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 71
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/HexCrushActivity$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 79
    :catch_1
    move-exception v1

    .line 80
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 73
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_3
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/HexCrushActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 74
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 73
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 75
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 76
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/HexCrushActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1

    .line 83
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/HexCrushActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 85
    const-string v5, "com.freepezzle.hexcrush"

    .line 84
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 86
    .local v2, "intent5":Landroid/content/Intent;
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/HexCrushActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    .line 100
    const/4 v1, 0x4

    if-ne p1, v1, :cond_0

    .line 101
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/HexCrushActivity;->moveTaskToBack(Z)Z

    .line 106
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
    .line 94
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 95
    invoke-virtual {p0}, Lcom/aio/downloader/activity/HexCrushActivity;->finish()V

    .line 96
    return-void
.end method
