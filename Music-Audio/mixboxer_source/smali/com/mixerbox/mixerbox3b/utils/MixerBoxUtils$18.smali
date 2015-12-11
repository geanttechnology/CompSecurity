.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$name:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 957
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$name:Ljava/lang/String;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 987
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 988
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 989
    return-void
.end method

.method public final onSuccess(Ljava/lang/String;)V
    .locals 10

    .prologue
    const/4 v8, 0x1

    const/4 v9, 0x0

    .line 960
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 961
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080081

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v8}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 962
    const-string v0, "action:playlist_create"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 964
    const-string v1, ""

    .line 966
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 967
    const-string v2, "mChangePlaylist"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 971
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 972
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$name:Ljava/lang/String;

    const-string v3, ""

    const-string v4, ""

    const-string v5, "0"

    const-string v6, "0"

    const-string v7, ""

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 974
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    check-cast v2, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 975
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    check-cast v2, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 976
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    check-cast v2, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v2, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v5

    .line 977
    iput-object v0, v5, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 978
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    const/4 v4, -0x1

    move v2, v9

    move v3, v8

    invoke-static/range {v0 .. v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    .line 980
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    invoke-static {v0, v9}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMyPlaylist(Landroid/content/Context;Z)V

    .line 981
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    if-eqz v0, :cond_0

    .line 982
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 983
    :cond_0
    return-void

    .line 968
    :catch_0
    move-exception v0

    .line 969
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
