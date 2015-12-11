.class Lawh$3;
.super Lawf;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lawh;->b(Lqm;Latt;)Lqq;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lawf",
        "<",
        "Lcom/google/android/gms/common/api/Status;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic b:Latt;

.field final synthetic c:Lawh;


# direct methods
.method constructor <init>(Lawh;Lqm;Latt;)V
    .locals 0

    iput-object p1, p0, Lawh$3;->c:Lawh;

    iput-object p3, p0, Lawh$3;->b:Latt;

    invoke-direct {p0, p2}, Lawf;-><init>(Lqm;)V

    return-void
.end method


# virtual methods
.method public synthetic a(Lcom/google/android/gms/common/api/Status;)Lqt;
    .locals 1

    invoke-virtual {p0, p1}, Lawh$3;->c(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Status;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lawc;)V
    .locals 1

    iget-object v0, p0, Lawh$3;->b:Latt;

    invoke-virtual {p1, p0, v0}, Lawc;->a(Lqk;Latt;)V

    return-void
.end method

.method protected synthetic b(Lqd;)V
    .locals 0

    check-cast p1, Lawc;

    invoke-virtual {p0, p1}, Lawh$3;->a(Lawc;)V

    return-void
.end method

.method public c(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Status;
    .locals 0

    return-object p1
.end method
