.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;
.super Ljava/lang/Object;
.source "RetailSearchEditTextWatcher.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;)V
    .locals 0

    .prologue
    .line 481
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onA9SuggestionShow()V
    .locals 3

    .prologue
    .line 515
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mISSLatencyLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$800(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 517
    :try_start_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isISSLatencyLogged:Z
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$900(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 519
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$600(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;->searchSuggestionsFirstEntryShowed()V

    .line 520
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    const/4 v2, 0x1

    # setter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isISSLatencyLogged:Z
    invoke-static {v0, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$902(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Z)Z

    .line 522
    :cond_0
    monitor-exit v1

    .line 523
    return-void

    .line 522
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
    .line 497
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1$1;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 509
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$600(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;->recordRecentSearchCleared()V

    .line 510
    return-void
.end method

.method public onQueryBuilderClick(Ljava/lang/String;)V
    .locals 3
    .param p1, "suggestionText"    # Ljava/lang/String;

    .prologue
    .line 485
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 487
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setText(Ljava/lang/CharSequence;)V

    .line 488
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setSelection(I)V

    .line 489
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$600(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;->recordQueryBuilderUsage()V

    .line 491
    :cond_0
    return-void
.end method
