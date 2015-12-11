.class public Lcom/amazon/mShop/startup/BaseActivity;
.super Landroid/support/v4/app/FragmentActivity;
.source "BaseActivity.java"


# static fields
.field public static final ACTION_STARTUP_TASK:Ljava/lang/String; = "actionStartupTask"

.field public static final INTENT_EXTRA_DATA_TASK_ID:Ljava/lang/String; = "intentExtraDataTaskId"

.field public static final INTENT_EXTRA_DATA_TASK_RESULT:Ljava/lang/String; = "intentExtraDataTaskResult"


# instance fields
.field private mStartupTaskId:Ljava/lang/String;

.field private mStartupTaskResult:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    .line 84
    const-string/jumbo v0, "taskResultSucceed"

    iput-object v0, p0, Lcom/amazon/mShop/startup/BaseActivity;->mStartupTaskResult:Ljava/lang/String;

    return-void
.end method

.method private bindStartupTask()V
    .locals 2

    .prologue
    .line 93
    const-string/jumbo v0, "actionStartupTask"

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/BaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 94
    invoke-virtual {p0}, Lcom/amazon/mShop/startup/BaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "intentDataStartupTaskId"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getCharSequenceExtra(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/mShop/startup/BaseActivity;->mStartupTaskId:Ljava/lang/String;

    .line 96
    :cond_0
    return-void
.end method

.method private clearBindStartupTask()V
    .locals 1

    .prologue
    .line 99
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/startup/BaseActivity;->mStartupTaskId:Ljava/lang/String;

    .line 100
    return-void
.end method

.method private notifyStartupTask()V
    .locals 3

    .prologue
    .line 110
    const-string/jumbo v1, "actionStartupTask"

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/BaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/BaseActivity;->hasBindStartupTask()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 111
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "actionStartupTask"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 112
    .local v0, "intentOut":Landroid/content/Intent;
    const-string/jumbo v1, "intentExtraDataTaskId"

    iget-object v2, p0, Lcom/amazon/mShop/startup/BaseActivity;->mStartupTaskId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 113
    const-string/jumbo v1, "intentExtraDataTaskResult"

    iget-object v2, p0, Lcom/amazon/mShop/startup/BaseActivity;->mStartupTaskResult:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 114
    const/4 v1, -0x1

    invoke-virtual {p0, v1, v0}, Lcom/amazon/mShop/startup/BaseActivity;->setResult(ILandroid/content/Intent;)V

    .line 115
    invoke-direct {p0}, Lcom/amazon/mShop/startup/BaseActivity;->clearBindStartupTask()V

    .line 117
    .end local v0    # "intentOut":Landroid/content/Intent;
    :cond_0
    return-void
.end method

.method public static startActivityForStartup(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 2
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "startupTaskId"    # Ljava/lang/String;

    .prologue
    .line 75
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 76
    :cond_0
    const-string/jumbo v0, "startActivityForStartup"

    const-string/jumbo v1, "invalid parameter"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    :goto_0
    return-void

    .line 79
    :cond_1
    const-string/jumbo v0, "intentDataStartupTaskId"

    invoke-virtual {p1, v0, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 80
    const-string/jumbo v0, "actionStartupTask"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 81
    const/16 v0, 0x10

    invoke-virtual {p0, p1, v0}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0
.end method


# virtual methods
.method protected endStartupTask(Ljava/lang/String;)V
    .locals 1
    .param p1, "r"    # Ljava/lang/String;

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/amazon/mShop/startup/BaseActivity;->hasBindStartupTask()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 87
    iput-object p1, p0, Lcom/amazon/mShop/startup/BaseActivity;->mStartupTaskResult:Ljava/lang/String;

    .line 89
    :cond_0
    return-void
.end method

.method public finish()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/amazon/mShop/startup/BaseActivity;->notifyStartupTask()V

    .line 36
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 37
    return-void
.end method

.method public finishIfNotFinishing()V
    .locals 1

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/amazon/mShop/startup/BaseActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    :goto_0
    return-void

    .line 67
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/startup/BaseActivity;->finish()V

    goto :goto_0
.end method

.method protected hasBindStartupTask()Z
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/startup/BaseActivity;->mStartupTaskId:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 104
    const/4 v0, 0x0

    .line 106
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 52
    invoke-static {p1}, Lcom/amazon/mShop/util/LocaleUtils;->ensureConfigLocale(Landroid/content/res/Configuration;)V

    .line 53
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 57
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->ensureAppLocale(Landroid/content/Context;)V

    .line 58
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 20
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->ensureAppLocale(Landroid/content/Context;)V

    .line 21
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    invoke-direct {p0}, Lcom/amazon/mShop/startup/BaseActivity;->bindStartupTask()V

    .line 23
    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 41
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onDestroy()V

    .line 42
    const-string/jumbo v0, "actionStartupTask"

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/BaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 43
    invoke-direct {p0}, Lcom/amazon/mShop/startup/BaseActivity;->notifyStartupTask()V

    .line 45
    :cond_0
    return-void
.end method

.method protected onStart()V
    .locals 0

    .prologue
    .line 29
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->ensureAppLocale(Landroid/content/Context;)V

    .line 30
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onStart()V

    .line 31
    return-void
.end method
