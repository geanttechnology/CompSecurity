.class Ldq$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ldq;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field final synthetic b:Ldq;


# direct methods
.method constructor <init>(Ldq;Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V
    .locals 0

    .prologue
    .line 159
    iput-object p1, p0, Ldq$2;->b:Ldq;

    iput-object p2, p0, Ldq$2;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 162
    iget-object v0, p0, Ldq$2;->b:Ldq;

    invoke-static {v0}, Ldq;->b(Ldq;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->isCommerceUnavailable()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 163
    iget-object v0, p0, Ldq$2;->b:Ldq;

    invoke-static {v0}, Ldq;->a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ldq$2;->b:Ldq;

    invoke-static {v0}, Ldq;->a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 164
    iget-object v0, p0, Ldq$2;->b:Ldq;

    invoke-static {v0}, Ldq;->a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, p0, Ldq$2;->b:Ldq;

    invoke-static {v1}, Ldq;->c(Ldq;)Landroid/app/Activity;

    move-result-object v1

    const v2, 0x7f08009f

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d(Ljava/lang/String;)V

    .line 169
    :cond_0
    :goto_0
    return-void

    .line 166
    :cond_1
    iget-object v0, p0, Ldq$2;->b:Ldq;

    invoke-static {v0}, Ldq;->a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Ldq$2;->b:Ldq;

    invoke-static {v0}, Ldq;->a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Ldq$2;->b:Ldq;

    invoke-static {v0}, Ldq;->a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, p0, Ldq$2;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c(Ljava/lang/String;)V

    goto :goto_0
.end method
