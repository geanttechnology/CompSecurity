.class public final Lcom/google/android/gms/internal/by;
.super Ljava/lang/Object;


# direct methods
.method public static a(Lcom/google/android/gms/internal/v;)Lcom/google/a/a/a;
    .locals 6

    iget-object v0, p0, Lcom/google/android/gms/internal/v;->e:Ljava/util/List;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/util/HashSet;

    iget-object v1, p0, Lcom/google/android/gms/internal/v;->e:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    :goto_0
    new-instance v2, Lcom/google/a/a/a;

    new-instance v3, Ljava/util/Date;

    iget-wide v4, p0, Lcom/google/android/gms/internal/v;->b:J

    invoke-direct {v3, v4, v5}, Ljava/util/Date;-><init>(J)V

    iget v1, p0, Lcom/google/android/gms/internal/v;->d:I

    packed-switch v1, :pswitch_data_0

    sget v1, Lcom/google/a/b;->a:I

    :goto_1
    iget-boolean v4, p0, Lcom/google/android/gms/internal/v;->f:Z

    invoke-direct {v2, v3, v1, v0, v4}, Lcom/google/a/a/a;-><init>(Ljava/util/Date;ILjava/util/Set;Z)V

    return-object v2

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :pswitch_0
    sget v1, Lcom/google/a/b;->c:I

    goto :goto_1

    :pswitch_1
    sget v1, Lcom/google/a/b;->b:I

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
