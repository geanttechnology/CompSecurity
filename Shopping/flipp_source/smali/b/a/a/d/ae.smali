.class final Lb/a/a/d/ae;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb/a/a/d/al;
.implements Lb/a/a/d/am;


# instance fields
.field private final a:[Lb/a/a/d/am;

.field private final b:[Lb/a/a/d/al;


# direct methods
.method constructor <init>(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 1772
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1773
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 1774
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1776
    invoke-static {p1, v0, v1}, Lb/a/a/d/ae;->a(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V

    .line 1778
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-gtz v2, :cond_0

    .line 1779
    iput-object v3, p0, Lb/a/a/d/ae;->a:[Lb/a/a/d/am;

    .line 1785
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-gtz v0, :cond_1

    .line 1786
    iput-object v3, p0, Lb/a/a/d/ae;->b:[Lb/a/a/d/al;

    .line 1791
    :goto_1
    return-void

    .line 1781
    :cond_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Lb/a/a/d/am;

    invoke-interface {v0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lb/a/a/d/am;

    iput-object v0, p0, Lb/a/a/d/ae;->a:[Lb/a/a/d/am;

    goto :goto_0

    .line 1788
    :cond_1
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Lb/a/a/d/al;

    invoke-interface {v1, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lb/a/a/d/al;

    iput-object v0, p0, Lb/a/a/d/ae;->b:[Lb/a/a/d/al;

    goto :goto_1
.end method

.method private static a(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1843
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v2

    .line 1844
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_4

    .line 1845
    invoke-interface {p0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 1846
    instance-of v3, v0, Lb/a/a/d/am;

    if-eqz v3, :cond_0

    .line 1847
    instance-of v3, v0, Lb/a/a/d/ae;

    if-eqz v3, :cond_2

    .line 1848
    check-cast v0, Lb/a/a/d/ae;

    iget-object v0, v0, Lb/a/a/d/ae;->a:[Lb/a/a/d/am;

    invoke-static {p1, v0}, Lb/a/a/d/ae;->a(Ljava/util/List;[Ljava/lang/Object;)V

    .line 1854
    :cond_0
    :goto_1
    add-int/lit8 v0, v1, 0x1

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 1855
    instance-of v3, v0, Lb/a/a/d/al;

    if-eqz v3, :cond_1

    .line 1856
    instance-of v3, v0, Lb/a/a/d/ae;

    if-eqz v3, :cond_3

    .line 1857
    check-cast v0, Lb/a/a/d/ae;

    iget-object v0, v0, Lb/a/a/d/ae;->b:[Lb/a/a/d/al;

    invoke-static {p2, v0}, Lb/a/a/d/ae;->a(Ljava/util/List;[Ljava/lang/Object;)V

    .line 1844
    :cond_1
    :goto_2
    add-int/lit8 v0, v1, 0x2

    move v1, v0

    goto :goto_0

    .line 1850
    :cond_2
    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1859
    :cond_3
    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 1863
    :cond_4
    return-void
.end method

.method private static a(Ljava/util/List;[Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;[",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1866
    if-eqz p1, :cond_0

    .line 1867
    const/4 v0, 0x0

    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_0

    .line 1868
    aget-object v1, p1, v0

    invoke-interface {p0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1867
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1871
    :cond_0
    return-void
.end method
