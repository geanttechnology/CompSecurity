.class public Lcom/amazon/searchapp/retailsearch/client/suggestions/AbstractSearchSuggestionsListener;
.super Ljava/lang/Object;
.source "AbstractSearchSuggestionsListener.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public endRequest()V
    .locals 0

    .prologue
    .line 37
    return-void
.end method

.method public error(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 25
    return-void
.end method

.method public result(Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;)V
    .locals 0
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;

    .prologue
    .line 21
    return-void
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 14
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/AbstractSearchSuggestionsListener;->result(Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;)V

    return-void
.end method

.method public startRequest()V
    .locals 0

    .prologue
    .line 17
    return-void
.end method

.method public suggestion(Lcom/amazon/searchapp/retailsearch/model/Suggestion;)V
    .locals 0
    .param p1, "suggestion"    # Lcom/amazon/searchapp/retailsearch/model/Suggestion;

    .prologue
    .line 29
    return-void
.end method

.method public suggestionList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Suggestion;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "suggestionList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Suggestion;>;"
    return-void
.end method
