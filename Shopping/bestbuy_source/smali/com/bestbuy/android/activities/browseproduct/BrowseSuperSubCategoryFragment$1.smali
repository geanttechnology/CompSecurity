.class Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
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
    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a(Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;)Ljava/util/List;

    move-result-object v0

    add-int/lit8 v1, p3, -0x2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/browse/Category;

    .line 136
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "group"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 137
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a(Lcom/bestbuy/android/api/lib/models/browse/Category;)V

    .line 140
    :cond_0
    return-void
.end method
