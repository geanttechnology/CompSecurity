.class public abstract Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
.super Ljava/lang/Object;
.source "WebResponseParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mCurrentState:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

.field private mParseBodyChunkWasMaybeNeeded:Z

.field private mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

.field private final mParserName:Ljava/lang/String;

.field private mWebResponseHeaders:Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 10
    const-class v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "parserName"    # Ljava/lang/String;

    .prologue
    .line 28
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mParserName:Ljava/lang/String;

    .line 30
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 31
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Before_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mCurrentState:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    .line 32
    return-void
.end method

.method private checkAndChangeState(Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;)V
    .locals 5
    .param p1, "nextState"    # Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    .prologue
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    const/4 v4, 0x0

    const/4 v2, 0x1

    .line 148
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mCurrentState:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Before_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-eq v0, v1, :cond_0

    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Begin_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-ne p1, v0, :cond_0

    .line 150
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: beginParse has been called more than once."

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 192
    :goto_0
    return-void

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mCurrentState:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Before_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-ne v0, v1, :cond_2

    .line 156
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Parsing:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-ne p1, v0, :cond_1

    .line 158
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: parseBodyChunk called before beginParse"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 162
    :cond_1
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Completed:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-ne p1, v0, :cond_5

    .line 164
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: endParse called before beginParse"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 168
    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mCurrentState:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Begin_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-ne v0, v1, :cond_4

    .line 170
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Completed:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-ne p1, v0, :cond_3

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->shouldParseBody()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 172
    iput-boolean v2, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mParseBodyChunkWasMaybeNeeded:Z

    goto :goto_0

    .line 176
    :cond_3
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Parsing:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-ne p1, v0, :cond_5

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->shouldParseBody()Z

    move-result v0

    if-nez v0, :cond_5

    .line 178
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: shouldParseBody is false. parseBodyChunk should not be called"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 182
    :cond_4
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mCurrentState:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Completed:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-ne v0, v1, :cond_5

    .line 184
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Parsing:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    if-ne p1, v0, :cond_5

    .line 186
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: parseBodyChunk called after endParse"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 191
    :cond_5
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mCurrentState:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    goto :goto_0
.end method


# virtual methods
.method public beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
    .locals 8
    .param p1, "responseHeaders"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 36
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    sget-object v3, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Begin_Parse:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    invoke-direct {p0, v3}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->checkAndChangeState(Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;)V

    .line 38
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mWebResponseHeaders:Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .line 40
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->internalBeginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Z

    move-result v0

    .line 42
    .local v0, "handled":Z
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mWebResponseHeaders:Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->getStatusCode()J

    move-result-wide v1

    .line 43
    .local v1, "httpCode":J
    const-wide/16 v3, 0xc8

    cmp-long v3, v1, v3

    if-ltz v3, :cond_0

    const-wide/16 v3, 0x12c

    cmp-long v3, v1, v3

    if-ltz v3, :cond_1

    .line 45
    :cond_0
    sget-object v3, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "%s: HTTP Error: %d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 46
    if-nez v0, :cond_1

    .line 48
    sget-object v3, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorHttpError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {p0, v3}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z

    .line 51
    :cond_1
    return-void
.end method

.method public endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 6

    .prologue
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 78
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Completed:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->checkAndChangeState(Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;)V

    .line 80
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-eq v0, v1, :cond_0

    .line 82
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: endParse: called after another method returned a parse error."

    new-array v2, v5, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 84
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    .line 103
    :goto_0
    return-object v0

    .line 87
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->internalEndParse()V

    .line 89
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-ne v0, v1, :cond_2

    .line 91
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mParseBodyChunkWasMaybeNeeded:Z

    if-eqz v0, :cond_1

    .line 93
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: endParse called before parseBodyChunk. Confirm that this is by design."

    new-array v2, v5, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 98
    :cond_1
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: endParse: Malformed response. Confirm all received data is being properly passed to the parser, device capabilities are set properly, and no server-side behavior changes have occurred."

    new-array v2, v5, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 103
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    goto :goto_0
.end method

.method public getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 1

    .prologue
    .line 113
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    return-object v0
.end method

.method public abstract getParsedResponse()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method protected getParserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mParserName:Ljava/lang/String;

    return-object v0
.end method

.method protected getWebResponseHeaders()Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;
    .locals 1

    .prologue
    .line 138
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mWebResponseHeaders:Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    return-object v0
.end method

.method protected internalBeginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Z
    .locals 1
    .param p1, "responseHeaders"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 143
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    const/4 v0, 0x0

    return v0
.end method

.method protected abstract internalEndParse()V
.end method

.method protected abstract internalParseBodyChunk([BJ)V
.end method

.method public parseBodyChunk([BJ)Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 5
    .param p1, "data"    # [B
    .param p2, "length"    # J

    .prologue
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 55
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;->Parsing:Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;

    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->checkAndChangeState(Lcom/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState;)V

    .line 57
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-eq v0, v1, :cond_0

    .line 59
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: parseBodyChunk: called after another method returned a parse error."

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 61
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    .line 73
    :goto_0
    return-object v0

    .line 64
    :cond_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->internalParseBodyChunk([BJ)V

    .line 66
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-ne v0, v1, :cond_1

    .line 68
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: parseBodyChunk: Malformed response. confirm all received data is being properly passed to the parser, device capabilities are set properly, and no server-side behavior changes have occurred."

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 73
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    goto :goto_0
.end method

.method protected setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z
    .locals 6
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;

    .prologue
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    const/4 v5, 0x1

    .line 118
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-eq v0, v1, :cond_0

    .line 120
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "%s: setParseError has been called more than once.  Was %s, Now %s."

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/common/ParseError;->name()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    const/4 v3, 0x2

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/ParseError;->name()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 127
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->mParseError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 128
    return v5
.end method

.method public shouldParseBody()Z
    .locals 2

    .prologue
    .line 108
    .local p0, "this":Lcom/amazon/identity/kcpsdk/common/WebResponseParser;, "Lcom/amazon/identity/kcpsdk/common/WebResponseParser<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorHttpError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
