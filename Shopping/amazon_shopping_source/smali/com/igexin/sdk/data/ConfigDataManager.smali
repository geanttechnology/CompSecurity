.class public Lcom/igexin/sdk/data/ConfigDataManager;
.super Ljava/lang/Object;
.source "ConfigDataManager.java"


# static fields
.field private static downloadUrl:Ljava/lang/String;

.field private static encryptEnable:Z

.field private static masterAppID:Ljava/lang/String;

.field private static masterPkgName:Ljava/lang/String;

.field private static masterServiceAction:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    sput-boolean v0, Lcom/igexin/sdk/data/ConfigDataManager;->encryptEnable:Z

    .line 20
    const/4 v0, 0x0

    sput-object v0, Lcom/igexin/sdk/data/ConfigDataManager;->downloadUrl:Ljava/lang/String;

    .line 21
    const-string/jumbo v0, "com.amazon.pushservice"

    sput-object v0, Lcom/igexin/sdk/data/ConfigDataManager;->masterPkgName:Ljava/lang/String;

    .line 22
    const-string/jumbo v0, "so6J4ecxpZ8Fnq7AaaZdN"

    sput-object v0, Lcom/igexin/sdk/data/ConfigDataManager;->masterAppID:Ljava/lang/String;

    .line 23
    const-string/jumbo v0, "com.amazon.pushservice.start"

    sput-object v0, Lcom/igexin/sdk/data/ConfigDataManager;->masterServiceAction:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getDownloadUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/igexin/sdk/data/ConfigDataManager;->downloadUrl:Ljava/lang/String;

    return-object v0
.end method

.method public static getEncryptEnable()Z
    .locals 1

    .prologue
    .line 34
    sget-boolean v0, Lcom/igexin/sdk/data/ConfigDataManager;->encryptEnable:Z

    return v0
.end method

.method public static getMasterAppID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/igexin/sdk/data/ConfigDataManager;->masterAppID:Ljava/lang/String;

    return-object v0
.end method

.method public static getMasterPkgName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    sget-object v0, Lcom/igexin/sdk/data/ConfigDataManager;->masterPkgName:Ljava/lang/String;

    return-object v0
.end method

.method public static getMasterServiceAction()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    sget-object v0, Lcom/igexin/sdk/data/ConfigDataManager;->masterServiceAction:Ljava/lang/String;

    return-object v0
.end method

.method public static init()V
    .locals 0

    .prologue
    .line 26
    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->read()V

    .line 27
    return-void
.end method

.method private static read()V
    .locals 8

    .prologue
    .line 70
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v5

    invoke-virtual {v5}, Lcom/igexin/sdk/SdkService;->getDBHelper()Lcom/igexin/sdk/db/DBHelper;

    move-result-object v5

    invoke-virtual {v5}, Lcom/igexin/sdk/db/DBHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    const-string/jumbo v6, "select id, value from config order by id"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 71
    .local v0, "cursor":Landroid/database/Cursor;
    if-eqz v0, :cond_3

    .line 72
    :cond_0
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 73
    const/4 v1, 0x0

    .line 74
    .local v1, "i":I
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "i":I
    .local v2, "i":I
    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    .line 75
    .local v3, "id":I
    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 76
    .local v4, "value":Ljava/lang/String;
    packed-switch v3, :pswitch_data_0

    goto :goto_0

    .line 78
    :pswitch_0
    const-string/jumbo v5, "true"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    const/4 v5, 0x1

    :goto_1
    sput-boolean v5, Lcom/igexin/sdk/data/ConfigDataManager;->encryptEnable:Z

    goto :goto_0

    :cond_1
    const/4 v5, 0x0

    goto :goto_1

    .line 81
    :pswitch_1
    const-string/jumbo v5, "null"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 82
    sput-object v4, Lcom/igexin/sdk/data/ConfigDataManager;->downloadUrl:Ljava/lang/String;

    goto :goto_0

    .line 85
    :pswitch_2
    const-string/jumbo v5, "null"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 86
    sput-object v4, Lcom/igexin/sdk/data/ConfigDataManager;->masterPkgName:Ljava/lang/String;

    goto :goto_0

    .line 89
    :pswitch_3
    const-string/jumbo v5, "null"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 90
    sput-object v4, Lcom/igexin/sdk/data/ConfigDataManager;->masterAppID:Ljava/lang/String;

    goto :goto_0

    .line 93
    :pswitch_4
    const-string/jumbo v5, "null"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 94
    sput-object v4, Lcom/igexin/sdk/data/ConfigDataManager;->masterServiceAction:Ljava/lang/String;

    goto :goto_0

    .line 99
    .end local v2    # "i":I
    .end local v3    # "id":I
    .end local v4    # "value":Ljava/lang/String;
    :cond_2
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 101
    :cond_3
    return-void

    .line 76
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public static setDownloadUrl(Ljava/lang/String;)V
    .locals 0
    .param p0, "downloadUrl"    # Ljava/lang/String;

    .prologue
    .line 42
    sput-object p0, Lcom/igexin/sdk/data/ConfigDataManager;->downloadUrl:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public static setEncryptEnable(Z)V
    .locals 0
    .param p0, "enable"    # Z

    .prologue
    .line 30
    sput-boolean p0, Lcom/igexin/sdk/data/ConfigDataManager;->encryptEnable:Z

    .line 31
    return-void
