.class Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 311
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 344
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 345
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 8

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x1

    const/4 v0, 0x0

    .line 314
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 315
    if-nez p1, :cond_0

    .line 341
    :goto_0
    return-void

    .line 317
    :cond_0
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->val$params:[Ljava/lang/Integer;

    aget-object v1, v1, v0

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_1

    .line 318
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 321
    :cond_1
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 322
    const-string v2, "getVector"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 323
    const-string v2, "items"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 324
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v2

    const/16 v3, 0x14

    if-ge v2, v3, :cond_2

    .line 325
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->endList:Z

    .line 326
    :cond_2
    :goto_1
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_3

    .line 327
    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 329
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v5

    sub-int/2addr v5, v0

    add-int/lit8 v5, v5, -0x1

    invoke-static {v3, v2, v4, v0, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 326
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 331
    :catch_0
    move-exception v0

    .line 332
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 334
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->f:Landroid/view/LayoutInflater;

    if-nez v0, :cond_5

    .line 335
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->llLoading:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0

    .line 338
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->f:Landroid/view/LayoutInflater;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    invoke-direct {v1, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;-><init>(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/util/List;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 339
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->val$params:[Ljava/lang/Integer;

    aget-object v1, v1, v6

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->val$params:[Ljava/lang/Integer;

    const/4 v3, 0x2

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 340
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->llLoading:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0
.end method
