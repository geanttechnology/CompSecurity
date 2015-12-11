.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showDropDownIfApplicable()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 581
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 584
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 585
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/PopupWindow;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 587
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/PopupWindow;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setInputMethodMode(I)V

    .line 589
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/PopupWindow;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getDesiredPopupWindowWidth()I
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 590
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/PopupWindow;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getDesiredPopupWindowHeight()I
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1900(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 591
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 592
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/PopupWindow;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    if-nez v0, :cond_2

    .line 593
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/PopupWindow;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View;)V

    .line 609
    :cond_1
    :goto_0
    return-void

    .line 605
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/PopupWindow;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/EditText;

    move-result-object v1

    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getDesiredPopupWindowWidth()I
    invoke-static {v3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)I

    move-result v4

    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getDesiredPopupWindowHeight()I
    invoke-static {v3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1900(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)I

    move-result v5

    move v3, v2

    invoke-virtual/range {v0 .. v5}, Landroid/widget/PopupWindow;->update(Landroid/view/View;IIII)V

    goto :goto_0
.end method
