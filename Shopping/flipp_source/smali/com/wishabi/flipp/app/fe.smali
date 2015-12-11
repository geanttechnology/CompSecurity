.class final Lcom/wishabi/flipp/app/fe;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/PopupMenu$OnMenuItemClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ShoppingListFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V
    .locals 0

    .prologue
    .line 327
    iput-object p1, p0, Lcom/wishabi/flipp/app/fe;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 331
    iget-object v0, p0, Lcom/wishabi/flipp/app/fe;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Lcom/wishabi/flipp/app/ShoppingListFragment;Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method
