.class public Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "EditorialResponseHandler.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<P::",
        "Lcom/xfinity/playerlib/model/editorial/EditorialParser;",
        "R:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final parser:Lcom/xfinity/playerlib/model/editorial/EditorialParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TP;"
        }
    .end annotation
.end field

.field private resourceFactory:Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory",
            "<TP;TR;>;"
        }
    .end annotation
.end field

.field private response:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TR;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/editorial/EditorialParser;Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TP;",
            "Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory",
            "<TP;TR;>;)V"
        }
    .end annotation

    .prologue
    .line 20
    .local p0, "this":Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;, "Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler<TP;TR;>;"
    .local p1, "parser":Lcom/xfinity/playerlib/model/editorial/EditorialParser;, "TP;"
    .local p2, "resourceFactory":Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;, "Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory<TP;TR;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;->parser:Lcom/xfinity/playerlib/model/editorial/EditorialParser;

    .line 22
    iput-object p2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;->resourceFactory:Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;

    .line 23
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;->addDefaultHeaderHandlers()V

    .line 24
    return-void
.end method


# virtual methods
.method public getEditorialResponse()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation

    .prologue
    .line 39
    .local p0, "this":Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;, "Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler<TP;TR;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;->response:Ljava/lang/Object;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 4
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 30
    .local p0, "this":Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;, "Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler<TP;TR;>;"
    :try_start_0
    const-string v2, "UTF-8"

    invoke-static {p1, v2}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 35
    .local v1, "json":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;->resourceFactory:Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;->parser:Lcom/xfinity/playerlib/model/editorial/EditorialParser;

    invoke-interface {v2, v3, v1}, Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;->createResource(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;->response:Ljava/lang/Object;

    .line 36
    return-void

    .line 31
    .end local v1    # "json":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 32
    .local v0, "e":Ljava/io/IOException;
    new-instance v2, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v2, v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v2
.end method
