.class public final Lawh;
.super Ljava/lang/Object;

# interfaces
.implements Latr;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(Lqm;Latt;[Landroid/content/IntentFilter;)Lqq;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Latt;",
            "[",
            "Landroid/content/IntentFilter;",
            ")",
            "Lqq",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation

    new-instance v0, Lawi;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, p3, v1}, Lawi;-><init>(Lqm;Latt;[Landroid/content/IntentFilter;Lawh$1;)V

    invoke-interface {p1, v0}, Lqm;->a(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method

.method private a(Lcom/google/android/gms/wearable/Asset;)V
    .locals 2

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "asset is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p1}, Lcom/google/android/gms/wearable/Asset;->b()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "invalid asset"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {p1}, Lcom/google/android/gms/wearable/Asset;->a()[B

    move-result-object v0

    if-eqz v0, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "invalid asset"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    return-void
.end method


# virtual methods
.method public a(Lqm;Latt;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Latt;",
            ")",
            "Lqq",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lawh;->a(Lqm;Latt;[Landroid/content/IntentFilter;)Lqq;

    move-result-object v0

    return-object v0
.end method

.method public a(Lqm;Lcom/google/android/gms/wearable/Asset;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Lcom/google/android/gms/wearable/Asset;",
            ")",
            "Lqq",
            "<",
            "Latu;",
            ">;"
        }
    .end annotation

    invoke-direct {p0, p2}, Lawh;->a(Lcom/google/android/gms/wearable/Asset;)V

    new-instance v0, Lawh$2;

    invoke-direct {v0, p0, p1, p2}, Lawh$2;-><init>(Lawh;Lqm;Lcom/google/android/gms/wearable/Asset;)V

    invoke-interface {p1, v0}, Lqm;->a(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method

.method public a(Lqm;Lcom/google/android/gms/wearable/PutDataRequest;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Lcom/google/android/gms/wearable/PutDataRequest;",
            ")",
            "Lqq",
            "<",
            "Lats;",
            ">;"
        }
    .end annotation

    new-instance v0, Lawh$1;

    invoke-direct {v0, p0, p1, p2}, Lawh$1;-><init>(Lawh;Lqm;Lcom/google/android/gms/wearable/PutDataRequest;)V

    invoke-interface {p1, v0}, Lqm;->a(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method

.method public b(Lqm;Latt;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Latt;",
            ")",
            "Lqq",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation

    new-instance v0, Lawh$3;

    invoke-direct {v0, p0, p1, p2}, Lawh$3;-><init>(Lawh;Lqm;Latt;)V

    invoke-interface {p1, v0}, Lqm;->a(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method
