.class public Laeq;
.super Ljava/lang/Object;

# interfaces
.implements Lahr;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lqm;Lahx;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Lahx;",
            ")",
            "Lqq",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation

    new-instance v0, Laeq$2;

    invoke-direct {v0, p0, p1, p2}, Laeq$2;-><init>(Laeq;Lqm;Lahx;)V

    invoke-interface {p1, v0}, Lqm;->b(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method

.method public a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Lcom/google/android/gms/location/LocationRequest;",
            "Lahx;",
            ")",
            "Lqq",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation

    new-instance v0, Laeq$1;

    invoke-direct {v0, p0, p1, p2, p3}, Laeq$1;-><init>(Laeq;Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)V

    invoke-interface {p1, v0}, Lqm;->b(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method
