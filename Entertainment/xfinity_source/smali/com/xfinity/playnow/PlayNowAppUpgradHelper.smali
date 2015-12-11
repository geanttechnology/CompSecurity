.class public Lcom/xfinity/playnow/PlayNowAppUpgradHelper;
.super Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;
.source "PlayNowAppUpgradHelper.java"


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/model/user/UserManager;Landroid/content/SharedPreferences;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;)V
    .locals 0
    .param p1, "playNowApplication"    # Lcom/xfinity/playerlib/PlayerApplication;
    .param p3, "sharedPrefs"    # Landroid/content/SharedPreferences;
    .param p4, "downloadsManager"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p5, "persistentEntityCache"    # Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;
    .param p6, "persistentCaptionsCache"    # Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;
    .param p7, "bookmarkDAO"    # Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/PlayerApplication;",
            "Lcom/comcast/cim/model/user/UserManager",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;",
            "Landroid/content/SharedPreferences;",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;",
            "Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;",
            "Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;",
            "Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;",
            ")V"
        }
    .end annotation

    .prologue
    .line 23
    .local p2, "userManager":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;>;"
    invoke-direct/range {p0 .. p7}, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;-><init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/model/user/UserManager;Landroid/content/SharedPreferences;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;)V

    .line 24
    return-void
.end method


# virtual methods
.method protected upgradeRequiresFilterReset(I)Z
    .locals 1
    .param p1, "oldVersion"    # I

    .prologue
    .line 33
    const/16 v0, 0x8a9

    if-ge p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected upgradeRequiresSignout(I)Z
    .locals 1
    .param p1, "versionCodeLastLaunch"    # I

    .prologue
    .line 28
    const/16 v0, 0x8a3

    if-ge p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
