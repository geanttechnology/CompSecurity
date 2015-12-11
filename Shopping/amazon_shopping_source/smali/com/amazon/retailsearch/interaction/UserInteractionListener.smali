.class public interface abstract Lcom/amazon/retailsearch/interaction/UserInteractionListener;
.super Ljava/lang/Object;
.source "UserInteractionListener.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/display/results/ResultsDisplayListeners;


# virtual methods
.method public abstract endPage(Landroid/view/View;)V
.end method

.method public abstract getSelectedAsin()Ljava/lang/String;
.end method

.method public abstract resultItemBuilt(Landroid/view/ViewGroup;Landroid/widget/ImageView;Ljava/lang/String;)V
.end method

.method public abstract resultItemSelected(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Lcom/amazon/retailsearch/metrics/DetailPageType;)V
.end method

.method public abstract retrySearch()V
.end method

.method public abstract search(Ljava/lang/String;)V
.end method

.method public abstract startPage(Landroid/view/View;I)V
.end method
