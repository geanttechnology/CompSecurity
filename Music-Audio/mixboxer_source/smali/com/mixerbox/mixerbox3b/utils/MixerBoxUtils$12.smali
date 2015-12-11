.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$12;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 624
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$12;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$12;->val$ctx:Landroid/content/Context;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onSuccess(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 627
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 629
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$12;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    .line 632
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 633
    const-string v1, "followInfoV2"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 634
    const-string v1, "items"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 635
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 636
    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 638
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$12;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$12;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v5

    sub-int/2addr v5, v0

    add-int/lit8 v5, v5, -0x1

    invoke-static {v3, v2, v4, v0, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 635
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 640
    :catch_0
    move-exception v0

    .line 641
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 644
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$12;->val$f:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->setContent()V

    .line 645
    return-void
.end method
