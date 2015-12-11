.class Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;
.super Ljava/lang/Object;
.source "RetailSearchQueryEntry.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->onDeletePastSearchesClick(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

.field final synthetic val$deleteURL:Ljava/lang/String;

.field final synthetic val$id:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 418
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->val$id:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->val$deleteURL:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 422
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->suggestionDataProvider:Lcom/amazon/retailsearch/data/SuggestionDataProvider;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->access$600(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;)Lcom/amazon/retailsearch/data/SuggestionDataProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->val$id:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->val$deleteURL:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->deletePastSearches(Ljava/lang/String;Ljava/lang/String;)Z

    .line 423
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->access$700(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;)Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 425
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->access$800(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;)Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->setForceUpdatePastSearches(Z)V

    .line 426
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->access$700(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;)Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->access$900(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->filter(Ljava/lang/CharSequence;)V

    .line 428
    :cond_0
    return-void
.end method
