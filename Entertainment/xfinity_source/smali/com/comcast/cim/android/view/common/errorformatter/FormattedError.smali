.class public Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
.super Ljava/lang/Object;
.source "FormattedError.java"


# instance fields
.field private final description:Ljava/lang/String;

.field private final failedOperationRetryable:Z

.field private final moreInfo:Ljava/lang/String;

.field private final title:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "moreInfo"    # Ljava/lang/String;
    .param p4, "failedOperationRetryable"    # Z

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->title:Ljava/lang/String;

    .line 11
    iput-object p2, p0, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->description:Ljava/lang/String;

    .line 12
    iput-object p3, p0, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->moreInfo:Ljava/lang/String;

    .line 13
    iput-boolean p4, p0, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->failedOperationRetryable:Z

    .line 14
    return-void
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getMoreInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->moreInfo:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->title:Ljava/lang/String;

    return-object v0
.end method

.method public isFailedOperationRetryable()Z
    .locals 1

    .prologue
    .line 29
    iget-boolean v0, p0, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->failedOperationRetryable:Z

    return v0
.end method
