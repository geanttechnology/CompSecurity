.class Lcom/mixerbox/mixerbox3b/MainPage$42;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;

.field final synthetic val$b:[Z


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;[Z)V
    .locals 0

    .prologue
    .line 3171
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->val$b:[Z

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 3200
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 3201
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDiscover:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->loadContent()V

    .line 3202
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 3174
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 3175
    if-nez p1, :cond_1

    .line 3196
    :cond_0
    :goto_0
    return-void

    .line 3177
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 3179
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 3180
    const-string v2, "searchPage"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 3181
    const-string v2, "items"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    move v0, v1

    .line 3182
    :goto_1
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_2

    .line 3183
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 3184
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v6

    sub-int/2addr v6, v0

    add-int/lit8 v6, v6, -0x1

    invoke-static {v4, v3, v5, v0, v6}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 3182
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 3186
    :catch_0
    move-exception v0

    .line 3187
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 3189
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDiscover:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->loadContent()V

    .line 3190
    const/4 v0, 0x1

    .line 3191
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->val$b:[Z

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->val$b:[Z

    array-length v2, v2

    if-lez v2, :cond_3

    .line 3192
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->val$b:[Z

    aget-boolean v0, v0, v1

    .line 3193
    :cond_3
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstDiscover(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_0

    if-eqz v0, :cond_0

    .line 3194
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$42;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x3

    new-array v1, v1, [Z

    invoke-virtual {v0, v2, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    goto :goto_0
.end method
