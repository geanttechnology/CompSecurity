.class Lcom/mixerbox/mixerbox3b/MainPage$13;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;

.field final synthetic val$mid:Ljava/lang/String;

.field final synthetic val$pid:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1162
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->val$pid:Ljava/lang/String;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->val$mid:Ljava/lang/String;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onSuccess(Ljava/lang/String;)V
    .locals 12

    .prologue
    const/4 v10, 0x0

    .line 1165
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 1166
    if-eqz p1, :cond_0

    .line 1170
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1171
    const-string v1, "getVector"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 1173
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->val$pid:Ljava/lang/String;

    const-string v2, "name"

    invoke-virtual {v11, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "owner"

    invoke-virtual {v11, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "ownerName"

    invoke-virtual {v11, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, ""

    const-string v6, "subsCnt"

    invoke-virtual {v11, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v8, "url"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x3

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 1177
    const-string v1, "items"

    invoke-virtual {v11, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    move v4, v10

    .line 1178
    :goto_0
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v4, v2, :cond_3

    .line 1179
    invoke-virtual {v1, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "_id"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->val$mid:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1184
    :goto_1
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 1185
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v5

    .line 1186
    iput-object v0, v5, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 1187
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_2

    .line 1188
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->val$pid:Ljava/lang/String;

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/4 v4, -0x1

    invoke-static/range {v0 .. v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    .line 1197
    :cond_0
    :goto_2
    return-void

    .line 1178
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 1191
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$13;->val$pid:Ljava/lang/String;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-static/range {v0 .. v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    :catch_0
    move-exception v0

    goto :goto_2

    :cond_3
    move v4, v10

    goto :goto_1
.end method
