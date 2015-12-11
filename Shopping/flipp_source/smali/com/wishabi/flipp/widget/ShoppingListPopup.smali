.class public Lcom/wishabi/flipp/widget/ShoppingListPopup;
.super Lcom/wishabi/flipp/widget/SlidingFrameLayout;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Lcom/wishabi/flipp/widget/dr;

.field private final b:Landroid/widget/RelativeLayout;

.field private final c:Landroid/widget/TextView;

.field private final d:Landroid/widget/TextView;

.field private final e:Landroid/widget/Button;

.field private f:J

.field private g:Landroid/animation/Animator;

.field private h:Landroid/animation/Animator;

.field private i:Landroid/animation/Animator;

.field private j:Lcom/wishabi/flipp/widget/dq;

.field private k:I

.field private l:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 79
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 80
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 83
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 84
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3

    .prologue
    .line 88
    invoke-direct {p0, p1, p2, p3}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 90
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090036

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->setBackgroundColor(I)V

    .line 92
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f030050

    invoke-static {v0, v1, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 94
    const v0, 0x7f0b0133

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 97
    const v1, 0x7f0b0136

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->b:Landroid/widget/RelativeLayout;

    .line 100
    const v1, 0x7f0b0139

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->c:Landroid/widget/TextView;

    .line 102
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->c:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setAlpha(F)V

    .line 104
    const v1, 0x7f0b0135

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->e:Landroid/widget/Button;

    .line 106
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->e:Landroid/widget/Button;

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 108
    const v1, 0x7f0b0138

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->d:Landroid/widget/TextView;

    .line 111
    const-wide/16 v0, 0x3e8

    iput-wide v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->f:J

    .line 113
    sget v0, Lcom/wishabi/flipp/widget/ds;->c:I

    iput v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    .line 114
    sget v0, Lcom/wishabi/flipp/widget/dp;->d:I

    iput v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->l:I

    .line 115
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/ShoppingListPopup;)I
    .locals 1

    .prologue
    .line 20
    iget v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    return v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/ShoppingListPopup;I)I
    .locals 0

    .prologue
    .line 20
    iput p1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    return p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/ShoppingListPopup;Lcom/wishabi/flipp/widget/dq;)Lcom/wishabi/flipp/widget/dq;
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->j:Lcom/wishabi/flipp/widget/dq;

    return-object p1
.end method

