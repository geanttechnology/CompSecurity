.class Lavm$1;
.super Lawf;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lavm;->a(Lqm;)Lqq;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lawf",
        "<",
        "Laug;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic b:Lavm;


# direct methods
.method constructor <init>(Lavm;Lqm;)V
    .locals 0

    iput-object p1, p0, Lavm$1;->b:Lavm;

    invoke-direct {p0, p2}, Lawf;-><init>(Lqm;)V

    return-void
.end method


# virtual methods
.method protected synthetic a(Lcom/google/android/gms/common/api/Status;)Lqt;
    .locals 1

    invoke-virtual {p0, p1}, Lavm$1;->c(Lcom/google/android/gms/common/api/Status;)Laug;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lawc;)V
    .locals 0

    invoke-virtual {p1, p0}, Lawc;->a(Lqk;)V

    return-void
.end method

.method protected synthetic b(Lqd;)V
    .locals 0

    check-cast p1, Lawc;

    invoke-virtual {p0, p1}, Lavm$1;->a(Lawc;)V

    return-void
.end method

.method protected c(Lcom/google/android/gms/common/api/Status;)Laug;
    .locals 2

    new-instance v0, Lavn;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lavn;-><init>(Lcom/google/android/gms/common/api/Status;Ljava/util/List;)V

    return-object v0
.end method
