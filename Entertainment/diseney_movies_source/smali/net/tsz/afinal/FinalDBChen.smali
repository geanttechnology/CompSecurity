.class public Lnet/tsz/afinal/FinalDBChen;
.super Ljava/lang/Object;
.source "FinalDBChen.java"


# instance fields
.field private database:Landroid/database/sqlite/SQLiteDatabase;

.field private sel:Ljava/lang/String;

.field public sqlOpenHelper:Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;

.field private tabName:Ljava/lang/String;

.field private where:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3
    .param p1, "mContext"    # Landroid/content/Context;
    .param p2, "dbName"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    const-string v1, "SELECT * FROM "

    iput-object v1, p0, Lnet/tsz/afinal/FinalDBChen;->sel:Ljava/lang/String;

    .line 91
    const-string v1, " WHERE "

    iput-object v1, p0, Lnet/tsz/afinal/FinalDBChen;->where:Ljava/lang/String;

    .line 84
    invoke-static {p1, p2, v2, v2, v2}, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->create(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;

    move-result-object v0

    .line 86
    .local v0, "sqlOpenHelper":Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;
    invoke-virtual {v0}, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    iput-object v1, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    .line 87
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dbName"    # Ljava/lang/String;
    .param p3, "obj"    # Ljava/lang/Object;
    .param p4, "defaultTableName"    # Ljava/lang/String;
    .param p5, "defaultSql"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    const-string v0, "SELECT * FROM "

    iput-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->sel:Ljava/lang/String;

    .line 91
    const-string v0, " WHERE "

    iput-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->where:Ljava/lang/String;

    .line 49
    iput-object p4, p0, Lnet/tsz/afinal/FinalDBChen;->tabName:Ljava/lang/String;

    .line 50
    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 52
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p4

    .line 56
    :cond_0
    const-string v0, ""

    .line 55
    invoke-static {p1, p2, p3, p4, v0}, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->create(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;

    move-result-object v0

    iput-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->sqlOpenHelper:Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;

    .line 57
    iget-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->sqlOpenHelper:Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;

    invoke-virtual {v0}, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->getDb()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    .line 58
    return-void
.end method

.method public constructor <init>(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "database"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    const-string v0, "SELECT * FROM "

    iput-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->sel:Ljava/lang/String;

    .line 91
    const-string v0, " WHERE "

    iput-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->where:Ljava/lang/String;

    .line 41
    iput-object p1, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    .line 42
    return-void
.end method


# virtual methods
.method public addTable(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "tabName"    # Ljava/lang/String;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    .line 62
    iget-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {p1, v0, p2}, Lnet/tsz/afinal/UtilChen;->addTab(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/Object;)V

    .line 65
    :cond_0
    return-void
.end method

.method public closeDb()V
    .locals 0

    .prologue
    .line 77
    return-void
.end method

.method public deleteItem(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1
    .param p1, "tabName"    # Ljava/lang/String;
    .param p2, "whereClause"    # Ljava/lang/String;
    .param p3, "whereArgs"    # [Ljava/lang/String;

    .prologue
    .line 405
    iget-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0, p1, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 406
    return-void
.end method

.method public findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 21
    .param p1, "whereName"    # Ljava/lang/String;
    .param p2, "whereValue"    # Ljava/lang/String;
    .param p4, "tabName"    # Ljava/lang/String;
    .param p5, "orderCommand"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 281
    .local p3, "clasz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    new-instance v15, Ljava/util/ArrayList;

    invoke-direct {v15}, Ljava/util/ArrayList;-><init>()V

    .line 282
    .local v15, "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    const/4 v10, 0x0

    .line 284
    .local v10, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-static/range {p4 .. p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 286
    move-object/from16 v0, p0

    iget-object v0, v0, Lnet/tsz/afinal/FinalDBChen;->tabName:Ljava/lang/String;

    move-object/from16 p4, v0

    .line 290
    :cond_0
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v12

    .line 291
    .local v12, "fields":[Ljava/lang/reflect/Field;
    array-length v1, v12

    new-array v3, v1, [Ljava/lang/String;

    .line 292
    .local v3, "columns":[Ljava/lang/String;
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_0
    array-length v1, v12

    if-lt v14, v1, :cond_1

    .line 298
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static/range {p1 .. p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "=?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 300
    .local v4, "selection":Ljava/lang/String;
    const/4 v1, 0x1

    new-array v5, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p2, v5, v1

    .line 301
    .local v5, "args":[Ljava/lang/String;
    invoke-static/range {p1 .. p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 303
    const/4 v4, 0x0

    .line 304
    const/4 v5, 0x0

    .line 305
    move-object/from16 v0, p0

    iget-object v1, v0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    .line 306
    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v2, p4

    move-object/from16 v8, p5

    .line 305
    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 321
    :goto_1
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_5

    .line 390
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 393
    .end local v3    # "columns":[Ljava/lang/String;
    .end local v4    # "selection":Ljava/lang/String;
    .end local v5    # "args":[Ljava/lang/String;
    .end local v12    # "fields":[Ljava/lang/reflect/Field;
    .end local v14    # "i":I
    :goto_2
    return-object v15

    .line 293
    .restart local v3    # "columns":[Ljava/lang/String;
    .restart local v12    # "fields":[Ljava/lang/reflect/Field;
    .restart local v14    # "i":I
    :cond_1
    :try_start_1
    aget-object v1, v12, v14

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 294
    aget-object v1, v12, v14

    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v14

    .line 292
    add-int/lit8 v14, v14, 0x1

    goto :goto_0

    .line 307
    .restart local v4    # "selection":Ljava/lang/String;
    .restart local v5    # "args":[Ljava/lang/String;
    :cond_2
    invoke-static/range {p1 .. p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 308
    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 312
    new-instance v1, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v2, v0, Lnet/tsz/afinal/FinalDBChen;->sel:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p4

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lnet/tsz/afinal/FinalDBChen;->where:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 313
    .local v18, "sql":Ljava/lang/String;
    invoke-static/range {p5 .. p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 314
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static/range {v18 .. v18}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p5

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 316
    :cond_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v2, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v1, v0, v2}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 317
    goto :goto_1

    .line 318
    .end local v18    # "sql":Ljava/lang/String;
    :cond_4
    move-object/from16 v0, p0

    iget-object v1, v0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    .line 319
    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v2, p4

    move-object/from16 v8, p5

    .line 318
    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 321
    goto/16 :goto_1

    .line 322
    :cond_5
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v16

    .line 323
    .local v16, "obj":Ljava/lang/Object;, "TT;"
    const/16 v20, 0x0

    .local v20, "x":I
    :goto_3
    array-length v1, v3

    move/from16 v0, v20

    if-lt v0, v1, :cond_6

    .line 378
    invoke-interface/range {v15 .. v16}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_1

    .line 380
    .end local v3    # "columns":[Ljava/lang/String;
    .end local v4    # "selection":Ljava/lang/String;
    .end local v5    # "args":[Ljava/lang/String;
    .end local v12    # "fields":[Ljava/lang/reflect/Field;
    .end local v14    # "i":I
    .end local v16    # "obj":Ljava/lang/Object;, "TT;"
    .end local v20    # "x":I
    :catch_0
    move-exception v11

    .line 382
    .local v11, "e":Ljava/lang/SecurityException;
    :try_start_2
    invoke-virtual {v11}, Ljava/lang/SecurityException;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 390
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto/16 :goto_2

    .line 325
    .end local v11    # "e":Ljava/lang/SecurityException;
    .restart local v3    # "columns":[Ljava/lang/String;
    .restart local v4    # "selection":Ljava/lang/String;
    .restart local v5    # "args":[Ljava/lang/String;
    .restart local v12    # "fields":[Ljava/lang/reflect/Field;
    .restart local v14    # "i":I
    .restart local v16    # "obj":Ljava/lang/Object;, "TT;"
    .restart local v20    # "x":I
    :cond_6
    :try_start_3
    aget-object v9, v3, v20

    .line 328
    .local v9, "c":Ljava/lang/String;
    const/16 v17, 0x0

    .line 330
    .local v17, "objValue":Ljava/lang/Object;
    const/4 v14, 0x0

    move-object/from16 v1, v17

    .end local v17    # "objValue":Ljava/lang/Object;
    :goto_4
    array-length v2, v12

    if-lt v14, v2, :cond_7

    .line 323
    add-int/lit8 v20, v20, 0x1

    goto :goto_3

    .line 331
    :cond_7
    aget-object v2, v12, v14

    const/4 v6, 0x1

    invoke-virtual {v2, v6}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 333
    aget-object v2, v12, v14

    invoke-virtual {v2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v13

    .line 336
    .local v13, "fname":Ljava/lang/String;
    invoke-virtual {v13, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 339
    aget-object v2, v12, v14

    invoke-virtual {v2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v19

    .line 340
    .local v19, "type":Ljava/lang/String;
    const-string v2, "String"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 342
    invoke-interface {v10, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 341
    invoke-interface {v10, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v17

    .local v17, "objValue":Ljava/lang/String;
    move-object/from16 v1, v17

    .line 373
    .end local v17    # "objValue":Ljava/lang/String;
    :cond_8
    :goto_5
    aget-object v2, v12, v14

    move-object/from16 v0, v16

    invoke-virtual {v2, v0, v1}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 330
    .end local v19    # "type":Ljava/lang/String;
    :cond_9
    add-int/lit8 v14, v14, 0x1

    goto :goto_4

    .line 343
    .restart local v19    # "type":Ljava/lang/String;
    :cond_a
    const-string v2, "Long"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_b

    .line 344
    const-string v2, "long"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 347
    :cond_b
    invoke-interface {v10, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 346
    invoke-interface {v10, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    .local v17, "objValue":Ljava/lang/Long;
    move-object/from16 v1, v17

    .line 348
    goto :goto_5

    .end local v17    # "objValue":Ljava/lang/Long;
    :cond_c
    const-string v2, "Integer"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_d

    .line 349
    const-string v2, "int"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_e

    .line 351
    :cond_d
    invoke-interface {v10, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 350
    invoke-interface {v10, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    .local v17, "objValue":Ljava/lang/Integer;
    move-object/from16 v1, v17

    .line 353
    goto :goto_5

    .end local v17    # "objValue":Ljava/lang/Integer;
    :cond_e
    const-string v2, "boolean"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_f

    .line 355
    invoke-interface {v10, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 354
    invoke-static {v1}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v17

    .local v17, "objValue":Ljava/lang/Boolean;
    move-object/from16 v1, v17

    .line 356
    goto :goto_5

    .end local v17    # "objValue":Ljava/lang/Boolean;
    :cond_f
    const-string v2, "Float"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_10

    .line 357
    const-string v2, "float"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_11

    .line 359
    :cond_10
    invoke-interface {v10, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 358
    invoke-interface {v10, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v17

    .local v17, "objValue":Ljava/lang/Float;
    move-object/from16 v1, v17

    .line 361
    goto/16 :goto_5

    .end local v17    # "objValue":Ljava/lang/Float;
    :cond_11
    const-string v2, "Double"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_12

    .line 362
    const-string v2, "double"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_13

    .line 364
    :cond_12
    invoke-interface {v10, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 363
    invoke-interface {v10, v1}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v17

    .local v17, "objValue":Ljava/lang/Double;
    move-object/from16 v1, v17

    .line 365
    goto/16 :goto_5

    .line 367
    .end local v17    # "objValue":Ljava/lang/Double;
    :cond_13
    const-string v2, "Short"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_14

    .line 368
    const-string v2, "short"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 370
    :cond_14
    invoke-interface {v10, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 369
    invoke-interface {v10, v1}, Landroid/database/Cursor;->getShort(I)S

    move-result v1

    invoke-static {v1}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;
    :try_end_3
    .catch Ljava/lang/SecurityException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v17

    .local v17, "objValue":Ljava/lang/Short;
    move-object/from16 v1, v17

    goto/16 :goto_5

    .line 383
    .end local v3    # "columns":[Ljava/lang/String;
    .end local v4    # "selection":Ljava/lang/String;
    .end local v5    # "args":[Ljava/lang/String;
    .end local v9    # "c":Ljava/lang/String;
    .end local v12    # "fields":[Ljava/lang/reflect/Field;
    .end local v13    # "fname":Ljava/lang/String;
    .end local v14    # "i":I
    .end local v16    # "obj":Ljava/lang/Object;, "TT;"
    .end local v17    # "objValue":Ljava/lang/Short;
    .end local v19    # "type":Ljava/lang/String;
    .end local v20    # "x":I
    :catch_1
    move-exception v11

    .line 385
    .local v11, "e":Ljava/lang/InstantiationException;
    :try_start_4
    invoke-virtual {v11}, Ljava/lang/InstantiationException;->printStackTrace()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 390
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto/16 :goto_2

    .line 386
    .end local v11    # "e":Ljava/lang/InstantiationException;
    :catch_2
    move-exception v11

    .line 388
    .local v11, "e":Ljava/lang/IllegalAccessException;
    :try_start_5
    invoke-virtual {v11}, Ljava/lang/IllegalAccessException;->printStackTrace()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 390
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto/16 :goto_2

    .line 389
    .end local v11    # "e":Ljava/lang/IllegalAccessException;
    :catchall_0
    move-exception v1

    .line 390
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 392
    throw v1
.end method

.method public getDatabase()Landroid/database/sqlite/SQLiteDatabase;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    return-object v0
.end method

.method public insertBeanList(Ljava/util/List;Ljava/lang/String;)J
    .locals 13
    .param p2, "tabName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/List",
            "<+",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            ")J"
        }
    .end annotation

    .prologue
    .line 186
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<+Ljava/lang/Object;>;"
    const-wide/16 v7, -0x1

    .line 188
    .local v7, "status":J
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v11

    if-eqz v11, :cond_0

    .line 189
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v6

    .line 190
    .local v6, "size":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-lt v3, v6, :cond_1

    .line 215
    .end local v3    # "i":I
    .end local v6    # "size":I
    :cond_0
    :goto_1
    return-wide v7

    .line 191
    .restart local v3    # "i":I
    .restart local v6    # "size":I
    :cond_1
    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    .line 192
    .local v2, "fields":[Ljava/lang/reflect/Field;
    new-instance v10, Landroid/content/ContentValues;

    invoke-direct {v10}, Landroid/content/ContentValues;-><init>()V

    .line 193
    .local v10, "values":Landroid/content/ContentValues;
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_2
    array-length v11, v2

    if-lt v4, v11, :cond_2

    .line 200
    iget-object v11, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v12, 0x0

    invoke-virtual {v11, p2, v12, v10}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v7

    .line 190
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 194
    :cond_2
    aget-object v1, v2, v4

    .line 195
    .local v1, "f":Ljava/lang/reflect/Field;
    const/4 v11, 0x1

    invoke-virtual {v1, v11}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 196
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v5

    .line 197
    .local v5, "key":Ljava/lang/String;
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v1, v12}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 198
    .local v9, "value":Ljava/lang/String;
    invoke-virtual {v10, v5, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    .line 193
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 204
    .end local v1    # "f":Ljava/lang/reflect/Field;
    .end local v2    # "fields":[Ljava/lang/reflect/Field;
    .end local v3    # "i":I
    .end local v4    # "j":I
    .end local v5    # "key":Ljava/lang/String;
    .end local v6    # "size":I
    .end local v9    # "value":Ljava/lang/String;
    .end local v10    # "values":Landroid/content/ContentValues;
    :catch_0
    move-exception v0

    .line 206
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-virtual {v0}, Ljava/lang/SecurityException;->printStackTrace()V

    goto :goto_1

    .line 207
    .end local v0    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v0

    .line 209
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_1

    .line 210
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_2
    move-exception v0

    .line 212
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_1
.end method

.method public insertMap(Ljava/util/Map;Ljava/lang/String;)J
    .locals 9
    .param p2, "tabName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")J"
        }
    .end annotation

    .prologue
    .line 159
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-wide/16 v3, -0x1

    .line 160
    .local v3, "status":J
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/Map;->size()I

    move-result v7

    if-eqz v7, :cond_0

    .line 162
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6}, Landroid/content/ContentValues;-><init>()V

    .line 163
    .local v6, "values":Landroid/content/ContentValues;
    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 164
    .local v1, "key":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_1

    .line 171
    iget-object v7, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v8, 0x0

    invoke-virtual {v7, p2, v8, v6}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v3

    .line 174
    .end local v0    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v1    # "key":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v6    # "values":Landroid/content/ContentValues;
    :cond_0
    return-wide v3

    .line 166
    .restart local v0    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .restart local v1    # "key":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v6    # "values":Landroid/content/ContentValues;
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 167
    .local v2, "s":Ljava/lang/String;
    invoke-interface {p1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 169
    .local v5, "v":Ljava/lang/String;
    invoke-virtual {v6, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public insertObject(Ljava/lang/Object;Ljava/lang/String;)J
    .locals 12
    .param p2, "tabName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;",
            "Ljava/lang/String;",
            ")J"
        }
    .end annotation

    .prologue
    .line 229
    .local p1, "obj":Ljava/lang/Object;, "TT;"
    const-wide/16 v6, -0x1

    .line 231
    .local v6, "status":J
    if-eqz p1, :cond_1

    .line 232
    :try_start_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 234
    iget-object p2, p0, Lnet/tsz/afinal/FinalDBChen;->tabName:Ljava/lang/String;

    .line 236
    :cond_0
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 238
    .local v9, "values":Landroid/content/ContentValues;
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 239
    .local v0, "clasz":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/lang/Object;>;"
    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v3

    .line 240
    .local v3, "fields":[Ljava/lang/reflect/Field;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    array-length v10, v3

    if-lt v4, v10, :cond_2

    .line 247
    iget-object v10, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v11, 0x0

    invoke-virtual {v10, p2, v11, v9}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v6

    .line 260
    .end local v0    # "clasz":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/lang/Object;>;"
    .end local v3    # "fields":[Ljava/lang/reflect/Field;
    .end local v4    # "i":I
    .end local v9    # "values":Landroid/content/ContentValues;
    :cond_1
    :goto_1
    return-wide v6

    .line 241
    .restart local v0    # "clasz":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/lang/Object;>;"
    .restart local v3    # "fields":[Ljava/lang/reflect/Field;
    .restart local v4    # "i":I
    .restart local v9    # "values":Landroid/content/ContentValues;
    :cond_2
    aget-object v2, v3, v4

    .line 242
    .local v2, "f":Ljava/lang/reflect/Field;
    const/4 v10, 0x1

    invoke-virtual {v2, v10}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 243
    invoke-virtual {v2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v5

    .line 244
    .local v5, "key":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 245
    .local v8, "value":Ljava/lang/String;
    invoke-virtual {v9, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    .line 240
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 250
    .end local v0    # "clasz":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/lang/Object;>;"
    .end local v2    # "f":Ljava/lang/reflect/Field;
    .end local v3    # "fields":[Ljava/lang/reflect/Field;
    .end local v4    # "i":I
    .end local v5    # "key":Ljava/lang/String;
    .end local v8    # "value":Ljava/lang/String;
    .end local v9    # "values":Landroid/content/ContentValues;
    :catch_0
    move-exception v1

    .line 252
    .local v1, "e":Ljava/lang/SecurityException;
    invoke-virtual {v1}, Ljava/lang/SecurityException;->printStackTrace()V

    goto :goto_1

    .line 253
    .end local v1    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v1

    .line 255
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v1}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_1

    .line 256
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    :catch_2
    move-exception v1

    .line 258
    .local v1, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_1
.end method

.method public quer(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p1, "tabName"    # Ljava/lang/String;
    .param p2, "file_id"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 419
    iget-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "file_id=\'"

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "\'"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object v1, p1

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    .line 420
    return-object p2
.end method

.method public setDatabase(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 0
    .param p1, "database"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 72
    iput-object p1, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    .line 73
    return-void
.end method

.method public updateValue(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V
    .locals 1
    .param p1, "tabName"    # Ljava/lang/String;
    .param p2, "whereName"    # Ljava/lang/String;
    .param p3, "whereValue"    # [Ljava/lang/String;
    .param p4, "updateValues"    # Landroid/content/ContentValues;

    .prologue
    .line 110
    iget-object v0, p0, Lnet/tsz/afinal/FinalDBChen;->database:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0, p1, p4, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 112
    return-void
.end method

.method public updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V
    .locals 10
    .param p1, "tabName"    # Ljava/lang/String;
    .param p2, "whereName"    # Ljava/lang/String;
    .param p3, "whereValue"    # [Ljava/lang/String;
    .param p4, "obj"    # Ljava/lang/Object;

    .prologue
    .line 128
    :try_start_0
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 130
    .local v5, "values":Landroid/content/ContentValues;
    invoke-virtual {p4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    .line 131
    .local v2, "fields":[Ljava/lang/reflect/Field;
    array-length v7, v2

    const/4 v6, 0x0

    :goto_0
    if-lt v6, v7, :cond_0

    .line 137
    invoke-virtual {p0, p1, p2, p3, v5}, Lnet/tsz/afinal/FinalDBChen;->updateValue(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 148
    .end local v2    # "fields":[Ljava/lang/reflect/Field;
    .end local v5    # "values":Landroid/content/ContentValues;
    :goto_1
    return-void

    .line 131
    .restart local v2    # "fields":[Ljava/lang/reflect/Field;
    .restart local v5    # "values":Landroid/content/ContentValues;
    :cond_0
    aget-object v1, v2, v6

    .line 132
    .local v1, "field":Ljava/lang/reflect/Field;
    const/4 v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 133
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v3

    .line 134
    .local v3, "key":Ljava/lang/String;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p4}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 135
    .local v4, "value":Ljava/lang/String;
    invoke-virtual {v5, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    .line 131
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 138
    .end local v1    # "field":Ljava/lang/reflect/Field;
    .end local v2    # "fields":[Ljava/lang/reflect/Field;
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "value":Ljava/lang/String;
    .end local v5    # "values":Landroid/content/ContentValues;
    :catch_0
    move-exception v0

    .line 140
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-virtual {v0}, Ljava/lang/SecurityException;->printStackTrace()V

    goto :goto_1

    .line 141
    .end local v0    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v0

    .line 143
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_1

    .line 144
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_2
    move-exception v0

    .line 146
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_1
.end method
