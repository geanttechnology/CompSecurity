.class final Lcom/wishabi/flipp/app/be;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/bd;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/bd;)V
    .locals 0

    .prologue
    .line 224
    iput-object p1, p0, Lcom/wishabi/flipp/app/be;->a:Lcom/wishabi/flipp/app/bd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 230
    iget-object v0, p0, Lcom/wishabi/flipp/app/be;->a:Lcom/wishabi/flipp/app/bd;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bd;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerActivity;->c(Lcom/wishabi/flipp/app/FlyerActivity;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 231
    iget-object v0, p0, Lcom/wishabi/flipp/app/be;->a:Lcom/wishabi/flipp/app/bd;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bd;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerActivity;->c(Lcom/wishabi/flipp/app/FlyerActivity;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 232
    :cond_0
    return-void
.end method

.method public final onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 235
    return-void
.end method

.method public final onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 226
    return-void
.end method
