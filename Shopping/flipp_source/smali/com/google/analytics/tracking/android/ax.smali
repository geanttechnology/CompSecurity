.class final Lcom/google/analytics/tracking/android/ax;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/analytics/tracking/android/p;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Lorg/apache/http/client/HttpClient;

.field private final c:Landroid/content/Context;

.field private d:Lcom/google/analytics/tracking/android/ak;

.field private e:Ljava/net/URL;


# direct methods
.method constructor <init>(Lorg/apache/http/client/HttpClient;Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 78
    invoke-static {p2}, Lcom/google/analytics/tracking/android/ak;->a(Landroid/content/Context;)Lcom/google/analytics/tracking/android/ak;

    move-result-object v0

    invoke-direct {p0, p1, v0, p2}, Lcom/google/analytics/tracking/android/ax;-><init>(Lorg/apache/http/client/HttpClient;Lcom/google/analytics/tracking/android/ak;Landroid/content/Context;)V

    .line 79
    return-void
.end method

.method private constructor <init>(Lorg/apache/http/client/HttpClient;Lcom/google/analytics/tracking/android/ak;Landroid/content/Context;)V
    .locals 9

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    invoke-virtual {p3}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ax;->c:Landroid/content/Context;

    .line 64
    const-string v0, "GoogleAnalytics"

    const-string v1, "3.0"

    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-static {v3}, Lcom/google/analytics/tracking/android/ba;->a(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v5, Landroid/os/Build;->ID:Ljava/lang/String;

    const-string v6, "%s/%s (Linux; U; Android %s; %s; %s Build/%s)"

    const/4 v7, 0x6

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v0, v7, v8

    const/4 v0, 0x1

    aput-object v1, v7, v0

    const/4 v0, 0x2

    aput-object v2, v7, v0

    const/4 v0, 0x3

    aput-object v3, v7, v0

    const/4 v0, 0x4

    aput-object v4, v7, v0

    const/4 v0, 0x5

    aput-object v5, v7, v0

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ax;->a:Ljava/lang/String;

    .line 72
    iput-object p1, p0, Lcom/google/analytics/tracking/android/ax;->b:Lorg/apache/http/client/HttpClient;

    .line 74
    iput-object p2, p0, Lcom/google/analytics/tracking/android/ax;->d:Lcom/google/analytics/tracking/android/ak;

    .line 75
    return-void
.end method

.method private a(Lcom/google/analytics/tracking/android/al;)Ljava/net/URL;
    .locals 3

    .prologue
    .line 256
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ax;->e:Ljava/net/URL;

    if-eqz v0, :cond_0

    .line 257
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ax;->e:Ljava/net/URL;

    .line 270
    :goto_0
    return-object v0

    .line 260
    :cond_0
    iget-object v1, p1, Lcom/google/analytics/tracking/android/al;->d:Ljava/lang/String;

    .line 262
    :try_start_0
    new-instance v0, Ljava/net/URL;

    const-string v2, "http:"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v1, "http://www.google-analytics.com/collect"

    :goto_1
    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 269
    :catch_0
    move-exception v0

    const-string v0, "Error trying to parse the hardcoded host url. This really shouldn\'t happen."

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->a(Ljava/lang/String;)V

    .line 270
    const/4 v0, 0x0

    goto :goto_0

    .line 262
    :cond_1
    :try_start_1
    const-string v1, "https://ssl.google-analytics.com/collect"
    :try_end_1
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpEntityEnclosingRequest;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 190
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 191
    const-string v0, "Empty hit, discarding."

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    move-object v0, v1

    .line 208
    :goto_0
    return-object v0

    .line 194
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 195
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v3, 0x7f4

    if-ge v0, v3, :cond_1

    .line 196
    new-instance v0, Lorg/apache/http/message/BasicHttpEntityEnclosingRequest;

    const-string v1, "GET"

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicHttpEntityEnclosingRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    :goto_1
    const-string v1, "User-Agent"

    iget-object v2, p0, Lcom/google/analytics/tracking/android/ax;->a:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lorg/apache/http/HttpEntityEnclosingRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 198
    :cond_1
    new-instance v0, Lorg/apache/http/message/BasicHttpEntityEnclosingRequest;

    const-string v2, "POST"

    invoke-direct {v0, v2, p2}, Lorg/apache/http/message/BasicHttpEntityEnclosingRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    :try_start_0
    new-instance v2, Lorg/apache/http/entity/StringEntity;

    invoke-direct {v2, p1}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v2}, Lorg/apache/http/HttpEntityEnclosingRequest;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 203
    :catch_0
    move-exception v0

    const-string v0, "Encoding error, discarding hit"

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    move-object v0, v1

    .line 204
    goto :goto_0
.end method

.method private static a(Lorg/apache/http/HttpEntityEnclosingRequest;)V
    .locals 6

    .prologue
    .line 217
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 218
    invoke-interface {p0}, Lorg/apache/http/HttpEntityEnclosingRequest;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v2

    array-length v3, v2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v3, :cond_0

    aget-object v4, v2, v0

    .line 219
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 218
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 221
    :cond_0
    invoke-interface {p0}, Lorg/apache/http/HttpEntityEnclosingRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v2, "\n"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 222
    invoke-interface {p0}, Lorg/apache/http/HttpEntityEnclosingRequest;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 224
    :try_start_0
    invoke-interface {p0}, Lorg/apache/http/HttpEntityEnclosingRequest;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    .line 225
    if-eqz v0, :cond_1

    .line 226
    invoke-virtual {v0}, Ljava/io/InputStream;->available()I

    move-result v2

    .line 227
    if-lez v2, :cond_1

    .line 228
    new-array v2, v2, [B

    .line 229
    invoke-virtual {v0, v2}, Ljava/io/InputStream;->read([B)I

    .line 230
    const-string v0, "POST:\n"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 231
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v2, "\n"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 238
    :cond_1
    :goto_1
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->c(Ljava/lang/String;)V

    .line 239
    return-void

    .line 235
    :catch_0
    move-exception v0

    const-string v0, "Error Writing hit to log..."

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->c(Ljava/lang/String;)V

    goto :goto_1
.end method


# virtual methods
.method public final a(Ljava/util/List;)I
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/google/analytics/tracking/android/al;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 99
    const/4 v4, 0x0

    .line 100
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->size()I

    move-result v2

    const/16 v3, 0x28

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v6

    .line 101
    const/4 v3, 0x1

    .line 102
    const/4 v2, 0x0

    move v5, v2

    :goto_0
    if-ge v5, v6, :cond_a

    .line 103
    move-object/from16 v0, p1

    invoke-interface {v0, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/analytics/tracking/android/al;

    .line 104
    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/google/analytics/tracking/android/ax;->a(Lcom/google/analytics/tracking/android/al;)Ljava/net/URL;

    move-result-object v7

    .line 106
    if-nez v7, :cond_1

    .line 107
    invoke-static {}, Lcom/google/analytics/tracking/android/an;->a()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 108
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "No destination: discarding hit: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, v2, Lcom/google/analytics/tracking/android/al;->a:Ljava/lang/String;

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    .line 112
    :goto_1
    add-int/lit8 v2, v4, 0x1

    .line 102
    :goto_2
    add-int/lit8 v4, v5, 0x1

    move v5, v4

    move v4, v2

    goto :goto_0

    .line 110
    :cond_0
    const-string v2, "No destination: discarding hit."

    invoke-static {v2}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    goto :goto_1

    .line 116
    :cond_1
    new-instance v8, Lorg/apache/http/HttpHost;

    invoke-virtual {v7}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7}, Ljava/net/URL;->getPort()I

    move-result v10

    invoke-virtual {v7}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v8, v9, v10, v11}, Lorg/apache/http/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    .line 118
    invoke-virtual {v7}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v7

    .line 126
    iget-object v9, v2, Lcom/google/analytics/tracking/android/al;->a:Ljava/lang/String;

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_2

    const-string v2, ""

    .line 129
    :goto_3
    move-object/from16 v0, p0

    invoke-direct {v0, v2, v7}, Lcom/google/analytics/tracking/android/ax;->a(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpEntityEnclosingRequest;

    move-result-object v7

    .line 130
    if-nez v7, :cond_4

    .line 131
    add-int/lit8 v2, v4, 0x1

    .line 132
    goto :goto_2

    .line 126
    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v12, v2, Lcom/google/analytics/tracking/android/al;->a:Ljava/lang/String;

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v12, v2, Lcom/google/analytics/tracking/android/al;->c:J

    const-wide/16 v14, 0x0

    cmp-long v12, v12, v14

    if-lez v12, :cond_3

    iget-wide v12, v2, Lcom/google/analytics/tracking/android/al;->c:J

    sub-long/2addr v10, v12

    const-wide/16 v12, 0x0

    cmp-long v12, v10, v12

    if-ltz v12, :cond_3

    const-string v12, "&qt="

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    :cond_3
    const-string v10, "&z="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-wide v12, v2, Lcom/google/analytics/tracking/android/al;->b:J

    invoke-virtual {v10, v12, v13}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_3

    .line 134
    :cond_4
    const-string v9, "Host"

    invoke-virtual {v8}, Lorg/apache/http/HttpHost;->toHostString()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v7, v9, v10}, Lorg/apache/http/HttpEntityEnclosingRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    invoke-static {}, Lcom/google/analytics/tracking/android/an;->a()Z

    move-result v9

    if-eqz v9, :cond_5

    .line 136
    invoke-static {v7}, Lcom/google/analytics/tracking/android/ax;->a(Lorg/apache/http/HttpEntityEnclosingRequest;)V

    .line 138
    :cond_5
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v9, 0x2000

    if-le v2, v9, :cond_7

    .line 139
    const-string v2, "Hit too long (> 8192 bytes)--not sent"

    invoke-static {v2}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    move v2, v3

    .line 169
    :cond_6
    :goto_4
    add-int/lit8 v3, v4, 0x1

    move/from16 v16, v2

    move v2, v3

    move/from16 v3, v16

    goto/16 :goto_2

    .line 141
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/analytics/tracking/android/ax;->d:Lcom/google/analytics/tracking/android/ak;

    invoke-virtual {v2}, Lcom/google/analytics/tracking/android/ak;->b()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 142
    const-string v2, "Dry run enabled. Hit not actually sent."

    invoke-static {v2}, Lcom/google/analytics/tracking/android/an;->b(Ljava/lang/String;)V

    move v2, v3

    goto :goto_4

    .line 145
    :cond_8
    if-eqz v3, :cond_b

    .line 146
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/analytics/tracking/android/ax;->c:Landroid/content/Context;

    invoke-static {v2}, Lcom/google/analytics/tracking/android/r;->a(Landroid/content/Context;)V
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 147
    const/4 v2, 0x0

    .line 149
    :goto_5
    :try_start_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/analytics/tracking/android/ax;->b:Lorg/apache/http/client/HttpClient;

    invoke-interface {v3, v8, v7}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v3

    .line 150
    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v7

    invoke-interface {v7}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    .line 151
    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v8

    .line 152
    if-eqz v8, :cond_9

    .line 153
    invoke-interface {v8}, Lorg/apache/http/HttpEntity;->consumeContent()V

    .line 155
    :cond_9
    const/16 v8, 0xc8

    if-eq v7, v8, :cond_6

    .line 157
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Bad response: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v3

    invoke-interface {v3}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v3

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_4

    .line 162
    :catch_0
    move-exception v3

    :goto_6
    const-string v3, "ClientProtocolException sending hit; discarding hit..."

    invoke-static {v3}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    goto :goto_4

    .line 163
    :catch_1
    move-exception v2

    .line 164
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "Exception sending hit: "

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    .line 165
    invoke-virtual {v2}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    move v2, v4

    .line 171
    :goto_7
    return v2

    :cond_a
    move v2, v4

    goto :goto_7

    .line 162
    :catch_2
    move-exception v2

    move v2, v3

    goto :goto_6

    :cond_b
    move v2, v3

    goto :goto_5
.end method

.method public final a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 282
    :try_start_0
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ax;->e:Ljava/net/URL;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 286
    :goto_0
    return-void

    .line 284
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ax;->e:Ljava/net/URL;

    goto :goto_0
.end method

.method public final a()Z
    .locals 2

    .prologue
    .line 83
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ax;->c:Landroid/content/Context;

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 85
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 90
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-nez v0, :cond_1

    .line 91
    :cond_0
    const-string v0, "...no network connectivity"

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->c(Ljava/lang/String;)V

    .line 92
    const/4 v0, 0x0

    .line 94
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method
