.class public Lcom/amazon/retailsearch/data/SearchSuggestionLoader;
.super Ljava/lang/Object;
.source "SearchSuggestionLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/data/SearchSuggestionLoader$1;,
        Lcom/amazon/retailsearch/data/SearchSuggestionLoader$RequestListener;
    }
.end annotation


# static fields
.field private static final UNKNOWN_CLIENT_ID:Ljava/lang/String; = "unknown"

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private clientID:Ljava/lang/String;

.field private query:Ljava/lang/String;

.field private searchAlias:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    return-void
.end method

.method static synthetic access$100()Lcom/amazon/retailsearch/log/MessageLogger;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-object v0
.end method


# virtual methods
.method public getClientID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->clientID:Ljava/lang/String;

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->searchAlias:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchSuggestions()Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 97
    iget-object v2, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->query:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    move-object v2, v3

    .line 117
    :goto_0
    return-object v2

    .line 102
    :cond_0
    new-instance v2, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    invoke-direct {v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;-><init>()V

    new-instance v4, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;

    invoke-direct {v4}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;-><init>()V

    invoke-virtual {v2, v4}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->setWebClient(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    move-result-object v4

    iget-object v2, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->clientID:Ljava/lang/String;

    if-nez v2, :cond_1

    const-string/jumbo v2, "unknown"

    :goto_1
    invoke-virtual {v4, v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->setClientId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;

    move-result-object v0

    .line 107
    .local v0, "client":Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;
    iget-object v2, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->searchAlias:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->query:Ljava/lang/String;

    new-instance v5, Lcom/amazon/retailsearch/data/SearchSuggestionLoader$RequestListener;

    invoke-direct {v5, p0, v3}, Lcom/amazon/retailsearch/data/SearchSuggestionLoader$RequestListener;-><init>(Lcom/amazon/retailsearch/data/SearchSuggestionLoader;Lcom/amazon/retailsearch/data/SearchSuggestionLoader$1;)V

    invoke-virtual {v0, v2, v4, v5}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;->searchSuggestions(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;)Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;

    move-result-object v1

    .line 111
    .local v1, "serviceCall":Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;
    :try_start_0
    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 102
    .end local v0    # "client":Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;
    .end local v1    # "serviceCall":Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;
    :cond_1
    iget-object v2, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->clientID:Ljava/lang/String;

    goto :goto_1

    .line 113
    .restart local v0    # "client":Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;
    .restart local v1    # "serviceCall":Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;
    :catch_0
    move-exception v2

    move-object v2, v3

    .line 117
    goto :goto_0
.end method

.method public setClientID(Ljava/lang/String;)Lcom/amazon/retailsearch/data/SearchSuggestionLoader;
    .locals 0
    .param p1, "clientID"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->clientID:Ljava/lang/String;

    .line 53
    return-object p0
.end method

.method public setQuery(Ljava/lang/String;)Lcom/amazon/retailsearch/data/SearchSuggestionLoader;
    .locals 0
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->query:Ljava/lang/String;

    .line 72
    return-object p0
.end method

.method public setSearchAlias(Ljava/lang/String;)Lcom/amazon/retailsearch/data/SearchSuggestionLoader;
    .locals 0
    .param p1, "searchAlias"    # Ljava/lang/String;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->searchAlias:Ljava/lang/String;

    .line 89
    return-object p0
.end method
