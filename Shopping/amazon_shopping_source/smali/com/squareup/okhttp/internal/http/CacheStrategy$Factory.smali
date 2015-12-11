.class public Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;
.super Ljava/lang/Object;
.source "CacheStrategy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/http/CacheStrategy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Factory"
.end annotation


# instance fields
.field private ageSeconds:I

.field final cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

.field private etag:Ljava/lang/String;

.field private expires:Ljava/util/Date;

.field private lastModified:Ljava/util/Date;

.field private lastModifiedString:Ljava/lang/String;

.field final nowMillis:J

.field private receivedResponseMillis:J

.field final request:Lcom/squareup/okhttp/internal/http/Request;

.field private sentRequestMillis:J

.field private servedDate:Ljava/util/Date;

.field private servedDateString:Ljava/lang/String;


# direct methods
.method public constructor <init>(JLcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;)V
    .locals 5
    .param p1, "nowMillis"    # J
    .param p3, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .param p4, "cacheResponse"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    const/4 v3, -0x1

    iput v3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->ageSeconds:I

    .line 129
    iput-wide p1, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->nowMillis:J

    .line 130
    iput-object p3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    .line 131
    iput-object p4, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    .line 133
    if-eqz p4, :cond_7

    .line 134
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p4}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v3

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Headers;->size()I

    move-result v3

    if-ge v1, v3, :cond_7

    .line 135
    invoke-virtual {p4}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;

    move-result-object v0

    .line 136
    .local v0, "fieldName":Ljava/lang/String;
    invoke-virtual {p4}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;

    move-result-object v2

    .line 137
    .local v2, "value":Ljava/lang/String;
    const-string/jumbo v3, "Date"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 138
    invoke-static {v2}, Lcom/squareup/okhttp/internal/http/HttpDate;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    iput-object v3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDate:Ljava/util/Date;

    .line 139
    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDateString:Ljava/lang/String;

    .line 134
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 140
    :cond_1
    const-string/jumbo v3, "Expires"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 141
    invoke-static {v2}, Lcom/squareup/okhttp/internal/http/HttpDate;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    iput-object v3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->expires:Ljava/util/Date;

    goto :goto_1

    .line 142
    :cond_2
    const-string/jumbo v3, "Last-Modified"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 143
    invoke-static {v2}, Lcom/squareup/okhttp/internal/http/HttpDate;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    iput-object v3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->lastModified:Ljava/util/Date;

    .line 144
    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->lastModifiedString:Ljava/lang/String;

    goto :goto_1

    .line 145
    :cond_3
    const-string/jumbo v3, "ETag"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 146
    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->etag:Ljava/lang/String;

    goto :goto_1

    .line 147
    :cond_4
    const-string/jumbo v3, "Age"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 148
    invoke-static {v2}, Lcom/squareup/okhttp/internal/http/HeaderParser;->parseSeconds(Ljava/lang/String;)I

    move-result v3

    iput v3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->ageSeconds:I

    goto :goto_1

    .line 149
    :cond_5
    sget-object v3, Lcom/squareup/okhttp/internal/http/OkHeaders;->SENT_MILLIS:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 150
    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    iput-wide v3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->sentRequestMillis:J

    goto :goto_1

    .line 151
    :cond_6
    sget-object v3, Lcom/squareup/okhttp/internal/http/OkHeaders;->RECEIVED_MILLIS:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 152
    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    iput-wide v3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->receivedResponseMillis:J

    goto :goto_1

    .line 156
    .end local v0    # "fieldName":Ljava/lang/String;
    .end local v1    # "i":I
    .end local v2    # "value":Ljava/lang/String;
    :cond_7
    return-void
.end method

