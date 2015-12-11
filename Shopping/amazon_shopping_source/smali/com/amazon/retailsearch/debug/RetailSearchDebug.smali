.class public Lcom/amazon/retailsearch/debug/RetailSearchDebug;
.super Ljava/lang/Object;
.source "RetailSearchDebug.java"


# static fields
.field private static final LOGGER:Lcom/amazon/retailsearch/log/MessageLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/retailsearch/debug/RetailSearchDebug;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->LOGGER:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static log(Ljava/lang/String;)V
    .locals 1
    .param p0, "debugText"    # Ljava/lang/String;

    .prologue
    .line 46
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 51
    :goto_0
    return-void

    .line 50
    :cond_0
    sget-object v0, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->LOGGER:Lcom/amazon/retailsearch/log/MessageLogger;

    invoke-interface {v0, p0}, Lcom/amazon/retailsearch/log/MessageLogger;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static logMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)V
    .locals 6
    .param p0, "event"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 59
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v3

    if-nez v3, :cond_1

    .line 70
    :cond_0
    return-void

    .line 64
    :cond_1
    invoke-interface {p0}, Lcom/amazon/client/metrics/MetricEvent;->getAsDataPoints()Ljava/util/List;

    move-result-object v0

    .line 66
    .local v0, "collectedMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/client/metrics/DataPoint;

    .line 68
    .local v1, "dp":Lcom/amazon/client/metrics/DataPoint;
    sget-object v3, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->LOGGER:Lcom/amazon/retailsearch/log/MessageLogger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p0}, Lcom/amazon/client/metrics/MetricEvent;->getSource()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/client/metrics/DataPoint;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " ; "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/client/metrics/DataPoint;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/retailsearch/log/MessageLogger;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static toast(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "debugText"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v1

    if-nez v1, :cond_0

    .line 37
    :goto_0
    return-void

    .line 35
    :cond_0
    const/4 v1, 0x1

    invoke-static {p0, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 36
    .local v0, "toast":Landroid/widget/Toast;
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method
