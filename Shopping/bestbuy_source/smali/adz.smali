.class public final Ladz;
.super Lsd;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lsd",
        "<",
        "Lads;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Ladz;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Ladz;

    invoke-direct {v0}, Ladz;-><init>()V

    sput-object v0, Ladz;->a:Ladz;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    const-string v0, "com.google.android.gms.common.ui.SignInButtonCreatorImpl"

    invoke-direct {p0, v0}, Lsd;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method public static a(Landroid/content/Context;II)Landroid/view/View;
    .locals 1

    sget-object v0, Ladz;->a:Ladz;

    invoke-direct {v0, p0, p1, p2}, Ladz;->b(Landroid/content/Context;II)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private b(Landroid/content/Context;II)Landroid/view/View;
    .locals 4

    :try_start_0
    invoke-static {p1}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v1

    invoke-virtual {p0, p1}, Ladz;->a(Landroid/content/Context;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lads;

    invoke-interface {v0, v1, p2, p3}, Lads;->a(Lry;II)Lry;

    move-result-object v0

    invoke-static {v0}, Lsb;->a(Lry;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lse;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not get button with size "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " and color "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lse;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public synthetic a(Landroid/os/IBinder;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Ladz;->b(Landroid/os/IBinder;)Lads;

    move-result-object v0

    return-object v0
.end method

.method public b(Landroid/os/IBinder;)Lads;
    .locals 1

    invoke-static {p1}, Ladt;->a(Landroid/os/IBinder;)Lads;

    move-result-object v0

    return-object v0
.end method
