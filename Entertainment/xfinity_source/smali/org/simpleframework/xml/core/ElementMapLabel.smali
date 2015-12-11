.class Lorg/simpleframework/xml/core/ElementMapLabel;
.super Lorg/simpleframework/xml/core/TemplateLabel;
.source "ElementMapLabel.java"


# instance fields
.field private data:Z

.field private decorator:Lorg/simpleframework/xml/core/Decorator;

.field private detail:Lorg/simpleframework/xml/core/Introspector;

.field private entry:Lorg/simpleframework/xml/core/Entry;

.field private format:Lorg/simpleframework/xml/stream/Format;

.field private inline:Z

.field private items:[Ljava/lang/Class;

.field private label:Lorg/simpleframework/xml/ElementMap;

.field private name:Ljava/lang/String;

.field private parent:Ljava/lang/String;

.field private path:Lorg/simpleframework/xml/core/Expression;

.field private required:Z

.field private type:Ljava/lang/Class;


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/core/Contact;Lorg/simpleframework/xml/ElementMap;Lorg/simpleframework/xml/stream/Format;)V
    .locals 1
    .param p1, "contact"    # Lorg/simpleframework/xml/core/Contact;
    .param p2, "label"    # Lorg/simpleframework/xml/ElementMap;
    .param p3, "format"    # Lorg/simpleframework/xml/stream/Format;

    .prologue
    .line 115
    invoke-direct {p0}, Lorg/simpleframework/xml/core/TemplateLabel;-><init>()V

    .line 116
    new-instance v0, Lorg/simpleframework/xml/core/Introspector;

    invoke-direct {v0, p1, p0, p3}, Lorg/simpleframework/xml/core/Introspector;-><init>(Lorg/simpleframework/xml/core/Contact;Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/stream/Format;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->detail:Lorg/simpleframework/xml/core/Introspector;

    .line 117
    new-instance v0, Lorg/simpleframework/xml/core/Qualifier;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/Qualifier;-><init>(Lorg/simpleframework/xml/core/Contact;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->decorator:Lorg/simpleframework/xml/core/Decorator;

    .line 118
    new-instance v0, Lorg/simpleframework/xml/core/Entry;

    invoke-direct {v0, p1, p2}, Lorg/simpleframework/xml/core/Entry;-><init>(Lorg/simpleframework/xml/core/Contact;Lorg/simpleframework/xml/ElementMap;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->entry:Lorg/simpleframework/xml/core/Entry;

    .line 119
    invoke-interface {p2}, Lorg/simpleframework/xml/ElementMap;->required()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->required:Z

    .line 120
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Contact;->getType()Ljava/lang/Class;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->type:Ljava/lang/Class;

    .line 121
    invoke-interface {p2}, Lorg/simpleframework/xml/ElementMap;->inline()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->inline:Z

    .line 122
    invoke-interface {p2}, Lorg/simpleframework/xml/ElementMap;->name()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->name:Ljava/lang/String;

    .line 123
    invoke-interface {p2}, Lorg/simpleframework/xml/ElementMap;->data()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->data:Z

    .line 124
    iput-object p3, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->format:Lorg/simpleframework/xml/stream/Format;

    .line 125
    iput-object p2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->label:Lorg/simpleframework/xml/ElementMap;

    .line 126
    return-void
.end method

.method private getMap()Lorg/simpleframework/xml/strategy/Type;
    .locals 2

    .prologue
    .line 277
    new-instance v0, Lorg/simpleframework/xml/core/ClassType;

    iget-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->type:Ljava/lang/Class;

    invoke-direct {v0, v1}, Lorg/simpleframework/xml/core/ClassType;-><init>(Ljava/lang/Class;)V

    return-object v0
.end method


# virtual methods
.method public getAnnotation()Ljava/lang/annotation/Annotation;
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->label:Lorg/simpleframework/xml/ElementMap;

    return-object v0
.end method

.method public getContact()Lorg/simpleframework/xml/core/Contact;
    .locals 1

    .prologue
    .line 316
    iget-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->detail:Lorg/simpleframework/xml/core/Introspector;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Introspector;->getContact()Lorg/simpleframework/xml/core/Contact;

    move-result-object v0

    return-object v0
.end method

.method public getConverter(Lorg/simpleframework/xml/core/Context;)Lorg/simpleframework/xml/core/Converter;
    .locals 3
    .param p1, "context"    # Lorg/simpleframework/xml/core/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 152
    invoke-direct {p0}, Lorg/simpleframework/xml/core/ElementMapLabel;->getMap()Lorg/simpleframework/xml/strategy/Type;

    move-result-object v0

    .line 154
    .local v0, "type":Lorg/simpleframework/xml/strategy/Type;
    iget-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->label:Lorg/simpleframework/xml/ElementMap;

    invoke-interface {v1}, Lorg/simpleframework/xml/ElementMap;->inline()Z

    move-result v1

    if-nez v1, :cond_0

    .line 155
    new-instance v1, Lorg/simpleframework/xml/core/CompositeMap;

    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->entry:Lorg/simpleframework/xml/core/Entry;

    invoke-direct {v1, p1, v2, v0}, Lorg/simpleframework/xml/core/CompositeMap;-><init>(Lorg/simpleframework/xml/core/Context;Lorg/simpleframework/xml/core/Entry;Lorg/simpleframework/xml/strategy/Type;)V

    .line 157
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Lorg/simpleframework/xml/core/CompositeInlineMap;

    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->entry:Lorg/simpleframework/xml/core/Entry;

    invoke-direct {v1, p1, v2, v0}, Lorg/simpleframework/xml/core/CompositeInlineMap;-><init>(Lorg/simpleframework/xml/core/Context;Lorg/simpleframework/xml/core/Entry;Lorg/simpleframework/xml/strategy/Type;)V

    goto :goto_0
.end method

.method public getDecorator()Lorg/simpleframework/xml/core/Decorator;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 138
    iget-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->decorator:Lorg/simpleframework/xml/core/Decorator;

    return-object v0
.end method

.method public getDependent()Lorg/simpleframework/xml/strategy/Type;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 189
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/ElementMapLabel;->getContact()Lorg/simpleframework/xml/core/Contact;

    move-result-object v0

    .line 191
    .local v0, "contact":Lorg/simpleframework/xml/core/Contact;
    iget-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->items:[Ljava/lang/Class;

    if-nez v1, :cond_0

    .line 192
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Contact;->getDependents()[Ljava/lang/Class;

    move-result-object v1

    iput-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->items:[Ljava/lang/Class;

    .line 194
    :cond_0
    iget-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->items:[Ljava/lang/Class;

    if-nez v1, :cond_1

    .line 195
    new-instance v1, Lorg/simpleframework/xml/core/ElementException;

    const-string v2, "Unable to determine type for %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-direct {v1, v2, v3}, Lorg/simpleframework/xml/core/ElementException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v1

    .line 197
    :cond_1
    iget-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->items:[Ljava/lang/Class;

    array-length v1, v1

    if-nez v1, :cond_2

    .line 198
    new-instance v1, Lorg/simpleframework/xml/core/ClassType;

    const-class v2, Ljava/lang/Object;

    invoke-direct {v1, v2}, Lorg/simpleframework/xml/core/ClassType;-><init>(Ljava/lang/Class;)V

    .line 200
    :goto_0
    return-object v1

    :cond_2
    new-instance v1, Lorg/simpleframework/xml/core/ClassType;

    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->items:[Ljava/lang/Class;

    aget-object v2, v2, v4

    invoke-direct {v1, v2}, Lorg/simpleframework/xml/core/ClassType;-><init>(Ljava/lang/Class;)V

    goto :goto_0
.end method

.method public getEmpty(Lorg/simpleframework/xml/core/Context;)Ljava/lang/Object;
    .locals 3
    .param p1, "context"    # Lorg/simpleframework/xml/core/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 171
    new-instance v1, Lorg/simpleframework/xml/core/ClassType;

    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->type:Ljava/lang/Class;

    invoke-direct {v1, v2}, Lorg/simpleframework/xml/core/ClassType;-><init>(Ljava/lang/Class;)V

    .line 172
    .local v1, "map":Lorg/simpleframework/xml/strategy/Type;
    new-instance v0, Lorg/simpleframework/xml/core/MapFactory;

    invoke-direct {v0, p1, v1}, Lorg/simpleframework/xml/core/MapFactory;-><init>(Lorg/simpleframework/xml/core/Context;Lorg/simpleframework/xml/strategy/Type;)V

    .line 174
    .local v0, "factory":Lorg/simpleframework/xml/core/Factory;
    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->label:Lorg/simpleframework/xml/ElementMap;

    invoke-interface {v2}, Lorg/simpleframework/xml/ElementMap;->empty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 175
    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Factory;->getInstance()Ljava/lang/Object;

    move-result-object v2

    .line 177
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getEntry()Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 212
    iget-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-virtual {v1}, Lorg/simpleframework/xml/stream/Format;->getStyle()Lorg/simpleframework/xml/stream/Style;

    move-result-object v0

    .line 214
    .local v0, "style":Lorg/simpleframework/xml/stream/Style;
    iget-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->detail:Lorg/simpleframework/xml/core/Introspector;

    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->parent:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lorg/simpleframework/xml/core/Introspector;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 215
    iget-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->detail:Lorg/simpleframework/xml/core/Introspector;

    invoke-virtual {v1}, Lorg/simpleframework/xml/core/Introspector;->getEntry()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->parent:Ljava/lang/String;

    .line 217
    :cond_0
    iget-object v1, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->parent:Ljava/lang/String;

    invoke-interface {v0, v1}, Lorg/simpleframework/xml/stream/Style;->getElement(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getExpression()Lorg/simpleframework/xml/core/Expression;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 263
    iget-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->path:Lorg/simpleframework/xml/core/Expression;

    if-nez v0, :cond_0

    .line 264
    iget-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->detail:Lorg/simpleframework/xml/core/Introspector;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Introspector;->getExpression()Lorg/simpleframework/xml/core/Expression;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->path:Lorg/simpleframework/xml/core/Expression;

    .line 266
    :cond_0
    iget-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->path:Lorg/simpleframework/xml/core/Expression;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 230
    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-virtual {v2}, Lorg/simpleframework/xml/stream/Format;->getStyle()Lorg/simpleframework/xml/stream/Style;

    move-result-object v1

    .line 231
    .local v1, "style":Lorg/simpleframework/xml/stream/Style;
    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->entry:Lorg/simpleframework/xml/core/Entry;

    invoke-virtual {v2}, Lorg/simpleframework/xml/core/Entry;->getEntry()Ljava/lang/String;

    move-result-object v0

    .line 233
    .local v0, "name":Ljava/lang/String;
    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->label:Lorg/simpleframework/xml/ElementMap;

    invoke-interface {v2}, Lorg/simpleframework/xml/ElementMap;->inline()Z

    move-result v2

    if-nez v2, :cond_0

    .line 234
    iget-object v2, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->detail:Lorg/simpleframework/xml/core/Introspector;

    invoke-virtual {v2}, Lorg/simpleframework/xml/core/Introspector;->getName()Ljava/lang/String;

    move-result-object v0

    .line 236
    :cond_0
    invoke-interface {v1, v0}, Lorg/simpleframework/xml/stream/Style;->getElement(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public getOverride()Ljava/lang/String;
    .locals 1

    .prologue
    .line 329
    iget-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 248
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/ElementMapLabel;->getExpression()Lorg/simpleframework/xml/core/Expression;

    move-result-object v1

    .line 249
    .local v1, "path":Lorg/simpleframework/xml/core/Expression;
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/ElementMapLabel;->getName()Ljava/lang/String;

    move-result-object v0

    .line 251
    .local v0, "name":Ljava/lang/String;
    invoke-interface {v1, v0}, Lorg/simpleframework/xml/core/Expression;->getElement(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public getType()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->type:Ljava/lang/Class;

    return-object v0
.end method

.method public isCollection()Z
    .locals 1

    .prologue
    .line 354
    const/4 v0, 0x1

    return v0
.end method

.method public isData()Z
    .locals 1

    .prologue
    .line 341
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->data:Z

    return v0
.end method

.method public isInline()Z
    .locals 1

    .prologue
    .line 378
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->inline:Z

    return v0
.end method

.method public isRequired()Z
    .locals 1

    .prologue
    .line 367
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->required:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 391
    iget-object v0, p0, Lorg/simpleframework/xml/core/ElementMapLabel;->detail:Lorg/simpleframework/xml/core/Introspector;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Introspector;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
