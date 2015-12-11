.class public Lnt;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:I

.field private b:I

.field private c:I

.field private d:I


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    const-string v0, "\\."

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 12
    array-length v1, v0

    if-lt v1, v2, :cond_0

    .line 13
    aget-object v1, v0, v3

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lnt;->a:I

    .line 17
    :goto_0
    array-length v1, v0

    if-lt v1, v4, :cond_1

    .line 18
    aget-object v1, v0, v2

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lnt;->b:I

    .line 22
    :goto_1
    array-length v1, v0

    if-lt v1, v5, :cond_2

    .line 23
    aget-object v1, v0, v4

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lnt;->c:I

    .line 27
    :goto_2
    array-length v1, v0

    const/4 v2, 0x4

    if-lt v1, v2, :cond_3

    .line 28
    aget-object v0, v0, v5

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lnt;->d:I

    .line 32
    :goto_3
    return-void

    .line 15
    :cond_0
    iput v3, p0, Lnt;->a:I

    goto :goto_0

    .line 20
    :cond_1
    iput v3, p0, Lnt;->b:I

    goto :goto_1

    .line 25
    :cond_2
    iput v3, p0, Lnt;->c:I

    goto :goto_2

    .line 30
    :cond_3
    iput v3, p0, Lnt;->d:I

    goto :goto_3
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lnt;->a:I

    return v0
.end method

.method public a(Lnt;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 51
    iget v2, p0, Lnt;->a:I

    invoke-virtual {p1}, Lnt;->a()I

    move-result v3

    if-le v2, v3, :cond_1

    .line 66
    :cond_0
    :goto_0
    return v0

    .line 53
    :cond_1
    iget v2, p0, Lnt;->a:I

    invoke-virtual {p1}, Lnt;->a()I

    move-result v3

    if-ge v2, v3, :cond_2

    move v0, v1

    .line 54
    goto :goto_0

    .line 56
    :cond_2
    iget v2, p0, Lnt;->b:I

    invoke-virtual {p1}, Lnt;->b()I

    move-result v3

    if-gt v2, v3, :cond_0

    .line 58
    iget v2, p0, Lnt;->b:I

    invoke-virtual {p1}, Lnt;->b()I

    move-result v3

    if-ge v2, v3, :cond_3

    move v0, v1

    .line 59
    goto :goto_0

    .line 61
    :cond_3
    iget v2, p0, Lnt;->c:I

    invoke-virtual {p1}, Lnt;->c()I

    move-result v3

    if-gt v2, v3, :cond_0

    .line 63
    iget v2, p0, Lnt;->c:I

    invoke-virtual {p1}, Lnt;->c()I

    move-result v3

    if-ge v2, v3, :cond_4

    move v0, v1

    .line 64
    goto :goto_0

    .line 66
    :cond_4
    iget v2, p0, Lnt;->d:I

    invoke-virtual {p1}, Lnt;->d()I

    move-result v3

    if-gt v2, v3, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 39
    iget v0, p0, Lnt;->b:I

    return v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 43
    iget v0, p0, Lnt;->c:I

    return v0
.end method

.method public d()I
    .locals 1

    .prologue
    .line 47
    iget v0, p0, Lnt;->d:I

    return v0
.end method
