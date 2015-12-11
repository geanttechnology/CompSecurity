.class Ldw$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ldw;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Ldw;


# direct methods
.method constructor <init>(Ldw;I)V
    .locals 0

    .prologue
    .line 167
    iput-object p1, p0, Ldw$2;->b:Ldw;

    iput p2, p0, Ldw$2;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 171
    iget-object v0, p0, Ldw$2;->b:Ldw;

    invoke-static {v0}, Ldw;->a(Ldw;)Ljava/util/List;

    move-result-object v0

    iget v1, p0, Ldw$2;->a:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "customOffer"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 172
    iget-object v0, p0, Ldw$2;->b:Ldw;

    invoke-static {v0}, Ldw;->a(Ldw;)Ljava/util/List;

    move-result-object v0

    iget v1, p0, Ldw$2;->a:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 173
    iget-object v0, p0, Ldw$2;->b:Ldw;

    invoke-static {v0}, Ldw;->c(Ldw;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a(Ljava/lang/String;)V

    .line 177
    :cond_0
    :goto_0
    return-void

    .line 174
    :cond_1
    iget-object v0, p0, Ldw$2;->b:Ldw;

    invoke-static {v0}, Ldw;->a(Ldw;)Ljava/util/List;

    move-result-object v0

    iget v1, p0, Ldw$2;->a:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "product"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 175
    iget-object v0, p0, Ldw$2;->b:Ldw;

    invoke-static {v0}, Ldw;->b(Ldw;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Ldw$2;->b:Ldw;

    invoke-static {v1}, Ldw;->a(Ldw;)Ljava/util/List;

    move-result-object v1

    iget v2, p0, Ldw$2;->a:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getSkuId()Ljava/lang/String;

    move-result-object v2

    iget-object v1, p0, Ldw$2;->b:Ldw;

    invoke-static {v1}, Ldw;->a(Ldw;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Ldw$2;->a:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_0
.end method
