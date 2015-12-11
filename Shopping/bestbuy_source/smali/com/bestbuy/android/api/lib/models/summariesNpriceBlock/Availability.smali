.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private delivery:Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;

.field private download:Lcom/bestbuy/android/api/lib/models/home/availability/Download;

.field private inStoreOnly:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;

.field private pickup:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

.field private ship:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDelivery()Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->delivery:Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;

    return-object v0
.end method

.method public getDownload()Lcom/bestbuy/android/api/lib/models/home/availability/Download;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->download:Lcom/bestbuy/android/api/lib/models/home/availability/Download;

    return-object v0
.end method

.method public getInStoreOnly()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->inStoreOnly:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;

    return-object v0
.end method

.method public getPickup()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    return-object v0
.end method

.method public getShip()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->ship:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;

    return-object v0
.end method

.method public setDelivery(Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->delivery:Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;

    .line 67
    return-void
.end method

.method public setDownload(Lcom/bestbuy/android/api/lib/models/home/availability/Download;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->download:Lcom/bestbuy/android/api/lib/models/home/availability/Download;

    .line 75
    return-void
.end method

.method public setInStoreOnly(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->inStoreOnly:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;

    .line 34
    return-void
.end method

.method public setPickup(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    .line 53
    return-void
.end method

.method public setShip(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->ship:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;

    .line 59
    return-void
.end method
