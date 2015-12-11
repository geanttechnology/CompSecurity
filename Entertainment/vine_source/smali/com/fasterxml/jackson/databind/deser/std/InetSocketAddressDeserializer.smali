.class public Lcom/fasterxml/jackson/databind/deser/std/InetSocketAddressDeserializer;
.super Lcom/fasterxml/jackson/databind/deser/std/FromStringDeserializer;
.source "InetSocketAddressDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/deser/std/FromStringDeserializer",
        "<",
        "Ljava/net/InetSocketAddress;",
        ">;"
    }
.end annotation


# static fields
.field public static final instance:Lcom/fasterxml/jackson/databind/deser/std/InetSocketAddressDeserializer;

.field private static final serialVersionUID:J = 0x1L


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/std/InetSocketAddressDeserializer;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/deser/std/InetSocketAddressDeserializer;-><init>()V

    sput-object v0, Lcom/fasterxml/jackson/databind/deser/std/InetSocketAddressDeserializer;->instance:Lcom/fasterxml/jackson/databind/deser/std/InetSocketAddressDeserializer;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Ljava/net/InetSocketAddress;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/FromStringDeserializer;-><init>(Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic _deserialize(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 14
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/InetSocketAddressDeserializer;->_deserialize(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/net/InetSocketAddress;

    move-result-object v0

    return-object v0
.end method

.method protected _deserialize(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/net/InetSocketAddress;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v5, 0x3a

    const/4 v1, 0x0

    const/4 v4, -0x1

    .line 27
    const-string v0, "["

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 30
    const/16 v0, 0x5d

    invoke-virtual {p1, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v3

    .line 31
    if-ne v3, v4, :cond_0

    .line 32
    new-instance v0, Lcom/fasterxml/jackson/databind/exc/InvalidFormatException;

    const-string v1, "Bracketed IPv6 address must contain closing bracket"

    const-class v2, Ljava/net/InetSocketAddress;

    invoke-direct {v0, v1, p1, v2}, Lcom/fasterxml/jackson/databind/exc/InvalidFormatException;-><init>(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V

    throw v0

    .line 37
    :cond_0
    invoke-virtual {p1, v5, v3}, Ljava/lang/String;->indexOf(II)I

    move-result v0

    .line 38
    if-le v0, v4, :cond_1

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 39
    :goto_0
    new-instance v2, Ljava/net/InetSocketAddress;

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {p1, v1, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1, v0}, Ljava/net/InetSocketAddress;-><init>(Ljava/lang/String;I)V

    move-object v0, v2

    .line 48
    :goto_1
    return-object v0

    :cond_1
    move v0, v1

    .line 38
    goto :goto_0

    .line 41
    :cond_2
    invoke-virtual {p1, v5}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    .line 42
    if-eq v2, v4, :cond_3

    add-int/lit8 v0, v2, 0x1

    invoke-virtual {p1, v5, v0}, Ljava/lang/String;->indexOf(II)I

    move-result v0

    if-ne v0, v4, :cond_3

    .line 44
    add-int/lit8 v0, v2, 0x1

    invoke-virtual {p1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 45
    new-instance v0, Ljava/net/InetSocketAddress;

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v3}, Ljava/net/InetSocketAddress;-><init>(Ljava/lang/String;I)V

    goto :goto_1

    .line 48
    :cond_3
    new-instance v0, Ljava/net/InetSocketAddress;

    invoke-direct {v0, p1, v1}, Ljava/net/InetSocketAddress;-><init>(Ljava/lang/String;I)V

    goto :goto_1
.end method
