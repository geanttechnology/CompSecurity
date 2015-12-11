.class public final Lcom/wishabi/flipp/widget/bl;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Lcom/wishabi/flipp/widget/bj;

.field public b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/graphics/drawable/Drawable;",
            ">;"
        }
    .end annotation
.end field

.field public c:Landroid/graphics/PointF;

.field public d:F

.field public e:F

.field public f:I

.field public g:Landroid/graphics/RectF;


# direct methods
.method private constructor <init>(Lcom/wishabi/flipp/widget/bj;)V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    if-nez v0, :cond_0

    .line 43
    :goto_0
    return-void

    .line 37
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/bj;->a:Ljava/util/List;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bl;->b:Ljava/util/List;

    .line 38
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/bj;->b:Landroid/graphics/PointF;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    .line 39
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget v0, v0, Lcom/wishabi/flipp/widget/bj;->c:F

    iput v0, p0, Lcom/wishabi/flipp/widget/bl;->d:F

    .line 40
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget v0, v0, Lcom/wishabi/flipp/widget/bj;->d:F

    iput v0, p0, Lcom/wishabi/flipp/widget/bl;->e:F

    .line 41
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget v0, v0, Lcom/wishabi/flipp/widget/bj;->e:I

    iput v0, p0, Lcom/wishabi/flipp/widget/bl;->f:I

    .line 42
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/bj;->f:Landroid/graphics/RectF;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    goto :goto_0
.end method

.method public synthetic constructor <init>(Lcom/wishabi/flipp/widget/bj;B)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/widget/bl;-><init>(Lcom/wishabi/flipp/widget/bj;)V

    return-void
.end method


# virtual methods
.method public final a([I)Lcom/wishabi/flipp/widget/bl;
    .locals 5

    .prologue
    .line 124
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    .line 125
    if-nez v1, :cond_0

    .line 133
    :goto_0
    return-object p0

    .line 128
    :cond_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 129
    const/4 v0, 0x0

    :goto_1
    const/16 v3, 0xb

    if-ge v0, v3, :cond_1

    aget v3, p1, v0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    .line 130
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v4, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    .line 131
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 129
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 133
    :cond_1
    iput-object v2, p0, Lcom/wishabi/flipp/widget/bl;->b:Ljava/util/List;

    goto :goto_0
.end method
