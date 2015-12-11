.class Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$2;
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
    .line 2435
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$2;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 2438
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$2;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2439
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$2;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopPlayer()V

    .line 2443
    :goto_0
    return-void

    .line 2442
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface$2;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->playNextSong()V

    goto :goto_0
.end method
