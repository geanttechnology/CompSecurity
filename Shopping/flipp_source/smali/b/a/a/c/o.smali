.class public final Lb/a/a/c/o;
.super Lb/a/a/c/d;
.source "SourceFile"


# instance fields
.field final a:I

.field final c:Lb/a/a/l;


# direct methods
.method public constructor <init>(Lb/a/a/c/f;)V
    .locals 1

    .prologue
    .line 77
    iget-object v0, p1, Lb/a/a/c/b;->g:Lb/a/a/d;

    invoke-direct {p0, p1, v0}, Lb/a/a/c/o;-><init>(Lb/a/a/c/f;Lb/a/a/d;)V

    .line 78
    return-void
.end method

.method public constructor <init>(Lb/a/a/c/f;Lb/a/a/d;)V
    .locals 1

    .prologue
    .line 88
    iget-object v0, p1, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-direct {p0, v0, p2}, Lb/a/a/c/d;-><init>(Lb/a/a/c;Lb/a/a/d;)V

    .line 89
    iget v0, p1, Lb/a/a/c/f;->a:I

    iput v0, p0, Lb/a/a/c/o;->a:I

    .line 90
    iget-object v0, p1, Lb/a/a/c/f;->c:Lb/a/a/l;

    iput-object v0, p0, Lb/a/a/c/o;->c:Lb/a/a/l;

    .line 91
    return-void
.end method

.method public constructor <init>(Lb/a/a/c;Lb/a/a/d;)V
    .locals 3

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Lb/a/a/c/d;-><init>(Lb/a/a/c;Lb/a/a/d;)V

    .line 55
    invoke-virtual {p1}, Lb/a/a/c;->d()Lb/a/a/l;

    move-result-object v0

    .line 60
    if-nez v0, :cond_0

    .line 61
    const/4 v0, 0x0

    iput-object v0, p0, Lb/a/a/c/o;->c:Lb/a/a/l;

    .line 67
    :goto_0
    const/16 v0, 0x64

    iput v0, p0, Lb/a/a/c/o;->a:I

    .line 68
    return-void

    .line 63
    :cond_0
    new-instance v1, Lb/a/a/c/p;

    invoke-virtual {p2}, Lb/a/a/d;->y()Lb/a/a/m;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lb/a/a/c/p;-><init>(Lb/a/a/l;Lb/a/a/m;)V

    iput-object v1, p0, Lb/a/a/c/o;->c:Lb/a/a/l;

    goto :goto_0
.end method


# virtual methods
.method public final a(J)I
    .locals 3

    .prologue
    .line 101
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->a(J)I

    move-result v0

    .line 102
    if-ltz v0, :cond_0

    .line 103
    iget v1, p0, Lb/a/a/c/o;->a:I

    rem-int/2addr v0, v1

    .line 105
    :goto_0
    return v0

    :cond_0
    iget v1, p0, Lb/a/a/c/o;->a:I

    add-int/lit8 v1, v1, -0x1

    add-int/lit8 v0, v0, 0x1

    iget v2, p0, Lb/a/a/c/o;->a:I

    rem-int/2addr v0, v2

    add-int/2addr v0, v1

    goto :goto_0
.end method

.method public final b(JI)J
    .locals 3

    .prologue
    .line 131
    const/4 v0, 0x0

    iget v1, p0, Lb/a/a/c/o;->a:I

    add-int/lit8 v1, v1, -0x1

    invoke-static {p0, p3, v0, v1}, Lb/a/a/c/g;->a(Lb/a/a/c;III)V

    .line 132
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->a(J)I

    move-result v0

    if-ltz v0, :cond_0

    iget v1, p0, Lb/a/a/c/o;->a:I

    div-int/2addr v0, v1

    .line 133
    :goto_0
    iget-object v1, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    iget v2, p0, Lb/a/a/c/o;->a:I

    mul-int/2addr v0, v2

    add-int/2addr v0, p3

    invoke-virtual {v1, p1, p2, v0}, Lb/a/a/c;->b(JI)J

    move-result-wide v0

    return-wide v0

    .line 132
    :cond_0
    add-int/lit8 v0, v0, 0x1

    iget v1, p0, Lb/a/a/c/o;->a:I

    div-int/2addr v0, v1

    add-int/lit8 v0, v0, -0x1

    goto :goto_0
.end method

.method public final d(J)J
    .locals 3

    .prologue
    .line 163
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->d(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final e(J)J
    .locals 3

    .prologue
    .line 167
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->e(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final e()Lb/a/a/l;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lb/a/a/c/o;->c:Lb/a/a/l;

    return-object v0
.end method

.method public final f(J)J
    .locals 3

    .prologue
    .line 171
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->f(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final g()I
    .locals 1

    .prologue
    .line 149
    const/4 v0, 0x0

    return v0
.end method

.method public final g(J)J
    .locals 3

    .prologue
    .line 175
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->g(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final h()I
    .locals 1

    .prologue
    .line 159
    iget v0, p0, Lb/a/a/c/o;->a:I

    add-int/lit8 v0, v0, -0x1

    return v0
.end method

.method public final h(J)J
    .locals 3

    .prologue
    .line 179
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->h(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final i(J)J
    .locals 3

    .prologue
    .line 183
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->i(J)J

    move-result-wide v0

    return-wide v0
.end method
