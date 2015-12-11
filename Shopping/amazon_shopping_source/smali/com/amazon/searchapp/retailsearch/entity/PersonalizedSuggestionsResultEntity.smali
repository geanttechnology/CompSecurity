.class public Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsResultEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PersonalizedSuggestionsResultEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;


# instance fields
.field private searchSuggestion:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getSearchSuggestion()Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsResultEntity;->searchSuggestion:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    return-object v0
.end method

.method public setSearchSuggestion(Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;)V
    .locals 0
    .param p1, "searchSuggestion"    # Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsResultEntity;->searchSuggestion:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    .line 33
    return-void
.end method
