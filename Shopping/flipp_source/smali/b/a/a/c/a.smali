.class public abstract Lb/a/a/c/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    return-void
.end method

.method private d()I
    .locals 4

    .prologue
    .line 120
    invoke-virtual {p0}, Lb/a/a/c/a;->a()Lb/a/a/c;

    move-result-object v0

    invoke-virtual {p0}, Lb/a/a/c/a;->b()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lb/a/a/c;->a(J)I

    move-result v0

    return v0
.end method


# virtual methods
.method public abstract a()Lb/a/a/c;
.end method

.method public final a(Ljava/util/Locale;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 167
    invoke-virtual {p0}, Lb/a/a/c/a;->a()Lb/a/a/c;

    move-result-object v0

    invoke-virtual {p0}, Lb/a/a/c/a;->b()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3, p1}, Lb/a/a/c;->a(JLjava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public abstract b()J
.end method

.method public final b(Ljava/util/Locale;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 198
    invoke-virtual {p0}, Lb/a/a/c/a;->a()Lb/a/a/c;

    move-result-object v0

    invoke-virtual {p0}, Lb/a/a/c/a;->b()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3, p1}, Lb/a/a/c;->b(JLjava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public c()Lb/a/a/a;
    .locals 2

    .prologue
    .line 101
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 442
    if-ne p0, p1, :cond_1

    .line 449
    :cond_0
    :goto_0
    return v0

    .line 445
    :cond_1
    instance-of v2, p1, Lb/a/a/c/a;

    if-nez v2, :cond_2

    move v0, v1

    .line 446
    goto :goto_0

    .line 448
    :cond_2
    check-cast p1, Lb/a/a/c/a;

    .line 449
    invoke-direct {p0}, Lb/a/a/c/a;->d()I

    move-result v2

    invoke-direct {p1}, Lb/a/a/c/a;->d()I

    move-result v3

    if-ne v2, v3, :cond_3

    invoke-virtual {p0}, Lb/a/a/c/a;->a()Lb/a/a/c;

    move-result-object v2

    invoke-virtual {v2}, Lb/a/a/c;->a()Lb/a/a/d;

    move-result-object v2

    invoke-virtual {p1}, Lb/a/a/c/a;->a()Lb/a/a/c;

    move-result-object v3

    invoke-virtual {v3}, Lb/a/a/c;->a()Lb/a/a/d;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p0}, Lb/a/a/c/a;->c()Lb/a/a/a;

    move-result-object v2

    invoke-virtual {p1}, Lb/a/a/c/a;->c()Lb/a/a/a;

    move-result-object v3

    invoke-static {v2, v3}, Lb/a/a/c/g;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 461
    invoke-direct {p0}, Lb/a/a/c/a;->d()I

    move-result v0

    mul-int/lit8 v0, v0, 0x11

    invoke-virtual {p0}, Lb/a/a/c/a;->a()Lb/a/a/c;

    move-result-object v1

    invoke-virtual {v1}, Lb/a/a/c;->a()Lb/a/a/d;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0}, Lb/a/a/c/a;->c()Lb/a/a/a;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 471
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Property["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lb/a/a/c/a;->a()Lb/a/a/c;

    move-result-object v1

    invoke-virtual {v1}, Lb/a/a/c;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
