.class Lcom/livemixtapes/SearchFragment$1;
.super Ljava/lang/Object;
.source "SearchFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/SearchFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SearchFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SearchFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SearchFragment$1;->this$0:Lcom/livemixtapes/SearchFragment;

    .line 186
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
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
    .line 189
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$1;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->list:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v1

    sub-int/2addr p3, v1

    .line 191
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$1;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v1}, Lcom/livemixtapes/LazyAdapterSearch;->isTopArtistSearch()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 192
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$1;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->topArtistsResultsList:Ljava/util/ArrayList;

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/HashMap;

    const-string v2, "artist"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 193
    .local v0, "searchStr":Ljava/lang/String;
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$1;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v1, v0}, Lcom/livemixtapes/ui/widgets/SearchView;->setQuery(Ljava/lang/String;)V

    .line 198
    .end local v0    # "searchStr":Ljava/lang/String;
    :goto_0
    return-void

    .line 195
    :cond_0
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$1;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    invoke-static {v1}, Lcom/livemixtapes/utils/Utility;->hideKeyboard(Landroid/app/Activity;)V

    .line 196
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$1;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v2, p0, Lcom/livemixtapes/SearchFragment$1;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v2, v2, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    iget-object v3, p0, Lcom/livemixtapes/SearchFragment$1;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v3, v3, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v3, p3}, Lcom/livemixtapes/LazyAdapterSearch;->getResult(I)Ljava/util/HashMap;

    move-result-object v3

    # invokes: Lcom/livemixtapes/SearchFragment;->showMixtapeFragment(Landroid/content/Context;Ljava/util/HashMap;)V
    invoke-static {v1, v2, v3}, Lcom/livemixtapes/SearchFragment;->access$0(Lcom/livemixtapes/SearchFragment;Landroid/content/Context;Ljava/util/HashMap;)V

    goto :goto_0
.end method
