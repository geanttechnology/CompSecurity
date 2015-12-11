.class public final Lcom/google/android/gms/internal/dj;
.super Lcom/google/android/gms/internal/fw;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/fw",
        "<",
        "Lcom/google/android/gms/internal/do;",
        ">;"
    }
.end annotation


# instance fields
.field private final f:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;I)V
    .locals 1

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/google/android/gms/internal/fw;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;[Ljava/lang/String;)V

    iput p4, p0, Lcom/google/android/gms/internal/dj;->f:I

    return-void
.end method


# virtual methods
.method protected final synthetic a(Landroid/os/IBinder;)Landroid/os/IInterface;
    .locals 1

    invoke-static {p1}, Lcom/google/android/gms/internal/dp;->a(Landroid/os/IBinder;)Lcom/google/android/gms/internal/do;

    move-result-object v0

    return-object v0
.end method

.method protected final a()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.gms.ads.service.START"

    return-object v0
.end method

.method protected final a(Lcom/google/android/gms/internal/gr;Lcom/google/android/gms/internal/ga;)V
    .locals 3

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iget v1, p0, Lcom/google/android/gms/internal/dj;->f:I

    iget-object v2, p0, Lcom/google/android/gms/internal/fw;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, p2, v1, v2, v0}, Lcom/google/android/gms/internal/gr;->g(Lcom/google/android/gms/internal/gn;ILjava/lang/String;Landroid/os/Bundle;)V

    return-void
.end method

.method protected final b()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.gms.ads.internal.request.IAdRequestService"

    return-object v0
.end method

.method public final c()Lcom/google/android/gms/internal/do;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/fw;->i()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/do;

    return-object v0
.end method
