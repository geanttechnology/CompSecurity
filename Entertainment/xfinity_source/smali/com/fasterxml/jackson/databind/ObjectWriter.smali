.class public Lcom/fasterxml/jackson/databind/ObjectWriter;
.super Ljava/lang/Object;
.source "ObjectWriter.java"

# interfaces
.implements Lcom/fasterxml/jackson/core/Versioned;
.implements Ljava/io/Serializable;


# static fields
.field protected static final NULL_PRETTY_PRINTER:Lcom/fasterxml/jackson/core/PrettyPrinter;

.field private static final serialVersionUID:J = -0x617d35a8b1013b0cL


# instance fields
.field protected final _config:Lcom/fasterxml/jackson/databind/SerializationConfig;

.field protected final _jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

.field protected final _prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

.field protected final _rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field protected final _rootType:Lcom/fasterxml/jackson/databind/JavaType;

.field protected final _schema:Lcom/fasterxml/jackson/core/FormatSchema;

.field protected final _serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

.field protected final _serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    new-instance v0, Lcom/fasterxml/jackson/core/util/MinimalPrettyPrinter;

    invoke-direct {v0}, Lcom/fasterxml/jackson/core/util/MinimalPrettyPrinter;-><init>()V

    sput-object v0, Lcom/fasterxml/jackson/databind/ObjectWriter;->NULL_PRETTY_PRINTER:Lcom/fasterxml/jackson/core/PrettyPrinter;

    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/databind/SerializationConfig;)V
    .locals 2
    .param p1, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/SerializationConfig;

    .prologue
    const/4 v1, 0x0

    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    .line 128
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    .line 129
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    .line 130
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    .line 132
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 133
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 134
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    .line 135
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    .line 136
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/core/FormatSchema;)V
    .locals 2
    .param p1, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/SerializationConfig;
    .param p3, "s"    # Lcom/fasterxml/jackson/core/FormatSchema;

    .prologue
    const/4 v1, 0x0

    .line 143
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 144
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    .line 146
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    .line 147
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    .line 148
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    .line 150
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 151
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 152
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    .line 153
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    .line 154
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/core/PrettyPrinter;)V
    .locals 1
    .param p1, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/SerializationConfig;
    .param p3, "rootType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p4, "pp"    # Lcom/fasterxml/jackson/core/PrettyPrinter;

    .prologue
    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 108
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    .line 110
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    .line 111
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    .line 112
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    .line 114
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 115
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    .line 116
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    .line 118
    invoke-virtual {p0, p2, p3}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prefetchRootSerializer(Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 119
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V
    .locals 1
    .param p1, "base"    # Lcom/fasterxml/jackson/databind/ObjectWriter;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/SerializationConfig;

    .prologue
    .line 179
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 180
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    .line 182
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    .line 183
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    .line 184
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    .line 185
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    .line 187
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 188
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 189
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    .line 190
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;Lcom/fasterxml/jackson/core/PrettyPrinter;Lcom/fasterxml/jackson/core/FormatSchema;)V
    .locals 1
    .param p1, "base"    # Lcom/fasterxml/jackson/databind/ObjectWriter;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/SerializationConfig;
    .param p3, "rootType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p5, "pp"    # Lcom/fasterxml/jackson/core/PrettyPrinter;
    .param p6, "s"    # Lcom/fasterxml/jackson/core/FormatSchema;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/ObjectWriter;",
            "Lcom/fasterxml/jackson/databind/SerializationConfig;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;",
            "Lcom/fasterxml/jackson/core/PrettyPrinter;",
            "Lcom/fasterxml/jackson/core/FormatSchema;",
            ")V"
        }
    .end annotation

    .prologue
    .line 162
    .local p4, "rootSer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 163
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    .line 165
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    .line 166
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    .line 167
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    .line 169
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 170
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 171
    iput-object p5, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    .line 172
    iput-object p6, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    .line 173
    return-void
.end method

