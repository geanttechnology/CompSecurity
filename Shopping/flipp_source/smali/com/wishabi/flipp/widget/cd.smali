.class public final Lcom/wishabi/flipp/widget/cd;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field final a:Lcom/wishabi/flipp/widget/CouponCell;

.field final b:Landroid/view/View;

.field final c:Lcom/wishabi/flipp/widget/ItemCellSmall;

.field d:Lcom/wishabi/flipp/app/dn;

.field private final e:Landroid/widget/TextView;

.field private final f:Landroid/widget/TextView;

.field private final g:Landroid/view/View;

.field private final h:Landroid/widget/TextView;

.field private final i:Landroid/widget/TextView;

.field private final j:Landroid/view/View;

.field private final k:Landroid/widget/TextView;

.field private final l:Landroid/view/View;

.field private final m:Landroid/widget/TextView;

.field private final n:Landroid/widget/TextView;

.field private final o:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 41
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/cd;-><init>(Landroid/content/Context;B)V

    .line 42
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 45
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/cd;-><init>(Landroid/content/Context;C)V

    .line 46
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;C)V
    .locals 2

    .prologue
    .line 49
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 51
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/cd;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f030032

    invoke-static {v0, v1, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 53
    const v0, 0x7f0b00d9

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/CouponCell;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->a:Lcom/wishabi/flipp/widget/CouponCell;

    .line 54
    const v0, 0x7f0b00ca

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->b:Landroid/view/View;

    .line 55
    const v0, 0x7f0b00cc

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ItemCellSmall;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->c:Lcom/wishabi/flipp/widget/ItemCellSmall;

    .line 56
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->c:Lcom/wishabi/flipp/widget/ItemCellSmall;

    sget-object v1, Landroid/widget/ImageView$ScaleType;->CENTER_CROP:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ItemCellSmall;->setImageScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 57
    const v0, 0x7f0b00cd

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->e:Landroid/widget/TextView;

    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->e:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 59
    const v0, 0x7f0b00ce

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->f:Landroid/widget/TextView;

    .line 61
    const v0, 0x7f0b00d0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->g:Landroid/view/View;

    .line 63
    const v0, 0x7f0b00d1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->h:Landroid/widget/TextView;

    .line 65
    const v0, 0x7f0b00d2

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->i:Landroid/widget/TextView;

    .line 66
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->i:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/cd;->i:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v1

    or-int/lit8 v1, v1, 0x10

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 68
    const v0, 0x7f0b00d3

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->j:Landroid/view/View;

    .line 70
    const v0, 0x7f0b00d4

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->k:Landroid/widget/TextView;

    .line 71
    const v0, 0x7f0b00d5

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->l:Landroid/view/View;

    .line 73
    const v0, 0x7f0b00d6

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->m:Landroid/widget/TextView;

    .line 74
    const v0, 0x7f0b00d7

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->n:Landroid/widget/TextView;

    .line 75
    const v0, 0x7f0b00d8

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/cd;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cd;->o:Landroid/widget/TextView;

    .line 76
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/cd;)Lcom/wishabi/flipp/app/dn;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->d:Lcom/wishabi/flipp/app/dn;

    return-object v0
.end method


# virtual methods
.method public final getCouponCell()Lcom/wishabi/flipp/widget/CouponCell;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->a:Lcom/wishabi/flipp/widget/CouponCell;

    return-object v0
.end method

.method public final setBadgeText(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 171
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 172
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->o:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 177
    :goto_0
    return-void

    .line 174
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->o:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 175
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->o:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setItemCouponPrice(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 158
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->l:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 164
    :goto_0
    return-void

    .line 161
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->m:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 162
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->l:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setItemCurrentPrice(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 129
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 136
    :goto_0
    return-void

    .line 132
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->h:Landroid/widget/TextView;

    const v1, 0x7f0e00c5

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 133
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->i:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 134
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setItemDiscountPrice(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 149
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 150
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->j:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 155
    :goto_0
    return-void

    .line 152
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->k:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 153
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->j:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setItemFinalPrice(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->n:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 168
    return-void
.end method

.method public final setItemMatchupImage(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->c:Lcom/wishabi/flipp/widget/ItemCellSmall;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ItemCellSmall;->setImageUrl(Ljava/lang/String;)V

    .line 118
    return-void
.end method

.method public final setItemMatchupLabel(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->e:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 122
    return-void
.end method

.method public final setItemMatchupMerchant(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->f:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 126
    return-void
.end method

.method public final setItemOriginalPrice(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 139
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 146
    :goto_0
    return-void

    .line 142
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->h:Landroid/widget/TextView;

    const v1, 0x7f0e00c8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 143
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->i:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 144
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cd;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method
