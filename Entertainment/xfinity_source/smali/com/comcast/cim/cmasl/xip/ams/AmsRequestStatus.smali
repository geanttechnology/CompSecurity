.class public Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;
.super Ljava/lang/Object;
.source "AmsRequestStatus.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private final errorMessage:Ljava/lang/String;

.field private final statusCode:Ljava/lang/Integer;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 0
    .param p1, "errorMessage"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "errorMessage"
        .end annotation
    .end param
    .param p2, "statusCode"    # Ljava/lang/Integer;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "statusCode"
        .end annotation
    .end param

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;->errorMessage:Ljava/lang/String;

    .line 15
    iput-object p2, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;->statusCode:Ljava/lang/Integer;

    .line 16
    return-void
.end method


# virtual methods
.method public getErrorMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;->errorMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getStatusCode()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;->statusCode:Ljava/lang/Integer;

    return-object v0
.end method

.method public toDetailedRequestStatus()Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .locals 3

    .prologue
    .line 27
    new-instance v0, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;->statusCode:Ljava/lang/Integer;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;->errorMessage:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;-><init>(Ljava/lang/Integer;Ljava/lang/String;)V

    return-object v0
.end method
