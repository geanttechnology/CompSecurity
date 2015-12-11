.class public Lcom/wishabi/flipp/widget/FeaturedItemCell;
.super Lcom/wishabi/flipp/widget/SlidingFrameLayout;
.source "SourceFile"


# instance fields
.field a:Landroid/animation/Animator;

.field private final b:Landroid/widget/TextView;

.field private final c:Lcom/wishabi/flipp/widget/WebImageView;

.field private final d:Lcom/wishabi/flipp/widget/WebImageView;

.field private final e:Landroid/widget/TextView;

.field private final f:Landroid/widget/TextView;

.field private g:Lcom/wishabi/flipp/content/h;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 34
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0, p1, p2, p3}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 41
    const v0, 0x7f0200e8

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->setBackgroundResource(I)V

    .line 43
    const v0, 0x7f030026

    invoke-static {p1, v0, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 45
    const v0, 0x7f0b00a6

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->b:Landroid/widget/TextView;

    .line 46
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->b:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 47
    const v0, 0x7f0b00a7

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->c:Lcom/wishabi/flipp/widget/WebImageView;

    .line 48
    const v0, 0x7f0b00aa

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->d:Lcom/wishabi/flipp/widget/WebImageView;

    .line 49
    const v0, 0x7f0b00a9

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->e:Landroid/widget/TextView;

    .line 50
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->e:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 51
    const v0, 0x7f0b00a8

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->f:Landroid/widget/TextView;

    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->f:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 54
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->getSlideInAnimation()Landroid/animation/Animator;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->a:Landroid/animation/Animator;

    .line 55
    return-void
.end method

.method private getSlideInAnimation()Landroid/animation/Animator;
    .locals 5

    .prologue
    const/4 v3, 0x2

    .line 125
    const-string v0, "xFraction"

    new-array v1, v3, [F

    fill-array-data v1, :array_0

    invoke-static {p0, v0, v1}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 126
    const-string v1, "alpha"

    new-array v2, v3, [F

    fill-array-data v2, :array_1

    invoke-static {p0, v1, v2}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v1

    .line 127
    new-instance v2, Landroid/animation/AnimatorSet;

    invoke-direct {v2}, Landroid/animation/AnimatorSet;-><init>()V

    .line 128
    new-array v3, v3, [Landroid/animation/Animator;

    const/4 v4, 0x0

    aput-object v1, v3, v4

    const/4 v1, 0x1

    aput-object v0, v3, v1

    invoke-virtual {v2, v3}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 129
    const-wide/16 v0, 0x14d

    invoke-virtual {v2, v0, v1}, Landroid/animation/AnimatorSet;->setDuration(J)Landroid/animation/AnimatorSet;

    .line 130
    new-instance v0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v2, v0}, Landroid/animation/AnimatorSet;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 132
    return-object v2

    .line 125
    nop

    :array_0
    .array-data 4
        0x3f800000    # 1.0f
        0x0
    .end array-data

    .line 126
    :array_1
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method


# virtual methods
.method public final a()V
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->a:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    .line 120
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->setVisibility(I)V

    .line 121
    return-void
.end method

.method public getData()Lcom/wishabi/flipp/content/h;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    return-object v0
.end method

.method public setData(Lcom/wishabi/flipp/content/h;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/16 v2, 0x8

    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    if-ne v0, p1, :cond_1

    .line 96
    :cond_0
    :goto_0
    return-void

    .line 61
    :cond_1
    iput-object p1, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    if-eqz v0, :cond_0

    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    iget-object v0, v0, Lcom/wishabi/flipp/content/h;->h:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 66
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->c:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 67
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->c:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    iget-object v0, v0, Lcom/wishabi/flipp/content/h;->g:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 70
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->b:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 81
    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->d:Lcom/wishabi/flipp/widget/WebImageView;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    iget-object v1, v1, Lcom/wishabi/flipp/content/h;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 83
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    iget-object v0, v0, Lcom/wishabi/flipp/content/h;->e:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 84
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->e:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 90
    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    iget-object v0, v0, Lcom/wishabi/flipp/content/h;->d:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 91
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->f:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 72
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->b:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    iget-object v1, v1, Lcom/wishabi/flipp/content/h;->g:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 73
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->b:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 76
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->c:Lcom/wishabi/flipp/widget/WebImageView;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    iget-object v1, v1, Lcom/wishabi/flipp/content/h;->h:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 77
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->c:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 78
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->b:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 86
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->e:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    iget-object v1, v1, Lcom/wishabi/flipp/content/h;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 87
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->e:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_2

    .line 93
    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->f:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->g:Lcom/wishabi/flipp/content/h;

    iget-object v1, v1, Lcom/wishabi/flipp/content/h;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FeaturedItemCell;->f:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0
.end method