.method private final _configureJsonGenerator(Lcom/fasterxml/jackson/core/JsonGenerator;)V
    .locals 3
    .param p1, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;

    .prologue
    .line 721
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    if-eqz v1, :cond_4

    .line 722
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    .line 723
    .local v0, "pp":Lcom/fasterxml/jackson/core/PrettyPrinter;
    sget-object v1, Lcom/fasterxml/jackson/databind/ObjectWriter;->NULL_PRETTY_PRINTER:Lcom/fasterxml/jackson/core/PrettyPrinter;

    if-ne v0, v1, :cond_2

    .line 724
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lcom/fasterxml/jackson/core/JsonGenerator;->setPrettyPrinter(Lcom/fasterxml/jackson/core/PrettyPrinter;)Lcom/fasterxml/jackson/core/JsonGenerator;

    .line 738
    .end local v0    # "pp":Lcom/fasterxml/jackson/core/PrettyPrinter;
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    if-eqz v1, :cond_1

    .line 739
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    invoke-virtual {p1, v1}, Lcom/fasterxml/jackson/core/JsonGenerator;->setSchema(Lcom/fasterxml/jackson/core/FormatSchema;)V

    .line 741
    :cond_1
    return-void

    .line 729
    .restart local v0    # "pp":Lcom/fasterxml/jackson/core/PrettyPrinter;
    :cond_2
    instance-of v1, v0, Lcom/fasterxml/jackson/core/util/Instantiatable;

    if-eqz v1, :cond_3

    .line 730
    check-cast v0, Lcom/fasterxml/jackson/core/util/Instantiatable;

    .end local v0    # "pp":Lcom/fasterxml/jackson/core/PrettyPrinter;
    invoke-interface {v0}, Lcom/fasterxml/jackson/core/util/Instantiatable;->createInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/core/PrettyPrinter;

    .line 732
    .restart local v0    # "pp":Lcom/fasterxml/jackson/core/PrettyPrinter;
    :cond_3
    invoke-virtual {p1, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->setPrettyPrinter(Lcom/fasterxml/jackson/core/PrettyPrinter;)Lcom/fasterxml/jackson/core/JsonGenerator;

    goto :goto_0

    .line 734
    .end local v0    # "pp":Lcom/fasterxml/jackson/core/PrettyPrinter;
    :cond_4
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    sget-object v2, Lcom/fasterxml/jackson/databind/SerializationFeature;->INDENT_OUTPUT:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v1, v2}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 735
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->useDefaultPrettyPrinter()Lcom/fasterxml/jackson/core/JsonGenerator;

    goto :goto_0
.end method

.method private final _writeCloseable(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/SerializationConfig;)V
    .locals 6
    .param p1, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "cfg"    # Lcom/fasterxml/jackson/databind/SerializationConfig;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;,
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 635
    move-object v2, p2

    check-cast v2, Ljava/io/Closeable;

    .line 637
    .local v2, "toClose":Ljava/io/Closeable;
    :try_start_0
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    if-nez v3, :cond_2

    .line 638
    invoke-virtual {p0, p3}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V

    .line 642
    :goto_0
    move-object v0, p1

    .line 643
    .local v0, "tmpJgen":Lcom/fasterxml/jackson/core/JsonGenerator;
    const/4 p1, 0x0

    .line 644
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->close()V

    .line 645
    move-object v1, v2

    .line 646
    .local v1, "tmpToClose":Ljava/io/Closeable;
    const/4 v2, 0x0

    .line 647
    invoke-interface {v1}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 652
    if-eqz p1, :cond_0

    .line 654
    :try_start_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 657
    :cond_0
    :goto_1
    if-eqz v2, :cond_1

    .line 659
    :try_start_2
    invoke-interface {v2}, Ljava/io/Closeable;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 663
    :cond_1
    :goto_2
    return-void

    .line 640
    .end local v0    # "tmpJgen":Lcom/fasterxml/jackson/core/JsonGenerator;
    .end local v1    # "tmpToClose":Ljava/io/Closeable;
    :cond_2
    :try_start_3
    invoke-virtual {p0, p3}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v3

    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    invoke-virtual {v3, p1, p2, v4, v5}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 652
    :catchall_0
    move-exception v3

    if-eqz p1, :cond_3

    .line 654
    :try_start_4
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 657
    :cond_3
    :goto_3
    if-eqz v2, :cond_4

    .line 659
    :try_start_5
    invoke-interface {v2}, Ljava/io/Closeable;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 660
    :cond_4
    :goto_4
    throw v3

    .line 655
    .restart local v0    # "tmpJgen":Lcom/fasterxml/jackson/core/JsonGenerator;
    .restart local v1    # "tmpToClose":Ljava/io/Closeable;
    :catch_0
    move-exception v3

    goto :goto_1

    .line 660
    :catch_1
    move-exception v3

    goto :goto_2

    .line 655
    .end local v0    # "tmpJgen":Lcom/fasterxml/jackson/core/JsonGenerator;
    .end local v1    # "tmpToClose":Ljava/io/Closeable;
    :catch_2
    move-exception v4

    goto :goto_3

    .line 660
    :catch_3
    move-exception v4

    goto :goto_4
