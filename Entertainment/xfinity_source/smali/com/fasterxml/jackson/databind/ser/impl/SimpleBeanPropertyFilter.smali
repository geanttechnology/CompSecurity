.class public abstract Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;
.super Ljava/lang/Object;
.source "SimpleBeanPropertyFilter.java"

# interfaces
.implements Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$SerializeExceptFilter;,
        Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$FilterExceptFilter;
    }
.end annotation


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static filterOutAllExcept(Ljava/util/Set;)Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "properties":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$FilterExceptFilter;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$FilterExceptFilter;-><init>(Ljava/util/Set;)V

    return-object v0
.end method

.method public static varargs filterOutAllExcept([Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;
    .locals 2
    .param p0, "propertyArray"    # [Ljava/lang/String;

    .prologue
    .line 37
    new-instance v0, Ljava/util/HashSet;

    array-length v1, p0

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    .line 38
    .local v0, "properties":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    invoke-static {v0, p0}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 39
    new-instance v1, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$FilterExceptFilter;

    invoke-direct {v1, v0}, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$FilterExceptFilter;-><init>(Ljava/util/Set;)V

    return-object v1
.end method

.method public static serializeAllExcept(Ljava/util/Set;)Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;"
        }
    .end annotation

    .prologue
    .line 43
    .local p0, "properties":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$SerializeExceptFilter;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$SerializeExceptFilter;-><init>(Ljava/util/Set;)V

    return-object v0
.end method

.method public static varargs serializeAllExcept([Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;
    .locals 2
    .param p0, "propertyArray"    # [Ljava/lang/String;

    .prologue
    .line 47
    new-instance v0, Ljava/util/HashSet;

    array-length v1, p0

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    .line 48
    .local v0, "properties":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    invoke-static {v0, p0}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 49
    new-instance v1, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$SerializeExceptFilter;

    invoke-direct {v1, v0}, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter$SerializeExceptFilter;-><init>(Ljava/util/Set;)V

    return-object v1
.end method


# virtual methods
.method public depositSchemaProperty(Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonObjectFormatVisitor;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 1
    .param p1, "writer"    # Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    .param p2, "objectVisitor"    # Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonObjectFormatVisitor;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 86
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;->include(Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 87
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->depositSchemaProperty(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonObjectFormatVisitor;)V

    .line 89
    :cond_0
    return-void
.end method

.method public depositSchemaProperty(Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;Lcom/fasterxml/jackson/databind/node/ObjectNode;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 1
    .param p1, "writer"    # Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    .param p2, "propertiesNode"    # Lcom/fasterxml/jackson/databind/node/ObjectNode;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 77
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;->include(Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    invoke-virtual {p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->depositSchemaProperty(Lcom/fasterxml/jackson/databind/node/ObjectNode;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 80
    :cond_0
    return-void
.end method

.method protected abstract include(Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;)Z
.end method

.method public serializeAsField(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;)V
    .locals 1
    .param p1, "bean"    # Ljava/lang/Object;
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p4, "writer"    # Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 67
    invoke-virtual {p0, p4}, Lcom/fasterxml/jackson/databind/ser/impl/SimpleBeanPropertyFilter;->include(Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    invoke-virtual {p4, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->serializeAsField(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 70
    :cond_0
    return-void
.end method
