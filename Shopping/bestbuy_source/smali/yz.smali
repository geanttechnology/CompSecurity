.class public final Lyz;
.super Lsd;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lsd",
        "<",
        "Lyp;",
        ">;"
    }
.end annotation

.annotation runtime Lzf;
.end annotation


# static fields
.field private static final a:Lyz;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lyz;

    invoke-direct {v0}, Lyz;-><init>()V

    sput-object v0, Lyz;->a:Lyz;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    const-string v0, "com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl"

    invoke-direct {p0, v0}, Lsd;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method public static a(Landroid/app/Activity;)Lym;
    .locals 1

    :try_start_0
    invoke-static {p0}, Lyz;->b(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "Using AdOverlay from the client jar."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    new-instance v0, Lxx;

    invoke-direct {v0, p0}, Lxx;-><init>(Landroid/app/Activity;)V

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lyz;->a:Lyz;

    invoke-direct {v0, p0}, Lyz;->c(Landroid/app/Activity;)Lym;
    :try_end_0
    .catch Lza; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Lza;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static b(Landroid/app/Activity;)Z
    .locals 3

    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "com.google.android.gms.ads.internal.purchase.useClientJar"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v0, Lza;

    const-string v1, "InAppPurchaseManager requires the useClientJar flag in intent extras."

    invoke-direct {v0, v1}, Lza;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const-string v1, "com.google.android.gms.ads.internal.purchase.useClientJar"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method private c(Landroid/app/Activity;)Lym;
    .locals 3

    const/4 v1, 0x0

    :try_start_0
    invoke-static {p1}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v2

    invoke-virtual {p0, p1}, Lyz;->a(Landroid/content/Context;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lyp;

    invoke-interface {v0, v2}, Lyp;->a(Lry;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lyn;->a(Landroid/os/IBinder;)Lym;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lse; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v2, "Could not create remote InAppPurchaseManager."

    invoke-static {v2, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    goto :goto_0

    :catch_1
    move-exception v0

    const-string v2, "Could not create remote InAppPurchaseManager."

    invoke-static {v2, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method protected synthetic a(Landroid/os/IBinder;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lyz;->b(Landroid/os/IBinder;)Lyp;

    move-result-object v0

    return-object v0
.end method

.method protected b(Landroid/os/IBinder;)Lyp;
    .locals 1

    invoke-static {p1}, Lyq;->a(Landroid/os/IBinder;)Lyp;

    move-result-object v0

    return-object v0
.end method
