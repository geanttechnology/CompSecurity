.class public Lamazon/communication/srr/SrrRequest$Builder;
.super Ljava/lang/Object;
.source "SrrRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/communication/srr/SrrRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# static fields
.field private static final sBuilderNullMetricEvent:Lcom/amazon/client/metrics/MetricEvent;


# instance fields
.field private mBuilderCompressionOption:Lamazon/communication/connection/CompressionOption;

.field private mBuilderEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

.field private mBuilderIsClearTextAllowed:Z

.field private mBuilderIsWiFiNecessary:Z

.field private mBuilderMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private mBuilderRequest:Lorg/apache/http/client/methods/HttpRequestBase;

.field private mBuilderRequestContext:Lamazon/communication/authentication/RequestContext;

.field private mBuilderTimeoutInMillis:I

.field private mIsLocked:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 54
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    const-string/jumbo v1, "Srr"

    const-string/jumbo v2, "SrrRequest"

    invoke-direct {v0, v1, v2}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lamazon/communication/srr/SrrRequest$Builder;->sBuilderNullMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    sget-object v0, Lamazon/communication/srr/SrrRequest$Builder;->sBuilderNullMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    iput-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 63
    iput v1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderTimeoutInMillis:I

    .line 64
    sget-object v0, Lamazon/communication/connection/CompressionOption;->ALLOWED:Lamazon/communication/connection/CompressionOption;

    iput-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderCompressionOption:Lamazon/communication/connection/CompressionOption;

    .line 65
    iput-boolean v1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderIsWiFiNecessary:Z

    .line 66
    iput-boolean v1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderIsClearTextAllowed:Z

    .line 67
    const/4 v0, 0x0

    iput-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderRequestContext:Lamazon/communication/authentication/RequestContext;

    .line 75
    iput-boolean v1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mIsLocked:Z

    .line 76
    return-void
.end method

.method static synthetic access$100(Lamazon/communication/srr/SrrRequest$Builder;)Lamazon/communication/identity/EndpointIdentity;
    .locals 1
    .param p0, "x0"    # Lamazon/communication/srr/SrrRequest$Builder;

    .prologue
    .line 52
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

    return-object v0
.end method

.method static synthetic access$200(Lamazon/communication/srr/SrrRequest$Builder;)I
    .locals 1
    .param p0, "x0"    # Lamazon/communication/srr/SrrRequest$Builder;

    .prologue
    .line 52
    iget v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderTimeoutInMillis:I

    return v0
.end method

.method static synthetic access$300(Lamazon/communication/srr/SrrRequest$Builder;)Lorg/apache/http/client/methods/HttpRequestBase;
    .locals 1
    .param p0, "x0"    # Lamazon/communication/srr/SrrRequest$Builder;

    .prologue
    .line 52
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderRequest:Lorg/apache/http/client/methods/HttpRequestBase;

    return-object v0
.end method

