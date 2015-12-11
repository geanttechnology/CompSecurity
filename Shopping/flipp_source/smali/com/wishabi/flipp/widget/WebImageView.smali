.class public Lcom/wishabi/flipp/widget/WebImageView;
.super Landroid/widget/ImageView;
.source "SourceFile"


# instance fields
.field protected a:Ljava/lang/String;

.field protected b:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 17
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/WebImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/WebImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 22
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 26
    return-void
.end method

.method private a()V
    .locals 2

    .prologue
    .line 80
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/WebImageView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/a/b/ad;->a(Landroid/content/Context;)Lcom/a/b/ad;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/WebImageView;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/a/b/ad;->a(Ljava/lang/String;)Lcom/a/b/aq;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Lcom/a/b/aq;->a(Landroid/widget/ImageView;Lcom/a/b/j;)V

    .line 81
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 4

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/WebImageView;->b:Z

    if-nez v0, :cond_1

    .line 46
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 58
    :cond_0
    :goto_0
    return-void

    .line 50
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/WebImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 51
    if-eqz v2, :cond_0

    .line 54
    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/WebImageView;->getWidth()I

    move-result v3

    int-to-float v3, v3

    int-to-float v0, v0

    div-float v0, v3, v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/WebImageView;->getHeight()I

    move-result v3

    int-to-float v3, v3

    int-to-float v1, v1

    div-float v1, v3, v1

    cmpl-float v3, v0, v1

    if-lez v3, :cond_2

    .line 55
    :goto_1
    invoke-virtual {p1, v0, v0}, Landroid/graphics/Canvas;->scale(FF)V

    .line 57
    invoke-virtual {v2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_0

    :cond_2
    move v0, v1

    .line 54
    goto :goto_1
.end method

.method protected onSizeChanged(IIII)V
    .locals 1

    .prologue
    .line 72
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ImageView;->onSizeChanged(IIII)V

    .line 74
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/WebImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 75
    iget-object v0, p0, Lcom/wishabi/flipp/widget/WebImageView;->a:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 76
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/WebImageView;->a()V

    .line 77
    :cond_0
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/WebImageView;->a:Ljava/lang/String;

    if-nez v0, :cond_0

    if-eqz p1, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/WebImageView;->a:Ljava/lang/String;

    if-eqz v0, :cond_2

    if-eqz p1, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/widget/WebImageView;->a:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 41
    :cond_1
    :goto_0
    return-void

    .line 37
    :cond_2
    iput-object p1, p0, Lcom/wishabi/flipp/widget/WebImageView;->a:Ljava/lang/String;

    .line 38
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/WebImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 39
    if-eqz p1, :cond_1

    .line 40
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/WebImageView;->a()V

    goto :goto_0
.end method

.method public setTopLeftCrop(Z)V
    .locals 0

    .prologue
    .line 29
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/WebImageView;->b:Z

    .line 30
    return-void
.end method
