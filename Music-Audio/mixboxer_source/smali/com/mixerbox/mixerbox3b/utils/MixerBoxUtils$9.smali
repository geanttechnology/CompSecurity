.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 526
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$ctx:Landroid/content/Context;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onSuccess(Ljava/lang/String;)V
    .locals 8

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 529
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 530
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    .line 532
    if-eqz p1, :cond_2

    .line 535
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 536
    const-string v3, "searchVideo"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 537
    const-string v3, "items"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    move v0, v2

    .line 538
    :goto_0
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_0

    .line 539
    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 540
    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$ctx:Landroid/content/Context;

    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v7

    sub-int/2addr v7, v0

    add-int/lit8 v7, v7, -0x1

    invoke-static {v5, v4, v6, v0, v7}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V

    .line 538
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 542
    :cond_0
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v0

    const/4 v4, 0x2

    if-lt v0, v4, :cond_3

    const/4 v0, 0x1

    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "isArtist"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    const/4 v0, 0x1

    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v3, "isArtist"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    :goto_1
    move v3, v0

    .line 552
    :goto_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->setContent()V

    .line 553
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$ctx:Landroid/content/Context;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstSearch(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 554
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/16 v4, 0xa

    new-array v1, v1, [Z

    aput-boolean v3, v1, v2

    invoke-virtual {v0, v4, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    .line 556
    :cond_1
    return-void

    .line 546
    :catch_0
    move-exception v0

    .line 547
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    move v3, v2

    .line 549
    goto :goto_2

    .line 550
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$ctx:Landroid/content/Context;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;->val$ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080048

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    move v3, v2

    goto :goto_2

    :cond_3
    move v0, v2

    goto :goto_1
.end method
