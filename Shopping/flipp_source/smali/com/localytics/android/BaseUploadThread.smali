.class abstract Lcom/localytics/android/BaseUploadThread;
.super Ljava/lang/Thread;
.source "SourceFile"


# instance fields
.field customerID:Ljava/lang/String;

.field final mData:Ljava/util/TreeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

.field private final mSessionHandler:Lcom/localytics/android/BaseHandler;

.field private uploadResponseString:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/localytics/android/BaseHandler;Ljava/util/TreeMap;Ljava/lang/String;Lcom/localytics/android/LocalyticsDao;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/localytics/android/BaseHandler;",
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/localytics/android/LocalyticsDao;",
            ")V"
        }
    .end annotation

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 39
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/localytics/android/BaseUploadThread;->uploadResponseString:Ljava/lang/String;

    .line 55
    iput-object p1, p0, Lcom/localytics/android/BaseUploadThread;->mSessionHandler:Lcom/localytics/android/BaseHandler;

    .line 56
    iput-object p2, p0, Lcom/localytics/android/BaseUploadThread;->mData:Ljava/util/TreeMap;

    .line 57
    iput-object p3, p0, Lcom/localytics/android/BaseUploadThread;->customerID:Ljava/lang/String;

    .line 58
    iput-object p4, p0, Lcom/localytics/android/BaseUploadThread;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    .line 59
    return-void
.end method

.method static createURLConnection(Ljava/net/URL;Ljava/net/Proxy;)Ljava/net/URLConnection;
    .locals 1

    .prologue
    .line 367
    if-nez p1, :cond_0

    .line 369
    invoke-virtual {p0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 373
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0, p1}, Ljava/net/URL;->openConnection(Ljava/net/Proxy;)Ljava/net/URLConnection;

    move-result-object v0

    goto :goto_0
.end method

