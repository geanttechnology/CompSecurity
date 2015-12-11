.class public interface abstract Lcom/amazon/retailsearch/data/ISuggestionDataProvider;
.super Ljava/lang/Object;
.source "ISuggestionDataProvider.java"


# virtual methods
.method public abstract deletePastSearches(Ljava/lang/String;Ljava/lang/String;)Z
.end method

.method public abstract getPastSearches(Ljava/lang/String;Z)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getSearchSuggestions(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getSuggestions(Ljava/lang/String;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getSuggestions(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getSuggestions(Ljava/lang/String;Ljava/lang/String;Z)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getSuggestions(Ljava/lang/String;Z)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation
.end method
