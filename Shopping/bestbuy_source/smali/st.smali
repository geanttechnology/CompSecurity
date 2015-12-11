.class public Lst;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;Lcom/google/android/gms/internal/gs;Ljava/lang/String;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/google/android/gms/internal/gs;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/concurrent/Future",
            "<",
            "Lsr;",
            ">;"
        }
    .end annotation

    new-instance v4, Labs;

    invoke-direct {v4}, Labs;-><init>()V

    sget-object v6, Laca;->a:Landroid/os/Handler;

    new-instance v0, Lst$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lst$1;-><init>(Lst;Landroid/content/Context;Lcom/google/android/gms/internal/gs;Labs;Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-object v4
.end method

.method protected a(Landroid/content/Context;Lcom/google/android/gms/internal/gs;Labs;)Lsr;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/google/android/gms/internal/gs;",
            "Labs",
            "<",
            "Lsr;",
            ">;)",
            "Lsr;"
        }
    .end annotation

    new-instance v0, Lsu;

    invoke-direct {v0, p1, p2}, Lsu;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/gs;)V

    new-instance v1, Lst$2;

    invoke-direct {v1, p0, p3, v0}, Lst$2;-><init>(Lst;Labs;Lsr;)V

    invoke-interface {v0, v1}, Lsr;->a(Lss;)V

    return-object v0
.end method
