.class public Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;
.super Ljava/lang/Object;
.source "AdvSearchSuggestionsRequest.java"


# instance fields
.field private filters:Ljava/lang/String;

.field private maxDepartments:Ljava/lang/Integer;

.field private maxSuggestions:Ljava/lang/Integer;

.field private query:Ljava/lang/String;

.field private toggleRefinements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getFilters()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;->filters:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxDepartments()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;->maxDepartments:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMaxSuggestions()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;->maxSuggestions:Ljava/lang/Integer;

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getToggleRefinements()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;->toggleRefinements:Ljava/util/List;

    return-object v0
.end method

.method public setMaxSuggestions(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;->maxSuggestions:Ljava/lang/Integer;

    .line 66
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;->query:Ljava/lang/String;

    .line 27
    return-void
.end method
