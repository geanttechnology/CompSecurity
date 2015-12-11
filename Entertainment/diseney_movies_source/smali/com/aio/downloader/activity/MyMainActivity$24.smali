.class Lcom/aio/downloader/activity/MyMainActivity$24;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$24;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 2142
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 2158
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$24;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2159
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 2152
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 2147
    return-void
.end method
