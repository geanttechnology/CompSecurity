.class public abstract Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;
.super Lcom/fasterxml/jackson/databind/ser/std/StdScalarSerializer;
.source "DateTimeSerializerBase.java"

# interfaces
.implements Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/fasterxml/jackson/databind/ser/std/StdScalarSerializer",
        "<TT;>;",
        "Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;"
    }
.end annotation


# instance fields
.field protected final _customFormat:Ljava/text/DateFormat;

.field protected final _useTimestamp:Z


# direct methods
.method protected constructor <init>(Ljava/lang/Class;ZLjava/text/DateFormat;)V
    .locals 0
    .param p2, "useTimestamp"    # Z
    .param p3, "customFormat"    # Ljava/text/DateFormat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TT;>;Z",
            "Ljava/text/DateFormat;",
            ")V"
        }
    .end annotation

    .prologue
    .line 40
    .local p0, "this":Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;, "Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase<TT;>;"
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/ser/std/StdScalarSerializer;-><init>(Ljava/lang/Class;)V

    .line 41
    iput-boolean p2, p0, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->_useTimestamp:Z

    .line 42
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->_customFormat:Ljava/text/DateFormat;

    .line 43
    return-void
.end method


# virtual methods
.method protected abstract _timestamp(Ljava/lang/Object;)J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)J"
        }
    .end annotation
.end method

