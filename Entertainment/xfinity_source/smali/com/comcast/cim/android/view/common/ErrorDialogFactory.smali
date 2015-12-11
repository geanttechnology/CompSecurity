.class public Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
.super Ljava/lang/Object;
.source "ErrorDialogFactory.java"


# instance fields
.field private final errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private final resources:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Landroid/content/res/Resources;)V
    .locals 0
    .param p1, "errorFormatter"    # Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    .param p2, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .param p3, "resources"    # Landroid/content/res/Resources;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p2, p0, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 19
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 20
    iput-object p3, p0, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->resources:Landroid/content/res/Resources;

    .line 21
    return-void
.end method


# virtual methods
.method public createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .locals 1
    .param p1, "error"    # Ljava/lang/Throwable;
    .param p2, "tryAgainListener"    # Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    invoke-interface {v0, p1}, Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p2}, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    return-object v0
.end method

.method public createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .locals 5
    .param p1, "error"    # Ljava/lang/Throwable;
    .param p2, "formatted"    # Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .param p3, "tryAgainListener"    # Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;

    .prologue
    .line 29
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 30
    invoke-static {p3}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 33
    .local v0, "args":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v2

    if-nez v2, :cond_2

    .line 34
    const-string v2, "tag"

    const-string v3, "errorDlgRetryable"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    const-string v2, "title"

    iget-object v3, p0, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->resources:Landroid/content/res/Resources;

    sget v4, Lcom/comcast/cim/android/R$string;->dlg_title_error:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    const-string v2, "description"

    iget-object v3, p0, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->resources:Landroid/content/res/Resources;

    sget v4, Lcom/comcast/cim/android/R$string;->ALERT_INTERNET_UNREACHABLE:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    .end local p1    # "error":Ljava/lang/Throwable;
    :cond_0
    :goto_0
    new-instance v1, Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-direct {v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;-><init>()V

    .line 53
    .local v1, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 54
    invoke-virtual {p2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->isFailedOperationRetryable()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 55
    invoke-virtual {v1, p3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setTryAgainListener(Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)V

    .line 57
    :cond_1
    return-object v1

    .line 38
    .end local v1    # "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .restart local p1    # "error":Ljava/lang/Throwable;
    :cond_2
    instance-of v2, p1, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    if-eqz v2, :cond_3

    check-cast p1, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    .end local p1    # "error":Ljava/lang/Throwable;
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->getDetailedStatusCode()I

    move-result v2

    const/16 v3, 0xbb9

    if-ne v2, v3, :cond_3

    .line 39
    const-string v2, "tag"

    const-string v3, "errorDlgXipProvisioning"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    :goto_1
    const-string v2, "title"

    invoke-virtual {p2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    const-string v2, "description"

    invoke-virtual {p2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getDescription()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    invoke-virtual {p2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getMoreInfo()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 48
    const-string v2, "additionalInfo"

    invoke-virtual {p2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getMoreInfo()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 40
    :cond_3
    invoke-virtual {p2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->isFailedOperationRetryable()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 41
    const-string v2, "tag"

    const-string v3, "errorDlgRetryable"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 43
    :cond_4
    const-string v2, "tag"

    const-string v3, "errorDlg"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
