.class final Lcom/wishabi/flipp/app/au;
.super Lcom/wishabi/flipp/b/x;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FeaturedFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FeaturedFragment;)V
    .locals 0

    .prologue
    .line 553
    iput-object p1, p0, Lcom/wishabi/flipp/app/au;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-direct {p0}, Lcom/wishabi/flipp/b/x;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 556
    iget-object v0, p0, Lcom/wishabi/flipp/app/au;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FeaturedFragment;->f(Lcom/wishabi/flipp/app/FeaturedFragment;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 557
    return-void
.end method

.method public final a(Z)V
    .locals 2

    .prologue
    .line 561
    iget-object v0, p0, Lcom/wishabi/flipp/app/au;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FeaturedFragment;->f(Lcom/wishabi/flipp/app/FeaturedFragment;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 565
    iget-object v0, p0, Lcom/wishabi/flipp/app/au;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FeaturedFragment;->d(Lcom/wishabi/flipp/app/FeaturedFragment;)V

    .line 566
    return-void
.end method
