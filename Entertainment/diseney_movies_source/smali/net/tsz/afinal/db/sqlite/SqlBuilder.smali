.class public Lnet/tsz/afinal/db/sqlite/SqlBuilder;
.super Ljava/lang/Object;
.source "SqlBuilder.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static buildDeleteSql(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "strWhere"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 155
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p0}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v1

    .line 156
    .local v1, "table":Lnet/tsz/afinal/db/table/TableInfo;
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getDeleteSqlBytableName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 158
    .local v0, "strSQL":Ljava/lang/StringBuffer;
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 159
    const-string v2, " WHERE "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 160
    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 163
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static buildDeleteSql(Ljava/lang/Class;Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;
    .locals 6
    .param p1, "idValue"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Object;",
            ")",
            "Lnet/tsz/afinal/db/sqlite/SqlInfo;"
        }
    .end annotation

    .prologue
    .line 131
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p0}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v3

    .line 132
    .local v3, "table":Lnet/tsz/afinal/db/table/TableInfo;
    invoke-virtual {v3}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v0

    .line 134
    .local v0, "id":Lnet/tsz/afinal/db/table/Id;
    if-nez p1, :cond_0

    .line 135
    new-instance v4, Lnet/tsz/afinal/exception/DbException;

    const-string v5, "getDeleteSQL:idValue is null"

    invoke-direct {v4, v5}, Lnet/tsz/afinal/exception/DbException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 138
    :cond_0
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-virtual {v3}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getDeleteSqlBytableName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 139
    .local v2, "strSQL":Ljava/lang/StringBuffer;
    const-string v4, " WHERE "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    invoke-virtual {v0}, Lnet/tsz/afinal/db/table/Id;->getColumn()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    const-string v5, "=?"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 141
    new-instance v1, Lnet/tsz/afinal/db/sqlite/SqlInfo;

    invoke-direct {v1}, Lnet/tsz/afinal/db/sqlite/SqlInfo;-><init>()V

    .line 142
    .local v1, "sqlInfo":Lnet/tsz/afinal/db/sqlite/SqlInfo;
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->setSql(Ljava/lang/String;)V

    .line 143
    invoke-virtual {v1, p1}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->addValue(Ljava/lang/Object;)V

    .line 145
    return-object v1
.end method

.method public static buildDeleteSql(Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;
    .locals 8
    .param p0, "entity"    # Ljava/lang/Object;

    .prologue
    .line 110
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-static {v5}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v4

    .line 112
    .local v4, "table":Lnet/tsz/afinal/db/table/TableInfo;
    invoke-virtual {v4}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v0

    .line 113
    .local v0, "id":Lnet/tsz/afinal/db/table/Id;
    invoke-virtual {v0, p0}, Lnet/tsz/afinal/db/table/Id;->getValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 115
    .local v1, "idvalue":Ljava/lang/Object;
    if-nez v1, :cond_0

    .line 116
    new-instance v5, Lnet/tsz/afinal/exception/DbException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "getDeleteSQL:"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " id value is null"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lnet/tsz/afinal/exception/DbException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 118
    :cond_0
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-virtual {v4}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getDeleteSqlBytableName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v5}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 119
    .local v3, "strSQL":Ljava/lang/StringBuffer;
    const-string v5, " WHERE "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {v0}, Lnet/tsz/afinal/db/table/Id;->getColumn()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v6, "=?"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 121
    new-instance v2, Lnet/tsz/afinal/db/sqlite/SqlInfo;

    invoke-direct {v2}, Lnet/tsz/afinal/db/sqlite/SqlInfo;-><init>()V

    .line 122
    .local v2, "sqlInfo":Lnet/tsz/afinal/db/sqlite/SqlInfo;
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->setSql(Ljava/lang/String;)V

    .line 123
    invoke-virtual {v2, v1}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->addValue(Ljava/lang/Object;)V

    .line 125
    return-object v2
.end method

