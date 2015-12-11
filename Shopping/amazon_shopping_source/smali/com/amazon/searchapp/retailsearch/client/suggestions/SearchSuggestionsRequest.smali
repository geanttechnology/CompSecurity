.class public final Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;
.super Ljava/lang/Object;
.source "SearchSuggestionsRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$1;,
        Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;
    }
.end annotation


# instance fields
.field private final confidence:Ljava/lang/String;

.field private final method:Ljava/lang/String;

.field private final queryPrefix:Ljava/lang/String;

.field private final searchAlias:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "searchAlias"    # Ljava/lang/String;
    .param p3, "queryPrefix"    # Ljava/lang/String;
    .param p4, "confidence"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->method:Ljava/lang/String;

    .line 43
    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->searchAlias:Ljava/lang/String;

    .line 44
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->queryPrefix:Ljava/lang/String;

    .line 45
    iput-object p4, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->confidence:Ljava/lang/String;

    .line 46
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # Ljava/lang/String;
    .param p5, "x4"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$1;

    .prologue
    .line 9
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getConfidence()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->confidence:Ljava/lang/String;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->method:Ljava/lang/String;

    return-object v0
.end method

.method public getQueryPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->queryPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->searchAlias:Ljava/lang/String;

    return-object v0
.end method
