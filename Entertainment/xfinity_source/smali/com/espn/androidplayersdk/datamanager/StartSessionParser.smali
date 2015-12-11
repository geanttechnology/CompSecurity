.class Lcom/espn/androidplayersdk/datamanager/StartSessionParser;
.super Ljava/lang/Object;
.source "StartSessionParser.java"


# instance fields
.field final domain:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    const-string v0, "go.com"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/StartSessionParser;->domain:Ljava/lang/String;

    .line 32
    return-void
.end method


# virtual methods
.method generateErrorObject(Lorg/json/JSONObject;)Lcom/espn/androidplayersdk/objects/EPAuthError;
    .locals 8
    .param p1, "object"    # Lorg/json/JSONObject;

    .prologue
    .line 117
    const/4 v0, 0x0

    .line 118
    .local v0, "error":Lcom/espn/androidplayersdk/objects/EPAuthError;
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 120
    .local v7, "values":Landroid/content/ContentValues;
    :try_start_0
    const-string v1, "status"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    const-string v1, "status"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_5

    const-string v1, "status"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "error"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 121
    const-string v1, "timestamp"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "timestamp"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 122
    const-string v1, "timestamp"

    const-string v2, "timestamp"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    :cond_0
    const-string v1, "message"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v1, "message"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 125
    const-string v1, "message"

    const-string v2, "message"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    :cond_1
    const-string v1, "abbreviation"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "abbreviation"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 128
    const-string v1, "abbreviation"

    const-string v2, "abbreviation"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    :cond_2
    const-string v1, "type"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string v1, "type"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 131
    const-string v1, "type"

    const-string v2, "type"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    :cond_3
    const-string v1, "code"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    const-string v1, "code"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 134
    const-string v1, "code"

    const-string v2, "code"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 136
    :cond_4
    new-instance v0, Lcom/espn/androidplayersdk/objects/EPAuthError;

    .end local v0    # "error":Lcom/espn/androidplayersdk/objects/EPAuthError;
    const-string v1, "timestamp"

    invoke-virtual {v7, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "message"

    invoke-virtual {v7, v2}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "abbreviation"

    invoke-virtual {v7, v3}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 137
    const-string v4, "type"

    invoke-virtual {v7, v4}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "code"

    invoke-virtual {v7, v5}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    .line 136
    invoke-direct/range {v0 .. v5}, Lcom/espn/androidplayersdk/objects/EPAuthError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 144
    .restart local v0    # "error":Lcom/espn/androidplayersdk/objects/EPAuthError;
    :cond_5
    :goto_0
    return-object v0

    .line 140
    .end local v0    # "error":Lcom/espn/androidplayersdk/objects/EPAuthError;
    :catch_0
    move-exception v6

    .line 141
    .local v6, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "StartSessionParser:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_6

    invoke-virtual {v6}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_1
    const/4 v2, 0x5

    invoke-static {v1, v2, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 142
    const/4 v0, 0x0

    .restart local v0    # "error":Lcom/espn/androidplayersdk/objects/EPAuthError;
    goto :goto_0

    .line 141
    .end local v0    # "error":Lcom/espn/androidplayersdk/objects/EPAuthError;
    :cond_6
    const-string v1, ""

    goto :goto_1
.end method

.method getFWToken(Lcom/espn/androidplayersdk/datamanager/EPStream;)Lcom/espn/androidplayersdk/datamanager/EPStream;
    .locals 4
    .param p1, "stream"    # Lcom/espn/androidplayersdk/datamanager/EPStream;

    .prologue
    .line 148
    const-string v1, "0"

    .line 150
    .local v1, "randNum":Ljava/lang/String;
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->isAdInsertionEnabled()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 151
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getfwSyncTokenUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 153
    :try_start_0
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getfwSyncTokenUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/espn/androidplayersdk/datamanager/StartSessionParser;->getRequest(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "UTF-8"

    invoke-static {v2, v3}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 159
    :cond_0
    :goto_0
    const-string v2, "0"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 160
    new-instance v2, Ljava/util/Random;

    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    invoke-virtual {v2}, Ljava/util/Random;->nextFloat()F

    move-result v2

    const v3, 0x4b189680    # 1.0E7f

    mul-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    .line 161
    :cond_1
    iget-object v2, p1, Lcom/espn/androidplayersdk/datamanager/EPStream;->playbackUrl:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&_fw_syncing_token="

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p1, Lcom/espn/androidplayersdk/datamanager/EPStream;->playbackUrl:Ljava/lang/String;

    .line 164
    :cond_2
    return-object p1

    .line 154
    :catch_0
    move-exception v0

    .line 155
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    const-string v2, "Sync token URL Encoding failed"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 156
    const-string v1, "0"

    goto :goto_0
.end method

.method getRequest(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p1, "pUrl"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x5

    .line 168
    const/4 v2, 0x0

    .line 170
    .local v2, "is":Ljava/io/InputStream;
    :try_start_0
    new-instance v6, Ljava/net/URL;

    invoke-direct {v6, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 171
    .local v6, "url":Ljava/net/URL;
    invoke-virtual {v6}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 172
    .local v0, "conn":Ljava/net/URLConnection;
    invoke-virtual {v0}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    .line 173
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v7, Ljava/io/InputStreamReader;

    invoke-direct {v7, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v4, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 174
    .local v4, "reader":Ljava/io/BufferedReader;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 175
    .local v5, "sb":Ljava/lang/StringBuilder;
    const/4 v3, 0x0

    .line 176
    .local v3, "line":Ljava/lang/String;
    :goto_0
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_1

    .line 179
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v7

    .line 183
    if-eqz v2, :cond_0

    .line 185
    :try_start_1
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 190
    .end local v0    # "conn":Ljava/net/URLConnection;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    .end local v6    # "url":Ljava/net/URL;
    :cond_0
    :goto_1
    return-object v7

    .line 177
    .restart local v0    # "conn":Ljava/net/URLConnection;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v5    # "sb":Ljava/lang/StringBuilder;
    .restart local v6    # "url":Ljava/net/URL;
    :cond_1
    :try_start_2
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 180
    .end local v0    # "conn":Ljava/net/URLConnection;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    .end local v6    # "url":Ljava/net/URL;
    :catch_0
    move-exception v1

    .line 181
    .local v1, "e":Ljava/lang/Exception;
    :try_start_3
    const-string v7, "Sync token error"

    const/4 v8, 0x5

    invoke-static {v7, v8, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 183
    if-eqz v2, :cond_2

    .line 185
    :try_start_4
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 190
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_2
    :goto_2
    const-string v7, "0"

    goto :goto_1

    .line 186
    .restart local v0    # "conn":Ljava/net/URLConnection;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v5    # "sb":Ljava/lang/StringBuilder;
    .restart local v6    # "url":Ljava/net/URL;
    :catch_1
    move-exception v1

    .line 187
    .local v1, "e":Ljava/io/IOException;
    const-string v8, "Sync token error"

    invoke-static {v8, v9, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1

    .line 186
    .end local v0    # "conn":Ljava/net/URLConnection;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    .end local v6    # "url":Ljava/net/URL;
    .local v1, "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 187
    .local v1, "e":Ljava/io/IOException;
    const-string v7, "Sync token error"

    invoke-static {v7, v9, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_2

    .line 182
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v7

    .line 183
    if-eqz v2, :cond_3

    .line 185
    :try_start_5
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 189
    :cond_3
    :goto_3
    throw v7

    .line 186
    :catch_3
    move-exception v1

    .line 187
    .restart local v1    # "e":Ljava/io/IOException;
    const-string v8, "Sync token error"

    invoke-static {v8, v9, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_3
.end method

.method parse(Lorg/json/JSONObject;Ljava/util/HashMap;)Lcom/espn/androidplayersdk/datamanager/EPStream;
    .locals 10
    .param p1, "object"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Lcom/espn/androidplayersdk/datamanager/EPStream;"
        }
    .end annotation

    .prologue
    .line 37
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v3, 0x0

    .line 39
    .local v3, "epStream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    :try_start_0
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .line 40
    .local v7, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v8, "status"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_f

    const-string v8, "status"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_f

    const-string v8, "status"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const-string v9, "success"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_f

    .line 42
    const-string v8, "session"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_e

    const-string v8, "session"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_e

    .line 43
    const-string v8, "session"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 45
    .local v6, "sessionObj":Lorg/json/JSONObject;
    const-string v8, "channel"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    const-string v8, "channel"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 46
    const-string v8, "networkId"

    const-string v9, "channel"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    :cond_0
    const-string v8, "event"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    const-string v8, "event"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 49
    const-string v8, "event"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 50
    .local v4, "eventObj":Lorg/json/JSONObject;
    const-string v8, "id"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    const-string v8, "id"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 51
    const-string v8, "eventId"

    const-string v9, "id"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    :cond_1
    const-string v8, "airingId"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    const-string v8, "airingId"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 54
    const-string v8, "airingId"

    const-string v9, "airingId"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    .end local v4    # "eventObj":Lorg/json/JSONObject;
    :cond_2
    const-string v8, "playbackUrls"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    const-string v8, "playbackUrls"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 58
    const-string v8, "playbackUrls"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 60
    .local v5, "playbackObj":Lorg/json/JSONObject;
    const-string v8, "default"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    const-string v8, "default"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 61
    const-string v8, "playbackUrl"

    const-string v9, "default"

    invoke-virtual {v5, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    :cond_3
    const-string v8, "alternate"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    const-string v8, "alternate"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 64
    const-string v8, "alternatePlaybackUrl"

    const-string v9, "alternate"

    invoke-virtual {v5, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    .end local v5    # "playbackObj":Lorg/json/JSONObject;
    :cond_4
    const-string v8, "maintainUrl"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    const-string v8, "maintainUrl"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_5

    .line 68
    const-string v8, "maintainUrl"

    const-string v9, "maintainUrl"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    :cond_5
    const-string v8, "programChangeUrl"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    const-string v8, "programChangeUrl"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_6

    .line 71
    const-string v8, "programChangeUrl"

    const-string v9, "programChangeUrl"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    :cond_6
    const-string v8, "token"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    const-string v8, "token"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_7

    .line 74
    const-string v8, "token"

    const-string v9, "token"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    :cond_7
    const-string v8, "authorizationCookieName"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_8

    const-string v8, "authorizationCookieName"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_8

    .line 77
    const-string v8, "authorizationCookieName"

    const-string v9, "authorizationCookieName"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    :cond_8
    const-string v8, "analytics"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_a

    const-string v8, "analytics"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_a

    .line 80
    const-string v8, "analytics"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 81
    .local v0, "analyticsObj":Lorg/json/JSONObject;
    const-string v8, "conviva"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_a

    const-string v8, "conviva"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_a

    .line 82
    const-string v8, "conviva"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 83
    .local v1, "convivaObj":Lorg/json/JSONObject;
    const-string v8, "cdn"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_9

    const-string v8, "cdn"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_9

    .line 84
    const-string v8, "cdn"

    const-string v9, "cdn"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    :cond_9
    const-string v8, "resource"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_a

    const-string v8, "resource"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_a

    .line 86
    const-string v8, "resource"

    const-string v9, "resource"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    .end local v0    # "analyticsObj":Lorg/json/JSONObject;
    .end local v1    # "convivaObj":Lorg/json/JSONObject;
    :cond_a
    const-string v8, "fwSyncTokenUrl"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_b

    const-string v8, "fwSyncTokenUrl"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_b

    .line 91
    const-string v8, "fwSyncTokenUrl"

    const-string v9, "fwSyncTokenUrl"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    :cond_b
    const-string v8, "adInsertionEnabled"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_c

    const-string v8, "adInsertionEnabled"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_c

    .line 95
    const-string v8, "adInsertionEnabled"

    const-string v9, "adInsertionEnabled"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    :cond_c
    if-eqz p2, :cond_10

    const-string v8, "ttl"

    invoke-virtual {p2, v8}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_10

    .line 99
    const-string v9, "ttl"

    const-string v8, "ttl"

    invoke-virtual {p2, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v7, v9, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 103
    :cond_d
    :goto_0
    const-string v8, "domain"

    const-string v9, "go.com"

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    .end local v6    # "sessionObj":Lorg/json/JSONObject;
    :cond_e
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPStream;

    .end local v3    # "epStream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    invoke-direct {v3, v7}, Lcom/espn/androidplayersdk/datamanager/EPStream;-><init>(Ljava/util/HashMap;)V

    .line 113
    .end local v7    # "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v3    # "epStream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    :cond_f
    :goto_1
    return-object v3

    .line 100
    .restart local v6    # "sessionObj":Lorg/json/JSONObject;
    .restart local v7    # "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_10
    const-string v8, "ttl"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_d

    const-string v8, "ttl"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_d

    .line 101
    const-string v8, "ttl"

    const-string v9, "ttl"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 108
    .end local v3    # "epStream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    .end local v6    # "sessionObj":Lorg/json/JSONObject;
    .end local v7    # "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v2

    .line 109
    .local v2, "e":Ljava/lang/Exception;
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "StartSessionParser:"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_11

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v8

    :goto_2
    const/4 v9, 0x5

    invoke-static {v8, v9, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 110
    const/4 v3, 0x0

    .restart local v3    # "epStream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    goto :goto_1

    .line 109
    .end local v3    # "epStream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    :cond_11
    const-string v8, ""

    goto :goto_2
.end method
