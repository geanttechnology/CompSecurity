.class final Lb/a/a/b/g;
.super Lb/a/a/c/m;
.source "SourceFile"


# instance fields
.field private final b:Lb/a/a/b/d;


# direct methods
.method constructor <init>(Lb/a/a/b/d;Lb/a/a/l;)V
    .locals 1

    .prologue
    .line 42
    invoke-static {}, Lb/a/a/d;->m()Lb/a/a/d;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lb/a/a/c/m;-><init>(Lb/a/a/d;Lb/a/a/l;)V

    .line 43
    iput-object p1, p0, Lb/a/a/b/g;->b:Lb/a/a/b/d;

    .line 44
    return-void
.end method


# virtual methods
.method public final a(J)I
    .locals 3

    .prologue
    .line 48
    iget-object v0, p0, Lb/a/a/b/g;->b:Lb/a/a/b/d;

    invoke-virtual {v0, p1, p2}, Lb/a/a/b/d;->a(J)I

    move-result v1

    invoke-virtual {v0, p1, p2, v1}, Lb/a/a/b/d;->a(JI)I

    move-result v2

    invoke-virtual {v0, p1, p2, v1, v2}, Lb/a/a/b/d;->a(JII)I

    move-result v0

    return v0
.end method

.method public final c(J)I
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lb/a/a/b/g;->b:Lb/a/a/b/d;

    invoke-virtual {v0, p1, p2}, Lb/a/a/b/d;->f(J)I

    move-result v0

    return v0
.end method

.method protected final c(JI)I
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lb/a/a/b/g;->b:Lb/a/a/b/d;

    invoke-virtual {v0, p1, p2, p3}, Lb/a/a/b/d;->c(JI)I

    move-result v0

    return v0
.end method

.method public final e()Lb/a/a/l;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lb/a/a/b/g;->b:Lb/a/a/b/d;

    iget-object v0, v0, Lb/a/a/b/a;->f:Lb/a/a/l;

    return-object v0
.end method

.method public final g()I
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x1

    return v0
.end method

.method public final h()I
    .locals 1

    .prologue
    .line 60
    invoke-static {}, Lb/a/a/b/d;->M()I

    move-result v0

    return v0
.end method
