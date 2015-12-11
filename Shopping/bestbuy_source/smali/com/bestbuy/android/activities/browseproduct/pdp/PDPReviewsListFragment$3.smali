.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Ljava/lang/String;Ljava/util/ArrayList;Landroid/widget/LinearLayout;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Landroid/widget/TextView;

.field final synthetic c:Ljava/util/ArrayList;

.field final synthetic d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Ljava/lang/String;Landroid/widget/TextView;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 343
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->c:Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    const v6, 0x7f0b0031

    const v5, 0x7f0201b1

    const/4 v4, 0x0

    .line 346
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 347
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 348
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->a:Ljava/lang/String;

    const-string v2, "Cons"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 349
    const-string v1, "bb.distilledReviewCon"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 350
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->p(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "pdp: distilled review: con: reviews"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 351
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->p(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pdp: reviews: con"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 358
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->q(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/TextView;

    move-result-object v0

    if-nez v0, :cond_3

    .line 359
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Landroid/widget/TextView;)Landroid/widget/TextView;

    .line 368
    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getTag()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "UnClicked"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 369
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;I)I

    .line 370
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    const-string v1, "Clicked"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 371
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0063

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 372
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    const v1, 0x7f0201b0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 373
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->c:Ljava/util/ArrayList;

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getFeature()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Ljava/lang/String;)V

    .line 382
    :goto_2
    return-void

    .line 352
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->a:Ljava/lang/String;

    const-string v2, "Pros"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 353
    const-string v1, "bb.distilledReviewPro"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 354
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->p(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "pdp: distilled review: pro: reviews"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 355
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->p(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pdp: reviews: pro"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 361
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->q(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 362
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->q(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/TextView;

    move-result-object v0

    const-string v1, "UnClicked"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 363
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->q(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 364
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->q(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 365
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Landroid/widget/TextView;)Landroid/widget/TextView;

    goto/16 :goto_1

    .line 375
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;I)I

    .line 376
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    const-string v1, "UnClicked"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 377
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 378
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->b:Landroid/widget/TextView;

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 379
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;->d:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Ljava/lang/String;)V

    goto/16 :goto_2
.end method
