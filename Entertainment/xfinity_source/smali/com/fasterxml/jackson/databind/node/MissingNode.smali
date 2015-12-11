.class public final Lcom/fasterxml/jackson/databind/node/MissingNode;
.super Lcom/fasterxml/jackson/databind/node/BaseJsonNode;
.source "MissingNode.java"


# static fields
.field private static final instance:Lcom/fasterxml/jackson/databind/node/MissingNode;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    new-instance v0, Lcom/fasterxml/jackson/databind/node/MissingNode;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/node/MissingNode;-><init>()V

    sput-object v0, Lcom/fasterxml/jackson/databind/node/MissingNode;->instance:Lcom/fasterxml/jackson/databind/node/MissingNode;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/node/BaseJsonNode;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/fasterxml/jackson/databind/node/MissingNode;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/fasterxml/jackson/databind/node/MissingNode;->instance:Lcom/fasterxml/jackson/databind/node/MissingNode;

    return-object v0
.end method


# virtual methods
.method public asText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    const-string v0, ""

    return-object v0
.end method

.method public asToken()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->NOT_AVAILABLE:Lcom/fasterxml/jackson/core/JsonToken;

    return-object v0
.end method

.method public deepCopy()Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">()TT;"
        }
    .end annotation

    .prologue
    .line 33
    return-object p0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 92
    if-ne p1, p0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isMissingNode()Z
    .locals 1

    .prologue
    .line 40
    const/4 v0, 0x1

    return v0
.end method

.method public path(I)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 58
    return-object p0
.end method

.method public path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 0
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 55
    return-object p0
.end method

.method public final serialize(Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 0
    .param p1, "jg"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 70
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNull()V

    .line 71
    return-void
.end method

.method public serializeWithType(Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    .locals 0
    .param p1, "jg"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p3, "typeSer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 78
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNull()V

    .line 79
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    const-string v0, ""

    return-object v0
.end method
