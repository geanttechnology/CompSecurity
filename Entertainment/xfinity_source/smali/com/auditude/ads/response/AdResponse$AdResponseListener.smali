.class public interface abstract Lcom/auditude/ads/response/AdResponse$AdResponseListener;
.super Ljava/lang/Object;
.source "AdResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/response/AdResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "AdResponseListener"
.end annotation


# virtual methods
.method public abstract onRequestComplete(Ljava/util/ArrayList;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/exception/AssetException;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract onRequestFailed(Ljava/lang/Throwable;)V
.end method
