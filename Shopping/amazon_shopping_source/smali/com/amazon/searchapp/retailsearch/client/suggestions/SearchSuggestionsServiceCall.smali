.class public Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;
.super Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;
.source "SearchSuggestionsServiceCall.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;",
        ">;"
    }
.end annotation


# static fields
.field private static PARSER_CLASS:Ljava/lang/String;

.field private static defaultParser:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;


# instance fields
.field private final parser:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

.field private final request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 37
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;

    invoke-virtual {v1}, Ljava/lang/Class;->getPackage()Ljava/lang/Package;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Package;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".jackson.SearchSuggestionsParser"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->PARSER_CLASS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;)V
    .locals 6
    .param p1, "client"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;
    .param p2, "request"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;
    .param p3, "listener"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;
    .param p4, "parser"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

    .prologue
    .line 51
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "/search/complete"

    const-class v5, Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 52
    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    .line 53
    iput-object p4, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->parser:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

    .line 54
    return-void
.end method

.method private declared-synchronized getDefaultParser()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;
    .locals 1

    .prologue
    .line 127
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->defaultParser:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

    if-nez v0, :cond_0

    .line 128
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->PARSER_CLASS:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/util/ClassUtil;->createInstance(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->defaultParser:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

    .line 131
    :cond_0
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->defaultParser:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 127
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private getParser()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->parser:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->parser:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->getDefaultParser()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method protected buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 77
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->getMethod()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 78
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->METHOD:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 81
    :cond_0
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->getQueryPrefix()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 82
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->QUERY_PREFIX:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->getQueryPrefix()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 85
    :cond_1
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->getSearchAlias()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 86
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->SEARCH_ALIAS:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->getSearchAlias()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 89
    :cond_2
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->getConfidence()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 90
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->CONFIDENCE:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;->getConfidence()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 93
    :cond_3
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->MARKETPLACE_ID:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getMarketplaceId()I

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 96
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;->getClientId()Ljava/lang/String;

    move-result-object v0

    .line 98
    .local v0, "clientId":Ljava/lang/String;
    if-eqz v0, :cond_4

    .line 99
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1, v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 101
    :cond_4
    return-void
.end method

.method protected getClient()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;
    .locals 1

    .prologue
    .line 61
    invoke-super {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;

    return-object v0
.end method

.method protected bridge synthetic getClient()Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;

    move-result-object v0

    return-object v0
.end method

.method protected getListener()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;
    .locals 1

    .prologue
    .line 69
    invoke-super {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getListener()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;

    return-object v0
.end method

.method protected bridge synthetic getListener()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->getListener()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;

    move-result-object v0

    return-object v0
.end method

.method protected readResponse(ILjava/lang/String;Ljava/io/InputStream;)Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
    .locals 2
    .param p1, "statusCode"    # I
    .param p2, "statusLine"    # Ljava/lang/String;
    .param p3, "content"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 109
    if-eqz p3, :cond_0

    .line 110
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->getParser()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->getListener()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;

    move-result-object v1

    invoke-interface {v0, p3, v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;->parse(Ljava/io/InputStream;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;)Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;

    move-result-object v0

    .line 113
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic readResponse(ILjava/lang/String;Ljava/io/InputStream;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 23
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;->readResponse(ILjava/lang/String;Ljava/io/InputStream;)Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;

    move-result-object v0

    return-object v0
.end method
