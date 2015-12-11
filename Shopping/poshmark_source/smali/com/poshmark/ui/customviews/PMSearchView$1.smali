.class Lcom/poshmark/ui/customviews/PMSearchView$1;
.super Ljava/lang/Object;
.source "PMSearchView.java"

# interfaces
.implements Landroid/widget/FilterQueryProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/PMSearchView;->updateAutoCompleteView()V
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
    .line 82
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

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

    .line 86
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iget-object v4, v4, Lcom/poshmark/ui/customviews/PMSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v4}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v2

    .line 87
    .local v2, "oldCursor":Landroid/database/Cursor;
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMSearchView;->getQuery()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 88
    .local v0, "enteredText":Ljava/lang/String;
    if-eqz v0, :cond_3

    .line 89
    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 90
    .local v1, "newText":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_0

    .line 92
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iput-object v1, v4, Lcom/poshmark/ui/customviews/PMSearchView;->currentSearchString:Ljava/lang/String;

    .line 93
    new-instance v3, Lcom/poshmark/utils/PMSearchBoxTimer;

    const/16 v4, 0x32

    new-instance v5, Lcom/poshmark/ui/customviews/PMSearchView$1$1;

    invoke-direct {v5, p0, v1}, Lcom/poshmark/ui/customviews/PMSearchView$1$1;-><init>(Lcom/poshmark/ui/customviews/PMSearchView$1;Ljava/lang/String;)V

    invoke-direct {v3, v4, v6, v1, v5}, Lcom/poshmark/utils/PMSearchBoxTimer;-><init>(IZLjava/lang/String;Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;)V

    .local v3, "timer":Lcom/poshmark/utils/PMSearchBoxTimer;
    move-object v4, v2

    .line 123
    .end local v1    # "newText":Ljava/lang/String;
    .end local v3    # "timer":Lcom/poshmark/utils/PMSearchBoxTimer;
    :goto_0
    return-object v4

    .line 103
    .restart local v1    # "newText":Ljava/lang/String;
    :cond_0
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iget-boolean v4, v4, Lcom/poshmark/ui/customviews/PMSearchView;->bShowRecentsByDefault:Z

    if-eqz v4, :cond_1

    .line 104
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iget-object v4, v4, Lcom/poshmark/ui/customviews/PMSearchView;->suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->fillCursorWithRecents()Landroid/database/Cursor;

    move-result-object v4

    goto :goto_0

    .line 106
    :cond_1
    if-eqz v2, :cond_2

    .line 107
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 110
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

    .line 111
    goto :goto_0

    .line 115
    .end local v1    # "newText":Ljava/lang/String;
    :cond_3
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iget-boolean v4, v4, Lcom/poshmark/ui/customviews/PMSearchView;->bShowRecentsByDefault:Z

    if-eqz v4, :cond_4

    .line 116
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iget-object v4, v4, Lcom/poshmark/ui/customviews/PMSearchView;->suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->fillCursorWithRecents()Landroid/database/Cursor;

    move-result-object v4

    goto :goto_0

    .line 118
    :cond_4
    if-eqz v2, :cond_5

    .line 119
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 122
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

    .line 123
    goto :goto_0
.end method
