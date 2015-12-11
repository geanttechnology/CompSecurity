.class public Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;
.super Ljava/lang/Object;
.source "PlayerAmsErrorFormatter.java"

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
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    invoke-direct {v0}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;->resources:Landroid/content/res/Resources;

    .line 17
    return-void
.end method

.method private getDescriptionResourceForError(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Ljava/lang/Integer;
    .locals 2
    .param p1, "error"    # Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .prologue
    .line 52
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v0

    .line 53
    .local v0, "errorCode":I
    sparse-switch v0, :sswitch_data_0

    .line 68
    const/4 v1, 0x0

    :goto_0
    return-object v1

    .line 55
    :sswitch_0
    sget v1, Lcom/xfinity/playerlib/R$string;->video_max_per_household_streams:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0

    .line 57
    :sswitch_1
    sget v1, Lcom/xfinity/playerlib/R$string;->video_max_per_household_streams_another_user:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0

    .line 59
    :sswitch_2
    sget v1, Lcom/xfinity/playerlib/R$string;->video_playback_session_expired:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0

    .line 61
    :sswitch_3
    sget v1, Lcom/xfinity/playerlib/R$string;->video_playback_error_msg_default:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0

    .line 66
    :sswitch_4
    sget v1, Lcom/xfinity/playerlib/R$string;->auth_server_error:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0

    .line 53
    :sswitch_data_0
    .sparse-switch
        0x19a -> :sswitch_3
        0x44d -> :sswitch_0
        0x44e -> :sswitch_2
        0x44f -> :sswitch_1
        0x1004 -> :sswitch_4
        0x1005 -> :sswitch_4
        0x1007 -> :sswitch_4
        0x100c -> :sswitch_4
    .end sparse-switch
.end method

.method private isOriginalOperationRetryable(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Z
    .locals 1
    .param p1, "amsError"    # Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .prologue
    .line 36
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 47
    const/4 v0, 0x1

    :goto_0
    return v0

    .line 41
    :sswitch_0
    const/4 v0, 0x0

    goto :goto_0

    .line 36
    nop

    :sswitch_data_0
    .sparse-switch
        0x19a -> :sswitch_0
        0x44d -> :sswitch_0
        0x44e -> :sswitch_0
        0x44f -> :sswitch_0
    .end sparse-switch
.end method


# virtual methods
.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 11
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    const/4 v4, 0x0

    .line 21
    instance-of v5, p1, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    if-nez v5, :cond_1

    .line 31
    :cond_0
    :goto_0
    return-object v4

    :cond_1
    move-object v0, p1

    .line 24
    check-cast v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .line 25
    .local v0, "amsError":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;->getDescriptionResourceForError(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Ljava/lang/Integer;

    move-result-object v1

    .line 26
    .local v1, "descriptionResource":Ljava/lang/Integer;
    if-eqz v1, :cond_0

    .line 27
    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;->isOriginalOperationRetryable(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Z

    move-result v2

    .line 28
    .local v2, "retryable":Z
    iget-object v5, p0, Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    iget-object v6, p0, Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v7, Lcom/xfinity/playerlib/R$string;->dlg_title_error:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6, v0}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;->buildTitle(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;

    move-result-object v3

    .line 29
    .local v3, "title":Ljava/lang/String;
    new-instance v5, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    iget-object v6, p0, Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;->resources:Landroid/content/res/Resources;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v7

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getStatusCodeForDisplay()I

    move-result v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-virtual {v6, v7, v8}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v3, v6, v4, v2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    move-object v4, v5

    goto :goto_0
.end method
