.class Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall$1;
.super Ljava/lang/Object;
.source "AmazonWebserviceCall.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;


# direct methods
.method constructor <init>(Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall$1;->this$0:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getErrorCode(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    .locals 1
    .param p1, "httpURLConnection"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 135
    const/4 v0, 0x0

    return-object v0
.end method

.method public parse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;[B)Ljava/lang/Object;
    .locals 2
    .param p1, "responseHeaders"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;
    .param p2, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall$1;->this$0:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebServiceCallback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;->onHeadersReceived(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V

    .line 119
    if-eqz p2, :cond_0

    .line 121
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall$1;->this$0:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebServiceCallback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    array-length v1, p2

    invoke-interface {v0, p2, v1}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;->onBodyChunkReceived([BI)V

    .line 124
    :cond_0
    # getter for: Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Request complete"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall$1;->this$0:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebServiceCallback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;->onRequestComplete()V

    .line 127
    const/4 v0, 0x0

    return-object v0
.end method
