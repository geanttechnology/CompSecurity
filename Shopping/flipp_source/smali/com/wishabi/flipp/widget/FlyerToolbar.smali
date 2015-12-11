.class public Lcom/wishabi/flipp/widget/FlyerToolbar;
.super Landroid/widget/RelativeLayout;
.source "SourceFile"


# instance fields
.field public final a:Landroid/widget/TextView;

.field public b:Z

.field private c:Lcom/wishabi/flipp/widget/bh;

.field private final d:Landroid/widget/SeekBar;

.field private final e:Landroid/widget/ImageButton;

.field private final f:Landroid/widget/ImageButton;

.field private final g:Landroid/widget/ProgressBar;

.field private final h:Landroid/widget/Button;

.field private i:I

.field private j:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 43
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 44
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 47
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 48
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 56
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 59
    const v0, 0x7f03002f

    invoke-static {p1, v0, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 61
    const v0, 0x7f0b00c9

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    const/16 v1, 0x32

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setMax(I)V

    .line 63
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    new-instance v1, Lcom/wishabi/flipp/widget/bd;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/bd;-><init>(Lcom/wishabi/flipp/widget/FlyerToolbar;)V

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 88
    const v0, 0x7f0b00c5

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->a:Landroid/widget/TextView;

    .line 90
    const v0, 0x7f0b00c7

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->e:Landroid/widget/ImageButton;

    .line 91
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->e:Landroid/widget/ImageButton;

    new-instance v1, Lcom/wishabi/flipp/widget/be;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/be;-><init>(Lcom/wishabi/flipp/widget/FlyerToolbar;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 99
    const v0, 0x7f0b00c6

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->f:Landroid/widget/ImageButton;

    .line 100
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->f:Landroid/widget/ImageButton;

    new-instance v1, Lcom/wishabi/flipp/widget/bf;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/bf;-><init>(Lcom/wishabi/flipp/widget/FlyerToolbar;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 108
    const v0, 0x7f0b00c3

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->h:Landroid/widget/Button;

    .line 109
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->h:Landroid/widget/Button;

    new-instance v1, Lcom/wishabi/flipp/widget/bg;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/bg;-><init>(Lcom/wishabi/flipp/widget/FlyerToolbar;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 117
    const v0, 0x7f0b00c8

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->g:Landroid/widget/ProgressBar;

    .line 119
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->g:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 120
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->a:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 121
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->f:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 122
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->e:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 123
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/FlyerToolbar;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->g:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method private b()V
    .locals 5

    .prologue
    const/16 v3, 0x8

    const/4 v1, 0x0

    .line 208
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    invoke-virtual {v0}, Landroid/widget/SeekBar;->getProgress()I

    move-result v0

    .line 209
    if-nez v0, :cond_1

    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->i:I

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->j:Z

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 211
    :goto_0
    iget-object v4, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->a:Landroid/widget/TextView;

    if-eqz v0, :cond_2

    move v2, v1

    :goto_1
    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 212
    iget-object v4, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->f:Landroid/widget/ImageButton;

    if-eqz v0, :cond_3

    move v2, v3

    :goto_2
    invoke-virtual {v4, v2}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 213
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->e:Landroid/widget/ImageButton;

    if-eqz v0, :cond_4

    :goto_3
    invoke-virtual {v2, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 214
    return-void

    :cond_1
    move v0, v1

    .line 209
    goto :goto_0

    :cond_2
    move v2, v3

    .line 211
    goto :goto_1

    :cond_3
    move v2, v1

    .line 212
    goto :goto_2

    :cond_4
    move v3, v1

    .line 213
    goto :goto_3
.end method

.method static synthetic b(Lcom/wishabi/flipp/widget/FlyerToolbar;)V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->b()V

    return-void
.end method

.method static synthetic c(Lcom/wishabi/flipp/widget/FlyerToolbar;)Lcom/wishabi/flipp/widget/bh;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->c:Lcom/wishabi/flipp/widget/bh;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/widget/FlyerToolbar;)V
    .locals 0

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->a()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 217
    iget-object v1, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    invoke-virtual {v1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v1

    if-lez v1, :cond_1

    .line 218
    iget-object v1, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    .line 220
    :cond_0
    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/SeekBar;->setEnabled(Z)V

    .line 221
    return-void

    .line 220
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    iget-boolean v2, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->b:Z

    if-eqz v2, :cond_0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getDiscount()I
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    invoke-virtual {v0}, Landroid/widget/SeekBar;->getProgress()I

    move-result v0

    return v0
.end method

.method public getShowCoupon()Z
    .locals 1

    .prologue
    .line 204
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->j:Z

    return v0
.end method

.method public setBackwardEnabled(Z)V
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->f:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 131
    return-void
.end method

.method public setCouponCount(I)V
    .locals 1

    .prologue
    .line 181
    iput p1, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->i:I

    .line 182
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->j:Z

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setShowCoupon(Z)V

    .line 183
    return-void
.end method

.method public setDiscount(I)V
    .locals 2

    .prologue
    .line 150
    const/16 v0, 0x32

    invoke-static {p1, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 151
    iget-object v1, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    invoke-virtual {v1, v0}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 152
    return-void
.end method

.method public setFlyerToolbarListener(Lcom/wishabi/flipp/widget/bh;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->c:Lcom/wishabi/flipp/widget/bh;

    .line 53
    return-void
.end method

.method public setForwardEnabled(Z)V
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->e:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 127
    return-void
.end method

.method public setProgressVisible(Z)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/16 v1, 0x8

    .line 134
    if-eqz p1, :cond_0

    .line 135
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->g:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 136
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setVisibility(I)V

    .line 137
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->h:Landroid/widget/Button;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 138
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->a:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 139
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->f:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 140
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->e:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 147
    :goto_0
    return-void

    .line 142
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->g:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 143
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->d:Landroid/widget/SeekBar;

    invoke-virtual {v0, v2}, Landroid/widget/SeekBar;->setVisibility(I)V

    .line 144
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->h:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 145
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->b()V

    goto :goto_0
.end method

.method public setShowCoupon(Z)V
    .locals 7

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 187
    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->i:I

    if-gtz v2, :cond_2

    .line 188
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->h:Landroid/widget/Button;

    const v3, 0x7f0e013b

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setText(I)V

    .line 196
    :goto_0
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->h:Landroid/widget/Button;

    if-nez p1, :cond_0

    iget v3, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->i:I

    if-lez v3, :cond_1

    :cond_0
    move v0, v1

    :cond_1
    invoke-virtual {v2, v0}, Landroid/widget/Button;->setEnabled(Z)V

    .line 197
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->h:Landroid/widget/Button;

    invoke-virtual {v0, p1}, Landroid/widget/Button;->setSelected(Z)V

    .line 198
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->j:Z

    .line 200
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->b()V

    .line 201
    return-void

    .line 189
    :cond_2
    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->i:I

    if-ne v2, v1, :cond_3

    .line 190
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->h:Landroid/widget/Button;

    const v3, 0x7f0e0139

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setText(I)V

    goto :goto_0

    .line 192
    :cond_3
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->h:Landroid/widget/Button;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0e013a

    new-array v5, v1, [Ljava/lang/Object;

    iget v6, p0, Lcom/wishabi/flipp/widget/FlyerToolbar;->i:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v0

    invoke-virtual {v3, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
