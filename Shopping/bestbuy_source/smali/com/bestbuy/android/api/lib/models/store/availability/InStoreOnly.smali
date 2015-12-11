.class public Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private available:Ljava/lang/String;

.field private inStoreAvailability:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailable()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;->available:Ljava/lang/String;

    return-object v0
.end method

.method public getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    return-object v0
.end method

.method public setAvailable(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;->available:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public setInStoreAvailability(Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;->inStoreAvailability:Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    .line 29
    return-void
.end method
