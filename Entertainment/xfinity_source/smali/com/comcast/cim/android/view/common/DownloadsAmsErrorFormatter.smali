.class public Lcom/comcast/cim/android/view/common/DownloadsAmsErrorFormatter;
.super Ljava/lang/Object;
.source "DownloadsAmsErrorFormatter.java"

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

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/DownloadsAmsErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/DownloadsAmsErrorFormatter;->resources:Landroid/content/res/Resources;

    .line 17
    return-void
.end method

.method private getDescriptionResourceForError(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Ljava/lang/Integer;
    .locals 2
    .param p1, "error"    # Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .prologue
    .line 35
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v0

    .line 36
    .local v0, "errorCode":I
    packed-switch v0, :pswitch_data_0

    .line 43
    :pswitch_0
    const/4 v1, 0x0

    :goto_0
    return-object v1

    .line 41
    :pswitch_1
    sget v1, Lcom/xfinity/playerlib/R$string;->download_generic_error_message:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0

    .line 36
    :pswitch_data_0
    .packed-switch 0x1004
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 10
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    const/4 v9, 0x0

    const/4 v3, 0x0

    .line 21
    instance-of v4, p1, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    if-nez v4, :cond_1

    .line 30
    :cond_0
    :goto_0
    return-object v3

    :cond_1
    move-object v0, p1

    .line 24
    check-cast v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .line 25
    .local v0, "amsError":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/DownloadsAmsErrorFormatter;->getDescriptionResourceForError(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Ljava/lang/Integer;

    move-result-object v1

    .line 26
    .local v1, "descriptionResource":Ljava/lang/Integer;
    if-eqz v1, :cond_0

    .line 27
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/DownloadsAmsErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    iget-object v5, p0, Lcom/comcast/cim/android/view/common/DownloadsAmsErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v6, Lcom/xfinity/playerlib/R$string;->dlg_title_error:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v0}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;->buildTitle(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;

    move-result-object v2

    .line 28
    .local v2, "title":Ljava/lang/String;
    new-instance v4, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    iget-object v5, p0, Lcom/comcast/cim/android/view/common/DownloadsAmsErrorFormatter;->resources:Landroid/content/res/Resources;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v6

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getStatusCodeForDisplay()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-virtual {v5, v6, v7}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v2, v5, v3, v9}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    move-object v3, v4

    goto :goto_0
.end method
