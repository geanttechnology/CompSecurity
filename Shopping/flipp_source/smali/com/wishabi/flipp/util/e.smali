.class public final Lcom/wishabi/flipp/util/e;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Landroid/content/res/Resources;Lb/a/a/b;Lb/a/a/b;Lb/a/a/b;)Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 13
    invoke-virtual {p2, p1}, Lb/a/a/b;->a(Lb/a/a/z;)I

    move-result v0

    if-gez v0, :cond_3

    .line 14
    invoke-virtual {p2}, Lb/a/a/b;->c_()Lb/a/a/r;

    move-result-object v0

    invoke-virtual {p1}, Lb/a/a/b;->c_()Lb/a/a/r;

    move-result-object v1

    invoke-static {v0, v1}, Lb/a/a/k;->a(Lb/a/a/aa;Lb/a/a/aa;)Lb/a/a/k;

    move-result-object v0

    iget v0, v0, Lb/a/a/a/f;->p:I

    .line 16
    const/4 v1, 0x7

    if-le v0, v1, :cond_0

    .line 17
    const v0, 0x7f0e013e

    new-array v1, v7, [Ljava/lang/Object;

    invoke-virtual {p1}, Lb/a/a/b;->c()Ljava/util/Date;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-virtual {p1}, Lb/a/a/b;->c()Ljava/util/Date;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-virtual {p0, v0, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 52
    :goto_0
    return-object v0

    .line 19
    :cond_0
    if-le v0, v5, :cond_1

    .line 20
    const v0, 0x7f0e013f

    new-array v1, v5, [Ljava/lang/Object;

    invoke-virtual {p1}, Lb/a/a/b;->c()Ljava/util/Date;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-virtual {p0, v0, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 21
    :cond_1
    if-lez v0, :cond_2

    .line 22
    const v0, 0x7f0e0141

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 24
    :cond_2
    const v0, 0x7f0e0140

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 27
    :cond_3
    invoke-virtual {p2, p3}, Lb/a/a/b;->a(Lb/a/a/z;)I

    move-result v0

    if-ltz v0, :cond_4

    .line 28
    const v0, 0x7f0e0095

    new-array v1, v7, [Ljava/lang/Object;

    invoke-virtual {p3}, Lb/a/a/b;->c()Ljava/util/Date;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-virtual {p3}, Lb/a/a/b;->c()Ljava/util/Date;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-virtual {p0, v0, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 30
    :cond_4
    invoke-static {p2, p3}, Lb/a/a/ad;->a(Lb/a/a/z;Lb/a/a/z;)Lb/a/a/ad;

    move-result-object v0

    iget v0, v0, Lb/a/a/a/f;->p:I

    .line 31
    invoke-static {p2, p3}, Lb/a/a/s;->a(Lb/a/a/z;Lb/a/a/z;)Lb/a/a/s;

    move-result-object v1

    iget v1, v1, Lb/a/a/a/f;->p:I

    .line 32
    invoke-static {p2, p3}, Lb/a/a/ac;->a(Lb/a/a/z;Lb/a/a/z;)Lb/a/a/ac;

    move-result-object v2

    iget v2, v2, Lb/a/a/a/f;->p:I

    .line 33
    invoke-virtual {p2}, Lb/a/a/b;->c_()Lb/a/a/r;

    move-result-object v3

    invoke-virtual {p3}, Lb/a/a/b;->c_()Lb/a/a/r;

    move-result-object v4

    invoke-static {v3, v4}, Lb/a/a/k;->a(Lb/a/a/aa;Lb/a/a/aa;)Lb/a/a/k;

    move-result-object v3

    iget v3, v3, Lb/a/a/a/f;->p:I

    .line 36
    if-lez v0, :cond_5

    .line 37
    const v1, 0x7f0d000b

    new-array v2, v5, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p0, v1, v0, v2}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 39
    :cond_5
    if-lez v1, :cond_6

    .line 40
    const v0, 0x7f0d0005

    new-array v2, v5, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p0, v0, v1, v2}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 42
    :cond_6
    if-lez v2, :cond_7

    .line 43
    const v0, 0x7f0d000a

    new-array v1, v5, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v6

    invoke-virtual {p0, v0, v2, v1}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 45
    :cond_7
    if-le v3, v5, :cond_8

    .line 46
    const v0, 0x7f0e0159

    new-array v1, v5, [Ljava/lang/Object;

    invoke-virtual {p3}, Lb/a/a/b;->c()Ljava/util/Date;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-virtual {p0, v0, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 47
    :cond_8
    if-lez v3, :cond_9

    .line 48
    const v0, 0x7f0e015a

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 49
    :cond_9
    if-nez v3, :cond_a

    .line 50
    const v0, 0x7f0e0096

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 52
    :cond_a
    const v0, 0x7f0e0158

    new-array v1, v7, [Ljava/lang/Object;

    invoke-virtual {p3}, Lb/a/a/b;->c()Ljava/util/Date;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-virtual {p3}, Lb/a/a/b;->c()Ljava/util/Date;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-virtual {p0, v0, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0
.end method
