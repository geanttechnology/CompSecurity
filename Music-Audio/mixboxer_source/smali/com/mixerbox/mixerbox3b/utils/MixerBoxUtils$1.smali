.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$session:Lcom/facebook/Session;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/content/Context;Lcom/facebook/Session;)V
    .locals 0

    .prologue
    .line 98
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$session:Lcom/facebook/Session;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 109
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 110
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 111
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 112
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 113
    const-string v2, "isLogIn"

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 114
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 115
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    const-class v2, Lcom/mixerbox/mixerbox3b/LoginBridge;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 116
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 117
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 129
    :goto_0
    return-void

    .line 120
    :cond_0
    sget v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->retryCount:I

    if-lez v0, :cond_1

    .line 121
    const/4 v0, 0x0

    sput v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->retryCount:I

    .line 122
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08005e

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080049

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto :goto_0

    .line 125
    :cond_1
    sget v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->retryCount:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->retryCount:I

    .line 126
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08004a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 127
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$session:Lcom/facebook/Session;

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getAuthLoginInfo(Landroid/content/Context;Lcom/facebook/Session;)V

    goto :goto_0
.end method

.method public final onSuccess(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 101
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 102
    const-string v0, "action:logged_in"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 103
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putAuthLoginResponse(Landroid/content/Context;Ljava/lang/String;)V

    .line 104
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;->val$ctx:Landroid/content/Context;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->finishFetchInitData(Landroid/content/Context;)V

    .line 105
    return-void
.end method
