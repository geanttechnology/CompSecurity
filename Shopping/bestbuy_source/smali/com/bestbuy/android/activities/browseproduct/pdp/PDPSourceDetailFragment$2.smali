.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

.field final synthetic b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;)V
    .locals 0

    .prologue
    .line 283
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$2;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 286
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$2;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://www.bestbuy.com"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getSellerUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 287
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$2;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$2;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a(Ljava/lang/String;)V

    .line 288
    return-void
.end method
