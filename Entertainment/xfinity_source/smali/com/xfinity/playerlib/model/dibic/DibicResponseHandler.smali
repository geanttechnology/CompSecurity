.class public Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "DibicResponseHandler.java"


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

.field private final parser:Lcom/xfinity/playerlib/model/dibic/DibicParser;

.field private final programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

.field private final tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/dibic/DibicParser;Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
    .locals 1
    .param p1, "parser"    # Lcom/xfinity/playerlib/model/dibic/DibicParser;
    .param p2, "programFactory"    # Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;
    .param p3, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .param p4, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 17
    const-class v0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->LOG:Lorg/slf4j/Logger;

    .line 26
    iput-object p1, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->parser:Lcom/xfinity/playerlib/model/dibic/DibicParser;

    .line 27
    iput-object p2, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

    .line 28
    iput-object p3, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 29
    iput-object p4, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 30
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->addDefaultHeaderHandlers()V

    .line 31
    return-void
.end method


# virtual methods
.method public getDibicResource()Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 5
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 35
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Parsing input stream into list of programs"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 36
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->parser:Lcom/xfinity/playerlib/model/dibic/DibicParser;

    new-instance v2, Lorg/apache/commons/io/input/SwappedDataInputStream;

    new-instance v3, Ljava/io/BufferedInputStream;

    invoke-direct {v3, p1}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v2, v3}, Lorg/apache/commons/io/input/SwappedDataInputStream;-><init>(Ljava/io/InputStream;)V

    iget-object v3, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-virtual {v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/dibic/DibicParser;->getPrograms(Lorg/apache/commons/io/input/SwappedDataInputStream;Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;

    move-result-object v0

    .line 37
    .local v0, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Parsing complete, {} programs fetched"

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 38
    new-instance v1, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-direct {v1, v0, v2, v3}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;-><init>(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 39
    return-void
.end method
