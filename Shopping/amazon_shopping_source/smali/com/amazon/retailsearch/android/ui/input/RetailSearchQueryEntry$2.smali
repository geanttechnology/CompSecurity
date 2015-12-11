.class Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;
.super Ljava/lang/Object;
.source "RetailSearchQueryEntry.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setUpAutoComplete()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)V
    .locals 0

    .prologue
    .line 198
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 11
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 201
    .local p1, "listView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;

    .line 203
    .local v9, "row":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mQueryListeners:Ljava/util/Set;
    invoke-static {v10}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$100(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Ljava/util/Set;

    move-result-object v10

    if-eqz v10, :cond_1

    .line 205
    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getIntentData()Ljava/lang/String;

    move-result-object v2

    .line 206
    .local v2, "intentData":Ljava/lang/String;
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v10

    invoke-virtual {v10}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v10

    invoke-virtual {v10}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    .line 207
    .local v3, "intentUri":Landroid/net/Uri;
    const-string/jumbo v10, "paramText"

    invoke-virtual {v3, v10}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 208
    .local v5, "keyword":Ljava/lang/String;
    const-string/jumbo v10, "paramSuggestionDepartmentFilter"

    invoke-virtual {v3, v10}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 209
    .local v0, "department":Ljava/lang/String;
    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v10}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$000(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v10

    if-nez v10, :cond_0

    const-string/jumbo v8, ""

    .line 210
    .local v8, "rawUserInput":Ljava/lang/String;
    :goto_0
    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v10}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$000(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v10

    invoke-virtual {v10, v5}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 211
    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;
    invoke-static {v10}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$200(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->getSearchAlias()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10, v0, v5, v8}, Lcom/amazon/retailsearch/metrics/IssLogger;->createLogData(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v4

    .line 213
    .local v4, "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v7, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-direct {v7, v0, v5, v8, v4}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 214
    .local v7, "query":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mQueryListeners:Ljava/util/Set;
    invoke-static {v10}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$100(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Ljava/util/Set;

    move-result-object v10

    invoke-interface {v10}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    .line 216
    .local v6, "listener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    invoke-interface {v6, v7}, Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;->onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/Query;)V

    goto :goto_1

    .line 209
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v6    # "listener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    .end local v7    # "query":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    .end local v8    # "rawUserInput":Ljava/lang/String;
    :cond_0
    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v10}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$000(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    goto :goto_0

    .line 219
    .end local v0    # "department":Ljava/lang/String;
    .end local v2    # "intentData":Ljava/lang/String;
    .end local v3    # "intentUri":Landroid/net/Uri;
    .end local v5    # "keyword":Ljava/lang/String;
    :cond_1
    return-void
.end method
