.class public Lmo;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:I

.field private b:Ljb;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput v0, p0, Lmo;->a:I

    .line 38
    const/4 v0, 0x0

    iput-object v0, p0, Lmo;->b:Ljb;

    .line 308
    return-void
.end method

.method static synthetic a(Lmo;I)I
    .locals 0

    .prologue
    .line 29
    iput p1, p0, Lmo;->a:I

    return p1
.end method

.method public static a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;IZLandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)Landroid/view/View;
    .locals 12

    .prologue
    .line 42
    new-instance v4, Lmp;

    invoke-direct {v4}, Lmp;-><init>()V

    .line 43
    new-instance v5, Lmo;

    invoke-direct {v5}, Lmo;-><init>()V

    .line 44
    const/4 v11, 0x0

    .line 45
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 46
    packed-switch p4, :pswitch_data_0

    move-object v5, v11

    .line 82
    :goto_0
    return-object v5

    .line 48
    :pswitch_0
    const v1, 0x7f0300d2

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move/from16 v6, p5

    .line 49
    invoke-static/range {v0 .. v6}, Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;Z)V

    goto :goto_0

    .line 53
    :pswitch_1
    const v1, 0x7f0300cd

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    move/from16 v8, p5

    .line 54
    invoke-static/range {v0 .. v8}, Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;Landroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    goto :goto_0

    .line 58
    :pswitch_2
    const v1, 0x7f0300cf

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    goto :goto_0

    .line 63
    :pswitch_3
    const v1, 0x7f0300d0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    move-object v6, p0

    move-object v7, p1

    move-object v8, p2

    move-object v9, p3

    move-object v10, v4

    .line 64
    invoke-direct/range {v5 .. v11}, Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;)V

    move-object v5, v11

    .line 65
    goto :goto_0

    .line 68
    :pswitch_4
    const v1, 0x7f0300d1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 69
    invoke-static {p0, p2, v4, v5}, Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lmp;Landroid/view/View;)V

    goto :goto_0

    .line 73
    :pswitch_5
    const v1, 0x7f0300ce

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    goto :goto_0

    .line 46
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method static synthetic a(Lmo;)Ljb;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lmo;->b:Ljb;

    return-object v0
.end method

.method static synthetic a(Lmo;Ljb;)Ljb;
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lmo;->b:Ljb;

    return-object p1
.end method

