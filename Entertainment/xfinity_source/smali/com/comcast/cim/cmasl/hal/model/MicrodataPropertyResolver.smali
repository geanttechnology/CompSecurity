.class public Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;
.super Ljava/lang/Object;
.source "MicrodataPropertyResolver.java"


# instance fields
.field private halResource:Lcom/comcast/cim/microdata/model/MicrodataItem;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V
    .locals 0
    .param p1, "halResource"    # Lcom/comcast/cim/microdata/model/MicrodataItem;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->halResource:Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 19
    return-void
.end method


# virtual methods
.method public copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;
    .locals 1
    .param p1, "halResource"    # Lcom/comcast/cim/microdata/model/MicrodataItem;

    .prologue
    .line 23
    new-instance v0, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    invoke-direct {v0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;-><init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V

    return-object v0
.end method

.method public fetchBoolean(Ljava/lang/String;)Z
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 78
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asBoolean()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public fetchInt(Ljava/lang/String;)I
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 86
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asInt()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public fetchItem(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 123
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asItem()Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v0

    return-object v0
.end method

.method public fetchLinkAsString(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->resolve()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public fetchLinkAsUriTemplate(Ljava/lang/String;)Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 61
    new-instance v0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;-><init>(Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)V

    return-object v0
.end method

.method public fetchList(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<TE;>;"
        }
    .end annotation

    .prologue
    .line 102
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asList()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public fetchOptionalBoolean(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "defaultBoolean"    # Z

    .prologue
    .line 82
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asBoolean(Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public fetchOptionalInt(Ljava/lang/String;I)I
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "defaultInt"    # I

    .prologue
    .line 90
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asInt(Ljava/lang/Integer;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public fetchOptionalItem(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 127
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    .line 128
    .local v0, "property":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->isMissing()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 129
    const/4 v1, 0x0

    .line 132
    :goto_0
    return-object v1

    :cond_0
    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asItem()Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v1

    goto :goto_0
.end method

.method public fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 114
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    .line 115
    .local v0, "property":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->isMissing()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 116
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 119
    :goto_0
    return-object v1

    :cond_0
    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asItems()Ljava/util/List;

    move-result-object v1

    goto :goto_0
.end method

.method public fetchOptionalLinkAsString(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    .line 40
    .local v0, "property":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->isMissing()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 41
    const/4 v1, 0x0

    .line 43
    :goto_0
    return-object v1

    :cond_0
    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->resolve()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public fetchOptionalList(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<TE;>;"
        }
    .end annotation

    .prologue
    .line 106
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 74
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public fetchString(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 2
    .param p1, "propertyName"    # Ljava/lang/String;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->halResource:Lcom/comcast/cim/microdata/model/MicrodataItem;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Lcom/comcast/cim/microdata/model/MicrodataItem;->get(Ljava/lang/String;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    return-object v0
.end method
