.class public Lcom/aio/downloader/views/RoundImageView;
.super Landroid/widget/ImageView;
.source "RoundImageView.java"


# instance fields
.field private final maskPaint:Landroid/graphics/Paint;

.field private rect_adius:F

.field private final roundRect:Landroid/graphics/RectF;

.field private final zonePaint:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 31
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/RoundImageView;->roundRect:Landroid/graphics/RectF;

    .line 32
    const/high16 v0, 0x42700000    # 60.0f

    iput v0, p0, Lcom/aio/downloader/views/RoundImageView;->rect_adius:F

    .line 33
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/RoundImageView;->maskPaint:Landroid/graphics/Paint;

    .line 34
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/RoundImageView;->zonePaint:Landroid/graphics/Paint;

    .line 28
    invoke-direct {p0}, Lcom/aio/downloader/views/RoundImageView;->init()V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/RoundImageView;->roundRect:Landroid/graphics/RectF;

    .line 32
    const/high16 v0, 0x42700000    # 60.0f

    iput v0, p0, Lcom/aio/downloader/views/RoundImageView;->rect_adius:F

    .line 33
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/RoundImageView;->maskPaint:Landroid/graphics/Paint;

    .line 34
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/RoundImageView;->zonePaint:Landroid/graphics/Paint;

    .line 23
    invoke-direct {p0}, Lcom/aio/downloader/views/RoundImageView;->init()V

    .line 24
    return-void
.end method

.method private init()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 37
    iget-object v1, p0, Lcom/aio/downloader/views/RoundImageView;->maskPaint:Landroid/graphics/Paint;

    invoke-virtual {v1, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 38
    iget-object v1, p0, Lcom/aio/downloader/views/RoundImageView;->maskPaint:Landroid/graphics/Paint;

    new-instance v2, Landroid/graphics/PorterDuffXfermode;

    sget-object v3, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v2, v3}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 40
    iget-object v1, p0, Lcom/aio/downloader/views/RoundImageView;->zonePaint:Landroid/graphics/Paint;

    invoke-virtual {v1, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 41
    iget-object v1, p0, Lcom/aio/downloader/views/RoundImageView;->zonePaint:Landroid/graphics/Paint;

    const v2, -0xb0c11

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 43
    invoke-virtual {p0}, Lcom/aio/downloader/views/RoundImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    .line 44
    .local v0, "density":F
    iget v1, p0, Lcom/aio/downloader/views/RoundImageView;->rect_adius:F

    mul-float/2addr v1, v0

    iput v1, p0, Lcom/aio/downloader/views/RoundImageView;->rect_adius:F

    .line 45
    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/16 v4, 0x1f

    .line 63
    iget-object v0, p0, Lcom/aio/downloader/views/RoundImageView;->roundRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/aio/downloader/views/RoundImageView;->zonePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v4}, Landroid/graphics/Canvas;->saveLayer(Landroid/graphics/RectF;Landroid/graphics/Paint;I)I

    .line 64
    iget-object v0, p0, Lcom/aio/downloader/views/RoundImageView;->roundRect:Landroid/graphics/RectF;

    iget v1, p0, Lcom/aio/downloader/views/RoundImageView;->rect_adius:F

    iget v2, p0, Lcom/aio/downloader/views/RoundImageView;->rect_adius:F

    iget-object v3, p0, Lcom/aio/downloader/views/RoundImageView;->zonePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 66
    iget-object v0, p0, Lcom/aio/downloader/views/RoundImageView;->roundRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/aio/downloader/views/RoundImageView;->maskPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v4}, Landroid/graphics/Canvas;->saveLayer(Landroid/graphics/RectF;Landroid/graphics/Paint;I)I

    .line 67
    invoke-super {p0, p1}, Landroid/widget/ImageView;->draw(Landroid/graphics/Canvas;)V

    .line 68
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 69
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 6
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    const/4 v5, 0x0

    .line 55
    invoke-super/range {p0 .. p5}, Landroid/widget/ImageView;->onLayout(ZIIII)V

    .line 56
    invoke-virtual {p0}, Lcom/aio/downloader/views/RoundImageView;->getWidth()I

    move-result v1

    .line 57
    .local v1, "w":I
    invoke-virtual {p0}, Lcom/aio/downloader/views/RoundImageView;->getHeight()I

    move-result v0

    .line 58
    .local v0, "h":I
    iget-object v2, p0, Lcom/aio/downloader/views/RoundImageView;->roundRect:Landroid/graphics/RectF;

    int-to-float v3, v1

    int-to-float v4, v0

    invoke-virtual {v2, v5, v5, v3, v4}, Landroid/graphics/RectF;->set(FFFF)V

    .line 59
    return-void
.end method

.method public setRectAdius(F)V
    .locals 0
    .param p1, "adius"    # F

    .prologue
    .line 48
    iput p1, p0, Lcom/aio/downloader/views/RoundImageView;->rect_adius:F

    .line 49
    invoke-virtual {p0}, Lcom/aio/downloader/views/RoundImageView;->invalidate()V

    .line 50
    return-void
.end method
