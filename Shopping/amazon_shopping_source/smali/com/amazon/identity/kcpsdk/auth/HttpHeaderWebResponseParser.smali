.class public Lcom/amazon/identity/kcpsdk/auth/HttpHeaderWebResponseParser;
.super Ljava/lang/Object;
.source "HttpHeaderWebResponseParser.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;


# instance fields
.field private mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/HttpHeaderWebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    return-void
.end method


# virtual methods
.method public beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
    .locals 4
    .param p1, "responseHeaders"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 17
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->getStatusCode()J

    move-result-wide v0

    .line 19
    .local v0, "httpCode":J
    const-wide/16 v2, 0xc8

    cmp-long v2, v0, v2

    if-ltz v2, :cond_0

    const-wide/16 v2, 0x12c

    cmp-long v2, v0, v2

    if-ltz v2, :cond_1

    .line 21
    :cond_0
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorHttpError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    iput-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/HttpHeaderWebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 23
    :cond_1
    return-void
.end method

.method public endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/HttpHeaderWebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    return-object v0
.end method

.method public getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/HttpHeaderWebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    return-object v0
.end method

.method public getParsedResponse()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 40
    const/4 v0, 0x0

    return-object v0
.end method

.method public parseBodyChunk([BI)Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 1
    .param p1, "bodyChunk"    # [B
    .param p2, "length"    # I

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/HttpHeaderWebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    return-object v0
.end method

.method public shouldParseBody()Z
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    return v0
.end method
