.class public final Lcom/wishabi/flipp/widget/af;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# static fields
.field public static final a:[I


# instance fields
.field final b:Landroid/widget/RelativeLayout;

.field final c:Landroid/widget/LinearLayout;

.field private final d:Lcom/wishabi/flipp/widget/WebImageView;

.field private final e:Landroid/widget/TextView;

.field private final f:Lcom/wishabi/flipp/widget/WebImageView;

.field private final g:Landroid/widget/TextView;

.field private final h:Landroid/widget/TextView;

.field private final i:Landroid/widget/LinearLayout;

.field private final j:Landroid/widget/TextView;

.field private final k:Landroid/widget/TextView;

.field private final l:Landroid/widget/TextView;

.field private final m:Landroid/widget/TextView;

.field private final n:Landroid/widget/TextView;

.field private final o:Landroid/widget/RelativeLayout;

.field private final p:Landroid/widget/LinearLayout;

.field private final q:Lcom/wishabi/flipp/widget/ActionButton;

.field private final r:Lcom/wishabi/flipp/widget/ActionButton;

.field private final s:Landroid/widget/TextView;

.field private final t:Landroid/widget/LinearLayout;

.field private final u:Landroid/widget/TextView;

.field private final v:Landroid/widget/TextView;

.field private w:Lcom/wishabi/flipp/widget/ak;

.field private x:Z

.field private y:Z

.field private z:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 28
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x7f010009

    aput v2, v0, v1

    sput-object v0, Lcom/wishabi/flipp/widget/af;->a:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 63
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/af;-><init>(Landroid/content/Context;B)V

    .line 64
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 67
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/af;-><init>(Landroid/content/Context;C)V

    .line 68
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;C)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 71
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, v2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 73
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/af;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f03001d

    invoke-static {v0, v1, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 75
    const v0, 0x7f0b007a

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->d:Lcom/wishabi/flipp/widget/WebImageView;

    .line 76
    const v0, 0x7f0b007c

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->e:Landroid/widget/TextView;

    .line 77
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->e:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 78
    const v0, 0x7f0b007d

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->f:Lcom/wishabi/flipp/widget/WebImageView;

    .line 79
    const v0, 0x7f0b007f

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->g:Landroid/widget/TextView;

    .line 80
    const v0, 0x7f0b0080

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->h:Landroid/widget/TextView;

    .line 81
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->h:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 82
    const v0, 0x7f0b0081

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->i:Landroid/widget/LinearLayout;

    .line 83
    const v0, 0x7f0b0082

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->j:Landroid/widget/TextView;

    .line 84
    const v0, 0x7f0b0084

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->k:Landroid/widget/TextView;

    .line 85
    const v0, 0x7f0b0083

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->l:Landroid/widget/TextView;

    .line 86
    const v0, 0x7f0b0085

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->m:Landroid/widget/TextView;

    .line 87
    const v0, 0x7f0b0086

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->n:Landroid/widget/TextView;

    .line 88
    const v0, 0x7f0b0087

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->o:Landroid/widget/RelativeLayout;

    .line 90
    const v0, 0x7f0b008b

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->p:Landroid/widget/LinearLayout;

    .line 91
    const v0, 0x7f0b008d

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ActionButton;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->q:Lcom/wishabi/flipp/widget/ActionButton;

    .line 92
    const v0, 0x7f0b008e

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ActionButton;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->r:Lcom/wishabi/flipp/widget/ActionButton;

    .line 93
    const v0, 0x7f0b008f

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->b:Landroid/widget/RelativeLayout;

    .line 94
    const v0, 0x7f0b0090

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->s:Landroid/widget/TextView;

    .line 95
    const v0, 0x7f0b0091

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->c:Landroid/widget/LinearLayout;

    .line 97
    const v0, 0x7f0b0092

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->t:Landroid/widget/LinearLayout;

    .line 98
    const v0, 0x7f0b0093

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->u:Landroid/widget/TextView;

    .line 99
    const v0, 0x7f0b0094

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/af;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/af;->v:Landroid/widget/TextView;

    .line 100
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->v:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 102
    iput-boolean v2, p0, Lcom/wishabi/flipp/widget/af;->x:Z

    .line 103
    iput-boolean v2, p0, Lcom/wishabi/flipp/widget/af;->y:Z

    .line 104
    iput-boolean v2, p0, Lcom/wishabi/flipp/widget/af;->z:Z

    .line 106
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/af;->d()V

    .line 107
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/af;)Lcom/wishabi/flipp/widget/ak;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->w:Lcom/wishabi/flipp/widget/ak;

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/widget/af;)Z
    .locals 1

    .prologue
    .line 17
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/af;->z:Z

    return v0
