.class public interface abstract Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;
.super Ljava/lang/Object;
.source "RetailSearchSuggestionFilterListener.java"


# virtual methods
.method public abstract afterPublishResults(Ljava/lang/String;Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract beforePerformFiltering()V
.end method

.method public abstract beforePublishResults(Ljava/util/List;Z)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;Z)V"
        }
    .end annotation
.end method