.method public static buildInsertSql(Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;
    .locals 9
    .param p0, "entity"    # Ljava/lang/Object;

    .prologue
    .line 40
    invoke-static {p0}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSaveKeyValueListByEntity(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    .line 42
    .local v1, "keyValueList":Ljava/util/List;, "Ljava/util/List<Lnet/tsz/afinal/db/table/KeyValue;>;"
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    .line 43
    .local v5, "strSQL":Ljava/lang/StringBuffer;
    const/4 v4, 0x0

    .line 44
    .local v4, "sqlInfo":Lnet/tsz/afinal/db/sqlite/SqlInfo;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v6

    if-lez v6, :cond_0

    .line 46
    new-instance v4, Lnet/tsz/afinal/db/sqlite/SqlInfo;

    .end local v4    # "sqlInfo":Lnet/tsz/afinal/db/sqlite/SqlInfo;
    invoke-direct {v4}, Lnet/tsz/afinal/db/sqlite/SqlInfo;-><init>()V

    .line 48
    .restart local v4    # "sqlInfo":Lnet/tsz/afinal/db/sqlite/SqlInfo;
    const-string v6, "INSERT INTO "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 49
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-static {v6}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v6

    invoke-virtual {v6}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 50
    const-string v6, " ("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 51
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_1

    .line 55
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->length()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 56
    const-string v6, ") VALUES ( "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 58
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    .line 59
    .local v3, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-lt v0, v3, :cond_2

    .line 62
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->length()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 63
    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 65
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->setSql(Ljava/lang/String;)V

    .line 68
    .end local v0    # "i":I
    .end local v3    # "length":I
    :cond_0
    return-object v4

    .line 51
    :cond_1
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lnet/tsz/afinal/db/table/KeyValue;

    .line 52
    .local v2, "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-virtual {v2}, Lnet/tsz/afinal/db/table/KeyValue;->getKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v7

    const-string v8, ","

    invoke-virtual {v7, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 53
    invoke-virtual {v2}, Lnet/tsz/afinal/db/table/KeyValue;->getValue()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v4, v7}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->addValue(Ljava/lang/Object;)V

    goto :goto_0

    .line 60
    .end local v2    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    .restart local v0    # "i":I
    .restart local v3    # "length":I
    :cond_2
    const-string v6, "?,"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 59
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static getCreatTableSQL(Ljava/lang/Class;)Ljava/lang/String;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 305
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p0}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v7

    .line 307
    .local v7, "table":Lnet/tsz/afinal/db/table/TableInfo;
    invoke-virtual {v7}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v0

    .line 308
    .local v0, "id":Lnet/tsz/afinal/db/table/Id;
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    .line 309
    .local v6, "strSQL":Ljava/lang/StringBuffer;
    const-string v8, "CREATE TABLE IF NOT EXISTS "

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 310
    invoke-virtual {v7}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 311
    const-string v8, " ( "

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 313
    invoke-virtual {v0}, Lnet/tsz/afinal/db/table/Id;->getDataType()Ljava/lang/Class;

    move-result-object v3

    .line 314
    .local v3, "primaryClazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v8, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    if-eq v3, v8, :cond_0

    const-class v8, Ljava/lang/Integer;

    if-ne v3, v8, :cond_1

    .line 315
    :cond_0
    const-string v8, "\""

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v0}, Lnet/tsz/afinal/db/table/Id;->getColumn()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, "\"    "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, "INTEGER PRIMARY KEY AUTOINCREMENT,"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 319
    :goto_0
    iget-object v8, v7, Lnet/tsz/afinal/db/table/TableInfo;->propertyMap:Ljava/util/HashMap;

    invoke-virtual {v8}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v5

    .line 320
    .local v5, "propertys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/Property;>;"
    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_2

    .line 325
    iget-object v8, v7, Lnet/tsz/afinal/db/table/TableInfo;->manyToOneMap:Ljava/util/HashMap;

    invoke-virtual {v8}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v2

    .line 326
    .local v2, "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_3

    .line 329
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->length()I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 330
    const-string v8, " )"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 331
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    return-object v8

    .line 317
    .end local v2    # "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    .end local v5    # "propertys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/Property;>;"
    :cond_1
    const-string v8, "\""

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v0}, Lnet/tsz/afinal/db/table/Id;->getColumn()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, "\"    "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, "TEXT PRIMARY KEY,"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 320
    .restart local v5    # "propertys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/Property;>;"
    :cond_2
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lnet/tsz/afinal/db/table/Property;

    .line 321
    .local v4, "property":Lnet/tsz/afinal/db/table/Property;
    const-string v9, "\""

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {v4}, Lnet/tsz/afinal/db/table/Property;->getColumn()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 322
    const-string v9, "\","

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 326
    .end local v4    # "property":Lnet/tsz/afinal/db/table/Property;
    .restart local v2    # "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_3
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lnet/tsz/afinal/db/table/ManyToOne;

    .line 327
    .local v1, "manyToOne":Lnet/tsz/afinal/db/table/ManyToOne;
    const-string v9, "\""

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {v1}, Lnet/tsz/afinal/db/table/ManyToOne;->getColumn()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    const-string v10, "\","

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2
.end method

