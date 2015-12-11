.class Lcom/aio/downloader/activity/AppActivity1$3;
.super Ljava/lang/Object;
.source "AppActivity1.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppActivity1;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppActivity1$3;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    .line 246
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 264
    iget-object v0, p0, Lcom/aio/downloader/activity/AppActivity1$3;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    # getter for: Lcom/aio/downloader/activity/AppActivity1;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppActivity1;->access$5(Lcom/aio/downloader/activity/AppActivity1;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 265
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 258
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 252
    return-void
.end method
