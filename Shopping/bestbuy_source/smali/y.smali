.class public final Ly;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Landroid/database/sqlite/SQLiteDatabase;

.field private final b:Laa;

.field private c:I


# direct methods
.method public constructor <init>(Lz;Laa;)V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    invoke-virtual {p1}, Lz;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Ly;->a:Landroid/database/sqlite/SQLiteDatabase;

    .line 44
    const v0, 0x7fffffff

    iput v0, p0, Ly;->c:I

    .line 45
    iput-object p2, p0, Ly;->b:Laa;

    .line 46
    return-void
.end method

.method private d()V
    .locals 6

    .prologue
    .line 82
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "DELETE FROM metrics WHERE ROWID IN (SELECT ROWID FROM metrics ORDER BY timestamp DESC LIMIT -1 OFFSET "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Ly;->c:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 85
    iget-object v1, p0, Ly;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1, v0}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v0

    .line 91
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v1, v2, :cond_1

    .line 92
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteStatement;->executeUpdateDelete()I

    move-result v0

    .line 93
    if-lez v0, :cond_0

    .line 94
    iget-object v1, p0, Ly;->b:Laa;

    const-string v2, "free_storage"

    int-to-long v4, v0

    invoke-virtual {v1, v2, v4, v5}, Laa;->b(Ljava/lang/String;J)V

    .line 99
    :cond_0
    :goto_0
    return-void

    .line 97
    :cond_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    goto :goto_0
.end method


# virtual methods
.method public final a()Ljava/util/List;
    .locals 12

    .prologue
    const/4 v11, 0x0

    const/4 v10, 0x1

    const/4 v2, 0x0

    .line 102
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 103
    new-instance v9, Ljava/util/HashSet;

    invoke-direct {v9}, Ljava/util/HashSet;-><init>()V

    .line 104
    iget-object v0, p0, Ly;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "metrics"

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 106
    :try_start_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 107
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->isAfterLast()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 109
    :try_start_1
    new-instance v0, Laf;

    new-instance v2, Lorg/json/JSONObject;

    const/4 v3, 0x1

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const/4 v3, 0x0

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-direct {v0, v2, v4, v5}, Laf;-><init>(Lorg/json/JSONObject;J)V

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 114
    :goto_1
    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 117
    :catchall_0
    move-exception v0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    throw v0

    .line 110
    :catch_0
    move-exception v0

    .line 111
    :try_start_3
    const-string v2, "Error parsing JSON from metric database"

    invoke-static {v2, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 112
    const/4 v0, 0x1

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v9, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 117
    :cond_0
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 120
    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 121
    iget-object v2, p0, Ly;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "metrics"

    const-string v4, "data=?"

    new-array v5, v10, [Ljava/lang/String;

    aput-object v0, v5, v11

    invoke-virtual {v2, v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_2

    .line 124
    :cond_1
    return-object v8
.end method

.method public final a(I)V
    .locals 1

    .prologue
    .line 77
    const/16 v0, 0xc8

    iput v0, p0, Ly;->c:I

    .line 78
    invoke-direct {p0}, Ly;->d()V

    .line 79
    return-void
.end method

.method public final a(Ljava/util/List;)Z
    .locals 11

    .prologue
    const/4 v10, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 49
    .line 50
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 51
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    move v1, v2

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laf;

    .line 52
    const-string v6, "timestamp"

    invoke-virtual {v0}, Laf;->a()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 53
    invoke-virtual {v0}, Laf;->b()Lorg/json/JSONObject;

    move-result-object v6

    if-nez v6, :cond_0

    invoke-virtual {v10}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v0

    .line 54
    :goto_1
    const-string v6, "data"

    invoke-virtual {v4, v6, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    iget-object v0, p0, Ly;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "metrics"

    invoke-virtual {v0, v6, v10, v4}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v6

    const-wide/16 v8, -0x1

    cmp-long v0, v6, v8

    if-nez v0, :cond_1

    .line 56
    iget-object v0, p0, Ly;->b:Laa;

    const-string v6, "db_errors"

    const-wide/16 v8, 0x1

    invoke-virtual {v0, v6, v8, v9}, Laa;->b(Ljava/lang/String;J)V

    goto :goto_0

    .line 53
    :cond_0
    invoke-virtual {v0}, Laf;->b()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    :cond_1
    move v1, v3

    .line 60
    goto :goto_0

    .line 62
    :cond_2
    if-eqz v1, :cond_3

    .line 63
    invoke-direct {p0}, Ly;->d()V

    .line 65
    :cond_3
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    if-eqz v1, :cond_5

    :cond_4
    move v2, v3

    :cond_5
    return v2
.end method

.method public final b()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 128
    iget-object v0, p0, Ly;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "metrics"

    invoke-virtual {v0, v1, v2, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 129
    return-void
.end method

.method public final c()V
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Ly;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 133
    return-void
.end method
