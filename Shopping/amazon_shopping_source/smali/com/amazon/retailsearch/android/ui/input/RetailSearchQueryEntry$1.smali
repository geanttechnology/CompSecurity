.class Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$1;
.super Ljava/lang/Object;
.source "RetailSearchQueryEntry.java"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


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
    .line 158
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 8
    .param p1, "view"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v5, 0x0

    .line 164
    const/4 v6, 0x3

    if-eq p2, v6, :cond_0

    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v6

    const/16 v7, 0x42

    if-ne v6, v7, :cond_1

    .line 167
    :cond_0
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v6}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$000(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v6

    if-nez v6, :cond_2

    .line 193
    :cond_1
    :goto_0
    return v5

    .line 171
    :cond_2
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v6}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$000(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 172
    .local v1, "keywords":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 178
    const-string/jumbo v6, "^(\\*|\\s)*$"

    invoke-virtual {v1, v6}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 180
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v6}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$000(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v6

    const-string/jumbo v7, ""

    invoke-virtual {v6, v7}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 183
    :cond_3
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v5}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$000(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 184
    .local v4, "typedQueryText":Ljava/lang/String;
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mQueryListeners:Ljava/util/Set;
    invoke-static {v5}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->access$100(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    .line 186
    .local v2, "listener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    new-instance v3, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-direct {v3, v4}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;)V

    .line 187
    .local v3, "query":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    invoke-virtual {v3, v4}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->setRawUserInput(Ljava/lang/String;)V

    .line 188
    sget-object v5, Lcom/amazon/retailsearch/android/api/query/QuerySource;->NAV_BAR_INPUT:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    invoke-virtual {v3, v5}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->setSource(Lcom/amazon/retailsearch/android/api/query/QuerySource;)V

    .line 189
    invoke-interface {v2, v3}, Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;->onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/Query;)V

    goto :goto_1

    .line 191
    .end local v2    # "listener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    .end local v3    # "query":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    :cond_4
    const/4 v5, 0x1

    goto :goto_0
.end method
