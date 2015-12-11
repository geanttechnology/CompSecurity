.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$19;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$name:Ljava/lang/String;

.field final synthetic val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 995
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$19;->val$ctx:Landroid/content/Context;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$19;->val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$19;->val$name:Ljava/lang/String;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onSuccess(Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 998
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 999
    const-string v0, "action:playlist_create"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 1000
    const-string v0, ""

    .line 1002
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1003
    const-string v2, "mChangePlaylist"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 1007
    :goto_0
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$19;->val$ctx:Landroid/content/Context;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$19;->val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$19;->val$name:Ljava/lang/String;

    invoke-static {v1, v0, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addSong(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;ZLjava/lang/String;)V

    .line 1008
    return-void

    .line 1004
    :catch_0
    move-exception v1

    .line 1005
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
