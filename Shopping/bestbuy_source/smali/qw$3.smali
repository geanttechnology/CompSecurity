.class Lqw$3;
.super Ljava/lang/Object;

# interfaces
.implements Ladg;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lqw;
.end annotation


# instance fields
.field final synthetic a:Lqw;


# direct methods
.method constructor <init>(Lqw;)V
    .locals 0

    iput-object p1, p0, Lqw$3;->a:Lqw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public c()Z
    .locals 1

    iget-object v0, p0, Lqw$3;->a:Lqw;

    invoke-virtual {v0}, Lqw;->d()Z

    move-result v0

    return v0
.end method

.method public c_()Landroid/os/Bundle;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public d_()Z
    .locals 1

    iget-object v0, p0, Lqw$3;->a:Lqw;

    invoke-static {v0}, Lqw;->h(Lqw;)Z

    move-result v0

    return v0
.end method
