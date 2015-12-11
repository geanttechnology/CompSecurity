.class public Lcom/amazon/retailsearch/data/sims/SimilaritiesLoader;
.super Ljava/lang/Object;
.source "SimilaritiesLoader.java"


# static fields
.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/amazon/retailsearch/data/sims/SimilaritiesLoader;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/data/sims/SimilaritiesLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method


# virtual methods
.method public getSims(Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;Ljava/lang/String;)V
    .locals 5
    .param p2, "asin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 38
    .local p1, "listener":Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/SearchResult;>;"
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    .line 39
    .local v0, "client":Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    invoke-virtual {v0, p1, p2}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->similarities(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;

    move-result-object v2

    .line 42
    .local v2, "serviceCall":Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;
    :try_start_0
    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;->execute()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 49
    :goto_0
    return-void

    .line 44
    :catch_0
    move-exception v1

    .line 46
    .local v1, "e":Ljava/io/IOException;
    sget-object v3, Lcom/amazon/retailsearch/data/sims/SimilaritiesLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;)V

    .line 47
    invoke-virtual {p1, v1}, Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;->error(Ljava/lang/Exception;)V

    goto :goto_0
.end method