.method private static formatUploadBody(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 93
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    .line 97
    :goto_0
    return-object p0

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private retrieveHttpResponse(Ljava/io/InputStream;)V
    .locals 3

    .prologue
    .line 329
    new-instance v0, Ljava/io/BufferedReader;

    new-instance v1, Ljava/io/InputStreamReader;

    const-string v2, "UTF-8"

    invoke-direct {v1, p1, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 330
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 333
    :goto_0
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 335
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 338
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 339
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 341
    invoke-virtual {p0, v1}, Lcom/localytics/android/BaseUploadThread;->onUploadResponded(Ljava/lang/String;)V

    .line 344
    :cond_1
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    .line 345
    return-void
.end method


# virtual methods
.method getApiKey()Ljava/lang/String;
    .locals 3

    .prologue
    .line 63
    iget-object v0, p0, Lcom/localytics/android/BaseUploadThread;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v1

    .line 64
    iget-object v0, p0, Lcom/localytics/android/BaseUploadThread;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/DatapointHelper;->getLocalyticsRollupKeyOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 65
    if-eqz v0, :cond_0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 70
    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method

.method onUploadResponded(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 354
    const-string v0, "%s upload response: \n%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/localytics/android/BaseUploadThread;->mSessionHandler:Lcom/localytics/android/BaseHandler;

    iget-object v3, v3, Lcom/localytics/android/BaseHandler;->siloName:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 355
    iput-object p1, p0, Lcom/localytics/android/BaseUploadThread;->uploadResponseString:Ljava/lang/String;

    .line 356
    return-void
.end method

.method public run()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v3, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 76
    :try_start_0
    invoke-virtual {p0}, Lcom/localytics/android/BaseUploadThread;->uploadData()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    .line 83
    iget-object v1, p0, Lcom/localytics/android/BaseUploadThread;->mSessionHandler:Lcom/localytics/android/BaseHandler;

    iget-object v2, p0, Lcom/localytics/android/BaseUploadThread;->mSessionHandler:Lcom/localytics/android/BaseHandler;

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v5

    iget-object v0, p0, Lcom/localytics/android/BaseUploadThread;->uploadResponseString:Ljava/lang/String;

    aput-object v0, v3, v6

    invoke-virtual {v2, v7, v3}, Lcom/localytics/android/BaseHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/localytics/android/BaseHandler;->sendMessage(Landroid/os/Message;)Z

    .line 84
    return-void

    .line 83
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/localytics/android/BaseUploadThread;->mSessionHandler:Lcom/localytics/android/BaseHandler;

    iget-object v2, p0, Lcom/localytics/android/BaseUploadThread;->mSessionHandler:Lcom/localytics/android/BaseHandler;

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/localytics/android/BaseUploadThread;->uploadResponseString:Ljava/lang/String;

    aput-object v4, v3, v6

    invoke-virtual {v2, v7, v3}, Lcom/localytics/android/BaseHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseHandler;->sendMessage(Landroid/os/Message;)Z

    throw v0
.end method

.method upload(Lcom/localytics/android/BaseUploadThread$UploadType;Ljava/lang/String;Ljava/lang/String;I)Z
    .locals 6

    .prologue
    .line 103
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseUploadThread;->upload(Lcom/localytics/android/BaseUploadThread$UploadType;Ljava/lang/String;Ljava/lang/String;IZ)Z

    move-result v0

    return v0
.end method

.method upload(Lcom/localytics/android/BaseUploadThread$UploadType;Ljava/lang/String;Ljava/lang/String;IZ)Z
    .locals 9

    .prologue
    .line 118
    if-nez p2, :cond_0

    .line 120
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "url cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 123
    :cond_0
    if-nez p3, :cond_1

    .line 125
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "body cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 128
    :cond_1
    sget-object v0, Lcom/localytics/android/BaseUploadThread$UploadType;->ANALYTICS:Lcom/localytics/android/BaseUploadThread$UploadType;

    if-ne p1, v0, :cond_a

    .line 130
    const-string v0, "Analytics upload body before compression is: \n%s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 140
    :cond_2
    :goto_0
    const/4 v2, 0x0

    .line 143
    :try_start_0
    const-string v0, "UTF-8"

    invoke-virtual {p3, v0}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    .line 144
    sget-object v1, Lcom/localytics/android/BaseUploadThread$UploadType;->ANALYTICS:Lcom/localytics/android/BaseUploadThread$UploadType;

    if-ne p1, v1, :cond_1c

    .line 152
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    array-length v1, v0

    invoke-direct {v3, v1}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    .line 153
    new-instance v1, Ljava/util/zip/GZIPOutputStream;

    invoke-direct {v1, v3}, Ljava/util/zip/GZIPOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 154
    :try_start_1
    invoke-virtual {v1, v0}, Ljava/util/zip/GZIPOutputStream;->write([B)V

    .line 155
    invoke-virtual {v1}, Ljava/util/zip/GZIPOutputStream;->finish()V

    .line 161
    invoke-static {}, Lcom/localytics/android/DatapointHelper;->getApiLevel()I

    move-result v0

    const/16 v2, 0x13

    if-ge v0, v2, :cond_3

    .line 163
    invoke-virtual {v1}, Ljava/util/zip/GZIPOutputStream;->flush()V

    .line 166
    :cond_3
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_d
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_c
    .catchall {:try_start_1 .. :try_end_1} :catchall_5

    move-result-object v0

    move-object v3, v0

    .line 167
    :goto_1
    if-eqz v1, :cond_4

    .line 189
    :try_start_2
    invoke-virtual {v1}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 201
    :cond_4
    const/4 v1, 0x0

    .line 204
    :try_start_3
    iget-object v0, p0, Lcom/localytics/android/BaseUploadThread;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getProxy()Ljava/net/Proxy;

    move-result-object v0

    .line 205
    new-instance v2, Ljava/net/URL;

    invoke-direct {v2, p2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-static {v2, v0}, Lcom/localytics/android/BaseUploadThread;->createURLConnection(Ljava/net/URL;Ljava/net/Proxy;)Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;
    :try_end_3
    .catch Ljava/io/EOFException; {:try_start_3 .. :try_end_3} :catch_b
    .catch Ljava/net/MalformedURLException; {:try_start_3 .. :try_end_3} :catch_a
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_8
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 207
    const v1, 0xea60

    :try_start_4
    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 208
    const v1, 0xea60

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 209
    sget-object v1, Lcom/localytics/android/BaseUploadThread$UploadType;->MARKETING:Lcom/localytics/android/BaseUploadThread$UploadType;

    if-eq p1, v1, :cond_e

    const/4 v1, 0x1

    :goto_2
    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 210
    sget-object v1, Lcom/localytics/android/BaseUploadThread$UploadType;->ANALYTICS:Lcom/localytics/android/BaseUploadThread$UploadType;

    if-ne p1, v1, :cond_f

    .line 212
    const-string v1, "Content-Type"

    const-string v2, "application/x-gzip"

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    const-string v1, "Content-Encoding"

    const-string v2, "gzip"

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    const-string v1, "X-DONT-SEND-AMP"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    :goto_3
    sget-object v1, Lcom/localytics/android/BaseUploadThread$UploadType;->MARKETING:Lcom/localytics/android/BaseUploadThread$UploadType;

    if-ne p1, v1, :cond_5

    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 222
    const-string v1, "AMP-Test-Mode"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    :cond_5
    if-eqz p5, :cond_6

    .line 226
    const-string v1, "X-NO-DELAY"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    :cond_6
    const-string v1, "Accept-Encoding"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    const-string v1, "x-upload-time"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    long-to-double v4, v4

    const-wide v6, 0x408f400000000000L    # 1000.0

    div-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->round(D)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 234
    const-string v1, "x-install-id"

    iget-object v2, p0, Lcom/localytics/android/BaseUploadThread;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getInstallationId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    const-string v1, "x-app-id"

    iget-object v2, p0, Lcom/localytics/android/BaseUploadThread;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 236
    const-string v1, "x-client-version"

    const-string v2, "androida_3.4.0"

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 237
    const-string v1, "x-app-version"

    iget-object v2, p0, Lcom/localytics/android/BaseUploadThread;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/localytics/android/DatapointHelper;->getAppVersion(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    const-string v1, "x-customer-id"

    iget-object v2, p0, Lcom/localytics/android/BaseUploadThread;->customerID:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 240
    sget-object v1, Lcom/localytics/android/BaseUploadThread$UploadType;->MARKETING:Lcom/localytics/android/BaseUploadThread$UploadType;

    if-eq p1, v1, :cond_7

    .line 242
    array-length v1, v3

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V
    :try_end_4
    .catch Ljava/io/EOFException; {:try_start_4 .. :try_end_4} :catch_6
    .catch Ljava/net/MalformedURLException; {:try_start_4 .. :try_end_4} :catch_7
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_9
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    .line 243
    const/4 v2, 0x0

    .line 246
    :try_start_5
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v2

    .line 247
    invoke-virtual {v2, v3}, Ljava/io/OutputStream;->write([B)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 251
    if-eqz v2, :cond_7

    .line 253
    :try_start_6
    invoke-virtual {v2}, Ljava/io/OutputStream;->flush()V

    .line 254
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V

    .line 260
    :cond_7
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    .line 262
    const-string v2, "%s upload complete with status %d"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/localytics/android/BaseUploadThread;->mSessionHandler:Lcom/localytics/android/BaseHandler;

    iget-object v5, v5, Lcom/localytics/android/BaseHandler;->siloName:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I
    :try_end_6
    .catch Ljava/io/EOFException; {:try_start_6 .. :try_end_6} :catch_6
    .catch Ljava/net/MalformedURLException; {:try_start_6 .. :try_end_6} :catch_7
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_9
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    .line 264
    const/16 v2, 0x1ad

    if-ne v1, v2, :cond_13

    .line 266
    if-eqz v0, :cond_8

    .line 314
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 315
    :cond_8
    const/4 v0, 0x0

    .line 319
    :cond_9
    :goto_4
    return v0

    .line 132
    :cond_a
    sget-object v0, Lcom/localytics/android/BaseUploadThread$UploadType;->PROFILES:Lcom/localytics/android/BaseUploadThread$UploadType;

    if-ne p1, v0, :cond_2

    .line 134
    const-string v0, "Profile upload body is: \n%s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p3}, Lcom/localytics/android/BaseUploadThread;->formatUploadBody(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    goto/16 :goto_0

    .line 192
    :catch_0
    move-exception v0

    .line 194
    const-string v1, "Caught exception"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 195
    const/4 v0, 0x0

    goto :goto_4

    .line 173
    :catch_1
    move-exception v0

    move-object v1, v2

    .line 175
    :goto_5
    :try_start_7
    const-string v2, "UnsupportedEncodingException"

    invoke-static {v2, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_5

    .line 176
    if-eqz v1, :cond_b

    .line 189
    :try_start_8
    invoke-virtual {v1}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_2

    .line 195
    :cond_b
    const/4 v0, 0x0

    goto :goto_4

    .line 192
    :catch_2
    move-exception v0

    .line 194
    const-string v1, "Caught exception"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 195
    const/4 v0, 0x0

    goto :goto_4

    .line 178
    :catch_3
    move-exception v0

    .line 180
    :goto_6
    :try_start_9
    const-string v1, "IOException"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 181
    if-eqz v2, :cond_c

    .line 189
    :try_start_a
    invoke-virtual {v2}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_4

    .line 195
    :cond_c
    const/4 v0, 0x0

    goto :goto_4

    .line 192
    :catch_4
    move-exception v0

    .line 194
    const-string v1, "Caught exception"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 195
    const/4 v0, 0x0

    goto :goto_4

    .line 185
    :catchall_0
    move-exception v0

    :goto_7
    if-eqz v2, :cond_d

    .line 189
    :try_start_b
    invoke-virtual {v2}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_5

    .line 195
    :cond_d
    throw v0

    .line 192
    :catch_5
    move-exception v0

    .line 194
    const-string v1, "Caught exception"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 195
    const/4 v0, 0x0

    goto :goto_4

    .line 209
    :cond_e
    const/4 v1, 0x0

    goto/16 :goto_2

    .line 218
    :cond_f
    :try_start_c
    const-string v1, "Content-Type"

    const-string v2, "application/json; charset=utf-8"

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_c
    .catch Ljava/io/EOFException; {:try_start_c .. :try_end_c} :catch_6
    .catch Ljava/net/MalformedURLException; {:try_start_c .. :try_end_c} :catch_7
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_9
    .catchall {:try_start_c .. :try_end_c} :catchall_3

    goto/16 :goto_3

    .line 288
    :catch_6
    move-exception v1

    move-object v6, v0

    move-object v0, v1

    .line 290
    :goto_8
    const/4 v1, 0x2

    if-ne p4, v1, :cond_19

    .line 292
    :try_start_d
    const-string v1, "ClientProtocolException"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_4

    .line 293
    if-eqz v6, :cond_10

    .line 314
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 315
    :cond_10
    const/4 v0, 0x0

    goto :goto_4

    .line 251
    :catchall_1
    move-exception v1

    if-eqz v2, :cond_11

    .line 253
    :try_start_e
    invoke-virtual {v2}, Ljava/io/OutputStream;->flush()V

    .line 254
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V

    .line 255
    :cond_11
    throw v1
    :try_end_e
    .catch Ljava/io/EOFException; {:try_start_e .. :try_end_e} :catch_6
    .catch Ljava/net/MalformedURLException; {:try_start_e .. :try_end_e} :catch_7
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_9
    .catchall {:try_start_e .. :try_end_e} :catchall_3

    .line 300
    :catch_7
    move-exception v1

    move-object v8, v1

    move-object v1, v0

    move-object v0, v8

    .line 302
    :goto_9
    :try_start_f
    const-string v2, "ClientProtocolException"

    invoke-static {v2, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_2

    .line 303
    if-eqz v1, :cond_12

    .line 314
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 315
    :cond_12
    const/4 v0, 0x0

    goto/16 :goto_4

    .line 271
    :cond_13
    const/16 v2, 0x190

    if-lt v1, v2, :cond_15

    const/16 v2, 0x1f3

    if-gt v1, v2, :cond_15

    .line 273
    if-eqz v0, :cond_14

    .line 314
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 315
    :cond_14
    const/4 v0, 0x1

    goto/16 :goto_4

    .line 278
    :cond_15
    const/16 v2, 0x1f4

    if-lt v1, v2, :cond_17

    const/16 v2, 0x257

    if-gt v1, v2, :cond_17

    .line 280
    if-eqz v0, :cond_16

    .line 314
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 315
    :cond_16
    const/4 v0, 0x0

    goto/16 :goto_4

    .line 286
    :cond_17
    :try_start_10
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/localytics/android/BaseUploadThread;->retrieveHttpResponse(Ljava/io/InputStream;)V
    :try_end_10
    .catch Ljava/io/EOFException; {:try_start_10 .. :try_end_10} :catch_6
    .catch Ljava/net/MalformedURLException; {:try_start_10 .. :try_end_10} :catch_7
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_10} :catch_9
    .catchall {:try_start_10 .. :try_end_10} :catchall_3

    .line 312
    if-eqz v0, :cond_18

    .line 314
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 319
    :cond_18
    const/4 v0, 0x1

    goto/16 :goto_4

    .line 297
    :cond_19
    add-int/lit8 v4, p4, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v5, p5

    :try_start_11
    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseUploadThread;->upload(Lcom/localytics/android/BaseUploadThread$UploadType;Ljava/lang/String;Ljava/lang/String;IZ)Z
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_4

    move-result v0

    .line 312
    if-eqz v6, :cond_9

    .line 314
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_4

    .line 305
    :catch_8
    move-exception v0

    .line 307
    :goto_a
    :try_start_12
    const-string v2, "ClientProtocolException"

    invoke-static {v2, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_2

    .line 308
    if-eqz v1, :cond_1a

    .line 314
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 315
    :cond_1a
    const/4 v0, 0x0

    goto/16 :goto_4

    .line 312
    :catchall_2
    move-exception v0

    :goto_b
    if-eqz v1, :cond_1b

    .line 314
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 315
    :cond_1b
    throw v0

    .line 312
    :catchall_3
    move-exception v1

    move-object v8, v1

    move-object v1, v0

    move-object v0, v8

    goto :goto_b

    :catchall_4
    move-exception v0

    move-object v1, v6

    goto :goto_b

    .line 305
    :catch_9
    move-exception v1

    move-object v8, v1

    move-object v1, v0

    move-object v0, v8

    goto :goto_a

    .line 300
    :catch_a
    move-exception v0

    goto :goto_9

    .line 288
    :catch_b
    move-exception v0

    move-object v6, v1

    goto/16 :goto_8

    .line 185
    :catchall_5
    move-exception v0

    move-object v2, v1

    goto/16 :goto_7

    .line 178
    :catch_c
    move-exception v0

    move-object v2, v1

    goto/16 :goto_6

    .line 173
    :catch_d
    move-exception v0

    goto/16 :goto_5

    :cond_1c
    move-object v1, v2

    move-object v3, v0

    goto/16 :goto_1
.end method

.method abstract uploadData()I
.end method
