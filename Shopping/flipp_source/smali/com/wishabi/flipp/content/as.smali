.class public final Lcom/wishabi/flipp/content/as;
.super Landroid/support/v7/widget/an;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/an",
        "<",
        "Lcom/wishabi/flipp/content/ax;",
        ">;"
    }
.end annotation


# instance fields
.field public c:Lcom/wishabi/flipp/content/ay;

.field public final d:Lcom/wishabi/flipp/content/ShoppingList;

.field public e:Z

.field private final f:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/wishabi/flipp/content/ShoppingList;)V
    .locals 2

    .prologue
    .line 113
    invoke-direct {p0}, Landroid/support/v7/widget/an;-><init>()V

    .line 114
    iput-object p1, p0, Lcom/wishabi/flipp/content/as;->f:Landroid/content/Context;

    .line 115
    iput-object p2, p0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    .line 116
    iget-object v0, p0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    invoke-virtual {v0}, Landroid/support/v7/widget/ao;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot change whether this adapter has stable IDs while the adapter has registered observers."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/an;->b:Z

    .line 117
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ShoppingList;->a()I

    move-result v0

    return v0
.end method

.method public final a(I)I
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/content/ShoppingList;->a(I)I

    move-result v0

    return v0
.end method

.method public final synthetic a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/bi;
    .locals 3

    .prologue
    .line 21
    iget-object v0, p0, Lcom/wishabi/flipp/content/as;->f:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    packed-switch p2, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid view type for shopping list"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    new-instance v1, Lcom/wishabi/flipp/widget/db;

    iget-object v0, p0, Lcom/wishabi/flipp/content/as;->f:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/wishabi/flipp/widget/db;-><init>(Landroid/content/Context;)V

    new-instance v0, Lcom/wishabi/flipp/content/aw;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/content/aw;-><init>(Lcom/wishabi/flipp/content/as;)V

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/db;->setListener(Lcom/wishabi/flipp/widget/dj;)V

    const v0, 0x7f0b0121

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/CustomEditText;

    new-instance v2, Lcom/wishabi/flipp/content/at;

    invoke-direct {v2, p0, v1}, Lcom/wishabi/flipp/content/at;-><init>(Lcom/wishabi/flipp/content/as;Lcom/wishabi/flipp/widget/db;)V

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CustomEditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    new-instance v2, Lcom/wishabi/flipp/content/au;

    invoke-direct {v2, p0, v1}, Lcom/wishabi/flipp/content/au;-><init>(Lcom/wishabi/flipp/content/as;Lcom/wishabi/flipp/widget/db;)V

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CustomEditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    new-instance v2, Lcom/wishabi/flipp/content/av;

    invoke-direct {v2, p0, v1}, Lcom/wishabi/flipp/content/av;-><init>(Lcom/wishabi/flipp/content/as;Lcom/wishabi/flipp/widget/db;)V

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CustomEditText;->setKeyboardDimissedListener(Lcom/wishabi/flipp/widget/av;)V

    move-object v0, v1

    :goto_0
    new-instance v1, Lcom/wishabi/flipp/content/ax;

    invoke-direct {v1, v0}, Lcom/wishabi/flipp/content/ax;-><init>(Landroid/view/View;)V

    return-object v1

    :pswitch_1
    const v1, 0x7f03004f

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final synthetic a(Landroid/support/v7/widget/bi;I)V
    .locals 10

    .prologue
    const/4 v0, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 21
    check-cast p1, Lcom/wishabi/flipp/content/ax;

    iget-object v1, p0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v1, p2}, Lcom/wishabi/flipp/content/ShoppingList;->a(I)I

    move-result v1

    packed-switch v1, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid view type for shopping list"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v1, p0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    iget-object v4, v1, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-eqz v4, :cond_0

    iget-object v4, v1, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v4, p2}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v4

    if-nez v4, :cond_1

    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Lcom/wishabi/flipp/content/ShoppingList;->c(J)Lcom/wishabi/flipp/content/SimpleSearchResult;

    move-result-object v4

    if-nez v0, :cond_3

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Shopping list item has no data"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iget-object v1, v1, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, p2}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v4

    if-nez v4, :cond_2

    :goto_1
    check-cast v0, Lcom/wishabi/flipp/content/az;

    goto :goto_0

    :cond_2
    invoke-virtual {v1, p2}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    iget-object v0, v0, Lcom/wishabi/flipp/util/m;->e:Ljava/lang/Object;

    goto :goto_1

    :cond_3
    new-array v1, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v2

    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/db;->getLongTag()J

    move-result-wide v6

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v8

    cmp-long v1, v6, v8

    if-eqz v1, :cond_4

    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/db;->a()V

    :cond_4
    iget-object v1, p0, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    invoke-interface {v1, v0}, Lcom/wishabi/flipp/content/ay;->b(Lcom/wishabi/flipp/content/az;)V

    :cond_5
    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v6

    invoke-virtual {v1, v6, v7}, Lcom/wishabi/flipp/widget/db;->setLongTag(J)V

    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/wishabi/flipp/widget/db;->setName(Ljava/lang/String;)V

    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/az;->c()Z

    move-result v5

    invoke-virtual {v1, v5}, Lcom/wishabi/flipp/widget/db;->setChecked(Z)V

    iget-object v5, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    if-eqz v4, :cond_7

    iget-object v1, v4, Lcom/wishabi/flipp/content/SimpleSearchResult;->a:Ljava/util/ArrayList;

    if-eqz v1, :cond_7

    iget-object v1, v4, Lcom/wishabi/flipp/content/SimpleSearchResult;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    :goto_2
    invoke-virtual {v5, v1}, Lcom/wishabi/flipp/widget/db;->setResultCount(I)V

    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    iget v5, v0, Lcom/wishabi/flipp/content/az;->b:I

    invoke-virtual {v1, v5}, Lcom/wishabi/flipp/widget/db;->setClipCount(I)V

    iget-object v5, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v6

    iget-object v1, p0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    iget-wide v8, v1, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    cmp-long v1, v6, v8

    if-nez v1, :cond_8

    move v1, v3

    :goto_3
    invoke-virtual {v5, v1}, Lcom/wishabi/flipp/widget/db;->setSelected(Z)V

    iget-boolean v1, p0, Lcom/wishabi/flipp/content/as;->e:Z

    if-eqz v1, :cond_9

    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/db;->a()V

    iput-boolean v2, v0, Lcom/wishabi/flipp/content/az;->c:Z

    iget-object v0, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    sget v1, Lcom/wishabi/flipp/widget/dk;->d:I

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/db;->setState$282bce2c(I)V

    :cond_6
    :goto_4
    return-void

    :cond_7
    move v1, v2

    goto :goto_2

    :cond_8
    move v1, v2

    goto :goto_3

    :cond_9
    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/db;->getLongTag()J

    move-result-wide v6

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v8

    cmp-long v1, v6, v8

    if-nez v1, :cond_a

    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/db;->getState$1599ee8e()I

    move-result v1

    sget v3, Lcom/wishabi/flipp/widget/dk;->c:I

    if-eq v1, v3, :cond_6

    :cond_a
    iget-boolean v1, v0, Lcom/wishabi/flipp/content/az;->c:Z

    if-eqz v1, :cond_b

    if-eqz v4, :cond_b

    iget-object v1, v4, Lcom/wishabi/flipp/content/SimpleSearchResult;->b:Ljava/util/ArrayList;

    if-eqz v1, :cond_b

    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    iget-object v3, v4, Lcom/wishabi/flipp/content/SimpleSearchResult;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Lcom/wishabi/flipp/widget/db;->setThumbnailUrls(Ljava/util/ArrayList;)V

    iget-object v1, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/db;->b()V

    iput-boolean v2, v0, Lcom/wishabi/flipp/content/az;->c:Z

    goto :goto_4

    :cond_b
    iget v0, v0, Lcom/wishabi/flipp/content/az;->b:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_c

    if-eqz v4, :cond_c

    iget-object v0, v4, Lcom/wishabi/flipp/content/SimpleSearchResult;->a:Ljava/util/ArrayList;

    if-eqz v0, :cond_c

    iget-object v0, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    sget v1, Lcom/wishabi/flipp/widget/dk;->a:I

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/db;->setState$282bce2c(I)V

    goto :goto_4

    :cond_c
    iget-object v0, p1, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    sget v1, Lcom/wishabi/flipp/widget/dk;->b:I

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/db;->setState$282bce2c(I)V

    goto :goto_4

    :pswitch_1
    iget-object v0, p1, Lcom/wishabi/flipp/content/ax;->l:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v1, p2}, Lcom/wishabi/flipp/content/ShoppingList;->b(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_4

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final a(Z)V
    .locals 1

    .prologue
    .line 257
    iput-boolean p1, p0, Lcom/wishabi/flipp/content/as;->e:Z

    .line 258
    iget-object v0, p0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    invoke-virtual {v0}, Landroid/support/v7/widget/ao;->b()V

    .line 259
    return-void
.end method

.method public final b(I)J
    .locals 2

    .prologue
    .line 196
    iget-object v0, p0, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    iget-object v1, v0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-eqz v1, :cond_0

    iget-object v1, v0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, p1}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v1

    if-nez v1, :cond_1

    :cond_0
    const-wide/16 v0, -0x1

    :goto_0
    return-wide v0

    :cond_1
    iget-object v0, v0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    iget-wide v0, v0, Lcom/wishabi/flipp/util/m;->a:J

    goto :goto_0
.end method
