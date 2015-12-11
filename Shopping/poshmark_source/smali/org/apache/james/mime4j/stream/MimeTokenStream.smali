.class public Lorg/apache/james/mime4j/stream/MimeTokenStream;
.super Ljava/lang/Object;
.source "MimeTokenStream.java"


# instance fields
.field private final bodyDescBuilder:Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;

.field private final config:Lorg/apache/james/mime4j/stream/MimeConfig;

.field private currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

.field private final entities:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lorg/apache/james/mime4j/stream/EntityStateMachine;",
            ">;"
        }
    .end annotation
.end field

.field private final fieldBuilder:Lorg/apache/james/mime4j/stream/FieldBuilder;

.field private final monitor:Lorg/apache/james/mime4j/codec/DecodeMonitor;

.field private recursionMode:Lorg/apache/james/mime4j/stream/RecursionMode;

.field private rootentity:Lorg/apache/james/mime4j/stream/MimeEntity;

.field private state:Lorg/apache/james/mime4j/stream/EntityState;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 100
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/apache/james/mime4j/stream/MimeTokenStream;-><init>(Lorg/apache/james/mime4j/stream/MimeConfig;)V

    .line 101
    return-void
.end method

.method public constructor <init>(Lorg/apache/james/mime4j/stream/MimeConfig;)V
    .locals 1
    .param p1, "config"    # Lorg/apache/james/mime4j/stream/MimeConfig;

    .prologue
    const/4 v0, 0x0

    .line 104
    invoke-direct {p0, p1, v0, v0, v0}, Lorg/apache/james/mime4j/stream/MimeTokenStream;-><init>(Lorg/apache/james/mime4j/stream/MimeConfig;Lorg/apache/james/mime4j/codec/DecodeMonitor;Lorg/apache/james/mime4j/stream/FieldBuilder;Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;)V

    .line 105
    return-void
.end method

.method public constructor <init>(Lorg/apache/james/mime4j/stream/MimeConfig;Lorg/apache/james/mime4j/codec/DecodeMonitor;Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;)V
    .locals 1
    .param p1, "config"    # Lorg/apache/james/mime4j/stream/MimeConfig;
    .param p2, "monitor"    # Lorg/apache/james/mime4j/codec/DecodeMonitor;
    .param p3, "bodyDescBuilder"    # Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;

    .prologue
    .line 117
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0, p3}, Lorg/apache/james/mime4j/stream/MimeTokenStream;-><init>(Lorg/apache/james/mime4j/stream/MimeConfig;Lorg/apache/james/mime4j/codec/DecodeMonitor;Lorg/apache/james/mime4j/stream/FieldBuilder;Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;)V

    .line 118
    return-void
.end method

