.class public Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;
.super Lcom/comcast/cim/model/user/UserDao;
.source "PlayNowUserDao.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/model/user/UserDao",
        "<",
        "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/comcast/cim/model/user/service/PreferencesUserStore;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/service/PreferencesUserStore",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 10
    .local p1, "userStore":Lcom/comcast/cim/model/user/service/PreferencesUserStore;, "Lcom/comcast/cim/model/user/service/PreferencesUserStore<Lcom/xfinity/playerlib/model/user/PlayNowUser;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/model/user/UserDao;-><init>(Lcom/comcast/cim/model/services/KeyValueStore;)V

    .line 11
    return-void
.end method
