.class public abstract Lorg/springframework/util/ClassUtils;
.super Ljava/lang/Object;
.source "ClassUtils.java"


# static fields
.field private static final commonClassCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;>;"
        }
    .end annotation
.end field

.field private static final primitiveTypeNameMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;>;"
        }
    .end annotation
.end field

.field private static final primitiveTypeToWrapperMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;>;"
        }
    .end annotation
.end field

.field private static final primitiveWrapperTypeMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 12

    .prologue
    const/4 v11, 0x3

    const/4 v10, 0x2

    const/16 v9, 0x8

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 77
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4, v9}, Ljava/util/HashMap;-><init>(I)V

    sput-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    .line 82
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4, v9}, Ljava/util/HashMap;-><init>(I)V

    sput-object v4, Lorg/springframework/util/ClassUtils;->primitiveTypeToWrapperMap:Ljava/util/Map;

    .line 87
    new-instance v4, Ljava/util/HashMap;

    const/16 v5, 0x20

    invoke-direct {v4, v5}, Ljava/util/HashMap;-><init>(I)V

    sput-object v4, Lorg/springframework/util/ClassUtils;->primitiveTypeNameMap:Ljava/util/Map;

    .line 93
    new-instance v4, Ljava/util/HashMap;

    const/16 v5, 0x20

    invoke-direct {v4, v5}, Ljava/util/HashMap;-><init>(I)V

    sput-object v4, Lorg/springframework/util/ClassUtils;->commonClassCache:Ljava/util/Map;

    .line 97
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    const-class v5, Ljava/lang/Boolean;

    sget-object v6, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    const-class v5, Ljava/lang/Byte;

    sget-object v6, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    const-class v5, Ljava/lang/Character;

    sget-object v6, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    const-class v5, Ljava/lang/Double;

    sget-object v6, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    const-class v5, Ljava/lang/Float;

    sget-object v6, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    const-class v5, Ljava/lang/Integer;

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 103
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    const-class v5, Ljava/lang/Long;

    sget-object v6, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    const-class v5, Ljava/lang/Short;

    sget-object v6, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 106
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 107
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Class<*>;Ljava/lang/Class<*>;>;"
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveTypeToWrapperMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    new-array v5, v8, [Ljava/lang/Class;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Class;

    aput-object v4, v5, v7

    invoke-static {v5}, Lorg/springframework/util/ClassUtils;->registerCommonClasses([Ljava/lang/Class;)V

    goto :goto_0

    .line 111
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Class<*>;Ljava/lang/Class<*>;>;"
    :cond_0
    new-instance v3, Ljava/util/HashSet;

    const/16 v4, 0x20

    invoke-direct {v3, v4}, Ljava/util/HashSet;-><init>(I)V

    .line 112
    .local v3, "primitiveTypes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Class<*>;>;"
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveWrapperTypeMap:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 113
    new-array v4, v9, [Ljava/lang/Class;

    const-class v5, [Z

    aput-object v5, v4, v7

    const-class v5, [B

    aput-object v5, v4, v8

    const-class v5, [C

    aput-object v5, v4, v10

    const-class v5, [D

    aput-object v5, v4, v11

    const/4 v5, 0x4

    const-class v6, [F

    aput-object v6, v4, v5

    const/4 v5, 0x5

    const-class v6, [I

    aput-object v6, v4, v5

    const/4 v5, 0x6

    const-class v6, [J

    aput-object v6, v4, v5

    const/4 v5, 0x7

    const-class v6, [S

    aput-object v6, v4, v5

    invoke-static {v4}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 114
    sget-object v4, Ljava/lang/Void;->TYPE:Ljava/lang/Class;

    invoke-interface {v3, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 115
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Class;

    .line 116
    .local v2, "primitiveType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v4, Lorg/springframework/util/ClassUtils;->primitiveTypeNameMap:Ljava/util/Map;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 119
    .end local v2    # "primitiveType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    new-array v4, v9, [Ljava/lang/Class;

    const-class v5, [Ljava/lang/Boolean;

    aput-object v5, v4, v7

    const-class v5, [Ljava/lang/Byte;

    aput-object v5, v4, v8

    const-class v5, [Ljava/lang/Character;

    aput-object v5, v4, v10

    const-class v5, [Ljava/lang/Double;

    aput-object v5, v4, v11

    const/4 v5, 0x4

    const-class v6, [Ljava/lang/Float;

    aput-object v6, v4, v5

    const/4 v5, 0x5

    const-class v6, [Ljava/lang/Integer;

    aput-object v6, v4, v5

    const/4 v5, 0x6

    const-class v6, [Ljava/lang/Long;

    aput-object v6, v4, v5

    const/4 v5, 0x7

    const-class v6, [Ljava/lang/Short;

    aput-object v6, v4, v5

    invoke-static {v4}, Lorg/springframework/util/ClassUtils;->registerCommonClasses([Ljava/lang/Class;)V

    .line 120
    new-array v4, v9, [Ljava/lang/Class;

    const-class v5, Ljava/lang/Number;

    aput-object v5, v4, v7

    const-class v5, [Ljava/lang/Number;

    aput-object v5, v4, v8

    const-class v5, Ljava/lang/String;

    aput-object v5, v4, v10

    const-class v5, [Ljava/lang/String;

    aput-object v5, v4, v11

    const/4 v5, 0x4

    const-class v6, Ljava/lang/Object;

    aput-object v6, v4, v5

    const/4 v5, 0x5

    const-class v6, [Ljava/lang/Object;

    aput-object v6, v4, v5

    const/4 v5, 0x6

    const-class v6, Ljava/lang/Class;

    aput-object v6, v4, v5

    const/4 v5, 0x7

    const-class v6, [Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-static {v4}, Lorg/springframework/util/ClassUtils;->registerCommonClasses([Ljava/lang/Class;)V

    .line 121
    const/4 v4, 0x6

    new-array v4, v4, [Ljava/lang/Class;

    const-class v5, Ljava/lang/Throwable;

    aput-object v5, v4, v7

    const-class v5, Ljava/lang/Exception;

    aput-object v5, v4, v8

    const-class v5, Ljava/lang/RuntimeException;

    aput-object v5, v4, v10

    const-class v5, Ljava/lang/Error;

    aput-object v5, v4, v11

    const/4 v5, 0x4

    const-class v6, Ljava/lang/StackTraceElement;

    aput-object v6, v4, v5

    const/4 v5, 0x5

    const-class v6, [Ljava/lang/StackTraceElement;

    aput-object v6, v4, v5

    invoke-static {v4}, Lorg/springframework/util/ClassUtils;->registerCommonClasses([Ljava/lang/Class;)V

    .line 122
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static forName(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;
    .locals 11
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "classLoader"    # Ljava/lang/ClassLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/ClassLoader;",
            ")",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Ljava/lang/LinkageError;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    .line 207
    const-string v8, "Name must not be null"

    invoke-static {p0, v8}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 209
    invoke-static {p0}, Lorg/springframework/util/ClassUtils;->resolvePrimitiveClassName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 210
    .local v1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez v1, :cond_0

    .line 211
    sget-object v8, Lorg/springframework/util/ClassUtils;->commonClassCache:Ljava/util/Map;

    invoke-interface {v8, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    check-cast v1, Ljava/lang/Class;

    .line 213
    .restart local v1    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    if-eqz v1, :cond_1

    .line 249
    .end local v1    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    return-object v1

    .line 218
    .restart local v1    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    const-string v8, "[]"

    invoke-virtual {p0, v8}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 219
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v8

    const-string v9, "[]"

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    sub-int/2addr v8, v9

    invoke-virtual {p0, v10, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 220
    .local v3, "elementClassName":Ljava/lang/String;
    invoke-static {v3, p1}, Lorg/springframework/util/ClassUtils;->forName(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v2

    .line 221
    .local v2, "elementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {v2, v10}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    goto :goto_0

    .line 225
    .end local v2    # "elementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v3    # "elementClassName":Ljava/lang/String;
    :cond_2
    const-string v8, "[L"

    invoke-virtual {p0, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    const-string v8, ";"

    invoke-virtual {p0, v8}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 226
    const-string v8, "[L"

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    invoke-virtual {p0, v8, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 227
    .local v4, "elementName":Ljava/lang/String;
    invoke-static {v4, p1}, Lorg/springframework/util/ClassUtils;->forName(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v2

    .line 228
    .restart local v2    # "elementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {v2, v10}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    goto :goto_0

    .line 232
    .end local v2    # "elementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v4    # "elementName":Ljava/lang/String;
    :cond_3
    const-string v8, "["

    invoke-virtual {p0, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 233
    const-string v8, "["

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-virtual {p0, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    .line 234
    .restart local v4    # "elementName":Ljava/lang/String;
    invoke-static {v4, p1}, Lorg/springframework/util/ClassUtils;->forName(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v2

    .line 235
    .restart local v2    # "elementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {v2, v10}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    goto :goto_0

    .line 238
    .end local v2    # "elementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v4    # "elementName":Ljava/lang/String;
    :cond_4
    move-object v0, p1

    .line 239
    .local v0, "classLoaderToUse":Ljava/lang/ClassLoader;
    if-nez v0, :cond_5

    .line 240
    invoke-static {}, Lorg/springframework/util/ClassUtils;->getDefaultClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 243
    :cond_5
    :try_start_0
    invoke-virtual {v0, p0}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 244
    :catch_0
    move-exception v5

    .line 245
    .local v5, "ex":Ljava/lang/ClassNotFoundException;
    const/16 v8, 0x2e

    invoke-virtual {p0, v8}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v7

    .line 246
    .local v7, "lastDotIndex":I
    const/4 v8, -0x1

    if-eq v7, v8, :cond_6

    .line 247
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, v10, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const/16 v9, 0x24

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v8

    add-int/lit8 v9, v7, 0x1

    invoke-virtual {p0, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 249
    .local v6, "innerClassName":Ljava/lang/String;
    :try_start_1
    invoke-virtual {v0, v6}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v1

    goto/16 :goto_0

    .line 250
    :catch_1
    move-exception v8

    .line 254
    .end local v6    # "innerClassName":Ljava/lang/String;
    :cond_6
    throw v5
.end method

.method public static getDefaultClassLoader()Ljava/lang/ClassLoader;
    .locals 2

    .prologue
    .line 145
    const/4 v0, 0x0

    .line 147
    .local v0, "cl":Ljava/lang/ClassLoader;
    :try_start_0
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getContextClassLoader()Ljava/lang/ClassLoader;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 151
    :goto_0
    if-nez v0, :cond_0

    .line 153
    const-class v1, Lorg/springframework/util/ClassUtils;

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 155
    :cond_0
    return-object v0

    .line 148
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static getDescriptiveType(Ljava/lang/Object;)Ljava/lang/String;
    .locals 5
    .param p0, "value"    # Ljava/lang/Object;

    .prologue
    .line 484
    if-nez p0, :cond_0

    .line 485
    const/4 v4, 0x0

    .line 502
    :goto_0
    return-object v4

    .line 487
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 488
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {v0}, Ljava/lang/reflect/Proxy;->isProxyClass(Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 489
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 490
    .local v3, "result":Ljava/lang/StringBuilder;
    const-string v4, " implementing "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 491
    invoke-virtual {v0}, Ljava/lang/Class;->getInterfaces()[Ljava/lang/Class;

    move-result-object v2

    .line 492
    .local v2, "ifcs":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v4, v2

    if-ge v1, v4, :cond_2

    .line 493
    aget-object v4, v2, v1

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 494
    array-length v4, v2

    add-int/lit8 v4, v4, -0x1

    if-ge v1, v4, :cond_1

    .line 495
    const/16 v4, 0x2c

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 492
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 498
    :cond_2
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 499
    .end local v1    # "i":I
    .end local v2    # "ifcs":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    .end local v3    # "result":Ljava/lang/StringBuilder;
    :cond_3
    invoke-virtual {v0}, Ljava/lang/Class;->isArray()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 500
    invoke-static {v0}, Lorg/springframework/util/ClassUtils;->getQualifiedNameForArray(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 502
    :cond_4
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method public static getQualifiedName(Ljava/lang/Class;)Ljava/lang/String;
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
    .line 443
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string v0, "Class must not be null"

    invoke-static {p0, v0}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 444
    invoke-virtual {p0}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 445
    invoke-static {p0}, Lorg/springframework/util/ClassUtils;->getQualifiedNameForArray(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    .line 447
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static getQualifiedNameForArray(Ljava/lang/Class;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 457
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 458
    .local v0, "result":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {p0}, Ljava/lang/Class;->isArray()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 459
    invoke-virtual {p0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object p0

    .line 460
    const-string v1, "[]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 462
    :cond_0
    const/4 v1, 0x0

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->insert(ILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 463
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static isPresent(Ljava/lang/String;Ljava/lang/ClassLoader;)Z
    .locals 2
    .param p0, "className"    # Ljava/lang/String;
    .param p1, "classLoader"    # Ljava/lang/ClassLoader;

    .prologue
    .line 323
    :try_start_0
    invoke-static {p0, p1}, Lorg/springframework/util/ClassUtils;->forName(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 324
    const/4 v1, 0x1

    .line 327
    :goto_0
    return v1

    .line 325
    :catch_0
    move-exception v0

    .line 327
    .local v0, "ex":Ljava/lang/Throwable;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private static varargs registerCommonClasses([Ljava/lang/Class;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 129
    .local p0, "commonClasses":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    move-object v0, p0

    .local v0, "arr$":[Ljava/lang/Class;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 130
    .local v1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v4, Lorg/springframework/util/ClassUtils;->commonClassCache:Ljava/util/Map;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 132
    .end local v1    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    return-void
.end method

.method public static resolvePrimitiveClassName(Ljava/lang/String;)Ljava/lang/Class;
    .locals 3
    .param p0, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 292
    const/4 v0, 0x0

    .line 295
    .local v0, "result":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x8

    if-gt v1, v2, :cond_0

    .line 297
    sget-object v1, Lorg/springframework/util/ClassUtils;->primitiveTypeNameMap:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "result":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    check-cast v0, Ljava/lang/Class;

    .line 299
    .restart local v0    # "result":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    return-object v0
.end method
