.class final Lahy$1;
.super Ljava/lang/Object;

# interfaces
.implements Lqe;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lahy;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lqe",
        "<",
        "Lafd;",
        "Lqa;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    const v0, 0x7fffffff

    return v0
.end method

.method public a(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Lqa;Lqo;Lqp;)Lafd;
    .locals 8

    new-instance v0, Lafd;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "locationServices"

    invoke-virtual {p3}, Lcom/google/android/gms/internal/jg;->a()Ljava/lang/String;

    move-result-object v7

    move-object v1, p1

    move-object v2, p2

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v0 .. v7}, Lafd;-><init>(Landroid/content/Context;Landroid/os/Looper;Ljava/lang/String;Lqo;Lqp;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public synthetic a(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Ljava/lang/Object;Lqo;Lqp;)Lqd;
    .locals 7

    move-object v4, p4

    check-cast v4, Lqa;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Lahy$1;->a(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Lqa;Lqo;Lqp;)Lafd;

    move-result-object v0

    return-object v0
.end method
