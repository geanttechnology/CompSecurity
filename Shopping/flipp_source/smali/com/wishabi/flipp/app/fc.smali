.class final Lcom/wishabi/flipp/app/fc;
.super Landroid/support/v7/widget/ax;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ShoppingListFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V
    .locals 0

    .prologue
    .line 261
    iput-object p1, p0, Lcom/wishabi/flipp/app/fc;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-direct {p0}, Landroid/support/v7/widget/ax;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 3

    .prologue
    .line 264
    iget-object v0, p0, Lcom/wishabi/flipp/app/fc;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 265
    iget-object v1, p0, Lcom/wishabi/flipp/app/fc;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->g(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/app/FocusedRecyclerView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->getFocusedChild()Landroid/view/View;

    move-result-object v1

    .line 266
    const/4 v2, 0x1

    if-ne p1, v2, :cond_0

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 274
    :cond_0
    :goto_0
    return-void

    .line 270
    :cond_1
    instance-of v0, v1, Lcom/wishabi/flipp/widget/db;

    if-eqz v0, :cond_2

    .line 271
    iget-object v0, p0, Lcom/wishabi/flipp/app/fc;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->e(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/as;

    move-result-object v0

    invoke-static {v1}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->c(Landroid/view/View;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/content/as;->c(I)V

    .line 273
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/fc;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->d(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    goto :goto_0
.end method
