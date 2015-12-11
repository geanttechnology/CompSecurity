.class Lcom/mixerbox/mixerbox3b/MainPage$41;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 3107
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 3138
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 3141
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 3142
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->loadContent()V

    .line 3143
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 3110
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 3111
    if-nez p1, :cond_1

    .line 3112
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 3113
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->loadContent()V

    .line 3134
    :cond_0
    :goto_0
    return-void

    .line 3117
    :cond_1
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 3118
    const-string v2, "newsPage"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 3119
    const-string v2, "items"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    move v0, v1

    .line 3120
    :goto_1
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_2

    .line 3121
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 3122
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v6

    sub-int/2addr v6, v0

    add-int/lit8 v6, v6, -0x1

    invoke-static {v4, v3, v5, v0, v6}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 3120
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 3124
    :catch_0
    move-exception v0

    .line 3125
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 3127
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;->notifyDataSetChanged()V

    .line 3128
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 3129
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->loadContent()V

    .line 3130
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    const/4 v2, 0x1

    iput-boolean v2, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->canScroll:Z

    .line 3131
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstNewsfeed(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3132
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$41;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x2

    new-array v1, v1, [Z

    invoke-virtual {v0, v2, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    goto :goto_0
.end method
