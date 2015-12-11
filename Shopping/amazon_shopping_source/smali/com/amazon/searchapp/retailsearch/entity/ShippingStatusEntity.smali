.class public Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ShippingStatusEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;


# instance fields
.field private badgeAssetId:Ljava/lang/String;

.field private freeRentalLabel:Ljava/lang/String;

.field private hasBadge:Z

.field private hasFreeRental:Z

.field private message:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getBadgeAssetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->badgeAssetId:Ljava/lang/String;

    return-object v0
.end method

.method public getFreeRentalLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->freeRentalLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getHasBadge()Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->hasBadge:Z

    return v0
.end method

.method public getHasFreeRental()Z
    .locals 1

    .prologue
    .line 93
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->hasFreeRental:Z

    return v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->message:Ljava/lang/String;

    return-object v0
.end method

.method public setBadgeAssetId(Ljava/lang/String;)V
    .locals 0
    .param p1, "badgeAssetId"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->badgeAssetId:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setFreeRentalLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "freeRentalLabel"    # Ljava/lang/String;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->freeRentalLabel:Ljava/lang/String;

    .line 124
    return-void
.end method

.method public setHasBadge(Z)V
    .locals 0
    .param p1, "hasBadge"    # Z

    .prologue
    .line 43
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->hasBadge:Z

    .line 44
    return-void
.end method

.method public setHasFreeRental(Z)V
    .locals 0
    .param p1, "hasFreeRental"    # Z

    .prologue
    .line 103
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->hasFreeRental:Z

    .line 104
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;->message:Ljava/lang/String;

    .line 64
    return-void
.end method
