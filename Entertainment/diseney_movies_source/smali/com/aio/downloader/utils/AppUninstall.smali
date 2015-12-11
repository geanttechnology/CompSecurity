.class public Lcom/aio/downloader/utils/AppUninstall;
.super Ljava/lang/Object;
.source "AppUninstall.java"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    const-string v0, "feedback-uninstall"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 9
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static native onUninstall(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public static openUrlWhenUninstall(Landroid/content/Context;Ljava/lang/String;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "openUrl"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v4

    iget-object v3, v4, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    .line 13
    .local v3, "dirStr":Ljava/lang/String;
    const-string v1, "com.android.browser/com.android.browser.BrowserActivity"

    .line 14
    .local v1, "activity":Ljava/lang/String;
    const-string v0, "android.intent.action.VIEW"

    .line 15
    .local v0, "action":Ljava/lang/String;
    move-object v2, p1

    .line 16
    .local v2, "data":Ljava/lang/String;
    invoke-static {v3, v1, v0, v2}, Lcom/aio/downloader/utils/AppUninstall;->onUninstall(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    return-void
.end method

.method public static startActionWhenUninstall(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget-object v0, v1, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    .line 21
    .local v0, "dirStr":Ljava/lang/String;
    const/4 v1, 0x0

    invoke-static {v0, v1, p1, p2}, Lcom/aio/downloader/utils/AppUninstall;->onUninstall(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    return-void
.end method

.method public static startActivityWhenUninstall(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "activityName"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 25
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget-object v0, v1, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    .line 26
    .local v0, "dirStr":Ljava/lang/String;
    const-string v1, "%s/%s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v4, v4}, Lcom/aio/downloader/utils/AppUninstall;->onUninstall(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    return-void
.end method
