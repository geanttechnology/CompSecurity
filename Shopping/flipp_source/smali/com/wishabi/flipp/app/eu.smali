.class final Lcom/wishabi/flipp/app/eu;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ShoppingListFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V
    .locals 0

    .prologue
    .line 335
    iput-object p1, p0, Lcom/wishabi/flipp/app/eu;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 338
    iget-object v0, p0, Lcom/wishabi/flipp/app/eu;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    iget-object v1, p0, Lcom/wishabi/flipp/app/eu;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->h(Lcom/wishabi/flipp/app/ShoppingListFragment;)Landroid/widget/PopupMenu;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Lcom/wishabi/flipp/app/ShoppingListFragment;Landroid/view/Menu;)V

    .line 339
    iget-object v0, p0, Lcom/wishabi/flipp/app/eu;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->h(Lcom/wishabi/flipp/app/ShoppingListFragment;)Landroid/widget/PopupMenu;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupMenu;->show()V

    .line 340
    return-void
.end method
