.class public Lcom/amazon/identity/platform/setting/PlatformSettings;
.super Ljava/lang/Object;
.source "PlatformSettings.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;,
        Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sTheOnlyInstance:Lcom/amazon/identity/platform/setting/PlatformSettings;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/identity/platform/setting/PlatformSettings;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/platform/setting/PlatformSettings;->TAG:Ljava/lang/String;

    .line 25
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/identity/platform/setting/PlatformSettings;->sTheOnlyInstance:Lcom/amazon/identity/platform/setting/PlatformSettings;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 29
    const-class v2, Lcom/amazon/identity/platform/setting/PlatformSettings;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/amazon/identity/platform/setting/PlatformSettings;->sTheOnlyInstance:Lcom/amazon/identity/platform/setting/PlatformSettings;

    if-eqz v1, :cond_0

    .line 31
    sget-object v1, Lcom/amazon/identity/platform/setting/PlatformSettings;->sTheOnlyInstance:Lcom/amazon/identity/platform/setting/PlatformSettings;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    :goto_0
    monitor-exit v2

    return-object v1

    .line 36
    :cond_0
    :try_start_1
    const-string/jumbo v1, "com.amazon.dcp.settings.SettingsCache"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 50
    :try_start_2
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 51
    if-nez v1, :cond_1

    .line 53
    sget-object v1, Lcom/amazon/identity/platform/setting/PlatformSettings;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Can\'t initialize DCP settings without an application context; using defaults"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    new-instance v1, Lcom/amazon/identity/platform/setting/PlatformSettings;

    invoke-direct {v1}, Lcom/amazon/identity/platform/setting/PlatformSettings;-><init>()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 29
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1

    .line 40
    :catch_0
    move-exception v1

    :try_start_3
    sget-object v1, Lcom/amazon/identity/platform/setting/PlatformSettings;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "DCP settings not available; using defaults"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    new-instance v1, Lcom/amazon/identity/platform/setting/PlatformSettings;

    invoke-direct {v1}, Lcom/amazon/identity/platform/setting/PlatformSettings;-><init>()V

    .line 44
    sput-object v1, Lcom/amazon/identity/platform/setting/PlatformSettings;->sTheOnlyInstance:Lcom/amazon/identity/platform/setting/PlatformSettings;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 62
    :cond_1
    :try_start_4
    invoke-static {p0}, Lcom/amazon/identity/platform/setting/DCPSettings;->getDCPSettings(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/DCPSettings;

    move-result-object v1

    .line 63
    sput-object v1, Lcom/amazon/identity/platform/setting/PlatformSettings;->sTheOnlyInstance:Lcom/amazon/identity/platform/setting/PlatformSettings;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 65
    :catch_1
    move-exception v0

    .line 67
    .local v0, "e":Ljava/lang/Exception;
    :try_start_5
    sget-object v1, Lcom/amazon/identity/platform/setting/PlatformSettings;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Failed to initialize DCP settings; using defaults"

    invoke-static {v1, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 68
    new-instance v1, Lcom/amazon/identity/platform/setting/PlatformSettings;

    invoke-direct {v1}, Lcom/amazon/identity/platform/setting/PlatformSettings;-><init>()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_0
.end method


# virtual methods
.method public addListener(Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;

    .prologue
    .line 99
    return-void
.end method

.method public getSettingBoolean(Ljava/lang/String;Z)Z
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Z

    .prologue
    .line 84
    return p2
.end method

.method public declared-synchronized getSettingInteger(Ljava/lang/String;I)I
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 94
    monitor-enter p0

    monitor-exit p0

    return p2
.end method

.method public getSettingLong(Ljava/lang/String;J)J
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 89
    return-wide p2
.end method

.method public getSettingString(Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p1, "nameSpace"    # Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 79
    return-object p3
.end method

.method public final getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 74
    sget-object v0, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->Default:Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
