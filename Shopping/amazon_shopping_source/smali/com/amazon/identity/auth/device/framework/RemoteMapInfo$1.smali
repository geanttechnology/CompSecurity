.class Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;
.super Ljava/lang/Object;
.source "RemoteMapInfo.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->fetchVersionInfo()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback",
        "<",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

.field final synthetic val$mapVersionInfoUri:Landroid/net/Uri;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Landroid/net/Uri;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->val$mapVersionInfoUri:Landroid/net/Uri;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public useContentProviderClient(Landroid/content/ContentProviderClient;)Ljava/lang/Object;
    .locals 7
    .param p1, "client"    # Landroid/content/ContentProviderClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 244
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->val$mapVersionInfoUri:Landroid/net/Uri;

    sget-object v0, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->QUERY_MAP_INFO_COLUMNS:Ljava/util/List;

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentProviderClient;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 252
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    :try_start_0
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_1

    .line 254
    :cond_0
    # getter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "No version info returned from package %s."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    # getter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mPackageName:Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$100(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 257
    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    .line 307
    :goto_0
    return-object v3

    .line 260
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    const-string/jumbo v1, "map_major_version"

    invoke-static {v6, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMajorVersion:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$202(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/Integer;)Ljava/lang/Integer;

    .line 263
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    const-string/jumbo v1, "map_minor_version"

    invoke-static {v6, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMinorVersion:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$302(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/Integer;)Ljava/lang/Integer;

    .line 266
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    const-string/jumbo v1, "map_sw_version"

    invoke-static {v6, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mSWVersion:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$402(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/Integer;)Ljava/lang/Integer;

    .line 270
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    const-string/jumbo v1, "current_device_type"

    invoke-static {v6, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mDeviceType:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$502(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/String;)Ljava/lang/String;

    .line 274
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    # getter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mDeviceType:Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$500(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    .line 276
    # getter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Package %s has a null device type. Defaulting to the central device type"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 279
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    # getter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$600(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralDeviceType:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/Platform;->getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mDeviceType:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$502(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/String;)Ljava/lang/String;

    .line 284
    :cond_2
    const-string/jumbo v0, "dsn_override"

    invoke-static {v6, v0}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->containsColumn(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 287
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    const-string/jumbo v1, "dsn_override"

    invoke-static {v6, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mOverrideDSN:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$702(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/String;)Ljava/lang/String;

    .line 298
    :goto_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    const-string/jumbo v1, "map_init_version"

    invoke-static {v6, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMAPInitVersion:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$802(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/Integer;)Ljava/lang/Integer;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 305
    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    goto/16 :goto_0

    .line 293
    :cond_3
    :try_start_2
    # getter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Package %s does not provide a custom DSN override"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;->this$0:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    # getter for: Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mPackageName:Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->access$100(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 305
    :catchall_0
    move-exception v0

    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    throw v0
.end method
