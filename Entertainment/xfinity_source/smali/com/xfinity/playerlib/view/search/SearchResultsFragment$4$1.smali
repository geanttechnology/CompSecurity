.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$1;
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
        "Lcom/xfinity/playerlib/model/tags/Network;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;

.field final synthetic val$networkFilters:Ljava/util/Set;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;Lcom/xfinity/playerlib/model/tags/Network;Ljava/util/Set;)V
    .locals 1
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;
    .param p2, "tagMatch"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 324
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$1;->this$1:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$1;->val$networkFilters:Ljava/util/Set;

    iget-object v0, p1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0, v0, p2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/tags/Tag;)V

    return-void
.end method


# virtual methods
.method protected onTagSelected(Lcom/xfinity/playerlib/model/tags/Network;)V
    .locals 1
    .param p1, "tag"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 326
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$1;->val$networkFilters:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 327
    return-void
.end method

.method protected bridge synthetic onTagSelected(Lcom/xfinity/playerlib/model/tags/Tag;)V
    .locals 0

    .prologue
    .line 324
    check-cast p1, Lcom/xfinity/playerlib/model/tags/Network;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$1;->onTagSelected(Lcom/xfinity/playerlib/model/tags/Network;)V

    return-void
.end method
