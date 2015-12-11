.class Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "LocalDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "LocalDataStorageDBHelper"
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "version"    # I

    .prologue
    .line 98
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".db"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1, p3}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 99
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 7
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 104
    # getter for: Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Creating Local DataStore"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    new-instance v0, Lcom/amazon/identity/auth/device/framework/SQLTable;

    const-string/jumbo v1, "accounts"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/SQLTable;-><init>(Ljava/lang/String;)V

    const-string/jumbo v1, "_id"

    const-string/jumbo v2, "INTEGER PRIMARY KEY AUTOINCREMENT"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "directed_id"

    const-string/jumbo v2, "TEXT UNIQUE NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "display_name"

    const-string/jumbo v2, "TEXT UNIQUE"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "account_timestamp"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "account_deleted"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "account_dirty"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SQLTable;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 107
    new-instance v0, Lcom/amazon/identity/auth/device/framework/SQLTable;

    const-string/jumbo v1, "userdata"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/SQLTable;-><init>(Ljava/lang/String;)V

    const-string/jumbo v1, "_id"

    const-string/jumbo v2, "INTEGER PRIMARY KEY AUTOINCREMENT"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "userdata_account_id"

    const-string/jumbo v2, "TEXT NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "userdata_key"

    const-string/jumbo v2, "TEXT NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "userdata_value"

    const-string/jumbo v2, "TEXT"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "userdata_timestamp"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "userdata_deleted"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "userdata_dirty"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "UNIQUE(%s,%s)"

    new-array v2, v6, [Ljava/lang/Object;

    const-string/jumbo v3, "userdata_account_id"

    aput-object v3, v2, v4

    const-string/jumbo v3, "userdata_key"

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addConstraint(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SQLTable;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 108
    new-instance v0, Lcom/amazon/identity/auth/device/framework/SQLTable;

    const-string/jumbo v1, "tokens"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/SQLTable;-><init>(Ljava/lang/String;)V

    const-string/jumbo v1, "_id"

    const-string/jumbo v2, "INTEGER PRIMARY KEY AUTOINCREMENT"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "token_account_id"

    const-string/jumbo v2, "TEXT NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "token_key"

    const-string/jumbo v2, "TEXT NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "token_value"

    const-string/jumbo v2, "TEXT"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "token_timestamp"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "token_deleted"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "token_dirty"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "UNIQUE(%s,%s)"

    new-array v2, v6, [Ljava/lang/Object;

    const-string/jumbo v3, "token_account_id"

    aput-object v3, v2, v4

    const-string/jumbo v3, "token_key"

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addConstraint(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SQLTable;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 109
    new-instance v0, Lcom/amazon/identity/auth/device/framework/SQLTable;

    const-string/jumbo v1, "device_data"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/SQLTable;-><init>(Ljava/lang/String;)V

    const-string/jumbo v1, "_id"

    const-string/jumbo v2, "INTEGER PRIMARY KEY AUTOINCREMENT"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "device_data_namespace"

    const-string/jumbo v2, "TEXT NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "device_data_key"

    const-string/jumbo v2, "TEXT NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "device_data_value"

    const-string/jumbo v2, "TEXT"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "device_data_timestamp"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "device_data_deleted"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "device_data_dirty"

    const-string/jumbo v2, "INTEGER NOT NULL"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    const-string/jumbo v1, "UNIQUE(%s,%s)"

    new-array v2, v6, [Ljava/lang/Object;

    const-string/jumbo v3, "device_data_namespace"

    aput-object v3, v2, v4

    const-string/jumbo v3, "device_data_key"

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/SQLTable;->addConstraint(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SQLTable;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 110
    return-void
.end method

.method public onOpen(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 115
    invoke-super {p0, p1}, Landroid/database/sqlite/SQLiteOpenHelper;->onOpen(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 116
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->isReadOnly()Z

    move-result v0

    if-nez v0, :cond_0

    .line 118
    const-string/jumbo v0, "PRAGMA foreign_keys=ON;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 120
    :cond_0
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 5
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 125
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Cannot upgrade from version %d to %d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
