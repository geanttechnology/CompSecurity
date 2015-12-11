.class public abstract Lcom/comcast/cim/model/user/UserManager;
.super Ljava/lang/Object;
.source "UserManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/model/user/UserManager$UserManagerListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/comcast/cim/model/user/User;",
        "S::",
        "Lcom/comcast/cim/model/user/service/UserSettings;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final currentUser:Lcom/comcast/cim/model/user/CurrentUser;

.field private final listeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/model/user/UserManager$UserManagerListener",
            "<TT;TS;>;>;"
        }
    .end annotation
.end field

.field private loggedInUser:Lcom/comcast/cim/model/user/User;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private loggedInUserSettings:Lcom/comcast/cim/model/user/service/UserSettings;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TS;"
        }
    .end annotation
.end field

.field private saveUserExecutor:Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;

.field private final userDao:Lcom/comcast/cim/model/user/UserDao;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/UserDao",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final userSettingsDao:Lcom/comcast/cim/model/user/service/UserSettingsDao;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/service/UserSettingsDao",
            "<TS;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/model/user/UserDao;Lcom/comcast/cim/model/user/service/UserSettingsDao;Lcom/comcast/cim/model/user/CurrentUser;Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;)V
    .locals 1
    .param p3, "currentUser"    # Lcom/comcast/cim/model/user/CurrentUser;
    .param p4, "saveUserExecutor"    # Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/UserDao",
            "<TT;>;",
            "Lcom/comcast/cim/model/user/service/UserSettingsDao",
            "<TS;>;",
            "Lcom/comcast/cim/model/user/CurrentUser;",
            "Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 31
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    .local p1, "userDao":Lcom/comcast/cim/model/user/UserDao;, "Lcom/comcast/cim/model/user/UserDao<TT;>;"
    .local p2, "userSettingsDao":Lcom/comcast/cim/model/user/service/UserSettingsDao;, "Lcom/comcast/cim/model/user/service/UserSettingsDao<TS;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    .line 32
    iput-object p1, p0, Lcom/comcast/cim/model/user/UserManager;->userDao:Lcom/comcast/cim/model/user/UserDao;

    .line 33
    iput-object p2, p0, Lcom/comcast/cim/model/user/UserManager;->userSettingsDao:Lcom/comcast/cim/model/user/service/UserSettingsDao;

    .line 34
    iput-object p3, p0, Lcom/comcast/cim/model/user/UserManager;->currentUser:Lcom/comcast/cim/model/user/CurrentUser;

    .line 35
    iput-object p4, p0, Lcom/comcast/cim/model/user/UserManager;->saveUserExecutor:Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;

    .line 36
    return-void
.end method

