.class public Ldg;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/app/Activity;

.field private c:Landroid/view/LayoutInflater;

.field private d:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field

.field private e:I

.field private f:Lcom/bestbuy/android/base/BBYBaseFragment;

.field private g:Z

.field private h:Z

.field private i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private j:Landroid/widget/LinearLayout;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;ILandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;I",
            "Landroid/widget/LinearLayout;",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 55
    invoke-direct {p0, p1, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 38
    const/4 v0, 0x0

    iput-object v0, p0, Ldg;->j:Landroid/widget/LinearLayout;

    .line 56
    iput-object p4, p0, Ldg;->a:Ljava/util/ArrayList;

    .line 57
    iput-object p1, p0, Ldg;->b:Landroid/app/Activity;

    .line 58
    iput-object p5, p0, Ldg;->d:Ljava/util/ArrayList;

    .line 59
    iput p6, p0, Ldg;->e:I

    .line 60
    iput-object p2, p0, Ldg;->f:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 61
    iput-object p7, p0, Ldg;->j:Landroid/widget/LinearLayout;

    .line 62
    iput-object p8, p0, Ldg;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 63
    iput-boolean p9, p0, Ldg;->h:Z

    .line 64
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Ldg;->c:Landroid/view/LayoutInflater;

    .line 65
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;IZ)V"
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0, p1, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 38
    const/4 v0, 0x0

    iput-object v0, p0, Ldg;->j:Landroid/widget/LinearLayout;

    .line 43
    iput-object p4, p0, Ldg;->a:Ljava/util/ArrayList;

    .line 44
    iput-object p1, p0, Ldg;->b:Landroid/app/Activity;

    .line 45
    iput-object p5, p0, Ldg;->d:Ljava/util/ArrayList;

    .line 46
    iput p6, p0, Ldg;->e:I

    .line 47
    iput-object p2, p0, Ldg;->f:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 48
    iput-boolean p7, p0, Ldg;->g:Z

    .line 49
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Ldg;->c:Landroid/view/LayoutInflater;

    .line 50
    return-void
.end method

