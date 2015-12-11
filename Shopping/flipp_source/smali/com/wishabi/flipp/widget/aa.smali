.class public final Lcom/wishabi/flipp/widget/aa;
.super Landroid/support/v7/widget/an;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/an",
        "<",
        "Lcom/wishabi/flipp/widget/ab;",
        ">;"
    }
.end annotation


# instance fields
.field private final c:Landroid/content/Context;

.field private final d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;"
        }
    .end annotation
.end field

.field private final e:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;"
        }
    .end annotation
.end field

.field private final f:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/wishabi/flipp/content/b;",
            ">;"
        }
    .end annotation
.end field

.field private final g:Lcom/wishabi/flipp/widget/ae;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Ljava/util/HashMap;Ljava/util/HashMap;Lcom/wishabi/flipp/widget/ae;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/wishabi/flipp/content/b;",
            ">;",
            "Lcom/wishabi/flipp/widget/ae;",
            ")V"
        }
    .end annotation

    .prologue
    .line 251
    invoke-direct {p0}, Landroid/support/v7/widget/an;-><init>()V

    .line 253
    iput-object p1, p0, Lcom/wishabi/flipp/widget/aa;->c:Landroid/content/Context;

    .line 257
    iput-object p2, p0, Lcom/wishabi/flipp/widget/aa;->d:Ljava/util/List;

    .line 258
    iput-object p3, p0, Lcom/wishabi/flipp/widget/aa;->e:Ljava/util/HashMap;

    .line 259
    iput-object p4, p0, Lcom/wishabi/flipp/widget/aa;->f:Ljava/util/HashMap;

    .line 260
    iput-object p5, p0, Lcom/wishabi/flipp/widget/aa;->g:Lcom/wishabi/flipp/widget/ae;

    .line 261
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 286
    iget-object v0, p0, Lcom/wishabi/flipp/widget/aa;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public final a(I)I
    .locals 1

    .prologue
    .line 300
    const/4 v0, 0x0

    return v0
.end method

.method public final synthetic a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/bi;
    .locals 3

    .prologue
    .line 27
    new-instance v0, Lcom/wishabi/flipp/widget/af;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/aa;->c:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/widget/af;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/af;->a()V

    new-instance v1, Lcom/wishabi/flipp/widget/ab;

    iget-object v2, p0, Lcom/wishabi/flipp/widget/aa;->g:Lcom/wishabi/flipp/widget/ae;

    invoke-direct {v1, v0, v2}, Lcom/wishabi/flipp/widget/ab;-><init>(Lcom/wishabi/flipp/widget/af;Lcom/wishabi/flipp/widget/ae;)V

    return-object v1
.end method

