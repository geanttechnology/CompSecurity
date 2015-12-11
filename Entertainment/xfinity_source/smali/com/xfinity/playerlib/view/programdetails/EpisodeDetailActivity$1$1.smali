.class Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1$1;
.super Ljava/lang/Object;
.source "EpisodeDetailActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;->onPostExecute(Ljava/lang/Boolean;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->openOptionsMenu()V

    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->access$100(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setHasSeenMenuOptions(Z)V

    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->access$200(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V

    .line 55
    return-void
.end method
