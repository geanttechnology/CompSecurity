.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private available:Z

.field private checkStoresLink:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

.field private displayMessage:Ljava/lang/String;

.field private inStoreAvailability:Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    return-object v0
.end method

.method public isAvailable()Z
    .locals 1

    .prologue
    .line 49
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->available:Z

    return v0
.end method

.method public setAvailable(Z)V
    .locals 0

    .prologue
    .line 54
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->available:Z

    .line 55
    return-void
.end method

.method public setCheckStoresLink(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    .line 31
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->displayMessage:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setInStoreAvailability(Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    .line 63
    return-void
.end method
