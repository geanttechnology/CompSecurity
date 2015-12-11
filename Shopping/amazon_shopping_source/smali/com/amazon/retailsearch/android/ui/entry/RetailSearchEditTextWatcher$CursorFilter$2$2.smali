.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$2;
.super Ljava/lang/Object;
.source "RetailSearchEditTextWatcher.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
        "<",
        "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;)V
    .locals 0

    .prologue
    .line 526
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$2;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/Query;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/api/query/Query;

    .prologue
    .line 526
    check-cast p1, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .end local p1    # "x0":Lcom/amazon/retailsearch/android/api/query/Query;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$2;->onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)V

    return-void
.end method

.method public onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)V
    .locals 1
    .param p1, "query"    # Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .prologue
    .line 530
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$2;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$1000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 534
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$2;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/UIUtils;->closeSoftKeyboard(Landroid/view/View;)V

    .line 535
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$2;->this$2:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$1000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;->onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/Query;)V

    .line 537
    :cond_0
    return-void
.end method
