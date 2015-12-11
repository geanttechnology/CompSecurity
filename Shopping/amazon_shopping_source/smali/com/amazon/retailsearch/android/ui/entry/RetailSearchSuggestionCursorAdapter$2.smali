.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$2;
.super Ljava/lang/Object;
.source "RetailSearchSuggestionCursorAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->updateSuggestionItemView(Landroid/content/Context;Landroid/database/Cursor;Landroid/widget/LinearLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

.field final synthetic val$searchSuggestion:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 200
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$2;->val$searchSuggestion:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->access$000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;)Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 206
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->access$000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;)Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$2;->val$searchSuggestion:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;->onQueryBuilderClick(Ljava/lang/String;)V

    .line 208
    :cond_0
    return-void
.end method
