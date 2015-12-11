.class Lorg/simpleframework/xml/core/CacheLabel;
.super Ljava/lang/Object;
.source "CacheLabel.java"

# interfaces
.implements Lorg/simpleframework/xml/core/Label;


# instance fields
.field private final annotation:Ljava/lang/annotation/Annotation;

.field private final attribute:Z

.field private final collection:Z

.field private final contact:Lorg/simpleframework/xml/core/Contact;

.field private final data:Z

.field private final decorator:Lorg/simpleframework/xml/core/Decorator;

.field private final depend:Lorg/simpleframework/xml/strategy/Type;

.field private final entry:Ljava/lang/String;

.field private final expression:Lorg/simpleframework/xml/core/Expression;

.field private final inline:Z

.field private final key:Ljava/lang/Object;

.field private final label:Lorg/simpleframework/xml/core/Label;

.field private final name:Ljava/lang/String;

.field private final names:[Ljava/lang/String;

.field private final override:Ljava/lang/String;

.field private final path:Ljava/lang/String;

.field private final paths:[Ljava/lang/String;

.field private final required:Z

.field private final text:Z

.field private final type:Ljava/lang/Class;

.field private final union:Z


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/core/Label;)V
    .locals 1
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 149
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 150
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->annotation:Ljava/lang/annotation/Annotation;

    .line 151
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getExpression()Lorg/simpleframework/xml/core/Expression;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->expression:Lorg/simpleframework/xml/core/Expression;

    .line 152
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getDecorator()Lorg/simpleframework/xml/core/Decorator;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->decorator:Lorg/simpleframework/xml/core/Decorator;

    .line 153
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isAttribute()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->attribute:Z

    .line 154
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isCollection()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->collection:Z

    .line 155
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getContact()Lorg/simpleframework/xml/core/Contact;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->contact:Lorg/simpleframework/xml/core/Contact;

    .line 156
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getDependent()Lorg/simpleframework/xml/strategy/Type;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->depend:Lorg/simpleframework/xml/strategy/Type;

    .line 157
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isRequired()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->required:Z

    .line 158
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getOverride()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->override:Ljava/lang/String;

    .line 159
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isInline()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->inline:Z

    .line 160
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isUnion()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->union:Z

    .line 161
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getNames()[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->names:[Ljava/lang/String;

    .line 162
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getPaths()[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->paths:[Ljava/lang/String;

    .line 163
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getPath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->path:Ljava/lang/String;

    .line 164
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getType()Ljava/lang/Class;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->type:Ljava/lang/Class;

    .line 165
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->name:Ljava/lang/String;

    .line 166
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getEntry()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->entry:Ljava/lang/String;

    .line 167
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isData()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->data:Z

    .line 168
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isText()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->text:Z

    .line 169
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getKey()Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->key:Ljava/lang/Object;

    .line 170
    iput-object p1, p0, Lorg/simpleframework/xml/core/CacheLabel;->label:Lorg/simpleframework/xml/core/Label;

    .line 171
    return-void
.end method


# virtual methods
.method public getAnnotation()Ljava/lang/annotation/Annotation;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->annotation:Ljava/lang/annotation/Annotation;

    return-object v0
.end method

.method public getContact()Lorg/simpleframework/xml/core/Contact;
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->contact:Lorg/simpleframework/xml/core/Contact;

    return-object v0
.end method

.method public getConverter(Lorg/simpleframework/xml/core/Context;)Lorg/simpleframework/xml/core/Converter;
    .locals 1
    .param p1, "context"    # Lorg/simpleframework/xml/core/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 274
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->label:Lorg/simpleframework/xml/core/Label;

    invoke-interface {v0, p1}, Lorg/simpleframework/xml/core/Label;->getConverter(Lorg/simpleframework/xml/core/Context;)Lorg/simpleframework/xml/core/Converter;

    move-result-object v0

    return-object v0
.end method

.method public getDecorator()Lorg/simpleframework/xml/core/Decorator;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 260
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->decorator:Lorg/simpleframework/xml/core/Decorator;

    return-object v0
.end method

.method public getDependent()Lorg/simpleframework/xml/strategy/Type;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 301
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->depend:Lorg/simpleframework/xml/strategy/Type;

    return-object v0
.end method

.method public getEmpty(Lorg/simpleframework/xml/core/Context;)Ljava/lang/Object;
    .locals 1
    .param p1, "context"    # Lorg/simpleframework/xml/core/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 288
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->label:Lorg/simpleframework/xml/core/Label;

    invoke-interface {v0, p1}, Lorg/simpleframework/xml/core/Label;->getEmpty(Lorg/simpleframework/xml/core/Context;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getEntry()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 324
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->entry:Ljava/lang/String;

    return-object v0
.end method

.method public getExpression()Lorg/simpleframework/xml/core/Expression;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 361
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->expression:Lorg/simpleframework/xml/core/Expression;

    return-object v0
.end method

.method public getKey()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 312
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->key:Ljava/lang/Object;

    return-object v0
.end method

.method public getLabel(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Label;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 198
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->label:Lorg/simpleframework/xml/core/Label;

    invoke-interface {v0, p1}, Lorg/simpleframework/xml/core/Label;->getLabel(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 337
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getNames()[Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 210
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->names:[Ljava/lang/String;

    return-object v0
.end method

.method public getOverride()Ljava/lang/String;
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->override:Ljava/lang/String;

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 349
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getPaths()[Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 223
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->paths:[Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 388
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->type:Ljava/lang/Class;

    return-object v0
.end method

.method public getType(Ljava/lang/Class;)Lorg/simpleframework/xml/strategy/Type;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 184
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->label:Lorg/simpleframework/xml/core/Label;

    invoke-interface {v0, p1}, Lorg/simpleframework/xml/core/Label;->getType(Ljava/lang/Class;)Lorg/simpleframework/xml/strategy/Type;

    move-result-object v0

    return-object v0
.end method

.method public isAttribute()Z
    .locals 1

    .prologue
    .line 436
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->attribute:Z

    return v0
.end method

.method public isCollection()Z
    .locals 1

    .prologue
    .line 449
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->collection:Z

    return v0
.end method

.method public isData()Z
    .locals 1

    .prologue
    .line 400
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->data:Z

    return v0
.end method

.method public isInline()Z
    .locals 1

    .prologue
    .line 425
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->inline:Z

    return v0
.end method

.method public isRequired()Z
    .locals 1

    .prologue
    .line 462
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->required:Z

    return v0
.end method

.method public isText()Z
    .locals 1

    .prologue
    .line 412
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->text:Z

    return v0
.end method

.method public isUnion()Z
    .locals 1

    .prologue
    .line 473
    iget-boolean v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->union:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 486
    iget-object v0, p0, Lorg/simpleframework/xml/core/CacheLabel;->label:Lorg/simpleframework/xml/core/Label;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
