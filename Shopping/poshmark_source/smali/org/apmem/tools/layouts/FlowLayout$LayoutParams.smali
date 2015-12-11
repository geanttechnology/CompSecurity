.class public Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;
.super Landroid/view/ViewGroup$MarginLayoutParams;
.source "FlowLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/apmem/tools/layouts/FlowLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LayoutParams"
.end annotation


# instance fields
.field public gravity:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        mapping = {
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x0
                to = "NONE"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x30
                to = "TOP"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x50
                to = "BOTTOM"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x3
                to = "LEFT"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x5
                to = "RIGHT"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x10
                to = "CENTER_VERTICAL"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x70
                to = "FILL_VERTICAL"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x1
                to = "CENTER_HORIZONTAL"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x7
                to = "FILL_HORIZONTAL"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x11
                to = "CENTER"
            .end subannotation,
            .subannotation Landroid/view/ViewDebug$IntToString;
                from = 0x77
                to = "FILL"
            .end subannotation
        }
    .end annotation
.end field

.field private inlineStartLength:I

.field private inlineStartThickness:I

.field private length:I

.field public newLine:Z

.field private spacingLength:I

.field private spacingThickness:I

.field private thickness:I

.field public weight:F

.field private x:I

.field private y:I


# direct methods
.method public constructor <init>(II)V
    .locals 1
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    const/4 v0, 0x0

    .line 468
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V

    .line 436
    iput-boolean v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->newLine:Z

    .line 437
    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->gravity:I

    .line 451
    const/high16 v0, -0x40800000    # -1.0f

    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->weight:F

    .line 469
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attributeSet"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, 0x0

    .line 463
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 436
    iput-boolean v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->newLine:Z

    .line 437
    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->gravity:I

    .line 451
    const/high16 v0, -0x40800000    # -1.0f

    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->weight:F

    .line 464
    invoke-direct {p0, p1, p2}, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->readStyleParameters(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 465
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1
    .param p1, "layoutParams"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    const/4 v0, 0x0

    .line 472
    invoke-direct {p0, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 436
    iput-boolean v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->newLine:Z

    .line 437
    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->gravity:I

    .line 451
    const/high16 v0, -0x40800000    # -1.0f

    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->weight:F

    .line 473
    return-void
.end method

.method static synthetic access$000(Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;)I
    .locals 1
    .param p0, "x0"    # Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;

    .prologue
    .line 435
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->x:I

    return v0
.end method

.method static synthetic access$100(Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;)I
    .locals 1
    .param p0, "x0"    # Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;

    .prologue
    .line 435
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->y:I

    return v0
.end method

.method private readStyleParameters(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attributeSet"    # Landroid/util/AttributeSet;

    .prologue
    .line 484
    sget-object v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout_LayoutParams:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 486
    .local v0, "a":Landroid/content/res/TypedArray;
    :try_start_0
    sget v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout_LayoutParams_layout_newLine:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->newLine:Z

    .line 487
    sget v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout_LayoutParams_android_layout_gravity:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    iput v1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->gravity:I

    .line 488
    sget v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout_LayoutParams_layout_weight:I

    const/high16 v2, -0x40800000    # -1.0f

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->weight:F
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 490
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 492
    return-void

    .line 490
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    throw v1
.end method


# virtual methods
.method clearCalculatedFields(I)V
    .locals 2
    .param p1, "orientation"    # I

    .prologue
    .line 541
    if-nez p1, :cond_0

    .line 542
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->leftMargin:I

    iget v1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->rightMargin:I

    add-int/2addr v0, v1

    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->spacingLength:I

    .line 543
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->topMargin:I

    iget v1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->bottomMargin:I

    add-int/2addr v0, v1

    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->spacingThickness:I

    .line 548
    :goto_0
    return-void

    .line 545
    :cond_0
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->topMargin:I

    iget v1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->bottomMargin:I

    add-int/2addr v0, v1

    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->spacingLength:I

    .line 546
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->leftMargin:I

    iget v1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->rightMargin:I

    add-int/2addr v0, v1

    iput v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->spacingThickness:I

    goto :goto_0
.end method

.method getInlineStartLength()I
    .locals 1

    .prologue
    .line 501
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->inlineStartLength:I

    return v0
.end method

.method getInlineStartThickness()I
    .locals 1

    .prologue
    .line 525
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->inlineStartThickness:I

    return v0
.end method

.method getLength()I
    .locals 1

    .prologue
    .line 509
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->length:I

    return v0
.end method

.method getSpacingLength()I
    .locals 1

    .prologue
    .line 533
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->spacingLength:I

    return v0
.end method

.method getSpacingThickness()I
    .locals 1

    .prologue
    .line 537
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->spacingThickness:I

    return v0
.end method

.method getThickness()I
    .locals 1

    .prologue
    .line 517
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->thickness:I

    return v0
.end method

.method public gravitySpecified()Z
    .locals 1

    .prologue
    .line 476
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->gravity:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method setInlineStartLength(I)V
    .locals 0
    .param p1, "inlineStartLength"    # I

    .prologue
    .line 505
    iput p1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->inlineStartLength:I

    .line 506
    return-void
.end method

.method setInlineStartThickness(I)V
    .locals 0
    .param p1, "inlineStartThickness"    # I

    .prologue
    .line 529
    iput p1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->inlineStartThickness:I

    .line 530
    return-void
.end method

.method setLength(I)V
    .locals 0
    .param p1, "length"    # I

    .prologue
    .line 513
    iput p1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->length:I

    .line 514
    return-void
.end method

.method setPosition(II)V
    .locals 0
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 496
    iput p1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->x:I

    .line 497
    iput p2, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->y:I

    .line 498
    return-void
.end method

.method setThickness(I)V
    .locals 0
    .param p1, "thickness"    # I

    .prologue
    .line 521
    iput p1, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->thickness:I

    .line 522
    return-void
.end method

.method public weightSpecified()Z
    .locals 2

    .prologue
    .line 480
    iget v0, p0, Lorg/apmem/tools/layouts/FlowLayout$LayoutParams;->weight:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
