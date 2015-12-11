.class public Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
.super Ljava/lang/Object;
.source "ViewItMetricHelper.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mCountMetricsPerSessionMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mFlowSessionDurationObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mCountMetricsPerSessionMap:Ljava/util/Map;

    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 26
    return-void
.end method


# virtual methods
.method public cancelFlowBarcodeFailObserver()V
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 181
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 183
    :cond_0
    return-void
.end method

.method public cancelFlowBarcodeNoMatchesObserver()V
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 131
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 133
    :cond_0
    return-void
.end method

.method public cancelFlowBarcodeSuccessObserver()V
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 155
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 156
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 158
    :cond_0
    return-void
.end method

.method public cancelFlowImageFailObserver()V
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 230
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 231
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 233
    :cond_0
    return-void
.end method

.method public cancelFlowImageSuccessObserver()V
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 205
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 206
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 208
    :cond_0
    return-void
.end method

.method public cancelFlowTimeToSuccessObserver()V
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 106
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 108
    :cond_0
    return-void
.end method

.method public finishFlowBarcodeFailObserver()V
    .locals 2

    .prologue
    .line 172
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 173
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-barcode-failure"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 174
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 176
    :cond_0
    return-void
.end method

.method public finishFlowBarcodeNoMatchesObserver()V
    .locals 2

    .prologue
    .line 122
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 123
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-barcode-nomatches"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 124
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 126
    :cond_0
    return-void
.end method

.method public finishFlowBarcodeSuccessObserver()V
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-barcode-success"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 149
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 151
    :cond_0
    return-void
.end method

.method public finishFlowImageFailObserver()V
    .locals 2

    .prologue
    .line 222
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-product-failure"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 224
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 226
    :cond_0
    return-void
.end method

.method public finishFlowImageSuccessObserver()V
    .locals 2

    .prologue
    .line 197
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 198
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-product-success"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 199
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 201
    :cond_0
    return-void
.end method

.method public finishFlowSessionDurationObserver()V
    .locals 2

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowSessionDurationObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowSessionDurationObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-session-duration"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 79
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowSessionDurationObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 81
    :cond_0
    return-void
.end method

.method public finishFlowTimeToSuccessObserver()V
    .locals 2

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-time-to-success"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 99
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 101
    :cond_0
    return-void
.end method

.method public logCountMetricsPerSession(Ljava/lang/String;I)V
    .locals 3
    .param p1, "metric"    # Ljava/lang/String;
    .param p2, "count"    # I

    .prologue
    .line 38
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    if-lez p2, :cond_1

    .line 39
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mCountMetricsPerSessionMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 40
    .local v0, "previousCount":Ljava/lang/Integer;
    if-eqz v0, :cond_0

    .line 41
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    add-int/2addr p2, v1

    .line 43
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mCountMetricsPerSessionMap:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    .end local v0    # "previousCount":Ljava/lang/Integer;
    :cond_1
    return-void
.end method

.method public postCountMetricsPerSession()V
    .locals 7

    .prologue
    .line 51
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mCountMetricsPerSessionMap:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_1

    .line 52
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mCountMetricsPerSessionMap:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    .line 53
    .local v1, "entrySet":Ljava/util/Set;, "Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Integer;>;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 54
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 55
    .local v3, "key":Ljava/lang/String;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    .line 57
    .local v4, "value":Ljava/lang/Integer;
    sget-object v5, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;->FLOW_SCAN:Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-static {v5, v3, v6}, Lcom/amazon/mShop/net/CountMetricObserver;->logCountMetrics(Lcom/amazon/mShop/net/CountMetricObserver$MetricType;Ljava/lang/String;I)V

    goto :goto_0

    .line 59
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Integer;>;"
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "value":Ljava/lang/Integer;
    :cond_0
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mCountMetricsPerSessionMap:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->clear()V

    .line 61
    .end local v1    # "entrySet":Ljava/util/Set;, "Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Integer;>;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method public startFlowBarcodeFailObserver()V
    .locals 2

    .prologue
    .line 164
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 167
    :cond_0
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-barcode-failure"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 168
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-barcode-failure"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 169
    return-void
.end method

.method public startFlowBarcodeNoMatchesObserver()V
    .locals 2

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 117
    :cond_0
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-barcode-nomatches"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 118
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeNoMatchesObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-barcode-nomatches"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 119
    return-void
.end method

.method public startFlowBarcodeSuccessObserver()V
    .locals 2

    .prologue
    .line 139
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 142
    :cond_0
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-barcode-success"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 143
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowBarcodeSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-barcode-success"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 144
    return-void
.end method

.method public startFlowImageFailObserver()V
    .locals 2

    .prologue
    .line 214
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 215
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 217
    :cond_0
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-product-failure"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 218
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageFailObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-product-failure"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 219
    return-void
.end method

.method public startFlowImageSuccessObserver()V
    .locals 2

    .prologue
    .line 189
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 190
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 192
    :cond_0
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-product-success"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 193
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowImageSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-product-success"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 194
    return-void
.end method

.method public startFlowSessionDurationObserver()V
    .locals 2

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowSessionDurationObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowSessionDurationObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 72
    :cond_0
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-session-duration"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowSessionDurationObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowSessionDurationObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-session-duration"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 74
    return-void
.end method

.method public startFlowTimeToSuccessObserver()V
    .locals 2

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 92
    :cond_0
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-time-to-success"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->mFlowTimeToSuccessObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Scan-time-to-success"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 94
    return-void
.end method
