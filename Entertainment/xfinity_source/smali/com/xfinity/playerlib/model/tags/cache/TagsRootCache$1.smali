.class Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;
.super Ljava/lang/Object;
.source "TagsRootCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;

    .prologue
    .line 39
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;, "Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;->this$0:Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;
    .locals 2

    .prologue
    .line 42
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;, "Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;"
    new-instance v0, Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;->this$0:Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;

    # getter for: Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->tagsParser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;
    invoke-static {v1}, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->access$000(Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;)Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;-><init>(Lcom/xfinity/playerlib/model/tags/parser/TagsParser;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 39
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;, "Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;->get()Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;

    move-result-object v0

    return-object v0
.end method
