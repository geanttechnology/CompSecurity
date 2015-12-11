.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$pid:Ljava/lang/String;

.field final synthetic val$pname:Ljava/lang/String;

.field final synthetic val$shouldToast:Z

.field final synthetic val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;ZLcom/mixerbox/mixerbox3b/classes/SongItem;)V
    .locals 0

    .prologue
    .line 827
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$pname:Ljava/lang/String;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$ctx:Landroid/content/Context;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$pid:Ljava/lang/String;

    iput-boolean p5, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$shouldToast:Z

    iput-object p6, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 847
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 848
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$shouldToast:Z

    if-eqz v0, :cond_0

    .line 849
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 851
    :cond_0
    return-void
.end method

.method public final onSuccess(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 830
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 831
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$pname:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 832
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$pid:Ljava/lang/String;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$pname:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putDefaultAddedPlaylist(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 833
    :cond_0
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$shouldToast:Z

    if-eqz v0, :cond_1

    .line 834
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080077

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 835
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 836
    const-string v1, "f"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 837
    const-string v1, "playlist"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$pid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 838
    const-string v1, "t"

    const-string v2, "yt"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 839
    const-string v1, "action:music_add"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 840
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;->val$ctx:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMyPlaylist(Landroid/content/Context;Z)V

    .line 843
    :cond_1
    return-void
.end method
