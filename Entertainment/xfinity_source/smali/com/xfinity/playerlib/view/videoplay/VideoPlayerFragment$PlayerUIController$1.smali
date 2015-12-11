.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showClickableAdButtonForUrl(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    .prologue
    .line 963
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->val$url:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 966
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 967
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->pause()V

    .line 969
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adView:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/webkit/WebView;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1$1;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 992
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adView:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/webkit/WebView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 993
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adView:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->bringToFront()V

    .line 994
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adView:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/webkit/WebView;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;->val$url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 995
    return-void
.end method
