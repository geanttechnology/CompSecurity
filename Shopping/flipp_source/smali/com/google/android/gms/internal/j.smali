.class public abstract Lcom/google/android/gms/internal/j;
.super Landroid/os/Binder;

# interfaces
.implements Lcom/google/android/gms/internal/i;


# direct methods
.method public static a(Landroid/os/IBinder;)Lcom/google/android/gms/internal/i;
    .locals 2

    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "com.google.android.gms.ads.internal.client.IAdManagerCreator"

    invoke-interface {p0, v0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/google/android/gms/internal/i;

    if-eqz v1, :cond_1

    check-cast v0, Lcom/google/android/gms/internal/i;

    goto :goto_0

    :cond_1
    new-instance v0, Lcom/google/android/gms/internal/k;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/k;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 7

    const/4 v0, 0x0

    const/4 v6, 0x1

    sparse-switch p1, :sswitch_data_0

    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v0

    :goto_0
    return v0

    :sswitch_0
    const-string v0, "com.google.android.gms.ads.internal.client.IAdManagerCreator"

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    move v0, v6

    goto :goto_0

    :sswitch_1
    const-string v1, "com.google.android.gms.ads.internal.client.IAdManagerCreator"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gms/a/b;->a(Landroid/os/IBinder;)Lcom/google/android/gms/a/a;

    move-result-object v1

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_0

    sget-object v2, Lcom/google/android/gms/internal/x;->CREATOR:Lcom/google/android/gms/internal/ky;

    invoke-static {p2}, Lcom/google/android/gms/internal/ky;->a(Landroid/os/Parcel;)Lcom/google/android/gms/internal/x;

    move-result-object v2

    :goto_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    if-nez v4, :cond_1

    move-object v4, v0

    :goto_2
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/internal/j;->a(Lcom/google/android/gms/a/a;Lcom/google/android/gms/internal/x;Ljava/lang/String;Lcom/google/android/gms/internal/bn;I)Landroid/os/IBinder;

    move-result-object v0

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    move v0, v6

    goto :goto_0

    :cond_0
    move-object v2, v0

    goto :goto_1

    :cond_1
    const-string v0, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator"

    invoke-interface {v4, v0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    if-eqz v0, :cond_2

    instance-of v5, v0, Lcom/google/android/gms/internal/bn;

    if-eqz v5, :cond_2

    check-cast v0, Lcom/google/android/gms/internal/bn;

    move-object v4, v0

    goto :goto_2

    :cond_2
    new-instance v0, Lcom/google/android/gms/internal/bp;

    invoke-direct {v0, v4}, Lcom/google/android/gms/internal/bp;-><init>(Landroid/os/IBinder;)V

    move-object v4, v0

    goto :goto_2

    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
