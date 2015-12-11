.class Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
.super Ljava/lang/Object;
.source "DownloadEngineClientManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ClientStorageInfo"
.end annotation


# instance fields
.field iAuthority:Ljava/lang/String;

.field iAvailable:D

.field iAvailableForStorage:D

.field iAvailableLessHeadroom:D

.field iFree:D

.field iTotal:D

.field iUsedByApp:D

.field final synthetic this$0:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;Ljava/lang/String;)V
    .locals 2
    .param p2, "auth"    # Ljava/lang/String;

    .prologue
    const-wide/16 v0, 0x0

    .line 943
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->this$0:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 936
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iFree:D

    .line 937
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iUsedByApp:D

    .line 938
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iTotal:D

    .line 939
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    .line 940
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableForStorage:D

    .line 941
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableLessHeadroom:D

    .line 944
    iput-object p2, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAuthority:Ljava/lang/String;

    .line 945
    return-void
.end method


# virtual methods
.method reset()V
    .locals 2

    .prologue
    const-wide/16 v0, 0x0

    .line 1046
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iFree:D

    .line 1047
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iUsedByApp:D

    .line 1048
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iTotal:D

    .line 1049
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    .line 1050
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableForStorage:D

    .line 1051
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableLessHeadroom:D

    .line 1052
    return-void
.end method

