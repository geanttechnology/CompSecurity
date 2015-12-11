.class Lcom/poshmark/ui/customviews/PMSearchView$3;
.super Ljava/lang/Object;
.source "PMSearchView.java"

# interfaces
.implements Landroid/widget/SearchView$OnSuggestionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMSearchView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMSearchView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMSearchView;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMSearchView$3;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onSuggestionClick(I)Z
    .locals 6
    .param p1, "i"    # I

    .prologue
    const/4 v5, 0x0

    .line 170
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMSearchView$3;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iget-object v3, v3, Lcom/poshmark/ui/customviews/PMSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v3}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 171
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->moveToPosition(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 172
    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 173
    .local v1, "idCol":I
    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    .line 174
    .local v2, "suggestionItem":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMSearchView$3;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    const/4 v4, 0x0

    invoke-virtual {v3, v4, v5}, Lcom/poshmark/ui/customviews/PMSearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 175
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMSearchView$3;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    invoke-virtual {v3, v2, v5}, Lcom/poshmark/ui/customviews/PMSearchView;->launchSearch(Lcom/poshmark/data_model/models/SuggestedSearchItem;Z)V

    .line 177
    .end local v1    # "idCol":I
    .end local v2    # "suggestionItem":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    :cond_0
    const/4 v3, 0x1

    return v3
.end method

.method public onSuggestionSelect(I)Z
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 165
    const/4 v0, 0x0

    return v0
.end method
