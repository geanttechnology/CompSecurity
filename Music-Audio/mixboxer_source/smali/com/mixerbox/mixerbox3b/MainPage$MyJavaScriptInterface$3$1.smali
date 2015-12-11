.class Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$2:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 2501
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3$1;->this$2:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 2510
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 2511
    if-nez p2, :cond_1

    .line 2529
    :cond_0
    :goto_0
    return-void

    .line 2513
    :cond_1
    invoke-static {p2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 2515
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 2516
    const-string v1, "error"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2518
    const-string v1, "error"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2519
    const-string v1, "code"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2520
    const-string v1, "200"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2521
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3$1;->this$2:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPostFB(Landroid/content/Context;Z)V

    .line 2522
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3$1;->this$2:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2523
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3$1;->this$2:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->checkbox:Landroid/widget/CheckBox;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 2526
    :catch_0
    move-exception v0

    .line 2527
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2504
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 2505
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 2506
    return-void
.end method
