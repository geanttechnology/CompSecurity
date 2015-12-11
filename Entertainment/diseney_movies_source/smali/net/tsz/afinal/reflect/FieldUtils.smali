.class public Lnet/tsz/afinal/reflect/FieldUtils;
.super Ljava/lang/Object;
.source "FieldUtils.java"


# static fields
.field private static sdf:Ljava/text/SimpleDateFormat;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 340
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd HH:mm:ss"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lnet/tsz/afinal/reflect/FieldUtils;->sdf:Ljava/text/SimpleDateFormat;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getBooleanFieldGetMethod(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;
    .locals 6
    .param p1, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 53
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "is"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 54
    .local v1, "mn":Ljava/lang/String;
    invoke-static {p1}, Lnet/tsz/afinal/reflect/FieldUtils;->isISStart(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 55
    move-object v1, p1

    .line 58
    :cond_0
    const/4 v2, 0x0

    :try_start_0
    new-array v2, v2, [Ljava/lang/Class;

    invoke-virtual {p0, v1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 61
    :goto_0
    return-object v2

    .line 59
    :catch_0
    move-exception v0

    .line 60
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    invoke-virtual {v0}, Ljava/lang/NoSuchMethodException;->printStackTrace()V

    .line 61
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static getBooleanFieldSetMethod(Ljava/lang/Class;Ljava/lang/reflect/Field;)Ljava/lang/reflect/Method;
    .locals 8
    .param p1, "f"    # Ljava/lang/reflect/Field;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/reflect/Field;",
            ")",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v7, 0x3

    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 67
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v1

    .line 68
    .local v1, "fn":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "set"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 69
    .local v2, "mn":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lnet/tsz/afinal/reflect/FieldUtils;->isISStart(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 70
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "set"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v4, 0x2

    invoke-virtual {v1, v4, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 73
    :cond_0
    const/4 v3, 0x1

    :try_start_0
    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {p0, v2, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 76
    :goto_0
    return-object v3

    .line 74
    :catch_0
    move-exception v0

    .line 75
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    invoke-virtual {v0}, Ljava/lang/NoSuchMethodException;->printStackTrace()V

    .line 76
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static getColumnByField(Ljava/lang/reflect/Field;)Ljava/lang/String;
    .locals 5
    .param p0, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 247
    const-class v4, Lnet/tsz/afinal/annotation/sqlite/Property;

    invoke-virtual {p0, v4}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v3

    check-cast v3, Lnet/tsz/afinal/annotation/sqlite/Property;

    .line 248
    .local v3, "property":Lnet/tsz/afinal/annotation/sqlite/Property;
    if-eqz v3, :cond_0

    invoke-interface {v3}, Lnet/tsz/afinal/annotation/sqlite/Property;->column()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_0

    .line 249
    invoke-interface {v3}, Lnet/tsz/afinal/annotation/sqlite/Property;->column()Ljava/lang/String;

    move-result-object v4

    .line 266
    :goto_0
    return-object v4

    .line 252
    :cond_0
    const-class v4, Lnet/tsz/afinal/annotation/sqlite/ManyToOne;

    invoke-virtual {p0, v4}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v1

    check-cast v1, Lnet/tsz/afinal/annotation/sqlite/ManyToOne;

    .line 253
    .local v1, "manyToOne":Lnet/tsz/afinal/annotation/sqlite/ManyToOne;
    if-eqz v1, :cond_1

    invoke-interface {v1}, Lnet/tsz/afinal/annotation/sqlite/ManyToOne;->column()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_1

    .line 254
    invoke-interface {v1}, Lnet/tsz/afinal/annotation/sqlite/ManyToOne;->column()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 257
    :cond_1
    const-class v4, Lnet/tsz/afinal/annotation/sqlite/OneToMany;

    invoke-virtual {p0, v4}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v2

    check-cast v2, Lnet/tsz/afinal/annotation/sqlite/OneToMany;

    .line 258
    .local v2, "oneToMany":Lnet/tsz/afinal/annotation/sqlite/OneToMany;
    if-eqz v2, :cond_2

    invoke-interface {v2}, Lnet/tsz/afinal/annotation/sqlite/OneToMany;->manyColumn()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_2

    invoke-interface {v2}, Lnet/tsz/afinal/annotation/sqlite/OneToMany;->manyColumn()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_2

    .line 259
    invoke-interface {v2}, Lnet/tsz/afinal/annotation/sqlite/OneToMany;->manyColumn()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 262
    :cond_2
    const-class v4, Lnet/tsz/afinal/annotation/sqlite/Id;

    invoke-virtual {p0, v4}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/annotation/sqlite/Id;

    .line 263
    .local v0, "id":Lnet/tsz/afinal/annotation/sqlite/Id;
    if-eqz v0, :cond_3

    invoke-interface {v0}, Lnet/tsz/afinal/annotation/sqlite/Id;->column()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_3

    .line 264
    invoke-interface {v0}, Lnet/tsz/afinal/annotation/sqlite/Id;->column()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 266
    :cond_3
    invoke-virtual {p0}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method public static getFieldByColumnName(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    .locals 8
    .param p1, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/reflect/Field;"
        }
    .end annotation

    .prologue
    .line 186
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v1, 0x0

    .line 187
    .local v1, "field":Ljava/lang/reflect/Field;
    if-eqz p1, :cond_2

    .line 188
    invoke-virtual {p0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    .line 189
    .local v2, "fields":[Ljava/lang/reflect/Field;
    if-eqz v2, :cond_2

    array-length v5, v2

    if-lez v5, :cond_2

    .line 190
    invoke-static {p0}, Lnet/tsz/afinal/reflect/ClassUtils;->getPrimaryKeyColumn(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 191
    invoke-static {p0}, Lnet/tsz/afinal/reflect/ClassUtils;->getPrimaryKeyField(Ljava/lang/Class;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 193
    :cond_0
    if-nez v1, :cond_1

    .line 194
    array-length v6, v2

    const/4 v5, 0x0

    :goto_0
    if-lt v5, v6, :cond_3

    .line 209
    :cond_1
    :goto_1
    if-nez v1, :cond_2

    .line 210
    invoke-static {p0, p1}, Lnet/tsz/afinal/reflect/FieldUtils;->getFieldByName(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 214
    .end local v2    # "fields":[Ljava/lang/reflect/Field;
    :cond_2
    return-object v1

    .line 194
    .restart local v2    # "fields":[Ljava/lang/reflect/Field;
    :cond_3
    aget-object v0, v2, v5

    .line 195
    .local v0, "f":Ljava/lang/reflect/Field;
    const-class v7, Lnet/tsz/afinal/annotation/sqlite/Property;

    invoke-virtual {v0, v7}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v4

    check-cast v4, Lnet/tsz/afinal/annotation/sqlite/Property;

    .line 196
    .local v4, "property":Lnet/tsz/afinal/annotation/sqlite/Property;
    if-eqz v4, :cond_4

    invoke-interface {v4}, Lnet/tsz/afinal/annotation/sqlite/Property;->column()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 197
    move-object v1, v0

    .line 198
    goto :goto_1

    .line 201
    :cond_4
    const-class v7, Lnet/tsz/afinal/annotation/sqlite/ManyToOne;

    invoke-virtual {v0, v7}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v3

    check-cast v3, Lnet/tsz/afinal/annotation/sqlite/ManyToOne;

    .line 202
    .local v3, "manyToOne":Lnet/tsz/afinal/annotation/sqlite/ManyToOne;
    if-eqz v3, :cond_5

    invoke-interface {v3}, Lnet/tsz/afinal/annotation/sqlite/ManyToOne;->column()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-eqz v7, :cond_5

    .line 203
    move-object v1, v0

    .line 204
    goto :goto_1

    .line 194
    :cond_5
    add-int/lit8 v5, v5, 0x1

    goto :goto_0
.end method

.method public static getFieldByName(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    .locals 2
    .param p1, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/reflect/Field;"
        }
    .end annotation

    .prologue
    .line 225
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v1, 0x0

    .line 226
    .local v1, "field":Ljava/lang/reflect/Field;
    if-eqz p1, :cond_0

    .line 228
    :try_start_0
    invoke-virtual {p0, p1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 235
    :cond_0
    :goto_0
    return-object v1

    .line 229
    :catch_0
    move-exception v0

    .line 230
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-virtual {v0}, Ljava/lang/SecurityException;->printStackTrace()V

    goto :goto_0

    .line 231
    .end local v0    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v0

    .line 232
    .local v0, "e":Ljava/lang/NoSuchFieldException;
    invoke-virtual {v0}, Ljava/lang/NoSuchFieldException;->printStackTrace()V

    goto :goto_0
.end method

.method public static getFieldGetMethod(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;
    .locals 6
    .param p1, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 92
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "get"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 94
    .local v1, "mn":Ljava/lang/String;
    const/4 v2, 0x0

    :try_start_0
    new-array v2, v2, [Ljava/lang/Class;

    invoke-virtual {p0, v1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 97
    :goto_0
    return-object v2

    .line 95
    :catch_0
    move-exception v0

    .line 96
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    invoke-virtual {v0}, Ljava/lang/NoSuchMethodException;->printStackTrace()V

    .line 97
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static getFieldGetMethod(Ljava/lang/Class;Ljava/lang/reflect/Field;)Ljava/lang/reflect/Method;
    .locals 4
    .param p1, "f"    # Ljava/lang/reflect/Field;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/reflect/Field;",
            ")",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .line 41
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v0

    .line 42
    .local v0, "fn":Ljava/lang/String;
    const/4 v1, 0x0

    .line 43
    .local v1, "m":Ljava/lang/reflect/Method;
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v2

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    if-ne v2, v3, :cond_0

    .line 44
    invoke-static {p0, v0}, Lnet/tsz/afinal/reflect/FieldUtils;->getBooleanFieldGetMethod(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 46
    :cond_0
    if-nez v1, :cond_1

    .line 47
    invoke-static {p0, v0}, Lnet/tsz/afinal/reflect/FieldUtils;->getFieldGetMethod(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 49
    :cond_1
    return-object v1
.end method

.method public static getFieldSetMethod(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;
    .locals 2
    .param p1, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .line 116
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :try_start_0
    invoke-virtual {p0, p1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    invoke-static {p0, v1}, Lnet/tsz/afinal/reflect/FieldUtils;->getFieldSetMethod(Ljava/lang/Class;Ljava/lang/reflect/Field;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 122
    :goto_0
    return-object v1

    .line 117
    :catch_0
    move-exception v0

    .line 118
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-virtual {v0}, Ljava/lang/SecurityException;->printStackTrace()V

    .line 122
    .end local v0    # "e":Ljava/lang/SecurityException;
    :goto_1
    const/4 v1, 0x0

    goto :goto_0

    .line 119
    :catch_1
    move-exception v0

    .line 120
    .local v0, "e":Ljava/lang/NoSuchFieldException;
    invoke-virtual {v0}, Ljava/lang/NoSuchFieldException;->printStackTrace()V

    goto :goto_1
.end method

.method public static getFieldSetMethod(Ljava/lang/Class;Ljava/lang/reflect/Field;)Ljava/lang/reflect/Method;
    .locals 7
    .param p1, "f"    # Ljava/lang/reflect/Field;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/reflect/Field;",
            ")",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 102
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v1

    .line 103
    .local v1, "fn":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "set"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 105
    .local v2, "mn":Ljava/lang/String;
    const/4 v3, 0x1

    :try_start_0
    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {p0, v2, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 111
    :goto_0
    return-object v3

    .line 106
    :catch_0
    move-exception v0

    .line 107
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v3

    sget-object v4, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    if-ne v3, v4, :cond_0

    .line 108
    invoke-static {p0, p1}, Lnet/tsz/afinal/reflect/FieldUtils;->getBooleanFieldSetMethod(Ljava/lang/Class;Ljava/lang/reflect/Field;)Ljava/lang/reflect/Method;

    move-result-object v3

    goto :goto_0

    .line 111
    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static getFieldValue(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 2
    .param p0, "entity"    # Ljava/lang/Object;
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 143
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-static {v1, p1}, Lnet/tsz/afinal/reflect/FieldUtils;->getFieldGetMethod(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 144
    .local v0, "method":Ljava/lang/reflect/Method;
    invoke-static {p0, v0}, Lnet/tsz/afinal/reflect/FieldUtils;->invoke(Ljava/lang/Object;Ljava/lang/reflect/Method;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public static getFieldValue(Ljava/lang/Object;Ljava/lang/reflect/Field;)Ljava/lang/Object;
    .locals 2
    .param p0, "entity"    # Ljava/lang/Object;
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 132
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-static {v1, p1}, Lnet/tsz/afinal/reflect/FieldUtils;->getFieldGetMethod(Ljava/lang/Class;Ljava/lang/reflect/Field;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 133
    .local v0, "method":Ljava/lang/reflect/Method;
    invoke-static {p0, v0}, Lnet/tsz/afinal/reflect/FieldUtils;->invoke(Ljava/lang/Object;Ljava/lang/reflect/Method;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public static getPropertyDefaultValue(Ljava/lang/reflect/Field;)Ljava/lang/String;
    .locals 2
    .param p0, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 272
    const-class v1, Lnet/tsz/afinal/annotation/sqlite/Property;

    invoke-virtual {p0, v1}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/annotation/sqlite/Property;

    .line 273
    .local v0, "property":Lnet/tsz/afinal/annotation/sqlite/Property;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lnet/tsz/afinal/annotation/sqlite/Property;->defaultValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_0

    .line 274
    invoke-interface {v0}, Lnet/tsz/afinal/annotation/sqlite/Property;->defaultValue()Ljava/lang/String;

    move-result-object v1

    .line 276
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private static invoke(Ljava/lang/Object;Ljava/lang/reflect/Method;)Ljava/lang/Object;
    .locals 3
    .param p0, "obj"    # Ljava/lang/Object;
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    const/4 v1, 0x0

    .line 297
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 307
    :cond_0
    :goto_0
    return-object v1

    .line 299
    :cond_1
    const/4 v2, 0x0

    :try_start_0
    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p1, p0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v1

    goto :goto_0

    .line 300
    :catch_0
    move-exception v0

    .line 301
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_0

    .line 302
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v0

    .line 303
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0

    .line 304
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v0

    .line 305
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->printStackTrace()V

    goto :goto_0
.end method

.method public static isBaseDateType(Ljava/lang/reflect/Field;)Z
    .locals 2
    .param p0, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 324
    invoke-virtual {p0}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v0

    .line 325
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v1, Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 326
    const-class v1, Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 327
    const-class v1, Ljava/lang/Byte;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 328
    const-class v1, Ljava/lang/Long;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 329
    const-class v1, Ljava/lang/Double;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 330
    const-class v1, Ljava/lang/Float;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 331
    const-class v1, Ljava/lang/Character;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 332
    const-class v1, Ljava/lang/Short;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 333
    const-class v1, Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 334
    const-class v1, Ljava/util/Date;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 335
    const-class v1, Ljava/util/Date;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 336
    const-class v1, Ljava/sql/Date;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 337
    invoke-virtual {v0}, Ljava/lang/Class;->isPrimitive()Z

    move-result v1

    if-nez v1, :cond_0

    .line 325
    const/4 v1, 0x0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private static isISStart(Ljava/lang/String;)Z
    .locals 2
    .param p0, "fieldName"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 82
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 85
    :cond_0
    :goto_0
    return v0

    :cond_1
    const-string v1, "is"

    invoke-virtual {p0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x2

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-static {v1}, Ljava/lang/Character;->isLowerCase(C)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isManyToOne(Ljava/lang/reflect/Field;)Z
    .locals 1
    .param p0, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 312
    const-class v0, Lnet/tsz/afinal/annotation/sqlite/ManyToOne;

    invoke-virtual {p0, v0}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isManyToOneOrOneToMany(Ljava/lang/reflect/Field;)Z
    .locals 1
    .param p0, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 320
    invoke-static {p0}, Lnet/tsz/afinal/reflect/FieldUtils;->isManyToOne(Ljava/lang/reflect/Field;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0}, Lnet/tsz/afinal/reflect/FieldUtils;->isOneToMany(Ljava/lang/reflect/Field;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isOneToMany(Ljava/lang/reflect/Field;)Z
    .locals 1
    .param p0, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 316
    const-class v0, Lnet/tsz/afinal/annotation/sqlite/OneToMany;

    invoke-virtual {p0, v0}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isTransient(Ljava/lang/reflect/Field;)Z
    .locals 1
    .param p0, "f"    # Ljava/lang/reflect/Field;

    .prologue
    .line 287
    const-class v0, Lnet/tsz/afinal/annotation/sqlite/Transient;

    invoke-virtual {p0, v0}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static setFieldValue(Ljava/lang/Object;Ljava/lang/reflect/Field;Ljava/lang/Object;)V
    .locals 7
    .param p0, "entity"    # Ljava/lang/Object;
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v3, 0x0

    .line 155
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4, p1}, Lnet/tsz/afinal/reflect/FieldUtils;->getFieldSetMethod(Ljava/lang/Class;Ljava/lang/reflect/Field;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 156
    .local v1, "set":Ljava/lang/reflect/Method;
    if-eqz v1, :cond_0

    .line 157
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    .line 158
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v2

    .line 159
    .local v2, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v4, Ljava/lang/String;

    if-ne v2, v4, :cond_1

    .line 160
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, p0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 176
    .end local v1    # "set":Ljava/lang/reflect/Method;
    .end local v2    # "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    :goto_0
    return-void

    .line 161
    .restart local v1    # "set":Ljava/lang/reflect/Method;
    .restart local v2    # "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    sget-object v4, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    if-eq v2, v4, :cond_2

    const-class v4, Ljava/lang/Integer;

    if-ne v2, v4, :cond_4

    .line 162
    :cond_2
    const/4 v3, 0x1

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    if-nez p2, :cond_3

    const/4 v3, 0x0

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    :goto_1
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v4, v5

    invoke-virtual {v1, p0, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 173
    .end local v1    # "set":Ljava/lang/reflect/Method;
    .end local v2    # "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catch_0
    move-exception v0

    .line 174
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 162
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "set":Ljava/lang/reflect/Method;
    .restart local v2    # "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_3
    :try_start_1
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    goto :goto_1

    .line 163
    :cond_4
    sget-object v4, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    if-eq v2, v4, :cond_5

    const-class v4, Ljava/lang/Float;

    if-ne v2, v4, :cond_7

    .line 164
    :cond_5
    const/4 v3, 0x1

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    if-nez p2, :cond_6

    const/4 v3, 0x0

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    :goto_2
    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    aput-object v3, v4, v5

    invoke-virtual {v1, p0, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_6
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v3

    goto :goto_2

    .line 165
    :cond_7
    sget-object v4, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    if-eq v2, v4, :cond_8

    const-class v4, Ljava/lang/Long;

    if-ne v2, v4, :cond_a

    .line 166
    :cond_8
    const/4 v3, 0x1

    new-array v5, v3, [Ljava/lang/Object;

    const/4 v6, 0x0

    if-nez p2, :cond_9

    const/4 v3, 0x0

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    :goto_3
    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v5, v6

    invoke-virtual {v1, p0, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_9
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    goto :goto_3

    .line 167
    :cond_a
    const-class v4, Ljava/util/Date;

    if-ne v2, v4, :cond_c

    .line 168
    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    if-nez p2, :cond_b

    :goto_4
    aput-object v3, v4, v5

    invoke-virtual {v1, p0, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    :cond_b
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lnet/tsz/afinal/reflect/FieldUtils;->stringToDateTime(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    goto :goto_4

    .line 170
    :cond_c
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    invoke-virtual {v1, p0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method private static stringToDateTime(Ljava/lang/String;)Ljava/util/Date;
    .locals 2
    .param p0, "strDate"    # Ljava/lang/String;

    .prologue
    .line 342
    if-eqz p0, :cond_0

    .line 344
    :try_start_0
    sget-object v1, Lnet/tsz/afinal/reflect/FieldUtils;->sdf:Ljava/text/SimpleDateFormat;

    invoke-virtual {v1, p0}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 349
    :goto_0
    return-object v1

    .line 345
    :catch_0
    move-exception v0

    .line 346
    .local v0, "e":Ljava/text/ParseException;
    invoke-virtual {v0}, Ljava/text/ParseException;->printStackTrace()V

    .line 349
    .end local v0    # "e":Ljava/text/ParseException;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
