.class Lcom/aio/downloader/cleaner/Solid;
.super Landroid/view/View;
.source "Solid.java"


# instance fields
.field private aboveWavePaint:Landroid/graphics/Paint;

.field private blowWavePaint:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 19
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/aio/downloader/cleaner/Solid;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 20
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 24
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v1, -0x1

    const/4 v2, -0x2

    invoke-direct {v0, v1, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 25
    .local v0, "params":Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 26
    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/Solid;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 27
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v2, 0x0

    .line 39
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 40
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/Solid;->getLeft()I

    move-result v0

    int-to-float v1, v0

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/Solid;->getRight()I

    move-result v0

    int-to-float v3, v0

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/Solid;->getBottom()I

    move-result v0

    int-to-float v4, v0

    iget-object v5, p0, Lcom/aio/downloader/cleaner/Solid;->blowWavePaint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 41
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/Solid;->getLeft()I

    move-result v0

    int-to-float v1, v0

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/Solid;->getRight()I

    move-result v0

    int-to-float v3, v0

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/Solid;->getBottom()I

    move-result v0

    int-to-float v4, v0

    iget-object v5, p0, Lcom/aio/downloader/cleaner/Solid;->aboveWavePaint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 42
    return-void
.end method

.method public setAboveWavePaint(Landroid/graphics/Paint;)V
    .locals 0
    .param p1, "aboveWavePaint"    # Landroid/graphics/Paint;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/aio/downloader/cleaner/Solid;->aboveWavePaint:Landroid/graphics/Paint;

    .line 31
    return-void
.end method

.method public setBlowWavePaint(Landroid/graphics/Paint;)V
    .locals 0
    .param p1, "blowWavePaint"    # Landroid/graphics/Paint;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/aio/downloader/cleaner/Solid;->blowWavePaint:Landroid/graphics/Paint;

    .line 35
    return-void
.end method
