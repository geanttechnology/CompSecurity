.class public Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;
.super Ljava/lang/Object;
.source "AdvSearchSuggestionsResponse.java"


# instance fields
.field private query:Ljava/lang/String;

.field private suggestions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;",
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
.method public getSuggestions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;",
            ">;"
        }
    .end annotation

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;->suggestions:Ljava/util/List;

    return-object v0
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;->query:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setSuggestions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;->suggestions:Ljava/util/List;

    .line 34
    return-void
.end method
