.class Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;
.super Ljava/lang/Object;
.source "MultiDeleteActionFragment.java"

# interfaces
.implements Landroid/view/ActionMode$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 49
    invoke-interface {p2}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    sget v1, Lcom/xfinity/playerlib/R$id;->delete:I

    if-ne v0, v1, :cond_0

    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->deleteItems()V

    .line 51
    invoke-virtual {p1}, Landroid/view/ActionMode;->finish()V

    .line 52
    const/4 v0, 0x1

    .line 55
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 6
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v5, 0x1

    .line 27
    iget-object v2, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    invoke-virtual {v2, v5}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->setEditMode(Z)V

    .line 28
    iget-object v2, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    .line 29
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ActionBar;->getThemedContext()Landroid/content/Context;

    move-result-object v2

    .line 28
    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$layout;->action_mode_custom:I

    const/4 v4, 0x0

    .line 29
    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 31
    .local v0, "customView":Landroid/view/View;
    invoke-virtual {p1, v0}, Landroid/view/ActionMode;->setCustomView(Landroid/view/View;)V

    .line 32
    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    sget v2, Lcom/xfinity/playerlib/R$id;->counter:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v3, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->counterField:Landroid/widget/TextView;

    .line 34
    invoke-virtual {p1}, Landroid/view/ActionMode;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v1

    .line 35
    .local v1, "menuInflater":Landroid/view/MenuInflater;
    sget v2, Lcom/xfinity/playerlib/R$menu;->context_menu:I

    invoke-virtual {v1, v2, p2}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 37
    iget-object v2, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->showSelectedCountOnActionMenu()V

    .line 39
    return v5
.end method

.method public onDestroyActionMode(Landroid/view/ActionMode;)V
    .locals 2
    .param p1, "mode"    # Landroid/view/ActionMode;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->actionMode:Landroid/view/ActionMode;

    if-ne p1, v0, :cond_0

    .line 62
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->setEditMode(Z)V

    .line 64
    :cond_0
    return-void
.end method

.method public onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 44
    const/4 v0, 0x0

    return v0
.end method
