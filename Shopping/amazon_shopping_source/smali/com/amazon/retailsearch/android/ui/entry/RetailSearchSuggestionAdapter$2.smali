.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$2;
.super Ljava/lang/Object;
.source "RetailSearchSuggestionAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->updateSuggestionItemView(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;Landroid/widget/LinearLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

.field final synthetic val$searchSuggestion:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 223
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$2;->val$searchSuggestion:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 227
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->access$000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;)Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->access$000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;)Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$2;->val$searchSuggestion:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;->onQueryBuilderClick(Ljava/lang/String;)V

    .line 231
    :cond_0
    return-void
.end method
