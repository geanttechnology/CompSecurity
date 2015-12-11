.class public Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;
.super Ljava/lang/Object;
.source "OptionalHandlerFactory.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final CLASS_NAME_DOM_DOCUMENT:Ljava/lang/String; = "org.w3c.dom.Node"

.field private static final CLASS_NAME_DOM_NODE:Ljava/lang/String; = "org.w3c.dom.Node"

.field private static final DESERIALIZERS_FOR_JAVAX_XML:Ljava/lang/String; = "com.fasterxml.jackson.databind.ext.CoreXMLDeserializers"

.field private static final DESERIALIZER_FOR_DOM_DOCUMENT:Ljava/lang/String; = "com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer"

.field private static final DESERIALIZER_FOR_DOM_NODE:Ljava/lang/String; = "com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer"

.field private static final PACKAGE_PREFIX_JAVAX_XML:Ljava/lang/String; = "javax.xml."

.field private static final SERIALIZERS_FOR_JAVAX_XML:Ljava/lang/String; = "com.fasterxml.jackson.databind.ext.CoreXMLSerializers"

.field private static final SERIALIZER_FOR_DOM_NODE:Ljava/lang/String; = "com.fasterxml.jackson.databind.ext.DOMSerializer"

.field public static final instance:Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;

.field private static final serialVersionUID:J = -0x62941eec3f7e11c0L


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    new-instance v0, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;-><init>()V

    sput-object v0, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->instance:Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private doesImplement(Ljava/lang/Class;Ljava/lang/String;)Z
    .locals 3
    .param p2, "classNameToImplement"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p1, "actualType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v1, 0x1

    .line 145
    move-object v0, p1

    .local v0, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    if-eqz v0, :cond_2

    .line 146
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 154
    :cond_0
    :goto_1
    return v1

    .line 150
    :cond_1
    invoke-direct {p0, v0, p2}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->hasInterface(Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 145
    invoke-virtual {v0}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v0

    goto :goto_0

    .line 154
    :cond_2
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private hasInterface(Ljava/lang/Class;Ljava/lang/String;)Z
    .locals 7
    .param p2, "interfaceToImplement"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v5, 0x1

    .line 159
    invoke-virtual {p1}, Ljava/lang/Class;->getInterfaces()[Ljava/lang/Class;

    move-result-object v3

    .line 160
    .local v3, "interfaces":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    move-object v0, v3

    .local v0, "arr$":[Ljava/lang/Class;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_2

    aget-object v2, v0, v1

    .line 161
    .local v2, "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 171
    .end local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    :goto_1
    return v5

    .line 160
    .restart local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 166
    .end local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_2
    move-object v0, v3

    array-length v4, v0

    const/4 v1, 0x0

    :goto_2
    if-ge v1, v4, :cond_3

    aget-object v2, v0, v1

    .line 167
    .restart local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0, v2, p2}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->hasInterface(Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 166
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 171
    .end local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_3
    const/4 v5, 0x0

    goto :goto_1
.end method

.method private hasInterfaceStartingWith(Ljava/lang/Class;Ljava/lang/String;)Z
    .locals 7
    .param p2, "prefix"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v5, 0x1

    .line 193
    invoke-virtual {p1}, Ljava/lang/Class;->getInterfaces()[Ljava/lang/Class;

    move-result-object v3

    .line 194
    .local v3, "interfaces":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    move-object v0, v3

    .local v0, "arr$":[Ljava/lang/Class;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_2

    aget-object v2, v0, v1

    .line 195
    .local v2, "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 205
    .end local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    :goto_1
    return v5

    .line 194
    .restart local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 200
    .end local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_2
    move-object v0, v3

    array-length v4, v0

    const/4 v1, 0x0

    :goto_2
    if-ge v1, v4, :cond_3

    aget-object v2, v0, v1

    .line 201
    .restart local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0, v2, p2}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->hasInterfaceStartingWith(Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 200
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 205
    .end local v2    # "iface":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_3
    const/4 v5, 0x0

    goto :goto_1
.end method

.method private hasSupertypeStartingWith(Ljava/lang/Class;Ljava/lang/String;)Z
    .locals 4
    .param p2, "prefix"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p1, "rawType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v2, 0x1

    .line 177
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v1

    .local v1, "supertype":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    if-eqz v1, :cond_2

    .line 178
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 188
    :cond_0
    :goto_1
    return v2

    .line 177
    :cond_1
    invoke-virtual {v1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v1

    goto :goto_0

    .line 183
    :cond_2
    move-object v0, p1

    .local v0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_2
    if-eqz v0, :cond_3

    .line 184
    invoke-direct {p0, v0, p2}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->hasInterfaceStartingWith(Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 183
    invoke-virtual {v0}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v0

    goto :goto_2

    .line 188
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method

.method private instantiate(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "className"    # Ljava/lang/String;

    .prologue
    .line 135
    :try_start_0
    invoke-static {p1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/LinkageError; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 140
    :goto_0
    return-object v0

    .line 139
    :catch_0
    move-exception v0

    .line 140
    :goto_1
    const/4 v0, 0x0

    goto :goto_0

    .line 137
    :catch_1
    move-exception v0

    goto :goto_1
.end method


# virtual methods
.method public findDeserializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/DeserializationConfig;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 10
    .param p1, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 88
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v7

    .line 89
    .local v7, "rawType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v7}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 92
    .local v0, "className":Ljava/lang/String;
    const-string v9, "javax.xml."

    invoke-virtual {v0, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_0

    const-string v9, "javax.xml."

    invoke-direct {p0, v7, v9}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->hasSupertypeStartingWith(Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 94
    :cond_0
    const-string v3, "com.fasterxml.jackson.databind.ext.CoreXMLDeserializers"

    .line 102
    .local v3, "factoryName":Ljava/lang/String;
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->instantiate(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    .line 103
    .local v5, "ob":Ljava/lang/Object;
    if-nez v5, :cond_4

    .line 123
    .end local v3    # "factoryName":Ljava/lang/String;
    .end local v5    # "ob":Ljava/lang/Object;
    :cond_1
    :goto_0
    return-object v8

    .line 95
    :cond_2
    const-string v9, "org.w3c.dom.Node"

    invoke-direct {p0, v7, v9}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->doesImplement(Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 96
    const-string v8, "com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer"

    invoke-direct {p0, v8}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->instantiate(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    goto :goto_0

    .line 97
    :cond_3
    const-string v9, "org.w3c.dom.Node"

    invoke-direct {p0, v7, v9}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->doesImplement(Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 98
    const-string v8, "com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer"

    invoke-direct {p0, v8}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->instantiate(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    goto :goto_0

    .restart local v3    # "factoryName":Ljava/lang/String;
    .restart local v5    # "ob":Ljava/lang/Object;
    :cond_4
    move-object v6, v5

    .line 107
    check-cast v6, Lcom/fasterxml/jackson/databind/util/Provider;

    .line 108
    .local v6, "prov":Lcom/fasterxml/jackson/databind/util/Provider;, "Lcom/fasterxml/jackson/databind/util/Provider<Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;>;"
    invoke-interface {v6}, Lcom/fasterxml/jackson/databind/util/Provider;->provide()Ljava/util/Collection;

    move-result-object v2

    .line 111
    .local v2, "entries":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;>;"
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_5
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_6

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;

    .line 112
    .local v1, "deser":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;"
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getValueClass()Ljava/lang/Class;

    move-result-object v9

    if-ne v7, v9, :cond_5

    move-object v8, v1

    .line 113
    goto :goto_0

    .line 117
    .end local v1    # "deser":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;"
    :cond_6
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_7
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;

    .line 118
    .restart local v1    # "deser":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<*>;"
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getValueClass()Ljava/lang/Class;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v9

    if-eqz v9, :cond_7

    move-object v8, v1

    .line 119
    goto :goto_0
.end method

.method public findSerializer(Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 10
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/SerializationConfig;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/SerializationConfig;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;"
        }
    .end annotation

    .prologue
    const/4 v9, 0x0

    .line 49
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v7

    .line 50
    .local v7, "rawType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v7}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 53
    .local v0, "className":Ljava/lang/String;
    const-string v8, "javax.xml."

    invoke-virtual {v0, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    const-string v8, "javax.xml."

    invoke-direct {p0, v7, v8}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->hasSupertypeStartingWith(Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 55
    :cond_0
    const-string v3, "com.fasterxml.jackson.databind.ext.CoreXMLSerializers"

    .line 62
    .local v3, "factoryName":Ljava/lang/String;
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->instantiate(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    .line 63
    .local v5, "ob":Ljava/lang/Object;
    if-nez v5, :cond_3

    move-object v8, v9

    .line 83
    .end local v3    # "factoryName":Ljava/lang/String;
    .end local v5    # "ob":Ljava/lang/Object;
    :goto_0
    return-object v8

    .line 56
    :cond_1
    const-string v8, "org.w3c.dom.Node"

    invoke-direct {p0, v7, v8}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->doesImplement(Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 57
    const-string v8, "com.fasterxml.jackson.databind.ext.DOMSerializer"

    invoke-direct {p0, v8}, Lcom/fasterxml/jackson/databind/ext/OptionalHandlerFactory;->instantiate(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/fasterxml/jackson/databind/JsonSerializer;

    goto :goto_0

    :cond_2
    move-object v8, v9

    .line 59
    goto :goto_0

    .restart local v3    # "factoryName":Ljava/lang/String;
    .restart local v5    # "ob":Ljava/lang/Object;
    :cond_3
    move-object v6, v5

    .line 67
    check-cast v6, Lcom/fasterxml/jackson/databind/util/Provider;

    .line 68
    .local v6, "prov":Lcom/fasterxml/jackson/databind/util/Provider;, "Lcom/fasterxml/jackson/databind/util/Provider<Ljava/util/Map$Entry<Ljava/lang/Class<*>;Lcom/fasterxml/jackson/databind/JsonSerializer<*>;>;>;"
    invoke-interface {v6}, Lcom/fasterxml/jackson/databind/util/Provider;->provide()Ljava/util/Collection;

    move-result-object v1

    .line 71
    .local v1, "entries":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map$Entry<Ljava/lang/Class<*>;Lcom/fasterxml/jackson/databind/JsonSerializer<*>;>;>;"
    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_4
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_5

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 72
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Class<*>;Lcom/fasterxml/jackson/databind/JsonSerializer<*>;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v8

    if-ne v7, v8, :cond_4

    .line 73
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/fasterxml/jackson/databind/JsonSerializer;

    goto :goto_0

    .line 77
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Class<*>;Lcom/fasterxml/jackson/databind/JsonSerializer<*>;>;"
    :cond_5
    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_6
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_7

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 78
    .restart local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Class<*>;Lcom/fasterxml/jackson/databind/JsonSerializer<*>;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Class;

    invoke-virtual {v8, v7}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 79
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/fasterxml/jackson/databind/JsonSerializer;

    goto :goto_0

    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Class<*>;Lcom/fasterxml/jackson/databind/JsonSerializer<*>;>;"
    :cond_7
    move-object v8, v9

    .line 83
    goto :goto_0
.end method
