.class Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 120
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 121
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 122
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 90
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 91
    if-eqz p1, :cond_3

    .line 94
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 95
    const-string v1, "getMyFollowing"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 96
    const-string v1, "items"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 97
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    .line 98
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 99
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->isNull(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 100
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 103
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v5

    sub-int/2addr v5, v1

    add-int/lit8 v5, v5, -0x1

    invoke-static {v0, v3, v4, v1, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V

    .line 98
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 105
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    if-nez v0, :cond_2

    .line 116
    :goto_1
    return-void

    .line 107
    :catch_0
    move-exception v0

    .line 108
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 114
    :cond_2
    :goto_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->loadContent()V

    .line 115
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    goto :goto_1

    .line 112
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    goto :goto_2
.end method
