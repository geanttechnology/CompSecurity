.class Leg$2;
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
    .line 207
    iput-object p1, p0, Leg$2;->b:Leg;

    iput-object p2, p0, Leg$2;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 211
    iget-object v0, p0, Leg$2;->b:Leg;

    invoke-static {v0}, Leg;->b(Leg;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v0

    .line 212
    iget-object v1, p0, Leg$2;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getSellerId()Ljava/lang/String;

    move-result-object v1

    .line 213
    iget-object v2, p0, Leg$2;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getProductId()Ljava/lang/String;

    move-result-object v2

    .line 214
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "http://www.bestbuy.com/m/e/product/morebuyingoptions.jsp?checkForPlansAndAccessories=true&skuId="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "&sellerId="

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&productId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 215
    new-instance v1, Lky;

    iget-object v2, p0, Leg$2;->b:Leg;

    invoke-static {v2}, Leg;->c(Leg;)Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Leg$2;->b:Leg;

    invoke-static {v3}, Leg;->a(Leg;)Landroid/support/v4/app/Fragment;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lky;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 216
    invoke-virtual {v1}, Lky;->a()V

    .line 217
    return-void
.end method