.end method

.method public static setMasterAppID(Ljava/lang/String;)V
    .locals 0
    .param p0, "masterAppID"    # Ljava/lang/String;

    .prologue
    .line 58
    sput-object p0, Lcom/igexin/sdk/data/ConfigDataManager;->masterAppID:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public static setMasterPkgName(Ljava/lang/String;)V
    .locals 0
    .param p0, "masterPkgName"    # Ljava/lang/String;

    .prologue
    .line 50
    sput-object p0, Lcom/igexin/sdk/data/ConfigDataManager;->masterPkgName:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public static setMasterServiceAction(Ljava/lang/String;)V
    .locals 0
    .param p0, "masterServiceAction"    # Ljava/lang/String;

    .prologue
    .line 66
    sput-object p0, Lcom/igexin/sdk/data/ConfigDataManager;->masterServiceAction:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public static updateDBValue(ILjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p0, "valueID"    # I
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 116
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 117
    .local v0, "values":Landroid/content/ContentValues;
    const-string/jumbo v1, "id"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 118
    const-string/jumbo v1, "name"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    const-string/jumbo v1, "value"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v1

    invoke-virtual {v1}, Lcom/igexin/sdk/SdkService;->getDBHelper()Lcom/igexin/sdk/db/DBHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/igexin/sdk/db/DBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    const-string/jumbo v2, "config"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 121
    return-void
.end method

.method public static write(Lcom/igexin/sdk/data/DynamicConfig;)V
    .locals 3
    .param p0, "cfg"    # Lcom/igexin/sdk/data/DynamicConfig;

    .prologue
    .line 104
    const/4 v1, 0x1

    const-string/jumbo v2, "encrypt"

    invoke-virtual {p0}, Lcom/igexin/sdk/data/DynamicConfig;->isEncrypt()Z

    move-result v0

    if-eqz v0, :cond_4

    const-string/jumbo v0, "true"

    :goto_0
    invoke-static {v1, v2, v0}, Lcom/igexin/sdk/data/ConfigDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 105
    invoke-virtual {p0}, Lcom/igexin/sdk/data/DynamicConfig;->getDownloadUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 106
    const/4 v0, 0x2

    const-string/jumbo v1, "downloadUrl"

    invoke-virtual {p0}, Lcom/igexin/sdk/data/DynamicConfig;->getDownloadUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/igexin/sdk/data/ConfigDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 107
    :cond_0
    invoke-virtual {p0}, Lcom/igexin/sdk/data/DynamicConfig;->getMasterPkgName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 108
    const/4 v0, 0x3

    const-string/jumbo v1, "masterPkgName"

    invoke-virtual {p0}, Lcom/igexin/sdk/data/DynamicConfig;->getMasterPkgName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/igexin/sdk/data/ConfigDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 109
    :cond_1
    invoke-virtual {p0}, Lcom/igexin/sdk/data/DynamicConfig;->getMasterAppID()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 110
    const/4 v0, 0x4

    const-string/jumbo v1, "masterAppID"

    invoke-virtual {p0}, Lcom/igexin/sdk/data/DynamicConfig;->getMasterAppID()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/igexin/sdk/data/ConfigDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 111
    :cond_2
    invoke-virtual {p0}, Lcom/igexin/sdk/data/DynamicConfig;->getMasterServiceAction()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 112
    const/4 v0, 0x5

    const-string/jumbo v1, "masterServiceAction"

    invoke-virtual {p0}, Lcom/igexin/sdk/data/DynamicConfig;->getMasterServiceAction()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/igexin/sdk/data/ConfigDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 113
    :cond_3
    return-void

    .line 104
    :cond_4
    const-string/jumbo v0, "false"

    goto :goto_0
.end method