.method update(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V
    .locals 2
    .param p1, "clientSettings"    # Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    .prologue
    .line 948
    if-nez p1, :cond_0

    .line 949
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->reset()V

    .line 955
    :goto_0
    return-void

    .line 953
    :cond_0
    const-string v1, "root_destination_path"

    invoke-virtual {p1, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 954
    .local v0, "mediaPath":Ljava/lang/String;
    invoke-virtual {p0, v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->update(Ljava/lang/String;Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V

    goto :goto_0
.end method

.method update(Ljava/lang/String;Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V
    .locals 24
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "clientSettings"    # Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    .prologue
    .line 959
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->this$0:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->diskStatusOK()Z

    move-result v18

    if-eqz v18, :cond_0

    invoke-static/range {p1 .. p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v18

    if-eqz v18, :cond_1

    .line 960
    :cond_0
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$0()Ljava/lang/String;

    move-result-object v18

    const-string v19, "no path resetting storage"

    invoke-static/range {v18 .. v19}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 961
    invoke-virtual/range {p0 .. p0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->reset()V

    .line 1043
    :goto_0
    return-void

    .line 964
    :cond_1
    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "+updateStorageInfo \"storage_info\":{\"free_storage\" : "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iFree:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 965
    const-string v19, ", \"total_storage\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iTotal:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 966
    const-string v19, ", \"app_storage\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iUsedByApp:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 967
    const-string v19, ", \"available\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 968
    const-string v19, ", \"availableLessHeadroom\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableLessHeadroom:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 969
    const-string v19, ", \"available_storage\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableForStorage:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "}"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 964
    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 971
    .local v11, "logString":Ljava/lang/String;
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$0()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-static {v0, v11}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 973
    new-instance v17, Landroid/os/StatFs;

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-direct {v0, v1}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    .line 975
    .local v17, "stat":Landroid/os/StatFs;
    invoke-virtual/range {v17 .. v17}, Landroid/os/StatFs;->getAvailableBlocks()I

    move-result v18

    move/from16 v0, v18

    int-to-long v4, v0

    .line 976
    .local v4, "ab":J
    invoke-virtual/range {v17 .. v17}, Landroid/os/StatFs;->getBlockSize()I

    move-result v18

    move/from16 v0, v18

    int-to-long v8, v0

    .line 977
    .local v8, "bs":J
    invoke-virtual/range {v17 .. v17}, Landroid/os/StatFs;->getBlockCount()I

    move-result v18

    move/from16 v0, v18

    int-to-long v6, v0

    .line 979
    .local v6, "bc":J
    mul-long v18, v4, v8

    move-wide/from16 v0, v18

    long-to-double v0, v0

    move-wide/from16 v18, v0

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iFree:D

    .line 980
    mul-long v18, v6, v8

    move-wide/from16 v0, v18

    long-to-double v0, v0

    move-wide/from16 v18, v0

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iTotal:D

    .line 981
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->this$0:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAuthority:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->calcDiskUsage(Ljava/lang/String;)D

    move-result-wide v18

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iUsedByApp:D

    .line 984
    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "from stat \"storage_info\":{\"free_storage\" : "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iFree:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 985
    const-string v19, ", \"total_storage\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iTotal:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 986
    const-string v19, ", \"app_storage\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iUsedByApp:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "}"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 984
    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 987
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$0()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-static {v0, v11}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 989
    const-string v18, "headroom_override"

    move-object/from16 v0, p2

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 990
    .local v10, "h":Ljava/lang/String;
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v18

    if-eqz v18, :cond_2

    .line 991
    const-string v18, "headroom"

    move-object/from16 v0, p2

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 992
    :cond_2
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v18

    if-eqz v18, :cond_3

    .line 993
    const-string v10, "-1"

    .line 995
    :cond_3
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$0()Ljava/lang/String;

    move-result-object v18

    new-instance v19, Ljava/lang/StringBuilder;

    const-string v20, "headroom from registry ["

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v19

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " ]"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v19}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 997
    const-string v18, "max_storage_override"

    move-object/from16 v0, p2

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 998
    .local v16, "ms":Ljava/lang/String;
    invoke-static/range {v16 .. v16}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v18

    if-eqz v18, :cond_4

    .line 999
    const-string v18, "max_storage"

    move-object/from16 v0, p2

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 1000
    :cond_4
    invoke-static/range {v16 .. v16}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v18

    if-eqz v18, :cond_5

    .line 1001
    const-string v16, "-1"

    .line 1003
    :cond_5
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$0()Ljava/lang/String;

    move-result-object v18

    new-instance v19, Ljava/lang/StringBuilder;

    const-string v20, "max storage from registry ["

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " ]"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v19}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1005
    invoke-static/range {v16 .. v16}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v14

    .line 1006
    .local v14, "max_storage":D
    invoke-static {v10}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v12

    .line 1009
    .local v12, "headroom":D
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$0()Ljava/lang/String;

    move-result-object v18

    new-instance v19, Ljava/lang/StringBuilder;

    const-string v20, "After parse - max storage [ "

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v20, "%1$,.2f"

    const/16 v21, 0x1

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-static {v14, v15}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v23

    aput-object v23, v21, v22

    invoke-static/range {v20 .. v21}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " ] headroom [ "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "%1$,.2f"

    const/16 v21, 0x1

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v23

    aput-object v23, v21, v22

    invoke-static/range {v20 .. v21}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " ]"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v19}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1011
    const-wide/high16 v18, -0x4010000000000000L    # -1.0

    cmpl-double v18, v14, v18

    if-nez v18, :cond_8

    .line 1013
    move-object/from16 v0, p0

    iget-wide v14, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iTotal:D

    .line 1018
    :goto_1
    const-wide/high16 v18, -0x4010000000000000L    # -1.0

    cmpl-double v18, v12, v18

    if-nez v18, :cond_6

    .line 1019
    const-wide/16 v12, 0x0

    .line 1024
    :cond_6
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$0()Ljava/lang/String;

    move-result-object v18

    new-instance v19, Ljava/lang/StringBuilder;

    const-string v20, "After checks for disabled -max storage [ "

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v20, "%1$,.2f"

    const/16 v21, 0x1

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-static {v14, v15}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v23

    aput-object v23, v21, v22

    invoke-static/range {v20 .. v21}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " ] headroom [ "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "%1$,.2f"

    const/16 v21, 0x1

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v23

    aput-object v23, v21, v22

    invoke-static/range {v20 .. v21}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " ]"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v19}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1028
    const-wide/16 v18, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iUsedByApp:D

    move-wide/from16 v20, v0

    sub-double v20, v14, v20

    invoke-static/range {v18 .. v21}, Ljava/lang/Math;->max(DD)D

    move-result-wide v18

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableForStorage:D

    .line 1029
    const-wide/16 v18, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iFree:D

    move-wide/from16 v20, v0

    sub-double v20, v20, v12

    invoke-static/range {v18 .. v21}, Ljava/lang/Math;->max(DD)D

    move-result-wide v18

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableLessHeadroom:D

    .line 1031
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableLessHeadroom:D

    move-wide/from16 v18, v0

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    .line 1032
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    move-wide/from16 v18, v0

    const-wide/16 v20, 0x0

    cmpl-double v18, v18, v20

    if-lez v18, :cond_7

    .line 1033
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableLessHeadroom:D

    move-wide/from16 v18, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableForStorage:D

    move-wide/from16 v20, v0

    invoke-static/range {v18 .. v21}, Ljava/lang/Math;->min(DD)D

    move-result-wide v18

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    .line 1036
    :cond_7
    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "-updateStorageInfo \"storage_info\":{\"free_storage\" : "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iFree:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 1037
    const-string v19, ", \"total_storage\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iTotal:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 1038
    const-string v19, ", \"app_storage\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iUsedByApp:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 1039
    const-string v19, ", \"available\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 1040
    const-string v19, ", \"availableLessHeadroom\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableLessHeadroom:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 1041
    const-string v19, ", \"available_storage\" : "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "%1$,.2f"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailableForStorage:D

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "}"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 1036
    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 1042
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$0()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-static {v0, v11}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1015
    :cond_8
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iTotal:D

    move-wide/from16 v18, v0

    move-wide/from16 v0, v18

    invoke-static {v0, v1, v14, v15}, Ljava/lang/Math;->min(DD)D

    move-result-wide v14

    goto/16 :goto_1
.end method
