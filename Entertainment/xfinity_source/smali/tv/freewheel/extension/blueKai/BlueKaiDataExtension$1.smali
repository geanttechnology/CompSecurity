.class Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;
.super Ljava/lang/Object;
.source "BlueKaiDataExtension.java"

# interfaces
.implements Ltv/freewheel/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;


# direct methods
.method constructor <init>(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 8
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    const/4 v7, 0x1

    .line 34
    const-string v4, "false"

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v3

    iget-object v5, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->constants:Ltv/freewheel/ad/interfaces/IConstants;
    invoke-static {v5}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$000(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v5

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_SUCCESS()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 35
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v3}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$100(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ltv/freewheel/utils/Logger;

    move-result-object v3

    const-string v4, "RequestComplete: false, return."

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 58
    :cond_0
    :goto_0
    return-void

    .line 39
    :cond_1
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;
    invoke-static {v3}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$200(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ltv/freewheel/ad/interfaces/IAdContext;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 44
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v3}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$100(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ltv/freewheel/utils/Logger;

    move-result-object v3

    const-string v4, "requestCompleteListener()"

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 45
    new-instance v1, Ltv/freewheel/extension/ParamParser;

    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;
    invoke-static {v3}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$200(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ltv/freewheel/ad/interfaces/IAdContext;

    move-result-object v3

    const-string v4, "extension.blueKai"

    invoke-direct {v1, v3, v4}, Ltv/freewheel/extension/ParamParser;-><init>(Ltv/freewheel/ad/interfaces/IAdContext;Ljava/lang/String;)V

    .line 46
    .local v1, "paramParer":Ltv/freewheel/extension/ParamParser;
    const-string v3, "bluekaiMobileDataSync"

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ltv/freewheel/extension/ParamParser;->parseBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    .line 48
    .local v2, "shouldSync":Z
    if-eqz v2, :cond_0

    sget-boolean v3, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->alreadySync:Z

    if-nez v3, :cond_0

    .line 49
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # invokes: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->getAndroidId()Ljava/lang/String;
    invoke-static {v3}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$300(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "androidId":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 51
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    iget-object v4, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->bluekaiScript:Ljava/lang/String;
    invoke-static {v4}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$400(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "androidId_md5"

    invoke-static {v0}, Ltv/freewheel/utils/CommonUtil;->md5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    # setter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->bluekaiScript:Ljava/lang/String;
    invoke-static {v3, v4}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$402(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;Ljava/lang/String;)Ljava/lang/String;

    .line 52
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    new-instance v4, Landroid/webkit/WebView;

    iget-object v5, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;
    invoke-static {v5}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$200(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ltv/freewheel/ad/interfaces/IAdContext;

    move-result-object v5

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IAdContext;->getActivity()Landroid/app/Activity;

    move-result-object v5

    invoke-direct {v4, v5}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    # setter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->webView:Landroid/webkit/WebView;
    invoke-static {v3, v4}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$502(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;Landroid/webkit/WebView;)Landroid/webkit/WebView;

    .line 53
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->webView:Landroid/webkit/WebView;
    invoke-static {v3}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$500(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Landroid/webkit/WebView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 54
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->webView:Landroid/webkit/WebView;
    invoke-static {v3}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$500(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Landroid/webkit/WebView;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;->this$0:Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    # getter for: Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->bluekaiScript:Ljava/lang/String;
    invoke-static {v4}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->access$400(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "text/html"

    const-string v6, "UTF-8"

    invoke-virtual {v3, v4, v5, v6}, Landroid/webkit/WebView;->loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    sput-boolean v7, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->alreadySync:Z

    goto/16 :goto_0
.end method
