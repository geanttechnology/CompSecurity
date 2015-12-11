.class public final Lpx;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<O::",
        "Lpy;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final a:Lqe;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqe",
            "<*TO;>;"
        }
    .end annotation
.end field

.field private final b:Lqf;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqf",
            "<*>;"
        }
    .end annotation
.end field

.field private final c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/common/api/Scope;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public varargs constructor <init>(Lqe;Lqf;[Lcom/google/android/gms/common/api/Scope;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<C::",
            "Lqd;",
            ">(",
            "Lqe",
            "<TC;TO;>;",
            "Lqf",
            "<TC;>;[",
            "Lcom/google/android/gms/common/api/Scope;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lpx;->a:Lqe;

    iput-object p2, p0, Lpx;->b:Lqf;

    new-instance v0, Ljava/util/ArrayList;

    invoke-static {p3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lpx;->c:Ljava/util/ArrayList;

    return-void
.end method


# virtual methods
.method public a()Lqe;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lqe",
            "<*TO;>;"
        }
    .end annotation

    iget-object v0, p0, Lpx;->a:Lqe;

    return-object v0
.end method

.method public b()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/common/api/Scope;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lpx;->c:Ljava/util/ArrayList;

    return-object v0
.end method

.method public c()Lqf;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lqf",
            "<*>;"
        }
    .end annotation

    iget-object v0, p0, Lpx;->b:Lqf;

    return-object v0
.end method
