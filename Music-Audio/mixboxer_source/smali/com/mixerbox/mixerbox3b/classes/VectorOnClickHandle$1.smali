.class final Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$b:Ljava/lang/String;

.field final synthetic val$id:Ljava/lang/String;

.field final synthetic val$j:Lorg/json/JSONObject;

.field final synthetic val$v:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 226
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$b:Ljava/lang/String;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$id:Ljava/lang/String;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$v:Landroid/view/View;

    iput-object p5, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$j:Lorg/json/JSONObject;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 253
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 255
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$v:Landroid/view/View;

    check-cast v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$j:Lorg/json/JSONObject;

    const-string v2, "title"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 259
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 260
    return-void

    .line 256
    :catch_0
    move-exception v0

    .line 257
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public final onSuccess(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 229
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 230
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 231
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$b:Ljava/lang/String;

    const-string v1, "true"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 232
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getDJs(Landroid/content/Context;)V

    .line 245
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v3, 0x7f0800e9

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 246
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 247
    const-string v1, "dj_id"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$id:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 248
    const-string v1, "follow"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$b:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 249
    const-string v1, "action:follow"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 250
    return-void

    :cond_1
    move v1, v2

    .line 235
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 237
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/MyItem;

    invoke-interface {v0}, Lcom/mixerbox/mixerbox3b/classes/MyItem;->getMyJSONObject()Lorg/json/JSONObject;

    move-result-object v0

    const-string v3, "ref"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 238
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 239
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;->notifyDataSetChanged()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 235
    :cond_2
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_1
.end method
