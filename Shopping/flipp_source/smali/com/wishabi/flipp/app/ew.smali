.class final Lcom/wishabi/flipp/app/ew;
.super Lcom/wishabi/flipp/b/as;
.source "SourceFile"


# instance fields
.field final synthetic a:J

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Lcom/wishabi/flipp/app/ShoppingListFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ShoppingListFragment;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;JLjava/lang/String;)V
    .locals 1

    .prologue
    .line 518
    iput-object p1, p0, Lcom/wishabi/flipp/app/ew;->c:Lcom/wishabi/flipp/app/ShoppingListFragment;

    iput-wide p5, p0, Lcom/wishabi/flipp/app/ew;->a:J

    iput-object p7, p0, Lcom/wishabi/flipp/app/ew;->b:Ljava/lang/String;

    invoke-direct {p0, p2, p3, p4}, Lcom/wishabi/flipp/b/as;-><init>(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected final a(Lcom/wishabi/flipp/content/SimpleSearchResult;)V
    .locals 6

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 521
    iget-object v0, p0, Lcom/wishabi/flipp/app/ew;->c:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->j(Lcom/wishabi/flipp/app/ShoppingListFragment;)Ljava/util/HashMap;

    move-result-object v0

    iget-wide v2, p0, Lcom/wishabi/flipp/app/ew;->a:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 523
    iget-object v0, p0, Lcom/wishabi/flipp/app/ew;->c:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ew;->c:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/ShoppingList;

    move-result-object v0

    if-nez v0, :cond_1

    .line 539
    :cond_0
    :goto_0
    return-void

    .line 526
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/32 v2, 0x36ee80

    add-long/2addr v0, v2

    iput-wide v0, p1, Lcom/wishabi/flipp/content/SimpleSearchResult;->c:J

    .line 529
    iget-object v0, p1, Lcom/wishabi/flipp/content/SimpleSearchResult;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 530
    sget-object v2, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ew;->b:Ljava/lang/String;

    if-eqz v1, :cond_4

    const-string v0, " "

    const/4 v3, 0x2

    invoke-virtual {v1, v0, v3}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    array-length v3, v0

    if-le v3, v4, :cond_4

    aget-object v3, v0, v5

    invoke-static {v3}, Lcom/wishabi/flipp/util/q;->b(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    aget-object v0, v0, v4

    :goto_1
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    const-string v4, "q_raw"

    invoke-virtual {v3, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "q"

    invoke-virtual {v3, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "hits"

    const-string v4, "0"

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "count"

    invoke-virtual {v2, v1, v3, v5}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    const-string v1, "count"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "count | "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x0

    const-wide/16 v4, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v1, v0, v3, v4}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V

    .line 534
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/ew;->c:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->c(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/app/ff;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p1, Lcom/wishabi/flipp/content/SimpleSearchResult;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p1, Lcom/wishabi/flipp/content/SimpleSearchResult;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_3

    .line 536
    iget-object v0, p1, Lcom/wishabi/flipp/content/SimpleSearchResult;->b:Ljava/util/ArrayList;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 538
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/ew;->c:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/ShoppingList;

    move-result-object v0

    iget-wide v2, p0, Lcom/wishabi/flipp/app/ew;->a:J

    invoke-virtual {v0, v2, v3, p1}, Lcom/wishabi/flipp/content/ShoppingList;->a(JLcom/wishabi/flipp/content/SimpleSearchResult;)V

    goto/16 :goto_0

    :cond_4
    move-object v0, v1

    goto :goto_1
.end method

.method protected final onCancelled()V
    .locals 6

    .prologue
    .line 543
    iget-object v0, p0, Lcom/wishabi/flipp/app/ew;->c:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->j(Lcom/wishabi/flipp/app/ShoppingListFragment;)Ljava/util/HashMap;

    move-result-object v0

    iget-wide v2, p0, Lcom/wishabi/flipp/app/ew;->a:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 545
    iget-boolean v0, p0, Lcom/wishabi/flipp/b/as;->d:Z

    if-nez v0, :cond_0

    .line 555
    :goto_0
    return-void

    .line 550
    :cond_0
    invoke-static {}, Lcom/wishabi/flipp/content/SimpleSearchResult;->a()Lcom/wishabi/flipp/content/SimpleSearchResult;

    move-result-object v0

    .line 551
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/32 v4, 0xea60

    add-long/2addr v2, v4

    iput-wide v2, v0, Lcom/wishabi/flipp/content/SimpleSearchResult;->c:J

    .line 554
    iget-object v1, p0, Lcom/wishabi/flipp/app/ew;->c:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/ShoppingList;

    move-result-object v1

    iget-wide v2, p0, Lcom/wishabi/flipp/app/ew;->a:J

    invoke-virtual {v1, v2, v3, v0}, Lcom/wishabi/flipp/content/ShoppingList;->a(JLcom/wishabi/flipp/content/SimpleSearchResult;)V

    goto :goto_0
.end method

.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 518
    check-cast p1, Lcom/wishabi/flipp/content/SimpleSearchResult;

    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/app/ew;->a(Lcom/wishabi/flipp/content/SimpleSearchResult;)V

    return-void
.end method
