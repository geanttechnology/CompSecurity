.class Lcom/mixerbox/mixerbox3b/MainPage$47;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 3817
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$47;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 3842
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 3843
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$47;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$47;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 3845
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 3820
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 3821
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 3823
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 3824
    const-string v1, "changePlaylist"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "changePlaylist"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "status"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 3825
    const-string v1, "changePlaylist"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "status"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 3826
    if-eqz v0, :cond_1

    .line 3827
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$47;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$47;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800e9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 3838
    :cond_0
    :goto_0
    return-void

    .line 3830
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$47;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$47;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 3834
    :catch_0
    move-exception v0

    .line 3835
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
