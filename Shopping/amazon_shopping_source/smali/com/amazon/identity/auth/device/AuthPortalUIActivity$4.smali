.class Lcom/amazon/identity/auth/device/AuthPortalUIActivity$4;
.super Ljava/lang/Object;
.source "AuthPortalUIActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

.field final synthetic val$delayFadeAnimation:Landroid/view/animation/Animation;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 1456
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$4;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$4;->val$delayFadeAnimation:Landroid/view/animation/Animation;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 1460
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$4;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$4;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mProgressbarId:I
    invoke-static {v2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2400(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    .line 1461
    .local v0, "progressBar":Landroid/widget/ProgressBar;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$4;->val$delayFadeAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->startAnimation(Landroid/view/animation/Animation;)V

    .line 1462
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 1463
    return-void
.end method
