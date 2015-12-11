.class Ltv/freewheel/renderers/html/MRAIDWebView$3;
.super Landroid/webkit/WebViewClient;
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
.field final synthetic this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

.field final synthetic val$bridge:Ltv/freewheel/renderers/html/HTMLRenderer;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/html/MRAIDWebView;Ltv/freewheel/renderers/html/HTMLRenderer;)V
    .locals 0

    .prologue
    .line 270
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    iput-object p2, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->val$bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 315
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 316
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 317
    return-void
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 288
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

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

    iget-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->withLoadedCallBack:Z
    invoke-static {v2}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$500(Ltv/freewheel/renderers/html/MRAIDWebView;)Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 289
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 290
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    const/4 v1, 0x1

    # setter for: Ltv/freewheel/renderers/html/MRAIDWebView;->pageLoaded:Z
    invoke-static {v0, v1}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$402(Ltv/freewheel/renderers/html/MRAIDWebView;Z)Z

    .line 291
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # invokes: Ltv/freewheel/renderers/html/MRAIDWebView;->setBaseURL(Ljava/lang/String;)V
    invoke-static {v0, p2}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$600(Ltv/freewheel/renderers/html/MRAIDWebView;Ljava/lang/String;)V

    .line 292
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # invokes: Ltv/freewheel/renderers/html/MRAIDWebView;->tryTriggerLoaded()V
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$700(Ltv/freewheel/renderers/html/MRAIDWebView;)V

    .line 293
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 282
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 283
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    const/4 v1, 0x0

    # setter for: Ltv/freewheel/renderers/html/MRAIDWebView;->pageLoaded:Z
    invoke-static {v0, v1}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$402(Ltv/freewheel/renderers/html/MRAIDWebView;Z)Z

    .line 284
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 273
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 274
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 275
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->pageLoaded:Z
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$400(Ltv/freewheel/renderers/html/MRAIDWebView;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 276
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->val$bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-virtual {v0, p2, p3}, Ltv/freewheel/renderers/html/HTMLRenderer;->mraidLoadFail(ILjava/lang/String;)V

    .line 278
    :cond_0
    return-void
.end method

.method public onScaleChanged(Landroid/webkit/WebView;FF)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "oldScale"    # F
    .param p3, "newScale"    # F

    .prologue
    .line 303
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 304
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onScaleChanged(Landroid/webkit/WebView;FF)V

    .line 305
    return-void
.end method

.method public onTooManyRedirects(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "cancelMsg"    # Landroid/os/Message;
    .param p3, "continueMsg"    # Landroid/os/Message;

    .prologue
    .line 309
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 310
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onTooManyRedirects(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V

    .line 311
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 297
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 298
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$3;->val$bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
