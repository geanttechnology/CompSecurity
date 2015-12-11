.class public abstract Lb/a/a/a/c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb/a/a/aa;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lb/a/a/aa;",
        "Ljava/lang/Comparable",
        "<",
        "Lb/a/a/aa;",
        ">;"
    }
.end annotation


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    return-void
.end method

.method private c(Lb/a/a/d;)I
    .locals 2

    .prologue
    .line 170
    const/4 v0, 0x0

    :goto_0
    const/4 v1, 0x3

    if-ge v0, v1, :cond_1

    .line 171
    invoke-virtual {p0, v0}, Lb/a/a/a/c;->b(I)Lb/a/a/d;

    move-result-object v1

    if-ne v1, p1, :cond_0

    .line 175
    :goto_1
    return v0

    .line 170
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 175
    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method


# virtual methods
.method public a(Lb/a/a/aa;)I
    .locals 5

    .prologue
    const/4 v4, 0x3

    const/4 v0, 0x0

    .line 311
    if-ne p0, p1, :cond_1

    .line 331
    :cond_0
    :goto_0
    return v0

    :cond_1
    move v1, v0

    .line 314
    :goto_1
    if-ge v1, v4, :cond_3

    .line 318
    invoke-virtual {p0, v1}, Lb/a/a/a/c;->b(I)Lb/a/a/d;

    move-result-object v2

    invoke-interface {p1, v1}, Lb/a/a/aa;->b(I)Lb/a/a/d;

    move-result-object v3

    if-eq v2, v3, :cond_2

    .line 319
    new-instance v0, Ljava/lang/ClassCastException;

    const-string v1, "ReadablePartial objects must have matching field types"

    invoke-direct {v0, v1}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 317
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_3
    move v1, v0

    .line 323
    :goto_2
    if-ge v1, v4, :cond_0

    .line 324
    invoke-virtual {p0, v1}, Lb/a/a/a/c;->a(I)I

    move-result v2

    invoke-interface {p1, v1}, Lb/a/a/aa;->a(I)I

    move-result v3

    if-le v2, v3, :cond_4

    .line 325
    const/4 v0, 0x1

    goto :goto_0

    .line 327
    :cond_4
    invoke-virtual {p0, v1}, Lb/a/a/a/c;->a(I)I

    move-result v2

    invoke-interface {p1, v1}, Lb/a/a/aa;->a(I)I

    move-result v3

    if-ge v2, v3, :cond_5

    .line 328
    const/4 v0, -0x1

    goto :goto_0

    .line 323
    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_2
.end method

.method public a(Lb/a/a/d;)I
    .locals 3

    .prologue
    .line 150
    invoke-direct {p0, p1}, Lb/a/a/a/c;->c(Lb/a/a/d;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Field \'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' is not supported"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p0, v0}, Lb/a/a/a/c;->a(I)I

    move-result v0

    return v0
.end method

.method public abstract a(ILb/a/a/a;)Lb/a/a/c;
.end method

.method public final b(I)Lb/a/a/d;
    .locals 1

    .prologue
    .line 79
    invoke-virtual {p0}, Lb/a/a/a/c;->a()Lb/a/a/a;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lb/a/a/a/c;->a(ILb/a/a/a;)Lb/a/a/c;

    move-result-object v0

    invoke-virtual {v0}, Lb/a/a/c;->a()Lb/a/a/d;

    move-result-object v0

    return-object v0
.end method

.method public b(Lb/a/a/d;)Z
    .locals 2

    .prologue
    .line 160
    invoke-direct {p0, p1}, Lb/a/a/a/c;->c(Lb/a/a/d;)I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final c(I)Lb/a/a/c;
    .locals 1

    .prologue
    .line 105
    invoke-virtual {p0}, Lb/a/a/a/c;->a()Lb/a/a/a;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lb/a/a/a/c;->a(ILb/a/a/a;)Lb/a/a/c;

    move-result-object v0

    return-object v0
.end method

.method public synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 46
    check-cast p1, Lb/a/a/aa;

    invoke-virtual {p0, p1}, Lb/a/a/a/c;->a(Lb/a/a/aa;)I

    move-result v0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 255
    if-ne p0, p1, :cond_1

    .line 256
    const/4 v0, 0x1

    .line 270
    :cond_0
    :goto_0
    return v0

    .line 258
    :cond_1
    instance-of v1, p1, Lb/a/a/aa;

    if-eqz v1, :cond_0

    .line 261
    check-cast p1, Lb/a/a/aa;

    move v1, v0

    .line 262
    :goto_1
    const/4 v2, 0x3

    if-ge v1, v2, :cond_2

    .line 266
    invoke-virtual {p0, v1}, Lb/a/a/a/c;->a(I)I

    move-result v2

    invoke-interface {p1, v1}, Lb/a/a/aa;->a(I)I

    move-result v3

    if-ne v2, v3, :cond_0

    invoke-virtual {p0, v1}, Lb/a/a/a/c;->b(I)Lb/a/a/d;

    move-result-object v2

    invoke-interface {p1, v1}, Lb/a/a/aa;->b(I)Lb/a/a/d;

    move-result-object v3

    if-ne v2, v3, :cond_0

    .line 265
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 270
    :cond_2
    invoke-virtual {p0}, Lb/a/a/a/c;->a()Lb/a/a/a;

    move-result-object v0

    invoke-interface {p1}, Lb/a/a/aa;->a()Lb/a/a/a;

    move-result-object v1

    invoke-static {v0, v1}, Lb/a/a/c/g;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 280
    const/16 v1, 0x9d

    .line 281
    const/4 v0, 0x0

    :goto_0
    const/4 v2, 0x3

    if-ge v0, v2, :cond_0

    .line 282
    mul-int/lit8 v1, v1, 0x17

    invoke-virtual {p0, v0}, Lb/a/a/a/c;->a(I)I

    move-result v2

    add-int/2addr v1, v2

    .line 283
    mul-int/lit8 v1, v1, 0x17

    invoke-virtual {p0, v0}, Lb/a/a/a/c;->b(I)Lb/a/a/d;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int/2addr v1, v2

    .line 281
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 285
    :cond_0
    invoke-virtual {p0}, Lb/a/a/a/c;->a()Lb/a/a/a;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    add-int/2addr v0, v1

    .line 286
    return v0
.end method
