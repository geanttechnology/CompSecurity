.class Lco/vine/android/RecordingFragment$13;
.super Ljava/lang/Object;
.source "RecordingFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/RecordingFragment;->onSessionSwitchPressed(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/RecordingFragment;


# direct methods
.method constructor <init>(Lco/vine/android/RecordingFragment;)V
    .locals 0

    .prologue
    .line 849
    iput-object p1, p0, Lco/vine/android/RecordingFragment$13;->this$0:Lco/vine/android/RecordingFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 852
    iget-object v1, p0, Lco/vine/android/RecordingFragment$13;->this$0:Lco/vine/android/RecordingFragment;

    invoke-virtual {v1}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 853
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 854
    const v1, 0x7f0e00c1

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 856
    :cond_0
    iget-object v1, p0, Lco/vine/android/RecordingFragment$13;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mIsDraftUpgradeAnimationRunning:Z
    invoke-static {v1}, Lco/vine/android/RecordingFragment;->access$1400(Lco/vine/android/RecordingFragment;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 857
    iget-object v1, p0, Lco/vine/android/RecordingFragment$13;->this$0:Lco/vine/android/RecordingFragment;

    const/4 v2, 0x1

    # setter for: Lco/vine/android/RecordingFragment;->mIsDraftUpgradeAnimationRunning:Z
    invoke-static {v1, v2}, Lco/vine/android/RecordingFragment;->access$1402(Lco/vine/android/RecordingFragment;Z)Z

    .line 858
    iget-object v1, p0, Lco/vine/android/RecordingFragment$13;->this$0:Lco/vine/android/RecordingFragment;

    iget-object v2, p0, Lco/vine/android/RecordingFragment$13;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mDraftUpgradeCount:I
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$1500(Lco/vine/android/RecordingFragment;)I

    move-result v2

    invoke-virtual {v1, v2}, Lco/vine/android/RecordingFragment;->onDraftUpgradeNumberChanged(I)V

    .line 860
    :cond_1
    return-void
.end method
