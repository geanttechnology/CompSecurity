.class public Lcom/newrelic/agent/android/harvest/HttpTransaction;
.super Lcom/newrelic/agent/android/harvest/type/HarvestableArray;
.source "HttpTransaction.java"


# instance fields
.field private appData:Ljava/lang/String;

.field private bytesReceived:J

.field private bytesSent:J

.field private carrier:Ljava/lang/String;

.field private errorCode:I

.field private httpMethod:Ljava/lang/String;

.field private statusCode:I

.field private timestamp:Ljava/lang/Long;

.field private totalTime:D

.field private url:Ljava/lang/String;

.field private wanType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableArray;-><init>()V

    return-void
.end method


# virtual methods
.method public asJsonArray()Lcom/newrelic/com/google/gson/JsonArray;
    .locals 4

    .prologue
    .line 28
    new-instance v0, Lcom/newrelic/com/google/gson/JsonArray;

    invoke-direct {v0}, Lcom/newrelic/com/google/gson/JsonArray;-><init>()V

    .line 29
    .local v0, "array":Lcom/newrelic/com/google/gson/JsonArray;
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->url:Ljava/lang/String;

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 30
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->carrier:Ljava/lang/String;

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 31
    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->totalTime:D

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 32
    iget v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->statusCode:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 33
    iget v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->errorCode:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 34
    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->bytesSent:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 35
    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->bytesReceived:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 36
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->appData:Ljava/lang/String;

    if-nez v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 37
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->wanType:Ljava/lang/String;

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 38
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->httpMethod:Ljava/lang/String;

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 39
    return-object v0

    .line 36
    :cond_0
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->appData:Ljava/lang/String;

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    goto :goto_0
.end method

.method public getAppData()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->appData:Ljava/lang/String;

    return-object v0
.end method

.method public getBytesReceived()J
    .locals 2

    .prologue
    .line 119
    iget-wide v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->bytesReceived:J

    return-wide v0
.end method

.method public getBytesSent()J
    .locals 2

    .prologue
    .line 115
    iget-wide v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->bytesSent:J

    return-wide v0
.end method

.method public getCarrier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->carrier:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorCode()I
    .locals 1

    .prologue
    .line 111
    iget v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->errorCode:I

    return v0
.end method

.method public getHttpMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->httpMethod:Ljava/lang/String;

    return-object v0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 107
    iget v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->statusCode:I

    return v0
.end method

.method public getTimestamp()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->timestamp:Ljava/lang/Long;

    return-object v0
.end method

.method public getTotalTime()D
    .locals 2

    .prologue
    .line 103
    iget-wide v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->totalTime:D

    return-wide v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWanType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->wanType:Ljava/lang/String;

    return-object v0
.end method

.method public setAppData(Ljava/lang/String;)V
    .locals 0
    .param p1, "appData"    # Ljava/lang/String;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->appData:Ljava/lang/String;

    .line 80
    return-void
.end method

.method public setBytesReceived(J)V
    .locals 1
    .param p1, "bytesReceived"    # J

    .prologue
    .line 75
    iput-wide p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->bytesReceived:J

    .line 76
    return-void
.end method

.method public setBytesSent(J)V
    .locals 1
    .param p1, "bytesSent"    # J

    .prologue
    .line 71
    iput-wide p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->bytesSent:J

    .line 72
    return-void
.end method

.method public setCarrier(Ljava/lang/String;)V
    .locals 0
    .param p1, "carrier"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->carrier:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setErrorCode(I)V
    .locals 0
    .param p1, "errorCode"    # I

    .prologue
    .line 67
    iput p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->errorCode:I

    .line 68
    return-void
.end method

.method public setHttpMethod(Ljava/lang/String;)V
    .locals 0
    .param p1, "httpMethod"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->httpMethod:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setStatusCode(I)V
    .locals 0
    .param p1, "statusCode"    # I

    .prologue
    .line 63
    iput p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->statusCode:I

    .line 64
    return-void
.end method

.method public setTimestamp(Ljava/lang/Long;)V
    .locals 0
    .param p1, "timestamp"    # Ljava/lang/Long;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->timestamp:Ljava/lang/Long;

    .line 88
    return-void
.end method

.method public setTotalTime(D)V
    .locals 1
    .param p1, "totalTime"    # D

    .prologue
    .line 59
    iput-wide p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->totalTime:D

    .line 60
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->url:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setWanType(Ljava/lang/String;)V
    .locals 0
    .param p1, "wanType"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->wanType:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    const/16 v4, 0x27

    .line 132
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "HttpTransaction{url=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", carrier=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->carrier:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", wanType=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->wanType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", httpMethod=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->httpMethod:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", totalTime="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->totalTime:D

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", statusCode="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->statusCode:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", errorCode="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->errorCode:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", bytesSent="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->bytesSent:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", bytesReceived="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->bytesReceived:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", appData=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->appData:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", timestamp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/HttpTransaction;->timestamp:Ljava/lang/Long;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
