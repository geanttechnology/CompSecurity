.class Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;
.super Ljava/lang/Object;
.source "AuthenticationActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/authentication/AuthenticationActivity;->onSigninFailed(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

.field final synthetic val$exception:Ljava/lang/Exception;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 213
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;"
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    iput-object p2, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->val$exception:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 215
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;"
    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v3}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->hideSigningInSpinner()V

    .line 216
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 217
    .local v0, "args":Landroid/os/Bundle;
    const-string v3, "errorDlg"

    invoke-static {v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v1

    .line 218
    .local v1, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->val$exception:Ljava/lang/Exception;

    instance-of v3, v3, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->val$exception:Ljava/lang/Exception;

    check-cast v3, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    .line 219
    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->getDetailedStatusCode()I

    move-result v3

    const/16 v4, 0xbc1

    if-ne v3, v4, :cond_0

    .line 220
    const-string v3, "description"

    iget-object v4, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v4}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/comcast/cim/android/R$string;->XIP_ERROR_CLOCK_SKEW:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 222
    new-instance v3, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5$1;

    invoke-direct {v3, p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5$1;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;)V

    invoke-virtual {v1, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 236
    :goto_0
    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v3}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v3

    const-string v4, "caldialogfragment"

    invoke-virtual {v1, v3, v4}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 237
    return-void

    .line 229
    :cond_0
    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    iget-object v4, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->val$exception:Ljava/lang/Exception;

    invoke-virtual {v3, v4}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getErrorResourceForException(Ljava/lang/Exception;)I

    move-result v2

    .line 231
    .local v2, "errorResourceId":I
    const-string v3, "description"

    iget-object v4, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v4}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 233
    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    # invokes: Lcom/comcast/cim/android/authentication/AuthenticationActivity;->createSigninErrorCancelListener()Landroid/content/DialogInterface$OnCancelListener;
    invoke-static {v3}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->access$300(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    goto :goto_0
.end method
