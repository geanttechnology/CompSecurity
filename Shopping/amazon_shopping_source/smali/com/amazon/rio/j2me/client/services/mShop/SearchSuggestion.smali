.class public Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;
.super Ljava/lang/Object;
.source "SearchSuggestion.java"


# instance fields
.field private autoSearch:Ljava/lang/Boolean;

.field private department:Ljava/lang/String;

.field private filters:Ljava/lang/String;

.field private query:Ljava/lang/String;

.field private rawId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAutoSearch()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->autoSearch:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getDepartment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->department:Ljava/lang/String;

    return-object v0
.end method

.method public getFilters()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->filters:Ljava/lang/String;

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->query:Ljava/lang/String;

    return-object v0
.end method

.method public setAutoSearch(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->autoSearch:Ljava/lang/Boolean;

    .line 66
    return-void
.end method

.method public setDepartment(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->department:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setFilters(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->filters:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->query:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setRawId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->rawId:Ljava/lang/String;

    .line 79
    return-void
.end method
