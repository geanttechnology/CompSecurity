.class public Lb/a/a/c/e;
.super Lb/a/a/c/c;
.source "SourceFile"


# instance fields
.field final a:Lb/a/a/l;


# direct methods
.method public constructor <init>(Lb/a/a/l;Lb/a/a/m;)V
    .locals 2

    .prologue
    .line 52
    invoke-direct {p0, p2}, Lb/a/a/c/c;-><init>(Lb/a/a/m;)V

    .line 53
    if-nez p1, :cond_0

    .line 54
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The field must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_0
    invoke-virtual {p1}, Lb/a/a/l;->b()Z

    move-result v0

    if-nez v0, :cond_1

    .line 57
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The field must be supported"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 59
    :cond_1
    iput-object p1, p0, Lb/a/a/c/e;->a:Lb/a/a/l;

    .line 60
    return-void
.end method


# virtual methods
.method public a(JI)J
    .locals 3

    .prologue
    .line 89
    iget-object v0, p0, Lb/a/a/c/e;->a:Lb/a/a/l;

    invoke-virtual {v0, p1, p2, p3}, Lb/a/a/l;->a(JI)J

    move-result-wide v0

    return-wide v0
.end method

.method public a(JJ)J
    .locals 3

    .prologue
    .line 93
    iget-object v0, p0, Lb/a/a/c/e;->a:Lb/a/a/l;

    invoke-virtual {v0, p1, p2, p3, p4}, Lb/a/a/l;->a(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public c(JJ)J
    .locals 3

    .prologue
    .line 97
    iget-object v0, p0, Lb/a/a/c/e;->a:Lb/a/a/l;

    invoke-virtual {v0, p1, p2, p3, p4}, Lb/a/a/l;->c(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public final c()Z
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lb/a/a/c/e;->a:Lb/a/a/l;

    invoke-virtual {v0}, Lb/a/a/l;->c()Z

    move-result v0

    return v0
.end method

.method public d()J
    .locals 2

    .prologue
    .line 101
    iget-object v0, p0, Lb/a/a/c/e;->a:Lb/a/a/l;

    invoke-virtual {v0}, Lb/a/a/l;->d()J

    move-result-wide v0

    return-wide v0
.end method
