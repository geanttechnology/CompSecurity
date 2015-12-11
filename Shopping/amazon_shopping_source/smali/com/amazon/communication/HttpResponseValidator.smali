.class public Lcom/amazon/communication/HttpResponseValidator;
.super Ljava/lang/Object;
.source "HttpResponseValidator.java"


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 29
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.HttpResponseValidator"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/HttpResponseValidator;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    return-void
.end method

.method private static changeStatusLine(Lorg/apache/http/HttpResponse;ILjava/lang/String;)V
    .locals 8
    .param p0, "response"    # Lorg/apache/http/HttpResponse;
    .param p1, "newStatusCode"    # I
    .param p2, "newReasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 106
    invoke-interface {p0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v1

    .line 107
    .local v1, "statusLine":Lorg/apache/http/StatusLine;
    new-instance v0, Lorg/apache/http/message/BasicStatusLine;

    invoke-interface {v1}, Lorg/apache/http/StatusLine;->getProtocolVersion()Lorg/apache/http/ProtocolVersion;

    move-result-object v2

    invoke-direct {v0, v2, p1, p2}, Lorg/apache/http/message/BasicStatusLine;-><init>(Lorg/apache/http/ProtocolVersion;ILjava/lang/String;)V

    .line 109
    .local v0, "newStatusLine":Lorg/apache/http/StatusLine;
    sget-object v2, Lcom/amazon/communication/HttpResponseValidator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v3, "changeStatusCode"

    const-string/jumbo v4, "changing code and phrase"

    const/4 v5, 0x4

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string/jumbo v7, "statusLine"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object v0, v5, v6

    const/4 v6, 0x2

    const-string/jumbo v7, "newStatusLine"

    aput-object v7, v5, v6

    const/4 v6, 0x3

    aput-object v1, v5, v6

    invoke-virtual {v2, v3, v4, v5}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 111
    invoke-interface {p0, v0}, Lorg/apache/http/HttpResponse;->setStatusLine(Lorg/apache/http/StatusLine;)V

    .line 112
    return-void
.end method

.method public static validateContentLength(Lorg/apache/http/HttpResponse;)Z
    .locals 14
    .param p0, "response"    # Lorg/apache/http/HttpResponse;

    .prologue
    .line 51
    invoke-interface {p0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v8

    invoke-interface {v8}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    .line 52
    .local v7, "statusCode":I
    div-int/lit8 v8, v7, 0x64

    const/4 v9, 0x2

    if-eq v8, v9, :cond_0

    .line 53
    sget-object v8, Lcom/amazon/communication/HttpResponseValidator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "validateContentLength"

    const-string/jumbo v10, "Ignoring non-2xx status code"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    const-string/jumbo v13, "statusCode"

    aput-object v13, v11, v12

    const/4 v12, 0x1

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 55
    const/4 v8, 0x1

    .line 96
    :goto_0
    return v8

    .line 57
    :cond_0
    const-string/jumbo v8, "Content-Length"

    invoke-interface {p0, v8}, Lorg/apache/http/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lorg/apache/http/Header;

    move-result-object v0

    .line 58
    .local v0, "contentHeader":Lorg/apache/http/Header;
    if-nez v0, :cond_1

    .line 60
    sget-object v8, Lcom/amazon/communication/HttpResponseValidator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "validateContentLength"

    const-string/jumbo v10, "No Content-Length header"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 61
    const/4 v8, 0x1

    goto :goto_0

    .line 65
    :cond_1
    invoke-interface {v0}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 66
    .local v4, "headerContentLength":J
    sget-object v8, Lcom/amazon/communication/HttpResponseValidator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "validateContentLength"

    const-string/jumbo v10, "Got header content-length"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    const-string/jumbo v13, "headerContentLength"

    aput-object v13, v11, v12

    const/4 v12, 0x1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 68
    const-wide/16 v8, 0x0

    cmp-long v8, v4, v8

    if-gez v8, :cond_2

    .line 70
    const/4 v8, 0x1

    goto :goto_0

    .line 74
    :cond_2
    invoke-interface {p0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    .line 75
    .local v1, "entity":Lorg/apache/http/HttpEntity;
    if-nez v1, :cond_3

    .line 76
    const-wide/16 v8, 0x0

    cmp-long v8, v4, v8

    if-eqz v8, :cond_5

    .line 77
    sget-object v8, Lcom/amazon/communication/HttpResponseValidator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "validateContentLength"

    const-string/jumbo v10, "Unexpected null content"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    const-string/jumbo v13, "headerContentLength"

    aput-object v13, v11, v12

    const/4 v12, 0x1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 79
    const-string/jumbo v8, "Content-Length"

    const-string/jumbo v9, "0"

    invoke-interface {p0, v8, v9}, Lorg/apache/http/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const/16 v8, 0x1f4

    const-string/jumbo v9, "Unexpected Null Content"

    invoke-static {p0, v8, v9}, Lcom/amazon/communication/HttpResponseValidator;->changeStatusLine(Lorg/apache/http/HttpResponse;ILjava/lang/String;)V

    .line 81
    const/4 v8, 0x0

    goto :goto_0

    .line 84
    :cond_3
    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->getContentLength()J

    move-result-wide v2

    .line 85
    .local v2, "entityContentLength":J
    sget-object v8, Lcom/amazon/communication/HttpResponseValidator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "validateContentLength"

    const-string/jumbo v10, "got entity content-length"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    const-string/jumbo v13, "entityContentLength"

    aput-object v13, v11, v12

    const/4 v12, 0x1

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 87
    cmp-long v8, v4, v2

    if-eqz v8, :cond_5

    .line 88
    sget-object v8, Lcom/amazon/communication/HttpResponseValidator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "validateContentLength"

    const-string/jumbo v10, "Length mismatch"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 89
    const-string/jumbo v8, "Content-Length"

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    invoke-interface {p0, v8, v9}, Lorg/apache/http/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    cmp-long v8, v2, v4

    if-gez v8, :cond_4

    const-string/jumbo v6, "Response Truncated"

    .line 92
    .local v6, "reasonPhrase":Ljava/lang/String;
    :goto_1
    const/16 v8, 0x1f4

    invoke-static {p0, v8, v6}, Lcom/amazon/communication/HttpResponseValidator;->changeStatusLine(Lorg/apache/http/HttpResponse;ILjava/lang/String;)V

    .line 93
    const/4 v8, 0x0

    goto/16 :goto_0

    .line 90
    .end local v6    # "reasonPhrase":Ljava/lang/String;
    :cond_4
    const-string/jumbo v6, "Content Length Mismatch"

    goto :goto_1

    .line 96
    .end local v2    # "entityContentLength":J
    :cond_5
    const/4 v8, 0x1

    goto/16 :goto_0
.end method
