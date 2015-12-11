.class public Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
.super Ljava/lang/Object;
.source "DetailedRequestStatus.java"


# instance fields
.field private final statusCode:Ljava/lang/Integer;

.field private final statusMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/Integer;Ljava/lang/String;)V
    .locals 0
    .param p1, "statusCode"    # Ljava/lang/Integer;
    .param p2, "statusMessage"    # Ljava/lang/String;

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-object p1, p0, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->statusCode:Ljava/lang/Integer;

    .line 11
    iput-object p2, p0, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->statusMessage:Ljava/lang/String;

    .line 12
    return-void
.end method


# virtual methods
.method public getStatusCode()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->statusCode:Ljava/lang/Integer;

    return-object v0
.end method

.method public getStatusMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->statusMessage:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 24
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->statusCode:Ljava/lang/Integer;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->statusMessage:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
