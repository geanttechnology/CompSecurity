.class public Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;
.super Ljava/lang/Object;
.source "VideoTrackerSharedPreferenceProvider.java"


# instance fields
.field private final context:Landroid/content/Context;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;->context:Landroid/content/Context;

    .line 19
    iput-object p2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 20
    return-void
.end method


# virtual methods
.method public getSharedPreferencesForCurrentUser()Landroid/content/SharedPreferences;
    .locals 4

    .prologue
    .line 23
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    .line 24
    .local v0, "user":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;->context:Landroid/content/Context;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "TRACK_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    return-object v1
.end method
