.class public Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private available:Ljava/lang/String;

.field private checkStoresLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckStoresLink;

.field private displayMessage:Ljava/lang/String;

.field private inStoreAvailability:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;


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
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->available:Ljava/lang/String;

    return-object v0
.end method

.method public getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/store/availability/CheckStoresLink;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckStoresLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    return-object v0
.end method

.method public setAvailable(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->available:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setCheckStoresLink(Lcom/bestbuy/android/api/lib/models/store/availability/CheckStoresLink;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckStoresLink;

    .line 43
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->displayMessage:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setInStoreAvailability(Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    .line 27
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 55
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClassPojo [inStoreAvailability = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", displayMessage = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->displayMessage:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", checkStoresLink = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckStoresLink;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", available = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->available:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