.method public constructor <init>(Lorg/apache/james/mime4j/stream/MimeConfig;Lorg/apache/james/mime4j/codec/DecodeMonitor;Lorg/apache/james/mime4j/stream/FieldBuilder;Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;)V
    .locals 1
    .param p1, "config"    # Lorg/apache/james/mime4j/stream/MimeConfig;
    .param p2, "monitor"    # Lorg/apache/james/mime4j/codec/DecodeMonitor;
    .param p3, "fieldBuilder"    # Lorg/apache/james/mime4j/stream/FieldBuilder;
    .param p4, "bodyDescBuilder"    # Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;

    .prologue
    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->entities:Ljava/util/LinkedList;

    .line 86
    sget-object v0, Lorg/apache/james/mime4j/stream/EntityState;->T_END_OF_STREAM:Lorg/apache/james/mime4j/stream/EntityState;

    iput-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->state:Lorg/apache/james/mime4j/stream/EntityState;

    .line 88
    sget-object v0, Lorg/apache/james/mime4j/stream/RecursionMode;->M_RECURSE:Lorg/apache/james/mime4j/stream/RecursionMode;

    iput-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->recursionMode:Lorg/apache/james/mime4j/stream/RecursionMode;

    .line 126
    if-eqz p1, :cond_0

    .end local p1    # "config":Lorg/apache/james/mime4j/stream/MimeConfig;
    :goto_0
    iput-object p1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->config:Lorg/apache/james/mime4j/stream/MimeConfig;

    .line 127
    if-eqz p3, :cond_1

    .end local p3    # "fieldBuilder":Lorg/apache/james/mime4j/stream/FieldBuilder;
    :goto_1
    iput-object p3, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->fieldBuilder:Lorg/apache/james/mime4j/stream/FieldBuilder;

    .line 129
    if-eqz p2, :cond_2

    .end local p2    # "monitor":Lorg/apache/james/mime4j/codec/DecodeMonitor;
    :goto_2
    iput-object p2, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->monitor:Lorg/apache/james/mime4j/codec/DecodeMonitor;

    .line 131
    if-eqz p4, :cond_4

    .end local p4    # "bodyDescBuilder":Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;
    :goto_3
    iput-object p4, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->bodyDescBuilder:Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;

    .line 133
    return-void

    .line 126
    .restart local p1    # "config":Lorg/apache/james/mime4j/stream/MimeConfig;
    .restart local p2    # "monitor":Lorg/apache/james/mime4j/codec/DecodeMonitor;
    .restart local p3    # "fieldBuilder":Lorg/apache/james/mime4j/stream/FieldBuilder;
    .restart local p4    # "bodyDescBuilder":Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;
    :cond_0
    new-instance p1, Lorg/apache/james/mime4j/stream/MimeConfig;

    .end local p1    # "config":Lorg/apache/james/mime4j/stream/MimeConfig;
    invoke-direct {p1}, Lorg/apache/james/mime4j/stream/MimeConfig;-><init>()V

    goto :goto_0

    .line 127
    :cond_1
    new-instance p3, Lorg/apache/james/mime4j/stream/DefaultFieldBuilder;

    .end local p3    # "fieldBuilder":Lorg/apache/james/mime4j/stream/FieldBuilder;
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->config:Lorg/apache/james/mime4j/stream/MimeConfig;

    invoke-virtual {v0}, Lorg/apache/james/mime4j/stream/MimeConfig;->getMaxHeaderLen()I

    move-result v0

    invoke-direct {p3, v0}, Lorg/apache/james/mime4j/stream/DefaultFieldBuilder;-><init>(I)V

    goto :goto_1

    .line 129
    :cond_2
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->config:Lorg/apache/james/mime4j/stream/MimeConfig;

    invoke-virtual {v0}, Lorg/apache/james/mime4j/stream/MimeConfig;->isStrictParsing()Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object p2, Lorg/apache/james/mime4j/codec/DecodeMonitor;->STRICT:Lorg/apache/james/mime4j/codec/DecodeMonitor;

    goto :goto_2

    :cond_3
    sget-object p2, Lorg/apache/james/mime4j/codec/DecodeMonitor;->SILENT:Lorg/apache/james/mime4j/codec/DecodeMonitor;

    goto :goto_2

    .line 131
    .end local p2    # "monitor":Lorg/apache/james/mime4j/codec/DecodeMonitor;
    :cond_4
    new-instance p4, Lorg/apache/james/mime4j/stream/FallbackBodyDescriptorBuilder;

    .end local p4    # "bodyDescBuilder":Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;
    invoke-direct {p4}, Lorg/apache/james/mime4j/stream/FallbackBodyDescriptorBuilder;-><init>()V

    goto :goto_3
.end method

.method public constructor <init>(Lorg/apache/james/mime4j/stream/MimeConfig;Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;)V
    .locals 1
    .param p1, "config"    # Lorg/apache/james/mime4j/stream/MimeConfig;
    .param p2, "bodyDescBuilder"    # Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;

    .prologue
    const/4 v0, 0x0

    .line 110
    invoke-direct {p0, p1, v0, v0, p2}, Lorg/apache/james/mime4j/stream/MimeTokenStream;-><init>(Lorg/apache/james/mime4j/stream/MimeConfig;Lorg/apache/james/mime4j/codec/DecodeMonitor;Lorg/apache/james/mime4j/stream/FieldBuilder;Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;)V

    .line 111
    return-void
