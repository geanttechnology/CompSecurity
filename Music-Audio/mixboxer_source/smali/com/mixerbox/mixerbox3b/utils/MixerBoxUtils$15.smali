.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$pid:Ljava/lang/String;

.field final synthetic val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;)V
    .locals 0

    .prologue
    .line 857
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$pid:Ljava/lang/String;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 899
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 900
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 901
    return-void
.end method

.method public final onSuccess(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 860
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 861
    if-eqz p1, :cond_2

    .line 863
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 865
    const-string v2, "mChangePlaylist"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "mChangePlaylist"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "status"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 866
    const-string v0, "mChangePlaylist"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "status"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 867
    :cond_0
    if-eqz v0, :cond_3

    .line 869
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "SongFragment"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 870
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$pid:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 872
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 873
    const/4 v0, -0x1

    if-eq v1, v0, :cond_1

    .line 874
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 875
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->notifyDataSetChanged()V

    .line 879
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080078

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 880
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 881
    const-string v1, "f"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 882
    const-string v1, "id"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 883
    const-string v1, "playlist"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$pid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 884
    const-string v1, "t"

    const-string v2, "yt"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 885
    const-string v1, "action:music_del"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 894
    :cond_2
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMyPlaylist(Landroid/content/Context;Z)V

    .line 895
    return-void

    .line 887
    :cond_3
    :try_start_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 889
    :catch_0
    move-exception v0

    .line 890
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