.end method

.method private final _writeCloseableValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/SerializationConfig;)V
    .locals 5
    .param p1, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "cfg"    # Lcom/fasterxml/jackson/databind/SerializationConfig;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;,
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 672
    move-object v1, p2

    check-cast v1, Ljava/io/Closeable;

    .line 674
    .local v1, "toClose":Ljava/io/Closeable;
    :try_start_0
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    if-nez v2, :cond_2

    .line 675
    invoke-virtual {p0, p3}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V

    .line 679
    :goto_0
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    sget-object v3, Lcom/fasterxml/jackson/databind/SerializationFeature;->FLUSH_AFTER_WRITE_VALUE:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 680
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->flush()V

    .line 682
    :cond_0
    move-object v0, v1

    .line 683
    .local v0, "tmpToClose":Ljava/io/Closeable;
    const/4 v1, 0x0

    .line 684
    invoke-interface {v0}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 686
    if-eqz v1, :cond_1

    .line 688
    :try_start_1
    invoke-interface {v1}, Ljava/io/Closeable;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 692
    :cond_1
    :goto_1
    return-void

    .line 677
    .end local v0    # "tmpToClose":Ljava/io/Closeable;
    :cond_2
    :try_start_2
    invoke-virtual {p0, p3}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v2

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    invoke-virtual {v2, p1, p2, v3, v4}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 686
    :catchall_0
    move-exception v2

    if-eqz v1, :cond_3

    .line 688
    :try_start_3
    invoke-interface {v1}, Ljava/io/Closeable;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    .line 689
    :cond_3
    :goto_2
    throw v2

    .restart local v0    # "tmpToClose":Ljava/io/Closeable;
    :catch_0
    move-exception v2

    goto :goto_1

    .end local v0    # "tmpToClose":Ljava/io/Closeable;
    :catch_1
    move-exception v3

    goto :goto_2
.end method