.end method

.method private doParse(Ljava/io/InputStream;Lorg/apache/james/mime4j/stream/EntityState;)V
    .locals 10
    .param p1, "stream"    # Ljava/io/InputStream;
    .param p2, "start"    # Lorg/apache/james/mime4j/stream/EntityState;

    .prologue
    .line 181
    const/4 v1, 0x0

    .line 182
    .local v1, "lineSource":Lorg/apache/james/mime4j/io/LineNumberSource;
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->config:Lorg/apache/james/mime4j/stream/MimeConfig;

    invoke-virtual {v0}, Lorg/apache/james/mime4j/stream/MimeConfig;->isCountLineNumbers()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 183
    new-instance v9, Lorg/apache/james/mime4j/io/LineNumberInputStream;

    invoke-direct {v9, p1}, Lorg/apache/james/mime4j/io/LineNumberInputStream;-><init>(Ljava/io/InputStream;)V

    .line 184
    .local v9, "lineInput":Lorg/apache/james/mime4j/io/LineNumberInputStream;
    move-object v1, v9

    .line 185
    move-object p1, v9

    .line 188
    .end local v9    # "lineInput":Lorg/apache/james/mime4j/io/LineNumberInputStream;
    :cond_0
    new-instance v0, Lorg/apache/james/mime4j/stream/MimeEntity;

    iget-object v3, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->config:Lorg/apache/james/mime4j/stream/MimeConfig;

    sget-object v5, Lorg/apache/james/mime4j/stream/EntityState;->T_END_MESSAGE:Lorg/apache/james/mime4j/stream/EntityState;

    iget-object v6, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->monitor:Lorg/apache/james/mime4j/codec/DecodeMonitor;

    iget-object v7, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->fieldBuilder:Lorg/apache/james/mime4j/stream/FieldBuilder;

    iget-object v8, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->bodyDescBuilder:Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;

    move-object v2, p1

    move-object v4, p2

    invoke-direct/range {v0 .. v8}, Lorg/apache/james/mime4j/stream/MimeEntity;-><init>(Lorg/apache/james/mime4j/io/LineNumberSource;Ljava/io/InputStream;Lorg/apache/james/mime4j/stream/MimeConfig;Lorg/apache/james/mime4j/stream/EntityState;Lorg/apache/james/mime4j/stream/EntityState;Lorg/apache/james/mime4j/codec/DecodeMonitor;Lorg/apache/james/mime4j/stream/FieldBuilder;Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;)V

    iput-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->rootentity:Lorg/apache/james/mime4j/stream/MimeEntity;

    .line 198
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->rootentity:Lorg/apache/james/mime4j/stream/MimeEntity;

    iget-object v2, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->recursionMode:Lorg/apache/james/mime4j/stream/RecursionMode;

    invoke-virtual {v0, v2}, Lorg/apache/james/mime4j/stream/MimeEntity;->setRecursionMode(Lorg/apache/james/mime4j/stream/RecursionMode;)V

    .line 199
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->rootentity:Lorg/apache/james/mime4j/stream/MimeEntity;

    iput-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    .line 200
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->entities:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->clear()V

    .line 201
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->entities:Ljava/util/LinkedList;

    iget-object v2, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    invoke-virtual {v0, v2}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 202
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    invoke-interface {v0}, Lorg/apache/james/mime4j/stream/EntityStateMachine;->getState()Lorg/apache/james/mime4j/stream/EntityState;

    move-result-object v0

    iput-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->state:Lorg/apache/james/mime4j/stream/EntityState;

    .line 203
    return-void
.end method

