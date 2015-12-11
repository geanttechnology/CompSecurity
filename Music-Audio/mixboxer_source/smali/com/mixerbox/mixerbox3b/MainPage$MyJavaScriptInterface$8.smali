.class Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

.field final synthetic val$s:I


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;I)V
    .locals 0

    .prologue
    .line 2618
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iput p2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->val$s:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 2621
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldCloseApp:Z

    if-ne v0, v2, :cond_1

    .line 2657
    :cond_0
    :goto_0
    return-void

    .line 2624
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->val$s:I

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    .line 2626
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v2, :cond_2

    .line 2627
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->errorCount:I

    .line 2629
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 2630
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->tvNoNet:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 2631
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopPlayer()V

    goto :goto_0

    .line 2633
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v2, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->tvNoNet:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_4

    .line 2634
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->tvNoNet:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 2635
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    .line 2638
    :cond_4
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_5

    .line 2639
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetCanAuto:Z

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v2, :cond_5

    .line 2640
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetCanAuto:Z

    .line 2641
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlHint:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2642
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->setWebViewTouchListener()V
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$600(Lcom/mixerbox/mixerbox3b/MainPage;)V

    .line 2645
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->tvSwitch:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_6

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v2, :cond_6

    .line 2646
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->tvSwitch:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 2647
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPlayerType(Landroid/content/Context;I)V

    .line 2648
    sput v2, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    .line 2649
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->setWebViewTouchListener()V
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$600(Lcom/mixerbox/mixerbox3b/MainPage;)V

    .line 2652
    :cond_6
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v2, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldResetTime:Z

    if-eqz v0, :cond_0

    .line 2653
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldResetTime:Z

    .line 2654
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:seekTo("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->resetTime:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 2655
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$8;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->resetTime:I

    goto/16 :goto_0
.end method
