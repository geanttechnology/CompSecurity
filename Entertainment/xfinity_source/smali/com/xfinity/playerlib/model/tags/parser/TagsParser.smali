.class public Lcom/xfinity/playerlib/model/tags/parser/TagsParser;
.super Ljava/lang/Object;
.source "TagsParser.java"


# instance fields
.field private final mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/xfinity/playerlib/model/tags/parser/TagsParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 18
    return-void
.end method


# virtual methods
.method public parseTags(Ljava/io/InputStream;)Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .locals 3
    .param p1, "tagsInputStream"    # Ljava/io/InputStream;

    .prologue
    .line 27
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/parser/TagsParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v2, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;

    invoke-virtual {v1, p1, v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 28
    :catch_0
    move-exception v0

    .line 29
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v1, v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v1
.end method
