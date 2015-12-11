.class public Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;
.super Ljava/lang/Object;
.source "PersonalizedSuggestionLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$1;,
        Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;
    }
.end annotation


# instance fields
.field private clientID:Ljava/lang/String;

.field private searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getSearchBoxLogger()Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    .line 37
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 38
    return-void
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;)Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    return-object v0
.end method


# virtual methods
.method public deletePersonalizedSuggestions(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    .locals 6
    .param p1, "deleteParamR"    # Ljava/lang/String;
    .param p2, "deleteParamK"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 95
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 121
    :cond_0
    :goto_0
    return-object v4

    .line 100
    :cond_1
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v2

    .line 101
    .local v2, "searchClient":Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    new-instance v0, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;

    invoke-direct {v0, p0, v4}, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;-><init>(Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$1;)V

    .line 102
    .local v0, "listener":Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;
    invoke-virtual {v2, p1, p2, v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->personalizedSuggestions(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    move-result-object v3

    .line 104
    .local v3, "serviceCall":Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;
    if-eqz v3, :cond_0

    .line 109
    # setter for: Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;->serviceCall:Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;
    invoke-static {v0, v3}, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;->access$102(Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;)Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    .line 113
    :try_start_0
    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;

    .line 114
    .local v1, "result":Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;->getSearchSuggestion()Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    goto :goto_0

    .line 116
    .end local v1    # "result":Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;
    :catch_0
    move-exception v5

    goto :goto_0
.end method

.method public getClientID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;->clientID:Ljava/lang/String;

    return-object v0
.end method

.method public getPersonalizedSuggestions()Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 67
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v1

    .line 69
    .local v1, "searchClient":Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    new-instance v4, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;

    invoke-direct {v4, p0, v3}, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;-><init>(Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$1;)V

    invoke-virtual {v1, v4}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->personalizedSuggestions(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    move-result-object v2

    .line 70
    .local v2, "serviceCall":Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;
    if-nez v2, :cond_1

    .line 85
    :cond_0
    :goto_0
    return-object v3

    .line 77
    :cond_1
    :try_start_0
    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;

    .line 78
    .local v0, "result":Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;->getSearchSuggestion()Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 80
    .end local v0    # "result":Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method public setClientID(Ljava/lang/String;)Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;
    .locals 0
    .param p1, "clientID"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;->clientID:Ljava/lang/String;

    .line 57
    return-object p0
.end method
