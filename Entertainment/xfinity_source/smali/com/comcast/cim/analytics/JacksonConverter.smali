.class public Lcom/comcast/cim/analytics/JacksonConverter;
.super Ljava/lang/Object;
.source "JacksonConverter.java"

# interfaces
.implements Lcom/squareup/tape/FileObjectQueue$Converter;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/squareup/tape/FileObjectQueue$Converter",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private final type:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/lang/Class;)V
    .locals 0
    .param p1, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/ObjectMapper;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lcom/comcast/cim/analytics/JacksonConverter;, "Lcom/comcast/cim/analytics/JacksonConverter<TT;>;"
    .local p2, "type":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/analytics/JacksonConverter;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 17
    iput-object p2, p0, Lcom/comcast/cim/analytics/JacksonConverter;->type:Ljava/lang/Class;

    .line 18
    return-void
.end method


# virtual methods
.method public from([B)Ljava/lang/Object;
    .locals 2
    .param p1, "bytes"    # [B
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/analytics/JacksonConverter;, "Lcom/comcast/cim/analytics/JacksonConverter<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/analytics/JacksonConverter;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, p0, Lcom/comcast/cim/analytics/JacksonConverter;->type:Ljava/lang/Class;

    invoke-virtual {v0, p1, v1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue([BLjava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public toStream(Ljava/lang/Object;Ljava/io/OutputStream;)V
    .locals 1
    .param p2, "outputStream"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Ljava/io/OutputStream;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 27
    .local p0, "this":Lcom/comcast/cim/analytics/JacksonConverter;, "Lcom/comcast/cim/analytics/JacksonConverter<TT;>;"
    .local p1, "analyticsTask":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/comcast/cim/analytics/JacksonConverter;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p2, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writeValue(Ljava/io/OutputStream;Ljava/lang/Object;)V

    .line 28
    return-void
.end method
