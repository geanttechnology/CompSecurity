.class public Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;
.super Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;
.source "ResourceMicrodataModelFactory.java"


# direct methods
.method public constructor <init>(Lcom/comcast/cim/microdata/client/HypermediaClient;Ljava/lang/String;)V
    .locals 2
    .param p1, "client"    # Lcom/comcast/cim/microdata/client/HypermediaClient;
    .param p2, "baseUrl"    # Ljava/lang/String;

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;-><init>()V

    .line 12
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataContext;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-direct {v0, p1, p2, p0, v1}, Lcom/comcast/cim/microdata/model/MicrodataContext;-><init>(Lcom/comcast/cim/microdata/client/HypermediaClient;Ljava/lang/String;Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;Ljava/util/Map;)V

    iput-object v0, p0, Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    .line 13
    return-void
.end method

.method private createResource(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 2
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;
    .param p6, "isCanonical"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataProperty;",
            ">;Z)",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;"
        }
    .end annotation

    .prologue
    .line 59
    .local p3, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    .local p4, "forms":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataForm;>;"
    .local p5, "properties":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataProperty;>;"
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataResource;

    invoke-direct {v0, p1}, Lcom/comcast/cim/microdata/model/MicrodataResource;-><init>(Ljava/lang/String;)V

    .line 60
    .local v0, "item":Lcom/comcast/cim/microdata/model/MicrodataResource;
    invoke-virtual {v0, p2}, Lcom/comcast/cim/microdata/model/MicrodataResource;->setId(Ljava/lang/String;)V

    .line 61
    invoke-virtual {v0, p5}, Lcom/comcast/cim/microdata/model/MicrodataResource;->addProperties(Ljava/util/List;)V

    .line 62
    invoke-virtual {v0, p4}, Lcom/comcast/cim/microdata/model/MicrodataResource;->addForms(Ljava/util/List;)V

    .line 63
    invoke-virtual {v0, p3}, Lcom/comcast/cim/microdata/model/MicrodataResource;->addLinks(Ljava/util/List;)V

    .line 64
    iget-object v1, p0, Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataResource;->setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V

    .line 65
    invoke-virtual {v0, p6}, Lcom/comcast/cim/microdata/model/MicrodataResource;->setCanonical(Z)V

    .line 66
    return-object v0
.end method

.method private getSelfLink(Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataLink;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;)",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;"
        }
    .end annotation

    .prologue
    .line 70
    .local p1, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/microdata/model/MicrodataLink;

    .line 71
    .local v1, "link":Lcom/comcast/cim/microdata/model/MicrodataLink;
    const-string v2, "self"

    invoke-interface {v1}, Lcom/comcast/cim/microdata/model/MicrodataLink;->getRelation()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 75
    .end local v1    # "link":Lcom/comcast/cim/microdata/model/MicrodataLink;
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private isTag(Lcom/comcast/cim/microdata/model/MicrodataLink;)Z
    .locals 2
    .param p1, "link"    # Lcom/comcast/cim/microdata/model/MicrodataLink;

    .prologue
    .line 79
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataLink;->getValue()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getHref()Ljava/lang/String;

    move-result-object v0

    const-string v1, "tag:"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 7
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataProperty;",
            ">;)",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;"
        }
    .end annotation

    .prologue
    .line 23
    .local p3, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    .local p4, "forms":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataForm;>;"
    .local p5, "properties":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataProperty;>;"
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v6}, Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;->createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v0

    return-object v0
.end method

.method public createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 10
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;
    .param p6, "isRoot"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataProperty;",
            ">;Z)",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;"
        }
    .end annotation

    .prologue
    .line 34
    .local p3, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    .local p4, "forms":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataForm;>;"
    .local p5, "properties":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataProperty;>;"
    invoke-direct {p0, p3}, Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;->getSelfLink(Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataLink;

    move-result-object v8

    .line 37
    .local v8, "self":Lcom/comcast/cim/microdata/model/MicrodataLink;
    if-eqz v8, :cond_2

    .line 39
    if-nez p6, :cond_0

    invoke-direct {p0, v8}, Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;->isTag(Lcom/comcast/cim/microdata/model/MicrodataLink;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v6, 0x1

    .local v6, "isCanonical":Z
    :goto_0
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    .line 41
    invoke-direct/range {v0 .. v6}, Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;->createResource(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v7

    .line 44
    .local v7, "resource":Lcom/comcast/cim/microdata/model/MicrodataItem;
    invoke-interface {v8}, Lcom/comcast/cim/microdata/model/MicrodataLink;->getValue()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getHref()Ljava/lang/String;

    move-result-object v9

    .line 45
    .local v9, "selfHref":Ljava/lang/String;
    iget-object v0, p0, Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v0}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getItemMap()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, v9, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    .end local v6    # "isCanonical":Z
    .end local v7    # "resource":Lcom/comcast/cim/microdata/model/MicrodataItem;
    .end local v9    # "selfHref":Ljava/lang/String;
    :goto_1
    return-object v7

    .line 39
    :cond_1
    const/4 v6, 0x0

    goto :goto_0

    .line 49
    :cond_2
    invoke-super/range {p0 .. p5}, Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;->createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v7

    goto :goto_1
.end method
