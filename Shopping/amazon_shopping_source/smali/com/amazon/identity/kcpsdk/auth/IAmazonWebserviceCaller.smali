.class public interface abstract Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;
.super Ljava/lang/Object;
.source "IAmazonWebserviceCaller.java"


# virtual methods
.method public abstract call(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;
        }
    .end annotation
.end method

.method public abstract createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;
.end method

.method public abstract createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;
.end method

.method public abstract createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;
.end method
