.class public Lcom/comcast/cim/android/view/launch/LaunchActivity;
.super Lcom/comcast/cim/android/view/common/BaseActivity;
.source "LaunchActivity.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

.field private intentInterceptor:Lcom/comcast/cim/android/view/launch/LaunchIntentInterceptor;

.field private launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

.field private shouldFinishIfResumed:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/comcast/cim/android/view/launch/LaunchActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;-><init>()V

    .line 27
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getLaunchStrategy()Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    .line 28
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getLaunchIntentInterceptor()Lcom/comcast/cim/android/view/launch/LaunchIntentInterceptor;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->intentInterceptor:Lcom/comcast/cim/android/view/launch/LaunchIntentInterceptor;

    .line 29
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAppUpgradeHelper()Lcom/comcast/cim/android/application/AppUpgradeHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->shouldFinishIfResumed:Z

    return-void
.end method


# virtual methods
.method public final finish()V
    .locals 2

    .prologue
    .line 131
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->shouldFinishIfResumed:Z

    .line 132
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "exit"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 133
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "exit"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V

    .line 135
    :cond_0
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->finish()V

    .line 136
    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x1

    .line 149
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/common/BaseActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 151
    if-ne p1, v2, :cond_0

    if-nez p2, :cond_0

    .line 152
    sget-object v0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Initialization got cancelled"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 153
    iput-boolean v2, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->shouldFinishIfResumed:Z

    .line 155
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x0

    .line 36
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 37
    sget-object v2, Lcom/comcast/cim/android/view/launch/LaunchActivity;->LOG:Lorg/slf4j/Logger;

    const-string v3, "onCreate"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 41
    if-eqz p1, :cond_0

    .line 42
    const-string v2, "shouldFinishIfResumed"

    invoke-virtual {p1, v2, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->shouldFinishIfResumed:Z

    .line 46
    :cond_0
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

    invoke-interface {v2}, Lcom/comcast/cim/android/application/AppUpgradeHelper;->onLaunch()V
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/utils/exceptions/CimException; {:try_start_0 .. :try_end_0} :catch_0

    .line 68
    :goto_0
    return-void

    .line 47
    :catch_0
    move-exception v1

    .line 49
    .local v1, "e":Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    new-instance v0, Lcom/comcast/cim/android/view/launch/LaunchActivity$1;

    invoke-direct {v0, p0, p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity$1;-><init>(Lcom/comcast/cim/android/view/launch/LaunchActivity;Landroid/content/Context;)V

    .line 56
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/comcast/cim/android/R$string;->failed_upgrade:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 58
    const/4 v2, -0x3

    const-string v3, "Exit"

    new-instance v4, Lcom/comcast/cim/android/view/launch/LaunchActivity$2;

    invoke-direct {v4, p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity$2;-><init>(Lcom/comcast/cim/android/view/launch/LaunchActivity;)V

    invoke-virtual {v0, v2, v3, v4}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 64
    invoke-virtual {v0, v5}, Landroid/app/AlertDialog;->setCancelable(Z)V

    .line 65
    invoke-virtual {v0, v5}, Landroid/app/AlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 66
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_0
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 140
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 141
    sget-object v0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onNewIntent"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 143
    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->setIntent(Landroid/content/Intent;)V

    .line 144
    const-string v0, "exit"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->shouldFinishIfResumed:Z

    .line 145
    return-void
.end method

.method protected onResume()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    .line 72
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onResume()V

    .line 73
    sget-object v7, Lcom/comcast/cim/android/view/launch/LaunchActivity;->LOG:Lorg/slf4j/Logger;

    const-string v8, "onResume"

    invoke-interface {v7, v8}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 75
    iget-boolean v7, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->shouldFinishIfResumed:Z

    if-eqz v7, :cond_1

    .line 76
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->finish()V

    .line 127
    :cond_0
    :goto_0
    return-void

    .line 80
    :cond_1
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 81
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    .line 83
    .local v5, "providedIntent":Landroid/content/Intent;
    if-eqz v5, :cond_2

    invoke-virtual {v5}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v7

    if-eqz v7, :cond_2

    .line 84
    invoke-virtual {v5}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v7

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 87
    :cond_2
    const-string v7, "exit"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 88
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->finish()V

    goto :goto_0

    .line 90
    :cond_3
    const/4 v4, 0x0

    .line 91
    .local v4, "interceptStateStack":Ljava/util/List;, "Ljava/util/List<Landroid/content/Intent;>;"
    iget-object v7, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->intentInterceptor:Lcom/comcast/cim/android/view/launch/LaunchIntentInterceptor;

    if-eqz v7, :cond_4

    .line 93
    :try_start_0
    iget-object v7, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->intentInterceptor:Lcom/comcast/cim/android/view/launch/LaunchIntentInterceptor;

    invoke-interface {v7, v5}, Lcom/comcast/cim/android/view/launch/LaunchIntentInterceptor;->intercept(Landroid/content/Intent;)Ljava/util/List;

    move-result-object v4

    .line 94
    if-eqz v4, :cond_4

    .line 95
    const-string v8, "flowStates"

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v7

    new-array v7, v7, [Landroid/content/Intent;

    invoke-interface {v4, v7}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Landroid/os/Parcelable;

    invoke-virtual {v0, v8, v7}, Landroid/os/Bundle;->putParcelableArray(Ljava/lang/String;[Landroid/os/Parcelable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 106
    :cond_4
    :goto_1
    iput-boolean v9, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->shouldFinishIfResumed:Z

    .line 108
    const/4 v3, 0x0

    .line 109
    .local v3, "intent":Landroid/content/Intent;
    if-eqz v4, :cond_5

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_5

    .line 110
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/Intent;

    .line 111
    .local v6, "state":Landroid/content/Intent;
    invoke-virtual {p0, v6}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 98
    .end local v3    # "intent":Landroid/content/Intent;
    .end local v6    # "state":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 99
    .local v1, "e":Ljava/lang/Exception;
    sget-object v7, Lcom/comcast/cim/android/view/launch/LaunchActivity;->LOG:Lorg/slf4j/Logger;

    const-string v8, "failed during intercept"

    invoke-interface {v7, v8, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 100
    sget v7, Lcom/comcast/cim/android/R$string;->dlg_dive_error:I

    invoke-virtual {p0, v7}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 101
    .local v2, "errString":Ljava/lang/String;
    invoke-static {p0, v2, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/Toast;->show()V

    goto :goto_1

    .line 115
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "errString":Ljava/lang/String;
    .restart local v3    # "intent":Landroid/content/Intent;
    :cond_5
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->isTaskRoot()Z

    move-result v7

    if-eqz v7, :cond_6

    .line 116
    new-instance v3, Landroid/content/Intent;

    .end local v3    # "intent":Landroid/content/Intent;
    iget-object v7, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    invoke-virtual {v7}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->getDefaultActivityClass()Ljava/lang/Class;

    move-result-object v7

    invoke-direct {v3, p0, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 120
    .restart local v3    # "intent":Landroid/content/Intent;
    :cond_6
    if-eqz v3, :cond_7

    .line 121
    invoke-virtual {v3, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 122
    const/4 v7, 0x0

    invoke-virtual {p0, v3, v7}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto/16 :goto_0

    .line 124
    :cond_7
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->finish()V

    goto/16 :goto_0
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 159
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 160
    const-string v0, "shouldFinishIfResumed"

    iget-boolean v1, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity;->shouldFinishIfResumed:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 161
    return-void
.end method
