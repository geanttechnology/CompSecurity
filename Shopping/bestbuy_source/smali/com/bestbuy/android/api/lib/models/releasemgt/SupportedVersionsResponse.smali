.class public Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x1e539b24352f6fb6L


# instance fields
.field private cancelButtonTitle:Ljava/lang/String;

.field private feedbackButtonTitle:Ljava/lang/String;

.field private si:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

.field private storeButtonTitle:Ljava/lang/String;

.field private storeLink:Ljava/lang/String;

.field private type:I

.field private updateButtonTitle:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCancelButtonTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->cancelButtonTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getFeedbackButtonTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->feedbackButtonTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getSi()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->si:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    return-object v0
.end method

.method public getStoreButtonTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->storeButtonTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->storeLink:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->type:I

    return v0
.end method

.method public getUpdateButtonTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->updateButtonTitle:Ljava/lang/String;

    return-object v0
.end method

.method public setCancelButtonTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->cancelButtonTitle:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public setFeedbackButtonTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 94
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->feedbackButtonTitle:Ljava/lang/String;

    .line 95
    return-void
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->si:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    .line 35
    return-void
.end method

.method public setStoreButtonTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->storeButtonTitle:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public setStoreLink(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->storeLink:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setType(I)V
    .locals 0

    .prologue
    .line 46
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->type:I

    .line 47
    return-void
.end method

.method public setUpdateButtonTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->updateButtonTitle:Ljava/lang/String;

    .line 107
    return-void
.end method
