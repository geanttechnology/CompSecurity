.class final Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;
.super Ljava/lang/Object;
.source "ShowCleanActivity1.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "DisplayNextView"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V
    .locals 0

    .prologue
    .line 349
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;)V
    .locals 0

    .prologue
    .line 349
    invoke-direct {p0, p1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 4
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 354
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mContainer:Landroid/view/View;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$2(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 355
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 358
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 351
    return-void
.end method
