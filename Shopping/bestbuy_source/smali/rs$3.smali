.class Lrs$3;
.super Ljava/lang/Object;

# interfaces
.implements Lrt;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrs;->a(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Landroid/os/Bundle;

.field final synthetic b:Lrs;


# direct methods
.method constructor <init>(Lrs;Landroid/os/Bundle;)V
    .locals 0

    iput-object p1, p0, Lrs$3;->b:Lrs;

    iput-object p2, p0, Lrs$3;->a:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public a(Lrr;)V
    .locals 2

    iget-object v0, p0, Lrs$3;->b:Lrs;

    invoke-static {v0}, Lrs;->b(Lrs;)Lrr;

    move-result-object v0

    iget-object v1, p0, Lrs$3;->a:Landroid/os/Bundle;

    invoke-interface {v0, v1}, Lrr;->a(Landroid/os/Bundle;)V

    return-void
.end method
