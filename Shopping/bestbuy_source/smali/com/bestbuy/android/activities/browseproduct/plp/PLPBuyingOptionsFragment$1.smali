.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

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
    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 146
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 147
    const-string v1, "New Condition"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->c(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 154
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->f(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Leq;

    move-result-object v0

    invoke-virtual {v0}, Leq;->notifyDataSetChanged()V

    .line 155
    return-void

    .line 149
    :cond_1
    const-string v1, "Open-Box Condition"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->d(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 151
    :cond_2
    const-string v1, "Refurbished Condition"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->e(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;

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
    .line 159
    return-void
.end method
