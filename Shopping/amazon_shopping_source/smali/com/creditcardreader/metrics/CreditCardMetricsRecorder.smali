.class public Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;
.super Ljava/lang/Object;
.source "CreditCardMetricsRecorder.java"


# instance fields
.field private mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

.field private mPortrait:Z


# direct methods
.method public constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    .locals 3
    .param p1, "activity"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    invoke-direct {p0, p1}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->setOrientation(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    .line 44
    invoke-static {p1}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 45
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const-string/jumbo v1, "MShopAndroidPhoneApp/CardScanner"

    const-string/jumbo v2, "ShowCardScannerCredit"

    invoke-interface {v0, v1, v2}, Lcom/amazon/client/metrics/MetricsFactory;->createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 46
    return-void
.end method

.method private getSuccessType(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)Lcom/creditcardreader/metrics/CreditCardEvent;
    .locals 8
    .param p1, "result"    # Lcom/a9/creditcardreaderlibrary/CreditCardResult;

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 171
    const/4 v2, 0x0

    .line 172
    .local v2, "foundExpirationDate":Z
    const/4 v0, 0x0

    .line 173
    .local v0, "foundAlternateCardNumbers":Z
    const/4 v1, 0x0

    .line 176
    .local v1, "foundAlternateExpirationDates":Z
    invoke-virtual {p1}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getExpirationDate()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_0

    .line 177
    const/4 v2, 0x1

    .line 181
    :cond_0
    invoke-virtual {p1}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getAlternateCardNumbers()Ljava/util/List;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-virtual {p1}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getAlternateCardNumbers()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_1

    .line 182
    const/4 v0, 0x1

    .line 186
    :cond_1
    invoke-virtual {p1}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getAlternateExpirationDates()Ljava/util/List;

    move-result-object v7

    if-eqz v7, :cond_2

    invoke-virtual {p1}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getAlternateExpirationDates()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_2

    .line 187
    const/4 v1, 0x1

    .line 191
    :cond_2
    if-eqz v2, :cond_3

    if-nez v0, :cond_3

    if-nez v1, :cond_3

    move v3, v5

    .line 192
    .local v3, "highConfidence":Z
    :goto_0
    if-eqz v3, :cond_4

    .line 193
    sget-object v6, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_HIGH_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 209
    :goto_1
    return-object v6

    .end local v3    # "highConfidence":Z
    :cond_3
    move v3, v6

    .line 191
    goto :goto_0

    .line 197
    .restart local v3    # "highConfidence":Z
    :cond_4
    if-nez v2, :cond_5

    if-nez v0, :cond_5

    move v4, v5

    .line 198
    .local v4, "lowExpirationConfidence":Z
    :goto_2
    if-eqz v4, :cond_6

    .line 199
    sget-object v6, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_LOW_EXPIRATION_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    goto :goto_1

    .end local v4    # "lowExpirationConfidence":Z
    :cond_5
    move v4, v6

    .line 197
    goto :goto_2

    .line 203
    .restart local v4    # "lowExpirationConfidence":Z
    :cond_6
    if-nez v2, :cond_7

    if-eqz v0, :cond_7

    .line 204
    .local v5, "lowNumberConfidence":Z
    :goto_3
    if-eqz v5, :cond_8

    .line 205
    sget-object v6, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_LOW_NUMBER_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    goto :goto_1

    .end local v5    # "lowNumberConfidence":Z
    :cond_7
    move v5, v6

    .line 203
    goto :goto_3

    .line 209
    .restart local v5    # "lowNumberConfidence":Z
    :cond_8
    sget-object v6, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    goto :goto_1
.end method

.method private setOrientation(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    .locals 1
    .param p1, "activity"    # Lcom/creditcardreader/activities/CreditCardScanActivity;

    .prologue
    .line 219
    invoke-virtual {p1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getScreenOrientation()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 224
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mPortrait:Z

    .line 226
    :goto_0
    return-void

    .line 221
    :pswitch_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mPortrait:Z

    goto :goto_0

    .line 219
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public recordAlign()V
    .locals 4

    .prologue
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .line 73
    iget-boolean v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mPortrait:Z

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->ALIGNED_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 77
    :goto_0
    return-void

    .line 76
    :cond_0
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->ALIGNED_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto :goto_0
.end method

.method public recordCameraError()V
    .locals 4

    .prologue
    .line 146
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->FAILURE_CAMERA_ERROR:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 147
    return-void
.end method

.method public recordCancel()V
    .locals 4

    .prologue
    .line 101
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->CANCEL:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 102
    return-void
.end method

.method public recordCancelOnBackground()V
    .locals 4

    .prologue
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .line 108
    iget-boolean v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mPortrait:Z

    if-eqz v0, :cond_0

    .line 109
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->CANCEL_ON_BACKGROUND_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 112
    :goto_0
    return-void

    .line 111
    :cond_0
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->CANCEL_ON_BACKGROUND_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto :goto_0
.end method

.method public recordHelp()V
    .locals 4

    .prologue
    .line 118
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->HELP:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 119
    return-void
.end method

.method public recordMetric()V
    .locals 2

    .prologue
    .line 56
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v1, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 57
    return-void
.end method

.method public recordPromising()V
    .locals 4

    .prologue
    .line 83
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->PROMISING:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 84
    return-void
.end method

.method public recordRescan()V
    .locals 4

    .prologue
    .line 132
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->RESCAN_AFTER_TIMEOUT:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 133
    return-void
.end method

.method public recordSession()V
    .locals 4

    .prologue
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .line 63
    iget-boolean v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mPortrait:Z

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->SESSION_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 67
    :goto_0
    return-void

    .line 66
    :cond_0
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->SESSION_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto :goto_0
.end method

.method public recordSuccess(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)V
    .locals 4
    .param p1, "result"    # Lcom/a9/creditcardreaderlibrary/CreditCardResult;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-direct {p0, p1}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->getSuccessType(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)Lcom/creditcardreader/metrics/CreditCardEvent;

    move-result-object v1

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 95
    return-void
.end method

.method public recordTimeout()V
    .locals 4

    .prologue
    .line 125
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->SCAN_TIMEOUT_PROMPT:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 126
    return-void
.end method

.method public recordTimeoutCancel()V
    .locals 4

    .prologue
    .line 139
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->FAILURE_SCAN_TIMEOUT:Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v1}, Lcom/creditcardreader/metrics/CreditCardEvent;->getEvent()Ljava/lang/String;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 140
    return-void
.end method
