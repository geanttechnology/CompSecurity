.class public Lcom/comcast/cim/microdata/model/MicrodataItemImpl;
.super Ljava/lang/Object;
.source "MicrodataItemImpl.java"

# interfaces
.implements Lcom/comcast/cim/microdata/model/MicrodataItem;


# instance fields
.field private context:Lcom/comcast/cim/microdata/model/MicrodataContext;

.field private forms:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;",
            ">;"
        }
    .end annotation
.end field

.field private id:Ljava/lang/String;

.field private links:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;"
        }
    .end annotation
.end field

.field private properties:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataProperty;",
            ">;"
        }
    .end annotation
.end field

.field private requiredProps:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->type:Ljava/lang/String;

    .line 24
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    .line 25
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->links:Ljava/util/Map;

    .line 26
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->forms:Ljava/util/Map;

    .line 27
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->requiredProps:Ljava/util/Set;

    .line 28
    return-void
.end method


# virtual methods
.method public addForms(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 81
    .local p1, "newForms":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataForm;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataForm;

    .line 82
    .local v0, "form":Lcom/comcast/cim/microdata/model/MicrodataForm;
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->forms:Ljava/util/Map;

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataForm;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 84
    .end local v0    # "form":Lcom/comcast/cim/microdata/model/MicrodataForm;
    :cond_0
    return-void
.end method

.method public addLink(Lcom/comcast/cim/microdata/model/MicrodataLink;)V
    .locals 2
    .param p1, "link"    # Lcom/comcast/cim/microdata/model/MicrodataLink;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->links:Ljava/util/Map;

    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataLink;->getRelation()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    return-void
.end method

.method public addLinks(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 64
    .local p1, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/microdata/model/MicrodataLink;

    .line 65
    .local v1, "link":Lcom/comcast/cim/microdata/model/MicrodataLink;
    invoke-virtual {p0, v1}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->addLink(Lcom/comcast/cim/microdata/model/MicrodataLink;)V

    goto :goto_0

    .line 67
    .end local v1    # "link":Lcom/comcast/cim/microdata/model/MicrodataLink;
    :cond_0
    return-void
.end method

.method public addProperties(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataProperty;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 44
    .local p1, "properties":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataProperty;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/microdata/model/MicrodataProperty;

    .line 45
    .local v1, "property":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    invoke-virtual {p0, v1}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->addProperty(Lcom/comcast/cim/microdata/model/MicrodataProperty;)V

    goto :goto_0

    .line 47
    .end local v1    # "property":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    :cond_0
    return-void
.end method

.method public addProperty(Lcom/comcast/cim/microdata/model/MicrodataProperty;)V
    .locals 3
    .param p1, "property"    # Lcom/comcast/cim/microdata/model/MicrodataProperty;

    .prologue
    .line 35
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;

    .line 36
    .local v0, "oldProperty":Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;
    if-nez v0, :cond_0

    .line 37
    iget-object v1, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    :goto_0
    return-void

    .line 39
    :cond_0
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->getValues()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->addValues(Ljava/util/Collection;)V

    goto :goto_0
.end method

.method public get(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 5
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 147
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 148
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-object v1, v2

    .line 162
    :goto_0
    return-object v1

    .line 149
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->forms:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 151
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v2}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getModelFactory()Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->forms:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, p1, v3, v4}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataProperty(Ljava/lang/String;Ljava/lang/Object;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v1

    .line 152
    .local v1, "prop":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    invoke-interface {v2, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 154
    .end local v1    # "prop":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    :cond_1
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->links:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 156
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v2}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getModelFactory()Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->links:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, p1, v3, v4}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataProperty(Ljava/lang/String;Ljava/lang/Object;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v1

    .line 157
    .restart local v1    # "prop":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    invoke-interface {v2, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 160
    .end local v1    # "prop":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    :cond_2
    new-instance v0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;

    invoke-direct {v0, p1}, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;-><init>(Ljava/lang/String;)V

    .line 161
    .local v0, "missing":Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    invoke-interface {v2, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v1, v0

    .line 162
    goto :goto_0
.end method

.method public get(Ljava/lang/String;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "useNetwork"    # Z

    .prologue
    .line 169
    invoke-virtual {p0, p1}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->get(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    return-object v0
.end method

.method public getForms()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;",
            ">;"
        }
    .end annotation

    .prologue
    .line 127
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->forms:Ljava/util/Map;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLinks()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;"
        }
    .end annotation

    .prologue
    .line 120
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->links:Ljava/util/Map;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getProperties()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataProperty;",
            ">;"
        }
    .end annotation

    .prologue
    .line 113
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataProperty;

    return-object v0
.end method

.method public getRequiredProps()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 183
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->requiredProps:Ljava/util/Set;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->type:Ljava/lang/String;

    return-object v0
.end method

.method public isCanonical()Z
    .locals 1

    .prologue
    .line 175
    const/4 v0, 0x1

    return v0
.end method

.method public setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V
    .locals 0
    .param p1, "context"    # Lcom/comcast/cim/microdata/model/MicrodataContext;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    .line 180
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->id:Ljava/lang/String;

    .line 107
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 136
    new-instance v0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    invoke-direct {v0, p0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;-><init>(Ljava/lang/Object;)V

    .line 137
    .local v0, "builder":Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    const-string v1, "type"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->type:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 138
    const-string v1, "id"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->id:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 139
    const-string v1, "links"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->links:Ljava/util/Map;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 140
    const-string v1, "forms"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->forms:Ljava/util/Map;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 141
    const-string v1, "properties"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->properties:Ljava/util/Map;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 142
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
