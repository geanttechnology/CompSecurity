.class Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$1;
.super Ljava/lang/Object;
.source "AlertAnimationManager.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;
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
    .line 39
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 4
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 47
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->destroyText()V
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$000(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    .line 49
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    move-result-object v2

    monitor-enter v2

    .line 50
    :try_start_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$200(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v0

    .line 51
    .local v0, "identifier":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    move-result-object v1

    const/4 v3, 0x1

    invoke-virtual {v1, v0, v3}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->emergencyAlertCompleted(Ljava/lang/String;Z)V

    .line 52
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->checkForNextAlert()V
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$300(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    .line 53
    monitor-exit v2

    .line 54
    return-void

    .line 53
    .end local v0    # "identifier":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 59
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 43
    return-void
.end method
