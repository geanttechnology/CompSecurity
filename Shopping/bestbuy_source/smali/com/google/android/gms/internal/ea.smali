.class public final Lcom/google/android/gms/internal/ea;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# annotations
.annotation runtime Lzf;
.end annotation


# static fields
.field public static final CREATOR:Lxs;


# instance fields
.field public final a:I

.field public final b:Lye;

.field public final c:Lyg;

.field public final d:Landroid/content/Context;

.field public final e:Lyd;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lxs;

    invoke-direct {v0}, Lxs;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ea;->CREATOR:Lxs;

    return-void
.end method

.method public constructor <init>(ILandroid/os/IBinder;Landroid/os/IBinder;Landroid/os/IBinder;Landroid/os/IBinder;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/ea;->a:I

    invoke-static {p2}, Lrz;->a(Landroid/os/IBinder;)Lry;

    move-result-object v0

    invoke-static {v0}, Lsb;->a(Lry;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lye;

    iput-object v0, p0, Lcom/google/android/gms/internal/ea;->b:Lye;

    invoke-static {p3}, Lrz;->a(Landroid/os/IBinder;)Lry;

    move-result-object v0

    invoke-static {v0}, Lsb;->a(Lry;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lyg;

    iput-object v0, p0, Lcom/google/android/gms/internal/ea;->c:Lyg;

    invoke-static {p4}, Lrz;->a(Landroid/os/IBinder;)Lry;

    move-result-object v0

    invoke-static {v0}, Lsb;->a(Lry;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    iput-object v0, p0, Lcom/google/android/gms/internal/ea;->d:Landroid/content/Context;

    invoke-static {p5}, Lrz;->a(Landroid/os/IBinder;)Lry;

    move-result-object v0

    invoke-static {v0}, Lsb;->a(Lry;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lyd;

    iput-object v0, p0, Lcom/google/android/gms/internal/ea;->e:Lyd;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lye;Lyg;Lyd;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x2

    iput v0, p0, Lcom/google/android/gms/internal/ea;->a:I

    iput-object p1, p0, Lcom/google/android/gms/internal/ea;->d:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/ea;->b:Lye;

    iput-object p3, p0, Lcom/google/android/gms/internal/ea;->c:Lyg;

    iput-object p4, p0, Lcom/google/android/gms/internal/ea;->e:Lyd;

    return-void
.end method

.method public static a(Landroid/content/Intent;)Lcom/google/android/gms/internal/ea;
    .locals 2

    :try_start_0
    const-string v0, "com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/google/android/gms/internal/ea;

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    const-string v1, "com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/ea;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Landroid/content/Intent;Lcom/google/android/gms/internal/ea;)V
    .locals 2

    new-instance v0, Landroid/os/Bundle;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(I)V

    const-string v1, "com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    const-string v1, "com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo"

    invoke-virtual {p0, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    return-void
.end method


# virtual methods
.method public a()Landroid/os/IBinder;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/ea;->e:Lyd;

    invoke-static {v0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v0

    invoke-interface {v0}, Lry;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public b()Landroid/os/IBinder;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/ea;->b:Lye;

    invoke-static {v0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v0

    invoke-interface {v0}, Lry;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public c()Landroid/os/IBinder;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/ea;->c:Lyg;

    invoke-static {v0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v0

    invoke-interface {v0}, Lry;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public d()Landroid/os/IBinder;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/ea;->d:Landroid/content/Context;

    invoke-static {v0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v0

    invoke-interface {v0}, Lry;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lxs;->a(Lcom/google/android/gms/internal/ea;Landroid/os/Parcel;I)V

    return-void
.end method
