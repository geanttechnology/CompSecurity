.class final Lb/a/a/b/m;
.super Lb/a/a/c/h;
.source "SourceFile"


# instance fields
.field protected final a:Lb/a/a/b/d;


# direct methods
.method constructor <init>(Lb/a/a/b/d;)V
    .locals 4

    .prologue
    .line 46
    invoke-static {}, Lb/a/a/d;->s()Lb/a/a/d;

    move-result-object v0

    invoke-virtual {p1}, Lb/a/a/b/d;->Q()J

    move-result-wide v2

    invoke-direct {p0, v0, v2, v3}, Lb/a/a/c/h;-><init>(Lb/a/a/d;J)V

    .line 47
    iput-object p1, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    .line 48
    return-void
.end method


# virtual methods
.method public final a(J)I
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {v0, p1, p2}, Lb/a/a/b/d;->a(J)I

    move-result v0

    return v0
.end method

.method public final a(JI)J
    .locals 5

    .prologue
    .line 59
    if-nez p3, :cond_0

    .line 64
    :goto_0
    return-wide p1

    .line 62
    :cond_0
    invoke-virtual {p0, p1, p2}, Lb/a/a/b/m;->a(J)I

    move-result v0

    .line 63
    add-int v1, v0, p3

    xor-int v2, v0, v1

    if-gez v2, :cond_1

    xor-int v2, v0, p3

    if-ltz v2, :cond_1

    new-instance v1, Ljava/lang/ArithmeticException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "The calculation caused an overflow: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " + "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 64
    :cond_1
    invoke-virtual {p0, p1, p2, v1}, Lb/a/a/b/m;->b(JI)J

    move-result-wide p1

    goto :goto_0
.end method

.method public final a(JJ)J
    .locals 3

    .prologue
    .line 68
    invoke-static {p3, p4}, Lb/a/a/c/g;->a(J)I

    move-result v0

    invoke-virtual {p0, p1, p2, v0}, Lb/a/a/b/m;->a(JI)J

    move-result-wide v0

    return-wide v0
.end method

.method public final b(JI)J
    .locals 3

    .prologue
    .line 83
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {v0}, Lb/a/a/b/d;->N()I

    move-result v0

    iget-object v1, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {v1}, Lb/a/a/b/d;->O()I

    move-result v1

    invoke-static {p0, p3, v0, v1}, Lb/a/a/c/g;->a(Lb/a/a/c;III)V

    .line 85
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {v0, p1, p2, p3}, Lb/a/a/b/d;->d(JI)J

    move-result-wide v0

    return-wide v0
.end method

.method public final b(J)Z
    .locals 3

    .prologue
    .line 100
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {p0, p1, p2}, Lb/a/a/b/m;->a(J)I

    move-result v1

    invoke-virtual {v0, v1}, Lb/a/a/b/d;->c(I)Z

    move-result v0

    return v0
.end method

.method public final c(JJ)J
    .locals 3

    .prologue
    .line 89
    cmp-long v0, p1, p3

    if-gez v0, :cond_0

    .line 90
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {v0, p3, p4, p1, p2}, Lb/a/a/b/d;->a(JJ)J

    move-result-wide v0

    neg-long v0, v0

    .line 92
    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {v0, p1, p2, p3, p4}, Lb/a/a/b/d;->a(JJ)J

    move-result-wide v0

    goto :goto_0
.end method

.method public final d(J)J
    .locals 3

    .prologue
    .line 124
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {p0, p1, p2}, Lb/a/a/b/m;->a(J)I

    move-result v1

    invoke-virtual {v0, v1}, Lb/a/a/b/d;->b(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public final e(J)J
    .locals 5

    .prologue
    .line 128
    invoke-virtual {p0, p1, p2}, Lb/a/a/b/m;->a(J)I

    move-result v0

    .line 129
    iget-object v1, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {v1, v0}, Lb/a/a/b/d;->b(I)J

    move-result-wide v2

    .line 130
    cmp-long v1, p1, v2

    if-eqz v1, :cond_0

    .line 132
    iget-object v1, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {v1, v0}, Lb/a/a/b/d;->b(I)J

    move-result-wide p1

    .line 134
    :cond_0
    return-wide p1
.end method

.method public final e()Lb/a/a/l;
    .locals 1

    .prologue
    .line 96
    const/4 v0, 0x0

    return-object v0
.end method

.method public final f()Lb/a/a/l;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    iget-object v0, v0, Lb/a/a/b/a;->c:Lb/a/a/l;

    return-object v0
.end method

.method public final g()I
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {v0}, Lb/a/a/b/d;->N()I

    move-result v0

    return v0
.end method

.method public final h()I
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lb/a/a/b/m;->a:Lb/a/a/b/d;

    invoke-virtual {v0}, Lb/a/a/b/d;->O()I

    move-result v0

    return v0
.end method

.method public final i(J)J
    .locals 3

    .prologue
    .line 138
    invoke-virtual {p0, p1, p2}, Lb/a/a/b/m;->d(J)J

    move-result-wide v0

    sub-long v0, p1, v0

    return-wide v0
.end method
