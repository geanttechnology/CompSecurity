.class public abstract Lorg/springframework/util/ObjectUtils;
.super Ljava/lang/Object;
.source "ObjectUtils.java"


# direct methods
.method public static nullSafeEquals(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 3
    .param p0, "o1"    # Ljava/lang/Object;
    .param p1, "o2"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 246
    if-ne p0, p1, :cond_1

    .line 284
    .end local p0    # "o1":Ljava/lang/Object;
    .end local p1    # "o2":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v0

    .line 249
    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_1
    if-eqz p0, :cond_2

    if-nez p1, :cond_3

    :cond_2
    move v0, v1

    .line 250
    goto :goto_0

    .line 252
    :cond_3
    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 255
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 256
    instance-of v0, p0, [Ljava/lang/Object;

    if-eqz v0, :cond_4

    instance-of v0, p1, [Ljava/lang/Object;

    if-eqz v0, :cond_4

    .line 257
    check-cast p0, [Ljava/lang/Object;

    .end local p0    # "o1":Ljava/lang/Object;
    check-cast p0, [Ljava/lang/Object;

    check-cast p1, [Ljava/lang/Object;

    .end local p1    # "o2":Ljava/lang/Object;
    check-cast p1, [Ljava/lang/Object;

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0

    .line 259
    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_4
    instance-of v0, p0, [Z

    if-eqz v0, :cond_5

    instance-of v0, p1, [Z

    if-eqz v0, :cond_5

    .line 260
    check-cast p0, [Z

    .end local p0    # "o1":Ljava/lang/Object;
    check-cast p0, [Z

    check-cast p1, [Z

    .end local p1    # "o2":Ljava/lang/Object;
    check-cast p1, [Z

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([Z[Z)Z

    move-result v0

    goto :goto_0

    .line 262
    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_5
    instance-of v0, p0, [B

    if-eqz v0, :cond_6

    instance-of v0, p1, [B

    if-eqz v0, :cond_6

    .line 263
    check-cast p0, [B

    .end local p0    # "o1":Ljava/lang/Object;
    check-cast p0, [B

    check-cast p1, [B

    .end local p1    # "o2":Ljava/lang/Object;
    check-cast p1, [B

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v0

    goto :goto_0

    .line 265
    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_6
    instance-of v0, p0, [C

    if-eqz v0, :cond_7

    instance-of v0, p1, [C

    if-eqz v0, :cond_7

    .line 266
    check-cast p0, [C

    .end local p0    # "o1":Ljava/lang/Object;
    check-cast p0, [C

    check-cast p1, [C

    .end local p1    # "o2":Ljava/lang/Object;
    check-cast p1, [C

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([C[C)Z

    move-result v0

    goto :goto_0

    .line 268
    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_7
    instance-of v0, p0, [D

    if-eqz v0, :cond_8

    instance-of v0, p1, [D

    if-eqz v0, :cond_8

    .line 269
    check-cast p0, [D

    .end local p0    # "o1":Ljava/lang/Object;
    check-cast p0, [D

    check-cast p1, [D

    .end local p1    # "o2":Ljava/lang/Object;
    check-cast p1, [D

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([D[D)Z

    move-result v0

    goto/16 :goto_0

    .line 271
    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_8
    instance-of v0, p0, [F

    if-eqz v0, :cond_9

    instance-of v0, p1, [F

    if-eqz v0, :cond_9

    .line 272
    check-cast p0, [F

    .end local p0    # "o1":Ljava/lang/Object;
    check-cast p0, [F

    check-cast p1, [F

    .end local p1    # "o2":Ljava/lang/Object;
    check-cast p1, [F

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([F[F)Z

    move-result v0

    goto/16 :goto_0

    .line 274
    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_9
    instance-of v0, p0, [I

    if-eqz v0, :cond_a

    instance-of v0, p1, [I

    if-eqz v0, :cond_a

    .line 275
    check-cast p0, [I

    .end local p0    # "o1":Ljava/lang/Object;
    check-cast p0, [I

    check-cast p1, [I

    .end local p1    # "o2":Ljava/lang/Object;
    check-cast p1, [I

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([I[I)Z

    move-result v0

    goto/16 :goto_0

    .line 277
    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_a
    instance-of v0, p0, [J

    if-eqz v0, :cond_b

    instance-of v0, p1, [J

    if-eqz v0, :cond_b

    .line 278
    check-cast p0, [J

    .end local p0    # "o1":Ljava/lang/Object;
    check-cast p0, [J

    check-cast p1, [J

    .end local p1    # "o2":Ljava/lang/Object;
    check-cast p1, [J

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([J[J)Z

    move-result v0

    goto/16 :goto_0

    .line 280
    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_b
    instance-of v0, p0, [S

    if-eqz v0, :cond_c

    instance-of v0, p1, [S

    if-eqz v0, :cond_c

    .line 281
    check-cast p0, [S

    .end local p0    # "o1":Ljava/lang/Object;
    check-cast p0, [S

    check-cast p1, [S

    .end local p1    # "o2":Ljava/lang/Object;
    check-cast p1, [S

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([S[S)Z

    move-result v0

    goto/16 :goto_0

    .restart local p0    # "o1":Ljava/lang/Object;
    .restart local p1    # "o2":Ljava/lang/Object;
    :cond_c
    move v0, v1

    .line 284
    goto/16 :goto_0
.end method
