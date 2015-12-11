.class Lrs$2;
.super Ljava/lang/Object;

# interfaces
.implements Lrt;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrs;->a(Landroid/app/Activity;Landroid/os/Bundle;Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Landroid/app/Activity;

.field final synthetic b:Landroid/os/Bundle;

.field final synthetic c:Landroid/os/Bundle;

.field final synthetic d:Lrs;


# direct methods
.method constructor <init>(Lrs;Landroid/app/Activity;Landroid/os/Bundle;Landroid/os/Bundle;)V
    .locals 0

    iput-object p1, p0, Lrs$2;->d:Lrs;

    iput-object p2, p0, Lrs$2;->a:Landroid/app/Activity;

    iput-object p3, p0, Lrs$2;->b:Landroid/os/Bundle;

    iput-object p4, p0, Lrs$2;->c:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public a(Lrr;)V
    .locals 4

    iget-object v0, p0, Lrs$2;->d:Lrs;

    invoke-static {v0}, Lrs;->b(Lrs;)Lrr;

    move-result-object v0

    iget-object v1, p0, Lrs$2;->a:Landroid/app/Activity;

    iget-object v2, p0, Lrs$2;->b:Landroid/os/Bundle;

    iget-object v3, p0, Lrs$2;->c:Landroid/os/Bundle;

    invoke-interface {v0, v1, v2, v3}, Lrr;->a(Landroid/app/Activity;Landroid/os/Bundle;Landroid/os/Bundle;)V

    return-void
.end method
