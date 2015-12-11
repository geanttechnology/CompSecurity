.class public interface abstract Lcom/amazon/mShop/net/HttpFetcher$Subscriber;
.super Ljava/lang/Object;
.source "HttpFetcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/HttpFetcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Subscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<TT;>;)V"
        }
    .end annotation
.end method

.method public abstract onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<TT;>;)V"
        }
    .end annotation
.end method
