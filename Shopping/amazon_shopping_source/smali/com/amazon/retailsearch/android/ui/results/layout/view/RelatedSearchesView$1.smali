.class Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView$1;
.super Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
.source "RelatedSearchesView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->build(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;

.field final synthetic val$relatedSearch:Lcom/amazon/searchapp/retailsearch/model/Link;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;Landroid/content/res/Resources;Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/res/Resources;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;

    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView$1;->val$relatedSearch:Lcom/amazon/searchapp/retailsearch/model/Link;

    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;-><init>(Landroid/content/res/Resources;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView$1;->val$relatedSearch:Lcom/amazon/searchapp/retailsearch/model/Link;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->search(Ljava/lang/String;)V

    .line 66
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->access$000(Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->recordRelatedSearchesInvoked()V

    .line 67
    return-void
.end method