.method static synthetic a(Ldg;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Ldg;->b:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)I
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Ldg;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public a(Ljava/lang/String;)I
    .locals 5

    .prologue
    .line 190
    iget-object v0, p0, Ldg;->d:Ljava/util/ArrayList;

    .line 191
    const-string v1, ""

    .line 192
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    .line 193
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 194
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getSku()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 199
    :cond_1
    iget-object v2, p0, Ldg;->a:Ljava/util/ArrayList;

    .line 200
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 201
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 202
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 205
    :goto_0
    return v0

    :cond_3
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public a(I)V
    .locals 0

    .prologue
    .line 68
    iput p1, p0, Ldg;->e:I

    .line 69
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Ldg;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 73
    const/4 v0, 0x0

    return v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 28
    check-cast p1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {p0, p1}, Ldg;->a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 15

    .prologue
    .line 94
    if-nez p2, :cond_a

    .line 95
    new-instance v3, Ldh;

    invoke-direct {v3}, Ldh;-><init>()V

    .line 96
    iget-object v2, p0, Ldg;->c:Landroid/view/LayoutInflater;

    const v4, 0x7f03011c

    const/4 v5, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v2, v4, v0, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 97
    const v2, 0x7f0c032e

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Ldh;->h:Landroid/widget/LinearLayout;

    .line 98
    const v2, 0x7f0c0427

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v2, v3, Ldh;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 99
    const v2, 0x7f0c0426

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v3, Ldh;->a:Landroid/widget/ImageView;

    .line 100
    const v2, 0x7f0c0429

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RatingBar;

    iput-object v2, v3, Ldh;->c:Landroid/widget/RatingBar;

    .line 101
    const v2, 0x7f0c042a

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v2, v3, Ldh;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 102
    const v2, 0x7f0c00cd

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Ldh;->f:Landroid/widget/LinearLayout;

    .line 103
    const v2, 0x7f0c0301

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Ldh;->e:Landroid/widget/LinearLayout;

    .line 104
    const v2, 0x7f0c0300

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Ldh;->g:Landroid/widget/LinearLayout;

    .line 105
    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v13, v3

    .line 109
    :goto_0
    iget-object v2, v13, Ldh;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 110
    iget-object v2, p0, Ldg;->a:Ljava/util/ArrayList;

    move/from16 v0, p1

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 111
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v14

    .line 112
    iget-object v2, p0, Ldg;->d:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_9

    .line 113
    iget-object v2, p0, Ldg;->d:Ljava/util/ArrayList;

    move/from16 v0, p1

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    move-object v12, v2

    check-cast v12, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    .line 114
    if-eqz v3, :cond_9

    .line 115
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v4

    .line 117
    :try_start_0
    invoke-virtual {p0}, Ldg;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v5, v13, Ldh;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v6, 0x3e8

    const v7, 0x7f080024

    invoke-static {v2, v5, v4, v6, v7}, Llt;->a(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;II)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 123
    :goto_1
    iget-object v2, v13, Ldh;->c:Landroid/widget/RatingBar;

    const/4 v4, 0x5

    invoke-virtual {v2, v4}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 124
    const/4 v2, 0x0

    .line 125
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 126
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v4

    double-to-float v2, v4

    .line 127
    :cond_0
    iget-object v4, v13, Ldh;->c:Landroid/widget/RatingBar;

    invoke-virtual {v4, v2}, Landroid/widget/RatingBar;->setRating(F)V

    .line 128
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 129
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v2

    .line 130
    iget-object v4, v13, Ldh;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "( "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, " reviews )"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 132
    :cond_1
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 133
    iget-object v2, p0, Ldg;->b:Landroid/app/Activity;

    const/4 v4, 0x3

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, ""

    invoke-static/range {v2 .. v8}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v2

    .line 134
    if-eqz v2, :cond_2

    .line 135
    iget-object v4, v13, Ldh;->f:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 136
    iget-object v4, v13, Ldh;->f:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 140
    :cond_2
    iget-boolean v2, p0, Ldg;->g:Z

    if-eqz v2, :cond_b

    .line 141
    iget-object v4, p0, Ldg;->b:Landroid/app/Activity;

    iget-object v5, p0, Ldg;->f:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget v8, p0, Ldg;->e:I

    iget-boolean v9, p0, Ldg;->g:Z

    iget-object v10, p0, Ldg;->j:Landroid/widget/LinearLayout;

    iget-object v11, p0, Ldg;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-object v6, v3

    move-object v7, v12

    invoke-static/range {v4 .. v11}, Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;IZLandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)Landroid/view/View;

    move-result-object v2

    .line 146
    :goto_2
    if-eqz v2, :cond_3

    .line 147
    iget-object v4, v13, Ldh;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 150
    :cond_3
    const-string v2, ""

    .line 151
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    if-eqz v4, :cond_8

    .line 152
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 153
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 154
    :cond_4
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_5

    iget-object v4, p0, Ldg;->b:Landroid/app/Activity;

    const v5, 0x7f080068

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 155
    :cond_5
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    if-eqz v4, :cond_6

    .line 156
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 158
    :cond_6
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_7

    iget-object v4, p0, Ldg;->b:Landroid/app/Activity;

    const v5, 0x7f080068

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 159
    :cond_7
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    if-eqz v4, :cond_8

    .line 160
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 163
    :cond_8
    iget-object v4, v13, Ldh;->a:Landroid/widget/ImageView;

    const/4 v5, 0x0

    invoke-static {v2, v4, v5}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 178
    :cond_9
    iget-object v2, v13, Ldh;->h:Landroid/widget/LinearLayout;

    new-instance v4, Ldg$1;

    invoke-direct {v4, p0, v3}, Ldg$1;-><init>(Ldg;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 185
    return-object p2

    .line 107
    :cond_a
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ldh;

    move-object v13, v2

    goto/16 :goto_0

    .line 119
    :catch_0
    move-exception v2

    .line 120
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 121
    iget-object v2, v13, Ldh;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 142
    :cond_b
    iget-boolean v2, p0, Ldg;->h:Z

    if-eqz v2, :cond_c

    .line 143
    iget-object v4, p0, Ldg;->b:Landroid/app/Activity;

    iget-object v5, p0, Ldg;->f:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget v8, p0, Ldg;->e:I

    iget-boolean v9, p0, Ldg;->h:Z

    iget-object v10, p0, Ldg;->j:Landroid/widget/LinearLayout;

    iget-object v11, p0, Ldg;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-object v6, v3

    move-object v7, v12

    invoke-static/range {v4 .. v11}, Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;IZLandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)Landroid/view/View;

    move-result-object v2

    goto/16 :goto_2

    .line 145
    :cond_c
    iget-object v4, p0, Ldg;->b:Landroid/app/Activity;

    iget-object v5, p0, Ldg;->f:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget v8, p0, Ldg;->e:I

    const/4 v9, 0x0

    iget-object v10, p0, Ldg;->j:Landroid/widget/LinearLayout;

    iget-object v11, p0, Ldg;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-object v6, v3

    move-object v7, v12

    invoke-static/range {v4 .. v11}, Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;IZLandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)Landroid/view/View;

    move-result-object v2

    goto/16 :goto_2
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 78
    const/4 v0, 0x2

    return v0
.end method
