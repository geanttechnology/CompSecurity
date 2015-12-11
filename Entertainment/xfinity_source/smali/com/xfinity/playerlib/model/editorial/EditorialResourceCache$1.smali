.class Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;
.super Ljava/lang/Object;
.source "EditorialResourceCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->fetchResourceWithNoCache()Ljava/lang/Object;
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
        "Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler",
        "<TP;TR;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;

    .prologue
    .line 37
    .local p0, "this":Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;, "Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;->this$0:Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler",
            "<TP;TR;>;"
        }
    .end annotation

    .prologue
    .line 39
    .local p0, "this":Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;, "Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;"
    new-instance v0, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;->this$0:Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;

    # getter for: Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->parser:Lcom/xfinity/playerlib/model/editorial/EditorialParser;
    invoke-static {v1}, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->access$000(Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;)Lcom/xfinity/playerlib/model/editorial/EditorialParser;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;->this$0:Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;

    # getter for: Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->editorialResourceFactory:Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->access$100(Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;)Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;-><init>(Lcom/xfinity/playerlib/model/editorial/EditorialParser;Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 37
    .local p0, "this":Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;, "Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;->get()Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;

    move-result-object v0

    return-object v0
.end method
