.class Lcom/livemixtapes/profile/SelectedPlayList$7;
.super Ljava/lang/Object;
.source "SelectedPlayList.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SelectedPlayList;->shake(Landroid/content/Context;Landroid/view/View;Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/profile/SelectedPlayList;

.field private final synthetic val$callback:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SelectedPlayList;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$7;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iput-object p2, p0, Lcom/livemixtapes/profile/SelectedPlayList$7;->val$callback:Ljava/lang/Runnable;

    .line 468
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 1
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 476
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$7;->val$callback:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 477
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$7;->val$callback:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 479
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 483
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 471
    return-void
.end method
