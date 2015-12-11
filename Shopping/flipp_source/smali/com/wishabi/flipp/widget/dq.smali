.class final Lcom/wishabi/flipp/widget/dq;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field a:Z

.field final synthetic b:Lcom/wishabi/flipp/widget/ShoppingListPopup;


# direct methods
.method public constructor <init>(Lcom/wishabi/flipp/widget/ShoppingListPopup;J)V
    .locals 2

    .prologue
    .line 50
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dq;->b:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/widget/dq;->a:Z

    .line 52
    invoke-virtual {p1, p0, p2, p3}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 53
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 64
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/dq;->a:Z

    if-eqz v0, :cond_1

    .line 75
    :cond_0
    :goto_0
    return-void

    .line 67
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dq;->b:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;)I

    move-result v0

    sget v1, Lcom/wishabi/flipp/widget/ds;->e:I

    if-ne v0, v1, :cond_2

    .line 68
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dq;->b:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    sget v1, Lcom/wishabi/flipp/widget/ds;->c:I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;I)I

    .line 70
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dq;->b:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->b(Lcom/wishabi/flipp/widget/ShoppingListPopup;)Lcom/wishabi/flipp/widget/dr;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/dq;->b:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->b(Lcom/wishabi/flipp/widget/ShoppingListPopup;)Lcom/wishabi/flipp/widget/dr;

    move-result-object v0

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/dr;->a()Z

    move-result v0

    if-nez v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dq;->b:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Z)V

    goto :goto_0
.end method
