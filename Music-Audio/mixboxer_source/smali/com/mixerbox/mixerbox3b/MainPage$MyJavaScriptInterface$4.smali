.class Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;)V
    .locals 0

    .prologue
    .line 2539
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 2542
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isReady:Z

    .line 2543
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlayAfterReady:Z

    if-eqz v0, :cond_0

    .line 2544
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlayAfterReady:Z

    .line 2545
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    .line 2547
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    if-ne v0, v2, :cond_1

    .line 2548
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:setScreenSize("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 2551
    :goto_0
    return-void

    .line 2550
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:setScreenSize("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$4;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method