.end method

.method private c()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 357
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/af;->y:Z

    if-eqz v0, :cond_0

    .line 358
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->v:Landroid/widget/TextView;

    const v1, 0x7f0e0017

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 359
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->v:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/af;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090007

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 361
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->v:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 370
    :goto_0
    return-void

    .line 362
    :cond_0
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/af;->x:Z

    if-eqz v0, :cond_1

    .line 363
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->v:Landroid/widget/TextView;

    const v1, 0x7f0e0013

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 364
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->v:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/af;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090001

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 366
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->v:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 368
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->v:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method private d()V
    .locals 5

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 375
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/af;->z:Z

    if-eqz v0, :cond_0

    .line 376
    const v1, 0x7f0200c6

    .line 377
    const v0, 0x7f0e0138

    .line 378
    iget-object v2, p0, Lcom/wishabi/flipp/widget/af;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 379
    iget-object v2, p0, Lcom/wishabi/flipp/widget/af;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 387
    :goto_0
    iget-object v2, p0, Lcom/wishabi/flipp/widget/af;->r:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/widget/ActionButton;->setIcon(I)V

    .line 388
    iget-object v1, p0, Lcom/wishabi/flipp/widget/af;->r:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/ActionButton;->setLabel(I)V

    .line 389
    return-void

    .line 381
    :cond_0
    const v1, 0x7f0200bb

    .line 382
    const v0, 0x7f0e0104

    .line 383
    iget-object v2, p0, Lcom/wishabi/flipp/widget/af;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 384
    iget-object v2, p0, Lcom/wishabi/flipp/widget/af;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 306
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->b:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 307
    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 159
    .line 161
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 162
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->j:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 163
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->j:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    move v0, v1

    .line 170
    :goto_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 171
    iget-object v3, p0, Lcom/wishabi/flipp/widget/af;->l:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 172
    iget-object v3, p0, Lcom/wishabi/flipp/widget/af;->l:Landroid/widget/TextView;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 179
    :goto_1
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 180
    iget-object v3, p0, Lcom/wishabi/flipp/widget/af;->k:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 181
    iget-object v3, p0, Lcom/wishabi/flipp/widget/af;->k:Landroid/widget/TextView;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 188
    :goto_2
    iget-object v3, p0, Lcom/wishabi/flipp/widget/af;->i:Landroid/widget/LinearLayout;

    if-nez v0, :cond_0

    move v1, v2

    :cond_0
    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 189
    return-void

    .line 165
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->j:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 166
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->j:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 167
    const/4 v0, 0x1

    goto :goto_0

    .line 174
    :cond_2
    iget-object v3, p0, Lcom/wishabi/flipp/widget/af;->l:Landroid/widget/TextView;

    invoke-virtual {v3, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 175
    iget-object v3, p0, Lcom/wishabi/flipp/widget/af;->l:Landroid/widget/TextView;

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 176
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 183
    :cond_3
    iget-object v3, p0, Lcom/wishabi/flipp/widget/af;->k:Landroid/widget/TextView;

    invoke-virtual {v3, p3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 184
    iget-object v3, p0, Lcom/wishabi/flipp/widget/af;->k:Landroid/widget/TextView;

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 185
    add-int/lit8 v0, v0, 0x1

    goto :goto_2
.end method

.method public final b()V
    .locals 4

    .prologue
    .line 323
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v1

    .line 324
    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_0

    .line 325
    iget-object v2, p0, Lcom/wishabi/flipp/widget/af;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 324
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 327
    :cond_0
    return-void
.end method

.method public final getIsClipped()Z
    .locals 1

    .prologue
    .line 231
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/af;->x:Z

    return v0
.end method

.method protected final onCreateDrawableState(I)[I
    .locals 2

    .prologue
    .line 111
    add-int/lit8 v0, p1, 0x1

    invoke-super {p0, v0}, Landroid/widget/FrameLayout;->onCreateDrawableState(I)[I

    move-result-object v0

    .line 112
    iget-boolean v1, p0, Lcom/wishabi/flipp/widget/af;->x:Z

    if-eqz v1, :cond_0

    .line 113
    sget-object v1, Lcom/wishabi/flipp/widget/af;->a:[I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/af;->mergeDrawableStates([I[I)[I

    .line 114
    :cond_0
    return-object v0
.end method

.method public final setBrandImage(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 132
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 133
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->f:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 134
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->f:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 135
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->e:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 141
    :goto_0
    return-void

    .line 137
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->f:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 138
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->f:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 139
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->e:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setBrandName(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->e:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 129
    return-void
.end method

.method public final setDisclaimer(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 202
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 203
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->u:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 204
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->u:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 209
    :goto_0
    return-void

    .line 206
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->u:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 207
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->u:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setHasBarcode(Z)V
    .locals 0

    .prologue
    .line 295
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/af;->z:Z

    .line 296
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/af;->d()V

    .line 297
    return-void
.end method

.method public final setImage(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 118
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->d:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 120
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->d:Lcom/wishabi/flipp/widget/WebImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    .line 125
    :goto_0
    return-void

    .line 122
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->d:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 123
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->d:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setIsClipped(Z)V
    .locals 2

    .prologue
    .line 222
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/af;->x:Z

    .line 224
    iget-object v1, p0, Lcom/wishabi/flipp/widget/af;->q:Lcom/wishabi/flipp/widget/ActionButton;

    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/af;->x:Z

    if-eqz v0, :cond_0

    const v0, 0x7f0e0156

    :goto_0
    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/ActionButton;->setLabel(I)V

    .line 227
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/af;->c()V

    .line 228
    return-void

    .line 224
    :cond_0
    const v0, 0x7f0e002c

    goto :goto_0
.end method

.method public final setIsSent(Z)V
    .locals 0

    .prologue
    .line 235
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/af;->y:Z

    .line 236
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/af;->c()V

    .line 237
    return-void
.end method

.method public final setItemMatchupLabel(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 311
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->s:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 312
    return-void
.end method

.method public final setListener(Lcom/wishabi/flipp/widget/ak;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 240
    iput-object p1, p0, Lcom/wishabi/flipp/widget/af;->w:Lcom/wishabi/flipp/widget/ak;

    .line 242
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->w:Lcom/wishabi/flipp/widget/ak;

    if-nez v0, :cond_0

    .line 243
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->q:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 244
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->r:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 245
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 246
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->t:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 292
    :goto_0
    return-void

    .line 250
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->q:Lcom/wishabi/flipp/widget/ActionButton;

    new-instance v1, Lcom/wishabi/flipp/widget/ag;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/ag;-><init>(Lcom/wishabi/flipp/widget/af;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 260
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->r:Lcom/wishabi/flipp/widget/ActionButton;

    new-instance v1, Lcom/wishabi/flipp/widget/ah;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/ah;-><init>(Lcom/wishabi/flipp/widget/af;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 273
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->p:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/wishabi/flipp/widget/ai;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/ai;-><init>(Lcom/wishabi/flipp/widget/af;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 283
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->t:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/wishabi/flipp/widget/aj;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/aj;-><init>(Lcom/wishabi/flipp/widget/af;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method public final setMerchant(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 144
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 145
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->g:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 146
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->h:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 152
    :goto_0
    return-void

    .line 148
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->g:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 149
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->h:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 150
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->h:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setPromoText(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 192
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 193
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->m:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 194
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->m:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 199
    :goto_0
    return-void

    .line 196
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->m:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 197
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->m:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setSaleStory(Ljava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 155
    invoke-virtual {p0, p1, v0, v0}, Lcom/wishabi/flipp/widget/af;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    return-void
.end method

.method public final setValidity(Landroid/text/Spannable;)V
    .locals 2

    .prologue
    .line 212
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 213
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->n:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 214
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->n:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 219
    :goto_0
    return-void

    .line 216
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->n:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 217
    iget-object v0, p0, Lcom/wishabi/flipp/widget/af;->n:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method
