.class Lcom/xfinity/playerlib/view/search/SearchActivity$1$1;
.super Ljava/lang/Object;
.source "SearchActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchActivity$1;->onMenuItemActionExpand(Landroid/view/MenuItem;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/search/SearchActivity$1;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchActivity$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/search/SearchActivity$1;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1$1;->this$1:Lcom/xfinity/playerlib/view/search/SearchActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1$1;->this$1:Lcom/xfinity/playerlib/view/search/SearchActivity$1;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchActivity;->loadSearchTermsIfAvail()Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->access$000(Lcom/xfinity/playerlib/view/search/SearchActivity;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$1$1;->this$1:Lcom/xfinity/playerlib/view/search/SearchActivity$1;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchActivity$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchActivity;->inputMethodManager:Landroid/view/inputmethod/InputMethodManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->access$100(Lcom/xfinity/playerlib/view/search/SearchActivity;)Landroid/view/inputmethod/InputMethodManager;

    move-result-object v0

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    .line 55
    :cond_0
    return-void
.end method
