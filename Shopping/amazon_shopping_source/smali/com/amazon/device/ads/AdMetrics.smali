.class Lcom/amazon/device/ads/AdMetrics;
.super Ljava/lang/Object;
.source "AdMetrics.java"


# static fields
.field public static final LOG_TAG:Ljava/lang/String; = "AdMetrics"


# instance fields
.field private adData:Lcom/amazon/device/ads/AdData;

.field private globalMetrics:Lcom/amazon/device/ads/MetricsCollector;


# direct methods
.method public constructor <init>(Lcom/amazon/device/ads/AdData;)V
    .locals 0
    .param p1, "adData"    # Lcom/amazon/device/ads/AdData;

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/amazon/device/ads/AdMetrics;->adData:Lcom/amazon/device/ads/AdData;

    .line 35
    return-void
.end method

.method protected static addMetricsToJSON(Lorg/json/JSONObject;Lcom/amazon/device/ads/MetricsCollector;)V
    .locals 27
    .param p0, "json"    # Lorg/json/JSONObject;
    .param p1, "metricsCollector"    # Lcom/amazon/device/ads/MetricsCollector;

    .prologue
    .line 121
    if-nez p1, :cond_1

    .line 204
    :cond_0
    return-void

    .line 137
    :cond_1
    new-instance v19, Ljava/util/HashMap;

    invoke-direct/range {v19 .. v19}, Ljava/util/HashMap;-><init>()V

    .line 138
    .local v19, "startedMetricHits":Ljava/util/HashMap;, "Ljava/util/HashMap<Lcom/amazon/device/ads/Metrics$MetricType;Ljava/lang/Long;>;"
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 141
    .local v9, "incrementedMetricHits":Ljava/util/HashMap;, "Ljava/util/HashMap<Lcom/amazon/device/ads/Metrics$MetricType;Ljava/lang/Integer;>;"
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/MetricsCollector;->getAdTypeMetricTag()Ljava/lang/String;

    move-result-object v4

    .line 142
    .local v4, "adTypeMetricTag":Ljava/lang/String;
    if-eqz v4, :cond_2

    .line 144
    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v23

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string/jumbo v24, "_"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 150
    :cond_2
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/MetricsCollector;->getMetricHits()Ljava/util/Vector;

    move-result-object v23

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/MetricsCollector;->getMetricHits()Ljava/util/Vector;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/util/Vector;->size()I

    move-result v24

    move/from16 v0, v24

    new-array v0, v0, [Lcom/amazon/device/ads/MetricsCollector$MetricHit;

    move-object/from16 v24, v0

    invoke-virtual/range {v23 .. v24}, Ljava/util/Vector;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v20

    check-cast v20, [Lcom/amazon/device/ads/MetricsCollector$MetricHit;

    .line 152
    .local v20, "tempMetricHits":[Lcom/amazon/device/ads/MetricsCollector$MetricHit;
    const/16 v17, 0x0

    .line 153
    .local v17, "metricName":Ljava/lang/String;
    move-object/from16 v5, v20

    .local v5, "arr$":[Lcom/amazon/device/ads/MetricsCollector$MetricHit;
    array-length v10, v5

    .local v10, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    :goto_0
    if-ge v6, v10, :cond_a

    aget-object v11, v5, v6

    .line 155
    .local v11, "metricHit":Lcom/amazon/device/ads/MetricsCollector$MetricHit;
    iget-object v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHit;->metric:Lcom/amazon/device/ads/Metrics$MetricType;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Lcom/amazon/device/ads/Metrics$MetricType;->getAaxName()Ljava/lang/String;

    move-result-object v17

    .line 156
    if-eqz v4, :cond_3

    iget-object v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHit;->metric:Lcom/amazon/device/ads/Metrics$MetricType;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Lcom/amazon/device/ads/Metrics$MetricType;->isAdTypeSpecific()Z

    move-result v23

    if-eqz v23, :cond_3

    .line 158
    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v23

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 160
    :cond_3
    instance-of v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHitStartTime;

    move/from16 v23, v0

    if-eqz v23, :cond_5

    move-object v13, v11

    .line 162
    check-cast v13, Lcom/amazon/device/ads/MetricsCollector$MetricHitStartTime;

    .line 163
    .local v13, "metricHitStartTime":Lcom/amazon/device/ads/MetricsCollector$MetricHitStartTime;
    iget-object v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHit;->metric:Lcom/amazon/device/ads/Metrics$MetricType;

    move-object/from16 v23, v0

    iget-wide v0, v13, Lcom/amazon/device/ads/MetricsCollector$MetricHitStartTime;->startTime:J

    move-wide/from16 v24, v0

    invoke-static/range {v24 .. v25}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v24

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    .end local v13    # "metricHitStartTime":Lcom/amazon/device/ads/MetricsCollector$MetricHitStartTime;
    :cond_4
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 165
    :cond_5
    instance-of v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;

    move/from16 v23, v0

    if-eqz v23, :cond_6

    move-object v14, v11

    .line 167
    check-cast v14, Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;

    .line 168
    .local v14, "metricHitStopTime":Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;
    iget-object v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHit;->metric:Lcom/amazon/device/ads/Metrics$MetricType;

    move-object/from16 v23, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/Long;

    .line 169
    .local v18, "startTime":Ljava/lang/Long;
    if-eqz v18, :cond_4

    .line 171
    iget-wide v0, v14, Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;->stopTime:J

    move-wide/from16 v23, v0

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Long;->longValue()J

    move-result-wide v25

    sub-long v21, v23, v25

    .line 172
    .local v21, "totalTime":J
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-wide/from16 v2, v21

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;J)V

    goto :goto_1

    .line 175
    .end local v14    # "metricHitStopTime":Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;
    .end local v18    # "startTime":Ljava/lang/Long;
    .end local v21    # "totalTime":J
    :cond_6
    instance-of v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHitTotalTime;

    move/from16 v23, v0

    if-eqz v23, :cond_7

    move-object/from16 v16, v11

    .line 177
    check-cast v16, Lcom/amazon/device/ads/MetricsCollector$MetricHitTotalTime;

    .line 178
    .local v16, "metricHitTotalTime":Lcom/amazon/device/ads/MetricsCollector$MetricHitTotalTime;
    move-object/from16 v0, v16

    iget-wide v0, v0, Lcom/amazon/device/ads/MetricsCollector$MetricHitTotalTime;->totalTime:J

    move-wide/from16 v23, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-wide/from16 v2, v23

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;J)V

    goto :goto_1

    .line 180
    .end local v16    # "metricHitTotalTime":Lcom/amazon/device/ads/MetricsCollector$MetricHitTotalTime;
    :cond_7
    instance-of v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHitIncrement;

    move/from16 v23, v0

    if-eqz v23, :cond_9

    move-object v12, v11

    .line 182
    check-cast v12, Lcom/amazon/device/ads/MetricsCollector$MetricHitIncrement;

    .line 183
    .local v12, "metricHitIncrement":Lcom/amazon/device/ads/MetricsCollector$MetricHitIncrement;
    iget-object v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHit;->metric:Lcom/amazon/device/ads/Metrics$MetricType;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-virtual {v9, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    .line 184
    .local v7, "increment":Ljava/lang/Integer;
    if-nez v7, :cond_8

    iget v0, v12, Lcom/amazon/device/ads/MetricsCollector$MetricHitIncrement;->increment:I

    move/from16 v23, v0

    :goto_2
    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    .line 185
    iget-object v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHit;->metric:Lcom/amazon/device/ads/Metrics$MetricType;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-virtual {v9, v0, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 184
    :cond_8
    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v23

    iget v0, v12, Lcom/amazon/device/ads/MetricsCollector$MetricHitIncrement;->increment:I

    move/from16 v24, v0

    add-int v23, v23, v24

    goto :goto_2

    .line 187
    .end local v7    # "increment":Ljava/lang/Integer;
    .end local v12    # "metricHitIncrement":Lcom/amazon/device/ads/MetricsCollector$MetricHitIncrement;
    :cond_9
    instance-of v0, v11, Lcom/amazon/device/ads/MetricsCollector$MetricHitString;

    move/from16 v23, v0

    if-eqz v23, :cond_4

    move-object v15, v11

    .line 189
    check-cast v15, Lcom/amazon/device/ads/MetricsCollector$MetricHitString;

    .line 190
    .local v15, "metricHitString":Lcom/amazon/device/ads/MetricsCollector$MetricHitString;
    iget-object v0, v15, Lcom/amazon/device/ads/MetricsCollector$MetricHitString;->text:Ljava/lang/String;

    move-object/from16 v23, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v23

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 195
    .end local v11    # "metricHit":Lcom/amazon/device/ads/MetricsCollector$MetricHit;
    .end local v15    # "metricHitString":Lcom/amazon/device/ads/MetricsCollector$MetricHitString;
    :cond_a
    invoke-virtual {v9}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v23

    invoke-interface/range {v23 .. v23}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 197
    .local v8, "incrementedMetric":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/amazon/device/ads/Metrics$MetricType;Ljava/lang/Integer;>;"
    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual/range {v23 .. v23}, Lcom/amazon/device/ads/Metrics$MetricType;->getAaxName()Ljava/lang/String;

    move-result-object v17

    .line 198
    if-eqz v4, :cond_b

    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual/range {v23 .. v23}, Lcom/amazon/device/ads/Metrics$MetricType;->isAdTypeSpecific()Z

    move-result v23

    if-eqz v23, :cond_b

    .line 200
    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v23

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 202
    :cond_b
    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Ljava/lang/Integer;

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Integer;->intValue()I

    move-result v23

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move/from16 v2, v23

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;I)V

    goto :goto_3
.end method

.method private getAaxUrlAndResetAdMetrics()Ljava/lang/String;
    .locals 4

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdMetrics;->getAaxJson()Ljava/lang/String;

    move-result-object v0

    .line 45
    .local v0, "json":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/device/ads/Utils;->getURLEncodedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 47
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/device/ads/AdMetrics;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getInstrumentationPixelUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 51
    .local v1, "url":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/device/ads/AdMetrics;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->resetMetricsCollector()V

    .line 53
    return-object v1
.end method


# virtual methods
.method public addGlobalMetrics(Lcom/amazon/device/ads/MetricsCollector;)V
    .locals 0
    .param p1, "globalMetrics"    # Lcom/amazon/device/ads/MetricsCollector;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/amazon/device/ads/AdMetrics;->globalMetrics:Lcom/amazon/device/ads/MetricsCollector;

    .line 96
    return-void
.end method

.method public canSubmit()Z
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 74
    iget-object v3, p0, Lcom/amazon/device/ads/AdMetrics;->adData:Lcom/amazon/device/ads/AdData;

    if-nez v3, :cond_1

    .line 90
    :cond_0
    :goto_0
    return v2

    .line 77
    :cond_1
    iget-object v3, p0, Lcom/amazon/device/ads/AdMetrics;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getInstrumentationPixelUrl()Ljava/lang/String;

    move-result-object v1

    .line 78
    .local v1, "pixelUrl":Ljava/lang/String;
    if-eqz v1, :cond_0

    const-string/jumbo v3, ""

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 83
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/RegistrationInfo;->getAppKey()Ljava/lang/String;

    move-result-object v0

    .line 84
    .local v0, "appKey":Ljava/lang/String;
    if-eqz v0, :cond_2

    const-string/jumbo v3, "123"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 86
    :cond_2
    const-string/jumbo v3, "AdMetrics"

    const-string/jumbo v4, "Not submitting metrics because the AppKey is either not set or set to a test key."

    invoke-static {v3, v4}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 90
    :cond_3
    const/4 v2, 0x1

    goto :goto_0
.end method

.method protected getAaxJson()Ljava/lang/String;
    .locals 5

    .prologue
    .line 104
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 107
    .local v1, "json":Lorg/json/JSONObject;
    const-string/jumbo v3, "c"

    const-string/jumbo v4, "msdk"

    invoke-static {v1, v3, v4}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    const-string/jumbo v3, "v"

    invoke-static {}, Lcom/amazon/device/ads/Version;->getRawSDKVersion()Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v3, v4}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    iget-object v3, p0, Lcom/amazon/device/ads/AdMetrics;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/amazon/device/ads/AdMetrics;->addMetricsToJSON(Lorg/json/JSONObject;Lcom/amazon/device/ads/MetricsCollector;)V

    .line 112
    iget-object v3, p0, Lcom/amazon/device/ads/AdMetrics;->globalMetrics:Lcom/amazon/device/ads/MetricsCollector;

    invoke-static {v1, v3}, Lcom/amazon/device/ads/AdMetrics;->addMetricsToJSON(Lorg/json/JSONObject;Lcom/amazon/device/ads/MetricsCollector;)V

    .line 114
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    .line 115
    .local v2, "jsonString":Ljava/lang/String;
    const/4 v3, 0x1

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 116
    .local v0, "bracesRemovedJsonString":Ljava/lang/String;
    return-object v0
.end method

.method public getAaxWebRequestAndResetAdMetrics()Lcom/amazon/device/ads/WebRequest;
    .locals 2

    .prologue
    .line 63
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->createNewWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v0

    .line 64
    .local v0, "webRequest":Lcom/amazon/device/ads/WebRequest;
    invoke-direct {p0}, Lcom/amazon/device/ads/AdMetrics;->getAaxUrlAndResetAdMetrics()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setUrlString(Ljava/lang/String;)V

    .line 65
    return-object v0
.end method
