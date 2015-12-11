.class public Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
.super Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
.source "SettingsInstance.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final DEFAULT_BT:D

.field private final DEFAULT_CELL:J

.field private final DEFAULT_DP:Ljava/lang/String;

.field private final DEFAULT_FRAGMENT_NOTIFICATION_RATE:I

.field private final DEFAULT_HEADROOM:J

.field private final DEFAULT_MAX_STORAGE:J

.field private final SEVEN_DAYS:J

.field private iFragmentNotificationRate:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->LOG_TAG:Ljava/lang/String;

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/ContentResolver;Ljava/lang/String;)V
    .locals 8
    .param p1, "resolver"    # Landroid/content/ContentResolver;
    .param p2, "aAuthority"    # Ljava/lang/String;

    .prologue
    const-wide/32 v6, 0x6400000

    const/16 v4, 0xa

    .line 33
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 21
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    iput-wide v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->DEFAULT_BT:D

    .line 22
    iput-wide v6, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->DEFAULT_HEADROOM:J

    .line 23
    iput-wide v6, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->DEFAULT_MAX_STORAGE:J

    .line 24
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->DEFAULT_CELL:J

    .line 25
    const-string v1, "/"

    iput-object v1, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->DEFAULT_DP:Ljava/lang/String;

    .line 26
    iput v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->DEFAULT_FRAGMENT_NOTIFICATION_RATE:I

    .line 27
    iput v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->iFragmentNotificationRate:I

    .line 28
    const-wide/32 v2, 0x93a80

    iput-wide v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->SEVEN_DAYS:J

    .line 34
    const-string v1, "registration_status"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    .line 35
    const-string v1, "registration_status"

    const-string v2, "1"

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    :cond_0
    const-string v1, "last_authentication"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_1

    .line 39
    const-string v1, "last_authentication"

    const-string v2, "-1"

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    :cond_1
    const/4 v0, -0x1

    .line 42
    .local v0, "default_invalid":I
    const-string v1, "last_sync"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_8

    .line 44
    const-string v1, "battery_threshold"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_2

    .line 45
    const-string v1, "battery_threshold"

    const-string v2, "1.0"

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    :cond_2
    const-string v1, "cell_data_quota"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_3

    .line 48
    const-string v1, "cell_data_quota"

    const-string v2, "0"

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    :cond_3
    const-string v1, "headroom"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_4

    .line 51
    const-string v1, "headroom"

    const-string v2, "104857600"

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    :cond_4
    const-string v1, "max_storage"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_5

    .line 54
    const-string v1, "max_storage"

    const-string v2, "104857600"

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    :cond_5
    const-string v1, "destination_path"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_6

    .line 57
    const-string v1, "destination_path"

    const-string v2, "/"

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    :cond_6
    const-string v1, "client_configuration_conn_to"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_7

    .line 60
    const-string v1, "client_configuration_conn_to"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    :cond_7
    const-string v1, "client_configuration_socket_to"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_8

    .line 63
    const-string v1, "client_configuration_socket_to"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    :cond_8
    const-string v1, "default_configuration_fragment_rate"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_9

    .line 68
    const-string v1, "default_configuration_fragment_rate"

    const-string v2, "10"

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    :cond_9
    const-string v1, "client_configuration_fragment_rate"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_a

    .line 71
    const-string v1, "client_configuration_fragment_rate"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->iFragmentNotificationRate:I

    .line 73
    :cond_a
    const-string v1, "cell_quota_start_date"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_b

    .line 74
    const-string v1, "cell_quota_start_date"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    :cond_b
    const-string v1, "cell_quota_used"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_c

    .line 77
    const-string v1, "cell_quota_used"

    const-string v2, "0"

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    :cond_c
    const-string v1, "downloader_init_state"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_d

    .line 80
    const-string v1, "downloader_init_state"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    :cond_d
    return-void
.end method


