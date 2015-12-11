.class final Lcom/wishabi/flipp/app/an;
.super Lcom/wishabi/flipp/b/x;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FavoritesFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FavoritesFragment;)V
    .locals 0

    .prologue
    .line 506
    iput-object p1, p0, Lcom/wishabi/flipp/app/an;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-direct {p0}, Lcom/wishabi/flipp/b/x;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 509
    iget-object v0, p0, Lcom/wishabi/flipp/app/an;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->e(Lcom/wishabi/flipp/app/FavoritesFragment;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 510
    return-void
.end method

.method public final a(Z)V
    .locals 2

    .prologue
    .line 514
    iget-object v0, p0, Lcom/wishabi/flipp/app/an;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->e(Lcom/wishabi/flipp/app/FavoritesFragment;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 518
    iget-object v0, p0, Lcom/wishabi/flipp/app/an;->a:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->b(Lcom/wishabi/flipp/app/FavoritesFragment;)V

    .line 519
    return-void
.end method
