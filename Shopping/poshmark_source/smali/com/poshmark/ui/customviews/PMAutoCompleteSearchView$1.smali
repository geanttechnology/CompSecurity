.class Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;
.super Ljava/lang/Object;
.source "PMAutoCompleteSearchView.java"

# interfaces
.implements Landroid/widget/FilterQueryProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setup()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runQuery(Ljava/lang/CharSequence;)Landroid/database/Cursor;
    .locals 8
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v5, 0x2

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 104
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iget-object v4, v4, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v4}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v2

    .line 105
    .local v2, "oldCursor":Landroid/database/Cursor;
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 106
    .local v0, "enteredText":Ljava/lang/String;
    if-eqz v0, :cond_3

    .line 107
    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 108
    .local v1, "newText":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_0

    .line 110
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iput-object v1, v4, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->currentSearchString:Ljava/lang/String;

    .line 111
    new-instance v3, Lcom/poshmark/utils/PMSearchBoxTimer;

    const/16 v4, 0x32

    new-instance v5, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1$1;

    invoke-direct {v5, p0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1$1;-><init>(Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;Ljava/lang/String;)V

    invoke-direct {v3, v4, v6, v1, v5}, Lcom/poshmark/utils/PMSearchBoxTimer;-><init>(IZLjava/lang/String;Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;)V

    .local v3, "timer":Lcom/poshmark/utils/PMSearchBoxTimer;
    move-object v4, v2

    .line 141
    .end local v1    # "newText":Ljava/lang/String;
    .end local v3    # "timer":Lcom/poshmark/utils/PMSearchBoxTimer;
    :goto_0
    return-object v4

    .line 121
    .restart local v1    # "newText":Ljava/lang/String;
    :cond_0
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iget-boolean v4, v4, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->bShowRecentsByDefault:Z

    if-eqz v4, :cond_1

    .line 122
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iget-object v4, v4, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->fillCursorWithRecents()Landroid/database/Cursor;

    move-result-object v4

    goto :goto_0

    .line 124
    :cond_1
    if-eqz v2, :cond_2

    .line 125
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 128
    :cond_2
    new-instance v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .end local v2    # "oldCursor":Landroid/database/Cursor;
    new-array v4, v5, [Ljava/lang/String;

    sget-object v5, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v5, v4, v7

    sget-object v5, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v5, v4, v6

    invoke-direct {v2, v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .restart local v2    # "oldCursor":Landroid/database/Cursor;
    move-object v4, v2

    .line 129
    goto :goto_0

    .line 133
    .end local v1    # "newText":Ljava/lang/String;
    :cond_3
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iget-boolean v4, v4, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->bShowRecentsByDefault:Z

    if-eqz v4, :cond_4

    .line 134
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iget-object v4, v4, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->fillCursorWithRecents()Landroid/database/Cursor;

    move-result-object v4

    goto :goto_0

    .line 136
    :cond_4
    if-eqz v2, :cond_5

    .line 137
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 140
    :cond_5
    new-instance v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .end local v2    # "oldCursor":Landroid/database/Cursor;
    new-array v4, v5, [Ljava/lang/String;

    sget-object v5, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v5, v4, v7

    sget-object v5, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v5, v4, v6

    invoke-direct {v2, v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .restart local v2    # "oldCursor":Landroid/database/Cursor;
    move-object v4, v2

    .line 141
    goto :goto_0
.end method
