.class Laeq$1;
.super Laer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laeq;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;
.end annotation


# instance fields
.field final synthetic b:Lcom/google/android/gms/location/LocationRequest;

.field final synthetic c:Lahx;

.field final synthetic d:Laeq;


# direct methods
.method constructor <init>(Laeq;Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)V
    .locals 0

    iput-object p1, p0, Laeq$1;->d:Laeq;

    iput-object p3, p0, Laeq$1;->b:Lcom/google/android/gms/location/LocationRequest;

    iput-object p4, p0, Laeq$1;->c:Lahx;

    invoke-direct {p0, p2}, Laer;-><init>(Lqm;)V

    return-void
.end method


# virtual methods
.method protected a(Lafd;)V
    .locals 3

    iget-object v0, p0, Laeq$1;->b:Lcom/google/android/gms/location/LocationRequest;

    iget-object v1, p0, Laeq$1;->c:Lahx;

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v1, v2}, Lafd;->a(Lcom/google/android/gms/location/LocationRequest;Lahx;Landroid/os/Looper;)V

    sget-object v0, Lcom/google/android/gms/common/api/Status;->a:Lcom/google/android/gms/common/api/Status;

    invoke-virtual {p0, v0}, Laeq$1;->a(Lqt;)V

    return-void
.end method

.method protected synthetic b(Lqd;)V
    .locals 0

    check-cast p1, Lafd;

    invoke-virtual {p0, p1}, Laeq$1;->a(Lafd;)V

    return-void
.end method
