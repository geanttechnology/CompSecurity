.class Laqg$1;
.super Ljava/lang/Object;

# interfaces
.implements Laqj;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laqg;-><init>()V
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Laqk;)V
    .locals 1

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p1, v0}, Laqk;->a(Ljava/util/List;)V

    return-void
.end method

.method public a(Ljava/util/List;J)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Laqh;",
            ">;J)V"
        }
    .end annotation

    return-void
.end method
