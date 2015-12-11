.class public final Lank;
.super Ljava/lang/Object;


# instance fields
.field private final a:Laop;


# direct methods
.method public constructor <init>(Laop;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laop;

    iput-object v0, p0, Lank;->a:Laop;

    return-void
.end method


# virtual methods
.method public a()Lcom/google/android/gms/maps/model/LatLng;
    .locals 2

    :try_start_0
    iget-object v0, p0, Lank;->a:Laop;

    invoke-interface {v0}, Laop;->c()Lcom/google/android/gms/maps/model/LatLng;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public a(Lanh;)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lank;->a:Laop;

    invoke-virtual {p1}, Lanh;->a()Lry;

    move-result-object v1

    invoke-interface {v0, v1}, Laop;->a(Lry;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public b()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lank;->a:Laop;

    invoke-interface {v0}, Laop;->g()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    instance-of v0, p1, Lank;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    :try_start_0
    iget-object v0, p0, Lank;->a:Laop;

    check-cast p1, Lank;

    iget-object v1, p1, Lank;->a:Laop;

    invoke-interface {v0, v1}, Laop;->a(Laop;)Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public hashCode()I
    .locals 2

    :try_start_0
    iget-object v0, p0, Lank;->a:Laop;

    invoke-interface {v0}, Laop;->k()I
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method
