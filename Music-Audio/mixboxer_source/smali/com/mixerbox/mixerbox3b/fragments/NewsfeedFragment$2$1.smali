.class Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 147
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 148
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 149
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 87
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 88
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    if-nez p1, :cond_1

    .line 143
    :cond_0
    :goto_0
    return-void

    .line 89
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    if-eqz v0, :cond_3

    .line 90
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 94
    :goto_1
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getLastPushed()Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    move-result-object v0

    .line 95
    if-eqz v0, :cond_2

    .line 96
    new-instance v2, Lorg/json/JSONObject;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "{margin: true,type: \"general\",views: {header: {mainText: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f080112

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\"},main: {mainLink: {type: \"playlist\",ref: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",title: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",owner: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",size: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",thumbnail: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",thumbnailHQ: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",ownerId: \"\"},mainText: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",subText: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",sideText: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",thumbnail: {style: \"square\",url: \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "\"}},footer: {bgColor: true,links: [{type: \"button\",title: \""

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800e7

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "\",action: \"subscribe\",switch: {type: \"button\",title: \""

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800e8

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "\",action: \"unsubscribe\"}},{type: \"dummy\"},{type: \"dummy\"}]}}}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 124
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {v0, v2, v3, v4, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 130
    :cond_2
    :goto_2
    :try_start_1
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 131
    const-string v2, "newsPage"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 132
    const-string v2, "items"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 133
    :goto_3
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_4

    .line 134
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 135
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v5

    sub-int/2addr v5, v1

    add-int/lit8 v5, v5, -0x1

    invoke-static {v0, v3, v4, v1, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 133
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    .line 92
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    goto/16 :goto_1

    .line 126
    :catch_0
    move-exception v0

    .line 127
    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    goto :goto_2

    .line 137
    :catch_1
    move-exception v0

    .line 138
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 140
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;->notifyDataSetChanged()V

    .line 141
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 142
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->canScroll:Z

    goto/16 :goto_0
.end method
