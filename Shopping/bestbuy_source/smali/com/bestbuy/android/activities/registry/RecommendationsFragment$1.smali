.class Lcom/bestbuy/android/activities/registry/RecommendationsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/RecommendationsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment$1;->a:Lcom/bestbuy/android/activities/registry/RecommendationsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
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
    const/4 v4, 0x1

    .line 85
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment$1;->a:Lcom/bestbuy/android/activities/registry/RecommendationsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment$1;->a:Lcom/bestbuy/android/activities/registry/RecommendationsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->a(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->a(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 86
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment$1;->a:Lcom/bestbuy/android/activities/registry/RecommendationsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->b(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;)Ljava/lang/String;

    move-result-object v2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment$1;->a:Lcom/bestbuy/android/activities/registry/RecommendationsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->c(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const/16 v3, 0x32

    invoke-direct {v1, v4, v2, v0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;I)V

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment$1;->a:Lcom/bestbuy/android/activities/registry/RecommendationsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 88
    return-void
.end method
