.class Laeq$2;
.super Laer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laeq;->a(Lqm;Lahx;)Lqq;
.end annotation


# instance fields
.field final synthetic b:Lahx;

.field final synthetic c:Laeq;


# direct methods
.method constructor <init>(Laeq;Lqm;Lahx;)V
    .locals 0

    iput-object p1, p0, Laeq$2;->c:Laeq;

    iput-object p3, p0, Laeq$2;->b:Lahx;

    invoke-direct {p0, p2}, Laer;-><init>(Lqm;)V

    return-void
.end method


# virtual methods
.method protected a(Lafd;)V
    .locals 1

    iget-object v0, p0, Laeq$2;->b:Lahx;

    invoke-virtual {p1, v0}, Lafd;->a(Lahx;)V

    sget-object v0, Lcom/google/android/gms/common/api/Status;->a:Lcom/google/android/gms/common/api/Status;

    invoke-virtual {p0, v0}, Laeq$2;->a(Lqt;)V

    return-void
.end method

.method protected synthetic b(Lqd;)V
    .locals 0

    check-cast p1, Lafd;

    invoke-virtual {p0, p1}, Laeq$2;->a(Lafd;)V

    return-void
.end method
