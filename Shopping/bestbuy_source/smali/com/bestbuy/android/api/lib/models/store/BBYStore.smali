.class public Lcom/bestbuy/android/api/lib/models/store/BBYStore;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private distance:Ljava/lang/String;

.field private skuAvailability:Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "availability"
    .end annotation
.end field

.field private storeDetails:Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

.field private storeId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "id"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->skuAvailability:Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    return-object v0
.end method

.method public getDistance()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->distance:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->storeDetails:Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    return-object v0
.end method

.method public getStoreId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->storeId:Ljava/lang/String;

    return-object v0
.end method

.method public setAvailability(Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->skuAvailability:Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    .line 54
    return-void
.end method

.method public setDistance(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->distance:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setStoreDetails(Lcom/bestbuy/android/api/lib/models/store/StoreDetails;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->storeDetails:Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    .line 46
    return-void
.end method

.method public setStoreId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->storeId:Ljava/lang/String;

    .line 30
    return-void
.end method
