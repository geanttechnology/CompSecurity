.class public Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PersonalizedSuggestionsEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;


# instance fields
.field private requestId:Ljava/lang/String;

.field private searchedText:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SearchedText;",
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
.method public getRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsEntity;->requestId:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchedText()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SearchedText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsEntity;->searchedText:Ljava/util/List;

    return-object v0
.end method

.method public setRequestId(Ljava/lang/String;)V
    .locals 0
    .param p1, "requestId"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsEntity;->requestId:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setSearchedText(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SearchedText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 56
    .local p1, "searchedText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsEntity;->searchedText:Ljava/util/List;

    .line 57
    return-void
.end method
