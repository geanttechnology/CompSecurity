.class Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;
.super Ljava/lang/Object;
.source "AlertAnimationManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->addToPlayerView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V
    .locals 0

    .prologue
    .line 260
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 263
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$1000(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 264
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$1000(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$1000(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 265
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$1000(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$1100(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->removeView(Landroid/view/View;)V

    .line 267
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$500(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->getView()Landroid/view/View;

    move-result-object v0

    .line 268
    .local v0, "playerView":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$1000(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 269
    return-void
.end method
