.class final Lb/a/a/b/r;
.super Lb/a/a/c/d;
.source "SourceFile"


# instance fields
.field private final a:Lb/a/a/b/d;


# direct methods
.method constructor <init>(Lb/a/a/c;Lb/a/a/b/d;)V
    .locals 1

    .prologue
    .line 41
    invoke-static {}, Lb/a/a/d;->t()Lb/a/a/d;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lb/a/a/c/d;-><init>(Lb/a/a/c;Lb/a/a/d;)V

    .line 42
    iput-object p2, p0, Lb/a/a/b/r;->a:Lb/a/a/b/d;

    .line 43
    return-void
.end method


# virtual methods
.method public final a(J)I
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->a(J)I

    move-result v0

    .line 47
    if-gtz v0, :cond_0

    .line 48
    rsub-int/lit8 v0, v0, 0x1

    .line 50
    :cond_0
    return v0
.end method

.method public final a(JI)J
    .locals 3

    .prologue
    .line 54
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2, p3}, Lb/a/a/c;->a(JI)J

    move-result-wide v0

    return-wide v0
.end method

.method public final a(JJ)J
    .locals 3

    .prologue
    .line 58
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2, p3, p4}, Lb/a/a/c;->a(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public final b(JJ)I
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2, p3, p4}, Lb/a/a/c;->b(JJ)I

    move-result v0

    return v0
.end method

.method public final b(JI)J
    .locals 3

    .prologue
    .line 86
    const/4 v0, 0x1

    iget-object v1, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v1}, Lb/a/a/c;->h()I

    move-result v1

    invoke-static {p0, p3, v0, v1}, Lb/a/a/c/g;->a(Lb/a/a/c;III)V

    .line 87
    iget-object v0, p0, Lb/a/a/b/r;->a:Lb/a/a/b/d;

    invoke-virtual {v0, p1, p2}, Lb/a/a/b/d;->a(J)I

    move-result v0

    if-gtz v0, :cond_0

    .line 88
    rsub-int/lit8 p3, p3, 0x1

    .line 90
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lb/a/a/c/d;->b(JI)J

    move-result-wide v0

    return-wide v0
.end method

.method public final c(JJ)J
    .locals 3

    .prologue
    .line 74
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2, p3, p4}, Lb/a/a/c;->c(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public final d(J)J
    .locals 3

    .prologue
    .line 102
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->d(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final e(J)J
    .locals 3

    .prologue
    .line 106
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->e(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final g()I
    .locals 1

    .prologue
    .line 94
    const/4 v0, 0x1

    return v0
.end method

.method public final h()I
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0}, Lb/a/a/c;->h()I

    move-result v0

    return v0
.end method

.method public final i(J)J
    .locals 3

    .prologue
    .line 110
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->i(J)J

    move-result-wide v0

    return-wide v0
.end method
