.class public abstract Lqj;
.super Lqh;

# interfaces
.implements Lra;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<R::",
        "Lqt;",
        "A::",
        "Lqd;",
        ">",
        "Lqh",
        "<TR;>;",
        "Lra",
        "<TA;>;"
    }
.end annotation


# instance fields
.field private final b:Lqf;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqf",
            "<TA;>;"
        }
    .end annotation
.end field

.field private final c:Lqm;

.field private d:Lqy;


# direct methods
.method protected constructor <init>(Lqf;Lqm;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqf",
            "<TA;>;",
            "Lqm;",
            ")V"
        }
    .end annotation

    invoke-interface {p2}, Lqm;->a()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {p0, v0}, Lqh;-><init>(Landroid/os/Looper;)V

    invoke-static {p1}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lqf;

    iput-object v0, p0, Lqj;->b:Lqf;

    iput-object p2, p0, Lqj;->c:Lqm;

    return-void
.end method

.method private a(Landroid/os/RemoteException;)V
    .locals 4

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/16 v1, 0x8

    invoke-virtual {p1}, Landroid/os/RemoteException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gms/common/api/Status;-><init>(ILjava/lang/String;Landroid/app/PendingIntent;)V

    invoke-virtual {p0, v0}, Lqj;->b(Lcom/google/android/gms/common/api/Status;)V

    return-void
.end method


# virtual methods
.method public final a(Lqd;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TA;)V"
        }
    .end annotation

    :try_start_0
    invoke-virtual {p0, p1}, Lqj;->b(Lqd;)V
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_1

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-direct {p0, v0}, Lqj;->a(Landroid/os/RemoteException;)V

    throw v0

    :catch_1
    move-exception v0

    invoke-direct {p0, v0}, Lqj;->a(Landroid/os/RemoteException;)V

    goto :goto_0
.end method

.method public a(Lqy;)V
    .locals 0

    iput-object p1, p0, Lqj;->d:Lqy;

    return-void
.end method

.method public final b(Lcom/google/android/gms/common/api/Status;)V
    .locals 2

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->e()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v1, "Failed result must not be success"

    invoke-static {v0, v1}, Lady;->b(ZLjava/lang/Object;)V

    invoke-virtual {p0, p1}, Lqj;->a(Lcom/google/android/gms/common/api/Status;)Lqt;

    move-result-object v0

    invoke-virtual {p0, v0}, Lqj;->a(Lqt;)V

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected abstract b(Lqd;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TA;)V"
        }
    .end annotation
.end method

.method protected e()V
    .locals 1

    invoke-super {p0}, Lqh;->e()V

    iget-object v0, p0, Lqj;->d:Lqy;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lqj;->d:Lqy;

    invoke-interface {v0, p0}, Lqy;->a(Lra;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lqj;->d:Lqy;

    :cond_0
    return-void
.end method

.method public final f()Lqf;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lqf",
            "<TA;>;"
        }
    .end annotation

    iget-object v0, p0, Lqj;->b:Lqf;

    return-object v0
.end method

.method public g()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method
