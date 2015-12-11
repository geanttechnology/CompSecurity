.class public Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;
.super Ljava/lang/Object;
.source "AmazonOODMSUserIdentifier.java"

# interfaces
.implements Lcom/AmazonDevice/Identity/Common/IWebResponseParser;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "GenericWebResponseParser"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;
    }
.end annotation


# instance fields
.field private httpCode:Ljava/lang/Long;

.field private parseError:Lcom/AmazonDevice/Identity/Common/ParseError;

.field private final stream:Ljava/io/ByteArrayOutputStream;


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 217
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 231
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->stream:Ljava/io/ByteArrayOutputStream;

    .line 233
    sget-object v0, Lcom/AmazonDevice/Identity/Common/ParseError;->ParseErrorNoError:Lcom/AmazonDevice/Identity/Common/ParseError;

    iput-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->parseError:Lcom/AmazonDevice/Identity/Common/ParseError;

    return-void
.end method


# virtual methods
.method public beginParse(Lcom/AmazonDevice/Identity/Common/WebResponseHeaders;)V
    .locals 4
    .param p1, "headers"    # Lcom/AmazonDevice/Identity/Common/WebResponseHeaders;

    .prologue
    .line 238
    invoke-virtual {p1}, Lcom/AmazonDevice/Identity/Common/WebResponseHeaders;->getStatusCode()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->httpCode:Ljava/lang/Long;

    .line 239
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->httpCode:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    const-wide/16 v2, 0xc8

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->httpCode:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    const-wide/16 v2, 0x12c

    cmp-long v0, v0, v2

    if-ltz v0, :cond_1

    .line 240
    :cond_0
    sget-object v0, Lcom/AmazonDevice/Identity/Common/ParseError;->ParseErrorHttpError:Lcom/AmazonDevice/Identity/Common/ParseError;

    iput-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->parseError:Lcom/AmazonDevice/Identity/Common/ParseError;

    .line 241
    :cond_1
    return-void
.end method

.method public endParse()Lcom/AmazonDevice/Identity/Common/ParseError;
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->parseError:Lcom/AmazonDevice/Identity/Common/ParseError;

    return-object v0
.end method

.method public getParseError()Lcom/AmazonDevice/Identity/Common/ParseError;
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->parseError:Lcom/AmazonDevice/Identity/Common/ParseError;

    return-object v0
.end method

.method public getParsedResponse()Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;
    .locals 7

    .prologue
    .line 260
    :try_start_0
    iget-object v2, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->stream:Ljava/io/ByteArrayOutputStream;

    const-string/jumbo v3, "UTF-8"

    invoke-virtual {v2, v3}, Ljava/io/ByteArrayOutputStream;->toString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 261
    .local v1, "response":Ljava/lang/String;
    new-instance v2, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;

    iget-object v3, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->httpCode:Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-direct {v2, v3, v4, v1}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;-><init>(JLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 265
    .end local v1    # "response":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 263
    :catch_0
    move-exception v0

    .line 265
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;

    const-wide/16 v3, 0x1f4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Error decoding response "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;-><init>(JLjava/lang/String;)V

    goto :goto_0
.end method

.method public bridge synthetic getParsedResponse()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 217
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->getParsedResponse()Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;

    move-result-object v0

    return-object v0
.end method

.method public parseBodyChunk([BI)Lcom/AmazonDevice/Identity/Common/ParseError;
    .locals 2
    .param p1, "bodyChunk"    # [B
    .param p2, "length"    # I

    .prologue
    .line 272
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->stream:Ljava/io/ByteArrayOutputStream;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1, p2}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 273
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;->parseError:Lcom/AmazonDevice/Identity/Common/ParseError;

    return-object v0
.end method

.method public shouldParseBody()Z
    .locals 1

    .prologue
    .line 279
    const/4 v0, 0x1

    return v0
.end method
