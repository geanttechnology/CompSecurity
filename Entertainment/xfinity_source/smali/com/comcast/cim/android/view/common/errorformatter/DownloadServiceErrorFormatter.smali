.class public Lcom/comcast/cim/android/view/common/errorformatter/DownloadServiceErrorFormatter;
.super Ljava/lang/Object;
.source "DownloadServiceErrorFormatter.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;


# instance fields
.field private final resources:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>(Landroid/content/res/Resources;)V
    .locals 0
    .param p1, "resources"    # Landroid/content/res/Resources;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/errorformatter/DownloadServiceErrorFormatter;->resources:Landroid/content/res/Resources;

    .line 13
    return-void
.end method

.method private getDescriptionResourceForError(Lcom/comcast/cim/downloads/DownloadServiceException;)I
    .locals 1
    .param p1, "error"    # Lcom/comcast/cim/downloads/DownloadServiceException;

    .prologue
    .line 35
    instance-of v0, p1, Lcom/comcast/cim/downloads/MaxDownloadsReachedException;

    if-eqz v0, :cond_0

    .line 36
    sget v0, Lcom/comcast/cim/android/R$string;->max_downloads_allowed_message:I

    .line 38
    :goto_0
    return v0

    :cond_0
    sget v0, Lcom/comcast/cim/android/R$string;->alert_generic_error:I

    goto :goto_0
.end method

.method private getTitleForError(Lcom/comcast/cim/downloads/DownloadServiceException;)Ljava/lang/String;
    .locals 2
    .param p1, "error"    # Lcom/comcast/cim/downloads/DownloadServiceException;

    .prologue
    .line 27
    instance-of v0, p1, Lcom/comcast/cim/downloads/MaxDownloadsReachedException;

    if-eqz v0, :cond_0

    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/DownloadServiceErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v1, Lcom/comcast/cim/android/R$string;->max_downloads_allowed_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 30
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/DownloadServiceErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v1, Lcom/comcast/cim/android/R$string;->dlg_title_error:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 6
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    const/4 v3, 0x0

    .line 17
    instance-of v4, p1, Lcom/comcast/cim/downloads/DownloadServiceException;

    if-nez v4, :cond_0

    .line 23
    :goto_0
    return-object v3

    :cond_0
    move-object v1, p1

    .line 20
    check-cast v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    .line 21
    .local v1, "downloadError":Lcom/comcast/cim/downloads/DownloadServiceException;
    invoke-direct {p0, v1}, Lcom/comcast/cim/android/view/common/errorformatter/DownloadServiceErrorFormatter;->getTitleForError(Lcom/comcast/cim/downloads/DownloadServiceException;)Ljava/lang/String;

    move-result-object v2

    .line 22
    .local v2, "title":Ljava/lang/String;
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/errorformatter/DownloadServiceErrorFormatter;->resources:Landroid/content/res/Resources;

    invoke-direct {p0, v1}, Lcom/comcast/cim/android/view/common/errorformatter/DownloadServiceErrorFormatter;->getDescriptionResourceForError(Lcom/comcast/cim/downloads/DownloadServiceException;)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 23
    .local v0, "description":Ljava/lang/String;
    new-instance v4, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    const/4 v5, 0x0

    invoke-direct {v4, v2, v0, v3, v5}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    move-object v3, v4

    goto :goto_0
.end method
