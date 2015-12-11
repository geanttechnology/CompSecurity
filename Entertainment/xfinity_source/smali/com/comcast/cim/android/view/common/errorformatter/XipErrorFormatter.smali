.class public Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;
.super Ljava/lang/Object;
.source "XipErrorFormatter.java"

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
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    new-instance v0, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    invoke-direct {v0}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;->resources:Landroid/content/res/Resources;

    .line 14
    return-void
.end method

.method private getDescriptionResourceForError(Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;)I
    .locals 2
    .param p1, "error"    # Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    .prologue
    .line 34
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->getDetailedStatusCode()I

    move-result v0

    .line 35
    .local v0, "errorCode":I
    sparse-switch v0, :sswitch_data_0

    .line 44
    sget v1, Lcom/comcast/cim/android/R$string;->alert_generic_error:I

    :goto_0
    return v1

    .line 37
    :sswitch_0
    sget v1, Lcom/comcast/cim/android/R$string;->video_auth_incorrect_clock_error:I

    goto :goto_0

    .line 42
    :sswitch_1
    sget v1, Lcom/comcast/cim/android/R$string;->ALERT_CONSUMER_KEY_LOGGED_OUT:I

    goto :goto_0

    .line 35
    :sswitch_data_0
    .sparse-switch
        0xbb9 -> :sswitch_1
        0xbc1 -> :sswitch_0
    .end sparse-switch
.end method

.method private getTitleForError(Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;
    .locals 6
    .param p1, "error"    # Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    .prologue
    .line 29
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v2, Lcom/comcast/cim/android/R$string;->dlg_title_error:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->getStatusCodeForDisplay()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 30
    .local v0, "titlePrefix":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    invoke-virtual {v1, v0, p1}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;->buildTitle(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private isOriginalOperationRetryable(Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;)Z
    .locals 2
    .param p1, "error"    # Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    .prologue
    .line 49
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->getDetailedStatusCode()I

    move-result v0

    .line 50
    .local v0, "errorCode":I
    sparse-switch v0, :sswitch_data_0

    .line 55
    const/4 v1, 0x1

    :goto_0
    return v1

    .line 53
    :sswitch_0
    const/4 v1, 0x0

    goto :goto_0

    .line 50
    nop

    :sswitch_data_0
    .sparse-switch
        0xbb9 -> :sswitch_0
        0xbc1 -> :sswitch_0
    .end sparse-switch
.end method


# virtual methods
.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 7
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    const/4 v4, 0x0

    .line 18
    instance-of v5, p1, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    if-nez v5, :cond_0

    .line 25
    :goto_0
    return-object v4

    :cond_0
    move-object v3, p1

    .line 21
    check-cast v3, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    .line 22
    .local v3, "xipError":Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;
    invoke-direct {p0, v3}, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;->getTitleForError(Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;

    move-result-object v2

    .line 23
    .local v2, "title":Ljava/lang/String;
    iget-object v5, p0, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;->resources:Landroid/content/res/Resources;

    invoke-direct {p0, v3}, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;->getDescriptionResourceForError(Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 24
    .local v0, "description":Ljava/lang/String;
    invoke-direct {p0, v3}, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;->isOriginalOperationRetryable(Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;)Z

    move-result v1

    .line 25
    .local v1, "retryable":Z
    new-instance v5, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    invoke-direct {v5, v2, v0, v4, v1}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    move-object v4, v5

    goto :goto_0
.end method
