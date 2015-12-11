.class Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 162
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 163
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 164
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 16

    .prologue
    .line 110
    invoke-super/range {p0 .. p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 111
    if-eqz p1, :cond_0

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    if-nez v1, :cond_1

    .line 158
    :cond_0
    :goto_0
    return-void

    .line 113
    :cond_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    move-object/from16 v0, p1

    invoke-static {v1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putAuthLoginResponse(Landroid/content/Context;Ljava/lang/String;)V

    .line 116
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    move-object/from16 v0, p1

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 118
    const-string v2, "authLoginV2"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 119
    const-string v2, "data"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v13

    .line 120
    new-instance v14, Ljava/util/ArrayList;

    invoke-direct {v14}, Ljava/util/ArrayList;-><init>()V

    .line 121
    const-string v1, "playlists"

    invoke-virtual {v13, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v15

    .line 123
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xf

    if-lt v1, v2, :cond_2

    .line 124
    const-string v1, "coverhq"

    move-object v12, v1

    .line 127
    :goto_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 128
    invoke-virtual {v15}, Lorg/json/JSONArray;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    move v11, v1

    :goto_2
    if-ltz v11, :cond_4

    .line 129
    invoke-virtual {v15, v11}, Lorg/json/JSONArray;->isNull(I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 130
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, ""

    const-string v3, ""

    const-string v4, ""

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    const-string v8, ""

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v14, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 128
    :goto_3
    add-int/lit8 v1, v11, -0x1

    move v11, v1

    goto :goto_2

    .line 126
    :cond_2
    const-string v1, "cover"

    move-object v12, v1

    goto :goto_1

    .line 133
    :cond_3
    invoke-virtual {v15, v11}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 134
    const/4 v1, 0x1

    invoke-static {v2, v12, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getPlaylistItem(Lorg/json/JSONObject;Ljava/lang/String;I)Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    move-result-object v1

    invoke-virtual {v14, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 136
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    const-string v3, "_id"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_3

    .line 153
    :catch_0
    move-exception v1

    .line 154
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    .line 156
    :goto_4
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    .line 157
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    goto/16 :goto_0

    .line 138
    :cond_4
    :try_start_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v14}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    .line 139
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://i.ytimg.com/vi/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getLastHistory()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/mqdefault.jpg"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 140
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v11, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "PLAYLISTHISTORYID"

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    check-cast v3, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080111

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const-string v5, ""

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    check-cast v6, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v9, "PLAYLISTHISTORYID"

    invoke-virtual {v6, v9}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getSongCount(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    const/4 v9, 0x6

    const/4 v10, 0x0

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v11, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 143
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 144
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 145
    const-string v1, "subs_playlists"

    invoke-virtual {v13, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 146
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    move v2, v1

    :goto_5
    if-ltz v2, :cond_5

    .line 147
    invoke-virtual {v4, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 148
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const-string v6, "_id"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 149
    const/4 v1, 0x2

    invoke-static {v5, v12, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getPlaylistItem(Lorg/json/JSONObject;Ljava/lang/String;I)Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 146
    add-int/lit8 v1, v2, -0x1

    move v2, v1

    goto :goto_5

    .line 152
    :cond_5
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_4
.end method
