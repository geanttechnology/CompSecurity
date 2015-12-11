.class public interface abstract Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;
.super Ljava/lang/Object;
.source "IAmazonWebServiceCallback.java"


# virtual methods
.method public abstract onBodyChunkReceived([BI)V
.end method

.method public abstract onHeadersReceived(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
.end method

.method public abstract onNetworkError()V
.end method

.method public abstract onRequestComplete()V
.end method
