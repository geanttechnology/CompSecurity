.class public Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;
.super Ljava/lang/Object;
.source "SearchSuggestionsRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private confidence:Ljava/lang/String;

.field private method:Ljava/lang/String;

.field private queryPrefix:Ljava/lang/String;

.field private searchAlias:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "queryPrefix"    # Ljava/lang/String;

    .prologue
    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 100
    const-string/jumbo v0, "complete"

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->method:Ljava/lang/String;

    .line 101
    const-string/jumbo v0, "aps"

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->searchAlias:Ljava/lang/String;

    .line 102
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->queryPrefix:Ljava/lang/String;

    .line 103
    const-string/jumbo v0, "1"

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->confidence:Ljava/lang/String;

    .line 104
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;
    .locals 6

    .prologue
    .line 176
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->method:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->searchAlias:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->queryPrefix:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->confidence:Ljava/lang/String;

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$1;)V

    return-object v0
.end method

.method public setSearchAlias(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;
    .locals 0
    .param p1, "searchAlias"    # Ljava/lang/String;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->searchAlias:Ljava/lang/String;

    .line 119
    return-object p0
.end method
