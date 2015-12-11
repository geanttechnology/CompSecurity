.class public Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field public static final HARD_UPDATE:I = 0x64

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private cancelButtonTitle:Ljava/lang/String;

.field private dialog:Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;

.field private feedbackButtonTitle:Ljava/lang/String;

.field private storeButtonTitle:Ljava/lang/String;

.field private storeLink:Ljava/lang/String;

.field private type:I

.field private updateButtonTitle:Ljava/lang/String;

.field private version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCancelButtonTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->cancelButtonTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getDialog()Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->dialog:Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;

    return-object v0
.end method

.method public getFeedbackButtonTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->feedbackButtonTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreButtonTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->storeButtonTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->storeLink:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->type:I

    return v0
.end method

.method public getUpdateButtonTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->updateButtonTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setCancelButtonTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->cancelButtonTitle:Ljava/lang/String;

    .line 123
    return-void
.end method

.method public setDialog(Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;)V
    .locals 0

    .prologue
    .line 165
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->dialog:Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;

    .line 166
    return-void
.end method

.method public setFeedbackButtonTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->feedbackButtonTitle:Ljava/lang/String;

    .line 137
    return-void
.end method

.method public setStoreButtonTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->storeButtonTitle:Ljava/lang/String;

    .line 109
    return-void
.end method

.method public setStoreLink(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 94
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->storeLink:Ljava/lang/String;

    .line 95
    return-void
.end method

.method public setType(I)V
    .locals 0

    .prologue
    .line 80
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->type:I

    .line 81
    return-void
.end method

.method public setUpdateButtonTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->updateButtonTitle:Ljava/lang/String;

    .line 151
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/AppDetail;->version:Ljava/lang/String;

    .line 67
    return-void
.end method
