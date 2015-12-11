.class public Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;
.super Ljava/lang/Object;
.source "WebResponseParserAdapter.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;


# instance fields
.field protected mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/common/WebResponseParser;)V
    .locals 0
    .param p1, "parser"    # Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    .line 16
    return-void
.end method


# virtual methods
.method public beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
    .locals 1
    .param p1, "responseHeaders"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v0, :cond_0

    .line 23
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V

    .line 25
    :cond_0
    return-void
.end method

.method public endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    .line 46
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    .line 70
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getParsedResponse()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParsedResponse()Ljava/lang/Object;

    move-result-object v0

    .line 81
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parseBodyChunk([BI)Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 3
    .param p1, "data"    # [B
    .param p2, "len"    # I

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v0, :cond_0

    .line 32
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    int-to-long v1, p2

    invoke-virtual {v0, p1, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->parseBodyChunk([BJ)Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    .line 35
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public shouldParseBody()Z
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;->mParser:Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->shouldParseBody()Z

    move-result v0

    .line 59
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
