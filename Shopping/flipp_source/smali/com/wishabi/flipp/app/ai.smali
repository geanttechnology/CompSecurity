.class final Lcom/wishabi/flipp/app/ai;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/r;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FavoritesFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FavoritesFragment;)V
    .locals 0

    .prologue
    .line 161
    iput-object p1, p0, Lcom/wishabi/flipp/app/ai;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/wishabi/flipp/widget/CollectionView;I)V
    .locals 3

    .prologue
    .line 165
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 166
    if-nez v0, :cond_1

    .line 182
    :cond_0
    :goto_0
    return-void

    .line 169
    :cond_1
    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/widget/bw;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 170
    if-eqz v0, :cond_0

    .line 173
    iget-object v1, p0, Lcom/wishabi/flipp/app/ai;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 174
    if-eqz v1, :cond_0

    .line 177
    invoke-interface {v0, p2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 178
    new-instance v2, Lcom/wishabi/flipp/content/FlyerActivityIntent;

    invoke-direct {v2, v1, v0}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Landroid/database/Cursor;)V

    const/4 v0, 0x0

    invoke-virtual {v1, v2, v0}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 180
    const v0, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0
.end method
