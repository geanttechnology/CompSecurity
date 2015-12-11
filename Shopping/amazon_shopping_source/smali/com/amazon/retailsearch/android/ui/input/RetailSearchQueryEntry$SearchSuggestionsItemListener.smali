.class public Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;
.super Ljava/lang/Object;
.source "RetailSearchQueryEntry.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchSuggestionsItemListener"
.end annotation


# instance fields
.field private autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

.field private entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

.field private filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

.field searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

.field private suggestionDataProvider:Lcom/amazon/retailsearch/data/SuggestionDataProvider;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;Lcom/amazon/retailsearch/data/SuggestionDataProvider;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;)V
    .locals 1
    .param p1, "autoCompleteTextView"    # Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    .param p2, "suggestionDataProvider"    # Lcom/amazon/retailsearch/data/SuggestionDataProvider;
    .param p3, "entryContext"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    .prologue
    .line 387
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 379
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getSearchBoxLogger()Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    .line 388
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 389
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    .line 390
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->suggestionDataProvider:Lcom/amazon/retailsearch/data/SuggestionDataProvider;

    .line 391
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    .line 392
    return-void
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;)Lcom/amazon/retailsearch/data/SuggestionDataProvider;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    .prologue
    .line 377
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->suggestionDataProvider:Lcom/amazon/retailsearch/data/SuggestionDataProvider;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;)Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    .prologue
    .line 377
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;)Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    .prologue
    .line 377
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    .prologue
    .line 377
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    return-object v0
.end method


# virtual methods
.method public onA9SuggestionShow()V
    .locals 3

    .prologue
    .line 435
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    monitor-enter v1

    .line 437
    :try_start_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isISSLatencyLogged()Z

    move-result v0

    if-nez v0, :cond_0

    .line 439
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;->searchSuggestionsFirstEntryShowed()V

    .line 440
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->setISSLatencyLogged(Z)V

    .line 442
    :cond_0
    monitor-exit v1

    .line 443
    return-void

    .line 442
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onDeletePastSearchesClick(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "deleteURL"    # Ljava/lang/String;

    .prologue
    .line 417
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener$1;-><init>(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 430
    return-void
.end method

.method public onQueryBuilderClick(Ljava/lang/String;)V
    .locals 3
    .param p1, "suggestionText"    # Ljava/lang/String;

    .prologue
    .line 405
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 408
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 409
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setSelection(I)V

    .line 411
    :cond_0
    return-void
.end method

.method public setFilter(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;)V
    .locals 0
    .param p1, "filter"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    .prologue
    .line 399
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    .line 400
    return-void
.end method
