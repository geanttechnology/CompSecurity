.class Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 232
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onSuccess(Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 235
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 236
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 260
    :goto_0
    return-void

    .line 237
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    if-nez v0, :cond_1

    .line 238
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    .line 239
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->val$params:[Ljava/lang/Integer;

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v2, -0x1

    if-ne v0, v2, :cond_2

    .line 240
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 243
    :cond_2
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 244
    const-string v2, "newsPage"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 245
    const-string v2, "items"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 246
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    const/16 v3, 0x14

    if-ge v0, v3, :cond_3

    .line 247
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    const/4 v3, 0x1

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->endList:Z

    .line 248
    :cond_3
    :goto_1
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_4

    .line 249
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 250
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v5

    sub-int/2addr v5, v1

    add-int/lit8 v5, v5, -0x1

    invoke-static {v0, v3, v4, v1, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 248
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 252
    :catch_0
    move-exception v0

    .line 253
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 255
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;->notifyDataSetChanged()V

    .line 256
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 257
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;->this$2:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->llLoading:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0
.end method
