.class Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10

    .prologue
    .line 132
    const/4 v0, 0x0

    :try_start_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 133
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->item:Lorg/json/JSONObject;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$100(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "isAlbum"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 134
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->item:Lorg/json/JSONObject;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$100(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "isAlbum"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    move-object v9, v0

    .line 136
    :goto_0
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->item:Lorg/json/JSONObject;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$100(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "ref"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->title:Ljava/lang/String;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$200(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->owner:Ljava/lang/String;
    invoke-static {v4}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$300(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->size:Ljava/lang/String;
    invoke-static {v5}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$400(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "0"

    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->u:Ljava/lang/String;
    invoke-static {v7}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$500(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x3

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 138
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$600(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 139
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$600(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 140
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 157
    :goto_1
    return-void

    .line 144
    :cond_0
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$600(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 146
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$600(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v6

    .line 147
    iput-object v0, v6, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 149
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->access$600(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    invoke-static/range {v1 .. v6}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    .line 151
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 152
    const-string v2, "id"

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    const-string v0, "action:playlist_play"

    invoke-static {v0, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 154
    :catch_0
    move-exception v0

    .line 155
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    :cond_1
    move-object v9, v0

    goto/16 :goto_0
.end method
