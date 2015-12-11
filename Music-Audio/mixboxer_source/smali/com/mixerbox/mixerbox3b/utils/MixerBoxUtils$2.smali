.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$2;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$hasToShowMyPlaylist:Z


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/content/Context;Z)V
    .locals 0

    .prologue
    .line 195
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$2;->val$ctx:Landroid/content/Context;

    iput-boolean p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$2;->val$hasToShowMyPlaylist:Z

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onSuccess(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 198
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 200
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$2;->val$ctx:Landroid/content/Context;

    iget-boolean v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$2;->val$hasToShowMyPlaylist:Z

    # invokes: Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->parseMyPlaylist(Landroid/content/Context;Ljava/lang/String;Z)V
    invoke-static {v0, p1, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->access$000(Landroid/content/Context;Ljava/lang/String;Z)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 204
    :goto_0
    return-void

    .line 201
    :catch_0
    move-exception v0

    .line 202
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
