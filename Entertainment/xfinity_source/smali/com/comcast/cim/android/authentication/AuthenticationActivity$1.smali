.class Lcom/comcast/cim/android/authentication/AuthenticationActivity$1;
.super Ljava/lang/Object;
.source "AuthenticationActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/authentication/AuthenticationActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 84
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$1;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$1;"
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$1;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 87
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$1;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$1;"
    const-string v1, "hsdPromptDlg"

    invoke-static {v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    .line 88
    .local v0, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$1;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "caldialogfragment"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 89
    return-void
.end method
