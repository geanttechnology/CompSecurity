.class final Lcom/wishabi/flipp/app/x;
.super Lcom/wishabi/flipp/b/x;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/CouponFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/CouponFragment;)V
    .locals 0

    .prologue
    .line 546
    iput-object p1, p0, Lcom/wishabi/flipp/app/x;->a:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-direct {p0}, Lcom/wishabi/flipp/b/x;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 554
    iget-object v0, p0, Lcom/wishabi/flipp/app/x;->a:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/CouponFragment;->b(Lcom/wishabi/flipp/app/CouponFragment;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 555
    return-void
.end method

.method public final a(Z)V
    .locals 2

    .prologue
    .line 549
    iget-object v0, p0, Lcom/wishabi/flipp/app/x;->a:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/CouponFragment;->b(Lcom/wishabi/flipp/app/CouponFragment;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 550
    return-void
.end method
