.class public Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;
.super Ljava/lang/Object;
.source "HalLiveFeaturedContentResource.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private liveFeaturedContentList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;->liveFeaturedContentList:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public getLiveFeaturedContent()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 33
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;->liveFeaturedContentList:Ljava/util/List;

    return-object v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 8
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 19
    const-string v4, "resources"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 21
    .local v3, "items":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 22
    .local v2, "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    invoke-direct {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;-><init>()V

    .line 24
    .local v1, "featuredContent":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
    :try_start_0
    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 25
    iget-object v5, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;->liveFeaturedContentList:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lcom/comcast/cim/microdata/exception/PropertyNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 26
    :catch_0
    move-exception v0

    .line 27
    .local v0, "e":Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;
    sget-object v5, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;->LOG:Lorg/slf4j/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Failed to parse Featured Content: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 30
    .end local v0    # "e":Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;
    .end local v1    # "featuredContent":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
    .end local v2    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    :cond_0
    return-void
.end method
