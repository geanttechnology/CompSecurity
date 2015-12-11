.class public Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
.super Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;
.source "AmsHttpErrorException.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;
    }
.end annotation


# instance fields
.field private final amsRequestStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V
    .locals 0
    .param p1, "requestStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .param p2, "amsRequestStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    .prologue
    .line 104
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;-><init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V

    .line 105
    iput-object p2, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->amsRequestStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    .line 106
    return-void
.end method

.method public static fromHttpStatusAndAMSStatus(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    .locals 3
    .param p0, "httpStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .param p1, "amsStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    .prologue
    .line 113
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    .line 114
    .local v0, "detailedStatusCode":Ljava/lang/Integer;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/16 v2, 0xc8

    if-eq v1, v2, :cond_0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/16 v2, 0xc9

    if-ne v1, v2, :cond_1

    .line 117
    :cond_0
    const/4 v1, 0x0

    .line 119
    :goto_0
    return-object v1

    :cond_1
    new-instance v1, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;-><init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V

    goto :goto_0
.end method

.method public static getPlayerActionForException(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;
    .locals 1
    .param p0, "e"    # Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .prologue
    .line 124
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 191
    sget-object v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->INCREMENT:Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    :goto_0
    return-object v0

    .line 152
    :sswitch_0
    sget-object v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->STOP:Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    goto :goto_0

    .line 124
    nop

    :sswitch_data_0
    .sparse-switch
        0x195 -> :sswitch_0
        0x197 -> :sswitch_0
        0x199 -> :sswitch_0
        0x19c -> :sswitch_0
        0x19d -> :sswitch_0
        0x19f -> :sswitch_0
        0x1a1 -> :sswitch_0
        0x1a4 -> :sswitch_0
        0x3e8 -> :sswitch_0
        0x3ea -> :sswitch_0
        0x3ee -> :sswitch_0
        0x3ef -> :sswitch_0
        0x3f0 -> :sswitch_0
        0x44d -> :sswitch_0
        0x44e -> :sswitch_0
        0x44f -> :sswitch_0
        0x451 -> :sswitch_0
        0x76d -> :sswitch_0
        0x7d0 -> :sswitch_0
        0x7d2 -> :sswitch_0
        0xfa5 -> :sswitch_0
        0xfa9 -> :sswitch_0
        0x13c5 -> :sswitch_0
        0x1773 -> :sswitch_0
        0x1774 -> :sswitch_0
        0x1775 -> :sswitch_0
        0x1776 -> :sswitch_0
    .end sparse-switch
.end method


# virtual methods
.method public getAmsRequestStatus()Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->amsRequestStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    return-object v0
.end method

.method public getDetailedStatusCode()I
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->amsRequestStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getStatusCodeForDisplay()I
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->amsRequestStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method
