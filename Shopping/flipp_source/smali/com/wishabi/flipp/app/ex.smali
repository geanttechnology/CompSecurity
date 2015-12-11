.class final Lcom/wishabi/flipp/app/ex;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/ActionMode$Callback;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ShoppingListFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V
    .locals 0

    .prologue
    .line 166
    iput-object p1, p0, Lcom/wishabi/flipp/app/ex;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 182
    const/4 v0, 0x0

    return v0
.end method

.method public final onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 169
    iget-object v0, p0, Lcom/wishabi/flipp/app/ex;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->d(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    .line 170
    iget-object v0, p0, Lcom/wishabi/flipp/app/ex;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->e(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/as;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/content/as;->a(Z)V

    .line 171
    iget-object v0, p0, Lcom/wishabi/flipp/app/ex;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->f(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->setEnabled(Z)V

    .line 172
    return v2
.end method

.method public final onDestroyActionMode(Landroid/view/ActionMode;)V
    .locals 2

    .prologue
    .line 187
    iget-object v0, p0, Lcom/wishabi/flipp/app/ex;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->d(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    .line 188
    iget-object v0, p0, Lcom/wishabi/flipp/app/ex;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->e(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/as;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/content/as;->a(Z)V

    .line 189
    iget-object v0, p0, Lcom/wishabi/flipp/app/ex;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->f(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->setEnabled(Z)V

    .line 190
    return-void
.end method

.method public final onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1

    .prologue
    .line 177
    const/4 v0, 0x1

    return v0
.end method
