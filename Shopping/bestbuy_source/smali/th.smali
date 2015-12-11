.class public final Lth;
.super Lsd;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lsd",
        "<",
        "Ltt;",
        ">;"
    }
.end annotation

.annotation runtime Lzf;
.end annotation


# static fields
.field private static final a:Lth;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lth;

    invoke-direct {v0}, Lth;-><init>()V

    sput-object v0, Lth;->a:Lth;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    const-string v0, "com.google.android.gms.ads.AdManagerCreatorImpl"

    invoke-direct {p0, v0}, Lsd;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lwc;)Ltq;
    .locals 6

    const v1, 0x648278

    invoke-static {p0}, Lpu;->a(Landroid/content/Context;)I

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lth;->a:Lth;

    invoke-direct {v0, p0, p1, p2, p3}, Lth;->b(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lwc;)Ltq;

    move-result-object v0

    if-nez v0, :cond_1

    :cond_0
    const-string v0, "Using AdManager from the client jar."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    new-instance v5, Lcom/google/android/gms/internal/gs;

    const/4 v0, 0x1

    invoke-direct {v5, v1, v1, v0}, Lcom/google/android/gms/internal/gs;-><init>(IIZ)V

    new-instance v0, Lahi;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Lahi;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lwd;Lcom/google/android/gms/internal/gs;)V

    :cond_1
    return-object v0
.end method

.method private b(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lwc;)Ltq;
    .locals 7

    const/4 v6, 0x0

    :try_start_0
    invoke-static {p1}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v1

    invoke-virtual {p0, p1}, Lth;->a(Landroid/content/Context;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltt;

    const v5, 0x648278

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-interface/range {v0 .. v5}, Ltt;->a(Lry;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lwd;I)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Ltr;->a(Landroid/os/IBinder;)Ltq;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lse; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "Could not create remote AdManager."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v6

    goto :goto_0

    :catch_1
    move-exception v0

    const-string v1, "Could not create remote AdManager."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v6

    goto :goto_0
.end method


# virtual methods
.method protected synthetic a(Landroid/os/IBinder;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lth;->b(Landroid/os/IBinder;)Ltt;

    move-result-object v0

    return-object v0
.end method

.method protected b(Landroid/os/IBinder;)Ltt;
    .locals 1

    invoke-static {p1}, Ltu;->a(Landroid/os/IBinder;)Ltt;

    move-result-object v0

    return-object v0
.end method
