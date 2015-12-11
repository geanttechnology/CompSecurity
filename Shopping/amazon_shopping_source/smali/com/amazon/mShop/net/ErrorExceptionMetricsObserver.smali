.class public Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;
.super Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
.source "ErrorExceptionMetricsObserver.java"


# static fields
.field static final METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;


# instance fields
.field private mException:Ljava/lang/Exception;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    new-instance v0, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-void
.end method

.method public constructor <init>(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->mException:Ljava/lang/Exception;

    .line 27
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;)Ljava/lang/Exception;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->getException()Ljava/lang/Exception;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Ljava/lang/Exception;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ljava/lang/Exception;

    .prologue
    .line 20
    invoke-static {p0}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->getErrorMessage(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getErrorMessage(Ljava/lang/Exception;)Ljava/lang/String;
    .locals 3
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    .line 124
    const/4 v1, 0x0

    .line 125
    .local v1, "errorMessage":Ljava/lang/String;
    instance-of v2, p0, Lcom/amazon/mShop/net/WebViewErrorException;

    if-eqz v2, :cond_0

    move-object v0, p0

    .line 126
    check-cast v0, Lcom/amazon/mShop/net/WebViewErrorException;

    .line 127
    .local v0, "error":Lcom/amazon/mShop/net/WebViewErrorException;
    invoke-virtual {v0}, Lcom/amazon/mShop/net/WebViewErrorException;->toString()Ljava/lang/String;

    move-result-object v1

    .line 132
    .end local v0    # "error":Lcom/amazon/mShop/net/WebViewErrorException;
    :goto_0
    return-object v1

    .line 129
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Exception;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->getFormattedStackTraces([Ljava/lang/StackTraceElement;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private getException()Ljava/lang/Exception;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->mException:Ljava/lang/Exception;

    return-object v0
.end method

.method private static getFormattedStackTraces([Ljava/lang/StackTraceElement;)Ljava/lang/String;
    .locals 4
    .param p0, "stackTrace"    # [Ljava/lang/StackTraceElement;

    .prologue
    .line 136
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 137
    const/4 v2, 0x0

    .line 148
    :goto_0
    return-object v2

    .line 140
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 142
    .local v1, "str":Ljava/lang/StringBuilder;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-ge v0, v2, :cond_1

    .line 143
    aget-object v2, p0, v0

    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 144
    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    aget-object v3, p0, v0

    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    aget-object v3, p0, v0

    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 142
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 148
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public static logMetric(Ljava/lang/Exception;)V
    .locals 1
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    .line 44
    if-eqz p0, :cond_0

    .line 45
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/Exception;->setStackTrace([Ljava/lang/StackTraceElement;)V

    .line 46
    new-instance v0, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;-><init>(Ljava/lang/Exception;)V

    invoke-static {v0}, Lcom/amazon/mShop/net/MetricsCollector;->queueEvent(Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;)V

    .line 48
    :cond_0
    return-void
.end method


# virtual methods
.method public getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;
    .locals 1

    .prologue
    .line 40
    sget-object v0, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-object v0
.end method

.method public getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->ErrorExceptionMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method