.method public acceptJsonFormatVisitor(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 3
    .param p1, "visitor"    # Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;
    .param p2, "typeHint"    # Lcom/fasterxml/jackson/databind/JavaType;

    .prologue
    .line 122
    .local p0, "this":Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;, "Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase<TT;>;"
    iget-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->_useTimestamp:Z

    .line 123
    .local v0, "asNumber":Z
    if-nez v0, :cond_0

    .line 124
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->_customFormat:Ljava/text/DateFormat;

    if-nez v1, :cond_0

    .line 125
    invoke-interface {p1}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->getProvider()Lcom/fasterxml/jackson/databind/SerializerProvider;

    move-result-object v1

    sget-object v2, Lcom/fasterxml/jackson/databind/SerializationFeature;->WRITE_DATES_AS_TIMESTAMPS:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v1, v2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v0

    .line 128
    :cond_0
    if-eqz v0, :cond_1

    .line 129
    invoke-interface {p1, p2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->expectNumberFormat(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonNumberFormatVisitor;

    move-result-object v1

    sget-object v2, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormat;->UTC_MILLISEC:Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormat;

    invoke-interface {v1, v2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonNumberFormatVisitor;->format(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormat;)V

    .line 133
    :goto_0
    return-void

    .line 131
    :cond_1
    invoke-interface {p1, p2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->expectStringFormat(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonStringFormatVisitor;

    move-result-object v1

    sget-object v2, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormat;->DATE_TIME:Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormat;

    invoke-interface {v1, v2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonStringFormatVisitor;->format(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormat;)V

    goto :goto_0
.end method

.method public createContextual(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 8
    .param p1, "prov"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p2, "property"    # Lcom/fasterxml/jackson/databind/BeanProperty;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/SerializerProvider;",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;, "Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase<TT;>;"
    const/4 v7, 0x0

    .line 51
    if-eqz p2, :cond_0

    .line 52
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v5

    invoke-interface {p2}, Lcom/fasterxml/jackson/databind/BeanProperty;->getMember()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findFormat(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/annotation/JsonFormat$Value;

    move-result-object v1

    .line 53
    .local v1, "format":Lcom/fasterxml/jackson/annotation/JsonFormat$Value;
    if-eqz v1, :cond_0

    .line 55
    invoke-virtual {v1}, Lcom/fasterxml/jackson/annotation/JsonFormat$Value;->getShape()Lcom/fasterxml/jackson/annotation/JsonFormat$Shape;

    move-result-object v5

    invoke-virtual {v5}, Lcom/fasterxml/jackson/annotation/JsonFormat$Shape;->isNumeric()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 56
    const/4 v5, 0x1

    const/4 v6, 0x0

    invoke-virtual {p0, v5, v6}, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->withFormat(ZLjava/text/DateFormat;)Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;

    move-result-object p0

    .line 88
    .end local v1    # "format":Lcom/fasterxml/jackson/annotation/JsonFormat$Value;
    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;, "Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase<TT;>;"
    :cond_0
    :goto_0
    return-object p0

    .line 59
    .restart local v1    # "format":Lcom/fasterxml/jackson/annotation/JsonFormat$Value;
    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;, "Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase<TT;>;"
    :cond_1
    invoke-virtual {v1}, Lcom/fasterxml/jackson/annotation/JsonFormat$Value;->getTimeZone()Ljava/util/TimeZone;

    move-result-object v4

    .line 60
    .local v4, "tz":Ljava/util/TimeZone;
    invoke-virtual {v1}, Lcom/fasterxml/jackson/annotation/JsonFormat$Value;->getPattern()Ljava/lang/String;

    move-result-object v3

    .line 61
    .local v3, "pattern":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_4

    .line 62
    invoke-virtual {v1}, Lcom/fasterxml/jackson/annotation/JsonFormat$Value;->getLocale()Ljava/util/Locale;

    move-result-object v2

    .line 63
    .local v2, "loc":Ljava/util/Locale;
    if-nez v2, :cond_2

    .line 64
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getLocale()Ljava/util/Locale;

    move-result-object v2

    .line 66
    :cond_2
    new-instance v0, Ljava/text/SimpleDateFormat;

    invoke-direct {v0, v3, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 67
    .local v0, "df":Ljava/text/SimpleDateFormat;
    if-nez v4, :cond_3

    .line 68
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getTimeZone()Ljava/util/TimeZone;

    move-result-object v4

    .line 70
    :cond_3
    invoke-virtual {v0, v4}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 71
    invoke-virtual {p0, v7, v0}, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->withFormat(ZLjava/text/DateFormat;)Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;

    move-result-object p0

    goto :goto_0

    .line 74
    .end local v0    # "df":Ljava/text/SimpleDateFormat;
    .end local v2    # "loc":Ljava/util/Locale;
    :cond_4
    if-eqz v4, :cond_0

    .line 75
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getConfig()Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v5

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/SerializationConfig;->getDateFormat()Ljava/text/DateFormat;

    move-result-object v0

    .line 77
    .local v0, "df":Ljava/text/DateFormat;
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    const-class v6, Lcom/fasterxml/jackson/databind/util/StdDateFormat;

    if-ne v5, v6, :cond_5

    .line 78
    invoke-static {v4}, Lcom/fasterxml/jackson/databind/util/StdDateFormat;->getISO8601Format(Ljava/util/TimeZone;)Ljava/text/DateFormat;

    move-result-object v0

    .line 84
    :goto_1
    invoke-virtual {p0, v7, v0}, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->withFormat(ZLjava/text/DateFormat;)Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;

    move-result-object p0

    goto :goto_0

    .line 81
    :cond_5
    invoke-virtual {v0}, Ljava/text/DateFormat;->clone()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "df":Ljava/text/DateFormat;
    check-cast v0, Ljava/text/DateFormat;

    .line 82
    .restart local v0    # "df":Ljava/text/DateFormat;
    invoke-virtual {v0, v4}, Ljava/text/DateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    goto :goto_1
.end method

.method public getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 3
    .param p1, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p2, "typeHint"    # Ljava/lang/reflect/Type;

    .prologue
    .line 109
    .local p0, "this":Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;, "Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase<TT;>;"
    iget-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->_useTimestamp:Z

    .line 110
    .local v0, "asNumber":Z
    if-nez v0, :cond_0

    .line 111
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->_customFormat:Ljava/text/DateFormat;

    if-nez v1, :cond_0

    .line 112
    sget-object v1, Lcom/fasterxml/jackson/databind/SerializationFeature;->WRITE_DATES_AS_TIMESTAMPS:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {p1, v1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v0

    .line 115
    :cond_0
    if-eqz v0, :cond_1

    const-string v1, "number"

    :goto_0
    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2}, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->createSchemaNode(Ljava/lang/String;Z)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v1

    return-object v1

    :cond_1
    const-string v1, "string"

    goto :goto_0
.end method

.method public isEmpty(Ljava/lang/Object;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    .prologue
    .line 100
    .local p0, "this":Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;, "Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase<TT;>;"
    .local p1, "value":Ljava/lang/Object;, "TT;"
    if-eqz p1, :cond_0

    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;->_timestamp(Ljava/lang/Object;)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public abstract serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lcom/fasterxml/jackson/core/JsonGenerator;",
            "Lcom/fasterxml/jackson/databind/SerializerProvider;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation
.end method

.method public abstract withFormat(ZLjava/text/DateFormat;)Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/text/DateFormat;",
            ")",
            "Lcom/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase",
            "<TT;>;"
        }
    .end annotation
.end method
