.class Lcom/poshmark/ui/fragments/SearchResultsFragment$1;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SearchResultsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SearchResultsFragment;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 1
    .param p1, "isPagination"    # Z

    .prologue
    .line 67
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    # invokes: Lcom/poshmark/ui/fragments/SearchResultsFragment;->getSearchResults(Z)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->access$000(Lcom/poshmark/ui/fragments/SearchResultsFragment;Z)V

    .line 68
    return-void
.end method
