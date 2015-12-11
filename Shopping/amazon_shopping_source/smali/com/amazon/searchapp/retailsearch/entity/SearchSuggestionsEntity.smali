.class public Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "SearchSuggestionsEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;


# instance fields
.field private query:Ljava/lang/String;

.field private suggestions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Suggestion;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getSuggestions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Suggestion;",
            ">;"
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;->suggestions:Ljava/util/List;

    return-object v0
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;->query:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setSuggestions(Ljava/util/List;)V
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
    .line 56
    .local p1, "suggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Suggestion;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;->suggestions:Ljava/util/List;

    .line 57
    return-void
.end method
