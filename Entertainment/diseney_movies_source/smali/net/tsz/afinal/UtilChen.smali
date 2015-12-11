.class public Lnet/tsz/afinal/UtilChen;
.super Ljava/lang/Object;
.source "UtilChen.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addTab(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/Object;)V
    .locals 14
    .param p0, "defaultTableName"    # Ljava/lang/String;
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    .line 26
    const-string v8, ""

    .line 30
    .local v8, "sql":Ljava/lang/String;
    :try_start_0
    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "CREATE TABLE IF NOT EXISTS "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 31
    new-instance v7, Ljava/lang/StringBuffer;

    invoke-direct {v7}, Ljava/lang/StringBuffer;-><init>()V

    .line 32
    .local v7, "sb":Ljava/lang/StringBuffer;
    const-string v5, "("

    .line 33
    .local v5, "l":Ljava/lang/String;
    const-string v6, ")"

    .line 34
    .local v6, "r":Ljava/lang/String;
    const-string v0, ","

    .line 35
    .local v0, "d":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "VARCHAR(200)"

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 37
    .local v9, "varchar":Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v4

    .line 38
    .local v4, "fields":[Ljava/lang/reflect/Field;
    array-length v11, v4

    const/4 v10, 0x0

    :goto_0
    if-lt v10, v11, :cond_0

    .line 45
    const-string v10, ","

    invoke-virtual {v7, v10}, Ljava/lang/StringBuffer;->lastIndexOf(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 46
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 48
    invoke-virtual {p1, v8}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 63
    .end local v0    # "d":Ljava/lang/String;
    .end local v4    # "fields":[Ljava/lang/reflect/Field;
    .end local v5    # "l":Ljava/lang/String;
    .end local v6    # "r":Ljava/lang/String;
    .end local v7    # "sb":Ljava/lang/StringBuffer;
    .end local v9    # "varchar":Ljava/lang/String;
    :goto_1
    return-void

    .line 38
    .restart local v0    # "d":Ljava/lang/String;
    .restart local v4    # "fields":[Ljava/lang/reflect/Field;
    .restart local v5    # "l":Ljava/lang/String;
    .restart local v6    # "r":Ljava/lang/String;
    .restart local v7    # "sb":Ljava/lang/StringBuffer;
    .restart local v9    # "varchar":Ljava/lang/String;
    :cond_0
    aget-object v2, v4, v10

    .line 39
    .local v2, "field":Ljava/lang/reflect/Field;
    const/4 v12, 0x1

    invoke-virtual {v2, v12}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 40
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 41
    .local v3, "fieldName":Ljava/lang/String;
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 38
    add-int/lit8 v10, v10, 0x1

    goto :goto_0

    .line 52
    .end local v0    # "d":Ljava/lang/String;
    .end local v2    # "field":Ljava/lang/reflect/Field;
    .end local v3    # "fieldName":Ljava/lang/String;
    .end local v4    # "fields":[Ljava/lang/reflect/Field;
    .end local v5    # "l":Ljava/lang/String;
    .end local v6    # "r":Ljava/lang/String;
    .end local v7    # "sb":Ljava/lang/StringBuffer;
    .end local v9    # "varchar":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 55
    .local v1, "e":Ljava/lang/SecurityException;
    invoke-virtual {v1}, Ljava/lang/SecurityException;->printStackTrace()V

    goto :goto_1

    .line 57
    .end local v1    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v1

    .line 60
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v1}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_1
.end method
