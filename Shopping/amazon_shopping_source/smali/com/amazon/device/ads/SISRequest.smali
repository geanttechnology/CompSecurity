.class interface abstract Lcom/amazon/device/ads/SISRequest;
.super Ljava/lang/Object;
.source "SISRequestor.java"


# virtual methods
.method public abstract getCallMetricType()Lcom/amazon/device/ads/Metrics$MetricType;
.end method

.method public abstract getLogTag()Ljava/lang/String;
.end method

.method public abstract getPath()Ljava/lang/String;
.end method

.method public abstract getPostParameters()Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getQueryParameters()Lcom/amazon/device/ads/WebRequest$QueryStringParameters;
.end method

.method public abstract onResponseReceived(Lorg/json/JSONObject;)V
.end method
