.class final Lcom/wishabi/flipp/widget/dl;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ShoppingListPopup;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ShoppingListPopup;)V
    .locals 0

    .prologue
    .line 197
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dl;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 205
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dl;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    sget v1, Lcom/wishabi/flipp/widget/ds;->c:I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;I)I

    .line 206
    return-void
.end method

.method public final onAnimationStart(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 200
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dl;->a:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    sget v1, Lcom/wishabi/flipp/widget/ds;->b:I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Lcom/wishabi/flipp/widget/ShoppingListPopup;I)I

    .line 201
    return-void
.end method