.method private cacheResponseAge()J
    .locals 12

    .prologue
    const-wide/16 v0, 0x0

    .line 287
    iget-object v8, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDate:Ljava/util/Date;

    if-eqz v8, :cond_0

    iget-wide v8, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->receivedResponseMillis:J

    iget-object v10, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDate:Ljava/util/Date;

    invoke-virtual {v10}, Ljava/util/Date;->getTime()J

    move-result-wide v10

    sub-long/2addr v8, v10

    invoke-static {v0, v1, v8, v9}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    .line 290
    .local v0, "apparentReceivedAge":J
    :cond_0
    iget v8, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->ageSeconds:I

    const/4 v9, -0x1

    if-eq v8, v9, :cond_1

    sget-object v8, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    iget v9, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->ageSeconds:I

    int-to-long v9, v9

    invoke-virtual {v8, v9, v10}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v8

    invoke-static {v0, v1, v8, v9}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    .line 293
    .local v2, "receivedAge":J
    :goto_0
    iget-wide v8, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->receivedResponseMillis:J

    iget-wide v10, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->sentRequestMillis:J

    sub-long v6, v8, v10

    .line 294
    .local v6, "responseDuration":J
    iget-wide v8, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->nowMillis:J

    iget-wide v10, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->receivedResponseMillis:J

    sub-long v4, v8, v10

    .line 295
    .local v4, "residentDuration":J
    add-long v8, v2, v6

    add-long/2addr v8, v4

    return-wide v8

    .end local v2    # "receivedAge":J
    .end local v4    # "residentDuration":J
    .end local v6    # "responseDuration":J
    :cond_1
    move-wide v2, v0

    .line 290
    goto :goto_0
.end method

.method private computeFreshnessLifetime()J
    .locals 9

    .prologue
    const-wide/16 v5, 0x0

    .line 258
    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v7}, Lcom/squareup/okhttp/internal/http/Response;->cacheControl()Lcom/squareup/okhttp/CacheControl;

    move-result-object v2

    .line 259
    .local v2, "responseCaching":Lcom/squareup/okhttp/CacheControl;
    invoke-virtual {v2}, Lcom/squareup/okhttp/CacheControl;->maxAgeSeconds()I

    move-result v7

    const/4 v8, -0x1

    if-eq v7, v8, :cond_1

    .line 260
    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v2}, Lcom/squareup/okhttp/CacheControl;->maxAgeSeconds()I

    move-result v6

    int-to-long v6, v6

    invoke-virtual {v5, v6, v7}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v5

    .line 279
    :cond_0
    :goto_0
    return-wide v5

    .line 261
    :cond_1
    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->expires:Ljava/util/Date;

    if-eqz v7, :cond_4

    .line 262
    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDate:Ljava/util/Date;

    if-eqz v7, :cond_2

    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDate:Ljava/util/Date;

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v3

    .line 265
    .local v3, "servedMillis":J
    :goto_1
    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->expires:Ljava/util/Date;

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v7

    sub-long v0, v7, v3

    .line 266
    .local v0, "delta":J
    cmp-long v7, v0, v5

    if-lez v7, :cond_3

    .end local v0    # "delta":J
    :goto_2
    move-wide v5, v0

    goto :goto_0

    .line 262
    .end local v3    # "servedMillis":J
    :cond_2
    iget-wide v3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->receivedResponseMillis:J

    goto :goto_1

    .restart local v0    # "delta":J
    .restart local v3    # "servedMillis":J
    :cond_3
    move-wide v0, v5

    .line 266
    goto :goto_2

    .line 267
    .end local v0    # "delta":J
    .end local v3    # "servedMillis":J
    :cond_4
    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->lastModified:Ljava/util/Date;

    if-eqz v7, :cond_0

    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v7}, Lcom/squareup/okhttp/internal/http/Response;->request()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v7

    invoke-virtual {v7}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v7

    invoke-virtual {v7}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v7

    if-nez v7, :cond_0

    .line 273
    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDate:Ljava/util/Date;

    if-eqz v7, :cond_5

    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDate:Ljava/util/Date;

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v3

    .line 276
    .restart local v3    # "servedMillis":J
    :goto_3
    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->lastModified:Ljava/util/Date;

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v7

    sub-long v0, v3, v7

    .line 277
    .restart local v0    # "delta":J
    cmp-long v7, v0, v5

    if-lez v7, :cond_0

    const-wide/16 v5, 0xa

    div-long v5, v0, v5

    goto :goto_0

    .line 273
    .end local v0    # "delta":J
    .end local v3    # "servedMillis":J
    :cond_5
    iget-wide v3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->sentRequestMillis:J

    goto :goto_3
