.class public final Lcom/amazon/identity/auth/device/utils/GenericUtils;
.super Ljava/lang/Object;
.source "GenericUtils.java"


# static fields
.field private static final CLONEABLE_TO_CLONE_METHOD:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap",
            "<",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/reflect/Method;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/auth/device/utils/GenericUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/GenericUtils;->TAG:Ljava/lang/String;

    .line 13
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/GenericUtils;->CLONEABLE_TO_CLONE_METHOD:Ljava/util/WeakHashMap;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method

.method private static declared-synchronized clone(Ljava/lang/Cloneable;)Ljava/lang/Object;
    .locals 9
    .param p0, "obj"    # Ljava/lang/Cloneable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 73
    const-class v5, Lcom/amazon/identity/auth/device/utils/GenericUtils;

    monitor-enter v5

    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 74
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v4, Lcom/amazon/identity/auth/device/utils/GenericUtils;->CLONEABLE_TO_CLONE_METHOD:Ljava/util/WeakHashMap;

    invoke-virtual {v4, v0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/reflect/Method;

    .line 75
    .local v1, "cloneMethod":Ljava/lang/reflect/Method;
    if-nez v1, :cond_0

    .line 77
    const-string/jumbo v4, "clone"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Class;

    invoke-virtual {v0, v4, v6}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 78
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    .line 80
    sget-object v4, Lcom/amazon/identity/auth/device/utils/GenericUtils;->CLONEABLE_TO_CLONE_METHOD:Ljava/util/WeakHashMap;

    invoke-virtual {v4, v0, v1}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    :cond_0
    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, p0, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v4

    monitor-exit v5

    return-object v4

    .line 85
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "cloneMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v2

    .line 87
    .local v2, "e":Ljava/lang/Exception;
    :try_start_1
    const-string/jumbo v4, "Clone method failed on the object of type %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 89
    .local v3, "errorMsg":Ljava/lang/String;
    sget-object v4, Lcom/amazon/identity/auth/device/utils/GenericUtils;->TAG:Ljava/lang/String;

    invoke-static {v4, v3, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 90
    new-instance v4, Ljava/lang/CloneNotSupportedException;

    invoke-direct {v4, v3}, Ljava/lang/CloneNotSupportedException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 73
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v3    # "errorMsg":Ljava/lang/String;
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4
.end method

.method public static cloneMap(Ljava/util/Map;)Ljava/util/Map;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/amazon/identity/auth/device/utils/PublicCloneable",
            "<TT;>;>(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "TT;>;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "TT;>;"
        }
    .end annotation

    .prologue
    .line 96
    .local p0, "keyToValueLookup":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;TT;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 97
    .local v0, "clonedLookup":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;TT;>;"
    invoke-interface {p0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 99
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;TT;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/identity/auth/device/utils/PublicCloneable;

    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->cloneObject(Lcom/amazon/identity/auth/device/utils/PublicCloneable;)Lcom/amazon/identity/auth/device/utils/PublicCloneable;

    move-result-object v1

    .line 100
    .local v1, "clonedValue":Lcom/amazon/identity/auth/device/utils/PublicCloneable;, "TT;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v0, v4, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 103
    .end local v1    # "clonedValue":Lcom/amazon/identity/auth/device/utils/PublicCloneable;, "TT;"
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;TT;>;"
    :cond_0
    return-object v0
.end method

.method public static cloneObject(Lcom/amazon/identity/auth/device/utils/PublicCloneable;)Lcom/amazon/identity/auth/device/utils/PublicCloneable;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/amazon/identity/auth/device/utils/PublicCloneable",
            "<TT;>;>(TT;)TT;"
        }
    .end annotation

    .prologue
    .line 108
    .local p0, "item":Lcom/amazon/identity/auth/device/utils/PublicCloneable;, "TT;"
    if-nez p0, :cond_0

    .line 110
    const/4 v0, 0x0

    .line 113
    :goto_0
    return-object v0

    :cond_0
    invoke-interface {p0}, Lcom/amazon/identity/auth/device/utils/PublicCloneable;->cloneObject()Lcom/amazon/identity/auth/device/utils/PublicCloneable;

    move-result-object v0

    goto :goto_0
.end method

.method public static equals(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 3
    .param p0, "obj1"    # Ljava/lang/Object;
    .param p1, "obj2"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x0

    .line 21
    if-nez p0, :cond_1

    .line 23
    if-nez p1, :cond_0

    const/4 v0, 0x1

    .line 31
    :cond_0
    :goto_0
    return v0

    .line 26
    :cond_1
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    if-ne v1, v2, :cond_0

    .line 31
    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public static typeSafeClone(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 40
    .local p0, "obj":Ljava/lang/Object;, "TT;"
    if-nez p0, :cond_1

    .line 42
    const/4 p0, 0x0

    .line 63
    .end local p0    # "obj":Ljava/lang/Object;, "TT;"
    :cond_0
    :goto_0
    return-object p0

    .line 45
    .restart local p0    # "obj":Ljava/lang/Object;, "TT;"
    :cond_1
    instance-of v0, p0, Lcom/amazon/identity/auth/device/utils/PublicCloneable;

    if-eqz v0, :cond_2

    .line 47
    check-cast p0, Lcom/amazon/identity/auth/device/utils/PublicCloneable;

    .end local p0    # "obj":Ljava/lang/Object;, "TT;"
    invoke-interface {p0}, Lcom/amazon/identity/auth/device/utils/PublicCloneable;->cloneObject()Lcom/amazon/identity/auth/device/utils/PublicCloneable;

    move-result-object p0

    goto :goto_0

    .line 53
    .restart local p0    # "obj":Ljava/lang/Object;, "TT;"
    :cond_2
    instance-of v0, p0, Ljava/lang/String;

    if-nez v0, :cond_0

    .line 57
    instance-of v0, p0, Ljava/lang/Integer;

    if-nez v0, :cond_0

    .line 61
    instance-of v0, p0, Ljava/lang/Cloneable;

    if-eqz v0, :cond_3

    .line 63
    check-cast p0, Ljava/lang/Cloneable;

    .end local p0    # "obj":Ljava/lang/Object;, "TT;"
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->clone(Ljava/lang/Cloneable;)Ljava/lang/Object;

    move-result-object p0

    goto :goto_0

    .line 66
    .restart local p0    # "obj":Ljava/lang/Object;, "TT;"
    :cond_3
    new-instance v0, Ljava/lang/CloneNotSupportedException;

    const-string/jumbo v1, "Clone not supported on type %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/CloneNotSupportedException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
