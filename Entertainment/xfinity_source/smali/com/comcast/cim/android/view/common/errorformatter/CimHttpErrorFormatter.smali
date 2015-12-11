.class public Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorFormatter;
.super Ljava/lang/Object;
.source "CimHttpErrorFormatter.java"

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

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorFormatter;->resources:Landroid/content/res/Resources;

    .line 14
    return-void
.end method

.method private getTitleForError(Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;
    .locals 3
    .param p1, "error"    # Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    .prologue
    .line 28
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v2, Lcom/comcast/cim/android/R$string;->dlg_title_error:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 29
    .local v0, "titlePrefix":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorFormatter;->titleBuilder:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    invoke-virtual {v1, v0, p1}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;->buildTitle(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 6
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    const/4 v3, 0x0

    .line 18
    instance-of v4, p1, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    if-nez v4, :cond_0

    .line 24
    :goto_0
    return-object v3

    :cond_0
    move-object v0, p1

    .line 21
    check-cast v0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    .line 22
    .local v0, "cimHttpException":Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;
    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorFormatter;->getTitleForError(Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;

    move-result-object v2

    .line 23
    .local v2, "title":Ljava/lang/String;
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v5, Lcom/comcast/cim/android/R$string;->alert_generic_error:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 24
    .local v1, "description":Ljava/lang/String;
    new-instance v4, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    const/4 v5, 0x1

    invoke-direct {v4, v2, v1, v3, v5}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    move-object v3, v4

    goto :goto_0
.end method
