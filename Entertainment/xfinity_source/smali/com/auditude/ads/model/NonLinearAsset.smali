.class public Lcom/auditude/ads/model/NonLinearAsset;
.super Lcom/auditude/ads/model/Asset;
.source "NonLinearAsset.java"

# interfaces
.implements Lcom/auditude/ads/model/INonLinearAsset;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/model/BaseElement;)V
    .locals 0
    .param p1, "parent"    # Lcom/auditude/ads/model/BaseElement;

    .prologue
    .line 7
    invoke-direct {p0, p1}, Lcom/auditude/ads/model/Asset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 8
    return-void
.end method


# virtual methods
.method public CopyTo(Lcom/auditude/ads/model/Asset;)V
    .locals 1
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;

    .prologue
    .line 19
    invoke-super {p0, p1}, Lcom/auditude/ads/model/Asset;->CopyTo(Lcom/auditude/ads/model/Asset;)V

    .line 21
    if-eqz p1, :cond_0

    .line 23
    invoke-virtual {p0}, Lcom/auditude/ads/model/NonLinearAsset;->getDurationInMillis()I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setDurationInMillis(I)V

    .line 24
    invoke-virtual {p0}, Lcom/auditude/ads/model/NonLinearAsset;->getLeadTimeInMillis()I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setLeadTimeInMillis(I)V

    .line 26
    :cond_0
    return-void
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    const-string v0, "nonlinear"

    return-object v0
.end method
