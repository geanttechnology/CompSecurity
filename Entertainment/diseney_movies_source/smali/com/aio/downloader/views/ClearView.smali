.class public Lcom/aio/downloader/views/ClearView;
.super Landroid/view/View;
.source "ClearView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;
    }
.end annotation


# instance fields
.field private angelListener:Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;

.field private color:I

.field private heigth:I

.field private isRun:Z

.field private paint:Landroid/graphics/Paint;

.field private rectf:Landroid/graphics/RectF;

.field state:Z

.field private sweepAngle:I

.field private width:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x1

    .line 24
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 19
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/views/ClearView;->isRun:Z

    .line 20
    iput-boolean v1, p0, Lcom/aio/downloader/views/ClearView;->state:Z

    .line 25
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/ClearView;->paint:Landroid/graphics/Paint;

    .line 26
    iget-object v0, p0, Lcom/aio/downloader/views/ClearView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 27
    const v0, -0x8a5807

    iput v0, p0, Lcom/aio/downloader/views/ClearView;->color:I

    .line 28
    const/16 v0, 0xe6

    iput v0, p0, Lcom/aio/downloader/views/ClearView;->sweepAngle:I

    .line 29
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/ClearView;)Z
    .locals 1

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/aio/downloader/views/ClearView;->isRun:Z

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/views/ClearView;)I
    .locals 1

    .prologue
    .line 16
    iget v0, p0, Lcom/aio/downloader/views/ClearView;->sweepAngle:I

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/views/ClearView;I)V
    .locals 0

    .prologue
    .line 16
    iput p1, p0, Lcom/aio/downloader/views/ClearView;->sweepAngle:I

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/views/ClearView;Z)V
    .locals 0

    .prologue
    .line 19
    iput-boolean p1, p0, Lcom/aio/downloader/views/ClearView;->isRun:Z

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/views/ClearView;I)V
    .locals 0

    .prologue
    .line 18
    iput p1, p0, Lcom/aio/downloader/views/ClearView;->color:I

    return-void
.end method


# virtual methods
.method public SetonAngelchanged(Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/aio/downloader/views/ClearView;->angelListener:Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;

    .line 100
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 83
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 84
    iget-object v0, p0, Lcom/aio/downloader/views/ClearView;->paint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/ClearView;->color:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 85
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView;->rectf:Landroid/graphics/RectF;

    const/high16 v2, -0x3d4c0000    # -90.0f

    iget v0, p0, Lcom/aio/downloader/views/ClearView;->sweepAngle:I

    int-to-float v3, v0

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/aio/downloader/views/ClearView;->paint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    .line 86
    iget-object v0, p0, Lcom/aio/downloader/views/ClearView;->angelListener:Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/aio/downloader/views/ClearView;->angelListener:Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;

    iget v1, p0, Lcom/aio/downloader/views/ClearView;->sweepAngle:I

    invoke-interface {v0, v1}, Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;->OnAngelChanged(I)V

    .line 90
    :cond_0
    return-void
.end method

.method protected onMeasure(II)V
    .locals 4
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/4 v3, 0x0

    .line 74
    invoke-super {p0, p1, p2}, Landroid/view/View;->onMeasure(II)V

    .line 75
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/ClearView;->width:I

    .line 76
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/ClearView;->heigth:I

    .line 77
    new-instance v0, Landroid/graphics/RectF;

    iget v1, p0, Lcom/aio/downloader/views/ClearView;->width:I

    int-to-float v1, v1

    iget v2, p0, Lcom/aio/downloader/views/ClearView;->heigth:I

    int-to-float v2, v2

    invoke-direct {v0, v3, v3, v1, v2}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lcom/aio/downloader/views/ClearView;->rectf:Landroid/graphics/RectF;

    .line 78
    iget v0, p0, Lcom/aio/downloader/views/ClearView;->width:I

    iget v1, p0, Lcom/aio/downloader/views/ClearView;->heigth:I

    invoke-virtual {p0, v0, v1}, Lcom/aio/downloader/views/ClearView;->setMeasuredDimension(II)V

    .line 79
    return-void
.end method

.method public setAngle(I)V
    .locals 2
    .param p1, "angle"    # I

    .prologue
    const/4 v1, 0x1

    .line 32
    iget-boolean v0, p0, Lcom/aio/downloader/views/ClearView;->isRun:Z

    if-eqz v0, :cond_0

    .line 70
    :goto_0
    return-void

    .line 35
    :cond_0
    iput-boolean v1, p0, Lcom/aio/downloader/views/ClearView;->state:Z

    .line 36
    iput-boolean v1, p0, Lcom/aio/downloader/views/ClearView;->isRun:Z

    .line 37
    new-instance v0, Lcom/aio/downloader/views/ClearView$1;

    invoke-direct {v0, p0, p1}, Lcom/aio/downloader/views/ClearView$1;-><init>(Lcom/aio/downloader/views/ClearView;I)V

    .line 68
    invoke-virtual {v0}, Lcom/aio/downloader/views/ClearView$1;->start()V

    goto :goto_0
.end method
