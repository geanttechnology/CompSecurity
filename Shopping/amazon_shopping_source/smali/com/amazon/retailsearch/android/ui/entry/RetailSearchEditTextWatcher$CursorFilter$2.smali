.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;
.super Ljava/lang/Object;
.source "RetailSearchEditTextWatcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

.field final synthetic val$cursor:Landroid/database/Cursor;

.field final synthetic val$hideSpinner:Z

.field final synthetic val$searchTerm:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;ZLandroid/database/Cursor;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 443
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iput-boolean p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$hideSpinner:Z

    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$cursor:Landroid/database/Cursor;

    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$searchTerm:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const/4 v3, 0x0

    const/4 v8, 0x0

    .line 449
    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$hideSpinner:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$200(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 451
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$200(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v1, v3, v3}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 452
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    # invokes: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->getSearchMagnifierImage()Landroid/graphics/drawable/Drawable;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->access$300(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2, v8, v8, v8}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 463
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$cursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 466
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$cursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_1

    .line 468
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 469
    .local v7, "text":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$searchTerm:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 471
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$searchTerm:Ljava/lang/String;

    invoke-virtual {v7, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$searchTerm:Ljava/lang/String;

    invoke-virtual {v1, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 556
    .end local v7    # "text":Ljava/lang/String;
    :goto_0
    return-void

    .line 478
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$cursor:Landroid/database/Cursor;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$searchTerm:Ljava/lang/String;

    new-instance v5, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;

    invoke-direct {v5, p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;)V

    new-instance v6, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$2;

    invoke-direct {v6, p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$2;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;)V

    invoke-direct/range {v0 .. v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;ZLjava/lang/String;Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V

    .line 540
    .local v0, "adapter":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mCursor:Landroid/database/Cursor;

    if-eqz v1, :cond_2

    .line 542
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 543
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iput-object v8, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mCursor:Landroid/database/Cursor;

    .line 545
    :cond_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$cursor:Landroid/database/Cursor;

    iput-object v2, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mCursor:Landroid/database/Cursor;

    .line 546
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSuggstionsListView:Landroid/widget/ListView;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$1100(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/widget/ListView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 547
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSuggstionsListView:Landroid/widget/ListView;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$1100(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/widget/ListView;

    move-result-object v1

    new-instance v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$3;

    invoke-direct {v2, p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$3;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;)V

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    goto :goto_0
.end method
