.class final Lcom/a/a/a/b/k;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field a:I

.field b:I

.field c:I

.field final d:[I


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    const/16 v0, 0xa

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/a/a/a/b/k;->d:[I

    return-void
.end method


# virtual methods
.method final a(III)V
    .locals 3

    .prologue
    .line 71
    iget-object v0, p0, Lcom/a/a/a/b/k;->d:[I

    array-length v0, v0

    if-lt p1, v0, :cond_0

    .line 89
    :goto_0
    return-void

    .line 75
    :cond_0
    const/4 v0, 0x1

    shl-int/2addr v0, p1

    .line 76
    iget v1, p0, Lcom/a/a/a/b/k;->a:I

    or-int/2addr v1, v0

    iput v1, p0, Lcom/a/a/a/b/k;->a:I

    .line 77
    and-int/lit8 v1, p2, 0x1

    if-eqz v1, :cond_1

    .line 78
    iget v1, p0, Lcom/a/a/a/b/k;->b:I

    or-int/2addr v1, v0

    iput v1, p0, Lcom/a/a/a/b/k;->b:I

    .line 82
    :goto_1
    and-int/lit8 v1, p2, 0x2

    if-eqz v1, :cond_2

    .line 83
    iget v1, p0, Lcom/a/a/a/b/k;->c:I

    or-int/2addr v0, v1

    iput v0, p0, Lcom/a/a/a/b/k;->c:I

    .line 88
    :goto_2
    iget-object v0, p0, Lcom/a/a/a/b/k;->d:[I

    aput p3, v0, p1

    goto :goto_0

    .line 80
    :cond_1
    iget v1, p0, Lcom/a/a/a/b/k;->b:I

    xor-int/lit8 v2, v0, -0x1

    and-int/2addr v1, v2

    iput v1, p0, Lcom/a/a/a/b/k;->b:I

    goto :goto_1

    .line 85
    :cond_2
    iget v1, p0, Lcom/a/a/a/b/k;->c:I

    xor-int/lit8 v0, v0, -0x1

    and-int/2addr v0, v1

    iput v0, p0, Lcom/a/a/a/b/k;->c:I

    goto :goto_2
.end method
