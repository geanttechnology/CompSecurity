.class public Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;
.super Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
.source "DeregisterDeviceResponseParser.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/kcpsdk/common/WebResponseParser",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;",
        ">;"
    }
.end annotation


# instance fields
.field private final mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

.field private mResponse:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;-><init>(Ljava/lang/String;)V

    .line 22
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/common/XMLParser;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    .line 23
    return-void
.end method


# virtual methods
.method public getParsedResponse()Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;->mResponse:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;

    return-object v0
.end method

.method public bridge synthetic getParsedResponse()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;->getParsedResponse()Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;

    move-result-object v0

    return-object v0
.end method

.method protected internalEndParse()V
    .locals 4

    .prologue
    .line 43
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseEndOfDocument()Lorg/w3c/dom/Document;

    move-result-object v2

    .line 44
    .local v2, "xmlDoc":Lorg/w3c/dom/Document;
    if-nez v2, :cond_0

    .line 46
    sget-object v3, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {p0, v3}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;->setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z

    .line 61
    :goto_0
    return-void

    .line 50
    :cond_0
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;

    invoke-direct {v1}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;-><init>()V

    .line 51
    .local v1, "result":Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;
    invoke-static {v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorParser;->parseError(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/common/FIRSError;

    move-result-object v3

    .line 53
    if-eqz v3, :cond_1

    .line 55
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;->DeregisterDeviceErrorTypeFailed:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    invoke-direct {v0, v3}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;-><init>(Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;)V

    .line 57
    .local v0, "error":Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;
    invoke-virtual {v1, v0}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;->setError(Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;)V

    .line 60
    .end local v0    # "error":Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;
    :cond_1
    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;->mResponse:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;

    goto :goto_0
.end method

.method protected internalParseBodyChunk([BJ)V
    .locals 1
    .param p1, "data"    # [B
    .param p2, "length"    # J

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseChunk([BJ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 36
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;->setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z

    .line 38
    :cond_0
    return-void
.end method
