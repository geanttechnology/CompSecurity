.class public Lcom/poshmark/ui/customviews/CameraViewportRectView;
.super Landroid/view/View;
.source "CameraViewportRectView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;
    }
.end annotation


# instance fields
.field VIEWPORT_HEIGHT:I

.field VIEWPORT_LEFT:I

.field VIEWPORT_TOP:I

.field VIEWPORT_WIDTH:I

.field backgroundPaint:Landroid/graphics/Paint;

.field listener:Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;

.field private parentHeight:I

.field private parentWidth:I

.field viewPortRectPaint:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/16 v1, 0x64

    .line 22
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 12
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->backgroundPaint:Landroid/graphics/Paint;

    .line 13
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->viewPortRectPaint:Landroid/graphics/Paint;

    .line 16
    const/16 v0, 0xa

    iput v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    .line 17
    iput v1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    .line 18
    iput v1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_WIDTH:I

    .line 19
    iput v1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    .line 20
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->listener:Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;

    .line 23
    return-void
.end method


# virtual methods
.method public getViewPortTop()I
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    return v0
.end method

.method public getViewportBottom()I
    .locals 2

    .prologue
    .line 68
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    add-int/2addr v0, v1

    return v0
.end method

.method public getViewportHeight()I
    .locals 1

    .prologue
    .line 80
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    return v0
.end method

.method public getViewportLeft()I
    .locals 1

    .prologue
    .line 60
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    return v0
.end method

.method public getViewportOffsetFromBottomEdgeOfScreen()I
    .locals 3

    .prologue
    .line 96
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->parentHeight:I

    iget v1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v2, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    add-int/2addr v1, v2

    sub-int/2addr v0, v1

    return v0
.end method

.method public getViewportOffsetFromLeftEdgeOfScreen()I
    .locals 1

    .prologue
    .line 84
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    return v0
.end method

.method public getViewportOffsetFromRightEdgeOfScreen()I
    .locals 3

    .prologue
    .line 88
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->parentWidth:I

    iget v1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    iget v2, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_WIDTH:I

    add-int/2addr v1, v2

    sub-int/2addr v0, v1

    return v0
.end method

.method public getViewportOffsetFromTopEdgeOfScreen()I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    return v0
.end method

.method public getViewportRect()Landroid/graphics/Rect;
    .locals 6

    .prologue
    .line 100
    new-instance v0, Landroid/graphics/Rect;

    iget v1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    iget v2, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v3, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    iget v4, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_WIDTH:I

    add-int/2addr v3, v4

    iget v4, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    add-int/2addr v4, v5

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 101
    .local v0, "rect":Landroid/graphics/Rect;
    return-object v0
.end method

.method public getViewportRight()I
    .locals 2

    .prologue
    .line 64
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    iget v1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_WIDTH:I

    add-int/2addr v0, v1

    return v0
.end method

.method public getViewportWidth()I
    .locals 1

    .prologue
    .line 76
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_WIDTH:I

    return v0
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 11
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v10, 0x0

    .line 35
    iget v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->parentWidth:I

    iget v6, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    mul-int/lit8 v6, v6, 0x2

    sub-int/2addr v5, v6

    iput v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_WIDTH:I

    .line 36
    iget v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_WIDTH:I

    iput v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    .line 37
    iget v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->parentHeight:I

    iget v6, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    sub-int/2addr v5, v6

    div-int/lit8 v5, v5, 0x2

    iput v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    .line 39
    new-instance v0, Landroid/graphics/Rect;

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v5

    iget v6, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    invoke-direct {v0, v10, v10, v5, v6}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 40
    .local v0, "above":Landroid/graphics/Rect;
    new-instance v2, Landroid/graphics/Rect;

    iget v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v6, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    iget v7, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v8, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    add-int/2addr v7, v8

    invoke-direct {v2, v10, v5, v6, v7}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 41
    .local v2, "left":Landroid/graphics/Rect;
    new-instance v3, Landroid/graphics/Rect;

    iget v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    iget v6, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_WIDTH:I

    add-int/2addr v5, v6

    iget v6, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v7

    iget v8, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v9, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    add-int/2addr v8, v9

    invoke-direct {v3, v5, v6, v7, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 42
    .local v3, "right":Landroid/graphics/Rect;
    new-instance v1, Landroid/graphics/Rect;

    iget v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v6, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    add-int/2addr v5, v6

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v6

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v7

    invoke-direct {v1, v10, v5, v6, v7}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 44
    .local v1, "bottom":Landroid/graphics/Rect;
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->backgroundPaint:Landroid/graphics/Paint;

    const/16 v6, 0xcc

    invoke-static {v6, v10, v10, v10}, Landroid/graphics/Color;->argb(IIII)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 45
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->backgroundPaint:Landroid/graphics/Paint;

    sget-object v6, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 46
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->backgroundPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v5}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 47
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->backgroundPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v2, v5}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 48
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->backgroundPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v3, v5}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 49
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->backgroundPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v5}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 50
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->viewPortRectPaint:Landroid/graphics/Paint;

    const/4 v6, -0x1

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 51
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->viewPortRectPaint:Landroid/graphics/Paint;

    sget-object v6, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 52
    new-instance v4, Landroid/graphics/Rect;

    iget v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    iget v6, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v7, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_LEFT:I

    iget v8, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_WIDTH:I

    add-int/2addr v7, v8

    iget v8, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_TOP:I

    iget v9, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->VIEWPORT_HEIGHT:I

    add-int/2addr v8, v9

    invoke-direct {v4, v5, v6, v7, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 53
    .local v4, "test":Landroid/graphics/Rect;
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->viewPortRectPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v4, v5}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 54
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->listener:Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;

    if-eqz v5, :cond_0

    .line 55
    iget-object v5, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->listener:Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;

    invoke-interface {v5}, Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;->afterDraw()V

    .line 57
    :cond_0
    return-void
.end method

.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 27
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->parentWidth:I

    .line 28
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->parentHeight:I

    .line 29
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->parentWidth:I

    iget v1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->parentHeight:I

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->setMeasuredDimension(II)V

    .line 30
    return-void
.end method

.method public setCustomListerner(Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/poshmark/ui/customviews/CameraViewportRectView;->listener:Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;

    .line 106
    return-void
.end method
