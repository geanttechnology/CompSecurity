.class public Lcom/amazon/retailsearch/metrics/SearchMetricEvent;
.super Ljava/lang/Object;
.source "SearchMetricEvent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/metrics/SearchMetricEvent$1;
    }
.end annotation


# instance fields
.field private final connectionType:I

.field private final connectivityManager:Landroid/net/ConnectivityManager;

.field private final event:Lcom/amazon/client/metrics/MetricEvent;

.field preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private final viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/MetricEvent;Landroid/content/Context;)V
    .locals 2
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 39
    iput-object p1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    .line 40
    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 41
    const-string/jumbo v1, "connectivity"

    invoke-virtual {p2, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/ConnectivityManager;

    iput-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectivityManager:Landroid/net/ConnectivityManager;

    .line 43
    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 44
    .local v0, "activeNetwork":Landroid/net/NetworkInfo;
    if-nez v0, :cond_0

    const/4 v1, -0x1

    :goto_0
    iput v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectionType:I

    .line 45
    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget v1, v1, Landroid/content/res/Configuration;->orientation:I

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->addOrientationMetrics(I)V

    .line 46
    return-void

    .line 44
    :cond_0
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    goto :goto_0
.end method

.method private addOrientationMetrics(I)V
    .locals 4
    .param p1, "orientation"    # I

    .prologue
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .line 222
    packed-switch p1, :pswitch_data_0

    .line 231
    :goto_0
    return-void

    .line 225
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchLandscape:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    goto :goto_0

    .line 228
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchPortrait:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    goto :goto_0

    .line 222
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private clearConnectionTypeMetrics()V
    .locals 2

    .prologue
    .line 124
    iget v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectionType:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 126
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchWifi:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeCounter(Ljava/lang/String;)V

    .line 127
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFWifi:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeTimer(Ljava/lang/String;)V

    .line 134
    :cond_0
    :goto_0
    return-void

    .line 129
    :cond_1
    iget v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectionType:I

    if-nez v0, :cond_0

    .line 131
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchCell:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeCounter(Ljava/lang/String;)V

    .line 132
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFCell:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeTimer(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private clearViewType()V
    .locals 2

    .prologue
    .line 195
    sget-object v0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent$1;->$SwitchMap$com$amazon$retailsearch$android$ui$results$ViewType:[I

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 214
    :goto_0
    return-void

    .line 198
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchGrid:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeCounter(Ljava/lang/String;)V

    .line 199
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFGrid:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 202
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchList:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeCounter(Ljava/lang/String;)V

    .line 203
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFList:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 206
    :pswitch_2
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchImage:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeCounter(Ljava/lang/String;)V

    .line 207
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFImage:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 210
    :pswitch_3
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchSplit:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeCounter(Ljava/lang/String;)V

    .line 211
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFSplit:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->removeTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 195
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method


# virtual methods
.method public addCounter(Ljava/lang/String;D)V
    .locals 1
    .param p1, "counterName"    # Ljava/lang/String;
    .param p2, "counterValue"    # D

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 64
    return-void
.end method

.method public addString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1, p2}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    return-void
.end method

.method public getEvent()Lcom/amazon/client/metrics/MetricEvent;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    return-object v0
.end method

.method public startConnectionTypeMetrics()V
    .locals 4

    .prologue
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .line 83
    iget v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectionType:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 85
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchWifi:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v2, v3}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 86
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFWifi:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startTimer(Ljava/lang/String;)V

    .line 93
    :cond_0
    :goto_0
    return-void

    .line 88
    :cond_1
    iget v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectionType:I

    if-nez v0, :cond_0

    .line 90
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchCell:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v2, v3}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 91
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFCell:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startTimer(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public startTimer(Ljava/lang/String;)V
    .locals 1
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V

    .line 69
    return-void
.end method

.method public startViewTypeMetrics()V
    .locals 4

    .prologue
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .line 141
    sget-object v0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent$1;->$SwitchMap$com$amazon$retailsearch$android$ui$results$ViewType:[I

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 159
    :goto_0
    return-void

    .line 144
    :pswitch_0
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchGrid:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v2, v3}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 145
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFGrid:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 148
    :pswitch_1
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchList:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v2, v3}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 149
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFList:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 152
    :pswitch_2
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchImage:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v2, v3}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 153
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFImage:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 156
    :pswitch_3
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchSplit:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v2, v3}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 157
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFSplit:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 141
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public stopConnectionTypeMetrics()V
    .locals 3

    .prologue
    .line 102
    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 103
    .local v0, "activeNetwork":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    iget v2, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectionType:I

    if-eq v1, v2, :cond_2

    .line 105
    :cond_0
    invoke-direct {p0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->clearConnectionTypeMetrics()V

    .line 117
    :cond_1
    :goto_0
    return-void

    .line 109
    :cond_2
    iget v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectionType:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_3

    .line 111
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFWifi:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 113
    :cond_3
    iget v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->connectionType:I

    if-nez v1, :cond_1

    .line 115
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFCell:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopTimer(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public stopTimer(Ljava/lang/String;)V
    .locals 1
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->event:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    .line 74
    return-void
.end method

.method public stopViewTypeMetrics()V
    .locals 2

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 168
    invoke-direct {p0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->clearViewType()V

    .line 187
    :goto_0
    return-void

    .line 172
    :cond_0
    sget-object v0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent$1;->$SwitchMap$com$amazon$retailsearch$android$ui$results$ViewType:[I

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 175
    :pswitch_0
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFGrid:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 178
    :pswitch_1
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFList:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 181
    :pswitch_2
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFImage:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 184
    :pswitch_3
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFSplit:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 172
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
