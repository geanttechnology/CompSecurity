.class public final Lb/a/a/c/k;
.super Lb/a/a/c/d;
.source "SourceFile"


# instance fields
.field private final a:I

.field private final c:I

.field private final d:I


# direct methods
.method public constructor <init>(Lb/a/a/c;)V
    .locals 2

    .prologue
    .line 47
    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    const/16 v1, 0x63

    invoke-direct {p0, p1, v0, v1}, Lb/a/a/c/k;-><init>(Lb/a/a/c;Lb/a/a/d;I)V

    .line 48
    return-void

    .line 47
    :cond_0
    invoke-virtual {p1}, Lb/a/a/c;->a()Lb/a/a/d;

    move-result-object v0

    goto :goto_0
.end method

.method public constructor <init>(Lb/a/a/c;Lb/a/a/d;)V
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lb/a/a/c/k;-><init>(Lb/a/a/c;Lb/a/a/d;I)V

    .line 60
    return-void
.end method

.method private constructor <init>(Lb/a/a/c;Lb/a/a/d;I)V
    .locals 3

    .prologue
    const v2, 0x7fffffff

    const/high16 v1, -0x80000000

    .line 74
    invoke-direct {p0, p1, p2}, Lb/a/a/c/d;-><init>(Lb/a/a/c;Lb/a/a/d;)V

    .line 76
    if-nez p3, :cond_0

    .line 77
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The offset cannot be zero"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 80
    :cond_0
    iput p3, p0, Lb/a/a/c/k;->a:I

    .line 82
    invoke-virtual {p1}, Lb/a/a/c;->g()I

    move-result v0

    add-int/2addr v0, p3

    if-ge v1, v0, :cond_1

    .line 83
    invoke-virtual {p1}, Lb/a/a/c;->g()I

    move-result v0

    add-int/2addr v0, p3

    iput v0, p0, Lb/a/a/c/k;->c:I

    .line 87
    :goto_0
    invoke-virtual {p1}, Lb/a/a/c;->h()I

    move-result v0

    add-int/2addr v0, p3

    if-le v2, v0, :cond_2

    .line 88
    invoke-virtual {p1}, Lb/a/a/c;->h()I

    move-result v0

    add-int/2addr v0, p3

    iput v0, p0, Lb/a/a/c/k;->d:I

    .line 92
    :goto_1
    return-void

    .line 85
    :cond_1
    iput v1, p0, Lb/a/a/c/k;->c:I

    goto :goto_0

    .line 90
    :cond_2
    iput v2, p0, Lb/a/a/c/k;->d:I

    goto :goto_1
.end method


# virtual methods
.method public final a(J)I
    .locals 3

    .prologue
    .line 101
    invoke-super {p0, p1, p2}, Lb/a/a/c/d;->a(J)I

    move-result v0

    iget v1, p0, Lb/a/a/c/k;->a:I

    add-int/2addr v0, v1

    return v0
.end method

.method public final a(JI)J
    .locals 5

    .prologue
    .line 113
    invoke-super {p0, p1, p2, p3}, Lb/a/a/c/d;->a(JI)J

    move-result-wide v0

    .line 114
    invoke-virtual {p0, v0, v1}, Lb/a/a/c/k;->a(J)I

    move-result v2

    iget v3, p0, Lb/a/a/c/k;->c:I

    iget v4, p0, Lb/a/a/c/k;->d:I

    invoke-static {p0, v2, v3, v4}, Lb/a/a/c/g;->a(Lb/a/a/c;III)V

    .line 115
    return-wide v0
.end method

.method public final a(JJ)J
    .locals 5

    .prologue
    .line 127
    invoke-super {p0, p1, p2, p3, p4}, Lb/a/a/c/d;->a(JJ)J

    move-result-wide v0

    .line 128
    invoke-virtual {p0, v0, v1}, Lb/a/a/c/k;->a(J)I

    move-result v2

    iget v3, p0, Lb/a/a/c/k;->c:I

    iget v4, p0, Lb/a/a/c/k;->d:I

    invoke-static {p0, v2, v3, v4}, Lb/a/a/c/g;->a(Lb/a/a/c;III)V

    .line 129
    return-wide v0
.end method

.method public final b(JI)J
    .locals 3

    .prologue
    .line 153
    iget v0, p0, Lb/a/a/c/k;->c:I

    iget v1, p0, Lb/a/a/c/k;->d:I

    invoke-static {p0, p3, v0, v1}, Lb/a/a/c/g;->a(Lb/a/a/c;III)V

    .line 154
    iget v0, p0, Lb/a/a/c/k;->a:I

    sub-int v0, p3, v0

    invoke-super {p0, p1, p2, v0}, Lb/a/a/c/d;->b(JI)J

    move-result-wide v0

    return-wide v0
.end method

.method public final b(J)Z
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->b(J)Z

    move-result v0

    return v0
.end method

.method public final d(J)J
    .locals 3

    .prologue
    .line 188
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->d(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final e(J)J
    .locals 3

    .prologue
    .line 192
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->e(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final f(J)J
    .locals 3

    .prologue
    .line 196
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->f(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final f()Lb/a/a/l;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0}, Lb/a/a/c;->f()Lb/a/a/l;

    move-result-object v0

    return-object v0
.end method

.method public final g()I
    .locals 1

    .prologue
    .line 175
    iget v0, p0, Lb/a/a/c/k;->c:I

    return v0
.end method

.method public final g(J)J
    .locals 3

    .prologue
    .line 200
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->g(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final h()I
    .locals 1

    .prologue
    .line 184
    iget v0, p0, Lb/a/a/c/k;->d:I

    return v0
.end method

.method public final h(J)J
    .locals 3

    .prologue
    .line 204
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->h(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final i(J)J
    .locals 3

    .prologue
    .line 208
    iget-object v0, p0, Lb/a/a/c/d;->b:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->i(J)J

    move-result-wide v0

    return-wide v0
.end method
