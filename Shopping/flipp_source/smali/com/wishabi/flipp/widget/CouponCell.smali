.class public Lcom/wishabi/flipp/widget/CouponCell;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# static fields
.field public static final a:[I


# instance fields
.field private A:Z

.field private B:Z

.field private C:Z

.field private D:I

.field final b:Landroid/view/View;

.field final c:Landroid/view/View;

.field final d:Lcom/wishabi/flipp/widget/ItemCellSmall;

.field e:Lcom/wishabi/flipp/app/dn;

.field private final f:Landroid/view/View;

.field private final g:Landroid/view/View;

.field private final h:Landroid/widget/ImageView;

.field private final i:Landroid/view/View;

.field private final j:Landroid/view/View;

.field private final k:Landroid/view/View;

.field private final l:Landroid/widget/TextView;

.field private final m:Lcom/wishabi/flipp/widget/WebImageView;

.field private final n:Landroid/widget/TextView;

.field private final o:Landroid/widget/TextView;

.field private final p:Landroid/widget/TextView;

.field private final q:Landroid/widget/TextView;

.field private final r:Lcom/wishabi/flipp/widget/WebImageView;

.field private final s:Landroid/widget/TextView;

.field private final t:Landroid/view/View;

.field private final u:Lcom/wishabi/flipp/widget/WebImageView;

.field private final v:Landroid/widget/TextView;

.field private final w:Landroid/view/View;

.field private final x:Landroid/widget/TextView;

.field private final y:Landroid/widget/TextView;

.field private z:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 38
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x7f010009

    aput v2, v0, v1

    sput-object v0, Lcom/wishabi/flipp/widget/CouponCell;->a:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 85
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/CouponCell;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 86
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/CouponCell;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 90
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 94
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 81
    sget v0, Lcom/wishabi/flipp/widget/z;->a:I

    iput v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->D:I

    .line 96
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CouponCell;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f03001b

    invoke-static {v0, v1, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 98
    const v0, 0x7f0b005e

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->f:Landroid/view/View;

    .line 99
    const v0, 0x7f0b0075

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->g:Landroid/view/View;

    .line 100
    const v0, 0x7f0b0076

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    .line 103
    const v0, 0x7f0b005f

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->i:Landroid/view/View;

    .line 105
    const v0, 0x7f0b0065

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->b:Landroid/view/View;

    .line 107
    const v0, 0x7f0b0066

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->j:Landroid/view/View;

    .line 109
    const v0, 0x7f0b0069

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->k:Landroid/view/View;

    .line 110
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->k:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 111
    const v0, 0x7f0b006a

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->l:Landroid/widget/TextView;

    .line 113
    const v0, 0x7f0b006b

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->m:Lcom/wishabi/flipp/widget/WebImageView;

    .line 115
    const v0, 0x7f0b006d

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->n:Landroid/widget/TextView;

    .line 117
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->n:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 118
    const v0, 0x7f0b006e

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->o:Landroid/widget/TextView;

    .line 120
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->o:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 121
    const v0, 0x7f0b006f

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->p:Landroid/widget/TextView;

    .line 123
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->p:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 124
    const v0, 0x7f0b0070

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->q:Landroid/widget/TextView;

    .line 126
    const v0, 0x7f0b0067

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->r:Lcom/wishabi/flipp/widget/WebImageView;

    .line 127
    const v0, 0x7f0b0068

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    .line 128
    const v0, 0x7f0b0072

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->t:Landroid/view/View;

    .line 130
    const v0, 0x7f0b0073

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->u:Lcom/wishabi/flipp/widget/WebImageView;

    .line 132
    const v0, 0x7f0b0074

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->v:Landroid/widget/TextView;

    .line 134
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->v:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 136
    const v0, 0x7f0b0071

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->w:Landroid/view/View;

    .line 137
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->w:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 138
    const v0, 0x7f0b0060

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    .line 139
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 140
    const v0, 0x7f0b0062

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ItemCellSmall;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->d:Lcom/wishabi/flipp/widget/ItemCellSmall;

    .line 141
    const v0, 0x7f0b0063

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->x:Landroid/widget/TextView;

    .line 142
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->x:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 143
    const v0, 0x7f0b0064

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->y:Landroid/widget/TextView;

    .line 145
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/CouponCell;)Lcom/wishabi/flipp/app/dn;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->e:Lcom/wishabi/flipp/app/dn;

    return-object v0
.end method

.method private a()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 404
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->C:Z

    if-eqz v0, :cond_0

    .line 405
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    const v1, 0x7f0e0018

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 406
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CouponCell;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090008

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 408
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 422
    :goto_0
    return-void

    .line 409
    :cond_0
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->B:Z

    if-eqz v0, :cond_1

    .line 410
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    const v1, 0x7f0e0014

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 411
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CouponCell;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090002

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 413
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 414
    :cond_1
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->A:Z

    if-eqz v0, :cond_2

    .line 415
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    const v1, 0x7f0e0017

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 416
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CouponCell;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090007

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 418
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 420
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->s:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method private b()V
    .locals 7

    .prologue
    const v6, 0x7f0200e1

    const v5, 0x7f0200e0

    const/4 v4, 0x2

    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 425
    iget v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->D:I

    sget v1, Lcom/wishabi/flipp/widget/z;->b:I

    if-ne v0, v1, :cond_0

    .line 426
    invoke-virtual {p0, v2, v2, v2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setPadding(IIII)V

    .line 427
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->g:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 428
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 430
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 431
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->setSelected(Z)V

    .line 464
    :goto_0
    return-void

    .line 432
    :cond_0
    iget v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->D:I

    sget v1, Lcom/wishabi/flipp/widget/z;->c:I

    if-ne v0, v1, :cond_1

    .line 433
    invoke-virtual {p0, v2, v2, v2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setPadding(IIII)V

    .line 434
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->g:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 435
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    invoke-virtual {v0, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 437
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 438
    invoke-virtual {p0, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setSelected(Z)V

    goto :goto_0

    .line 439
    :cond_1
    iget v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->D:I

    sget v1, Lcom/wishabi/flipp/widget/z;->d:I

    if-ne v0, v1, :cond_2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CouponCell;->isActivated()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 441
    invoke-static {v4}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 442
    invoke-virtual {p0, v0, v0, v0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->setPadding(IIII)V

    .line 443
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 444
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 446
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 447
    invoke-virtual {p0, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setSelected(Z)V

    goto :goto_0

    .line 448
    :cond_2
    iget v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->D:I

    sget v1, Lcom/wishabi/flipp/widget/z;->d:I

    if-ne v0, v1, :cond_3

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CouponCell;->isActivated()Z

    move-result v0

    if-nez v0, :cond_3

    .line 450
    invoke-static {v4}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 451
    invoke-virtual {p0, v0, v0, v0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->setPadding(IIII)V

    .line 452
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->g:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 453
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    invoke-virtual {v0, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 455
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 456
    invoke-virtual {p0, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setSelected(Z)V

    goto :goto_0

    .line 458
    :cond_3
    invoke-virtual {p0, v2, v2, v2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setPadding(IIII)V

    .line 459
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->g:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 460
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 461
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->h:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 462
    invoke-virtual {p0, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setSelected(Z)V

    goto :goto_0
.end method


# virtual methods
.method public final a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v2, 0x1

    const/16 v6, 0x8

    const/4 v4, 0x0

    const/4 v1, 0x0

    .line 305
    .line 308
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 309
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->n:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 310
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->n:Landroid/widget/TextView;

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setVisibility(I)V

    move v0, v1

    move-object v3, v4

    .line 320
    :goto_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 321
    iget-object v5, p0, Lcom/wishabi/flipp/widget/CouponCell;->o:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 322
    iget-object v5, p0, Lcom/wishabi/flipp/widget/CouponCell;->o:Landroid/widget/TextView;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 332
    :goto_1
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 333
    iget-object v5, p0, Lcom/wishabi/flipp/widget/CouponCell;->p:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 334
    iget-object v4, p0, Lcom/wishabi/flipp/widget/CouponCell;->p:Landroid/widget/TextView;

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 346
    :goto_2
    if-ne v0, v2, :cond_0

    .line 347
    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 348
    const/4 v0, 0x2

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 350
    :cond_0
    return-void

    .line 312
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->n:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 313
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->n:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 314
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->n:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 316
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->n:Landroid/widget/TextView;

    move-object v3, v0

    move v0, v2

    .line 317
    goto :goto_0

    .line 324
    :cond_2
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CouponCell;->o:Landroid/widget/TextView;

    invoke-virtual {v3, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 325
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CouponCell;->o:Landroid/widget/TextView;

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 326
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CouponCell;->o:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->setSingleLine()V

    .line 328
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CouponCell;->o:Landroid/widget/TextView;

    .line 329
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 336
    :cond_3
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CouponCell;->p:Landroid/widget/TextView;

    invoke-virtual {v3, p3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 337
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CouponCell;->p:Landroid/widget/TextView;

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 338
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CouponCell;->p:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->setSingleLine()V

    .line 340
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CouponCell;->p:Landroid/widget/TextView;

    .line 341
    add-int/lit8 v0, v0, 0x1

    goto :goto_2
.end method

.method public final a(ZZ)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 368
    if-eqz p1, :cond_1

    .line 369
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 370
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->w:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 384
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->q:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    const/16 v1, 0x23

    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 386
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->q:Landroid/widget/TextView;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 389
    :goto_0
    return-void

    .line 376
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 377
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->w:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 379
    if-eqz p2, :cond_0

    .line 380
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->q:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    const/16 v1, 0x55

    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 382
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->q:Landroid/widget/TextView;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMaxLines(I)V

    goto :goto_0
.end method

.method protected onCreateDrawableState(I)[I
    .locals 2

    .prologue
    .line 149
    add-int/lit8 v0, p1, 0x1

    invoke-super {p0, v0}, Landroid/widget/FrameLayout;->onCreateDrawableState(I)[I

    move-result-object v0

    .line 150
    iget-boolean v1, p0, Lcom/wishabi/flipp/widget/CouponCell;->z:Z

    if-eqz v1, :cond_0

    .line 151
    sget-object v1, Lcom/wishabi/flipp/widget/CouponCell;->a:[I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/CouponCell;->mergeDrawableStates([I[I)[I

    .line 152
    :cond_0
    return-object v0
.end method

.method public setActivated(Z)V
    .locals 0

    .prologue
    .line 468
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->setActivated(Z)V

    .line 469
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CouponCell;->b()V

    .line 470
    return-void
.end method

.method public setContainerHeight(I)V
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->f:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 219
    return-void
.end method

.method public setCouponBrandImage(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 283
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 284
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->m:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 285
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->m:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 286
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->l:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 293
    :goto_0
    return-void

    .line 289
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->m:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 290
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->m:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 291
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->l:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setCouponBrandName(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->l:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 280
    return-void
.end method

.method public setCouponImage(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 222
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->r:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 224
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->r:Lcom/wishabi/flipp/widget/WebImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 229
    :goto_0
    return-void

    .line 226
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->r:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 227
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->r:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setCouponPromoText(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 353
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->q:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 354
    return-void
.end method

.method public setCouponSaleStory(Ljava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 300
    invoke-virtual {p0, p1, v0, v0}, Lcom/wishabi/flipp/widget/CouponCell;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 301
    return-void
.end method

.method public setIsClipped(Z)V
    .locals 0

    .prologue
    .line 254
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/CouponCell;->z:Z

    .line 255
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CouponCell;->b()V

    .line 256
    return-void
.end method

.method public setIsExpired(Z)V
    .locals 0

    .prologue
    .line 264
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/CouponCell;->B:Z

    .line 265
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CouponCell;->a()V

    .line 266
    return-void
.end method

.method public setIsSent(Z)V
    .locals 0

    .prologue
    .line 259
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/CouponCell;->A:Z

    .line 260
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CouponCell;->a()V

    .line 261
    return-void
.end method

.method public setIsUnavailable(Z)V
    .locals 0

    .prologue
    .line 269
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/CouponCell;->C:Z

    .line 270
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CouponCell;->a()V

    .line 271
    return-void
.end method

.method public setItemMatchupHeight(I)V
    .locals 2

    .prologue
    .line 357
    const/16 v0, 0xa

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 358
    iget-object v1, p0, Lcom/wishabi/flipp/widget/CouponCell;->w:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iput p1, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 359
    iget-object v1, p0, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    add-int/2addr v0, p1

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 360
    return-void
.end method

.method public setItemMatchupImage(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 392
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->d:Lcom/wishabi/flipp/widget/ItemCellSmall;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ItemCellSmall;->setImageUrl(Ljava/lang/String;)V

    .line 393
    return-void
.end method

.method public setItemMatchupLabel(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 396
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->x:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 397
    return-void
.end method

.method public setItemMatchupMerchant(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 400
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->y:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 401
    return-void
.end method

.method public setMerchantFallback(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 232
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 233
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->t:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 240
    :goto_0
    return-void

    .line 235
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->t:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 236
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->v:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 237
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->v:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 238
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->u:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setMerchantLogoUrl(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 243
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->t:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 251
    :goto_0
    return-void

    .line 246
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->t:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 247
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->u:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 248
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->u:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 249
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CouponCell;->v:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setSelectionState$5470411a(I)V
    .locals 0

    .prologue
    .line 274
    iput p1, p0, Lcom/wishabi/flipp/widget/CouponCell;->D:I

    .line 275
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CouponCell;->b()V

    .line 276
    return-void
.end method

.method public setShowCouponBrand(Z)V
    .locals 2

    .prologue
    .line 296
    iget-object v1, p0, Lcom/wishabi/flipp/widget/CouponCell;->k:Landroid/view/View;

    if-eqz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 297
    return-void

    .line 296
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method
