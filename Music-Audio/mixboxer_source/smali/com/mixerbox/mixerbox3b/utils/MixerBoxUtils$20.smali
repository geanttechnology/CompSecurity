.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$pid:Ljava/lang/String;

.field final synthetic val$shouldToast:Z


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;ZLandroid/content/Context;)V
    .locals 0

    .prologue
    .line 1014
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$pid:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$shouldToast:Z

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$ctx:Landroid/content/Context;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1034
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 1035
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 1036
    return-void
.end method

.method public final onSuccess(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1017
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 1018
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1019
    const-string v1, "id"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$pid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1020
    const-string v1, "sub"

    const-string v2, "1"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1021
    const-string v1, "action:subscribe"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 1023
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$shouldToast:Z

    if-eqz v0, :cond_0

    .line 1024
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800e9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 1025
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$ctx:Landroid/content/Context;

    invoke-static {v0, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMySubsPlaylist(Landroid/content/Context;ZZ)V

    .line 1026
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$ctx:Landroid/content/Context;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstSubscribe(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1027
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x7

    new-array v2, v3, [Z

    invoke-virtual {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    .line 1030
    :cond_0
    return-void
.end method
