.class Lcom/inc247/ChatSDKWebView$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDKWebView;->destroyWebView()V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDKWebView;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDKWebView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDKWebView$3;->this$0:Lcom/inc247/ChatSDKWebView;

    .line 278
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 281
    :try_start_0
    # getter for: Lcom/inc247/ChatSDKWebView;->self:Lcom/inc247/ChatSDKWebView;
    invoke-static {}, Lcom/inc247/ChatSDKWebView;->access$2()Lcom/inc247/ChatSDKWebView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKWebView;->setVisibility(I)V

    .line 282
    # getter for: Lcom/inc247/ChatSDKWebView;->self:Lcom/inc247/ChatSDKWebView;
    invoke-static {}, Lcom/inc247/ChatSDKWebView;->access$2()Lcom/inc247/ChatSDKWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/inc247/ChatSDKWebView;->destroy()V

    .line 283
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/inc247/ChatSDKWebView;->access$3(Lcom/inc247/ChatSDKWebView;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 288
    :goto_0
    return-void

    .line 284
    :catch_0
    move-exception v0

    .line 285
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 286
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method
