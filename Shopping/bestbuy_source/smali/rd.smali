.class public Lrd;
.super Landroid/support/v4/content/Loader;

# interfaces
.implements Lqo;
.implements Lqp;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v4/content/Loader",
        "<",
        "Lpp;",
        ">;",
        "Lqo;",
        "Lqp;"
    }
.end annotation


# instance fields
.field public final a:Lqm;

.field private b:Z

.field private c:Lpp;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lqm;)V
    .locals 0

    invoke-direct {p0, p1}, Landroid/support/v4/content/Loader;-><init>(Landroid/content/Context;)V

    iput-object p2, p0, Lrd;->a:Lqm;

    return-void
.end method

.method private a(Lpp;)V
    .locals 1

    iput-object p1, p0, Lrd;->c:Lpp;

    invoke-virtual {p0}, Lrd;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lrd;->isAbandoned()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0, p1}, Lrd;->deliverResult(Ljava/lang/Object;)V

    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    iget-boolean v0, p0, Lrd;->b:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    iput-boolean v0, p0, Lrd;->b:Z

    invoke-virtual {p0}, Lrd;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lrd;->isAbandoned()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    :cond_0
    return-void
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lrd;->b:Z

    sget-object v0, Lpp;->a:Lpp;

    invoke-direct {p0, v0}, Lrd;->a(Lpp;)V

    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lrd;->b:Z

    invoke-direct {p0, p1}, Lrd;->a(Lpp;)V

    return-void
.end method

.method public onConnectionSuspended(I)V
    .locals 0

    return-void
.end method

.method protected onReset()V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lrd;->c:Lpp;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lrd;->b:Z

    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0, p0}, Lqm;->b(Lqo;)V

    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0, p0}, Lqm;->b(Lqp;)V

    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0}, Lqm;->c()V

    return-void
.end method

.method protected onStartLoading()V
    .locals 1

    invoke-super {p0}, Landroid/support/v4/content/Loader;->onStartLoading()V

    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0, p0}, Lqm;->a(Lqo;)V

    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0, p0}, Lqm;->a(Lqp;)V

    iget-object v0, p0, Lrd;->c:Lpp;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lrd;->c:Lpp;

    invoke-virtual {p0, v0}, Lrd;->deliverResult(Ljava/lang/Object;)V

    :cond_0
    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0}, Lqm;->e()Z

    move-result v0

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lrd;->b:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    :cond_1
    return-void
.end method

.method protected onStopLoading()V
    .locals 1

    iget-object v0, p0, Lrd;->a:Lqm;

    invoke-interface {v0}, Lqm;->c()V

    return-void
.end method
