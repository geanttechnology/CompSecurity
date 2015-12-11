.class Laeo$1;
.super Ljava/lang/Object;

# interfaces
.implements Lafj;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Laeo;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lafj",
        "<",
        "Laex;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Laeo;


# direct methods
.method constructor <init>(Laeo;)V
    .locals 0

    iput-object p1, p0, Laeo$1;->a:Laeo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    iget-object v0, p0, Laeo$1;->a:Laeo;

    invoke-static {v0}, Laeo;->a(Laeo;)V

    return-void
.end method

.method public b()Laex;
    .locals 1

    iget-object v0, p0, Laeo$1;->a:Laeo;

    invoke-virtual {v0}, Laeo;->j()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Laex;

    return-object v0
.end method

.method public synthetic c()Landroid/os/IInterface;
    .locals 1

    invoke-virtual {p0}, Laeo$1;->b()Laex;

    move-result-object v0

    return-object v0
.end method
