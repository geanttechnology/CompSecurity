.class Leq$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Leq;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

.field final synthetic b:Leq;


# direct methods
.method constructor <init>(Leq;Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;)V
    .locals 0

    .prologue
    .line 209
    iput-object p1, p0, Leq$2;->b:Leq;

    iput-object p2, p0, Leq$2;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 213
    iget-object v0, p0, Leq$2;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getSellerId()Ljava/lang/String;

    move-result-object v0

    .line 214
    iget-object v1, p0, Leq$2;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getProductId()Ljava/lang/String;

    move-result-object v1

    .line 215
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "http://www.bestbuy.com/m/e/product/morebuyingoptions.jsp?checkForPlansAndAccessories=true&skuId="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Leq$2;->b:Leq;

    invoke-static {v3}, Leq;->b(Leq;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&sellerId="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&productId="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 216
    new-instance v1, Lky;

    iget-object v2, p0, Leq$2;->b:Leq;

    invoke-static {v2}, Leq;->c(Leq;)Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Leq$2;->b:Leq;

    invoke-static {v3}, Leq;->a(Leq;)Landroid/support/v4/app/Fragment;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lky;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 217
    invoke-virtual {v1}, Lky;->a()V

    .line 218
    return-void
.end method