.method static synthetic access$400(Lamazon/communication/srr/SrrRequest$Builder;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p0, "x0"    # Lamazon/communication/srr/SrrRequest$Builder;

    .prologue
    .line 52
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    return-object v0
.end method

.method static synthetic access$500(Lamazon/communication/srr/SrrRequest$Builder;)Lamazon/communication/connection/CompressionOption;
    .locals 1
    .param p0, "x0"    # Lamazon/communication/srr/SrrRequest$Builder;

    .prologue
    .line 52
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderCompressionOption:Lamazon/communication/connection/CompressionOption;

    return-object v0
.end method

.method static synthetic access$600(Lamazon/communication/srr/SrrRequest$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lamazon/communication/srr/SrrRequest$Builder;

    .prologue
    .line 52
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderIsWiFiNecessary:Z

    return v0
.end method

.method static synthetic access$700(Lamazon/communication/srr/SrrRequest$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lamazon/communication/srr/SrrRequest$Builder;

    .prologue
    .line 52
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderIsClearTextAllowed:Z

    return v0
.end method

.method static synthetic access$800(Lamazon/communication/srr/SrrRequest$Builder;)Lamazon/communication/authentication/RequestContext;
    .locals 1
    .param p0, "x0"    # Lamazon/communication/srr/SrrRequest$Builder;

    .prologue
    .line 52
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderRequestContext:Lamazon/communication/authentication/RequestContext;

    return-object v0
.end method


# virtual methods
.method public build()Lamazon/communication/srr/SrrRequest;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 224
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mIsLocked:Z

    if-eqz v0, :cond_0

    .line 225
    new-instance v0, Ljava/lang/IllegalAccessException;

    const-string/jumbo v1, "Instance already locked"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 227
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mIsLocked:Z

    .line 228
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderRequest:Lorg/apache/http/client/methods/HttpRequestBase;

    if-nez v0, :cond_1

    .line 229
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Request cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 231
    :cond_1
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

    if-nez v0, :cond_2

    .line 232
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "EndpointIdentity cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 234
    :cond_2
    new-instance v0, Lamazon/communication/srr/SrrRequest;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lamazon/communication/srr/SrrRequest;-><init>(Lamazon/communication/srr/SrrRequest$Builder;Lamazon/communication/srr/SrrRequest$1;)V

    return-object v0
.end method

.method public setCompressionOption(Lamazon/communication/connection/CompressionOption;)Lamazon/communication/srr/SrrRequest$Builder;
    .locals 2
    .param p1, "compressionOption"    # Lamazon/communication/connection/CompressionOption;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 158
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mIsLocked:Z

    if-eqz v0, :cond_0

    .line 159
    new-instance v0, Ljava/lang/IllegalAccessException;

    const-string/jumbo v1, "Instance already locked"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 161
    :cond_0
    if-eqz p1, :cond_1

    .line 162
    iput-object p1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderCompressionOption:Lamazon/communication/connection/CompressionOption;

    .line 164
    :cond_1
    return-object p0
.end method

.method public setEndpointIdentity(Lamazon/communication/identity/EndpointIdentity;)Lamazon/communication/srr/SrrRequest$Builder;
    .locals 2
    .param p1, "destination"    # Lamazon/communication/identity/EndpointIdentity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 101
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mIsLocked:Z

    if-eqz v0, :cond_0

    .line 102
    new-instance v0, Ljava/lang/IllegalAccessException;

    const-string/jumbo v1, "Instance already locked"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 104
    :cond_0
    iput-object p1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

    .line 105
    return-object p0
.end method

.method public setMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)Lamazon/communication/srr/SrrRequest$Builder;
    .locals 2
    .param p1, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 117
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mIsLocked:Z

    if-eqz v0, :cond_0

    .line 118
    new-instance v0, Ljava/lang/IllegalAccessException;

    const-string/jumbo v1, "Instance already locked"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 120
    :cond_0
    if-eqz p1, :cond_1

    .line 121
    iput-object p1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 123
    :cond_1
    return-object p0
.end method

.method public setRequest(Lorg/apache/http/client/methods/HttpRequestBase;)Lamazon/communication/srr/SrrRequest$Builder;
    .locals 2
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpRequestBase;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 86
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mIsLocked:Z

    if-eqz v0, :cond_0

    .line 87
    new-instance v0, Ljava/lang/IllegalAccessException;

    const-string/jumbo v1, "Instance already locked"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 89
    :cond_0
    iput-object p1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderRequest:Lorg/apache/http/client/methods/HttpRequestBase;

    .line 90
    return-object p0
.end method

.method public setRequestContext(Lamazon/communication/authentication/RequestContext;)Lamazon/communication/srr/SrrRequest$Builder;
    .locals 2
    .param p1, "requestContext"    # Lamazon/communication/authentication/RequestContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 210
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mIsLocked:Z

    if-eqz v0, :cond_0

    .line 211
    new-instance v0, Ljava/lang/IllegalAccessException;

    const-string/jumbo v1, "Instance already locked"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 213
    :cond_0
    iput-object p1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderRequestContext:Lamazon/communication/authentication/RequestContext;

    .line 214
    return-object p0
.end method

.method public setTimeout(I)Lamazon/communication/srr/SrrRequest$Builder;
    .locals 2
    .param p1, "timeoutInMillis"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 137
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest$Builder;->mIsLocked:Z

    if-eqz v0, :cond_0

    .line 138
    new-instance v0, Ljava/lang/IllegalAccessException;

    const-string/jumbo v1, "Instance already locked"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 141
    :cond_0
    if-gez p1, :cond_1

    .line 142
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Timeout must not be negative!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 144
    :cond_1
    iput p1, p0, Lamazon/communication/srr/SrrRequest$Builder;->mBuilderTimeoutInMillis:I

    .line 145
    return-object p0
.end method
