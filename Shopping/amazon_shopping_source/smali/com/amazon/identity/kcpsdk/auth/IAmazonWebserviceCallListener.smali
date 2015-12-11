.class public interface abstract Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
.super Ljava/lang/Object;
.source "IAmazonWebserviceCallListener.java"


# virtual methods
.method public abstract onAuthenticationFailed()V
.end method

.method public abstract onNetworkFailure()V
.end method

.method public abstract onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
.end method

.method public abstract onResponseComplete(Ljava/lang/Object;)V
.end method
