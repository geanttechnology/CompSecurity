.class public Lcom/wishabi/flipp/widget/aw;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/wishabi/flipp/widget/aw;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/widget/aw;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/wishabi/flipp/widget/a;Lb/a/a/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/wishabi/flipp/widget/a;",
            "Lb/a/a/b;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "II",
            "Lcom/wishabi/flipp/widget/f",
            "<",
            "Ljava/util/ArrayList;",
            ">;",
            "Lcom/wishabi/flipp/content/c;",
            ")V"
        }
    .end annotation

    .prologue
    .line 195
    sget-object v2, Lcom/wishabi/flipp/util/g;->a:Lb/a/a/i;

    invoke-static {v2}, Lb/a/a/b;->a(Lb/a/a/i;)Lb/a/a/b;

    move-result-object v2

    .line 196
    if-eqz p2, :cond_3

    invoke-static {p2}, Lb/a/a/f;->a(Lb/a/a/z;)J

    move-result-wide v4

    invoke-virtual {v2}, Lb/a/a/a/b;->a()J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-lez v2, :cond_2

    const/4 v2, 0x1

    :goto_0
    if-eqz v2, :cond_3

    const/4 v2, 0x1

    :goto_1
    invoke-virtual {p1, v2}, Lcom/wishabi/flipp/widget/a;->setExpired(Z)V

    .line 197
    move/from16 v0, p8

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/a;->setSelectionState$448952c2(I)V

    .line 198
    invoke-virtual {p1, p3}, Lcom/wishabi/flipp/widget/a;->setImageUrl(Ljava/lang/String;)V

    .line 199
    invoke-virtual {p1, p4}, Lcom/wishabi/flipp/widget/a;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 200
    if-nez p10, :cond_4

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->a:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->a:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setClickable(Z)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->a:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->a:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setLongClickable(Z)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setClickable(Z)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setLongClickable(Z)V

    :goto_2
    move-object/from16 v0, p10

    iput-object v0, p1, Lcom/wishabi/flipp/widget/a;->h:Lcom/wishabi/flipp/app/dn;

    .line 201
    invoke-static {p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "/images/bg/logo_bg.gif"

    invoke-virtual {p5, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 203
    :cond_0
    invoke-virtual {p1, p6}, Lcom/wishabi/flipp/widget/a;->setMerchantFallback(Ljava/lang/String;)V

    .line 207
    :goto_3
    if-eqz p9, :cond_1

    invoke-static/range {p9 .. p9}, Lcom/wishabi/flipp/widget/aw;->a(Ljava/util/ArrayList;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 209
    :cond_1
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Lcom/wishabi/flipp/widget/a;->setShowCouponMatchup(Z)V

    .line 213
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/a;->refreshDrawableState()V

    .line 250
    :goto_4
    return-void

    .line 196
    :cond_2
    const/4 v2, 0x0

    goto :goto_0

    :cond_3
    const/4 v2, 0x0

    goto :goto_1

    .line 200
    :cond_4
    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->a:Landroid/view/View;

    new-instance v3, Lcom/wishabi/flipp/widget/b;

    move/from16 v0, p7

    invoke-direct {v3, p1, v0}, Lcom/wishabi/flipp/widget/b;-><init>(Lcom/wishabi/flipp/widget/a;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->a:Landroid/view/View;

    new-instance v3, Lcom/wishabi/flipp/widget/c;

    move/from16 v0, p7

    invoke-direct {v3, p1, v0}, Lcom/wishabi/flipp/widget/c;-><init>(Lcom/wishabi/flipp/widget/a;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    new-instance v3, Lcom/wishabi/flipp/widget/d;

    move/from16 v0, p7

    invoke-direct {v3, p1, v0}, Lcom/wishabi/flipp/widget/d;-><init>(Lcom/wishabi/flipp/widget/a;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->b:Landroid/view/View;

    new-instance v3, Lcom/wishabi/flipp/widget/e;

    move/from16 v0, p7

    invoke-direct {v3, p1, v0}, Lcom/wishabi/flipp/widget/e;-><init>(Lcom/wishabi/flipp/widget/a;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    goto :goto_2

    .line 205
    :cond_5
    invoke-virtual {p1, p5}, Lcom/wishabi/flipp/widget/a;->setMerchantLogoUrl(Ljava/lang/String;)V

    goto :goto_3

    .line 218
    :cond_6
    const/4 v2, 0x1

    invoke-virtual {p1, v2}, Lcom/wishabi/flipp/widget/a;->setShowCouponMatchup(Z)V

    .line 219
    const/16 v2, 0x37

    invoke-static {v2}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v2

    invoke-virtual {p1, v2}, Lcom/wishabi/flipp/widget/a;->setCouponMatchupHeight(I)V

    .line 223
    invoke-virtual/range {p9 .. p9}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v3, 0x1

    if-le v2, v3, :cond_7

    .line 224
    const v2, 0x7f0e0033

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual/range {p9 .. p9}, Ljava/util/ArrayList;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Lcom/wishabi/flipp/widget/a;->setCouponMatchupAvailable(Ljava/lang/String;)V

    .line 229
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/a;->refreshDrawableState()V

    goto :goto_4

    .line 235
    :cond_7
    const/4 v2, 0x0

    move-object/from16 v0, p9

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/content/c;

    .line 236
    invoke-virtual {v2}, Lcom/wishabi/flipp/content/c;->a()[Ljava/lang/String;

    move-result-object v2

    .line 239
    const/4 v3, 0x0

    aget-object v3, v2, v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_9

    const/4 v3, 0x1

    aget-object v3, v2, v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_9

    const/4 v3, 0x2

    aget-object v3, v2, v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 242
    const v2, 0x7f0e0033

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Lcom/wishabi/flipp/widget/a;->setCouponMatchupAvailable(Ljava/lang/String;)V

    .line 249
    :cond_8
    :goto_5
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/a;->refreshDrawableState()V

    goto/16 :goto_4

    .line 245
    :cond_9
    const/4 v3, 0x0

    aget-object v5, v2, v3

    const/4 v3, 0x1

    aget-object v6, v2, v3

    const/4 v3, 0x2

    aget-object v7, v2, v3

    const/4 v4, 0x0

    const/4 v3, 0x0

    const/4 v2, 0x0

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_a

    iget-object v5, p1, Lcom/wishabi/flipp/widget/a;->d:Landroid/widget/TextView;

    const/4 v8, 0x0

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v5, p1, Lcom/wishabi/flipp/widget/a;->d:Landroid/widget/TextView;

    const/16 v8, 0x8

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setVisibility(I)V

    :goto_6
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_b

    iget-object v5, p1, Lcom/wishabi/flipp/widget/a;->e:Landroid/widget/TextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v5, p1, Lcom/wishabi/flipp/widget/a;->e:Landroid/widget/TextView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    :goto_7
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_c

    iget-object v5, p1, Lcom/wishabi/flipp/widget/a;->f:Landroid/widget/TextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v5, p1, Lcom/wishabi/flipp/widget/a;->f:Landroid/widget/TextView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    :goto_8
    if-eqz v2, :cond_d

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->c:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v2, v5}, Landroid/view/View;->setVisibility(I)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->g:Landroid/widget/TextView;

    const/16 v5, 0x8

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    const/4 v2, 0x1

    if-ne v3, v2, :cond_8

    const/4 v2, 0x0

    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setSingleLine(Z)V

    const/4 v2, 0x2

    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setMaxLines(I)V

    goto :goto_5

    :cond_a
    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->d:Landroid/widget/TextView;

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->d:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->d:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->setSingleLine()V

    iget-object v4, p1, Lcom/wishabi/flipp/widget/a;->d:Landroid/widget/TextView;

    const/4 v3, 0x1

    const/4 v2, 0x1

    goto :goto_6

    :cond_b
    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->e:Landroid/widget/TextView;

    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->e:Landroid/widget/TextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->e:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->setSingleLine()V

    iget-object v4, p1, Lcom/wishabi/flipp/widget/a;->e:Landroid/widget/TextView;

    add-int/lit8 v3, v3, 0x1

    const/4 v2, 0x1

    goto :goto_7

    :cond_c
    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->f:Landroid/widget/TextView;

    invoke-virtual {v2, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->f:Landroid/widget/TextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->f:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->setSingleLine()V

    iget-object v4, p1, Lcom/wishabi/flipp/widget/a;->f:Landroid/widget/TextView;

    add-int/lit8 v3, v3, 0x1

    const/4 v2, 0x1

    goto :goto_8

    :cond_d
    iget-object v2, p1, Lcom/wishabi/flipp/widget/a;->c:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_5
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/CouponCell;ILandroid/database/Cursor;ZZIILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Lcom/wishabi/flipp/widget/CouponCell;",
            "I",
            "Landroid/database/Cursor;",
            "ZZII",
            "Lcom/wishabi/flipp/widget/z",
            "<",
            "Ljava/util/ArrayList;",
            ">;",
            "Lcom/wishabi/flipp/content/o;",
            ")V"
        }
    .end annotation

    .prologue
    .line 103
    new-instance v5, Lcom/wishabi/flipp/content/c;

    move-object/from16 v0, p4

    invoke-direct {v5, v0}, Lcom/wishabi/flipp/content/c;-><init>(Landroid/database/Cursor;)V

    .line 104
    const/4 v9, 0x1

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move/from16 v4, p3

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v10, p8

    move-object/from16 v11, p9

    move-object/from16 v12, p10

    invoke-static/range {v1 .. v12}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/CouponCell;ILcom/wishabi/flipp/content/c;ZZIZILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    .line 106
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/CouponCell;ILcom/wishabi/flipp/content/c;ZZIZILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Lcom/wishabi/flipp/widget/CouponCell;",
            "I",
            "Lcom/wishabi/flipp/content/c;",
            "ZZIZI",
            "Lcom/wishabi/flipp/widget/z",
            "<",
            "Ljava/util/ArrayList;",
            ">;",
            "Lcom/wishabi/flipp/content/o;",
            ")V"
        }
    .end annotation

    .prologue
    .line 122
    if-eqz p5, :cond_1

    iget-boolean v2, p4, Lcom/wishabi/flipp/content/c;->q:Z

    if-eqz v2, :cond_1

    const/4 v2, 0x1

    :goto_0
    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setIsClipped(Z)V

    .line 123
    if-eqz p6, :cond_2

    invoke-virtual {p4, p1}, Lcom/wishabi/flipp/content/c;->a(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    const/4 v2, 0x1

    :goto_1
    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setIsUnavailable(Z)V

    .line 124
    if-eqz p6, :cond_4

    iget-boolean v2, p4, Lcom/wishabi/flipp/content/c;->p:Z

    if-eqz v2, :cond_3

    invoke-virtual {p4, p1}, Lcom/wishabi/flipp/content/c;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    const/4 v2, 0x1

    :goto_2
    if-eqz v2, :cond_4

    const/4 v2, 0x1

    :goto_3
    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setIsExpired(Z)V

    .line 125
    if-eqz p6, :cond_5

    iget-boolean v2, p4, Lcom/wishabi/flipp/content/c;->r:Z

    if-eqz v2, :cond_5

    const/4 v2, 0x1

    :goto_4
    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setIsSent(Z)V

    .line 126
    invoke-virtual {p2, p7}, Lcom/wishabi/flipp/widget/CouponCell;->setSelectionState$5470411a(I)V

    .line 127
    iget-object v2, p4, Lcom/wishabi/flipp/content/c;->m:Ljava/lang/String;

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setCouponImage(Ljava/lang/String;)V

    .line 128
    if-nez p11, :cond_6

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setClickable(Z)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setLongClickable(Z)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setClickable(Z)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setLongClickable(Z)V

    :goto_5
    move-object/from16 v0, p11

    iput-object v0, p2, Lcom/wishabi/flipp/widget/CouponCell;->e:Lcom/wishabi/flipp/app/dn;

    .line 129
    invoke-virtual {p4}, Lcom/wishabi/flipp/content/c;->a()[Ljava/lang/String;

    move-result-object v2

    .line 130
    const/4 v3, 0x0

    aget-object v3, v2, v3

    const/4 v4, 0x1

    aget-object v4, v2, v4

    const/4 v5, 0x2

    aget-object v2, v2, v5

    invoke-virtual {p2, v3, v4, v2}, Lcom/wishabi/flipp/widget/CouponCell;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    iget-object v2, p4, Lcom/wishabi/flipp/content/c;->i:Ljava/lang/String;

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setCouponPromoText(Ljava/lang/String;)V

    .line 132
    iget-object v2, p4, Lcom/wishabi/flipp/content/c;->d:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 133
    iget-object v2, p4, Lcom/wishabi/flipp/content/c;->c:Ljava/lang/String;

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setMerchantFallback(Ljava/lang/String;)V

    .line 137
    :goto_6
    if-eqz p10, :cond_0

    invoke-virtual/range {p10 .. p10}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 139
    :cond_0
    const/4 v2, 0x0

    move/from16 v0, p8

    invoke-virtual {p2, v2, v0}, Lcom/wishabi/flipp/widget/CouponCell;->a(ZZ)V

    .line 140
    move/from16 v0, p9

    invoke-virtual {p2, v0}, Lcom/wishabi/flipp/widget/CouponCell;->setContainerHeight(I)V

    .line 144
    invoke-virtual {p2}, Lcom/wishabi/flipp/widget/CouponCell;->refreshDrawableState()V

    .line 180
    :goto_7
    return-void

    .line 122
    :cond_1
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 123
    :cond_2
    const/4 v2, 0x0

    goto/16 :goto_1

    .line 124
    :cond_3
    const/4 v2, 0x0

    goto/16 :goto_2

    :cond_4
    const/4 v2, 0x0

    goto/16 :goto_3

    .line 125
    :cond_5
    const/4 v2, 0x0

    goto/16 :goto_4

    .line 128
    :cond_6
    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    new-instance v3, Lcom/wishabi/flipp/widget/v;

    invoke-direct {v3, p2, p3}, Lcom/wishabi/flipp/widget/v;-><init>(Lcom/wishabi/flipp/widget/CouponCell;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->c:Landroid/view/View;

    new-instance v3, Lcom/wishabi/flipp/widget/w;

    invoke-direct {v3, p2, p3}, Lcom/wishabi/flipp/widget/w;-><init>(Lcom/wishabi/flipp/widget/CouponCell;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->b:Landroid/view/View;

    new-instance v3, Lcom/wishabi/flipp/widget/x;

    invoke-direct {v3, p2, p3}, Lcom/wishabi/flipp/widget/x;-><init>(Lcom/wishabi/flipp/widget/CouponCell;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/CouponCell;->b:Landroid/view/View;

    new-instance v3, Lcom/wishabi/flipp/widget/y;

    invoke-direct {v3, p2, p3}, Lcom/wishabi/flipp/widget/y;-><init>(Lcom/wishabi/flipp/widget/CouponCell;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    goto :goto_5

    .line 135
    :cond_7
    iget-object v2, p4, Lcom/wishabi/flipp/content/c;->d:Ljava/lang/String;

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setMerchantLogoUrl(Ljava/lang/String;)V

    goto :goto_6

    .line 149
    :cond_8
    const/4 v2, 0x0

    move-object/from16 v0, p10

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/content/o;

    .line 153
    const/16 v3, 0x3c

    invoke-static {v3}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v3

    .line 155
    int-to-double v4, v3

    const-wide v6, 0x3fe3333333333333L    # 0.6

    mul-double/2addr v4, v6

    double-to-int v4, v4

    .line 156
    const/16 v5, 0x32

    invoke-static {v5}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v5

    .line 157
    int-to-float v6, v5

    iget-object v7, v2, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    invoke-virtual {v7}, Landroid/graphics/RectF;->width()F

    move-result v7

    div-float/2addr v6, v7

    iget-object v7, v2, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    invoke-virtual {v7}, Landroid/graphics/RectF;->height()F

    move-result v7

    mul-float/2addr v6, v7

    int-to-float v3, v3

    int-to-float v4, v4

    invoke-static {v6, v3, v4}, Lcom/wishabi/flipp/util/j;->a(FFF)F

    move-result v3

    float-to-int v3, v3

    .line 160
    iget-object v4, p2, Lcom/wishabi/flipp/widget/CouponCell;->d:Lcom/wishabi/flipp/widget/ItemCellSmall;

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/ItemCellSmall;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    iput v5, v4, Landroid/view/ViewGroup$LayoutParams;->width:I

    iget-object v4, p2, Lcom/wishabi/flipp/widget/CouponCell;->d:Lcom/wishabi/flipp/widget/ItemCellSmall;

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/ItemCellSmall;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    iput v3, v4, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 161
    const/16 v3, 0x104

    invoke-static {v3}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v3

    invoke-virtual {p2, v3}, Lcom/wishabi/flipp/widget/CouponCell;->setContainerHeight(I)V

    .line 164
    const/4 v3, 0x1

    move/from16 v0, p8

    invoke-virtual {p2, v3, v0}, Lcom/wishabi/flipp/widget/CouponCell;->a(ZZ)V

    .line 165
    const/16 v3, 0x32

    invoke-static {v3}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v3

    invoke-virtual {p2, v3}, Lcom/wishabi/flipp/widget/CouponCell;->setItemMatchupHeight(I)V

    .line 167
    iget-object v3, v2, Lcom/wishabi/flipp/content/o;->h:Ljava/lang/String;

    invoke-virtual {p2, v3}, Lcom/wishabi/flipp/widget/CouponCell;->setItemMatchupImage(Ljava/lang/String;)V

    .line 168
    iget-object v3, v2, Lcom/wishabi/flipp/content/o;->n:Ljava/lang/String;

    invoke-virtual {p2, v3}, Lcom/wishabi/flipp/widget/CouponCell;->setItemMatchupMerchant(Ljava/lang/String;)V

    .line 170
    iget-object v3, v2, Lcom/wishabi/flipp/content/o;->j:Ljava/lang/Float;

    if-eqz v3, :cond_9

    iget-boolean v3, v2, Lcom/wishabi/flipp/content/o;->l:Z

    if-eqz v3, :cond_9

    const v3, 0x7f0e0074

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v2, v2, Lcom/wishabi/flipp/content/o;->j:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-static {v2}, Lcom/wishabi/flipp/util/q;->a(F)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v4, v5

    invoke-virtual {p0, v3, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 175
    :goto_8
    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/CouponCell;->setItemMatchupLabel(Ljava/lang/String;)V

    .line 179
    invoke-virtual {p2}, Lcom/wishabi/flipp/widget/CouponCell;->refreshDrawableState()V

    goto/16 :goto_7

    .line 170
    :cond_9
    const v2, 0x7f0e0073

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_8
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/cd;ILcom/wishabi/flipp/content/c;ILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Lcom/wishabi/flipp/widget/cd;",
            "I",
            "Lcom/wishabi/flipp/content/c;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;",
            "Lcom/wishabi/flipp/app/dn;",
            ")V"
        }
    .end annotation

    .prologue
    .line 39
    invoke-virtual {p2}, Lcom/wishabi/flipp/widget/cd;->getCouponCell()Lcom/wishabi/flipp/widget/CouponCell;

    move-result-object v3

    const/4 v6, 0x1

    const/4 v7, 0x1

    sget v8, Lcom/wishabi/flipp/widget/z;->a:I

    const/4 v9, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    move-object v1, p0

    move-object v2, p1

    move/from16 v4, p3

    move-object/from16 v5, p4

    move/from16 v10, p5

    invoke-static/range {v1 .. v12}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/CouponCell;ILcom/wishabi/flipp/content/c;ZZIZILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    .line 44
    if-eqz p6, :cond_0

    invoke-virtual/range {p6 .. p6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 88
    :cond_0
    :goto_0
    return-void

    .line 49
    :cond_1
    const/4 v1, 0x0

    move-object/from16 v0, p6

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/content/o;

    .line 50
    invoke-virtual {v1}, Lcom/wishabi/flipp/content/o;->b()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 55
    if-nez p7, :cond_3

    iget-object v2, p2, Lcom/wishabi/flipp/widget/cd;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/cd;->b:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setClickable(Z)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/cd;->a:Lcom/wishabi/flipp/widget/CouponCell;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/wishabi/flipp/widget/CouponCell;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/cd;->a:Lcom/wishabi/flipp/widget/CouponCell;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/wishabi/flipp/widget/CouponCell;->setClickable(Z)V

    :goto_1
    move-object/from16 v0, p7

    iput-object v0, p2, Lcom/wishabi/flipp/widget/cd;->d:Lcom/wishabi/flipp/app/dn;

    .line 58
    const/16 v2, 0x32

    invoke-static {v2}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v2

    .line 59
    const/16 v3, 0x3c

    invoke-static {v3}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v3

    .line 61
    iget-object v4, p2, Lcom/wishabi/flipp/widget/cd;->c:Lcom/wishabi/flipp/widget/ItemCellSmall;

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/ItemCellSmall;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    iput v2, v4, Landroid/view/ViewGroup$LayoutParams;->width:I

    iget-object v2, p2, Lcom/wishabi/flipp/widget/cd;->c:Lcom/wishabi/flipp/widget/ItemCellSmall;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/ItemCellSmall;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 62
    iget-object v2, v1, Lcom/wishabi/flipp/content/o;->h:Ljava/lang/String;

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/cd;->setItemMatchupImage(Ljava/lang/String;)V

    .line 65
    const v2, 0x7f0e0073

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/cd;->setItemMatchupLabel(Ljava/lang/String;)V

    .line 67
    iget-object v2, v1, Lcom/wishabi/flipp/content/o;->n:Ljava/lang/String;

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/cd;->setItemMatchupMerchant(Ljava/lang/String;)V

    .line 70
    iget v2, v1, Lcom/wishabi/flipp/content/o;->p:I

    sget v3, Lcom/wishabi/flipp/content/n;->a:I

    if-ne v2, v3, :cond_4

    .line 71
    iget-object v2, v1, Lcom/wishabi/flipp/content/o;->f:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-static {v2}, Lcom/wishabi/flipp/util/q;->a(F)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/cd;->setItemOriginalPrice(Ljava/lang/String;)V

    .line 73
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "-"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, v1, Lcom/wishabi/flipp/content/o;->g:Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    invoke-static {v3}, Lcom/wishabi/flipp/util/q;->a(F)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/cd;->setItemDiscountPrice(Ljava/lang/String;)V

    .line 80
    :cond_2
    :goto_2
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "-"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, v1, Lcom/wishabi/flipp/content/o;->i:Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    invoke-static {v3}, Lcom/wishabi/flipp/util/q;->a(F)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/cd;->setItemCouponPrice(Ljava/lang/String;)V

    .line 82
    iget-object v2, v1, Lcom/wishabi/flipp/content/o;->j:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-static {v2}, Lcom/wishabi/flipp/util/q;->a(F)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/cd;->setItemFinalPrice(Ljava/lang/String;)V

    .line 86
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lcom/wishabi/flipp/content/o;->k:Ljava/lang/Float;

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v1

    const/high16 v3, 0x42c80000    # 100.0f

    mul-float/2addr v1, v3

    float-to-int v1, v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "% "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f0e011b

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Lcom/wishabi/flipp/widget/cd;->setBadgeText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 55
    :cond_3
    iget-object v2, p2, Lcom/wishabi/flipp/widget/cd;->b:Landroid/view/View;

    new-instance v3, Lcom/wishabi/flipp/widget/ce;

    move/from16 v0, p3

    invoke-direct {v3, p2, v0}, Lcom/wishabi/flipp/widget/ce;-><init>(Lcom/wishabi/flipp/widget/cd;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p2, Lcom/wishabi/flipp/widget/cd;->a:Lcom/wishabi/flipp/widget/CouponCell;

    new-instance v3, Lcom/wishabi/flipp/widget/cf;

    move/from16 v0, p3

    invoke-direct {v3, p2, v0}, Lcom/wishabi/flipp/widget/cf;-><init>(Lcom/wishabi/flipp/widget/cd;I)V

    invoke-virtual {v2, v3}, Lcom/wishabi/flipp/widget/CouponCell;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_1

    .line 75
    :cond_4
    iget v2, v1, Lcom/wishabi/flipp/content/o;->p:I

    sget v3, Lcom/wishabi/flipp/content/n;->b:I

    if-ne v2, v3, :cond_2

    .line 76
    iget-object v2, v1, Lcom/wishabi/flipp/content/o;->e:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-static {v2}, Lcom/wishabi/flipp/util/q;->a(F)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/cd;->setItemCurrentPrice(Ljava/lang/String;)V

    .line 78
    const/4 v2, 0x0

    invoke-virtual {p2, v2}, Lcom/wishabi/flipp/widget/cd;->setItemDiscountPrice(Ljava/lang/String;)V

    goto/16 :goto_2
.end method

.method public static a(Ljava/util/ArrayList;)Z
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;)Z"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 253
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v1

    .line 266
    :goto_0
    return v0

    .line 256
    :cond_1
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v2, :cond_3

    .line 257
    invoke-virtual {p0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    .line 258
    if-nez v0, :cond_2

    move v0, v1

    .line 259
    goto :goto_0

    .line 261
    :cond_2
    invoke-virtual {v0}, Lcom/wishabi/flipp/content/c;->a()[Ljava/lang/String;

    move-result-object v0

    .line 262
    if-nez v0, :cond_3

    move v0, v1

    .line 263
    goto :goto_0

    :cond_3
    move v0, v2

    .line 266
    goto :goto_0
.end method
