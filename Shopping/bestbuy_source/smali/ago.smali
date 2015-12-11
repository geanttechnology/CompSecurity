.class public final Lago;
.super Lagu;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lagu",
        "<",
        "Lago;",
        ">;"
    }
.end annotation


# static fields
.field private static volatile c:[Lago;


# instance fields
.field public a:I

.field public b:Lagp;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lagu;-><init>()V

    invoke-virtual {p0}, Lago;->b()Lago;

    return-void
.end method

.method public static a()[Lago;
    .locals 2

    sget-object v0, Lago;->c:[Lago;

    if-nez v0, :cond_1

    sget-object v1, Lagy;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lago;->c:[Lago;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    new-array v0, v0, [Lago;

    sput-object v0, Lago;->c:[Lago;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lago;->c:[Lago;

    return-object v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method


# virtual methods
.method public a(Lagr;)Lago;
    .locals 1

    :cond_0
    :goto_0
    invoke-virtual {p1}, Lagr;->a()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    invoke-virtual {p0, p1, v0}, Lago;->a(Lagr;I)Z

    move-result v0

    if-nez v0, :cond_0

    :sswitch_0
    return-object p0

    :sswitch_1
    invoke-virtual {p1}, Lagr;->f()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    :pswitch_0
    iput v0, p0, Lago;->a:I

    goto :goto_0

    :sswitch_2
    iget-object v0, p0, Lago;->b:Lagp;

    if-nez v0, :cond_1

    new-instance v0, Lagp;

    invoke-direct {v0}, Lagp;-><init>()V

    iput-object v0, p0, Lago;->b:Lagp;

    :cond_1
    iget-object v0, p0, Lago;->b:Lagp;

    invoke-virtual {p1, v0}, Lagr;->a(Laha;)V

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x8 -> :sswitch_1
        0x12 -> :sswitch_2
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public a(Lags;)V
    .locals 2

    const/4 v0, 0x1

    iget v1, p0, Lago;->a:I

    invoke-virtual {p1, v0, v1}, Lags;->a(II)V

    iget-object v0, p0, Lago;->b:Lagp;

    if-eqz v0, :cond_0

    const/4 v0, 0x2

    iget-object v1, p0, Lago;->b:Lagp;

    invoke-virtual {p1, v0, v1}, Lags;->a(ILaha;)V

    :cond_0
    invoke-super {p0, p1}, Lagu;->a(Lags;)V

    return-void
.end method

.method public b()Lago;
    .locals 2

    const/4 v1, 0x0

    const/4 v0, 0x1

    iput v0, p0, Lago;->a:I

    iput-object v1, p0, Lago;->b:Lagp;

    iput-object v1, p0, Lago;->o:Lagw;

    const/4 v0, -0x1

    iput v0, p0, Lago;->p:I

    return-object p0
.end method

.method public synthetic b(Lagr;)Laha;
    .locals 1

    invoke-virtual {p0, p1}, Lago;->a(Lagr;)Lago;

    move-result-object v0

    return-object v0
.end method

.method protected c()I
    .locals 3

    invoke-super {p0}, Lagu;->c()I

    move-result v0

    const/4 v1, 0x1

    iget v2, p0, Lago;->a:I

    invoke-static {v1, v2}, Lags;->c(II)I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lago;->b:Lagp;

    if-eqz v1, :cond_0

    const/4 v1, 0x2

    iget-object v2, p0, Lago;->b:Lagp;

    invoke-static {v1, v2}, Lags;->c(ILaha;)I

    move-result v1

    add-int/2addr v0, v1

    :cond_0
    return v0
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
    instance-of v1, p1, Lago;

    if-eqz v1, :cond_0

    check-cast p1, Lago;

    iget v1, p0, Lago;->a:I

    iget v2, p1, Lago;->a:I

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lago;->b:Lagp;

    if-nez v1, :cond_3

    iget-object v1, p1, Lago;->b:Lagp;

    if-nez v1, :cond_0

    :cond_2
    invoke-virtual {p0, p1}, Lago;->a(Lagu;)Z

    move-result v0

    goto :goto_0

    :cond_3
    iget-object v1, p0, Lago;->b:Lagp;

    iget-object v2, p1, Lago;->b:Lagp;

    invoke-virtual {v1, v2}, Lagp;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    goto :goto_0
.end method

.method public hashCode()I
    .locals 2

    iget v0, p0, Lago;->a:I

    add-int/lit16 v0, v0, 0x20f

    mul-int/lit8 v1, v0, 0x1f

    iget-object v0, p0, Lago;->b:Lagp;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lago;->d()I

    move-result v1

    add-int/2addr v0, v1

    return v0

    :cond_0
    iget-object v0, p0, Lago;->b:Lagp;

    invoke-virtual {v0}, Lagp;->hashCode()I

    move-result v0

    goto :goto_0
.end method
