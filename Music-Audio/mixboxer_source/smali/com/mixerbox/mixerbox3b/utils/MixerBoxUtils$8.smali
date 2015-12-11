.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

.field final synthetic val$title:Ljava/lang/String;

.field final synthetic val$type:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 469
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$type:Ljava/lang/String;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$title:Ljava/lang/String;

    iput-object p5, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$ctx:Landroid/content/Context;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onSuccess(Ljava/lang/String;)V
    .locals 11

    .prologue
    const/4 v10, 0x2

    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 472
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 473
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    .line 474
    if-eqz p1, :cond_5

    .line 479
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 480
    const-string v3, "getVector"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 481
    const-string v2, "items"

    invoke-virtual {v3, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 482
    const/4 v2, 0x0

    invoke-virtual {v4, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    const-string v5, "type"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    invoke-virtual {v4, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    const-string v5, "type"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v5, "divider"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$type:Ljava/lang/String;

    const-string v5, "dj"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 484
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    new-instance v5, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;

    new-instance v6, Lorg/json/JSONObject;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "{\"type\":\"divider\",\"title\":\""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$title:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "\"}"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$ctx:Landroid/content/Context;

    invoke-direct {v5, v6, v7}, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;-><init>(Lorg/json/JSONObject;Landroid/content/Context;)V

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 487
    :cond_0
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    .line 488
    const-string v2, "type"

    const-string v6, "dj_info"

    invoke-virtual {v5, v2, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move v2, v0

    .line 489
    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v6

    if-ge v2, v6, :cond_4

    .line 490
    invoke-virtual {v4, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    .line 491
    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$type:Ljava/lang/String;

    const-string v8, "dj"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    if-gt v2, v10, :cond_2

    .line 492
    if-ge v2, v10, :cond_1

    .line 493
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 489
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 496
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$ctx:Landroid/content/Context;

    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    invoke-static {v0, v5, v7, v2, v8}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V

    move v0, v1

    .line 501
    :cond_2
    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v7, v7, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    iget-object v8, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$ctx:Landroid/content/Context;

    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v9

    sub-int/2addr v9, v2

    add-int/lit8 v9, v9, -0x1

    sub-int/2addr v9, v0

    invoke-static {v7, v6, v8, v2, v9}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 506
    :catch_0
    move-exception v0

    .line 507
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 512
    :cond_3
    :goto_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->setContent()V

    .line 513
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->canScroll:Z

    .line 519
    return-void

    .line 503
    :cond_4
    if-eqz v3, :cond_3

    :try_start_1
    const-string v0, "isArtist"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    const-string v0, "isArtist"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2

    .line 510
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$ctx:Landroid/content/Context;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;->val$ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080048

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto :goto_2
.end method
