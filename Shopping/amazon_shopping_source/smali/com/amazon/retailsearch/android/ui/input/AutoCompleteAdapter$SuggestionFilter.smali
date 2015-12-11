.class final Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;
.super Landroid/widget/Filter;
.source "AutoCompleteAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "SuggestionFilter"
.end annotation


# instance fields
.field private mLastConstraint:Ljava/lang/CharSequence;

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;->this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    invoke-direct {p0}, Landroid/widget/Filter;-><init>()V

    return-void
.end method


# virtual methods
.method protected performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
    .locals 5
    .param p1, "constraint"    # Ljava/lang/CharSequence;

    .prologue
    .line 113
    new-instance v0, Landroid/widget/Filter$FilterResults;

    invoke-direct {v0}, Landroid/widget/Filter$FilterResults;-><init>()V

    .line 115
    .local v0, "result":Landroid/widget/Filter$FilterResults;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;->this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestionLock:Ljava/lang/Object;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->access$100(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)Ljava/lang/Object;

    move-result-object v3

    monitor-enter v3

    .line 117
    :try_start_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;->this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->access$200(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    move-result-object v2

    if-eqz v2, :cond_0

    if-eqz p1, :cond_0

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;->mLastConstraint:Ljava/lang/CharSequence;

    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 120
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;->this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->access$200(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v4}, Lcom/amazon/retailsearch/data/ISuggestionDataProvider;->getSuggestions(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 122
    .local v1, "suggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    iput-object v1, v0, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 123
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    iput v2, v0, Landroid/widget/Filter$FilterResults;->count:I

    .line 126
    .end local v1    # "suggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    :cond_0
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;->mLastConstraint:Ljava/lang/CharSequence;

    .line 127
    monitor-exit v3

    .line 129
    return-object v0

    .line 127
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V
    .locals 3
    .param p1, "constraint"    # Ljava/lang/CharSequence;
    .param p2, "results"    # Landroid/widget/Filter$FilterResults;

    .prologue
    .line 138
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;->this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestions:Ljava/util/List;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->access$300(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 140
    iget v2, p2, Landroid/widget/Filter$FilterResults;->count:I

    if-lez v2, :cond_0

    .line 142
    iget-object v2, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    check-cast v2, Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    .line 144
    .local v1, "s":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;->this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestions:Ljava/util/List;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->access$300(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 148
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "s":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;->this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->notifyDataSetChanged()V

    .line 149
    return-void
.end method
