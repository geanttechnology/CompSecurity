.class Leg$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Leg;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

.field final synthetic b:Leg;


# direct methods
.method constructor <init>(Leg;Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;)V
    .locals 0

    .prologue
    .line 197
    iput-object p1, p0, Leg$1;->b:Leg;

    iput-object p2, p0, Leg$1;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 201
    iget-object v0, p0, Leg$1;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Leg$1;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getSellerName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "BestBuy"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 202
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://www.bestbuy.com"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Leg$1;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getSellerUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 203
    iget-object v0, p0, Leg$1;->b:Leg;

    invoke-static {v0}, Leg;->a(Leg;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a(Ljava/lang/String;)V

    .line 205
    :cond_0
    return-void
.end method
