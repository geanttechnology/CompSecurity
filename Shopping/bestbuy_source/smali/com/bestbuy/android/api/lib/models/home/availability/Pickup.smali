.class public Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private available:Ljava/lang/String;

.field private checkStoresLink:Lcom/bestbuy/android/api/lib/models/home/availability/CheckStoresLink;

.field private displayMessage:Ljava/lang/String;

.field private inStoreAvailability:Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailable()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->available:Ljava/lang/String;

    return-object v0
.end method

.method public getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/home/availability/CheckStoresLink;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/home/availability/CheckStoresLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    return-object v0
.end method

.method public setAvailable(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->available:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setCheckStoresLink(Lcom/bestbuy/android/api/lib/models/home/availability/CheckStoresLink;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/home/availability/CheckStoresLink;

    .line 44
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->displayMessage:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setInStoreAvailability(Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    .line 28
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 56
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClassPojo [inStoreAvailability = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", displayMessage = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->displayMessage:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", checkStoresLink = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/home/availability/CheckStoresLink;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", available = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Pickup;->available:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
