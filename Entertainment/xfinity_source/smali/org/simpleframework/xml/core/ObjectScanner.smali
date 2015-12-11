.class Lorg/simpleframework/xml/core/ObjectScanner;
.super Ljava/lang/Object;
.source "ObjectScanner.java"

# interfaces
.implements Lorg/simpleframework/xml/core/Scanner;


# instance fields
.field private access:Lorg/simpleframework/xml/DefaultType;

.field private builder:Lorg/simpleframework/xml/core/StructureBuilder;

.field private name:Ljava/lang/String;

.field private required:Z

.field private scanner:Lorg/simpleframework/xml/core/ClassScanner;

.field private structure:Lorg/simpleframework/xml/core/Structure;

.field private type:Ljava/lang/Class;


# direct methods
.method public constructor <init>(Ljava/lang/Class;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 90
    new-instance v0, Lorg/simpleframework/xml/stream/Format;

    invoke-direct {v0}, Lorg/simpleframework/xml/stream/Format;-><init>()V

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/ObjectScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V

    .line 91
    return-void
.end method

.method public constructor <init>(Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "format"    # Lorg/simpleframework/xml/stream/Format;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 101
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 102
    new-instance v0, Lorg/simpleframework/xml/core/ClassScanner;

    invoke-direct {v0, p1, p2}, Lorg/simpleframework/xml/core/ClassScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    .line 103
    new-instance v0, Lorg/simpleframework/xml/core/StructureBuilder;

    invoke-direct {v0, p0, p1, p2}, Lorg/simpleframework/xml/core/StructureBuilder;-><init>(Lorg/simpleframework/xml/core/Scanner;Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->builder:Lorg/simpleframework/xml/core/StructureBuilder;

    .line 104
    iput-object p1, p0, Lorg/simpleframework/xml/core/ObjectScanner;->type:Ljava/lang/Class;

    .line 105
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ObjectScanner;->scan(Ljava/lang/Class;)V

    .line 106
    return-void
.end method

.method private access(Ljava/lang/Class;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 476
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v1, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v1}, Lorg/simpleframework/xml/core/ClassScanner;->getDefault()Lorg/simpleframework/xml/Default;

    move-result-object v0

    .line 478
    .local v0, "holder":Lorg/simpleframework/xml/Default;
    if-eqz v0, :cond_0

    .line 479
    invoke-interface {v0}, Lorg/simpleframework/xml/Default;->required()Z

    move-result v1

    iput-boolean v1, p0, Lorg/simpleframework/xml/core/ObjectScanner;->required:Z

    .line 480
    invoke-interface {v0}, Lorg/simpleframework/xml/Default;->value()Lorg/simpleframework/xml/DefaultType;

    move-result-object v1

    iput-object v1, p0, Lorg/simpleframework/xml/core/ObjectScanner;->access:Lorg/simpleframework/xml/DefaultType;

    .line 482
    :cond_0
    return-void
.end method

.method private commit(Ljava/lang/Class;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 411
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->structure:Lorg/simpleframework/xml/core/Structure;

    if-nez v0, :cond_0

    .line 412
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->builder:Lorg/simpleframework/xml/core/StructureBuilder;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/StructureBuilder;->build(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Structure;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->structure:Lorg/simpleframework/xml/core/Structure;

    .line 414
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->builder:Lorg/simpleframework/xml/core/StructureBuilder;

    .line 415
    return-void
.end method

.method private field(Ljava/lang/Class;)V
    .locals 6
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 506
    new-instance v3, Lorg/simpleframework/xml/core/FieldScanner;

    iget-object v4, p0, Lorg/simpleframework/xml/core/ObjectScanner;->access:Lorg/simpleframework/xml/DefaultType;

    iget-boolean v5, p0, Lorg/simpleframework/xml/core/ObjectScanner;->required:Z

    invoke-direct {v3, p1, v4, v5}, Lorg/simpleframework/xml/core/FieldScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;Z)V

    .line 508
    .local v3, "list":Lorg/simpleframework/xml/core/ContactList;
    invoke-virtual {v3}, Lorg/simpleframework/xml/core/ContactList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/simpleframework/xml/core/Contact;

    .line 509
    .local v0, "contact":Lorg/simpleframework/xml/core/Contact;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Contact;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v2

    .line 511
    .local v2, "label":Ljava/lang/annotation/Annotation;
    if-eqz v2, :cond_0

    .line 512
    iget-object v4, p0, Lorg/simpleframework/xml/core/ObjectScanner;->builder:Lorg/simpleframework/xml/core/StructureBuilder;

    invoke-virtual {v4, v0, v2}, Lorg/simpleframework/xml/core/StructureBuilder;->process(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;)V

    goto :goto_0

    .line 515
    .end local v0    # "contact":Lorg/simpleframework/xml/core/Contact;
    .end local v2    # "label":Ljava/lang/annotation/Annotation;
    :cond_1
    return-void
.end method

.method private isEmpty(Ljava/lang/String;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 495
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private method(Ljava/lang/Class;)V
    .locals 6
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 525
    new-instance v3, Lorg/simpleframework/xml/core/MethodScanner;

    iget-object v4, p0, Lorg/simpleframework/xml/core/ObjectScanner;->access:Lorg/simpleframework/xml/DefaultType;

    iget-boolean v5, p0, Lorg/simpleframework/xml/core/ObjectScanner;->required:Z

    invoke-direct {v3, p1, v4, v5}, Lorg/simpleframework/xml/core/MethodScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;Z)V

    .line 527
    .local v3, "list":Lorg/simpleframework/xml/core/ContactList;
    invoke-virtual {v3}, Lorg/simpleframework/xml/core/ContactList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/simpleframework/xml/core/Contact;

    .line 528
    .local v0, "contact":Lorg/simpleframework/xml/core/Contact;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Contact;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v2

    .line 530
    .local v2, "label":Ljava/lang/annotation/Annotation;
    if-eqz v2, :cond_0

    .line 531
    iget-object v4, p0, Lorg/simpleframework/xml/core/ObjectScanner;->builder:Lorg/simpleframework/xml/core/StructureBuilder;

    invoke-virtual {v4, v0, v2}, Lorg/simpleframework/xml/core/StructureBuilder;->process(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;)V

    goto :goto_0

    .line 534
    .end local v0    # "contact":Lorg/simpleframework/xml/core/Contact;
    .end local v2    # "label":Ljava/lang/annotation/Annotation;
    :cond_1
    return-void
.end method

.method private order(Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 426
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->builder:Lorg/simpleframework/xml/core/StructureBuilder;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/StructureBuilder;->assemble(Ljava/lang/Class;)V

    .line 427
    return-void
.end method

.method private root(Ljava/lang/Class;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 452
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    .line 453
    .local v0, "real":Ljava/lang/String;
    iget-object v3, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v3}, Lorg/simpleframework/xml/core/ClassScanner;->getRoot()Lorg/simpleframework/xml/Root;

    move-result-object v1

    .line 454
    .local v1, "root":Lorg/simpleframework/xml/Root;
    move-object v2, v0

    .line 456
    .local v2, "text":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 457
    invoke-interface {v1}, Lorg/simpleframework/xml/Root;->name()Ljava/lang/String;

    move-result-object v2

    .line 459
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/ObjectScanner;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 460
    invoke-static {v0}, Lorg/simpleframework/xml/core/Reflector;->getName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 462
    :cond_0
    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lorg/simpleframework/xml/core/ObjectScanner;->name:Ljava/lang/String;

    .line 464
    :cond_1
    return-void
.end method

.method private scan(Ljava/lang/Class;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 393
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ObjectScanner;->root(Ljava/lang/Class;)V

    .line 394
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ObjectScanner;->order(Ljava/lang/Class;)V

    .line 395
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ObjectScanner;->access(Ljava/lang/Class;)V

    .line 396
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ObjectScanner;->field(Ljava/lang/Class;)V

    .line 397
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ObjectScanner;->method(Ljava/lang/Class;)V

    .line 398
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ObjectScanner;->validate(Ljava/lang/Class;)V

    .line 399
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ObjectScanner;->commit(Ljava/lang/Class;)V

    .line 400
    return-void
.end method

.method private validate(Ljava/lang/Class;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 439
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->builder:Lorg/simpleframework/xml/core/StructureBuilder;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/StructureBuilder;->commit(Ljava/lang/Class;)V

    .line 440
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->builder:Lorg/simpleframework/xml/core/StructureBuilder;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/StructureBuilder;->validate(Ljava/lang/Class;)V

    .line 441
    return-void
.end method


# virtual methods
.method public getCaller(Lorg/simpleframework/xml/core/Context;)Lorg/simpleframework/xml/core/Caller;
    .locals 1
    .param p1, "context"    # Lorg/simpleframework/xml/core/Context;

    .prologue
    .line 188
    new-instance v0, Lorg/simpleframework/xml/core/Caller;

    invoke-direct {v0, p0, p1}, Lorg/simpleframework/xml/core/Caller;-><init>(Lorg/simpleframework/xml/core/Scanner;Lorg/simpleframework/xml/core/Context;)V

    return-object v0
.end method

.method public getCommit()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 278
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getCommit()Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    return-object v0
.end method

.method public getComplete()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getComplete()Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    return-object v0
.end method

.method public getDecorator()Lorg/simpleframework/xml/core/Decorator;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getDecorator()Lorg/simpleframework/xml/core/Decorator;

    move-result-object v0

    return-object v0
.end method

.method public getInstantiator()Lorg/simpleframework/xml/core/Instantiator;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->structure:Lorg/simpleframework/xml/core/Structure;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Structure;->getInstantiator()Lorg/simpleframework/xml/core/Instantiator;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 265
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getOrder()Lorg/simpleframework/xml/Order;
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getOrder()Lorg/simpleframework/xml/Order;

    move-result-object v0

    return-object v0
.end method

.method public getParameters()Lorg/simpleframework/xml/core/ParameterMap;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getParameters()Lorg/simpleframework/xml/core/ParameterMap;

    move-result-object v0

    return-object v0
.end method

.method public getPersist()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getPersist()Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    return-object v0
.end method

.method public getReplace()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getReplace()Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    return-object v0
.end method

.method public getResolve()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 343
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getResolve()Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    return-object v0
.end method

.method public getRevision()Lorg/simpleframework/xml/Version;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->structure:Lorg/simpleframework/xml/core/Structure;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Structure;->getRevision()Lorg/simpleframework/xml/Version;

    move-result-object v0

    return-object v0
.end method

.method public getSection()Lorg/simpleframework/xml/core/Section;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->structure:Lorg/simpleframework/xml/core/Structure;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Structure;->getSection()Lorg/simpleframework/xml/core/Section;

    move-result-object v0

    return-object v0
.end method

.method public getSignature()Lorg/simpleframework/xml/core/Signature;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getSignature()Lorg/simpleframework/xml/core/Signature;

    move-result-object v0

    return-object v0
.end method

.method public getSignatures()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Signature;",
            ">;"
        }
    .end annotation

    .prologue
    .line 129
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getSignatures()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getText()Lorg/simpleframework/xml/core/Label;
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->structure:Lorg/simpleframework/xml/core/Structure;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Structure;->getText()Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    return-object v0
.end method

.method public getType()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->type:Ljava/lang/Class;

    return-object v0
.end method

.method public getValidate()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 291
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getValidate()Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()Lorg/simpleframework/xml/core/Label;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->structure:Lorg/simpleframework/xml/core/Structure;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Structure;->getVersion()Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    return-object v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 367
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->getRoot()Lorg/simpleframework/xml/Root;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPrimitive()Z
    .locals 1

    .prologue
    .line 355
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->structure:Lorg/simpleframework/xml/core/Structure;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/Structure;->isPrimitive()Z

    move-result v0

    return v0
.end method

.method public isStrict()Z
    .locals 1

    .prologue
    .line 381
    iget-object v0, p0, Lorg/simpleframework/xml/core/ObjectScanner;->scanner:Lorg/simpleframework/xml/core/ClassScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ClassScanner;->isStrict()Z

    move-result v0

    return v0
.end method
