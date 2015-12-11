.class public abstract Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;
.super Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
.source "JsonWebResponseParser.java"


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
.field private final mBuffer:Ljava/io/ByteArrayOutputStream;

.field private final mParser:Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser",
            "<TT;>;"
        }
    .end annotation
.end field

.field private mResponse:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;)V
    .locals 1
    .param p1, "parserName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;, "Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser<TT;>;"
    .local p2, "parser":Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;, "Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser<TT;>;"
    invoke-direct {p0, p1}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;-><init>(Ljava/lang/String;)V

    .line 20
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    .line 22
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->mResponse:Ljava/lang/Object;

    .line 27
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;

    .line 28
    return-void
.end method


# virtual methods
.method public getParsedResponse()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;, "Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->mResponse:Ljava/lang/Object;

    return-object v0
.end method

.method protected internalBeginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Z
    .locals 1
    .param p1, "headers"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 39
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;, "Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser<TT;>;"
    const/4 v0, 0x1

    return v0
.end method

.method protected internalEndParse()V
    .locals 6

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;, "Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser<TT;>;"
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    :goto_0
    :try_start_1
    new-instance v2, Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-direct {v2, v3, v4}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 63
    .local v2, "jsonString":Ljava/lang/String;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 64
    .local v1, "json":Lorg/json/JSONObject;
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->TAG:Ljava/lang/String;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 65
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;

    invoke-virtual {v3, v1}, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;->parse(Lorg/json/JSONObject;)Ljava/lang/Object;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->mResponse:Ljava/lang/Object;
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_2

    .line 75
    .end local v1    # "json":Lorg/json/JSONObject;
    .end local v2    # "jsonString":Ljava/lang/String;
    :goto_1
    return-void

    .line 57
    :catch_0
    move-exception v3

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v4, " Failed to close buffer"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 67
    :catch_1
    move-exception v0

    .line 69
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 73
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :catch_2
    move-exception v3

    sget-object v3, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {p0, v3}, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z

    goto :goto_1
.end method

.method protected internalParseBodyChunk([BJ)V
    .locals 3
    .param p1, "data"    # [B
    .param p2, "length"    # J

    .prologue
    .line 45
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;, "Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    const/4 v1, 0x0

    long-to-int v2, p2

    invoke-virtual {v0, p1, v1, v2}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 46
    return-void
.end method
