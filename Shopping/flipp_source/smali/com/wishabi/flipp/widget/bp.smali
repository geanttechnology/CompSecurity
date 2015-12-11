.class public final Lcom/wishabi/flipp/widget/bp;
.super Landroid/view/View;
.source "SourceFile"


# instance fields
.field final a:Landroid/widget/EdgeEffect;

.field final b:Landroid/widget/EdgeEffect;

.field final c:Landroid/widget/EdgeEffect;

.field final d:Landroid/widget/EdgeEffect;

.field e:Z

.field f:Z

.field g:Z

.field h:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 23
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 25
    new-instance v0, Landroid/widget/EdgeEffect;

    invoke-direct {v0, p1}, Landroid/widget/EdgeEffect;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bp;->a:Landroid/widget/EdgeEffect;

    .line 26
    new-instance v0, Landroid/widget/EdgeEffect;

    invoke-direct {v0, p1}, Landroid/widget/EdgeEffect;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bp;->b:Landroid/widget/EdgeEffect;

    .line 27
    new-instance v0, Landroid/widget/EdgeEffect;

    invoke-direct {v0, p1}, Landroid/widget/EdgeEffect;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bp;->c:Landroid/widget/EdgeEffect;

    .line 28
    new-instance v0, Landroid/widget/EdgeEffect;

    invoke-direct {v0, p1}, Landroid/widget/EdgeEffect;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bp;->d:Landroid/widget/EdgeEffect;

    .line 30
    iput-boolean v1, p0, Lcom/wishabi/flipp/widget/bp;->e:Z

    .line 31
    iput-boolean v1, p0, Lcom/wishabi/flipp/widget/bp;->g:Z

    .line 32
    iput-boolean v1, p0, Lcom/wishabi/flipp/widget/bp;->f:Z

    .line 33
    iput-boolean v1, p0, Lcom/wishabi/flipp/widget/bp;->h:Z

    .line 34
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 93
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bp;->a:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    .line 94
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bp;->b:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    .line 95
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bp;->c:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bp;->d:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    .line 98
    iput-boolean v1, p0, Lcom/wishabi/flipp/widget/bp;->e:Z

    .line 99
    iput-boolean v1, p0, Lcom/wishabi/flipp/widget/bp;->g:Z

    .line 100
    iput-boolean v1, p0, Lcom/wishabi/flipp/widget/bp;->f:Z

    .line 101
    iput-boolean v1, p0, Lcom/wishabi/flipp/widget/bp;->h:Z

    .line 102
    return-void
.end method

.method protected final onDraw(Landroid/graphics/Canvas;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 106
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 108
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bp;->a:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-nez v0, :cond_1

    .line 109
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v0

    .line 110
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getHeight()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1, v4, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 111
    const/high16 v1, -0x3d4c0000    # -90.0f

    invoke-virtual {p1, v1, v4, v4}, Landroid/graphics/Canvas;->rotate(FFF)V

    .line 112
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bp;->a:Landroid/widget/EdgeEffect;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getHeight()I

    move-result v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getWidth()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/widget/EdgeEffect;->setSize(II)V

    .line 113
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bp;->a:Landroid/widget/EdgeEffect;

    invoke-virtual {v1, p1}, Landroid/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 114
    invoke-static {p0}, Landroid/support/v4/view/ap;->d(Landroid/view/View;)V

    .line 116
    :cond_0
    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 119
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bp;->b:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-nez v0, :cond_3

    .line 120
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v0

    .line 121
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getWidth()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1, v1, v4}, Landroid/graphics/Canvas;->translate(FF)V

    .line 122
    const/high16 v1, 0x42b40000    # 90.0f

    invoke-virtual {p1, v1, v4, v4}, Landroid/graphics/Canvas;->rotate(FFF)V

    .line 123
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bp;->b:Landroid/widget/EdgeEffect;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getHeight()I

    move-result v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getWidth()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/widget/EdgeEffect;->setSize(II)V

    .line 124
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bp;->b:Landroid/widget/EdgeEffect;

    invoke-virtual {v1, p1}, Landroid/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 125
    invoke-static {p0}, Landroid/support/v4/view/ap;->d(Landroid/view/View;)V

    .line 127
    :cond_2
    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 130
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bp;->c:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-nez v0, :cond_5

    .line 131
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v0

    .line 132
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bp;->c:Landroid/widget/EdgeEffect;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getHeight()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/widget/EdgeEffect;->setSize(II)V

    .line 133
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bp;->c:Landroid/widget/EdgeEffect;

    invoke-virtual {v1, p1}, Landroid/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 134
    invoke-static {p0}, Landroid/support/v4/view/ap;->d(Landroid/view/View;)V

    .line 136
    :cond_4
    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 139
    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bp;->d:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-nez v0, :cond_7

    .line 140
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v0

    .line 141
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getWidth()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getHeight()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .line 142
    const/high16 v1, 0x43340000    # 180.0f

    invoke-virtual {p1, v1, v4, v4}, Landroid/graphics/Canvas;->rotate(FFF)V

    .line 143
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bp;->d:Landroid/widget/EdgeEffect;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bp;->getHeight()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/widget/EdgeEffect;->setSize(II)V

    .line 144
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bp;->d:Landroid/widget/EdgeEffect;

    invoke-virtual {v1, p1}, Landroid/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 145
    invoke-static {p0}, Landroid/support/v4/view/ap;->d(Landroid/view/View;)V

    .line 147
    :cond_6
    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 149
    :cond_7
    return-void
.end method
