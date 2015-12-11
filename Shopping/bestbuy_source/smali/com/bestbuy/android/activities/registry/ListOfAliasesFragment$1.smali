.class Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment$1;->a:Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
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
    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment$1;->a:Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->a(Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge p3, v0, :cond_0

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment$1;->a:Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->b(Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;)Lcn;

    move-result-object v0

    iget-object v0, v0, Lcn;->a:Ljava/util/List;

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v5, v0

    check-cast v5, Lcom/bestbuy/android/api/lib/models/registry/AliasesList;

    .line 88
    new-instance v0, Ljl;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment$1;->a:Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment$1;->a:Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment$1;->a:Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->c(Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/AliasesList;->getAlias()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/AliasesList;->getDescription()Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Ljl;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Ljl;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 93
    :cond_0
    return-void
.end method
