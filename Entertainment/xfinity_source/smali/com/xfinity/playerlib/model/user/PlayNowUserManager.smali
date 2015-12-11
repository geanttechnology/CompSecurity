.class public Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
.super Lcom/comcast/cim/model/user/XipUserManager;
.source "PlayNowUserManager.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/model/user/XipUserManager",
        "<",
        "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
        "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;Lcom/comcast/cim/model/user/service/UserSettingsDao;Lcom/comcast/cim/model/user/CurrentUser;Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;)V
    .locals 0
    .param p1, "playNowUserUserDao"    # Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;
    .param p3, "currentUser"    # Lcom/comcast/cim/model/user/CurrentUser;
    .param p4, "executor"    # Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;",
            "Lcom/comcast/cim/model/user/service/UserSettingsDao",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;",
            "Lcom/comcast/cim/model/user/CurrentUser;",
            "Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 14
    .local p2, "playNowUserSettingsUserSettingsDao":Lcom/comcast/cim/model/user/service/UserSettingsDao;, "Lcom/comcast/cim/model/user/service/UserSettingsDao<Lcom/xfinity/playerlib/model/user/PlayerUserSettings;>;"
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/comcast/cim/model/user/XipUserManager;-><init>(Lcom/comcast/cim/model/user/UserDao;Lcom/comcast/cim/model/user/service/UserSettingsDao;Lcom/comcast/cim/model/user/CurrentUser;Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;)V

    .line 15
    return-void
.end method


# virtual methods
.method public bridge synthetic createUser(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)Lcom/comcast/cim/model/user/XipUser;
    .locals 1

    .prologue
    .line 11
    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->createUser(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)Lcom/xfinity/playerlib/model/user/PlayNowUser;

    move-result-object v0

    return-object v0
.end method

.method public createUser(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)Lcom/xfinity/playerlib/model/user/PlayNowUser;
    .locals 1
    .param p1, "userCredentials"    # Lcom/comcast/cim/android/authentication/UserCredentials;
    .param p2, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;

    .prologue
    .line 19
    new-instance v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-direct {v0, p1, p2}, Lcom/xfinity/playerlib/model/user/PlayNowUser;-><init>(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)V

    return-object v0
.end method
