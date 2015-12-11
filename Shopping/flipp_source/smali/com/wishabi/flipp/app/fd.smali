.class final Lcom/wishabi/flipp/app/fd;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/dv;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ShoppingListFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V
    .locals 0

    .prologue
    .line 295
    iput-object p1, p0, Lcom/wishabi/flipp/app/fd;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/widget/TextView;)V
    .locals 4

    .prologue
    .line 298
    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    .line 299
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 315
    :cond_0
    :goto_0
    return-void

    .line 302
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/fd;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/ShoppingList;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/content/ShoppingList;->a(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 303
    if-eqz v0, :cond_0

    .line 306
    invoke-virtual {v0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    .line 307
    iget-object v3, p0, Lcom/wishabi/flipp/app/fd;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    if-eqz v0, :cond_3

    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->d(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    :goto_1
    invoke-static {v3, v0, v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Lcom/wishabi/flipp/app/ShoppingListFragment;J)J

    .line 310
    iget-object v0, p0, Lcom/wishabi/flipp/app/fd;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->c(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/app/ff;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 311
    iget-object v0, p0, Lcom/wishabi/flipp/app/fd;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->c(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/app/ff;

    move-result-object v0

    invoke-interface {v0, v2}, Lcom/wishabi/flipp/app/ff;->a(Ljava/lang/String;)V

    .line 313
    :cond_2
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget v1, Lcom/wishabi/flipp/b/s;->a:I

    const/4 v3, -0x1

    invoke-virtual {v0, v2, v1, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;II)V

    goto :goto_0

    .line 307
    :cond_3
    const-wide/16 v0, -0x1

    goto :goto_1
.end method
