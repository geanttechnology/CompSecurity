.class public Lcom/comcast/cim/utils/JsonDeserializer;
.super Ljava/lang/Object;
.source "JsonDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 13
    .local p0, "this":Lcom/comcast/cim/utils/JsonDeserializer;, "Lcom/comcast/cim/utils/JsonDeserializer<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/comcast/cim/utils/JsonDeserializer;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 15
    return-void
.end method


# virtual methods
.method public deserialize(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .param p1, "json"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 18
    .local p0, "this":Lcom/comcast/cim/utils/JsonDeserializer;, "Lcom/comcast/cim/utils/JsonDeserializer<TT;>;"
    .local p2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<+TT;>;"
    new-instance v1, Ljava/io/StringReader;

    invoke-direct {v1, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    .line 20
    .local v1, "reader":Ljava/io/StringReader;
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/utils/JsonDeserializer;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v2, v1, p2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    return-object v2

    .line 21
    :catch_0
    move-exception v0

    .line 22
    .local v0, "e":Ljava/io/IOException;
    new-instance v2, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v2, v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v2
.end method
