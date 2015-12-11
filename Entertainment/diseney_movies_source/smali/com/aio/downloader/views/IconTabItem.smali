.class public Lcom/aio/downloader/views/IconTabItem;
.super Landroid/widget/RadioButton;
.source "IconTabItem.java"


# instance fields
.field private buttonDrawable:Landroid/graphics/drawable/Drawable;

.field private mDrawableHeight:I

.field private mDrawableWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    .line 28
    invoke-direct {p0, p1, p2}, Landroid/widget/RadioButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 29
    sget-object v1, Lcom/aio/downloader/R$styleable;->CompoundButton:[I

    invoke-virtual {p1, p2, v1, v2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 30
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/views/IconTabItem;->buttonDrawable:Landroid/graphics/drawable/Drawable;

    .line 31
    const/4 v1, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/IconTabItem;->mDrawableWidth:I

    .line 32
    const/4 v1, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/IconTabItem;->mDrawableHeight:I

    .line 33
    const v1, 0x7f02007a

    invoke-virtual {p0, v1}, Lcom/aio/downloader/views/IconTabItem;->setButtonDrawable(I)V

    .line 34
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 35
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 8
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 39
    invoke-super {p0, p1}, Landroid/widget/RadioButton;->onDraw(Landroid/graphics/Canvas;)V

    .line 40
    iget-object v5, p0, Lcom/aio/downloader/views/IconTabItem;->buttonDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v5, :cond_0

    .line 41
    iget-object v5, p0, Lcom/aio/downloader/views/IconTabItem;->buttonDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0}, Lcom/aio/downloader/views/IconTabItem;->getDrawableState()[I

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 42
    invoke-virtual {p0}, Lcom/aio/downloader/views/IconTabItem;->getGravity()I

    move-result v5

    and-int/lit8 v3, v5, 0x70

    .line 43
    .local v3, "verticalGravity":I
    iget v5, p0, Lcom/aio/downloader/views/IconTabItem;->mDrawableWidth:I

    if-nez v5, :cond_1

    iget-object v5, p0, Lcom/aio/downloader/views/IconTabItem;->buttonDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v5}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    .line 45
    .local v0, "buttonHeight":I
    :goto_0
    const/4 v4, 0x0

    .line 47
    .local v4, "y":I
    sparse-switch v3, :sswitch_data_0

    .line 56
    :goto_1
    iget v5, p0, Lcom/aio/downloader/views/IconTabItem;->mDrawableHeight:I

    if-nez v5, :cond_2

    iget-object v5, p0, Lcom/aio/downloader/views/IconTabItem;->buttonDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v5}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 57
    .local v2, "buttonWidth":I
    :goto_2
    invoke-virtual {p0}, Lcom/aio/downloader/views/IconTabItem;->getWidth()I

    move-result v5

    sub-int/2addr v5, v2

    div-int/lit8 v1, v5, 0x2

    .line 58
    .local v1, "buttonLeft":I
    iget-object v5, p0, Lcom/aio/downloader/views/IconTabItem;->buttonDrawable:Landroid/graphics/drawable/Drawable;

    add-int v6, v1, v2

    add-int v7, v4, v0

    invoke-virtual {v5, v1, v4, v6, v7}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 59
    iget-object v5, p0, Lcom/aio/downloader/views/IconTabItem;->buttonDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v5, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 61
    .end local v0    # "buttonHeight":I
    .end local v1    # "buttonLeft":I
    .end local v2    # "buttonWidth":I
    .end local v3    # "verticalGravity":I
    .end local v4    # "y":I
    :cond_0
    return-void

    .line 43
    .restart local v3    # "verticalGravity":I
    :cond_1
    iget v0, p0, Lcom/aio/downloader/views/IconTabItem;->mDrawableWidth:I

    goto :goto_0

    .line 49
    .restart local v0    # "buttonHeight":I
    .restart local v4    # "y":I
    :sswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/views/IconTabItem;->getHeight()I

    move-result v5

    sub-int v4, v5, v0

    .line 50
    goto :goto_1

    .line 52
    :sswitch_1
    invoke-virtual {p0}, Lcom/aio/downloader/views/IconTabItem;->getHeight()I

    move-result v5

    sub-int/2addr v5, v0

    div-int/lit8 v4, v5, 0x2

    goto :goto_1

    .line 56
    :cond_2
    iget v2, p0, Lcom/aio/downloader/views/IconTabItem;->mDrawableHeight:I

    goto :goto_2

    .line 47
    nop

    :sswitch_data_0
    .sparse-switch
        0x10 -> :sswitch_1
        0x50 -> :sswitch_0
    .end sparse-switch
.end method
