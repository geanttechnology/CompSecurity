.class final Lb/a/a/b/e;
.super Lb/a/a/c/l;
.source "SourceFile"


# direct methods
.method constructor <init>()V
    .locals 3

    .prologue
    .line 760
    invoke-static {}, Lb/a/a/d;->k()Lb/a/a/d;

    move-result-object v0

    invoke-static {}, Lb/a/a/b/d;->S()Lb/a/a/l;

    move-result-object v1

    invoke-static {}, Lb/a/a/b/d;->T()Lb/a/a/l;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lb/a/a/c/l;-><init>(Lb/a/a/d;Lb/a/a/l;Lb/a/a/l;)V

    .line 761
    return-void
.end method


# virtual methods
.method public final a(Ljava/util/Locale;)I
    .locals 1

    .prologue
    .line 772
    invoke-static {p1}, Lb/a/a/b/p;->a(Ljava/util/Locale;)Lb/a/a/b/p;

    move-result-object v0

    iget v0, v0, Lb/a/a/b/p;->m:I

    return v0
.end method

.method public final a(JLjava/lang/String;Ljava/util/Locale;)J
    .locals 3

    .prologue
    .line 768
    invoke-static {p4}, Lb/a/a/b/p;->a(Ljava/util/Locale;)Lb/a/a/b/p;

    move-result-object v0

    iget-object v1, v0, Lb/a/a/b/p;->f:[Ljava/lang/String;

    array-length v0, v1

    :cond_0
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_1

    aget-object v2, v1, v0

    invoke-virtual {v2, p3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p0, p1, p2, v0}, Lb/a/a/b/e;->b(JI)J

    move-result-wide v0

    return-wide v0

    :cond_1
    new-instance v0, Lb/a/a/o;

    invoke-static {}, Lb/a/a/d;->k()Lb/a/a/d;

    move-result-object v1

    invoke-direct {v0, v1, p3}, Lb/a/a/o;-><init>(Lb/a/a/d;Ljava/lang/String;)V

    throw v0
.end method

.method public final a(ILjava/util/Locale;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 764
    invoke-static {p2}, Lb/a/a/b/p;->a(Ljava/util/Locale;)Lb/a/a/b/p;

    move-result-object v0

    iget-object v0, v0, Lb/a/a/b/p;->f:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method
