.class Lawh$2;
.super Lawf;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lawh;->a(Lqm;Lcom/google/android/gms/wearable/Asset;)Lqq;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lawf",
        "<",
        "Latu;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic b:Lcom/google/android/gms/wearable/Asset;

.field final synthetic c:Lawh;


# direct methods
.method constructor <init>(Lawh;Lqm;Lcom/google/android/gms/wearable/Asset;)V
    .locals 0

    iput-object p1, p0, Lawh$2;->c:Lawh;

    iput-object p3, p0, Lawh$2;->b:Lcom/google/android/gms/wearable/Asset;

    invoke-direct {p0, p2}, Lawf;-><init>(Lqm;)V

    return-void
.end method


# virtual methods
.method protected synthetic a(Lcom/google/android/gms/common/api/Status;)Lqt;
    .locals 1

    invoke-virtual {p0, p1}, Lawh$2;->c(Lcom/google/android/gms/common/api/Status;)Latu;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lawc;)V
    .locals 1

    iget-object v0, p0, Lawh$2;->b:Lcom/google/android/gms/wearable/Asset;

    invoke-virtual {p1, p0, v0}, Lawc;->a(Lqk;Lcom/google/android/gms/wearable/Asset;)V

    return-void
.end method

.method protected synthetic b(Lqd;)V
    .locals 0

    check-cast p1, Lawc;

    invoke-virtual {p0, p1}, Lawh$2;->a(Lawc;)V

    return-void
.end method

.method protected c(Lcom/google/android/gms/common/api/Status;)Latu;
    .locals 2

    new-instance v0, Lawk;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lawk;-><init>(Lcom/google/android/gms/common/api/Status;Landroid/os/ParcelFileDescriptor;)V

    return-object v0
.end method
