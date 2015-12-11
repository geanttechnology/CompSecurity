.class Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;
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
    .line 2557
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 2560
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isReady:Z

    .line 2561
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    if-ne v0, v1, :cond_1

    .line 2562
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:setScreenSize("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

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

    .line 2565
    :goto_0
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    if-nez v0, :cond_2

    .line 2566
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlHint:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2567
    sput v4, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    .line 2568
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPlayerType(Landroid/content/Context;I)V

    .line 2569
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    .line 2574
    :cond_0
    :goto_1
    return-void

    .line 2564
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:setScreenSize("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

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

    .line 2570
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlayAfterReady:Z

    if-eqz v0, :cond_0

    .line 2571
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlayAfterReady:Z

    .line 2572
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$5;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_1
.end method
