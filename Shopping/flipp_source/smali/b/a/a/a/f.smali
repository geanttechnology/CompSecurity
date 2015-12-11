.class public abstract Lb/a/a/a/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb/a/a/ab;
.implements Ljava/io/Serializable;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lb/a/a/ab;",
        "Ljava/io/Serializable;",
        "Ljava/lang/Comparable",
        "<",
        "Lb/a/a/a/f;",
        ">;"
    }
.end annotation


# instance fields
.field public volatile p:I


# direct methods
.method public constructor <init>(I)V
    .locals 0

    .prologue
    .line 157
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 158
    iput p1, p0, Lb/a/a/a/f;->p:I

    .line 159
    return-void
.end method

.method public static a(Lb/a/a/z;Lb/a/a/z;Lb/a/a/m;)I
    .locals 6

    .prologue
    .line 68
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 69
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "ReadableInstant objects must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 71
    :cond_1
    invoke-static {p0}, Lb/a/a/f;->b(Lb/a/a/z;)Lb/a/a/a;

    move-result-object v0

    .line 72
    invoke-virtual {p2, v0}, Lb/a/a/m;->a(Lb/a/a/a;)Lb/a/a/l;

    move-result-object v0

    invoke-interface {p1}, Lb/a/a/z;->a()J

    move-result-wide v2

    invoke-interface {p0}, Lb/a/a/z;->a()J

    move-result-wide v4

    invoke-virtual {v0, v2, v3, v4, v5}, Lb/a/a/l;->b(JJ)I

    move-result v0

    .line 73
    return v0
.end method


# virtual methods
.method public abstract a()Lb/a/a/m;
.end method

.method public abstract b()Lb/a/a/v;
.end method

.method public final c()Lb/a/a/m;
    .locals 1

    .prologue
    .line 217
    invoke-virtual {p0}, Lb/a/a/a/f;->a()Lb/a/a/m;

    move-result-object v0

    return-object v0
.end method

.method public synthetic compareTo(Ljava/lang/Object;)I
    .locals 3

    .prologue
    .line 46
    check-cast p1, Lb/a/a/a/f;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    if-eq v0, v1, :cond_0

    new-instance v0, Ljava/lang/ClassCastException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " cannot be compared to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget v0, p1, Lb/a/a/a/f;->p:I

    iget v1, p0, Lb/a/a/a/f;->p:I

    if-le v1, v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    if-ge v1, v0, :cond_2

    const/4 v0, -0x1

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final d()I
    .locals 1

    .prologue
    .line 233
    iget v0, p0, Lb/a/a/a/f;->p:I

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 301
    if-ne p0, p1, :cond_1

    .line 308
    :cond_0
    :goto_0
    return v0

    .line 304
    :cond_1
    instance-of v2, p1, Lb/a/a/ab;

    if-nez v2, :cond_2

    move v0, v1

    .line 305
    goto :goto_0

    .line 307
    :cond_2
    check-cast p1, Lb/a/a/ab;

    .line 308
    invoke-interface {p1}, Lb/a/a/ab;->b()Lb/a/a/v;

    move-result-object v2

    invoke-virtual {p0}, Lb/a/a/a/f;->b()Lb/a/a/v;

    move-result-object v3

    if-ne v2, v3, :cond_3

    invoke-interface {p1}, Lb/a/a/ab;->d()I

    move-result v2

    iget v3, p0, Lb/a/a/a/f;->p:I

    if-eq v2, v3, :cond_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 317
    iget v0, p0, Lb/a/a/a/f;->p:I

    add-int/lit16 v0, v0, 0x1cb

    .line 319
    mul-int/lit8 v0, v0, 0x1b

    invoke-virtual {p0}, Lb/a/a/a/f;->a()Lb/a/a/m;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    .line 320
    return v0
.end method
