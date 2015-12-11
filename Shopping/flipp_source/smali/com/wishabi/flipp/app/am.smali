.class final Lcom/wishabi/flipp/app/am;
.super Lcom/wishabi/flipp/widget/bw;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FavoritesFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FavoritesFragment;Landroid/content/Context;Landroid/database/Cursor;Landroid/util/SparseBooleanArray;Ljava/util/List;Lcom/wishabi/flipp/widget/cb;Lcom/wishabi/flipp/widget/bc;)V
    .locals 9

    .prologue
    .line 376
    iput-object p1, p0, Lcom/wishabi/flipp/app/am;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lcom/wishabi/flipp/widget/bw;-><init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/util/SparseBooleanArray;Ljava/util/List;Lcom/wishabi/flipp/widget/cb;ZLcom/wishabi/flipp/widget/ec;Lcom/wishabi/flipp/widget/bc;)V

    return-void
.end method


# virtual methods
.method protected final a(Landroid/content/Context;I)Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 381
    const/4 v0, 0x0

    .line 385
    iget-object v1, p0, Lcom/wishabi/flipp/app/am;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FavoritesFragment;->c(Lcom/wishabi/flipp/app/FavoritesFragment;)Lcom/wishabi/flipp/widget/bw;

    move-result-object v1

    iget-boolean v1, v1, Lcom/wishabi/flipp/widget/bw;->b:Z

    if-eqz v1, :cond_0

    if-eq p2, v2, :cond_1

    :cond_0
    if-nez p2, :cond_2

    .line 386
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/am;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->d(Lcom/wishabi/flipp/app/FavoritesFragment;)I

    move-result v0

    if-ne v0, v2, :cond_3

    .line 387
    iget-object v0, p0, Lcom/wishabi/flipp/app/am;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e00f9

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 395
    :cond_2
    :goto_0
    return-object v0

    .line 390
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/am;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e00fa

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/wishabi/flipp/app/am;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v4}, Lcom/wishabi/flipp/app/FavoritesFragment;->d(Lcom/wishabi/flipp/app/FavoritesFragment;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
