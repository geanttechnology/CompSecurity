.class final Lcom/wishabi/flipp/widget/dh;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/b/j;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/db;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/db;)V
    .locals 0

    .prologue
    .line 431
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dh;->a:Lcom/wishabi/flipp/widget/db;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 434
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dh;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->e(Lcom/wishabi/flipp/widget/db;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 442
    :cond_0
    :goto_0
    return-void

    .line 437
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dh;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->f(Lcom/wishabi/flipp/widget/db;)Landroid/animation/AnimatorSet;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 440
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dh;->a:Lcom/wishabi/flipp/widget/db;

    sget v1, Lcom/wishabi/flipp/widget/dk;->c:I

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/db;->setState$282bce2c(I)V

    .line 441
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dh;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->f(Lcom/wishabi/flipp/widget/db;)Landroid/animation/AnimatorSet;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->start()V

    goto :goto_0
.end method

.method public final b()V
    .locals 2

    .prologue
    .line 446
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dh;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 447
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dh;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/dh;->a:Lcom/wishabi/flipp/widget/db;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/dj;->d(Lcom/wishabi/flipp/widget/db;)V

    .line 448
    :cond_0
    return-void
.end method
