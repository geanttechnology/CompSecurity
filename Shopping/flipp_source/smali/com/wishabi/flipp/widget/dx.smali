.class public final Lcom/wishabi/flipp/widget/dx;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/b/aw;


# instance fields
.field public a:I

.field public final b:Lcom/wishabi/flipp/widget/dy;

.field public c:Landroid/graphics/Bitmap;

.field public final d:[B

.field public final e:Ljava/util/concurrent/atomic/AtomicInteger;

.field public final f:Landroid/graphics/RectF;

.field final synthetic g:Lcom/wishabi/flipp/widget/dw;


# direct methods
.method public constructor <init>(Lcom/wishabi/flipp/widget/dw;IIIFFFF)V
    .locals 2

    .prologue
    const/16 v1, 0x100

    .line 72
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dx;->g:Lcom/wishabi/flipp/widget/dw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    sget-object v0, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v1, v0}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dx;->c:Landroid/graphics/Bitmap;

    .line 89
    const/16 v0, 0x4000

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dx;->d:[B

    .line 90
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dx;->e:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 73
    iput p4, p0, Lcom/wishabi/flipp/widget/dx;->a:I

    .line 74
    new-instance v0, Lcom/wishabi/flipp/widget/dy;

    invoke-direct {v0, p2, p3, p4}, Lcom/wishabi/flipp/widget/dy;-><init>(III)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dx;->b:Lcom/wishabi/flipp/widget/dy;

    .line 75
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, p5, p6, p7, p8}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dx;->f:Landroid/graphics/RectF;

    .line 76
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dx;->g:Lcom/wishabi/flipp/widget/dw;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/dw;->a(Lcom/wishabi/flipp/widget/dw;)Ljava/util/Map;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/dx;->b:Lcom/wishabi/flipp/widget/dy;

    invoke-interface {v0, v1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dx;->g:Lcom/wishabi/flipp/widget/dw;

    invoke-static {v0}, Landroid/support/v4/view/ap;->d(Landroid/view/View;)V

    .line 98
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dx;->g:Lcom/wishabi/flipp/widget/dw;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/dw;->invalidate()V

    .line 99
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dx;->g:Lcom/wishabi/flipp/widget/dw;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/dw;->b(Lcom/wishabi/flipp/widget/dw;)Ljava/util/Map;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/dx;->b:Lcom/wishabi/flipp/widget/dy;

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    return-void
.end method

.method public final b()V
    .locals 2

    .prologue
    .line 104
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dx;->g:Lcom/wishabi/flipp/widget/dw;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/dw;->b(Lcom/wishabi/flipp/widget/dw;)Ljava/util/Map;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/dx;->b:Lcom/wishabi/flipp/widget/dy;

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dx;->g:Lcom/wishabi/flipp/widget/dw;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/dw;->c(Lcom/wishabi/flipp/widget/dw;)Ljava/util/Stack;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 106
    return-void
.end method
