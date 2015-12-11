.class final Lcom/wishabi/flipp/app/s;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/n;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/n;)V
    .locals 0

    .prologue
    .line 497
    iput-object p1, p0, Lcom/wishabi/flipp/app/s;->a:Lcom/wishabi/flipp/app/n;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 500
    iget-object v0, p0, Lcom/wishabi/flipp/app/s;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->e(Lcom/wishabi/flipp/app/n;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 501
    return-void
.end method
