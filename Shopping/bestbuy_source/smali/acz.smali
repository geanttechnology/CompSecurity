.class final Lacz;
.super Landroid/os/Handler;


# instance fields
.field final synthetic a:Lacy;


# direct methods
.method public constructor <init>(Lacy;Landroid/os/Looper;)V
    .locals 0

    iput-object p1, p0, Lacz;->a:Lacy;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6

    const/4 v5, 0x2

    const/4 v4, 0x0

    const/4 v3, 0x4

    const/4 v2, 0x1

    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v0, v2, :cond_0

    iget-object v0, p0, Lacz;->a:Lacy;

    invoke-virtual {v0}, Lacy;->g()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lada;

    invoke-virtual {v0}, Lada;->a()V

    invoke-virtual {v0}, Lada;->c()V

    :goto_0
    return-void

    :cond_0
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lacz;->a:Lacy;

    invoke-static {v0}, Lacy;->a(Lacy;)Lade;

    move-result-object v1

    new-instance v2, Lpp;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-direct {v2, v0, v4}, Lpp;-><init>(ILandroid/app/PendingIntent;)V

    invoke-virtual {v1, v2}, Lade;->a(Lpp;)V

    goto :goto_0

    :cond_1
    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v0, v3, :cond_2

    iget-object v0, p0, Lacz;->a:Lacy;

    invoke-static {v0, v3, v4}, Lacy;->a(Lacy;ILandroid/os/IInterface;)V

    iget-object v0, p0, Lacz;->a:Lacy;

    invoke-static {v0}, Lacy;->a(Lacy;)Lade;

    move-result-object v1

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v1, v0}, Lade;->a(I)V

    iget-object v0, p0, Lacz;->a:Lacy;

    invoke-static {v0, v3, v2, v4}, Lacy;->a(Lacy;IILandroid/os/IInterface;)Z

    goto :goto_0

    :cond_2
    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v0, v5, :cond_3

    iget-object v0, p0, Lacz;->a:Lacy;

    invoke-virtual {v0}, Lacy;->c()Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lada;

    invoke-virtual {v0}, Lada;->a()V

    invoke-virtual {v0}, Lada;->c()V

    goto :goto_0

    :cond_3
    iget v0, p1, Landroid/os/Message;->what:I

    if-eq v0, v5, :cond_4

    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v0, v2, :cond_5

    :cond_4
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lada;

    invoke-virtual {v0}, Lada;->b()V

    goto :goto_0

    :cond_5
    const-string v0, "GmsClient"

    const-string v1, "Don\'t know how to handle this message."

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