.method private static getDeleteSqlBytableName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "tableName"    # Ljava/lang/String;

    .prologue
    .line 105
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "DELETE FROM "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getPropertyStrSql(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 341
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1, p0}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    const-string v2, "="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    .line 342
    .local v0, "sbSQL":Ljava/lang/StringBuffer;
    instance-of v1, p1, Ljava/lang/String;

    if-nez v1, :cond_0

    instance-of v1, p1, Ljava/util/Date;

    if-nez v1, :cond_0

    instance-of v1, p1, Ljava/sql/Date;

    if-eqz v1, :cond_1

    .line 343
    :cond_0
    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 347
    :goto_0
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 345
    :cond_1
    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public static getSaveKeyValueListByEntity(Ljava/lang/Object;)Ljava/util/List;
    .locals 10
    .param p0, "entity"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<",
            "Lnet/tsz/afinal/db/table/KeyValue;",
            ">;"
        }
    .end annotation

    .prologue
    .line 73
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 75
    .local v1, "keyValueList":Ljava/util/List;, "Ljava/util/List<Lnet/tsz/afinal/db/table/KeyValue;>;"
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    invoke-static {v8}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v7

    .line 76
    .local v7, "table":Lnet/tsz/afinal/db/table/TableInfo;
    invoke-virtual {v7}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v8

    invoke-virtual {v8, p0}, Lnet/tsz/afinal/db/table/Id;->getValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 78
    .local v0, "idvalue":Ljava/lang/Object;
    instance-of v8, v0, Ljava/lang/Integer;

    if-nez v8, :cond_0

    .line 79
    instance-of v8, v0, Ljava/lang/String;

    if-eqz v8, :cond_0

    if-eqz v0, :cond_0

    .line 80
    new-instance v2, Lnet/tsz/afinal/db/table/KeyValue;

    invoke-virtual {v7}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v8

    invoke-virtual {v8}, Lnet/tsz/afinal/db/table/Id;->getColumn()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v2, v8, v0}, Lnet/tsz/afinal/db/table/KeyValue;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    .line 81
    .local v2, "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 86
    .end local v2    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    :cond_0
    iget-object v8, v7, Lnet/tsz/afinal/db/table/TableInfo;->propertyMap:Ljava/util/HashMap;

    invoke-virtual {v8}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v6

    .line 87
    .local v6, "propertys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/Property;>;"
    invoke-interface {v6}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_1
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_3

    .line 94
    iget-object v8, v7, Lnet/tsz/afinal/db/table/TableInfo;->manyToOneMap:Ljava/util/HashMap;

    invoke-virtual {v8}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v4

    .line 95
    .local v4, "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_2
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_4

    .line 100
    return-object v1

    .line 87
    .end local v4    # "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_3
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lnet/tsz/afinal/db/table/Property;

    .line 88
    .local v5, "property":Lnet/tsz/afinal/db/table/Property;
    invoke-static {v5, p0}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->property2KeyValue(Lnet/tsz/afinal/db/table/Property;Ljava/lang/Object;)Lnet/tsz/afinal/db/table/KeyValue;

    move-result-object v2

    .line 89
    .restart local v2    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    if-eqz v2, :cond_1

    .line 90
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 95
    .end local v2    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    .end local v5    # "property":Lnet/tsz/afinal/db/table/Property;
    .restart local v4    # "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_4
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lnet/tsz/afinal/db/table/ManyToOne;

    .line 96
    .local v3, "many":Lnet/tsz/afinal/db/table/ManyToOne;
    invoke-static {v3, p0}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->manyToOne2KeyValue(Lnet/tsz/afinal/db/table/ManyToOne;Ljava/lang/Object;)Lnet/tsz/afinal/db/table/KeyValue;

    move-result-object v2

    .line 97
    .restart local v2    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    if-eqz v2, :cond_2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1
