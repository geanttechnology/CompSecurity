.class Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;
.super Ljava/lang/Object;
.source "DibicResourceCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/dibic/DibicResource;
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
        "Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    .prologue
    .line 73
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;, "Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;->this$0:Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;
    .locals 5

    .prologue
    .line 76
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;, "Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;"
    new-instance v1, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;

    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;->this$0:Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    # getter for: Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->dibicParser:Lcom/xfinity/playerlib/model/dibic/DibicParser;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->access$000(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)Lcom/xfinity/playerlib/model/dibic/DibicParser;

    move-result-object v2

    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;->this$0:Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    # getter for: Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->access$100(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

    move-result-object v3

    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;->this$0:Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    # getter for: Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->access$200(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;->this$0:Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    # getter for: Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v4}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->access$300(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v4

    invoke-direct {v1, v2, v3, v0, v4}, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;-><init>(Lcom/xfinity/playerlib/model/dibic/DibicParser;Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    return-object v1
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 73
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;, "Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;->get()Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;

    move-result-object v0

    return-object v0
.end method
