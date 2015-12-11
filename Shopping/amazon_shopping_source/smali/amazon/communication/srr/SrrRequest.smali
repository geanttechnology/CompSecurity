.class public Lamazon/communication/srr/SrrRequest;
.super Ljava/lang/Object;
.source "SrrRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lamazon/communication/srr/SrrRequest$1;,
        Lamazon/communication/srr/SrrRequest$Builder;
    }
.end annotation


# instance fields
.field private final mCompressionOption:Lamazon/communication/connection/CompressionOption;

.field private final mEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

.field private final mIsClearTextAllowed:Z

.field private final mIsWiFiNecessary:Z

.field private final mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private final mRequest:Lorg/apache/http/client/methods/HttpRequestBase;

.field private final mRequestContext:Lamazon/communication/authentication/RequestContext;

.field private final mTimeoutInMillis:I


# direct methods
.method private constructor <init>(Lamazon/communication/srr/SrrRequest$Builder;)V
    .locals 1
    .param p1, "builder"    # Lamazon/communication/srr/SrrRequest$Builder;

    .prologue
    .line 238
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 239
    # getter for: Lamazon/communication/srr/SrrRequest$Builder;->mBuilderEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;
    invoke-static {p1}, Lamazon/communication/srr/SrrRequest$Builder;->access$100(Lamazon/communication/srr/SrrRequest$Builder;)Lamazon/communication/identity/EndpointIdentity;

    move-result-object v0

    iput-object v0, p0, Lamazon/communication/srr/SrrRequest;->mEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

    .line 240
    # getter for: Lamazon/communication/srr/SrrRequest$Builder;->mBuilderTimeoutInMillis:I
    invoke-static {p1}, Lamazon/communication/srr/SrrRequest$Builder;->access$200(Lamazon/communication/srr/SrrRequest$Builder;)I

    move-result v0

    iput v0, p0, Lamazon/communication/srr/SrrRequest;->mTimeoutInMillis:I

    .line 241
    # getter for: Lamazon/communication/srr/SrrRequest$Builder;->mBuilderRequest:Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-static {p1}, Lamazon/communication/srr/SrrRequest$Builder;->access$300(Lamazon/communication/srr/SrrRequest$Builder;)Lorg/apache/http/client/methods/HttpRequestBase;

    move-result-object v0

    iput-object v0, p0, Lamazon/communication/srr/SrrRequest;->mRequest:Lorg/apache/http/client/methods/HttpRequestBase;

    .line 242
    # getter for: Lamazon/communication/srr/SrrRequest$Builder;->mBuilderMetricEvent:Lcom/amazon/client/metrics/MetricEvent;
    invoke-static {p1}, Lamazon/communication/srr/SrrRequest$Builder;->access$400(Lamazon/communication/srr/SrrRequest$Builder;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    iput-object v0, p0, Lamazon/communication/srr/SrrRequest;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 243
    # getter for: Lamazon/communication/srr/SrrRequest$Builder;->mBuilderCompressionOption:Lamazon/communication/connection/CompressionOption;
    invoke-static {p1}, Lamazon/communication/srr/SrrRequest$Builder;->access$500(Lamazon/communication/srr/SrrRequest$Builder;)Lamazon/communication/connection/CompressionOption;

    move-result-object v0

    iput-object v0, p0, Lamazon/communication/srr/SrrRequest;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    .line 244
    # getter for: Lamazon/communication/srr/SrrRequest$Builder;->mBuilderIsWiFiNecessary:Z
    invoke-static {p1}, Lamazon/communication/srr/SrrRequest$Builder;->access$600(Lamazon/communication/srr/SrrRequest$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lamazon/communication/srr/SrrRequest;->mIsWiFiNecessary:Z

    .line 245
    # getter for: Lamazon/communication/srr/SrrRequest$Builder;->mBuilderIsClearTextAllowed:Z
    invoke-static {p1}, Lamazon/communication/srr/SrrRequest$Builder;->access$700(Lamazon/communication/srr/SrrRequest$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lamazon/communication/srr/SrrRequest;->mIsClearTextAllowed:Z

    .line 246
    # getter for: Lamazon/communication/srr/SrrRequest$Builder;->mBuilderRequestContext:Lamazon/communication/authentication/RequestContext;
    invoke-static {p1}, Lamazon/communication/srr/SrrRequest$Builder;->access$800(Lamazon/communication/srr/SrrRequest$Builder;)Lamazon/communication/authentication/RequestContext;

    move-result-object v0

    iput-object v0, p0, Lamazon/communication/srr/SrrRequest;->mRequestContext:Lamazon/communication/authentication/RequestContext;

    .line 247
    return-void
.end method

.method synthetic constructor <init>(Lamazon/communication/srr/SrrRequest$Builder;Lamazon/communication/srr/SrrRequest$1;)V
    .locals 0
    .param p1, "x0"    # Lamazon/communication/srr/SrrRequest$Builder;
    .param p2, "x1"    # Lamazon/communication/srr/SrrRequest$1;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lamazon/communication/srr/SrrRequest;-><init>(Lamazon/communication/srr/SrrRequest$Builder;)V

    return-void
.end method


# virtual methods
.method public getCompressionOption()Lamazon/communication/connection/CompressionOption;
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    return-object v0
.end method

.method public getEndpointIdentity()Lamazon/communication/identity/EndpointIdentity;
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest;->mEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

    return-object v0
.end method

.method public getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;
    .locals 1

    .prologue
    .line 275
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    return-object v0
.end method

.method public getRequest()Lorg/apache/http/client/methods/HttpRequestBase;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest;->mRequest:Lorg/apache/http/client/methods/HttpRequestBase;

    return-object v0
.end method

.method public getRequestContext()Lamazon/communication/authentication/RequestContext;
    .locals 1

    .prologue
    .line 320
    iget-object v0, p0, Lamazon/communication/srr/SrrRequest;->mRequestContext:Lamazon/communication/authentication/RequestContext;

    return-object v0
.end method

.method public getTimeout()I
    .locals 1

    .prologue
    .line 284
    iget v0, p0, Lamazon/communication/srr/SrrRequest;->mTimeoutInMillis:I

    return v0
.end method

.method public isClearTextAllowed()Z
    .locals 1

    .prologue
    .line 311
    iget-boolean v0, p0, Lamazon/communication/srr/SrrRequest;->mIsClearTextAllowed:Z

    return v0
.end method
