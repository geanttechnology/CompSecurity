.class public Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;
.source "TitaniumTicketResponseHandler.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private titaniumTicket:Lcom/xfinity/playerlib/downloads/TitaniumTicket;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "jsonObjectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    .line 18
    return-void
.end method


# virtual methods
.method public getTitaniumTicket()Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;->titaniumTicket:Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    return-object v0
.end method

.method protected handleAMSResponseBody(Lcom/fasterxml/jackson/databind/JsonNode;)V
    .locals 5
    .param p1, "rootNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 22
    const-string v2, "drmToken"

    invoke-virtual {p1, v2}, Lcom/fasterxml/jackson/databind/JsonNode;->findValue(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 23
    .local v0, "drmNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string v2, "titaniumToken"

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/databind/JsonNode;->findValue(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v1

    .line 24
    .local v1, "tTokenNode":Lcom/fasterxml/jackson/databind/JsonNode;
    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;->jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/JsonNode;->traverse()Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v3

    const-class v4, Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    invoke-virtual {v2, v3, v4}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    iput-object v2, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;->titaniumTicket:Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    .line 25
    return-void
.end method
