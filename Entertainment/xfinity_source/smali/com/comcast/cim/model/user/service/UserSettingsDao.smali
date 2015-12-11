.class public Lcom/comcast/cim/model/user/service/UserSettingsDao;
.super Ljava/lang/Object;
.source "UserSettingsDao.java"

# interfaces
.implements Lcom/comcast/cim/model/services/KeyValueDao;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S::",
        "Lcom/comcast/cim/model/user/service/UserSettings;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/model/services/KeyValueDao",
        "<",
        "Lcom/comcast/cim/model/user/User;",
        "TS;>;"
    }
.end annotation


# instance fields
.field private final initializer:Lcom/comcast/cim/cmasl/utils/initializer/Initializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/initializer/Initializer",
            "<TS;>;"
        }
    .end annotation
.end field

.field private final store:Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore",
            "<TS;>;"
        }
    .end annotation
.end field

.field private final userSettingsFactory:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<TS;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;Lcom/comcast/cim/cmasl/utils/provider/Provider;Lcom/comcast/cim/cmasl/utils/initializer/Initializer;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore",
            "<TS;>;",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<TS;>;",
            "Lcom/comcast/cim/cmasl/utils/initializer/Initializer",
            "<TS;>;)V"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "this":Lcom/comcast/cim/model/user/service/UserSettingsDao;, "Lcom/comcast/cim/model/user/service/UserSettingsDao<TS;>;"
    .local p1, "store":Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;, "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore<TS;>;"
    .local p2, "userSettingsFactory":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<TS;>;"
    .local p3, "initializer":Lcom/comcast/cim/cmasl/utils/initializer/Initializer;, "Lcom/comcast/cim/cmasl/utils/initializer/Initializer<TS;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/comcast/cim/model/user/service/UserSettingsDao;->store:Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;

    .line 19
    iput-object p2, p0, Lcom/comcast/cim/model/user/service/UserSettingsDao;->userSettingsFactory:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 20
    iput-object p3, p0, Lcom/comcast/cim/model/user/service/UserSettingsDao;->initializer:Lcom/comcast/cim/cmasl/utils/initializer/Initializer;

    .line 21
    return-void
.end method

.method private getKey(Lcom/comcast/cim/model/user/User;)Ljava/lang/String;
    .locals 2
    .param p1, "user"    # Lcom/comcast/cim/model/user/User;

    .prologue
    .line 52
    .local p0, "this":Lcom/comcast/cim/model/user/service/UserSettingsDao;, "Lcom/comcast/cim/model/user/service/UserSettingsDao<TS;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "usersettings_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-interface {p1}, Lcom/comcast/cim/model/user/User;->getUserKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public get(Lcom/comcast/cim/model/user/User;)Lcom/comcast/cim/model/user/service/UserSettings;
    .locals 3
    .param p1, "user"    # Lcom/comcast/cim/model/user/User;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/User;",
            ")TS;"
        }
    .end annotation

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/model/user/service/UserSettingsDao;, "Lcom/comcast/cim/model/user/service/UserSettingsDao<TS;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/model/user/service/UserSettingsDao;->getKey(Lcom/comcast/cim/model/user/User;)Ljava/lang/String;

    move-result-object v0

    .line 35
    .local v0, "key":Ljava/lang/String;
    iget-object v2, p0, Lcom/comcast/cim/model/user/service/UserSettingsDao;->store:Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;

    invoke-virtual {v2, v0}, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->get(Ljava/lang/String;)Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    .line 36
    .local v1, "s":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    if-nez v1, :cond_0

    .line 37
    iget-object v2, p0, Lcom/comcast/cim/model/user/service/UserSettingsDao;->userSettingsFactory:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "s":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    check-cast v1, Lcom/comcast/cim/model/user/service/UserSettings;

    .line 38
    .restart local v1    # "s":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    iget-object v2, p0, Lcom/comcast/cim/model/user/service/UserSettingsDao;->initializer:Lcom/comcast/cim/cmasl/utils/initializer/Initializer;

    invoke-interface {v2, v1}, Lcom/comcast/cim/cmasl/utils/initializer/Initializer;->initialize(Ljava/lang/Object;)V

    .line 39
    iget-object v2, p0, Lcom/comcast/cim/model/user/service/UserSettingsDao;->store:Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;

    invoke-virtual {v2, v0, v1}, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->put(Ljava/lang/String;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 43
    :goto_0
    return-object v1

    .line 41
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/model/user/service/UserSettingsDao;->initializer:Lcom/comcast/cim/cmasl/utils/initializer/Initializer;

    invoke-interface {v2, v1}, Lcom/comcast/cim/cmasl/utils/initializer/Initializer;->initialize(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public put(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 2
    .param p1, "user"    # Lcom/comcast/cim/model/user/User;
    .param p2, "settings"    # Lcom/comcast/cim/model/user/service/UserSettings;

    .prologue
    .line 29
    .local p0, "this":Lcom/comcast/cim/model/user/service/UserSettingsDao;, "Lcom/comcast/cim/model/user/service/UserSettingsDao<TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/model/user/service/UserSettingsDao;->store:Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;

    invoke-direct {p0, p1}, Lcom/comcast/cim/model/user/service/UserSettingsDao;->getKey(Lcom/comcast/cim/model/user/User;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->put(Ljava/lang/String;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 30
    return-void
.end method
