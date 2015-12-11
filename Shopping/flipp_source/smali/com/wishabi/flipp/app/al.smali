.class final Lcom/wishabi/flipp/app/al;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/bc;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FavoritesFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FavoritesFragment;)V
    .locals 0

    .prologue
    .line 204
    iput-object p1, p0, Lcom/wishabi/flipp/app/al;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/wishabi/flipp/widget/ba;)V
    .locals 10

    .prologue
    const/4 v4, 0x0

    const/4 v5, -0x1

    .line 207
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/ba;->getFeaturedItem()Lcom/wishabi/flipp/content/h;

    move-result-object v6

    .line 208
    if-nez v6, :cond_1

    .line 250
    :cond_0
    :goto_0
    return-void

    .line 211
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/al;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->c(Lcom/wishabi/flipp/app/FavoritesFragment;)Lcom/wishabi/flipp/widget/bw;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 215
    iget-object v0, p0, Lcom/wishabi/flipp/app/al;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->a(Lcom/wishabi/flipp/app/FavoritesFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getActiveViews()Landroid/util/SparseArray;

    move-result-object v7

    .line 217
    invoke-virtual {v7}, Landroid/util/SparseArray;->size()I

    move-result v8

    move v3, v4

    move v2, v5

    .line 218
    :goto_1
    if-ge v3, v8, :cond_2

    .line 219
    invoke-virtual {v7, v3}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v1

    .line 220
    iget-object v0, p0, Lcom/wishabi/flipp/app/al;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->c(Lcom/wishabi/flipp/app/FavoritesFragment;)Lcom/wishabi/flipp/widget/bw;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/bw;->e(I)I

    move-result v0

    .line 222
    sget v9, Lcom/wishabi/flipp/widget/ca;->b:I

    if-ne v0, v9, :cond_3

    .line 223
    invoke-virtual {v7, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ba;

    .line 225
    if-ne v0, p1, :cond_3

    move v0, v1

    .line 218
    :goto_2
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    move v2, v0

    goto :goto_1

    .line 230
    :cond_2
    if-eq v2, v5, :cond_0

    .line 233
    iget-object v0, p0, Lcom/wishabi/flipp/app/al;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->c(Lcom/wishabi/flipp/app/FavoritesFragment;)Lcom/wishabi/flipp/widget/bw;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/bw;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 234
    if-eqz v0, :cond_0

    .line 237
    iget-object v1, p0, Lcom/wishabi/flipp/app/al;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 238
    if-eqz v1, :cond_0

    .line 241
    new-instance v2, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-direct {v2, v0}, Lcom/wishabi/flipp/content/Flyer$Model;-><init>(Landroid/database/Cursor;)V

    .line 242
    sget-object v3, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v5, "Favorites"

    sget-object v7, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v5, v7}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v2, v5, v6}, Lcom/wishabi/flipp/b/a;->b(Lcom/wishabi/flipp/content/Flyer$Model;Ljava/lang/String;Lcom/wishabi/flipp/content/h;)V

    .line 246
    new-instance v2, Lcom/wishabi/flipp/content/FlyerActivityIntent;

    invoke-virtual {v6}, Lcom/wishabi/flipp/content/h;->a()Landroid/graphics/RectF;

    move-result-object v3

    invoke-direct {v2, v1, v0, v3}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/graphics/RectF;)V

    invoke-virtual {v1, v2, v4}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 248
    const v0, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0

    :cond_3
    move v0, v2

    goto :goto_2
.end method
