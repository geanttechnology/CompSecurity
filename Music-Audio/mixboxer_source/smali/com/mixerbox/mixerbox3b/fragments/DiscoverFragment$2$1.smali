.class Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 123
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 124
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 92
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 93
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-nez v0, :cond_1

    .line 119
    :cond_0
    :goto_0
    return-void

    .line 95
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 97
    if-nez p1, :cond_2

    .line 98
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    goto :goto_0

    .line 101
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 103
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 104
    const-string v1, "searchPage"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 105
    const-string v1, "items"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 106
    const/4 v0, 0x0

    move v1, v0

    :goto_1
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_3

    .line 107
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 108
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v5

    sub-int/2addr v5, v1

    add-int/lit8 v5, v5, -0x1

    invoke-static {v0, v3, v4, v1, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 106
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 110
    :catch_0
    move-exception v0

    .line 111
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 114
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    iget-object v4, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->f:Landroid/view/LayoutInflater;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    invoke-direct {v2, v3, v4, v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;-><init>(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/util/List;)V

    invoke-virtual {v1, v2}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 118
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    goto/16 :goto_0
.end method
