.class public final Laiv;
.super Ljava/lang/Object;


# direct methods
.method public static a(Landroid/content/Context;)I
    .locals 1

    invoke-static {p0}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    :try_start_0
    invoke-static {p0}, Lanf;->a(Landroid/content/Context;)Lakw;
    :try_end_0
    .catch Lps; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    invoke-static {v0}, Laiv;->a(Lakw;)V

    const/4 v0, 0x0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    iget v0, v0, Lps;->a:I

    goto :goto_0
.end method

.method public static a(Lakw;)V
    .locals 2

    :try_start_0
    invoke-interface {p0}, Lakw;->a()Lajl;

    move-result-object v0

    invoke-static {v0}, Lail;->a(Lajl;)V

    invoke-interface {p0}, Lakw;->b()Laod;

    move-result-object v0

    invoke-static {v0}, Lani;->a(Laod;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method
