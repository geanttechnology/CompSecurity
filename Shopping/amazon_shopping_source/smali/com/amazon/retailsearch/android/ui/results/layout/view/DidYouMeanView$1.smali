.class Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$1;
.super Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
.source "DidYouMeanView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->lowConfidence(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

.field final synthetic val$correctedQuery:Lcom/amazon/searchapp/retailsearch/model/Link;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;Landroid/content/res/Resources;Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/res/Resources;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$1;->val$correctedQuery:Lcom/amazon/searchapp/retailsearch/model/Link;

    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;-><init>(Landroid/content/res/Resources;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$1;->val$correctedQuery:Lcom/amazon/searchapp/retailsearch/model/Link;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$1;->val$correctedQuery:Lcom/amazon/searchapp/retailsearch/model/Link;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->search(Ljava/lang/String;)V

    .line 86
    :cond_0
    return-void
.end method
