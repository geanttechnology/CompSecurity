.class final Luk/co/senab/actionbarpulltorefresh/library/d;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Luk/co/senab/actionbarpulltorefresh/library/c;


# direct methods
.method constructor <init>(Luk/co/senab/actionbarpulltorefresh/library/c;)V
    .locals 0

    .prologue
    .line 429
    iput-object p1, p0, Luk/co/senab/actionbarpulltorefresh/library/d;->a:Luk/co/senab/actionbarpulltorefresh/library/c;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 432
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/d;->a:Luk/co/senab/actionbarpulltorefresh/library/c;

    iget-object v0, v0, Luk/co/senab/actionbarpulltorefresh/library/c;->a:Landroid/view/View;

    .line 433
    if-eqz v0, :cond_0

    .line 434
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 436
    :cond_0
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/d;->a:Luk/co/senab/actionbarpulltorefresh/library/c;

    invoke-virtual {v0}, Luk/co/senab/actionbarpulltorefresh/library/c;->a()V

    .line 437
    return-void
.end method
