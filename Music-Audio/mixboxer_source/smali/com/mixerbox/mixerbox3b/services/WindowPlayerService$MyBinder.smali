.class public Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;
.super Landroid/os/Binder;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;


# direct methods
.method public constructor <init>(Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    return-void
.end method


# virtual methods
.method public getCurrentTime()I
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->current:I

    return v0
.end method

.method public getIsPlaying()Z
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->flag:Z

    return v0
.end method

.method public pauseMusic()V
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->flag:Z

    .line 51
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 52
    return-void
.end method

.method public playMusic()V
    .locals 2

    .prologue
    .line 54
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->flag:Z

    .line 55
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:playVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 56
    return-void
.end method

.method public playMusic(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 38
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->isReady:Z

    if-nez v0, :cond_0

    .line 39
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    # invokes: Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->loadUrl()V
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->access$000(Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;)V

    .line 40
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->shouldPlayAfterReady:Z

    .line 41
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iput-object p1, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->musicId:Ljava/lang/String;

    .line 42
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->flag:Z

    .line 48
    :goto_0
    return-void

    .line 45
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->flag:Z

    .line 46
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:loadVideoById(\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\',0)"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method
