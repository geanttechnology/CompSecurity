.class final Lcom/wishabi/flipp/content/au;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/db;

.field final synthetic b:Lcom/wishabi/flipp/content/as;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/content/as;Lcom/wishabi/flipp/widget/db;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/wishabi/flipp/content/au;->b:Lcom/wishabi/flipp/content/as;

    iput-object p2, p0, Lcom/wishabi/flipp/content/au;->a:Lcom/wishabi/flipp/widget/db;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onFocusChange(Landroid/view/View;Z)V
    .locals 6

    .prologue
    .line 152
    if-eqz p2, :cond_0

    .line 153
    iget-object v0, p0, Lcom/wishabi/flipp/content/au;->a:Lcom/wishabi/flipp/widget/db;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/db;->setSubmitted(Z)V

    .line 155
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/content/au;->b:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    if-eqz v0, :cond_1

    .line 156
    iget-object v0, p0, Lcom/wishabi/flipp/content/au;->b:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    iget-object v1, p0, Lcom/wishabi/flipp/content/au;->a:Lcom/wishabi/flipp/widget/db;

    iget-object v2, p0, Lcom/wishabi/flipp/content/au;->b:Lcom/wishabi/flipp/content/as;

    iget-object v2, v2, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    iget-object v3, p0, Lcom/wishabi/flipp/content/au;->a:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/db;->getLongTag()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/wishabi/flipp/content/ShoppingList;->b(J)Lcom/wishabi/flipp/content/az;

    move-result-object v2

    invoke-interface {v0, v1, v2, p2}, Lcom/wishabi/flipp/content/ay;->b(Lcom/wishabi/flipp/widget/db;Lcom/wishabi/flipp/content/az;Z)V

    .line 159
    :cond_1
    return-void
.end method
