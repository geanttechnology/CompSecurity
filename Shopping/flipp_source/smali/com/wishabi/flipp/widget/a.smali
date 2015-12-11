.class public final Lcom/wishabi/flipp/widget/a;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field final a:Landroid/view/View;

.field final b:Landroid/view/View;

.field final c:Landroid/view/View;

.field final d:Landroid/widget/TextView;

.field final e:Landroid/widget/TextView;

.field final f:Landroid/widget/TextView;

.field final g:Landroid/widget/TextView;

.field h:Lcom/wishabi/flipp/app/dn;

.field private final i:Landroid/view/View;

.field private final j:Landroid/view/View;

.field private final k:Landroid/widget/ImageView;

.field private final l:Lcom/wishabi/flipp/widget/WebImageView;

.field private final m:Landroid/view/View;

.field private final n:Lcom/wishabi/flipp/widget/WebImageView;

.field private final o:Landroid/widget/TextView;

.field private final p:Landroid/widget/TextView;

.field private q:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 48
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/a;-><init>(Landroid/content/Context;B)V

    .line 49
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/a;-><init>(Landroid/content/Context;C)V

    .line 53
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;C)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 56
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 58
    const v0, 0x7f030007

    invoke-static {p1, v0, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 60
    const v0, 0x7f0b002e

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->i:Landroid/view/View;

    .line 61
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->i:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 62
    const v0, 0x7f0b003c

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->j:Landroid/view/View;

    .line 63
    const v0, 0x7f0b003d

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->k:Landroid/widget/ImageView;

    .line 66
    const v0, 0x7f0b002f

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->a:Landroid/view/View;

    .line 67
    const v0, 0x7f0b0030

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->l:Lcom/wishabi/flipp/widget/WebImageView;

    .line 68
    const v0, 0x7f0b0039

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->m:Landroid/view/View;

    .line 70
    const v0, 0x7f0b003a

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->n:Lcom/wishabi/flipp/widget/WebImageView;

    .line 72
    const v0, 0x7f0b003b

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->o:Landroid/widget/TextView;

    .line 74
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->o:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 75
    const v0, 0x7f0b0031

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->p:Landroid/widget/TextView;

    .line 77
    const v0, 0x7f0b0032

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    .line 78
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 79
    const v0, 0x7f0b0034

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->c:Landroid/view/View;

    .line 80
    const v0, 0x7f0b0035

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->d:Landroid/widget/TextView;

    .line 82
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->d:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 83
    const v0, 0x7f0b0036

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->e:Landroid/widget/TextView;

    .line 85
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->e:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 86
    const v0, 0x7f0b0037

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->f:Landroid/widget/TextView;

    .line 88
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->f:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 89
    const v0, 0x7f0b0038

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/a;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/a;->g:Landroid/widget/TextView;

    .line 91
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/a;)Lcom/wishabi/flipp/app/dn;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->h:Lcom/wishabi/flipp/app/dn;

    return-object v0
.end method

.method private a()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 282
    iget v0, p0, Lcom/wishabi/flipp/widget/a;->q:I

    sget v1, Lcom/wishabi/flipp/widget/f;->b:I

    if-ne v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/a;->isActivated()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 284
    invoke-static {v4}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 285
    invoke-virtual {p0, v0, v0, v0, v0}, Lcom/wishabi/flipp/widget/a;->setPadding(IIII)V

    .line 286
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->j:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 287
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->k:Landroid/widget/ImageView;

    const v1, 0x7f0200e0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 289
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->k:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 304
    :goto_0
    return-void

    .line 290
    :cond_0
    iget v0, p0, Lcom/wishabi/flipp/widget/a;->q:I

    sget v1, Lcom/wishabi/flipp/widget/f;->b:I

    if-ne v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/a;->isActivated()Z

    move-result v0

    if-nez v0, :cond_1

    .line 292
    invoke-static {v4}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 293
    invoke-virtual {p0, v0, v0, v0, v0}, Lcom/wishabi/flipp/widget/a;->setPadding(IIII)V

    .line 294
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->j:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 295
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->k:Landroid/widget/ImageView;

    const v1, 0x7f0200e1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 297
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->k:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 299
    :cond_1
    invoke-virtual {p0, v2, v2, v2, v2}, Lcom/wishabi/flipp/widget/a;->setPadding(IIII)V

    .line 300
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->j:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 301
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->k:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 302
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->k:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public final setActivated(Z)V
    .locals 0

    .prologue
    .line 308
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->setActivated(Z)V

    .line 309
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/a;->a()V

    .line 310
    return-void
.end method

.method public final setCouponMatchupAvailable(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 265
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 266
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->g:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 267
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->g:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 274
    :goto_0
    return-void

    .line 270
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->g:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 271
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->g:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 272
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setCouponMatchupHeight(I)V
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 196
    return-void
.end method

.method public final setExpired(Z)V
    .locals 3

    .prologue
    .line 157
    if-eqz p1, :cond_0

    .line 158
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->p:Landroid/widget/TextView;

    const v1, 0x7f0e0014

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 159
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->p:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/a;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090002

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 161
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->p:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 165
    :goto_0
    return-void

    .line 163
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->p:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setImageUrl(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 168
    if-eqz p1, :cond_0

    .line 169
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->l:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 170
    :cond_0
    return-void
.end method

.method public final setItemBackgroundResource(I)V
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->a:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundResource(I)V

    .line 154
    return-void
.end method

.method public final setMerchantFallback(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 173
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 174
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->m:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 181
    :goto_0
    return-void

    .line 176
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->m:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 177
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->o:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 178
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->o:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 179
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->n:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setMerchantLogoUrl(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 184
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 185
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->m:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 192
    :goto_0
    return-void

    .line 187
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->m:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 188
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->n:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 189
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->n:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 190
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->o:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setSelectionState$448952c2(I)V
    .locals 0

    .prologue
    .line 277
    iput p1, p0, Lcom/wishabi/flipp/widget/a;->q:I

    .line 278
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/a;->a()V

    .line 279
    return-void
.end method

.method public final setShowCouponMatchup(Z)V
    .locals 4

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 199
    iget-object v3, p0, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    if-eqz p1, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 200
    iget-object v0, p0, Lcom/wishabi/flipp/widget/a;->i:Landroid/view/View;

    if-eqz p1, :cond_1

    :goto_1
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 201
    return-void

    :cond_0
    move v0, v2

    .line 199
    goto :goto_0

    :cond_1
    move v1, v2

    .line 200
    goto :goto_1
.end method
