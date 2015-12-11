.class Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;->a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 8
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
    const/4 v6, 0x0

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;->a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge p3, v0, :cond_0

    .line 222
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;->a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;->a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 223
    new-instance v0, Ljd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;->a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;->a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;->a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->b(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;->a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    invoke-static {v5}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->b(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v5

    const/4 v7, 0x0

    invoke-direct/range {v0 .. v7}, Ljd;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljd;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 226
    :cond_0
    return-void
.end method
