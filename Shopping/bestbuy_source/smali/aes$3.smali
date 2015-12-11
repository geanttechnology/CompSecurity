.class Laes$3;
.super Laet;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laes;->a(Lqm;Ljava/util/List;)Lqq;
.end annotation


# instance fields
.field final synthetic b:Ljava/util/List;

.field final synthetic c:Laes;


# direct methods
.method constructor <init>(Laes;Lqm;Ljava/util/List;)V
    .locals 0

    iput-object p1, p0, Laes$3;->c:Laes;

    iput-object p3, p0, Laes$3;->b:Ljava/util/List;

    invoke-direct {p0, p2}, Laet;-><init>(Lqm;)V

    return-void
.end method


# virtual methods
.method protected a(Lafd;)V
    .locals 2

    new-instance v0, Laes$3$1;

    invoke-direct {v0, p0}, Laes$3$1;-><init>(Laes$3;)V

    iget-object v1, p0, Laes$3;->b:Ljava/util/List;

    invoke-virtual {p1, v1, v0}, Lafd;->a(Ljava/util/List;Laih;)V

    return-void
.end method

.method protected synthetic b(Lqd;)V
    .locals 0

    check-cast p1, Lafd;

    invoke-virtual {p0, p1}, Laes$3;->a(Lafd;)V

    return-void
.end method
