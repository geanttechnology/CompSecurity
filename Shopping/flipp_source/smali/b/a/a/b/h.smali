.class final Lb/a/a/b/h;
.super Lb/a/a/c/m;
.source "SourceFile"


# instance fields
.field private final b:Lb/a/a/b/d;


# direct methods
.method constructor <init>(Lb/a/a/b/d;Lb/a/a/l;)V
    .locals 1

    .prologue
    .line 42
    invoke-static {}, Lb/a/a/d;->n()Lb/a/a/d;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lb/a/a/c/m;-><init>(Lb/a/a/d;Lb/a/a/l;)V

    .line 43
    iput-object p1, p0, Lb/a/a/b/h;->b:Lb/a/a/b/d;

    .line 44
    return-void
.end method


# virtual methods
.method public final a(J)I
    .locals 3

    .prologue
    .line 53
    iget-object v0, p0, Lb/a/a/b/h;->b:Lb/a/a/b/d;

    invoke-virtual {v0, p1, p2}, Lb/a/a/b/d;->a(J)I

    move-result v1

    invoke-virtual {v0, p1, p2, v1}, Lb/a/a/b/d;->b(JI)I

    move-result v0

    return v0
.end method

.method public final c(J)I
    .locals 3

    .prologue
    .line 69
    iget-object v0, p0, Lb/a/a/b/h;->b:Lb/a/a/b/d;

    invoke-virtual {v0, p1, p2}, Lb/a/a/b/d;->a(J)I

    move-result v0

    .line 70
    iget-object v1, p0, Lb/a/a/b/h;->b:Lb/a/a/b/d;

    invoke-virtual {v1, v0}, Lb/a/a/b/d;->c(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const/16 v0, 0x16e

    :goto_0
    return v0

    :cond_0
    const/16 v0, 0x16d

    goto :goto_0
.end method

.method protected final c(JI)I
    .locals 1

    .prologue
    const/16 v0, 0x16d

    .line 93
    invoke-static {}, Lb/a/a/b/d;->L()I

    .line 94
    if-gt p3, v0, :cond_0

    if-gtz p3, :cond_1

    :cond_0
    invoke-virtual {p0, p1, p2}, Lb/a/a/b/h;->c(J)I

    move-result v0

    :cond_1
    return v0
.end method

.method public final e()Lb/a/a/l;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lb/a/a/b/h;->b:Lb/a/a/b/d;

    iget-object v0, v0, Lb/a/a/b/a;->g:Lb/a/a/l;

    return-object v0
.end method

.method public final g()I
    .locals 1

    .prologue
    .line 61
    const/4 v0, 0x1

    return v0
.end method

.method public final h()I
    .locals 1

    .prologue
    .line 65
    invoke-static {}, Lb/a/a/b/d;->L()I

    move-result v0

    return v0
.end method
