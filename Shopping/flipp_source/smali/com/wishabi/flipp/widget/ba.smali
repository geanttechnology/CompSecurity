.class public final Lcom/wishabi/flipp/widget/ba;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field final a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

.field private final b:Landroid/widget/TextView;

.field private final c:Landroid/widget/TextView;

.field private final d:Lcom/wishabi/flipp/widget/WebImageView;

.field private final e:Landroid/widget/TextView;

.field private f:Z

.field private g:Z

.field private final h:Landroid/graphics/Rect;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 33
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ba;-><init>(Landroid/content/Context;B)V

    .line 34
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 37
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ba;-><init>(Landroid/content/Context;C)V

    .line 38
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;C)V
    .locals 2

    .prologue
    .line 41
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 44
    const v0, 0x7f030029

    invoke-static {p1, v0, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 46
    const v0, 0x7f0b0040

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ba;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ba;->b:Landroid/widget/TextView;

    .line 47
    const v0, 0x7f0b00af

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ba;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ba;->c:Landroid/widget/TextView;

    .line 48
    const v0, 0x7f0b0094

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ba;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ba;->e:Landroid/widget/TextView;

    .line 49
    const v0, 0x7f0b00ae

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ba;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ba;->d:Lcom/wishabi/flipp/widget/WebImageView;

    .line 50
    const v0, 0x7f0b00b1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ba;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/FeaturedItemCell;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->c:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 53
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->d:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setTopLeftCrop(Z)V

    .line 54
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->e:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 55
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->a()V

    .line 57
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ba;->h:Landroid/graphics/Rect;

    .line 58
    return-void
.end method

.method private b()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 71
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/ba;->g:Z

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->e:Landroid/widget/TextView;

    const v1, 0x7f0e0016

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 73
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->e:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ba;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090006

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 75
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->e:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 84
    :goto_0
    return-void

    .line 76
    :cond_0
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/ba;->f:Z

    if-eqz v0, :cond_1

    .line 77
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->e:Landroid/widget/TextView;

    const v1, 0x7f0e0015

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 78
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->e:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ba;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090005

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 80
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->e:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 82
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->e:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method final a()V
    .locals 4

    .prologue
    .line 101
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 102
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ba;->b:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 103
    const-string v1, ". "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 104
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ba;->c:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 106
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->getData()Lcom/wishabi/flipp/content/h;

    move-result-object v1

    .line 107
    if-eqz v1, :cond_2

    .line 108
    const-string v2, ". "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 109
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ba;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0e00b5

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 111
    iget-object v2, v1, Lcom/wishabi/flipp/content/h;->g:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 112
    const-string v2, ". "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 113
    iget-object v2, v1, Lcom/wishabi/flipp/content/h;->g:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 116
    :cond_0
    iget-object v2, v1, Lcom/wishabi/flipp/content/h;->e:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 117
    const-string v2, ". "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 118
    iget-object v2, v1, Lcom/wishabi/flipp/content/h;->e:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 121
    :cond_1
    iget-object v2, v1, Lcom/wishabi/flipp/content/h;->d:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 122
    const-string v2, ". "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 123
    iget-object v1, v1, Lcom/wishabi/flipp/content/h;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 127
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ba;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 128
    return-void
.end method

.method public final getFeaturedItem()Lcom/wishabi/flipp/content/h;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->getData()Lcom/wishabi/flipp/content/h;

    move-result-object v0

    return-object v0
.end method

.method public final getPercentVisibility()F
    .locals 3

    .prologue
    .line 149
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ba;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ba;->getHeight()I

    move-result v1

    mul-int/2addr v0, v1

    .line 150
    if-gtz v0, :cond_0

    .line 151
    const/4 v0, 0x0

    .line 156
    :goto_0
    return v0

    .line 153
    :cond_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ba;->h:Landroid/graphics/Rect;

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/ba;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    .line 154
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ba;->h:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v1

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ba;->h:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->height()I

    move-result v2

    mul-int/2addr v1, v2

    .line 156
    int-to-float v1, v1

    const/high16 v2, 0x42c80000    # 100.0f

    mul-float/2addr v1, v2

    int-to-float v0, v0

    div-float v0, v1, v0

    goto :goto_0
.end method

.method public final setFeaturedItemClickListener(Lcom/wishabi/flipp/widget/bc;)V
    .locals 2

    .prologue
    .line 160
    if-nez p1, :cond_0

    .line 161
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 170
    :goto_0
    return-void

    .line 163
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    new-instance v1, Lcom/wishabi/flipp/widget/bb;

    invoke-direct {v1, p0, p1}, Lcom/wishabi/flipp/widget/bb;-><init>(Lcom/wishabi/flipp/widget/ba;Lcom/wishabi/flipp/widget/bc;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method public final setFlyerDate(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->c:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 97
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ba;->a()V

    .line 98
    return-void
.end method

.method public final setFlyerName(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->b:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ba;->a()V

    .line 93
    return-void
.end method

.method public final setThumbnailUrl(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ba;->d:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 88
    return-void
.end method

.method public final setUnread(Z)V
    .locals 0

    .prologue
    .line 66
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/ba;->f:Z

    .line 67
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/ba;->b()V

    .line 68
    return-void
.end method

.method public final setUpcoming(Z)V
    .locals 0

    .prologue
    .line 61
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/ba;->g:Z

    .line 62
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/ba;->b()V

    .line 63
    return-void
.end method
