.class Lcom/xfinity/playerlib/view/search/SearchActivity$1;
.super Ljava/lang/Object;
.source "SearchActivity.java"

# interfaces
.implements Landroid/view/MenuItem$OnActionExpandListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/search/SearchActivity;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onMenuItemActionCollapse(Landroid/view/MenuItem;)Z
    .locals 3
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchActivity;->inputMethodManager:Landroid/view/inputmethod/InputMethodManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->access$100(Lcom/xfinity/playerlib/view/search/SearchActivity;)Landroid/view/inputmethod/InputMethodManager;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchActivity;->searchEditText:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchActivity;->access$400(Lcom/xfinity/playerlib/view/search/SearchActivity;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 66
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchActivity;->getSearchResultsFragment()Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->access$300(Lcom/xfinity/playerlib/view/search/SearchActivity;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->onMenuItemActionCollapse(Landroid/view/MenuItem;)Z

    .line 67
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/search/SearchActivity;->setResult(I)V

    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->finish()V

    .line 69
    const/4 v0, 0x1

    return v0
.end method

.method public onMenuItemActionExpand(Landroid/view/MenuItem;)Z
    .locals 6
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 45
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 47
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "KEY_SHOW_KEYBOARD_ON_START"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 49
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchActivity;->access$200(Lcom/xfinity/playerlib/view/search/SearchActivity;)Landroid/os/Handler;

    move-result-object v1

    new-instance v2, Lcom/xfinity/playerlib/view/search/SearchActivity$1$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/search/SearchActivity$1$1;-><init>(Lcom/xfinity/playerlib/view/search/SearchActivity$1;)V

    const-wide/16 v4, 0xc8

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 59
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchActivity;->getSearchResultsFragment()Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchActivity;->access$300(Lcom/xfinity/playerlib/view/search/SearchActivity;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->onMenuItemActionExpand(Landroid/view/MenuItem;)Z

    .line 60
    const/4 v1, 0x1

    return v1
.end method
