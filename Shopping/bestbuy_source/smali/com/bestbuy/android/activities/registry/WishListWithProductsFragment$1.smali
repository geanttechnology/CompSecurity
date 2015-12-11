.class Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V
    .locals 0

    .prologue
    .line 330
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
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
    .line 335
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Lcom/bestbuy/android/activities/stores/DialogSpinner;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v0

    invoke-interface {v0, p3}, Landroid/widget/SpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 336
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;Ljava/lang/String;Z)V

    .line 337
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
    .line 343
    return-void
.end method
