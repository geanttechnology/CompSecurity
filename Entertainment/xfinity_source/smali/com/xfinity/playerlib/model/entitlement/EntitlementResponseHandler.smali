.class public Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/XipResponseHandler;
.source "EntitlementResponseHandler.java"


# instance fields
.field private jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private parser:Lcom/xfinity/playerlib/model/entitlement/EntitlementParser;

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 1
    .param p1, "jsonObjectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/xip/XipResponseHandler;-><init>()V

    .line 11
    new-instance v0, Lcom/xfinity/playerlib/model/entitlement/EntitlementParser;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/entitlement/EntitlementParser;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;->parser:Lcom/xfinity/playerlib/model/entitlement/EntitlementParser;

    .line 15
    iput-object p1, p0, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;->jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 16
    return-void
.end method


# virtual methods
.method public getVideoEntitlement()Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 2
    .param p1, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;->parser:Lcom/xfinity/playerlib/model/entitlement/EntitlementParser;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;->jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, v1, p1}, Lcom/xfinity/playerlib/model/entitlement/EntitlementParser;->parse(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/InputStream;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 21
    return-void
.end method
