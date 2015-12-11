.class final Lcom/wishabi/flipp/app/dk;
.super Lcom/wishabi/flipp/b/x;
.source "SourceFile"


# instance fields
.field final synthetic a:Z

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Lcom/wishabi/flipp/app/MainActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/MainActivity;ZLjava/lang/String;)V
    .locals 0

    .prologue
    .line 506
    iput-object p1, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    iput-boolean p2, p0, Lcom/wishabi/flipp/app/dk;->a:Z

    iput-object p3, p0, Lcom/wishabi/flipp/app/dk;->b:Ljava/lang/String;

    invoke-direct {p0}, Lcom/wishabi/flipp/b/x;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 509
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->c(Lcom/wishabi/flipp/app/MainActivity;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setVisibility(I)V

    .line 510
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->c(Lcom/wishabi/flipp/app/MainActivity;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 511
    return-void
.end method

.method public final a(Z)V
    .locals 9

    .prologue
    const/4 v8, 0x0

    const/4 v6, 0x0

    .line 525
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->d(Lcom/wishabi/flipp/app/MainActivity;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 529
    :try_start_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->d(Lcom/wishabi/flipp/app/MainActivity;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 530
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/MainActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v2, 0x0

    const-string v3, "postal_code = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v7, p0, Lcom/wishabi/flipp/app/dk;->b:Ljava/lang/String;

    aput-object v7, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 536
    :goto_0
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_0

    .line 538
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 539
    new-instance v1, Lcom/wishabi/flipp/content/FlyerActivityIntent;

    iget-object v2, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-virtual {v2}, Lcom/wishabi/flipp/app/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Landroid/database/Cursor;)V

    .line 541
    iget-object v2, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/app/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 542
    iget-object v1, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    const v2, 0x7f040001

    const v3, 0x7f040002

    invoke-virtual {v1, v2, v3}, Lcom/wishabi/flipp/app/MainActivity;->overridePendingTransition(II)V

    .line 545
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 549
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->e(Lcom/wishabi/flipp/app/MainActivity;)Ljava/lang/String;

    .line 550
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->c(Lcom/wishabi/flipp/app/MainActivity;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setVisibility(I)V

    .line 551
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->c(Lcom/wishabi/flipp/app/MainActivity;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    invoke-virtual {v0, v8}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 552
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->f(Lcom/wishabi/flipp/app/MainActivity;)I

    .line 553
    return-void

    :catch_0
    move-exception v0

    move-object v0, v6

    goto :goto_0
.end method

.method public final b()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 515
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/dk;->a:Z

    if-eqz v0, :cond_0

    .line 516
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->c(Lcom/wishabi/flipp/app/MainActivity;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setVisibility(I)V

    .line 517
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->b(Lcom/wishabi/flipp/app/MainActivity;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(Z)V

    .line 519
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/dk;->c:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->c(Lcom/wishabi/flipp/app/MainActivity;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 520
    return-void
.end method
