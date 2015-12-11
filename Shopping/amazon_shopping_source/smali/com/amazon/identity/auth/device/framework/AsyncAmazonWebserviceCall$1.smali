.class Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;
.super Ljava/lang/Object;
.source "AsyncAmazonWebserviceCall.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

.field final synthetic val$callback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->this$0:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->val$callback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBodyChunkReceived([BI)V
    .locals 2
    .param p1, "arg0"    # [B
    .param p2, "arg1"    # I

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->this$0:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    # getter for: Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->access$000(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$1;-><init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;[BI)V

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/HandlerHelpers;->postAndWait(Landroid/os/Handler;Ljava/lang/Runnable;)V

    .line 75
    return-void
.end method

.method public onHeadersReceived(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
    .locals 2
    .param p1, "arg0"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->this$0:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    # getter for: Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->access$000(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$2;

    invoke-direct {v1, p0, p1}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$2;-><init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/HandlerHelpers;->postAndWait(Landroid/os/Handler;Ljava/lang/Runnable;)V

    .line 88
    return-void
.end method

.method public onNetworkError()V
    .locals 2

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->this$0:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    # getter for: Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->access$000(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$3;

    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$3;-><init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;)V

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/HandlerHelpers;->postAndWait(Landroid/os/Handler;Ljava/lang/Runnable;)V

    .line 101
    return-void
.end method

.method public onRequestComplete()V
    .locals 2

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->this$0:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    # getter for: Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->access$000(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$4;

    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$4;-><init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;)V

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/HandlerHelpers;->postAndWait(Landroid/os/Handler;Ljava/lang/Runnable;)V

    .line 114
    return-void
.end method
