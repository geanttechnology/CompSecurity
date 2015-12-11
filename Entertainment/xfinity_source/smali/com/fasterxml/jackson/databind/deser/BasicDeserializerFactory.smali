.class public abstract Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;
.super Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
.source "BasicDeserializerFactory.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field protected static final _arrayDeserializers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field static final _collectionFallbacks:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+",
            "Ljava/util/Collection;",
            ">;>;"
        }
    .end annotation
.end field

.field protected static final _keyDeserializers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/KeyDeserializer;",
            ">;"
        }
    .end annotation
.end field

.field static final _mapFallbacks:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+",
            "Ljava/util/Map;",
            ">;>;"
        }
    .end annotation
.end field

.field protected static final _simpleDeserializers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/fasterxml/jackson/databind/type/ClassKey;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field protected final _factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

.field protected optionalHandlers:Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    .line 43
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    sput-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_simpleDeserializers:Ljava/util/HashMap;

    .line 49
    invoke-static {}, Lcom/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers;->getAll()Ljava/util/HashMap;

    move-result-object v4

    sput-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_arrayDeserializers:Ljava/util/HashMap;

    .line 56
    invoke-static {}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializers;->constructAll()Ljava/util/HashMap;

    move-result-object v4

    sput-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_keyDeserializers:Ljava/util/HashMap;

    .line 60
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_simpleDeserializers:Ljava/util/HashMap;

    const-class v5, Ljava/lang/Object;

    new-instance v6, Lcom/fasterxml/jackson/databind/deser/std/UntypedObjectDeserializer;

    invoke-direct {v6}, Lcom/fasterxml/jackson/databind/deser/std/UntypedObjectDeserializer;-><init>()V

    invoke-static {v4, v5, v6}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_add(Ljava/util/Map;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V

    .line 63
    new-instance v2, Lcom/fasterxml/jackson/databind/deser/std/StringDeserializer;

    invoke-direct {v2}, Lcom/fasterxml/jackson/databind/deser/std/StringDeserializer;-><init>()V

    .line 64
    .local v2, "strDeser":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;"
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_simpleDeserializers:Ljava/util/HashMap;

    const-class v5, Ljava/lang/String;

    invoke-static {v4, v5, v2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_add(Ljava/util/Map;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V

    .line 65
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_simpleDeserializers:Ljava/util/HashMap;

    const-class v5, Ljava/lang/CharSequence;

    invoke-static {v4, v5, v2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_add(Ljava/util/Map;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V

    .line 68
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_simpleDeserializers:Ljava/util/HashMap;

    invoke-static {}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers;->all()[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_add(Ljava/util/Map;[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V

    .line 70
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_simpleDeserializers:Ljava/util/HashMap;

    invoke-static {}, Lcom/fasterxml/jackson/databind/deser/std/DateDeserializers;->all()[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_add(Ljava/util/Map;[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V

    .line 72
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_simpleDeserializers:Ljava/util/HashMap;

    invoke-static {}, Lcom/fasterxml/jackson/databind/deser/std/JdkDeserializers;->all()[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_add(Ljava/util/Map;[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V

    .line 74
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_simpleDeserializers:Ljava/util/HashMap;

    invoke-static {}, Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers;->all()[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_add(Ljava/util/Map;[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V

    .line 97
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    sput-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_mapFallbacks:Ljava/util/HashMap;

    .line 100
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_mapFallbacks:Ljava/util/HashMap;

    const-class v5, Ljava/util/Map;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    const-class v6, Ljava/util/LinkedHashMap;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_mapFallbacks:Ljava/util/HashMap;

    const-class v5, Ljava/util/concurrent/ConcurrentMap;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    const-class v6, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_mapFallbacks:Ljava/util/HashMap;

    const-class v5, Ljava/util/SortedMap;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    const-class v6, Ljava/util/TreeMap;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_mapFallbacks:Ljava/util/HashMap;

    const-string v5, "java.util.NavigableMap"

    const-class v6, Ljava/util/TreeMap;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 111
    :try_start_0
    const-string v4, "java.util.concurrent.ConcurrentNavigableMap"

    invoke-static {v4}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 112
    .local v0, "key":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string v4, "java.util.concurrent.ConcurrentSkipListMap"

    invoke-static {v4}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    .line 114
    .local v3, "value":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    move-object v1, v3

    .line 115
    .local v1, "mapValue":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/util/Map<**>;>;"
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_mapFallbacks:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 126
    .end local v0    # "key":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "mapValue":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/util/Map<**>;>;"
    .end local v3    # "value":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    sput-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_collectionFallbacks:Ljava/util/HashMap;

    .line 129
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_collectionFallbacks:Ljava/util/HashMap;

    const-class v5, Ljava/util/Collection;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    const-class v6, Ljava/util/ArrayList;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 130
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_collectionFallbacks:Ljava/util/HashMap;

    const-class v5, Ljava/util/List;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    const-class v6, Ljava/util/ArrayList;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_collectionFallbacks:Ljava/util/HashMap;

    const-class v5, Ljava/util/Set;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    const-class v6, Ljava/util/HashSet;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_collectionFallbacks:Ljava/util/HashMap;

    const-class v5, Ljava/util/SortedSet;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    const-class v6, Ljava/util/TreeSet;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_collectionFallbacks:Ljava/util/HashMap;

    const-class v5, Ljava/util/Queue;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    const-class v6, Ljava/util/LinkedList;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 140
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_collectionFallbacks:Ljava/util/HashMap;

    const-string v5, "java.util.Deque"

    const-class v6, Ljava/util/LinkedList;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    sget-object v4, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_collectionFallbacks:Ljava/util/HashMap;

    const-string v5, "java.util.NavigableSet"

    const-class v6, Ljava/util/TreeSet;

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    return-void

    .line 117
    :catch_0
    move-exception v4

    goto :goto_0

    .line 116
    :catch_1
    move-exception v4

    goto :goto_0
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;)V
    .locals 1
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    .prologue
    .line 167
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;-><init>()V

    .line 147
    sget-object v0, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->instance:Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->optionalHandlers:Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;

    .line 168
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    .line 169
    return-void
.end method

.method private static _add(Ljava/util/Map;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/fasterxml/jackson/databind/type/ClassKey;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;>;",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 88
    .local p0, "desers":Ljava/util/Map;, "Ljava/util/Map<Lcom/fasterxml/jackson/databind/type/ClassKey;Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;>;"
    .local p1, "valueClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "stdDeser":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;"
    move-object v0, p2

    .line 89
    .local v0, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    new-instance v1, Lcom/fasterxml/jackson/databind/type/ClassKey;

    invoke-direct {v1, p1}, Lcom/fasterxml/jackson/databind/type/ClassKey;-><init>(Ljava/lang/Class;)V

    invoke-interface {p0, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    return-void
.end method

.method private static _add(Ljava/util/Map;[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/fasterxml/jackson/databind/type/ClassKey;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;>;[",
            "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 79
    .local p0, "desers":Ljava/util/Map;, "Ljava/util/Map<Lcom/fasterxml/jackson/databind/type/ClassKey;Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;>;"
    .local p1, "serializers":[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;"
    move-object v0, p1

    .local v0, "arr$":[Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 80
    .local v3, "ser":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;"
    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getValueClass()Ljava/lang/Class;

    move-result-object v4

    invoke-static {p0, v4, v3}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_add(Ljava/util/Map;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;)V

    .line 79
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 82
    .end local v3    # "ser":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;"
    :cond_0
    return-void
.end method

.method private _createEnumKeyDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .locals 13
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1175
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v2

    .line 1176
    .local v2, "config":Lcom/fasterxml/jackson/databind/DeserializationConfig;
    invoke-virtual {v2, p2}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->introspect(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/BeanDescription;

    move-result-object v1

    .line 1177
    .local v1, "beanDesc":Lcom/fasterxml/jackson/databind/BeanDescription;
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/BeanDescription;->getClassInfo()Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    move-result-object v10

    invoke-virtual {p0, p1, v10}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findDeserializerFromAnnotation(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v4

    .line 1178
    .local v4, "des":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v4, :cond_0

    .line 1179
    invoke-static {v2, p2, v4}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializers;->constructDelegatingKeyDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v10

    .line 1212
    :goto_0
    return-object v10

    .line 1181
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v5

    .line 1183
    .local v5, "enumClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p0, v5, v2, v1}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findCustomEnumDeserializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v3

    .line 1184
    .local v3, "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v3, :cond_1

    .line 1185
    invoke-static {v2, p2, v4}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializers;->constructDelegatingKeyDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v10

    goto :goto_0

    .line 1188
    :cond_1
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/BeanDescription;->findJsonValueMethod()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v10

    invoke-virtual {p0, v5, v2, v10}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->constructEnumResolver(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Lcom/fasterxml/jackson/databind/util/EnumResolver;

    move-result-object v6

    .line 1190
    .local v6, "enumRes":Lcom/fasterxml/jackson/databind/util/EnumResolver;, "Lcom/fasterxml/jackson/databind/util/EnumResolver<*>;"
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/BeanDescription;->getFactoryMethods()Ljava/util/List;

    move-result-object v10

    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_6

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 1191
    .local v7, "factory":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v10

    invoke-virtual {v10, v7}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->hasCreatorAnnotation(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 1192
    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getParameterCount()I

    move-result v0

    .line 1193
    .local v0, "argCount":I
    const/4 v10, 0x1

    if-ne v0, v10, :cond_5

    .line 1194
    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getRawReturnType()Ljava/lang/Class;

    move-result-object v9

    .line 1196
    .local v9, "returnType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v9, v5}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v10

    if-eqz v10, :cond_5

    .line 1198
    const/4 v10, 0x0

    invoke-virtual {v7, v10}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getGenericParameterType(I)Ljava/lang/reflect/Type;

    move-result-object v10

    const-class v11, Ljava/lang/String;

    if-eq v10, v11, :cond_3

    .line 1199
    new-instance v10, Ljava/lang/IllegalArgumentException;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Parameter #0 type for factory method ("

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ") not suitable, must be java.lang.String"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 1201
    :cond_3
    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->canOverrideAccessModifiers()Z

    move-result v10

    if-eqz v10, :cond_4

    .line 1202
    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getMember()Ljava/lang/reflect/Method;

    move-result-object v10

    invoke-static {v10}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->checkAndFixAccess(Ljava/lang/reflect/Member;)V

    .line 1204
    :cond_4
    invoke-static {v6, v7}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializers;->constructEnumKeyDeserializer(Lcom/fasterxml/jackson/databind/util/EnumResolver;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v10

    goto :goto_0

    .line 1207
    .end local v9    # "returnType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_5
    new-instance v10, Ljava/lang/IllegalArgumentException;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Unsuitable method ("

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ") decorated with @JsonCreator (for Enum type "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ")"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 1212
    .end local v0    # "argCount":I
    .end local v7    # "factory":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    :cond_6
    invoke-static {v6}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializers;->constructEnumKeyDeserializer(Lcom/fasterxml/jackson/databind/util/EnumResolver;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v10

    goto/16 :goto_0
.end method

.method private _findStdValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    .locals 1
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 337
    invoke-static {p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers;->findValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    move-result-object v0

    return-object v0
.end method

.method private _mapAbstractType2(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 5
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 271
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    .line 272
    .local v1, "currClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->hasAbstractTypeResolvers()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 273
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->abstractTypeResolvers()Ljava/lang/Iterable;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/fasterxml/jackson/databind/AbstractTypeResolver;

    .line 274
    .local v3, "resolver":Lcom/fasterxml/jackson/databind/AbstractTypeResolver;
    invoke-virtual {v3, p1, p2}, Lcom/fasterxml/jackson/databind/AbstractTypeResolver;->findTypeMapping(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 275
    .local v0, "concrete":Lcom/fasterxml/jackson/databind/JavaType;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v4, v1, :cond_0

    .line 280
    .end local v0    # "concrete":Lcom/fasterxml/jackson/databind/JavaType;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "resolver":Lcom/fasterxml/jackson/databind/AbstractTypeResolver;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected _addDeserializerConstructors(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;)V
    .locals 26
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p4, "intr"    # Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .param p5, "creators"    # Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            "Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/AnnotationIntrospector;",
            "Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 415
    .local p3, "vchecker":Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;, "Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker<*>;"
    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/BeanDescription;->findDefaultConstructor()Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;

    move-result-object v19

    .line 416
    .local v19, "defaultCtor":Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    if-eqz v19, :cond_1

    .line 417
    invoke-virtual/range {p5 .. p5}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->hasDefaultCreator()Z

    move-result v2

    if-eqz v2, :cond_0

    move-object/from16 v0, p4

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->hasCreatorAnnotation(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 418
    :cond_0
    move-object/from16 v0, p5

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->setDefaultCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 422
    :cond_1
    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/BeanDescription;->getConstructors()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v20

    .local v20, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_e

    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;

    .line 423
    .local v8, "ctor":Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;->getParameterCount()I

    move-result v18

    .line 424
    .local v18, "argCount":I
    move-object/from16 v0, p4

    invoke-virtual {v0, v8}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->hasCreatorAnnotation(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Z

    move-result v9

    .line 425
    .local v9, "isCreator":Z
    move-object/from16 v0, p3

    invoke-interface {v0, v8}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->isCreatorVisible(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Z

    move-result v10

    .line 427
    .local v10, "isVisible":Z
    const/4 v2, 0x1

    move/from16 v0, v18

    if-ne v0, v2, :cond_3

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move-object/from16 v6, p4

    move-object/from16 v7, p5

    .line 428
    invoke-virtual/range {v2 .. v10}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_handleSingleArgumentConstructor(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;ZZ)Z

    goto :goto_0

    .line 432
    :cond_3
    if-nez v9, :cond_4

    if-eqz v10, :cond_2

    .line 441
    :cond_4
    const/16 v23, 0x0

    .line 442
    .local v23, "nonAnnotatedParam":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    const/16 v22, 0x0

    .line 443
    .local v22, "namedCount":I
    const/16 v21, 0x0

    .line 444
    .local v21, "injectCount":I
    move/from16 v0, v18

    new-array v0, v0, [Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-object/from16 v25, v0

    .line 445
    .local v25, "properties":[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_1
    move/from16 v0, v18

    if-ge v15, v0, :cond_a

    .line 446
    invoke-virtual {v8, v15}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;->getParameter(I)Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    move-result-object v16

    .line 447
    .local v16, "param":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    if-nez v16, :cond_6

    const/16 v24, 0x0

    .line 448
    .local v24, "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :goto_2
    if-nez v24, :cond_7

    const/4 v14, 0x0

    .line 449
    .local v14, "name":Ljava/lang/String;
    :goto_3
    move-object/from16 v0, p4

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findInjectableValueId(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Object;

    move-result-object v17

    .line 450
    .local v17, "injectId":Ljava/lang/Object;
    if-eqz v14, :cond_8

    invoke-virtual {v14}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_8

    .line 451
    add-int/lit8 v22, v22, 0x1

    move-object/from16 v11, p0

    move-object/from16 v12, p1

    move-object/from16 v13, p2

    .line 452
    invoke-virtual/range {v11 .. v17}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->constructCreatorProperty(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Ljava/lang/String;ILcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-result-object v2

    aput-object v2, v25, v15

    .line 445
    :cond_5
    :goto_4
    add-int/lit8 v15, v15, 0x1

    goto :goto_1

    .line 447
    .end local v14    # "name":Ljava/lang/String;
    .end local v17    # "injectId":Ljava/lang/Object;
    .end local v24    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_6
    move-object/from16 v0, p4

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findNameForDeserialization(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/PropertyName;

    move-result-object v24

    goto :goto_2

    .line 448
    .restart local v24    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_7
    invoke-virtual/range {v24 .. v24}, Lcom/fasterxml/jackson/databind/PropertyName;->getSimpleName()Ljava/lang/String;

    move-result-object v14

    goto :goto_3

    .line 453
    .restart local v14    # "name":Ljava/lang/String;
    .restart local v17    # "injectId":Ljava/lang/Object;
    :cond_8
    if-eqz v17, :cond_9

    .line 454
    add-int/lit8 v21, v21, 0x1

    move-object/from16 v11, p0

    move-object/from16 v12, p1

    move-object/from16 v13, p2

    .line 455
    invoke-virtual/range {v11 .. v17}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->constructCreatorProperty(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Ljava/lang/String;ILcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-result-object v2

    aput-object v2, v25, v15

    goto :goto_4

    .line 456
    :cond_9
    if-nez v23, :cond_5

    .line 457
    move-object/from16 v23, v16

    goto :goto_4

    .line 462
    .end local v14    # "name":Ljava/lang/String;
    .end local v16    # "param":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    .end local v17    # "injectId":Ljava/lang/Object;
    .end local v24    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_a
    if-nez v9, :cond_b

    if-gtz v22, :cond_b

    if-lez v21, :cond_2

    .line 464
    :cond_b
    add-int v2, v22, v21

    move/from16 v0, v18

    if-ne v2, v0, :cond_c

    .line 465
    move-object/from16 v0, p5

    move-object/from16 v1, v25

    invoke-virtual {v0, v8, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addPropertyCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V

    goto/16 :goto_0

    .line 466
    :cond_c
    if-nez v22, :cond_d

    add-int/lit8 v2, v21, 0x1

    move/from16 v0, v18

    if-ne v2, v0, :cond_d

    .line 468
    move-object/from16 v0, p5

    move-object/from16 v1, v25

    invoke-virtual {v0, v8, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addDelegatingCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V

    goto/16 :goto_0

    .line 470
    :cond_d
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Argument #"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {v23 .. v23}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;->getIndex()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " of constructor "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 474
    .end local v8    # "ctor":Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    .end local v9    # "isCreator":Z
    .end local v10    # "isVisible":Z
    .end local v15    # "i":I
    .end local v18    # "argCount":I
    .end local v21    # "injectCount":I
    .end local v22    # "namedCount":I
    .end local v23    # "nonAnnotatedParam":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    .end local v25    # "properties":[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    :cond_e
    return-void
.end method

.method protected _addDeserializerFactoryMethods(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;)V
    .locals 24
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p4, "intr"    # Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .param p5, "creators"    # Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            "Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/AnnotationIntrospector;",
            "Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 536
    .local p3, "vchecker":Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;, "Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker<*>;"
    invoke-virtual/range {p1 .. p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v3

    .line 537
    .local v3, "config":Lcom/fasterxml/jackson/databind/DeserializationConfig;
    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/BeanDescription;->getFactoryMethods()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v18

    .local v18, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_10

    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 538
    .local v8, "factory":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    move-object/from16 v0, p4

    invoke-virtual {v0, v8}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->hasCreatorAnnotation(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Z

    move-result v9

    .line 539
    .local v9, "isCreator":Z
    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getParameterCount()I

    move-result v17

    .line 541
    .local v17, "argCount":I
    if-nez v17, :cond_1

    .line 542
    if-eqz v9, :cond_0

    .line 543
    move-object/from16 v0, p5

    invoke-virtual {v0, v8}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->setDefaultCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    goto :goto_0

    .line 548
    :cond_1
    const/4 v2, 0x1

    move/from16 v0, v17

    if-ne v0, v2, :cond_5

    .line 549
    const/4 v2, 0x0

    invoke-virtual {v8, v2}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getParameter(I)Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    move-result-object v15

    .line 550
    .local v15, "param":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    if-nez v15, :cond_3

    const/16 v22, 0x0

    .line 551
    .local v22, "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :goto_1
    if-nez v22, :cond_4

    const/4 v13, 0x0

    .line 552
    .local v13, "name":Ljava/lang/String;
    :goto_2
    move-object/from16 v0, p4

    invoke-virtual {v0, v15}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findInjectableValueId(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Object;

    move-result-object v16

    .line 554
    .local v16, "injectId":Ljava/lang/Object;
    if-nez v16, :cond_6

    if-eqz v13, :cond_2

    invoke-virtual {v13}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_6

    :cond_2
    move-object/from16 v2, p0

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move-object/from16 v6, p4

    move-object/from16 v7, p5

    .line 555
    invoke-virtual/range {v2 .. v9}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_handleSingleArgumentFactory(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;Z)Z

    goto :goto_0

    .line 550
    .end local v13    # "name":Ljava/lang/String;
    .end local v16    # "injectId":Ljava/lang/Object;
    .end local v22    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_3
    move-object/from16 v0, p4

    invoke-virtual {v0, v15}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findNameForDeserialization(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/PropertyName;

    move-result-object v22

    goto :goto_1

    .line 551
    .restart local v22    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_4
    invoke-virtual/range {v22 .. v22}, Lcom/fasterxml/jackson/databind/PropertyName;->getSimpleName()Ljava/lang/String;

    move-result-object v13

    goto :goto_2

    .line 563
    .end local v15    # "param":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    .end local v22    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_5
    move-object/from16 v0, p4

    invoke-virtual {v0, v8}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->hasCreatorAnnotation(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 568
    :cond_6
    const/16 v21, 0x0

    .line 569
    .local v21, "nonAnnotatedParam":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    move/from16 v0, v17

    new-array v0, v0, [Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-object/from16 v23, v0

    .line 570
    .local v23, "properties":[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    const/16 v20, 0x0

    .line 571
    .local v20, "namedCount":I
    const/16 v19, 0x0

    .line 572
    .local v19, "injectCount":I
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_3
    move/from16 v0, v17

    if-ge v14, v0, :cond_c

    .line 573
    invoke-virtual {v8, v14}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getParameter(I)Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    move-result-object v15

    .line 574
    .restart local v15    # "param":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    if-nez v15, :cond_8

    const/16 v22, 0x0

    .line 575
    .restart local v22    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :goto_4
    if-nez v22, :cond_9

    const/4 v13, 0x0

    .line 576
    .restart local v13    # "name":Ljava/lang/String;
    :goto_5
    move-object/from16 v0, p4

    invoke-virtual {v0, v15}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findInjectableValueId(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Object;

    move-result-object v16

    .line 577
    .restart local v16    # "injectId":Ljava/lang/Object;
    if-eqz v13, :cond_a

    invoke-virtual {v13}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_a

    .line 578
    add-int/lit8 v20, v20, 0x1

    move-object/from16 v10, p0

    move-object/from16 v11, p1

    move-object/from16 v12, p2

    .line 579
    invoke-virtual/range {v10 .. v16}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->constructCreatorProperty(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Ljava/lang/String;ILcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-result-object v2

    aput-object v2, v23, v14

    .line 572
    :cond_7
    :goto_6
    add-int/lit8 v14, v14, 0x1

    goto :goto_3

    .line 574
    .end local v13    # "name":Ljava/lang/String;
    .end local v16    # "injectId":Ljava/lang/Object;
    .end local v22    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_8
    move-object/from16 v0, p4

    invoke-virtual {v0, v15}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findNameForDeserialization(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/PropertyName;

    move-result-object v22

    goto :goto_4

    .line 575
    .restart local v22    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_9
    invoke-virtual/range {v22 .. v22}, Lcom/fasterxml/jackson/databind/PropertyName;->getSimpleName()Ljava/lang/String;

    move-result-object v13

    goto :goto_5

    .line 580
    .restart local v13    # "name":Ljava/lang/String;
    .restart local v16    # "injectId":Ljava/lang/Object;
    :cond_a
    if-eqz v16, :cond_b

    .line 581
    add-int/lit8 v19, v19, 0x1

    move-object/from16 v10, p0

    move-object/from16 v11, p1

    move-object/from16 v12, p2

    .line 582
    invoke-virtual/range {v10 .. v16}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->constructCreatorProperty(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Ljava/lang/String;ILcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-result-object v2

    aput-object v2, v23, v14

    goto :goto_6

    .line 583
    :cond_b
    if-nez v21, :cond_7

    .line 584
    move-object/from16 v21, v15

    goto :goto_6

    .line 589
    .end local v13    # "name":Ljava/lang/String;
    .end local v15    # "param":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    .end local v16    # "injectId":Ljava/lang/Object;
    .end local v22    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_c
    if-nez v9, :cond_d

    if-gtz v20, :cond_d

    if-lez v19, :cond_0

    .line 591
    :cond_d
    add-int v2, v20, v19

    move/from16 v0, v17

    if-ne v2, v0, :cond_e

    .line 592
    move-object/from16 v0, p5

    move-object/from16 v1, v23

    invoke-virtual {v0, v8, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addPropertyCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V

    goto/16 :goto_0

    .line 593
    :cond_e
    if-nez v20, :cond_f

    add-int/lit8 v2, v19, 0x1

    move/from16 v0, v17

    if-ne v2, v0, :cond_f

    .line 595
    move-object/from16 v0, p5

    move-object/from16 v1, v23

    invoke-virtual {v0, v8, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addDelegatingCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V

    goto/16 :goto_0

    .line 597
    :cond_f
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Argument #"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v21 .. v21}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;->getIndex()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " of factory method "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 602
    .end local v8    # "factory":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .end local v9    # "isCreator":Z
    .end local v14    # "i":I
    .end local v17    # "argCount":I
    .end local v19    # "injectCount":I
    .end local v20    # "namedCount":I
    .end local v21    # "nonAnnotatedParam":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    .end local v23    # "properties":[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    :cond_10
    return-void
.end method

.method protected _constructDefaultValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    .locals 8
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 348
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->canOverrideAccessModifiers()Z

    move-result v7

    .line 349
    .local v7, "fixAccess":Z
    new-instance v5, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;

    invoke-direct {v5, p2, v7}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;-><init>(Lcom/fasterxml/jackson/databind/BeanDescription;Z)V

    .line 350
    .local v5, "creators":Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v4

    .line 353
    .local v4, "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v6

    .line 354
    .local v6, "config":Lcom/fasterxml/jackson/databind/DeserializationConfig;
    invoke-virtual {v6}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getDefaultVisibilityChecker()Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;

    move-result-object v3

    .line 355
    .local v3, "vchecker":Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;, "Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker<*>;"
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/BeanDescription;->getClassInfo()Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    move-result-object v0

    invoke-virtual {v4, v0, v3}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findAutoDetectVisibility(Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;)Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;

    move-result-object v3

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    .line 360
    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_addDeserializerFactoryMethods(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;)V

    .line 362
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/BeanDescription;->getType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->isConcrete()Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    .line 363
    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_addDeserializerConstructors(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;)V

    .line 365
    :cond_0
    invoke-virtual {v5, v6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->constructValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationConfig;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    move-result-object v0

    return-object v0
.end method

.method protected _findCustomArrayDeserializer(Lcom/fasterxml/jackson/databind/type/ArrayType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 8
    .param p1, "type"    # Lcom/fasterxml/jackson/databind/type/ArrayType;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p4, "elementTypeDeserializer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/type/ArrayType;",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 741
    .local p5, "elementDeserializer":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->deserializers()Ljava/lang/Iterable;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/deser/Deserializers;

    .local v0, "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    .line 742
    invoke-interface/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/Deserializers;->findArrayDeserializer(Lcom/fasterxml/jackson/databind/type/ArrayType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v6

    .line 744
    .local v6, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v6, :cond_0

    .line 748
    .end local v0    # "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    .end local v6    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v6

    :cond_1
    const/4 v6, 0x0

    goto :goto_0
.end method

.method protected _findCustomCollectionDeserializer(Lcom/fasterxml/jackson/databind/type/CollectionType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 8
    .param p1, "type"    # Lcom/fasterxml/jackson/databind/type/CollectionType;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p4, "elementTypeDeserializer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/type/CollectionType;",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 842
    .local p5, "elementDeserializer":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->deserializers()Ljava/lang/Iterable;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/deser/Deserializers;

    .local v0, "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    .line 843
    invoke-interface/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/Deserializers;->findCollectionDeserializer(Lcom/fasterxml/jackson/databind/type/CollectionType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v6

    .line 845
    .local v6, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v6, :cond_0

    .line 849
    .end local v0    # "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    .end local v6    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v6

    :cond_1
    const/4 v6, 0x0

    goto :goto_0
.end method

.method protected _findCustomCollectionLikeDeserializer(Lcom/fasterxml/jackson/databind/type/CollectionLikeType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 8
    .param p1, "type"    # Lcom/fasterxml/jackson/databind/type/CollectionLikeType;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p4, "elementTypeDeserializer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/type/CollectionLikeType;",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 857
    .local p5, "elementDeserializer":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->deserializers()Ljava/lang/Iterable;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/deser/Deserializers;

    .local v0, "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    .line 858
    invoke-interface/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/Deserializers;->findCollectionLikeDeserializer(Lcom/fasterxml/jackson/databind/type/CollectionLikeType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v6

    .line 860
    .local v6, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v6, :cond_0

    .line 864
    .end local v0    # "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    .end local v6    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v6

    :cond_1
    const/4 v6, 0x0

    goto :goto_0
.end method

.method protected _findCustomEnumDeserializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 4
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1047
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->deserializers()Ljava/lang/Iterable;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/deser/Deserializers;

    .line 1048
    .local v0, "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    invoke-interface {v0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/Deserializers;->findEnumDeserializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v1

    .line 1049
    .local v1, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v1, :cond_0

    .line 1053
    .end local v0    # "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    .end local v1    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected _findCustomMapDeserializer(Lcom/fasterxml/jackson/databind/type/MapType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 9
    .param p1, "type"    # Lcom/fasterxml/jackson/databind/type/MapType;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p4, "keyDeserializer"    # Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .param p5, "elementTypeDeserializer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/type/MapType;",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            "Lcom/fasterxml/jackson/databind/KeyDeserializer;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 976
    .local p6, "elementDeserializer":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->deserializers()Ljava/lang/Iterable;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/deser/Deserializers;

    .local v0, "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    .line 977
    invoke-interface/range {v0 .. v6}, Lcom/fasterxml/jackson/databind/deser/Deserializers;->findMapDeserializer(Lcom/fasterxml/jackson/databind/type/MapType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v7

    .line 979
    .local v7, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v7, :cond_0

    .line 983
    .end local v0    # "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    .end local v7    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v7

    :cond_1
    const/4 v7, 0x0

    goto :goto_0
.end method

.method protected _findCustomMapLikeDeserializer(Lcom/fasterxml/jackson/databind/type/MapLikeType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 9
    .param p1, "type"    # Lcom/fasterxml/jackson/databind/type/MapLikeType;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p4, "keyDeserializer"    # Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .param p5, "elementTypeDeserializer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/type/MapLikeType;",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            "Lcom/fasterxml/jackson/databind/KeyDeserializer;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 992
    .local p6, "elementDeserializer":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->deserializers()Ljava/lang/Iterable;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/deser/Deserializers;

    .local v0, "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    .line 993
    invoke-interface/range {v0 .. v6}, Lcom/fasterxml/jackson/databind/deser/Deserializers;->findMapLikeDeserializer(Lcom/fasterxml/jackson/databind/type/MapLikeType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v7

    .line 995
    .local v7, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v7, :cond_0

    .line 999
    .end local v0    # "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    .end local v7    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v7

    :cond_1
    const/4 v7, 0x0

    goto :goto_0
.end method

.method protected _findCustomTreeNodeDeserializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 4
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1082
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/fasterxml/jackson/databind/JsonNode;>;"
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->deserializers()Ljava/lang/Iterable;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/deser/Deserializers;

    .line 1083
    .local v0, "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    invoke-interface {v0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/Deserializers;->findTreeNodeDeserializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v1

    .line 1084
    .local v1, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v1, :cond_0

    .line 1088
    .end local v0    # "d":Lcom/fasterxml/jackson/databind/deser/Deserializers;
    .end local v1    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected _findJsonValueFor(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .locals 2
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "enumType"    # Lcom/fasterxml/jackson/databind/JavaType;

    .prologue
    .line 1458
    if-nez p2, :cond_0

    .line 1459
    const/4 v1, 0x0

    .line 1462
    :goto_0
    return-object v1

    .line 1461
    :cond_0
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->introspect(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/BeanDescription;

    move-result-object v0

    .line 1462
    .local v0, "beanDesc":Lcom/fasterxml/jackson/databind/BeanDescription;
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/BeanDescription;->findJsonValueMethod()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v1

    goto :goto_0
.end method

.method protected _handleSingleArgumentConstructor(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;ZZ)Z
    .locals 13
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p4, "intr"    # Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .param p5, "creators"    # Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;
    .param p6, "ctor"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    .param p7, "isCreator"    # Z
    .param p8, "isVisible"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            "Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/AnnotationIntrospector;",
            "Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;",
            "ZZ)Z"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 483
    .local p3, "vchecker":Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;, "Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker<*>;"
    const/4 v2, 0x0

    move-object/from16 v0, p6

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;->getParameter(I)Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    move-result-object v7

    .line 484
    .local v7, "param":Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    if-nez v7, :cond_1

    const/4 v9, 0x0

    .line 485
    .local v9, "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :goto_0
    if-nez v9, :cond_2

    const/4 v5, 0x0

    .line 486
    .local v5, "name":Ljava/lang/String;
    :goto_1
    move-object/from16 v0, p4

    invoke-virtual {v0, v7}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findInjectableValueId(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Object;

    move-result-object v8

    .line 488
    .local v8, "injectId":Ljava/lang/Object;
    if-nez v8, :cond_0

    if-eqz v5, :cond_3

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_3

    .line 490
    :cond_0
    const/4 v2, 0x1

    new-array v10, v2, [Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    .line 491
    .local v10, "properties":[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    const/4 v12, 0x0

    const/4 v6, 0x0

    move-object v2, p0

    move-object v3, p1

    move-object v4, p2

    invoke-virtual/range {v2 .. v8}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->constructCreatorProperty(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Ljava/lang/String;ILcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-result-object v2

    aput-object v2, v10, v12

    .line 492
    move-object/from16 v0, p5

    move-object/from16 v1, p6

    invoke-virtual {v0, v1, v10}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addPropertyCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V

    .line 493
    const/4 v2, 0x1

    .line 528
    .end local v10    # "properties":[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    :goto_2
    return v2

    .line 484
    .end local v5    # "name":Ljava/lang/String;
    .end local v8    # "injectId":Ljava/lang/Object;
    .end local v9    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_1
    move-object/from16 v0, p4

    invoke-virtual {v0, v7}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findNameForDeserialization(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/PropertyName;

    move-result-object v9

    goto :goto_0

    .line 485
    .restart local v9    # "pn":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_2
    invoke-virtual {v9}, Lcom/fasterxml/jackson/databind/PropertyName;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 497
    .restart local v5    # "name":Ljava/lang/String;
    .restart local v8    # "injectId":Ljava/lang/Object;
    :cond_3
    const/4 v2, 0x0

    move-object/from16 v0, p6

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;->getRawParameterType(I)Ljava/lang/Class;

    move-result-object v11

    .line 498
    .local v11, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v2, Ljava/lang/String;

    if-ne v11, v2, :cond_6

    .line 499
    if-nez p7, :cond_4

    if-eqz p8, :cond_5

    .line 500
    :cond_4
    invoke-virtual/range {p5 .. p6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addStringCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 502
    :cond_5
    const/4 v2, 0x1

    goto :goto_2

    .line 504
    :cond_6
    sget-object v2, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    if-eq v11, v2, :cond_7

    const-class v2, Ljava/lang/Integer;

    if-ne v11, v2, :cond_a

    .line 505
    :cond_7
    if-nez p7, :cond_8

    if-eqz p8, :cond_9

    .line 506
    :cond_8
    invoke-virtual/range {p5 .. p6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addIntCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 508
    :cond_9
    const/4 v2, 0x1

    goto :goto_2

    .line 510
    :cond_a
    sget-object v2, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    if-eq v11, v2, :cond_b

    const-class v2, Ljava/lang/Long;

    if-ne v11, v2, :cond_e

    .line 511
    :cond_b
    if-nez p7, :cond_c

    if-eqz p8, :cond_d

    .line 512
    :cond_c
    invoke-virtual/range {p5 .. p6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addLongCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 514
    :cond_d
    const/4 v2, 0x1

    goto :goto_2

    .line 516
    :cond_e
    sget-object v2, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    if-eq v11, v2, :cond_f

    const-class v2, Ljava/lang/Double;

    if-ne v11, v2, :cond_12

    .line 517
    :cond_f
    if-nez p7, :cond_10

    if-eqz p8, :cond_11

    .line 518
    :cond_10
    invoke-virtual/range {p5 .. p6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addDoubleCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 520
    :cond_11
    const/4 v2, 0x1

    goto :goto_2

    .line 524
    :cond_12
    if-eqz p7, :cond_13

    .line 525
    const/4 v2, 0x0

    move-object/from16 v0, p5

    move-object/from16 v1, p6

    invoke-virtual {v0, v1, v2}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addDelegatingCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V

    .line 526
    const/4 v2, 0x1

    goto :goto_2

    .line 528
    :cond_13
    const/4 v2, 0x0

    goto :goto_2
.end method

.method protected _handleSingleArgumentFactory(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;Z)Z
    .locals 4
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p4, "intr"    # Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .param p5, "creators"    # Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;
    .param p6, "factory"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .param p7, "isCreator"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            "Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/AnnotationIntrospector;",
            "Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;",
            "Z)Z"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .local p3, "vchecker":Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;, "Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker<*>;"
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 610
    invoke-virtual {p6, v2}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getRawParameterType(I)Ljava/lang/Class;

    move-result-object v0

    .line 612
    .local v0, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v3, Ljava/lang/String;

    if-ne v0, v3, :cond_2

    .line 613
    if-nez p7, :cond_0

    invoke-interface {p3, p6}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->isCreatorVisible(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 614
    :cond_0
    invoke-virtual {p5, p6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addStringCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 646
    :cond_1
    :goto_0
    return v1

    .line 618
    :cond_2
    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    if-eq v0, v3, :cond_3

    const-class v3, Ljava/lang/Integer;

    if-ne v0, v3, :cond_5

    .line 619
    :cond_3
    if-nez p7, :cond_4

    invoke-interface {p3, p6}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->isCreatorVisible(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 620
    :cond_4
    invoke-virtual {p5, p6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addIntCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    goto :goto_0

    .line 624
    :cond_5
    sget-object v3, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    if-eq v0, v3, :cond_6

    const-class v3, Ljava/lang/Long;

    if-ne v0, v3, :cond_8

    .line 625
    :cond_6
    if-nez p7, :cond_7

    invoke-interface {p3, p6}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->isCreatorVisible(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 626
    :cond_7
    invoke-virtual {p5, p6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addLongCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    goto :goto_0

    .line 630
    :cond_8
    sget-object v3, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    if-eq v0, v3, :cond_9

    const-class v3, Ljava/lang/Double;

    if-ne v0, v3, :cond_b

    .line 631
    :cond_9
    if-nez p7, :cond_a

    invoke-interface {p3, p6}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->isCreatorVisible(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 632
    :cond_a
    invoke-virtual {p5, p6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addDoubleCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    goto :goto_0

    .line 636
    :cond_b
    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    if-eq v0, v3, :cond_c

    const-class v3, Ljava/lang/Boolean;

    if-ne v0, v3, :cond_e

    .line 637
    :cond_c
    if-nez p7, :cond_d

    invoke-interface {p3, p6}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->isCreatorVisible(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 638
    :cond_d
    invoke-virtual {p5, p6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addBooleanCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    goto :goto_0

    .line 642
    :cond_e
    invoke-virtual {p4, p6}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->hasCreatorAnnotation(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Z

    move-result v3

    if-eqz v3, :cond_f

    .line 643
    const/4 v2, 0x0

    invoke-virtual {p5, p6, v2}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->addDelegatingCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V

    goto :goto_0

    :cond_f
    move v1, v2

    .line 646
    goto :goto_0
.end method

.method public _valueInstantiatorInstance(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    .locals 6
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "annotated"    # Lcom/fasterxml/jackson/databind/introspect/Annotated;
    .param p3, "instDef"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 372
    if-nez p3, :cond_1

    .line 403
    :cond_0
    :goto_0
    return-object v1

    .line 378
    :cond_1
    instance-of v3, p3, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    if-eqz v3, :cond_2

    move-object v1, p3

    .line 379
    check-cast v1, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    .local v1, "inst":Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    goto :goto_0

    .line 381
    .end local v1    # "inst":Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    :cond_2
    instance-of v3, p3, Ljava/lang/Class;

    if-nez v3, :cond_3

    .line 382
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AnnotationIntrospector returned key deserializer definition of type "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; expected type KeyDeserializer or Class<KeyDeserializer> instead"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_3
    move-object v2, p3

    .line 386
    check-cast v2, Ljava/lang/Class;

    .line 387
    .local v2, "instClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v3, Lcom/fasterxml/jackson/databind/annotation/NoClass;

    if-eq v2, v3, :cond_0

    .line 390
    const-class v3, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    invoke-virtual {v3, v2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 391
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AnnotationIntrospector returned Class "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; expected Class<ValueInstantiator>"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 394
    :cond_4
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getHandlerInstantiator()Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;

    move-result-object v0

    .line 395
    .local v0, "hi":Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;
    if-eqz v0, :cond_5

    .line 396
    invoke-virtual {v0, p1, p2, v2}, Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;->valueInstantiatorInstance(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    move-result-object v1

    .restart local v1    # "inst":Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    goto :goto_0

    .line 398
    .end local v1    # "inst":Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    :cond_5
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->canOverrideAccessModifiers()Z

    move-result v3

    invoke-static {v2, v3}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->createInstance(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    .restart local v1    # "inst":Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    goto :goto_0
.end method

.method protected constructCreatorProperty(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Ljava/lang/String;ILcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    .locals 14
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "index"    # I
    .param p5, "param"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    .param p6, "injectableValueId"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 660
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v10

    .line 661
    .local v10, "config":Lcom/fasterxml/jackson/databind/DeserializationConfig;
    invoke-virtual {v10}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getTypeFactory()Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-result-object v3

    invoke-virtual/range {p5 .. p5}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;->getParameterType()Ljava/lang/reflect/Type;

    move-result-object v6

    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/BeanDescription;->bindingsForBeanType()Lcom/fasterxml/jackson/databind/type/TypeBindings;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v13

    .line 662
    .local v13, "t0":Lcom/fasterxml/jackson/databind/JavaType;
    new-instance v12, Lcom/fasterxml/jackson/databind/BeanProperty$Std;

    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/BeanDescription;->getClassAnnotations()Lcom/fasterxml/jackson/databind/util/Annotations;

    move-result-object v3

    move-object/from16 v0, p3

    move-object/from16 v1, p5

    invoke-direct {v12, v0, v13, v3, v1}, Lcom/fasterxml/jackson/databind/BeanProperty$Std;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/util/Annotations;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)V

    .line 663
    .local v12, "property":Lcom/fasterxml/jackson/databind/BeanProperty$Std;
    move-object/from16 v0, p2

    move-object/from16 v1, p5

    invoke-virtual {p0, p1, v0, v13, v1}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->resolveType(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v4

    .line 664
    .local v4, "type":Lcom/fasterxml/jackson/databind/JavaType;
    if-eq v4, v13, :cond_0

    .line 665
    invoke-virtual {v12, v4}, Lcom/fasterxml/jackson/databind/BeanProperty$Std;->withType(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/BeanProperty$Std;

    move-result-object v12

    .line 668
    :cond_0
    move-object/from16 v0, p5

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findDeserializerFromAnnotation(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v11

    .line 670
    .local v11, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    move-object/from16 v0, p5

    invoke-virtual {p0, p1, v0, v4}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->modifyTypeByAnnotation(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v4

    .line 673
    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/JavaType;->getTypeHandler()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 675
    .local v5, "typeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    if-nez v5, :cond_1

    .line 676
    invoke-virtual {p0, v10, v4}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v5

    .line 678
    :cond_1
    new-instance v2, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/BeanDescription;->getClassAnnotations()Lcom/fasterxml/jackson/databind/util/Annotations;

    move-result-object v6

    move-object/from16 v3, p3

    move-object/from16 v7, p5

    move/from16 v8, p4

    move-object/from16 v9, p6

    invoke-direct/range {v2 .. v9}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/util/Annotations;Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;ILjava/lang/Object;)V

    .line 680
    .local v2, "prop":Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    if-eqz v11, :cond_2

    .line 681
    invoke-virtual {v2, v11}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->withValueDeserializer(Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-result-object v2

    .line 683
    :cond_2
    return-object v2
.end method

.method protected constructEnumResolver(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Lcom/fasterxml/jackson/databind/util/EnumResolver;
    .locals 2
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p3, "jsonValueMethod"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;",
            ")",
            "Lcom/fasterxml/jackson/databind/util/EnumResolver",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 1442
    .local p1, "enumClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz p3, :cond_1

    .line 1443
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getAnnotated()Ljava/lang/reflect/Method;

    move-result-object v0

    .line 1444
    .local v0, "accessor":Ljava/lang/reflect/Method;
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->canOverrideAccessModifiers()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1445
    invoke-static {v0}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->checkAndFixAccess(Ljava/lang/reflect/Member;)V

    .line 1447
    :cond_0
    invoke-static {p1, v0}, Lcom/fasterxml/jackson/databind/util/EnumResolver;->constructUnsafeUsingMethod(Ljava/lang/Class;Ljava/lang/reflect/Method;)Lcom/fasterxml/jackson/databind/util/EnumResolver;

    move-result-object v1

    .line 1453
    .end local v0    # "accessor":Ljava/lang/reflect/Method;
    :goto_0
    return-object v1

    .line 1450
    :cond_1
    sget-object v1, Lcom/fasterxml/jackson/databind/DeserializationFeature;->READ_ENUMS_USING_TO_STRING:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1451
    invoke-static {p1}, Lcom/fasterxml/jackson/databind/util/EnumResolver;->constructUnsafeUsingToString(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/util/EnumResolver;

    move-result-object v1

    goto :goto_0

    .line 1453
    :cond_2
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v1

    invoke-static {p1, v1}, Lcom/fasterxml/jackson/databind/util/EnumResolver;->constructUnsafe(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;)Lcom/fasterxml/jackson/databind/util/EnumResolver;

    move-result-object v1

    goto :goto_0
.end method

.method public createArrayDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/type/ArrayType;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 9
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/type/ArrayType;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/type/ArrayType;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 697
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/type/ArrayType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v8

    .line 700
    .local v8, "elemType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 701
    .local v5, "contentDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    if-nez v5, :cond_2

    .line 703
    sget-object v0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_arrayDeserializers:Ljava/util/HashMap;

    invoke-virtual {v0, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 704
    .local v7, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v7, :cond_1

    .line 709
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v2

    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findCustomArrayDeserializer(Lcom/fasterxml/jackson/databind/type/ArrayType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v6

    .line 711
    .local v6, "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v6, :cond_0

    move-object v7, v6

    .line 733
    .end local v7    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_0
    :goto_0
    return-object v7

    .line 717
    .end local v6    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    .restart local v7    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_1
    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/JavaType;->isPrimitive()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 718
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Internal error: primitive type ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") passed, no array deserializer found"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 722
    .end local v7    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_2
    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/JavaType;->getTypeHandler()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 724
    .local v4, "elemTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    if-nez v4, :cond_3

    .line 725
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v0

    invoke-virtual {p0, v0, v8}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v4

    .line 728
    :cond_3
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v2

    move-object v0, p0

    move-object v1, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findCustomArrayDeserializer(Lcom/fasterxml/jackson/databind/type/ArrayType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v6

    .line 730
    .restart local v6    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v6, :cond_4

    move-object v7, v6

    .line 731
    goto :goto_0

    .line 733
    :cond_4
    new-instance v7, Lcom/fasterxml/jackson/databind/deser/std/ObjectArrayDeserializer;

    invoke-direct {v7, p2, v5, v4}, Lcom/fasterxml/jackson/databind/deser/std/ObjectArrayDeserializer;-><init>(Lcom/fasterxml/jackson/databind/type/ArrayType;Lcom/fasterxml/jackson/databind/JsonDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;)V

    goto :goto_0
.end method

.method public createCollectionDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/type/CollectionType;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 11
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/type/CollectionType;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/type/CollectionType;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 762
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/type/CollectionType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v7

    .line 764
    .local v7, "contentType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 767
    .local v5, "contentDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/JavaType;->getTypeHandler()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 769
    .local v4, "contentTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    if-nez v4, :cond_0

    .line 770
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v0

    invoke-virtual {p0, v0, v7}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v4

    .line 774
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v2

    move-object v0, p0

    move-object v1, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findCustomCollectionDeserializer(Lcom/fasterxml/jackson/databind/type/CollectionType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v8

    .line 776
    .local v8, "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v8, :cond_1

    .line 814
    .end local v8    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v8

    .line 780
    .restart local v8    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_1
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/type/CollectionType;->getRawClass()Ljava/lang/Class;

    move-result-object v6

    .line 781
    .local v6, "collectionClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez v5, :cond_2

    .line 783
    const-class v0, Ljava/util/EnumSet;

    invoke-virtual {v0, v6}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 784
    new-instance v8, Lcom/fasterxml/jackson/databind/deser/std/EnumSetDeserializer;

    .end local v8    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    const/4 v0, 0x0

    invoke-direct {v8, v7, v0}, Lcom/fasterxml/jackson/databind/deser/std/EnumSetDeserializer;-><init>(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonDeserializer;)V

    goto :goto_0

    .line 797
    .restart local v8    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_2
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/type/CollectionType;->isInterface()Z

    move-result v0

    if-nez v0, :cond_3

    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/type/CollectionType;->isAbstract()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 799
    :cond_3
    sget-object v0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_collectionFallbacks:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Class;

    .line 800
    .local v9, "fallback":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/util/Collection;>;"
    if-nez v9, :cond_4

    .line 801
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Can not find a deserializer for non-concrete Collection type "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 803
    :cond_4
    move-object v6, v9

    .line 804
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v0

    invoke-virtual {v0, p2, v6}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->constructSpecializedType(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object p2

    .end local p2    # "type":Lcom/fasterxml/jackson/databind/type/CollectionType;
    check-cast p2, Lcom/fasterxml/jackson/databind/type/CollectionType;

    .line 806
    .restart local p2    # "type":Lcom/fasterxml/jackson/databind/type/CollectionType;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->introspectForCreation(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/BeanDescription;

    move-result-object p3

    .line 808
    .end local v9    # "fallback":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/util/Collection;>;"
    :cond_5
    invoke-virtual {p0, p1, p3}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    move-result-object v10

    .line 810
    .local v10, "inst":Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Ljava/lang/String;

    if-ne v0, v1, :cond_6

    .line 812
    new-instance v8, Lcom/fasterxml/jackson/databind/deser/std/StringCollectionDeserializer;

    .end local v8    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    invoke-direct {v8, p2, v5, v10}, Lcom/fasterxml/jackson/databind/deser/std/StringCollectionDeserializer;-><init>(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonDeserializer;Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;)V

    goto :goto_0

    .line 814
    .restart local v8    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_6
    new-instance v8, Lcom/fasterxml/jackson/databind/deser/std/CollectionDeserializer;

    .end local v8    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    invoke-direct {v8, p2, v5, v4, v10}, Lcom/fasterxml/jackson/databind/deser/std/CollectionDeserializer;-><init>(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;)V

    goto :goto_0
.end method

.method public createCollectionLikeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/type/CollectionLikeType;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 7
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/type/CollectionLikeType;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/type/CollectionLikeType;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 823
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/type/CollectionLikeType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v6

    .line 825
    .local v6, "contentType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {v6}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 828
    .local v5, "contentDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    invoke-virtual {v6}, Lcom/fasterxml/jackson/databind/JavaType;->getTypeHandler()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 830
    .local v4, "contentTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    if-nez v4, :cond_0

    .line 831
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v0

    invoke-virtual {p0, v0, v6}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v4

    .line 833
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v2

    move-object v0, p0

    move-object v1, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findCustomCollectionLikeDeserializer(Lcom/fasterxml/jackson/databind/type/CollectionLikeType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v0

    return-object v0
.end method

.method public createEnumDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 9
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1016
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v2

    .line 1018
    .local v2, "enumClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v6

    invoke-virtual {p0, v2, v6, p3}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findCustomEnumDeserializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v1

    .line 1020
    .local v1, "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v1, :cond_0

    .line 1040
    .end local v1    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v1

    .line 1025
    .restart local v1    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_0
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/BeanDescription;->getFactoryMethods()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 1026
    .local v3, "factory":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v6

    invoke-virtual {v6, v3}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->hasCreatorAnnotation(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1027
    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getParameterCount()I

    move-result v0

    .line 1028
    .local v0, "argCount":I
    const/4 v6, 0x1

    if-ne v0, v6, :cond_2

    .line 1029
    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getRawReturnType()Ljava/lang/Class;

    move-result-object v5

    .line 1031
    .local v5, "returnType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v5, v2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 1032
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v6

    invoke-static {v6, v2, v3}, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;->deserializerForCreator(Lcom/fasterxml/jackson/databind/DeserializationConfig;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v1

    goto :goto_0

    .line 1035
    .end local v5    # "returnType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_2
    new-instance v6, Ljava/lang/IllegalArgumentException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unsuitable method ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") decorated with @JsonCreator (for Enum type "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 1040
    .end local v0    # "argCount":I
    .end local v3    # "factory":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    :cond_3
    new-instance v1, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;

    .end local v1    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v6

    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/BeanDescription;->findJsonValueMethod()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v7

    invoke-virtual {p0, v2, v6, v7}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->constructEnumResolver(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Lcom/fasterxml/jackson/databind/util/EnumResolver;

    move-result-object v6

    invoke-direct {v1, v6}, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;-><init>(Lcom/fasterxml/jackson/databind/util/EnumResolver;)V

    goto :goto_0
.end method

.method public createKeyDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .locals 8
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1142
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v1

    .line 1143
    .local v1, "config":Lcom/fasterxml/jackson/databind/DeserializationConfig;
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->hasKeyDeserializers()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 1144
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v1, v7}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->introspectClassAnnotations(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/BeanDescription;

    move-result-object v0

    .line 1145
    .local v0, "beanDesc":Lcom/fasterxml/jackson/databind/BeanDescription;
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->keyDeserializers()Ljava/lang/Iterable;

    move-result-object v7

    invoke-interface {v7}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;

    .line 1146
    .local v2, "d":Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;
    invoke-interface {v2, p2, v1, v0}, Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;->findKeyDeserializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v3

    .line 1147
    .local v3, "deser":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    if-eqz v3, :cond_0

    move-object v5, v3

    .line 1168
    .end local v0    # "beanDesc":Lcom/fasterxml/jackson/databind/BeanDescription;
    .end local v2    # "d":Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;
    .end local v3    # "deser":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    return-object v5

    .line 1153
    :cond_2
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v6

    .line 1154
    .local v6, "raw":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v7, Ljava/lang/String;

    if-eq v6, v7, :cond_3

    const-class v7, Ljava/lang/Object;

    if-ne v6, v7, :cond_4

    .line 1155
    :cond_3
    invoke-static {v1, p2}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializers;->constructStringKeyDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v5

    goto :goto_0

    .line 1158
    :cond_4
    sget-object v7, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_keyDeserializers:Ljava/util/HashMap;

    invoke-virtual {v7, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .line 1159
    .local v5, "kdes":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    if-nez v5, :cond_1

    .line 1163
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->isEnumType()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 1164
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_createEnumKeyDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v5

    goto :goto_0

    .line 1167
    :cond_5
    invoke-static {v1, p2}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializers;->findStringBasedKeyDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v5

    .line 1168
    goto :goto_0
.end method

.method public createMapDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/type/MapType;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 22
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/type/MapType;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/type/MapType;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 878
    invoke-virtual/range {p1 .. p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v5

    .line 879
    .local v5, "config":Lcom/fasterxml/jackson/databind/DeserializationConfig;
    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/type/MapType;->getKeyType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v19

    .line 880
    .local v19, "keyType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/type/MapType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v16

    .line 884
    .local v16, "contentType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual/range {v16 .. v16}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 887
    .local v9, "contentDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .line 889
    .local v7, "keyDes":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    invoke-virtual/range {v16 .. v16}, Lcom/fasterxml/jackson/databind/JavaType;->getTypeHandler()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 891
    .local v8, "contentTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    if-nez v8, :cond_0

    .line 892
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v5, v1}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v8

    :cond_0
    move-object/from16 v3, p0

    move-object/from16 v4, p2

    move-object/from16 v6, p3

    .line 896
    invoke-virtual/range {v3 .. v9}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findCustomMapDeserializer(Lcom/fasterxml/jackson/databind/type/MapType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v17

    .line 899
    .local v17, "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v17, :cond_1

    .line 937
    .end local v17    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v17

    .line 903
    .restart local v17    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_1
    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/type/MapType;->getRawClass()Ljava/lang/Class;

    move-result-object v21

    .line 904
    .local v21, "mapClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v3, Ljava/util/EnumMap;

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 905
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v20

    .line 906
    .local v20, "kt":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz v20, :cond_2

    invoke-virtual/range {v20 .. v20}, Ljava/lang/Class;->isEnum()Z

    move-result v3

    if-nez v3, :cond_3

    .line 907
    :cond_2
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Can not construct EnumMap; generic (key) type not available"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 909
    :cond_3
    new-instance v17, Lcom/fasterxml/jackson/databind/deser/std/EnumMapDeserializer;

    .end local v17    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    const/4 v3, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-direct {v0, v1, v3, v9}, Lcom/fasterxml/jackson/databind/deser/std/EnumMapDeserializer;-><init>(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)V

    goto :goto_0

    .line 923
    .end local v20    # "kt":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v17    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_4
    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/type/MapType;->isInterface()Z

    move-result v3

    if-nez v3, :cond_5

    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/type/MapType;->isAbstract()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 925
    :cond_5
    sget-object v3, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_mapFallbacks:Ljava/util/HashMap;

    invoke-virtual/range {v21 .. v21}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/Class;

    .line 926
    .local v18, "fallback":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/util/Map;>;"
    if-nez v18, :cond_6

    .line 927
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Can not find a deserializer for non-concrete Map type "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 929
    :cond_6
    move-object/from16 v21, v18

    .line 930
    move-object/from16 v0, p2

    move-object/from16 v1, v21

    invoke-virtual {v5, v0, v1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->constructSpecializedType(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object p2

    .end local p2    # "type":Lcom/fasterxml/jackson/databind/type/MapType;
    check-cast p2, Lcom/fasterxml/jackson/databind/type/MapType;

    .line 932
    .restart local p2    # "type":Lcom/fasterxml/jackson/databind/type/MapType;
    move-object/from16 v0, p2

    invoke-virtual {v5, v0}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->introspectForCreation(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/BeanDescription;

    move-result-object p3

    .line 934
    .end local v18    # "fallback":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/util/Map;>;"
    :cond_7
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p3

    invoke-virtual {v0, v1, v2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    move-result-object v12

    .line 935
    .local v12, "inst":Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    new-instance v10, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;

    move-object/from16 v11, p2

    move-object v13, v7

    move-object v14, v9

    move-object v15, v8

    invoke-direct/range {v10 .. v15}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;-><init>(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;)V

    .line 936
    .local v10, "md":Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v3

    invoke-virtual/range {p3 .. p3}, Lcom/fasterxml/jackson/databind/BeanDescription;->getClassInfo()Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findPropertiesToIgnore(Lcom/fasterxml/jackson/databind/introspect/Annotated;)[Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v10, v3}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->setIgnorableProperties([Ljava/lang/String;)V

    move-object/from16 v17, v10

    .line 937
    goto/16 :goto_0
.end method

.method public createMapLikeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/type/MapLikeType;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 9
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/type/MapLikeType;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/type/MapLikeType;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 946
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/type/MapLikeType;->getKeyType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v8

    .line 947
    .local v8, "keyType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/type/MapLikeType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v7

    .line 951
    .local v7, "contentType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 954
    .local v6, "contentDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .line 961
    .local v4, "keyDes":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/JavaType;->getTypeHandler()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 963
    .local v5, "contentTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    if-nez v5, :cond_0

    .line 964
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v0

    invoke-virtual {p0, v0, v7}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v5

    .line 966
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v2

    move-object v0, p0

    move-object v1, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v6}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findCustomMapLikeDeserializer(Lcom/fasterxml/jackson/databind/type/MapLikeType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v0

    return-object v0
.end method

.method public createTreeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 2
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "nodeType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p3, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/BeanDescription;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1068
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    .line 1070
    .local v1, "nodeClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/fasterxml/jackson/databind/JsonNode;>;"
    invoke-virtual {p0, v1, p1, p3}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findCustomTreeNodeDeserializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v0

    .line 1072
    .local v0, "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v0, :cond_0

    .line 1075
    .end local v0    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_0
    return-object v0

    .restart local v0    # "custom":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_0
    invoke-static {v1}, Lcom/fasterxml/jackson/databind/deser/std/JsonNodeDeserializer;->getDeserializer(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v0

    goto :goto_0
.end method

.method protected findDeserializerFromAnnotation(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 2
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "ann"    # Lcom/fasterxml/jackson/databind/introspect/Annotated;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/introspect/Annotated;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1293
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findDeserializer(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Ljava/lang/Object;

    move-result-object v0

    .line 1294
    .local v0, "deserDef":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 1295
    const/4 v1, 0x0

    .line 1297
    :goto_0
    return-object v1

    :cond_0
    invoke-virtual {p1, p2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->deserializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v1

    goto :goto_0
.end method

.method public findPropertyContentTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .locals 5
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "containerType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p3, "propertyEntity"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1265
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v0

    .line 1266
    .local v0, "ai":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    invoke-virtual {v0, p1, p3, p2}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findPropertyContentTypeResolver(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;

    move-result-object v1

    .line 1267
    .local v1, "b":Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;, "Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder<*>;"
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v2

    .line 1269
    .local v2, "contentType":Lcom/fasterxml/jackson/databind/JavaType;
    if-nez v1, :cond_0

    .line 1270
    invoke-virtual {p0, p1, v2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v4

    .line 1275
    :goto_0
    return-object v4

    .line 1273
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getSubtypeResolver()Lcom/fasterxml/jackson/databind/jsontype/SubtypeResolver;

    move-result-object v4

    invoke-virtual {v4, p3, p1, v0, v2}, Lcom/fasterxml/jackson/databind/jsontype/SubtypeResolver;->collectAndResolveSubtypes(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/JavaType;)Ljava/util/Collection;

    move-result-object v3

    .line 1275
    .local v3, "subtypes":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/fasterxml/jackson/databind/jsontype/NamedType;>;"
    invoke-interface {v1, p1, v2, v3}, Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;->buildTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Ljava/util/Collection;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v4

    goto :goto_0
.end method

.method public findPropertyTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .locals 4
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "baseType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p3, "annotated"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1238
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v0

    .line 1239
    .local v0, "ai":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    invoke-virtual {v0, p1, p3, p2}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findPropertyTypeResolver(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;

    move-result-object v1

    .line 1241
    .local v1, "b":Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;, "Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder<*>;"
    if-nez v1, :cond_0

    .line 1242
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v3

    .line 1247
    :goto_0
    return-object v3

    .line 1245
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getSubtypeResolver()Lcom/fasterxml/jackson/databind/jsontype/SubtypeResolver;

    move-result-object v3

    invoke-virtual {v3, p3, p1, v0, p2}, Lcom/fasterxml/jackson/databind/jsontype/SubtypeResolver;->collectAndResolveSubtypes(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Lcom/fasterxml/jackson/databind/JavaType;)Ljava/util/Collection;

    move-result-object v2

    .line 1247
    .local v2, "subtypes":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/fasterxml/jackson/databind/jsontype/NamedType;>;"
    invoke-interface {v1, p1, p2, v2}, Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;->buildTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Ljava/util/Collection;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v3

    goto :goto_0
.end method

.method public findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .locals 9
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "baseType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1102
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v4

    .line 1103
    .local v4, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1, v4}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->introspectClassAnnotations(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/BeanDescription;

    move-result-object v3

    .line 1104
    .local v3, "bean":Lcom/fasterxml/jackson/databind/BeanDescription;
    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/BeanDescription;->getClassInfo()Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    move-result-object v0

    .line 1105
    .local v0, "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v1

    .line 1106
    .local v1, "ai":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    invoke-virtual {v1, p1, v0, p2}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findTypeResolver(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;

    move-result-object v2

    .line 1111
    .local v2, "b":Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;, "Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder<*>;"
    const/4 v6, 0x0

    .line 1112
    .local v6, "subtypes":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/fasterxml/jackson/databind/jsontype/NamedType;>;"
    if-nez v2, :cond_0

    .line 1113
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getDefaultTyper(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;

    move-result-object v2

    .line 1114
    if-nez v2, :cond_1

    .line 1115
    const/4 v7, 0x0

    .line 1128
    :goto_0
    return-object v7

    .line 1118
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getSubtypeResolver()Lcom/fasterxml/jackson/databind/jsontype/SubtypeResolver;

    move-result-object v7

    invoke-virtual {v7, v0, p1, v1}, Lcom/fasterxml/jackson/databind/jsontype/SubtypeResolver;->collectAndResolveSubtypes(Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;)Ljava/util/Collection;

    move-result-object v6

    .line 1122
    :cond_1
    invoke-interface {v2}, Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;->getDefaultImpl()Ljava/lang/Class;

    move-result-object v7

    if-nez v7, :cond_2

    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->isAbstract()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 1123
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->mapAbstractType(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v5

    .line 1124
    .local v5, "defaultType":Lcom/fasterxml/jackson/databind/JavaType;
    if-eqz v5, :cond_2

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v8

    if-eq v7, v8, :cond_2

    .line 1125
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v7

    invoke-interface {v2, v7}, Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;->defaultImpl(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;

    move-result-object v2

    .line 1128
    .end local v5    # "defaultType":Lcom/fasterxml/jackson/databind/JavaType;
    :cond_2
    invoke-interface {v2, p1, p2, v6}, Lcom/fasterxml/jackson/databind/jsontype/TypeResolverBuilder;->buildTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Ljava/util/Collection;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v7

    goto :goto_0
.end method

.method public findValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    .locals 9
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 299
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v1

    .line 301
    .local v1, "config":Lcom/fasterxml/jackson/databind/DeserializationConfig;
    const/4 v4, 0x0

    .line 303
    .local v4, "instantiator":Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/BeanDescription;->getClassInfo()Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    move-result-object v0

    .line 304
    .local v0, "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v6

    invoke-virtual {v6, v0}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findValueInstantiator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;)Ljava/lang/Object;

    move-result-object v3

    .line 305
    .local v3, "instDef":Ljava/lang/Object;
    if-eqz v3, :cond_0

    .line 306
    invoke-virtual {p0, v1, v0, v3}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_valueInstantiatorInstance(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    move-result-object v4

    .line 308
    :cond_0
    if-nez v4, :cond_1

    .line 312
    invoke-direct {p0, v1, p2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_findStdValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    move-result-object v4

    .line 313
    if-nez v4, :cond_1

    .line 314
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_constructDefaultValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    move-result-object v4

    .line 319
    :cond_1
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v6}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->hasValueInstantiators()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 320
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v6}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->valueInstantiators()Ljava/lang/Iterable;

    move-result-object v6

    invoke-interface {v6}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;

    .line 321
    .local v5, "insts":Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;
    invoke-interface {v5, v1, p2, v4}, Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;->findValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    move-result-object v4

    .line 323
    if-nez v4, :cond_2

    .line 324
    new-instance v6, Lcom/fasterxml/jackson/databind/JsonMappingException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Broken registered ValueInstantiators (of type "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "): returned null ValueInstantiator"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 330
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v5    # "insts":Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;
    :cond_3
    return-object v4
.end method

.method public getFactoryConfig()Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    return-object v0
.end method

.method public mapAbstractType(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 6
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 247
    :goto_0
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_mapAbstractType2(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 248
    .local v0, "next":Lcom/fasterxml/jackson/databind/JavaType;
    if-nez v0, :cond_0

    .line 249
    return-object p2

    .line 255
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v2

    .line 256
    .local v2, "prevCls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    .line 257
    .local v1, "nextCls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eq v2, v1, :cond_1

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 258
    :cond_1
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Invalid abstract type resolution from "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": latter is not a subtype of former"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 260
    :cond_2
    move-object p2, v0

    .line 261
    goto :goto_0
.end method

.method protected modifyTypeByAnnotation(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 16
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "a"    # Lcom/fasterxml/jackson/databind/introspect/Annotated;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ">(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/introspect/Annotated;",
            "TT;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1322
    .local p3, "type":Lcom/fasterxml/jackson/databind/JavaType;, "TT;"
    invoke-virtual/range {p1 .. p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v7

    .line 1323
    .local v7, "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-virtual {v7, v0, v1}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findDeserializationType(Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/JavaType;)Ljava/lang/Class;

    move-result-object v12

    .line 1324
    .local v12, "subclass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz v12, :cond_0

    .line 1326
    :try_start_0
    move-object/from16 v0, p3

    invoke-virtual {v0, v12}, Lcom/fasterxml/jackson/databind/JavaType;->narrowBy(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p3

    .line 1333
    :cond_0
    invoke-virtual/range {p3 .. p3}, Lcom/fasterxml/jackson/databind/JavaType;->isContainerType()Z

    move-result v13

    if-eqz v13, :cond_5

    .line 1334
    invoke-virtual/range {p3 .. p3}, Lcom/fasterxml/jackson/databind/JavaType;->getKeyType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v13

    move-object/from16 v0, p2

    invoke-virtual {v7, v0, v13}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findDeserializationKeyType(Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/JavaType;)Ljava/lang/Class;

    move-result-object v10

    .line 1335
    .local v10, "keyClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz v10, :cond_2

    .line 1337
    move-object/from16 v0, p3

    instance-of v13, v0, Lcom/fasterxml/jackson/databind/type/MapLikeType;

    if-nez v13, :cond_1

    .line 1338
    new-instance v13, Lcom/fasterxml/jackson/databind/JsonMappingException;

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Illegal key-type annotation: type "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p3

    invoke-virtual {v14, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " is not a Map(-like) type"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-direct {v13, v14}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 1327
    .end local v10    # "keyClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catch_0
    move-exception v6

    .line 1328
    .local v6, "iae":Ljava/lang/IllegalArgumentException;
    new-instance v13, Lcom/fasterxml/jackson/databind/JsonMappingException;

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Failed to narrow type "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p3

    invoke-virtual {v14, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " with concrete-type annotation (value "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v12}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, "), method \'"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual/range {p2 .. p2}, Lcom/fasterxml/jackson/databind/introspect/Annotated;->getName()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, "\': "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v6}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    const/4 v15, 0x0

    invoke-direct {v13, v14, v15, v6}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonLocation;Ljava/lang/Throwable;)V

    throw v13

    .line 1341
    .end local v6    # "iae":Ljava/lang/IllegalArgumentException;
    .restart local v10    # "keyClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    :try_start_1
    move-object/from16 v0, p3

    check-cast v0, Lcom/fasterxml/jackson/databind/type/MapLikeType;

    move-object v13, v0

    invoke-virtual {v13, v10}, Lcom/fasterxml/jackson/databind/type/MapLikeType;->narrowKey(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object p3

    .line 1346
    :cond_2
    invoke-virtual/range {p3 .. p3}, Lcom/fasterxml/jackson/databind/JavaType;->getKeyType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v11

    .line 1351
    .local v11, "keyType":Lcom/fasterxml/jackson/databind/JavaType;
    if-eqz v11, :cond_3

    invoke-virtual {v11}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v13

    if-nez v13, :cond_3

    .line 1352
    move-object/from16 v0, p2

    invoke-virtual {v7, v0}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findKeyDeserializer(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Ljava/lang/Object;

    move-result-object v9

    .line 1353
    .local v9, "kdDef":Ljava/lang/Object;
    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v9}, Lcom/fasterxml/jackson/databind/DeserializationContext;->keyDeserializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v8

    .line 1354
    .local v8, "kd":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    if-eqz v8, :cond_3

    .line 1355
    check-cast p3, Lcom/fasterxml/jackson/databind/type/MapLikeType;

    .end local p3    # "type":Lcom/fasterxml/jackson/databind/JavaType;, "TT;"
    move-object/from16 v0, p3

    invoke-virtual {v0, v8}, Lcom/fasterxml/jackson/databind/type/MapLikeType;->withKeyValueHandler(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/type/MapLikeType;

    move-result-object p3

    .line 1356
    .restart local p3    # "type":Lcom/fasterxml/jackson/databind/JavaType;, "TT;"
    invoke-virtual/range {p3 .. p3}, Lcom/fasterxml/jackson/databind/JavaType;->getKeyType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v11

    .line 1361
    .end local v8    # "kd":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .end local v9    # "kdDef":Ljava/lang/Object;
    :cond_3
    invoke-virtual/range {p3 .. p3}, Lcom/fasterxml/jackson/databind/JavaType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v13

    move-object/from16 v0, p2

    invoke-virtual {v7, v0, v13}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findDeserializationContentType(Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/JavaType;)Ljava/lang/Class;

    move-result-object v2

    .line 1362
    .local v2, "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz v2, :cond_4

    .line 1364
    :try_start_2
    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/databind/JavaType;->narrowContentsBy(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    :try_end_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object p3

    .line 1370
    :cond_4
    invoke-virtual/range {p3 .. p3}, Lcom/fasterxml/jackson/databind/JavaType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v5

    .line 1371
    .local v5, "contentType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v13

    if-nez v13, :cond_5

    .line 1372
    move-object/from16 v0, p2

    invoke-virtual {v7, v0}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findContentDeserializer(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Ljava/lang/Object;

    move-result-object v4

    .line 1373
    .local v4, "cdDef":Ljava/lang/Object;
    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v4}, Lcom/fasterxml/jackson/databind/DeserializationContext;->deserializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v3

    .line 1374
    .local v3, "cd":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v3, :cond_5

    .line 1375
    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Lcom/fasterxml/jackson/databind/JavaType;->withContentValueHandler(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object p3

    .line 1379
    .end local v2    # "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v3    # "cd":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    .end local v4    # "cdDef":Ljava/lang/Object;
    .end local v5    # "contentType":Lcom/fasterxml/jackson/databind/JavaType;
    .end local v10    # "keyClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v11    # "keyType":Lcom/fasterxml/jackson/databind/JavaType;
    :cond_5
    return-object p3

    .line 1342
    .restart local v10    # "keyClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catch_1
    move-exception v6

    .line 1343
    .restart local v6    # "iae":Ljava/lang/IllegalArgumentException;
    new-instance v13, Lcom/fasterxml/jackson/databind/JsonMappingException;

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Failed to narrow key type "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p3

    invoke-virtual {v14, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " with key-type annotation ("

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, "): "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v6}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    const/4 v15, 0x0

    invoke-direct {v13, v14, v15, v6}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonLocation;Ljava/lang/Throwable;)V

    throw v13

    .line 1365
    .end local v6    # "iae":Ljava/lang/IllegalArgumentException;
    .restart local v2    # "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v11    # "keyType":Lcom/fasterxml/jackson/databind/JavaType;
    :catch_2
    move-exception v6

    .line 1366
    .restart local v6    # "iae":Ljava/lang/IllegalArgumentException;
    new-instance v13, Lcom/fasterxml/jackson/databind/JsonMappingException;

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Failed to narrow content type "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p3

    invoke-virtual {v14, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " with content-type annotation ("

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, "): "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v6}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    const/4 v15, 0x0

    invoke-direct {v13, v14, v15, v6}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonLocation;Ljava/lang/Throwable;)V

    throw v13
.end method

.method protected resolveType(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 9
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p3, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p4, "member"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 1394
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/JavaType;->isContainerType()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 1395
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v3

    .line 1396
    .local v3, "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/JavaType;->getKeyType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v6

    .line 1397
    .local v6, "keyType":Lcom/fasterxml/jackson/databind/JavaType;
    if-eqz v6, :cond_0

    .line 1398
    invoke-virtual {v3, p4}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findKeyDeserializer(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Ljava/lang/Object;

    move-result-object v5

    .line 1399
    .local v5, "kdDef":Ljava/lang/Object;
    invoke-virtual {p1, p4, v5}, Lcom/fasterxml/jackson/databind/DeserializationContext;->keyDeserializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v4

    .line 1400
    .local v4, "kd":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    if-eqz v4, :cond_0

    .line 1401
    check-cast p3, Lcom/fasterxml/jackson/databind/type/MapLikeType;

    .end local p3    # "type":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {p3, v4}, Lcom/fasterxml/jackson/databind/type/MapLikeType;->withKeyValueHandler(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/type/MapLikeType;

    move-result-object p3

    .line 1402
    .restart local p3    # "type":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/JavaType;->getKeyType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v6

    .line 1406
    .end local v4    # "kd":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .end local v5    # "kdDef":Ljava/lang/Object;
    :cond_0
    invoke-virtual {v3, p4}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findContentDeserializer(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Ljava/lang/Object;

    move-result-object v1

    .line 1407
    .local v1, "cdDef":Ljava/lang/Object;
    invoke-virtual {p1, p4, v1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->deserializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v0

    .line 1408
    .local v0, "cd":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v0, :cond_1

    .line 1409
    invoke-virtual {p3, v0}, Lcom/fasterxml/jackson/databind/JavaType;->withContentValueHandler(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object p3

    .line 1416
    :cond_1
    instance-of v8, p4, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    if-eqz v8, :cond_2

    .line 1417
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v8

    invoke-virtual {p0, v8, p3, p4}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findPropertyContentTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v2

    .line 1419
    .local v2, "contentTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    if-eqz v2, :cond_2

    .line 1420
    invoke-virtual {p3, v2}, Lcom/fasterxml/jackson/databind/JavaType;->withContentTypeHandler(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object p3

    .line 1426
    .end local v0    # "cd":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    .end local v1    # "cdDef":Ljava/lang/Object;
    .end local v2    # "contentTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .end local v3    # "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .end local v6    # "keyType":Lcom/fasterxml/jackson/databind/JavaType;
    :cond_2
    instance-of v8, p4, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    if-eqz v8, :cond_4

    .line 1427
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v8

    invoke-virtual {p0, v8, p3, p4}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findPropertyTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v7

    .line 1433
    .local v7, "valueTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    :goto_0
    if-eqz v7, :cond_3

    .line 1434
    invoke-virtual {p3, v7}, Lcom/fasterxml/jackson/databind/JavaType;->withTypeHandler(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object p3

    .line 1436
    :cond_3
    return-object p3

    .line 1431
    .end local v7    # "valueTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    :cond_4
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v8

    invoke-virtual {p0, v8, p3}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->findTypeDeserializer(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v7

    .restart local v7    # "valueTypeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    goto :goto_0
.end method

.method public final withAbstractTypeResolver(Lcom/fasterxml/jackson/databind/AbstractTypeResolver;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    .locals 1
    .param p1, "resolver"    # Lcom/fasterxml/jackson/databind/AbstractTypeResolver;

    .prologue
    .line 223
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->withAbstractTypeResolver(Lcom/fasterxml/jackson/databind/AbstractTypeResolver;)Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->withConfig(Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    return-object v0
.end method

.method public final withAdditionalDeserializers(Lcom/fasterxml/jackson/databind/deser/Deserializers;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    .locals 1
    .param p1, "additional"    # Lcom/fasterxml/jackson/databind/deser/Deserializers;

    .prologue
    .line 196
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->withAdditionalDeserializers(Lcom/fasterxml/jackson/databind/deser/Deserializers;)Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->withConfig(Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    return-object v0
.end method

.method public final withAdditionalKeyDeserializers(Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    .locals 1
    .param p1, "additional"    # Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;

    .prologue
    .line 205
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->withAdditionalKeyDeserializers(Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;)Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->withConfig(Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    return-object v0
.end method

.method protected abstract withConfig(Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
.end method

.method public final withDeserializerModifier(Lcom/fasterxml/jackson/databind/deser/BeanDeserializerModifier;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    .locals 1
    .param p1, "modifier"    # Lcom/fasterxml/jackson/databind/deser/BeanDeserializerModifier;

    .prologue
    .line 214
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->withDeserializerModifier(Lcom/fasterxml/jackson/databind/deser/BeanDeserializerModifier;)Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->withConfig(Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    return-object v0
.end method

.method public final withValueInstantiators(Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    .locals 1
    .param p1, "instantiators"    # Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;

    .prologue
    .line 232
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->_factoryConfig:Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;->withValueInstantiators(Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;)Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/deser/BasicDeserializerFactory;->withConfig(Lcom/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    return-object v0
.end method
