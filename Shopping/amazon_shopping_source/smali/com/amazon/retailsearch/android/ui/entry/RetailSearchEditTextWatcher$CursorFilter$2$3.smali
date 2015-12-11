.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$3;
.super Ljava/lang/Object;
.source "RetailSearchEditTextWatcher.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;)V
    .locals 0

    .prologue
    .line 548
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$3;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
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
    .line 553
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$3;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$3;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->val$cursor:Landroid/database/Cursor;

    invoke-virtual {v0, v1, p3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->processSuggestionItemClick(Landroid/database/Cursor;I)V

    .line 554
    return-void
.end method
