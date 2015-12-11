.class public final Lcom/wishabi/flipp/content/aw;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/dj;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/content/as;


# direct methods
.method protected constructor <init>(Lcom/wishabi/flipp/content/as;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/wishabi/flipp/widget/db;)V
    .locals 4

    .prologue
    .line 57
    iget-object v0, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/db;->getLongTag()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/content/ShoppingList;->b(J)Lcom/wishabi/flipp/content/az;

    move-result-object v0

    .line 59
    iget-object v1, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v1, v1, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 63
    :cond_0
    :goto_0
    return-void

    .line 62
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v1, v1, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    invoke-interface {v1, v0}, Lcom/wishabi/flipp/content/ay;->a(Lcom/wishabi/flipp/content/az;)V

    goto :goto_0
.end method

.method public final a(Lcom/wishabi/flipp/widget/db;Z)V
    .locals 4

    .prologue
    .line 47
    iget-object v0, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/db;->getLongTag()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/content/ShoppingList;->b(J)Lcom/wishabi/flipp/content/az;

    move-result-object v0

    .line 49
    iget-object v1, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v1, v1, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 53
    :cond_0
    :goto_0
    return-void

    .line 52
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v1, v1, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    invoke-interface {v1, p1, v0, p2}, Lcom/wishabi/flipp/content/ay;->a(Lcom/wishabi/flipp/widget/db;Lcom/wishabi/flipp/content/az;Z)V

    goto :goto_0
.end method

.method public final b(Lcom/wishabi/flipp/widget/db;)V
    .locals 4

    .prologue
    .line 67
    iget-object v0, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/db;->getLongTag()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/content/ShoppingList;->b(J)Lcom/wishabi/flipp/content/az;

    move-result-object v0

    .line 69
    iget-object v1, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v1, v1, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 73
    :cond_0
    :goto_0
    return-void

    .line 72
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    invoke-interface {v0, p1}, Lcom/wishabi/flipp/content/ay;->a(Lcom/wishabi/flipp/widget/db;)V

    goto :goto_0
.end method

.method public final c(Lcom/wishabi/flipp/widget/db;)V
    .locals 4

    .prologue
    .line 77
    iget-object v0, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/db;->getLongTag()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/content/ShoppingList;->b(J)Lcom/wishabi/flipp/content/az;

    move-result-object v0

    .line 79
    iget-object v1, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v1, v1, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 83
    :cond_0
    :goto_0
    return-void

    .line 82
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/content/aw;->a:Lcom/wishabi/flipp/content/as;

    iget-object v1, v1, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    invoke-interface {v1, v0}, Lcom/wishabi/flipp/content/ay;->c(Lcom/wishabi/flipp/content/az;)V

    goto :goto_0
.end method

.method public final d(Lcom/wishabi/flipp/widget/db;)V
    .locals 1

    .prologue
    .line 87
    sget v0, Lcom/wishabi/flipp/widget/dk;->a:I

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/db;->setState$282bce2c(I)V

    .line 88
    return-void
.end method