.end method

.method public static getSelectSQL(Ljava/lang/Class;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 200
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p0}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v0

    invoke-virtual {v0}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSqlByTableName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSelectSQL(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p1, "idValue"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Object;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 176
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p0}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v1

    .line 178
    .local v1, "table":Lnet/tsz/afinal/db/table/TableInfo;
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSqlByTableName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 179
    .local v0, "strSQL":Ljava/lang/StringBuffer;
    const-string v2, " WHERE "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 180
    invoke-virtual {v1}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v2

    invoke-virtual {v2}, Lnet/tsz/afinal/db/table/Id;->getColumn()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getPropertyStrSql(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 182
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static getSelectSQLByWhere(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "strWhere"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 204
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p0}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v1

    .line 206
    .local v1, "table":Lnet/tsz/afinal/db/table/TableInfo;
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSqlByTableName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 208
    .local v0, "strSQL":Ljava/lang/StringBuffer;
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 209
    const-string v2, " WHERE "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 212
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static getSelectSqlAsSqlInfo(Ljava/lang/Class;Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;
    .locals 5
    .param p1, "idValue"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Object;",
            ")",
            "Lnet/tsz/afinal/db/sqlite/SqlInfo;"
        }
    .end annotation

    .prologue
    .line 186
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p0}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v2

    .line 188
    .local v2, "table":Lnet/tsz/afinal/db/table/TableInfo;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-virtual {v2}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSqlByTableName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 189
    .local v1, "strSQL":Ljava/lang/StringBuffer;
    const-string v3, " WHERE "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v3

    invoke-virtual {v2}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v4

    invoke-virtual {v4}, Lnet/tsz/afinal/db/table/Id;->getColumn()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v3

    const-string v4, "=?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 191
    new-instance v0, Lnet/tsz/afinal/db/sqlite/SqlInfo;

    invoke-direct {v0}, Lnet/tsz/afinal/db/sqlite/SqlInfo;-><init>()V

    .line 192
    .local v0, "sqlInfo":Lnet/tsz/afinal/db/sqlite/SqlInfo;
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->setSql(Ljava/lang/String;)V

    .line 193
    invoke-virtual {v0, p1}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->addValue(Ljava/lang/Object;)V

    .line 195
    return-object v0
.end method

