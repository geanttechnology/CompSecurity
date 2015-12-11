.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$9;
.super Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->updateBreadcrumbViews()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

.field final synthetic val$networkFilter:Lcom/xfinity/playerlib/model/tags/Network;

.field final synthetic val$networkFilters:Ljava/util/Set;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/util/Set;Lcom/xfinity/playerlib/model/tags/Network;)V
    .locals 1
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 737
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$9;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$9;->val$networkFilters:Ljava/util/Set;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$9;->val$networkFilter:Lcom/xfinity/playerlib/model/tags/Network;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;)V

    return-void
.end method


# virtual methods
.method protected onBreadcrumbClicked()V
    .locals 2

    .prologue
    .line 739
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$9;->val$networkFilters:Ljava/util/Set;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$9;->val$networkFilter:Lcom/xfinity/playerlib/model/tags/Network;

    invoke-interface {v0, v1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 740
    return-void
.end method
