.class Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)V
    .locals 0

    .prologue
    .line 169
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 174
    new-instance v1, Lih;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    iget-object v2, v2, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    iget-object v4, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)Landroid/view/View;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->c(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;->getDeals()Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-direct {v1, v2, v3, v4, v0}, Lih;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V

    sget-object v0, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v1, v0, v2}, Lih;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 176
    return-void
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 180
    return-void
.end method
