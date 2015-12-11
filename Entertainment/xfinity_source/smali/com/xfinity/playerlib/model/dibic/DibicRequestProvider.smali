.class public Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;
.super Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;
.source "DibicRequestProvider.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

.field private final tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V
    .locals 2
    .param p1, "programFactory"    # Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;
    .param p2, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .param p3, "cacheKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;, "Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider<TT;>;"
    .local p4, "baseRequest":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    invoke-direct {p0, p4, p3}, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Ljava/lang/String;)V

    .line 22
    const-string v0, "Accept"

    const-string v1, "application/dibic"

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 23
    iput-object p2, p0, Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 24
    iput-object p1, p0, Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;->programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

    .line 25
    return-void
.end method


# virtual methods
.method public getProgramFactory()Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;
    .locals 1

    .prologue
    .line 28
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;, "Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;->programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

    return-object v0
.end method

.method public getTagsRoot()Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .locals 1

    .prologue
    .line 32
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;, "Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    return-object v0
.end method
