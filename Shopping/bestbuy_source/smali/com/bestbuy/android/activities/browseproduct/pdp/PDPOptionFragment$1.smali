.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->a(Ljava/util/List;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/pdp/Option;

.field final synthetic b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;Lcom/bestbuy/android/api/lib/models/pdp/Option;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$1;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$1;->a:Lcom/bestbuy/android/api/lib/models/pdp/Option;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 160
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 161
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$1;->a:Lcom/bestbuy/android/api/lib/models/pdp/Option;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/Option;->getSku()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 162
    sget-object v1, Llu;->an:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$1;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 165
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$1;->a:Lcom/bestbuy/android/api/lib/models/pdp/Option;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/Option;->getSku()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-direct {v1, v2, v3, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 166
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 167
    return-void
.end method
