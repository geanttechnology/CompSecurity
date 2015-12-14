.class Lcom/livemixtapes/SearchFragment$8;
.super Ljava/lang/Object;
.source "SearchFragment.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SearchFragment;->shake(Landroid/content/Context;Landroid/view/View;Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SearchFragment;

.field private final synthetic val$callback:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SearchFragment;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SearchFragment$8;->this$0:Lcom/livemixtapes/SearchFragment;

    iput-object p2, p0, Lcom/livemixtapes/SearchFragment$8;->val$callback:Ljava/lang/Runnable;

    .line 352
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 1
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 360
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment$8;->val$callback:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 361
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment$8;->val$callback:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 363
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 367
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 355
    return-void
.end method
