.class Lxv$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lxv;->a(Lxy;Ljava/lang/String;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Lxy;

.field final synthetic b:Landroid/content/Intent;

.field final synthetic c:Lxv;


# direct methods
.method constructor <init>(Lxv;Lxy;Landroid/content/Intent;)V
    .locals 0

    iput-object p1, p0, Lxv$1;->c:Lxv;

    iput-object p2, p0, Lxv$1;->a:Lxy;

    iput-object p3, p0, Lxv$1;->b:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    :try_start_0
    iget-object v0, p0, Lxv$1;->c:Lxv;

    invoke-static {v0}, Lxv;->a(Lxv;)Lye;

    move-result-object v0

    iget-object v1, p0, Lxv$1;->a:Lxy;

    iget-object v1, v1, Lxy;->b:Ljava/lang/String;

    const/4 v2, -0x1

    iget-object v3, p0, Lxv$1;->b:Landroid/content/Intent;

    invoke-virtual {v0, v1, v2, v3}, Lye;->a(Ljava/lang/String;ILandroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lxv$1;->c:Lxv;

    invoke-static {v0}, Lxv;->c(Lxv;)Lyv;

    move-result-object v7

    new-instance v0, Lxz;

    iget-object v1, p0, Lxv$1;->c:Lxv;

    invoke-static {v1}, Lxv;->b(Lxv;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lxv$1;->a:Lxy;

    iget-object v2, v2, Lxy;->c:Ljava/lang/String;

    const/4 v3, 0x1

    const/4 v4, -0x1

    iget-object v5, p0, Lxv$1;->b:Landroid/content/Intent;

    iget-object v6, p0, Lxv$1;->a:Lxy;

    invoke-direct/range {v0 .. v6}, Lxz;-><init>(Landroid/content/Context;Ljava/lang/String;ZILandroid/content/Intent;Lxy;)V

    invoke-interface {v7, v0}, Lyv;->a(Lys;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lxv$1;->c:Lxv;

    invoke-static {v0}, Lxv;->c(Lxv;)Lyv;

    move-result-object v7

    new-instance v0, Lxz;

    iget-object v1, p0, Lxv$1;->c:Lxv;

    invoke-static {v1}, Lxv;->b(Lxv;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lxv$1;->a:Lxy;

    iget-object v2, v2, Lxy;->c:Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, -0x1

    iget-object v5, p0, Lxv$1;->b:Landroid/content/Intent;

    iget-object v6, p0, Lxv$1;->a:Lxy;

    invoke-direct/range {v0 .. v6}, Lxz;-><init>(Landroid/content/Context;Ljava/lang/String;ZILandroid/content/Intent;Lxy;)V

    invoke-interface {v7, v0}, Lyv;->a(Lys;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v0, "Fail to verify and dispatch pending transaction"

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0
.end method
