.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

.field final synthetic b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$5;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$5;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 241
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$5;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://www.bestbuy.com"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$5;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getSellerUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 242
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$5;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$5;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a(Ljava/lang/String;)V

    .line 243
    return-void
.end method
