.class public final Lcom/fasterxml/jackson/databind/type/TypeFactory;
.super Ljava/lang/Object;
.source "TypeFactory.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field protected static final CORE_TYPE_BOOL:Lcom/fasterxml/jackson/databind/type/SimpleType;

.field protected static final CORE_TYPE_INT:Lcom/fasterxml/jackson/databind/type/SimpleType;

.field protected static final CORE_TYPE_LONG:Lcom/fasterxml/jackson/databind/type/SimpleType;

.field protected static final CORE_TYPE_STRING:Lcom/fasterxml/jackson/databind/type/SimpleType;

.field private static final NO_TYPES:[Lcom/fasterxml/jackson/databind/JavaType;

.field protected static final instance:Lcom/fasterxml/jackson/databind/type/TypeFactory;

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field protected transient _cachedArrayListType:Lcom/fasterxml/jackson/databind/type/HierarchicType;

.field protected transient _cachedHashMapType:Lcom/fasterxml/jackson/databind/type/HierarchicType;

.field protected final _modifiers:[Lcom/fasterxml/jackson/databind/type/TypeModifier;

.field protected final _parser:Lcom/fasterxml/jackson/databind/type/TypeParser;

.field protected final _typeCache:Lcom/fasterxml/jackson/databind/util/LRUMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/util/LRUMap",
            "<",
            "Lcom/fasterxml/jackson/databind/type/ClassKey;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 37
    const/4 v0, 0x0

    new-array v0, v0, [Lcom/fasterxml/jackson/databind/JavaType;

    sput-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->NO_TYPES:[Lcom/fasterxml/jackson/databind/JavaType;

    .line 44
    new-instance v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;-><init>()V

    sput-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->instance:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    .line 56
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    const-class v1, Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->CORE_TYPE_STRING:Lcom/fasterxml/jackson/databind/type/SimpleType;

    .line 57
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    sget-object v1, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->CORE_TYPE_BOOL:Lcom/fasterxml/jackson/databind/type/SimpleType;

    .line 58
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    sget-object v1, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->CORE_TYPE_INT:Lcom/fasterxml/jackson/databind/type/SimpleType;

    .line 59
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    sget-object v1, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->CORE_TYPE_LONG:Lcom/fasterxml/jackson/databind/type/SimpleType;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    .line 106
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    new-instance v0, Lcom/fasterxml/jackson/databind/util/LRUMap;

    const/16 v1, 0x10

    const/16 v2, 0x64

    invoke-direct {v0, v1, v2}, Lcom/fasterxml/jackson/databind/util/LRUMap;-><init>(II)V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_typeCache:Lcom/fasterxml/jackson/databind/util/LRUMap;

    .line 107
    new-instance v0, Lcom/fasterxml/jackson/databind/type/TypeParser;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/type/TypeParser;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;)V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_parser:Lcom/fasterxml/jackson/databind/type/TypeParser;

    .line 108
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_modifiers:[Lcom/fasterxml/jackson/databind/type/TypeModifier;

    .line 109
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/type/TypeParser;[Lcom/fasterxml/jackson/databind/type/TypeModifier;)V
    .locals 3

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    new-instance v0, Lcom/fasterxml/jackson/databind/util/LRUMap;

    const/16 v1, 0x10

    const/16 v2, 0x64

    invoke-direct {v0, v1, v2}, Lcom/fasterxml/jackson/databind/util/LRUMap;-><init>(II)V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_typeCache:Lcom/fasterxml/jackson/databind/util/LRUMap;

    .line 112
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_parser:Lcom/fasterxml/jackson/databind/type/TypeParser;

    .line 113
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_modifiers:[Lcom/fasterxml/jackson/databind/type/TypeModifier;

    .line 114
    return-void
.end method

.method private _collectionType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 896
    const-class v0, Ljava/util/Collection;

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->findTypeParameters(Ljava/lang/Class;Ljava/lang/Class;)[Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 898
    if-nez v0, :cond_0

    .line 899
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/databind/type/CollectionType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionType;

    move-result-object v0

    .line 905
    :goto_0
    return-object v0

    .line 902
    :cond_0
    array-length v1, v0

    const/4 v2, 0x1

    if-eq v1, v2, :cond_1

    .line 903
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Strange Collection type "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": can not determine type parameters"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 905
    :cond_1
    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/databind/type/CollectionType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionType;

    move-result-object v0

    goto :goto_0
.end method

.method private _mapType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 882
    const-class v0, Ljava/util/Map;

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->findTypeParameters(Ljava/lang/Class;Ljava/lang/Class;)[Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 884
    if-nez v0, :cond_0

    .line 885
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/fasterxml/jackson/databind/type/MapType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;

    move-result-object v0

    .line 891
    :goto_0
    return-object v0

    .line 888
    :cond_0
    array-length v1, v0

    const/4 v2, 0x2

    if-eq v1, v2, :cond_1

    .line 889
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Strange Map type "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": can not determine type parameters"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 891
    :cond_1
    const/4 v1, 0x0

    aget-object v1, v0, v1

    const/4 v2, 0x1

    aget-object v0, v0, v2

    invoke-static {p1, v1, v0}, Lcom/fasterxml/jackson/databind/type/MapType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;

    move-result-object v0

    goto :goto_0
.end method

.method public static defaultInstance()Lcom/fasterxml/jackson/databind/type/TypeFactory;
    .locals 1

    .prologue
    .line 129
    sget-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->instance:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    return-object v0
.end method

.method public static rawClass(Ljava/lang/reflect/Type;)Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/reflect/Type;",
            ")",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 153
    instance-of v0, p0, Ljava/lang/Class;

    if-eqz v0, :cond_0

    .line 154
    check-cast p0, Ljava/lang/Class;

    .line 157
    :goto_0
    return-object p0

    :cond_0
    invoke-static {}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->defaultInstance()Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object p0

    goto :goto_0
.end method

.method public static unknownType()Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 143
    invoke-static {}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->defaultInstance()Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method protected declared-synchronized _arrayListSuperInterfaceChain(Lcom/fasterxml/jackson/databind/type/HierarchicType;)Lcom/fasterxml/jackson/databind/type/HierarchicType;
    .locals 2

    .prologue
    .line 1042
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_cachedArrayListType:Lcom/fasterxml/jackson/databind/type/HierarchicType;

    if-nez v0, :cond_0

    .line 1043
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->deepCloneWithoutSubtype()Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    .line 1044
    const-class v1, Ljava/util/List;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_doFindSuperInterfaceChain(Lcom/fasterxml/jackson/databind/type/HierarchicType;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    .line 1045
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getSuperType()Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_cachedArrayListType:Lcom/fasterxml/jackson/databind/type/HierarchicType;

    .line 1047
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_cachedArrayListType:Lcom/fasterxml/jackson/databind/type/HierarchicType;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->deepCloneWithoutSubtype()Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    .line 1048
    invoke-virtual {p1, v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSuperType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V

    .line 1049
    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSubType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1050
    monitor-exit p0

    return-object p1

    .line 1042
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected _constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 5

    .prologue
    .line 368
    instance-of v0, p1, Ljava/lang/Class;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 369
    check-cast v0, Ljava/lang/Class;

    .line 370
    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_fromClass(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 395
    :goto_0
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_modifiers:[Lcom/fasterxml/jackson/databind/type/TypeModifier;

    if-eqz v1, :cond_7

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->isContainerType()Z

    move-result v1

    if-nez v1, :cond_7

    .line 396
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_modifiers:[Lcom/fasterxml/jackson/databind/type/TypeModifier;

    array-length v4, v3

    const/4 v1, 0x0

    :goto_1
    if-ge v1, v4, :cond_7

    aget-object v2, v3, v1

    .line 397
    invoke-virtual {v2, v0, p1, p2, p0}, Lcom/fasterxml/jackson/databind/type/TypeModifier;->modifyType(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;Lcom/fasterxml/jackson/databind/type/TypeFactory;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v2

    .line 396
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    move-object v0, v2

    goto :goto_1

    .line 373
    :cond_0
    instance-of v0, p1, Ljava/lang/reflect/ParameterizedType;

    if-eqz v0, :cond_1

    move-object v0, p1

    .line 374
    check-cast v0, Ljava/lang/reflect/ParameterizedType;

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_fromParamType(Ljava/lang/reflect/ParameterizedType;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0

    .line 376
    :cond_1
    instance-of v0, p1, Lcom/fasterxml/jackson/databind/JavaType;

    if-eqz v0, :cond_2

    .line 377
    check-cast p1, Lcom/fasterxml/jackson/databind/JavaType;

    .line 400
    :goto_2
    return-object p1

    .line 379
    :cond_2
    instance-of v0, p1, Ljava/lang/reflect/GenericArrayType;

    if-eqz v0, :cond_3

    move-object v0, p1

    .line 380
    check-cast v0, Ljava/lang/reflect/GenericArrayType;

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_fromArrayType(Ljava/lang/reflect/GenericArrayType;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0

    .line 382
    :cond_3
    instance-of v0, p1, Ljava/lang/reflect/TypeVariable;

    if-eqz v0, :cond_4

    move-object v0, p1

    .line 383
    check-cast v0, Ljava/lang/reflect/TypeVariable;

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_fromVariable(Ljava/lang/reflect/TypeVariable;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0

    .line 385
    :cond_4
    instance-of v0, p1, Ljava/lang/reflect/WildcardType;

    if-eqz v0, :cond_5

    move-object v0, p1

    .line 386
    check-cast v0, Ljava/lang/reflect/WildcardType;

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_fromWildcard(Ljava/lang/reflect/WildcardType;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0

    .line 389
    :cond_5
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unrecognized Type: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    if-nez p1, :cond_6

    const-string v0, "[null]"

    :goto_3
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_6
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_3

    :cond_7
    move-object p1, v0

    .line 400
    goto :goto_2
.end method

.method protected _doFindSuperInterfaceChain(Lcom/fasterxml/jackson/databind/type/HierarchicType;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/type/HierarchicType;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/HierarchicType;"
        }
    .end annotation

    .prologue
    .line 1000
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    .line 1001
    invoke-virtual {v1}, Ljava/lang/Class;->getGenericInterfaces()[Ljava/lang/reflect/Type;

    move-result-object v2

    .line 1004
    if-eqz v2, :cond_1

    .line 1005
    array-length v3, v2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v3, :cond_1

    aget-object v4, v2, v0

    .line 1006
    invoke-virtual {p0, v4, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_findSuperInterfaceChain(Ljava/lang/reflect/Type;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v4

    .line 1007
    if-eqz v4, :cond_0

    .line 1008
    invoke-virtual {v4, p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSubType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V

    .line 1009
    invoke-virtual {p1, v4}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSuperType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V

    .line 1024
    :goto_1
    return-object p1

    .line 1005
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1015
    :cond_1
    invoke-virtual {v1}, Ljava/lang/Class;->getGenericSuperclass()Ljava/lang/reflect/Type;

    move-result-object v0

    .line 1016
    if-eqz v0, :cond_2

    .line 1017
    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_findSuperInterfaceChain(Ljava/lang/reflect/Type;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    .line 1018
    if-eqz v0, :cond_2

    .line 1019
    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSubType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V

    .line 1020
    invoke-virtual {p1, v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSuperType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V

    goto :goto_1

    .line 1024
    :cond_2
    const/4 p1, 0x0

    goto :goto_1
.end method

.method protected _findSuperClassChain(Ljava/lang/reflect/Type;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/reflect/Type;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/HierarchicType;"
        }
    .end annotation

    .prologue
    .line 956
    new-instance v0, Lcom/fasterxml/jackson/databind/type/HierarchicType;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;-><init>(Ljava/lang/reflect/Type;)V

    .line 957
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    .line 958
    if-ne v1, p2, :cond_0

    .line 971
    :goto_0
    return-object v0

    .line 962
    :cond_0
    invoke-virtual {v1}, Ljava/lang/Class;->getGenericSuperclass()Ljava/lang/reflect/Type;

    move-result-object v1

    .line 963
    if-eqz v1, :cond_1

    .line 964
    invoke-virtual {p0, v1, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_findSuperClassChain(Ljava/lang/reflect/Type;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v1

    .line 965
    if-eqz v1, :cond_1

    .line 966
    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSubType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V

    .line 967
    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSuperType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V

    goto :goto_0

    .line 971
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected _findSuperInterfaceChain(Ljava/lang/reflect/Type;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/reflect/Type;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/HierarchicType;"
        }
    .end annotation

    .prologue
    .line 976
    new-instance v0, Lcom/fasterxml/jackson/databind/type/HierarchicType;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;-><init>(Ljava/lang/reflect/Type;)V

    .line 977
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    .line 978
    if-ne v1, p2, :cond_0

    .line 979
    new-instance v0, Lcom/fasterxml/jackson/databind/type/HierarchicType;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;-><init>(Ljava/lang/reflect/Type;)V

    .line 995
    :goto_0
    return-object v0

    .line 985
    :cond_0
    const-class v2, Ljava/util/HashMap;

    if-ne v1, v2, :cond_1

    .line 986
    const-class v2, Ljava/util/Map;

    if-ne p2, v2, :cond_1

    .line 987
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_hashMapSuperInterfaceChain(Lcom/fasterxml/jackson/databind/type/HierarchicType;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    goto :goto_0

    .line 990
    :cond_1
    const-class v2, Ljava/util/ArrayList;

    if-ne v1, v2, :cond_2

    .line 991
    const-class v1, Ljava/util/List;

    if-ne p2, v1, :cond_2

    .line 992
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_arrayListSuperInterfaceChain(Lcom/fasterxml/jackson/databind/type/HierarchicType;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    goto :goto_0

    .line 995
    :cond_2
    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_doFindSuperInterfaceChain(Lcom/fasterxml/jackson/databind/type/HierarchicType;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    goto :goto_0
.end method

.method protected _findSuperTypeChain(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/HierarchicType;"
        }
    .end annotation

    .prologue
    .line 948
    invoke-virtual {p2}, Ljava/lang/Class;->isInterface()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 949
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_findSuperInterfaceChain(Ljava/lang/reflect/Type;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    .line 951
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_findSuperClassChain(Ljava/lang/reflect/Type;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    goto :goto_0
.end method

.method protected _fromArrayType(Ljava/lang/reflect/GenericArrayType;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 822
    invoke-interface {p1}, Ljava/lang/reflect/GenericArrayType;->getGenericComponentType()Ljava/lang/reflect/Type;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 823
    invoke-static {v0, v1, v1}, Lcom/fasterxml/jackson/databind/type/ArrayType;->construct(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Object;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/type/ArrayType;

    move-result-object v0

    return-object v0
.end method

.method protected _fromClass(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/type/TypeBindings;",
            ")",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 683
    const-class v0, Ljava/lang/String;

    if-ne p1, v0, :cond_1

    sget-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->CORE_TYPE_STRING:Lcom/fasterxml/jackson/databind/type/SimpleType;

    .line 730
    :cond_0
    :goto_0
    return-object v0

    .line 684
    :cond_1
    sget-object v0, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    if-ne p1, v0, :cond_2

    sget-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->CORE_TYPE_BOOL:Lcom/fasterxml/jackson/databind/type/SimpleType;

    goto :goto_0

    .line 685
    :cond_2
    sget-object v0, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    if-ne p1, v0, :cond_3

    sget-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->CORE_TYPE_INT:Lcom/fasterxml/jackson/databind/type/SimpleType;

    goto :goto_0

    .line 686
    :cond_3
    sget-object v0, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    if-ne p1, v0, :cond_4

    sget-object v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->CORE_TYPE_LONG:Lcom/fasterxml/jackson/databind/type/SimpleType;

    goto :goto_0

    .line 689
    :cond_4
    new-instance v1, Lcom/fasterxml/jackson/databind/type/ClassKey;

    invoke-direct {v1, p1}, Lcom/fasterxml/jackson/databind/type/ClassKey;-><init>(Ljava/lang/Class;)V

    .line 692
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_typeCache:Lcom/fasterxml/jackson/databind/util/LRUMap;

    monitor-enter v2

    .line 693
    :try_start_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_typeCache:Lcom/fasterxml/jackson/databind/util/LRUMap;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/util/LRUMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/JavaType;

    .line 694
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 695
    if-nez v0, :cond_0

    .line 707
    invoke-virtual {p1}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 708
    invoke-virtual {p1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {v0, v3, v3}, Lcom/fasterxml/jackson/databind/type/ArrayType;->construct(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Object;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/type/ArrayType;

    move-result-object v0

    .line 726
    :goto_1
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_typeCache:Lcom/fasterxml/jackson/databind/util/LRUMap;

    monitor-enter v2

    .line 727
    :try_start_1
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_typeCache:Lcom/fasterxml/jackson/databind/util/LRUMap;

    invoke-virtual {v3, v1, v0}, Lcom/fasterxml/jackson/databind/util/LRUMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 728
    monitor-exit v2

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 694
    :catchall_1
    move-exception v0

    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v0

    .line 712
    :cond_5
    invoke-virtual {p1}, Ljava/lang/Class;->isEnum()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 713
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    goto :goto_1

    .line 718
    :cond_6
    const-class v0, Ljava/util/Map;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 719
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_mapType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_1

    .line 720
    :cond_7
    const-class v0, Ljava/util/Collection;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 721
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_collectionType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_1

    .line 723
    :cond_8
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    goto :goto_1
.end method

.method protected _fromParamType(Ljava/lang/reflect/ParameterizedType;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v3, 0x0

    .line 781
    invoke-interface {p1}, Ljava/lang/reflect/ParameterizedType;->getRawType()Ljava/lang/reflect/Type;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    .line 782
    invoke-interface {p1}, Ljava/lang/reflect/ParameterizedType;->getActualTypeArguments()[Ljava/lang/reflect/Type;

    move-result-object v5

    .line 783
    if-nez v5, :cond_1

    move v4, v3

    .line 787
    :goto_0
    if-nez v4, :cond_2

    .line 788
    sget-object v1, Lcom/fasterxml/jackson/databind/type/TypeFactory;->NO_TYPES:[Lcom/fasterxml/jackson/databind/JavaType;

    .line 797
    :cond_0
    const-class v2, Ljava/util/Map;

    invoke-virtual {v2, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 798
    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructSimpleType(Ljava/lang/Class;[Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    .line 799
    const-class v2, Ljava/util/Map;

    invoke-virtual {p0, v1, v2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->findTypeParameters(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Class;)[Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    .line 800
    array-length v2, v1

    const/4 v4, 0x2

    if-eq v2, v4, :cond_3

    .line 801
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not find 2 type parameters for Map class "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " (found "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    array-length v1, v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 783
    :cond_1
    array-length v1, v5

    move v4, v1

    goto :goto_0

    .line 790
    :cond_2
    new-array v1, v4, [Lcom/fasterxml/jackson/databind/JavaType;

    move v2, v3

    .line 791
    :goto_1
    if-ge v2, v4, :cond_0

    .line 792
    aget-object v6, v5, v2

    invoke-virtual {p0, v6, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v6

    aput-object v6, v1, v2

    .line 791
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 803
    :cond_3
    aget-object v2, v1, v3

    aget-object v1, v1, v7

    invoke-static {v0, v2, v1}, Lcom/fasterxml/jackson/databind/type/MapType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;

    move-result-object v0

    .line 816
    :goto_2
    return-object v0

    .line 805
    :cond_4
    const-class v2, Ljava/util/Collection;

    invoke-virtual {v2, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 806
    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructSimpleType(Ljava/lang/Class;[Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    .line 807
    const-class v2, Ljava/util/Collection;

    invoke-virtual {p0, v1, v2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->findTypeParameters(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Class;)[Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    .line 808
    array-length v2, v1

    if-eq v2, v7, :cond_5

    .line 809
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not find 1 type parameter for Collection class "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " (found "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    array-length v1, v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 811
    :cond_5
    aget-object v1, v1, v3

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/type/CollectionType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionType;

    move-result-object v0

    goto :goto_2

    .line 813
    :cond_6
    if-nez v4, :cond_7

    .line 814
    new-instance v1, Lcom/fasterxml/jackson/databind/type/SimpleType;

    invoke-direct {v1, v0}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    move-object v0, v1

    goto :goto_2

    .line 816
    :cond_7
    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructSimpleType(Ljava/lang/Class;[Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_2
.end method

.method protected _fromParameterizedClass(Ljava/lang/Class;Ljava/util/List;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ">;)",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 739
    invoke-virtual {p1}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 740
    invoke-virtual {p1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {v0, v1, v1}, Lcom/fasterxml/jackson/databind/type/ArrayType;->construct(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Object;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/type/ArrayType;

    move-result-object v0

    .line 766
    :goto_0
    return-object v0

    .line 742
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Class;->isEnum()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 743
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    goto :goto_0

    .line 745
    :cond_1
    const-class v0, Ljava/util/Map;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 748
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 749
    invoke-interface {p2, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/JavaType;

    .line 750
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    const/4 v2, 0x2

    if-lt v1, v2, :cond_2

    invoke-interface {p2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/JavaType;

    .line 752
    :goto_1
    invoke-static {p1, v0, v1}, Lcom/fasterxml/jackson/databind/type/MapType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;

    move-result-object v0

    goto :goto_0

    .line 750
    :cond_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    goto :goto_1

    .line 754
    :cond_3
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_mapType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0

    .line 756
    :cond_4
    const-class v0, Ljava/util/Collection;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 757
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    if-lt v0, v3, :cond_5

    .line 758
    invoke-interface {p2, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/JavaType;

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/databind/type/CollectionType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionType;

    move-result-object v0

    goto :goto_0

    .line 760
    :cond_5
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_collectionType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0

    .line 762
    :cond_6
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_7

    .line 763
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    goto :goto_0

    .line 765
    :cond_7
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Lcom/fasterxml/jackson/databind/JavaType;

    invoke-interface {p2, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/fasterxml/jackson/databind/JavaType;

    .line 766
    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructSimpleType(Ljava/lang/Class;[Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0
.end method

.method protected _fromVariable(Ljava/lang/reflect/TypeVariable;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/reflect/TypeVariable",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/type/TypeBindings;",
            ")",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 832
    if-nez p2, :cond_1

    .line 833
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 864
    :cond_0
    :goto_0
    return-object v0

    .line 837
    :cond_1
    invoke-interface {p1}, Ljava/lang/reflect/TypeVariable;->getName()Ljava/lang/String;

    move-result-object v1

    .line 838
    invoke-virtual {p2, v1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->findType(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 839
    if-nez v0, :cond_0

    .line 848
    invoke-interface {p1}, Ljava/lang/reflect/TypeVariable;->getBounds()[Ljava/lang/reflect/Type;

    move-result-object v0

    .line 863
    invoke-virtual {p2, v1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_addPlaceholder(Ljava/lang/String;)V

    .line 864
    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0
.end method

.method protected _fromWildcard(Ljava/lang/reflect/WildcardType;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 2

    .prologue
    .line 877
    invoke-interface {p1}, Ljava/lang/reflect/WildcardType;->getUpperBounds()[Ljava/lang/reflect/Type;

    move-result-object v0

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method protected declared-synchronized _hashMapSuperInterfaceChain(Lcom/fasterxml/jackson/databind/type/HierarchicType;)Lcom/fasterxml/jackson/databind/type/HierarchicType;
    .locals 2

    .prologue
    .line 1029
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_cachedHashMapType:Lcom/fasterxml/jackson/databind/type/HierarchicType;

    if-nez v0, :cond_0

    .line 1030
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->deepCloneWithoutSubtype()Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    .line 1031
    const-class v1, Ljava/util/Map;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_doFindSuperInterfaceChain(Lcom/fasterxml/jackson/databind/type/HierarchicType;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    .line 1032
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getSuperType()Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_cachedHashMapType:Lcom/fasterxml/jackson/databind/type/HierarchicType;

    .line 1034
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_cachedHashMapType:Lcom/fasterxml/jackson/databind/type/HierarchicType;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->deepCloneWithoutSubtype()Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    .line 1035
    invoke-virtual {p1, v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSuperType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V

    .line 1036
    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->setSubType(Lcom/fasterxml/jackson/databind/type/HierarchicType;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1037
    monitor-exit p0

    return-object p1

    .line 1029
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected _resolveVariableViaSubTypes(Lcom/fasterxml/jackson/databind/type/HierarchicType;Ljava/lang/String;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 4

    .prologue
    .line 911
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->isGeneric()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 912
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getTypeParameters()[Ljava/lang/reflect/TypeVariable;

    move-result-object v1

    .line 913
    const/4 v0, 0x0

    array-length v2, v1

    :goto_0
    if-ge v0, v2, :cond_2

    .line 914
    aget-object v3, v1, v0

    .line 915
    invoke-interface {v3}, Ljava/lang/reflect/TypeVariable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 917
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->asGeneric()Ljava/lang/reflect/ParameterizedType;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/reflect/ParameterizedType;->getActualTypeArguments()[Ljava/lang/reflect/Type;

    move-result-object v1

    aget-object v0, v1, v0

    .line 918
    instance-of v1, v0, Ljava/lang/reflect/TypeVariable;

    if-eqz v1, :cond_0

    .line 919
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getSubType()Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v1

    check-cast v0, Ljava/lang/reflect/TypeVariable;

    invoke-interface {v0}, Ljava/lang/reflect/TypeVariable;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v1, v0, p3}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_resolveVariableViaSubTypes(Lcom/fasterxml/jackson/databind/type/HierarchicType;Ljava/lang/String;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 926
    :goto_1
    return-object v0

    .line 922
    :cond_0
    invoke-virtual {p0, v0, p3}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_1

    .line 913
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 926
    :cond_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_1
.end method

.method protected _unknownType()Lcom/fasterxml/jackson/databind/JavaType;
    .locals 2

    .prologue
    .line 930
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    const-class v1, Ljava/lang/Object;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    return-object v0
.end method

.method public constructArrayType(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/ArrayType;
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 426
    invoke-static {p1, v0, v0}, Lcom/fasterxml/jackson/databind/type/ArrayType;->construct(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Object;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/type/ArrayType;

    move-result-object v0

    return-object v0
.end method

.method public constructArrayType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/ArrayType;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/ArrayType;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 416
    invoke-virtual {p0, p1, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {v0, v1, v1}, Lcom/fasterxml/jackson/databind/type/ArrayType;->construct(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Object;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/type/ArrayType;

    move-result-object v0

    return-object v0
.end method

.method public constructCollectionLikeType(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionLikeType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ")",
            "Lcom/fasterxml/jackson/databind/type/CollectionLikeType;"
        }
    .end annotation

    .prologue
    .line 466
    invoke-static {p1, p2}, Lcom/fasterxml/jackson/databind/type/CollectionLikeType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionLikeType;

    move-result-object v0

    return-object v0
.end method

.method public constructCollectionLikeType(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/CollectionLikeType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/CollectionLikeType;"
        }
    .end annotation

    .prologue
    .line 456
    invoke-virtual {p0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/databind/type/CollectionLikeType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionLikeType;

    move-result-object v0

    return-object v0
.end method

.method public constructCollectionType(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Ljava/util/Collection;",
            ">;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ")",
            "Lcom/fasterxml/jackson/databind/type/CollectionType;"
        }
    .end annotation

    .prologue
    .line 446
    invoke-static {p1, p2}, Lcom/fasterxml/jackson/databind/type/CollectionType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionType;

    move-result-object v0

    return-object v0
.end method

.method public constructCollectionType(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/CollectionType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Ljava/util/Collection;",
            ">;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/CollectionType;"
        }
    .end annotation

    .prologue
    .line 436
    invoke-virtual {p0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/databind/type/CollectionType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionType;

    move-result-object v0

    return-object v0
.end method

.method public constructFromCanonical(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 219
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_parser:Lcom/fasterxml/jackson/databind/type/TypeParser;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/type/TypeParser;->parse(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method public constructMapLikeType(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapLikeType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ")",
            "Lcom/fasterxml/jackson/databind/type/MapLikeType;"
        }
    .end annotation

    .prologue
    .line 496
    invoke-static {p1, p2, p3}, Lcom/fasterxml/jackson/databind/type/MapLikeType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapLikeType;

    move-result-object v0

    return-object v0
.end method

.method public constructMapLikeType(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/MapLikeType;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/MapLikeType;"
        }
    .end annotation

    .prologue
    .line 506
    invoke-virtual {p0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-virtual {p0, p3}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/fasterxml/jackson/databind/type/MapType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;

    move-result-object v0

    return-object v0
.end method

.method public constructMapType(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Ljava/util/Map;",
            ">;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ")",
            "Lcom/fasterxml/jackson/databind/type/MapType;"
        }
    .end annotation

    .prologue
    .line 476
    invoke-static {p1, p2, p3}, Lcom/fasterxml/jackson/databind/type/MapType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;

    move-result-object v0

    return-object v0
.end method

.method public constructMapType(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/MapType;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Ljava/util/Map;",
            ">;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/MapType;"
        }
    .end annotation

    .prologue
    .line 486
    invoke-virtual {p0, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-virtual {p0, p3}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/fasterxml/jackson/databind/type/MapType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;

    move-result-object v0

    return-object v0
.end method

.method public varargs constructParametricType(Ljava/lang/Class;[Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;[",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ")",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 579
    invoke-virtual {p1}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 581
    array-length v0, p2

    if-eq v0, v3, :cond_0

    .line 582
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Need exactly 1 parameter type for arrays ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 584
    :cond_0
    aget-object v0, p2, v2

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructArrayType(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/ArrayType;

    move-result-object v0

    .line 600
    :goto_0
    return-object v0

    .line 586
    :cond_1
    const-class v0, Ljava/util/Map;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 587
    array-length v0, p2

    const/4 v1, 0x2

    if-eq v0, v1, :cond_2

    .line 588
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Need exactly 2 parameter types for Map types ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 590
    :cond_2
    aget-object v0, p2, v2

    aget-object v1, p2, v3

    invoke-virtual {p0, p1, v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructMapType(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;

    move-result-object v0

    goto :goto_0

    .line 592
    :cond_3
    const-class v0, Ljava/util/Collection;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 593
    array-length v0, p2

    if-eq v0, v3, :cond_4

    .line 594
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Need exactly 1 parameter type for Collection types ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 596
    :cond_4
    aget-object v0, p2, v2

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructCollectionType(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionType;

    move-result-object v0

    goto :goto_0

    .line 598
    :cond_5
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructSimpleType(Ljava/lang/Class;[Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0
.end method

.method public varargs constructParametricType(Ljava/lang/Class;[Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;[",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 553
    array-length v1, p2

    .line 554
    new-array v2, v1, [Lcom/fasterxml/jackson/databind/JavaType;

    .line 555
    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_0

    .line 556
    aget-object v3, p2, v0

    const/4 v4, 0x0

    invoke-virtual {p0, v3, v4}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_fromClass(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v3

    aput-object v3, v2, v0

    .line 555
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 558
    :cond_0
    invoke-virtual {p0, p1, v2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructParametricType(Ljava/lang/Class;[Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method public constructRawCollectionLikeType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/CollectionLikeType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/CollectionLikeType;"
        }
    .end annotation

    .prologue
    .line 637
    invoke-static {}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/databind/type/CollectionLikeType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionLikeType;

    move-result-object v0

    return-object v0
.end method

.method public constructRawCollectionType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/CollectionType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Ljava/util/Collection;",
            ">;)",
            "Lcom/fasterxml/jackson/databind/type/CollectionType;"
        }
    .end annotation

    .prologue
    .line 622
    invoke-static {}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/databind/type/CollectionType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/CollectionType;

    move-result-object v0

    return-object v0
.end method

.method public constructRawMapLikeType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/MapLikeType;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/type/MapLikeType;"
        }
    .end annotation

    .prologue
    .line 667
    invoke-static {}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/fasterxml/jackson/databind/type/MapLikeType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapLikeType;

    move-result-object v0

    return-object v0
.end method

.method public constructRawMapType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/MapType;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Ljava/util/Map;",
            ">;)",
            "Lcom/fasterxml/jackson/databind/type/MapType;"
        }
    .end annotation

    .prologue
    .line 652
    invoke-static {}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-static {}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->unknownType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/fasterxml/jackson/databind/type/MapType;->construct(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/type/MapType;

    move-result-object v0

    return-object v0
.end method

.method public constructSimpleType(Ljava/lang/Class;[Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;[",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ")",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v6, 0x0

    .line 515
    invoke-virtual {p1}, Ljava/lang/Class;->getTypeParameters()[Ljava/lang/reflect/TypeVariable;

    move-result-object v1

    .line 516
    array-length v0, v1

    array-length v2, p2

    if-eq v0, v2, :cond_0

    .line 517
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Parameter type mismatch for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ": expected "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    array-length v1, v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " parameters, was given "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    array-length v2, p2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 520
    :cond_0
    array-length v0, v1

    new-array v2, v0, [Ljava/lang/String;

    .line 521
    array-length v3, v1

    move v0, v6

    :goto_0
    if-ge v0, v3, :cond_1

    .line 522
    aget-object v5, v1, v0

    invoke-interface {v5}, Ljava/lang/reflect/TypeVariable;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v0

    .line 521
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 524
    :cond_1
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    move-object v1, p1

    move-object v3, p2

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;[Ljava/lang/String;[Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Object;Ljava/lang/Object;Z)V

    .line 525
    return-object v0
.end method

.method public constructSpecializedType(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 176
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    if-ne v0, p2, :cond_0

    .line 204
    :goto_0
    return-object p1

    .line 180
    :cond_0
    instance-of v0, p1, Lcom/fasterxml/jackson/databind/type/SimpleType;

    if-eqz v0, :cond_5

    .line 182
    invoke-virtual {p2}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-nez v0, :cond_1

    const-class v0, Ljava/util/Map;

    invoke-virtual {v0, p2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_1

    const-class v0, Ljava/util/Collection;

    invoke-virtual {v0, p2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 186
    :cond_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 187
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Class "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " not subtype of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 190
    :cond_2
    new-instance v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Ljava/lang/Class;)V

    invoke-virtual {p0, p2, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_fromClass(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 192
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getValueHandler()Ljava/lang/Object;

    move-result-object v1

    .line 193
    if-eqz v1, :cond_3

    .line 194
    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/JavaType;->withValueHandler(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 196
    :cond_3
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getTypeHandler()Ljava/lang/Object;

    move-result-object v1

    .line 197
    if-eqz v1, :cond_4

    .line 198
    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/JavaType;->withTypeHandler(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    :cond_4
    move-object p1, v0

    .line 200
    goto :goto_0

    .line 204
    :cond_5
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/databind/JavaType;->narrowBy(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object p1

    goto :goto_0
.end method

.method public constructType(Lcom/fasterxml/jackson/core/type/TypeReference;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/type/TypeReference",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 345
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/type/TypeReference;->getType()Ljava/lang/reflect/Type;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method public constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 337
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method public constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 354
    if-nez p2, :cond_0

    const/4 v0, 0x0

    .line 355
    :goto_0
    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0

    .line 354
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;

    invoke-direct {v0, p0, p2}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Lcom/fasterxml/jackson/databind/JavaType;)V

    goto :goto_0
.end method

.method public constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 341
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method public constructType(Ljava/lang/reflect/Type;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/reflect/Type;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 349
    if-nez p2, :cond_0

    const/4 v0, 0x0

    .line 350
    :goto_0
    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0

    .line 349
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;

    invoke-direct {v0, p0, p2}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Ljava/lang/Class;)V

    goto :goto_0
.end method

.method public findTypeParameters(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Class;)[Lcom/fasterxml/jackson/databind/JavaType;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Ljava/lang/Class",
            "<*>;)[",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 241
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    .line 242
    if-ne v0, p2, :cond_2

    .line 244
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->containedTypeCount()I

    move-result v2

    .line 245
    if-nez v2, :cond_1

    const/4 v0, 0x0

    .line 258
    :cond_0
    :goto_0
    return-object v0

    .line 246
    :cond_1
    new-array v0, v2, [Lcom/fasterxml/jackson/databind/JavaType;

    .line 247
    const/4 v1, 0x0

    :goto_1
    if-ge v1, v2, :cond_0

    .line 248
    invoke-virtual {p1, v1}, Lcom/fasterxml/jackson/databind/JavaType;->containedType(I)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v3

    aput-object v3, v0, v1

    .line 247
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 258
    :cond_2
    new-instance v1, Lcom/fasterxml/jackson/databind/type/TypeBindings;

    invoke-direct {v1, p0, p1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Lcom/fasterxml/jackson/databind/JavaType;)V

    invoke-virtual {p0, v0, p2, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->findTypeParameters(Ljava/lang/Class;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/type/TypeBindings;)[Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0
.end method

.method public findTypeParameters(Ljava/lang/Class;Ljava/lang/Class;)[Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)[",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 262
    new-instance v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;

    invoke-direct {v0, p0, p1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Ljava/lang/Class;)V

    invoke-virtual {p0, p1, p2, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->findTypeParameters(Ljava/lang/Class;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/type/TypeBindings;)[Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method public findTypeParameters(Ljava/lang/Class;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/type/TypeBindings;)[Lcom/fasterxml/jackson/databind/JavaType;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/type/TypeBindings;",
            ")[",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 268
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_findSuperTypeChain(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    .line 270
    if-nez v0, :cond_1

    .line 271
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Class "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is not a subtype of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    move-object p3, v1

    .line 275
    :cond_1
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getSuperType()Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 276
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getSuperType()Lcom/fasterxml/jackson/databind/type/HierarchicType;

    move-result-object v0

    .line 277
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->getRawClass()Ljava/lang/Class;

    move-result-object v2

    .line 278
    new-instance v1, Lcom/fasterxml/jackson/databind/type/TypeBindings;

    invoke-direct {v1, p0, v2}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Ljava/lang/Class;)V

    .line 279
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->isGeneric()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 280
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->asGeneric()Ljava/lang/reflect/ParameterizedType;

    move-result-object v3

    .line 281
    invoke-interface {v3}, Ljava/lang/reflect/ParameterizedType;->getActualTypeArguments()[Ljava/lang/reflect/Type;

    move-result-object v3

    .line 282
    invoke-virtual {v2}, Ljava/lang/Class;->getTypeParameters()[Ljava/lang/reflect/TypeVariable;

    move-result-object v4

    .line 283
    array-length v5, v3

    .line 284
    const/4 v2, 0x0

    :goto_0
    if-ge v2, v5, :cond_0

    .line 285
    aget-object v6, v4, v2

    invoke-interface {v6}, Ljava/lang/reflect/TypeVariable;->getName()Ljava/lang/String;

    move-result-object v6

    .line 286
    aget-object v7, v3, v2

    invoke-virtual {p0, v7, p3}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v7

    .line 287
    invoke-virtual {v1, v6, v7}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->addBinding(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 284
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 294
    :cond_2
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/type/HierarchicType;->isGeneric()Z

    move-result v0

    if-nez v0, :cond_3

    .line 295
    const/4 v0, 0x0

    .line 297
    :goto_1
    return-object v0

    :cond_3
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->typesAsArray()[Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_1
.end method

.method public moreSpecificType(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 2

    .prologue
    .line 312
    if-nez p1, :cond_1

    move-object p1, p2

    .line 327
    :cond_0
    :goto_0
    return-object p1

    .line 315
    :cond_1
    if-eqz p2, :cond_0

    .line 318
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    .line 319
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    .line 320
    if-eq v0, v1, :cond_0

    .line 324
    invoke-virtual {v0, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_0

    move-object p1, p2

    .line 325
    goto :goto_0
.end method

.method public uncheckedSimpleType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 536
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    return-object v0
.end method

.method public withModifier(Lcom/fasterxml/jackson/databind/type/TypeModifier;)Lcom/fasterxml/jackson/databind/type/TypeFactory;
    .locals 4

    .prologue
    .line 118
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_modifiers:[Lcom/fasterxml/jackson/databind/type/TypeModifier;

    if-nez v0, :cond_0

    .line 119
    new-instance v0, Lcom/fasterxml/jackson/databind/type/TypeFactory;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_parser:Lcom/fasterxml/jackson/databind/type/TypeParser;

    const/4 v2, 0x1

    new-array v2, v2, [Lcom/fasterxml/jackson/databind/type/TypeModifier;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-direct {v0, v1, v2}, Lcom/fasterxml/jackson/databind/type/TypeFactory;-><init>(Lcom/fasterxml/jackson/databind/type/TypeParser;[Lcom/fasterxml/jackson/databind/type/TypeModifier;)V

    .line 121
    :goto_0
    return-object v0

    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/type/TypeFactory;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_parser:Lcom/fasterxml/jackson/databind/type/TypeParser;

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_modifiers:[Lcom/fasterxml/jackson/databind/type/TypeModifier;

    invoke-static {v0, p1}, Lcom/fasterxml/jackson/databind/util/ArrayBuilders;->insertInListNoDup([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/fasterxml/jackson/databind/type/TypeModifier;

    invoke-direct {v1, v2, v0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;-><init>(Lcom/fasterxml/jackson/databind/type/TypeParser;[Lcom/fasterxml/jackson/databind/type/TypeModifier;)V

    move-object v0, v1

    goto :goto_0
.end method
