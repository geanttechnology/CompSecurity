.class public Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;


# direct methods
.method public constructor <init>(Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;)V
    .locals 0

    .prologue
    .line 144
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public log(Ljava/lang/String;)V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 173
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "FROM JS: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 174
    return-void
.end method

.method public onPlayerReady()V
    .locals 4
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 163
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->isReady:Z

    .line 164
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->shouldPlayAfterReady:Z

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:loadVideoById(\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->musicId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\',0)"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 166
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->flag:Z

    .line 168
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->shouldPlayAfterReady:Z

    .line 169
    return-void
.end method

.method public playNext()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 147
    const/4 v0, 0x0

    const v1, 0xbc5c01

    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    .line 149
    :try_start_0
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->messenger:Landroid/os/Messenger;

    invoke-virtual {v1, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 153
    :goto_0
    return-void

    .line 150
    :catch_0
    move-exception v0

    .line 151
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    goto :goto_0
.end method

.method public setCurrentTime(I)V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 157
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iput p1, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->current:I

    .line 158
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "FROM JS: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 159
    return-void
.end method
