.class public Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "TagsResponseHandler.java"


# instance fields
.field private final parser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

.field private tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/tags/parser/TagsParser;)V
    .locals 0
    .param p1, "parser"    # Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;->parser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    .line 18
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;->addDefaultHeaderHandlers()V

    .line 19
    return-void
.end method


# virtual methods
.method public getTagsRoot()Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 1
    .param p1, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;->parser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/tags/parser/TagsParser;->parseTags(Ljava/io/InputStream;)Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 24
    return-void
.end method
