.class public Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;
.super Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer;
.source "EnumDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer$FactoryBasedDeserializer;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer",
        "<",
        "Ljava/lang/Enum",
        "<*>;>;"
    }
.end annotation


# instance fields
.field protected final _resolver:Lcom/fasterxml/jackson/databind/util/EnumResolver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/util/EnumResolver",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/util/EnumResolver;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/util/EnumResolver",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p1, "res":Lcom/fasterxml/jackson/databind/util/EnumResolver;, "Lcom/fasterxml/jackson/databind/util/EnumResolver<*>;"
    const-class v0, Ljava/lang/Enum;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer;-><init>(Ljava/lang/Class;)V

    .line 28
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;->_resolver:Lcom/fasterxml/jackson/databind/util/EnumResolver;

    .line 29
    return-void
.end method

.method public static deserializerForCreator(Lcom/fasterxml/jackson/databind/DeserializationConfig;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 4
    .param p0, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p2, "factory"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationConfig;",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 43
    .local p1, "enumClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v1, 0x0

    invoke-virtual {p2, v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getRawParameterType(I)Ljava/lang/Class;

    move-result-object v0

    .line 44
    .local v0, "paramClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v1, Ljava/lang/String;

    if-ne v0, v1, :cond_1

    .line 45
    const/4 v0, 0x0

    .line 54
    :goto_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->canOverrideAccessModifiers()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 55
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getMember()Ljava/lang/reflect/Method;

    move-result-object v1

    invoke-static {v1}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->checkAndFixAccess(Ljava/lang/reflect/Member;)V

    .line 57
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer$FactoryBasedDeserializer;

    invoke-direct {v1, p1, p2, v0}, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer$FactoryBasedDeserializer;-><init>(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;Ljava/lang/Class;)V

    return-object v1

    .line 46
    :cond_1
    sget-object v1, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    if-eq v0, v1, :cond_2

    const-class v1, Ljava/lang/Integer;

    if-ne v0, v1, :cond_3

    .line 47
    :cond_2
    const-class v0, Ljava/lang/Integer;

    goto :goto_0

    .line 48
    :cond_3
    sget-object v1, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    if-eq v0, v1, :cond_4

    const-class v1, Ljava/lang/Long;

    if-ne v0, v1, :cond_5

    .line 49
    :cond_4
    const-class v0, Ljava/lang/Long;

    goto :goto_0

    .line 51
    :cond_5
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Parameter #0 type for factory method ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") not suitable, must be java.lang.String or int/Integer/long/Long"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method public deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Enum;
    .locals 9
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            ")",
            "Ljava/lang/Enum",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 77
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 80
    .local v0, "curr":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v5, :cond_0

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v5, :cond_2

    .line 81
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    .line 82
    .local v2, "name":Ljava/lang/String;
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;->_resolver:Lcom/fasterxml/jackson/databind/util/EnumResolver;

    invoke-virtual {v5, v2}, Lcom/fasterxml/jackson/databind/util/EnumResolver;->findEnum(Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v3

    .line 83
    .local v3, "result":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    if-nez v3, :cond_1

    sget-object v5, Lcom/fasterxml/jackson/databind/DeserializationFeature;->READ_UNKNOWN_ENUM_VALUES_AS_NULL:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v5}, Lcom/fasterxml/jackson/databind/DeserializationContext;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 84
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;->_resolver:Lcom/fasterxml/jackson/databind/util/EnumResolver;

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/util/EnumResolver;->getEnumClass()Ljava/lang/Class;

    move-result-object v5

    const-string v6, "value not one of declared Enum instance names"

    invoke-virtual {p2, v2, v5, v6}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5

    :cond_1
    move-object v4, v3

    .line 104
    .end local v2    # "name":Ljava/lang/String;
    .end local v3    # "result":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    .local v4, "result":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    :goto_0
    return-object v4

    .line 90
    .end local v4    # "result":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    :cond_2
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v5, :cond_5

    .line 94
    sget-object v5, Lcom/fasterxml/jackson/databind/DeserializationFeature;->FAIL_ON_NUMBERS_FOR_ENUMS:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v5}, Lcom/fasterxml/jackson/databind/DeserializationContext;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 95
    const-string v5, "Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)"

    invoke-virtual {p2, v5}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5

    .line 98
    :cond_3
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v1

    .line 99
    .local v1, "index":I
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;->_resolver:Lcom/fasterxml/jackson/databind/util/EnumResolver;

    invoke-virtual {v5, v1}, Lcom/fasterxml/jackson/databind/util/EnumResolver;->getEnum(I)Ljava/lang/Enum;

    move-result-object v3

    .line 100
    .restart local v3    # "result":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    if-nez v3, :cond_4

    sget-object v5, Lcom/fasterxml/jackson/databind/DeserializationFeature;->READ_UNKNOWN_ENUM_VALUES_AS_NULL:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v5}, Lcom/fasterxml/jackson/databind/DeserializationContext;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 101
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;->_resolver:Lcom/fasterxml/jackson/databind/util/EnumResolver;

    invoke-virtual {v6}, Lcom/fasterxml/jackson/databind/util/EnumResolver;->getEnumClass()Ljava/lang/Class;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "index value outside legal index range [0.."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;->_resolver:Lcom/fasterxml/jackson/databind/util/EnumResolver;

    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/util/EnumResolver;->lastValidIndex()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "]"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p2, v5, v6, v7}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdNumberException(Ljava/lang/Number;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5

    :cond_4
    move-object v4, v3

    .line 104
    .end local v3    # "result":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    .restart local v4    # "result":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    goto :goto_0

    .line 106
    .end local v1    # "index":I
    .end local v4    # "result":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    :cond_5
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;->_resolver:Lcom/fasterxml/jackson/databind/util/EnumResolver;

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/util/EnumResolver;->getEnumClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {p2, v5}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5
.end method

.method public bridge synthetic deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "x1"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 20
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/EnumDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Enum;

    move-result-object v0

    return-object v0
.end method

.method public isCachable()Z
    .locals 1

    .prologue
    .line 71
    const/4 v0, 0x1

    return v0
.end method
