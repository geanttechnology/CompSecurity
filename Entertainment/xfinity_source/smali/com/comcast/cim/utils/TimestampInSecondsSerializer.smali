.class public Lcom/comcast/cim/utils/TimestampInSecondsSerializer;
.super Lcom/fasterxml/jackson/databind/JsonSerializer;
.source "TimestampInSecondsSerializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/JsonSerializer",
        "<",
        "Ljava/util/Date;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/JsonSerializer;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 11
    check-cast p1, Ljava/util/Date;

    invoke-virtual {p0, p1, p2, p3}, Lcom/comcast/cim/utils/TimestampInSecondsSerializer;->serialize(Ljava/util/Date;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    return-void
.end method

.method public serialize(Ljava/util/Date;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 6
    .param p1, "date"    # Ljava/util/Date;
    .param p2, "jsonGenerator"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "serializerProvider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 15
    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    long-to-int v0, v2

    .line 16
    .local v0, "timestampInSeconds":I
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(I)V

    .line 17
    return-void
.end method
