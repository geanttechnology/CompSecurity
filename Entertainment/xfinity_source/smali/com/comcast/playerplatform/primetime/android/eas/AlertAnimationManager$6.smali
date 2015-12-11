.class Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$6;
.super Ljava/lang/Object;
.source "AlertAnimationManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->startAlertAnimation()V
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
    .line 286
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$6;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 289
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$6;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$1100(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$6;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$1200(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Landroid/view/animation/TranslateAnimation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 290
    return-void
.end method
