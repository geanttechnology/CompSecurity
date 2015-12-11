.class public final Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;
.super Ljava/lang/Object;
.source "ZeroesMeasurementUtils.java"


# static fields
.field public static final EXTRA_MEASUREMENT:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 24
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".measurement"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->EXTRA_MEASUREMENT:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 195
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 196
    return-void
.end method

.method public static actionFailedMeasurement(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;
    .locals 3
    .param p0, "actionName"    # Ljava/lang/String;

    .prologue
    .line 157
    new-instance v0, Lcom/amazon/sdk/availability/Measurement;

    invoke-direct {v0}, Lcom/amazon/sdk/availability/Measurement;-><init>()V

    const-string/jumbo v1, "actionFailed"

    invoke-virtual {v0, v1}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementName(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementTimestamp(J)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementValueNumber(Ljava/lang/Number;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    const-string/jumbo v1, "action"

    invoke-virtual {v0, v1, p0}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    const-string/jumbo v1, "reason"

    const-string/jumbo v2, "unknown"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    const-string/jumbo v1, "protocolVersion"

    const-string/jumbo v2, "2"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    const-string/jumbo v1, "source"

    const-string/jumbo v2, "failure"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    return-object v0
.end method

.method public static actionFailedMeasurement(Ljava/lang/String;Lcom/amazon/mas/client/http/WebResponse;)Lcom/amazon/sdk/availability/Measurement;
    .locals 6
    .param p0, "actionName"    # Ljava/lang/String;
    .param p1, "webResponse"    # Lcom/amazon/mas/client/http/WebResponse;

    .prologue
    .line 178
    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->getResponse()Lorg/apache/http/HttpResponse;

    move-result-object v3

    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v2

    .line 179
    .local v2, "statusLine":Lorg/apache/http/StatusLine;
    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->getResponse()Lorg/apache/http/HttpResponse;

    move-result-object v3

    const-string/jumbo v4, "x-amzn-RequestId"

    invoke-interface {v3, v4}, Lorg/apache/http/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lorg/apache/http/Header;

    move-result-object v1

    .line 181
    .local v1, "requestIdHeader":Lorg/apache/http/Header;
    if-nez v1, :cond_0

    .line 182
    const-string/jumbo v0, ""

    .line 187
    .local v0, "requestId":Ljava/lang/String;
    :goto_0
    invoke-static {p0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    const-string/jumbo v4, "reason"

    const-string/jumbo v5, "invalidResponse"

    invoke-virtual {v3, v4, v5}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    const-string/jumbo v4, "statusCode"

    invoke-interface {v2}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    const-string/jumbo v4, "body"

    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    const-string/jumbo v4, "requestId"

    invoke-virtual {v3, v4, v0}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    return-object v3

    .line 184
    .end local v0    # "requestId":Ljava/lang/String;
    :cond_0
    invoke-interface {v1}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "requestId":Ljava/lang/String;
    goto :goto_0
.end method

.method public static fromIntent(Landroid/content/Intent;)Lcom/amazon/sdk/availability/Measurement;
    .locals 12
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    .line 96
    :try_start_0
    new-instance v4, Lorg/json/JSONObject;

    sget-object v9, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->EXTRA_MEASUREMENT:Ljava/lang/String;

    invoke-virtual {p0, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v4, v9}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    .local v4, "measurementJson":Lorg/json/JSONObject;
    const-string/jumbo v9, "name"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 102
    .local v6, "name":Ljava/lang/String;
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 103
    new-instance v9, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v10, "measurementName can\'t be empty"

    invoke-direct {v9, v10}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 97
    .end local v4    # "measurementJson":Lorg/json/JSONObject;
    .end local v6    # "name":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 98
    .local v0, "e":Lorg/json/JSONException;
    new-instance v9, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v10, "The measurement isn\'t valid JSON"

    invoke-direct {v9, v10}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 106
    .end local v0    # "e":Lorg/json/JSONException;
    .restart local v4    # "measurementJson":Lorg/json/JSONObject;
    .restart local v6    # "name":Ljava/lang/String;
    :cond_0
    const-string/jumbo v9, "value"

    const-wide/16 v10, 0x0

    invoke-virtual {v4, v9, v10, v11}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;D)D

    move-result-wide v7

    .line 108
    .local v7, "value":D
    new-instance v9, Lcom/amazon/sdk/availability/Measurement;

    invoke-direct {v9}, Lcom/amazon/sdk/availability/Measurement;-><init>()V

    invoke-virtual {v9, v6}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementName(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v9

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    invoke-virtual {v9, v10, v11}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementTimestamp(J)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v9

    invoke-static {v7, v8}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementValueNumber(Ljava/lang/Number;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v9

    const-string/jumbo v10, "protocolVersion"

    const-string/jumbo v11, "2"

    invoke-virtual {v9, v10, v11}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v9

    const-string/jumbo v10, "source"

    const-string/jumbo v11, "ui"

    invoke-virtual {v9, v10, v11}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    .line 115
    .local v3, "measurement":Lcom/amazon/sdk/availability/Measurement;
    const-string/jumbo v9, "metadata"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 116
    .local v5, "metadata":Lorg/json/JSONObject;
    if-eqz v5, :cond_1

    .line 118
    invoke-virtual {v5}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v2

    .line 119
    .local v2, "keys":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    .line 120
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 121
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {v5, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v3, v1, v9}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    goto :goto_0

    .line 125
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "keys":Ljava/util/Iterator;
    :cond_1
    return-object v3
.end method

.method public static fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;
    .locals 5
    .param p0, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 136
    new-instance v1, Ljava/io/StringWriter;

    invoke-direct {v1}, Ljava/io/StringWriter;-><init>()V

    .line 137
    .local v1, "stringWriter":Ljava/io/StringWriter;
    new-instance v0, Ljava/io/PrintWriter;

    invoke-direct {v0, v1}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    .line 138
    .local v0, "printWriter":Ljava/io/PrintWriter;
    invoke-virtual {p0, v0}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 140
    new-instance v2, Lcom/amazon/sdk/availability/Measurement;

    invoke-direct {v2}, Lcom/amazon/sdk/availability/Measurement;-><init>()V

    const-string/jumbo v3, "exception"

    invoke-virtual {v2, v3}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementName(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementTimestamp(J)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v2

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementValueNumber(Ljava/lang/Number;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v2

    const-string/jumbo v3, "trace"

    invoke-virtual {v1}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v2

    const-string/jumbo v3, "protocolVersion"

    const-string/jumbo v4, "2"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v2

    const-string/jumbo v3, "source"

    const-string/jumbo v4, "exception"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v2

    return-object v2
.end method