.method private createUserSaveTask(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)Lcom/comcast/cim/model/user/service/UserSaveTask;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)",
            "Lcom/comcast/cim/model/user/service/UserSaveTask;"
        }
    .end annotation

    .prologue
    .line 149
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    .local p1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    .local p2, "settings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    new-instance v0, Lcom/comcast/cim/model/user/service/UserSaveTask;

    invoke-direct {v0, p0, p1, p2}, Lcom/comcast/cim/model/user/service/UserSaveTask;-><init>(Lcom/comcast/cim/model/user/UserManager;Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    return-object v0
.end method

.method private loadCurrentUser()V
    .locals 4

    .prologue
    .line 125
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    const/4 v1, 0x0

    .line 126
    .local v1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    const/4 v2, 0x0

    .line 128
    .local v2, "userSettings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    iget-object v3, p0, Lcom/comcast/cim/model/user/UserManager;->currentUser:Lcom/comcast/cim/model/user/CurrentUser;

    invoke-virtual {v3}, Lcom/comcast/cim/model/user/CurrentUser;->getKey()Ljava/lang/String;

    move-result-object v0

    .line 129
    .local v0, "currentUserKey":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 130
    iget-object v3, p0, Lcom/comcast/cim/model/user/UserManager;->userDao:Lcom/comcast/cim/model/user/UserDao;

    invoke-virtual {v3, v0}, Lcom/comcast/cim/model/user/UserDao;->get(Ljava/lang/String;)Lcom/comcast/cim/model/user/User;

    move-result-object v1

    .line 132
    if-eqz v1, :cond_0

    .line 133
    iget-object v3, p0, Lcom/comcast/cim/model/user/UserManager;->userSettingsDao:Lcom/comcast/cim/model/user/service/UserSettingsDao;

    invoke-virtual {v3, v1}, Lcom/comcast/cim/model/user/service/UserSettingsDao;->get(Lcom/comcast/cim/model/user/User;)Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v2

    .line 136
    :cond_0
    iput-object v1, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUser:Lcom/comcast/cim/model/user/User;

    .line 137
    iput-object v2, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUserSettings:Lcom/comcast/cim/model/user/service/UserSettings;

    .line 139
    iget-object v3, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUser:Lcom/comcast/cim/model/user/User;

    if-eqz v3, :cond_1

    .line 140
    invoke-direct {p0, v1, v2}, Lcom/comcast/cim/model/user/UserManager;->onUserLoaded(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 142
    :cond_1
    return-void
.end method

.method private onUserLoaded(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation

    .prologue
    .line 47
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    .local p1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    .local p2, "settings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    iget-object v2, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    monitor-enter v2

    .line 48
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/model/user/UserManager$UserManagerListener;

    .line 49
    .local v0, "listener":Lcom/comcast/cim/model/user/UserManager$UserManagerListener;, "Lcom/comcast/cim/model/user/UserManager$UserManagerListener<TT;TS;>;"
    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/model/user/UserManager$UserManagerListener;->onUserLoaded(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    goto :goto_0

    .line 51
    .end local v0    # "listener":Lcom/comcast/cim/model/user/UserManager$UserManagerListener;, "Lcom/comcast/cim/model/user/UserManager$UserManagerListener<TT;TS;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_0
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 52
    return-void
.end method


# virtual methods
.method public addUserManagerListener(Lcom/comcast/cim/model/user/UserManager$UserManagerListener;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/UserManager$UserManagerListener",
            "<TT;TS;>;)V"
        }
    .end annotation

    .prologue
    .line 39
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    .local p1, "listener":Lcom/comcast/cim/model/user/UserManager$UserManagerListener;, "Lcom/comcast/cim/model/user/UserManager$UserManagerListener<TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 40
    return-void
.end method

.method public getHashedOmnitureGuid()Ljava/lang/String;
    .locals 2

    .prologue
    .line 162
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/user/UserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v1

    .line 163
    .local v1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    if-nez v1, :cond_1

    .line 164
    const-string v0, ""

    .line 169
    :cond_0
    :goto_0
    return-object v0

    .line 167
    :cond_1
    invoke-interface {v1}, Lcom/comcast/cim/model/user/User;->getOmnitureTrackingKey()Ljava/lang/String;

    move-result-object v0

    .line 169
    .local v0, "trackingKey":Ljava/lang/String;
    if-nez v0, :cond_0

    const-string v0, ""

    goto :goto_0
.end method

.method public getUser()Lcom/comcast/cim/model/user/User;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 79
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    monitor-enter p0

    .line 80
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUser:Lcom/comcast/cim/model/user/User;

    if-nez v0, :cond_0

    .line 81
    invoke-direct {p0}, Lcom/comcast/cim/model/user/UserManager;->loadCurrentUser()V

    .line 84
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUser:Lcom/comcast/cim/model/user/User;

    monitor-exit p0

    return-object v0

    .line 85
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TS;"
        }
    .end annotation

    .prologue
    .line 89
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    monitor-enter p0

    .line 90
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUserSettings:Lcom/comcast/cim/model/user/service/UserSettings;

    if-nez v0, :cond_0

    .line 91
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "UserSettings for the logged in User is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 94
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 93
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUserSettings:Lcom/comcast/cim/model/user/service/UserSettings;

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v0
.end method

.method public onUserChanged(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation

    .prologue
    .line 71
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    .local p1, "newUser":Lcom/comcast/cim/model/user/User;, "TT;"
    .local p2, "settings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    iget-object v2, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    monitor-enter v2

    .line 72
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/model/user/UserManager$UserManagerListener;

    .line 73
    .local v0, "listener":Lcom/comcast/cim/model/user/UserManager$UserManagerListener;, "Lcom/comcast/cim/model/user/UserManager$UserManagerListener<TT;TS;>;"
    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/model/user/UserManager$UserManagerListener;->onUserChanged(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    goto :goto_0

    .line 75
    .end local v0    # "listener":Lcom/comcast/cim/model/user/UserManager$UserManagerListener;, "Lcom/comcast/cim/model/user/UserManager$UserManagerListener<TT;TS;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_0
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 76
    return-void
.end method

.method public onUserLoggedIn(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation

    .prologue
    .line 55
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    .local p1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    .local p2, "settings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    iget-object v2, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    monitor-enter v2

    .line 56
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/model/user/UserManager$UserManagerListener;

    .line 57
    .local v0, "listener":Lcom/comcast/cim/model/user/UserManager$UserManagerListener;, "Lcom/comcast/cim/model/user/UserManager$UserManagerListener<TT;TS;>;"
    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/model/user/UserManager$UserManagerListener;->onUserLoggedIn(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    goto :goto_0

    .line 59
    .end local v0    # "listener":Lcom/comcast/cim/model/user/UserManager$UserManagerListener;, "Lcom/comcast/cim/model/user/UserManager$UserManagerListener<TT;TS;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_0
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 60
    return-void
.end method

.method public onUserLoggedOut()V
    .locals 4

    .prologue
    .line 63
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    iget-object v2, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    monitor-enter v2

    .line 64
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/model/user/UserManager;->listeners:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/model/user/UserManager$UserManagerListener;

    .line 65
    .local v0, "listener":Lcom/comcast/cim/model/user/UserManager$UserManagerListener;
    invoke-interface {v0}, Lcom/comcast/cim/model/user/UserManager$UserManagerListener;->onUserLoggedOut()V

    goto :goto_0

    .line 67
    .end local v0    # "listener":Lcom/comcast/cim/model/user/UserManager$UserManagerListener;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_0
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 68
    return-void
.end method

.method public saveUser(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation

    .prologue
    .line 153
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    .local p1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    .local p2, "userSettings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    monitor-enter p0

    .line 154
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 155
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->userDao:Lcom/comcast/cim/model/user/UserDao;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/model/user/UserDao;->put(Lcom/comcast/cim/model/user/User;)V

    .line 156
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->userSettingsDao:Lcom/comcast/cim/model/user/service/UserSettingsDao;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/cim/model/user/service/UserSettingsDao;->put(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 158
    :cond_0
    monitor-exit p0

    .line 159
    return-void

    .line 158
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public saveUserAsync()V
    .locals 3

    .prologue
    .line 145
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->saveUserExecutor:Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;

    iget-object v1, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUser:Lcom/comcast/cim/model/user/User;

    iget-object v2, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUserSettings:Lcom/comcast/cim/model/user/service/UserSettings;

    invoke-direct {p0, v1, v2}, Lcom/comcast/cim/model/user/UserManager;->createUserSaveTask(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)Lcom/comcast/cim/model/user/service/UserSaveTask;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 146
    return-void
.end method

.method public setUser(Lcom/comcast/cim/model/user/User;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 98
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    .local p1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    monitor-enter p0

    .line 99
    :try_start_0
    invoke-interface {p1}, Lcom/comcast/cim/model/user/User;->getUserKey()Ljava/lang/String;

    move-result-object v0

    .line 100
    .local v0, "currentUserKey":Ljava/lang/String;
    iget-object v3, p0, Lcom/comcast/cim/model/user/UserManager;->currentUser:Lcom/comcast/cim/model/user/CurrentUser;

    invoke-virtual {v3, v0}, Lcom/comcast/cim/model/user/CurrentUser;->setKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 101
    .local v1, "previousUserKey":Ljava/lang/String;
    iget-object v3, p0, Lcom/comcast/cim/model/user/UserManager;->userDao:Lcom/comcast/cim/model/user/UserDao;

    invoke-virtual {v3, p1}, Lcom/comcast/cim/model/user/UserDao;->put(Lcom/comcast/cim/model/user/User;)V

    .line 103
    iget-object v3, p0, Lcom/comcast/cim/model/user/UserManager;->userSettingsDao:Lcom/comcast/cim/model/user/service/UserSettingsDao;

    invoke-virtual {v3, p1}, Lcom/comcast/cim/model/user/service/UserSettingsDao;->get(Lcom/comcast/cim/model/user/User;)Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v2

    .line 105
    .local v2, "userSettings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    iput-object p1, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUser:Lcom/comcast/cim/model/user/User;

    .line 106
    iput-object v2, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUserSettings:Lcom/comcast/cim/model/user/service/UserSettings;

    .line 107
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 108
    invoke-virtual {p0, p1, v2}, Lcom/comcast/cim/model/user/UserManager;->onUserChanged(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 110
    :cond_0
    invoke-virtual {p0, p1, v2}, Lcom/comcast/cim/model/user/UserManager;->onUserLoggedIn(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 111
    monitor-exit p0

    .line 112
    return-void

    .line 111
    .end local v0    # "currentUserKey":Ljava/lang/String;
    .end local v1    # "previousUserKey":Ljava/lang/String;
    .end local v2    # "userSettings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    :catchall_0
    move-exception v3

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method public signOutUser()V
    .locals 1

    .prologue
    .line 115
    .local p0, "this":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->currentUser:Lcom/comcast/cim/model/user/CurrentUser;

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/CurrentUser;->forget()V

    .line 116
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/model/user/UserManager;->loggedInUser:Lcom/comcast/cim/model/user/User;

    .line 117
    invoke-virtual {p0}, Lcom/comcast/cim/model/user/UserManager;->onUserLoggedOut()V

    .line 118
    return-void
.end method
