.class Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 242
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 243
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 10

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v1, 0x0

    .line 194
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 196
    if-eqz p1, :cond_3

    .line 197
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    if-nez v0, :cond_2

    .line 199
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    .line 202
    :goto_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 203
    const-string v2, "getVector"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 204
    const-string v2, "items"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 205
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v3, "type"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v3, "type"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v3, "divider"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorType:Ljava/lang/String;

    const-string v3, "dj"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 206
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;

    new-instance v4, Lorg/json/JSONObject;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "{\"type\":\"divider\",\"title\":\""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->title:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\"}"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v5}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;-><init>(Lorg/json/JSONObject;Landroid/content/Context;)V

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 208
    :cond_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 209
    const-string v0, "type"

    const-string v4, "dj_info"

    invoke-virtual {v3, v0, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 210
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 211
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    const/4 v4, 0x1

    iput-boolean v4, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->endList:Z

    :cond_1
    move v0, v1

    .line 212
    :goto_1
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_3

    .line 213
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 214
    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorType:Ljava/lang/String;

    const-string v6, "dj"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    if-gt v0, v9, :cond_6

    .line 215
    if-ge v0, v9, :cond_5

    .line 216
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 212
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 201
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 227
    :catch_0
    move-exception v0

    .line 228
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 230
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->f:Landroid/view/LayoutInflater;

    if-nez v0, :cond_7

    .line 231
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 232
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iput-boolean v8, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->canScroll:Z

    .line 239
    :goto_3
    return-void

    .line 220
    :cond_5
    :try_start_1
    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    invoke-static {v5, v3, v6, v0, v7}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V

    .line 221
    :cond_6
    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v7

    sub-int/2addr v7, v0

    add-int/lit8 v7, v7, -0x1

    invoke-static {v5, v4, v6, v0, v7}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2

    .line 235
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->f:Landroid/view/LayoutInflater;

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    invoke-direct {v2, v3, v4, v5}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;-><init>(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/util/List;)V

    invoke-virtual {v0, v2}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 236
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 237
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 238
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iput-boolean v8, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->canScroll:Z

    goto :goto_3
.end method
