.class public Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;
.super Lcom/fasterxml/jackson/databind/JsonMappingException;
.source "UnrecognizedPropertyException.java"


# instance fields
.field protected transient _propertiesAsString:Ljava/lang/String;

.field protected final _propertyIds:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field protected final _referringClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field protected final _unrecognizedPropertyName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonLocation;Ljava/lang/Class;Ljava/lang/String;Ljava/util/Collection;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "loc"    # Lcom/fasterxml/jackson/core/JsonLocation;
    .param p4, "propName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/fasterxml/jackson/core/JsonLocation;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 49
    .local p3, "referringClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p5, "propertyIds":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Object;>;"
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonLocation;)V

    .line 50
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->_referringClass:Ljava/lang/Class;

    .line 51
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->_unrecognizedPropertyName:Ljava/lang/String;

    .line 52
    iput-object p5, p0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->_propertyIds:Ljava/util/Collection;

    .line 53
    return-void
.end method

.method public static from(Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/Object;Ljava/lang/String;Ljava/util/Collection;)Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;
    .locals 6
    .param p0, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p1, "fromObjectOrClass"    # Ljava/lang/Object;
    .param p2, "propertyName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Ljava/lang/Object;",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Object;",
            ">;)",
            "Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;"
        }
    .end annotation

    .prologue
    .line 69
    .local p3, "propertyIds":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Object;>;"
    if-nez p1, :cond_0

    .line 70
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-direct {v2}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v2

    .line 73
    :cond_0
    instance-of v2, p1, Ljava/lang/Class;

    if-eqz v2, :cond_1

    move-object v3, p1

    .line 74
    check-cast v3, Ljava/lang/Class;

    .line 78
    .local v3, "ref":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Unrecognized field \""

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v4, "\" (class "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v4, "), not marked as ignorable"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 79
    .local v1, "msg":Ljava/lang/String;
    new-instance v0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentLocation()Lcom/fasterxml/jackson/core/JsonLocation;

    move-result-object v2

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonLocation;Ljava/lang/Class;Ljava/lang/String;Ljava/util/Collection;)V

    .line 82
    .local v0, "e":Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;
    invoke-virtual {v0, p1, p2}, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->prependPath(Ljava/lang/Object;Ljava/lang/String;)V

    .line 83
    return-object v0

    .line 76
    .end local v0    # "e":Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;
    .end local v1    # "msg":Ljava/lang/String;
    .end local v3    # "ref":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    .restart local v3    # "ref":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    goto :goto_0
.end method


# virtual methods
.method public getMessageSuffix()Ljava/lang/String;
    .locals 7

    .prologue
    const/16 v6, 0x22

    .line 97
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->_propertiesAsString:Ljava/lang/String;

    .line 98
    .local v3, "suffix":Ljava/lang/String;
    if-nez v3, :cond_1

    iget-object v4, p0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->_propertyIds:Ljava/util/Collection;

    if-eqz v4, :cond_1

    .line 99
    new-instance v2, Ljava/lang/StringBuilder;

    const/16 v4, 0x64

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 100
    .local v2, "sb":Ljava/lang/StringBuilder;
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->_propertyIds:Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->size()I

    move-result v1

    .line 101
    .local v1, "len":I
    const/4 v4, 0x1

    if-ne v1, v4, :cond_2

    .line 102
    const-string/jumbo v4, " (one known property: \""

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 103
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->_propertyIds:Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 104
    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 119
    :cond_0
    :goto_0
    const-string/jumbo v4, "])"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 120
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->_propertiesAsString:Ljava/lang/String;

    .line 122
    .end local v1    # "len":I
    .end local v2    # "sb":Ljava/lang/StringBuilder;
    :cond_1
    return-object v3

    .line 106
    .restart local v1    # "len":I
    .restart local v2    # "sb":Ljava/lang/StringBuilder;
    :cond_2
    const-string/jumbo v4, " ("

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " known properties: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 107
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/exc/UnrecognizedPropertyException;->_propertyIds:Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 108
    .local v0, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/Object;>;"
    :cond_3
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 109
    const-string/jumbo v4, ", \""

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 110
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 111
    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 113
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    const/16 v5, 0xc8

    if-le v4, v5, :cond_3

    .line 114
    const-string/jumbo v4, " [truncated]"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method
