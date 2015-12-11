.class final Lcom/wishabi/flipp/widget/dg;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/db;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/db;)V
    .locals 0

    .prologue
    .line 370
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dg;->a:Lcom/wishabi/flipp/widget/db;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 385
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dg;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 386
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dg;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/dg;->a:Lcom/wishabi/flipp/widget/db;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/dj;->d(Lcom/wishabi/flipp/widget/db;)V

    .line 387
    :cond_0
    return-void
.end method

.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 379
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dg;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 380
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dg;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/dg;->a:Lcom/wishabi/flipp/widget/db;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/dj;->d(Lcom/wishabi/flipp/widget/db;)V

    .line 381
    :cond_0
    return-void
.end method

.method public final onAnimationStart(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 373
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dg;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->d(Lcom/wishabi/flipp/widget/db;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 374
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dg;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->d(Lcom/wishabi/flipp/widget/db;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setAlpha(F)V

    .line 375
    return-void
.end method
