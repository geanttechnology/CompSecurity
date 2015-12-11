.class final Lcom/wishabi/flipp/app/et;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ShoppingListFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/wishabi/flipp/app/et;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 150
    const-string v0, "postal_code"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 162
    :cond_0
    :goto_0
    return-void

    .line 153
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/et;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    iget-object v1, p0, Lcom/wishabi/flipp/app/et;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Lcom/wishabi/flipp/app/ShoppingListFragment;)Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "postal_code"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Lcom/wishabi/flipp/app/ShoppingListFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 154
    iget-object v0, p0, Lcom/wishabi/flipp/app/et;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/ShoppingList;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 155
    iget-object v0, p0, Lcom/wishabi/flipp/app/et;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/ShoppingList;

    move-result-object v0

    const-wide/16 v2, -0x1

    iput-wide v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    .line 157
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/et;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/ShoppingList;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 158
    iget-object v0, p0, Lcom/wishabi/flipp/app/et;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/ShoppingList;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ShoppingList;->c()V

    .line 160
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/et;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->c(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/app/ff;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 161
    iget-object v0, p0, Lcom/wishabi/flipp/app/et;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->c(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/app/ff;

    move-result-object v0

    invoke-interface {v0}, Lcom/wishabi/flipp/app/ff;->a()V

    goto :goto_0
.end method
