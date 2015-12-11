.class public Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;
.super Ljava/lang/Object;
.source "GenericErrorFormatter.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;


# instance fields
.field private final resources:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>(Landroid/content/res/Resources;)V
    .locals 0
    .param p1, "resources"    # Landroid/content/res/Resources;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;->resources:Landroid/content/res/Resources;

    .line 17
    return-void
.end method

.method private getDescriptionResourceForError(Ljava/lang/Throwable;)I
    .locals 1
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 44
    instance-of v0, p1, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;->isNetworkError(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 45
    sget v0, Lcom/comcast/cim/android/R$string;->network_connection_error_message:I

    .line 47
    :goto_0
    return v0

    :cond_0
    sget v0, Lcom/comcast/cim/android/R$string;->alert_generic_error:I

    goto :goto_0
.end method

.method private getMoreInfoForError(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 9
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 52
    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 53
    .local v0, "cause":Ljava/lang/Throwable;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 54
    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 68
    :cond_0
    :goto_0
    return-object v2

    .line 56
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 57
    .local v2, "message":Ljava/lang/String;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    if-gtz v5, :cond_0

    .line 61
    :cond_2
    const-string v4, ""

    .line 63
    .local v4, "stackTraceString":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v3

    .line 64
    .local v3, "stackTrace":[Ljava/lang/StackTraceElement;
    array-length v6, v3

    const/4 v5, 0x0

    :goto_1
    if-ge v5, v6, :cond_3

    aget-object v1, v3, v5

    .line 65
    .local v1, "element":Ljava/lang/StackTraceElement;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 64
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .end local v1    # "element":Ljava/lang/StackTraceElement;
    :cond_3
    move-object v2, v4

    .line 68
    goto :goto_0
.end method

.method private getTitleForError(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 2
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 36
    instance-of v0, p1, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;->isNetworkError(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 37
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v1, Lcom/comcast/cim/android/R$string;->network_connection_error_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 39
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v1, Lcom/comcast/cim/android/R$string;->dlg_title_error:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 5
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;->getTitleForError(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    .line 22
    .local v2, "title":Ljava/lang/String;
    iget-object v3, p0, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;->resources:Landroid/content/res/Resources;

    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;->getDescriptionResourceForError(Ljava/lang/Throwable;)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 23
    .local v0, "description":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;->getMoreInfoForError(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    .line 24
    .local v1, "moreInfo":Ljava/lang/String;
    new-instance v3, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    const/4 v4, 0x1

    invoke-direct {v3, v2, v0, v1, v4}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    return-object v3
.end method

.method public isNetworkError(Ljava/lang/Throwable;)Z
    .locals 2
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 28
    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 29
    .local v0, "cause":Ljava/lang/Throwable;
    if-eqz v0, :cond_1

    instance-of v1, v0, Ljava/net/SocketTimeoutException;

    if-nez v1, :cond_0

    instance-of v1, v0, Ljava/net/UnknownHostException;

    if-nez v1, :cond_0

    instance-of v1, v0, Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectTimeoutException;

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
