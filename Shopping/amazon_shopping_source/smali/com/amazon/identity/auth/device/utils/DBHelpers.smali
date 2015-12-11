.class public final Lcom/amazon/identity/auth/device/utils/DBHelpers;
.super Ljava/lang/Object;
.source "DBHelpers.java"


# static fields
.field public static final FALSE:I = 0x0

.field private static final TAG:Ljava/lang/String;

.field public static final TRUE:I = 0x1


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/amazon/identity/auth/device/utils/DBHelpers;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/DBHelpers;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    return-void
.end method

.method public static closeCursor(Landroid/database/Cursor;)V
    .locals 0
    .param p0, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 281
    if-nez p0, :cond_0

    .line 287
    :goto_0
    return-void

    .line 286
    :cond_0
    invoke-interface {p0}, Landroid/database/Cursor;->close()V

    goto :goto_0
.end method

.method public static containsColumn(Landroid/database/Cursor;Ljava/lang/String;)Z
    .locals 1
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 65
    invoke-interface {p0, p1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getAliasColumnName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "table"    # Ljava/lang/String;
    .param p1, "column"    # Ljava/lang/String;
    .param p2, "alias"    # Ljava/lang/String;

    .prologue
    .line 230
    const-string/jumbo v0, "%s.%s as %s"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    aput-object p1, v1, v2

    const/4 v2, 0x2

    aput-object p2, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getBoolean(Landroid/database/Cursor;Ljava/lang/String;)Z
    .locals 4
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 53
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getLong(Landroid/database/Cursor;Ljava/lang/String;)J

    move-result-wide v0

    const-wide/16 v2, 0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getDate(Landroid/database/Cursor;Ljava/lang/String;)Ljava/util/Date;
    .locals 3
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 48
    new-instance v0, Ljava/util/Date;

    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getLong(Landroid/database/Cursor;Ljava/lang/String;)J

    move-result-wide v1

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    return-object v0
.end method

.method public static getInt(Landroid/database/Cursor;Ljava/lang/String;)I
    .locals 2
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-interface {p0, p1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 36
    .local v0, "columnIndex":I
    invoke-interface {p0, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    return v1
.end method

.method public static getLong(Landroid/database/Cursor;Ljava/lang/String;)J
    .locals 3
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-interface {p0, p1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 43
    .local v0, "columnIndex":I
    invoke-interface {p0, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    return-wide v1
.end method

.method public static getNamespaceColumnName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "table"    # Ljava/lang/String;
    .param p1, "column"    # Ljava/lang/String;

    .prologue
    .line 225
    const-string/jumbo v0, "%s.%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getResultFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "column"    # Ljava/lang/String;

    .prologue
    .line 141
    invoke-interface {p0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_0

    .line 143
    const/4 v0, 0x0

    .line 146
    :goto_0
    return-object v0

    :cond_0
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 58
    invoke-interface {p0, p1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 60
    .local v0, "columnIndex":I
    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z
    .locals 6
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "table"    # Ljava/lang/String;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "whereClause"    # Ljava/lang/String;
    .param p4, "whereArgs"    # [Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 242
    :try_start_0
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 243
    if-lez v2, :cond_1

    .line 259
    :cond_0
    :goto_0
    return v0

    .line 248
    :cond_1
    const/4 v2, 0x0

    invoke-virtual {p0, p1, v2, p2}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    .line 249
    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    move v0, v1

    goto :goto_0

    .line 255
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/utils/DBHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Error inserting into database in ifCannotUpdateThenInsert"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    sget-object v0, Lcom/amazon/identity/auth/device/utils/DBHelpers;->TAG:Ljava/lang/String;

    move v0, v1

    .line 259
    goto :goto_0
.end method

.method public static isNull(Landroid/database/Cursor;Ljava/lang/String;)Z
    .locals 2
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 70
    invoke-interface {p0, p1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 72
    .local v0, "columnIndex":I
    invoke-interface {p0, v0}, Landroid/database/Cursor;->isNull(I)Z

    move-result v1

    return v1
.end method

.method public static populateCursor([Ljava/lang/String;Ljava/util/Collection;)Landroid/database/Cursor;
    .locals 11
    .param p0, "columns"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)",
            "Landroid/database/Cursor;"
        }
    .end annotation

    .prologue
    .local p1, "multipleRowColumnToValues":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/4 v2, 0x0

    const/4 v8, 0x1

    const/4 v10, 0x0

    .line 186
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 220
    :cond_0
    :goto_0
    return-object v2

    .line 191
    :cond_1
    array-length v6, p0

    const/16 v7, 0x2710

    if-lt v6, v7, :cond_2

    .line 193
    sget-object v6, Lcom/amazon/identity/auth/device/utils/DBHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "The number of columns %d is too large to be handled. Issue tracked in SSO-160."

    new-array v8, v8, [Ljava/lang/Object;

    array-length v9, p0

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 199
    :cond_2
    new-instance v2, Landroid/database/MatrixCursor;

    invoke-direct {v2, p0}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    .line 201
    .local v2, "cursor":Landroid/database/MatrixCursor;
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 203
    .local v0, "columnToValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    array-length v6, p0

    new-array v5, v6, [Ljava/lang/String;

    .line 204
    .local v5, "values":[Ljava/lang/String;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_2
    array-length v6, p0

    if-ge v3, v6, :cond_4

    .line 206
    aget-object v1, p0, v3

    .line 207
    .local v1, "curColumn":Ljava/lang/String;
    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 209
    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    aput-object v6, v5, v3

    .line 204
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 213
    :cond_3
    sget-object v6, Lcom/amazon/identity/auth/device/utils/DBHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Column %s not supported"

    new-array v7, v8, [Ljava/lang/Object;

    aput-object v1, v7, v10

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    goto :goto_3

    .line 217
    .end local v1    # "curColumn":Ljava/lang/String;
    :cond_4
    invoke-virtual {v2, v5}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_1
.end method

.method public static populateCursor([Ljava/lang/String;Ljava/util/Map;)Landroid/database/Cursor;
    .locals 2
    .param p0, "columns"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Landroid/database/Cursor;"
        }
    .end annotation

    .prologue
    .line 175
    .local p1, "columnToValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 177
    :cond_0
    const/4 v0, 0x0

    .line 180
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/util/Map;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->populateCursor([Ljava/lang/String;Ljava/util/Collection;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0
.end method

.method public static querySingleResult(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "table"    # Ljava/lang/String;
    .param p2, "column"    # Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 113
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->querySingleResult(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static querySingleResult(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "table"    # Ljava/lang/String;
    .param p2, "column"    # Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "orderBy"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 123
    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p2, v2, v0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p3

    move-object v4, p4

    move-object v6, v5

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 124
    .local v8, "result":Landroid/database/Cursor;
    if-nez v8, :cond_0

    .line 135
    :goto_0
    return-object v5

    .line 131
    :cond_0
    :try_start_0
    invoke-static {v8, p2}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getResultFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v5

    .line 135
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public static querySingleResult(Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "resolver"    # Lcom/amazon/identity/auth/device/framework/SecureContentResolver;
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "column"    # Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 81
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->querySingleResult(Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static querySingleResult(Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "resolver"    # Lcom/amazon/identity/auth/device/framework/SecureContentResolver;
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "column"    # Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 91
    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p2, v2, v0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 92
    .local v6, "result":Landroid/database/Cursor;
    if-nez v6, :cond_0

    .line 94
    const/4 v0, 0x0

    .line 103
    :goto_0
    return-object v0

    .line 99
    :cond_0
    :try_start_0
    invoke-static {v6, p2}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getResultFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 103
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public static tryInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)Z
    .locals 5
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "table"    # Ljava/lang/String;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v0, 0x0

    .line 266
    const/4 v1, 0x0

    :try_start_0
    invoke-virtual {p0, p1, v1, p2}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v1

    .line 267
    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-ltz v1, :cond_0

    const/4 v0, 0x1

    .line 275
    :cond_0
    :goto_0
    return v0

    .line 273
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/device/utils/DBHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Error inserting into database in tryInsert"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    sget-object v1, Lcom/amazon/identity/auth/device/utils/DBHelpers;->TAG:Ljava/lang/String;

    goto :goto_0
.end method

.method public static varargs upgradeTable(Landroid/database/sqlite/SQLiteDatabase;Lcom/amazon/identity/auth/device/framework/SQLTable;[Ljava/lang/String;)V
    .locals 13
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "table"    # Lcom/amazon/identity/auth/device/framework/SQLTable;
    .param p2, "migrationCommands"    # [Ljava/lang/String;

    .prologue
    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 151
    new-instance v5, Lcom/amazon/identity/auth/device/framework/SQLTable;

    invoke-direct {v5, p1}, Lcom/amazon/identity/auth/device/framework/SQLTable;-><init>(Lcom/amazon/identity/auth/device/framework/SQLTable;)V

    .line 152
    .local v5, "tempTable":Lcom/amazon/identity/auth/device/framework/SQLTable;
    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "temp_"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/SQLTable;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/identity/auth/device/framework/SQLTable;->setName(Ljava/lang/String;)V

    .line 154
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/SQLTable;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 156
    move-object v0, p2

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, p2

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v4, v0, v2

    .line 158
    .local v4, "migrationCommand":Ljava/lang/String;
    invoke-virtual {p0, v4}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 156
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 161
    .end local v4    # "migrationCommand":Ljava/lang/String;
    :cond_0
    const-string/jumbo v6, ", "

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/SQLTable;->getColumnNames()Ljava/util/List;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/StringHelpers;->join(Ljava/lang/String;Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v1

    .line 163
    .local v1, "fields":Ljava/lang/String;
    const-string/jumbo v6, "INSERT INTO %s (%s) SELECT %s FROM %s;"

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/SQLTable;->getName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v10

    aput-object v1, v7, v11

    aput-object v1, v7, v12

    const/4 v8, 0x3

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/SQLTable;->getName()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 168
    const-string/jumbo v6, "DROP TABLE %s;"

    new-array v7, v11, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/SQLTable;->getName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v10

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 169
    const-string/jumbo v6, "ALTER TABLE %s RENAME TO %s;"

    new-array v7, v12, [Ljava/lang/Object;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/SQLTable;->getName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v10

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/SQLTable;->getName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 170
    return-void
.end method
