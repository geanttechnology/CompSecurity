.class public Lcom/bestbuy/android/api/lib/models/remix/StoreList;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Iterable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Iterable",
        "<",
        "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
        ">;"
    }
.end annotation


# instance fields
.field private hasNext:Z

.field private stores:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private totalStores:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getStores()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->stores:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTotalStores()I
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->totalStores:I

    return v0
.end method

.method public isHasNext()Z
    .locals 1

    .prologue
    .line 20
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->hasNext:Z

    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->stores:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 49
    return-object v0
.end method

.method public setHasNext(Z)V
    .locals 0

    .prologue
    .line 24
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->hasNext:Z

    .line 25
    return-void
.end method

.method public setStores(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->stores:Ljava/util/ArrayList;

    .line 33
    return-void
.end method

.method public setTotalStores(I)V
    .locals 0

    .prologue
    .line 40
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->totalStores:I

    .line 41
    return-void
.end method
