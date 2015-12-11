.class Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;
.super Ljava/lang/Object;
.source "PlayNowSignoutActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;->this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 47
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 50
    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;->this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    # getter for: Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->access$000(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;->this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    # getter for: Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->access$000(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteAllContent()Ljava/util/Map;
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 56
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;->this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    # getter for: Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->userManager:Lcom/comcast/cim/model/user/UserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->access$100(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)Lcom/comcast/cim/model/user/UserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/UserManager;->signOutUser()V

    .line 57
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;->this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    # getter for: Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->access$200(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;->this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->restartAppFlow(Landroid/content/Context;)V

    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;->this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->finish()V

    .line 59
    return-void

    .line 53
    :catch_0
    move-exception v0

    goto :goto_0
.end method
