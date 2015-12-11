.class final Lcom/wishabi/flipp/content/av;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/av;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/db;

.field final synthetic b:Lcom/wishabi/flipp/content/as;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/content/as;Lcom/wishabi/flipp/widget/db;)V
    .locals 0

    .prologue
    .line 163
    iput-object p1, p0, Lcom/wishabi/flipp/content/av;->b:Lcom/wishabi/flipp/content/as;

    iput-object p2, p0, Lcom/wishabi/flipp/content/av;->a:Lcom/wishabi/flipp/widget/db;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 4

    .prologue
    .line 166
    iget-object v0, p0, Lcom/wishabi/flipp/content/av;->b:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/wishabi/flipp/content/av;->b:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    iget-object v1, p0, Lcom/wishabi/flipp/content/av;->b:Lcom/wishabi/flipp/content/as;

    iget-object v1, v1, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    iget-object v2, p0, Lcom/wishabi/flipp/content/av;->a:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/db;->getLongTag()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/wishabi/flipp/content/ShoppingList;->b(J)Lcom/wishabi/flipp/content/az;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/content/ay;->d(Lcom/wishabi/flipp/content/az;)V

    .line 169
    :cond_0
    return-void
.end method
