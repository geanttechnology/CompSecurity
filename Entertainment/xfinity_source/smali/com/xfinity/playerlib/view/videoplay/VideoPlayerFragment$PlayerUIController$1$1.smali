.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1$1;
.super Landroid/webkit/WebViewClient;
.source "VideoPlayerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field isFirstUrl:Z

.field final synthetic this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;)V
    .locals 1
    .param p1, "this$2"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;

    .prologue
    .line 969
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1$1;->this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    .line 970
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1$1;->isFirstUrl:Z

    return-void
.end method


# virtual methods
.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "incomingUrl"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 974
    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1$1;->isFirstUrl:Z

    if-eqz v1, :cond_0

    .line 975
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1$1;->isFirstUrl:Z

    .line 976
    invoke-virtual {p1, p2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 988
    :goto_0
    return v2

    .line 978
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 979
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 980
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1$1;->this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startActivity(Landroid/content/Intent;)V

    .line 985
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1$1;->this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->hideAdViewOnResume:Z
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2202(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    goto :goto_0
.end method
