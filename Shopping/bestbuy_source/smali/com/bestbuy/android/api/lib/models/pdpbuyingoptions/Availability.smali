.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersion:J = 0x1L


# instance fields
.field private pickup:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

.field private ship:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    return-object v0
.end method

.method public getShip()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->ship:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;

    return-object v0
.end method

.method public setPickup(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->pickup:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    .line 23
    return-void
.end method

.method public setShip(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->ship:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;

    .line 31
    return-void
.end method
