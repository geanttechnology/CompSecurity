.class public Lcom/comcast/cim/utils/JsonSerializer;
.super Ljava/lang/Object;
.source "JsonSerializer.java"


# instance fields
.field private final mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/utils/JsonSerializer;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 17
    return-void
.end method


# virtual methods
.method public serialize(Ljava/lang/Object;)Ljava/lang/String;
    .locals 5
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 21
    :try_start_0
    new-instance v3, Ljava/io/StringWriter;

    invoke-direct {v3}, Ljava/io/StringWriter;-><init>()V

    .line 22
    .local v3, "writer":Ljava/io/StringWriter;
    new-instance v1, Lcom/fasterxml/jackson/databind/MappingJsonFactory;

    iget-object v4, p0, Lcom/comcast/cim/utils/JsonSerializer;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v1, v4}, Lcom/fasterxml/jackson/databind/MappingJsonFactory;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    .line 23
    .local v1, "factory":Lcom/fasterxml/jackson/databind/MappingJsonFactory;
    invoke-virtual {v1, v3}, Lcom/fasterxml/jackson/databind/MappingJsonFactory;->createJsonGenerator(Ljava/io/Writer;)Lcom/fasterxml/jackson/core/JsonGenerator;

    move-result-object v2

    .line 24
    .local v2, "generator":Lcom/fasterxml/jackson/core/JsonGenerator;
    iget-object v4, p0, Lcom/comcast/cim/utils/JsonSerializer;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v4, v2, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V

    .line 26
    invoke-virtual {v3}, Ljava/io/StringWriter;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    return-object v4

    .line 28
    .end local v1    # "factory":Lcom/fasterxml/jackson/databind/MappingJsonFactory;
    .end local v2    # "generator":Lcom/fasterxml/jackson/core/JsonGenerator;
    .end local v3    # "writer":Ljava/io/StringWriter;
    :catch_0
    move-exception v0

    .line 29
    .local v0, "e":Ljava/io/IOException;
    new-instance v4, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v4, v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v4
.end method
