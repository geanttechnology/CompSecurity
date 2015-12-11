.class final Lcom/wishabi/flipp/app/bd;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FlyerActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlyerActivity;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lcom/wishabi/flipp/app/bd;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .prologue
    .line 222
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/high16 v1, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 223
    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 224
    new-instance v1, Lcom/wishabi/flipp/app/be;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/be;-><init>(Lcom/wishabi/flipp/app/bd;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 237
    iget-object v1, p0, Lcom/wishabi/flipp/app/bd;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerActivity;->c(Lcom/wishabi/flipp/app/FlyerActivity;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 238
    return-void
.end method
