.class public Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;
.super Ljava/lang/Object;
.source "ImpressionTrackingData.java"

# interfaces
.implements Lcom/amazon/client/metrics/clickstream/ClickStreamInfo;


# instance fields
.field mImpressionData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field mImpressionMetadata:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field mImpressionType:Ljava/lang/String;

.field mProgramGroup:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDataPoints()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 76
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 77
    .local v0, "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    sget-object v1, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_PROGRAM_GROUP:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mProgramGroup:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamHelper;->addDatapoint(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    sget-object v1, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mImpressionType:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamHelper;->addDatapoint(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    sget-object v1, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_DATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mImpressionData:Ljava/util/List;

    invoke-static {v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamHelper;->listToString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamHelper;->addDatapoint(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    sget-object v1, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_METADATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mImpressionMetadata:Ljava/util/Map;

    invoke-static {v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamHelper;->mapToString(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamHelper;->addDatapoint(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    return-object v0
.end method

.method public getImpresionData()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mImpressionData:Ljava/util/List;

    return-object v0
.end method

.method public getImpressionMetadata()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mImpressionMetadata:Ljava/util/Map;

    return-object v0
.end method

.method public getImpressionProgramGroup()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mProgramGroup:Ljava/lang/String;

    return-object v0
.end method

.method public getImpressionType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mImpressionType:Ljava/lang/String;

    return-object v0
.end method

.method public setImpresionData(Ljava/util/List;)Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;"
        }
    .end annotation

    .prologue
    .line 61
    .local p1, "impressionData":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mImpressionData:Ljava/util/List;

    .line 62
    return-object p0
.end method

.method public setImpressionMetadata(Ljava/util/Map;)Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;"
        }
    .end annotation

    .prologue
    .line 70
    .local p1, "impressionMetadata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mImpressionMetadata:Ljava/util/Map;

    .line 71
    return-object p0
.end method

.method public setImpressionProgramGroup(Ljava/lang/String;)Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;
    .locals 0
    .param p1, "programGroup"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mProgramGroup:Ljava/lang/String;

    .line 44
    return-object p0
.end method

.method public setImpressionType(Ljava/lang/String;)Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;
    .locals 0
    .param p1, "impressionType"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;->mImpressionType:Ljava/lang/String;

    .line 53
    return-object p0
.end method
