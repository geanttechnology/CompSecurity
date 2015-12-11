.class Lcom/amazon/identity/platform/setting/DCPSettings;
.super Lcom/amazon/identity/platform/setting/PlatformSettings;
.source "DCPSettings.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/identity/platform/setting/DCPSettings;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/platform/setting/DCPSettings;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/identity/platform/setting/PlatformSettings;-><init>()V

    return-void
.end method

.method static getDCPSettings(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/DCPSettings;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 26
    invoke-static {p0}, Lcom/amazon/dcp/settings/SettingsCache;->setContext(Landroid/content/Context;)V

    .line 27
    invoke-static {}, Lcom/amazon/dcp/settings/SettingsCache;->waitForInitialSync()V

    .line 28
    new-instance v0, Lcom/amazon/identity/platform/setting/DCPSettings;

    invoke-direct {v0}, Lcom/amazon/identity/platform/setting/DCPSettings;-><init>()V

    return-object v0
.end method


# virtual methods
.method public addListener(Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;)V
    .locals 3
    .param p1, "listener"    # Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;

    .prologue
    .line 102
    :try_start_0
    invoke-static {}, Lcom/amazon/dcp/settings/SettingsCache;->getInstance()Lcom/amazon/dcp/settings/SettingsCache;

    move-result-object v1

    new-instance v2, Lcom/amazon/identity/platform/setting/DCPSettings$1;

    invoke-direct {v2, p0, p1}, Lcom/amazon/identity/platform/setting/DCPSettings$1;-><init>(Lcom/amazon/identity/platform/setting/DCPSettings;Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;)V

    invoke-virtual {v1, v2}, Lcom/amazon/dcp/settings/SettingsCache;->addListener(Lcom/amazon/dcp/settings/SettingsCache$IListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 117
    :goto_0
    return-void

    .line 113
    :catch_0
    move-exception v0

    .line 115
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/identity/platform/setting/DCPSettings;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to add DCP settings listener"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getSettingBoolean(Ljava/lang/String;Z)Z
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Z

    .prologue
    .line 60
    :try_start_0
    new-instance v1, Lcom/amazon/dcp/settings/SettingBoolean;

    invoke-direct {v1, p1, p2}, Lcom/amazon/dcp/settings/SettingBoolean;-><init>(Ljava/lang/String;Z)V

    invoke-virtual {v1}, Lcom/amazon/dcp/settings/SettingBoolean;->getValue()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result p2

    .line 65
    .end local p2    # "defaultValue":Z
    :goto_0
    return p2

    .line 62
    .restart local p2    # "defaultValue":Z
    :catch_0
    move-exception v0

    .line 64
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/identity/platform/setting/DCPSettings;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "DCP Settings throws exceptions. Returning default value."

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getSettingInteger(Ljava/lang/String;I)I
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 88
    :try_start_0
    new-instance v1, Lcom/amazon/dcp/settings/SettingInteger;

    invoke-direct {v1, p1, p2}, Lcom/amazon/dcp/settings/SettingInteger;-><init>(Ljava/lang/String;I)V

    invoke-virtual {v1}, Lcom/amazon/dcp/settings/SettingInteger;->getValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result p2

    .line 93
    .end local p2    # "defaultValue":I
    :goto_0
    return p2

    .line 90
    .restart local p2    # "defaultValue":I
    :catch_0
    move-exception v0

    .line 92
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/identity/platform/setting/DCPSettings;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "DCP Settings throws exceptions. Returning default value."

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getSettingLong(Ljava/lang/String;J)J
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 74
    :try_start_0
    new-instance v1, Lcom/amazon/dcp/settings/SettingLong;

    invoke-direct {v1, p1, p2, p3}, Lcom/amazon/dcp/settings/SettingLong;-><init>(Ljava/lang/String;J)V

    invoke-virtual {v1}, Lcom/amazon/dcp/settings/SettingLong;->getValue()J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide p2

    .line 79
    .end local p2    # "defaultValue":J
    :goto_0
    return-wide p2

    .line 76
    .restart local p2    # "defaultValue":J
    :catch_0
    move-exception v0

    .line 78
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/identity/platform/setting/DCPSettings;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "DCP Settings throws exceptions. Returning default value."

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getSettingString(Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "nameSpace"    # Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 35
    sget-object v2, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->DeviceGlobal:Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    if-ne p1, v2, :cond_0

    .line 37
    sget-object v1, Lcom/amazon/dcp/settings/SettingsNamespace;->DeviceGlobal:Lcom/amazon/dcp/settings/SettingsNamespace;

    .line 46
    .local v1, "settingsNamespace":Lcom/amazon/dcp/settings/SettingsNamespace;
    :goto_0
    :try_start_0
    new-instance v2, Lcom/amazon/dcp/settings/SettingString;

    invoke-direct {v2, v1, p2, p3}, Lcom/amazon/dcp/settings/SettingString;-><init>(Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/amazon/dcp/settings/SettingString;->getValue()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p3

    .line 51
    .end local p3    # "defaultValue":Ljava/lang/String;
    :goto_1
    return-object p3

    .line 41
    .end local v1    # "settingsNamespace":Lcom/amazon/dcp/settings/SettingsNamespace;
    .restart local p3    # "defaultValue":Ljava/lang/String;
    :cond_0
    sget-object v1, Lcom/amazon/dcp/settings/SettingsNamespace;->Default:Lcom/amazon/dcp/settings/SettingsNamespace;

    .restart local v1    # "settingsNamespace":Lcom/amazon/dcp/settings/SettingsNamespace;
    goto :goto_0

    .line 48
    :catch_0
    move-exception v0

    .line 50
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/identity/platform/setting/DCPSettings;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "DCP Settings throws exceptions. Returning default value."

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method
