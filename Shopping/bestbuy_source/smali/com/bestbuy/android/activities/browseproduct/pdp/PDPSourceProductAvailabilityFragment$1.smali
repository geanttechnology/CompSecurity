.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
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
    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 136
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 137
    const-string v1, "New Condition"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 144
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Leg;

    move-result-object v0

    invoke-virtual {v0}, Leg;->notifyDataSetChanged()V

    .line 145
    return-void

    .line 139
    :cond_1
    const-string v1, "Open-Box Condition"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 141
    :cond_2
    const-string v1, "Refurbished Condition"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0
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
    .line 149
    return-void
.end method
