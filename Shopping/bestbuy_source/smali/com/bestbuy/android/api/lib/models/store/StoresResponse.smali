.class public Lcom/bestbuy/android/api/lib/models/store/StoresResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/store/Si;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/store/Si;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoresResponse;->si:Lcom/bestbuy/android/api/lib/models/store/Si;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/store/Si;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoresResponse;->si:Lcom/bestbuy/android/api/lib/models/store/Si;

    .line 25
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 30
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClassPojo [si = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/StoresResponse;->si:Lcom/bestbuy/android/api/lib/models/store/Si;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
