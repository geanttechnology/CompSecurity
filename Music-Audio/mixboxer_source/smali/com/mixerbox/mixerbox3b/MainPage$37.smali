.class Lcom/mixerbox/mixerbox3b/MainPage$37;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 2701
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$37;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2737
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 2738
    invoke-static {p2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 2739
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 2704
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 2705
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 2707
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 2708
    const-string v1, "data"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2733
    :cond_0
    :goto_0
    return-void

    .line 2710
    :cond_1
    const-string v1, "data"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 2711
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->isNull(I)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2713
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 2714
    const-string v1, "publish_actions"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 2715
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$37;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v1

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->requestPublishPermissions(Lcom/facebook/Session;)V
    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->access$700(Lcom/mixerbox/mixerbox3b/MainPage;Lcom/facebook/Session;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 2730
    :catch_0
    move-exception v0

    .line 2731
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 2718
    :cond_2
    :try_start_1
    const-string v1, "publish_actions"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 2719
    if-ne v0, v2, :cond_4

    .line 2720
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$37;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getPostFB(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 2721
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$37;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPostFB(Landroid/content/Context;Z)V

    .line 2722
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$37;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2723
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$37;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->shouldOpenConfirmDialog:Z

    .line 2724
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$37;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->checkbox:Landroid/widget/CheckBox;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_0

    .line 2727
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$37;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v1

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->requestPublishPermissions(Lcom/facebook/Session;)V
    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->access$700(Lcom/mixerbox/mixerbox3b/MainPage;Lcom/facebook/Session;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
