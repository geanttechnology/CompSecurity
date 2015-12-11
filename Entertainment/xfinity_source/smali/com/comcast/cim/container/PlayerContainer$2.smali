.class Lcom/comcast/cim/container/PlayerContainer$2;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getEditorVideoCoverResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory",
        "<",
        "Lcom/xfinity/playerlib/model/editorial/CoverParser;",
        "Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/PlayerContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 478
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$2;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createResource(Lcom/xfinity/playerlib/model/editorial/CoverParser;Ljava/lang/String;)Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;
    .locals 3
    .param p1, "parser"    # Lcom/xfinity/playerlib/model/editorial/CoverParser;
    .param p2, "json"    # Ljava/lang/String;

    .prologue
    .line 481
    new-instance v0, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;

    invoke-virtual {p1, p2}, Lcom/xfinity/playerlib/model/editorial/CoverParser;->getPrograms(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {p1, p2}, Lcom/xfinity/playerlib/model/editorial/CoverParser;->getCollectionTitle(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;-><init>(Ljava/util/List;Ljava/lang/String;)V

    return-object v0
.end method

.method public bridge synthetic createResource(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 478
    check-cast p1, Lcom/xfinity/playerlib/model/editorial/CoverParser;

    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/container/PlayerContainer$2;->createResource(Lcom/xfinity/playerlib/model/editorial/CoverParser;Ljava/lang/String;)Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;

    move-result-object v0

    return-object v0
.end method
