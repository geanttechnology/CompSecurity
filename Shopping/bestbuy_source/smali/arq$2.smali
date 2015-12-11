.class Larq$2;
.super Ljava/lang/Object;

# interfaces
.implements Larr;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Larq;->a(Ljava/util/Set;Larp;)Larf;
.end annotation


# instance fields
.field final synthetic a:Larq;


# direct methods
.method constructor <init>(Larq;)V
    .locals 0

    iput-object p1, p0, Larq$2;->a:Larq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Laro;Ljava/util/Set;Ljava/util/Set;Larl;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Laro;",
            "Ljava/util/Set",
            "<",
            "Larn;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Larn;",
            ">;",
            "Larl;",
            ")V"
        }
    .end annotation

    invoke-virtual {p1}, Laro;->c()Ljava/util/List;

    move-result-object v0

    invoke-interface {p2, v0}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-virtual {p1}, Laro;->d()Ljava/util/List;

    move-result-object v0

    invoke-interface {p3, v0}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-interface {p4}, Larl;->e()Larj;

    move-result-object v0

    invoke-virtual {p1}, Laro;->c()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p1}, Laro;->f()Ljava/util/List;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Larj;->a(Ljava/util/List;Ljava/util/List;)V

    invoke-interface {p4}, Larl;->f()Larj;

    move-result-object v0

    invoke-virtual {p1}, Laro;->d()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p1}, Laro;->g()Ljava/util/List;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Larj;->a(Ljava/util/List;Ljava/util/List;)V

    return-void
.end method
