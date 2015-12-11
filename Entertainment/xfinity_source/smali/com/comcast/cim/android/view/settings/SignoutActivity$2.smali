.class Lcom/comcast/cim/android/view/settings/SignoutActivity$2;
.super Ljava/lang/Object;
.source "SignoutActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/settings/SignoutActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/settings/SignoutActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/settings/SignoutActivity;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity$2;->this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 37
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 38
    iget-object v0, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity$2;->this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;

    # getter for: Lcom/comcast/cim/android/view/settings/SignoutActivity;->userManager:Lcom/comcast/cim/model/user/UserManager;
    invoke-static {v0}, Lcom/comcast/cim/android/view/settings/SignoutActivity;->access$000(Lcom/comcast/cim/android/view/settings/SignoutActivity;)Lcom/comcast/cim/model/user/UserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/UserManager;->signOutUser()V

    .line 39
    iget-object v0, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity$2;->this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;

    # getter for: Lcom/comcast/cim/android/view/settings/SignoutActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    invoke-static {v0}, Lcom/comcast/cim/android/view/settings/SignoutActivity;->access$100(Lcom/comcast/cim/android/view/settings/SignoutActivity;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity$2;->this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->restartAppFlow(Landroid/content/Context;)V

    .line 40
    iget-object v0, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity$2;->this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/settings/SignoutActivity;->finish()V

    .line 41
    return-void
.end method
