.class public interface abstract Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;
.super Ljava/lang/Object;
.source "DataLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/loader/DataLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "DataLoaderListener"
.end annotation


# virtual methods
.method public abstract onRequestComplete(Ljava/lang/String;)V
.end method

.method public abstract onRequestFailed(Ljava/lang/Throwable;)V
.end method
