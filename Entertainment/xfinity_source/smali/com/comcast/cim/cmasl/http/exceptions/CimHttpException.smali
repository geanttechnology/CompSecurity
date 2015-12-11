.class public Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;
.super Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
.source "CimHttpException.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V
    .locals 1
    .param p1, "detailedStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    .prologue
    .line 27
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    .line 28
    iput-object p1, p0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    .line 29
    return-void
.end method


# virtual methods
.method public getDetailedStatus()Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    return-object v0
.end method

.method public getDetailedStatusCode()I
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getStatusCodeForDisplay()I
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method
