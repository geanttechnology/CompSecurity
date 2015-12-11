.class Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1;
.super Landroid/os/AsyncTask;
.source "SeriesDetailActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;->onResumeInternal()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Boolean;
    .locals 2
    .param p1, "voids"    # [Ljava/lang/Void;

    .prologue
    .line 35
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;->access$000(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 37
    .local v0, "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenMenuOptions()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    return-object v1
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 31
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method protected onPostExecute(Ljava/lang/Boolean;)V
    .locals 4
    .param p1, "hasSeenMenuOptions"    # Ljava/lang/Boolean;

    .prologue
    .line 43
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_0

    .line 45
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 50
    .local v0, "handler":Landroid/os/Handler;
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1;)V

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 59
    .end local v0    # "handler":Landroid/os/Handler;
    :cond_0
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 31
    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1;->onPostExecute(Ljava/lang/Boolean;)V

    return-void
.end method
