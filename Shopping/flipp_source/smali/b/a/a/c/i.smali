.class final Lb/a/a/c/i;
.super Lb/a/a/c/c;
.source "SourceFile"


# instance fields
.field final synthetic a:Lb/a/a/c/h;


# direct methods
.method constructor <init>(Lb/a/a/c/h;Lb/a/a/m;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lb/a/a/c/i;->a:Lb/a/a/c/h;

    .line 153
    invoke-direct {p0, p2}, Lb/a/a/c/c;-><init>(Lb/a/a/m;)V

    .line 154
    return-void
.end method


# virtual methods
.method public final a(JI)J
    .locals 3

    .prologue
    .line 183
    iget-object v0, p0, Lb/a/a/c/i;->a:Lb/a/a/c/h;

    invoke-virtual {v0, p1, p2, p3}, Lb/a/a/c/h;->a(JI)J

    move-result-wide v0

    return-wide v0
.end method

.method public final a(JJ)J
    .locals 3

    .prologue
    .line 187
    iget-object v0, p0, Lb/a/a/c/i;->a:Lb/a/a/c/h;

    invoke-virtual {v0, p1, p2, p3, p4}, Lb/a/a/c/h;->a(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public final b(JJ)I
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lb/a/a/c/i;->a:Lb/a/a/c/h;

    invoke-virtual {v0, p1, p2, p3, p4}, Lb/a/a/c/h;->b(JJ)I

    move-result v0

    return v0
.end method

.method public final c(JJ)J
    .locals 3

    .prologue
    .line 196
    iget-object v0, p0, Lb/a/a/c/i;->a:Lb/a/a/c/h;

    invoke-virtual {v0, p1, p2, p3, p4}, Lb/a/a/c/h;->c(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public final c()Z
    .locals 1

    .prologue
    .line 157
    const/4 v0, 0x0

    return v0
.end method

.method public final d()J
    .locals 2

    .prologue
    .line 161
    iget-object v0, p0, Lb/a/a/c/i;->a:Lb/a/a/c/h;

    iget-wide v0, v0, Lb/a/a/c/h;->b:J

    return-wide v0
.end method
