.class public final Laim;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lajo;

.field private b:Lajh;


# direct methods
.method protected constructor <init>(Lajo;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lajo;

    iput-object v0, p0, Laim;->a:Lajo;

    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/maps/model/MarkerOptions;)Lank;
    .locals 2

    :try_start_0
    iget-object v0, p0, Laim;->a:Lajo;

    invoke-interface {v0, p1}, Lajo;->a(Lcom/google/android/gms/maps/model/MarkerOptions;)Laop;

    move-result-object v1

    if-eqz v1, :cond_0

    new-instance v0, Lank;

    invoke-direct {v0, v1}, Lank;-><init>(Laop;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final a()Lcom/google/android/gms/maps/model/CameraPosition;
    .locals 2

    :try_start_0
    iget-object v0, p0, Laim;->a:Lajo;

    invoke-interface {v0}, Lajo;->a()Lcom/google/android/gms/maps/model/CameraPosition;
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

.method public final a(Laik;)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Laim;->a:Lajo;

    invoke-virtual {p1}, Laik;->a()Lry;

    move-result-object v1

    invoke-interface {v0, v1}, Lajo;->a(Lry;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final a(Lain;)V
    .locals 2

    if-nez p1, :cond_0

    :try_start_0
    iget-object v0, p0, Laim;->a:Lajo;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lajo;->a(Lakz;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Laim;->a:Lajo;

    new-instance v1, Laim$3;

    invoke-direct {v1, p0, p1}, Laim$3;-><init>(Laim;Lain;)V

    invoke-interface {v0, v1}, Lajo;->a(Lakz;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final a(Laio;)V
    .locals 2

    if-nez p1, :cond_0

    :try_start_0
    iget-object v0, p0, Laim;->a:Lajo;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lajo;->a(Lall;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Laim;->a:Lajo;

    new-instance v1, Laim$2;

    invoke-direct {v1, p0, p1}, Laim$2;-><init>(Laim;Laio;)V

    invoke-interface {v0, v1}, Lajo;->a(Lall;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final a(Laip;)V
    .locals 2

    if-nez p1, :cond_0

    :try_start_0
    iget-object v0, p0, Laim;->a:Lajo;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lajo;->a(Lalr;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Laim;->a:Lajo;

    new-instance v1, Laim$4;

    invoke-direct {v1, p0, p1}, Laim$4;-><init>(Laim;Laip;)V

    invoke-interface {v0, v1}, Lajo;->a(Lalr;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final a(Laiq;)V
    .locals 2

    if-nez p1, :cond_0

    :try_start_0
    iget-object v0, p0, Laim;->a:Lajo;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lajo;->a(Lamd;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Laim;->a:Lajo;

    new-instance v1, Laim$1;

    invoke-direct {v1, p0, p1}, Laim$1;-><init>(Laim;Laiq;)V

    invoke-interface {v0, v1}, Lajo;->a(Lamd;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final a(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Laim;->a:Lajo;

    invoke-interface {v0, p1}, Lajo;->c(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final b()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Laim;->a:Lajo;

    invoke-interface {v0}, Lajo;->e()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final c()Lajh;
    .locals 2

    :try_start_0
    iget-object v0, p0, Laim;->b:Lajh;

    if-nez v0, :cond_0

    new-instance v0, Lajh;

    iget-object v1, p0, Laim;->a:Lajo;

    invoke-interface {v1}, Lajo;->k()Lakm;

    move-result-object v1

    invoke-direct {v0, v1}, Lajh;-><init>(Lakm;)V

    iput-object v0, p0, Laim;->b:Lajh;

    :cond_0
    iget-object v0, p0, Laim;->b:Lajh;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method