# virtual methods
.method public get(Ljava/lang/String;Z)Ljava/lang/String;
    .locals 2
    .param p1, "aKey"    # Ljava/lang/String;
    .param p2, "aReturnEffective"    # Z

    .prologue
    .line 170
    const/4 v0, 0x0

    .line 171
    .local v0, "value":Ljava/lang/String;
    if-eqz p2, :cond_0

    .line 172
    const-string v1, "battery_threshold"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 173
    const-string v1, "battery_threshold_override"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 186
    :cond_0
    :goto_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 188
    .end local v0    # "value":Ljava/lang/String;
    :goto_1
    return-object v0

    .line 174
    .restart local v0    # "value":Ljava/lang/String;
    :cond_1
    const-string v1, "cell_data_quota"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 175
    const-string v1, "cell_data_quota_override"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 176
    :cond_2
    const-string v1, "destination_path"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 177
    const-string v1, "destination_path_override"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 178
    :cond_3
    const-string v1, "headroom"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 179
    const-string v1, "headroom_override"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 180
    :cond_4
    const-string v1, "max_storage"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 181
    const-string v1, "max_storage_override"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 182
    :cond_5
    const-string v1, "default_configuration_fragment_rate"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 183
    const-string v1, "client_configuration_fragment_rate"

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 188
    :cond_6
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public getBundle()Landroid/os/Bundle;
    .locals 11

    .prologue
    const/4 v10, 0x2

    const/4 v5, 0x1

    const/4 v3, 0x0

    .line 86
    new-array v2, v10, [Ljava/lang/String;

    .line 87
    const-string v0, "name"

    aput-object v0, v2, v3

    .line 88
    const-string v0, "value"

    aput-object v0, v2, v5

    .line 91
    .local v2, "PROJECTION":[Ljava/lang/String;
    const/16 v0, 0x15

    new-array v4, v0, [Ljava/lang/String;

    .line 92
    const-string v0, "client_configuration_socket_to"

    aput-object v0, v4, v3

    .line 93
    const-string v0, "client_configuration_fragment_rate"

    aput-object v0, v4, v5

    .line 94
    const-string v0, "default_configuration_fragment_rate"

    aput-object v0, v4, v10

    const/4 v0, 0x3

    .line 95
    const-string v3, "client_configuration_conn_to"

    aput-object v3, v4, v0

    const/4 v0, 0x4

    .line 96
    const-string v3, "root_destination_path"

    aput-object v3, v4, v0

    const/4 v0, 0x5

    .line 97
    const-string v3, "client_configuration_headers"

    aput-object v3, v4, v0

    const/4 v0, 0x6

    .line 99
    const-string v3, "destination_path"

    aput-object v3, v4, v0

    const/4 v0, 0x7

    .line 100
    const-string v3, "max_storage"

    aput-object v3, v4, v0

    const/16 v0, 0x8

    .line 101
    const-string v3, "headroom"

    aput-object v3, v4, v0

    const/16 v0, 0x9

    .line 102
    const-string v3, "cell_data_quota"

    aput-object v3, v4, v0

    const/16 v0, 0xa

    .line 103
    const-string v3, "battery_threshold"

    aput-object v3, v4, v0

    const/16 v0, 0xb

    .line 105
    const-string v3, "headroom_override"

    aput-object v3, v4, v0

    const/16 v0, 0xc

    .line 106
    const-string v3, "max_storage_override"

    aput-object v3, v4, v0

    const/16 v0, 0xd

    .line 107
    const-string v3, "cell_data_quota_override"

    aput-object v3, v4, v0

    const/16 v0, 0xe

    .line 108
    const-string v3, "battery_threshold_override"

    aput-object v3, v4, v0

    const/16 v0, 0xf

    .line 109
    const-string v3, "destination_path_override"

    aput-object v3, v4, v0

    const/16 v0, 0x10

    .line 111
    const-string v3, "registration_status"

    aput-object v3, v4, v0

    const/16 v0, 0x11

    .line 112
    const-string v3, "last_authentication"

    aput-object v3, v4, v0

    const/16 v0, 0x12

    .line 114
    const-string v3, "downloader_init_state"

    aput-object v3, v4, v0

    const/16 v0, 0x13

    .line 116
    const-string v3, "cell_quota_used"

    aput-object v3, v4, v0

    const/16 v0, 0x14

    .line 117
    const-string v3, "cell_quota_start_date"

    aput-object v3, v4, v0

    .line 120
    .local v4, "ARGS":[Ljava/lang/String;
    const-string v6, "name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=?"

    .line 147
    .local v6, "WHERE":Ljava/lang/String;
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->iAuthority:Ljava/lang/String;

    invoke-static {v0}, Lcom/penthera/virtuososdk/database/impl/provider/Registry$RegistryColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 148
    .local v1, "registryUri":Landroid/net/Uri;
    const/4 v8, 0x0

    .line 149
    .local v8, "cursor":Landroid/database/Cursor;
    new-instance v7, Landroid/os/Bundle;

    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 151
    .local v7, "bundle":Landroid/os/Bundle;
    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->resolver:Landroid/content/ContentResolver;

    const-string v3, "name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=? OR name=?"

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 153
    if-eqz v8, :cond_0

    .line 154
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->isAfterLast()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_2

    .line 161
    :cond_0
    if-eqz v8, :cond_1

    .line 162
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 166
    :cond_1
    :goto_1
    return-object v7

    .line 155
    :cond_2
    const/4 v0, 0x0

    :try_start_1
    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x1

    invoke-interface {v8, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v0, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 158
    :catch_0
    move-exception v9

    .line 159
    .local v9, "e":Ljava/lang/Exception;
    :try_start_2
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Registry getBundle exception: "

    invoke-static {v0, v3, v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 161
    if-eqz v8, :cond_1

    .line 162
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 160
    .end local v9    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 161
    if-eqz v8, :cond_3

    .line 162
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 164
    :cond_3
    throw v0
.end method
