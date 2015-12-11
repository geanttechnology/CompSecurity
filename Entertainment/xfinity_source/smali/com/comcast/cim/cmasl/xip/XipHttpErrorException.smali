.class public Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;
.super Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;
.source "XipHttpErrorException.java"


# instance fields
.field private final xipStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V
    .locals 0
    .param p1, "xipStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .param p2, "detailedRequestStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    .prologue
    .line 28
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;-><init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V

    .line 29
    iput-object p1, p0, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->xipStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    .line 30
    return-void
.end method

.method public static fromHttpResponse(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;
    .locals 8
    .param p0, "requestStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, "headerMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 47
    .local v1, "xipHeaderValue":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 48
    const-string v3, "X-xip-error"

    invoke-interface {p1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "xipHeaderValue":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 51
    .restart local v1    # "xipHeaderValue":Ljava/lang/String;
    :cond_0
    if-nez v1, :cond_1

    .line 53
    const/4 v3, 0x0

    .line 66
    :goto_0
    return-object v3

    .line 56
    :cond_1
    const/4 v0, -0x1

    .line 58
    .local v0, "xipErrorCode":I
    const-string v3, "XIP"

    invoke-virtual {v1, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 60
    :try_start_0
    const-string v3, "XIP"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 65
    :cond_2
    :goto_1
    new-instance v2, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const-string v4, "XIP Error %d. %s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static {v0}, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->getMessageForCode(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;-><init>(Ljava/lang/Integer;Ljava/lang/String;)V

    .line 66
    .local v2, "xipStatus":Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    new-instance v3, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    invoke-direct {v3, v2, p0}, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;-><init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V

    goto :goto_0

    .line 61
    .end local v2    # "xipStatus":Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    :catch_0
    move-exception v3

    goto :goto_1
.end method

.method private static getMessageForCode(I)Ljava/lang/String;
    .locals 1
    .param p0, "xipErrorCode"    # I

    .prologue
    .line 80
    packed-switch p0, :pswitch_data_0

    .line 92
    :pswitch_0
    const-string v0, "This request requires authentication."

    :goto_0
    return-object v0

    .line 82
    :pswitch_1
    const-string v0, "This request requires your time to be correct."

    goto :goto_0

    .line 84
    :pswitch_2
    const-string v0, "This device has not been provisioned."

    goto :goto_0

    .line 86
    :pswitch_3
    const-string v0, "The signature on the request was incorrect."

    goto :goto_0

    .line 88
    :pswitch_4
    const-string v0, "This request requires authentication."

    goto :goto_0

    .line 90
    :pswitch_5
    const-string v0, "The submitted login was not valid."

    goto :goto_0

    .line 80
    nop

    :pswitch_data_0
    .packed-switch 0xbb9
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_5
        :pswitch_0
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public getDetailedStatusCode()I
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->xipStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getStatusCodeForDisplay()I
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->xipStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getXipStatus()Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->xipStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    return-object v0
.end method
