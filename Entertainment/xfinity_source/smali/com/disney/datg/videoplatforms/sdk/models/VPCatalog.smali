.class public Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
.super Ljava/lang/Object;
.source "VPCatalog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;
    }
.end annotation


# instance fields
.field private catalogType:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

.field private collection:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    return-void
.end method


# virtual methods
.method public getCollection()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;",
            ">;"
        }
    .end annotation

    .prologue
    .line 16
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->collection:Ljava/util/List;

    return-object v0
.end method

.method public setCollection(Ljava/util/List;Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;)V
    .locals 0
    .param p2, "catalogType"    # Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;",
            ">;",
            "Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;",
            ")V"
        }
    .end annotation

    .prologue
    .line 20
    .local p1, "collection":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->collection:Ljava/util/List;

    .line 21
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->catalogType:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    .line 22
    return-void
.end method
