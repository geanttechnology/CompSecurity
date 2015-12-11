.class Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$4;
.super Ljava/lang/Object;
.source "AlertAnimationManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->startAlert()V
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
    .line 221
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$4;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$4;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedPlayerStatus:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$700(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    if-nez v0, :cond_0

    .line 225
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$4;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->saveCurrentPlayerState()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$800(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    .line 227
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$4;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->startAlertContent()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$900(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    .line 228
    return-void
.end method
