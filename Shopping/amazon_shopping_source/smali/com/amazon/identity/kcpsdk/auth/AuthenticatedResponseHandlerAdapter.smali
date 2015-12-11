.class public Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;
.super Ljava/lang/Object;
.source "AuthenticatedResponseHandlerAdapter.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;


# instance fields
.field private mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

.field private mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;)V
    .locals 2
    .param p1, "parser"    # Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    .line 16
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;-><init>(Lcom/amazon/identity/kcpsdk/common/WebResponseParser;)V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    .line 17
    return-void
.end method


# virtual methods
.method public authenticationSucceeded()Z
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->authenticationSucceeded()Z

    move-result v0

    return v0
.end method

.method public beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
    .locals 1
    .param p1, "responseHeaders"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    if-eqz v0, :cond_0

    .line 24
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0, p1}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V

    .line 26
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V

    .line 27
    return-void
.end method

.method public endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    if-eqz v0, :cond_0

    .line 49
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 51
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 52
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    return-object v0
.end method

.method public getCredentialErrorText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->getCredentialErrorText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCredentialStatus()Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->getCredentialStatus()Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    move-result-object v0

    return-object v0
.end method

.method public getCredentialWarningText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->getCredentialWarningText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 2

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-eq v0, v1, :cond_0

    .line 67
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    .line 69
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    goto :goto_0
.end method

.method public getParsedResponse()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    if-nez v0, :cond_0

    .line 77
    const/4 v0, 0x0

    .line 80
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->getParsedResponse()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public parseBodyChunk([BI)Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 3
    .param p1, "data"    # [B
    .param p2, "len"    # I

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->shouldParseBody()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0, p1, p2}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->parseBodyChunk([BI)Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 37
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->shouldParseBody()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 39
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    int-to-long v1, p2

    invoke-virtual {v0, p1, v1, v2}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->parseBodyChunk([BJ)Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 41
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    return-object v0
.end method

.method public shouldParseBody()Z
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mInnerResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->shouldParseBody()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->mAuthResponseHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler;->shouldParseBody()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
