.class public Lagj;
.super Lsd;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lsd",
        "<",
        "Lagg;",
        ">;"
    }
.end annotation


# static fields
.field private static a:Lagj;


# direct methods
.method protected constructor <init>()V
    .locals 1

    const-string v0, "com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl"

    invoke-direct {p0, v0}, Lsd;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method public static a(Landroid/app/Activity;Lrv;Lcom/google/android/gms/wallet/fragment/WalletFragmentOptions;Lagd;)Laga;
    .locals 2

    invoke-static {p0}, Lpu;->a(Landroid/content/Context;)I

    move-result v0

    if-eqz v0, :cond_0

    new-instance v1, Lps;

    invoke-direct {v1, v0}, Lps;-><init>(I)V

    throw v1

    :cond_0
    :try_start_0
    invoke-static {}, Lagj;->a()Lagj;

    move-result-object v0

    invoke-virtual {v0, p0}, Lagj;->a(Landroid/content/Context;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lagg;

    invoke-static {p0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v1

    invoke-interface {v0, v1, p1, p2, p3}, Lagg;->a(Lry;Lrv;Lcom/google/android/gms/wallet/fragment/WalletFragmentOptions;Lagd;)Laga;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lse; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :catch_1
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private static a()Lagj;
    .locals 1

    sget-object v0, Lagj;->a:Lagj;

    if-nez v0, :cond_0

    new-instance v0, Lagj;

    invoke-direct {v0}, Lagj;-><init>()V

    sput-object v0, Lagj;->a:Lagj;

    :cond_0
    sget-object v0, Lagj;->a:Lagj;

    return-object v0
.end method


# virtual methods
.method protected synthetic a(Landroid/os/IBinder;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lagj;->b(Landroid/os/IBinder;)Lagg;

    move-result-object v0

    return-object v0
.end method

.method protected b(Landroid/os/IBinder;)Lagg;
    .locals 1

    invoke-static {p1}, Lagh;->a(Landroid/os/IBinder;)Lagg;

    move-result-object v0

    return-object v0
.end method
