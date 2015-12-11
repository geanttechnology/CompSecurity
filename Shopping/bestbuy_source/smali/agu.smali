.class public abstract Lagu;
.super Laha;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<M:",
        "Lagu",
        "<TM;>;>",
        "Laha;"
    }
.end annotation


# instance fields
.field protected o:Lagw;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Laha;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lags;)V
    .locals 2

    iget-object v0, p0, Lagu;->o:Lagw;

    if-nez v0, :cond_1

    :cond_0
    return-void

    :cond_1
    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Lagu;->o:Lagw;

    invoke-virtual {v1}, Lagw;->a()I

    move-result v1

    if-ge v0, v1, :cond_0

    iget-object v1, p0, Lagu;->o:Lagw;

    invoke-virtual {v1, v0}, Lagw;->b(I)Lagx;

    move-result-object v1

    invoke-virtual {v1, p1}, Lagx;->a(Lags;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method protected final a(Lagr;I)Z
    .locals 4

    invoke-virtual {p1}, Lagr;->q()I

    move-result v0

    invoke-virtual {p1, p2}, Lagr;->b(I)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-static {p2}, Lahd;->b(I)I

    move-result v1

    invoke-virtual {p1}, Lagr;->q()I

    move-result v2

    sub-int/2addr v2, v0

    invoke-virtual {p1, v0, v2}, Lagr;->a(II)[B

    move-result-object v0

    new-instance v2, Lahc;

    invoke-direct {v2, p2, v0}, Lahc;-><init>(I[B)V

    const/4 v0, 0x0

    iget-object v3, p0, Lagu;->o:Lagw;

    if-nez v3, :cond_2

    new-instance v3, Lagw;

    invoke-direct {v3}, Lagw;-><init>()V

    iput-object v3, p0, Lagu;->o:Lagw;

    :goto_1
    if-nez v0, :cond_1

    new-instance v0, Lagx;

    invoke-direct {v0}, Lagx;-><init>()V

    iget-object v3, p0, Lagu;->o:Lagw;

    invoke-virtual {v3, v1, v0}, Lagw;->a(ILagx;)V

    :cond_1
    invoke-virtual {v0, v2}, Lagx;->a(Lahc;)V

    const/4 v0, 0x1

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lagu;->o:Lagw;

    invoke-virtual {v0, v1}, Lagw;->a(I)Lagx;

    move-result-object v0

    goto :goto_1
.end method

.method protected final a(Lagu;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TM;)Z"
        }
    .end annotation

    iget-object v0, p0, Lagu;->o:Lagw;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lagu;->o:Lagw;

    invoke-virtual {v0}, Lagw;->b()Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_0
    iget-object v0, p1, Lagu;->o:Lagw;

    if-eqz v0, :cond_1

    iget-object v0, p1, Lagu;->o:Lagw;

    invoke-virtual {v0}, Lagw;->b()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lagu;->o:Lagw;

    iget-object v1, p1, Lagu;->o:Lagw;

    invoke-virtual {v0, v1}, Lagw;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method protected c()I
    .locals 3

    const/4 v0, 0x0

    iget-object v1, p0, Lagu;->o:Lagw;

    if-eqz v1, :cond_0

    move v1, v0

    :goto_0
    iget-object v2, p0, Lagu;->o:Lagw;

    invoke-virtual {v2}, Lagw;->a()I

    move-result v2

    if-ge v0, v2, :cond_1

    iget-object v2, p0, Lagu;->o:Lagw;

    invoke-virtual {v2, v0}, Lagw;->b(I)Lagx;

    move-result-object v2

    invoke-virtual {v2}, Lagx;->a()I

    move-result v2

    add-int/2addr v1, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    move v1, v0

    :cond_1
    return v1
.end method

.method protected final d()I
    .locals 1

    iget-object v0, p0, Lagu;->o:Lagw;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lagu;->o:Lagw;

    invoke-virtual {v0}, Lagw;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lagu;->o:Lagw;

    invoke-virtual {v0}, Lagw;->hashCode()I

    move-result v0

    goto :goto_0
.end method
