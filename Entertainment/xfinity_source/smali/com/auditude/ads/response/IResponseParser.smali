.class public interface abstract Lcom/auditude/ads/response/IResponseParser;
.super Ljava/lang/Object;
.source "IResponseParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;
    }
.end annotation


# virtual methods
.method public abstract cancel()V
.end method

.method public abstract loadAdRequest(Lcom/auditude/ads/response/AdResponse;Lcom/auditude/ads/loader/AdRequest;I)V
.end method

.method public abstract setResponseParserListener(Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;)V
.end method
