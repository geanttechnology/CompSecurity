.class public Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;
.super Ljava/lang/Object;
.source "CimHttpErrorTitleBuilder.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public buildTitle(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;
    .locals 2
    .param p1, "titlePrefix"    # Ljava/lang/String;
    .param p2, "error"    # Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    .prologue
    .line 7
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0, p2}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;->getTitleSuffixForThrowable(Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitleSuffixForThrowable(Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;
    .locals 4
    .param p1, "error"    # Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    .prologue
    .line 11
    const-string v0, " :: %d"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->getStatusCodeForDisplay()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
