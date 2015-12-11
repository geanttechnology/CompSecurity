.class final Lcom/wishabi/flipp/widget/dm;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ShoppingListPopup;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ShoppingListPopup;)V
    .locals 0

    .prologue
    .line 262
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dm;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 270
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dm;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->setVisibility(I)V

    .line 271
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dm;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    sget v1, Lcom/wishabi/flipp/widget/ds;->a:I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;I)I

    .line 272
    return-void
.end method

.method public final onAnimationStart(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 265
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dm;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    sget v1, Lcom/wishabi/flipp/widget/ds;->d:I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;I)I

    .line 266
    return-void
.end method
