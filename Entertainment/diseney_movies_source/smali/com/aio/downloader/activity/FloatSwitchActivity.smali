.class public Lcom/aio/downloader/activity/FloatSwitchActivity;
.super Landroid/app/Activity;
.source "FloatSwitchActivity.java"


# static fields
.field public static intent_float:Landroid/content/Intent;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 17
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 18
    const-string v3, "floatctri"

    .line 19
    const/4 v4, 0x0

    .line 18
    invoke-virtual {p0, v3, v4}, Lcom/aio/downloader/activity/FloatSwitchActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 20
    .local v2, "userInfo_float":Landroid/content/SharedPreferences;
    const-string v3, "fctri"

    const/4 v4, 0x1

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 21
    .local v1, "showfloat":Z
    new-instance v3, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatSwitchActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-class v5, Lcom/aio/downloader/floatwindow/FloatWindowService;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    sput-object v3, Lcom/aio/downloader/activity/FloatSwitchActivity;->intent_float:Landroid/content/Intent;

    .line 22
    if-eqz v1, :cond_0

    .line 24
    sget-object v3, Lcom/aio/downloader/activity/FloatSwitchActivity;->intent_float:Landroid/content/Intent;

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/FloatSwitchActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 28
    :goto_0
    sget-boolean v3, Lcom/aio/downloader/utils/Myutils;->iswidget2:Z

    if-eqz v3, :cond_1

    .line 29
    new-instance v3, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatSwitchActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-class v5, Lcom/aio/downloader/activity/FloatControlActivity;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/FloatSwitchActivity;->startActivity(Landroid/content/Intent;)V

    .line 40
    :goto_1
    return-void

    .line 26
    :cond_0
    sget-object v3, Lcom/aio/downloader/activity/FloatSwitchActivity;->intent_float:Landroid/content/Intent;

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/FloatSwitchActivity;->stopService(Landroid/content/Intent;)Z

    goto :goto_0

    .line 31
    :cond_1
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatSwitchActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 32
    const-class v4, Lcom/aio/downloader/activity/MyMainActivity;

    .line 31
    invoke-direct {v0, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 33
    .local v0, "intent":Landroid/content/Intent;
    const-string v3, "acquire_url_start"

    const-string v4, ""

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 34
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatSwitchActivity;->startActivity(Landroid/content/Intent;)V

    .line 35
    const v3, 0x7f04000c

    const v4, 0x7f040011

    invoke-virtual {p0, v3, v4}, Lcom/aio/downloader/activity/FloatSwitchActivity;->overridePendingTransition(II)V

    goto :goto_1
.end method
