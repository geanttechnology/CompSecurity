.class public Lcom/bestbuy/android/api/lib/models/store/Response;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private next:Ljava/lang/String;

.field private stores:[Lcom/bestbuy/android/api/lib/models/store/BBYStore;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getNext()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Response;->next:Ljava/lang/String;

    return-object v0
.end method

.method public getStores()[Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Response;->stores:[Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    return-object v0
.end method

.method public setNext(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Response;->next:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setStores([Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Response;->stores:[Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 37
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 42
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClassPojo [next = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Response;->next:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", stores = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Response;->stores:[Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
