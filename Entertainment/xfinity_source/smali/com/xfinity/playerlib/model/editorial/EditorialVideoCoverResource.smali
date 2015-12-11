.class public Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;
.super Ljava/lang/Object;
.source "EditorialVideoCoverResource.java"


# instance fields
.field private collectionTitle:Ljava/lang/String;

.field private programs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/CoverVideo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;Ljava/lang/String;)V
    .locals 0
    .param p2, "collectionTitle"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/CoverVideo;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 11
    .local p1, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/CoverVideo;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;->programs:Ljava/util/List;

    .line 13
    iput-object p2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;->collectionTitle:Ljava/lang/String;

    .line 14
    return-void
.end method


# virtual methods
.method public getCollectionTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;->collectionTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getPrograms()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/CoverVideo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;->programs:Ljava/util/List;

    return-object v0
.end method
