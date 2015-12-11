.class final Lcom/wishabi/flipp/widget/ef;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/ed;


# instance fields
.field a:[I

.field b:[I


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 190
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(B)V
    .locals 0

    .prologue
    .line 190
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/ef;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)I
    .locals 2

    .prologue
    .line 196
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ef;->a:[I

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ef;->a:[I

    array-length v1, v1

    rem-int v1, p1, v1

    aget v0, v0, v1

    return v0
.end method

.method public final b(I)I
    .locals 2

    .prologue
    .line 201
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ef;->b:[I

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ef;->b:[I

    array-length v1, v1

    rem-int v1, p1, v1

    aget v0, v0, v1

    return v0
.end method
