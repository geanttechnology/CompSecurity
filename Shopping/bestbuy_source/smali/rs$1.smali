.class Lrs$1;
.super Ljava/lang/Object;

# interfaces
.implements Lsc;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrs;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lsc",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lrs;


# direct methods
.method constructor <init>(Lrs;)V
    .locals 0

    iput-object p1, p0, Lrs$1;->a:Lrs;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lrr;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lrs$1;->a:Lrs;

    invoke-static {v0, p1}, Lrs;->a(Lrs;Lrr;)Lrr;

    iget-object v0, p0, Lrs$1;->a:Lrs;

    invoke-static {v0}, Lrs;->a(Lrs;)Ljava/util/LinkedList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lrt;

    iget-object v2, p0, Lrs$1;->a:Lrs;

    invoke-static {v2}, Lrs;->b(Lrs;)Lrr;

    move-result-object v2

    invoke-interface {v0, v2}, Lrt;->a(Lrr;)V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lrs$1;->a:Lrs;

    invoke-static {v0}, Lrs;->a(Lrs;)Ljava/util/LinkedList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/LinkedList;->clear()V

    iget-object v0, p0, Lrs$1;->a:Lrs;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lrs;->a(Lrs;Landroid/os/Bundle;)Landroid/os/Bundle;

    return-void
.end method
