.class public Lcom/livemixtapes/library/JSONParser;
.super Ljava/lang/Object;
.source "JSONParser.java"


# static fields
.field static is:Ljava/io/InputStream;

.field static jObj:Lorg/json/JSONObject;

.field static json:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 48
    sput-object v0, Lcom/livemixtapes/library/JSONParser;->is:Ljava/io/InputStream;

    .line 49
    sput-object v0, Lcom/livemixtapes/library/JSONParser;->jObj:Lorg/json/JSONObject;

    .line 50
    const-string v0, ""

    sput-object v0, Lcom/livemixtapes/library/JSONParser;->json:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    return-void
.end method

.method public static generateString(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 7
    .param p0, "stream"    # Ljava/io/InputStream;

    .prologue
    .line 291
    new-instance v3, Ljava/io/InputStreamReader;

    invoke-direct {v3, p0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 292
    .local v3, "reader":Ljava/io/InputStreamReader;
    new-instance v0, Ljava/io/BufferedReader;

    invoke-direct {v0, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 293
    .local v0, "buffer":Ljava/io/BufferedReader;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 297
    .local v4, "sb":Ljava/lang/StringBuilder;
    :goto_0
    :try_start_0
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .local v1, "cur":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 305
    .end local v1    # "cur":Ljava/lang/String;
    :goto_1
    :try_start_1
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 309
    :goto_2
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5

    .line 298
    .restart local v1    # "cur":Ljava/lang/String;
    :cond_0
    :try_start_2
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "\n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 300
    .end local v1    # "cur":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 301
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 306
    .end local v2    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    .line 307
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_2
.end method


# virtual methods
.method public getJSONFromUrl(Ljava/lang/String;Landroid/app/Activity;)Lorg/json/JSONObject;
    .locals 12
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/app/Activity;

    .prologue
    const/4 v8, 0x0

    .line 62
    :try_start_0
    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 63
    .local v1, "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    new-instance v3, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v3, p1}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 64
    .local v3, "httpGet":Lorg/apache/http/client/methods/HttpGet;
    const-string v9, "X-Api-Key"

    const-string v10, "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh"

    invoke-virtual {v3, v9, v10}, Lorg/apache/http/client/methods/HttpGet;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    const-string v9, "User-Agent"

    const-string v10, "LiveMixtapes Android/1.0.84 BETA"

    invoke-virtual {v3, v9, v10}, Lorg/apache/http/client/methods/HttpGet;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    invoke-virtual {v1, v3}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v4

    .line 68
    .local v4, "httpResponse":Lorg/apache/http/HttpResponse;
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v2

    .line 69
    .local v2, "httpEntity":Lorg/apache/http/HttpEntity;
    invoke-interface {v2}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v9

    sput-object v9, Lcom/livemixtapes/library/JSONParser;->is:Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 77
    :try_start_1
    new-instance v6, Ljava/io/BufferedReader;

    new-instance v9, Ljava/io/InputStreamReader;

    .line 78
    sget-object v10, Lcom/livemixtapes/library/JSONParser;->is:Ljava/io/InputStream;

    const-string v11, "iso-8859-1"

    invoke-direct {v9, v10, v11}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    const/16 v10, 0x8

    .line 77
    invoke-direct {v6, v9, v10}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    .line 79
    .local v6, "reader":Ljava/io/BufferedReader;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 80
    .local v7, "sb":Ljava/lang/StringBuilder;
    const/4 v5, 0x0

    .line 81
    .local v5, "line":Ljava/lang/String;
    :goto_0
    invoke-virtual {v6}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_1

    .line 84
    sget-object v9, Lcom/livemixtapes/library/JSONParser;->is:Ljava/io/InputStream;

    invoke-virtual {v9}, Ljava/io/InputStream;->close()V

    .line 85
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    sput-object v9, Lcom/livemixtapes/library/JSONParser;->json:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 92
    sget-object v9, Lcom/livemixtapes/library/JSONParser;->json:Ljava/lang/String;

    const-string v10, "BETA_DISABLED"

    invoke-virtual {v9, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_0

    const-string v9, "generic"

    sget-object v10, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual {v10}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 97
    new-instance v9, Lcom/livemixtapes/library/JSONParser$1;

    invoke-direct {v9, p0, p2}, Lcom/livemixtapes/library/JSONParser$1;-><init>(Lcom/livemixtapes/library/JSONParser;Landroid/app/Activity;)V

    invoke-virtual {p2, v9}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 148
    :cond_0
    :try_start_2
    new-instance v9, Lorg/json/JSONObject;

    sget-object v10, Lcom/livemixtapes/library/JSONParser;->json:Ljava/lang/String;

    invoke-direct {v9, v10}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    sput-object v9, Lcom/livemixtapes/library/JSONParser;->jObj:Lorg/json/JSONObject;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 155
    sget-object v8, Lcom/livemixtapes/library/JSONParser;->jObj:Lorg/json/JSONObject;

    .end local v1    # "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    .end local v2    # "httpEntity":Lorg/apache/http/HttpEntity;
    .end local v3    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v4    # "httpResponse":Lorg/apache/http/HttpResponse;
    .end local v5    # "line":Ljava/lang/String;
    .end local v6    # "reader":Ljava/io/BufferedReader;
    .end local v7    # "sb":Ljava/lang/StringBuilder;
    :goto_1
    return-object v8

    .line 71
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 82
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    .restart local v2    # "httpEntity":Lorg/apache/http/HttpEntity;
    .restart local v3    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v4    # "httpResponse":Lorg/apache/http/HttpResponse;
    .restart local v5    # "line":Ljava/lang/String;
    .restart local v6    # "reader":Ljava/io/BufferedReader;
    .restart local v7    # "sb":Ljava/lang/StringBuilder;
    :cond_1
    :try_start_3
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "\n"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 86
    .end local v5    # "line":Ljava/lang/String;
    .end local v6    # "reader":Ljava/io/BufferedReader;
    .end local v7    # "sb":Ljava/lang/StringBuilder;
    :catch_1
    move-exception v0

    .line 87
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v9, "Buffer Error"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Error converting result "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 149
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v5    # "line":Ljava/lang/String;
    .restart local v6    # "reader":Ljava/io/BufferedReader;
    .restart local v7    # "sb":Ljava/lang/StringBuilder;
    :catch_2
    move-exception v0

    .line 150
    .local v0, "e":Lorg/json/JSONException;
    const-string v9, "JSON Parser"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Error parsing data "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method public getUrlResponse(Ljava/lang/String;)Ljava/lang/String;
    .locals 21
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 168
    :try_start_0
    sget-object v17, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual/range {v17 .. v17}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    const v18, 0x7f070001

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v10

    .line 169
    .local v10, "in":Ljava/io/InputStream;
    const-string v13, "api42829"
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    .line 170
    .local v13, "password":Ljava/lang/String;
    const/4 v4, 0x0

    .line 172
    .local v4, "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    :try_start_1
    const-string v17, "BKS"

    invoke-static/range {v17 .. v17}, Ljava/security/KeyStore;->getInstance(Ljava/lang/String;)Ljava/security/KeyStore;

    move-result-object v11

    .line 173
    .local v11, "keyStore":Ljava/security/KeyStore;
    invoke-virtual {v13}, Ljava/lang/String;->toCharArray()[C

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v11, v10, v0}, Ljava/security/KeyStore;->load(Ljava/io/InputStream;[C)V

    .line 175
    new-instance v8, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v8}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 177
    .local v8, "httpParams":Lorg/apache/http/params/HttpParams;
    new-instance v16, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct/range {v16 .. v16}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 179
    .local v16, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v17, Lorg/apache/http/conn/scheme/Scheme;

    const-string v18, "https"

    new-instance v19, Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-object/from16 v0, v19

    invoke-direct {v0, v11}, Lorg/apache/http/conn/ssl/SSLSocketFactory;-><init>(Ljava/security/KeyStore;)V

    const/16 v20, 0x1bb

    invoke-direct/range {v17 .. v20}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual/range {v16 .. v17}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 181
    new-instance v2, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    move-object/from16 v0, v16

    invoke-direct {v2, v8, v0}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 186
    .local v2, "clientMan":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    new-instance v5, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v5, v2, v8}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .end local v4    # "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    .local v5, "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    move-object v4, v5

    .line 195
    .end local v2    # "clientMan":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    .end local v5    # "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    .end local v8    # "httpParams":Lorg/apache/http/params/HttpParams;
    .end local v11    # "keyStore":Ljava/security/KeyStore;
    .end local v16    # "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    .restart local v4    # "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    :goto_0
    :try_start_2
    new-instance v7, Lorg/apache/http/client/methods/HttpGet;

    move-object/from16 v0, p1

    invoke-direct {v7, v0}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 196
    .local v7, "httpGet":Lorg/apache/http/client/methods/HttpGet;
    const-string v17, "X-Api-Key"

    const-string v18, "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh"

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v7, v0, v1}, Lorg/apache/http/client/methods/HttpGet;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    const-string v17, "User-Agent"

    const-string v18, "LiveMixtapes Android/1.0.84 BETA"

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v7, v0, v1}, Lorg/apache/http/client/methods/HttpGet;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 198
    invoke-virtual {v4, v7}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v9

    .line 199
    .local v9, "httpResponse":Lorg/apache/http/HttpResponse;
    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v6

    .line 200
    .local v6, "httpEntity":Lorg/apache/http/HttpEntity;
    invoke-interface {v6}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v17

    sput-object v17, Lcom/livemixtapes/library/JSONParser;->is:Ljava/io/InputStream;
    :try_end_2
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    .line 211
    .end local v4    # "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    .end local v6    # "httpEntity":Lorg/apache/http/HttpEntity;
    .end local v7    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v9    # "httpResponse":Lorg/apache/http/HttpResponse;
    .end local v10    # "in":Ljava/io/InputStream;
    .end local v13    # "password":Ljava/lang/String;
    :goto_1
    :try_start_3
    new-instance v14, Ljava/io/BufferedReader;

    new-instance v17, Ljava/io/InputStreamReader;

    .line 212
    sget-object v18, Lcom/livemixtapes/library/JSONParser;->is:Ljava/io/InputStream;

    const-string v19, "iso-8859-1"

    invoke-direct/range {v17 .. v19}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    const/16 v18, 0x8

    .line 211
    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-direct {v14, v0, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    .line 213
    .local v14, "reader":Ljava/io/BufferedReader;
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    .line 214
    .local v15, "sb":Ljava/lang/StringBuilder;
    const/4 v12, 0x0

    .line 215
    .local v12, "line":Ljava/lang/String;
    :goto_2
    invoke-virtual {v14}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v12

    if-nez v12, :cond_0

    .line 218
    sget-object v17, Lcom/livemixtapes/library/JSONParser;->is:Ljava/io/InputStream;

    invoke-virtual/range {v17 .. v17}, Ljava/io/InputStream;->close()V

    .line 219
    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    sput-object v17, Lcom/livemixtapes/library/JSONParser;->json:Ljava/lang/String;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 224
    .end local v12    # "line":Ljava/lang/String;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "sb":Ljava/lang/StringBuilder;
    :goto_3
    sget-object v17, Lcom/livemixtapes/library/JSONParser;->json:Ljava/lang/String;

    return-object v17

    .line 202
    :catch_0
    move-exception v3

    .line 203
    .local v3, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {v3}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_1

    .line 204
    .end local v3    # "e":Ljava/io/UnsupportedEncodingException;
    :catch_1
    move-exception v3

    .line 205
    .local v3, "e":Lorg/apache/http/client/ClientProtocolException;
    invoke-virtual {v3}, Lorg/apache/http/client/ClientProtocolException;->printStackTrace()V

    goto :goto_1

    .line 206
    .end local v3    # "e":Lorg/apache/http/client/ClientProtocolException;
    :catch_2
    move-exception v3

    .line 207
    .local v3, "e":Ljava/io/IOException;
    invoke-virtual {v3}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 216
    .end local v3    # "e":Ljava/io/IOException;
    .restart local v12    # "line":Ljava/lang/String;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v15    # "sb":Ljava/lang/StringBuilder;
    :cond_0
    :try_start_4
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "\n"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    goto :goto_2

    .line 220
    .end local v12    # "line":Ljava/lang/String;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "sb":Ljava/lang/StringBuilder;
    :catch_3
    move-exception v3

    .line 221
    .local v3, "e":Ljava/lang/Exception;
    const-string v17, "Buffer Error"

    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "Error converting result "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3

    .line 189
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v4    # "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    .restart local v10    # "in":Ljava/io/InputStream;
    .restart local v13    # "password":Ljava/lang/String;
    :catch_4
    move-exception v17

    goto/16 :goto_0
.end method

.method public isSuccessfulRequest(Lorg/json/JSONObject;)Z
    .locals 4
    .param p1, "obj"    # Lorg/json/JSONObject;

    .prologue
    const/4 v2, 0x0

    .line 279
    if-nez p1, :cond_1

    .line 285
    :cond_0
    :goto_0
    return v2

    .line 282
    :cond_1
    :try_start_0
    const-string v3, "status"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 283
    .local v1, "statusCode":I
    const/16 v3, 0xc8

    if-ne v1, v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    .line 284
    .end local v1    # "statusCode":I
    :catch_0
    move-exception v0

    .line 285
    .local v0, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method public postData(Ljava/lang/String;Ljava/util/List;)Lorg/json/JSONObject;
    .locals 18
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;)",
            "Lorg/json/JSONObject;"
        }
    .end annotation

    .prologue
    .line 233
    .local p2, "nameValuePairs":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    sget-object v14, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v14}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    const v15, 0x7f070001

    invoke-virtual {v14, v15}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v7

    .line 234
    .local v7, "in":Ljava/io/InputStream;
    const-string v9, "api42829"

    .line 235
    .local v9, "password":Ljava/lang/String;
    const/4 v4, 0x0

    .line 237
    .local v4, "httpclient":Lorg/apache/http/impl/client/DefaultHttpClient;
    :try_start_0
    const-string v14, "BKS"

    invoke-static {v14}, Ljava/security/KeyStore;->getInstance(Ljava/lang/String;)Ljava/security/KeyStore;

    move-result-object v8

    .line 238
    .local v8, "keyStore":Ljava/security/KeyStore;
    invoke-virtual {v9}, Ljava/lang/String;->toCharArray()[C

    move-result-object v14

    invoke-virtual {v8, v7, v14}, Ljava/security/KeyStore;->load(Ljava/io/InputStream;[C)V

    .line 240
    new-instance v3, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v3}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 242
    .local v3, "httpParams":Lorg/apache/http/params/HttpParams;
    new-instance v11, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v11}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 244
    .local v11, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v14, Lorg/apache/http/conn/scheme/Scheme;

    const-string v15, "https"

    new-instance v16, Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-object/from16 v0, v16

    invoke-direct {v0, v8}, Lorg/apache/http/conn/ssl/SSLSocketFactory;-><init>(Ljava/security/KeyStore;)V

    const/16 v17, 0x1bb

    invoke-direct/range {v14 .. v17}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v11, v14}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 246
    new-instance v1, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v1, v3, v11}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 251
    .local v1, "clientMan":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    new-instance v5, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v5, v1, v3}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .end local v4    # "httpclient":Lorg/apache/http/impl/client/DefaultHttpClient;
    .local v5, "httpclient":Lorg/apache/http/impl/client/DefaultHttpClient;
    move-object v4, v5

    .line 260
    .end local v1    # "clientMan":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    .end local v3    # "httpParams":Lorg/apache/http/params/HttpParams;
    .end local v5    # "httpclient":Lorg/apache/http/impl/client/DefaultHttpClient;
    .end local v8    # "keyStore":Ljava/security/KeyStore;
    .end local v11    # "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    .restart local v4    # "httpclient":Lorg/apache/http/impl/client/DefaultHttpClient;
    :goto_0
    new-instance v6, Lorg/apache/http/client/methods/HttpPost;

    move-object/from16 v0, p1

    invoke-direct {v6, v0}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 262
    .local v6, "httppost":Lorg/apache/http/client/methods/HttpPost;
    :try_start_1
    new-instance v14, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string v15, "UTF-8"

    move-object/from16 v0, p2

    invoke-direct {v14, v0, v15}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    invoke-virtual {v6, v14}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 263
    const-string v14, "X-Api-Key"

    const-string v15, "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh"

    invoke-virtual {v6, v14, v15}, Lorg/apache/http/client/methods/HttpPost;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    const-string v14, "User-Agent"

    const-string v15, "LiveMixtapes Android/1.0.84 BETA"

    invoke-virtual {v6, v14, v15}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    invoke-virtual {v4, v6}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v10

    .line 266
    .local v10, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v14

    invoke-interface {v14}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v13

    .line 269
    .local v13, "stream":Ljava/io/InputStream;
    invoke-static {v13}, Lcom/livemixtapes/library/JSONParser;->generateString(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v12

    .line 272
    .local v12, "str":Ljava/lang/String;
    new-instance v14, Lorg/json/JSONObject;

    invoke-direct {v14, v12}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 274
    .end local v10    # "response":Lorg/apache/http/HttpResponse;
    .end local v12    # "str":Ljava/lang/String;
    .end local v13    # "stream":Ljava/io/InputStream;
    :goto_1
    return-object v14

    .line 273
    :catch_0
    move-exception v2

    .line 274
    .local v2, "e":Ljava/lang/Exception;
    const/4 v14, 0x0

    goto :goto_1

    .line 254
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v6    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    :catch_1
    move-exception v14

    goto :goto_0
.end method
