.class public Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;
.super Ljava/lang/Object;
.source "AmsErrorFormatter.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;


# instance fields
.field private final resources:Landroid/content/res/Resources;

.field private final titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;


# direct methods
.method public constructor <init>(Landroid/content/res/Resources;)V
    .locals 1
    .param p1, "resources"    # Landroid/content/res/Resources;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    new-instance v0, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    invoke-direct {v0}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    .line 12
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;->resources:Landroid/content/res/Resources;

    .line 13
    return-void
.end method

.method private getDescriptionResourceForError(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)I
    .locals 2
    .param p1, "error"    # Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .prologue
    .line 43
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v0

    .line 44
    .local v0, "errorCode":I
    sparse-switch v0, :sswitch_data_0

    .line 67
    sget v1, Lcom/comcast/cim/android/R$string;->video_playback_generic_error:I

    :goto_0
    return v1

    .line 47
    :sswitch_0
    sget v1, Lcom/comcast/cim/android/R$string;->account_flagged_for_abuse:I

    goto :goto_0

    .line 49
    :sswitch_1
    sget v1, Lcom/comcast/cim/android/R$string;->video_max_registered_devices:I

    goto :goto_0

    .line 51
    :sswitch_2
    sget v1, Lcom/comcast/cim/android/R$string;->video_device_deactivated:I

    goto :goto_0

    .line 55
    :sswitch_3
    sget v1, Lcom/comcast/cim/android/R$string;->invalid_request_error:I

    goto :goto_0

    .line 57
    :sswitch_4
    sget v1, Lcom/comcast/cim/android/R$string;->entitlement_data_expired_error:I

    goto :goto_0

    .line 61
    :sswitch_5
    sget v1, Lcom/comcast/cim/android/R$string;->auth_request_denied_error:I

    goto :goto_0

    .line 63
    :sswitch_6
    sget v1, Lcom/comcast/cim/android/R$string;->max_registered_devices_message:I

    goto :goto_0

    .line 65
    :sswitch_7
    sget v1, Lcom/comcast/cim/android/R$string;->registration_rate_limit_reached_message:I

    goto :goto_0

    .line 44
    :sswitch_data_0
    .sparse-switch
        0x190 -> :sswitch_3
        0x195 -> :sswitch_5
        0x197 -> :sswitch_5
        0x199 -> :sswitch_3
        0x19a -> :sswitch_4
        0x19f -> :sswitch_0
        0x1a4 -> :sswitch_5
        0x1a8 -> :sswitch_3
        0x3e8 -> :sswitch_1
        0x3ef -> :sswitch_2
        0x76d -> :sswitch_0
        0x1f42 -> :sswitch_6
        0x1f43 -> :sswitch_7
    .end sparse-switch
.end method

.method private getTitleForError(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Ljava/lang/String;
    .locals 6
    .param p1, "error"    # Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .prologue
    .line 29
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getAmsRequestStatus()Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 37
    sget v0, Lcom/comcast/cim/android/R$string;->dlg_title_error:I

    .line 39
    .local v0, "titlePrefixResource":I
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    iget-object v2, p0, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;->resources:Landroid/content/res/Resources;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getStatusCodeForDisplay()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v2, v0, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p1}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;->buildTitle(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 31
    .end local v0    # "titlePrefixResource":I
    :pswitch_0
    sget v0, Lcom/comcast/cim/android/R$string;->max_registered_devices_title:I

    .line 32
    .restart local v0    # "titlePrefixResource":I
    goto :goto_0

    .line 34
    .end local v0    # "titlePrefixResource":I
    :pswitch_1
    sget v0, Lcom/comcast/cim/android/R$string;->registration_rate_limit_reached_title:I

    .line 35
    .restart local v0    # "titlePrefixResource":I
    goto :goto_0

    .line 29
    :pswitch_data_0
    .packed-switch 0x1f42
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private isOriginalOperationRetryable(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Z
    .locals 2
    .param p1, "error"    # Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .prologue
    .line 72
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v0

    .line 73
    .local v0, "errorCode":I
    sparse-switch v0, :sswitch_data_0

    .line 89
    const/4 v1, 0x1

    :goto_0
    return v1

    .line 83
    :sswitch_0
    const/4 v1, 0x0

    goto :goto_0

    .line 73
    nop

    :sswitch_data_0
    .sparse-switch
        0x195 -> :sswitch_0
        0x197 -> :sswitch_0
        0x19a -> :sswitch_0
        0x19f -> :sswitch_0
        0x1a4 -> :sswitch_0
        0x3e8 -> :sswitch_0
        0x3ef -> :sswitch_0
        0x76d -> :sswitch_0
        0x1f42 -> :sswitch_0
    .end sparse-switch
.end method


# virtual methods
.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 10
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    const/4 v4, 0x0

    .line 17
    instance-of v5, p1, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    if-nez v5, :cond_0

    .line 24
    :goto_0
    return-object v4

    :cond_0
    move-object v0, p1

    .line 20
    check-cast v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .line 21
    .local v0, "amsError":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;->getTitleForError(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Ljava/lang/String;

    move-result-object v3

    .line 22
    .local v3, "title":Ljava/lang/String;
    iget-object v5, p0, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;->resources:Landroid/content/res/Resources;

    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;->getDescriptionResourceForError(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)I

    move-result v6

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getStatusCodeForDisplay()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v5, v6, v7}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 23
    .local v1, "description":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;->isOriginalOperationRetryable(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Z

    move-result v2

    .line 24
    .local v2, "retryable":Z
    new-instance v5, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    invoke-direct {v5, v3, v1, v4, v2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    move-object v4, v5

    goto :goto_0
.end method
