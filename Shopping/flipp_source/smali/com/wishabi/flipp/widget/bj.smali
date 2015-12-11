.class public final Lcom/wishabi/flipp/widget/bj;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/graphics/drawable/Drawable;",
            ">;"
        }
    .end annotation
.end field

.field final b:Landroid/graphics/PointF;

.field final c:F

.field final d:F

.field final e:I

.field final f:Landroid/graphics/RectF;

.field public final g:Landroid/graphics/Matrix;

.field public final h:Landroid/graphics/RectF;

.field public final i:Landroid/graphics/Rect;

.field public final j:Landroid/graphics/Rect;

.field k:J

.field public l:Z

.field public m:Z

.field public n:J

.field o:Z


# direct methods
.method private constructor <init>(Lcom/wishabi/flipp/widget/bl;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 191
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 192
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bl;->b:Ljava/util/List;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bj;->a:Ljava/util/List;

    .line 193
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bj;->b:Landroid/graphics/PointF;

    .line 194
    iget v0, p1, Lcom/wishabi/flipp/widget/bl;->d:F

    iput v0, p0, Lcom/wishabi/flipp/widget/bj;->c:F

    .line 195
    iget v0, p1, Lcom/wishabi/flipp/widget/bl;->e:F

    iput v0, p0, Lcom/wishabi/flipp/widget/bj;->d:F

    .line 196
    iget v0, p1, Lcom/wishabi/flipp/widget/bl;->f:I

    iput v0, p0, Lcom/wishabi/flipp/widget/bj;->e:I

    .line 197
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bj;->f:Landroid/graphics/RectF;

    .line 199
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bj;->g:Landroid/graphics/Matrix;

    .line 200
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bj;->h:Landroid/graphics/RectF;

    .line 201
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    .line 202
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bj;->j:Landroid/graphics/Rect;

    .line 204
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    if-nez v0, :cond_0

    .line 205
    const-wide/16 v0, 0x14d

    iput-wide v0, p0, Lcom/wishabi/flipp/widget/bj;->k:J

    .line 206
    iput-boolean v2, p0, Lcom/wishabi/flipp/widget/bj;->l:Z

    .line 207
    iput-boolean v2, p0, Lcom/wishabi/flipp/widget/bj;->m:Z

    .line 208
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/wishabi/flipp/widget/bj;->n:J

    .line 209
    iput-boolean v2, p0, Lcom/wishabi/flipp/widget/bj;->o:Z

    .line 217
    :goto_0
    return-void

    .line 211
    :cond_0
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget-wide v0, v0, Lcom/wishabi/flipp/widget/bj;->k:J

    iput-wide v0, p0, Lcom/wishabi/flipp/widget/bj;->k:J

    .line 212
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget-boolean v0, v0, Lcom/wishabi/flipp/widget/bj;->l:Z

    iput-boolean v0, p0, Lcom/wishabi/flipp/widget/bj;->l:Z

    .line 213
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget-boolean v0, v0, Lcom/wishabi/flipp/widget/bj;->m:Z

    iput-boolean v0, p0, Lcom/wishabi/flipp/widget/bj;->m:Z

    .line 214
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget-wide v0, v0, Lcom/wishabi/flipp/widget/bj;->n:J

    iput-wide v0, p0, Lcom/wishabi/flipp/widget/bj;->n:J

    .line 215
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bl;->a:Lcom/wishabi/flipp/widget/bj;

    iget-boolean v0, v0, Lcom/wishabi/flipp/widget/bj;->o:Z

    iput-boolean v0, p0, Lcom/wishabi/flipp/widget/bj;->o:Z

    goto :goto_0
.end method

.method public synthetic constructor <init>(Lcom/wishabi/flipp/widget/bl;B)V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/widget/bj;-><init>(Lcom/wishabi/flipp/widget/bl;)V

    return-void
.end method
