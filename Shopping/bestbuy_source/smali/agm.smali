.class public final Lagm;
.super Lagu;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lagu",
        "<",
        "Lagm;",
        ">;"
    }
.end annotation


# instance fields
.field public a:[Lagn;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lagu;-><init>()V

    invoke-virtual {p0}, Lagm;->a()Lagm;

    return-void
.end method

.method public static a([B)Lagm;
    .locals 1

    new-instance v0, Lagm;

    invoke-direct {v0}, Lagm;-><init>()V

    invoke-static {v0, p0}, Laha;->a(Laha;[B)Laha;

    move-result-object v0

    check-cast v0, Lagm;

    return-object v0
.end method


# virtual methods
.method public a()Lagm;
    .locals 1

    invoke-static {}, Lagn;->a()[Lagn;

    move-result-object v0

    iput-object v0, p0, Lagm;->a:[Lagn;

    const/4 v0, 0x0

    iput-object v0, p0, Lagm;->o:Lagw;

    const/4 v0, -0x1

    iput v0, p0, Lagm;->p:I

    return-object p0
.end method

.method public a(Lagr;)Lagm;
    .locals 4

    const/4 v1, 0x0

    :cond_0
    :goto_0
    invoke-virtual {p1}, Lagr;->a()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    invoke-virtual {p0, p1, v0}, Lagm;->a(Lagr;I)Z

    move-result v0

    if-nez v0, :cond_0

    :sswitch_0
    return-object p0

    :sswitch_1
    const/16 v0, 0xa

    invoke-static {p1, v0}, Lahd;->a(Lagr;I)I

    move-result v2

    iget-object v0, p0, Lagm;->a:[Lagn;

    if-nez v0, :cond_2

    move v0, v1

    :goto_1
    add-int/2addr v2, v0

    new-array v2, v2, [Lagn;

    if-eqz v0, :cond_1

    iget-object v3, p0, Lagm;->a:[Lagn;

    invoke-static {v3, v1, v2, v1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_1
    :goto_2
    array-length v3, v2

    add-int/lit8 v3, v3, -0x1

    if-ge v0, v3, :cond_3

    new-instance v3, Lagn;

    invoke-direct {v3}, Lagn;-><init>()V

    aput-object v3, v2, v0

    aget-object v3, v2, v0

    invoke-virtual {p1, v3}, Lagr;->a(Laha;)V

    invoke-virtual {p1}, Lagr;->a()I

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_2
    iget-object v0, p0, Lagm;->a:[Lagn;

    array-length v0, v0

    goto :goto_1

    :cond_3
    new-instance v3, Lagn;

    invoke-direct {v3}, Lagn;-><init>()V

    aput-object v3, v2, v0

    aget-object v0, v2, v0

    invoke-virtual {p1, v0}, Lagr;->a(Laha;)V

    iput-object v2, p0, Lagm;->a:[Lagn;

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0xa -> :sswitch_1
    .end sparse-switch
.end method

.method public a(Lags;)V
    .locals 3

    iget-object v0, p0, Lagm;->a:[Lagn;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lagm;->a:[Lagn;

    array-length v0, v0

    if-lez v0, :cond_1

    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Lagm;->a:[Lagn;

    array-length v1, v1

    if-ge v0, v1, :cond_1

    iget-object v1, p0, Lagm;->a:[Lagn;

    aget-object v1, v1, v0

    if-eqz v1, :cond_0

    const/4 v2, 0x1

    invoke-virtual {p1, v2, v1}, Lags;->a(ILaha;)V

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    invoke-super {p0, p1}, Lagu;->a(Lags;)V

    return-void
.end method

.method public synthetic b(Lagr;)Laha;
    .locals 1

    invoke-virtual {p0, p1}, Lagm;->a(Lagr;)Lagm;

    move-result-object v0

    return-object v0
.end method

.method protected c()I
    .locals 4

    invoke-super {p0}, Lagu;->c()I

    move-result v1

    iget-object v0, p0, Lagm;->a:[Lagn;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lagm;->a:[Lagn;

    array-length v0, v0

    if-lez v0, :cond_1

    const/4 v0, 0x0

    :goto_0
    iget-object v2, p0, Lagm;->a:[Lagn;

    array-length v2, v2

    if-ge v0, v2, :cond_1

    iget-object v2, p0, Lagm;->a:[Lagn;

    aget-object v2, v2, v0

    if-eqz v2, :cond_0

    const/4 v3, 0x1

    invoke-static {v3, v2}, Lags;->c(ILaha;)I

    move-result v2

    add-int/2addr v1, v2

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return v1
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 3

    const/4 v0, 0x0

    if-ne p1, p0, :cond_1

    const/4 v0, 0x1

    :cond_0
    :goto_0
    return v0

    :cond_1
    instance-of v1, p1, Lagm;

    if-eqz v1, :cond_0

    check-cast p1, Lagm;

    iget-object v1, p0, Lagm;->a:[Lagn;

    iget-object v2, p1, Lagm;->a:[Lagn;

    invoke-static {v1, v2}, Lagy;->a([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0, p1}, Lagm;->a(Lagu;)Z

    move-result v0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 2

    iget-object v0, p0, Lagm;->a:[Lagn;

    invoke-static {v0}, Lagy;->a([Ljava/lang/Object;)I

    move-result v0

    add-int/lit16 v0, v0, 0x20f

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lagm;->d()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method
