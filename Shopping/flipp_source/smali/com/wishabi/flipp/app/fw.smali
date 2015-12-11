.class final Lcom/wishabi/flipp/app/fw;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/fv;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/fv;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/wishabi/flipp/app/fw;->a:Lcom/wishabi/flipp/app/fv;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/wishabi/flipp/app/fw;->a:Lcom/wishabi/flipp/app/fv;

    iget-object v0, v0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/fu;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 148
    :goto_0
    return-void

    .line 147
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/fw;->a:Lcom/wishabi/flipp/app/fv;

    iget-object v0, v0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fu;->b(Lcom/wishabi/flipp/app/fu;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0
.end method
