.class public Lcom/bestbuy/android/api/lib/models/store/availability/Availability;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private delivery:Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;

.field private download:Lcom/bestbuy/android/api/lib/models/store/availability/Download;

.field private inStoreOnly:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;

.field private pickup:Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

.field private ship:Lcom/bestbuy/android/api/lib/models/store/availability/Ship;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDelivery()Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->delivery:Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;

    return-object v0
.end method

.method public getDownload()Lcom/bestbuy/android/api/lib/models/store/availability/Download;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->download:Lcom/bestbuy/android/api/lib/models/store/availability/Download;

    return-object v0
.end method

.method public getInStoreOnly()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->inStoreOnly:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;

    return-object v0
.end method

.method public getPickup()Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    return-object v0
.end method

.method public getShip()Lcom/bestbuy/android/api/lib/models/store/availability/Ship;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->ship:Lcom/bestbuy/android/api/lib/models/store/availability/Ship;

    return-object v0
.end method

.method public setDelivery(Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->delivery:Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;

    .line 47
    return-void
.end method

.method public setDownload(Lcom/bestbuy/android/api/lib/models/store/availability/Download;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->download:Lcom/bestbuy/android/api/lib/models/store/availability/Download;

    .line 39
    return-void
.end method

.method public setInStoreOnly(Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->inStoreOnly:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;

    .line 31
    return-void
.end method

.method public setPickup(Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    .line 55
    return-void
.end method

.method public setShip(Lcom/bestbuy/android/api/lib/models/store/availability/Ship;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->ship:Lcom/bestbuy/android/api/lib/models/store/availability/Ship;

    .line 63
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 67
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClassPojo [pickup = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", ship = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->ship:Lcom/bestbuy/android/api/lib/models/store/availability/Ship;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
