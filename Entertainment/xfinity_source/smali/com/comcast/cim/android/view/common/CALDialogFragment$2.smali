.class Lcom/comcast/cim/android/view/common/CALDialogFragment$2;
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

.field final synthetic val$args:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    iput-object p2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->val$args:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 157
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->dismiss()V

    .line 158
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->val$args:Landroid/os/Bundle;

    const-string v3, "uri"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 159
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->val$args:Landroid/os/Bundle;

    const-string v3, "uri"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 160
    .local v1, "uri":Landroid/net/Uri;
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/CALDialogFragment;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;
    invoke-static {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->access$200(Lcom/comcast/cim/android/view/common/CALDialogFragment;)Lcom/comcast/cim/utils/AppLauncher;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Lcom/comcast/cim/utils/AppLauncher;->startUri(Landroid/net/Uri;Landroid/app/Activity;)V

    .line 165
    .end local v1    # "uri":Landroid/net/Uri;
    :goto_0
    return-void

    .line 162
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->val$args:Landroid/os/Bundle;

    const-string v3, "packageName"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 163
    .local v0, "packageName":Ljava/lang/String;
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/CALDialogFragment;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;
    invoke-static {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->access$200(Lcom/comcast/cim/android/view/common/CALDialogFragment;)Lcom/comcast/cim/utils/AppLauncher;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Lcom/comcast/cim/utils/AppLauncher;->startApplication(Ljava/lang/String;Landroid/app/Activity;)V

    goto :goto_0
.end method
