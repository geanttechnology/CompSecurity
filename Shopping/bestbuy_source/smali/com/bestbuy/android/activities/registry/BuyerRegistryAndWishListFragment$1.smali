.class Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 11
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
    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/activities/stores/DialogSpinner;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v0

    invoke-interface {v0, p3}, Landroid/widget/SpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 149
    const-string v1, "All Gifts"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "All Items"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 151
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 152
    iget-object v10, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    const v3, 0x7f03011c

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->d(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v5

    const/4 v6, 0x2

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->f(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/LinearLayout;

    move-result-object v7

    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v8

    iget-object v9, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v9}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->h(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z

    move-result v9

    invoke-direct/range {v0 .. v9}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;ILandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    invoke-static {v10, v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;Ldg;)Ldg;

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->i(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ldg;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 225
    :cond_1
    :goto_0
    return-void

    .line 155
    :cond_2
    const-string v1, "Favorite Items"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "Favorite Gifts"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 157
    :cond_3
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 158
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 159
    const/4 v0, 0x0

    move v1, v0

    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_5

    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->isFavorite()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->d(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 159
    :cond_4
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 165
    :cond_5
    iget-object v10, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    const v3, 0x7f03011c

    const/4 v6, 0x2

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->f(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/LinearLayout;

    move-result-object v7

    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v8

    iget-object v9, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v9}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->h(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z

    move-result v9

    invoke-direct/range {v0 .. v9}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;ILandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    invoke-static {v10, v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;Ldg;)Ldg;

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->i(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ldg;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 168
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_7

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->h(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const-string v1, "No Favorite Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 174
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const-string v1, "No Favorite Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 176
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 178
    :cond_8
    const-string v1, "Purchased Gifts"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_9

    const-string v1, "Purchased Items"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 179
    :cond_9
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 180
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 181
    const/4 v0, 0x0

    move v1, v0

    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_b

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getPurchaseQuantity()I

    move-result v0

    if-lez v0, :cond_a

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->d(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 181
    :cond_a
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    .line 187
    :cond_b
    iget-object v10, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    const v3, 0x7f03011c

    const/4 v6, 0x2

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->f(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/LinearLayout;

    move-result-object v7

    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v8

    iget-object v9, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v9}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->h(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z

    move-result v9

    invoke-direct/range {v0 .. v9}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;ILandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    invoke-static {v10, v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;Ldg;)Ldg;

    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->i(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ldg;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 190
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_d

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->h(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const-string v1, "No Purchased Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 196
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const-string v1, "No Purchased Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 198
    :cond_d
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 200
    :cond_e
    const-string v1, "Not Purchased Gifts"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_f

    const-string v1, "Not Purchased Items"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 201
    :cond_f
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 202
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 203
    const/4 v0, 0x0

    move v1, v0

    :goto_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_11

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getPurchaseQuantity()I

    move-result v0

    if-nez v0, :cond_10

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->d(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_10

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->d(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_10

    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->d(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 203
    :cond_10
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    .line 210
    :cond_11
    iget-object v10, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    const v3, 0x7f03011c

    const/4 v6, 0x2

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->f(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/LinearLayout;

    move-result-object v7

    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v8

    iget-object v9, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v9}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->h(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z

    move-result v9

    invoke-direct/range {v0 .. v9}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;ILandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    invoke-static {v10, v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;Ldg;)Ldg;

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->i(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ldg;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 214
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_12

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_14

    .line 215
    :cond_12
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->h(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const-string v1, "No Not Purchased Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 220
    :cond_13
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const-string v1, "No Not Purchased Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 222
    :cond_14
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_0
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
    .line 231
    return-void
.end method
