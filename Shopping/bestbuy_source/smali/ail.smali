.class public final Lail;
.super Ljava/lang/Object;


# static fields
.field private static a:Lajl;


# direct methods
.method public static a(Lcom/google/android/gms/maps/model/LatLng;F)Laik;
    .locals 2

    :try_start_0
    new-instance v0, Laik;

    invoke-static {}, Lail;->a()Lajl;

    move-result-object v1

    invoke-interface {v1, p0, p1}, Lajl;->a(Lcom/google/android/gms/maps/model/LatLng;F)Lry;

    move-result-object v1

    invoke-direct {v0, v1}, Laik;-><init>(Lry;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method private static a()Lajl;
    .locals 2

    sget-object v0, Lail;->a:Lajl;

    const-string v1, "CameraUpdateFactory is not initialized"

    invoke-static {v0, v1}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lajl;

    return-object v0
.end method

.method public static a(Lajl;)V
    .locals 1

    invoke-static {p0}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lajl;

    sput-object v0, Lail;->a:Lajl;

    return-void
.end method
