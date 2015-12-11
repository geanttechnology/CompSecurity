.class Larq$1;
.super Ljava/lang/Object;

# interfaces
.implements Larr;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Larq;->a(Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Larp;)Larf;
.end annotation


# instance fields
.field final synthetic a:Ljava/util/Map;

.field final synthetic b:Ljava/util/Map;

.field final synthetic c:Ljava/util/Map;

.field final synthetic d:Ljava/util/Map;

.field final synthetic e:Larq;


# direct methods
.method constructor <init>(Larq;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V
    .locals 0

    iput-object p1, p0, Larq$1;->e:Larq;

    iput-object p2, p0, Larq$1;->a:Ljava/util/Map;

    iput-object p3, p0, Larq$1;->b:Ljava/util/Map;

    iput-object p4, p0, Larq$1;->c:Ljava/util/Map;

    iput-object p5, p0, Larq$1;->d:Ljava/util/Map;

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

    iget-object v0, p0, Larq$1;->a:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    iget-object v1, p0, Larq$1;->b:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    if-eqz v0, :cond_0

    invoke-interface {p2, v0}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-interface {p4}, Larl;->c()Larj;

    move-result-object v2

    invoke-interface {v2, v0, v1}, Larj;->a(Ljava/util/List;Ljava/util/List;)V

    :cond_0
    iget-object v0, p0, Larq$1;->c:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    iget-object v1, p0, Larq$1;->d:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    if-eqz v0, :cond_1

    invoke-interface {p3, v0}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-interface {p4}, Larl;->d()Larj;

    move-result-object v2

    invoke-interface {v2, v0, v1}, Larj;->a(Ljava/util/List;Ljava/util/List;)V

    :cond_1
    return-void
.end method