.method private static getSelectSqlByTableName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "tableName"    # Ljava/lang/String;

    .prologue
    .line 171
    new-instance v0, Ljava/lang/StringBuffer;

    const-string v1, "SELECT * FROM "

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUpdateSqlAsSqlInfo(Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;
    .locals 13
    .param p0, "entity"    # Ljava/lang/Object;

    .prologue
    .line 219
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v10

    invoke-static {v10}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v9

    .line 220
    .local v9, "table":Lnet/tsz/afinal/db/table/TableInfo;
    invoke-virtual {v9}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v10

    invoke-virtual {v10, p0}, Lnet/tsz/afinal/db/table/Id;->getValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 222
    .local v0, "idvalue":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 223
    new-instance v10, Lnet/tsz/afinal/exception/DbException;

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "this entity["

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "]\'s id value is null"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Lnet/tsz/afinal/exception/DbException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 226
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 228
    .local v1, "keyValueList":Ljava/util/List;, "Ljava/util/List<Lnet/tsz/afinal/db/table/KeyValue;>;"
    iget-object v10, v9, Lnet/tsz/afinal/db/table/TableInfo;->propertyMap:Ljava/util/HashMap;

    invoke-virtual {v10}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v6

    .line 229
    .local v6, "propertys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/Property;>;"
    invoke-interface {v6}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_1
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_4

    .line 236
    iget-object v10, v9, Lnet/tsz/afinal/db/table/TableInfo;->manyToOneMap:Ljava/util/HashMap;

    invoke-virtual {v10}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v4

    .line 237
    .local v4, "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_2
    :goto_1
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_5

    .line 242
    if-eqz v1, :cond_3

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v10

    if-nez v10, :cond_6

    :cond_3
    const/4 v7, 0x0

    .line 256
    :goto_2
    return-object v7

    .line 229
    .end local v4    # "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_4
    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lnet/tsz/afinal/db/table/Property;

    .line 230
    .local v5, "property":Lnet/tsz/afinal/db/table/Property;
    invoke-static {v5, p0}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->property2KeyValue(Lnet/tsz/afinal/db/table/Property;Ljava/lang/Object;)Lnet/tsz/afinal/db/table/KeyValue;

    move-result-object v2

    .line 231
    .local v2, "kv":Lnet/tsz/afinal/db/table/KeyValue;
    if-eqz v2, :cond_1

    .line 232
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 237
    .end local v2    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    .end local v5    # "property":Lnet/tsz/afinal/db/table/Property;
    .restart local v4    # "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_5
    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lnet/tsz/afinal/db/table/ManyToOne;

    .line 238
    .local v3, "many":Lnet/tsz/afinal/db/table/ManyToOne;
    invoke-static {v3, p0}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->manyToOne2KeyValue(Lnet/tsz/afinal/db/table/ManyToOne;Ljava/lang/Object;)Lnet/tsz/afinal/db/table/KeyValue;

    move-result-object v2

    .line 239
    .restart local v2    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    if-eqz v2, :cond_2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 244
    .end local v2    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    .end local v3    # "many":Lnet/tsz/afinal/db/table/ManyToOne;
    :cond_6
    new-instance v7, Lnet/tsz/afinal/db/sqlite/SqlInfo;

    invoke-direct {v7}, Lnet/tsz/afinal/db/sqlite/SqlInfo;-><init>()V

    .line 245
    .local v7, "sqlInfo":Lnet/tsz/afinal/db/sqlite/SqlInfo;
    new-instance v8, Ljava/lang/StringBuffer;

    const-string v10, "UPDATE "

    invoke-direct {v8, v10}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 246
    .local v8, "strSQL":Ljava/lang/StringBuffer;
    invoke-virtual {v9}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 247
    const-string v10, " SET "

    invoke-virtual {v8, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 248
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :goto_3
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_7

    .line 252
    invoke-virtual {v8}, Ljava/lang/StringBuffer;->length()I

    move-result v10

    add-int/lit8 v10, v10, -0x1

    invoke-virtual {v8, v10}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 253
    const-string v10, " WHERE "

    invoke-virtual {v8, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v10

    invoke-virtual {v9}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v11

    invoke-virtual {v11}, Lnet/tsz/afinal/db/table/Id;->getColumn()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v10

    const-string v11, "=?"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 254
    invoke-virtual {v7, v0}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->addValue(Ljava/lang/Object;)V

    .line 255
    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->setSql(Ljava/lang/String;)V

    goto :goto_2

    .line 248
    :cond_7
    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lnet/tsz/afinal/db/table/KeyValue;

    .line 249
    .restart local v2    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-virtual {v2}, Lnet/tsz/afinal/db/table/KeyValue;->getKey()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v8, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "=?,"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 250
    invoke-virtual {v2}, Lnet/tsz/afinal/db/table/KeyValue;->getValue()Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v7, v11}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->addValue(Ljava/lang/Object;)V

    goto :goto_3
.end method

.method public static getUpdateSqlAsSqlInfo(Ljava/lang/Object;Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/SqlInfo;
    .locals 12
    .param p0, "entity"    # Ljava/lang/Object;
    .param p1, "strWhere"    # Ljava/lang/String;

    .prologue
    .line 264
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v9

    invoke-static {v9}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v8

    .line 266
    .local v8, "table":Lnet/tsz/afinal/db/table/TableInfo;
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 269
    .local v0, "keyValueList":Ljava/util/List;, "Ljava/util/List<Lnet/tsz/afinal/db/table/KeyValue;>;"
    iget-object v9, v8, Lnet/tsz/afinal/db/table/TableInfo;->propertyMap:Ljava/util/HashMap;

    invoke-virtual {v9}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v5

    .line 270
    .local v5, "propertys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/Property;>;"
    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_3

    .line 276
    iget-object v9, v8, Lnet/tsz/afinal/db/table/TableInfo;->manyToOneMap:Ljava/util/HashMap;

    invoke-virtual {v9}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v3

    .line 277
    .local v3, "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_1
    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_4

    .line 282
    if-eqz v0, :cond_2

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v9

    if-nez v9, :cond_5

    .line 283
    :cond_2
    new-instance v9, Lnet/tsz/afinal/exception/DbException;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "this entity["

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "] has no property"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Lnet/tsz/afinal/exception/DbException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 270
    .end local v3    # "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_3
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lnet/tsz/afinal/db/table/Property;

    .line 271
    .local v4, "property":Lnet/tsz/afinal/db/table/Property;
    invoke-static {v4, p0}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->property2KeyValue(Lnet/tsz/afinal/db/table/Property;Ljava/lang/Object;)Lnet/tsz/afinal/db/table/KeyValue;

    move-result-object v1

    .line 272
    .local v1, "kv":Lnet/tsz/afinal/db/table/KeyValue;
    if-eqz v1, :cond_0

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 277
    .end local v1    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    .end local v4    # "property":Lnet/tsz/afinal/db/table/Property;
    .restart local v3    # "manyToOnes":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_4
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lnet/tsz/afinal/db/table/ManyToOne;

    .line 278
    .local v2, "many":Lnet/tsz/afinal/db/table/ManyToOne;
    invoke-static {v2, p0}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->manyToOne2KeyValue(Lnet/tsz/afinal/db/table/ManyToOne;Ljava/lang/Object;)Lnet/tsz/afinal/db/table/KeyValue;

    move-result-object v1

    .line 279
    .restart local v1    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    if-eqz v1, :cond_1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 286
    .end local v1    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    .end local v2    # "many":Lnet/tsz/afinal/db/table/ManyToOne;
    :cond_5
    new-instance v6, Lnet/tsz/afinal/db/sqlite/SqlInfo;

    invoke-direct {v6}, Lnet/tsz/afinal/db/sqlite/SqlInfo;-><init>()V

    .line 287
    .local v6, "sqlInfo":Lnet/tsz/afinal/db/sqlite/SqlInfo;
    new-instance v7, Ljava/lang/StringBuffer;

    const-string v9, "UPDATE "

    invoke-direct {v7, v9}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 288
    .local v7, "strSQL":Ljava/lang/StringBuffer;
    invoke-virtual {v8}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 289
    const-string v9, " SET "

    invoke-virtual {v7, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 290
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_7

    .line 294
    invoke-virtual {v7}, Ljava/lang/StringBuffer;->length()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    invoke-virtual {v7, v9}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 295
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_6

    .line 296
    const-string v9, " WHERE "

    invoke-virtual {v7, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {v9, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 298
    :cond_6
    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->setSql(Ljava/lang/String;)V

    .line 299
    return-object v6

    .line 290
    :cond_7
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lnet/tsz/afinal/db/table/KeyValue;

    .line 291
    .restart local v1    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-virtual {v1}, Lnet/tsz/afinal/db/table/KeyValue;->getKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v10

    const-string v11, "=?,"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 292
    invoke-virtual {v1}, Lnet/tsz/afinal/db/table/KeyValue;->getValue()Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v6, v10}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->addValue(Ljava/lang/Object;)V

    goto :goto_2
.end method

.method private static manyToOne2KeyValue(Lnet/tsz/afinal/db/table/ManyToOne;Ljava/lang/Object;)Lnet/tsz/afinal/db/table/KeyValue;
    .locals 5
    .param p0, "many"    # Lnet/tsz/afinal/db/table/ManyToOne;
    .param p1, "entity"    # Ljava/lang/Object;

    .prologue
    .line 367
    const/4 v0, 0x0

    .line 368
    .local v0, "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-virtual {p0}, Lnet/tsz/afinal/db/table/ManyToOne;->getColumn()Ljava/lang/String;

    move-result-object v1

    .line 369
    .local v1, "manycolumn":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lnet/tsz/afinal/db/table/ManyToOne;->getValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 370
    .local v2, "manyobject":Ljava/lang/Object;
    if-eqz v2, :cond_0

    .line 371
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v4

    invoke-virtual {v4}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v4

    invoke-virtual {v4, v2}, Lnet/tsz/afinal/db/table/Id;->getValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 372
    .local v3, "manyvalue":Ljava/lang/Object;
    if-eqz v1, :cond_0

    if-eqz v3, :cond_0

    .line 373
    new-instance v0, Lnet/tsz/afinal/db/table/KeyValue;

    .end local v0    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-direct {v0, v1, v3}, Lnet/tsz/afinal/db/table/KeyValue;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    .line 377
    .end local v3    # "manyvalue":Ljava/lang/Object;
    .restart local v0    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    :cond_0
    return-object v0
.end method

.method private static property2KeyValue(Lnet/tsz/afinal/db/table/Property;Ljava/lang/Object;)Lnet/tsz/afinal/db/table/KeyValue;
    .locals 4
    .param p0, "property"    # Lnet/tsz/afinal/db/table/Property;
    .param p1, "entity"    # Ljava/lang/Object;

    .prologue
    .line 353
    const/4 v0, 0x0

    .line 354
    .local v0, "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-virtual {p0}, Lnet/tsz/afinal/db/table/Property;->getColumn()Ljava/lang/String;

    move-result-object v1

    .line 355
    .local v1, "pcolumn":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lnet/tsz/afinal/db/table/Property;->getValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 356
    .local v2, "value":Ljava/lang/Object;
    if-eqz v2, :cond_1

    .line 357
    new-instance v0, Lnet/tsz/afinal/db/table/KeyValue;

    .end local v0    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/db/table/KeyValue;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    .line 362
    .restart local v0    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    :cond_0
    :goto_0
    return-object v0

    .line 359
    :cond_1
    invoke-virtual {p0}, Lnet/tsz/afinal/db/table/Property;->getDefaultValue()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {p0}, Lnet/tsz/afinal/db/table/Property;->getDefaultValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_0

    .line 360
    new-instance v0, Lnet/tsz/afinal/db/table/KeyValue;

    .end local v0    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-virtual {p0}, Lnet/tsz/afinal/db/table/Property;->getDefaultValue()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v3}, Lnet/tsz/afinal/db/table/KeyValue;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    .restart local v0    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    goto :goto_0
.end method
