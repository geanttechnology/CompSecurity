.class public interface abstract Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;
.super Ljava/lang/Object;
.source "IWebResponseParser.java"


# virtual methods
.method public abstract beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
.end method

.method public abstract endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;
.end method

.method public abstract getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;
.end method

.method public abstract getParsedResponse()Ljava/lang/Object;
.end method

.method public abstract parseBodyChunk([BI)Lcom/amazon/identity/kcpsdk/common/ParseError;
.end method

.method public abstract shouldParseBody()Z
.end method
