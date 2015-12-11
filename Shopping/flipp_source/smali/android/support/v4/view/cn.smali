.class final Landroid/support/v4/view/cn;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/cw;


# instance fields
.field a:Landroid/support/v4/view/cj;


# direct methods
.method constructor <init>(Landroid/support/v4/view/cj;)V
    .locals 0

    .prologue
    .line 501
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 502
    iput-object p1, p0, Landroid/support/v4/view/cn;->a:Landroid/support/v4/view/cj;

    .line 503
    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 507
    iget-object v0, p0, Landroid/support/v4/view/cn;->a:Landroid/support/v4/view/cj;

    invoke-static {v0}, Landroid/support/v4/view/cj;->d(Landroid/support/v4/view/cj;)I

    move-result v0

    if-ltz v0, :cond_0

    .line 508
    const/4 v0, 0x2

    invoke-static {p1, v0, v1}, Landroid/support/v4/view/ap;->a(Landroid/view/View;ILandroid/graphics/Paint;)V

    .line 510
    :cond_0
    iget-object v0, p0, Landroid/support/v4/view/cn;->a:Landroid/support/v4/view/cj;

    invoke-static {v0}, Landroid/support/v4/view/cj;->a(Landroid/support/v4/view/cj;)Ljava/lang/Runnable;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 511
    iget-object v0, p0, Landroid/support/v4/view/cn;->a:Landroid/support/v4/view/cj;

    invoke-static {v0}, Landroid/support/v4/view/cj;->a(Landroid/support/v4/view/cj;)Ljava/lang/Runnable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 513
    :cond_1
    const/high16 v0, 0x7e000000

    invoke-virtual {p1, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v0

    .line 515
    instance-of v2, v0, Landroid/support/v4/view/cw;

    if-eqz v2, :cond_3

    .line 516
    check-cast v0, Landroid/support/v4/view/cw;

    .line 518
    :goto_0
    if-eqz v0, :cond_2

    .line 519
    invoke-interface {v0, p1}, Landroid/support/v4/view/cw;->a(Landroid/view/View;)V

    .line 521
    :cond_2
    return-void

    :cond_3
    move-object v0, v1

    goto :goto_0
.end method

.method public final b(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 525
    iget-object v0, p0, Landroid/support/v4/view/cn;->a:Landroid/support/v4/view/cj;

    invoke-static {v0}, Landroid/support/v4/view/cj;->d(Landroid/support/v4/view/cj;)I

    move-result v0

    if-ltz v0, :cond_0

    .line 526
    iget-object v0, p0, Landroid/support/v4/view/cn;->a:Landroid/support/v4/view/cj;

    invoke-static {v0}, Landroid/support/v4/view/cj;->d(Landroid/support/v4/view/cj;)I

    move-result v0

    invoke-static {p1, v0, v1}, Landroid/support/v4/view/ap;->a(Landroid/view/View;ILandroid/graphics/Paint;)V

    .line 527
    iget-object v0, p0, Landroid/support/v4/view/cn;->a:Landroid/support/v4/view/cj;

    invoke-static {v0}, Landroid/support/v4/view/cj;->c(Landroid/support/v4/view/cj;)I

    .line 529
    :cond_0
    iget-object v0, p0, Landroid/support/v4/view/cn;->a:Landroid/support/v4/view/cj;

    invoke-static {v0}, Landroid/support/v4/view/cj;->b(Landroid/support/v4/view/cj;)Ljava/lang/Runnable;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 530
    iget-object v0, p0, Landroid/support/v4/view/cn;->a:Landroid/support/v4/view/cj;

    invoke-static {v0}, Landroid/support/v4/view/cj;->b(Landroid/support/v4/view/cj;)Ljava/lang/Runnable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 532
    :cond_1
    const/high16 v0, 0x7e000000

    invoke-virtual {p1, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v0

    .line 534
    instance-of v2, v0, Landroid/support/v4/view/cw;

    if-eqz v2, :cond_3

    .line 535
    check-cast v0, Landroid/support/v4/view/cw;

    .line 537
    :goto_0
    if-eqz v0, :cond_2

    .line 538
    invoke-interface {v0, p1}, Landroid/support/v4/view/cw;->b(Landroid/view/View;)V

    .line 540
    :cond_2
    return-void

    :cond_3
    move-object v0, v1

    goto :goto_0
.end method

.method public final c(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 544
    const/high16 v0, 0x7e000000

    invoke-virtual {p1, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v0

    .line 545
    const/4 v1, 0x0

    .line 546
    instance-of v2, v0, Landroid/support/v4/view/cw;

    if-eqz v2, :cond_1

    .line 547
    check-cast v0, Landroid/support/v4/view/cw;

    .line 549
    :goto_0
    if-eqz v0, :cond_0

    .line 550
    invoke-interface {v0, p1}, Landroid/support/v4/view/cw;->c(Landroid/view/View;)V

    .line 552
    :cond_0
    return-void

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method
