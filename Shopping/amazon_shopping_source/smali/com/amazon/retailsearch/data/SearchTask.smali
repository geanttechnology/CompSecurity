.class public interface abstract Lcom/amazon/retailsearch/data/SearchTask;
.super Ljava/lang/Object;
.source "SearchTask.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;
    }
.end annotation


# virtual methods
.method public abstract addListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)V
.end method

.method public abstract close()V
.end method

.method public abstract getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;
.end method

.method public abstract isLoading()Z
.end method

.method public abstract loadNext()V
.end method

.method public abstract loadNext(I)V
.end method

.method public abstract removeListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)Z
.end method

.method public abstract retry()V
.end method
