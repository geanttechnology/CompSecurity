.class Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;
.super Landroid/webkit/WebViewClient;
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
.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

.field final synthetic val$bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)V
    .locals 0

    .prologue
    .line 266
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    iput-object p2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->val$bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 311
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onLoadResource, url:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 312
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 313
    return-void
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 284
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onPageFinished, url="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", withLoadedCallBack="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->withLoadedCallBack:Z
    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$500(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 285
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 286
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const/4 v1, 0x1

    # setter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->pageLoaded:Z
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$402(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Z)Z

    .line 287
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # invokes: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->setBaseURL(Ljava/lang/String;)V
    invoke-static {v0, p2}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$600(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Ljava/lang/String;)V

    .line 288
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # invokes: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->tryTriggerLoaded()V
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$700(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)V

    .line 289
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 278
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onPageStarted, url="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 279
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const/4 v1, 0x0

    # setter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->pageLoaded:Z
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$402(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;Z)Z

    .line 280
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 269
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onReceivedError, failingUrl:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", description:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 270
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 271
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->pageLoaded:Z
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$400(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 272
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->val$bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-virtual {v0, p2, p3}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->mraidLoadFail(ILjava/lang/String;)V

    .line 274
    :cond_0
    return-void
.end method

.method public onScaleChanged(Landroid/webkit/WebView;FF)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "oldScale"    # F
    .param p3, "newScale"    # F

    .prologue
    .line 299
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onScaleChanged, oldScale="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", newScale="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 300
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onScaleChanged(Landroid/webkit/WebView;FF)V

    .line 301
    return-void
.end method

.method public onTooManyRedirects(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "cancelMsg"    # Landroid/os/Message;
    .param p3, "continueMsg"    # Landroid/os/Message;

    .prologue
    .line 305
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onTooManyRedirects, cancel message:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 306
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onTooManyRedirects(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V

    .line 307
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 293
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "shouldOverrideUrlLoading, url="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 294
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView$3;->val$bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
