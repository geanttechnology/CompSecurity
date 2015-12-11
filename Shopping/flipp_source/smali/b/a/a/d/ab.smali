.class public final Lb/a/a/d/ab;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static a:Lb/a/a/d/ac;


# direct methods
.method public static a()Lb/a/a/d/ac;
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 65
    sget-object v0, Lb/a/a/d/ab;->a:Lb/a/a/d/ac;

    if-nez v0, :cond_0

    .line 66
    new-instance v0, Lb/a/a/d/ad;

    invoke-direct {v0}, Lb/a/a/d/ad;-><init>()V

    const-string v1, "P"

    invoke-virtual {v0}, Lb/a/a/d/ad;->b()V

    new-instance v2, Lb/a/a/d/ah;

    invoke-direct {v2, v1}, Lb/a/a/d/ah;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v2, v2}, Lb/a/a/d/ad;->a(Lb/a/a/d/am;Lb/a/a/d/al;)Lb/a/a/d/ad;

    invoke-virtual {v0, v6}, Lb/a/a/d/ad;->a(I)V

    const-string v1, "Y"

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(Ljava/lang/String;)Lb/a/a/d/ad;

    move-result-object v0

    invoke-virtual {v0, v7}, Lb/a/a/d/ad;->a(I)V

    const-string v1, "M"

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(Ljava/lang/String;)Lb/a/a/d/ad;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(I)V

    const-string v1, "W"

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(Ljava/lang/String;)Lb/a/a/d/ad;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(I)V

    const-string v1, "D"

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(Ljava/lang/String;)Lb/a/a/d/ad;

    move-result-object v2

    const-string v4, "T"

    invoke-virtual {v2}, Lb/a/a/d/ad;->b()V

    iget-object v1, v2, Lb/a/a/d/ad;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_1

    new-instance v0, Lb/a/a/d/aj;

    sget-object v1, Lb/a/a/d/ah;->a:Lb/a/a/d/ah;

    sget-object v3, Lb/a/a/d/ah;->a:Lb/a/a/d/ah;

    invoke-direct {v0, v4, v4, v1, v3}, Lb/a/a/d/aj;-><init>(Ljava/lang/String;Ljava/lang/String;Lb/a/a/d/am;Lb/a/a/d/al;)V

    invoke-virtual {v2, v0, v0}, Lb/a/a/d/ad;->a(Lb/a/a/d/am;Lb/a/a/d/al;)Lb/a/a/d/ad;

    move-object v0, v2

    :goto_0
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(I)V

    const-string v1, "H"

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(Ljava/lang/String;)Lb/a/a/d/ad;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(I)V

    const-string v1, "M"

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(Ljava/lang/String;)Lb/a/a/d/ad;

    move-result-object v0

    const/16 v1, 0x9

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(I)V

    const-string v1, "S"

    invoke-virtual {v0, v1}, Lb/a/a/d/ad;->a(Ljava/lang/String;)Lb/a/a/d/ad;

    move-result-object v0

    invoke-virtual {v0}, Lb/a/a/d/ad;->a()Lb/a/a/d/ac;

    move-result-object v0

    sput-object v0, Lb/a/a/d/ab;->a:Lb/a/a/d/ac;

    .line 85
    :cond_0
    sget-object v0, Lb/a/a/d/ab;->a:Lb/a/a/d/ac;

    return-object v0

    .line 66
    :cond_1
    const/4 v0, 0x0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    :goto_1
    add-int/lit8 v3, v3, -0x1

    if-ltz v3, :cond_4

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    instance-of v5, v5, Lb/a/a/d/aj;

    if-eqz v5, :cond_2

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lb/a/a/d/aj;

    add-int/lit8 v3, v3, 0x1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    invoke-interface {v1, v3, v5}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v1

    move-object v3, v1

    :goto_2
    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_3

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot have two adjacent separators"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    add-int/lit8 v3, v3, -0x1

    goto :goto_1

    :cond_3
    invoke-static {v3}, Lb/a/a/d/ad;->a(Ljava/util/List;)[Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v3}, Ljava/util/List;->clear()V

    new-instance v5, Lb/a/a/d/aj;

    aget-object v0, v1, v6

    check-cast v0, Lb/a/a/d/am;

    aget-object v1, v1, v7

    check-cast v1, Lb/a/a/d/al;

    invoke-direct {v5, v4, v4, v0, v1}, Lb/a/a/d/aj;-><init>(Ljava/lang/String;Ljava/lang/String;Lb/a/a/d/am;Lb/a/a/d/al;)V

    invoke-interface {v3, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-interface {v3, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object v0, v2

    goto :goto_0

    :cond_4
    move-object v3, v1

    goto :goto_2
.end method
