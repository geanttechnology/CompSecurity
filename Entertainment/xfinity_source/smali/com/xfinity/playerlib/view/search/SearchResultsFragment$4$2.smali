.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$2;
.super Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener",
        "<",
        "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;

.field final synthetic val$genreFilters:Ljava/util/Set;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/Set;)V
    .locals 1
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;
    .param p2, "tagMatch"    # Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .prologue
    .line 332
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$2;->this$1:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$2;->val$genreFilters:Ljava/util/Set;

    iget-object v0, p1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0, v0, p2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/tags/Tag;)V

    return-void
.end method


# virtual methods
.method protected onTagSelected(Lcom/xfinity/playerlib/model/tags/OrderedTag;)V
    .locals 1
    .param p1, "tag"    # Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .prologue
    .line 334
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$2;->val$genreFilters:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 335
    return-void
.end method

.method protected bridge synthetic onTagSelected(Lcom/xfinity/playerlib/model/tags/Tag;)V
    .locals 0

    .prologue
    .line 332
    check-cast p1, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$2;->onTagSelected(Lcom/xfinity/playerlib/model/tags/OrderedTag;)V

    return-void
.end method
