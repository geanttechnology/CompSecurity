.class public final Laaa;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# direct methods
.method public static a(Landroid/content/Context;Lahi;Labe;Lcom/google/android/gms/internal/gu;Lwd;Laab;)Labn;
    .locals 6

    iget-object v0, p2, Labe;->b:Lcom/google/android/gms/internal/fj;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/fj;->t:Z

    if-eqz v0, :cond_0

    new-instance v0, Laaq;

    new-instance v3, Lst;

    invoke-direct {v3}, Lst;-><init>()V

    move-object v1, p0

    move-object v2, p1

    move-object v4, p2

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Laaq;-><init>(Landroid/content/Context;Lahi;Lst;Labe;Laab;)V

    :goto_0
    invoke-virtual {v0}, Labn;->e()V

    return-object v0

    :cond_0
    new-instance v0, Laac;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Laac;-><init>(Landroid/content/Context;Labe;Lcom/google/android/gms/internal/gu;Lwd;Laab;)V

    goto :goto_0
.end method
