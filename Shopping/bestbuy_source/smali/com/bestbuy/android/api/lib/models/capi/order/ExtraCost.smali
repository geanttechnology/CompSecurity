.class public Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private amount:D

.field private description:Ljava/lang/String;

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAmount()D
    .locals 2

    .prologue
    .line 24
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;->amount:D

    return-wide v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;->type:Ljava/lang/String;

    return-object v0
.end method

.method public loadData(Ljava/lang/String;Ljava/lang/String;D)Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;
    .locals 1

    .prologue
    .line 28
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;-><init>()V

    .line 29
    iput-object p1, v0, Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;->type:Ljava/lang/String;

    .line 30
    iput-object p2, v0, Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;->description:Ljava/lang/String;

    .line 31
    iput-wide p3, v0, Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;->amount:D

    .line 32
    return-object v0
.end method
