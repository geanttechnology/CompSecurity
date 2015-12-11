.class public Lcom/fasterxml/jackson/databind/util/RootNameLookup;
.super Ljava/lang/Object;
.source "RootNameLookup.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field protected _rootNames:Lcom/fasterxml/jackson/databind/util/LRUMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/util/LRUMap",
            "<",
            "Lcom/fasterxml/jackson/databind/type/ClassKey;",
            "Lcom/fasterxml/jackson/core/io/SerializedString;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public findRootName(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/cfg/MapperConfig;)Lcom/fasterxml/jackson/core/io/SerializedString;
    .locals 1
    .param p1, "rootType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/cfg/MapperConfig",
            "<*>;)",
            "Lcom/fasterxml/jackson/core/io/SerializedString;"
        }
    .end annotation

    .prologue
    .line 28
    .local p2, "config":Lcom/fasterxml/jackson/databind/cfg/MapperConfig;, "Lcom/fasterxml/jackson/databind/cfg/MapperConfig<*>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/util/RootNameLookup;->findRootName(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/cfg/MapperConfig;)Lcom/fasterxml/jackson/core/io/SerializedString;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized findRootName(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/cfg/MapperConfig;)Lcom/fasterxml/jackson/core/io/SerializedString;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/cfg/MapperConfig",
            "<*>;)",
            "Lcom/fasterxml/jackson/core/io/SerializedString;"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "rootType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "config":Lcom/fasterxml/jackson/databind/cfg/MapperConfig;, "Lcom/fasterxml/jackson/databind/cfg/MapperConfig<*>;"
    monitor-enter p0

    :try_start_0
    new-instance v3, Lcom/fasterxml/jackson/databind/type/ClassKey;

    invoke-direct {v3, p1}, Lcom/fasterxml/jackson/databind/type/ClassKey;-><init>(Ljava/lang/Class;)V

    .line 35
    .local v3, "key":Lcom/fasterxml/jackson/databind/type/ClassKey;
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/util/RootNameLookup;->_rootNames:Lcom/fasterxml/jackson/databind/util/LRUMap;

    if-nez v7, :cond_2

    .line 36
    new-instance v7, Lcom/fasterxml/jackson/databind/util/LRUMap;

    const/16 v8, 0x14

    const/16 v9, 0xc8

    invoke-direct {v7, v8, v9}, Lcom/fasterxml/jackson/databind/util/LRUMap;-><init>(II)V

    iput-object v7, p0, Lcom/fasterxml/jackson/databind/util/RootNameLookup;->_rootNames:Lcom/fasterxml/jackson/databind/util/LRUMap;

    .line 43
    :cond_0
    invoke-virtual {p2, p1}, Lcom/fasterxml/jackson/databind/cfg/MapperConfig;->introspectClassAnnotations(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/BeanDescription;

    move-result-object v1

    .line 44
    .local v1, "beanDesc":Lcom/fasterxml/jackson/databind/BeanDescription;
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/cfg/MapperConfig;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v2

    .line 45
    .local v2, "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/BeanDescription;->getClassInfo()Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    move-result-object v0

    .line 46
    .local v0, "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findRootName(Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;)Lcom/fasterxml/jackson/databind/PropertyName;

    move-result-object v6

    .line 49
    .local v6, "pname":Lcom/fasterxml/jackson/databind/PropertyName;
    if-eqz v6, :cond_1

    invoke-virtual {v6}, Lcom/fasterxml/jackson/databind/PropertyName;->hasSimpleName()Z

    move-result v7

    if-nez v7, :cond_3

    .line 51
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    .line 55
    .local v5, "nameStr":Ljava/lang/String;
    :goto_0
    new-instance v4, Lcom/fasterxml/jackson/core/io/SerializedString;

    invoke-direct {v4, v5}, Lcom/fasterxml/jackson/core/io/SerializedString;-><init>(Ljava/lang/String;)V

    .line 56
    .local v4, "name":Lcom/fasterxml/jackson/core/io/SerializedString;
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/util/RootNameLookup;->_rootNames:Lcom/fasterxml/jackson/databind/util/LRUMap;

    invoke-virtual {v7, v3, v4}, Lcom/fasterxml/jackson/databind/util/LRUMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 57
    .end local v0    # "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    .end local v1    # "beanDesc":Lcom/fasterxml/jackson/databind/BeanDescription;
    .end local v2    # "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .end local v5    # "nameStr":Ljava/lang/String;
    .end local v6    # "pname":Lcom/fasterxml/jackson/databind/PropertyName;
    :goto_1
    monitor-exit p0

    return-object v4

    .line 38
    .end local v4    # "name":Lcom/fasterxml/jackson/core/io/SerializedString;
    :cond_2
    :try_start_1
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/util/RootNameLookup;->_rootNames:Lcom/fasterxml/jackson/databind/util/LRUMap;

    invoke-virtual {v7, v3}, Lcom/fasterxml/jackson/databind/util/LRUMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/fasterxml/jackson/core/io/SerializedString;

    .line 39
    .restart local v4    # "name":Lcom/fasterxml/jackson/core/io/SerializedString;
    if-eqz v4, :cond_0

    goto :goto_1

    .line 53
    .end local v4    # "name":Lcom/fasterxml/jackson/core/io/SerializedString;
    .restart local v0    # "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    .restart local v1    # "beanDesc":Lcom/fasterxml/jackson/databind/BeanDescription;
    .restart local v2    # "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .restart local v6    # "pname":Lcom/fasterxml/jackson/databind/PropertyName;
    :cond_3
    invoke-virtual {v6}, Lcom/fasterxml/jackson/databind/PropertyName;->getSimpleName()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    .restart local v5    # "nameStr":Ljava/lang/String;
    goto :goto_0

    .line 33
    .end local v0    # "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    .end local v1    # "beanDesc":Lcom/fasterxml/jackson/databind/BeanDescription;
    .end local v2    # "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .end local v3    # "key":Lcom/fasterxml/jackson/databind/type/ClassKey;
    .end local v5    # "nameStr":Ljava/lang/String;
    .end local v6    # "pname":Lcom/fasterxml/jackson/databind/PropertyName;
    :catchall_0
    move-exception v7

    monitor-exit p0

    throw v7
.end method
