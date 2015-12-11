.class Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;
.super Lcom/loopj/android/http/AsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;

.field final synthetic val$i2:I

.field final synthetic val$p:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 400
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->val$p:Ljava/lang/String;

    iput p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->val$i2:I

    invoke-direct {p0}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 410
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "FAILURE "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " / "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 411
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->val$p:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 412
    iget v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->val$i2:I

    const/4 v1, 0x2

    if-gt v0, v1, :cond_0

    .line 413
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$ctx:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMyPlaylist(Landroid/content/Context;Z)V

    .line 414
    :cond_0
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 403
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->val$p:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 404
    iget v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->val$i2:I

    const/4 v1, 0x2

    if-gt v0, v1, :cond_0

    .line 405
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;->this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$ctx:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMyPlaylist(Landroid/content/Context;Z)V

    .line 406
    :cond_0
    return-void
.end method
