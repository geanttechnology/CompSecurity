.class public Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;
.super Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
.source "AuthenticatedResponseHandler.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/amazon/identity/kcpsdk/common/WebResponseParser",
        "<TT;>;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mAuthSucceeded:Z

.field private mInnerParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

.field private final mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/identity/kcpsdk/common/WebResponseParser",
            "<TT;>;"
        }
    .end annotation
.end field

.field private mOuterParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

.field private final mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

.field private mShouldTryParsing:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/kcpsdk/common/WebResponseParser;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/kcpsdk/common/WebResponseParser",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 30
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    .local p1, "nextParser":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;-><init>(Ljava/lang/String;)V

    .line 32
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/common/XMLParser;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    .line 33
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    .line 35
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mInnerParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 36
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mOuterParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 37
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mAuthSucceeded:Z

    .line 38
    return-void
.end method


# virtual methods
.method public authenticationSucceeded()Z
    .locals 1

    .prologue
    .line 48
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mAuthSucceeded:Z

    return v0
.end method

.method public getCredentialErrorText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->getWebResponseHeaders()Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatusChecker;->getErrorText(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCredentialStatus()Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;
    .locals 1

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->getWebResponseHeaders()Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatusChecker;->checkResponse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    move-result-object v0

    return-object v0
.end method

.method public getCredentialWarningText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->getWebResponseHeaders()Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatusChecker;->getWarningText(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getParsedResponse()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 69
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-nez v0, :cond_0

    .line 71
    const/4 v0, 0x0

    .line 74
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParsedResponse()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method protected internalBeginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Z
    .locals 9
    .param p1, "response"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    const/4 v4, 0x0

    const/4 v5, 0x1

    .line 80
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v3, :cond_0

    .line 82
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v3, p1}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V

    .line 92
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->getStatusCode()J

    move-result-wide v1

    .line 93
    .local v1, "statusCode":J
    const-string/jumbo v3, "content-type"

    invoke-virtual {p1, v3}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->getHeaderByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 94
    .local v0, "contentType":Ljava/lang/String;
    const-wide/16 v6, 0x1f4

    cmp-long v3, v1, v6

    if-eqz v3, :cond_1

    const-wide/16 v6, 0xc8

    cmp-long v3, v1, v6

    if-nez v3, :cond_3

    if-eqz v0, :cond_1

    const-string/jumbo v3, "text/xml"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    :cond_1
    move v3, v5

    :goto_0
    iput-boolean v3, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mShouldTryParsing:Z

    .line 100
    iget-boolean v3, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mShouldTryParsing:Z

    if-eqz v3, :cond_2

    .line 102
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "AuthenticatedResponseHandler: beginParse: Response could be an authentication error. Will try to parse as an authentication error. Status Code: %d Content-Type: %s"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v7, v4

    aput-object v0, v7, v5

    invoke-static {v3, v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 108
    :cond_2
    return v5

    :cond_3
    move v3, v4

    .line 94
    goto :goto_0
.end method

.method protected internalEndParse()V
    .locals 4

    .prologue
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    const/4 v0, 0x0

    .line 134
    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mShouldTryParsing:Z

    if-eqz v1, :cond_3

    .line 136
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mOuterParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-ne v1, v2, :cond_8

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseEndOfDocument()Lorg/w3c/dom/Document;

    move-result-object v1

    if-eqz v1, :cond_8

    invoke-static {v1}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorParser;->parseError(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/common/FIRSError;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/FIRSError;->getErrorType()Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    move-result-object v2

    sget-object v3, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    if-eq v2, v3, :cond_2

    :cond_0
    invoke-interface {v1}, Lorg/w3c/dom/Document;->getDocumentElement()Lorg/w3c/dom/Element;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-interface {v1}, Lorg/w3c/dom/Element;->getTagName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Errors"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    :cond_1
    move v1, v0

    :goto_0
    if-eqz v1, :cond_8

    :cond_2
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "AuthenticatedResponseHandler: endParse: Server returned an authentication error. You can ignore any malformed response errors from the inner parser."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    :goto_1
    iput-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mAuthSucceeded:Z

    .line 139
    :cond_3
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mInnerParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-ne v0, v1, :cond_4

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->shouldParseBody()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 141
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mInnerParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 145
    :cond_4
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mAuthSucceeded:Z

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mInnerParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    :goto_2
    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z

    .line 146
    return-void

    .line 136
    :cond_5
    const-string/jumbo v2, "Error"

    invoke-static {v1, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v1

    if-nez v1, :cond_6

    move v1, v0

    goto :goto_0

    :cond_6
    const-string/jumbo v2, "Code"

    invoke-static {v1, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v1

    if-nez v1, :cond_7

    move v1, v0

    goto :goto_0

    :cond_7
    const-string/jumbo v2, "DEVICE_MASTER_SERVICE_ERROR"

    invoke-interface {v1}, Lorg/w3c/dom/Element;->getTextContent()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0

    :cond_8
    const/4 v0, 0x1

    goto :goto_1

    .line 145
    :cond_9
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mOuterParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    goto :goto_2
.end method

.method protected internalParseBodyChunk([BJ)V
    .locals 2
    .param p1, "data"    # [B
    .param p2, "length"    # J

    .prologue
    .line 114
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mOuterParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-ne v0, v1, :cond_0

    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mShouldTryParsing:Z

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseChunk([BJ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 118
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mOuterParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 122
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mInnerParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->shouldParseBody()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 127
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->parseBodyChunk([BJ)Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mInnerParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 129
    :cond_1
    return-void
.end method

.method public shouldParseBody()Z
    .locals 1

    .prologue
    .line 43
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;, "Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mNextParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->shouldParseBody()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->mShouldTryParsing:Z

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
