.class Lace$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lace;->e()V
.end annotation


# instance fields
.field final synthetic a:Lxc;

.field final synthetic b:Lace;


# direct methods
.method constructor <init>(Lace;Lxc;)V
    .locals 0

    iput-object p1, p0, Lace$1;->b:Lace;

    iput-object p2, p0, Lace$1;->a:Lxc;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Lace$1;->a:Lxc;

    invoke-virtual {v0}, Lxc;->k()V

    return-void
.end method
