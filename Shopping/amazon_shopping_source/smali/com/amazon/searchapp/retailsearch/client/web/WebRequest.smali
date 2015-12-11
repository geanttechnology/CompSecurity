.class public Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;
.super Ljava/lang/Object;
.source "WebRequest.java"


# static fields
.field private static NO_CONNECTION_ERROR:Ljava/lang/String;


# instance fields
.field private final client:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

.field private connection:Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;

.field private content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

.field private headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private method:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-string/jumbo v0, "No connection created"

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->NO_CONNECTION_ERROR:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)V
    .locals 0
    .param p1, "client"    # Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->client:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    .line 40
    return-void
.end method


# virtual methods
.method public getResponse()Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->client:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->method:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->url:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    invoke-interface {v0, v1, v2, v3, v4}, Lcom/amazon/searchapp/retailsearch/client/web/WebClient;->createConnection(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->connection:Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;

    .line 105
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->connection:Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;->getResponse()Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;

    move-result-object v0

    return-object v0
.end method

.method public setContent(Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)V
    .locals 0
    .param p1, "content"    # Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    .line 96
    return-void
.end method

.method public setHeaders(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 0
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
    .line 81
    .local p1, "headers":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 82
    return-void
.end method

.method public setMethod(Ljava/lang/String;)V
    .locals 0
    .param p1, "method"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->method:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->url:Ljava/lang/String;

    .line 68
    return-void
.end method
