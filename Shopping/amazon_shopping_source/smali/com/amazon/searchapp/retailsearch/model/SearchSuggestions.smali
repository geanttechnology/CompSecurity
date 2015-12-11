.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
.super Ljava/lang/Object;
.source "SearchSuggestions.java"


# virtual methods
.method public abstract getQuery()Ljava/lang/String;
.end method

.method public abstract getSuggestions()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Suggestion;",
            ">;"
        }
    .end annotation
.end method
