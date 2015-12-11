.class public Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;
.super Ljava/lang/Object;
.source "PreferencesUserSettingsStore.java"

# interfaces
.implements Lcom/comcast/cim/model/services/KeyValueStore;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S::",
        "Lcom/comcast/cim/model/user/service/UserSettings;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/model/services/KeyValueStore",
        "<",
        "Ljava/lang/String;",
        "TS;>;"
    }
.end annotation


# instance fields
.field private final deserializer:Lcom/comcast/cim/utils/JsonDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<TS;>;"
        }
    .end annotation
.end field

.field private final preferences:Landroid/content/SharedPreferences;

.field private final serializer:Lcom/comcast/cim/utils/JsonSerializer;

.field private final userSettingsClazz:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TS;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/SharedPreferences;Lcom/comcast/cim/utils/JsonSerializer;Lcom/comcast/cim/utils/JsonDeserializer;Ljava/lang/Class;)V
    .locals 0
    .param p1, "preferences"    # Landroid/content/SharedPreferences;
    .param p2, "serializer"    # Lcom/comcast/cim/utils/JsonSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/SharedPreferences;",
            "Lcom/comcast/cim/utils/JsonSerializer;",
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<TS;>;",
            "Ljava/lang/Class",
            "<TS;>;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;, "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore<TS;>;"
    .local p3, "deserializer":Lcom/comcast/cim/utils/JsonDeserializer;, "Lcom/comcast/cim/utils/JsonDeserializer<TS;>;"
    .local p4, "userSettingsClazz":Ljava/lang/Class;, "Ljava/lang/Class<TS;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->preferences:Landroid/content/SharedPreferences;

    .line 18
    iput-object p2, p0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->serializer:Lcom/comcast/cim/utils/JsonSerializer;

    .line 19
    iput-object p3, p0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->deserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    .line 20
    iput-object p4, p0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->userSettingsClazz:Ljava/lang/Class;

    .line 21
    return-void
.end method


# virtual methods
.method public get(Ljava/lang/String;)Lcom/comcast/cim/model/user/service/UserSettings;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TS;"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;, "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore<TS;>;"
    const/4 v1, 0x0

    .line 33
    iget-object v2, p0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 34
    .local v0, "settings":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 37
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->deserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    iget-object v2, p0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->userSettingsClazz:Ljava/lang/Class;

    invoke-virtual {v1, v0, v2}, Lcom/comcast/cim/utils/JsonDeserializer;->deserialize(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/model/user/service/UserSettings;

    goto :goto_0
.end method

.method public bridge synthetic get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 8
    .local p0, "this":Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;, "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore<TS;>;"
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->get(Ljava/lang/String;)Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic put(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 8
    .local p0, "this":Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;, "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore<TS;>;"
    check-cast p1, Ljava/lang/String;

    check-cast p2, Lcom/comcast/cim/model/user/service/UserSettings;

    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->put(Ljava/lang/String;Lcom/comcast/cim/model/user/service/UserSettings;)V

    return-void
.end method

.method public put(Ljava/lang/String;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/comcast/cim/model/user/service/UserSettings;

    .prologue
    .line 25
    .local p0, "this":Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;, "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore<TS;>;"
    iget-object v2, p0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 26
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    iget-object v2, p0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;->serializer:Lcom/comcast/cim/utils/JsonSerializer;

    invoke-virtual {v2, p2}, Lcom/comcast/cim/utils/JsonSerializer;->serialize(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 27
    .local v1, "json":Ljava/lang/String;
    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 28
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 29
    return-void
.end method
