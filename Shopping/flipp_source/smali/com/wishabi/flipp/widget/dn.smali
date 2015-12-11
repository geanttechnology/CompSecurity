.class final Lcom/wishabi/flipp/widget/dn;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ShoppingListPopup;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ShoppingListPopup;)V
    .locals 0

    .prologue
    .line 296
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 314
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    sget v1, Lcom/wishabi/flipp/widget/ds;->c:I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;I)I

    .line 315
    return-void
.end method

.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 6

    .prologue
    .line 305
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->d(Lcom/wishabi/flipp/widget/ShoppingListPopup;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setAlpha(F)V

    .line 306
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->e(Lcom/wishabi/flipp/widget/ShoppingListPopup;)Landroid/widget/TextView;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setAlpha(F)V

    .line 308
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;)I

    move-result v0

    sget v1, Lcom/wishabi/flipp/widget/ds;->e:I

    if-ne v0, v1, :cond_0

    .line 309
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    new-instance v1, Lcom/wishabi/flipp/widget/dq;

    iget-object v2, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    iget-object v3, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->f(Lcom/wishabi/flipp/widget/ShoppingListPopup;)J

    move-result-wide v4

    invoke-direct {v1, v2, v4, v5}, Lcom/wishabi/flipp/widget/dq;-><init>(Lcom/wishabi/flipp/widget/ShoppingListPopup;J)V

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;Lcom/wishabi/flipp/widget/dq;)Lcom/wishabi/flipp/widget/dq;

    .line 310
    :cond_0
    return-void
.end method

.method public final onAnimationStart(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 299
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->c(Lcom/wishabi/flipp/widget/ShoppingListPopup;)Landroid/widget/Button;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 300
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dn;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    sget v1, Lcom/wishabi/flipp/widget/ds;->e:I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;I)I

    .line 301
    return-void
.end method