.method public static final stateToString(Lorg/apache/james/mime4j/stream/EntityState;)Ljava/lang/String;
    .locals 1
    .param p0, "state"    # Lorg/apache/james/mime4j/stream/EntityState;

    .prologue
    .line 387
    invoke-static {p0}, Lorg/apache/james/mime4j/stream/MimeEntity;->stateToString(Lorg/apache/james/mime4j/stream/EntityState;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getBodyDescriptor()Lorg/apache/james/mime4j/stream/BodyDescriptor;
    .locals 1

    .prologue
    .line 337
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    invoke-interface {v0}, Lorg/apache/james/mime4j/stream/EntityStateMachine;->getBodyDescriptor()Lorg/apache/james/mime4j/stream/BodyDescriptor;

    move-result-object v0

    return-object v0
.end method

.method public getConfig()Lorg/apache/james/mime4j/stream/MimeConfig;
    .locals 1

    .prologue
    .line 392
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->config:Lorg/apache/james/mime4j/stream/MimeConfig;

    return-object v0
.end method

.method public getDecodedInputStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 292
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    invoke-interface {v0}, Lorg/apache/james/mime4j/stream/EntityStateMachine;->getDecodedContentStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getField()Lorg/apache/james/mime4j/stream/Field;
    .locals 1

    .prologue
    .line 347
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    invoke-interface {v0}, Lorg/apache/james/mime4j/stream/EntityStateMachine;->getField()Lorg/apache/james/mime4j/stream/Field;

    move-result-object v0

    return-object v0
.end method

.method public getInputStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    invoke-interface {v0}, Lorg/apache/james/mime4j/stream/EntityStateMachine;->getContentStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getReader()Ljava/io/Reader;
    .locals 5

    .prologue
    .line 313
    invoke-virtual {p0}, Lorg/apache/james/mime4j/stream/MimeTokenStream;->getBodyDescriptor()Lorg/apache/james/mime4j/stream/BodyDescriptor;

    move-result-object v0

    .line 314
    .local v0, "bodyDescriptor":Lorg/apache/james/mime4j/stream/BodyDescriptor;
    invoke-interface {v0}, Lorg/apache/james/mime4j/stream/BodyDescriptor;->getCharset()Ljava/lang/String;

    move-result-object v3

    .line 316
    .local v3, "mimeCharset":Ljava/lang/String;
    if-eqz v3, :cond_0

    const-string v4, ""

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 317
    :cond_0
    sget-object v1, Lorg/apache/james/mime4j/util/CharsetUtil;->US_ASCII:Ljava/nio/charset/Charset;

    .line 321
    .local v1, "charset":Ljava/nio/charset/Charset;
    :goto_0
    invoke-virtual {p0}, Lorg/apache/james/mime4j/stream/MimeTokenStream;->getDecodedInputStream()Ljava/io/InputStream;

    move-result-object v2

    .line 322
    .local v2, "instream":Ljava/io/InputStream;
    new-instance v4, Ljava/io/InputStreamReader;

    invoke-direct {v4, v2, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    return-object v4

    .line 319
    .end local v1    # "charset":Ljava/nio/charset/Charset;
    .end local v2    # "instream":Ljava/io/InputStream;
    :cond_1
    invoke-static {v3}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v1

    .restart local v1    # "charset":Ljava/nio/charset/Charset;
    goto :goto_0
.end method

.method public getRecursionMode()Lorg/apache/james/mime4j/stream/RecursionMode;
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->recursionMode:Lorg/apache/james/mime4j/stream/RecursionMode;

    return-object v0
.end method

.method public getState()Lorg/apache/james/mime4j/stream/EntityState;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->state:Lorg/apache/james/mime4j/stream/EntityState;

    return-object v0
.end method

.method public isRaw()Z
    .locals 2

    .prologue
    .line 213
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->recursionMode:Lorg/apache/james/mime4j/stream/RecursionMode;

    sget-object v1, Lorg/apache/james/mime4j/stream/RecursionMode;->M_RAW:Lorg/apache/james/mime4j/stream/RecursionMode;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public next()Lorg/apache/james/mime4j/stream/EntityState;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/apache/james/mime4j/MimeException;
        }
    .end annotation

    .prologue
    .line 356
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->state:Lorg/apache/james/mime4j/stream/EntityState;

    sget-object v2, Lorg/apache/james/mime4j/stream/EntityState;->T_END_OF_STREAM:Lorg/apache/james/mime4j/stream/EntityState;

    if-eq v1, v2, :cond_0

    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    if-nez v1, :cond_2

    .line 357
    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "No more tokens are available."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 369
    .local v0, "next":Lorg/apache/james/mime4j/stream/EntityStateMachine;
    :cond_1
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->entities:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->removeLast()Ljava/lang/Object;

    .line 370
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->entities:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 371
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    .line 359
    .end local v0    # "next":Lorg/apache/james/mime4j/stream/EntityStateMachine;
    :cond_2
    :goto_0
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    if-eqz v1, :cond_5

    .line 360
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    invoke-interface {v1}, Lorg/apache/james/mime4j/stream/EntityStateMachine;->advance()Lorg/apache/james/mime4j/stream/EntityStateMachine;

    move-result-object v0

    .line 361
    .restart local v0    # "next":Lorg/apache/james/mime4j/stream/EntityStateMachine;
    if-eqz v0, :cond_3

    .line 362
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->entities:Ljava/util/LinkedList;

    invoke-virtual {v1, v0}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 363
    iput-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    .line 365
    :cond_3
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    invoke-interface {v1}, Lorg/apache/james/mime4j/stream/EntityStateMachine;->getState()Lorg/apache/james/mime4j/stream/EntityState;

    move-result-object v1

    iput-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->state:Lorg/apache/james/mime4j/stream/EntityState;

    .line 366
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->state:Lorg/apache/james/mime4j/stream/EntityState;

    sget-object v2, Lorg/apache/james/mime4j/stream/EntityState;->T_END_OF_STREAM:Lorg/apache/james/mime4j/stream/EntityState;

    if-eq v1, v2, :cond_1

    .line 367
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->state:Lorg/apache/james/mime4j/stream/EntityState;

    .line 378
    .end local v0    # "next":Lorg/apache/james/mime4j/stream/EntityStateMachine;
    :goto_1
    return-object v1

    .line 373
    .restart local v0    # "next":Lorg/apache/james/mime4j/stream/EntityStateMachine;
    :cond_4
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->entities:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->getLast()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/james/mime4j/stream/EntityStateMachine;

    iput-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    .line 374
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    iget-object v2, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->recursionMode:Lorg/apache/james/mime4j/stream/RecursionMode;

    invoke-interface {v1, v2}, Lorg/apache/james/mime4j/stream/EntityStateMachine;->setRecursionMode(Lorg/apache/james/mime4j/stream/RecursionMode;)V

    goto :goto_0

    .line 377
    .end local v0    # "next":Lorg/apache/james/mime4j/stream/EntityStateMachine;
    :cond_5
    sget-object v1, Lorg/apache/james/mime4j/stream/EntityState;->T_END_OF_STREAM:Lorg/apache/james/mime4j/stream/EntityState;

    iput-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->state:Lorg/apache/james/mime4j/stream/EntityState;

    .line 378
    iget-object v1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->state:Lorg/apache/james/mime4j/stream/EntityState;

    goto :goto_1
.end method

.method public parse(Ljava/io/InputStream;)V
    .locals 1
    .param p1, "stream"    # Ljava/io/InputStream;

    .prologue
    .line 140
    sget-object v0, Lorg/apache/james/mime4j/stream/EntityState;->T_START_MESSAGE:Lorg/apache/james/mime4j/stream/EntityState;

    invoke-direct {p0, p1, v0}, Lorg/apache/james/mime4j/stream/MimeTokenStream;->doParse(Ljava/io/InputStream;Lorg/apache/james/mime4j/stream/EntityState;)V

    .line 141
    return-void
.end method

.method public parseHeadless(Ljava/io/InputStream;Ljava/lang/String;)Lorg/apache/james/mime4j/stream/Field;
    .locals 6
    .param p1, "stream"    # Ljava/io/InputStream;
    .param p2, "contentType"    # Ljava/lang/String;

    .prologue
    .line 154
    if-nez p2, :cond_0

    .line 155
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Content type may not be null"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 159
    :cond_0
    :try_start_0
    new-instance v3, Lorg/apache/james/mime4j/stream/RawField;

    const-string v4, "Content-Type"

    invoke-direct {v3, v4, p2}, Lorg/apache/james/mime4j/stream/RawField;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    .local v3, "rawContentType":Lorg/apache/james/mime4j/stream/RawField;
    iget-object v4, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->bodyDescBuilder:Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;

    invoke-interface {v4, v3}, Lorg/apache/james/mime4j/stream/BodyDescriptorBuilder;->addField(Lorg/apache/james/mime4j/stream/RawField;)Lorg/apache/james/mime4j/stream/Field;
    :try_end_0
    .catch Lorg/apache/james/mime4j/MimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 161
    .local v2, "newContentType":Lorg/apache/james/mime4j/stream/Field;
    if-nez v2, :cond_1

    move-object v2, v3

    .line 167
    :cond_1
    sget-object v4, Lorg/apache/james/mime4j/stream/EntityState;->T_END_HEADER:Lorg/apache/james/mime4j/stream/EntityState;

    invoke-direct {p0, p1, v4}, Lorg/apache/james/mime4j/stream/MimeTokenStream;->doParse(Ljava/io/InputStream;Lorg/apache/james/mime4j/stream/EntityState;)V

    .line 169
    :try_start_1
    invoke-virtual {p0}, Lorg/apache/james/mime4j/stream/MimeTokenStream;->next()Lorg/apache/james/mime4j/stream/EntityState;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Lorg/apache/james/mime4j/MimeException; {:try_start_1 .. :try_end_1} :catch_2

    .line 177
    return-object v2

    .line 162
    .end local v2    # "newContentType":Lorg/apache/james/mime4j/stream/Field;
    .end local v3    # "rawContentType":Lorg/apache/james/mime4j/stream/RawField;
    :catch_0
    move-exception v1

    .line 164
    .local v1, "ex":Lorg/apache/james/mime4j/MimeException;
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-virtual {v1}, Lorg/apache/james/mime4j/MimeException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 170
    .end local v1    # "ex":Lorg/apache/james/mime4j/MimeException;
    .restart local v2    # "newContentType":Lorg/apache/james/mime4j/stream/Field;
    .restart local v3    # "rawContentType":Lorg/apache/james/mime4j/stream/RawField;
    :catch_1
    move-exception v0

    .line 172
    .local v0, "e":Ljava/io/IOException;
    new-instance v4, Ljava/lang/IllegalStateException;

    invoke-direct {v4, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 173
    .end local v0    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v0

    .line 175
    .local v0, "e":Lorg/apache/james/mime4j/MimeException;
    new-instance v4, Ljava/lang/IllegalStateException;

    invoke-direct {v4, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v4
.end method

.method public setRecursionMode(Lorg/apache/james/mime4j/stream/RecursionMode;)V
    .locals 1
    .param p1, "mode"    # Lorg/apache/james/mime4j/stream/RecursionMode;

    .prologue
    .line 241
    iput-object p1, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->recursionMode:Lorg/apache/james/mime4j/stream/RecursionMode;

    .line 242
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    if-eqz v0, :cond_0

    .line 243
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->currentStateMachine:Lorg/apache/james/mime4j/stream/EntityStateMachine;

    invoke-interface {v0, p1}, Lorg/apache/james/mime4j/stream/EntityStateMachine;->setRecursionMode(Lorg/apache/james/mime4j/stream/RecursionMode;)V

    .line 245
    :cond_0
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lorg/apache/james/mime4j/stream/MimeTokenStream;->rootentity:Lorg/apache/james/mime4j/stream/MimeEntity;

    invoke-virtual {v0}, Lorg/apache/james/mime4j/stream/MimeEntity;->stop()V

    .line 255
    return-void
.end method
