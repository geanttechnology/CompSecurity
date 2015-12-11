.class public Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;
.super Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
.source "RenameDeviceResponseParser.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/kcpsdk/common/WebResponseParser",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;",
        ">;"
    }
.end annotation


# static fields
.field public static final ERROR_CODE_ALREADY_USED:I = 0x4

.field public static final ERROR_CODE_INVALID_INPUT:I = 0x2

.field public static final ERROR_CODE_SUCCESS:I


# instance fields
.field private final mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

.field private mResponse:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;-><init>(Ljava/lang/String;)V

    .line 32
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/common/XMLParser;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    .line 33
    return-void
.end method


# virtual methods
.method public getParsedResponse()Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;->mResponse:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;

    return-object v0
.end method

.method public bridge synthetic getParsedResponse()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;->getParsedResponse()Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;

    move-result-object v0

    return-object v0
.end method

.method protected internalEndParse()V
    .locals 7

    .prologue
    const/4 v5, 0x0

    const/4 v3, 0x7

    .line 53
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseEndOfDocument()Lorg/w3c/dom/Document;

    move-result-object v1

    .line 54
    .local v1, "xmlDoc":Lorg/w3c/dom/Document;
    if-nez v1, :cond_0

    .line 56
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {p0, v2}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;->setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z

    .line 64
    :goto_0
    return-void

    .line 61
    :cond_0
    invoke-interface {v1}, Lorg/w3c/dom/Document;->getDocumentElement()Lorg/w3c/dom/Element;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-interface {v2}, Lorg/w3c/dom/Element;->getTagName()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v6, "response"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    :cond_1
    move-object v0, v5

    :goto_1
    if-nez v0, :cond_2

    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;

    invoke-direct {v0, v5, v3}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;-><init>(Ljava/lang/String;I)V

    .line 62
    .local v0, "response":Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;
    :cond_2
    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;->mResponse:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;

    goto :goto_0

    .line 61
    .end local v0    # "response":Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;
    :cond_3
    const-string/jumbo v4, "error_code"

    invoke-static {v2, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v4

    const-string/jumbo v6, "text"

    invoke-static {v2, v6}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    invoke-static {v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v6

    if-nez v4, :cond_4

    move-object v0, v5

    goto :goto_1

    :cond_4
    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    if-nez v2, :cond_5

    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;

    const-string/jumbo v4, "No response code found."

    invoke-direct {v2, v4, v3}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;-><init>(Ljava/lang/String;I)V

    :goto_2
    move-object v0, v2

    goto :goto_1

    :cond_5
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    :pswitch_0
    move v2, v3

    :goto_3
    new-instance v4, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;

    invoke-direct {v4, v6, v2}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;-><init>(Ljava/lang/String;I)V

    move-object v2, v4

    goto :goto_2

    :pswitch_1
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    goto :goto_3

    :pswitch_2
    const/4 v2, 0x3

    goto :goto_3

    :pswitch_3
    const/4 v2, 0x5

    goto :goto_3

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method protected internalParseBodyChunk([BJ)V
    .locals 1
    .param p1, "data"    # [B
    .param p2, "length"    # J

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseChunk([BJ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 46
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;->setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z

    .line 48
    :cond_0
    return-void
.end method