.method static synthetic b(Lcom/wishabi/flipp/widget/ShoppingListPopup;)Lcom/wishabi/flipp/widget/dr;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a:Lcom/wishabi/flipp/widget/dr;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/widget/ShoppingListPopup;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->e:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/widget/ShoppingListPopup;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->b:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic e(Lcom/wishabi/flipp/widget/ShoppingListPopup;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->c:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic f(Lcom/wishabi/flipp/widget/ShoppingListPopup;)J
    .locals 2

    .prologue
    .line 20
    iget-wide v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->f:J

    return-wide v0
.end method


# virtual methods
.method public final a(Ljava/lang/String;Z)V
    .locals 12

    .prologue
    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v11, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v6, 0x0

    .line 136
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->d:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 139
    iget v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    sget v3, Lcom/wishabi/flipp/widget/ds;->b:I

    if-eq v0, v3, :cond_0

    iget v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    sget v3, Lcom/wishabi/flipp/widget/ds;->c:I

    if-ne v0, v3, :cond_1

    .line 213
    :cond_0
    :goto_0
    return-void

    .line 143
    :cond_1
    iget v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    sget v3, Lcom/wishabi/flipp/widget/ds;->a:I

    if-ne v0, v3, :cond_6

    move v0, v1

    .line 146
    :goto_1
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->i:Landroid/animation/Animator;

    if-eqz v3, :cond_2

    .line 147
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->i:Landroid/animation/Animator;

    invoke-virtual {v3}, Landroid/animation/Animator;->cancel()V

    .line 148
    :cond_2
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->j:Lcom/wishabi/flipp/widget/dq;

    if-eqz v3, :cond_3

    .line 149
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->j:Lcom/wishabi/flipp/widget/dq;

    iput-boolean v1, v3, Lcom/wishabi/flipp/widget/dq;->a:Z

    .line 150
    :cond_3
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->h:Landroid/animation/Animator;

    if-eqz v3, :cond_4

    .line 151
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->h:Landroid/animation/Animator;

    invoke-virtual {v3}, Landroid/animation/Animator;->cancel()V

    .line 154
    :cond_4
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->b:Landroid/widget/RelativeLayout;

    invoke-virtual {v3, v5}, Landroid/widget/RelativeLayout;->setAlpha(F)V

    .line 155
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->c:Landroid/widget/TextView;

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setAlpha(F)V

    .line 156
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->e:Landroid/widget/Button;

    invoke-virtual {v3, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 159
    invoke-virtual {p0, v2}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->setVisibility(I)V

    .line 161
    if-eqz p2, :cond_b

    .line 162
    new-instance v7, Landroid/animation/AnimatorSet;

    invoke-direct {v7}, Landroid/animation/AnimatorSet;-><init>()V

    .line 167
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->getXFraction()F

    move-result v3

    .line 168
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->getYFraction()F

    move-result v4

    .line 169
    sget-object v8, Lcom/wishabi/flipp/widget/do;->a:[I

    iget v9, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->l:I

    add-int/lit8 v9, v9, -0x1

    aget v8, v8, v9

    packed-switch v8, :pswitch_data_0

    .line 184
    const-string v3, "yFraction"

    new-array v8, v11, [F

    cmpl-float v9, v4, v6

    if-nez v9, :cond_5

    if-eqz v0, :cond_5

    move v4, v5

    :cond_5
    aput v4, v8, v2

    aput v6, v8, v1

    invoke-static {p0, v3, v8}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v3

    .line 189
    :goto_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->getAlpha()F

    move-result v4

    .line 190
    const-string v8, "alpha"

    new-array v9, v11, [F

    cmpl-float v10, v4, v5

    if-nez v10, :cond_a

    if-eqz v0, :cond_a

    move v0, v6

    :goto_3
    aput v0, v9, v2

    aput v5, v9, v1

    invoke-static {p0, v8, v9}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 193
    new-array v4, v11, [Landroid/animation/Animator;

    aput-object v3, v4, v2

    aput-object v0, v4, v1

    invoke-virtual {v7, v4}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 195
    iput-object v7, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->g:Landroid/animation/Animator;

    .line 197
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->g:Landroid/animation/Animator;

    new-instance v1, Lcom/wishabi/flipp/widget/dl;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/dl;-><init>(Lcom/wishabi/flipp/widget/ShoppingListPopup;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 209
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->g:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    goto/16 :goto_0

    :cond_6
    move v0, v2

    .line 143
    goto/16 :goto_1

    .line 171
    :pswitch_0
    const-string v4, "xFraction"

    new-array v8, v11, [F

    cmpl-float v9, v3, v6

    if-nez v9, :cond_7

    if-eqz v0, :cond_7

    const/high16 v3, -0x40800000    # -1.0f

    :cond_7
    aput v3, v8, v2

    aput v6, v8, v1

    invoke-static {p0, v4, v8}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v3

    goto :goto_2

    .line 175
    :pswitch_1
    const-string v8, "yFraction"

    new-array v9, v11, [F

    cmpl-float v3, v4, v6

    if-nez v3, :cond_8

    if-eqz v0, :cond_8

    const/high16 v3, -0x40800000    # -1.0f

    :goto_4
    aput v3, v9, v2

    aput v6, v9, v1

    invoke-static {p0, v8, v9}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v3

    goto :goto_2

    :cond_8
    move v3, v4

    goto :goto_4

    .line 179
    :pswitch_2
    const-string v4, "xFraction"

    new-array v8, v11, [F

    cmpl-float v9, v3, v6

    if-nez v9, :cond_9

    if-eqz v0, :cond_9

    move v3, v5

    :cond_9
    aput v3, v8, v2

    aput v6, v8, v1

    invoke-static {p0, v4, v8}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v3

    goto :goto_2

    :cond_a
    move v0, v4

    .line 190
    goto :goto_3

    .line 211
    :cond_b
    sget v0, Lcom/wishabi/flipp/widget/ds;->c:I

    iput v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    goto/16 :goto_0

    .line 169
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final a(Z)V
    .locals 10

    .prologue
    const/high16 v9, 0x3f800000    # 1.0f

    const/high16 v8, -0x40800000    # -1.0f

    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 221
    iget v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    sget v1, Lcom/wishabi/flipp/widget/ds;->a:I

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    sget v1, Lcom/wishabi/flipp/widget/ds;->d:I

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    sget v1, Lcom/wishabi/flipp/widget/ds;->e:I

    if-ne v0, v1, :cond_1

    .line 279
    :cond_0
    :goto_0
    return-void

    .line 226
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->i:Landroid/animation/Animator;

    if-eqz v0, :cond_2

    .line 227
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->i:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    .line 228
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->j:Lcom/wishabi/flipp/widget/dq;

    if-eqz v0, :cond_3

    .line 229
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->j:Lcom/wishabi/flipp/widget/dq;

    iput-boolean v5, v0, Lcom/wishabi/flipp/widget/dq;->a:Z

    .line 230
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->g:Landroid/animation/Animator;

    if-eqz v0, :cond_4

    .line 231
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->g:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    .line 233
    :cond_4
    if-eqz p1, :cond_5

    .line 234
    new-instance v1, Landroid/animation/AnimatorSet;

    invoke-direct {v1}, Landroid/animation/AnimatorSet;-><init>()V

    .line 239
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->getXFraction()F

    move-result v0

    .line 240
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->getYFraction()F

    move-result v2

    .line 241
    sget-object v3, Lcom/wishabi/flipp/widget/do;->a:[I

    iget v4, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->l:I

    add-int/lit8 v4, v4, -0x1

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 253
    const-string v0, "yFraction"

    new-array v3, v7, [F

    aput v2, v3, v6

    aput v9, v3, v5

    invoke-static {p0, v0, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 257
    :goto_1
    const-string v2, "alpha"

    new-array v3, v7, [F

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->getAlpha()F

    move-result v4

    aput v4, v3, v6

    const/4 v4, 0x0

    aput v4, v3, v5

    invoke-static {p0, v2, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v2

    .line 259
    new-array v3, v7, [Landroid/animation/Animator;

    aput-object v0, v3, v6

    aput-object v2, v3, v5

    invoke-virtual {v1, v3}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 261
    iput-object v1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->h:Landroid/animation/Animator;

    .line 262
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->h:Landroid/animation/Animator;

    new-instance v1, Lcom/wishabi/flipp/widget/dm;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/dm;-><init>(Lcom/wishabi/flipp/widget/ShoppingListPopup;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 274
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->h:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    goto :goto_0

    .line 243
    :pswitch_0
    const-string v2, "xFraction"

    new-array v3, v7, [F

    aput v0, v3, v6

    aput v8, v3, v5

    invoke-static {p0, v2, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    goto :goto_1

    .line 246
    :pswitch_1
    const-string v0, "yFraction"

    new-array v3, v7, [F

    aput v2, v3, v6

    aput v8, v3, v5

    invoke-static {p0, v0, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    goto :goto_1

    .line 249
    :pswitch_2
    const-string v2, "xFraction"

    new-array v3, v7, [F

    aput v0, v3, v6

    aput v9, v3, v5

    invoke-static {p0, v2, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    goto :goto_1

    .line 276
    :cond_5
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->setVisibility(I)V

    .line 277
    sget v0, Lcom/wishabi/flipp/widget/ds;->a:I

    iput v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    goto/16 :goto_0

    .line 241
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x2

    .line 283
    iget v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->k:I

    sget v1, Lcom/wishabi/flipp/widget/ds;->c:I

    if-eq v0, v1, :cond_1

    .line 324
    :cond_0
    :goto_0
    return-void

    .line 286
    :cond_1
    new-instance v0, Landroid/animation/AnimatorSet;

    invoke-direct {v0}, Landroid/animation/AnimatorSet;-><init>()V

    .line 288
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->b:Landroid/widget/RelativeLayout;

    const-string v2, "alpha"

    new-array v3, v4, [F

    fill-array-data v3, :array_0

    invoke-static {v1, v2, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v1

    .line 290
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->c:Landroid/widget/TextView;

    const-string v3, "alpha"

    new-array v4, v4, [F

    fill-array-data v4, :array_1

    invoke-static {v2, v3, v4}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v2

    .line 293
    invoke-virtual {v0, v1}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/animation/AnimatorSet$Builder;->before(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 295
    iput-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->i:Landroid/animation/Animator;

    .line 296
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->i:Landroid/animation/Animator;

    new-instance v1, Lcom/wishabi/flipp/widget/dn;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/dn;-><init>(Lcom/wishabi/flipp/widget/ShoppingListPopup;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 318
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->i:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    .line 320
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a:Lcom/wishabi/flipp/widget/dr;

    if-eqz v0, :cond_0

    .line 321
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->d:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 322
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a:Lcom/wishabi/flipp/widget/dr;

    invoke-interface {v1, v0}, Lcom/wishabi/flipp/widget/dr;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 288
    nop

    :array_0
    .array-data 4
        0x3f800000    # 1.0f
        0x0
    .end array-data

    .line 290
    :array_1
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 328
    invoke-super {p0, p1}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 331
    const/4 v0, 0x1

    return v0
.end method

.method public setAnchor$31b0e336(I)V
    .locals 0

    .prologue
    .line 127
    iput p1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->l:I

    .line 128
    return-void
.end method

.method public setDismissDelay(J)V
    .locals 1

    .prologue
    .line 123
    iput-wide p1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->f:J

    .line 124
    return-void
.end method

.method public setShoppingListPopupListener(Lcom/wishabi/flipp/widget/dr;)V
    .locals 0

    .prologue
    .line 119
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a:Lcom/wishabi/flipp/widget/dr;

    .line 120
    return-void
.end method
