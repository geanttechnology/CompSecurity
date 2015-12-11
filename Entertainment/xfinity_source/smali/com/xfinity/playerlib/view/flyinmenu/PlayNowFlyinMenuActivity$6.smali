.class Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;
.super Ljava/lang/Object;
.source "PlayNowFlyinMenuActivity.java"

# interfaces
.implements Landroid/view/MenuItem$OnActionExpandListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 242
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onMenuItemActionCollapse(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 274
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->exitSearchMode()V

    .line 275
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    const/4 v1, 0x0

    # setter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->optionsMenuWasInvalidatedAfterSearchExpansion:Z
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$402(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;Z)Z

    .line 276
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchResultsFragment:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->onMenuItemActionCollapse(Landroid/view/MenuItem;)Z

    .line 280
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    # getter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$500(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6$2;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6$2;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 286
    sget v0, Lcom/xfinity/playerlib/R$string;->search:I

    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    .line 287
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->stopSpeaking()V

    .line 288
    const/4 v0, 0x1

    return v0
.end method

.method public onMenuItemActionExpand(Landroid/view/MenuItem;)Z
    .locals 5
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 246
    iget-object v3, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    # getter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$100(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 247
    new-instance v0, Landroid/content/Intent;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    const-class v4, Lcom/xfinity/playerlib/view/search/SearchActivity;

    invoke-direct {v0, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 248
    .local v0, "intent":Landroid/content/Intent;
    const-string v3, "KEY_SHOW_KEYBOARD_ON_START"

    invoke-virtual {v0, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 249
    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-virtual {v2, v0, v1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 269
    .end local v0    # "intent":Landroid/content/Intent;
    :goto_0
    return v1

    .line 253
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    # getter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->optionsMenuWasInvalidatedAfterSearchExpansion:Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$400(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 254
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    # setter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->optionsMenuWasInvalidatedAfterSearchExpansion:Z
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$402(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;Z)Z

    .line 260
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    # getter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$500(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Landroid/os/Handler;

    move-result-object v1

    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6$1;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6$1;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;)V

    invoke-virtual {v1, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 267
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->enterSearchMode()V

    .line 268
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchResultsFragment:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-virtual {v1, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->onMenuItemActionExpand(Landroid/view/MenuItem;)Z

    move v1, v2

    .line 269
    goto :goto_0
.end method
