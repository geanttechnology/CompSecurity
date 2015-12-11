.class public final Lani;
.super Ljava/lang/Object;


# static fields
.field private static a:Laod;


# direct methods
.method public static a(I)Lanh;
    .locals 2

    :try_start_0
    new-instance v0, Lanh;

    invoke-static {}, Lani;->a()Laod;

    move-result-object v1

    invoke-interface {v1, p0}, Laod;->a(I)Lry;

    move-result-object v1

    invoke-direct {v0, v1}, Lanh;-><init>(Lry;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method private static a()Laod;
    .locals 2

    sget-object v0, Lani;->a:Laod;

    const-string v1, "IBitmapDescriptorFactory is not initialized"

    invoke-static {v0, v1}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laod;

    return-object v0
.end method

.method public static a(Laod;)V
    .locals 1

    sget-object v0, Lani;->a:Laod;

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {p0}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laod;

    sput-object v0, Lani;->a:Laod;

    goto :goto_0
.end method
