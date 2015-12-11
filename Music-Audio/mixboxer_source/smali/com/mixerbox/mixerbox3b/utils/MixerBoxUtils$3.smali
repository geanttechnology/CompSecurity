.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$3;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$hasToClear:Z

.field final synthetic val$hasToShowMyPlaylist:Z


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/content/Context;ZZ)V
    .locals 0

    .prologue
    .line 211
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$3;->val$ctx:Landroid/content/Context;

    iput-boolean p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$3;->val$hasToShowMyPlaylist:Z

    iput-boolean p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$3;->val$hasToClear:Z

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onSuccess(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 214
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 216
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$3;->val$ctx:Landroid/content/Context;

    iget-boolean v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$3;->val$hasToShowMyPlaylist:Z

    iget-boolean v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$3;->val$hasToClear:Z

    # invokes: Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->parseMySubsPlaylist(Landroid/content/Context;Ljava/lang/String;ZZ)V
    invoke-static {v0, p1, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->access$100(Landroid/content/Context;Ljava/lang/String;ZZ)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 220
    :goto_0
    return-void

    .line 217
    :catch_0
    move-exception v0

    .line 218
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
