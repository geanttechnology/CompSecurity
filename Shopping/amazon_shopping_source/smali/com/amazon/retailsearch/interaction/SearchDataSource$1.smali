.class Lcom/amazon/retailsearch/interaction/SearchDataSource$1;
.super Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;
.source "SearchDataSource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/interaction/SearchDataSource;->submitQuery(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)Lcom/amazon/retailsearch/data/SearchTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/interaction/SearchDataSource;

.field final synthetic val$issEngagementData:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/interaction/SearchDataSource;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource$1;->this$0:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    iput-object p2, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource$1;->val$issEngagementData:Ljava/util/Map;

    invoke-direct {p0}, Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;-><init>()V

    return-void
.end method


# virtual methods
.method public trackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V
    .locals 2
    .param p1, "trackingInfo"    # Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    .prologue
    .line 80
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;->trackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V

    .line 81
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger;

    iget-object v1, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource$1;->val$issEngagementData:Ljava/util/Map;

    invoke-direct {v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;-><init>(Ljava/util/Map;)V

    .line 82
    .local v0, "issLogger":Lcom/amazon/retailsearch/metrics/IssLogger;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;->getRid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->setRequestId(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 83
    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/IssLogger;->submitLog()V

    .line 84
    return-void
.end method
