.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$i1:I

.field final synthetic val$pid:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;ILandroid/content/Context;)V
    .locals 0

    .prologue
    .line 332
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;->val$pid:Ljava/lang/String;

    iput p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;->val$i1:I

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;->val$ctx:Landroid/content/Context;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 347
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 348
    iget v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;->val$i1:I

    if-gt v0, v2, :cond_0

    .line 349
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;->val$ctx:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMySubsPlaylist(Landroid/content/Context;ZZ)V

    .line 350
    :cond_0
    return-void
.end method

.method public final onSuccess(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 335
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 336
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 337
    const-string v1, "id"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;->val$pid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 338
    const-string v1, "sub"

    const-string v2, "1"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 339
    const-string v1, "action:subscribe"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 340
    iget v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;->val$i1:I

    if-gt v0, v3, :cond_0

    .line 341
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;->val$ctx:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-static {v0, v1, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMySubsPlaylist(Landroid/content/Context;ZZ)V

    .line 343
    :cond_0
    return-void
.end method
