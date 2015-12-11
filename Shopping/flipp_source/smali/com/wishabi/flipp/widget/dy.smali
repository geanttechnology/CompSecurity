.class public final Lcom/wishabi/flipp/widget/dy;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:I

.field private b:I

.field private c:I


# direct methods
.method public constructor <init>(III)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    iput p1, p0, Lcom/wishabi/flipp/widget/dy;->a:I

    .line 44
    iput p2, p0, Lcom/wishabi/flipp/widget/dy;->b:I

    .line 45
    iput p3, p0, Lcom/wishabi/flipp/widget/dy;->c:I

    .line 46
    return-void
.end method


# virtual methods
.method public final a(III)V
    .locals 0

    .prologue
    .line 49
    iput p1, p0, Lcom/wishabi/flipp/widget/dy;->a:I

    .line 50
    iput p2, p0, Lcom/wishabi/flipp/widget/dy;->b:I

    .line 51
    iput p3, p0, Lcom/wishabi/flipp/widget/dy;->c:I

    .line 52
    return-void
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 56
    instance-of v1, p1, Lcom/wishabi/flipp/widget/dy;

    if-eqz v1, :cond_0

    .line 57
    check-cast p1, Lcom/wishabi/flipp/widget/dy;

    .line 58
    iget v1, p0, Lcom/wishabi/flipp/widget/dy;->a:I

    iget v2, p1, Lcom/wishabi/flipp/widget/dy;->a:I

    if-ne v1, v2, :cond_0

    iget v1, p0, Lcom/wishabi/flipp/widget/dy;->b:I

    iget v2, p1, Lcom/wishabi/flipp/widget/dy;->b:I

    if-ne v1, v2, :cond_0

    iget v1, p0, Lcom/wishabi/flipp/widget/dy;->c:I

    iget v2, p1, Lcom/wishabi/flipp/widget/dy;->c:I

    if-ne v1, v2, :cond_0

    const/4 v0, 0x1

    .line 61
    :cond_0
    return v0
.end method

.method public final hashCode()I
    .locals 2

    .prologue
    .line 66
    iget v0, p0, Lcom/wishabi/flipp/widget/dy;->a:I

    iget v1, p0, Lcom/wishabi/flipp/widget/dy;->b:I

    add-int/lit8 v1, v1, 0xb

    shl-int/2addr v0, v1

    iget v1, p0, Lcom/wishabi/flipp/widget/dy;->c:I

    add-int/lit8 v1, v1, 0x3

    shl-int/2addr v0, v1

    return v0
.end method
