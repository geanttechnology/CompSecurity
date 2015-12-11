.class public Lcom/aio/downloader/activity/WidgeGametActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "WidgeGametActivity.java"


# instance fields
.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private intent:Landroid/content/Intent;

.field private packageInfo:Landroid/content/pm/PackageInfo;


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

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->AIOBATTERY:Ljava/io/File;

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

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->AIOBATTERYAPK:Ljava/io/File;

    .line 19
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/WidgeGametActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/WidgeGametActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->AIOBATTERYAPK:Ljava/io/File;

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
    .line 129
    const-wide/16 v1, 0x0

    .line 130
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 131
    const/4 v0, 0x0

    .line 132
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 133
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 137
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 135
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const-wide/32 v5, 0x377eff

    const/high16 v4, 0x10000000

    .line 35
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 45
    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgeGametActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "shortcut_battery_click"

    invoke-static {v1, v2}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 47
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgeGametActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 48
    const-string v2, "com.aioapp.battery"

    const/4 v3, 0x0

    .line 47
    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 52
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v1, :cond_2

    .line 54
    :try_start_1
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 55
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/WidgeGametActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v1

    cmp-long v1, v1, v5

    if-ltz v1, :cond_0

    .line 56
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    .line 57
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    .line 58
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 59
    const-string v3, "application/vnd.android.package-archive"

    .line 57
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 60
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 61
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/WidgeGametActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 104
    :goto_1
    return-void

    .line 49
    :catch_0
    move-exception v0

    .line 50
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 62
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    :try_start_2
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 63
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/WidgeGametActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v1

    cmp-long v1, v1, v5

    if-ltz v1, :cond_1

    .line 64
    new-instance v1, Lcom/aio/downloader/activity/WidgeGametActivity$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/WidgeGametActivity$1;-><init>(Lcom/aio/downloader/activity/WidgeGametActivity;)V

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    .line 84
    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/WidgeGametActivity$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 93
    :catch_1
    move-exception v0

    .line 95
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 86
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_3
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgeGametActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 87
    const-class v3, Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 86
    iput-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    .line 88
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    const-string v2, "myid"

    const-string v3, "com.aioapp.battery"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 90
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 91
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/WidgeGametActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1

    .line 98
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgeGametActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 99
    const-string v2, "com.aioapp.battery"

    .line 98
    invoke-virtual {v1, v2}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    .line 100
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    invoke-virtual {v1, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 101
    iget-object v1, p0, Lcom/aio/downloader/activity/WidgeGametActivity;->intent:Landroid/content/Intent;

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/WidgeGametActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    .line 119
    const/4 v1, 0x4

    if-ne p1, v1, :cond_0

    .line 120
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/WidgeGametActivity;->moveTaskToBack(Z)Z

    .line 125
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
    .line 110
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 111
    invoke-virtual {p0}, Lcom/aio/downloader/activity/WidgeGametActivity;->finish()V

    .line 112
    return-void
.end method
