.class public Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field ctx:Landroid/content/Context;

.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 2403
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2404
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    .line 2405
    return-void
.end method


# virtual methods
.method public log(Ljava/lang/String;)V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2613
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

    .line 2614
    return-void
.end method

.method public onPageLoaded()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2580
    const/4 v0, 0x1

    sput-boolean v0, Lcom/mixerbox/mixerbox3b/MainPage;->isPageLoaded:Z

    .line 2581
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$6;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$6;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2592
    return-void
.end method

.method public onReady()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2539
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2553
    return-void
.end method

.method public onReadyV2()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2557
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2576
    return-void
.end method

.method public onShouldPlayChange(I)V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2663
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$9;

    invoke-direct {v1, p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$9;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;I)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2674
    return-void
.end method

.method public onStateChanged(I)V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2618
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;

    invoke-direct {v1, p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;I)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2659
    return-void
.end method

.method public playMediaPlayer()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2678
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$10;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$10;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2684
    return-void
.end method

.method public playNext()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2435
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$2;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2445
    return-void
.end method

.method public postFBAction()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2450
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$3;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2535
    return-void
.end method

.method public sendError()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2596
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$7;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$7;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2609
    return-void
.end method

.method public showTime(Ljava/lang/String;)V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 2409
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$1;

    invoke-direct {v1, p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$1;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2431
    return-void
.end method
