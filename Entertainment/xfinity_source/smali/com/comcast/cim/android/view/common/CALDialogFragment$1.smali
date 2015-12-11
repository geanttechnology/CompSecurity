.class Lcom/comcast/cim/android/view/common/CALDialogFragment$1;
.super Ljava/lang/Object;
.source "CALDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/CALDialogFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 144
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->dismiss()V

    .line 145
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/CALDialogFragment;->userManager:Lcom/comcast/cim/model/user/UserManager;
    invoke-static {v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->access$000(Lcom/comcast/cim/android/view/common/CALDialogFragment;)Lcom/comcast/cim/model/user/UserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/UserManager;->signOutUser()V

    .line 146
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/CALDialogFragment;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    invoke-static {v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->access$100(Lcom/comcast/cim/android/view/common/CALDialogFragment;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v0

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->restartAppFlow(Landroid/content/Context;)V

    .line 147
    return-void
.end method
