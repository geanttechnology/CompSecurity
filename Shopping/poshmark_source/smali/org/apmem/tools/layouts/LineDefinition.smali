.class Lorg/apmem/tools/layouts/LineDefinition;
.super Ljava/lang/Object;
.source "LineDefinition.java"


# instance fields
.field private final config:Lorg/apmem/tools/layouts/LayoutConfiguration;

.field private lineLength:I

.field private lineLengthWithSpacing:I

.field private lineStartLength:I

.field private lineStartThickness:I

.field private lineThickness:I

.field private lineThicknessWithSpacing:I

.field private final maxLength:I

.field private final views:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(ILorg/apmem/tools/layouts/LayoutConfiguration;)V
    .locals 2
    .param p1, "maxLength"    # I
    .param p2, "config"    # Lorg/apmem/tools/layouts/LayoutConfiguration;

    .prologue
    const/4 v1, 0x0

    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->views:Ljava/util/List;

    .line 20
    iput v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineStartThickness:I

    .line 21
    iput v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineStartLength:I

    .line 22
    iput p1, p0, Lorg/apmem/tools/layouts/LineDefinition;->maxLength:I

    .line 23
    iput-object p2, p0, Lorg/apmem/tools/layouts/LineDefinition;->config:Lorg/apmem/tools/layouts/LayoutConfiguration;

    .line 24
    return-void
.end method


# virtual methods
.method public addLineStartLength(I)V
    .locals 1
    .param p1, "extraLineStartLength"    # I

    .prologue
    .line 88
    iget v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineStartLength:I

    add-int/2addr v0, p1

    iput v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineStartLength:I

    .line 89
    return-void
.end method

.method public addLineStartThickness(I)V
    .locals 1
    .param p1, "extraLineStartThickness"    # I

    .prologue
    .line 84
    iget v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineStartThickness:I

    add-int/2addr v0, p1

    iput v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineStartThickness:I

    .line 85
    return-void
.end method

.method public addView(ILandroid/view/View;)V
    .locals 4
    .param p1, "i"    # I
    .param p2, "child"    # Landroid/view/View;

    .prologue
    .line 31
    invoke-virtual {p2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;

    .line 33
    .local v0, "lp":Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;
    iget-object v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->views:Ljava/util/List;

    invoke-interface {v1, p1, p2}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 35
    iget v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLengthWithSpacing:I

    invoke-virtual {v0}, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->getLength()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLength:I

    .line 36
    iget v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLength:I

    invoke-virtual {v0}, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->getSpacingLength()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLengthWithSpacing:I

    .line 37
    iget v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineThicknessWithSpacing:I

    invoke-virtual {v0}, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->getThickness()I

    move-result v2

    invoke-virtual {v0}, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->getSpacingThickness()I

    move-result v3

    add-int/2addr v2, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    iput v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineThicknessWithSpacing:I

    .line 38
    iget v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineThickness:I

    invoke-virtual {v0}, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->getThickness()I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    iput v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineThickness:I

    .line 39
    return-void
.end method

.method public addView(Landroid/view/View;)V
    .locals 1
    .param p1, "child"    # Landroid/view/View;

    .prologue
    .line 27
    iget-object v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->views:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-virtual {p0, v0, p1}, Lorg/apmem/tools/layouts/LineDefinition;->addView(ILandroid/view/View;)V

    .line 28
    return-void
.end method

.method public canFit(Landroid/view/View;)Z
    .locals 3
    .param p1, "child"    # Landroid/view/View;

    .prologue
    .line 43
    iget-object v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->config:Lorg/apmem/tools/layouts/LayoutConfiguration;

    invoke-virtual {v1}, Lorg/apmem/tools/layouts/LayoutConfiguration;->getOrientation()I

    move-result v1

    if-nez v1, :cond_0

    .line 44
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    .line 48
    .local v0, "childLength":I
    :goto_0
    iget v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLengthWithSpacing:I

    add-int/2addr v1, v0

    iget v2, p0, Lorg/apmem/tools/layouts/LineDefinition;->maxLength:I

    if-gt v1, v2, :cond_1

    const/4 v1, 0x1

    :goto_1
    return v1

    .line 46
    .end local v0    # "childLength":I
    :cond_0
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    .restart local v0    # "childLength":I
    goto :goto_0

    .line 48
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public getLineLength()I
    .locals 1

    .prologue
    .line 60
    iget v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLength:I

    return v0
.end method

.method public getLineStartLength()I
    .locals 1

    .prologue
    .line 64
    iget v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineStartLength:I

    return v0
.end method

.method public getLineStartThickness()I
    .locals 1

    .prologue
    .line 52
    iget v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineStartThickness:I

    return v0
.end method

.method public getLineThickness()I
    .locals 1

    .prologue
    .line 56
    iget v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineThicknessWithSpacing:I

    return v0
.end method

.method public getViews()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    iget-object v0, p0, Lorg/apmem/tools/layouts/LineDefinition;->views:Ljava/util/List;

    return-object v0
.end method

.method public setLength(I)V
    .locals 3
    .param p1, "length"    # I

    .prologue
    .line 78
    iget v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLengthWithSpacing:I

    iget v2, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLength:I

    sub-int v0, v1, v2

    .line 79
    .local v0, "lengthSpacing":I
    iput p1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLength:I

    .line 80
    add-int v1, p1, v0

    iput v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineLengthWithSpacing:I

    .line 81
    return-void
.end method

.method public setThickness(I)V
    .locals 3
    .param p1, "thickness"    # I

    .prologue
    .line 72
    iget v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineThicknessWithSpacing:I

    iget v2, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineThickness:I

    sub-int v0, v1, v2

    .line 73
    .local v0, "thicknessSpacing":I
    iput p1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineThicknessWithSpacing:I

    .line 74
    sub-int v1, p1, v0

    iput v1, p0, Lorg/apmem/tools/layouts/LineDefinition;->lineThickness:I

    .line 75
    return-void
.end method