.end method

.method private getCandidate()Lcom/squareup/okhttp/internal/http/CacheStrategy;
    .locals 25

    .prologue
    .line 182
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v20, v0

    if-nez v20, :cond_0

    .line 183
    new-instance v20, Lcom/squareup/okhttp/internal/http/CacheStrategy;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v22, v0

    sget-object v23, Lcom/squareup/okhttp/ResponseSource;->NETWORK:Lcom/squareup/okhttp/ResponseSource;

    const/16 v24, 0x0

    invoke-direct/range {v20 .. v24}, Lcom/squareup/okhttp/internal/http/CacheStrategy;-><init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;Lcom/squareup/okhttp/internal/http/CacheStrategy$1;)V

    .line 250
    :goto_0
    return-object v20

    .line 187
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/squareup/okhttp/internal/http/Request;->isHttps()Z

    move-result v20

    if-eqz v20, :cond_1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/squareup/okhttp/internal/http/Response;->handshake()Lcom/squareup/okhttp/Handshake;

    move-result-object v20

    if-nez v20, :cond_1

    .line 188
    new-instance v20, Lcom/squareup/okhttp/internal/http/CacheStrategy;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v22, v0

    sget-object v23, Lcom/squareup/okhttp/ResponseSource;->NETWORK:Lcom/squareup/okhttp/ResponseSource;

    const/16 v24, 0x0

    invoke-direct/range {v20 .. v24}, Lcom/squareup/okhttp/internal/http/CacheStrategy;-><init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;Lcom/squareup/okhttp/internal/http/CacheStrategy$1;)V

    goto :goto_0

    .line 194
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v21, v0

    invoke-static/range {v20 .. v21}, Lcom/squareup/okhttp/internal/http/CacheStrategy;->isCacheable(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Request;)Z

    move-result v20

    if-nez v20, :cond_2

    .line 195
    new-instance v20, Lcom/squareup/okhttp/internal/http/CacheStrategy;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v22, v0

    sget-object v23, Lcom/squareup/okhttp/ResponseSource;->NETWORK:Lcom/squareup/okhttp/ResponseSource;

    const/16 v24, 0x0

    invoke-direct/range {v20 .. v24}, Lcom/squareup/okhttp/internal/http/CacheStrategy;-><init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;Lcom/squareup/okhttp/internal/http/CacheStrategy$1;)V

    goto :goto_0

    .line 198
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/squareup/okhttp/internal/http/Request;->cacheControl()Lcom/squareup/okhttp/CacheControl;

    move-result-object v17

    .line 199
    .local v17, "requestCaching":Lcom/squareup/okhttp/CacheControl;
    invoke-virtual/range {v17 .. v17}, Lcom/squareup/okhttp/CacheControl;->noCache()Z

    move-result v20

    if-nez v20, :cond_3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v20, v0

    invoke-static/range {v20 .. v20}, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->hasConditions(Lcom/squareup/okhttp/internal/http/Request;)Z

    move-result v20

    if-eqz v20, :cond_4

    .line 200
    :cond_3
    new-instance v20, Lcom/squareup/okhttp/internal/http/CacheStrategy;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v22, v0

    sget-object v23, Lcom/squareup/okhttp/ResponseSource;->NETWORK:Lcom/squareup/okhttp/ResponseSource;

    const/16 v24, 0x0

    invoke-direct/range {v20 .. v24}, Lcom/squareup/okhttp/internal/http/CacheStrategy;-><init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;Lcom/squareup/okhttp/internal/http/CacheStrategy$1;)V

    goto/16 :goto_0

    .line 203
    :cond_4
    invoke-direct/range {p0 .. p0}, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponseAge()J

    move-result-wide v4

    .line 204
    .local v4, "ageMillis":J
    invoke-direct/range {p0 .. p0}, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->computeFreshnessLifetime()J

    move-result-wide v9

    .line 206
    .local v9, "freshMillis":J
    invoke-virtual/range {v17 .. v17}, Lcom/squareup/okhttp/CacheControl;->maxAgeSeconds()I

    move-result v20

    const/16 v21, -0x1

    move/from16 v0, v20

    move/from16 v1, v21

    if-eq v0, v1, :cond_5

    .line 207
    sget-object v20, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual/range {v17 .. v17}, Lcom/squareup/okhttp/CacheControl;->maxAgeSeconds()I

    move-result v21

    move/from16 v0, v21

    int-to-long v0, v0

    move-wide/from16 v21, v0

    invoke-virtual/range {v20 .. v22}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v20

    move-wide/from16 v0, v20

    invoke-static {v9, v10, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v9

    .line 210
    :cond_5
    const-wide/16 v13, 0x0

    .line 211
    .local v13, "minFreshMillis":J
    invoke-virtual/range {v17 .. v17}, Lcom/squareup/okhttp/CacheControl;->minFreshSeconds()I

    move-result v20

    const/16 v21, -0x1

    move/from16 v0, v20

    move/from16 v1, v21

    if-eq v0, v1, :cond_6

    .line 212
    sget-object v20, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual/range {v17 .. v17}, Lcom/squareup/okhttp/CacheControl;->minFreshSeconds()I

    move-result v21

    move/from16 v0, v21

    int-to-long v0, v0

    move-wide/from16 v21, v0

    invoke-virtual/range {v20 .. v22}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v13

    .line 215
    :cond_6
    const-wide/16 v11, 0x0

    .line 216
    .local v11, "maxStaleMillis":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/squareup/okhttp/internal/http/Response;->cacheControl()Lcom/squareup/okhttp/CacheControl;

    move-result-object v18

    .line 217
    .local v18, "responseCaching":Lcom/squareup/okhttp/CacheControl;
    invoke-virtual/range {v18 .. v18}, Lcom/squareup/okhttp/CacheControl;->mustRevalidate()Z

    move-result v20

    if-nez v20, :cond_7

    invoke-virtual/range {v17 .. v17}, Lcom/squareup/okhttp/CacheControl;->maxStaleSeconds()I

    move-result v20

    const/16 v21, -0x1

    move/from16 v0, v20

    move/from16 v1, v21

    if-eq v0, v1, :cond_7

    .line 218
    sget-object v20, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual/range {v17 .. v17}, Lcom/squareup/okhttp/CacheControl;->maxStaleSeconds()I

    move-result v21

    move/from16 v0, v21

    int-to-long v0, v0

    move-wide/from16 v21, v0

    invoke-virtual/range {v20 .. v22}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v11

    .line 221
    :cond_7
    invoke-virtual/range {v18 .. v18}, Lcom/squareup/okhttp/CacheControl;->noCache()Z

    move-result v20

    if-nez v20, :cond_a

    add-long v20, v4, v13

    add-long v22, v9, v11

    cmp-long v20, v20, v22

    if-gez v20, :cond_a

    .line 222
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/squareup/okhttp/internal/http/Response;->newBuilder()Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v20

    sget-object v21, Lcom/squareup/okhttp/ResponseSource;->CACHE:Lcom/squareup/okhttp/ResponseSource;

    invoke-virtual/range {v20 .. v21}, Lcom/squareup/okhttp/internal/http/Response$Builder;->setResponseSource(Lcom/squareup/okhttp/ResponseSource;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v6

    .line 224
    .local v6, "builder":Lcom/squareup/okhttp/internal/http/Response$Builder;
    add-long v20, v4, v13

    cmp-long v20, v20, v9

    if-ltz v20, :cond_8

    .line 225
    const-string/jumbo v20, "Warning"

    const-string/jumbo v21, "110 HttpURLConnection \"Response is stale\""

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v6, v0, v1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    .line 227
    :cond_8
    const-wide/32 v15, 0x5265c00

    .line 228
    .local v15, "oneDayMillis":J
    cmp-long v20, v4, v15

    if-lez v20, :cond_9

    invoke-direct/range {p0 .. p0}, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->isFreshnessLifetimeHeuristic()Z

    move-result v20

    if-eqz v20, :cond_9

    .line 229
    const-string/jumbo v20, "Warning"

    const-string/jumbo v21, "113 HttpURLConnection \"Heuristic expiration\""

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v6, v0, v1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    .line 231
    :cond_9
    new-instance v20, Lcom/squareup/okhttp/internal/http/CacheStrategy;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v21, v0

    invoke-virtual {v6}, Lcom/squareup/okhttp/internal/http/Response$Builder;->build()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v22

    sget-object v23, Lcom/squareup/okhttp/ResponseSource;->CACHE:Lcom/squareup/okhttp/ResponseSource;

    const/16 v24, 0x0

    invoke-direct/range {v20 .. v24}, Lcom/squareup/okhttp/internal/http/CacheStrategy;-><init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;Lcom/squareup/okhttp/internal/http/CacheStrategy$1;)V

    goto/16 :goto_0

    .line 234
    .end local v6    # "builder":Lcom/squareup/okhttp/internal/http/Response$Builder;
    .end local v15    # "oneDayMillis":J
    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/squareup/okhttp/internal/http/Request;->newBuilder()Lcom/squareup/okhttp/internal/http/Request$Builder;

    move-result-object v8

    .line 236
    .local v8, "conditionalRequestBuilder":Lcom/squareup/okhttp/internal/http/Request$Builder;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->lastModified:Ljava/util/Date;

    move-object/from16 v20, v0

    if-eqz v20, :cond_d

    .line 237
    const-string/jumbo v20, "If-Modified-Since"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->lastModifiedString:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v8, v0, v1}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    .line 242
    :cond_b
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->etag:Ljava/lang/String;

    move-object/from16 v20, v0

    if-eqz v20, :cond_c

    .line 243
    const-string/jumbo v20, "If-None-Match"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->etag:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v8, v0, v1}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    .line 246
    :cond_c
    invoke-virtual {v8}, Lcom/squareup/okhttp/internal/http/Request$Builder;->build()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v7

    .line 247
    .local v7, "conditionalRequest":Lcom/squareup/okhttp/internal/http/Request;
    invoke-static {v7}, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->hasConditions(Lcom/squareup/okhttp/internal/http/Request;)Z

    move-result v20

    if-eqz v20, :cond_e

    sget-object v19, Lcom/squareup/okhttp/ResponseSource;->CONDITIONAL_CACHE:Lcom/squareup/okhttp/ResponseSource;

    .line 250
    .local v19, "responseSource":Lcom/squareup/okhttp/ResponseSource;
    :goto_2
    new-instance v20, Lcom/squareup/okhttp/internal/http/CacheStrategy;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v19

    move-object/from16 v3, v22

    invoke-direct {v0, v7, v1, v2, v3}, Lcom/squareup/okhttp/internal/http/CacheStrategy;-><init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;Lcom/squareup/okhttp/internal/http/CacheStrategy$1;)V

    goto/16 :goto_0

    .line 238
    .end local v7    # "conditionalRequest":Lcom/squareup/okhttp/internal/http/Request;
    .end local v19    # "responseSource":Lcom/squareup/okhttp/ResponseSource;
    :cond_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDate:Ljava/util/Date;

    move-object/from16 v20, v0

    if-eqz v20, :cond_b

    .line 239
    const-string/jumbo v20, "If-Modified-Since"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->servedDateString:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v8, v0, v1}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    goto :goto_1

    .line 247
    .restart local v7    # "conditionalRequest":Lcom/squareup/okhttp/internal/http/Request;
    :cond_e
    sget-object v19, Lcom/squareup/okhttp/ResponseSource;->NETWORK:Lcom/squareup/okhttp/ResponseSource;

    goto :goto_2
