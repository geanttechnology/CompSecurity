.class final Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;
.super Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer;
.source "StdKeyDeserializer.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "StringKD"
.end annotation


# static fields
.field private static final sObject:Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;

.field private static final sString:Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 82
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;

    const-class v1, Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;-><init>(Ljava/lang/Class;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;->sString:Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;

    .line 83
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;

    const-class v1, Ljava/lang/Object;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;-><init>(Ljava/lang/Class;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;->sObject:Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;

    return-void
.end method

.method private constructor <init>(Ljava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 85
    .local p1, "nominalType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer;-><init>(Ljava/lang/Class;)V

    return-void
.end method

.method public static forType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;"
        }
    .end annotation

    .prologue
    .line 89
    .local p0, "nominalType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Ljava/lang/String;

    if-ne p0, v0, :cond_0

    .line 90
    sget-object v0, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;->sString:Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;

    .line 95
    :goto_0
    return-object v0

    .line 92
    :cond_0
    const-class v0, Ljava/lang/Object;

    if-ne p0, v0, :cond_1

    .line 93
    sget-object v0, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;->sObject:Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;

    goto :goto_0

    .line 95
    :cond_1
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;-><init>(Ljava/lang/Class;)V

    goto :goto_0
.end method


# virtual methods
.method public bridge synthetic _parse(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 79
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD;->_parse(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public _parse(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/String;
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 100
    return-object p1
.end method
