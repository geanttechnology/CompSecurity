.class final Lafe;
.super Lada;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lacy",
        "<",
        "Laex;",
        ">.ada<",
        "Laig;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic b:Lafd;

.field private final c:I

.field private final d:[Ljava/lang/String;


# direct methods
.method public constructor <init>(Lafd;Laig;I[Ljava/lang/String;)V
    .locals 1

    iput-object p1, p0, Lafe;->b:Lafd;

    invoke-direct {p0, p1, p2}, Lada;-><init>(Lacy;Ljava/lang/Object;)V

    invoke-static {p3}, Laia;->a(I)I

    move-result v0

    iput v0, p0, Lafe;->c:I

    iput-object p4, p0, Lafe;->d:[Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 0

    return-void
.end method

.method protected a(Laig;)V
    .locals 2

    if-eqz p1, :cond_0

    iget v0, p0, Lafe;->c:I

    iget-object v1, p0, Lafe;->d:[Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Laig;->a(I[Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method protected synthetic a(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Laig;

    invoke-virtual {p0, p1}, Lafe;->a(Laig;)V

    return-void
.end method
