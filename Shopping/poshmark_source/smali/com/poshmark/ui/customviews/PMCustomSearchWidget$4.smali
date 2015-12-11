.class Lcom/poshmark/ui/customviews/PMCustomSearchWidget$4;
.super Ljava/lang/Object;
.source "PMCustomSearchWidget.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setup()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$4;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
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
    .line 112
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$4;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v3, v3, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 113
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-virtual {v0, p3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->moveToPosition(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 114
    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 115
    .local v1, "idCol":I
    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    .line 116
    .local v2, "suggestionItem":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$4;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v3, v3, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setText(Ljava/lang/CharSequence;)V

    .line 117
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$4;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v4}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->launchSearch(Lcom/poshmark/data_model/models/SuggestedSearchItem;Z)V

    .line 119
    .end local v1    # "idCol":I
    .end local v2    # "suggestionItem":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    :cond_0
    return-void
.end method
