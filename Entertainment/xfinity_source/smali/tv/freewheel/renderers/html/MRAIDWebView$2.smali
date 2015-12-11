.class Ltv/freewheel/renderers/html/MRAIDWebView$2;
.super Landroid/webkit/WebChromeClient;
.source "MRAIDWebView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/renderers/html/MRAIDWebView;->init(Ltv/freewheel/renderers/html/HTMLRenderer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private customSurfaceView:Landroid/view/SurfaceView;

.field private customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

.field private holder:Landroid/view/ViewGroup;

.field final synthetic this$0:Ltv/freewheel/renderers/html/MRAIDWebView;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/html/MRAIDWebView;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 153
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    .line 166
    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    .line 167
    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

    .line 168
    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->customSurfaceView:Landroid/view/SurfaceView;

    return-void
.end method


# virtual methods
.method public getVideoLoadingProgressView()Landroid/view/View;
    .locals 3

    .prologue
    .line 156
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

    move-result-object v1

    const-string v2, "getVideoLoadingProgressView"

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 157
    new-instance v0, Landroid/widget/ProgressBar;

    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-virtual {v1}, Ltv/freewheel/renderers/html/MRAIDWebView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V

    .line 158
    .local v0, "bar":Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public onConsoleMessage(Ljava/lang/String;ILjava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "lineNumber"    # I
    .param p3, "sourceID"    # Ljava/lang/String;

    .prologue
    .line 163
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 164
    return-void
.end method

.method public onHideCustomView()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 219
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    const-string v1, "onHideCustomView"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 220
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customView:Landroid/view/View;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$200(Ltv/freewheel/renderers/html/MRAIDWebView;)Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_0

    .line 237
    :goto_0
    return-void

    .line 222
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ltv/freewheel/renderers/html/MRAIDWebView;->setVisibility(I)V

    .line 223
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

    invoke-interface {v0}, Landroid/webkit/WebChromeClient$CustomViewCallback;->onCustomViewHidden()V

    .line 224
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    if-eqz v0, :cond_1

    .line 225
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customView:Landroid/view/View;
    invoke-static {v1}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$200(Ltv/freewheel/renderers/html/MRAIDWebView;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 227
    :cond_1
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customView:Landroid/view/View;
    invoke-static {v0, v2}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$202(Ltv/freewheel/renderers/html/MRAIDWebView;Landroid/view/View;)Landroid/view/View;

    .line 228
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v0, v2}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$102(Ltv/freewheel/renderers/html/MRAIDWebView;Landroid/widget/VideoView;)Landroid/widget/VideoView;

    .line 229
    iput-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    .line 231
    iput-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

    .line 232
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_2

    .line 233
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/renderers/html/MRAIDBackgroundView;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$300(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/renderers/html/MRAIDBackgroundView;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/renderers/html/MRAIDBackgroundView;->hideFullScreenBackground()V

    .line 236
    :cond_2
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->requestFocus()Z

    goto :goto_0
.end method

.method public onShowCustomView(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "callback"    # Landroid/webkit/WebChromeClient$CustomViewCallback;

    .prologue
    const/4 v7, -0x1

    const/4 v6, 0x0

    .line 172
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

    move-result-object v4

    const-string v5, "onShowCustomView"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 173
    invoke-super {p0, p1, p2}, Landroid/webkit/WebChromeClient;->onShowCustomView(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V

    .line 174
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$100(Ltv/freewheel/renderers/html/MRAIDWebView;)Landroid/widget/VideoView;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 175
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

    move-result-object v4

    const-string v5, "The custom video is alive, no need to show it again"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 215
    :goto_0
    return-void

    .line 179
    :cond_0
    instance-of v4, p1, Landroid/widget/FrameLayout;

    if-eqz v4, :cond_4

    move-object v1, p1

    .line 180
    check-cast v1, Landroid/widget/FrameLayout;

    .line 181
    .local v1, "layout":Landroid/widget/FrameLayout;
    invoke-virtual {v1}, Landroid/widget/FrameLayout;->getFocusedChild()Landroid/view/View;

    move-result-object v3

    .line 182
    .local v3, "player":Landroid/view/View;
    instance-of v4, v3, Landroid/widget/VideoView;

    if-eqz v4, :cond_2

    .line 183
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-virtual {v1}, Landroid/widget/FrameLayout;->getFocusedChild()Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/VideoView;

    # setter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v5, v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$102(Ltv/freewheel/renderers/html/MRAIDWebView;Landroid/widget/VideoView;)Landroid/widget/VideoView;

    .line 184
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$100(Ltv/freewheel/renderers/html/MRAIDWebView;)Landroid/widget/VideoView;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-virtual {v4, v5}, Landroid/widget/VideoView;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 185
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$100(Ltv/freewheel/renderers/html/MRAIDWebView;)Landroid/widget/VideoView;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-virtual {v4, v5}, Landroid/widget/VideoView;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 199
    .end local v1    # "layout":Landroid/widget/FrameLayout;
    .end local v3    # "player":Landroid/view/View;
    :goto_1
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customView:Landroid/view/View;
    invoke-static {v4, p1}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$202(Ltv/freewheel/renderers/html/MRAIDWebView;Landroid/view/View;)Landroid/view/View;

    .line 200
    iput-object p2, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->customViewCallback:Landroid/webkit/WebChromeClient$CustomViewCallback;

    .line 202
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-virtual {v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->getParent()Landroid/view/ViewParent;

    move-result-object v4

    check-cast v4, Landroid/view/ViewGroup;

    iput-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    .line 203
    const/4 v0, 0x1

    .line 204
    .local v0, "idx":I
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xb

    if-lt v4, v5, :cond_1

    .line 205
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/renderers/html/MRAIDBackgroundView;
    invoke-static {v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$300(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/renderers/html/MRAIDBackgroundView;

    move-result-object v4

    invoke-virtual {v4}, Ltv/freewheel/renderers/html/MRAIDBackgroundView;->showFullScreenBackground()V

    .line 206
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/renderers/html/MRAIDBackgroundView;
    invoke-static {v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$300(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/renderers/html/MRAIDBackgroundView;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    .line 207
    const/4 v0, 0x0

    .line 210
    :cond_1
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v2, v7, v7}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 212
    .local v2, "p":Landroid/widget/FrameLayout$LayoutParams;
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Ltv/freewheel/renderers/html/MRAIDWebView;->setVisibility(I)V

    .line 213
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    invoke-virtual {v4, p1, v0, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 214
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->holder:Landroid/view/ViewGroup;

    invoke-virtual {v4}, Landroid/view/ViewGroup;->bringToFront()V

    goto :goto_0

    .line 187
    .end local v0    # "idx":I
    .end local v2    # "p":Landroid/widget/FrameLayout$LayoutParams;
    .restart local v1    # "layout":Landroid/widget/FrameLayout;
    .restart local v3    # "player":Landroid/view/View;
    :cond_2
    instance-of v4, v3, Landroid/view/SurfaceView;

    if-eqz v4, :cond_3

    .line 188
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

    move-result-object v4

    const-string v5, "The custom view is surface view."

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 189
    check-cast v3, Landroid/view/SurfaceView;

    .end local v3    # "player":Landroid/view/View;
    iput-object v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->customSurfaceView:Landroid/view/SurfaceView;

    .line 190
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->customSurfaceView:Landroid/view/SurfaceView;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Landroid/view/SurfaceView;->setZOrderMediaOverlay(Z)V

    .line 194
    :goto_2
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4, v6}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$102(Ltv/freewheel/renderers/html/MRAIDWebView;Landroid/widget/VideoView;)Landroid/widget/VideoView;

    goto :goto_1

    .line 192
    .restart local v3    # "player":Landroid/view/View;
    :cond_3
    iput-object v6, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->customSurfaceView:Landroid/view/SurfaceView;

    goto :goto_2

    .line 197
    .end local v1    # "layout":Landroid/widget/FrameLayout;
    .end local v3    # "player":Landroid/view/View;
    :cond_4
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView$2;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # setter for: Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;
    invoke-static {v4, v6}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$102(Ltv/freewheel/renderers/html/MRAIDWebView;Landroid/widget/VideoView;)Landroid/widget/VideoView;

    goto :goto_1
.end method
