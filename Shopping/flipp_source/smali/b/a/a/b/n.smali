.class final Lb/a/a/b/n;
.super Lb/a/a/c/m;
.source "SourceFile"


# instance fields
.field private final b:Lb/a/a/b/d;


# direct methods
.method constructor <init>(Lb/a/a/b/d;Lb/a/a/l;)V
    .locals 1

    .prologue
    .line 46
    invoke-static {}, Lb/a/a/d;->l()Lb/a/a/d;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lb/a/a/c/m;-><init>(Lb/a/a/d;Lb/a/a/l;)V

    .line 47
    iput-object p1, p0, Lb/a/a/b/n;->b:Lb/a/a/b/d;

    .line 48
    return-void
.end method


# virtual methods
.method public final a(J)I
    .locals 1

    .prologue
    .line 57
    invoke-static {p1, p2}, Lb/a/a/b/d;->d(J)I

    move-result v0

    return v0
.end method

.method protected final a(Ljava/lang/String;Ljava/util/Locale;)I
    .locals 2

    .prologue
    .line 91
    invoke-static {p2}, Lb/a/a/b/p;->a(Ljava/util/Locale;)Lb/a/a/b/p;

    move-result-object v0

    iget-object v0, v0, Lb/a/a/b/p;->h:Ljava/util/TreeMap;

    invoke-virtual {v0, p1}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0

    :cond_0
    new-instance v0, Lb/a/a/o;

    invoke-static {}, Lb/a/a/d;->l()Lb/a/a/d;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lb/a/a/o;-><init>(Lb/a/a/d;Ljava/lang/String;)V

    throw v0
.end method

.method public final a(Ljava/util/Locale;)I
    .locals 1

    .prologue
    .line 123
    invoke-static {p1}, Lb/a/a/b/p;->a(Ljava/util/Locale;)Lb/a/a/b/p;

    move-result-object v0

    iget v0, v0, Lb/a/a/b/p;->k:I

    return v0
.end method

.method public final a(ILjava/util/Locale;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    invoke-static {p2}, Lb/a/a/b/p;->a(Ljava/util/Locale;)Lb/a/a/b/p;

    move-result-object v0

    iget-object v0, v0, Lb/a/a/b/p;->b:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public final b(ILjava/util/Locale;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    invoke-static {p2}, Lb/a/a/b/p;->a(Ljava/util/Locale;)Lb/a/a/b/p;

    move-result-object v0

    iget-object v0, v0, Lb/a/a/b/p;->c:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public final e()Lb/a/a/l;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lb/a/a/b/n;->b:Lb/a/a/b/d;

    iget-object v0, v0, Lb/a/a/b/a;->d:Lb/a/a/l;

    return-object v0
.end method

.method public final g()I
    .locals 1

    .prologue
    .line 104
    const/4 v0, 0x1

    return v0
.end method

.method public final h()I
    .locals 1

    .prologue
    .line 113
    const/4 v0, 0x7

    return v0
.end method