.end method

.method private static hasConditions(Lcom/squareup/okhttp/internal/http/Request;)Z
    .locals 1
    .param p0, "request"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    .line 313
    const-string/jumbo v0, "If-Modified-Since"

    invoke-virtual {p0, v0}, Lcom/squareup/okhttp/internal/http/Request;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "If-None-Match"

    invoke-virtual {p0, v0}, Lcom/squareup/okhttp/internal/http/Request;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isFreshnessLifetimeHeuristic()Z
    .locals 2

    .prologue
    .line 304
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->cacheResponse:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->cacheControl()Lcom/squareup/okhttp/CacheControl;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/CacheControl;->maxAgeSeconds()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->expires:Ljava/util/Date;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public get()Lcom/squareup/okhttp/internal/http/CacheStrategy;
    .locals 6

    .prologue
    .line 163
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->getCandidate()Lcom/squareup/okhttp/internal/http/CacheStrategy;

    move-result-object v0

    .line 165
    .local v0, "candidate":Lcom/squareup/okhttp/internal/http/CacheStrategy;
    iget-object v2, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy;->source:Lcom/squareup/okhttp/ResponseSource;

    sget-object v3, Lcom/squareup/okhttp/ResponseSource;->CACHE:Lcom/squareup/okhttp/ResponseSource;

    if-eq v2, v3, :cond_0

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->cacheControl()Lcom/squareup/okhttp/CacheControl;

    move-result-object v2

    invoke-virtual {v2}, Lcom/squareup/okhttp/CacheControl;->onlyIfCached()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 167
    new-instance v2, Lcom/squareup/okhttp/internal/http/Response$Builder;

    invoke-direct {v2}, Lcom/squareup/okhttp/internal/http/Response$Builder;-><init>()V

    iget-object v3, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v2, v3}, Lcom/squareup/okhttp/internal/http/Response$Builder;->request(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v2

    # getter for: Lcom/squareup/okhttp/internal/http/CacheStrategy;->GATEWAY_TIMEOUT_STATUS_LINE:Lcom/squareup/okhttp/internal/http/StatusLine;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/CacheStrategy;->access$100()Lcom/squareup/okhttp/internal/http/StatusLine;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/squareup/okhttp/internal/http/Response$Builder;->statusLine(Lcom/squareup/okhttp/internal/http/StatusLine;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v2

    sget-object v3, Lcom/squareup/okhttp/ResponseSource;->NONE:Lcom/squareup/okhttp/ResponseSource;

    invoke-virtual {v2, v3}, Lcom/squareup/okhttp/internal/http/Response$Builder;->setResponseSource(Lcom/squareup/okhttp/ResponseSource;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v2

    # getter for: Lcom/squareup/okhttp/internal/http/CacheStrategy;->EMPTY_BODY:Lcom/squareup/okhttp/internal/http/Response$Body;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/CacheStrategy;->access$000()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/squareup/okhttp/internal/http/Response$Builder;->body(Lcom/squareup/okhttp/internal/http/Response$Body;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Response$Builder;->build()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v1

    .line 173
    .local v1, "noneResponse":Lcom/squareup/okhttp/internal/http/Response;
    new-instance v2, Lcom/squareup/okhttp/internal/http/CacheStrategy;

    iget-object v3, v0, Lcom/squareup/okhttp/internal/http/CacheStrategy;->request:Lcom/squareup/okhttp/internal/http/Request;

    sget-object v4, Lcom/squareup/okhttp/ResponseSource;->NONE:Lcom/squareup/okhttp/ResponseSource;

    const/4 v5, 0x0

    invoke-direct {v2, v3, v1, v4, v5}, Lcom/squareup/okhttp/internal/http/CacheStrategy;-><init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;Lcom/squareup/okhttp/internal/http/CacheStrategy$1;)V

    move-object v0, v2

    .line 176
    .end local v0    # "candidate":Lcom/squareup/okhttp/internal/http/CacheStrategy;
    .end local v1    # "noneResponse":Lcom/squareup/okhttp/internal/http/Response;
    :cond_0
    return-object v0
.end method
