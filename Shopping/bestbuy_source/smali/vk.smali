.class public final Lvk;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# direct methods
.method public static a(Landroid/content/Context;Lvm;)V
    .locals 1

    invoke-static {p0}, Lpu;->a(Landroid/content/Context;)I

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lug;->a()Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p1, v0}, Lvm;->a(Landroid/os/Bundle;)V

    :goto_0
    return-void

    :cond_0
    new-instance v0, Lvl;

    invoke-direct {v0, p0, p1}, Lvl;-><init>(Landroid/content/Context;Lvm;)V

    goto :goto_0
.end method