.method private static a(Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lmp;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 87
    const v0, 0x7f0c034a

    invoke-virtual {p3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p2, Lmp;->c:Landroid/widget/ImageView;

    .line 88
    const v0, 0x7f0c0348

    invoke-virtual {p3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p2, Lmp;->d:Landroid/widget/ImageView;

    .line 89
    const v0, 0x7f0c0349

    invoke-virtual {p3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p2, Lmp;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 90
    iget-object v0, p2, Lmp;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "1"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 91
    return-void
.end method

.method private a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;)V
    .locals 8

    .prologue
    const/4 v2, 0x1

    .line 183
    const v0, 0x7f0c0064

    invoke-virtual {p6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-static {p5, v0}, Lmp;->a(Lmp;Landroid/view/View;)Landroid/view/View;

    .line 184
    const v0, 0x7f0c0344

    invoke-virtual {p6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-static {p5, v0}, Lmp;->b(Lmp;Landroid/widget/LinearLayout;)Landroid/widget/LinearLayout;

    .line 185
    const v0, 0x7f0c034a

    invoke-virtual {p6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p5, Lmp;->c:Landroid/widget/ImageView;

    .line 186
    const v0, 0x7f0c0348

    invoke-virtual {p6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p5, Lmp;->d:Landroid/widget/ImageView;

    .line 187
    const v0, 0x7f0c0349

    invoke-virtual {p6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p5, Lmp;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 188
    iget-object v0, p5, Lmp;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p4}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getRequiredQuantity()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 189
    invoke-virtual {p4}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getRequiredQuantity()I

    move-result v0

    iput v0, p0, Lmo;->a:I

    .line 190
    iget v0, p0, Lmo;->a:I

    if-le v0, v2, :cond_0

    .line 191
    iget-object v0, p5, Lmp;->d:Landroid/widget/ImageView;

    const v1, 0x7f020115

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 192
    :cond_0
    iget v0, p0, Lmo;->a:I

    const/16 v1, 0xa

    if-ne v0, v1, :cond_2

    .line 193
    iget-object v0, p5, Lmp;->c:Landroid/widget/ImageView;

    const v1, 0x7f020007

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 197
    :cond_1
    :goto_0
    invoke-static {p5}, Lmp;->f(Lmp;)Landroid/widget/LinearLayout;

    move-result-object v6

    new-instance v0, Lmo$4;

    move-object v1, p0

    move-object v2, p6

    move-object v3, p1

    move-object v4, p2

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lmo$4;-><init>(Lmo;Landroid/view/View;Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/Entities;)V

    invoke-virtual {v6, v0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 214
    iget-object v7, p5, Lmp;->d:Landroid/widget/ImageView;

    new-instance v0, Lmo$5;

    move-object v1, p0

    move-object v2, p5

    move-object v3, p6

    move-object v4, p1

    move-object v5, p2

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lmo$5;-><init>(Lmo;Lmp;Landroid/view/View;Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/Entities;)V

    invoke-virtual {v7, v0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    iget-object v7, p5, Lmp;->c:Landroid/widget/ImageView;

    new-instance v0, Lmo$6;

    move-object v1, p0

    move-object v2, p6

    move-object v3, p1

    move-object v4, p2

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lmo$6;-><init>(Lmo;Landroid/view/View;Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;)V

    invoke-virtual {v7, v0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 250
    return-void

    .line 194
    :cond_2
    iget v0, p0, Lmo;->a:I

    if-ne v0, v2, :cond_1

    .line 195
    iget-object v0, p5, Lmp;->d:Landroid/widget/ImageView;

    const v1, 0x7f020116

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method

.method private static a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;Landroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V
    .locals 7

    .prologue
    .line 255
    const v0, 0x7f0c033b

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    .line 256
    const v0, 0x7f0c033c

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 257
    const v0, 0x7f0c033f

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {p4, v0}, Lmp;->a(Lmp;Lcom/bestbuy/android/bbyobjects/BBYTextView;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 258
    const v0, 0x7f0c0340

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {p4, v0}, Lmp;->b(Lmp;Lcom/bestbuy/android/bbyobjects/BBYTextView;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 259
    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 260
    const v0, 0x7f0c0341

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    invoke-static {p4, v0}, Lmp;->b(Lmp;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;

    .line 261
    invoke-static {p4}, Lmp;->c(Lmp;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 262
    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->isCommerceUnavailable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 263
    invoke-static {p4}, Lmp;->c(Lmp;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const v1, 0x7f020009

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 265
    :cond_0
    invoke-static {p4}, Lmp;->c(Lmp;)Landroid/widget/RelativeLayout;

    move-result-object v6

    new-instance v0, Lmo$7;

    move-object v1, p2

    move-object v2, p1

    move-object v3, p0

    move-object v4, p7

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lmo$7;-><init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/Entities;)V

    invoke-virtual {v6, v0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 287
    :goto_0
    invoke-static {p4}, Lmp;->a(Lmp;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Want: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getRequiredQuantity()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 288
    invoke-static {p4}, Lmp;->b(Lmp;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Have: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getPurchaseQuantity()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 290
    invoke-virtual {p3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->isFavorite()Z

    move-result v0

    if-eqz v0, :cond_2

    if-nez p8, :cond_2

    .line 291
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 292
    iget-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 293
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    const v1, 0x7f0200c9

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 294
    iget-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Our Favorite"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 306
    :goto_1
    return-void

    .line 282
    :cond_1
    const v0, 0x7f0c0341

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    invoke-static {p4, v0}, Lmp;->b(Lmp;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;

    .line 283
    invoke-static {p4}, Lmp;->c(Lmp;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0

    .line 295
    :cond_2
    invoke-virtual {p3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->isFavorite()Z

    move-result v0

    if-eqz v0, :cond_3

    if-eqz p8, :cond_3

    .line 296
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 297
    iget-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 298
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    const v1, 0x7f0200c9

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 299
    iget-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "My Favorite"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1

    .line 303
    :cond_3
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 304
    iget-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_1
.end method

.method private static a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;Z)V
    .locals 9

    .prologue
    const v3, 0x7f0200c9

    const/4 v8, 0x0

    .line 95
    const v0, 0x7f0c0064

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-static {p4, v0}, Lmp;->a(Lmp;Landroid/view/View;)Landroid/view/View;

    .line 96
    const v0, 0x7f0c033a

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-static {p4, v0}, Lmp;->a(Lmp;Landroid/widget/LinearLayout;)Landroid/widget/LinearLayout;

    .line 97
    const v0, 0x7f0c033b

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    .line 99
    const v0, 0x7f0c033c

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 100
    const v0, 0x7f0c033f

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {p4, v0}, Lmp;->a(Lmp;Lcom/bestbuy/android/bbyobjects/BBYTextView;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 101
    const v0, 0x7f0c0340

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {p4, v0}, Lmp;->b(Lmp;Lcom/bestbuy/android/bbyobjects/BBYTextView;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 102
    const v0, 0x7f0c0343

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    invoke-static {p4, v0}, Lmp;->a(Lmp;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;

    .line 103
    invoke-static {p4}, Lmp;->a(Lmp;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Want: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getRequiredQuantity()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 104
    invoke-static {p4}, Lmp;->b(Lmp;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Have: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getPurchaseQuantity()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 106
    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 107
    const v0, 0x7f0c0341

    invoke-virtual {p5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    invoke-static {p4, v0}, Lmp;->b(Lmp;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;

    .line 108
    invoke-static {p4}, Lmp;->c(Lmp;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v8}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 109
    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->isCommerceUnavailable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    invoke-static {p4}, Lmp;->c(Lmp;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const v1, 0x7f020009

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 112
    :cond_0
    invoke-static {p4}, Lmp;->c(Lmp;)Landroid/widget/RelativeLayout;

    move-result-object v0

    new-instance v1, Lmo$1;

    invoke-direct {v1, p2, p1, p0, p3}, Lmo$1;-><init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/registry/Entities;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 130
    :cond_1
    invoke-virtual {p3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->isFavorite()Z

    move-result v0

    if-eqz v0, :cond_2

    if-eqz p6, :cond_2

    .line 131
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 132
    iget-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Our Favorite"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 133
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    const-string v1, "Our Favorite"

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 143
    :goto_0
    invoke-static {p4}, Lmp;->d(Lmp;)Landroid/widget/LinearLayout;

    move-result-object v7

    new-instance v0, Lmo$2;

    move-object v1, p5

    move-object v2, p4

    move v3, p6

    move-object v4, p0

    move-object v5, p1

    move-object v6, p3

    invoke-direct/range {v0 .. v6}, Lmo$2;-><init>(Landroid/view/View;Lmp;ZLandroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/Entities;)V

    invoke-virtual {v7, v0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 170
    invoke-static {p4}, Lmp;->e(Lmp;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v8}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 171
    invoke-static {p4}, Lmp;->e(Lmp;)Landroid/widget/RelativeLayout;

    move-result-object v0

    new-instance v1, Lmo$3;

    invoke-direct {v1, p1, p2}, Lmo$3;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 179
    return-void

    .line 134
    :cond_2
    invoke-virtual {p3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->isFavorite()Z

    move-result v0

    if-eqz v0, :cond_3

    if-nez p6, :cond_3

    .line 135
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 136
    iget-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "My Favorite"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 137
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    const-string v1, "My Favorite"

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    goto :goto_0

    .line 139
    :cond_3
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    const v1, 0x7f0200cc

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 140
    iget-object v0, p4, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Favorite this"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 141
    iget-object v0, p4, Lmp;->a:Landroid/widget/ImageView;

    const-string v1, "Favorite this"

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method static synthetic b(Lmo;)I
    .locals 1

    .prologue
    .line 29
    iget v0, p0, Lmo;->a:I

    return v0
.end method
