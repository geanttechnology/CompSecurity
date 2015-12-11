.class Lcom/mixerbox/mixerbox3b/MainPage$12;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;

.field final synthetic val$yid:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1132
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$12;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/MainPage$12;->val$yid:Ljava/lang/String;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onSuccess(Ljava/lang/String;)V
    .locals 8

    .prologue
    .line 1135
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 1136
    if-eqz p1, :cond_0

    .line 1138
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1139
    const-string v1, "entry"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 1140
    const-string v1, "media$group"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 1141
    const-string v1, "media$title"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "$t"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1142
    const-string v1, "yt$duration"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "seconds"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1143
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://i.ytimg.com/vi/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$12;->val$yid:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/mqdefault.jpg"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 1144
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const-string v1, ""

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/MainPage$12;->val$yid:Ljava/lang/String;

    const/4 v5, 0x0

    const/4 v6, 0x1

    invoke-direct/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 1146
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1147
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1148
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$12;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object v1, v2, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    .line 1149
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$12;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 1150
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$12;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 1151
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$12;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 1152
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$12;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1156
    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method
