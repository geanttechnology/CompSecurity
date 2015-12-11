.class public interface abstract Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;
.super Ljava/lang/Object;
.source "SearchSuggestionsListener.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;",
        ">;"
    }
.end annotation


# virtual methods
.method public abstract suggestion(Lcom/amazon/searchapp/retailsearch/model/Suggestion;)V
.end method

.method public abstract suggestionList(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Suggestion;",
            ">;)V"
        }
    .end annotation
.end method
