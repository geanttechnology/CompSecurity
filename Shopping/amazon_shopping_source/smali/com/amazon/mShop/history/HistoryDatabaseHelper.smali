.class public Lcom/amazon/mShop/history/HistoryDatabaseHelper;
.super Lcom/amazon/mShop/util/DatabaseHelper;
.source "HistoryDatabaseHelper.java"


# direct methods
.method protected constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    const-string/jumbo v0, "history.db"

    const/4 v1, 0x2

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/mShop/util/DatabaseHelper;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    .line 17
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 5
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 33
    const-string/jumbo v1, "CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s TEXT, %s TEXT,UNIQUE(%s, %s, %s, %s) ON CONFLICT REPLACE);"

    const/16 v2, 0xc

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const-string/jumbo v4, "history"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string/jumbo v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string/jumbo v4, "asin"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    const-string/jumbo v4, "type"

    aput-object v4, v2, v3

    const/4 v3, 0x4

    const-string/jumbo v4, "locale"

    aput-object v4, v2, v3

    const/4 v3, 0x5

    const-string/jumbo v4, "visit_date"

    aput-object v4, v2, v3

    const/4 v3, 0x6

    const-string/jumbo v4, "email"

    aput-object v4, v2, v3

    const/4 v3, 0x7

    const-string/jumbo v4, "original_scanned_history"

    aput-object v4, v2, v3

    const/16 v3, 0x8

    const-string/jumbo v4, "asin"

    aput-object v4, v2, v3

    const/16 v3, 0x9

    const-string/jumbo v4, "type"

    aput-object v4, v2, v3

    const/16 v3, 0xa

    const-string/jumbo v4, "locale"

    aput-object v4, v2, v3

    const/16 v3, 0xb

    const-string/jumbo v4, "email"

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 38
    .local v0, "createTableString":Ljava/lang/String;
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 39
    return-void
.end method

.method public onDowngrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 27
    const-string/jumbo v0, "DROP TABLE IF EXISTS history"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 28
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/history/HistoryDatabaseHelper;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 29
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 21
    const-string/jumbo v0, "DROP TABLE IF EXISTS history"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 22
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/history/HistoryDatabaseHelper;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 23
    return-void
.end method
