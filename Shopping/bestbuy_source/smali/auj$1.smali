.class final Lauj$1;
.super Ljava/lang/Object;

# interfaces
.implements Lqe;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lauj;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lqe",
        "<",
        "Lawc;",
        "Lauk;",
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

.method public a(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Lauk;Lqo;Lqp;)Lawc;
    .locals 3

    if-eqz p4, :cond_0

    :goto_0
    new-instance v0, Lawc;

    invoke-direct {v0, p1, p2, p5, p6}, Lawc;-><init>(Landroid/content/Context;Landroid/os/Looper;Lqo;Lqp;)V

    return-object v0

    :cond_0
    new-instance v0, Lauk;

    new-instance v1, Laul;

    invoke-direct {v1}, Laul;-><init>()V

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lauk;-><init>(Laul;Lauj$1;)V

    goto :goto_0
.end method

.method public bridge synthetic a(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Ljava/lang/Object;Lqo;Lqp;)Lqd;
    .locals 7

    move-object v4, p4

    check-cast v4, Lauk;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Lauj$1;->a(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Lauk;Lqo;Lqp;)Lawc;

    move-result-object v0

    return-object v0
.end method
