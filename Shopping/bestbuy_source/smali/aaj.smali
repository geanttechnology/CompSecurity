.class public Laaj;
.super Lacy;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lacy",
        "<",
        "Laan;",
        ">;"
    }
.end annotation

.annotation runtime Lzf;
.end annotation


# instance fields
.field final a:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Lqo;Lqp;I)V
    .locals 6

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    const/4 v0, 0x0

    new-array v5, v0, [Ljava/lang/String;

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Lacy;-><init>(Landroid/content/Context;Landroid/os/Looper;Lqo;Lqp;[Ljava/lang/String;)V

    iput p4, p0, Laaj;->a:I

    return-void
.end method


# virtual methods
.method protected a(Landroid/os/IBinder;)Laan;
    .locals 1

    invoke-static {p1}, Laao;->a(Landroid/os/IBinder;)Laan;

    move-result-object v0

    return-object v0
.end method

.method protected a(Ladp;Ladb;)V
    .locals 3

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iget v1, p0, Laaj;->a:I

    invoke-virtual {p0}, Laaj;->h()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, p2, v1, v2, v0}, Ladp;->g(Ladm;ILjava/lang/String;Landroid/os/Bundle;)V

    return-void
.end method

.method protected synthetic b(Landroid/os/IBinder;)Landroid/os/IInterface;
    .locals 1

    invoke-virtual {p0, p1}, Laaj;->a(Landroid/os/IBinder;)Laan;

    move-result-object v0

    return-object v0
.end method

.method protected d()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.gms.ads.service.START"

    return-object v0
.end method

.method protected e()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.gms.ads.internal.request.IAdRequestService"

    return-object v0
.end method

.method public f()Laan;
    .locals 1

    invoke-super {p0}, Lacy;->j()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Laan;

    return-object v0
.end method
