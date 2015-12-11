.class Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1$1;
.super Ljava/lang/Object;
.source "PMAutoCompleteSearchView.java"

# interfaces
.implements Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->runQuery(Ljava/lang/CharSequence;)Landroid/database/Cursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;

.field final synthetic val$newText:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1$1;->this$1:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;

    iput-object p2, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1$1;->val$newText:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public timerCallback(Ljava/lang/String;)V
    .locals 2
    .param p1, "keyWord"    # Ljava/lang/String;

    .prologue
    .line 114
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1$1;->this$1:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->currentSearchString:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1$1;->this$1:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;->this$0:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1$1;->val$newText:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->fillFilteredCursor(Ljava/lang/CharSequence;)V

    .line 117
    :cond_0
    return-void
.end method
