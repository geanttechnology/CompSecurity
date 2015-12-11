.class public interface abstract Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;
.super Ljava/lang/Object;
.source "IResponseParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/response/IResponseParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "ResponseParserListener"
.end annotation


# virtual methods
.method public abstract onRequestComplete(Lcom/auditude/ads/exception/AssetException;)V
.end method

.method public abstract onRequestFailed(Ljava/lang/Throwable;)V
.end method
