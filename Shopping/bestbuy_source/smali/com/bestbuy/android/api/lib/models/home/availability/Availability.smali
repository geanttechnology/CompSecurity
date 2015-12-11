.class public Lcom/bestbuy/android/api/lib/models/home/availability/Availability;
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

.field private pickup:Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;

.field private ship:Lcom/bestbuy/android/api/lib/models/home/availability/Ship;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDelivery()Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->delivery:Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;

    return-object v0
.end method

.method public getDownload()Lcom/bestbuy/android/api/lib/models/home/availability/Download;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->download:Lcom/bestbuy/android/api/lib/models/home/availability/Download;

    return-object v0
.end method

.method public getPickup()Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;

    return-object v0
.end method

.method public getShip()Lcom/bestbuy/android/api/lib/models/home/availability/Ship;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->ship:Lcom/bestbuy/android/api/lib/models/home/availability/Ship;

    return-object v0
.end method

.method public setDelivery(Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->delivery:Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;

    .line 37
    return-void
.end method

.method public setDownload(Lcom/bestbuy/android/api/lib/models/home/availability/Download;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->download:Lcom/bestbuy/android/api/lib/models/home/availability/Download;

    .line 29
    return-void
.end method

.method public setPickup(Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;

    .line 45
    return-void
.end method

.method public setShip(Lcom/bestbuy/android/api/lib/models/home/availability/Ship;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->ship:Lcom/bestbuy/android/api/lib/models/home/availability/Ship;

    .line 53
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 57
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClassPojo [pickup = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", ship = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Availability;->ship:Lcom/bestbuy/android/api/lib/models/home/availability/Ship;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
