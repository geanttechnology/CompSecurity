.class final Lcom/wishabi/flipp/util/n;
.super Lcom/wishabi/flipp/util/o;
.source "SourceFile"


# instance fields
.field private final f:I


# direct methods
.method private constructor <init>(II)V
    .locals 0

    .prologue
    .line 178
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/util/o;-><init>(I)V

    .line 179
    iput p2, p0, Lcom/wishabi/flipp/util/n;->f:I

    .line 180
    return-void
.end method

.method synthetic constructor <init>(IIB)V
    .locals 0

    .prologue
    .line 169
    invoke-direct {p0, p1, p2}, Lcom/wishabi/flipp/util/n;-><init>(II)V

    return-void
.end method

.method private constructor <init>(IILjava/lang/String;)V
    .locals 0

    .prologue
    .line 173
    invoke-direct {p0, p1, p3}, Lcom/wishabi/flipp/util/o;-><init>(ILjava/lang/String;)V

    .line 174
    iput p2, p0, Lcom/wishabi/flipp/util/n;->f:I

    .line 175
    return-void
.end method

.method synthetic constructor <init>(IILjava/lang/String;B)V
    .locals 0

    .prologue
    .line 169
    invoke-direct {p0, p1, p2, p3}, Lcom/wishabi/flipp/util/n;-><init>(IILjava/lang/String;)V

    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 199
    iget v0, p0, Lcom/wishabi/flipp/util/n;->f:I

    return v0
.end method

.method public final a(I)Lcom/wishabi/flipp/util/m;
    .locals 1

    .prologue
    .line 209
    iget v0, p0, Lcom/wishabi/flipp/util/n;->f:I

    if-ge p1, v0, :cond_0

    .line 210
    const/4 v0, 0x0

    return-object v0

    .line 212
    :cond_0
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0
.end method

.method public final a(Lcom/wishabi/flipp/util/m;)V
    .locals 2

    .prologue
    .line 184
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Can\'t add items to a PlaceHolderSection"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final b()I
    .locals 1

    .prologue
    .line 217
    iget v0, p0, Lcom/wishabi/flipp/util/n;->f:I

    return v0
.end method

.method public final b(I)Lcom/wishabi/flipp/util/m;
    .locals 1

    .prologue
    .line 222
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/util/n;->a(I)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    return-object v0
.end method

.method public final b(Lcom/wishabi/flipp/util/m;)V
    .locals 2

    .prologue
    .line 189
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Can\'t add items to a PlaceHolderSection"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