.method public final synthetic a(Landroid/support/v7/widget/bi;I)V
    .locals 17

    .prologue
    .line 27
    check-cast p1, Lcom/wishabi/flipp/widget/ab;

    move-object/from16 v0, p0

    move/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/aa;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v5

    if-eqz v5, :cond_3

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/aa;->e:Ljava/util/HashMap;

    if-eqz v3, :cond_e

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/aa;->e:Ljava/util/HashMap;

    iget v3, v5, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    move-object v4, v2

    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/aa;->f:Ljava/util/HashMap;

    iget v3, v5, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/content/b;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/wishabi/flipp/widget/aa;->c:Landroid/content/Context;

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v6, v5, Lcom/wishabi/flipp/content/c;->m:Ljava/lang/String;

    invoke-virtual {v3, v6}, Lcom/wishabi/flipp/widget/af;->setImage(Ljava/lang/String;)V

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v6, v5, Lcom/wishabi/flipp/content/c;->g:Ljava/lang/String;

    invoke-virtual {v3, v6}, Lcom/wishabi/flipp/widget/af;->setBrandName(Ljava/lang/String;)V

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v6, v5, Lcom/wishabi/flipp/content/c;->h:Ljava/lang/String;

    invoke-virtual {v3, v6}, Lcom/wishabi/flipp/widget/af;->setBrandImage(Ljava/lang/String;)V

    iget-object v3, v5, Lcom/wishabi/flipp/content/c;->b:Ljava/lang/Integer;

    if-eqz v3, :cond_4

    iget-object v3, v5, Lcom/wishabi/flipp/content/c;->b:Ljava/lang/Integer;

    const/16 v6, 0xdeb

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    const/4 v6, 0x0

    invoke-virtual {v3, v6}, Lcom/wishabi/flipp/widget/af;->setMerchant(Ljava/lang/String;)V

    :goto_1
    invoke-virtual {v5}, Lcom/wishabi/flipp/content/c;->a()[Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    const/4 v7, 0x0

    aget-object v7, v3, v7

    const/4 v9, 0x1

    aget-object v9, v3, v9

    const/4 v10, 0x2

    aget-object v3, v3, v10

    invoke-virtual {v6, v7, v9, v3}, Lcom/wishabi/flipp/widget/af;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v3, v5, Lcom/wishabi/flipp/content/c;->i:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    invoke-virtual {v6, v3}, Lcom/wishabi/flipp/widget/af;->setPromoText(Ljava/lang/String;)V

    iget-object v3, v5, Lcom/wishabi/flipp/content/c;->k:Ljava/lang/String;

    iget-object v6, v5, Lcom/wishabi/flipp/content/c;->l:Ljava/lang/String;

    invoke-static {v3}, Lcom/wishabi/flipp/util/q;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6}, Lcom/wishabi/flipp/util/q;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const/4 v3, 0x0

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_0

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_5

    new-instance v3, Lcom/wishabi/flipp/content/FormattedString;

    const/4 v6, 0x1

    new-array v6, v6, [Lcom/wishabi/flipp/content/FormattedString$Part;

    const/4 v9, 0x0

    new-instance v10, Lcom/wishabi/flipp/content/FormattedString$Part;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const v12, 0x7f0e007b

    invoke-virtual {v8, v12}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const/4 v11, 0x1

    new-array v11, v11, [Lcom/wishabi/flipp/content/FormattedString$Format;

    const/4 v12, 0x0

    new-instance v13, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v14, Lcom/wishabi/flipp/content/ab;->b:I

    invoke-direct {v13, v14}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v13, v11, v12

    invoke-direct {v10, v7, v11}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v10, v6, v9

    invoke-direct {v3, v6}, Lcom/wishabi/flipp/content/FormattedString;-><init>([Lcom/wishabi/flipp/content/FormattedString$Part;)V

    invoke-virtual {v3}, Lcom/wishabi/flipp/content/FormattedString;->a()Landroid/text/Spannable;

    move-result-object v3

    :cond_0
    :goto_2
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_6

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    const/4 v6, 0x0

    invoke-virtual {v3, v6}, Lcom/wishabi/flipp/widget/af;->setValidity(Landroid/text/Spannable;)V

    :goto_3
    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-boolean v6, v5, Lcom/wishabi/flipp/content/c;->q:Z

    invoke-virtual {v3, v6}, Lcom/wishabi/flipp/widget/af;->setIsClipped(Z)V

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-boolean v6, v5, Lcom/wishabi/flipp/content/c;->r:Z

    invoke-virtual {v3, v6}, Lcom/wishabi/flipp/widget/af;->setIsSent(Z)V

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v3, v5, Lcom/wishabi/flipp/content/c;->n:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_7

    const/4 v3, 0x1

    :goto_4
    invoke-virtual {v6, v3}, Lcom/wishabi/flipp/widget/af;->setHasBarcode(Z)V

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/wishabi/flipp/widget/ab;->m:Lcom/wishabi/flipp/widget/ak;

    invoke-virtual {v3, v5}, Lcom/wishabi/flipp/widget/af;->setListener(Lcom/wishabi/flipp/widget/ak;)V

    if-eqz v4, :cond_1

    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_8

    :cond_1
    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/af;->a()V

    :cond_2
    if-nez v2, :cond_d

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/wishabi/flipp/widget/af;->setDisclaimer(Ljava/lang/String;)V

    :cond_3
    :goto_5
    return-void

    :cond_4
    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v6, v5, Lcom/wishabi/flipp/content/c;->c:Ljava/lang/String;

    invoke-virtual {v3, v6}, Lcom/wishabi/flipp/widget/af;->setMerchant(Ljava/lang/String;)V

    goto/16 :goto_1

    :cond_5
    new-instance v3, Lcom/wishabi/flipp/content/FormattedString;

    const/4 v9, 0x2

    new-array v9, v9, [Lcom/wishabi/flipp/content/FormattedString$Part;

    const/4 v10, 0x0

    new-instance v11, Lcom/wishabi/flipp/content/FormattedString$Part;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const v13, 0x7f0e007a

    invoke-virtual {v8, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, "\n"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    const/4 v13, 0x1

    new-array v13, v13, [Lcom/wishabi/flipp/content/FormattedString$Format;

    const/4 v14, 0x0

    new-instance v15, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v16, Lcom/wishabi/flipp/content/ab;->b:I

    invoke-direct/range {v15 .. v16}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v15, v13, v14

    invoke-direct {v11, v12, v13}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v11, v9, v10

    const/4 v10, 0x1

    new-instance v11, Lcom/wishabi/flipp/content/FormattedString$Part;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v12, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v12, " "

    invoke-virtual {v7, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const v12, 0x7f0e007c

    invoke-virtual {v8, v12}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v12, " "

    invoke-virtual {v7, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    new-array v7, v7, [Lcom/wishabi/flipp/content/FormattedString$Format;

    const/4 v12, 0x0

    new-instance v13, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v14, Lcom/wishabi/flipp/content/ab;->a:I

    invoke-direct {v13, v14}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v13, v7, v12

    invoke-direct {v11, v6, v7}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v11, v9, v10

    invoke-direct {v3, v9}, Lcom/wishabi/flipp/content/FormattedString;-><init>([Lcom/wishabi/flipp/content/FormattedString$Part;)V

    invoke-virtual {v3}, Lcom/wishabi/flipp/content/FormattedString;->a()Landroid/text/Spannable;

    move-result-object v3

    goto/16 :goto_2

    :cond_6
    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    invoke-virtual {v6, v3}, Lcom/wishabi/flipp/widget/af;->setValidity(Landroid/text/Spannable;)V

    goto/16 :goto_3

    :cond_7
    const/4 v3, 0x0

    goto/16 :goto_4

    :cond_8
    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v3, v3, Lcom/wishabi/flipp/widget/af;->b:Landroid/widget/RelativeLayout;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/af;->b()V

    const/4 v3, 0x0

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v9

    move v7, v3

    :goto_6
    if-ge v7, v9, :cond_2

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v3, v3, Lcom/wishabi/flipp/widget/af;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v7}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    if-nez v3, :cond_a

    new-instance v3, Lcom/wishabi/flipp/widget/ch;

    invoke-direct {v3, v8}, Lcom/wishabi/flipp/widget/ch;-><init>(Landroid/content/Context;)V

    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v6, -0x1

    const/4 v10, -0x2

    invoke-direct {v5, v6, v10}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v5}, Lcom/wishabi/flipp/widget/ch;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v5, v5, Lcom/wishabi/flipp/widget/af;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    move-object v6, v3

    :goto_7
    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/wishabi/flipp/content/o;

    const/16 v5, 0x46

    invoke-static {v5}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v5

    int-to-double v10, v5

    const-wide v12, 0x3fe3333333333333L    # 0.6

    mul-double/2addr v10, v12

    double-to-int v10, v10

    const/16 v11, 0x3c

    invoke-static {v11}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v11

    int-to-float v12, v11

    iget-object v13, v3, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    invoke-virtual {v13}, Landroid/graphics/RectF;->width()F

    move-result v13

    div-float/2addr v12, v13

    iget-object v13, v3, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    invoke-virtual {v13}, Landroid/graphics/RectF;->height()F

    move-result v13

    mul-float/2addr v12, v13

    int-to-float v5, v5

    int-to-float v10, v10

    invoke-static {v12, v5, v10}, Lcom/wishabi/flipp/util/j;->a(FFF)F

    move-result v5

    float-to-int v5, v5

    iget-object v10, v6, Lcom/wishabi/flipp/widget/ch;->a:Lcom/wishabi/flipp/widget/ItemCellSmall;

    invoke-virtual {v10}, Lcom/wishabi/flipp/widget/ItemCellSmall;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    iput v11, v10, Landroid/view/ViewGroup$LayoutParams;->width:I

    iget-object v10, v6, Lcom/wishabi/flipp/widget/ch;->a:Lcom/wishabi/flipp/widget/ItemCellSmall;

    invoke-virtual {v10}, Lcom/wishabi/flipp/widget/ItemCellSmall;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    iput v5, v10, Landroid/view/ViewGroup$LayoutParams;->height:I

    iget-object v5, v3, Lcom/wishabi/flipp/content/o;->h:Ljava/lang/String;

    invoke-virtual {v6, v5}, Lcom/wishabi/flipp/widget/ch;->setItemMatchupImage(Ljava/lang/String;)V

    iget-object v5, v3, Lcom/wishabi/flipp/content/o;->m:Ljava/lang/Integer;

    if-eqz v5, :cond_b

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-static {v5}, Lcom/wishabi/flipp/content/ag;->b(I)Z

    move-result v5

    if-eqz v5, :cond_b

    const v3, 0x7f0e0085

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-static {}, Lcom/wishabi/flipp/util/q;->a()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v5, v10

    invoke-virtual {v8, v3, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v6, v3}, Lcom/wishabi/flipp/widget/ch;->setItemMatchupLabel(Ljava/lang/String;)V

    const/4 v3, 0x0

    invoke-virtual {v6, v3}, Lcom/wishabi/flipp/widget/ch;->setItemMatchupMerchant(Ljava/lang/String;)V

    :goto_8
    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->n:Landroid/view/View$OnClickListener;

    invoke-virtual {v6, v3}, Lcom/wishabi/flipp/widget/ch;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v3, v3, Lcom/wishabi/flipp/widget/af;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v7}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    if-eqz v3, :cond_9

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Landroid/view/View;->setVisibility(I)V

    :cond_9
    add-int/lit8 v3, v7, 0x1

    move v7, v3

    goto/16 :goto_6

    :cond_a
    check-cast v3, Lcom/wishabi/flipp/widget/ch;

    move-object v6, v3

    goto/16 :goto_7

    :cond_b
    iget-object v5, v3, Lcom/wishabi/flipp/content/o;->j:Ljava/lang/Float;

    if-eqz v5, :cond_c

    iget-boolean v5, v3, Lcom/wishabi/flipp/content/o;->l:Z

    if-eqz v5, :cond_c

    const v5, 0x7f0e0074

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    iget-object v12, v3, Lcom/wishabi/flipp/content/o;->j:Ljava/lang/Float;

    invoke-virtual {v12}, Ljava/lang/Float;->floatValue()F

    move-result v12

    invoke-static {v12}, Lcom/wishabi/flipp/util/q;->a(F)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v8, v5, v10}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    :goto_9
    invoke-virtual {v6, v5}, Lcom/wishabi/flipp/widget/ch;->setItemMatchupLabel(Ljava/lang/String;)V

    iget-object v3, v3, Lcom/wishabi/flipp/content/o;->n:Ljava/lang/String;

    invoke-virtual {v6, v3}, Lcom/wishabi/flipp/widget/ch;->setItemMatchupMerchant(Ljava/lang/String;)V

    goto :goto_8

    :cond_c
    const v5, 0x7f0e0073

    invoke-virtual {v8, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    goto :goto_9

    :cond_d
    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v2, v2, Lcom/wishabi/flipp/content/b;->b:Ljava/lang/String;

    invoke-virtual {v3, v2}, Lcom/wishabi/flipp/widget/af;->setDisclaimer(Ljava/lang/String;)V

    goto/16 :goto_5

    :cond_e
    move-object v4, v2

    goto/16 :goto_0
.end method

.method public final b(I)J
    .locals 2

    .prologue
    .line 291
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/aa;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v0

    .line 292
    if-nez v0, :cond_0

    .line 293
    const-wide/16 v0, -0x1

    .line 295
    :goto_0
    return-wide v0

    :cond_0
    iget v0, v0, Lcom/wishabi/flipp/content/c;->a:I

    int-to-long v0, v0

    goto :goto_0
.end method

.method public final d(I)Lcom/wishabi/flipp/content/c;
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lcom/wishabi/flipp/widget/aa;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lt p1, v0, :cond_0

    .line 305
    const/4 v0, 0x0

    .line 307
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/aa;->d:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    goto :goto_0
.end method
