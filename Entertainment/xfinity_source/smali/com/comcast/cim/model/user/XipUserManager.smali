.class public abstract Lcom/comcast/cim/model/user/XipUserManager;
.super Lcom/comcast/cim/model/user/UserManager;
.source "XipUserManager.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<U:",
        "Lcom/comcast/cim/model/user/XipUser;",
        "S::",
        "Lcom/comcast/cim/model/user/service/UserSettings;",
        ">",
        "Lcom/comcast/cim/model/user/UserManager",
        "<TU;TS;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/comcast/cim/model/user/UserDao;Lcom/comcast/cim/model/user/service/UserSettingsDao;Lcom/comcast/cim/model/user/CurrentUser;Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;)V
    .locals 0
    .param p3, "currentUser"    # Lcom/comcast/cim/model/user/CurrentUser;
    .param p4, "saveUserExecutor"    # Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/UserDao",
            "<TU;>;",
            "Lcom/comcast/cim/model/user/service/UserSettingsDao",
            "<TS;>;",
            "Lcom/comcast/cim/model/user/CurrentUser;",
            "Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 11
    .local p0, "this":Lcom/comcast/cim/model/user/XipUserManager;, "Lcom/comcast/cim/model/user/XipUserManager<TU;TS;>;"
    .local p1, "userDao":Lcom/comcast/cim/model/user/UserDao;, "Lcom/comcast/cim/model/user/UserDao<TU;>;"
    .local p2, "userSettingsDao":Lcom/comcast/cim/model/user/service/UserSettingsDao;, "Lcom/comcast/cim/model/user/service/UserSettingsDao<TS;>;"
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/comcast/cim/model/user/UserManager;-><init>(Lcom/comcast/cim/model/user/UserDao;Lcom/comcast/cim/model/user/service/UserSettingsDao;Lcom/comcast/cim/model/user/CurrentUser;Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;)V

    .line 12
    return-void
.end method


# virtual methods
.method public abstract createUser(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)Lcom/comcast/cim/model/user/XipUser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/android/authentication/UserCredentials;",
            "Lcom/comcast/cim/model/user/AuthKeys;",
            ")TU;"
        }
    .end annotation
.end method
