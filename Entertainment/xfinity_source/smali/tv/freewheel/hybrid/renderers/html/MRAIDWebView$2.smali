.class Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;
.super Landroid/webkit/WebChromeClient;
.source "MRAIDWebView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->init(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private customSurfaceView:Landroid/view/SurfaceView;

.field private customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

.field private holder:Landroid/view/ViewGroup;

.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 146
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    .line 159
    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    .line 160
    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

    .line 161
    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->customSurfaceView:Landroid/view/SurfaceView;

    return-void
.end method


# virtual methods
.method public getVideoLoadingProgressView()Landroid/view/View;
    .locals 3

    .prologue
    .line 149
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    const-string v2, "getVideoLoadingProgressView"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 150
    new-instance v0, Landroid/widget/ProgressBar;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V

    .line 151
    .local v0, "bar":Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public onConsoleMessage(Ljava/lang/String;ILjava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "lineNumber"    # I
    .param p3, "sourceID"    # Ljava/lang/String;

    .prologue
    .line 156
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " -- From line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 157
    return-void
.end method

.method public onHideCustomView()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 212
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    const-string v1, "onHideCustomView"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 213
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customView:Landroid/view/View;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$200(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_0

    .line 228
    :goto_0
    return-void

    .line 215
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->setVisibility(I)V

    .line 216
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

    invoke-interface {v0}, Landroid/webkit/WebChromeClient$CustomViewCallback;->onCustomViewHidden()V

    .line 217
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customView:Landroid/view/View;
    invoke-static {v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$200(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 218
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customView:Landroid/view/View;
    invoke-static {v0, v2}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$202(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Landroid/view/View;)Landroid/view/View;

    .line 219
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v0, v2}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$102(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Landroid/widget/VideoView;)Landroid/widget/VideoView;

    .line 220
    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    .line 222
    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

    .line 223
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_1

    .line 224
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$300(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->hideFullScreenBackground()V

    .line 227
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->requestFocus()Z

    goto :goto_0
.end method

.method public onShowCustomView(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "callback"    # Landroid/webkit/WebChromeClient$CustomViewCallback;

    .prologue
    const/4 v7, -0x1

    const/4 v6, 0x0

    .line 165
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v4

    const-string v5, "onShowCustomView"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 166
    invoke-super {p0, p1, p2}, Landroid/webkit/WebChromeClient;->onShowCustomView(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V

    .line 167
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$100(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Landroid/widget/VideoView;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 168
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v4

    const-string v5, "The custom video is alive, no need to show it again"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 208
    :goto_0
    return-void

    .line 172
    :cond_0
    instance-of v4, p1, Landroid/widget/FrameLayout;

    if-eqz v4, :cond_4

    move-object v1, p1

    .line 173
    check-cast v1, Landroid/widget/FrameLayout;

    .line 174
    .local v1, "layout":Landroid/widget/FrameLayout;
    invoke-virtual {v1}, Landroid/widget/FrameLayout;->getFocusedChild()Landroid/view/View;

    move-result-object v3

    .line 175
    .local v3, "player":Landroid/view/View;
    instance-of v4, v3, Landroid/widget/VideoView;

    if-eqz v4, :cond_2

    .line 176
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v1}, Landroid/widget/FrameLayout;->getFocusedChild()Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/VideoView;

    # setter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v5, v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$102(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Landroid/widget/VideoView;)Landroid/widget/VideoView;

    .line 177
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$100(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Landroid/widget/VideoView;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v4, v5}, Landroid/widget/VideoView;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 178
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$100(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Landroid/widget/VideoView;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v4, v5}, Landroid/widget/VideoView;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 192
    .end local v1    # "layout":Landroid/widget/FrameLayout;
    .end local v3    # "player":Landroid/view/View;
    :goto_1
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customView:Landroid/view/View;
    invoke-static {v4, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$202(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Landroid/view/View;)Landroid/view/View;

    .line 193
    iput-object p2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

    .line 195
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->getParent()Landroid/view/ViewParent;

    move-result-object v4

    check-cast v4, Landroid/view/ViewGroup;

    iput-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    .line 196
    const/4 v0, 0x1

    .line 197
    .local v0, "idx":I
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xb

    if-lt v4, v5, :cond_1

    .line 198
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;
    invoke-static {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$300(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    move-result-object v4

    invoke-virtual {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->showFullScreenBackground()V

    .line 199
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;
    invoke-static {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$300(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    .line 200
    const/4 v0, 0x0

    .line 203
    :cond_1
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v2, v7, v7}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 205
    .local v2, "p":Landroid/widget/FrameLayout$LayoutParams;
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->setVisibility(I)V

    .line 206
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    invoke-virtual {v4, p1, v0, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 207
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    invoke-virtual {v4}, Landroid/view/ViewGroup;->bringToFront()V

    goto :goto_0

    .line 180
    .end local v0    # "idx":I
    .end local v2    # "p":Landroid/widget/FrameLayout$LayoutParams;
    .restart local v1    # "layout":Landroid/widget/FrameLayout;
    .restart local v3    # "player":Landroid/view/View;
    :cond_2
    instance-of v4, v3, Landroid/view/SurfaceView;

    if-eqz v4, :cond_3

    .line 181
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v4}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v4

    const-string v5, "The custom view is surface view."

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 182
    check-cast v3, Landroid/view/SurfaceView;

    .end local v3    # "player":Landroid/view/View;
    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->customSurfaceView:Landroid/view/SurfaceView;

    .line 183
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->customSurfaceView:Landroid/view/SurfaceView;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Landroid/view/SurfaceView;->setZOrderMediaOverlay(Z)V

    .line 187
    :goto_2
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4, v6}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$102(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Landroid/widget/VideoView;)Landroid/widget/VideoView;

    goto :goto_1

    .line 185
    .restart local v3    # "player":Landroid/view/View;
    :cond_3
    iput-object v6, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->customSurfaceView:Landroid/view/SurfaceView;

    goto :goto_2

    .line 190
    .end local v1    # "layout":Landroid/widget/FrameLayout;
    .end local v3    # "player":Landroid/view/View;
    :cond_4
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4, v6}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$102(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Landroid/widget/VideoView;)Landroid/widget/VideoView;

    goto :goto_1
.end method
