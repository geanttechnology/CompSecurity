.class public Lcom/bestbuy/android/activities/registry/ScannedItemFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# static fields
.field private static C:Z


# instance fields
.field private A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private B:Landroid/widget/RelativeLayout;

.field private D:Z

.field private E:Landroid/app/Activity;

.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private i:Landroid/widget/ImageView;

.field private j:Landroid/widget/RatingBar;

.field private k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private l:Landroid/widget/LinearLayout;

.field private m:Landroid/widget/LinearLayout;

.field private n:Landroid/widget/LinearLayout;

.field private o:Landroid/view/View;

.field private p:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private q:Landroid/widget/RelativeLayout;

.field private r:Landroid/widget/LinearLayout;

.field private s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private t:Landroid/widget/LinearLayout;

.field private u:Landroid/widget/LinearLayout;

.field private v:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field

.field private w:Landroid/widget/ImageView;

.field private x:Landroid/widget/ImageView;

.field private y:Landroid/widget/LinearLayout;

.field private z:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 71
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->p:Ljava/util/ArrayList;

    .line 68
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->D:Z

    .line 72
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    .line 73
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a:Ljava/lang/String;

    .line 74
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b:Ljava/lang/String;

    .line 75
    iput-object p4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    .line 76
    const-string v0, "weddingregistrylists"

    invoke-virtual {p4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 77
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->D:Z

    .line 79
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 364
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->y:Landroid/widget/LinearLayout;

    const v1, 0x7f0c039f

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 365
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->y:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 366
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v9, 0x5

    const/high16 v10, 0x41200000    # 10.0f

    const/4 v8, 0x2

    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 146
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "We Found It"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 148
    :cond_0
    if-eqz p1, :cond_8

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_8

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->l:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 152
    invoke-virtual {p1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 153
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v13

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->j:Landroid/widget/RatingBar;

    invoke-virtual {v0, v9}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 156
    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v6

    double-to-float v0, v6

    .line 157
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->j:Landroid/widget/RatingBar;

    invoke-virtual {v2, v0}, Landroid/widget/RatingBar;->setRating(F)V

    .line 158
    const/4 v2, 0x0

    cmpl-float v0, v0, v2

    if-lez v0, :cond_b

    .line 159
    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    .line 160
    const/4 v2, 0x1

    if-ne v0, v2, :cond_9

    .line 161
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    const v7, 0x7f0802df

    invoke-virtual {v6, v7}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 165
    :goto_0
    const/16 v2, 0x3e7

    if-le v0, v2, :cond_a

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v8, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 175
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    const/4 v2, 0x3

    const-string v6, ""

    move v5, v3

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 176
    if-eqz v0, :cond_1

    .line 177
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 179
    :cond_1
    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    move-object v6, p0

    move-object v7, v1

    move-object v8, v4

    move v10, v3

    move-object v11, v4

    move-object v12, v4

    invoke-static/range {v5 .. v12}, Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;IZLandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)Landroid/view/View;

    move-result-object v0

    .line 181
    if-eqz v0, :cond_2

    .line 182
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    const v1, 0x7f0c034a

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0348

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0349

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 188
    :cond_2
    const-string v0, ""

    .line 189
    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    if-eqz v1, :cond_7

    .line 190
    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 191
    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 192
    :cond_3
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    const v2, 0x7f080068

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 193
    :cond_4
    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 194
    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 196
    :cond_5
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_6

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    const v2, 0x7f080068

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 197
    :cond_6
    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_7

    .line 198
    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 201
    :cond_7
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->i:Landroid/widget/ImageView;

    invoke-static {v0, v1, v3}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 204
    :cond_8
    return-void

    .line 163
    :cond_9
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    const v7, 0x7f0802e0

    invoke-virtual {v6, v7}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 168
    :cond_a
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/high16 v2, 0x41300000    # 11.0f

    invoke-virtual {v0, v8, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    goto/16 :goto_1

    .line 171
    :cond_b
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v8, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    const v5, 0x7f080394

    invoke-virtual {v2, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public a(Z)V
    .locals 3

    .prologue
    const v1, 0x7f0c03a4

    const v2, 0x7f0c03a5

    .line 345
    if-eqz p1, :cond_1

    .line 346
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const v1, 0x7f0200c9

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 347
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->D:Z

    if-eqz v0, :cond_0

    .line 348
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "My Favorite"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 355
    :goto_0
    return-void

    .line 350
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Our Favorite"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0

    .line 352
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const v1, 0x7f0200cc

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 353
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Favorite This"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public b()V
    .locals 7

    .prologue
    const/16 v2, 0x8

    const/4 v4, 0x0

    .line 246
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    invoke-virtual {v0, p0, v1, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->q:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 249
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "We Found It"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 251
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    const v1, 0x7f0c03a4

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const v1, 0x7f0200cc

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 252
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    const v1, 0x7f0c03a5

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Favorite This"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 254
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->r:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->B:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 257
    sget-boolean v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->C:Z

    if-nez v0, :cond_1

    .line 258
    const-string v0, "Item Removed"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a(Ljava/lang/String;)V

    .line 261
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    const v1, 0x7f0c034a

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 262
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0348

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 264
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 265
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v6

    .line 266
    new-instance v0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V

    .line 267
    const v1, 0x7f0c03ab

    const-string v2, "CustomerAlsoViewedList"

    invoke-virtual {v6, v1, v0, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 269
    invoke-virtual {v6}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 270
    return-void
.end method

.method public b(Ljava/util/ArrayList;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/16 v5, 0x8

    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 208
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "Remove"

    invoke-virtual {v0, p0, v1, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 209
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    const-string v2, "weddingregistrylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    const-string v2, "weddingregistrylist"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 211
    :cond_0
    invoke-virtual {v1, v4}, Lnb;->l(Z)V

    .line 215
    :goto_0
    invoke-virtual {v1, v4}, Lnb;->k(Z)V

    .line 216
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->v:Ljava/util/ArrayList;

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->q:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v2, "Item Added"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->r:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->B:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 222
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->B:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 223
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->r:Landroid/widget/LinearLayout;

    const v2, 0x7f0c03a3

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    .line 224
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->t:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->r:Landroid/widget/LinearLayout;

    const v2, 0x7f0c03a6

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->u:Landroid/widget/LinearLayout;

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->u:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 227
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    const-string v2, "weddingregistrylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    const-string v2, "weddingregistrylist"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 228
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->z:Landroid/widget/ImageView;

    const v2, 0x7f02016f

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v2, "Return to Registry"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 230
    invoke-virtual {v1, v4}, Lnb;->l(Z)V

    .line 236
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 237
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v6

    .line 238
    new-instance v0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V

    .line 239
    const v1, 0x7f0c03ab

    const-string v2, "CustomerAlsoBoughtList"

    invoke-virtual {v6, v1, v0, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 241
    invoke-virtual {v6}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 242
    return-void

    .line 213
    :cond_2
    invoke-virtual {v1, v4}, Lnb;->j(Z)V

    goto/16 :goto_0

    .line 232
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->z:Landroid/widget/ImageView;

    const v1, 0x7f020170

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 233
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Return to Wish List"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public c()V
    .locals 0

    .prologue
    .line 359
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b()V

    .line 360
    return-void
.end method

.method public g()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 370
    new-instance v0, Ljb;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b:Ljava/lang/String;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v5

    :goto_0
    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ljb;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljb;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 372
    return-void

    .line 370
    :cond_0
    const-string v5, ""

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 7

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    move-object v0, p1

    .line 85
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    .line 87
    check-cast p1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 88
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v6

    .line 89
    new-instance v0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a:Ljava/lang/String;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V

    .line 90
    const v1, 0x7f0c03ab

    const-string v2, "CustomerAlsoViewedList"

    invoke-virtual {v6, v1, v0, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 92
    invoke-virtual {v6}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 93
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 14

    .prologue
    const/16 v4, 0xa

    const v2, 0x7f0c0348

    const/4 v3, 0x0

    const/4 v10, 0x1

    const/4 v13, 0x0

    .line 275
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 341
    :cond_0
    :goto_0
    return-void

    .line 277
    :sswitch_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 278
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    const v1, 0x7f040005

    const v2, 0x7f040008

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0

    .line 281
    :sswitch_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->g:Ljava/lang/String;

    .line 282
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 283
    const-string v1, "bb.addToList"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 284
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    const-string v2, "weddingregistrylists"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 285
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ";"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ";;;;evar48=LE-WL"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 286
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Llu;->L:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v2, v13, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 287
    new-instance v0, Liy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a:Ljava/lang/String;

    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->g:Ljava/lang/String;

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 288
    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v13, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 289
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    const-string v2, "weddingregistrylists"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 290
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ";"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ";;;;evar48=WR-WR"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 291
    sget-object v1, Llu;->az:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 292
    new-instance v0, Liy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a:Ljava/lang/String;

    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->g:Ljava/lang/String;

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 293
    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v13, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 298
    :sswitch_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ge v0, v4, :cond_2

    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 300
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const v1, 0x7f020115

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 301
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne v0, v4, :cond_0

    .line 302
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    const v1, 0x7f0c034a

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const v1, 0x7f020007

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 307
    :sswitch_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    const v1, 0x7f0c034a

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const v1, 0x7f020006

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 308
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-le v0, v10, :cond_0

    .line 309
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 310
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne v0, v10, :cond_3

    .line 311
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const v1, 0x7f020116

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 313
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const v1, 0x7f020115

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 318
    :sswitch_4
    new-instance v4, Ljv;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b:Ljava/lang/String;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v8

    :goto_1
    iget-object v9, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    move-object v6, p0

    move-object v11, v3

    move-object v12, v3

    invoke-direct/range {v4 .. v12}, Ljv;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/ProgressBar;Lmp;)V

    sget-object v0, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v1, v13, [Ljava/lang/Void;

    invoke-virtual {v4, v0, v1}, Ljv;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    :cond_4
    const-string v8, ""

    goto :goto_1

    .line 322
    :sswitch_5
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 323
    add-int/lit8 v0, v0, -0x1

    :goto_2
    if-ltz v0, :cond_0

    .line 324
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    if-nez v1, :cond_0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-nez v1, :cond_0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-nez v1, :cond_0

    .line 329
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 323
    add-int/lit8 v0, v0, -0x1

    goto :goto_2

    .line 335
    :sswitch_6
    new-instance v0, Lmf;

    invoke-direct {v0}, Lmf;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    const-string v2, "LIFE_EVENTS_PRODUCT_SCAN"

    const-string v3, "LIFE_EVENTS_PRODUCT_SCAN"

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c:Ljava/lang/String;

    invoke-virtual/range {v0 .. v5}, Lmf;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 336
    sput-boolean v10, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->C:Z

    goto/16 :goto_0

    .line 275
    :sswitch_data_0
    .sparse-switch
        0x7f0c0153 -> :sswitch_0
        0x7f0c0348 -> :sswitch_3
        0x7f0c034a -> :sswitch_2
        0x7f0c03a3 -> :sswitch_4
        0x7f0c03a6 -> :sswitch_5
        0x7f0c03aa -> :sswitch_1
        0x7f0c03ad -> :sswitch_6
    .end sparse-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 99
    invoke-super {p0, p1, p2, p3}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 100
    const v0, 0x7f0300ea

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 101
    const v0, 0x7f0c00c9

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 102
    const v0, 0x7f0c00c8

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->i:Landroid/widget/ImageView;

    .line 103
    const v0, 0x7f0c00cb

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->j:Landroid/widget/RatingBar;

    .line 104
    const v0, 0x7f0c00cc

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 105
    const v0, 0x7f0c00cd

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->m:Landroid/widget/LinearLayout;

    .line 106
    const v0, 0x7f0c0301

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->n:Landroid/widget/LinearLayout;

    .line 107
    const v0, 0x7f0c012c

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->o:Landroid/view/View;

    .line 108
    const v0, 0x7f0c03a2

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->r:Landroid/widget/LinearLayout;

    .line 109
    const v0, 0x7f0c039e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->y:Landroid/widget/LinearLayout;

    .line 110
    const v0, 0x7f0c03a9

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->q:Landroid/widget/RelativeLayout;

    .line 111
    const v0, 0x7f0c034a

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->w:Landroid/widget/ImageView;

    .line 112
    const v0, 0x7f0c0348

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->x:Landroid/widget/ImageView;

    .line 113
    const v0, 0x7f0c03a7

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->z:Landroid/widget/ImageView;

    .line 114
    const v0, 0x7f0c03a8

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 115
    const v0, 0x7f0c03ad

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->B:Landroid/widget/RelativeLayout;

    .line 116
    const v0, 0x7f0c03aa

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 117
    iget-boolean v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->D:Z

    if-eqz v2, :cond_0

    .line 118
    const-string v2, "Add Item"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setText(Ljava/lang/CharSequence;)V

    .line 119
    const v2, 0x7f020170

    invoke-virtual {v0, v2, v5, v5, v5}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 121
    :cond_0
    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 122
    const v0, 0x7f0c03a1

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->l:Landroid/widget/LinearLayout;

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->l:Landroid/widget/LinearLayout;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->p:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, ""

    invoke-virtual {v0, p0, v2, v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 127
    new-instance v0, Lhj;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->o:Landroid/view/View;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->p:Ljava/util/ArrayList;

    invoke-direct {v0, v2, p0, v3, v4}, Lhj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V

    .line 128
    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v3, v5, [Ljava/lang/Void;

    invoke-virtual {v0, v2, v3}, Lhj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 129
    return-object v1
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 134
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 135
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->C:Z

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Item Added"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 138
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 139
    new-instance v0, Lhj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->E:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->o:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->p:Ljava/util/ArrayList;

    invoke-direct {v0, v1, p0, v2, v3}, Lhj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V

    .line 140
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 142
    :cond_0
    return-void
.end method
