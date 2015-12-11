.class public Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;
.super Lcom/fasterxml/jackson/databind/ser/FilterProvider;
.source "SimpleFilterProvider.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x27362c7685343d04L


# instance fields
.field protected _cfgFailOnUnknownId:Z

.field protected _defaultFilter:Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;

.field protected final _filtersById:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 45
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;-><init>(Ljava/util/Map;)V

    .line 46
    return-void
.end method

.method public constructor <init>(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 51
    .local p1, "mapping":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;>;"
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/ser/FilterProvider;-><init>()V

    .line 36
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_cfgFailOnUnknownId:Z

    .line 52
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_filtersById:Ljava/util/Map;

    .line 53
    return-void
.end method


# virtual methods
.method public addFilter(Ljava/lang/String;Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;)Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "filter"    # Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;

    .prologue
    .line 81
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_filtersById:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    return-object p0
.end method

.method public findFilter(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;
    .locals 4
    .param p1, "filterId"    # Ljava/lang/Object;

    .prologue
    .line 98
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_filtersById:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;

    .line 99
    .local v0, "f":Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;
    if-nez v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_defaultFilter:Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;

    .line 101
    if-nez v0, :cond_0

    iget-boolean v1, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_cfgFailOnUnknownId:Z

    if-eqz v1, :cond_0

    .line 102
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "No filter configured with id \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' (type "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 106
    :cond_0
    return-object v0
.end method

.method public getDefaultFilter()Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_defaultFilter:Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;

    return-object v0
.end method

.method public removeFilter(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_filtersById:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;

    return-object v0
.end method

.method public setDefaultFilter(Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;)Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;
    .locals 0
    .param p1, "f"    # Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_defaultFilter:Lcom/fasterxml/jackson/databind/ser/BeanPropertyFilter;

    .line 64
    return-object p0
.end method

.method public setFailOnUnknownId(Z)Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;
    .locals 0
    .param p1, "state"    # Z

    .prologue
    .line 72
    iput-boolean p1, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_cfgFailOnUnknownId:Z

    .line 73
    return-object p0
.end method

.method public willFailOnUnknownId()Z
    .locals 1

    .prologue
    .line 77
    iget-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/SimpleFilterProvider;->_cfgFailOnUnknownId:Z

    return v0
.end method
