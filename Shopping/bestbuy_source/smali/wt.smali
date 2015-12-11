.class public final Lwt;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# direct methods
.method public static a(I)Lnw;
    .locals 1

    packed-switch p0, :pswitch_data_0

    sget-object v0, Lnw;->a:Lnw;

    :goto_0
    return-object v0

    :pswitch_0
    sget-object v0, Lnw;->c:Lnw;

    goto :goto_0

    :pswitch_1
    sget-object v0, Lnw;->b:Lnw;

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static a(Lcom/google/android/gms/internal/ay;)Lnx;
    .locals 4

    const/4 v0, 0x0

    const/4 v1, 0x6

    new-array v1, v1, [Lnx;

    sget-object v2, Lnx;->a:Lnx;

    aput-object v2, v1, v0

    const/4 v2, 0x1

    sget-object v3, Lnx;->b:Lnx;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    sget-object v3, Lnx;->c:Lnx;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    sget-object v3, Lnx;->d:Lnx;

    aput-object v3, v1, v2

    const/4 v2, 0x4

    sget-object v3, Lnx;->e:Lnx;

    aput-object v3, v1, v2

    const/4 v2, 0x5

    sget-object v3, Lnx;->f:Lnx;

    aput-object v3, v1, v2

    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_1

    aget-object v2, v1, v0

    invoke-virtual {v2}, Lnx;->a()I

    move-result v2

    iget v3, p0, Lcom/google/android/gms/internal/ay;->f:I

    if-ne v2, v3, :cond_0

    aget-object v2, v1, v0

    invoke-virtual {v2}, Lnx;->b()I

    move-result v2

    iget v3, p0, Lcom/google/android/gms/internal/ay;->c:I

    if-ne v2, v3, :cond_0

    aget-object v0, v1, v0

    :goto_1
    return-object v0

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    new-instance v0, Lnx;

    iget v1, p0, Lcom/google/android/gms/internal/ay;->f:I

    iget v2, p0, Lcom/google/android/gms/internal/ay;->c:I

    iget-object v3, p0, Lcom/google/android/gms/internal/ay;->b:Ljava/lang/String;

    invoke-static {v1, v2, v3}, Loq;->a(IILjava/lang/String;)Loo;

    move-result-object v1

    invoke-direct {v0, v1}, Lnx;-><init>(Loo;)V

    goto :goto_1
.end method

.method public static a(Lcom/google/android/gms/internal/av;)Lny;
    .locals 6

    iget-object v0, p0, Lcom/google/android/gms/internal/av;->e:Ljava/util/List;

    if-eqz v0, :cond_0

    new-instance v3, Ljava/util/HashSet;

    iget-object v0, p0, Lcom/google/android/gms/internal/av;->e:Ljava/util/List;

    invoke-direct {v3, v0}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    :goto_0
    new-instance v0, Lny;

    new-instance v1, Ljava/util/Date;

    iget-wide v4, p0, Lcom/google/android/gms/internal/av;->b:J

    invoke-direct {v1, v4, v5}, Ljava/util/Date;-><init>(J)V

    iget v2, p0, Lcom/google/android/gms/internal/av;->d:I

    invoke-static {v2}, Lwt;->a(I)Lnw;

    move-result-object v2

    iget-boolean v4, p0, Lcom/google/android/gms/internal/av;->f:Z

    iget-object v5, p0, Lcom/google/android/gms/internal/av;->k:Landroid/location/Location;

    invoke-direct/range {v0 .. v5}, Lny;-><init>(Ljava/util/Date;Lnw;Ljava/util/Set;ZLandroid/location/Location;)V

    return-object v0

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method
