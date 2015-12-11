.class final Lcom/wishabi/flipp/app/cz;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cx;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cx;)V
    .locals 0

    .prologue
    .line 367
    iput-object p1, p0, Lcom/wishabi/flipp/app/cz;->a:Lcom/wishabi/flipp/app/cx;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 370
    iget-object v0, p0, Lcom/wishabi/flipp/app/cz;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cx;->a(Lcom/wishabi/flipp/app/cx;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 371
    return-void
.end method