# virtual methods
.method protected final _configAndWriteValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V
    .locals 4
    .param p1, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;,
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 601
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_configureJsonGenerator(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 603
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    sget-object v2, Lcom/fasterxml/jackson/databind/SerializationFeature;->CLOSE_CLOSEABLE:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v1, v2}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v1

    if-eqz v1, :cond_1

    instance-of v1, p2, Ljava/io/Closeable;

    if-eqz v1, :cond_1

    .line 604
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-direct {p0, p1, p2, v1}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_writeCloseable(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    .line 626
    :cond_0
    :goto_0
    return-void

    .line 607
    :cond_1
    const/4 v0, 0x0

    .line 609
    .local v0, "closed":Z
    :try_start_0
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    if-nez v1, :cond_2

    .line 610
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V

    .line 614
    :goto_1
    const/4 v0, 0x1

    .line 615
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 620
    if-nez v0, :cond_0

    .line 622
    :try_start_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 623
    :catch_0
    move-exception v1

    goto :goto_0

    .line 612
    :cond_2
    :try_start_2
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    invoke-virtual {v1, p1, p2, v2, v3}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 620
    :catchall_0
    move-exception v1

    if-nez v0, :cond_3

    .line 622
    :try_start_3
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    .line 623
    :cond_3
    :goto_2
    throw v1

    :catch_1
    move-exception v2

    goto :goto_2
.end method

.method protected final _prefetchRootSerializer(Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 5
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/SerializationConfig;
    .param p2, "valueType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/SerializationConfig;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 702
    if-eqz p2, :cond_0

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    sget-object v3, Lcom/fasterxml/jackson/databind/SerializationFeature;->EAGER_SERIALIZER_FETCH:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 709
    :cond_0
    :goto_0
    return-object v1

    .line 706
    :cond_1
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v2

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-virtual {v2, p2, v3, v4}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->findTypedValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;ZLcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    :try_end_0
    .catch Lcom/fasterxml/jackson/core/JsonProcessingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 707
    :catch_0
    move-exception v0

    .line 709
    .local v0, "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    goto :goto_0
.end method

.method protected _serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;
    .locals 2
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/SerializationConfig;

    .prologue
    .line 585
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider:Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    invoke-virtual {v0, p1, v1}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->createInstance(Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/ser/SerializerFactory;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v0

    return-object v0
.end method

.method public canSerialize(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 571
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->hasSerializerFor(Ljava/lang/Class;)Z

    move-result v0

    return v0
.end method

.method public getJsonFactory()Lcom/fasterxml/jackson/core/JsonFactory;
    .locals 1

    .prologue
    .line 430
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    return-object v0
.end method

.method public getTypeFactory()Lcom/fasterxml/jackson/databind/type/TypeFactory;
    .locals 1

    .prologue
    .line 434
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/SerializationConfig;->getTypeFactory()Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-result-object v0

    return-object v0
.end method

.method public isEnabled(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z
    .locals 1
    .param p1, "f"    # Lcom/fasterxml/jackson/core/JsonParser$Feature;

    .prologue
    .line 426
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/core/JsonFactory;->isEnabled(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    return v0
.end method

.method public isEnabled(Lcom/fasterxml/jackson/databind/MapperFeature;)Z
    .locals 1
    .param p1, "f"    # Lcom/fasterxml/jackson/databind/MapperFeature;

    .prologue
    .line 422
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/MapperFeature;)Z

    move-result v0

    return v0
.end method

.method public isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z
    .locals 1
    .param p1, "f"    # Lcom/fasterxml/jackson/databind/SerializationFeature;

    .prologue
    .line 418
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v0

    return v0
.end method

.method public version()Lcom/fasterxml/jackson/core/Version;
    .locals 1

    .prologue
    .line 198
    sget-object v0, Lcom/fasterxml/jackson/databind/cfg/DatabindVersion;->instance:Lcom/fasterxml/jackson/databind/cfg/DatabindVersion;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/cfg/DatabindVersion;->version()Lcom/fasterxml/jackson/core/Version;

    move-result-object v0

    return-object v0
.end method

.method public with(Lcom/fasterxml/jackson/core/Base64Variant;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "b64variant"    # Lcom/fasterxml/jackson/core/Base64Variant;

    .prologue
    .line 407
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->with(Lcom/fasterxml/jackson/core/Base64Variant;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 408
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public with(Lcom/fasterxml/jackson/core/PrettyPrinter;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 7
    .param p1, "pp"    # Lcom/fasterxml/jackson/core/PrettyPrinter;

    .prologue
    .line 310
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    if-ne p1, v0, :cond_0

    .line 317
    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .line 314
    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    if-nez p1, :cond_1

    .line 315
    sget-object p1, Lcom/fasterxml/jackson/databind/ObjectWriter;->NULL_PRETTY_PRINTER:Lcom/fasterxml/jackson/core/PrettyPrinter;

    .line 317
    :cond_1
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectWriter;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    iget-object v6, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    move-object v1, p0

    move-object v5, p1

    invoke-direct/range {v0 .. v6}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;Lcom/fasterxml/jackson/core/PrettyPrinter;Lcom/fasterxml/jackson/core/FormatSchema;)V

    move-object p0, v0

    goto :goto_0
.end method

.method public with(Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "feature"    # Lcom/fasterxml/jackson/databind/SerializationFeature;

    .prologue
    .line 213
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->with(Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 214
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public varargs with(Lcom/fasterxml/jackson/databind/SerializationFeature;[Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "first"    # Lcom/fasterxml/jackson/databind/SerializationFeature;
    .param p2, "other"    # [Lcom/fasterxml/jackson/databind/SerializationFeature;

    .prologue
    .line 224
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1, p2}, Lcom/fasterxml/jackson/databind/SerializationConfig;->with(Lcom/fasterxml/jackson/databind/SerializationFeature;[Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 225
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public with(Lcom/fasterxml/jackson/databind/ser/FilterProvider;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "filterProvider"    # Lcom/fasterxml/jackson/databind/ser/FilterProvider;

    .prologue
    .line 298
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/SerializationConfig;->getFilterProvider()Lcom/fasterxml/jackson/databind/ser/FilterProvider;

    move-result-object v0

    if-ne p1, v0, :cond_0

    .line 301
    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectWriter;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->withFilters(Lcom/fasterxml/jackson/databind/ser/FilterProvider;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v0

    goto :goto_0
.end method

.method public with(Ljava/text/DateFormat;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "df"    # Ljava/text/DateFormat;

    .prologue
    .line 279
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->with(Ljava/text/DateFormat;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 280
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public with(Ljava/util/Locale;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "l"    # Ljava/util/Locale;

    .prologue
    .line 391
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->with(Ljava/util/Locale;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 392
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public with(Ljava/util/TimeZone;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "tz"    # Ljava/util/TimeZone;

    .prologue
    .line 396
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->with(Ljava/util/TimeZone;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 397
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public withDefaultPrettyPrinter()Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 1

    .prologue
    .line 289
    new-instance v0, Lcom/fasterxml/jackson/core/util/DefaultPrettyPrinter;

    invoke-direct {v0}, Lcom/fasterxml/jackson/core/util/DefaultPrettyPrinter;-><init>()V

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;->with(Lcom/fasterxml/jackson/core/PrettyPrinter;)Lcom/fasterxml/jackson/databind/ObjectWriter;

    move-result-object v0

    return-object v0
.end method

.method public varargs withFeatures([Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "features"    # [Lcom/fasterxml/jackson/databind/SerializationFeature;

    .prologue
    .line 234
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->withFeatures([Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 235
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public withRootName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "rootName"    # Ljava/lang/String;

    .prologue
    .line 330
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->withRootName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 331
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public withSchema(Lcom/fasterxml/jackson/core/FormatSchema;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 7
    .param p1, "schema"    # Lcom/fasterxml/jackson/core/FormatSchema;

    .prologue
    .line 344
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    if-ne v0, p1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectWriter;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    move-object v1, p0

    move-object v6, p1

    invoke-direct/range {v0 .. v6}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;Lcom/fasterxml/jackson/core/PrettyPrinter;Lcom/fasterxml/jackson/core/FormatSchema;)V

    move-object p0, v0

    goto :goto_0
.end method

.method public withType(Lcom/fasterxml/jackson/core/type/TypeReference;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/type/TypeReference",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/ObjectWriter;"
        }
    .end annotation

    .prologue
    .line 374
    .local p1, "rootType":Lcom/fasterxml/jackson/core/type/TypeReference;, "Lcom/fasterxml/jackson/core/type/TypeReference<*>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/SerializationConfig;->getTypeFactory()Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-result-object v0

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/type/TypeReference;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;->withType(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/ObjectWriter;

    move-result-object v0

    return-object v0
.end method

.method public withType(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 7
    .param p1, "rootType"    # Lcom/fasterxml/jackson/databind/JavaType;

    .prologue
    .line 358
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {p0, v0, p1}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prefetchRootSerializer(Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v4

    .line 359
    .local v4, "rootSer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    if-ne p1, v0, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectWriter;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_prettyPrinter:Lcom/fasterxml/jackson/core/PrettyPrinter;

    iget-object v6, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_schema:Lcom/fasterxml/jackson/core/FormatSchema;

    move-object v1, p0

    move-object v3, p1

    invoke-direct/range {v0 .. v6}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;Lcom/fasterxml/jackson/core/PrettyPrinter;Lcom/fasterxml/jackson/core/FormatSchema;)V

    move-object p0, v0

    goto :goto_0
.end method

.method public withType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/ObjectWriter;"
        }
    .end annotation

    .prologue
    .line 370
    .local p1, "rootType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->constructType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;->withType(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/ObjectWriter;

    move-result-object v0

    return-object v0
.end method

.method public withView(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/ObjectWriter;"
        }
    .end annotation

    .prologue
    .line 386
    .local p1, "view":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->withView(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 387
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public without(Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "feature"    # Lcom/fasterxml/jackson/databind/SerializationFeature;

    .prologue
    .line 244
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->without(Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 245
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public varargs without(Lcom/fasterxml/jackson/databind/SerializationFeature;[Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "first"    # Lcom/fasterxml/jackson/databind/SerializationFeature;
    .param p2, "other"    # [Lcom/fasterxml/jackson/databind/SerializationFeature;

    .prologue
    .line 255
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1, p2}, Lcom/fasterxml/jackson/databind/SerializationConfig;->without(Lcom/fasterxml/jackson/databind/SerializationFeature;[Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 256
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public varargs withoutFeatures([Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/ObjectWriter;
    .locals 2
    .param p1, "features"    # [Lcom/fasterxml/jackson/databind/SerializationFeature;

    .prologue
    .line 265
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->withoutFeatures([Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v0

    .line 266
    .local v0, "newConfig":Lcom/fasterxml/jackson/databind/SerializationConfig;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    if-ne v0, v1, :cond_0

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectWriter;

    invoke-direct {v1, p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;-><init>(Lcom/fasterxml/jackson/databind/ObjectWriter;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    move-object p0, v1

    goto :goto_0
.end method

.method public writeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V
    .locals 3
    .param p1, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;,
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 451
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_configureJsonGenerator(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 452
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    sget-object v1, Lcom/fasterxml/jackson/databind/SerializationFeature;->CLOSE_CLOSEABLE:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v0

    if-eqz v0, :cond_1

    instance-of v0, p2, Ljava/io/Closeable;

    if-eqz v0, :cond_1

    .line 454
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-direct {p0, p1, p2, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_writeCloseableValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/SerializationConfig;)V

    .line 465
    :cond_0
    :goto_0
    return-void

    .line 456
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    if-nez v0, :cond_2

    .line 457
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V

    .line 461
    :goto_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    sget-object v1, Lcom/fasterxml/jackson/databind/SerializationFeature;->FLUSH_AFTER_WRITE_VALUE:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 462
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->flush()V

    goto :goto_0

    .line 459
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_serializerProvider(Lcom/fasterxml/jackson/databind/SerializationConfig;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootType:Lcom/fasterxml/jackson/databind/JavaType;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_rootSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    invoke-virtual {v0, p1, p2, v1, v2}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;)V

    goto :goto_1
.end method

.method public writeValue(Ljava/io/File;Ljava/lang/Object;)V
    .locals 2
    .param p1, "resultFile"    # Ljava/io/File;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;,
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 480
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    sget-object v1, Lcom/fasterxml/jackson/core/JsonEncoding;->UTF8:Lcom/fasterxml/jackson/core/JsonEncoding;

    invoke-virtual {v0, p1, v1}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonGenerator(Ljava/io/File;Lcom/fasterxml/jackson/core/JsonEncoding;)Lcom/fasterxml/jackson/core/JsonGenerator;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_configAndWriteValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V

    .line 481
    return-void
.end method

.method public writeValue(Ljava/io/OutputStream;Ljava/lang/Object;)V
    .locals 2
    .param p1, "out"    # Ljava/io/OutputStream;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;,
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 497
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    sget-object v1, Lcom/fasterxml/jackson/core/JsonEncoding;->UTF8:Lcom/fasterxml/jackson/core/JsonEncoding;

    invoke-virtual {v0, p1, v1}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonGenerator(Ljava/io/OutputStream;Lcom/fasterxml/jackson/core/JsonEncoding;)Lcom/fasterxml/jackson/core/JsonGenerator;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_configAndWriteValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V

    .line 498
    return-void
.end method

.method public writeValue(Ljava/io/Writer;Ljava/lang/Object;)V
    .locals 1
    .param p1, "w"    # Ljava/io/Writer;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;,
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 513
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonGenerator(Ljava/io/Writer;)Lcom/fasterxml/jackson/core/JsonGenerator;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_configAndWriteValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V

    .line 514
    return-void
.end method

.method public writeValueAsBytes(Ljava/lang/Object;)[B
    .locals 5
    .param p1, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 551
    new-instance v0, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/core/JsonFactory;->_getBufferRecycler()Lcom/fasterxml/jackson/core/util/BufferRecycler;

    move-result-object v3

    invoke-direct {v0, v3}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;-><init>(Lcom/fasterxml/jackson/core/util/BufferRecycler;)V

    .line 553
    .local v0, "bb":Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;
    :try_start_0
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    sget-object v4, Lcom/fasterxml/jackson/core/JsonEncoding;->UTF8:Lcom/fasterxml/jackson/core/JsonEncoding;

    invoke-virtual {v3, v0, v4}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonGenerator(Ljava/io/OutputStream;Lcom/fasterxml/jackson/core/JsonEncoding;)Lcom/fasterxml/jackson/core/JsonGenerator;

    move-result-object v3

    invoke-virtual {p0, v3, p1}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_configAndWriteValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V
    :try_end_0
    .catch Lcom/fasterxml/jackson/core/JsonProcessingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 559
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;->toByteArray()[B

    move-result-object v2

    .line 560
    .local v2, "result":[B
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;->release()V

    .line 561
    return-object v2

    .line 554
    .end local v2    # "result":[B
    :catch_0
    move-exception v1

    .line 555
    .local v1, "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    throw v1

    .line 556
    .end local v1    # "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    :catch_1
    move-exception v1

    .line 557
    .local v1, "e":Ljava/io/IOException;
    invoke-static {v1}, Lcom/fasterxml/jackson/databind/JsonMappingException;->fromUnexpectedIOE(Ljava/io/IOException;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v3

    throw v3
.end method

.method public writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p1, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 528
    new-instance v1, Lcom/fasterxml/jackson/core/io/SegmentedStringWriter;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonFactory;->_getBufferRecycler()Lcom/fasterxml/jackson/core/util/BufferRecycler;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/fasterxml/jackson/core/io/SegmentedStringWriter;-><init>(Lcom/fasterxml/jackson/core/util/BufferRecycler;)V

    .line 530
    .local v1, "sw":Lcom/fasterxml/jackson/core/io/SegmentedStringWriter;
    :try_start_0
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectWriter;->_jsonFactory:Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-virtual {v2, v1}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonGenerator(Ljava/io/Writer;)Lcom/fasterxml/jackson/core/JsonGenerator;

    move-result-object v2

    invoke-virtual {p0, v2, p1}, Lcom/fasterxml/jackson/databind/ObjectWriter;->_configAndWriteValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V
    :try_end_0
    .catch Lcom/fasterxml/jackson/core/JsonProcessingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 536
    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/io/SegmentedStringWriter;->getAndClear()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 531
    :catch_0
    move-exception v0

    .line 532
    .local v0, "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    throw v0

    .line 533
    .end local v0    # "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    :catch_1
    move-exception v0

    .line 534
    .local v0, "e":Ljava/io/IOException;
    invoke-static {v0}, Lcom/fasterxml/jackson/databind/JsonMappingException;->fromUnexpectedIOE(Ljava/io/IOException;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2
.end method
