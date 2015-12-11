.class public interface abstract Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;
.super Ljava/lang/Object;
.source "RefinementsLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "RefinementResultListener"
.end annotation


# virtual methods
.method public abstract onError(Ljava/lang/Exception;)V
.end method

.method public abstract onResult(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
.end method
